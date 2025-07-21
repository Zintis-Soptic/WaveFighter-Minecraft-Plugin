package zintis.id.lv.waveFighter.messager;

import org.bukkit.ChatColor;

public class Message {

    public static String PLUGIN_NAME = "[Wave Fighter]";

    // Info messages
    public static String INFO_PLUGIN_ENABLED = ChatColor.GREEN + "----- Wave Fighter plugin has been enabled successfully -----";
    public static String INFO_PLAYER_JOIN = ChatColor.DARK_RED + PLUGIN_NAME + " To Start the Game Type '/startwave'";
    public static String INFO_SELECT_KIT = ChatColor.DARK_GREEN + PLUGIN_NAME + " Type '/wavekit [KIT_NAME]' to Select a Kit \n ";
    public static String INFO_WAVE_START = ChatColor.DARK_GREEN + PLUGIN_NAME + " Wave Has Been Started";

    // Success messages
    public static String SUCCESS_KIT_SELECTED = ChatColor.DARK_RED + " Kit has Been Selected";
    public static String SUCCESS_WAVE_STARTED = ChatColor.GREEN + PLUGIN_NAME + " Wave Started Successfully";
    public static String SUCCESS_KIT_LOADED = ChatColor.GREEN + "Kit '%s' loaded successfully!";

    // Error messages
    public static String ERROR_KIT_NOT_FOUND = ChatColor.DARK_GREEN + PLUGIN_NAME + ChatColor.DARK_RED + " Kit not Found";
    public static String ERROR_PLAYER_ONLY_COMMAND = ChatColor.DARK_GREEN + PLUGIN_NAME + ChatColor.DARK_RED + " Only players can use this command!";
    public static String ERROR_NO_KIT_NAME_SPECIFIED = ChatColor.DARK_GREEN + PLUGIN_NAME + ChatColor.DARK_RED + " You must specify a kit name";
    public static String ERROR_NO_KIT_FILE_FOUND = ChatColor.DARK_RED + "'Kits.yml' Not Found";
    public static String ERROR_INVALID_MATERIAL = ChatColor.DARK_RED + "Invalid material: %s in kit '%s'";
    public static String ERROR_KIT_LOADING = ChatColor.DARK_RED + "Failed to load kit '%s'. Please check the configuration.";

    // Kit YAML parsing validation
    public static String ERROR_KIT_MISSING_FIELDS = PLUGIN_NAME + " Kit '%s' is missing 'price' or 'items'.";
    public static String ERROR_KIT_INVALID_PRICE = PLUGIN_NAME + " Invalid price type in kit '%s'. Must be an integer.";
    public static String ERROR_ITEM_INVALID_AMOUNT = PLUGIN_NAME + " Invalid 'amount' type for item in kit '%s'. Skipping item.";

    // Kits list message
    public static String WAVE_KITS_LIST = ChatColor.DARK_GREEN + PLUGIN_NAME + " Kits: \n ";
}
