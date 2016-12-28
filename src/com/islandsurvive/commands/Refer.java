package com.islandsurvive.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.islandsurvive.main.C;
import com.islandsurvive.main.Core;

public class Refer implements CommandExecutor {
	
	private Core plugin;
	
	public Refer(Core pl) {
		plugin = pl;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage("You are not a player");
		return false;
	}else{
		Player player = (Player) sender;
		
		if(args.length == 0) {
			player.sendMessage(C.red + "Incorrect usage: /refer (Name)");
		
		}else if(args.length == 1) {
			
			if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Refered").equals(true)) {
				player.sendMessage(C.red + "You have already refered a player");
			}else{
			
			Player target = Bukkit.getPlayer(args[0]);
			
			if(target.hasPlayedBefore() == true) {

				player.sendMessage(C.gold + "Your referal for " + args[0] + " has been registered");
				target.sendMessage(C.gold + player.getName() + " has just refered you!");
				
				plugin.getConfig().set("Player-Data." + target.getUniqueId() + ".ReferedCount", plugin.getConfig().getInt("Player-Data." + player.getUniqueId() + ".ReferedCount", 0) + 1);
				plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Refered", true);
				plugin.saveConfig();
			
			}else
			
			player.sendMessage(C.red + "You cannot refer that player, they have not connected before.");
			}
		
		}else if(args.length >= 2) {
			player.sendMessage(C.red + "Incorrect usage: /refer (Name)");
			
		}else
			player.sendMessage(C.red + "Incorrect usage: /refer (Name)");
	}	
	return true;
	}
}
