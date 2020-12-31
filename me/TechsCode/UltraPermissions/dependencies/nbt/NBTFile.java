/*    */ package me.TechsCode.UltraPermissions.dependencies.nbt;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings.ObjectCreator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NBTFile
/*    */   extends NBTCompound
/*    */ {
/*    */   private final File file;
/*    */   private Object nbt;
/*    */   
/*    */   public NBTFile(File paramFile) {
/* 29 */     super(null, null);
/* 30 */     if (paramFile == null) {
/* 31 */       throw new NullPointerException("File can't be null!");
/*    */     }
/* 33 */     this.file = paramFile;
/* 34 */     if (paramFile.exists()) {
/* 35 */       FileInputStream fileInputStream = new FileInputStream(paramFile);
/* 36 */       this.nbt = NBTReflectionUtil.readNBT(fileInputStream);
/*    */     } else {
/* 38 */       this.nbt = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
/* 39 */       save();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void save() {
/*    */     try {
/* 50 */       getWriteLock().lock();
/* 51 */       if (!this.file.exists()) {
/* 52 */         this.file.getParentFile().mkdirs();
/* 53 */         if (!this.file.createNewFile())
/* 54 */           throw new IOException("Unable to create file at " + this.file.getAbsolutePath()); 
/*    */       } 
/* 56 */       FileOutputStream fileOutputStream = new FileOutputStream(this.file);
/* 57 */       NBTReflectionUtil.writeNBT(this.nbt, fileOutputStream);
/*    */     } finally {
/* 59 */       getWriteLock().unlock();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public File getFile() {
/* 67 */     return this.file;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getCompound() {
/* 72 */     return this.nbt;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void setCompound(Object paramObject) {
/* 77 */     this.nbt = paramObject;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */