/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package study.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class User extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"User\",\"namespace\":\"study.avro\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"favoriteNumber\",\"type\":[\"int\",\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence name;
  @Deprecated public java.lang.Integer favoriteNumber;

  /**
   * Default constructor.
   */
  public User() {}

  /**
   * All-args constructor.
   */
  public User(java.lang.CharSequence name, java.lang.Integer favoriteNumber) {
    this.name = name;
    this.favoriteNumber = favoriteNumber;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return favoriteNumber;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.CharSequence)value$; break;
    case 1: favoriteNumber = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'favoriteNumber' field.
   */
  public java.lang.Integer getFavoriteNumber() {
    return favoriteNumber;
  }

  /**
   * Sets the value of the 'favoriteNumber' field.
   * @param value the value to set.
   */
  public void setFavoriteNumber(java.lang.Integer value) {
    this.favoriteNumber = value;
  }

  /** Creates a new User RecordBuilder */
  public static study.avro.User.Builder newBuilder() {
    return new study.avro.User.Builder();
  }
  
  /** Creates a new User RecordBuilder by copying an existing Builder */
  public static study.avro.User.Builder newBuilder(study.avro.User.Builder other) {
    return new study.avro.User.Builder(other);
  }
  
  /** Creates a new User RecordBuilder by copying an existing User instance */
  public static study.avro.User.Builder newBuilder(study.avro.User other) {
    return new study.avro.User.Builder(other);
  }
  
  /**
   * RecordBuilder for User instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<User>
    implements org.apache.avro.data.RecordBuilder<User> {

    private java.lang.CharSequence name;
    private java.lang.Integer favoriteNumber;

    /** Creates a new Builder */
    private Builder() {
      super(study.avro.User.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(study.avro.User.Builder other) {
      super(other);
    }
    
    /** Creates a Builder by copying an existing User instance */
    private Builder(study.avro.User other) {
            super(study.avro.User.SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.favoriteNumber)) {
        this.favoriteNumber = data().deepCopy(fields()[1].schema(), other.favoriteNumber);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'name' field */
    public java.lang.CharSequence getName() {
      return name;
    }
    
    /** Sets the value of the 'name' field */
    public study.avro.User.Builder setName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'name' field has been set */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'name' field */
    public study.avro.User.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'favoriteNumber' field */
    public java.lang.Integer getFavoriteNumber() {
      return favoriteNumber;
    }
    
    /** Sets the value of the 'favoriteNumber' field */
    public study.avro.User.Builder setFavoriteNumber(java.lang.Integer value) {
      validate(fields()[1], value);
      this.favoriteNumber = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'favoriteNumber' field has been set */
    public boolean hasFavoriteNumber() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'favoriteNumber' field */
    public study.avro.User.Builder clearFavoriteNumber() {
      favoriteNumber = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public User build() {
      try {
        User record = new User();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.favoriteNumber = fieldSetFlags()[1] ? this.favoriteNumber : (java.lang.Integer) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
