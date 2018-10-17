package com.andrei1058.bedwars.cmds;

import com.andrei1058.bedwars.configuration.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Main extends JavaPlugin implements Listener {

    private static Main plugin;
    private static ConfigManager cfg;

    public void onEnable(){
        plugin = this;

        /** Check if bw plugin is loaded */
        if (Bukkit.getPluginManager().getPlugin("BedWars1058") == null){
            this.getLogger().severe("I can't run without BedWars1058 Plugin!");
            this.setEnabled(false);
            return;
        }

        /** Setup configuration */
        cfg = new ConfigManager("config", "plugins/BedWars1058/Addons/Cmds",false);
        setupConfiguration();

        /** Register listeners */
        if (getCfg().getBoolean("gameWin.enable")){
            Bukkit.getPluginManager().registerEvents(new WinListener(), getPlugin());
        }
        if (getCfg().getBoolean("finalKill.killer.enable") || getCfg().getBoolean("finalKill.victim.enable")){
            Bukkit.getPluginManager().registerEvents(new FinalKillListener(), getPlugin());
        }
    }

    private static void setupConfiguration(){
        YamlConfiguration yml = getCfg().getYml();
        yml.options().header("This is a BedWars1058 Minigame Addon by andrei1058.");
        yml.addDefault("gameWin.enable", true);
        yml.addDefault("gameWin.console", Arrays.asList("say {player} is one of the winners :D"));
        yml.addDefault("gameWin.player", Arrays.asList("me I won!"));
        yml.addDefault("finalKill.killer.enable", true);
        yml.addDefault("finalKill.killer.console", Arrays.asList("say {killer} killed {victim}"));
        yml.addDefault("finalKill.killer.player", Arrays.asList("me {killer} killed {victim}"));
        yml.addDefault("finalKill.victim.enable", true);
        yml.addDefault("finalKill.victim.console", Arrays.asList("say {victim} was killed by {killer}"));
        yml.addDefault("finalKill.victim.player", Arrays.asList("me {victim} was killed by {killer}"));
        yml.options().copyDefaults(true);
        getCfg().save();
    }

    public static Main getPlugin() {
        return plugin;
    }

    public static ConfigManager getCfg() {
        return cfg;
    }
}
