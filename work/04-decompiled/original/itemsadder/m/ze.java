package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketListener;
import dev.lone.itemsadder.Main;
import itemsadder.m.zf;
import org.bukkit.plugin.Plugin;

public class ze {
    public static void init() {
        ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener)new zf((Plugin)Main.rS(), PacketType.Play.Client.BLOCK_DIG));
    }
}
