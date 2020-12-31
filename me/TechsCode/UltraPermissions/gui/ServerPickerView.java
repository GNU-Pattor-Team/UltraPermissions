/*    */ package me.TechsCode.UltraPermissions.gui;
/*    */ 
/*    */ import java.util.Optional;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.BasicSearch;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.PageableGUI;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.SearchFeature;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.networking.NPlayer;
/*    */ import me.TechsCode.UltraPermissions.base.networking.NServer;
/*    */ import me.TechsCode.UltraPermissions.base.networking.NetworkData;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Words;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class ServerPickerView extends PageableGUI<NServer> {
/*    */   private final UltraPermissions plugin;
/*    */   
/*    */   public ServerPickerView(Player paramPlayer, UltraPermissions paramUltraPermissions) {
/* 26 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*    */     
/* 28 */     this.plugin = paramUltraPermissions;
/* 29 */     this.thisServer = paramUltraPermissions.getThisServer().orElse(null);
/*    */   }
/*    */ 
/*    */   
/*    */   private final NServer thisServer;
/*    */   
/*    */   public SearchFeature<NServer> getSearch() {
/* 36 */     return (SearchFeature<NServer>)new BasicSearch<NServer>()
/*    */       {
/*    */         public String[] getSearchableText(NServer param1NServer) {
/* 39 */           return new String[] { param1NServer.getName() };
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   public NServer[] getObjects() {
/* 46 */     Optional optional = this.plugin.getNetworkManager().getData();
/* 47 */     return optional.map(paramNetworkData -> (NServer[])paramNetworkData.getServerList().toArray((Object[])new NServer[0])).orElseGet(() -> new NServer[0]);
/*    */   }
/*    */   
/* 50 */   private static final Phrase ENTRY_ACTION = Phrase.create("serverPickerView.entry.action", "Click to select", Colors.GRAY, new Color[0]);
/* 51 */   private static final Phrase ENTRY_CURRENT_INDICATOR = Phrase.create("serverPickerView.entry.currentIndicator", "You are currently on this Server", Colors.GREEN, new Color[0]);
/* 52 */   private static final Phrase ENTRY_ADDRESS_ATTRIBUTE = Phrase.create("serverPickerView.entry.addressAttribute", "Address: **%ip%**:**%port%**", Colors.GRAY, new Color[] { Colors.YELLOW, Colors.YELLOW });
/* 53 */   private static final Phrase ENTRY_ADDRESS_ONLINE_PLAYERS_TITLE = Phrase.create("serverPickerView.entry.onlinePlayers.title", "Online Players:", Colors.GRAY, new Color[0]);
/* 54 */   private static final Phrase ENTRY_ADDRESS_ONLINE_PLAYERS_ENTRY = Phrase.create("serverPickerView.entry.onlinePlayers.entry", "- **%player%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*    */ 
/*    */   
/*    */   public void construct(Button paramButton, NServer paramNServer) {
/* 58 */     boolean bool = (this.thisServer != null && this.thisServer.getName().equals(paramNServer.getName())) ? true : false;
/*    */     
/* 60 */     paramButton.material(XMaterial.BLUE_STAINED_GLASS)
/* 61 */       .name(Animation.wave(paramNServer.getName(), new Color[] { Colors.DarkBlue, Colors.WHITE
/* 62 */           })).lore(new String[] {
/* 63 */           ENTRY_ACTION.get()
/*    */         });
/*    */     
/* 66 */     if (bool) {
/* 67 */       paramButton.item().appendLore(new String[] { "", ENTRY_CURRENT_INDICATOR.get() });
/*    */     }
/*    */     
/* 70 */     paramButton.item().appendLore(new String[] { "", ENTRY_ADDRESS_ATTRIBUTE
/*    */           
/* 72 */           .get().replace("%ip%", paramNServer.getIp()).replace("%port%", Integer.toString(paramNServer.getPort())), "", ENTRY_ADDRESS_ONLINE_PLAYERS_TITLE
/*    */           
/* 74 */           .get() });
/*    */ 
/*    */     
/* 77 */     for (NPlayer nPlayer : paramNServer.getPlayers()) {
/* 78 */       paramButton.item().appendLore(new String[] { ENTRY_ADDRESS_ONLINE_PLAYERS_ENTRY.get().replace("%player%", nPlayer.getName()) });
/*    */     } 
/*    */     
/* 81 */     if (paramNServer.getPlayers().isEmpty()) {
/* 82 */       paramButton.item().appendLore(new String[] { Colors.RED + Words.NONE.get() });
/*    */     }
/*    */     
/* 85 */     paramButton.action(paramActionType -> onSelect(paramNServer));
/*    */   }
/*    */   
/*    */   public abstract void onSelect(NServer paramNServer);
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/ServerPickerView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */