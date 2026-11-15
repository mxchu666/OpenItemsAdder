package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketListener;
import dev.lone.itemsadder.Main;
import itemsadder.m.PacketListener_56;
import org.bukkit.plugin.Plugin;

public class Opaque150 {
    public static void init() {
        ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener)new PacketListener_56((Plugin)Main.rS(), PacketType.Play.Client.BLOCK_DIG));
    }
}
