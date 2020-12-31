package me.TechsCode.UltraPermissions.dependencies.hikari.pool;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
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

public class HikariProxyPreparedStatement extends ProxyPreparedStatement implements PreparedStatement, Statement, Wrapper, AutoCloseable {
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
      ((PreparedStatement)this.delegate).setNull(paramInt1, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBoolean(int paramInt, boolean paramBoolean) {
    try {
      ((PreparedStatement)this.delegate).setBoolean(paramInt, paramBoolean);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setByte(int paramInt, byte paramByte) {
    try {
      ((PreparedStatement)this.delegate).setByte(paramInt, paramByte);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setShort(int paramInt, short paramShort) {
    try {
      ((PreparedStatement)this.delegate).setShort(paramInt, paramShort);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setInt(int paramInt1, int paramInt2) {
    try {
      ((PreparedStatement)this.delegate).setInt(paramInt1, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setLong(int paramInt, long paramLong) {
    try {
      ((PreparedStatement)this.delegate).setLong(paramInt, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setFloat(int paramInt, float paramFloat) {
    try {
      ((PreparedStatement)this.delegate).setFloat(paramInt, paramFloat);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setDouble(int paramInt, double paramDouble) {
    try {
      ((PreparedStatement)this.delegate).setDouble(paramInt, paramDouble);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBigDecimal(int paramInt, BigDecimal paramBigDecimal) {
    try {
      ((PreparedStatement)this.delegate).setBigDecimal(paramInt, paramBigDecimal);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setString(int paramInt, String paramString) {
    try {
      ((PreparedStatement)this.delegate).setString(paramInt, paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBytes(int paramInt, byte[] paramArrayOfbyte) {
    try {
      ((PreparedStatement)this.delegate).setBytes(paramInt, paramArrayOfbyte);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setDate(int paramInt, Date paramDate) {
    try {
      ((PreparedStatement)this.delegate).setDate(paramInt, paramDate);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setTime(int paramInt, Time paramTime) {
    try {
      ((PreparedStatement)this.delegate).setTime(paramInt, paramTime);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setTimestamp(int paramInt, Timestamp paramTimestamp) {
    try {
      ((PreparedStatement)this.delegate).setTimestamp(paramInt, paramTimestamp);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setAsciiStream(int paramInt1, InputStream paramInputStream, int paramInt2) {
    try {
      ((PreparedStatement)this.delegate).setAsciiStream(paramInt1, paramInputStream, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setUnicodeStream(int paramInt1, InputStream paramInputStream, int paramInt2) {
    try {
      ((PreparedStatement)this.delegate).setUnicodeStream(paramInt1, paramInputStream, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBinaryStream(int paramInt1, InputStream paramInputStream, int paramInt2) {
    try {
      ((PreparedStatement)this.delegate).setBinaryStream(paramInt1, paramInputStream, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void clearParameters() {
    try {
      ((PreparedStatement)this.delegate).clearParameters();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setObject(int paramInt1, Object paramObject, int paramInt2) {
    try {
      ((PreparedStatement)this.delegate).setObject(paramInt1, paramObject, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setObject(int paramInt, Object paramObject) {
    try {
      ((PreparedStatement)this.delegate).setObject(paramInt, paramObject);
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
      ((PreparedStatement)this.delegate).addBatch();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setCharacterStream(int paramInt1, Reader paramReader, int paramInt2) {
    try {
      ((PreparedStatement)this.delegate).setCharacterStream(paramInt1, paramReader, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setRef(int paramInt, Ref paramRef) {
    try {
      ((PreparedStatement)this.delegate).setRef(paramInt, paramRef);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBlob(int paramInt, Blob paramBlob) {
    try {
      ((PreparedStatement)this.delegate).setBlob(paramInt, paramBlob);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setClob(int paramInt, Clob paramClob) {
    try {
      ((PreparedStatement)this.delegate).setClob(paramInt, paramClob);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setArray(int paramInt, Array paramArray) {
    try {
      ((PreparedStatement)this.delegate).setArray(paramInt, paramArray);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public ResultSetMetaData getMetaData() {
    try {
      return ((PreparedStatement)this.delegate).getMetaData();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setDate(int paramInt, Date paramDate, Calendar paramCalendar) {
    try {
      ((PreparedStatement)this.delegate).setDate(paramInt, paramDate, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setTime(int paramInt, Time paramTime, Calendar paramCalendar) {
    try {
      ((PreparedStatement)this.delegate).setTime(paramInt, paramTime, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setTimestamp(int paramInt, Timestamp paramTimestamp, Calendar paramCalendar) {
    try {
      ((PreparedStatement)this.delegate).setTimestamp(paramInt, paramTimestamp, paramCalendar);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNull(int paramInt1, int paramInt2, String paramString) {
    try {
      ((PreparedStatement)this.delegate).setNull(paramInt1, paramInt2, paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setURL(int paramInt, URL paramURL) {
    try {
      ((PreparedStatement)this.delegate).setURL(paramInt, paramURL);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public ParameterMetaData getParameterMetaData() {
    try {
      return ((PreparedStatement)this.delegate).getParameterMetaData();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setRowId(int paramInt, RowId paramRowId) {
    try {
      ((PreparedStatement)this.delegate).setRowId(paramInt, paramRowId);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNString(int paramInt, String paramString) {
    try {
      ((PreparedStatement)this.delegate).setNString(paramInt, paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNCharacterStream(int paramInt, Reader paramReader, long paramLong) {
    try {
      ((PreparedStatement)this.delegate).setNCharacterStream(paramInt, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNClob(int paramInt, NClob paramNClob) {
    try {
      ((PreparedStatement)this.delegate).setNClob(paramInt, paramNClob);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setClob(int paramInt, Reader paramReader, long paramLong) {
    try {
      ((PreparedStatement)this.delegate).setClob(paramInt, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBlob(int paramInt, InputStream paramInputStream, long paramLong) {
    try {
      ((PreparedStatement)this.delegate).setBlob(paramInt, paramInputStream, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNClob(int paramInt, Reader paramReader, long paramLong) {
    try {
      ((PreparedStatement)this.delegate).setNClob(paramInt, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setSQLXML(int paramInt, SQLXML paramSQLXML) {
    try {
      ((PreparedStatement)this.delegate).setSQLXML(paramInt, paramSQLXML);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setObject(int paramInt1, Object paramObject, int paramInt2, int paramInt3) {
    try {
      ((PreparedStatement)this.delegate).setObject(paramInt1, paramObject, paramInt2, paramInt3);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setAsciiStream(int paramInt, InputStream paramInputStream, long paramLong) {
    try {
      ((PreparedStatement)this.delegate).setAsciiStream(paramInt, paramInputStream, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBinaryStream(int paramInt, InputStream paramInputStream, long paramLong) {
    try {
      ((PreparedStatement)this.delegate).setBinaryStream(paramInt, paramInputStream, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setCharacterStream(int paramInt, Reader paramReader, long paramLong) {
    try {
      ((PreparedStatement)this.delegate).setCharacterStream(paramInt, paramReader, paramLong);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setAsciiStream(int paramInt, InputStream paramInputStream) {
    try {
      ((PreparedStatement)this.delegate).setAsciiStream(paramInt, paramInputStream);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBinaryStream(int paramInt, InputStream paramInputStream) {
    try {
      ((PreparedStatement)this.delegate).setBinaryStream(paramInt, paramInputStream);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setCharacterStream(int paramInt, Reader paramReader) {
    try {
      ((PreparedStatement)this.delegate).setCharacterStream(paramInt, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNCharacterStream(int paramInt, Reader paramReader) {
    try {
      ((PreparedStatement)this.delegate).setNCharacterStream(paramInt, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setClob(int paramInt, Reader paramReader) {
    try {
      ((PreparedStatement)this.delegate).setClob(paramInt, paramReader);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setBlob(int paramInt, InputStream paramInputStream) {
    try {
      ((PreparedStatement)this.delegate).setBlob(paramInt, paramInputStream);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNClob(int paramInt, Reader paramReader) {
    try {
      ((PreparedStatement)this.delegate).setNClob(paramInt, paramReader);
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
      return ((PreparedStatement)this.delegate).getMaxFieldSize();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setMaxFieldSize(int paramInt) {
    try {
      ((PreparedStatement)this.delegate).setMaxFieldSize(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getMaxRows() {
    try {
      return ((PreparedStatement)this.delegate).getMaxRows();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setMaxRows(int paramInt) {
    try {
      ((PreparedStatement)this.delegate).setMaxRows(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setEscapeProcessing(boolean paramBoolean) {
    try {
      ((PreparedStatement)this.delegate).setEscapeProcessing(paramBoolean);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getQueryTimeout() {
    try {
      return ((PreparedStatement)this.delegate).getQueryTimeout();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setQueryTimeout(int paramInt) {
    try {
      ((PreparedStatement)this.delegate).setQueryTimeout(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void cancel() {
    try {
      ((PreparedStatement)this.delegate).cancel();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public SQLWarning getWarnings() {
    try {
      return ((PreparedStatement)this.delegate).getWarnings();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void clearWarnings() {
    try {
      ((PreparedStatement)this.delegate).clearWarnings();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setCursorName(String paramString) {
    try {
      ((PreparedStatement)this.delegate).setCursorName(paramString);
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
      return ((PreparedStatement)this.delegate).getUpdateCount();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean getMoreResults() {
    try {
      return ((PreparedStatement)this.delegate).getMoreResults();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setFetchDirection(int paramInt) {
    try {
      ((PreparedStatement)this.delegate).setFetchDirection(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getFetchDirection() {
    try {
      return ((PreparedStatement)this.delegate).getFetchDirection();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setFetchSize(int paramInt) {
    try {
      ((PreparedStatement)this.delegate).setFetchSize(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getFetchSize() {
    try {
      return ((PreparedStatement)this.delegate).getFetchSize();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getResultSetConcurrency() {
    try {
      return ((PreparedStatement)this.delegate).getResultSetConcurrency();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getResultSetType() {
    try {
      return ((PreparedStatement)this.delegate).getResultSetType();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void addBatch(String paramString) {
    try {
      ((PreparedStatement)this.delegate).addBatch(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void clearBatch() {
    try {
      ((PreparedStatement)this.delegate).clearBatch();
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
      return ((PreparedStatement)this.delegate).getMoreResults(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public ResultSet getGeneratedKeys() {
    try {
      return ((PreparedStatement)this.delegate).getGeneratedKeys();
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
      return ((PreparedStatement)this.delegate).getResultSetHoldability();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isClosed() {
    try {
      return ((PreparedStatement)this.delegate).isClosed();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setPoolable(boolean paramBoolean) {
    try {
      ((PreparedStatement)this.delegate).setPoolable(paramBoolean);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isPoolable() {
    try {
      return ((PreparedStatement)this.delegate).isPoolable();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void closeOnCompletion() {
    try {
      ((PreparedStatement)this.delegate).closeOnCompletion();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isCloseOnCompletion() {
    try {
      return ((PreparedStatement)this.delegate).isCloseOnCompletion();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isWrapperFor(Class<?> paramClass) {
    try {
      return ((PreparedStatement)this.delegate).isWrapperFor(paramClass);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  protected HikariProxyPreparedStatement(ProxyConnection paramProxyConnection, PreparedStatement paramPreparedStatement) {
    super(paramProxyConnection, paramPreparedStatement);
  }
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/pool/HikariProxyPreparedStatement.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */