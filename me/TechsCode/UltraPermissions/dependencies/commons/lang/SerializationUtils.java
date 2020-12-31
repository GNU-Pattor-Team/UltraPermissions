/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Serializable;
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
/*     */ public class SerializationUtils
/*     */ {
/*     */   public static Object clone(Serializable paramSerializable) {
/*  81 */     return deserialize(serialize(paramSerializable));
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
/*     */   public static void serialize(Serializable paramSerializable, OutputStream paramOutputStream) {
/* 102 */     if (paramOutputStream == null) {
/* 103 */       throw new IllegalArgumentException("The OutputStream must not be null");
/*     */     }
/* 105 */     ObjectOutputStream objectOutputStream = null;
/*     */     
/*     */     try {
/* 108 */       objectOutputStream = new ObjectOutputStream(paramOutputStream);
/* 109 */       objectOutputStream.writeObject(paramSerializable);
/*     */     }
/* 111 */     catch (IOException iOException) {
/* 112 */       throw new SerializationException(iOException);
/*     */     } finally {
/*     */       try {
/* 115 */         if (objectOutputStream != null) {
/* 116 */           objectOutputStream.close();
/*     */         }
/* 118 */       } catch (IOException iOException) {}
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
/*     */ 
/*     */   
/*     */   public static byte[] serialize(Serializable paramSerializable) {
/* 133 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
/* 134 */     serialize(paramSerializable, byteArrayOutputStream);
/* 135 */     return byteArrayOutputStream.toByteArray();
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
/*     */   public static Object deserialize(InputStream paramInputStream) {
/* 156 */     if (paramInputStream == null) {
/* 157 */       throw new IllegalArgumentException("The InputStream must not be null");
/*     */     }
/* 159 */     ObjectInputStream objectInputStream = null;
/*     */     
/*     */     try {
/* 162 */       objectInputStream = new ObjectInputStream(paramInputStream);
/* 163 */       return objectInputStream.readObject();
/*     */     }
/* 165 */     catch (ClassNotFoundException classNotFoundException) {
/* 166 */       throw new SerializationException(classNotFoundException);
/* 167 */     } catch (IOException iOException) {
/* 168 */       throw new SerializationException(iOException);
/*     */     } finally {
/*     */       try {
/* 171 */         if (objectInputStream != null) {
/* 172 */           objectInputStream.close();
/*     */         }
/* 174 */       } catch (IOException iOException) {}
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
/*     */ 
/*     */   
/*     */   public static Object deserialize(byte[] paramArrayOfbyte) {
/* 189 */     if (paramArrayOfbyte == null) {
/* 190 */       throw new IllegalArgumentException("The byte[] must not be null");
/*     */     }
/* 192 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
/* 193 */     return deserialize(byteArrayInputStream);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/SerializationUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */