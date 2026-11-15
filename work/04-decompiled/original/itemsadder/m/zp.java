package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketListener;
import itemsadder.m.zq;
import itemsadder.m.zr;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class zp {
    private static final int Um = 9;
    private static final int Un = 4;
    private static final String Uo = "{\"text\":\"%s\"}";
    private static final String Up = "minecraft:sign";
    private final Plugin Uq;
    private final Map Ur;
    private final Map Us;
    final PacketAdapter Ut;

    public zp(Plugin plugin) {
        this.Uq = plugin;
        this.Ur = new HashMap();
        this.Us = new HashMap();
        this.Ut = new zq(this, this.Uq, PacketType.Play.Client.UPDATE_SIGN);
        this.lG();
    }

    public zr a(Player player, List list) {
        Objects.requireNonNull(player, "player");
        Objects.requireNonNull(list, "text");
        zr zr2 = new zr(player, list);
        zr2.b(blockPosition -> {
            this.Us.put(player, blockPosition);
            this.Ur.putIfAbsent(player, zr2);
        });
        return zr2;
    }

    private void lG() {
        ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener)this.Ut);
    }
}
