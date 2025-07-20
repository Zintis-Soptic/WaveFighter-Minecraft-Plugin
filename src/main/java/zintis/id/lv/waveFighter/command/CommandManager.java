package zintis.id.lv.waveFighter.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import zintis.id.lv.waveFighter.kit.Kit;
import zintis.id.lv.waveFighter.kit.KitManager;
import zintis.id.lv.waveFighter.messager.Message;

public class CommandManager implements CommandExecutor {

    private final KitManager kitManager;
    private final JavaPlugin plugin;

    public CommandManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.kitManager = new KitManager(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String sentCommand = command.getName().toLowerCase().trim();

        return switch (sentCommand) {
            case "startwave" -> {
                sender.sendMessage(Message.INFO_WAVE_START);
                yield true;
            }
            case "wavekits" -> {
                sender.sendMessage(Message.WAVE_KITS_LIST);

                for (Kit kit : kitManager.getLoadedKits()) {
                    sender.sendMessage(ChatColor.AQUA + " - " + kit.getName() + "\n");
                }
                sender.sendMessage("\n" + Message.INFO_SELECT_KIT);
                yield true;
            }
            case "wavekit" -> {
                // Prevent non-players (Command block and Console) of using '/wavekit' command.
                if (!(sender instanceof Player player)) {
                    sender.sendMessage(Message.ERROR_PLAYER_ONLY_COMMAND);
                    yield true;
                }

                if (args.length == 0) {
                    player.sendMessage(Message.ERROR_NO_KIT_NAME_SPECIFIED);
                    yield true;
                }

                String kitName = args[0];
                Kit selectedKit = kitManager.getKitByName(kitName);
                if (selectedKit != null) {
                    kitManager.giveKitToPlayer((Player) sender, selectedKit);
                } else {
                    sender.sendMessage(Message.ERROR_KIT_NOT_FOUND);
                }
                yield true;
            }
            default -> false;
        };
    }
}
