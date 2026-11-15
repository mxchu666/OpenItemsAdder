package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketListener;
import itemsadder.m.PacketListener_57;
import itemsadder.m.PlayerBridge_32;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PacketAdapterHelper {
    private static final int Um = 9;
    private static final int Un = 4;
    private static final String Uo = "{\"text\":\"%s\"}";
    private static final String Up = "minecraft:sign";
    private final Plugin Uq;
    private final Map Ur;
    private final Map Us;
    final PacketAdapter Ut;

    public PacketAdapterHelper(Plugin plugin) {
        this.Uq = plugin;
        this.Ur = new HashMap();
        this.Us = new HashMap();
        this.Ut = new PacketListener_57(this, this.Uq, PacketType.Play.Client.UPDATE_SIGN);
        this.lG();
    }

    public PlayerBridge_32 a(Player player, List list) {
        Objects.requireNonNull(player, "player");
        Objects.requireNonNull(list, "text");
        PlayerBridge_32 playerBridge_32 = new PlayerBridge_32(player, list);
        playerBridge_32.b(blockPosition -> {
            this.Us.put(player, blockPosition);
            this.Ur.putIfAbsent(player, playerBridge_32);
        });
        return playerBridge_32;
    }

    private void lG() {
        ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener)this.Ut);
    }
}
