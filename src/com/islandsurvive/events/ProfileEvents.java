package com.islandsurvive.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ProfileEvents implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
	if(event.getInventory().getTitle().equals("Player Profile")){
	
            Player player = (Player) event.getWhoClicked();	
            event.setCancelled(true);
            player.updateInventory();            
		}
	}

}
