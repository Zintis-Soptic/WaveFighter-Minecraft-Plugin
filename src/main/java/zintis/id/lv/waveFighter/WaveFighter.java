package zintis.id.lv.waveFighter;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import zintis.id.lv.waveFighter.command.CommandManager;
import zintis.id.lv.waveFighter.messager.Message;

import java.util.Objects;

public final class WaveFighter extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        CommandManager commandManager = new CommandManager(this);
        Objects.requireNonNull(getCommand("startwave")).setExecutor(commandManager);
        Objects.requireNonNull(getCommand("wavekits")).setExecutor(commandManager);
        Objects.requireNonNull(getCommand("wavekit")).setExecutor(commandManager);

        this.getLogger().info(Message.INFO_PLUGIN_ENABLED);
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.sendMessage(Message.INFO_PLAYER_JOIN);
    }

}
