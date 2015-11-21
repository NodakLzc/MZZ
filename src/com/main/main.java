package com.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffect;

public class main extends JavaPlugin implements Listener{
	 public void onLoad() {
		    this.saveDefaultConfig();
		    System.out.println("[" + getName() + "]" + " " + "加载成功");
		  }

		  public void onEnable() {
		    getServer().getPluginManager().registerEvents(this, this);
		    System.out.println("[" + getName() + "]" + " " + "开启成功");
		  }

		  public void onDisable() {
		    System.out.println("[" + getName() + "]" + " " + "关闭成功");
		  }
	@EventHandler
	  public void onPlayerChat(AsyncPlayerChatEvent e) {
	    Player p = e.getPlayer();
	    String msg = e.getMessage();
	    for (String s:this.getConfig().getStringList("ZY")){
	    		if (msg.length()==s.length() & msg.equalsIgnoreCase(s)){
	    			for (String msg2:this.getConfig().getStringList(s)){
	    					if (msg2.startsWith("effect")){
	    						int i=msg2.indexOf(" ",0);
	    						int x=msg2.indexOf(" ",i+1);
	    						int x1=msg2.indexOf(" ",x+1);
	    						String point=msg2.substring(i+1,x);
	    						String n = msg2.substring(x+1,x1);
	    						String nn = msg2.substring(x1+1,msg2.length());
	    						p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(point), Integer.parseInt(n)*20, Integer.parseInt(nn)-1));
	    					}
	    					if (msg2.startsWith("msgall")){
	    						int i=msg2.indexOf(" ",0);
	    						String ma=msg2.substring(i+1,msg2.length()).replace("&","§").replace("<player>",p.getName());
	    						Bukkit.broadcastMessage(ma);
	    					}else{
	    					if (msg2.startsWith("msg")){
	    						int i=msg2.indexOf(" ",0);
	    						String ma=msg2.substring(i+1,msg2.length()).replace("&","§").replace("<player>",p.getName());
	    						p.sendMessage(ma);
	    					}
	    					}
	    					if (msg2.startsWith("exptake")){
	    						int i=msg2.indexOf(" ",0);	
	    						int d = 0;
	    						Boolean pp = false;
	    						String exp="";
	    						String mmsg="";
	    						if (msg2.indexOf(" ",i+1)>0){
	    							d=msg2.indexOf(" ",i+1);
	    							pp=true;
	    						}
	    						if (pp==true) {
	    							mmsg=msg2.substring(d+1,msg2.length()).replace("&","§");
	    							exp=msg2.substring(i+1,d);
	    						}
	    						else {
	    				     	exp=msg2.substring(i+1,msg2.length());}
	    				     	if (p.getLevel()>=Integer.parseInt(exp)){
	    				     		p.setLevel(p.getLevel()-Integer.parseInt(exp));
	    				     	}
	    				     	else {
	    				     		if (pp==true) p.sendMessage(mmsg);
	    				     		break;
	    				     	}
	    				     	 p.getWorld().spawnEntity(p.getLocation(), EntityType.PIG);
	    					}
	    					if (msg2.startsWith("expgive")){
	    						int i=msg2.indexOf(" ",0);
	    						String mmsg=msg2.substring(i+1,msg2.length());
	    						p.giveExp(Integer.parseInt(mmsg));
	    					}
	    					if (msg2.startsWith("cmd")){
	    						int i=msg2.indexOf("'",0);
	    						int j=msg2.indexOf("'",i+1);
	    						String cmd=msg2.substring(i+1,j);
	    						p.chat("/"+cmd);
	    					}
	    					if (msg2.startsWith("permission")){
	    						int i=msg2.indexOf(" ",0);
	    						String Permission=msg2.substring(i+1,msg2.length());
	    						if (!p.hasPermission(Permission)) break;
	    					}
	    					if (msg2.startsWith("explset")){
	    						int i=msg2.indexOf(" ",0);
	    						String exp=msg2.substring(i+1,msg2.length());
	    						p.setLevel(Integer.parseInt(exp));
	    					}
	    					if (msg2.startsWith("spawn")){
	    						int i=msg2.indexOf(" ",0);
	    						String s1=msg2.substring(i+1,msg2.length());
	    						EntityType mob = null;
	    						if (s1.equalsIgnoreCase("CHICKEN"))  mob=EntityType.CHICKEN;
	    						if (s1.equalsIgnoreCase("COW")) mob=EntityType.COW; 
	    						if (s1.equalsIgnoreCase("CREEPER")) mob=EntityType.CREEPER;
	    						if (s1.equalsIgnoreCase("GHAST")) mob=EntityType.GHAST;
	    						if (s1.equalsIgnoreCase("GIANT")) mob=EntityType.GIANT;
	    						if (s1.equalsIgnoreCase("HORSE")) mob=EntityType.HORSE;
	    						if (s1.equalsIgnoreCase("PIG")) mob=EntityType.PIG;
	    						if (s1.equalsIgnoreCase("PIGZOMB")) mob=EntityType.PIG_ZOMBIE;
	    						if (s1.equalsIgnoreCase("SHEEP")) mob=EntityType.SHEEP;
	    						if (s1.equalsIgnoreCase("SKELETON")) mob=EntityType.SKELETON;
	    						if (s1.equalsIgnoreCase("SLIME")) mob=EntityType.SLIME;
	    						if (s1.equalsIgnoreCase("SPIDER")) mob=EntityType.SPIDER;
	    						if (s1.equalsIgnoreCase("SQUID")) mob=EntityType.SQUID;
	    						if (s1.equalsIgnoreCase("ZOMBIE")) mob=EntityType.ZOMBIE;
	    						if (s1.equalsIgnoreCase("WOLF")) mob=EntityType.WOLF;
	    						if (s1.equalsIgnoreCase("CAVESPIDER")) mob=EntityType.CAVE_SPIDER;
	    						if (s1.equalsIgnoreCase("ENDERMAN")) mob=EntityType.ENDERMAN;
	    						if (s1.equalsIgnoreCase("SILVERFISH")) mob=EntityType.SILVERFISH;
	    						if (s1.equalsIgnoreCase("ENDERDRAGON")) mob=EntityType.ENDER_DRAGON;
	    						if (s1.equalsIgnoreCase("VILLAGER")) mob=EntityType.VILLAGER;
	    						if (s1.equalsIgnoreCase("BLAZE")) mob=EntityType.BLAZE;
	    						if (s1.equalsIgnoreCase("MUSHROOMCOW")) mob=EntityType.MUSHROOM_COW;
	    						if (s1.equalsIgnoreCase("MAGMACUBE")) mob=EntityType.MAGMA_CUBE;
	    						if (s1.equalsIgnoreCase("SNOWMAN")) mob=EntityType.SNOWMAN;
	    					    if (s1.equalsIgnoreCase("OCELOT")) mob=EntityType.OCELOT;
	    						if (s1.equalsIgnoreCase("IRONGOLEM")) mob=EntityType.IRON_GOLEM;
	    						if (s1.equalsIgnoreCase("WITHER")) mob=EntityType.WITHER;
	    						if (s1.equalsIgnoreCase("BAT")) mob=EntityType.BAT;
	    						if (s1.equalsIgnoreCase("WITCH")) mob=EntityType.WITCH;
	    						if (s1.equalsIgnoreCase("BOAT")) mob=EntityType.BOAT;
	    						if (s1.equalsIgnoreCase("MINECART")) mob=EntityType.MINECART;
	    						if (s1.equalsIgnoreCase("MINECART_CHEST")) mob=EntityType.MINECART_CHEST;
	    						if (s1.equalsIgnoreCase("MINECART_FURNACE")) mob=EntityType.MINECART_FURNACE;
	    						if (s1.equalsIgnoreCase("MINECART_TNT")) mob=EntityType.MINECART_TNT;
	    						if (s1.equalsIgnoreCase("MINECART_HOPPER")) mob=EntityType.MINECART_HOPPER;
	    						if (s1.equalsIgnoreCase("MINECART_MOB_SPAWNER")) mob=EntityType.MINECART_MOB_SPAWNER;
	    						if (s1.equalsIgnoreCase("ENDERCRYSTAL")) mob=EntityType.ENDER_CRYSTAL;
	    						if (s1.equalsIgnoreCase("EXPERIENCEORB")) mob=EntityType.EXPERIENCE_ORB;
	    						p.getWorld().spawnEntity(p.getLocation(), mob);
	    					}
	    			}
	    		}
	    	}
	    }
	public boolean onCommand(CommandSender sender,Command cmd,String lable,String args[]){
		if (cmd.getName().equalsIgnoreCase("zyreload") & sender.isOp()){
			this.reloadConfig();
			sender.sendMessage("§a已重载");
		}
		return false;
	}
