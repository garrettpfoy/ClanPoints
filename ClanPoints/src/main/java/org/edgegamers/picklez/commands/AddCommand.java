package org.edgegamers.picklez.commands;

import org.bukkit.entity.Player;
import org.edgegamers.picklez.storage.Points;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class AddCommand extends SimpleCommand {

    public AddCommand() {
        super("addpoints");

        setMinArguments(2);
        setUsage("<clan> [points]");
        setDescription("Used to add points to a clan, use wisely :). Use negative values to remove points");

    }

    @Override
    public void onCommand() {
        checkConsole();

        Player player = getPlayer();

        Points reaperPoints = new Points("reapers");
        Points dwarfPoints = new Points("dwarves");
        Points wizardPoints = new Points("wizards");

        if(args[0].equalsIgnoreCase("dwarves")) {
            dwarfPoints.addPoints(Integer.parseInt(args[1]));
            Common.tell(player, "&cPoints Manager &8> &7You have added &4" + Integer.parseInt(args[1]) + " &7points to the dwarves");
        }
        else if(args[0].equalsIgnoreCase("reapers")) {
            reaperPoints.addPoints(Integer.parseInt(args[1]));
            Common.tell(player, "&cPoints Manager &8> &7You have added &4" + Integer.parseInt(args[1]) + " &7points to the reapers");
        }
        else if(args[0].equalsIgnoreCase("wizards")) {
            wizardPoints.addPoints(Integer.parseInt(args[1]));
            Common.tell(player, "&cPoints Manager &8> &7You have added &4" + Integer.parseInt(args[1]) + " &7points to the wizards");
        }
    }
}
