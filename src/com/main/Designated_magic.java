package com.main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.main.Main;

@SuppressWarnings("deprecation")
public class Designated_magic implements Listener{
	@SuppressWarnings("unused")
	private Main plugin;
	public Designated_magic(Main plugin) {
		this.plugin=plugin;
	}
	
	
	@EventHandler
	public void onchat(PlayerInteractEntityEvent e){
		Player p=e.getPlayer();
		
		if(p.getItemInHand().getType()!=Material.AIR&&p.getItemInHand().getType()==Material.STICK){
			
		}
	
	}

}
