/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.text;
/*     */ 
/*     */ import java.text.FieldPosition;
/*     */ import java.text.Format;
/*     */ import java.text.ParsePosition;
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
/*     */ public class CompositeFormat
/*     */   extends Format
/*     */ {
/*     */   private static final long serialVersionUID = -4329119827877627683L;
/*     */   private final Format parser;
/*     */   private final Format formatter;
/*     */   
/*     */   public CompositeFormat(Format paramFormat1, Format paramFormat2) {
/*  55 */     this.parser = paramFormat1;
/*  56 */     this.formatter = paramFormat2;
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
/*     */   public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition) {
/*  70 */     return this.formatter.format(paramObject, paramStringBuffer, paramFieldPosition);
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
/*     */   public Object parseObject(String paramString, ParsePosition paramParsePosition) {
/*  84 */     return this.parser.parseObject(paramString, paramParsePosition);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Format getParser() {
/*  93 */     return this.parser;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Format getFormatter() {
/* 102 */     return this.formatter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String reformat(String paramString) {
/* 113 */     return format(parseObject(paramString));
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/text/CompositeFormat.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */