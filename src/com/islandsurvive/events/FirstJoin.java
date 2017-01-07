package com.islandsurvive.events;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.islandsurvive.main.C;
import com.islandsurvive.main.Core;

public class FirstJoin implements Listener {
	
	private Core plugin;
	
	public FirstJoin(Core pl) {
		plugin = pl;
		
	}
	
	@EventHandler
	public void onFirstJoin(PlayerJoinEvent event) {
		Player player = (Player) event.getPlayer();
		
		if(!player.hasPlayedBefore()) {
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".DateJoined", new SimpleDateFormat("dd/MM/yy").format(new Date()));
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".SpawnPlateTrigger", false);
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".CoalCount", 0);
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".IronCount", 0);
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".GoldCount", 0);
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".DiamondCount", 0);
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".EmeraldCount", 0);
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".RedstoneCount", 0);
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".LapisCount", 0);
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".QuartzCount", 0);
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".ReferedCount", 0);
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".NameWhenJoined", player.getName());plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Refered", false);			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "Coal");
			plugin.saveConfig();
			
			Bukkit.broadcastMessage(C.red + "Welcome " + C.gold + player.getName() + C.red + " to IslandSurvive!");
			player.sendMessage(C.green + "Use /Donate for Website information");
			player.sendMessage(C.green + "Use /Website for Website information");
			player.sendMessage(C.green + "Use /Staff for Staff information");
			player.sendMessage(C.green + "Use /Help for Server information");
			
		if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".SpawnPlateTrigger").equals(false));
			
			World Skyworld = Bukkit.getWorld("Skyworld");
			Location loc = new Location(Skyworld, -475, 133, -68);
			loc.setYaw(136);
			player.teleport(loc);

		}
	}
}
