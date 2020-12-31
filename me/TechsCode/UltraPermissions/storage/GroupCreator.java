/*    */ package me.TechsCode.UltraPermissions.storage;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storable;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GroupCreator
/*    */ {
/*    */   private final GroupStorage storage;
/*    */   private final String name;
/*    */   private int id;
/*    */   private String server;
/*    */   private String world;
/*    */   private String prefix;
/*    */   private String suffix;
/*    */   private boolean default_;
/* 21 */   private int priority = 1;
/* 22 */   private XMaterial icon = XMaterial.YELLOW_STAINED_GLASS_PANE;
/*    */   
/*    */   public GroupCreator(GroupStorage paramGroupStorage, String paramString) {
/* 25 */     this.storage = paramGroupStorage;
/* 26 */     this.name = paramString;
/*    */   }
/*    */   
/*    */   public GroupCreator setDefault(boolean paramBoolean) {
/* 30 */     this.default_ = paramBoolean;
/* 31 */     return this;
/*    */   }
/*    */   
/*    */   public GroupCreator setServer(String paramString) {
/* 35 */     this.server = paramString;
/* 36 */     return this;
/*    */   }
/*    */   
/*    */   public GroupCreator setWorld(String paramString) {
/* 40 */     this.world = paramString;
/* 41 */     return this;
/*    */   }
/*    */   
/*    */   public GroupCreator setPrefix(String paramString) {
/* 45 */     this.prefix = paramString;
/* 46 */     return this;
/*    */   }
/*    */   
/*    */   public GroupCreator setSuffix(String paramString) {
/* 50 */     this.suffix = paramString;
/* 51 */     return this;
/*    */   }
/*    */   
/*    */   public GroupCreator id(int paramInt) {
/* 55 */     this.id = paramInt;
/* 56 */     return this;
/*    */   }
/*    */   
/*    */   public GroupCreator setPriority(int paramInt) {
/* 60 */     this.priority = paramInt;
/* 61 */     return this;
/*    */   }
/*    */   
/*    */   public GroupCreator setIcon(XMaterial paramXMaterial) {
/* 65 */     this.icon = paramXMaterial;
/* 66 */     return this;
/*    */   }
/*    */   
/*    */   public Group create() {
/* 70 */     return (Group)this.storage.create((Storable)new Group((this.id == 0) ? this.storage.getNextNumericId() : this.id, this.name, this.world, this.server, this.priority, new HashSet(), this.default_, this.prefix, this.suffix, this.icon.name()));
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/GroupCreator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */