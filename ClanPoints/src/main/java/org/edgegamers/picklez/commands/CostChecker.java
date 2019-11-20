package org.edgegamers.picklez.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.edgegamers.picklez.main.ClanPoints;
import org.edgegamers.picklez.storage.Points;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.UUID;

public class CostChecker extends SimpleCommand {


    public CostChecker() {
        super("checkcost|costof|pointscost");

        setMinArguments(1);
        setUsage("<points>");
        setDescription("Used to view how much <points> would cost!");

    }

    @Override
    protected void onCommand() {
        checkConsole();

        Points reaperPoints = new Points("reapers");
        Points dwarfPoints = new Points("dwarves");
        Points wizardPoints = new Points("wizards");

        double cost = Integer.parseInt(args[0]) * 25000;

        UUID id = getPlayer().getUniqueId();

        OfflinePlayer player = Bukkit.getOfflinePlayer(id);

        Common.tell(getPlayer(), "&6Points &8\u00BB &7It would cost you &e$" + cost + " &7for " + args[0] + " points");

        if(ClanPoints.getEconomy().getBalance(player) > cost) {
            double leftOver = ClanPoints.getEconomy().getBalance(player) - cost;
            Common.tell(getPlayer(), "&6Points &8\u00BB &7If you were to buy these points, you would have: &a$" + leftOver + " &7 leftover!");
        }
        else {
            double needed = Math.abs(ClanPoints.getEconomy().getBalance(player) - cost);
            Common.tell(getPlayer(), "&6Points &8\u00BB &7If you wanted to buy these points, you would need: &a$" + needed + " &7 more!");
        }


    }
}
