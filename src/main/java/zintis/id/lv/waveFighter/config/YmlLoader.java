package zintis.id.lv.waveFighter.config;

import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static zintis.id.lv.waveFighter.messager.Message.*;

public class YmlLoader {

    private final JavaPlugin plugin;

    public YmlLoader(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public Map<String, Object> load(String resourceFileName) {
        Map<String, Object> root = new HashMap<>();

        if (!isResourceFileNameValid(resourceFileName)) {
            return root;
        }

        Yaml yaml = new Yaml();
        try (InputStream stream = plugin.getResource(resourceFileName.toLowerCase().trim())) {
            if (stream == null) {
                plugin.getLogger().warning(String.format(ERROR_RESOURCE_FILE_NOT_FOUND, resourceFileName));
                return root;
            }
            return yaml.load(stream);
        } catch (Exception e) {
            plugin.getLogger().severe(String.format(ERROR_FAILED_TO_LOAD_RESOURCE_FILE, resourceFileName) + "\n" + e.getMessage());
            return root;
        }
    }

    private boolean isResourceFileNameValid(String resourceFileName) {
        if (resourceFileName == null || resourceFileName.isEmpty()) {
            plugin.getLogger().warning(ERROR_INVALID_RESOURCE_FILE_NAME);
            return false;
        }
        return resourceFileName.endsWith(".yml") || resourceFileName.endsWith(".yaml");
    }
}
