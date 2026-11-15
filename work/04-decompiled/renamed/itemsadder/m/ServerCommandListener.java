package itemsadder.m;

import itemsadder.m.CommandSenderBridge_2;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PluginContract;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.plugin.Plugin;

public class ServerCommandListener
implements PluginContract {
    private final CommandSenderBridge_2 ayK;

    public ServerCommandListener(Plugin plugin, CommandSenderBridge_2 commandSenderBridge_2) {
        this.ayK = commandSenderBridge_2;
        ListenerBridge.a(this, plugin);
    }

    public void bU() {
        ListenerBridge.b(this);
    }

    @EventHandler
    private void b(ServerCommandEvent serverCommandEvent) {
        if (!this.ayK.ayI) {
            return;
        }
        if (serverCommandEvent.getCommand().equalsIgnoreCase("acceptprivacy")) {
            this.ayK.b(serverCommandEvent.getSender(), true);
            serverCommandEvent.setCancelled(true);
        } else if (serverCommandEvent.getCommand().equalsIgnoreCase("declineprivacy")) {
            this.ayK.b(serverCommandEvent.getSender(), false);
            serverCommandEvent.setCancelled(true);
        }
    }

    @EventHandler
    private void c(PlayerCommandPreprocessEvent playerCommandPreprocessEvent) {
        if (!this.ayK.ayI) {
            return;
        }
        if (playerCommandPreprocessEvent.getMessage().equalsIgnoreCase("/acceptprivacy")) {
            this.ayK.b((CommandSender)playerCommandPreprocessEvent.getPlayer(), true);
            playerCommandPreprocessEvent.setCancelled(true);
        } else if (playerCommandPreprocessEvent.getMessage().equalsIgnoreCase("/declineprivacy")) {
            this.ayK.b((CommandSender)playerCommandPreprocessEvent.getPlayer(), false);
            playerCommandPreprocessEvent.setCancelled(true);
        }
    }
}
