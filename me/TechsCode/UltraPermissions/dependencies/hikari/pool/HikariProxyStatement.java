package me.TechsCode.UltraPermissions.dependencies.hikari.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Wrapper;

public class HikariProxyStatement extends ProxyStatement implements Statement, Wrapper, AutoCloseable {
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
      return this.delegate.getMaxFieldSize();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setMaxFieldSize(int paramInt) {
    try {
      this.delegate.setMaxFieldSize(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getMaxRows() {
    try {
      return this.delegate.getMaxRows();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setMaxRows(int paramInt) {
    try {
      this.delegate.setMaxRows(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setEscapeProcessing(boolean paramBoolean) {
    try {
      this.delegate.setEscapeProcessing(paramBoolean);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getQueryTimeout() {
    try {
      return this.delegate.getQueryTimeout();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void setQueryTimeout(int paramInt) {
    try {
      this.delegate.setQueryTimeout(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void cancel() {
    try {
      this.delegate.cancel();
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
  
  public void setCursorName(String paramString) {
    try {
      this.delegate.setCursorName(paramString);
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
      return this.delegate.getUpdateCount();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean getMoreResults() {
    try {
      return this.delegate.getMoreResults();
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
  
  public int getResultSetConcurrency() {
    try {
      return this.delegate.getResultSetConcurrency();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public int getResultSetType() {
    try {
      return this.delegate.getResultSetType();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void addBatch(String paramString) {
    try {
      this.delegate.addBatch(paramString);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void clearBatch() {
    try {
      this.delegate.clearBatch();
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
      return this.delegate.getMoreResults(paramInt);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public ResultSet getGeneratedKeys() {
    try {
      return this.delegate.getGeneratedKeys();
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
      return this.delegate.getResultSetHoldability();
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
  
  public void setPoolable(boolean paramBoolean) {
    try {
      this.delegate.setPoolable(paramBoolean);
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isPoolable() {
    try {
      return this.delegate.isPoolable();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public void closeOnCompletion() {
    try {
      this.delegate.closeOnCompletion();
    } catch (SQLException sQLException) {
      throw checkException(sQLException);
    } 
  }
  
  public boolean isCloseOnCompletion() {
    try {
      return this.delegate.isCloseOnCompletion();
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
  
  protected HikariProxyStatement(ProxyConnection paramProxyConnection, Statement paramStatement) {
    super(paramProxyConnection, paramStatement);
  }
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/pool/HikariProxyStatement.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */