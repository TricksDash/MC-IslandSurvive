package com.islandsurvive.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import com.islandsurvive.main.C;
import com.islandsurvive.main.Core;


public class BlockProtection implements Listener {
	
	private Core plugin;
	
	public BlockProtection(Core pl) {
		plugin = pl;
		
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block diamond = event.getBlock();
		
		if(player.getLocation().getWorld().getName().equalsIgnoreCase("Skyworld")) {
			if(!(diamond.getType() == Material.COAL_ORE || 
				diamond.getType() == Material.IRON_ORE ||
				diamond.getType() == Material.GOLD_ORE ||
				diamond.getType() == Material.DIAMOND_ORE ||
				diamond.getType() == Material.EMERALD_ORE ||
				diamond.getType() == Material.REDSTONE_ORE ||
				diamond.getType() == Material.LAPIS_ORE ||
				diamond.getType() == Material.QUARTZ_ORE)) {
				if(!player.hasPermission("islandsurvive.rank.admin")) {
					event.setCancelled(true);
				player.sendMessage(C.red+C.bold + "Who do you think you are? You can't break that!");
				}
				else {
					return;
					
				}
			}
		}
	}
		
		@EventHandler
		public void onBlockPlace(BlockPlaceEvent event) {
			Player player = event.getPlayer();
			
			if(player.getLocation().getWorld().getName().equalsIgnoreCase("Skyworld")) {
					if(!player.hasPermission("islandsurvive.rank.admin")) {
						event.setCancelled(true);
					player.sendMessage(C.red+C.bold + "Who do you think you are? You can't place that!");
					}
					else {
						return;
				}
			}
		}
}
