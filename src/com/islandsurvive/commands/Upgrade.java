package com.islandsurvive.commands;

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
		
	if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("coal")) {
		if(eco.getBalance(player) >= 500) {
			eco.withdrawPlayer(player, 500);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "iron");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-500 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.white + "Iron!");

		
		}else{
			player.sendMessage(C.red + "You do not have enough Coins!");
		}
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("iron")) {
		if(eco.getBalance(player) >= 1000) {
			eco.withdrawPlayer(player, 1000);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "gold");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-1000 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.gold + "Gold!");

		
		}else{
			player.sendMessage(C.red + "You do not have enough Coins!");
		}
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("gold")) {
		if(eco.getBalance(player) >= 2000) {
			eco.withdrawPlayer(player, 2000);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "diamond");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-2000 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.aqua + "Diamond!");

		
		}else{
			player.sendMessage(C.red + "You do not have enough Coins!");
		}
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("diamond")) {
		if(eco.getBalance(player) >= 4000) {
			eco.withdrawPlayer(player, 4000);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "emerald");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-4000 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.green + "Emerald!");

		
		}else{
			player.sendMessage(C.red + "You do not have enough Coins!");
		}
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("emerald")) {
		if(eco.getBalance(player) >= 8000) {
			eco.withdrawPlayer(player, 8000);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "redstone");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-8000 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.red + "Redstone!");

		
		}else{
			player.sendMessage(C.red + "You do not have enough Coins!");
		}
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("redstone")) {
		if(eco.getBalance(player) >= 16000) {
			eco.withdrawPlayer(player, 16000);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "lapis");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-16000 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.blue + "Lapis!");

		
		}else{
			player.sendMessage(C.red + "You do not have enough Coins!");
		}
	}else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("lapis")) {
		if(eco.getBalance(player) >= 32000) {
			eco.withdrawPlayer(player, 32000);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "quartz");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-32000 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.gray + "Quartz!");

		
		}else{
			player.sendMessage(C.red + "You do not have enough Coins!");
		}
	}else
		player.sendMessage(C.red + "You have completed your leveling!");
	
	return true;
	}
}
