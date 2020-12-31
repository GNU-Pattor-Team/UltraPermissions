package me.TechsCode.UltraPermissions.dependencies.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public interface Nestable {
  Throwable getCause();
  
  String getMessage();
  
  String getMessage(int paramInt);
  
  String[] getMessages();
  
  Throwable getThrowable(int paramInt);
  
  int getThrowableCount();
  
  Throwable[] getThrowables();
  
  int indexOfThrowable(Class paramClass);
  
  int indexOfThrowable(Class paramClass, int paramInt);
  
  void printStackTrace(PrintWriter paramPrintWriter);
  
  void printStackTrace(PrintStream paramPrintStream);
  
  void printPartialStackTrace(PrintWriter paramPrintWriter);
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/exception/Nestable.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */