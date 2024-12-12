// ORM class for table 'order_detail'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Sat Nov 18 22:55:01 UTC 2023
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class order_detail extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("order_created_timestamp", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        order_detail.this.order_created_timestamp = (java.sql.Timestamp)value;
      }
    });
    setters.put("status", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        order_detail.this.status = (String)value;
      }
    });
    setters.put("price", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        order_detail.this.price = (Integer)value;
      }
    });
    setters.put("discount", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        order_detail.this.discount = (Double)value;
      }
    });
    setters.put("id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        order_detail.this.id = (String)value;
      }
    });
    setters.put("driver_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        order_detail.this.driver_id = (String)value;
      }
    });
    setters.put("user_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        order_detail.this.user_id = (String)value;
      }
    });
    setters.put("restaurant_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        order_detail.this.restaurant_id = (String)value;
      }
    });
  }
  public order_detail() {
    init0();
  }
  private java.sql.Timestamp order_created_timestamp;
  public java.sql.Timestamp get_order_created_timestamp() {
    return order_created_timestamp;
  }
  public void set_order_created_timestamp(java.sql.Timestamp order_created_timestamp) {
    this.order_created_timestamp = order_created_timestamp;
  }
  public order_detail with_order_created_timestamp(java.sql.Timestamp order_created_timestamp) {
    this.order_created_timestamp = order_created_timestamp;
    return this;
  }
  private String status;
  public String get_status() {
    return status;
  }
  public void set_status(String status) {
    this.status = status;
  }
  public order_detail with_status(String status) {
    this.status = status;
    return this;
  }
  private Integer price;
  public Integer get_price() {
    return price;
  }
  public void set_price(Integer price) {
    this.price = price;
  }
  public order_detail with_price(Integer price) {
    this.price = price;
    return this;
  }
  private Double discount;
  public Double get_discount() {
    return discount;
  }
  public void set_discount(Double discount) {
    this.discount = discount;
  }
  public order_detail with_discount(Double discount) {
    this.discount = discount;
    return this;
  }
  private String id;
  public String get_id() {
    return id;
  }
  public void set_id(String id) {
    this.id = id;
  }
  public order_detail with_id(String id) {
    this.id = id;
    return this;
  }
  private String driver_id;
  public String get_driver_id() {
    return driver_id;
  }
  public void set_driver_id(String driver_id) {
    this.driver_id = driver_id;
  }
  public order_detail with_driver_id(String driver_id) {
    this.driver_id = driver_id;
    return this;
  }
  private String user_id;
  public String get_user_id() {
    return user_id;
  }
  public void set_user_id(String user_id) {
    this.user_id = user_id;
  }
  public order_detail with_user_id(String user_id) {
    this.user_id = user_id;
    return this;
  }
  private String restaurant_id;
  public String get_restaurant_id() {
    return restaurant_id;
  }
  public void set_restaurant_id(String restaurant_id) {
    this.restaurant_id = restaurant_id;
  }
  public order_detail with_restaurant_id(String restaurant_id) {
    this.restaurant_id = restaurant_id;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof order_detail)) {
      return false;
    }
    order_detail that = (order_detail) o;
    boolean equal = true;
    equal = equal && (this.order_created_timestamp == null ? that.order_created_timestamp == null : this.order_created_timestamp.equals(that.order_created_timestamp));
    equal = equal && (this.status == null ? that.status == null : this.status.equals(that.status));
    equal = equal && (this.price == null ? that.price == null : this.price.equals(that.price));
    equal = equal && (this.discount == null ? that.discount == null : this.discount.equals(that.discount));
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.driver_id == null ? that.driver_id == null : this.driver_id.equals(that.driver_id));
    equal = equal && (this.user_id == null ? that.user_id == null : this.user_id.equals(that.user_id));
    equal = equal && (this.restaurant_id == null ? that.restaurant_id == null : this.restaurant_id.equals(that.restaurant_id));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof order_detail)) {
      return false;
    }
    order_detail that = (order_detail) o;
    boolean equal = true;
    equal = equal && (this.order_created_timestamp == null ? that.order_created_timestamp == null : this.order_created_timestamp.equals(that.order_created_timestamp));
    equal = equal && (this.status == null ? that.status == null : this.status.equals(that.status));
    equal = equal && (this.price == null ? that.price == null : this.price.equals(that.price));
    equal = equal && (this.discount == null ? that.discount == null : this.discount.equals(that.discount));
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.driver_id == null ? that.driver_id == null : this.driver_id.equals(that.driver_id));
    equal = equal && (this.user_id == null ? that.user_id == null : this.user_id.equals(that.user_id));
    equal = equal && (this.restaurant_id == null ? that.restaurant_id == null : this.restaurant_id.equals(that.restaurant_id));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.order_created_timestamp = JdbcWritableBridge.readTimestamp(1, __dbResults);
    this.status = JdbcWritableBridge.readString(2, __dbResults);
    this.price = JdbcWritableBridge.readInteger(3, __dbResults);
    this.discount = JdbcWritableBridge.readDouble(4, __dbResults);
    this.id = JdbcWritableBridge.readString(5, __dbResults);
    this.driver_id = JdbcWritableBridge.readString(6, __dbResults);
    this.user_id = JdbcWritableBridge.readString(7, __dbResults);
    this.restaurant_id = JdbcWritableBridge.readString(8, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.order_created_timestamp = JdbcWritableBridge.readTimestamp(1, __dbResults);
    this.status = JdbcWritableBridge.readString(2, __dbResults);
    this.price = JdbcWritableBridge.readInteger(3, __dbResults);
    this.discount = JdbcWritableBridge.readDouble(4, __dbResults);
    this.id = JdbcWritableBridge.readString(5, __dbResults);
    this.driver_id = JdbcWritableBridge.readString(6, __dbResults);
    this.user_id = JdbcWritableBridge.readString(7, __dbResults);
    this.restaurant_id = JdbcWritableBridge.readString(8, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeTimestamp(order_created_timestamp, 1 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeString(status, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(price, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDouble(discount, 4 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeString(id, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(driver_id, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(user_id, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(restaurant_id, 8 + __off, 12, __dbStmt);
    return 8;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeTimestamp(order_created_timestamp, 1 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeString(status, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(price, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDouble(discount, 4 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeString(id, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(driver_id, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(user_id, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(restaurant_id, 8 + __off, 12, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.order_created_timestamp = null;
    } else {
    this.order_created_timestamp = new Timestamp(__dataIn.readLong());
    this.order_created_timestamp.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.status = null;
    } else {
    this.status = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.price = null;
    } else {
    this.price = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.discount = null;
    } else {
    this.discount = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.id = null;
    } else {
    this.id = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.driver_id = null;
    } else {
    this.driver_id = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.user_id = null;
    } else {
    this.user_id = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.restaurant_id = null;
    } else {
    this.restaurant_id = Text.readString(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.order_created_timestamp) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.order_created_timestamp.getTime());
    __dataOut.writeInt(this.order_created_timestamp.getNanos());
    }
    if (null == this.status) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, status);
    }
    if (null == this.price) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.price);
    }
    if (null == this.discount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.discount);
    }
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, id);
    }
    if (null == this.driver_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, driver_id);
    }
    if (null == this.user_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, user_id);
    }
    if (null == this.restaurant_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, restaurant_id);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.order_created_timestamp) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.order_created_timestamp.getTime());
    __dataOut.writeInt(this.order_created_timestamp.getNanos());
    }
    if (null == this.status) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, status);
    }
    if (null == this.price) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.price);
    }
    if (null == this.discount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.discount);
    }
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, id);
    }
    if (null == this.driver_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, driver_id);
    }
    if (null == this.user_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, user_id);
    }
    if (null == this.restaurant_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, restaurant_id);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(order_created_timestamp==null?"null":"" + order_created_timestamp, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(status==null?"null":status, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(price==null?"null":"" + price, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(discount==null?"null":"" + discount, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(driver_id==null?"null":driver_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(user_id==null?"null":user_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(restaurant_id==null?"null":restaurant_id, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(order_created_timestamp==null?"null":"" + order_created_timestamp, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(status==null?"null":status, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(price==null?"null":"" + price, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(discount==null?"null":"" + discount, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(driver_id==null?"null":driver_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(user_id==null?"null":user_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(restaurant_id==null?"null":restaurant_id, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.order_created_timestamp = null; } else {
      this.order_created_timestamp = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.status = null; } else {
      this.status = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.price = null; } else {
      this.price = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.discount = null; } else {
      this.discount = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.id = null; } else {
      this.id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.driver_id = null; } else {
      this.driver_id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.user_id = null; } else {
      this.user_id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.restaurant_id = null; } else {
      this.restaurant_id = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.order_created_timestamp = null; } else {
      this.order_created_timestamp = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.status = null; } else {
      this.status = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.price = null; } else {
      this.price = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.discount = null; } else {
      this.discount = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.id = null; } else {
      this.id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.driver_id = null; } else {
      this.driver_id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.user_id = null; } else {
      this.user_id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.restaurant_id = null; } else {
      this.restaurant_id = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    order_detail o = (order_detail) super.clone();
    o.order_created_timestamp = (o.order_created_timestamp != null) ? (java.sql.Timestamp) o.order_created_timestamp.clone() : null;
    return o;
  }

  public void clone0(order_detail o) throws CloneNotSupportedException {
    o.order_created_timestamp = (o.order_created_timestamp != null) ? (java.sql.Timestamp) o.order_created_timestamp.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("order_created_timestamp", this.order_created_timestamp);
    __sqoop$field_map.put("status", this.status);
    __sqoop$field_map.put("price", this.price);
    __sqoop$field_map.put("discount", this.discount);
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("driver_id", this.driver_id);
    __sqoop$field_map.put("user_id", this.user_id);
    __sqoop$field_map.put("restaurant_id", this.restaurant_id);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("order_created_timestamp", this.order_created_timestamp);
    __sqoop$field_map.put("status", this.status);
    __sqoop$field_map.put("price", this.price);
    __sqoop$field_map.put("discount", this.discount);
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("driver_id", this.driver_id);
    __sqoop$field_map.put("user_id", this.user_id);
    __sqoop$field_map.put("restaurant_id", this.restaurant_id);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
