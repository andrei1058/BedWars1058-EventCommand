package com.andrei1058.bedwars.cmds;

public class ConfigPath {

    private static final String GAME_WIN_PATH = "game-win";

    public static String GAME_WIN_ENABLE = GAME_WIN_PATH + ".enable";
    private static final String GAME_WIN_FOR_EACH_WINNER = GAME_WIN_PATH + ".for-each-winner";
    public static String GAME_WIN_WINNER_CMDS_AS_PLAYER = GAME_WIN_FOR_EACH_WINNER + ".execute-as-player";
    public static String GAME_WIN_WINNER_CMDS_AS_CONSOLE = GAME_WIN_FOR_EACH_WINNER + ".execute-as-console";

    private static final String REGULAR_KILL_PATH = "regular-kill";
    private static final String REGULAR_KILL_FOR_KILLER = REGULAR_KILL_PATH + ".for-killer";
    public static String REGULAR_KILL_FOR_KILLER_ENABLE = REGULAR_KILL_FOR_KILLER + ".enable";
    public static String REGULAR_KILL_KILLER_AS_PLAYER = REGULAR_KILL_FOR_KILLER + ".execute-as-player";
    public static String REGULAR_KILL_KILLER_AS_CONSOLE = REGULAR_KILL_FOR_KILLER + ".execute-as-console";

    private static final String REGULAR_KILL_FOR_VICTIM_WITH_KILLER = REGULAR_KILL_PATH + ".for-victim-with-killer";
    public static String REGULAR_KILL_FOR_VICTIM_WITH_KILLER_ENABLE = REGULAR_KILL_FOR_VICTIM_WITH_KILLER + ".enable";
    public static String REGULAR_KILL_VICTIM_WITH_KILLER_AS_PLAYER = REGULAR_KILL_FOR_VICTIM_WITH_KILLER + ".execute-as-player";
    public static String REGULAR_KILL_VICTIM_WITH_KILLER_AS_CONSOLE = REGULAR_KILL_FOR_VICTIM_WITH_KILLER + ".execute-as-console";

    private static final String REGULAR_KILL_FOR_VICTIM_NO_KILLER = REGULAR_KILL_PATH + ".for-victim-without-killer";
    public static String REGULAR_KILL_FOR_VICTIM_NO_KILLER_ENABLE = REGULAR_KILL_FOR_VICTIM_NO_KILLER + ".enable";
    public static String REGULAR_KILL_VICTIM_NO_KILLER_AS_PLAYER = REGULAR_KILL_FOR_VICTIM_NO_KILLER + ".execute-as-player";
    public static String REGULAR_KILL_VICTIM_NO_KILLER_AS_CONSOLE = REGULAR_KILL_FOR_VICTIM_NO_KILLER + ".execute-as-console";

    private static final String FINAL_KILL_PATH = "regular-kill";
    private static final String FINAL_KILL_FOR_KILLER = FINAL_KILL_PATH + ".for-killer";
    public static String FINAL_KILL_FOR_KILLER_ENABLE = FINAL_KILL_FOR_KILLER + ".enable";
    public static String FINAL_KILL_KILLER_AS_PLAYER = FINAL_KILL_FOR_KILLER + ".execute-as-player";
    public static String FINAL_KILL_KILLER_AS_CONSOLE = FINAL_KILL_FOR_KILLER + ".execute-as-console";

    private static final String FINAL_KILL_FOR_VICTIM_WITH_KILLER = FINAL_KILL_PATH + ".for-victim-with-killer";
    public static String FINAL_KILL_FOR_VICTIM_WITH_KILLER_ENABLE = FINAL_KILL_FOR_VICTIM_WITH_KILLER + ".enable";
    public static String FINAL_KILL_VICTIM_WITH_KILLER_AS_PLAYER = FINAL_KILL_FOR_VICTIM_WITH_KILLER + ".execute-as-player";
    public static String FINAL_KILL_VICTIM_WITH_KILLER_AS_CONSOLE = FINAL_KILL_FOR_VICTIM_WITH_KILLER + ".execute-as-console";

    private static final String FINAL_KILL_FOR_VICTIM_NO_KILLER = FINAL_KILL_PATH + ".for-victim-without-killer";
    public static String FINAL_KILL_FOR_VICTIM_NO_KILLER_ENABLE = FINAL_KILL_FOR_VICTIM_NO_KILLER + ".enable";
    public static String FINAL_KILL_VICTIM_NO_KILLER_AS_PLAYER = FINAL_KILL_FOR_VICTIM_NO_KILLER + ".execute-as-player";
    public static String FINAL_KILL_VICTIM_NO_KILLER_AS_CONSOLE = FINAL_KILL_FOR_VICTIM_NO_KILLER + ".execute-as-console";

    private static final String BED_DESTROY_PATH = "bed-destroy";

    public static String BED_DESTROY_ENABLE = BED_DESTROY_PATH + ".enable";
    private static final String BED_DESTROY_FOR_DESTROYER = BED_DESTROY_PATH + ".for-destroyer-player";
    public static String BED_DESTROY_FOR_DESTROYER_AS_PLAYER = BED_DESTROY_FOR_DESTROYER + ".execute-as-player";
    public static String BED_DESTROY_FOR_DESTROYER_CONSOLE = BED_DESTROY_FOR_DESTROYER + ".execute-as-console";

    private static final String BED_DESTROY_FOR_DESTROYERS = BED_DESTROY_PATH + ".for-destroyer-team";
    public static String BED_DESTROY_FOR_DESTROYERS_AS_PLAYER = BED_DESTROY_FOR_DESTROYERS + ".execute-as-player";
    public static String BED_DESTROY_FOR_DESTROYERS_CONSOLE = BED_DESTROY_FOR_DESTROYERS + ".execute-as-console";
}
