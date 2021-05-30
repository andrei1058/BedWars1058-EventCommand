package com.andrei1058.bedwars.cmds.listeners;

import com.andrei1058.bedwars.api.events.player.PlayerKillEvent;
import com.andrei1058.bedwars.cmds.ConfigPath;
import com.andrei1058.bedwars.cmds.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class RegularKillsListener implements Listener {

    @EventHandler
    public void onRegularKill(PlayerKillEvent e) {
        if (e.getCause().toString().contains("FINAL_KILL")) return;
        Player killer = e.getKiller(), victim = e.getVictim();

        if (killer == null && Main.getCfg().getBoolean(ConfigPath.REGULAR_KILL_FOR_VICTIM_NO_KILLER_ENABLE)) {
            for (String s : Main.getCfg().getYml().getStringList(ConfigPath.REGULAR_KILL_VICTIM_NO_KILLER_AS_PLAYER)) {
                if (s.trim().isEmpty()) continue;
                Bukkit.getServer().dispatchCommand(victim, "/" + s.replace("{victim}", victim.getName())
                        .replace("{arena}", e.getArena().getWorldName())
                        .replace("{arenaDisplay}", e.getArena().getDisplayName())
                        .replace("{group}", e.getArena().getGroup()));
            }

            for (String s : Main.getCfg().getYml().getStringList(ConfigPath.REGULAR_KILL_VICTIM_NO_KILLER_AS_CONSOLE)) {
                if (s.trim().isEmpty()) continue;
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), s.replace("{victim}", victim.getName())
                        .replace("{arena}", e.getArena().getWorldName())
                        .replace("{arenaDisplay}", e.getArena().getDisplayName())
                        .replace("{group}", e.getArena().getGroup()));
            }
        } else if (killer != null) {
            if (Main.getCfg().getBoolean(ConfigPath.REGULAR_KILL_FOR_VICTIM_WITH_KILLER_ENABLE)) {
                for (String s : Main.getCfg().getYml().getStringList(ConfigPath.REGULAR_KILL_VICTIM_WITH_KILLER_AS_PLAYER)) {
                    if (s.trim().isEmpty()) continue;
                    Bukkit.getServer().dispatchCommand(victim, "/" + s.replace("{victim}", victim.getName())
                            .replace("{arena}", e.getArena().getWorldName())
                            .replace("{arenaDisplay}", e.getArena().getDisplayName())
                            .replace("{group}", e.getArena().getGroup())
                            .replace("{killer}", killer.getName()));
                }

                for (String s : Main.getCfg().getYml().getStringList(ConfigPath.REGULAR_KILL_VICTIM_WITH_KILLER_AS_CONSOLE)) {
                    if (s.trim().isEmpty()) continue;
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), s.replace("{victim}", victim.getName())
                            .replace("{arena}", e.getArena().getWorldName())
                            .replace("{arenaDisplay}", e.getArena().getDisplayName())
                            .replace("{group}", e.getArena().getGroup())
                            .replace("{killer}", killer.getName()));
                }
            }
            if (Main.getCfg().getBoolean(ConfigPath.REGULAR_KILL_FOR_KILLER_ENABLE)) {
                for (String s : Main.getCfg().getYml().getStringList(ConfigPath.REGULAR_KILL_KILLER_AS_PLAYER)) {
                    if (s.trim().isEmpty()) continue;
                    Bukkit.getServer().dispatchCommand(killer, "/" + s.replace("{victim}", victim.getName())
                            .replace("{arena}", e.getArena().getWorldName())
                            .replace("{arenaDisplay}", e.getArena().getDisplayName())
                            .replace("{group}", e.getArena().getGroup())
                            .replace("{killer}", killer.getName()));
                }

                for (String s : Main.getCfg().getYml().getStringList(ConfigPath.REGULAR_KILL_KILLER_AS_CONSOLE)) {
                    if (s.trim().isEmpty()) continue;
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), s.replace("{victim}", victim.getName())
                            .replace("{arena}", e.getArena().getWorldName())
                            .replace("{arenaDisplay}", e.getArena().getDisplayName())
                            .replace("{group}", e.getArena().getGroup())
                            .replace("{killer}", killer.getName()));
                }
            }
        }
    }
}
