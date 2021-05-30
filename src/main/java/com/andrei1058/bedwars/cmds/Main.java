package com.andrei1058.bedwars.cmds;

import com.andrei1058.bedwars.api.BedWars;
import com.andrei1058.bedwars.api.configuration.ConfigManager;
import com.andrei1058.bedwars.cmds.listeners.BedDestroyListener;
import com.andrei1058.bedwars.cmds.listeners.FinalKillsListener;
import com.andrei1058.bedwars.cmds.listeners.RegularKillsListener;
import com.andrei1058.bedwars.cmds.listeners.WinListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Main extends JavaPlugin implements Listener {

    private static Main plugin;
    private static ConfigManager cfg;
    public static BedWars api;

    public void onEnable() {
        plugin = this;

        /** Check if bw plugin is loaded */
        if (Bukkit.getPluginManager().getPlugin("BedWars1058") == null) {
            this.getLogger().severe("I can't run without BedWars1058 Plugin!");
            this.setEnabled(false);
            return;
        }

        try {
            Class.forName("com.andrei1058.bedwars.api.BedWars");
        } catch (Exception ex){
            getLogger().severe("Your BedWars1058 version is outdated. Please download the latest version!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        api = Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider();

        /* Setup configuration */
        cfg = new ConfigManager(this, "config", "plugins/BedWars1058/Addons/Cmds");
        setupConfiguration();

        /* Register listeners */
        if (getCfg().getBoolean(ConfigPath.GAME_WIN_ENABLE)) {
            Bukkit.getPluginManager().registerEvents(new WinListener(), getPlugin());
        }
        if (getCfg().getBoolean(ConfigPath.REGULAR_KILL_FOR_KILLER_ENABLE)
                || getCfg().getBoolean(ConfigPath.REGULAR_KILL_FOR_VICTIM_NO_KILLER_ENABLE)
                || getCfg().getBoolean(ConfigPath.REGULAR_KILL_FOR_VICTIM_WITH_KILLER_ENABLE)) {
            Bukkit.getPluginManager().registerEvents(new RegularKillsListener(), getPlugin());
        }
        if (getCfg().getBoolean(ConfigPath.FINAL_KILL_FOR_KILLER_ENABLE)
                || getCfg().getBoolean(ConfigPath.FINAL_KILL_FOR_VICTIM_NO_KILLER_ENABLE)
                || getCfg().getBoolean(ConfigPath.FINAL_KILL_FOR_VICTIM_WITH_KILLER_ENABLE)) {
            Bukkit.getPluginManager().registerEvents(new FinalKillsListener(), getPlugin());
        }
        if (getCfg().getBoolean(ConfigPath.BED_DESTROY_ENABLE)) {
            Bukkit.getPluginManager().registerEvents(new BedDestroyListener(), getPlugin());
        }
    }

    private static void setupConfiguration() {
        YamlConfiguration yml = getCfg().getYml();
        yml.options().header("This is a BedWars1058 mini-game add-on by andrei1058." +
                "\nDocumentation here: https://gitlab.com/bedwars-addons/bedwars1058-rewardcmds/wikis/home");

        yml.addDefault(ConfigPath.GAME_WIN_ENABLE, true);
        yml.addDefault(ConfigPath.GAME_WIN_WINNER_CMDS_AS_PLAYER, Arrays.asList("me I won on arena {arenaDisplay}!"));
        yml.addDefault(ConfigPath.GAME_WIN_WINNER_CMDS_AS_CONSOLE, Arrays.asList("eco give {player} 100"));

        yml.addDefault(ConfigPath.REGULAR_KILL_FOR_KILLER_ENABLE, true);
        yml.addDefault(ConfigPath.REGULAR_KILL_KILLER_AS_PLAYER, Arrays.asList("me {victim}aws killed by me on arena {displayArena}!"));
        yml.addDefault(ConfigPath.REGULAR_KILL_KILLER_AS_CONSOLE, Arrays.asList("eco give {killer} 30"));
        yml.addDefault(ConfigPath.REGULAR_KILL_FOR_VICTIM_WITH_KILLER_ENABLE, true);
        yml.addDefault(ConfigPath.REGULAR_KILL_VICTIM_WITH_KILLER_AS_PLAYER, Arrays.asList("me I was killed by {killer} on arena {arenaDisplay}"));
        yml.addDefault(ConfigPath.REGULAR_KILL_VICTIM_WITH_KILLER_AS_CONSOLE, Arrays.asList("eco give {victim} 5"));
        yml.addDefault(ConfigPath.REGULAR_KILL_FOR_VICTIM_NO_KILLER_ENABLE, true);
        yml.addDefault(ConfigPath.REGULAR_KILL_VICTIM_NO_KILLER_AS_PLAYER, Arrays.asList("me I died like a noob!"));
        yml.addDefault(ConfigPath.REGULAR_KILL_VICTIM_NO_KILLER_AS_CONSOLE, Arrays.asList("eco give {victim} 1"));

        yml.addDefault(ConfigPath.FINAL_KILL_FOR_KILLER_ENABLE, true);
        yml.addDefault(ConfigPath.FINAL_KILL_KILLER_AS_PLAYER, Arrays.asList("me {victim}aws killed by me on arena {displayArena}!"));
        yml.addDefault(ConfigPath.FINAL_KILL_KILLER_AS_CONSOLE, Arrays.asList("eco give {killer} 30"));
        yml.addDefault(ConfigPath.FINAL_KILL_FOR_VICTIM_WITH_KILLER_ENABLE, true);
        yml.addDefault(ConfigPath.FINAL_KILL_VICTIM_WITH_KILLER_AS_PLAYER, Arrays.asList("me I was killed by {killer} on arena {arenaDisplay}"));
        yml.addDefault(ConfigPath.FINAL_KILL_VICTIM_WITH_KILLER_AS_CONSOLE, Arrays.asList("eco give {victim} 5"));
        yml.addDefault(ConfigPath.FINAL_KILL_FOR_VICTIM_NO_KILLER_ENABLE, true);
        yml.addDefault(ConfigPath.FINAL_KILL_VICTIM_NO_KILLER_AS_PLAYER, Arrays.asList("me I died like a noob!"));
        yml.addDefault(ConfigPath.FINAL_KILL_VICTIM_NO_KILLER_AS_CONSOLE, Arrays.asList("eco give {victim} 1"));

        yml.addDefault(ConfigPath.BED_DESTROY_ENABLE, true);
        yml.addDefault(ConfigPath.BED_DESTROY_FOR_DESTROYER_AS_PLAYER, Arrays.asList("me Bed destroyed! Hahah"));
        yml.addDefault(ConfigPath.BED_DESTROY_FOR_DESTROYER_CONSOLE, Arrays.asList("eco give {victim} 5"));
        yml.addDefault(ConfigPath.BED_DESTROY_FOR_DESTROYERS_AS_PLAYER, Arrays.asList("me GG {victimTeam}"));
        yml.addDefault(ConfigPath.BED_DESTROY_FOR_DESTROYERS_CONSOLE, Arrays.asList("eco give {victim} 2"));

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
