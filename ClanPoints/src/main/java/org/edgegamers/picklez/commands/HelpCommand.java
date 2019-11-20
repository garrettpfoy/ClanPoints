package org.edgegamers.picklez.commands;

import org.bukkit.entity.Player;
import org.edgegamers.picklez.storage.Points;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class HelpCommand extends SimpleCommand {


    public HelpCommand() {
        super("clanpoints|points");

        setMinArguments(0);
        setUsage("Empty");
        setDescription("Used to view a the clan point leaderboard");

    }

    @Override
    protected void onCommand() {
        checkConsole();

        Points reaperPoints = new Points("reapers");
        Points dwarfPoints = new Points("dwarves");
        Points wizardPoints = new Points("wizards");

        Player player = (Player) sender;

        Common.tell(player, "&8&l&m-----------&r &6&lClan &7Points &8&l&m-----------");
        Common.tell(player, "&7");
        Common.tell(player, "&a&lDwarves &8--> &7 " + dwarfPoints.getPoints());
        Common.tell(player, "&e&lWizards &8--> &7 " + wizardPoints.getPoints());
        Common.tell(player, "&3&lReapers &8--> &7 " + reaperPoints.getPoints());
        Common.tell(player, "&7");
        Common.tell(player, "&8&l&m--------------------------------");


    }
}
