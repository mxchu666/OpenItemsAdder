package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerJoinListener_2;
import itemsadder.m.PluginDisableListener;
import itemsadder.m.RecordOfValue_3;
import itemsadder.m.VersionHelper_3;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

class PacketListener_49
extends PacketAdapter {
    PacketListener_49(Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        Player player = packetEvent.getPlayer();
        if (VersionHelper_3.UQ && !PlayerJoinListener_2.x(player)) {
            return;
        }
        PacketContainer packetContainer = packetEvent.getPacket();
        RecordOfValue_3 recordOfValue_3 = PacketListenerRegistry.uN().e(packetContainer);
        PluginDisableListener.zQ.put(player, recordOfValue_3);
    }
}
