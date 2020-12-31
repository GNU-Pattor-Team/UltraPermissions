/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.language;
/*      */ 
/*      */ import java.util.Locale;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.EncoderException;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.StringEncoder;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.binary.StringUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class DoubleMetaphone
/*      */   implements StringEncoder
/*      */ {
/*      */   private static final String VOWELS = "AEIOUY";
/*   48 */   private static final String[] SILENT_START = new String[] { "GN", "KN", "PN", "WR", "PS" };
/*      */   
/*   50 */   private static final String[] L_R_N_M_B_H_F_V_W_SPACE = new String[] { "L", "R", "N", "M", "B", "H", "F", "V", "W", " " };
/*      */   
/*   52 */   private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = new String[] { "ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER" };
/*      */   
/*   54 */   private static final String[] L_T_K_S_N_M_B_Z = new String[] { "L", "T", "K", "S", "N", "M", "B", "Z" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   60 */   private int maxCodeLen = 4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String doubleMetaphone(String paramString) {
/*   76 */     return doubleMetaphone(paramString, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String doubleMetaphone(String paramString, boolean paramBoolean) {
/*   87 */     paramString = cleanInput(paramString);
/*   88 */     if (paramString == null) {
/*   89 */       return null;
/*      */     }
/*      */     
/*   92 */     boolean bool = isSlavoGermanic(paramString);
/*   93 */     int i = isSilentStart(paramString) ? 1 : 0;
/*      */     
/*   95 */     DoubleMetaphoneResult doubleMetaphoneResult = new DoubleMetaphoneResult(getMaxCodeLen());
/*      */     
/*   97 */     while (!doubleMetaphoneResult.isComplete() && i <= paramString.length() - 1) {
/*   98 */       switch (paramString.charAt(i)) {
/*      */         case 'A':
/*      */         case 'E':
/*      */         case 'I':
/*      */         case 'O':
/*      */         case 'U':
/*      */         case 'Y':
/*  105 */           i = handleAEIOUY(doubleMetaphoneResult, i);
/*      */           continue;
/*      */         case 'B':
/*  108 */           doubleMetaphoneResult.append('P');
/*  109 */           i = (charAt(paramString, i + 1) == 'B') ? (i + 2) : (i + 1);
/*      */           continue;
/*      */         
/*      */         case 'Ç':
/*  113 */           doubleMetaphoneResult.append('S');
/*  114 */           i++;
/*      */           continue;
/*      */         case 'C':
/*  117 */           i = handleC(paramString, doubleMetaphoneResult, i);
/*      */           continue;
/*      */         case 'D':
/*  120 */           i = handleD(paramString, doubleMetaphoneResult, i);
/*      */           continue;
/*      */         case 'F':
/*  123 */           doubleMetaphoneResult.append('F');
/*  124 */           i = (charAt(paramString, i + 1) == 'F') ? (i + 2) : (i + 1);
/*      */           continue;
/*      */         case 'G':
/*  127 */           i = handleG(paramString, doubleMetaphoneResult, i, bool);
/*      */           continue;
/*      */         case 'H':
/*  130 */           i = handleH(paramString, doubleMetaphoneResult, i);
/*      */           continue;
/*      */         case 'J':
/*  133 */           i = handleJ(paramString, doubleMetaphoneResult, i, bool);
/*      */           continue;
/*      */         case 'K':
/*  136 */           doubleMetaphoneResult.append('K');
/*  137 */           i = (charAt(paramString, i + 1) == 'K') ? (i + 2) : (i + 1);
/*      */           continue;
/*      */         case 'L':
/*  140 */           i = handleL(paramString, doubleMetaphoneResult, i);
/*      */           continue;
/*      */         case 'M':
/*  143 */           doubleMetaphoneResult.append('M');
/*  144 */           i = conditionM0(paramString, i) ? (i + 2) : (i + 1);
/*      */           continue;
/*      */         case 'N':
/*  147 */           doubleMetaphoneResult.append('N');
/*  148 */           i = (charAt(paramString, i + 1) == 'N') ? (i + 2) : (i + 1);
/*      */           continue;
/*      */         
/*      */         case 'Ñ':
/*  152 */           doubleMetaphoneResult.append('N');
/*  153 */           i++;
/*      */           continue;
/*      */         case 'P':
/*  156 */           i = handleP(paramString, doubleMetaphoneResult, i);
/*      */           continue;
/*      */         case 'Q':
/*  159 */           doubleMetaphoneResult.append('K');
/*  160 */           i = (charAt(paramString, i + 1) == 'Q') ? (i + 2) : (i + 1);
/*      */           continue;
/*      */         case 'R':
/*  163 */           i = handleR(paramString, doubleMetaphoneResult, i, bool);
/*      */           continue;
/*      */         case 'S':
/*  166 */           i = handleS(paramString, doubleMetaphoneResult, i, bool);
/*      */           continue;
/*      */         case 'T':
/*  169 */           i = handleT(paramString, doubleMetaphoneResult, i);
/*      */           continue;
/*      */         case 'V':
/*  172 */           doubleMetaphoneResult.append('F');
/*  173 */           i = (charAt(paramString, i + 1) == 'V') ? (i + 2) : (i + 1);
/*      */           continue;
/*      */         case 'W':
/*  176 */           i = handleW(paramString, doubleMetaphoneResult, i);
/*      */           continue;
/*      */         case 'X':
/*  179 */           i = handleX(paramString, doubleMetaphoneResult, i);
/*      */           continue;
/*      */         case 'Z':
/*  182 */           i = handleZ(paramString, doubleMetaphoneResult, i, bool);
/*      */           continue;
/*      */       } 
/*  185 */       i++;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  190 */     return paramBoolean ? doubleMetaphoneResult.getAlternate() : doubleMetaphoneResult.getPrimary();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object encode(Object paramObject) {
/*  203 */     if (!(paramObject instanceof String)) {
/*  204 */       throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
/*      */     }
/*  206 */     return doubleMetaphone((String)paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String encode(String paramString) {
/*  217 */     return doubleMetaphone(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDoubleMetaphoneEqual(String paramString1, String paramString2) {
/*  231 */     return isDoubleMetaphoneEqual(paramString1, paramString2, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDoubleMetaphoneEqual(String paramString1, String paramString2, boolean paramBoolean) {
/*  245 */     return StringUtils.equals(doubleMetaphone(paramString1, paramBoolean), doubleMetaphone(paramString2, paramBoolean));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxCodeLen() {
/*  253 */     return this.maxCodeLen;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxCodeLen(int paramInt) {
/*  261 */     this.maxCodeLen = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleAEIOUY(DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
/*  270 */     if (paramInt == 0) {
/*  271 */       paramDoubleMetaphoneResult.append('A');
/*      */     }
/*  273 */     return paramInt + 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleC(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
/*  280 */     if (conditionC0(paramString, paramInt))
/*  281 */     { paramDoubleMetaphoneResult.append('K');
/*  282 */       paramInt += 2; }
/*  283 */     else if (paramInt == 0 && contains(paramString, paramInt, 6, new String[] { "CAESAR" }))
/*  284 */     { paramDoubleMetaphoneResult.append('S');
/*  285 */       paramInt += 2; }
/*  286 */     else if (contains(paramString, paramInt, 2, new String[] { "CH" }))
/*  287 */     { paramInt = handleCH(paramString, paramDoubleMetaphoneResult, paramInt); }
/*  288 */     else if (contains(paramString, paramInt, 2, new String[] { "CZ"
/*  289 */         }) && !contains(paramString, paramInt - 2, 4, new String[] { "WICZ" }))
/*      */     
/*  291 */     { paramDoubleMetaphoneResult.append('S', 'X');
/*  292 */       paramInt += 2; }
/*  293 */     else if (contains(paramString, paramInt + 1, 3, new String[] { "CIA" }))
/*      */     
/*  295 */     { paramDoubleMetaphoneResult.append('X');
/*  296 */       paramInt += 3; }
/*  297 */     else { if (contains(paramString, paramInt, 2, new String[] { "CC" }) && (paramInt != 1 || 
/*  298 */         charAt(paramString, 0) != 'M'))
/*      */       {
/*  300 */         return handleCC(paramString, paramDoubleMetaphoneResult, paramInt); } 
/*  301 */       if (contains(paramString, paramInt, 2, new String[] { "CK", "CG", "CQ" })) {
/*  302 */         paramDoubleMetaphoneResult.append('K');
/*  303 */         paramInt += 2;
/*  304 */       } else if (contains(paramString, paramInt, 2, new String[] { "CI", "CE", "CY" })) {
/*      */         
/*  306 */         if (contains(paramString, paramInt, 3, new String[] { "CIO", "CIE", "CIA" })) {
/*  307 */           paramDoubleMetaphoneResult.append('S', 'X');
/*      */         } else {
/*  309 */           paramDoubleMetaphoneResult.append('S');
/*      */         } 
/*  311 */         paramInt += 2;
/*      */       } else {
/*  313 */         paramDoubleMetaphoneResult.append('K');
/*  314 */         if (contains(paramString, paramInt + 1, 2, new String[] { " C", " Q", " G" })) {
/*      */           
/*  316 */           paramInt += 3;
/*  317 */         } else if (contains(paramString, paramInt + 1, 1, new String[] { "C", "K", "Q"
/*  318 */             }) && !contains(paramString, paramInt + 1, 2, new String[] { "CE", "CI" })) {
/*  319 */           paramInt += 2;
/*      */         } else {
/*  321 */           paramInt++;
/*      */         } 
/*      */       }  }
/*      */     
/*  325 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleCC(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
/*  332 */     if (contains(paramString, paramInt + 2, 1, new String[] { "I", "E", "H"
/*  333 */         }) && !contains(paramString, paramInt + 2, 2, new String[] { "HU" })) {
/*      */       
/*  335 */       if ((paramInt == 1 && charAt(paramString, paramInt - 1) == 'A') || 
/*  336 */         contains(paramString, paramInt - 1, 5, new String[] { "UCCEE", "UCCES" })) {
/*      */         
/*  338 */         paramDoubleMetaphoneResult.append("KS");
/*      */       } else {
/*      */         
/*  341 */         paramDoubleMetaphoneResult.append('X');
/*      */       } 
/*  343 */       paramInt += 3;
/*      */     } else {
/*  345 */       paramDoubleMetaphoneResult.append('K');
/*  346 */       paramInt += 2;
/*      */     } 
/*      */     
/*  349 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleCH(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
/*  356 */     if (paramInt > 0 && contains(paramString, paramInt, 4, new String[] { "CHAE" })) {
/*  357 */       paramDoubleMetaphoneResult.append('K', 'X');
/*  358 */       return paramInt + 2;
/*  359 */     }  if (conditionCH0(paramString, paramInt)) {
/*      */       
/*  361 */       paramDoubleMetaphoneResult.append('K');
/*  362 */       return paramInt + 2;
/*  363 */     }  if (conditionCH1(paramString, paramInt)) {
/*      */       
/*  365 */       paramDoubleMetaphoneResult.append('K');
/*  366 */       return paramInt + 2;
/*      */     } 
/*  368 */     if (paramInt > 0) {
/*  369 */       if (contains(paramString, 0, 2, new String[] { "MC" })) {
/*  370 */         paramDoubleMetaphoneResult.append('K');
/*      */       } else {
/*  372 */         paramDoubleMetaphoneResult.append('X', 'K');
/*      */       } 
/*      */     } else {
/*  375 */       paramDoubleMetaphoneResult.append('X');
/*      */     } 
/*  377 */     return paramInt + 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleD(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
/*  385 */     if (contains(paramString, paramInt, 2, new String[] { "DG" })) {
/*      */       
/*  387 */       if (contains(paramString, paramInt + 2, 1, new String[] { "I", "E", "Y" })) {
/*  388 */         paramDoubleMetaphoneResult.append('J');
/*  389 */         paramInt += 3;
/*      */       } else {
/*      */         
/*  392 */         paramDoubleMetaphoneResult.append("TK");
/*  393 */         paramInt += 2;
/*      */       } 
/*  395 */     } else if (contains(paramString, paramInt, 2, new String[] { "DT", "DD" })) {
/*  396 */       paramDoubleMetaphoneResult.append('T');
/*  397 */       paramInt += 2;
/*      */     } else {
/*  399 */       paramDoubleMetaphoneResult.append('T');
/*  400 */       paramInt++;
/*      */     } 
/*  402 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleG(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean) {
/*  410 */     if (charAt(paramString, paramInt + 1) == 'H') {
/*  411 */       paramInt = handleGH(paramString, paramDoubleMetaphoneResult, paramInt);
/*  412 */     } else if (charAt(paramString, paramInt + 1) == 'N') {
/*  413 */       if (paramInt == 1 && isVowel(charAt(paramString, 0)) && !paramBoolean) {
/*  414 */         paramDoubleMetaphoneResult.append("KN", "N");
/*  415 */       } else if (!contains(paramString, paramInt + 2, 2, new String[] { "EY"
/*  416 */           }) && charAt(paramString, paramInt + 1) != 'Y' && !paramBoolean) {
/*  417 */         paramDoubleMetaphoneResult.append("N", "KN");
/*      */       } else {
/*  419 */         paramDoubleMetaphoneResult.append("KN");
/*      */       } 
/*  421 */       paramInt += 2;
/*  422 */     } else if (contains(paramString, paramInt + 1, 2, new String[] { "LI" }) && !paramBoolean) {
/*  423 */       paramDoubleMetaphoneResult.append("KL", "L");
/*  424 */       paramInt += 2;
/*  425 */     } else if (paramInt == 0 && (
/*  426 */       charAt(paramString, paramInt + 1) == 'Y' || 
/*  427 */       contains(paramString, paramInt + 1, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))) {
/*      */       
/*  429 */       paramDoubleMetaphoneResult.append('K', 'J');
/*  430 */       paramInt += 2;
/*  431 */     } else if ((contains(paramString, paramInt + 1, 2, new String[] { "ER"
/*  432 */         }) || charAt(paramString, paramInt + 1) == 'Y') && 
/*  433 */       !contains(paramString, 0, 6, new String[] { "DANGER", "RANGER", "MANGER"
/*  434 */         }) && !contains(paramString, paramInt - 1, 1, new String[] { "E", "I"
/*  435 */         }) && !contains(paramString, paramInt - 1, 3, new String[] { "RGY", "OGY" })) {
/*      */       
/*  437 */       paramDoubleMetaphoneResult.append('K', 'J');
/*  438 */       paramInt += 2;
/*  439 */     } else if (contains(paramString, paramInt + 1, 1, new String[] { "E", "I", "Y"
/*  440 */         }) || contains(paramString, paramInt - 1, 4, new String[] { "AGGI", "OGGI" })) {
/*      */       
/*  442 */       if (contains(paramString, 0, 4, new String[] { "VAN ", "VON "
/*  443 */           }) || contains(paramString, 0, 3, new String[] { "SCH"
/*  444 */           }) || contains(paramString, paramInt + 1, 2, new String[] { "ET" })) {
/*      */         
/*  446 */         paramDoubleMetaphoneResult.append('K');
/*  447 */       } else if (contains(paramString, paramInt + 1, 3, new String[] { "IER" })) {
/*  448 */         paramDoubleMetaphoneResult.append('J');
/*      */       } else {
/*  450 */         paramDoubleMetaphoneResult.append('J', 'K');
/*      */       } 
/*  452 */       paramInt += 2;
/*  453 */     } else if (charAt(paramString, paramInt + 1) == 'G') {
/*  454 */       paramInt += 2;
/*  455 */       paramDoubleMetaphoneResult.append('K');
/*      */     } else {
/*  457 */       paramInt++;
/*  458 */       paramDoubleMetaphoneResult.append('K');
/*      */     } 
/*  460 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleGH(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
/*  467 */     if (paramInt > 0 && !isVowel(charAt(paramString, paramInt - 1))) {
/*  468 */       paramDoubleMetaphoneResult.append('K');
/*  469 */       paramInt += 2;
/*  470 */     } else if (paramInt == 0) {
/*  471 */       if (charAt(paramString, paramInt + 2) == 'I') {
/*  472 */         paramDoubleMetaphoneResult.append('J');
/*      */       } else {
/*  474 */         paramDoubleMetaphoneResult.append('K');
/*      */       } 
/*  476 */       paramInt += 2;
/*  477 */     } else if ((paramInt > 1 && contains(paramString, paramInt - 2, 1, new String[] { "B", "H", "D" })) || (paramInt > 2 && 
/*  478 */       contains(paramString, paramInt - 3, 1, new String[] { "B", "H", "D" })) || (paramInt > 3 && 
/*  479 */       contains(paramString, paramInt - 4, 1, new String[] { "B", "H" }))) {
/*      */       
/*  481 */       paramInt += 2;
/*      */     } else {
/*  483 */       if (paramInt > 2 && charAt(paramString, paramInt - 1) == 'U' && 
/*  484 */         contains(paramString, paramInt - 3, 1, new String[] { "C", "G", "L", "R", "T" })) {
/*      */         
/*  486 */         paramDoubleMetaphoneResult.append('F');
/*  487 */       } else if (paramInt > 0 && charAt(paramString, paramInt - 1) != 'I') {
/*  488 */         paramDoubleMetaphoneResult.append('K');
/*      */       } 
/*  490 */       paramInt += 2;
/*      */     } 
/*  492 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleH(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
/*  500 */     if ((paramInt == 0 || isVowel(charAt(paramString, paramInt - 1))) && 
/*  501 */       isVowel(charAt(paramString, paramInt + 1))) {
/*  502 */       paramDoubleMetaphoneResult.append('H');
/*  503 */       paramInt += 2;
/*      */     } else {
/*      */       
/*  506 */       paramInt++;
/*      */     } 
/*  508 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleJ(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean) {
/*  516 */     if (contains(paramString, paramInt, 4, new String[] { "JOSE" }) || contains(paramString, 0, 4, new String[] { "SAN " })) {
/*      */       
/*  518 */       if ((paramInt == 0 && charAt(paramString, paramInt + 4) == ' ') || paramString
/*  519 */         .length() == 4 || contains(paramString, 0, 4, new String[] { "SAN " })) {
/*  520 */         paramDoubleMetaphoneResult.append('H');
/*      */       } else {
/*  522 */         paramDoubleMetaphoneResult.append('J', 'H');
/*      */       } 
/*  524 */       paramInt++;
/*      */     } else {
/*  526 */       if (paramInt == 0 && !contains(paramString, paramInt, 4, new String[] { "JOSE" })) {
/*  527 */         paramDoubleMetaphoneResult.append('J', 'A');
/*  528 */       } else if (isVowel(charAt(paramString, paramInt - 1)) && !paramBoolean && (
/*  529 */         charAt(paramString, paramInt + 1) == 'A' || charAt(paramString, paramInt + 1) == 'O')) {
/*  530 */         paramDoubleMetaphoneResult.append('J', 'H');
/*  531 */       } else if (paramInt == paramString.length() - 1) {
/*  532 */         paramDoubleMetaphoneResult.append('J', ' ');
/*  533 */       } else if (!contains(paramString, paramInt + 1, 1, L_T_K_S_N_M_B_Z) && 
/*  534 */         !contains(paramString, paramInt - 1, 1, new String[] { "S", "K", "L" })) {
/*  535 */         paramDoubleMetaphoneResult.append('J');
/*      */       } 
/*      */       
/*  538 */       if (charAt(paramString, paramInt + 1) == 'J') {
/*  539 */         paramInt += 2;
/*      */       } else {
/*  541 */         paramInt++;
/*      */       } 
/*      */     } 
/*  544 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleL(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
/*  551 */     if (charAt(paramString, paramInt + 1) == 'L') {
/*  552 */       if (conditionL0(paramString, paramInt)) {
/*  553 */         paramDoubleMetaphoneResult.appendPrimary('L');
/*      */       } else {
/*  555 */         paramDoubleMetaphoneResult.append('L');
/*      */       } 
/*  557 */       paramInt += 2;
/*      */     } else {
/*  559 */       paramInt++;
/*  560 */       paramDoubleMetaphoneResult.append('L');
/*      */     } 
/*  562 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleP(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
/*  569 */     if (charAt(paramString, paramInt + 1) == 'H') {
/*  570 */       paramDoubleMetaphoneResult.append('F');
/*  571 */       paramInt += 2;
/*      */     } else {
/*  573 */       paramDoubleMetaphoneResult.append('P');
/*  574 */       paramInt = contains(paramString, paramInt + 1, 1, new String[] { "P", "B" }) ? (paramInt + 2) : (paramInt + 1);
/*      */     } 
/*  576 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleR(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean) {
/*  584 */     if (paramInt == paramString.length() - 1 && !paramBoolean && 
/*  585 */       contains(paramString, paramInt - 2, 2, new String[] { "IE"
/*  586 */         }) && !contains(paramString, paramInt - 4, 2, new String[] { "ME", "MA" })) {
/*  587 */       paramDoubleMetaphoneResult.appendAlternate('R');
/*      */     } else {
/*  589 */       paramDoubleMetaphoneResult.append('R');
/*      */     } 
/*  591 */     return (charAt(paramString, paramInt + 1) == 'R') ? (paramInt + 2) : (paramInt + 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleS(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean) {
/*  599 */     if (contains(paramString, paramInt - 1, 3, new String[] { "ISL", "YSL" })) {
/*      */       
/*  601 */       paramInt++;
/*  602 */     } else if (paramInt == 0 && contains(paramString, paramInt, 5, new String[] { "SUGAR" })) {
/*      */       
/*  604 */       paramDoubleMetaphoneResult.append('X', 'S');
/*  605 */       paramInt++;
/*  606 */     } else if (contains(paramString, paramInt, 2, new String[] { "SH" })) {
/*  607 */       if (contains(paramString, paramInt + 1, 4, new String[] { "HEIM", "HOEK", "HOLM", "HOLZ" })) {
/*      */         
/*  609 */         paramDoubleMetaphoneResult.append('S');
/*      */       } else {
/*  611 */         paramDoubleMetaphoneResult.append('X');
/*      */       } 
/*  613 */       paramInt += 2;
/*  614 */     } else if (contains(paramString, paramInt, 3, new String[] { "SIO", "SIA" }) || contains(paramString, paramInt, 4, new String[] { "SIAN" })) {
/*      */       
/*  616 */       if (paramBoolean) {
/*  617 */         paramDoubleMetaphoneResult.append('S');
/*      */       } else {
/*  619 */         paramDoubleMetaphoneResult.append('S', 'X');
/*      */       } 
/*  621 */       paramInt += 3;
/*  622 */     } else if ((paramInt == 0 && contains(paramString, paramInt + 1, 1, new String[] { "M", "N", "L", "W"
/*  623 */         })) || contains(paramString, paramInt + 1, 1, new String[] { "Z" })) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  628 */       paramDoubleMetaphoneResult.append('S', 'X');
/*  629 */       paramInt = contains(paramString, paramInt + 1, 1, new String[] { "Z" }) ? (paramInt + 2) : (paramInt + 1);
/*  630 */     } else if (contains(paramString, paramInt, 2, new String[] { "SC" })) {
/*  631 */       paramInt = handleSC(paramString, paramDoubleMetaphoneResult, paramInt);
/*      */     } else {
/*  633 */       if (paramInt == paramString.length() - 1 && contains(paramString, paramInt - 2, 2, new String[] { "AI", "OI" })) {
/*      */         
/*  635 */         paramDoubleMetaphoneResult.appendAlternate('S');
/*      */       } else {
/*  637 */         paramDoubleMetaphoneResult.append('S');
/*      */       } 
/*  639 */       paramInt = contains(paramString, paramInt + 1, 1, new String[] { "S", "Z" }) ? (paramInt + 2) : (paramInt + 1);
/*      */     } 
/*  641 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleSC(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
/*  648 */     if (charAt(paramString, paramInt + 2) == 'H') {
/*      */       
/*  650 */       if (contains(paramString, paramInt + 3, 2, new String[] { "OO", "ER", "EN", "UY", "ED", "EM" })) {
/*      */         
/*  652 */         if (contains(paramString, paramInt + 3, 2, new String[] { "ER", "EN" })) {
/*      */           
/*  654 */           paramDoubleMetaphoneResult.append("X", "SK");
/*      */         } else {
/*  656 */           paramDoubleMetaphoneResult.append("SK");
/*      */         }
/*      */       
/*  659 */       } else if (paramInt == 0 && !isVowel(charAt(paramString, 3)) && charAt(paramString, 3) != 'W') {
/*  660 */         paramDoubleMetaphoneResult.append('X', 'S');
/*      */       } else {
/*  662 */         paramDoubleMetaphoneResult.append('X');
/*      */       }
/*      */     
/*  665 */     } else if (contains(paramString, paramInt + 2, 1, new String[] { "I", "E", "Y" })) {
/*  666 */       paramDoubleMetaphoneResult.append('S');
/*      */     } else {
/*  668 */       paramDoubleMetaphoneResult.append("SK");
/*      */     } 
/*  670 */     return paramInt + 3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleT(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
/*  677 */     if (contains(paramString, paramInt, 4, new String[] { "TION" })) {
/*  678 */       paramDoubleMetaphoneResult.append('X');
/*  679 */       paramInt += 3;
/*  680 */     } else if (contains(paramString, paramInt, 3, new String[] { "TIA", "TCH" })) {
/*  681 */       paramDoubleMetaphoneResult.append('X');
/*  682 */       paramInt += 3;
/*  683 */     } else if (contains(paramString, paramInt, 2, new String[] { "TH" }) || contains(paramString, paramInt, 3, new String[] { "TTH" })) {
/*  684 */       if (contains(paramString, paramInt + 2, 2, new String[] { "OM", "AM"
/*      */           
/*  686 */           }) || contains(paramString, 0, 4, new String[] { "VAN ", "VON "
/*  687 */           }) || contains(paramString, 0, 3, new String[] { "SCH" })) {
/*  688 */         paramDoubleMetaphoneResult.append('T');
/*      */       } else {
/*  690 */         paramDoubleMetaphoneResult.append('0', 'T');
/*      */       } 
/*  692 */       paramInt += 2;
/*      */     } else {
/*  694 */       paramDoubleMetaphoneResult.append('T');
/*  695 */       paramInt = contains(paramString, paramInt + 1, 1, new String[] { "T", "D" }) ? (paramInt + 2) : (paramInt + 1);
/*      */     } 
/*  697 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleW(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
/*  704 */     if (contains(paramString, paramInt, 2, new String[] { "WR" })) {
/*      */       
/*  706 */       paramDoubleMetaphoneResult.append('R');
/*  707 */       paramInt += 2;
/*      */     }
/*  709 */     else if (paramInt == 0 && (isVowel(charAt(paramString, paramInt + 1)) || 
/*  710 */       contains(paramString, paramInt, 2, new String[] { "WH" }))) {
/*  711 */       if (isVowel(charAt(paramString, paramInt + 1))) {
/*      */         
/*  713 */         paramDoubleMetaphoneResult.append('A', 'F');
/*      */       } else {
/*      */         
/*  716 */         paramDoubleMetaphoneResult.append('A');
/*      */       } 
/*  718 */       paramInt++;
/*  719 */     } else if ((paramInt == paramString.length() - 1 && isVowel(charAt(paramString, paramInt - 1))) || 
/*  720 */       contains(paramString, paramInt - 1, 5, new String[] { "EWSKI", "EWSKY", "OWSKI", "OWSKY"
/*  721 */         }) || contains(paramString, 0, 3, new String[] { "SCH" })) {
/*      */       
/*  723 */       paramDoubleMetaphoneResult.appendAlternate('F');
/*  724 */       paramInt++;
/*  725 */     } else if (contains(paramString, paramInt, 4, new String[] { "WICZ", "WITZ" })) {
/*      */       
/*  727 */       paramDoubleMetaphoneResult.append("TS", "FX");
/*  728 */       paramInt += 4;
/*      */     } else {
/*  730 */       paramInt++;
/*      */     } 
/*      */     
/*  733 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleX(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt) {
/*  740 */     if (paramInt == 0) {
/*  741 */       paramDoubleMetaphoneResult.append('S');
/*  742 */       paramInt++;
/*      */     } else {
/*  744 */       if (paramInt != paramString.length() - 1 || (
/*  745 */         !contains(paramString, paramInt - 3, 3, new String[] { "IAU", "EAU"
/*  746 */           }) && !contains(paramString, paramInt - 2, 2, new String[] { "AU", "OU" })))
/*      */       {
/*  748 */         paramDoubleMetaphoneResult.append("KS");
/*      */       }
/*  750 */       paramInt = contains(paramString, paramInt + 1, 1, new String[] { "C", "X" }) ? (paramInt + 2) : (paramInt + 1);
/*      */     } 
/*  752 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int handleZ(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean) {
/*  760 */     if (charAt(paramString, paramInt + 1) == 'H') {
/*      */       
/*  762 */       paramDoubleMetaphoneResult.append('J');
/*  763 */       paramInt += 2;
/*      */     } else {
/*  765 */       if (contains(paramString, paramInt + 1, 2, new String[] { "ZO", "ZI", "ZA" }) || (paramBoolean && paramInt > 0 && 
/*  766 */         charAt(paramString, paramInt - 1) != 'T')) {
/*  767 */         paramDoubleMetaphoneResult.append("S", "TS");
/*      */       } else {
/*  769 */         paramDoubleMetaphoneResult.append('S');
/*      */       } 
/*  771 */       paramInt = (charAt(paramString, paramInt + 1) == 'Z') ? (paramInt + 2) : (paramInt + 1);
/*      */     } 
/*  773 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean conditionC0(String paramString, int paramInt) {
/*  782 */     if (contains(paramString, paramInt, 4, new String[] { "CHIA" }))
/*  783 */       return true; 
/*  784 */     if (paramInt <= 1)
/*  785 */       return false; 
/*  786 */     if (isVowel(charAt(paramString, paramInt - 2)))
/*  787 */       return false; 
/*  788 */     if (!contains(paramString, paramInt - 1, 3, new String[] { "ACH" })) {
/*  789 */       return false;
/*      */     }
/*  791 */     char c = charAt(paramString, paramInt + 2);
/*  792 */     return ((c != 'I' && c != 'E') || 
/*  793 */       contains(paramString, paramInt - 2, 6, new String[] { "BACHER", "MACHER" }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean conditionCH0(String paramString, int paramInt) {
/*  801 */     if (paramInt != 0)
/*  802 */       return false; 
/*  803 */     if (!contains(paramString, paramInt + 1, 5, new String[] { "HARAC", "HARIS"
/*  804 */         }) && !contains(paramString, paramInt + 1, 3, new String[] { "HOR", "HYM", "HIA", "HEM" }))
/*  805 */       return false; 
/*  806 */     if (contains(paramString, 0, 5, new String[] { "CHORE" })) {
/*  807 */       return false;
/*      */     }
/*  809 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean conditionCH1(String paramString, int paramInt) {
/*  817 */     return (contains(paramString, 0, 4, new String[] { "VAN ", "VON " }) || contains(paramString, 0, 3, new String[] { "SCH"
/*  818 */         }) || contains(paramString, paramInt - 2, 6, new String[] { "ORCHES", "ARCHIT", "ORCHID"
/*  819 */         }) || contains(paramString, paramInt + 2, 1, new String[] { "T", "S"
/*  820 */         }) || ((contains(paramString, paramInt - 1, 1, new String[] { "A", "O", "U", "E" }) || paramInt == 0) && (
/*  821 */       contains(paramString, paramInt + 2, 1, L_R_N_M_B_H_F_V_W_SPACE) || paramInt + 1 == paramString.length() - 1)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean conditionL0(String paramString, int paramInt) {
/*  828 */     if (paramInt == paramString.length() - 3 && 
/*  829 */       contains(paramString, paramInt - 1, 4, new String[] { "ILLO", "ILLA", "ALLE" }))
/*  830 */       return true; 
/*  831 */     if ((contains(paramString, paramString.length() - 2, 2, new String[] { "AS", "OS"
/*  832 */         }) || contains(paramString, paramString.length() - 1, 1, new String[] { "A", "O"
/*  833 */         })) && contains(paramString, paramInt - 1, 4, new String[] { "ALLE" })) {
/*  834 */       return true;
/*      */     }
/*  836 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean conditionM0(String paramString, int paramInt) {
/*  844 */     if (charAt(paramString, paramInt + 1) == 'M') {
/*  845 */       return true;
/*      */     }
/*  847 */     return (contains(paramString, paramInt - 1, 3, new String[] { "UMB" }) && (paramInt + 1 == paramString
/*  848 */       .length() - 1 || contains(paramString, paramInt + 2, 2, new String[] { "ER" })));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSlavoGermanic(String paramString) {
/*  858 */     return (paramString.indexOf('W') > -1 || paramString.indexOf('K') > -1 || paramString
/*  859 */       .indexOf("CZ") > -1 || paramString.indexOf("WITZ") > -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isVowel(char paramChar) {
/*  866 */     return ("AEIOUY".indexOf(paramChar) != -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSilentStart(String paramString) {
/*  875 */     boolean bool = false;
/*  876 */     for (String str : SILENT_START) {
/*  877 */       if (paramString.startsWith(str)) {
/*  878 */         bool = true;
/*      */         break;
/*      */       } 
/*      */     } 
/*  882 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String cleanInput(String paramString) {
/*  889 */     if (paramString == null) {
/*  890 */       return null;
/*      */     }
/*  892 */     paramString = paramString.trim();
/*  893 */     if (paramString.length() == 0) {
/*  894 */       return null;
/*      */     }
/*  896 */     return paramString.toUpperCase(Locale.ENGLISH);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected char charAt(String paramString, int paramInt) {
/*  905 */     if (paramInt < 0 || paramInt >= paramString.length()) {
/*  906 */       return Character.MIN_VALUE;
/*      */     }
/*  908 */     return paramString.charAt(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static boolean contains(String paramString, int paramInt1, int paramInt2, String... paramVarArgs) {
/*  917 */     boolean bool = false;
/*  918 */     if (paramInt1 >= 0 && paramInt1 + paramInt2 <= paramString.length()) {
/*  919 */       String str = paramString.substring(paramInt1, paramInt1 + paramInt2);
/*      */       
/*  921 */       for (String str1 : paramVarArgs) {
/*  922 */         if (str.equals(str1)) {
/*  923 */           bool = true;
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/*  928 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public class DoubleMetaphoneResult
/*      */   {
/*  938 */     private final StringBuilder primary = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());
/*  939 */     private final StringBuilder alternate = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());
/*      */     private final int maxLength;
/*      */     
/*      */     public DoubleMetaphoneResult(int param1Int) {
/*  943 */       this.maxLength = param1Int;
/*      */     }
/*      */     
/*      */     public void append(char param1Char) {
/*  947 */       appendPrimary(param1Char);
/*  948 */       appendAlternate(param1Char);
/*      */     }
/*      */     
/*      */     public void append(char param1Char1, char param1Char2) {
/*  952 */       appendPrimary(param1Char1);
/*  953 */       appendAlternate(param1Char2);
/*      */     }
/*      */     
/*      */     public void appendPrimary(char param1Char) {
/*  957 */       if (this.primary.length() < this.maxLength) {
/*  958 */         this.primary.append(param1Char);
/*      */       }
/*      */     }
/*      */     
/*      */     public void appendAlternate(char param1Char) {
/*  963 */       if (this.alternate.length() < this.maxLength) {
/*  964 */         this.alternate.append(param1Char);
/*      */       }
/*      */     }
/*      */     
/*      */     public void append(String param1String) {
/*  969 */       appendPrimary(param1String);
/*  970 */       appendAlternate(param1String);
/*      */     }
/*      */     
/*      */     public void append(String param1String1, String param1String2) {
/*  974 */       appendPrimary(param1String1);
/*  975 */       appendAlternate(param1String2);
/*      */     }
/*      */     
/*      */     public void appendPrimary(String param1String) {
/*  979 */       int i = this.maxLength - this.primary.length();
/*  980 */       if (param1String.length() <= i) {
/*  981 */         this.primary.append(param1String);
/*      */       } else {
/*  983 */         this.primary.append(param1String.substring(0, i));
/*      */       } 
/*      */     }
/*      */     
/*      */     public void appendAlternate(String param1String) {
/*  988 */       int i = this.maxLength - this.alternate.length();
/*  989 */       if (param1String.length() <= i) {
/*  990 */         this.alternate.append(param1String);
/*      */       } else {
/*  992 */         this.alternate.append(param1String.substring(0, i));
/*      */       } 
/*      */     }
/*      */     
/*      */     public String getPrimary() {
/*  997 */       return this.primary.toString();
/*      */     }
/*      */     
/*      */     public String getAlternate() {
/* 1001 */       return this.alternate.toString();
/*      */     }
/*      */     
/*      */     public boolean isComplete() {
/* 1005 */       return (this.primary.length() >= this.maxLength && this.alternate
/* 1006 */         .length() >= this.maxLength);
/*      */     }
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/DoubleMetaphone.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */