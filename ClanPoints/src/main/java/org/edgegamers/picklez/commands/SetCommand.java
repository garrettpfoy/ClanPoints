package org.edgegamers.picklez.commands;

import org.bukkit.entity.Player;
import org.edgegamers.picklez.storage.Points;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class SetCommand extends SimpleCommand {

    public SetCommand() {
        super("setpoints");

        setMinArguments(2);
        setUsage("<clan> [points]");
        setDescription("Used to set the the points, this will override all other points! Admin use only!");

    }

    @Override
    public void onCommand() {
        checkConsole();

        Player player = getPlayer();

        Points reaperPoints = new Points("reapers");
        Points dwarfPoints = new Points("dwarves");
        Points wizardPoints = new Points("wizards");

        if(args[0].equalsIgnoreCase("dwarves")) {
            dwarfPoints.setPoints(Integer.parseInt(args[1]));
            Common.tell(player, "&cPoints Manager &8> &7You have set the dwarf points to: " + Integer.parseInt(args[1]));
        }
        else if(args[0].equalsIgnoreCase("reapers")) {
            reaperPoints.setPoints(Integer.parseInt(args[1]));
            Common.tell(player, "&cPoints Manager &8>: &7You have set the reaper points to: " + Integer.parseInt(args[1]));
        }
        else if(args[0].equalsIgnoreCase("wizards")) {
            wizardPoints.setPoints(Integer.parseInt(args[1]));
            Common.tell(player, "&cPoints Manager &8> &7You have set the wizard points to: " + Integer.parseInt(args[1]));
        }
    }
}
