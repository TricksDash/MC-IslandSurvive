package com.islandsurvive.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.islandsurvive.main.C;
import com.islandsurvive.main.Core;

public class GoldPlateTrigger implements Listener {
	
	private Core plugin;
	
	public GoldPlateTrigger(Core pl) {
		plugin = pl;
		
	}
	
	@EventHandler
	public void onPlayerInterac(PlayerInteractEvent event) {
		Player player = (Player) event.getPlayer();
		if(event.getAction().equals(Action.PHYSICAL) && (event.getClickedBlock().getType() == Material.GOLD_PLATE)){
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".SpawnPlateTrigger", true);
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "Coal");
			plugin.saveConfig();
			
			player.sendMessage(C.gold + "Congratulations! You are now ready to play.");
			
			World Skyworld = Bukkit.getWorld("Skyworld");
			Location loc = new Location(Skyworld, -508, 146, 182);
			loc.setYaw(180);
			player.teleport(loc);
			
			player.getInventory().addItem(new ItemStack(Material.WOOD_PICKAXE));
			player.getInventory().addItem(new ItemStack(Material.WOOD_PICKAXE));
			player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 10));
		}
	}
}
