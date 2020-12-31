/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.StringWriter;
/*      */ import java.io.Writer;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.TreeMap;
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
/*      */ class Entities
/*      */ {
/*   45 */   private static final String[][] BASIC_ARRAY = new String[][] { { "quot", "34" }, { "amp", "38" }, { "lt", "60" }, { "gt", "62" } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   51 */   private static final String[][] APOS_ARRAY = new String[][] { { "apos", "39" } };
/*      */ 
/*      */ 
/*      */   
/*   55 */   static final String[][] ISO8859_1_ARRAY = new String[][] { { "nbsp", "160" }, { "iexcl", "161" }, { "cent", "162" }, { "pound", "163" }, { "curren", "164" }, { "yen", "165" }, { "brvbar", "166" }, { "sect", "167" }, { "uml", "168" }, { "copy", "169" }, { "ordf", "170" }, { "laquo", "171" }, { "not", "172" }, { "shy", "173" }, { "reg", "174" }, { "macr", "175" }, { "deg", "176" }, { "plusmn", "177" }, { "sup2", "178" }, { "sup3", "179" }, { "acute", "180" }, { "micro", "181" }, { "para", "182" }, { "middot", "183" }, { "cedil", "184" }, { "sup1", "185" }, { "ordm", "186" }, { "raquo", "187" }, { "frac14", "188" }, { "frac12", "189" }, { "frac34", "190" }, { "iquest", "191" }, { "Agrave", "192" }, { "Aacute", "193" }, { "Acirc", "194" }, { "Atilde", "195" }, { "Auml", "196" }, { "Aring", "197" }, { "AElig", "198" }, { "Ccedil", "199" }, { "Egrave", "200" }, { "Eacute", "201" }, { "Ecirc", "202" }, { "Euml", "203" }, { "Igrave", "204" }, { "Iacute", "205" }, { "Icirc", "206" }, { "Iuml", "207" }, { "ETH", "208" }, { "Ntilde", "209" }, { "Ograve", "210" }, { "Oacute", "211" }, { "Ocirc", "212" }, { "Otilde", "213" }, { "Ouml", "214" }, { "times", "215" }, { "Oslash", "216" }, { "Ugrave", "217" }, { "Uacute", "218" }, { "Ucirc", "219" }, { "Uuml", "220" }, { "Yacute", "221" }, { "THORN", "222" }, { "szlig", "223" }, { "agrave", "224" }, { "aacute", "225" }, { "acirc", "226" }, { "atilde", "227" }, { "auml", "228" }, { "aring", "229" }, { "aelig", "230" }, { "ccedil", "231" }, { "egrave", "232" }, { "eacute", "233" }, { "ecirc", "234" }, { "euml", "235" }, { "igrave", "236" }, { "iacute", "237" }, { "icirc", "238" }, { "iuml", "239" }, { "eth", "240" }, { "ntilde", "241" }, { "ograve", "242" }, { "oacute", "243" }, { "ocirc", "244" }, { "otilde", "245" }, { "ouml", "246" }, { "divide", "247" }, { "oslash", "248" }, { "ugrave", "249" }, { "uacute", "250" }, { "ucirc", "251" }, { "uuml", "252" }, { "yacute", "253" }, { "thorn", "254" }, { "yuml", "255" } };
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
/*  155 */   static final String[][] HTML40_ARRAY = new String[][] { { "fnof", "402" }, { "Alpha", "913" }, { "Beta", "914" }, { "Gamma", "915" }, { "Delta", "916" }, { "Epsilon", "917" }, { "Zeta", "918" }, { "Eta", "919" }, { "Theta", "920" }, { "Iota", "921" }, { "Kappa", "922" }, { "Lambda", "923" }, { "Mu", "924" }, { "Nu", "925" }, { "Xi", "926" }, { "Omicron", "927" }, { "Pi", "928" }, { "Rho", "929" }, { "Sigma", "931" }, { "Tau", "932" }, { "Upsilon", "933" }, { "Phi", "934" }, { "Chi", "935" }, { "Psi", "936" }, { "Omega", "937" }, { "alpha", "945" }, { "beta", "946" }, { "gamma", "947" }, { "delta", "948" }, { "epsilon", "949" }, { "zeta", "950" }, { "eta", "951" }, { "theta", "952" }, { "iota", "953" }, { "kappa", "954" }, { "lambda", "955" }, { "mu", "956" }, { "nu", "957" }, { "xi", "958" }, { "omicron", "959" }, { "pi", "960" }, { "rho", "961" }, { "sigmaf", "962" }, { "sigma", "963" }, { "tau", "964" }, { "upsilon", "965" }, { "phi", "966" }, { "chi", "967" }, { "psi", "968" }, { "omega", "969" }, { "thetasym", "977" }, { "upsih", "978" }, { "piv", "982" }, { "bull", "8226" }, { "hellip", "8230" }, { "prime", "8242" }, { "Prime", "8243" }, { "oline", "8254" }, { "frasl", "8260" }, { "weierp", "8472" }, { "image", "8465" }, { "real", "8476" }, { "trade", "8482" }, { "alefsym", "8501" }, { "larr", "8592" }, { "uarr", "8593" }, { "rarr", "8594" }, { "darr", "8595" }, { "harr", "8596" }, { "crarr", "8629" }, { "lArr", "8656" }, { "uArr", "8657" }, { "rArr", "8658" }, { "dArr", "8659" }, { "hArr", "8660" }, { "forall", "8704" }, { "part", "8706" }, { "exist", "8707" }, { "empty", "8709" }, { "nabla", "8711" }, { "isin", "8712" }, { "notin", "8713" }, { "ni", "8715" }, { "prod", "8719" }, { "sum", "8721" }, { "minus", "8722" }, { "lowast", "8727" }, { "radic", "8730" }, { "prop", "8733" }, { "infin", "8734" }, { "ang", "8736" }, { "and", "8743" }, { "or", "8744" }, { "cap", "8745" }, { "cup", "8746" }, { "int", "8747" }, { "there4", "8756" }, { "sim", "8764" }, { "cong", "8773" }, { "asymp", "8776" }, { "ne", "8800" }, { "equiv", "8801" }, { "le", "8804" }, { "ge", "8805" }, { "sub", "8834" }, { "sup", "8835" }, { "sube", "8838" }, { "supe", "8839" }, { "oplus", "8853" }, { "otimes", "8855" }, { "perp", "8869" }, { "sdot", "8901" }, { "lceil", "8968" }, { "rceil", "8969" }, { "lfloor", "8970" }, { "rfloor", "8971" }, { "lang", "9001" }, { "rang", "9002" }, { "loz", "9674" }, { "spades", "9824" }, { "clubs", "9827" }, { "hearts", "9829" }, { "diams", "9830" }, { "OElig", "338" }, { "oelig", "339" }, { "Scaron", "352" }, { "scaron", "353" }, { "Yuml", "376" }, { "circ", "710" }, { "tilde", "732" }, { "ensp", "8194" }, { "emsp", "8195" }, { "thinsp", "8201" }, { "zwnj", "8204" }, { "zwj", "8205" }, { "lrm", "8206" }, { "rlm", "8207" }, { "ndash", "8211" }, { "mdash", "8212" }, { "lsquo", "8216" }, { "rsquo", "8217" }, { "sbquo", "8218" }, { "ldquo", "8220" }, { "rdquo", "8221" }, { "bdquo", "8222" }, { "dagger", "8224" }, { "Dagger", "8225" }, { "permil", "8240" }, { "lsaquo", "8249" }, { "rsaquo", "8250" }, { "euro", "8364" } };
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final Entities XML;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final Entities HTML32;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final Entities HTML40;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final EntityMap map;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*  374 */     Entities entities = new Entities();
/*  375 */     entities.addEntities(BASIC_ARRAY);
/*  376 */     entities.addEntities(APOS_ARRAY);
/*  377 */     XML = entities;
/*      */ 
/*      */ 
/*      */     
/*  381 */     entities = new Entities();
/*  382 */     entities.addEntities(BASIC_ARRAY);
/*  383 */     entities.addEntities(ISO8859_1_ARRAY);
/*  384 */     HTML32 = entities;
/*      */ 
/*      */ 
/*      */     
/*  388 */     entities = new Entities();
/*  389 */     fillWithHtml40Entities(entities);
/*  390 */     HTML40 = entities;
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
/*      */   static void fillWithHtml40Entities(Entities paramEntities) {
/*  402 */     paramEntities.addEntities(BASIC_ARRAY);
/*  403 */     paramEntities.addEntities(ISO8859_1_ARRAY);
/*  404 */     paramEntities.addEntities(HTML40_ARRAY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static interface EntityMap
/*      */   {
/*      */     void add(String param1String, int param1Int);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     String name(int param1Int);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int value(String param1String);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class PrimitiveEntityMap
/*      */     implements EntityMap
/*      */   {
/*  444 */     private final Map mapNameToValue = new HashMap();
/*      */     
/*  446 */     private final IntHashMap mapValueToName = new IntHashMap();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void add(String param1String, int param1Int) {
/*  453 */       this.mapNameToValue.put(param1String, new Integer(param1Int));
/*  454 */       this.mapValueToName.put(param1Int, param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String name(int param1Int) {
/*  461 */       return (String)this.mapValueToName.get(param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int value(String param1String) {
/*  468 */       Object object = this.mapNameToValue.get(param1String);
/*  469 */       if (object == null) {
/*  470 */         return -1;
/*      */       }
/*  472 */       return ((Integer)object).intValue();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static abstract class MapIntMap
/*      */     implements EntityMap
/*      */   {
/*      */     protected final Map mapNameToValue;
/*      */ 
/*      */     
/*      */     protected final Map mapValueToName;
/*      */ 
/*      */     
/*      */     MapIntMap(Map param1Map1, Map param1Map2) {
/*  488 */       this.mapNameToValue = param1Map1;
/*  489 */       this.mapValueToName = param1Map2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void add(String param1String, int param1Int) {
/*  496 */       this.mapNameToValue.put(param1String, new Integer(param1Int));
/*  497 */       this.mapValueToName.put(new Integer(param1Int), param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String name(int param1Int) {
/*  504 */       return (String)this.mapValueToName.get(new Integer(param1Int));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int value(String param1String) {
/*  511 */       Object object = this.mapNameToValue.get(param1String);
/*  512 */       if (object == null) {
/*  513 */         return -1;
/*      */       }
/*  515 */       return ((Integer)object).intValue();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static class HashEntityMap
/*      */     extends MapIntMap
/*      */   {
/*      */     public HashEntityMap() {
/*  524 */       super(new HashMap(), new HashMap());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static class TreeEntityMap
/*      */     extends MapIntMap
/*      */   {
/*      */     public TreeEntityMap() {
/*  533 */       super(new TreeMap(), new TreeMap());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static class LookupEntityMap
/*      */     extends PrimitiveEntityMap
/*      */   {
/*      */     private String[] lookupTable;
/*      */     
/*      */     private static final int LOOKUP_TABLE_SIZE = 256;
/*      */ 
/*      */     
/*      */     public String name(int param1Int) {
/*  547 */       if (param1Int < 256) {
/*  548 */         return lookupTable()[param1Int];
/*      */       }
/*  550 */       return super.name(param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private String[] lookupTable() {
/*  561 */       if (this.lookupTable == null) {
/*  562 */         createLookupTable();
/*      */       }
/*  564 */       return this.lookupTable;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void createLookupTable() {
/*  573 */       this.lookupTable = new String[256];
/*  574 */       for (byte b = 0; b < 'Ā'; b++) {
/*  575 */         this.lookupTable[b] = super.name(b);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static class ArrayEntityMap
/*      */     implements EntityMap
/*      */   {
/*      */     protected final int growBy;
/*  584 */     protected int size = 0;
/*      */ 
/*      */     
/*      */     protected String[] names;
/*      */ 
/*      */     
/*      */     protected int[] values;
/*      */ 
/*      */     
/*      */     public ArrayEntityMap() {
/*  594 */       this.growBy = 100;
/*  595 */       this.names = new String[this.growBy];
/*  596 */       this.values = new int[this.growBy];
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ArrayEntityMap(int param1Int) {
/*  607 */       this.growBy = param1Int;
/*  608 */       this.names = new String[param1Int];
/*  609 */       this.values = new int[param1Int];
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void add(String param1String, int param1Int) {
/*  616 */       ensureCapacity(this.size + 1);
/*  617 */       this.names[this.size] = param1String;
/*  618 */       this.values[this.size] = param1Int;
/*  619 */       this.size++;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void ensureCapacity(int param1Int) {
/*  629 */       if (param1Int > this.names.length) {
/*  630 */         int i = Math.max(param1Int, this.size + this.growBy);
/*  631 */         String[] arrayOfString = new String[i];
/*  632 */         System.arraycopy(this.names, 0, arrayOfString, 0, this.size);
/*  633 */         this.names = arrayOfString;
/*  634 */         int[] arrayOfInt = new int[i];
/*  635 */         System.arraycopy(this.values, 0, arrayOfInt, 0, this.size);
/*  636 */         this.values = arrayOfInt;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String name(int param1Int) {
/*  644 */       for (byte b = 0; b < this.size; b++) {
/*  645 */         if (this.values[b] == param1Int) {
/*  646 */           return this.names[b];
/*      */         }
/*      */       } 
/*  649 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int value(String param1String) {
/*  656 */       for (byte b = 0; b < this.size; b++) {
/*  657 */         if (this.names[b].equals(param1String)) {
/*  658 */           return this.values[b];
/*      */         }
/*      */       } 
/*  661 */       return -1;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class BinaryEntityMap
/*      */     extends ArrayEntityMap
/*      */   {
/*      */     public BinaryEntityMap() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public BinaryEntityMap(int param1Int) {
/*  684 */       super(param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int binarySearch(int param1Int) {
/*  696 */       int i = 0;
/*  697 */       int j = this.size - 1;
/*      */       
/*  699 */       while (i <= j) {
/*  700 */         int k = i + j >>> 1;
/*  701 */         int m = this.values[k];
/*      */         
/*  703 */         if (m < param1Int) {
/*  704 */           i = k + 1; continue;
/*  705 */         }  if (m > param1Int) {
/*  706 */           j = k - 1; continue;
/*      */         } 
/*  708 */         return k;
/*      */       } 
/*      */       
/*  711 */       return -(i + 1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void add(String param1String, int param1Int) {
/*  718 */       ensureCapacity(this.size + 1);
/*  719 */       int i = binarySearch(param1Int);
/*  720 */       if (i > 0) {
/*      */         return;
/*      */       }
/*  723 */       i = -(i + 1);
/*  724 */       System.arraycopy(this.values, i, this.values, i + 1, this.size - i);
/*  725 */       this.values[i] = param1Int;
/*  726 */       System.arraycopy(this.names, i, this.names, i + 1, this.size - i);
/*  727 */       this.names[i] = param1String;
/*  728 */       this.size++;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String name(int param1Int) {
/*  735 */       int i = binarySearch(param1Int);
/*  736 */       if (i < 0) {
/*  737 */         return null;
/*      */       }
/*  739 */       return this.names[i];
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Entities() {
/*  749 */     this.map = new LookupEntityMap();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Entities(EntityMap paramEntityMap) {
/*  758 */     this.map = paramEntityMap;
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
/*      */   public void addEntities(String[][] paramArrayOfString) {
/*  770 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*  771 */       addEntity(paramArrayOfString[b][0], Integer.parseInt(paramArrayOfString[b][1]));
/*      */     }
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
/*      */   public void addEntity(String paramString, int paramInt) {
/*  786 */     this.map.add(paramString, paramInt);
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
/*      */   public String entityName(int paramInt) {
/*  799 */     return this.map.name(paramInt);
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
/*      */   public int entityValue(String paramString) {
/*  812 */     return this.map.value(paramString);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String escape(String paramString) {
/*  830 */     StringWriter stringWriter = createStringWriter(paramString);
/*      */     try {
/*  832 */       escape(stringWriter, paramString);
/*  833 */     } catch (IOException iOException) {
/*      */ 
/*      */       
/*  836 */       throw new UnhandledException(iOException);
/*      */     } 
/*  838 */     return stringWriter.toString();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void escape(Writer paramWriter, String paramString) {
/*  859 */     int i = paramString.length();
/*  860 */     for (byte b = 0; b < i; b++) {
/*  861 */       char c = paramString.charAt(b);
/*  862 */       String str = entityName(c);
/*  863 */       if (str == null) {
/*  864 */         if (c > '') {
/*  865 */           paramWriter.write("&#");
/*  866 */           paramWriter.write(Integer.toString(c, 10));
/*  867 */           paramWriter.write(59);
/*      */         } else {
/*  869 */           paramWriter.write(c);
/*      */         } 
/*      */       } else {
/*  872 */         paramWriter.write(38);
/*  873 */         paramWriter.write(str);
/*  874 */         paramWriter.write(59);
/*      */       } 
/*      */     } 
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String unescape(String paramString) {
/*  894 */     int i = paramString.indexOf('&');
/*  895 */     if (i < 0) {
/*  896 */       return paramString;
/*      */     }
/*  898 */     StringWriter stringWriter = createStringWriter(paramString);
/*      */     try {
/*  900 */       doUnescape(stringWriter, paramString, i);
/*  901 */     } catch (IOException iOException) {
/*      */ 
/*      */       
/*  904 */       throw new UnhandledException(iOException);
/*      */     } 
/*  906 */     return stringWriter.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private StringWriter createStringWriter(String paramString) {
/*  917 */     return new StringWriter((int)(paramString.length() + paramString.length() * 0.1D));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unescape(Writer paramWriter, String paramString) {
/*  938 */     int i = paramString.indexOf('&');
/*  939 */     if (i < 0) {
/*  940 */       paramWriter.write(paramString);
/*      */       return;
/*      */     } 
/*  943 */     doUnescape(paramWriter, paramString, i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void doUnescape(Writer paramWriter, String paramString, int paramInt) {
/*  961 */     paramWriter.write(paramString, 0, paramInt);
/*  962 */     int i = paramString.length();
/*  963 */     for (int j = paramInt; j < i; j++) {
/*  964 */       char c = paramString.charAt(j);
/*  965 */       if (c == '&')
/*  966 */       { int k = j + 1;
/*  967 */         int m = paramString.indexOf(';', k);
/*  968 */         if (m == -1) {
/*  969 */           paramWriter.write(c);
/*      */         } else {
/*      */           
/*  972 */           int n = paramString.indexOf('&', j + 1);
/*  973 */           if (n != -1 && n < m)
/*      */           
/*  975 */           { paramWriter.write(c); }
/*      */           else
/*      */           
/*  978 */           { String str = paramString.substring(k, m);
/*  979 */             int i1 = -1;
/*  980 */             int i2 = str.length();
/*  981 */             if (i2 > 0) {
/*  982 */               if (str.charAt(0) == '#') {
/*      */                 
/*  984 */                 if (i2 > 1) {
/*  985 */                   char c1 = str.charAt(1);
/*      */                   try {
/*  987 */                     switch (c1) {
/*      */                       case 'X':
/*      */                       case 'x':
/*  990 */                         i1 = Integer.parseInt(str.substring(2), 16);
/*      */                         break;
/*      */                       
/*      */                       default:
/*  994 */                         i1 = Integer.parseInt(str.substring(1), 10);
/*      */                         break;
/*      */                     } 
/*  997 */                     if (i1 > 65535) {
/*  998 */                       i1 = -1;
/*      */                     }
/* 1000 */                   } catch (NumberFormatException numberFormatException) {
/* 1001 */                     i1 = -1;
/*      */                   } 
/*      */                 } 
/*      */               } else {
/* 1005 */                 i1 = entityValue(str);
/*      */               } 
/*      */             }
/*      */             
/* 1009 */             if (i1 == -1) {
/* 1010 */               paramWriter.write(38);
/* 1011 */               paramWriter.write(str);
/* 1012 */               paramWriter.write(59);
/*      */             } else {
/* 1014 */               paramWriter.write(i1);
/*      */             } 
/* 1016 */             j = m; } 
/*      */         }  }
/* 1018 */       else { paramWriter.write(c); }
/*      */     
/*      */     } 
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/Entities.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */