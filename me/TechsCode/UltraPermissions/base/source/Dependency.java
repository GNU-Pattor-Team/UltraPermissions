/*    */ package me.TechsCode.UltraPermissions.base.source;
/*    */ 
/*    */ public class Dependency
/*    */ {
/*    */   private String groupId;
/*    */   
/*    */   public Dependency(String paramString1, String paramString2, String paramString3) {
/*  8 */     this.groupId = paramString1;
/*  9 */     this.artifactId = paramString2;
/* 10 */     this.version = paramString3;
/*    */   }
/*    */   private String artifactId; private String version;
/*    */   public String getGroupId() {
/* 14 */     return this.groupId;
/*    */   }
/*    */   
/*    */   public String getArtifactId() {
/* 18 */     return this.artifactId;
/*    */   }
/*    */   
/*    */   public String getVersion() {
/* 22 */     return this.version;
/*    */   }
/*    */   
/*    */   public String toURL() {
/* 26 */     return this.groupId.replace(".", "/") + "/" + this.artifactId + "/" + this.version + "/" + this.artifactId + "-" + this.version + ".jar";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 31 */     if (!(paramObject instanceof Dependency)) return false;
/*    */     
/* 33 */     Dependency dependency = (Dependency)paramObject;
/*    */     
/* 35 */     return dependency.toURL().equals(toURL());
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 40 */     return toURL().hashCode();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/source/Dependency.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */