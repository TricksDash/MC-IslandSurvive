package com.islandsurvive.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.islandsurvive.main.C;

public class ColoredNames implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		
		Team admin = board.registerNewTeam("Admin");
		
		admin.setPrefix(C.yellow + "*" + C.red);
		
		
		
		if(event.getPlayer().hasPermission("islandsurvive.rank.admin")){
			event.getPlayer().setPlayerListName(C.yellow + "*" + C.red + event.getPlayer().getName());
            admin.addPlayer((event.getPlayer()));


		
		} else if(event.getPlayer().hasPermission("islandsurvive.rank.mod")){
			event.getPlayer().setPlayerListName(C.yellow + "*" + C.gold + event.getPlayer().getName());
		
		} else if(event.getPlayer().hasPermission("islandsurvive.rank.assistant")){
			event.getPlayer().setPlayerListName(C.yellow + "*" + C.blue + event.getPlayer().getName());
		
		} else if(event.getPlayer().hasPermission("islandsurvive.rank.iron")){
			event.getPlayer().setPlayerListName(event.getPlayer().getName());
			
		} else if(event.getPlayer().hasPermission("islandsurvive.rank.gold")){
			event.getPlayer().setPlayerListName(C.yellow+ event.getPlayer().getName());
			
		} else if(event.getPlayer().hasPermission("islandsurvive.rank.diamond")){
			event.getPlayer().setPlayerListName(C.daqua + event.getPlayer().getName());
			
		} else if(event.getPlayer().hasPermission("islandsurvive.rank.premium")){
			event.getPlayer().setPlayerListName(C.green + event.getPlayer().getName());
		
		} else if(event.getPlayer().hasPermission("islandsurvive.rank.player")){
			event.getPlayer().setPlayerListName(C.gray + event.getPlayer().getName());
		}
	}
}
