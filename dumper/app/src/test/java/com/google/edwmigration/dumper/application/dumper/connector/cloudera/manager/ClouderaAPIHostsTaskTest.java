/*
 * Copyright 2022-2024 Google LLC
 * Copyright 2013-2021 CompilerWorks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.edwmigration.dumper.application.dumper.connector.cloudera.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.ByteSink;
import com.google.common.io.CharSink;
import com.google.edwmigration.dumper.application.dumper.MetadataDumperUsageException;
import com.google.edwmigration.dumper.application.dumper.connector.cloudera.manager.ClouderaManagerHandle.ClouderaClusterDTO;
import com.google.edwmigration.dumper.application.dumper.task.TaskRunContext;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClouderaAPIHostsTaskTest {

  private final ClouderaAPIHostsTask task = new ClouderaAPIHostsTask();
  private ClouderaManagerHandle handle;

  @Mock private TaskRunContext context;
  @Mock private ByteSink sink;

  @Mock private Writer writer;
  @Mock private CharSink charSink;
  @Mock private CloseableHttpClient httpClient;
  private URI uri;

  @Before
  public void setUp() throws Exception {
    uri = URI.create("http://localhost/api");
    handle = new ClouderaManagerHandle(uri, httpClient);

    when(sink.asCharSink(eq(StandardCharsets.UTF_8))).thenReturn(charSink);
    when(charSink.openBufferedStream()).thenReturn(writer);
  }

  @Test
  public void clustersExists_do_writes_success() throws Exception {
    handle.initClusters(
        ImmutableList.of(
            ClouderaClusterDTO.create("id1", "first-cluster"),
            ClouderaClusterDTO.create("id125", "second-cluster")));

    CloseableHttpResponse responseId1 = mock(CloseableHttpResponse.class);
    HttpEntity entityId1 = mock(HttpEntity.class);
    when(responseId1.getEntity()).thenReturn(entityId1);

    CloseableHttpResponse responseCldClst = mock(CloseableHttpResponse.class);
    HttpEntity entityCldClst = mock(HttpEntity.class);
    when(responseCldClst.getEntity()).thenReturn(entityCldClst);

    when(httpClient.execute(
            argThat(
                get -> get != null && get.getURI().toString().endsWith("/first-cluster/hosts"))))
        .thenReturn(responseId1);
    when(httpClient.execute(
            argThat(
                get -> get != null && get.getURI().toString().endsWith("/second-cluster/hosts"))))
        .thenReturn(responseCldClst);

    when(entityId1.getContent())
        .thenReturn(new ByteArrayInputStream("{\"clusterName\":\"first-cluster\"}".getBytes()));
    when(entityCldClst.getContent())
        .thenReturn(
            new ByteArrayInputStream("{\n\"clusterName\":\"second-cluster\"\n\r}".getBytes()));

    task.doRun(context, sink, handle);

    Set<URI> requestedUrls = new HashSet<>();
    verify(httpClient, times(2))
        .execute(
            argThat(
                request -> {
                  assertEquals(HttpGet.class, request.getClass());
                  requestedUrls.add(request.getURI());
                  return true;
                }));

    assertEquals(
        ImmutableSet.of(
            URI.create("http://localhost/api/clusters/first-cluster/hosts"),
            URI.create("http://localhost/api/clusters/second-cluster/hosts")),
        requestedUrls);

    // write jsonl. https://jsonlines.org/
    Set<String> fileLines = new HashSet<>();
    verify(writer, times(2))
        .write(
            (String)
                argThat(
                    content -> {
                      String str = (String) content;
                      assertFalse(str.contains("\n"));
                      assertFalse(str.contains("\r"));
                      fileLines.add(str);
                      return true;
                    }));
    verify(writer, times(2)).write('\n');
    assertEquals(
        ImmutableSet.of(
            "{\"clusterName\":\"first-cluster\"}", "{\"clusterName\":\"second-cluster\"}"),
        fileLines);

    verify(responseId1).close();
    verify(responseCldClst).close();
    verify(writer).close();
  }

  @Test
  public void clustersWereNotInitialized_throwsException() throws Exception {
    assertNull(handle.getClusters());

    MetadataDumperUsageException exception =
        assertThrows(MetadataDumperUsageException.class, () -> task.doRun(context, sink, handle));

    assertEquals(
        "Cloudera clusters must be initialized before hosts dumping.", exception.getMessage());

    verifyNoWrites();
  }

  private void verifyNoWrites() throws IOException {
    verify(writer, never()).write(anyChar());
    verify(writer, never()).write(anyString());
    verify(writer, never()).write(anyString(), anyInt(), anyInt());
    verify(writer, never()).write(any(char[].class));
    verify(writer, never()).write(any(char[].class), anyInt(), anyInt());
  }
}