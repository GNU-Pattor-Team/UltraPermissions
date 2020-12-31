/*     */ package me.TechsCode.UltraPermissions.dependencies.slf4j;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Enumeration;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.ServiceLoader;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.event.LoggingEvent;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.event.SubstituteLoggingEvent;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.helpers.NOPServiceProvider;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.helpers.SubstituteLogger;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.helpers.SubstituteServiceProvider;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.helpers.Util;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.spi.SLF4JServiceProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class LoggerFactory
/*     */ {
/*     */   static final String CODES_PREFIX = "http://www.slf4j.org/codes.html";
/*     */   static final String NO_PROVIDERS_URL = "http://www.slf4j.org/codes.html#noProviders";
/*     */   static final String IGNORED_BINDINGS_URL = "http://www.slf4j.org/codes.html#ignoredBindings";
/*     */   static final String NO_STATICLOGGERBINDER_URL = "http://www.slf4j.org/codes.html#StaticLoggerBinder";
/*     */   static final String MULTIPLE_BINDINGS_URL = "http://www.slf4j.org/codes.html#multiple_bindings";
/*     */   static final String NULL_LF_URL = "http://www.slf4j.org/codes.html#null_LF";
/*     */   static final String VERSION_MISMATCH = "http://www.slf4j.org/codes.html#version_mismatch";
/*     */   static final String SUBSTITUTE_LOGGER_URL = "http://www.slf4j.org/codes.html#substituteLogger";
/*     */   static final String LOGGER_NAME_MISMATCH_URL = "http://www.slf4j.org/codes.html#loggerNameMismatch";
/*     */   static final String REPLAY_URL = "http://www.slf4j.org/codes.html#replay";
/*     */   static final String UNSUCCESSFUL_INIT_URL = "http://www.slf4j.org/codes.html#unsuccessfulInit";
/*     */   static final String UNSUCCESSFUL_INIT_MSG = "org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit";
/*     */   static final int UNINITIALIZED = 0;
/*     */   static final int ONGOING_INITIALIZATION = 1;
/*     */   static final int FAILED_INITIALIZATION = 2;
/*     */   static final int SUCCESSFUL_INITIALIZATION = 3;
/*     */   static final int NOP_FALLBACK_INITIALIZATION = 4;
/*  89 */   static volatile int INITIALIZATION_STATE = 0;
/*  90 */   static final SubstituteServiceProvider SUBST_PROVIDER = new SubstituteServiceProvider();
/*  91 */   static final NOPServiceProvider NOP_FALLBACK_FACTORY = new NOPServiceProvider();
/*     */   
/*     */   static final String DETECT_LOGGER_NAME_MISMATCH_PROPERTY = "slf4j.detectLoggerNameMismatch";
/*     */   
/*     */   static final String JAVA_VENDOR_PROPERTY = "java.vendor.url";
/*     */   
/*  97 */   static boolean DETECT_LOGGER_NAME_MISMATCH = Util.safeGetBooleanSystemProperty("slf4j.detectLoggerNameMismatch");
/*     */   
/*     */   static volatile SLF4JServiceProvider PROVIDER;
/*     */   
/*     */   private static List<SLF4JServiceProvider> findServiceProviders() {
/* 102 */     ServiceLoader<SLF4JServiceProvider> serviceLoader = ServiceLoader.load(SLF4JServiceProvider.class);
/* 103 */     ArrayList<SLF4JServiceProvider> arrayList = new ArrayList();
/* 104 */     for (SLF4JServiceProvider sLF4JServiceProvider : serviceLoader) {
/* 105 */       arrayList.add(sLF4JServiceProvider);
/*     */     }
/* 107 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 117 */   private static final String[] API_COMPATIBILITY_LIST = new String[] { "1.8", "1.7" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void reset() {
/* 135 */     INITIALIZATION_STATE = 0;
/*     */   }
/*     */   
/*     */   private static final void performInitialization() {
/* 139 */     bind();
/* 140 */     if (INITIALIZATION_STATE == 3) {
/* 141 */       versionSanityCheck();
/*     */     }
/*     */   }
/*     */   
/*     */   private static final void bind() {
/*     */     try {
/* 147 */       List<SLF4JServiceProvider> list = findServiceProviders();
/* 148 */       reportMultipleBindingAmbiguity(list);
/* 149 */       if (list != null && !list.isEmpty()) {
/* 150 */         PROVIDER = list.get(0);
/*     */         
/* 152 */         PROVIDER.initialize();
/* 153 */         INITIALIZATION_STATE = 3;
/* 154 */         reportActualBinding(list);
/* 155 */         fixSubstituteLoggers();
/* 156 */         replayEvents();
/*     */         
/* 158 */         SUBST_PROVIDER.getSubstituteLoggerFactory().clear();
/*     */       } else {
/* 160 */         INITIALIZATION_STATE = 4;
/* 161 */         Util.report("No SLF4J providers were found.");
/* 162 */         Util.report("Defaulting to no-operation (NOP) logger implementation");
/* 163 */         Util.report("See http://www.slf4j.org/codes.html#noProviders for further details.");
/*     */         
/* 165 */         Set<URL> set = findPossibleStaticLoggerBinderPathSet();
/* 166 */         reportIgnoredStaticLoggerBinders(set);
/*     */       } 
/* 168 */     } catch (Exception exception) {
/* 169 */       failedBinding(exception);
/* 170 */       throw new IllegalStateException("Unexpected initialization failure", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void reportIgnoredStaticLoggerBinders(Set<URL> paramSet) {
/* 175 */     if (paramSet.isEmpty()) {
/*     */       return;
/*     */     }
/* 178 */     Util.report("Class path contains SLF4J bindings targeting slf4j-api versions prior to 1.8.");
/* 179 */     for (URL uRL : paramSet) {
/* 180 */       Util.report("Ignoring binding found at [" + uRL + "]");
/*     */     }
/* 182 */     Util.report("See http://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 189 */   private static String STATIC_LOGGER_BINDER_PATH = "me/TechsCode/UltraPermissions/dependencies/slf4j/impl/StaticLoggerBinder.class";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Set<URL> findPossibleStaticLoggerBinderPathSet() {
/* 195 */     LinkedHashSet<URL> linkedHashSet = new LinkedHashSet(); try {
/*     */       Enumeration<URL> enumeration;
/* 197 */       ClassLoader classLoader = LoggerFactory.class.getClassLoader();
/*     */       
/* 199 */       if (classLoader == null) {
/* 200 */         enumeration = ClassLoader.getSystemResources(STATIC_LOGGER_BINDER_PATH);
/*     */       } else {
/* 202 */         enumeration = classLoader.getResources(STATIC_LOGGER_BINDER_PATH);
/*     */       } 
/* 204 */       while (enumeration.hasMoreElements()) {
/* 205 */         URL uRL = enumeration.nextElement();
/* 206 */         linkedHashSet.add(uRL);
/*     */       } 
/* 208 */     } catch (IOException iOException) {
/* 209 */       Util.report("Error getting resources from path", iOException);
/*     */     } 
/* 211 */     return linkedHashSet;
/*     */   }
/*     */   
/*     */   private static void fixSubstituteLoggers() {
/* 215 */     synchronized (SUBST_PROVIDER) {
/* 216 */       SUBST_PROVIDER.getSubstituteLoggerFactory().postInitialization();
/* 217 */       for (SubstituteLogger substituteLogger : SUBST_PROVIDER.getSubstituteLoggerFactory().getLoggers()) {
/* 218 */         Logger logger = getLogger(substituteLogger.getName());
/* 219 */         substituteLogger.setDelegate(logger);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void failedBinding(Throwable paramThrowable) {
/* 226 */     INITIALIZATION_STATE = 2;
/* 227 */     Util.report("Failed to instantiate SLF4J LoggerFactory", paramThrowable);
/*     */   }
/*     */   
/*     */   private static void replayEvents() {
/* 231 */     LinkedBlockingQueue linkedBlockingQueue = SUBST_PROVIDER.getSubstituteLoggerFactory().getEventQueue();
/* 232 */     int i = linkedBlockingQueue.size();
/* 233 */     byte b = 0;
/* 234 */     char c = '';
/* 235 */     ArrayList arrayList = new ArrayList(128);
/*     */     while (true) {
/* 237 */       int j = linkedBlockingQueue.drainTo(arrayList, 128);
/* 238 */       if (j == 0)
/*     */         break; 
/* 240 */       for (SubstituteLoggingEvent substituteLoggingEvent : arrayList) {
/* 241 */         replaySingleEvent(substituteLoggingEvent);
/* 242 */         if (b++ == 0)
/* 243 */           emitReplayOrSubstituionWarning(substituteLoggingEvent, i); 
/*     */       } 
/* 245 */       arrayList.clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void emitReplayOrSubstituionWarning(SubstituteLoggingEvent paramSubstituteLoggingEvent, int paramInt) {
/* 250 */     if (paramSubstituteLoggingEvent.getLogger().isDelegateEventAware()) {
/* 251 */       emitReplayWarning(paramInt);
/* 252 */     } else if (!paramSubstituteLoggingEvent.getLogger().isDelegateNOP()) {
/*     */ 
/*     */       
/* 255 */       emitSubstitutionWarning();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void replaySingleEvent(SubstituteLoggingEvent paramSubstituteLoggingEvent) {
/* 260 */     if (paramSubstituteLoggingEvent == null) {
/*     */       return;
/*     */     }
/* 263 */     SubstituteLogger substituteLogger = paramSubstituteLoggingEvent.getLogger();
/* 264 */     String str = substituteLogger.getName();
/* 265 */     if (substituteLogger.isDelegateNull()) {
/* 266 */       throw new IllegalStateException("Delegate logger cannot be null at this state.");
/*     */     }
/*     */     
/* 269 */     if (!substituteLogger.isDelegateNOP())
/*     */     {
/* 271 */       if (substituteLogger.isDelegateEventAware()) {
/* 272 */         substituteLogger.log((LoggingEvent)paramSubstituteLoggingEvent);
/*     */       } else {
/* 274 */         Util.report(str);
/*     */       }  } 
/*     */   }
/*     */   
/*     */   private static void emitSubstitutionWarning() {
/* 279 */     Util.report("The following set of substitute loggers may have been accessed");
/* 280 */     Util.report("during the initialization phase. Logging calls during this");
/* 281 */     Util.report("phase were not honored. However, subsequent logging calls to these");
/* 282 */     Util.report("loggers will work as normally expected.");
/* 283 */     Util.report("See also http://www.slf4j.org/codes.html#substituteLogger");
/*     */   }
/*     */   
/*     */   private static void emitReplayWarning(int paramInt) {
/* 287 */     Util.report("A number (" + paramInt + ") of logging calls during the initialization phase have been intercepted and are");
/* 288 */     Util.report("now being replayed. These are subject to the filtering rules of the underlying logging system.");
/* 289 */     Util.report("See also http://www.slf4j.org/codes.html#replay");
/*     */   }
/*     */   
/*     */   private static final void versionSanityCheck() {
/*     */     try {
/* 294 */       String str = PROVIDER.getRequesteApiVersion();
/*     */       
/* 296 */       boolean bool = false;
/* 297 */       for (String str1 : API_COMPATIBILITY_LIST) {
/* 298 */         if (str.startsWith(str1)) {
/* 299 */           bool = true;
/*     */         }
/*     */       } 
/* 302 */       if (!bool) {
/* 303 */         Util.report("The requested version " + str + " by your slf4j binding is not compatible with " + 
/* 304 */             Arrays.<String>asList(API_COMPATIBILITY_LIST).toString());
/* 305 */         Util.report("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
/*     */       } 
/* 307 */     } catch (NoSuchFieldError noSuchFieldError) {
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 312 */     catch (Throwable throwable) {
/*     */       
/* 314 */       Util.report("Unexpected problem occured during version sanity check", throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean isAmbiguousProviderList(List<SLF4JServiceProvider> paramList) {
/* 319 */     return (paramList.size() > 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void reportMultipleBindingAmbiguity(List<SLF4JServiceProvider> paramList) {
/* 328 */     if (isAmbiguousProviderList(paramList)) {
/* 329 */       Util.report("Class path contains multiple SLF4J providers.");
/* 330 */       for (SLF4JServiceProvider sLF4JServiceProvider : paramList) {
/* 331 */         Util.report("Found provider [" + sLF4JServiceProvider + "]");
/*     */       }
/* 333 */       Util.report("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void reportActualBinding(List<SLF4JServiceProvider> paramList) {
/* 339 */     if (!paramList.isEmpty() && isAmbiguousProviderList(paramList)) {
/* 340 */       Util.report("Actual provider is of type [" + paramList.get(0) + "]");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Logger getLogger(String paramString) {
/* 353 */     ILoggerFactory iLoggerFactory = getILoggerFactory();
/* 354 */     return iLoggerFactory.getLogger(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Logger getLogger(Class<?> paramClass) {
/* 379 */     Logger logger = getLogger(paramClass.getName());
/* 380 */     if (DETECT_LOGGER_NAME_MISMATCH) {
/* 381 */       Class<?> clazz = Util.getCallingClass();
/* 382 */       if (clazz != null && nonMatchingClasses(paramClass, clazz)) {
/* 383 */         Util.report(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", new Object[] { logger.getName(), clazz
/* 384 */                 .getName() }));
/* 385 */         Util.report("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
/*     */       } 
/*     */     } 
/* 388 */     return logger;
/*     */   }
/*     */   
/*     */   private static boolean nonMatchingClasses(Class<?> paramClass1, Class<?> paramClass2) {
/* 392 */     return !paramClass2.isAssignableFrom(paramClass1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ILoggerFactory getILoggerFactory() {
/* 404 */     return getProvider().getLoggerFactory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static SLF4JServiceProvider getProvider() {
/* 414 */     if (INITIALIZATION_STATE == 0) {
/* 415 */       synchronized (LoggerFactory.class) {
/* 416 */         if (INITIALIZATION_STATE == 0) {
/* 417 */           INITIALIZATION_STATE = 1;
/* 418 */           performInitialization();
/*     */         } 
/*     */       } 
/*     */     }
/* 422 */     switch (INITIALIZATION_STATE) {
/*     */       case 3:
/* 424 */         return PROVIDER;
/*     */       case 4:
/* 426 */         return (SLF4JServiceProvider)NOP_FALLBACK_FACTORY;
/*     */       case 2:
/* 428 */         throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
/*     */ 
/*     */       
/*     */       case 1:
/* 432 */         return (SLF4JServiceProvider)SUBST_PROVIDER;
/*     */     } 
/* 434 */     throw new IllegalStateException("Unreachable code");
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/LoggerFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */