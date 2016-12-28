package com.islandsurvive.main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.islandsurvive.commands.Profile;
import com.islandsurvive.commands.Refer;
import com.islandsurvive.events.BlocksDestroyed;
import com.islandsurvive.events.CoalBreakTimer;
import com.islandsurvive.events.FirstJoin;
import com.islandsurvive.events.ProfileEvents;

import net.milkbowl.vault.economy.Economy;


public class Core extends JavaPlugin {
	
	public static Economy eco = null;
	
	public void onEnable() {
	PluginDescriptionFile pdfFile = getDescription();
	Logger logger = getLogger();

	registerCommands();
	registerConfig();
	registerEvents();
	
	if(!setupEconomy()){
	Bukkit.shutdown();
	}

	logger.info(pdfFile.getName() + "Has been enabled - Version " + pdfFile.getVersion());	
}

public void onDisable() {
	PluginDescriptionFile pdfFile = getDescription();
	Logger logger = getLogger();

	logger.info(pdfFile.getName() + "Has been disabled - Version " + pdfFile.getVersion());
}

public void registerCommands() {
	getCommand("profile").setExecutor(new Profile(this));
	getCommand("refer").setExecutor(new Refer(this));
	}

public void registerEvents() {
	PluginManager pm = getServer().getPluginManager();
	
	//pm.registerEvents(new BlocksDestroyed(this), this);
	pm.registerEvents(new FirstJoin(this), this);
	pm.registerEvents(new ProfileEvents(), this);
	pm.registerEvents(new CoalBreakTimer(this), this);
}

public void registerConfig() {
	getConfig().options().copyDefaults(true);
	saveDefaultConfig();
	}

private boolean setupEconomy(){
    RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
    if (economyProvider != null) {
        eco = economyProvider.getProvider();
    }

    return (eco != null);
    }
}