//	backup
//	if (s1.equalsIgnoreCase("CHICKEN"))  p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.CHICKEN);
//	if (s1.equalsIgnoreCase("COW")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.COW); 
//	if (s1.equalsIgnoreCase("CREEPER")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.CREEPER);
//	if (s1.equalsIgnoreCase("GHAST")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.GHAST);
//	if (s1.equalsIgnoreCase("GIANT")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.GIANT);
//	if (s1.equalsIgnoreCase("HORSE")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.HORSE);
//	if (s1.equalsIgnoreCase("PIG")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.PIG);
//	if (s1.equalsIgnoreCase("PIGZOMB")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.PIG_ZOMBIE);
//	if (s1.equalsIgnoreCase("SHEEP")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.SHEEP);
//	if (s1.equalsIgnoreCase("SKELETON")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.SKELETON);
//	if (s1.equalsIgnoreCase("SLIME")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.SLIME);
//	if (s1.equalsIgnoreCase("SPIDER")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.SPIDER);
//	if (s1.equalsIgnoreCase("SQUID")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.SQUID);
//	if (s1.equalsIgnoreCase("ZOMBIE")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.ZOMBIE);
//	if (s1.equalsIgnoreCase("WOLF")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.WOLF);
//	if (s1.equalsIgnoreCase("CAVESPIDER")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.CAVE_SPIDER);
//	if (s1.equalsIgnoreCase("ENDERMAN")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.ENDERMAN);
//	if (s1.equalsIgnoreCase("SILVERFISH")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.SILVERFISH);
//	if (s1.equalsIgnoreCase("ENDERDRAGON")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.ENDER_DRAGON);
//	if (s1.equalsIgnoreCase("VILLAGER")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.VILLAGER);
//	if (s1.equalsIgnoreCase("BLAZE")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.BLAZE);
//	if (s1.equalsIgnoreCase("MUSHROOMCOW")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.MUSHROOM_COW);
//	if (s1.equalsIgnoreCase("MAGMACUBE")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.MAGMA_CUBE);
//	if (s1.equalsIgnoreCase("SNOWMAN")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.SNOWMAN);
//  if (s1.equalsIgnoreCase("OCELOT")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.OCELOT);
//	if (s1.equalsIgnoreCase("IRONGOLEM")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.IRON_GOLEM);
//	if (s1.equalsIgnoreCase("WITHER")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.WITHER);
//	if (s1.equalsIgnoreCase("BAT")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.BAT);
//	if (s1.equalsIgnoreCase("WITCH")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.WITCH);
//	if (s1.equalsIgnoreCase("BOAT")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.BOAT);
//	if (s1.equalsIgnoreCase("MINECART")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.MINECART);
//	if (s1.equalsIgnoreCase("MINECART_CHEST")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.MINECART_CHEST);
//	if (s1.equalsIgnoreCase("MINECART_FURNACE")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.MINECART_FURNACE);
//	if (s1.equalsIgnoreCase("MINECART_TNT")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.MINECART_TNT);
//	if (s1.equalsIgnoreCase("MINECART_HOPPER")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.MINECART_HOPPER);
//	if (s1.equalsIgnoreCase("MINECART_MOB_SPAWNER")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.MINECART_MOB_SPAWNER);
//	if (s1.equalsIgnoreCase("ENDERCRYSTAL")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.ENDER_CRYSTAL);
//	if (s1.equalsIgnoreCase("EXPERIENCEORB")) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(),EntityType.EXPERIENCE_ORB);
	}
