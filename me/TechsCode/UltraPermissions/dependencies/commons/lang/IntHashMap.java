/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
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
/*     */ class IntHashMap
/*     */ {
/*     */   private transient Entry[] table;
/*     */   private transient int count;
/*     */   private int threshold;
/*     */   private final float loadFactor;
/*     */   
/*     */   private static class Entry
/*     */   {
/*     */     final int hash;
/*     */     final int key;
/*     */     Object value;
/*     */     Entry next;
/*     */     
/*     */     protected Entry(int param1Int1, int param1Int2, Object param1Object, Entry param1Entry) {
/*  84 */       this.hash = param1Int1;
/*  85 */       this.key = param1Int2;
/*  86 */       this.value = param1Object;
/*  87 */       this.next = param1Entry;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntHashMap() {
/*  96 */     this(20, 0.75F);
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
/*     */   public IntHashMap(int paramInt) {
/* 108 */     this(paramInt, 0.75F);
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
/*     */   public IntHashMap(int paramInt, float paramFloat) {
/* 122 */     if (paramInt < 0) {
/* 123 */       throw new IllegalArgumentException("Illegal Capacity: " + paramInt);
/*     */     }
/* 125 */     if (paramFloat <= 0.0F) {
/* 126 */       throw new IllegalArgumentException("Illegal Load: " + paramFloat);
/*     */     }
/* 128 */     if (paramInt == 0) {
/* 129 */       paramInt = 1;
/*     */     }
/*     */     
/* 132 */     this.loadFactor = paramFloat;
/* 133 */     this.table = new Entry[paramInt];
/* 134 */     this.threshold = (int)(paramInt * paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 143 */     return this.count;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 153 */     return (this.count == 0);
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
/*     */   public boolean contains(Object paramObject) {
/* 175 */     if (paramObject == null) {
/* 176 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 179 */     Entry[] arrayOfEntry = this.table;
/* 180 */     for (int i = arrayOfEntry.length; i-- > 0;) {
/* 181 */       for (Entry entry = arrayOfEntry[i]; entry != null; entry = entry.next) {
/* 182 */         if (entry.value.equals(paramObject)) {
/* 183 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/* 187 */     return false;
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
/*     */   public boolean containsValue(Object paramObject) {
/* 203 */     return contains(paramObject);
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
/*     */   public boolean containsKey(int paramInt) {
/* 216 */     Entry[] arrayOfEntry = this.table;
/* 217 */     int i = paramInt;
/* 218 */     int j = (i & Integer.MAX_VALUE) % arrayOfEntry.length;
/* 219 */     for (Entry entry = arrayOfEntry[j]; entry != null; entry = entry.next) {
/* 220 */       if (entry.hash == i) {
/* 221 */         return true;
/*     */       }
/*     */     } 
/* 224 */     return false;
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
/*     */   public Object get(int paramInt) {
/* 237 */     Entry[] arrayOfEntry = this.table;
/* 238 */     int i = paramInt;
/* 239 */     int j = (i & Integer.MAX_VALUE) % arrayOfEntry.length;
/* 240 */     for (Entry entry = arrayOfEntry[j]; entry != null; entry = entry.next) {
/* 241 */       if (entry.hash == i) {
/* 242 */         return entry.value;
/*     */       }
/*     */     } 
/* 245 */     return null;
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
/*     */   protected void rehash() {
/* 258 */     int i = this.table.length;
/* 259 */     Entry[] arrayOfEntry1 = this.table;
/*     */     
/* 261 */     int j = i * 2 + 1;
/* 262 */     Entry[] arrayOfEntry2 = new Entry[j];
/*     */     
/* 264 */     this.threshold = (int)(j * this.loadFactor);
/* 265 */     this.table = arrayOfEntry2;
/*     */     
/* 267 */     for (int k = i; k-- > 0;) {
/* 268 */       for (Entry entry = arrayOfEntry1[k]; entry != null; ) {
/* 269 */         Entry entry1 = entry;
/* 270 */         entry = entry.next;
/*     */         
/* 272 */         int m = (entry1.hash & Integer.MAX_VALUE) % j;
/* 273 */         entry1.next = arrayOfEntry2[m];
/* 274 */         arrayOfEntry2[m] = entry1;
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object put(int paramInt, Object paramObject) {
/* 296 */     Entry[] arrayOfEntry = this.table;
/* 297 */     int i = paramInt;
/* 298 */     int j = (i & Integer.MAX_VALUE) % arrayOfEntry.length; Entry entry;
/* 299 */     for (entry = arrayOfEntry[j]; entry != null; entry = entry.next) {
/* 300 */       if (entry.hash == i) {
/* 301 */         Object object = entry.value;
/* 302 */         entry.value = paramObject;
/* 303 */         return object;
/*     */       } 
/*     */     } 
/*     */     
/* 307 */     if (this.count >= this.threshold) {
/*     */       
/* 309 */       rehash();
/*     */       
/* 311 */       arrayOfEntry = this.table;
/* 312 */       j = (i & Integer.MAX_VALUE) % arrayOfEntry.length;
/*     */     } 
/*     */ 
/*     */     
/* 316 */     entry = new Entry(i, paramInt, paramObject, arrayOfEntry[j]);
/* 317 */     arrayOfEntry[j] = entry;
/* 318 */     this.count++;
/* 319 */     return null;
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
/*     */   public Object remove(int paramInt) {
/* 334 */     Entry[] arrayOfEntry = this.table;
/* 335 */     int i = paramInt;
/* 336 */     int j = (i & Integer.MAX_VALUE) % arrayOfEntry.length;
/* 337 */     for (Entry entry1 = arrayOfEntry[j], entry2 = null; entry1 != null; entry2 = entry1, entry1 = entry1.next) {
/* 338 */       if (entry1.hash == i) {
/* 339 */         if (entry2 != null) {
/* 340 */           entry2.next = entry1.next;
/*     */         } else {
/* 342 */           arrayOfEntry[j] = entry1.next;
/*     */         } 
/* 344 */         this.count--;
/* 345 */         Object object = entry1.value;
/* 346 */         entry1.value = null;
/* 347 */         return object;
/*     */       } 
/*     */     } 
/* 350 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void clear() {
/* 357 */     Entry[] arrayOfEntry = this.table;
/* 358 */     for (int i = arrayOfEntry.length; --i >= 0;) {
/* 359 */       arrayOfEntry[i] = null;
/*     */     }
/* 361 */     this.count = 0;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/IntHashMap.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */