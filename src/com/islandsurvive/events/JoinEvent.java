package com.islandsurvive.events;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.islandsurvive.main.C;
import com.islandsurvive.main.Core;

public class JoinEvent implements Listener {
	
	private Core plugin;
	
	public JoinEvent(Core pl) {
		plugin = pl;
		
	}
	
	@EventHandler
	public void onFirstJoin(PlayerJoinEvent event) {
		Player player = (Player) event.getPlayer();
		
		if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".SpawnPlateTrigger").equals(true));
		player.sendMessage(C.red + "Welcome back!");
		
		
	}
}
