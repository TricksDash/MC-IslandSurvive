package com.islandsurvive.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.islandsurvive.main.C;
import com.islandsurvive.main.Core;

import net.milkbowl.vault.economy.Economy;

public class Upgrade implements CommandExecutor {
	
	private Core plugin;
	
	public Upgrade(Core pl) {
		plugin = pl;
		
	}
	
	Economy eco = Core.eco;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage("You are not a player");
		return false;
		}
		
		
		Player player = (Player) sender;
		
	if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("coal"));
		if(eco.getBalance(player) >= 500) {
			eco.withdrawPlayer(player, 500);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "iron");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-500 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.white + "Iron!");
		}
		
		else if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Level").equals("coal"));
		if(eco.getBalance(player) == 500) {
			eco.withdrawPlayer(player, 500);
			
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Level", "iron");
			plugin.saveConfig();
			
			player.sendMessage(C.gray + "[" + C.gold + "-500 Coins" + C.gray + "]");
			player.sendMessage(C.gray + "[" + C.red + "Upgrade" + C.gray + "]: " + C.gold + "You have been upgraded to " + C.white + "Iron!");
		
		}else{
			player.sendMessage(C.red + "You do not have enough Coins to do that!");
		}
		
		return true;
	}
}
