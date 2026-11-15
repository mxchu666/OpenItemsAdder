package itemsadder.m;

import itemsadder.m.ai;
import itemsadder.m.azv;
import itemsadder.m.bev;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.plugin.Plugin;

public class baa
implements ai {
    private final azv ayK;

    public baa(Plugin plugin, azv azv2) {
        this.ayK = azv2;
        bev.a(this, plugin);
    }

    public void bU() {
        bev.b(this);
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
