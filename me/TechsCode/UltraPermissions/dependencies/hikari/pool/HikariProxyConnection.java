package me.TechsCode.UltraPermissions.dependencies.hikari.pool;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Wrapper;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import me.TechsCode.UltraPermissions.dependencies.hikari.util.FastList;

public class HikariProxyConnection extends ProxyConnection implements Wrapper, Connection, AutoCloseable {
  public Statement createStatement() {
    try {
      return super.createStatement();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public PreparedStatement prepareStatement(String paramString) {
    try {
      return super.prepareStatement(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public CallableStatement prepareCall(String paramString) {
    try {
      return super.prepareCall(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public String nativeSQL(String paramString) {
    try {
      return this.delegate.nativeSQL(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setAutoCommit(boolean paramBoolean) {
    try {
      super.setAutoCommit(paramBoolean);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean getAutoCommit() {
    try {
      return this.delegate.getAutoCommit();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void commit() {
    try {
      super.commit();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void rollback() {
    try {
      super.rollback();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isClosed() {
    try {
      return super.isClosed();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public DatabaseMetaData getMetaData() {
    try {
      return this.delegate.getMetaData();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setReadOnly(boolean paramBoolean) {
    try {
      super.setReadOnly(paramBoolean);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isReadOnly() {
    try {
      return this.delegate.isReadOnly();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setCatalog(String paramString) {
    try {
      super.setCatalog(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public String getCatalog() {
    try {
      return this.delegate.getCatalog();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setTransactionIsolation(int paramInt) {
    try {
      super.setTransactionIsolation(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getTransactionIsolation() {
    try {
      return this.delegate.getTransactionIsolation();
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
  
  public Statement createStatement(int paramInt1, int paramInt2) {
    try {
      return super.createStatement(paramInt1, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public PreparedStatement prepareStatement(String paramString, int paramInt1, int paramInt2) {
    try {
      return super.prepareStatement(paramString, paramInt1, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public CallableStatement prepareCall(String paramString, int paramInt1, int paramInt2) {
    try {
      return super.prepareCall(paramString, paramInt1, paramInt2);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Map getTypeMap() {
    try {
      return this.delegate.getTypeMap();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setTypeMap(Map<String, Class<?>> paramMap) {
    try {
      this.delegate.setTypeMap(paramMap);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setHoldability(int paramInt) {
    try {
      this.delegate.setHoldability(paramInt);
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
  
  public Savepoint setSavepoint() {
    try {
      return this.delegate.setSavepoint();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Savepoint setSavepoint(String paramString) {
    try {
      return this.delegate.setSavepoint(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void rollback(Savepoint paramSavepoint) {
    try {
      super.rollback(paramSavepoint);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void releaseSavepoint(Savepoint paramSavepoint) {
    try {
      this.delegate.releaseSavepoint(paramSavepoint);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Statement createStatement(int paramInt1, int paramInt2, int paramInt3) {
    try {
      return super.createStatement(paramInt1, paramInt2, paramInt3);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public PreparedStatement prepareStatement(String paramString, int paramInt1, int paramInt2, int paramInt3) {
    try {
      return super.prepareStatement(paramString, paramInt1, paramInt2, paramInt3);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public CallableStatement prepareCall(String paramString, int paramInt1, int paramInt2, int paramInt3) {
    try {
      return super.prepareCall(paramString, paramInt1, paramInt2, paramInt3);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public PreparedStatement prepareStatement(String paramString, int paramInt) {
    try {
      return super.prepareStatement(paramString, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public PreparedStatement prepareStatement(String paramString, int[] paramArrayOfint) {
    try {
      return super.prepareStatement(paramString, paramArrayOfint);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public PreparedStatement prepareStatement(String paramString, String[] paramArrayOfString) {
    try {
      return super.prepareStatement(paramString, paramArrayOfString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Clob createClob() {
    try {
      return this.delegate.createClob();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Blob createBlob() {
    try {
      return this.delegate.createBlob();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public NClob createNClob() {
    try {
      return this.delegate.createNClob();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public SQLXML createSQLXML() {
    try {
      return this.delegate.createSQLXML();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isValid(int paramInt) {
    try {
      return this.delegate.isValid(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setClientInfo(String paramString1, String paramString2) {
    this.delegate.setClientInfo(paramString1, paramString2);
  }
  
  public void setClientInfo(Properties paramProperties) {
    this.delegate.setClientInfo(paramProperties);
  }
  
  public String getClientInfo(String paramString) {
    try {
      return this.delegate.getClientInfo(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Properties getClientInfo() {
    try {
      return this.delegate.getClientInfo();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Array createArrayOf(String paramString, Object[] paramArrayOfObject) {
    try {
      return this.delegate.createArrayOf(paramString, paramArrayOfObject);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public Struct createStruct(String paramString, Object[] paramArrayOfObject) {
    try {
      return this.delegate.createStruct(paramString, paramArrayOfObject);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setSchema(String paramString) {
    try {
      this.delegate.setSchema(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public String getSchema() {
    try {
      return this.delegate.getSchema();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void abort(Executor paramExecutor) {
    try {
      this.delegate.abort(paramExecutor);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setNetworkTimeout(Executor paramExecutor, int paramInt) {
    try {
      super.setNetworkTimeout(paramExecutor, paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getNetworkTimeout() {
    try {
      return this.delegate.getNetworkTimeout();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  protected HikariProxyConnection(PoolEntry paramPoolEntry, Connection paramConnection, FastList<Statement> paramFastList, ProxyLeakTask paramProxyLeakTask, long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
    super(paramPoolEntry, paramConnection, paramFastList, paramProxyLeakTask, paramLong, paramBoolean1, paramBoolean2);
  }
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/pool/HikariProxyConnection.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */