package org.edgegamers.picklez.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.edgegamers.picklez.main.ClanPoints;
import org.edgegamers.picklez.storage.Points;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.UUID;

public class PurchaseCommand extends SimpleCommand {

    public PurchaseCommand() {
        super("buypoints");

        setMinArguments(1);
        setUsage("[points]");
        setDescription("Used to purchase points");

    }

    @Override
    public void onCommand() {
        checkConsole();

        Points reaperPoints = new Points("reapers");
        Points dwarfPoints = new Points("dwarves");
        Points wizardPoints = new Points("wizards");

        //calculate cost = 16000
        double cost = Integer.parseInt(args[0]) * 25000.0;
        UUID id = getPlayer().getUniqueId();

        OfflinePlayer player = Bukkit.getOfflinePlayer(id);

        if(ClanPoints.getEconomy().getBalance(player) < cost) {
            Common.tell(getPlayer(), "&cYou do not have enough money to purchase that many points! You need: $" + cost + "&c!");
        }
        else {
            ClanPoints.getEconomy().withdrawPlayer(player, cost);
            Common.tell(getPlayer(), "&a&l- &a$" + cost);
            if(getPlayer().hasPermission("clan.dwarf")) {
                dwarfPoints.addPoints(Integer.parseInt(args[0]));
                Common.tell(getPlayer(), "&8&l&m-----------&r &6&lClan &7Points &8&l&m-----------");
                Common.tell(getPlayer(), "&7");
                Common.tell(getPlayer(), "&a&lDwarves &8--> &7 " + dwarfPoints.getPoints() + " &8&l(&a&l+" + args[0] + "&8&l)");
                Common.tell(getPlayer(), "&e&lWizards &8--> &7 " + wizardPoints.getPoints());
                Common.tell(getPlayer(), "&3&lReapers &8--> &7 " + reaperPoints.getPoints());
                Common.tell(getPlayer(), "&7");
                Common.tell(getPlayer(), "&8&l&m--------------------------------");
            }
            else if(getPlayer().hasPermission("clan.reaper")) {
                reaperPoints.addPoints(Integer.parseInt(args[0]));
                Common.tell(getPlayer(), "&8&l&m-----------&r &6&lClan &7Points &8&l&m-----------");
                Common.tell(getPlayer(), "&7");
                Common.tell(getPlayer(), "&a&lDwarves &8--> &7 " + dwarfPoints.getPoints());
                Common.tell(getPlayer(), "&e&lWizards &8--> &7 " + wizardPoints.getPoints());
                Common.tell(getPlayer(), "&3&lReapers &8--> &7 " + reaperPoints.getPoints() + " &8&l(&a&l+" + args[0] + "&8&l)");
                Common.tell(getPlayer(), "&7");
                Common.tell(getPlayer(), "&8&l&m--------------------------------");
            }
            else if(getPlayer().hasPermission("clan.wizard")) {
                wizardPoints.addPoints(Integer.parseInt(args[0]));
                Common.tell(getPlayer(), "&8&l&m-----------&r &6&lClan &7Points &8&l&m-----------");
                Common.tell(getPlayer(), "&7");
                Common.tell(getPlayer(), "&a&lDwarves &8--> &7 " + dwarfPoints.getPoints());
                Common.tell(getPlayer(), "&e&lWizards &8--> &7 " + wizardPoints.getPoints() + " &8&l(&a&l+" + args[0] + "&8&l)");
                Common.tell(getPlayer(), "&3&lReapers &8--> &7 " + reaperPoints.getPoints());
                Common.tell(getPlayer(), "&7");
                Common.tell(getPlayer(), "&8&l&m--------------------------------");
            }


        }

    }
}
