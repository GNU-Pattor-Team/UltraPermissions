package me.TechsCode.UltraPermissions.dependencies.hikari.pool;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Wrapper;
import java.util.Calendar;
import java.util.Map;

public class HikariProxyResultSet extends ProxyResultSet implements ResultSet, Wrapper, AutoCloseable {
  public boolean next() {
    try {
      return this.delegate.next();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void close() {
    try {
      this.delegate.close();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean wasNull() {
    try {
      return this.delegate.wasNull();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public String getString(int paramInt) {
    try {
      return this.delegate.getString(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean getBoolean(int paramInt) {
    try {
      return this.delegate.getBoolean(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public byte getByte(int paramInt) {
    try {
      return this.delegate.getByte(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public short getShort(int paramInt) {
    try {
      return this.delegate.getShort(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getInt(int paramInt) {
    try {
      return this.delegate.getInt(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public long getLong(int paramInt) {
    try {
      return this.delegate.getLong(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public float getFloat(int paramInt) {
    try {
      return this.delegate.getFloat(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public double getDouble(int paramInt) {
    try {
      return this.delegate.getDouble(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public BigDecimal getBigDecimal(int paramInt1, int paramInt2) {
    try {
      return this.delegate.getBigDecimal(paramInt1, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public byte[] getBytes(int paramInt) {
    try {
      return this.delegate.getBytes(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Date getDate(int paramInt) {
    try {
      return this.delegate.getDate(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Time getTime(int paramInt) {
    try {
      return this.delegate.getTime(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Timestamp getTimestamp(int paramInt) {
    try {
      return this.delegate.getTimestamp(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public InputStream getAsciiStream(int paramInt) {
    try {
      return this.delegate.getAsciiStream(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public InputStream getUnicodeStream(int paramInt) {
    try {
      return this.delegate.getUnicodeStream(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public InputStream getBinaryStream(int paramInt) {
    try {
      return this.delegate.getBinaryStream(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public String getString(String paramString) {
    try {
      return this.delegate.getString(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean getBoolean(String paramString) {
    try {
      return this.delegate.getBoolean(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public byte getByte(String paramString) {
    try {
      return this.delegate.getByte(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public short getShort(String paramString) {
    try {
      return this.delegate.getShort(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getInt(String paramString) {
    try {
      return this.delegate.getInt(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public long getLong(String paramString) {
    try {
      return this.delegate.getLong(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public float getFloat(String paramString) {
    try {
      return this.delegate.getFloat(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public double getDouble(String paramString) {
    try {
      return this.delegate.getDouble(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public BigDecimal getBigDecimal(String paramString, int paramInt) {
    try {
      return this.delegate.getBigDecimal(paramString, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public byte[] getBytes(String paramString) {
    try {
      return this.delegate.getBytes(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Date getDate(String paramString) {
    try {
      return this.delegate.getDate(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Time getTime(String paramString) {
    try {
      return this.delegate.getTime(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Timestamp getTimestamp(String paramString) {
    try {
      return this.delegate.getTimestamp(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public InputStream getAsciiStream(String paramString) {
    try {
      return this.delegate.getAsciiStream(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public InputStream getUnicodeStream(String paramString) {
    try {
      return this.delegate.getUnicodeStream(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public InputStream getBinaryStream(String paramString) {
    try {
      return this.delegate.getBinaryStream(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public SQLWarning getWarnings() {
    try {
      return this.delegate.getWarnings();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void clearWarnings() {
    try {
      this.delegate.clearWarnings();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public String getCursorName() {
    try {
      return this.delegate.getCursorName();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public ResultSetMetaData getMetaData() {
    try {
      return this.delegate.getMetaData();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Object getObject(int paramInt) {
    try {
      return this.delegate.getObject(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Object getObject(String paramString) {
    try {
      return this.delegate.getObject(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int findColumn(String paramString) {
    try {
      return this.delegate.findColumn(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Reader getCharacterStream(int paramInt) {
    try {
      return this.delegate.getCharacterStream(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Reader getCharacterStream(String paramString) {
    try {
      return this.delegate.getCharacterStream(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public BigDecimal getBigDecimal(int paramInt) {
    try {
      return this.delegate.getBigDecimal(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public BigDecimal getBigDecimal(String paramString) {
    try {
      return this.delegate.getBigDecimal(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isBeforeFirst() {
    try {
      return this.delegate.isBeforeFirst();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isAfterLast() {
    try {
      return this.delegate.isAfterLast();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isFirst() {
    try {
      return this.delegate.isFirst();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isLast() {
    try {
      return this.delegate.isLast();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void beforeFirst() {
    try {
      this.delegate.beforeFirst();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void afterLast() {
    try {
      this.delegate.afterLast();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean first() {
    try {
      return this.delegate.first();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean last() {
    try {
      return this.delegate.last();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getRow() {
    try {
      return this.delegate.getRow();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean absolute(int paramInt) {
    try {
      return this.delegate.absolute(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean relative(int paramInt) {
    try {
      return this.delegate.relative(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean previous() {
    try {
      return this.delegate.previous();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setFetchDirection(int paramInt) {
    try {
      this.delegate.setFetchDirection(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getFetchDirection() {
    try {
      return this.delegate.getFetchDirection();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setFetchSize(int paramInt) {
    try {
      this.delegate.setFetchSize(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getFetchSize() {
    try {
      return this.delegate.getFetchSize();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getType() {
    try {
      return this.delegate.getType();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getConcurrency() {
    try {
      return this.delegate.getConcurrency();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean rowUpdated() {
    try {
      return this.delegate.rowUpdated();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean rowInserted() {
    try {
      return this.delegate.rowInserted();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean rowDeleted() {
    try {
      return this.delegate.rowDeleted();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateNull(int paramInt) {
    try {
      this.delegate.updateNull(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBoolean(int paramInt, boolean paramBoolean) {
    try {
      this.delegate.updateBoolean(paramInt, paramBoolean);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateByte(int paramInt, byte paramByte) {
    try {
      this.delegate.updateByte(paramInt, paramByte);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateShort(int paramInt, short paramShort) {
    try {
      this.delegate.updateShort(paramInt, paramShort);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateInt(int paramInt1, int paramInt2) {
    try {
      this.delegate.updateInt(paramInt1, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateLong(int paramInt, long paramLong) {
    try {
      this.delegate.updateLong(paramInt, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateFloat(int paramInt, float paramFloat) {
    try {
      this.delegate.updateFloat(paramInt, paramFloat);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateDouble(int paramInt, double paramDouble) {
    try {
      this.delegate.updateDouble(paramInt, paramDouble);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBigDecimal(int paramInt, BigDecimal paramBigDecimal) {
    try {
      this.delegate.updateBigDecimal(paramInt, paramBigDecimal);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateString(int paramInt, String paramString) {
    try {
      this.delegate.updateString(paramInt, paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBytes(int paramInt, byte[] paramArrayOfbyte) {
    try {
      this.delegate.updateBytes(paramInt, paramArrayOfbyte);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateDate(int paramInt, Date paramDate) {
    try {
      this.delegate.updateDate(paramInt, paramDate);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateTime(int paramInt, Time paramTime) {
    try {
      this.delegate.updateTime(paramInt, paramTime);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateTimestamp(int paramInt, Timestamp paramTimestamp) {
    try {
      this.delegate.updateTimestamp(paramInt, paramTimestamp);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateAsciiStream(int paramInt1, InputStream paramInputStream, int paramInt2) {
    try {
      this.delegate.updateAsciiStream(paramInt1, paramInputStream, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBinaryStream(int paramInt1, InputStream paramInputStream, int paramInt2) {
    try {
      this.delegate.updateBinaryStream(paramInt1, paramInputStream, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateCharacterStream(int paramInt1, Reader paramReader, int paramInt2) {
    try {
      this.delegate.updateCharacterStream(paramInt1, paramReader, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateObject(int paramInt1, Object paramObject, int paramInt2) {
    try {
      this.delegate.updateObject(paramInt1, paramObject, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateObject(int paramInt, Object paramObject) {
    try {
      this.delegate.updateObject(paramInt, paramObject);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateNull(String paramString) {
    try {
      this.delegate.updateNull(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBoolean(String paramString, boolean paramBoolean) {
    try {
      this.delegate.updateBoolean(paramString, paramBoolean);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateByte(String paramString, byte paramByte) {
    try {
      this.delegate.updateByte(paramString, paramByte);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateShort(String paramString, short paramShort) {
    try {
      this.delegate.updateShort(paramString, paramShort);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateInt(String paramString, int paramInt) {
    try {
      this.delegate.updateInt(paramString, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateLong(String paramString, long paramLong) {
    try {
      this.delegate.updateLong(paramString, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateFloat(String paramString, float paramFloat) {
    try {
      this.delegate.updateFloat(paramString, paramFloat);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateDouble(String paramString, double paramDouble) {
    try {
      this.delegate.updateDouble(paramString, paramDouble);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBigDecimal(String paramString, BigDecimal paramBigDecimal) {
    try {
      this.delegate.updateBigDecimal(paramString, paramBigDecimal);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateString(String paramString1, String paramString2) {
    try {
      this.delegate.updateString(paramString1, paramString2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBytes(String paramString, byte[] paramArrayOfbyte) {
    try {
      this.delegate.updateBytes(paramString, paramArrayOfbyte);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateDate(String paramString, Date paramDate) {
    try {
      this.delegate.updateDate(paramString, paramDate);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateTime(String paramString, Time paramTime) {
    try {
      this.delegate.updateTime(paramString, paramTime);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateTimestamp(String paramString, Timestamp paramTimestamp) {
    try {
      this.delegate.updateTimestamp(paramString, paramTimestamp);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateAsciiStream(String paramString, InputStream paramInputStream, int paramInt) {
    try {
      this.delegate.updateAsciiStream(paramString, paramInputStream, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBinaryStream(String paramString, InputStream paramInputStream, int paramInt) {
    try {
      this.delegate.updateBinaryStream(paramString, paramInputStream, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateCharacterStream(String paramString, Reader paramReader, int paramInt) {
    try {
      this.delegate.updateCharacterStream(paramString, paramReader, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateObject(String paramString, Object paramObject, int paramInt) {
    try {
      this.delegate.updateObject(paramString, paramObject, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateObject(String paramString, Object paramObject) {
    try {
      this.delegate.updateObject(paramString, paramObject);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void insertRow() {
    try {
      super.insertRow();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateRow() {
    try {
      super.updateRow();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void deleteRow() {
    try {
      super.deleteRow();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void refreshRow() {
    try {
      this.delegate.refreshRow();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void cancelRowUpdates() {
    try {
      this.delegate.cancelRowUpdates();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void moveToInsertRow() {
    try {
      this.delegate.moveToInsertRow();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void moveToCurrentRow() {
    try {
      this.delegate.moveToCurrentRow();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Object getObject(int paramInt, Map<String, Class<?>> paramMap) {
    try {
      return this.delegate.getObject(paramInt, paramMap);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Ref getRef(int paramInt) {
    try {
      return this.delegate.getRef(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Blob getBlob(int paramInt) {
    try {
      return this.delegate.getBlob(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Clob getClob(int paramInt) {
    try {
      return this.delegate.getClob(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Array getArray(int paramInt) {
    try {
      return this.delegate.getArray(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Object getObject(String paramString, Map<String, Class<?>> paramMap) {
    try {
      return this.delegate.getObject(paramString, paramMap);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Ref getRef(String paramString) {
    try {
      return this.delegate.getRef(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Blob getBlob(String paramString) {
    try {
      return this.delegate.getBlob(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Clob getClob(String paramString) {
    try {
      return this.delegate.getClob(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Array getArray(String paramString) {
    try {
      return this.delegate.getArray(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Date getDate(int paramInt, Calendar paramCalendar) {
    try {
      return this.delegate.getDate(paramInt, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Date getDate(String paramString, Calendar paramCalendar) {
    try {
      return this.delegate.getDate(paramString, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Time getTime(int paramInt, Calendar paramCalendar) {
    try {
      return this.delegate.getTime(paramInt, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Time getTime(String paramString, Calendar paramCalendar) {
    try {
      return this.delegate.getTime(paramString, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Timestamp getTimestamp(int paramInt, Calendar paramCalendar) {
    try {
      return this.delegate.getTimestamp(paramInt, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Timestamp getTimestamp(String paramString, Calendar paramCalendar) {
    try {
      return this.delegate.getTimestamp(paramString, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public URL getURL(int paramInt) {
    try {
      return this.delegate.getURL(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public URL getURL(String paramString) {
    try {
      return this.delegate.getURL(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateRef(int paramInt, Ref paramRef) {
    try {
      this.delegate.updateRef(paramInt, paramRef);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateRef(String paramString, Ref paramRef) {
    try {
      this.delegate.updateRef(paramString, paramRef);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBlob(int paramInt, Blob paramBlob) {
    try {
      this.delegate.updateBlob(paramInt, paramBlob);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBlob(String paramString, Blob paramBlob) {
    try {
      this.delegate.updateBlob(paramString, paramBlob);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateClob(int paramInt, Clob paramClob) {
    try {
      this.delegate.updateClob(paramInt, paramClob);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateClob(String paramString, Clob paramClob) {
    try {
      this.delegate.updateClob(paramString, paramClob);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateArray(int paramInt, Array paramArray) {
    try {
      this.delegate.updateArray(paramInt, paramArray);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateArray(String paramString, Array paramArray) {
    try {
      this.delegate.updateArray(paramString, paramArray);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public RowId getRowId(int paramInt) {
    try {
      return this.delegate.getRowId(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public RowId getRowId(String paramString) {
    try {
      return this.delegate.getRowId(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateRowId(int paramInt, RowId paramRowId) {
    try {
      this.delegate.updateRowId(paramInt, paramRowId);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateRowId(String paramString, RowId paramRowId) {
    try {
      this.delegate.updateRowId(paramString, paramRowId);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getHoldability() {
    try {
      return this.delegate.getHoldability();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isClosed() {
    try {
      return this.delegate.isClosed();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateNString(int paramInt, String paramString) {
    try {
      this.delegate.updateNString(paramInt, paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateNString(String paramString1, String paramString2) {
    try {
      this.delegate.updateNString(paramString1, paramString2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateNClob(int paramInt, NClob paramNClob) {
    try {
      this.delegate.updateNClob(paramInt, paramNClob);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateNClob(String paramString, NClob paramNClob) {
    try {
      this.delegate.updateNClob(paramString, paramNClob);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public NClob getNClob(int paramInt) {
    try {
      return this.delegate.getNClob(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public NClob getNClob(String paramString) {
    try {
      return this.delegate.getNClob(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public SQLXML getSQLXML(int paramInt) {
    try {
      return this.delegate.getSQLXML(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public SQLXML getSQLXML(String paramString) {
    try {
      return this.delegate.getSQLXML(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateSQLXML(int paramInt, SQLXML paramSQLXML) {
    try {
      this.delegate.updateSQLXML(paramInt, paramSQLXML);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateSQLXML(String paramString, SQLXML paramSQLXML) {
    try {
      this.delegate.updateSQLXML(paramString, paramSQLXML);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public String getNString(int paramInt) {
    try {
      return this.delegate.getNString(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public String getNString(String paramString) {
    try {
      return this.delegate.getNString(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Reader getNCharacterStream(int paramInt) {
    try {
      return this.delegate.getNCharacterStream(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Reader getNCharacterStream(String paramString) {
    try {
      return this.delegate.getNCharacterStream(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateNCharacterStream(int paramInt, Reader paramReader, long paramLong) {
    try {
      this.delegate.updateNCharacterStream(paramInt, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateNCharacterStream(String paramString, Reader paramReader, long paramLong) {
    try {
      this.delegate.updateNCharacterStream(paramString, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateAsciiStream(int paramInt, InputStream paramInputStream, long paramLong) {
    try {
      this.delegate.updateAsciiStream(paramInt, paramInputStream, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBinaryStream(int paramInt, InputStream paramInputStream, long paramLong) {
    try {
      this.delegate.updateBinaryStream(paramInt, paramInputStream, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateCharacterStream(int paramInt, Reader paramReader, long paramLong) {
    try {
      this.delegate.updateCharacterStream(paramInt, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateAsciiStream(String paramString, InputStream paramInputStream, long paramLong) {
    try {
      this.delegate.updateAsciiStream(paramString, paramInputStream, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBinaryStream(String paramString, InputStream paramInputStream, long paramLong) {
    try {
      this.delegate.updateBinaryStream(paramString, paramInputStream, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateCharacterStream(String paramString, Reader paramReader, long paramLong) {
    try {
      this.delegate.updateCharacterStream(paramString, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBlob(int paramInt, InputStream paramInputStream, long paramLong) {
    try {
      this.delegate.updateBlob(paramInt, paramInputStream, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBlob(String paramString, InputStream paramInputStream, long paramLong) {
    try {
      this.delegate.updateBlob(paramString, paramInputStream, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateClob(int paramInt, Reader paramReader, long paramLong) {
    try {
      this.delegate.updateClob(paramInt, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateClob(String paramString, Reader paramReader, long paramLong) {
    try {
      this.delegate.updateClob(paramString, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateNClob(int paramInt, Reader paramReader, long paramLong) {
    try {
      this.delegate.updateNClob(paramInt, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateNClob(String paramString, Reader paramReader, long paramLong) {
    try {
      this.delegate.updateNClob(paramString, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateNCharacterStream(int paramInt, Reader paramReader) {
    try {
      this.delegate.updateNCharacterStream(paramInt, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateNCharacterStream(String paramString, Reader paramReader) {
    try {
      this.delegate.updateNCharacterStream(paramString, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateAsciiStream(int paramInt, InputStream paramInputStream) {
    try {
      this.delegate.updateAsciiStream(paramInt, paramInputStream);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBinaryStream(int paramInt, InputStream paramInputStream) {
    try {
      this.delegate.updateBinaryStream(paramInt, paramInputStream);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateCharacterStream(int paramInt, Reader paramReader) {
    try {
      this.delegate.updateCharacterStream(paramInt, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateAsciiStream(String paramString, InputStream paramInputStream) {
    try {
      this.delegate.updateAsciiStream(paramString, paramInputStream);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBinaryStream(String paramString, InputStream paramInputStream) {
    try {
      this.delegate.updateBinaryStream(paramString, paramInputStream);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateCharacterStream(String paramString, Reader paramReader) {
    try {
      this.delegate.updateCharacterStream(paramString, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBlob(int paramInt, InputStream paramInputStream) {
    try {
      this.delegate.updateBlob(paramInt, paramInputStream);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateBlob(String paramString, InputStream paramInputStream) {
    try {
      this.delegate.updateBlob(paramString, paramInputStream);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateClob(int paramInt, Reader paramReader) {
    try {
      this.delegate.updateClob(paramInt, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateClob(String paramString, Reader paramReader) {
    try {
      this.delegate.updateClob(paramString, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateNClob(int paramInt, Reader paramReader) {
    try {
      this.delegate.updateNClob(paramInt, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void updateNClob(String paramString, Reader paramReader) {
    try {
      this.delegate.updateNClob(paramString, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Object getObject(int paramInt, Class<?> paramClass) {
    try {
      return this.delegate.getObject(paramInt, paramClass);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Object getObject(String paramString, Class<?> paramClass) {
    try {
      return this.delegate.getObject(paramString, paramClass);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isWrapperFor(Class<?> paramClass) {
    try {
      return this.delegate.isWrapperFor(paramClass);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  protected HikariProxyResultSet(ProxyConnection paramProxyConnection, ProxyStatement paramProxyStatement, ResultSet paramResultSet) {
    super(paramProxyConnection, paramProxyStatement, paramResultSet);
  }
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/pool/HikariProxyResultSet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */