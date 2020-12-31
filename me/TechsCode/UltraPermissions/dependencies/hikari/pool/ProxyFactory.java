package me.TechsCode.UltraPermissions.dependencies.hikari.pool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import me.TechsCode.UltraPermissions.dependencies.hikari.util.FastList;

public final class ProxyFactory {
  static ProxyConnection getProxyConnection(PoolEntry paramPoolEntry, Connection paramConnection, FastList<Statement> paramFastList, ProxyLeakTask paramProxyLeakTask, long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
    return new HikariProxyConnection(paramPoolEntry, paramConnection, paramFastList, paramProxyLeakTask, paramLong, paramBoolean1, paramBoolean2);
  }
  
  static Statement getProxyStatement(ProxyConnection paramProxyConnection, Statement paramStatement) {
    return new HikariProxyStatement(paramProxyConnection, paramStatement);
  }
  
  static CallableStatement getProxyCallableStatement(ProxyConnection paramProxyConnection, CallableStatement paramCallableStatement) {
    return new HikariProxyCallableStatement(paramProxyConnection, paramCallableStatement);
  }
  
  static PreparedStatement getProxyPreparedStatement(ProxyConnection paramProxyConnection, PreparedStatement paramPreparedStatement) {
    return new HikariProxyPreparedStatement(paramProxyConnection, paramPreparedStatement);
  }
  
  static ResultSet getProxyResultSet(ProxyConnection paramProxyConnection, ProxyStatement paramProxyStatement, ResultSet paramResultSet) {
    return new HikariProxyResultSet(paramProxyConnection, paramProxyStatement, paramResultSet);
  }
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/pool/ProxyFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */