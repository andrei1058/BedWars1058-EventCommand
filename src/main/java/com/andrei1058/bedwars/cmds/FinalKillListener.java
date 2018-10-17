package com.andrei1058.bedwars.cmds;

import com.andrei1058.bedwars.api.events.PlayerKillEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static com.andrei1058.bedwars.cmds.Main.getPlugin;

public class FinalKillListener implements Listener {


    @EventHandler
    public void onFinalKill(PlayerKillEvent e){
        if (e.getCause().toString().contains("FINAL_KILL")) return;
        Player killer = e.getKiller(), victim = e.getVictim();
        if (getPlugin().getCfg().getBoolean("finalKill.killer.enable") && killer != null){
            for (String s : getPlugin().getCfg().getYml().getStringList("finalKill.killer.player")){
                Bukkit.getServer().dispatchCommand(killer, "/"+s.replace("{killer}", killer.getName()).replace("{victim}", victim.getName()));
            }
            for (String s : getPlugin().getCfg().getYml().getStringList("finalKill.killer.console")){
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), s.replace("{killer}", killer.getName()).replace("{victim}", victim.getName()));
            }
        }
        if (getPlugin().getCfg().getBoolean("finalKill.victim.enable")){
            for (String s : getPlugin().getCfg().getYml().getStringList("finalKill.victim.player")){
                if (killer == null) {
                    Bukkit.getServer().dispatchCommand(victim, "/" + s.replace("{victim}", victim.getName()));
                } else {
                    Bukkit.getServer().dispatchCommand(victim, "/" + s.replace("{killer}", killer.getName()).replace("{victim}", victim.getName()));
                }
            }
            for (String s : getPlugin().getCfg().getYml().getStringList("finalKill.victim.console")){
                if (killer == null){
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), s.replace("{victim}", victim.getName()));
                } else {
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), s.replace("{killer}", killer.getName()).replace("{victim}", victim.getName()));
                }
            }
        }
    }
}
