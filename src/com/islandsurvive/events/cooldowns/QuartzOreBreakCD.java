package com.islandsurvive.events.cooldowns;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.islandsurvive.main.C;
import com.islandsurvive.main.Core;

import net.milkbowl.vault.economy.Economy;

public class QuartzOreBreakCD implements Listener {
	
	private Core plugin;
	
	public QuartzOreBreakCD(Core pl) {
		plugin = pl;
		
	}
	
	
		private HashMap<Player, Integer> cooldownTime;
		private HashMap<Player, BukkitRunnable> cooldownTask; {
		
			cooldownTime = new HashMap<Player, Integer>();
			cooldownTask = new HashMap<Player, BukkitRunnable>();
		}
			
		@EventHandler
		public void onOreBreak(BlockBreakEvent event) {
			Player player = event.getPlayer();
			Block block = event.getBlock();
			
			
			Economy eco = Core.eco;
			if(block.getType() == Material.QUARTZ_ORE) {
								
							if(cooldownTime.containsKey(player)) {
								
								if(block.getType()  == Material.QUARTZ_ORE){
									event.setCancelled(true);
									player.sendMessage(C.gray + "[" + C.red +  cooldownTime.get(player) + C.gray + "] " + C.yellow +  "Seconds until you can break another " + C.dred +  block.getType());
								}

								return;
							}
							player.sendMessage(" ");
							player.sendMessage(C.gray + "[" + C.gold + "+500 Coins" + C.gray + "]");
							player.sendMessage(" ");
							eco.depositPlayer(player, 500);
							
							plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".QuartzCount", plugin.getConfig().getInt("Player-Data." + player.getUniqueId() + ".QuartzCount", 0) + 1);
							plugin.saveConfig();
							
							player.sendMessage(C.gray + "[" + C.gold  + "+1" + C.gray + "] " + C.dgray +  block.getType() + " found!");

							cooldownTime.put(player, 1400);
							cooldownTask.put(player, new BukkitRunnable() {
								public void run() {
									cooldownTime.put(player, cooldownTime.get(player) - 1);
									event.setCancelled(true);
									if(cooldownTime.get(player) == 0) {
										block.setTypeId(153);
										cooldownTime.remove(player);
										cooldownTask.remove(player);
										cancel();
									}
								}
					});
					cooldownTask.get(player).runTaskTimer(plugin, 20, 20);
				}	
		{
	}
}
}
