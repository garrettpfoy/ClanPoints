package org.edgegamers.picklez.main;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.edgegamers.picklez.commands.*;

import org.edgegamers.picklez.listeners.DeathEvent;
import org.edgegamers.picklez.storage.Points;
import org.mineacademy.fo.plugin.SimplePlugin;

import java.io.File;
import java.io.IOException;

public class ClanPoints extends SimplePlugin {

    private static Economy econ = null;

    @Override
    public void onPluginStart() {

        getLogger().info("ClanPoints has been successfully enabled!");
        getLogger().info("Made by PickleZ for EdgeGamers organization!");
        getLogger().info("Version: 1.0.0 SNAPSHOT");
        getLogger().info("");
        getLogger().info("Attempting to load point configs...");
        Points reaperPoints = new Points("reapers");
        Points dwarfPoints = new Points("dwarves");
        Points wizardPoints = new Points("wizards");
        getLogger().info("Success!");

        registerCommand(new AddCommand());
        registerCommand(new PurchaseCommand());
        registerCommand(new HelpCommand());
        registerEvents(new DeathEvent());
        registerCommand(new SetCommand());
        registerCommand(new CostChecker());

        if (!setupVault()) {
            getLogger().severe("Error! You need vault to run this plugin! Please restart the server with vault to proceed!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

    }

    public boolean setupVault() {
        if(getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);

        if(rsp == null) {
            return false;
        }
        econ = rsp.getProvider();

        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

}
