package zintis.id.lv.waveFighter.kit;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import zintis.id.lv.waveFighter.messager.Message;

import java.io.InputStream;
import java.util.*;

public class KitManager {

    private final KitLoader kitLoader;
    private final List<Kit> loadedKits = new ArrayList<>();

    private final JavaPlugin plugin;

    public KitManager(JavaPlugin plugin) {
        this.plugin = plugin;
        kitLoader = new KitLoader(plugin);

        InputStream stream = plugin.getResource("Kits.yml");
        if (stream == null) {
            plugin.getLogger().warning(Message.ERROR_NO_KIT_FILE_FOUND);
            return;
        }

        loadedKits.addAll(kitLoader.loadKits(stream));
    }

    public List<Kit> getLoadedKits() {
        return Collections.unmodifiableList(loadedKits);
    }

    public Kit getKitByName(String name) {
        for (Kit kit : loadedKits) {
            if (kit.getName().equalsIgnoreCase(name)) {
                return kit;
            }
        }
        return null;
    }

    public void giveKitToPlayer(Player player, Kit kit) {
        if (player == null || kit == null) return;

        for (ItemStack item : kit.getItems()) {
            player.getInventory().addItem(item.clone());
        }

        player.sendMessage(ChatColor.AQUA + kit.getName() + Message.SUCCESS_KIT_SELECTED);
        player.setDisplayName(ChatColor.BLACK + "[" + kit.getName() + "] " + player.getName());
    }
}
