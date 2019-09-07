package com.andrei1058.bedwars.cmds.listeners;

import com.andrei1058.bedwars.api.events.player.PlayerBedBreakEvent;
import com.andrei1058.bedwars.cmds.ConfigPath;
import com.andrei1058.bedwars.cmds.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BedDestroyListener implements Listener {

    @EventHandler
    public void onBedDestroy(PlayerBedBreakEvent e) {

        for (String s : Main.getCfg().getYml().getStringList(ConfigPath.BED_DESTROY_FOR_DESTROYER_AS_PLAYER)) {
            if (s.trim().isEmpty()) continue;
            Bukkit.getServer().dispatchCommand(e.getPlayer(), s.replace("{destroyer}", e.getPlayer().getName()
                    .replace("{arena}", e.getPlayerTeam().getArena().getWorldName()))
                    .replace("{arenaDisplay}", e.getPlayerTeam().getArena().getDisplayName())
                    .replace("{group}", e.getPlayerTeam().getArena().getGroup())
                    .replace("{destroyerTeam}", e.getPlayerTeam().getName())
                    .replace("{victimTeam}", e.getVictimTeam().getName()));
        }
        for (String s : Main.getCfg().getYml().getStringList(ConfigPath.BED_DESTROY_FOR_DESTROYER_CONSOLE)) {
            if (s.trim().isEmpty()) continue;
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), s.replace("{destroyer}", e.getPlayer().getName()
                    .replace("{arena}", e.getPlayerTeam().getArena().getWorldName()))
                    .replace("{arenaDisplay}", e.getPlayerTeam().getArena().getDisplayName())
                    .replace("{group}", e.getPlayerTeam().getArena().getGroup())
                    .replace("{destroyerTeam}", e.getPlayerTeam().getName())
                    .replace("{victimTeam}", e.getVictimTeam().getName()));
        }

        for (Player p : e.getPlayerTeam().getMembers()) {
            if (p.equals(e.getPlayer())) continue;
            for (String s : Main.getCfg().getYml().getStringList(ConfigPath.BED_DESTROY_FOR_DESTROYERS_AS_PLAYER)) {
                if (s.trim().isEmpty()) continue;
                Bukkit.getServer().dispatchCommand(p, s.replace("{destroyer}", e.getPlayer().getName()
                        .replace("{arena}", e.getPlayerTeam().getArena().getWorldName()))
                        .replace("{arenaDisplay}", e.getPlayerTeam().getArena().getDisplayName())
                        .replace("{group}", e.getPlayerTeam().getArena().getGroup())
                        .replace("{player}", p.getName())
                        .replace("{destroyerTeam}", e.getPlayerTeam().getName())
                        .replace("{victimTeam}", e.getVictimTeam().getName()));
            }
            for (String s : Main.getCfg().getYml().getStringList(ConfigPath.BED_DESTROY_FOR_DESTROYERS_CONSOLE)) {
                if (s.trim().isEmpty()) continue;
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), s.replace("{destroyer}", e.getPlayer().getName()
                        .replace("{arena}", e.getPlayerTeam().getArena().getWorldName()))
                        .replace("{arenaDisplay}", e.getPlayerTeam().getArena().getDisplayName())
                        .replace("{group}", e.getPlayerTeam().getArena().getGroup())
                        .replace("{player}", p.getName())
                        .replace("{destroyerTeam}", e.getPlayerTeam().getName())
                        .replace("{victimTeam}", e.getVictimTeam().getName()));
            }
        }
    }
}
