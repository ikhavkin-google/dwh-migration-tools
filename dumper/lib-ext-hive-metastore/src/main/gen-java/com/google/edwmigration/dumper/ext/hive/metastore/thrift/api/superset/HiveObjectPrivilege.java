/**
 * Autogenerated by Thrift Compiler (0.17.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.google.edwmigration.dumper.ext.hive.metastore.thrift.api.superset;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.17.0)", date = "2023-08-11")
public class HiveObjectPrivilege implements org.apache.thrift.TBase<HiveObjectPrivilege, HiveObjectPrivilege._Fields>, java.io.Serializable, Cloneable, Comparable<HiveObjectPrivilege> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("HiveObjectPrivilege");

  private static final org.apache.thrift.protocol.TField HIVE_OBJECT_FIELD_DESC = new org.apache.thrift.protocol.TField("hiveObject", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField PRINCIPAL_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("principalName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PRINCIPAL_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("principalType", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField GRANT_INFO_FIELD_DESC = new org.apache.thrift.protocol.TField("grantInfo", org.apache.thrift.protocol.TType.STRUCT, (short)4);
  private static final org.apache.thrift.protocol.TField AUTHORIZER_FIELD_DESC = new org.apache.thrift.protocol.TField("authorizer", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new HiveObjectPrivilegeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new HiveObjectPrivilegeTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable HiveObjectRef hiveObject; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String principalName; // required
  /**
   * 
   * @see PrincipalType
   */
  public @org.apache.thrift.annotation.Nullable PrincipalType principalType; // required
  public @org.apache.thrift.annotation.Nullable PrivilegeGrantInfo grantInfo; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String authorizer; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HIVE_OBJECT((short)1, "hiveObject"),
    PRINCIPAL_NAME((short)2, "principalName"),
    /**
     * 
     * @see PrincipalType
     */
    PRINCIPAL_TYPE((short)3, "principalType"),
    GRANT_INFO((short)4, "grantInfo"),
    AUTHORIZER((short)5, "authorizer");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // HIVE_OBJECT
          return HIVE_OBJECT;
        case 2: // PRINCIPAL_NAME
          return PRINCIPAL_NAME;
        case 3: // PRINCIPAL_TYPE
          return PRINCIPAL_TYPE;
        case 4: // GRANT_INFO
          return GRANT_INFO;
        case 5: // AUTHORIZER
          return AUTHORIZER;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    @Override
    public short getThriftFieldId() {
      return _thriftId;
    }

    @Override
    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.HIVE_OBJECT, new org.apache.thrift.meta_data.FieldMetaData("hiveObject", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, HiveObjectRef.class)));
    tmpMap.put(_Fields.PRINCIPAL_NAME, new org.apache.thrift.meta_data.FieldMetaData("principalName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PRINCIPAL_TYPE, new org.apache.thrift.meta_data.FieldMetaData("principalType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, PrincipalType.class)));
    tmpMap.put(_Fields.GRANT_INFO, new org.apache.thrift.meta_data.FieldMetaData("grantInfo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, PrivilegeGrantInfo.class)));
    tmpMap.put(_Fields.AUTHORIZER, new org.apache.thrift.meta_data.FieldMetaData("authorizer", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(HiveObjectPrivilege.class, metaDataMap);
  }

  public HiveObjectPrivilege() {
  }

  public HiveObjectPrivilege(
    HiveObjectRef hiveObject,
    java.lang.String principalName,
    PrincipalType principalType,
    PrivilegeGrantInfo grantInfo,
    java.lang.String authorizer)
  {
    this();
    this.hiveObject = hiveObject;
    this.principalName = principalName;
    this.principalType = principalType;
    this.grantInfo = grantInfo;
    this.authorizer = authorizer;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public HiveObjectPrivilege(HiveObjectPrivilege other) {
    if (other.isSetHiveObject()) {
      this.hiveObject = new HiveObjectRef(other.hiveObject);
    }
    if (other.isSetPrincipalName()) {
      this.principalName = other.principalName;
    }
    if (other.isSetPrincipalType()) {
      this.principalType = other.principalType;
    }
    if (other.isSetGrantInfo()) {
      this.grantInfo = new PrivilegeGrantInfo(other.grantInfo);
    }
    if (other.isSetAuthorizer()) {
      this.authorizer = other.authorizer;
    }
  }

  @Override
  public HiveObjectPrivilege deepCopy() {
    return new HiveObjectPrivilege(this);
  }

  @Override
  public void clear() {
    this.hiveObject = null;
    this.principalName = null;
    this.principalType = null;
    this.grantInfo = null;
    this.authorizer = null;
  }

  @org.apache.thrift.annotation.Nullable
  public HiveObjectRef getHiveObject() {
    return this.hiveObject;
  }

  public HiveObjectPrivilege setHiveObject(@org.apache.thrift.annotation.Nullable HiveObjectRef hiveObject) {
    this.hiveObject = hiveObject;
    return this;
  }

  public void unsetHiveObject() {
    this.hiveObject = null;
  }

  /** Returns true if field hiveObject is set (has been assigned a value) and false otherwise */
  public boolean isSetHiveObject() {
    return this.hiveObject != null;
  }

  public void setHiveObjectIsSet(boolean value) {
    if (!value) {
      this.hiveObject = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getPrincipalName() {
    return this.principalName;
  }

  public HiveObjectPrivilege setPrincipalName(@org.apache.thrift.annotation.Nullable java.lang.String principalName) {
    this.principalName = principalName;
    return this;
  }

  public void unsetPrincipalName() {
    this.principalName = null;
  }

  /** Returns true if field principalName is set (has been assigned a value) and false otherwise */
  public boolean isSetPrincipalName() {
    return this.principalName != null;
  }

  public void setPrincipalNameIsSet(boolean value) {
    if (!value) {
      this.principalName = null;
    }
  }

  /**
   * 
   * @see PrincipalType
   */
  @org.apache.thrift.annotation.Nullable
  public PrincipalType getPrincipalType() {
    return this.principalType;
  }

  /**
   * 
   * @see PrincipalType
   */
  public HiveObjectPrivilege setPrincipalType(@org.apache.thrift.annotation.Nullable PrincipalType principalType) {
    this.principalType = principalType;
    return this;
  }

  public void unsetPrincipalType() {
    this.principalType = null;
  }

  /** Returns true if field principalType is set (has been assigned a value) and false otherwise */
  public boolean isSetPrincipalType() {
    return this.principalType != null;
  }

  public void setPrincipalTypeIsSet(boolean value) {
    if (!value) {
      this.principalType = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public PrivilegeGrantInfo getGrantInfo() {
    return this.grantInfo;
  }

  public HiveObjectPrivilege setGrantInfo(@org.apache.thrift.annotation.Nullable PrivilegeGrantInfo grantInfo) {
    this.grantInfo = grantInfo;
    return this;
  }

  public void unsetGrantInfo() {
    this.grantInfo = null;
  }

  /** Returns true if field grantInfo is set (has been assigned a value) and false otherwise */
  public boolean isSetGrantInfo() {
    return this.grantInfo != null;
  }

  public void setGrantInfoIsSet(boolean value) {
    if (!value) {
      this.grantInfo = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getAuthorizer() {
    return this.authorizer;
  }

  public HiveObjectPrivilege setAuthorizer(@org.apache.thrift.annotation.Nullable java.lang.String authorizer) {
    this.authorizer = authorizer;
    return this;
  }

  public void unsetAuthorizer() {
    this.authorizer = null;
  }

  /** Returns true if field authorizer is set (has been assigned a value) and false otherwise */
  public boolean isSetAuthorizer() {
    return this.authorizer != null;
  }

  public void setAuthorizerIsSet(boolean value) {
    if (!value) {
      this.authorizer = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case HIVE_OBJECT:
      if (value == null) {
        unsetHiveObject();
      } else {
        setHiveObject((HiveObjectRef)value);
      }
      break;

    case PRINCIPAL_NAME:
      if (value == null) {
        unsetPrincipalName();
      } else {
        setPrincipalName((java.lang.String)value);
      }
      break;

    case PRINCIPAL_TYPE:
      if (value == null) {
        unsetPrincipalType();
      } else {
        setPrincipalType((PrincipalType)value);
      }
      break;

    case GRANT_INFO:
      if (value == null) {
        unsetGrantInfo();
      } else {
        setGrantInfo((PrivilegeGrantInfo)value);
      }
      break;

    case AUTHORIZER:
      if (value == null) {
        unsetAuthorizer();
      } else {
        setAuthorizer((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case HIVE_OBJECT:
      return getHiveObject();

    case PRINCIPAL_NAME:
      return getPrincipalName();

    case PRINCIPAL_TYPE:
      return getPrincipalType();

    case GRANT_INFO:
      return getGrantInfo();

    case AUTHORIZER:
      return getAuthorizer();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  @Override
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case HIVE_OBJECT:
      return isSetHiveObject();
    case PRINCIPAL_NAME:
      return isSetPrincipalName();
    case PRINCIPAL_TYPE:
      return isSetPrincipalType();
    case GRANT_INFO:
      return isSetGrantInfo();
    case AUTHORIZER:
      return isSetAuthorizer();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof HiveObjectPrivilege)
      return this.equals((HiveObjectPrivilege)that);
    return false;
  }

  public boolean equals(HiveObjectPrivilege that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_hiveObject = true && this.isSetHiveObject();
    boolean that_present_hiveObject = true && that.isSetHiveObject();
    if (this_present_hiveObject || that_present_hiveObject) {
      if (!(this_present_hiveObject && that_present_hiveObject))
        return false;
      if (!this.hiveObject.equals(that.hiveObject))
        return false;
    }

    boolean this_present_principalName = true && this.isSetPrincipalName();
    boolean that_present_principalName = true && that.isSetPrincipalName();
    if (this_present_principalName || that_present_principalName) {
      if (!(this_present_principalName && that_present_principalName))
        return false;
      if (!this.principalName.equals(that.principalName))
        return false;
    }

    boolean this_present_principalType = true && this.isSetPrincipalType();
    boolean that_present_principalType = true && that.isSetPrincipalType();
    if (this_present_principalType || that_present_principalType) {
      if (!(this_present_principalType && that_present_principalType))
        return false;
      if (!this.principalType.equals(that.principalType))
        return false;
    }

    boolean this_present_grantInfo = true && this.isSetGrantInfo();
    boolean that_present_grantInfo = true && that.isSetGrantInfo();
    if (this_present_grantInfo || that_present_grantInfo) {
      if (!(this_present_grantInfo && that_present_grantInfo))
        return false;
      if (!this.grantInfo.equals(that.grantInfo))
        return false;
    }

    boolean this_present_authorizer = true && this.isSetAuthorizer();
    boolean that_present_authorizer = true && that.isSetAuthorizer();
    if (this_present_authorizer || that_present_authorizer) {
      if (!(this_present_authorizer && that_present_authorizer))
        return false;
      if (!this.authorizer.equals(that.authorizer))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetHiveObject()) ? 131071 : 524287);
    if (isSetHiveObject())
      hashCode = hashCode * 8191 + hiveObject.hashCode();

    hashCode = hashCode * 8191 + ((isSetPrincipalName()) ? 131071 : 524287);
    if (isSetPrincipalName())
      hashCode = hashCode * 8191 + principalName.hashCode();

    hashCode = hashCode * 8191 + ((isSetPrincipalType()) ? 131071 : 524287);
    if (isSetPrincipalType())
      hashCode = hashCode * 8191 + principalType.getValue();

    hashCode = hashCode * 8191 + ((isSetGrantInfo()) ? 131071 : 524287);
    if (isSetGrantInfo())
      hashCode = hashCode * 8191 + grantInfo.hashCode();

    hashCode = hashCode * 8191 + ((isSetAuthorizer()) ? 131071 : 524287);
    if (isSetAuthorizer())
      hashCode = hashCode * 8191 + authorizer.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(HiveObjectPrivilege other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetHiveObject(), other.isSetHiveObject());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHiveObject()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hiveObject, other.hiveObject);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetPrincipalName(), other.isSetPrincipalName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrincipalName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.principalName, other.principalName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetPrincipalType(), other.isSetPrincipalType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrincipalType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.principalType, other.principalType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetGrantInfo(), other.isSetGrantInfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGrantInfo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.grantInfo, other.grantInfo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetAuthorizer(), other.isSetAuthorizer());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAuthorizer()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.authorizer, other.authorizer);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  @Override
  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  @Override
  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("HiveObjectPrivilege(");
    boolean first = true;

    sb.append("hiveObject:");
    if (this.hiveObject == null) {
      sb.append("null");
    } else {
      sb.append(this.hiveObject);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("principalName:");
    if (this.principalName == null) {
      sb.append("null");
    } else {
      sb.append(this.principalName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("principalType:");
    if (this.principalType == null) {
      sb.append("null");
    } else {
      sb.append(this.principalType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("grantInfo:");
    if (this.grantInfo == null) {
      sb.append("null");
    } else {
      sb.append(this.grantInfo);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("authorizer:");
    if (this.authorizer == null) {
      sb.append("null");
    } else {
      sb.append(this.authorizer);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (hiveObject != null) {
      hiveObject.validate();
    }
    if (grantInfo != null) {
      grantInfo.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class HiveObjectPrivilegeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public HiveObjectPrivilegeStandardScheme getScheme() {
      return new HiveObjectPrivilegeStandardScheme();
    }
  }

  private static class HiveObjectPrivilegeStandardScheme extends org.apache.thrift.scheme.StandardScheme<HiveObjectPrivilege> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, HiveObjectPrivilege struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // HIVE_OBJECT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.hiveObject = new HiveObjectRef();
              struct.hiveObject.read(iprot);
              struct.setHiveObjectIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PRINCIPAL_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.principalName = iprot.readString();
              struct.setPrincipalNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PRINCIPAL_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.principalType = com.google.edwmigration.dumper.ext.hive.metastore.thrift.api.superset.PrincipalType.findByValue(iprot.readI32());
              struct.setPrincipalTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // GRANT_INFO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.grantInfo = new PrivilegeGrantInfo();
              struct.grantInfo.read(iprot);
              struct.setGrantInfoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // AUTHORIZER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.authorizer = iprot.readString();
              struct.setAuthorizerIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, HiveObjectPrivilege struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.hiveObject != null) {
        oprot.writeFieldBegin(HIVE_OBJECT_FIELD_DESC);
        struct.hiveObject.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.principalName != null) {
        oprot.writeFieldBegin(PRINCIPAL_NAME_FIELD_DESC);
        oprot.writeString(struct.principalName);
        oprot.writeFieldEnd();
      }
      if (struct.principalType != null) {
        oprot.writeFieldBegin(PRINCIPAL_TYPE_FIELD_DESC);
        oprot.writeI32(struct.principalType.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.grantInfo != null) {
        oprot.writeFieldBegin(GRANT_INFO_FIELD_DESC);
        struct.grantInfo.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.authorizer != null) {
        oprot.writeFieldBegin(AUTHORIZER_FIELD_DESC);
        oprot.writeString(struct.authorizer);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class HiveObjectPrivilegeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public HiveObjectPrivilegeTupleScheme getScheme() {
      return new HiveObjectPrivilegeTupleScheme();
    }
  }

  private static class HiveObjectPrivilegeTupleScheme extends org.apache.thrift.scheme.TupleScheme<HiveObjectPrivilege> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, HiveObjectPrivilege struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetHiveObject()) {
        optionals.set(0);
      }
      if (struct.isSetPrincipalName()) {
        optionals.set(1);
      }
      if (struct.isSetPrincipalType()) {
        optionals.set(2);
      }
      if (struct.isSetGrantInfo()) {
        optionals.set(3);
      }
      if (struct.isSetAuthorizer()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetHiveObject()) {
        struct.hiveObject.write(oprot);
      }
      if (struct.isSetPrincipalName()) {
        oprot.writeString(struct.principalName);
      }
      if (struct.isSetPrincipalType()) {
        oprot.writeI32(struct.principalType.getValue());
      }
      if (struct.isSetGrantInfo()) {
        struct.grantInfo.write(oprot);
      }
      if (struct.isSetAuthorizer()) {
        oprot.writeString(struct.authorizer);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, HiveObjectPrivilege struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.hiveObject = new HiveObjectRef();
        struct.hiveObject.read(iprot);
        struct.setHiveObjectIsSet(true);
      }
      if (incoming.get(1)) {
        struct.principalName = iprot.readString();
        struct.setPrincipalNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.principalType = com.google.edwmigration.dumper.ext.hive.metastore.thrift.api.superset.PrincipalType.findByValue(iprot.readI32());
        struct.setPrincipalTypeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.grantInfo = new PrivilegeGrantInfo();
        struct.grantInfo.read(iprot);
        struct.setGrantInfoIsSet(true);
      }
      if (incoming.get(4)) {
        struct.authorizer = iprot.readString();
        struct.setAuthorizerIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
