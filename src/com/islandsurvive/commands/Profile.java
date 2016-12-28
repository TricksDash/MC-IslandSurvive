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

public class Profile implements CommandExecutor {
	
	private Core plugin;
	
	public Profile(Core pl) {
		plugin = pl;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage("You are not a player");
		return false;
		}
		
		
		Player player = (Player) sender;
		
		Inventory playerProfile = Bukkit.createInventory(null, 9, "Player Profile");
		
		
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);

		
		// For using just /Profile\\
		if(args.length == 0){
			
			
			ItemStack playerSkull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
			
			// General \\
			SkullMeta playerSkullMeta = (SkullMeta) playerSkull.getItemMeta();
			playerSkullMeta.setOwner(player.getName());
			playerSkullMeta.setDisplayName(C.green + "Stats");
			playerSkullMeta.setLore(Arrays.asList(C.gray + "Dated Joined: " + C.gold + plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".DateJoined"), 
					C.gray + "Diamonds Mined: " + C.gold +  plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".DiamondCount"), 
					C.gray + "Referal Count: " + C.gold + plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".ReferalCount")));
			skull.setItemMeta(playerSkullMeta);
			
			// Mining \\
			ItemStack mining= new ItemStack(Material.IRON_ORE);
			ItemMeta miningMeta= mining.getItemMeta();
			miningMeta.setDisplayName(C.green + "Stats");
			miningMeta.setLore(Arrays.asList(C.gray + "Diamonds Mined: " + C.gold +  plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".DiamondCount"), 
					C.gray + "Emeralds Mined: " + C.gold + plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".EmeraldCount"), 
					C.gray + "Gold Mined: " + C.gold + plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".GoldCount"), 
					C.gray + "Iron Mined: " + C.gold + plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".IronCount"), 
					C.gray + "Coal Mined: " + C.gold + plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".CoalCount")));
			mining.setItemMeta(miningMeta);
			
			playerProfile.setItem(1, skull);
			playerProfile.setItem(3, mining);
			player.openInventory(playerProfile);
		}

		return true;
	}
}
