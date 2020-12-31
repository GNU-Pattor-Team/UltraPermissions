/*     */ package me.TechsCode.UltraPermissions.dependencies.slf4j.helpers;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Marker;
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
/*     */ public class BasicMarker
/*     */   implements Marker
/*     */ {
/*     */   private static final long serialVersionUID = -2849567615646933777L;
/*     */   private final String name;
/*  43 */   private List<Marker> referenceList = new CopyOnWriteArrayList<>();
/*     */   
/*     */   BasicMarker(String paramString) {
/*  46 */     if (paramString == null) {
/*  47 */       throw new IllegalArgumentException("A marker name cannot be null");
/*     */     }
/*  49 */     this.name = paramString;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  53 */     return this.name;
/*     */   }
/*     */   
/*     */   public void add(Marker paramMarker) {
/*  57 */     if (paramMarker == null) {
/*  58 */       throw new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
/*     */     }
/*     */ 
/*     */     
/*  62 */     if (contains(paramMarker)) {
/*     */       return;
/*     */     }
/*  65 */     if (paramMarker.contains(this)) {
/*     */       return;
/*     */     }
/*     */     
/*  69 */     this.referenceList.add(paramMarker);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasReferences() {
/*  74 */     return (this.referenceList.size() > 0);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public boolean hasChildren() {
/*  79 */     return hasReferences();
/*     */   }
/*     */   
/*     */   public Iterator<Marker> iterator() {
/*  83 */     return this.referenceList.iterator();
/*     */   }
/*     */   
/*     */   public boolean remove(Marker paramMarker) {
/*  87 */     return this.referenceList.remove(paramMarker);
/*     */   }
/*     */   
/*     */   public boolean contains(Marker paramMarker) {
/*  91 */     if (paramMarker == null) {
/*  92 */       throw new IllegalArgumentException("Other cannot be null");
/*     */     }
/*     */     
/*  95 */     if (equals(paramMarker)) {
/*  96 */       return true;
/*     */     }
/*     */     
/*  99 */     if (hasReferences()) {
/* 100 */       for (Marker marker : this.referenceList) {
/* 101 */         if (marker.contains(paramMarker)) {
/* 102 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(String paramString) {
/* 113 */     if (paramString == null) {
/* 114 */       throw new IllegalArgumentException("Other cannot be null");
/*     */     }
/*     */     
/* 117 */     if (this.name.equals(paramString)) {
/* 118 */       return true;
/*     */     }
/*     */     
/* 121 */     if (hasReferences()) {
/* 122 */       for (Marker marker : this.referenceList) {
/* 123 */         if (marker.contains(paramString)) {
/* 124 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/* 128 */     return false;
/*     */   }
/*     */   
/* 131 */   private static String OPEN = "[ ";
/* 132 */   private static String CLOSE = " ]";
/* 133 */   private static String SEP = ", ";
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 136 */     if (this == paramObject)
/* 137 */       return true; 
/* 138 */     if (paramObject == null)
/* 139 */       return false; 
/* 140 */     if (!(paramObject instanceof Marker)) {
/* 141 */       return false;
/*     */     }
/* 143 */     Marker marker = (Marker)paramObject;
/* 144 */     return this.name.equals(marker.getName());
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 148 */     return this.name.hashCode();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 152 */     if (!hasReferences()) {
/* 153 */       return getName();
/*     */     }
/* 155 */     Iterator<Marker> iterator = iterator();
/*     */     
/* 157 */     StringBuilder stringBuilder = new StringBuilder(getName());
/* 158 */     stringBuilder.append(' ').append(OPEN);
/* 159 */     while (iterator.hasNext()) {
/* 160 */       Marker marker = iterator.next();
/* 161 */       stringBuilder.append(marker.getName());
/* 162 */       if (iterator.hasNext()) {
/* 163 */         stringBuilder.append(SEP);
/*     */       }
/*     */     } 
/* 166 */     stringBuilder.append(CLOSE);
/*     */     
/* 168 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/helpers/BasicMarker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */