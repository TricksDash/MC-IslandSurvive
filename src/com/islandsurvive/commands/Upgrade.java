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

import net.milkbowl.vault.economy.Economy;

public class Upgrade implements CommandExecutor {
	
	private Core plugin;
	
	public Upgrade(Core pl) {
		plugin = pl;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage("You are not a player");
		return false;
		}
		
		
		Player player = (Player) sender;
		Economy eco = Core.eco;
		
	if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("Coal")) {
		if(eco.getBalance(player) >= 500) {
			eco.withdrawPlayer(player, 500);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "Iron");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-500 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.white + "Iron!");
			
			World Skyworld = Bukkit.getWorld("Skyworld");
			Location loc = new Location(Skyworld, -85, 162, 116);
			loc.setYaw(150);
			player.teleport(loc);

		}else{
			player.sendMessage(C.red + "You do not have enough Coins!");
		}
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("Iron")) {
		if(eco.getBalance(player) >= 1000) {
			eco.withdrawPlayer(player, 1000);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "Gold");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-1000 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.gold + "Gold!");
			
			World Skyworld = Bukkit.getWorld("Skyworld");
			Location loc = new Location(Skyworld, -58, 178, 272);
			loc.setYaw(0);
			player.teleport(loc);

		}else{
			player.sendMessage(C.red + "You do not have enough Coins!");
		}
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("Gold")) {
		if(eco.getBalance(player) >= 2000) {
			eco.withdrawPlayer(player, 2000);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "Diamond");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-2000 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.aqua + "Diamond!");
			
			World Skyworld = Bukkit.getWorld("Skyworld");
			Location loc = new Location(Skyworld, 11, 84, 243);
			loc.setYaw(-180);
			player.teleport(loc);
		
		}else{
			player.sendMessage(C.red + "You do not have enough Coins!");
		}
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("Diamond")) {
		if(eco.getBalance(player) >= 4000) {
			eco.withdrawPlayer(player, 4000);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "Emerald");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-4000 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.green + "Emerald!");
			
			World Skyworld = Bukkit.getWorld("Skyworld");
			Location loc = new Location(Skyworld, -40, 67, 335);
			loc.setYaw(23);
			player.teleport(loc);

		}else{
			player.sendMessage(C.red + "You do not have enough Coins!");
		}
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("Emerald")) {
		if(eco.getBalance(player) >= 8000) {
			eco.withdrawPlayer(player, 8000);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "Redstone");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-8000 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.red + "Redstone!");
			
			World Skyworld = Bukkit.getWorld("Skyworld");
			Location loc = new Location(Skyworld, -135, 102, 273);
			loc.setYaw(-80);
			player.teleport(loc);
		
		}else{
			player.sendMessage(C.red + "You do not have enough Coins!");
		}
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("Redstone")) {
		if(eco.getBalance(player) >= 16000) {
			eco.withdrawPlayer(player, 16000);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "Lapis");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-16000 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.blue + "Lapis!");
			
			World Skyworld = Bukkit.getWorld("Skyworld");
			Location loc = new Location(Skyworld, -97, 204, 600);
			loc.setYaw(90);
			player.teleport(loc);

		}else{
			player.sendMessage(C.red + "You do not have enough Coins!");
		}
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("Lapis")) {
		if(eco.getBalance(player) >= 32000) {
			eco.withdrawPlayer(player, 32000);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "Quartz");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-32000 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.gray + "Quartz!");
			
			World Skyworld = Bukkit.getWorld("Skyworld");
			Location loc = new Location(Skyworld, 263, 124, 165);
			loc.setYaw(147);
			player.teleport(loc);
		
		}else{
			player.sendMessage(C.red + "You do not have enough Coins!");
		}
	}else
		player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have completed your leveling!");
	
	return true;
	}
}
