package com.islandsurvive.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.islandsurvive.main.C;
import com.islandsurvive.main.Core;


public class BlocksDestroyed implements Listener {
	
	private Core plugin;
	
	public BlocksDestroyed(Core pl) {
		plugin = pl;
		
	}
	
	@EventHandler
	public void onOreBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block diamond = event.getBlock();
		
		if(player.getLocation().getWorld().getName().equalsIgnoreCase("Skyworld")) {
			if(diamond.getType() == Material.DIAMOND_ORE) {
				
				plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".DiamondCount", plugin.getConfig().getInt("Player-Data." + player.getUniqueId() + ".DiamondCount", 0) + 1);
				plugin.saveConfig();
				
				player.sendMessage(C.gray + "[" + C.gold + "+1" + C.gray + "]" + C.blue +  " Diamond Found");
				
			}
			if(diamond.getType() == Material.EMERALD_ORE) {
				
				plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".EmeraldCount", plugin.getConfig().getInt("Player-Data." + player.getUniqueId() + ".EmeraldCount", 0) + 1);
				plugin.saveConfig();
				
				player.sendMessage(C.gray + "[" + C.gold + "+1" + C.gray + "]" + C.green +  " Emerald Found");
				
			}
			if(diamond.getType() == Material.GOLD_ORE) {
				
				plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".GoldCount", plugin.getConfig().getInt("Player-Data." + player.getUniqueId() + ".GoldCount", 0) + 1);
				plugin.saveConfig();
				
				player.sendMessage(C.gray + "[" + C.gold + "+1" + C.gray + "]" + C.gold +  " Gold Found");
				
			}
			if(diamond.getType() == Material.IRON_ORE) {
				
				plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".IronCount", plugin.getConfig().getInt("Player-Data." + player.getUniqueId() + ".IronCount", 0) + 1);
				plugin.saveConfig();
				
				player.sendMessage(C.gray + "[" + C.gold + "+1" + C.gray + "]" + C.white+  " Iron Found");
				
			}
			if(diamond.getType() == Material.COAL_ORE) {
				
				plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".CoalCount", plugin.getConfig().getInt("Player-Data." + player.getUniqueId() + ".CoalCount", 0) + 1);
				plugin.saveConfig();
				
				player.sendMessage(C.gray + "[" + C.gold + "+1" + C.gray + "]" + C.dgray +  " Coal Found");
			}
		}
	}
}
