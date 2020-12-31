package me.TechsCode.UltraPermissions.dependencies.hikari.pool;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Wrapper;
import java.util.Calendar;
import java.util.Map;

public class HikariProxyCallableStatement extends ProxyCallableStatement implements PreparedStatement, Statement, CallableStatement, Wrapper, AutoCloseable {
  public ResultSet executeQuery() {
    try {
      return super.executeQuery();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int executeUpdate() {
    try {
      return super.executeUpdate();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNull(int paramInt1, int paramInt2) {
    try {
      ((CallableStatement)this.delegate).setNull(paramInt1, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBoolean(int paramInt, boolean paramBoolean) {
    try {
      ((CallableStatement)this.delegate).setBoolean(paramInt, paramBoolean);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setByte(int paramInt, byte paramByte) {
    try {
      ((CallableStatement)this.delegate).setByte(paramInt, paramByte);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setShort(int paramInt, short paramShort) {
    try {
      ((CallableStatement)this.delegate).setShort(paramInt, paramShort);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setInt(int paramInt1, int paramInt2) {
    try {
      ((CallableStatement)this.delegate).setInt(paramInt1, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setLong(int paramInt, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setLong(paramInt, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setFloat(int paramInt, float paramFloat) {
    try {
      ((CallableStatement)this.delegate).setFloat(paramInt, paramFloat);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setDouble(int paramInt, double paramDouble) {
    try {
      ((CallableStatement)this.delegate).setDouble(paramInt, paramDouble);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBigDecimal(int paramInt, BigDecimal paramBigDecimal) {
    try {
      ((CallableStatement)this.delegate).setBigDecimal(paramInt, paramBigDecimal);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setString(int paramInt, String paramString) {
    try {
      ((CallableStatement)this.delegate).setString(paramInt, paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBytes(int paramInt, byte[] paramArrayOfbyte) {
    try {
      ((CallableStatement)this.delegate).setBytes(paramInt, paramArrayOfbyte);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setDate(int paramInt, Date paramDate) {
    try {
      ((CallableStatement)this.delegate).setDate(paramInt, paramDate);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setTime(int paramInt, Time paramTime) {
    try {
      ((CallableStatement)this.delegate).setTime(paramInt, paramTime);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setTimestamp(int paramInt, Timestamp paramTimestamp) {
    try {
      ((CallableStatement)this.delegate).setTimestamp(paramInt, paramTimestamp);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setAsciiStream(int paramInt1, InputStream paramInputStream, int paramInt2) {
    try {
      ((CallableStatement)this.delegate).setAsciiStream(paramInt1, paramInputStream, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setUnicodeStream(int paramInt1, InputStream paramInputStream, int paramInt2) {
    try {
      ((CallableStatement)this.delegate).setUnicodeStream(paramInt1, paramInputStream, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBinaryStream(int paramInt1, InputStream paramInputStream, int paramInt2) {
    try {
      ((CallableStatement)this.delegate).setBinaryStream(paramInt1, paramInputStream, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void clearParameters() {
    try {
      ((CallableStatement)this.delegate).clearParameters();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setObject(int paramInt1, Object paramObject, int paramInt2) {
    try {
      ((CallableStatement)this.delegate).setObject(paramInt1, paramObject, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setObject(int paramInt, Object paramObject) {
    try {
      ((CallableStatement)this.delegate).setObject(paramInt, paramObject);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean execute() {
    try {
      return super.execute();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void addBatch() {
    try {
      ((CallableStatement)this.delegate).addBatch();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setCharacterStream(int paramInt1, Reader paramReader, int paramInt2) {
    try {
      ((CallableStatement)this.delegate).setCharacterStream(paramInt1, paramReader, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setRef(int paramInt, Ref paramRef) {
    try {
      ((CallableStatement)this.delegate).setRef(paramInt, paramRef);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBlob(int paramInt, Blob paramBlob) {
    try {
      ((CallableStatement)this.delegate).setBlob(paramInt, paramBlob);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setClob(int paramInt, Clob paramClob) {
    try {
      ((CallableStatement)this.delegate).setClob(paramInt, paramClob);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setArray(int paramInt, Array paramArray) {
    try {
      ((CallableStatement)this.delegate).setArray(paramInt, paramArray);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public ResultSetMetaData getMetaData() {
    try {
      return ((CallableStatement)this.delegate).getMetaData();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setDate(int paramInt, Date paramDate, Calendar paramCalendar) {
    try {
      ((CallableStatement)this.delegate).setDate(paramInt, paramDate, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setTime(int paramInt, Time paramTime, Calendar paramCalendar) {
    try {
      ((CallableStatement)this.delegate).setTime(paramInt, paramTime, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setTimestamp(int paramInt, Timestamp paramTimestamp, Calendar paramCalendar) {
    try {
      ((CallableStatement)this.delegate).setTimestamp(paramInt, paramTimestamp, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNull(int paramInt1, int paramInt2, String paramString) {
    try {
      ((CallableStatement)this.delegate).setNull(paramInt1, paramInt2, paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setURL(int paramInt, URL paramURL) {
    try {
      ((CallableStatement)this.delegate).setURL(paramInt, paramURL);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public ParameterMetaData getParameterMetaData() {
    try {
      return ((CallableStatement)this.delegate).getParameterMetaData();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setRowId(int paramInt, RowId paramRowId) {
    try {
      ((CallableStatement)this.delegate).setRowId(paramInt, paramRowId);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNString(int paramInt, String paramString) {
    try {
      ((CallableStatement)this.delegate).setNString(paramInt, paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNCharacterStream(int paramInt, Reader paramReader, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setNCharacterStream(paramInt, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNClob(int paramInt, NClob paramNClob) {
    try {
      ((CallableStatement)this.delegate).setNClob(paramInt, paramNClob);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setClob(int paramInt, Reader paramReader, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setClob(paramInt, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBlob(int paramInt, InputStream paramInputStream, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setBlob(paramInt, paramInputStream, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNClob(int paramInt, Reader paramReader, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setNClob(paramInt, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setSQLXML(int paramInt, SQLXML paramSQLXML) {
    try {
      ((CallableStatement)this.delegate).setSQLXML(paramInt, paramSQLXML);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setObject(int paramInt1, Object paramObject, int paramInt2, int paramInt3) {
    try {
      ((CallableStatement)this.delegate).setObject(paramInt1, paramObject, paramInt2, paramInt3);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setAsciiStream(int paramInt, InputStream paramInputStream, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setAsciiStream(paramInt, paramInputStream, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBinaryStream(int paramInt, InputStream paramInputStream, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setBinaryStream(paramInt, paramInputStream, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setCharacterStream(int paramInt, Reader paramReader, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setCharacterStream(paramInt, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setAsciiStream(int paramInt, InputStream paramInputStream) {
    try {
      ((CallableStatement)this.delegate).setAsciiStream(paramInt, paramInputStream);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBinaryStream(int paramInt, InputStream paramInputStream) {
    try {
      ((CallableStatement)this.delegate).setBinaryStream(paramInt, paramInputStream);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setCharacterStream(int paramInt, Reader paramReader) {
    try {
      ((CallableStatement)this.delegate).setCharacterStream(paramInt, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNCharacterStream(int paramInt, Reader paramReader) {
    try {
      ((CallableStatement)this.delegate).setNCharacterStream(paramInt, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setClob(int paramInt, Reader paramReader) {
    try {
      ((CallableStatement)this.delegate).setClob(paramInt, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBlob(int paramInt, InputStream paramInputStream) {
    try {
      ((CallableStatement)this.delegate).setBlob(paramInt, paramInputStream);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNClob(int paramInt, Reader paramReader) {
    try {
      ((CallableStatement)this.delegate).setNClob(paramInt, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public ResultSet executeQuery(String paramString) {
    try {
      return super.executeQuery(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int executeUpdate(String paramString) {
    try {
      return super.executeUpdate(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getMaxFieldSize() {
    try {
      return ((CallableStatement)this.delegate).getMaxFieldSize();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setMaxFieldSize(int paramInt) {
    try {
      ((CallableStatement)this.delegate).setMaxFieldSize(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getMaxRows() {
    try {
      return ((CallableStatement)this.delegate).getMaxRows();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setMaxRows(int paramInt) {
    try {
      ((CallableStatement)this.delegate).setMaxRows(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setEscapeProcessing(boolean paramBoolean) {
    try {
      ((CallableStatement)this.delegate).setEscapeProcessing(paramBoolean);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getQueryTimeout() {
    try {
      return ((CallableStatement)this.delegate).getQueryTimeout();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setQueryTimeout(int paramInt) {
    try {
      ((CallableStatement)this.delegate).setQueryTimeout(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void cancel() {
    try {
      ((CallableStatement)this.delegate).cancel();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public SQLWarning getWarnings() {
    try {
      return ((CallableStatement)this.delegate).getWarnings();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void clearWarnings() {
    try {
      ((CallableStatement)this.delegate).clearWarnings();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setCursorName(String paramString) {
    try {
      ((CallableStatement)this.delegate).setCursorName(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean execute(String paramString) {
    try {
      return super.execute(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public ResultSet getResultSet() {
    try {
      return super.getResultSet();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getUpdateCount() {
    try {
      return ((CallableStatement)this.delegate).getUpdateCount();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean getMoreResults() {
    try {
      return ((CallableStatement)this.delegate).getMoreResults();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setFetchDirection(int paramInt) {
    try {
      ((CallableStatement)this.delegate).setFetchDirection(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getFetchDirection() {
    try {
      return ((CallableStatement)this.delegate).getFetchDirection();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setFetchSize(int paramInt) {
    try {
      ((CallableStatement)this.delegate).setFetchSize(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getFetchSize() {
    try {
      return ((CallableStatement)this.delegate).getFetchSize();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getResultSetConcurrency() {
    try {
      return ((CallableStatement)this.delegate).getResultSetConcurrency();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getResultSetType() {
    try {
      return ((CallableStatement)this.delegate).getResultSetType();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void addBatch(String paramString) {
    try {
      ((CallableStatement)this.delegate).addBatch(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void clearBatch() {
    try {
      ((CallableStatement)this.delegate).clearBatch();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int[] executeBatch() {
    try {
      return super.executeBatch();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Connection getConnection() {
    try {
      return super.getConnection();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean getMoreResults(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getMoreResults(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public ResultSet getGeneratedKeys() {
    try {
      return ((CallableStatement)this.delegate).getGeneratedKeys();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int executeUpdate(String paramString, int paramInt) {
    try {
      return super.executeUpdate(paramString, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int executeUpdate(String paramString, int[] paramArrayOfint) {
    try {
      return super.executeUpdate(paramString, paramArrayOfint);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int executeUpdate(String paramString, String[] paramArrayOfString) {
    try {
      return super.executeUpdate(paramString, paramArrayOfString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean execute(String paramString, int paramInt) {
    try {
      return super.execute(paramString, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean execute(String paramString, int[] paramArrayOfint) {
    try {
      return super.execute(paramString, paramArrayOfint);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean execute(String paramString, String[] paramArrayOfString) {
    try {
      return super.execute(paramString, paramArrayOfString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getResultSetHoldability() {
    try {
      return ((CallableStatement)this.delegate).getResultSetHoldability();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isClosed() {
    try {
      return ((CallableStatement)this.delegate).isClosed();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setPoolable(boolean paramBoolean) {
    try {
      ((CallableStatement)this.delegate).setPoolable(paramBoolean);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isPoolable() {
    try {
      return ((CallableStatement)this.delegate).isPoolable();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void closeOnCompletion() {
    try {
      ((CallableStatement)this.delegate).closeOnCompletion();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isCloseOnCompletion() {
    try {
      return ((CallableStatement)this.delegate).isCloseOnCompletion();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void registerOutParameter(int paramInt1, int paramInt2) {
    try {
      ((CallableStatement)this.delegate).registerOutParameter(paramInt1, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void registerOutParameter(int paramInt1, int paramInt2, int paramInt3) {
    try {
      ((CallableStatement)this.delegate).registerOutParameter(paramInt1, paramInt2, paramInt3);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean wasNull() {
    try {
      return ((CallableStatement)this.delegate).wasNull();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public String getString(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getString(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean getBoolean(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getBoolean(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public byte getByte(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getByte(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public short getShort(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getShort(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getInt(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getInt(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public long getLong(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getLong(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public float getFloat(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getFloat(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public double getDouble(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getDouble(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public BigDecimal getBigDecimal(int paramInt1, int paramInt2) {
    try {
      return ((CallableStatement)this.delegate).getBigDecimal(paramInt1, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public byte[] getBytes(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getBytes(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Date getDate(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getDate(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Time getTime(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getTime(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Timestamp getTimestamp(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getTimestamp(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Object getObject(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getObject(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public BigDecimal getBigDecimal(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getBigDecimal(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Object getObject(int paramInt, Map<String, Class<?>> paramMap) {
    try {
      return ((CallableStatement)this.delegate).getObject(paramInt, paramMap);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Ref getRef(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getRef(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Blob getBlob(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getBlob(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Clob getClob(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getClob(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Array getArray(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getArray(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Date getDate(int paramInt, Calendar paramCalendar) {
    try {
      return ((CallableStatement)this.delegate).getDate(paramInt, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Time getTime(int paramInt, Calendar paramCalendar) {
    try {
      return ((CallableStatement)this.delegate).getTime(paramInt, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Timestamp getTimestamp(int paramInt, Calendar paramCalendar) {
    try {
      return ((CallableStatement)this.delegate).getTimestamp(paramInt, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void registerOutParameter(int paramInt1, int paramInt2, String paramString) {
    try {
      ((CallableStatement)this.delegate).registerOutParameter(paramInt1, paramInt2, paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void registerOutParameter(String paramString, int paramInt) {
    try {
      ((CallableStatement)this.delegate).registerOutParameter(paramString, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void registerOutParameter(String paramString, int paramInt1, int paramInt2) {
    try {
      ((CallableStatement)this.delegate).registerOutParameter(paramString, paramInt1, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void registerOutParameter(String paramString1, int paramInt, String paramString2) {
    try {
      ((CallableStatement)this.delegate).registerOutParameter(paramString1, paramInt, paramString2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public URL getURL(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getURL(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setURL(String paramString, URL paramURL) {
    try {
      ((CallableStatement)this.delegate).setURL(paramString, paramURL);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNull(String paramString, int paramInt) {
    try {
      ((CallableStatement)this.delegate).setNull(paramString, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBoolean(String paramString, boolean paramBoolean) {
    try {
      ((CallableStatement)this.delegate).setBoolean(paramString, paramBoolean);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setByte(String paramString, byte paramByte) {
    try {
      ((CallableStatement)this.delegate).setByte(paramString, paramByte);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setShort(String paramString, short paramShort) {
    try {
      ((CallableStatement)this.delegate).setShort(paramString, paramShort);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setInt(String paramString, int paramInt) {
    try {
      ((CallableStatement)this.delegate).setInt(paramString, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setLong(String paramString, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setLong(paramString, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setFloat(String paramString, float paramFloat) {
    try {
      ((CallableStatement)this.delegate).setFloat(paramString, paramFloat);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setDouble(String paramString, double paramDouble) {
    try {
      ((CallableStatement)this.delegate).setDouble(paramString, paramDouble);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBigDecimal(String paramString, BigDecimal paramBigDecimal) {
    try {
      ((CallableStatement)this.delegate).setBigDecimal(paramString, paramBigDecimal);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setString(String paramString1, String paramString2) {
    try {
      ((CallableStatement)this.delegate).setString(paramString1, paramString2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBytes(String paramString, byte[] paramArrayOfbyte) {
    try {
      ((CallableStatement)this.delegate).setBytes(paramString, paramArrayOfbyte);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setDate(String paramString, Date paramDate) {
    try {
      ((CallableStatement)this.delegate).setDate(paramString, paramDate);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setTime(String paramString, Time paramTime) {
    try {
      ((CallableStatement)this.delegate).setTime(paramString, paramTime);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setTimestamp(String paramString, Timestamp paramTimestamp) {
    try {
      ((CallableStatement)this.delegate).setTimestamp(paramString, paramTimestamp);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setAsciiStream(String paramString, InputStream paramInputStream, int paramInt) {
    try {
      ((CallableStatement)this.delegate).setAsciiStream(paramString, paramInputStream, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBinaryStream(String paramString, InputStream paramInputStream, int paramInt) {
    try {
      ((CallableStatement)this.delegate).setBinaryStream(paramString, paramInputStream, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setObject(String paramString, Object paramObject, int paramInt1, int paramInt2) {
    try {
      ((CallableStatement)this.delegate).setObject(paramString, paramObject, paramInt1, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setObject(String paramString, Object paramObject, int paramInt) {
    try {
      ((CallableStatement)this.delegate).setObject(paramString, paramObject, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setObject(String paramString, Object paramObject) {
    try {
      ((CallableStatement)this.delegate).setObject(paramString, paramObject);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setCharacterStream(String paramString, Reader paramReader, int paramInt) {
    try {
      ((CallableStatement)this.delegate).setCharacterStream(paramString, paramReader, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setDate(String paramString, Date paramDate, Calendar paramCalendar) {
    try {
      ((CallableStatement)this.delegate).setDate(paramString, paramDate, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setTime(String paramString, Time paramTime, Calendar paramCalendar) {
    try {
      ((CallableStatement)this.delegate).setTime(paramString, paramTime, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setTimestamp(String paramString, Timestamp paramTimestamp, Calendar paramCalendar) {
    try {
      ((CallableStatement)this.delegate).setTimestamp(paramString, paramTimestamp, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNull(String paramString1, int paramInt, String paramString2) {
    try {
      ((CallableStatement)this.delegate).setNull(paramString1, paramInt, paramString2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public String getString(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getString(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean getBoolean(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getBoolean(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public byte getByte(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getByte(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public short getShort(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getShort(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getInt(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getInt(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public long getLong(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getLong(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public float getFloat(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getFloat(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public double getDouble(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getDouble(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public byte[] getBytes(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getBytes(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Date getDate(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getDate(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Time getTime(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getTime(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Timestamp getTimestamp(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getTimestamp(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Object getObject(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getObject(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public BigDecimal getBigDecimal(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getBigDecimal(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Object getObject(String paramString, Map<String, Class<?>> paramMap) {
    try {
      return ((CallableStatement)this.delegate).getObject(paramString, paramMap);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Ref getRef(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getRef(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Blob getBlob(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getBlob(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Clob getClob(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getClob(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Array getArray(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getArray(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Date getDate(String paramString, Calendar paramCalendar) {
    try {
      return ((CallableStatement)this.delegate).getDate(paramString, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Time getTime(String paramString, Calendar paramCalendar) {
    try {
      return ((CallableStatement)this.delegate).getTime(paramString, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Timestamp getTimestamp(String paramString, Calendar paramCalendar) {
    try {
      return ((CallableStatement)this.delegate).getTimestamp(paramString, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public URL getURL(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getURL(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public RowId getRowId(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getRowId(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public RowId getRowId(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getRowId(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setRowId(String paramString, RowId paramRowId) {
    try {
      ((CallableStatement)this.delegate).setRowId(paramString, paramRowId);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNString(String paramString1, String paramString2) {
    try {
      ((CallableStatement)this.delegate).setNString(paramString1, paramString2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNCharacterStream(String paramString, Reader paramReader, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setNCharacterStream(paramString, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNClob(String paramString, NClob paramNClob) {
    try {
      ((CallableStatement)this.delegate).setNClob(paramString, paramNClob);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setClob(String paramString, Reader paramReader, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setClob(paramString, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBlob(String paramString, InputStream paramInputStream, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setBlob(paramString, paramInputStream, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNClob(String paramString, Reader paramReader, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setNClob(paramString, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public NClob getNClob(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getNClob(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public NClob getNClob(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getNClob(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setSQLXML(String paramString, SQLXML paramSQLXML) {
    try {
      ((CallableStatement)this.delegate).setSQLXML(paramString, paramSQLXML);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public SQLXML getSQLXML(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getSQLXML(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public SQLXML getSQLXML(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getSQLXML(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public String getNString(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getNString(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public String getNString(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getNString(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Reader getNCharacterStream(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getNCharacterStream(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Reader getNCharacterStream(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getNCharacterStream(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Reader getCharacterStream(int paramInt) {
    try {
      return ((CallableStatement)this.delegate).getCharacterStream(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Reader getCharacterStream(String paramString) {
    try {
      return ((CallableStatement)this.delegate).getCharacterStream(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBlob(String paramString, Blob paramBlob) {
    try {
      ((CallableStatement)this.delegate).setBlob(paramString, paramBlob);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setClob(String paramString, Clob paramClob) {
    try {
      ((CallableStatement)this.delegate).setClob(paramString, paramClob);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setAsciiStream(String paramString, InputStream paramInputStream, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setAsciiStream(paramString, paramInputStream, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBinaryStream(String paramString, InputStream paramInputStream, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setBinaryStream(paramString, paramInputStream, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setCharacterStream(String paramString, Reader paramReader, long paramLong) {
    try {
      ((CallableStatement)this.delegate).setCharacterStream(paramString, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setAsciiStream(String paramString, InputStream paramInputStream) {
    try {
      ((CallableStatement)this.delegate).setAsciiStream(paramString, paramInputStream);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBinaryStream(String paramString, InputStream paramInputStream) {
    try {
      ((CallableStatement)this.delegate).setBinaryStream(paramString, paramInputStream);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setCharacterStream(String paramString, Reader paramReader) {
    try {
      ((CallableStatement)this.delegate).setCharacterStream(paramString, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNCharacterStream(String paramString, Reader paramReader) {
    try {
      ((CallableStatement)this.delegate).setNCharacterStream(paramString, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setClob(String paramString, Reader paramReader) {
    try {
      ((CallableStatement)this.delegate).setClob(paramString, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBlob(String paramString, InputStream paramInputStream) {
    try {
      ((CallableStatement)this.delegate).setBlob(paramString, paramInputStream);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNClob(String paramString, Reader paramReader) {
    try {
      ((CallableStatement)this.delegate).setNClob(paramString, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Object getObject(int paramInt, Class<?> paramClass) {
    try {
      return ((CallableStatement)this.delegate).getObject(paramInt, paramClass);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Object getObject(String paramString, Class<?> paramClass) {
    try {
      return ((CallableStatement)this.delegate).getObject(paramString, paramClass);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isWrapperFor(Class<?> paramClass) {
    try {
      return ((CallableStatement)this.delegate).isWrapperFor(paramClass);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  protected HikariProxyCallableStatement(ProxyConnection paramProxyConnection, CallableStatement paramCallableStatement) {
    super(paramProxyConnection, paramCallableStatement);
  }
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/pool/HikariProxyCallableStatement.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */