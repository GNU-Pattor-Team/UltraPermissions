/*    */ package me.TechsCode.UltraPermissions.base.storage;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonNull;
/*    */ import java.util.Objects;
/*    */ import java.util.Optional;
/*    */ import me.TechsCode.UltraPermissions.base.misc.Getter;
/*    */ 
/*    */ public class Stored<T extends Storable> {
/*    */   private String key;
/*    */   
/*    */   public static <T extends Storable> Stored<T> empty() {
/* 13 */     return new Stored<>((JsonElement)JsonNull.INSTANCE, null);
/*    */   }
/*    */ 
/*    */   
/*    */   private Getter<Storage<T>> storageGetter;
/*    */   
/*    */   private T cache;
/*    */   
/*    */   public Stored(String paramString, Getter<Storage<T>> paramGetter) {
/* 22 */     this.key = paramString;
/* 23 */     this.storageGetter = paramGetter;
/*    */   }
/*    */   
/*    */   public Stored(JsonElement paramJsonElement, Getter<Storage<T>> paramGetter) {
/* 27 */     this.key = (paramJsonElement == null || paramJsonElement.isJsonNull()) ? null : paramJsonElement.getAsString();
/* 28 */     this.storageGetter = paramGetter;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Optional<T> get() {
/* 34 */     if (this.cache != null) {
/* 35 */       if (this.cache.isLinkedToStorage()) {
/* 36 */         return Optional.of(this.cache);
/*    */       }
/* 38 */       this.cache = null;
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 43 */     if (this.key == null) return Optional.empty(); 
/* 44 */     if (this.storageGetter == null) return Optional.empty();
/*    */     
/* 46 */     Storage storage = (Storage)this.storageGetter.get();
/*    */ 
/*    */     
/* 49 */     if (storage == null) return Optional.empty();
/*    */     
/* 51 */     Optional<T> optional = storage.get().stream().filter(paramStorable -> paramStorable.getKey().equals(this.key)).findFirst();
/*    */ 
/*    */     
/* 54 */     optional.ifPresent(paramStorable -> this.cache = (T)paramStorable);
/*    */     
/* 56 */     return optional;
/*    */   }
/*    */   
/*    */   public boolean isPresent() {
/* 60 */     return get().isPresent();
/*    */   }
/*    */   
/*    */   public String getKey() {
/* 64 */     return this.key;
/*    */   }
/*    */   
/*    */   public T orElse(T paramT) {
/* 68 */     Optional<T> optional = get();
/* 69 */     return optional.orElse(paramT);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 74 */     if (this == paramObject) return true; 
/* 75 */     if (paramObject == null || getClass() != paramObject.getClass()) return false; 
/* 76 */     Stored stored = (Stored)paramObject;
/* 77 */     return Objects.equals(this.key, stored.key);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 82 */     return Objects.hash(new Object[] { this.key });
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/storage/Stored.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */