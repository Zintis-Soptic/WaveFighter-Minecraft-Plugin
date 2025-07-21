package zintis.id.lv.waveFighter.kit;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;
import zintis.id.lv.waveFighter.messager.Message;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KitLoader {

    private final JavaPlugin plugin;

    public KitLoader(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public List<Kit> loadKits(InputStream stream) {
        List<Kit> kits = new ArrayList<>();
        Yaml yaml = new Yaml();

        Map<String, Object> root = yaml.load(stream);
        if (root == null || !root.containsKey("kits")) {
            plugin.getLogger().warning(Message.ERROR_NO_KIT_FILE_FOUND);
            return kits;
        }

        Map<String, Object> kitMap = (Map<String, Object>) root.get("kits");

        for (Map.Entry<String, Object> entry : kitMap.entrySet()) {
            String kitName = entry.getKey();
            Kit kit = parseKit(kitName, (Map<String, Object>) entry.getValue());
            if (kit != null) kits.add(kit);
        }

        return kits;
    }

    private Kit parseKit(String kitName, Map<String, Object> kitData) {
        if (!kitData.containsKey("price") || !kitData.containsKey("items")) {
            plugin.getLogger().warning(String.format(Message.ERROR_KIT_MISSING_FIELDS, kitName));
            return null;
        }

        int price;
        try {
            price = (int) kitData.get("price");
        } catch (ClassCastException e) {
            plugin.getLogger().warning(String.format(Message.ERROR_KIT_INVALID_PRICE, kitName));
            return null;
        }

        List<?> itemsRaw = (List<?>) kitData.get("items");
        List<ItemStack> items = parseItems(itemsRaw, kitName);

        return new Kit(kitName, price, items);
    }

    private List<ItemStack> parseItems(List<?> itemsRaw, String kitName) {
        List<ItemStack> items = new ArrayList<>();

        for (Object itemObj : itemsRaw) {
            if (!(itemObj instanceof Map)) continue;

            Map<String, Object> item = (Map<String, Object>) itemObj;
            String type = (String) item.get("type");

            if (type == null || !item.containsKey("amount")) continue;

            int amount;
            try {
                amount = (int) item.get("amount");
            } catch (ClassCastException e) {
                plugin.getLogger().warning(String.format(Message.ERROR_ITEM_INVALID_AMOUNT, kitName));
                continue;
            }

            try {
                items.add(new ItemStack(Material.valueOf(type.toUpperCase()), amount));
            } catch (IllegalArgumentException e) {
                plugin.getLogger().warning(String.format(Message.ERROR_INVALID_MATERIAL, type, kitName));
            }
        }

        return items;
    }
}
