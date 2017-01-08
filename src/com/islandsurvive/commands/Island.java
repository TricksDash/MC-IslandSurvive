package com.islandsurvive.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.islandsurvive.main.C;
import com.islandsurvive.main.Core;

public class Island implements CommandExecutor {
	
	private Core plugin;
	
	public Island(Core pl) {
		plugin = pl;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage("You are not a player");
		return false;
		}
		
		
		Player player = (Player) sender;
		
	if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("Coal")) {

			player.sendMessage(C.gray + "[" + C.red + "Teleport" + C.gray + "]: " + C.gold + "Teleporting to" + C.gray + " Coal " + C.gold + "Island!");
			
			World Skyworld = Bukkit.getWorld("Skyworld");
			Location loc = new Location(Skyworld, -508, 146, 182);
			loc.setYaw(180);
			player.teleport(loc);

	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("Iron")) {

		player.sendMessage(C.gray + "[" + C.red + "Teleport" + C.gray + "]: " + C.gold+ "Teleporting to" + C.white + " Iron " + C.gold + "Island!");
		
		World Skyworld = Bukkit.getWorld("Skyworld");
		Location loc = new Location(Skyworld, -508, 146, 182);
		loc.setYaw(180);
		player.teleport(loc);
		
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("Gold")) {

		player.sendMessage(C.gray + "[" + C.red + "Teleport" + C.gray + "]: " + C.gold + "Teleporting to" + C.gold + " Gold " + C.gold + "Island!");
		
		World Skyworld = Bukkit.getWorld("Skyworld");
		Location loc = new Location(Skyworld, -508, 146, 182);
		loc.setYaw(180);
		player.teleport(loc);
	
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("Diamond")) {

		player.sendMessage(C.gray + "[" + C.red + "Teleport" + C.gray + "]: " + C.gold + "Teleporting to" + C.aqua + " Diamond " + C.gold + "Island!");
		
		World Skyworld = Bukkit.getWorld("Skyworld");
		Location loc = new Location(Skyworld, -508, 146, 182);
		loc.setYaw(180);
		player.teleport(loc);
		
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("Emerald")) {

		player.sendMessage(C.gray + "[" + C.red + "Teleport" + C.gray + "]: " + C.gold + "Teleporting to" + C.green + " Emerald " + C.gold + "Island!");
		
		World Skyworld = Bukkit.getWorld("Skyworld");
		Location loc = new Location(Skyworld, -508, 146, 182);
		loc.setYaw(180);
		player.teleport(loc);
		
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("Redstone")) {

		player.sendMessage(C.gray + "[" + C.red + "Teleport" + C.gray + "]: " + C.gold+ "Teleporting to" + C.red + " Redstone " + C.gold + "Island!");
		
		World Skyworld = Bukkit.getWorld("Skyworld");
		Location loc = new Location(Skyworld, -508, 146, 182);
		loc.setYaw(180);
		player.teleport(loc);
		
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("Lapis")) {

		player.sendMessage(C.gray + "[" + C.red + "Teleport" + C.gray + "]: " + C.gold + "Teleporting to" + C.blue + " Lapis " + C.gold+ "Island!");
		
		World Skyworld = Bukkit.getWorld("Skyworld");
		Location loc = new Location(Skyworld, -508, 146, 182);
		loc.setYaw(180);
		player.teleport(loc);
		
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("Quartz")) {

		player.sendMessage(C.gray + "[" + C.red + "Teleport" + C.gray + "]: " + C.gold+ "Teleporting to" + C.gray + " Quartz " + C.gold+ "Island!");
		
		World Skyworld = Bukkit.getWorld("Skyworld");
		Location loc = new Location(Skyworld, -508, 146, 182);
		loc.setYaw(180);
		player.teleport(loc);
	}
		
	return true;
	}
}
