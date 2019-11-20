package org.edgegamers.picklez.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.edgegamers.picklez.storage.Points;
import org.mineacademy.fo.Common;

public class DeathEvent implements Listener {


    @EventHandler
    public void onPlayerDeath(final PlayerDeathEvent event) {
        Player player = event.getEntity();
        Player killer = player.getKiller();

        Points reaperPoints = new Points("reapers");
        Points dwarfPoints = new Points("dwarves");
        Points wizardPoints = new Points("wizards");

        if (player.hasPermission("clan.dwarf")) {
            dwarfPoints.addPoints(-10);
            event.setDeathMessage("§c§lDEATH §8\u00BB §a " + player.getDisplayName() + " §7died. §8§l(§c-10 §7points§8§l)");
        } else if (player.hasPermission("clan.wizard")) {
            wizardPoints.addPoints(-10);
            event.setDeathMessage("§c§lDEATH §8\u00BB §e " + player.getDisplayName() + " §7died. §8§l(§c-10 §7points§8§l)");
        } else if (player.hasPermission("clan.reaper")) {
            reaperPoints.addPoints(-10);
            event.setDeathMessage("§c§lDEATH §8\u00BB §3 " + player.getDisplayName() + " §7died. §8§l(§c-10 §7points§8§l)");
        }

        if (killer != null) {
            if (killer.hasPermission("clan.dwarf")) {
                dwarfPoints.addPoints(10);
                Common.tell(killer, "&c&lKILL &8\u00BB &7You have killed &c" + player.getDisplayName() + " &7! You have earned &410 &7points for your clan!");
            } else if (killer.hasPermission("clan.wizard")) {
                wizardPoints.addPoints(10);
                Common.tell(killer, "&c&lKILL &8\u00BB &7You have killed &c" + player.getDisplayName() + " &7! You have earned &410 &7points for your clan!");
            } else if (killer.hasPermission("clan.reaper")) {
                reaperPoints.addPoints(10);
                Common.tell(killer, "&c&lKILL &8\u00BB &7You have killed &c" + player.getDisplayName() + " &7! You have earned &410 &7points for your clan!");
            }
        }
    }
}

