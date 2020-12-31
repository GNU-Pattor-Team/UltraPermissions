/*    */ package me.TechsCode.UltraPermissions.base.source;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import java.io.File;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ 
/*    */ public class Maven {
/*    */   private static boolean initialized = false;
/*    */   private static TechPlugin plugin;
/* 16 */   private static final List<String> repositories = new ArrayList<>(
/* 17 */       Collections.singletonList("https://repo1.maven.org/maven2"));
/*    */   
/*    */   private static JarClassLoader classLoader;
/*    */   
/*    */   private static LocalRepository localRepository;
/*    */   private static Set<Dependency> loadedDependencies;
/*    */   private static Set<Dependency> failedDependencies;
/*    */   
/*    */   public static void initialize(SpigotTechPlugin paramSpigotTechPlugin) {
/* 26 */     if (initialized)
/*    */       return; 
/* 28 */     plugin = (TechPlugin)paramSpigotTechPlugin;
/*    */     
/* 30 */     classLoader = new JarClassLoader(paramSpigotTechPlugin);
/*    */     
/* 32 */     localRepository = new LocalRepository((TechPlugin)paramSpigotTechPlugin);
/* 33 */     loadedDependencies = new HashSet<>();
/* 34 */     failedDependencies = new HashSet<>();
/*    */     
/* 36 */     initialized = true;
/*    */   }
/*    */   
/*    */   public static void addRepository(String paramString) {
/* 40 */     Preconditions.checkArgument(initialized, "Call #initialize before using Maven");
/*    */     
/* 42 */     if (!repositories.contains(paramString)) {
/* 43 */       repositories.add(paramString);
/*    */     }
/*    */   }
/*    */   
/*    */   public static boolean loadDependency(String paramString1, String paramString2, String paramString3) {
/* 48 */     Dependency dependency = new Dependency(paramString1, paramString2, paramString3);
/*    */     
/* 50 */     return loadDependency(dependency);
/*    */   }
/*    */   
/*    */   public static boolean loadDependency(Dependency paramDependency) {
/* 54 */     Preconditions.checkArgument(initialized, "Call #initialize before using Maven");
/*    */     
/* 56 */     if (failedDependencies.contains(paramDependency)) return false; 
/* 57 */     if (loadedDependencies.contains(paramDependency)) return true;
/*    */     
/* 59 */     File file = localRepository.getIfPresent(paramDependency);
/*    */     
/* 61 */     if (file == null) {
/* 62 */       localRepository.load(paramDependency, repositories);
/*    */       
/* 64 */       file = localRepository.getIfPresent(paramDependency);
/*    */     } 
/*    */     
/* 67 */     if (file != null) {
/* 68 */       classLoader.load(file);
/* 69 */       loadedDependencies.add(paramDependency);
/*    */       
/* 71 */       plugin.log("Loaded dependency " + paramDependency.getGroupId() + ":" + paramDependency.getArtifactId() + ":" + paramDependency.getVersion());
/*    */     } else {
/* 73 */       failedDependencies.add(paramDependency);
/*    */       
/* 75 */       plugin.log("Could not load " + paramDependency.getGroupId() + " / " + paramDependency.getArtifactId() + " on " + paramDependency.getVersion());
/*    */     } 
/*    */     
/* 78 */     return (file != null);
/*    */   }
/*    */   
/*    */   public static boolean isLoaded(Dependency paramDependency) {
/* 82 */     return loadedDependencies.contains(paramDependency);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/source/Maven.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */