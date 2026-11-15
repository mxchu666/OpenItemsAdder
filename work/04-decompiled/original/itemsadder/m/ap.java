package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.version.ServerProtocolVersion;
import com.viaversion.viaversion.protocol.ServerProtocolVersionSingleton;
import dev.lone.itemsadder.Main;
import itemsadder.m.ae;
import itemsadder.m.bce;
import itemsadder.m.bev;
import itemsadder.m.d;
import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class ap
implements Listener {
    private static boolean registered = false;

    public static void register() {
        if (registered) {
            return;
        }
        bev.b(new ap(), (Plugin)Main.rS());
        registered = true;
    }

    public static boolean w(Player player) {
        if (!registered) {
            return Version.get().ordinal() < Version.v1_20_5.ordinal();
        }
        return Via.getAPI().getPlayerVersion(player.getUniqueId()) < Version.v1_20_5.ordinal();
    }

    public static boolean x(Player player) {
        if (!registered) {
            return Version.get().ordinal() >= Version.v1_21_3.ordinal();
        }
        return Via.getAPI().getPlayerVersion(player.getUniqueId()) >= Version.v1_21_3.ordinal();
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void c(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        ServerProtocolVersion serverProtocolVersion = Via.getAPI().getServerVersion();
        if (serverProtocolVersion instanceof ServerProtocolVersionSingleton) {
            ServerProtocolVersionSingleton serverProtocolVersionSingleton = (ServerProtocolVersionSingleton)serverProtocolVersion;
            int n = Via.getAPI().getPlayerVersion(player.getUniqueId());
            if (serverProtocolVersionSingleton.highestSupportedVersion() != n) {
                bce.warn("'" + player.getName() + "' is using a different protocol version of the game (" + n + ") than the server (" + serverProtocolVersionSingleton.highestSupportedVersion() + "). This may cause gameplay and graphical issues. Consider to avoid multi-version servers. Read more here: https://a.devs.beer/modern-model-viav");
            }
            ArrayList<String> arrayList = new ArrayList<String>();
            if (n < Version.v1_21_4.ordinal()) {
                if (d.g().bl) {
                    arrayList.add("modern items (1.21.4+ only)");
                }
                if (ae.dy) {
                    arrayList.add("modern emotes (1.21.4+ only)");
                }
                if (d.g().V.hf() > 0) {
                    arrayList.add("ENTITY blocks (1.21.4+ only)");
                }
            }
            if (!arrayList.isEmpty()) {
                bce.warn("Limitations: " + String.join((CharSequence)", ", arrayList));
            }
        }
    }

    public static boolean y(Player player) {
        if (!registered) {
            return Version.get().ordinal() >= Version.v1_21_4.ordinal();
        }
        return Via.getAPI().getPlayerVersion(player.getUniqueId()) >= Version.v1_21_4.ordinal();
    }
}
