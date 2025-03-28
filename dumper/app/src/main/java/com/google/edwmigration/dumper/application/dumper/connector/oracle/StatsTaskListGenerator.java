/*
 * Copyright 2022-2025 Google LLC
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
package com.google.edwmigration.dumper.application.dumper.connector.oracle;

import static com.google.edwmigration.dumper.application.dumper.connector.oracle.QueryGroup.StatsSource.AWR;
import static com.google.edwmigration.dumper.application.dumper.connector.oracle.QueryGroup.StatsSource.NATIVE;
import static com.google.edwmigration.dumper.application.dumper.connector.oracle.QueryGroup.StatsSource.STATSPACK;
import static com.google.edwmigration.dumper.application.dumper.connector.oracle.QueryGroup.TenantSetup.MULTI_TENANT;
import static com.google.edwmigration.dumper.application.dumper.connector.oracle.QueryGroup.TenantSetup.SINGLE_TENANT;

import com.google.common.collect.ImmutableList;
import com.google.edwmigration.dumper.application.dumper.ConnectorArguments;
import com.google.edwmigration.dumper.application.dumper.connector.oracle.task.ResultMessageTask;
import com.google.edwmigration.dumper.application.dumper.connector.oracle.task.StatsJdbcTask;
import com.google.edwmigration.dumper.application.dumper.task.DumpMetadataTask;
import com.google.edwmigration.dumper.application.dumper.task.FormatTask;
import com.google.edwmigration.dumper.application.dumper.task.Task;
import java.time.Duration;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
class StatsTaskListGenerator {

  private final OracleConnectorScope scope = OracleConnectorScope.STATS;

  private static final ImmutableList<String> AWR_NAMES =
      ImmutableList.of(
          "hist-cmd-types-awr",
          "source-conn-latest",
          "sql-stats-awr",
          "sys-metric-history",
          "segment-stats");

  private static final ImmutableList<String> NATIVE_NAMES_OPTIONAL =
      ImmutableList.of(
          "app-schemas-pdbs",
          "db-features",
          "db-instances",
          "db-link-sources",
          "db-links",
          "dtl-index-type",
          "dtl-source-code",
          "exttab",
          "m-view-types",
          "pdbs-info",
          "osstat",
          "cell-config",
          "data-files");

  private static final ImmutableList<String> NATIVE_NAMES_REQUIRED =
      ImmutableList.of(
          "data-types",
          "db-info",
          "db-objects",
          // The version of db-objects that gets SYNONYM objects, for which owner is PUBLIC.
          // A JOIN is performed to exclude objects which appear in the cdb_synonyms table.
          "db-objects-synonym-public",
          "table-types-dtl",
          "used-space-details");

  private static final ImmutableList<String> STATSPACK_NAMES =
      ImmutableList.of("hist-cmd-types-statspack", "sql-stats-statspack");

  @Nonnull
  ImmutableList<Task<?>> createTasks(ConnectorArguments arguments, Duration queriedDuration) {
    ImmutableList.Builder<Task<?>> builder = ImmutableList.builder();
    builder.add(new DumpMetadataTask(arguments, scope.formatName()));
    builder.add(new FormatTask(scope.formatName()));
    List<StatsJdbcTask> jdbcTasks = createJdbcTasks(queriedDuration);
    builder.addAll(jdbcTasks);

    QueryGroup awrAndCdb = QueryGroup.create(/* required= */ false, AWR, MULTI_TENANT);
    QueryGroup awrAndNotCdb = QueryGroup.create(/* required= */ false, AWR, SINGLE_TENANT);
    builder.add(ResultMessageTask.create(awrAndCdb, jdbcTasks));
    builder.add(ResultMessageTask.create(awrAndNotCdb, jdbcTasks));

    QueryGroup statspackAndCdb = QueryGroup.create(/* required= */ false, STATSPACK, MULTI_TENANT);
    QueryGroup statspackAndNotCdb =
        QueryGroup.create(/* required= */ false, STATSPACK, SINGLE_TENANT);
    builder.add(ResultMessageTask.create(statspackAndCdb, jdbcTasks));
    builder.add(ResultMessageTask.create(statspackAndNotCdb, jdbcTasks));

    return builder.build();
  }

  private List<StatsJdbcTask> createJdbcTasks(Duration queriedDuration) {
    ImmutableList.Builder<StatsJdbcTask> builder = ImmutableList.builder();
    for (String name : awrNames()) {
      QueryGroup awr = QueryGroup.create(/* required= */ false, AWR, SINGLE_TENANT);
      builder.addAll(createTaskWithAlternative(name, awr, queriedDuration));
    }
    for (String name : statspackNames()) {
      QueryGroup statspack = QueryGroup.create(/* required= */ false, STATSPACK, MULTI_TENANT);
      OracleStatsQuery query = OracleStatsQuery.create(name, statspack, queriedDuration);
      builder.add(StatsJdbcTask.fromQuery(query));
    }
    for (String name : NATIVE_NAMES_OPTIONAL) {
      QueryGroup group = QueryGroup.create(/* required= */ false, NATIVE, SINGLE_TENANT);
      builder.addAll(createTaskWithAlternative(name, group, queriedDuration));
    }
    for (String name : NATIVE_NAMES_REQUIRED) {
      QueryGroup group = QueryGroup.create(/* required= */ true, NATIVE, SINGLE_TENANT);
      builder.addAll(createTaskWithAlternative(name, group, queriedDuration));
    }
    return builder.build();
  }

  List<StatsJdbcTask> createTaskWithAlternative(
      String name, QueryGroup group, Duration queriedDuration) {
    OracleStatsQuery primary = OracleStatsQuery.create(name, group.toCdbVersion(), queriedDuration);
    StatsJdbcTask primaryTask = StatsJdbcTask.fromQuery(primary);
    OracleStatsQuery alternative = OracleStatsQuery.create(name, group, queriedDuration);
    StatsJdbcTask alternativeTask = StatsJdbcTask.fromQuery(alternative).onlyIfFailed(primaryTask);
    return ImmutableList.of(primaryTask, alternativeTask);
  }

  ImmutableList<String> awrNames() {
    return AWR_NAMES;
  }

  ImmutableList<String> statspackNames() {
    return STATSPACK_NAMES;
  }
}
