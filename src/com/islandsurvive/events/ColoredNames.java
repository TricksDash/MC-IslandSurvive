package com.islandsurvive.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import com.islandsurvive.main.C;

public class ColoredNames implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		if(event.getPlayer().hasPermission("islandsurvive.rank.admin")){
			event.getPlayer().setPlayerListName(C.yellow + "*" + C.red + event.getPlayer().getName());

		} else if(event.getPlayer().hasPermission("islandsurvive.rank.staff")){
			event.getPlayer().setPlayerListName(C.yellow + "*" + C.gold + event.getPlayer().getName());
		
		} else if(event.getPlayer().hasPermission("islandsurvive.rank.premium")){
			event.getPlayer().setPlayerListName(C.green + event.getPlayer().getName());
			
		} else if(event.getPlayer().hasPermission("islandsurvive.rank.vip")){
			event.getPlayer().setPlayerListName(C.yellow+ event.getPlayer().getName());
			
		} else if(event.getPlayer().hasPermission("islandsurvive.rank.mvp")){
			event.getPlayer().setPlayerListName(C.daqua + event.getPlayer().getName());
		}
	}
}
