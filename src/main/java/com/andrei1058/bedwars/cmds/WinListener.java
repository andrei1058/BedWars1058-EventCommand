package com.andrei1058.bedwars.cmds;

import com.andrei1058.bedwars.api.GameState;
import com.andrei1058.bedwars.api.events.GameStateChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static com.andrei1058.bedwars.cmds.Main.getPlugin;

public class WinListener implements Listener {

    @EventHandler
    public void onWin(GameStateChangeEvent e) {
        if (e.getState() == GameState.restarting) {
            Bukkit.getScheduler().runTaskLater(getPlugin(), () -> {
                for (Player p : e.getArena().getPlayers()) {
                    for (String s : getPlugin().getCfg().getYml().getStringList("gameWin.player")) {
                        Bukkit.getServer().dispatchCommand(p, "/" + s.replace("{player}", p.getName()));
                    }
                    for (String s : getPlugin().getCfg().getYml().getStringList("gameWin.console")) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), s.replace("{player}", p.getName()));
                    }
                }
            }, 10l);
        }
    }
}
