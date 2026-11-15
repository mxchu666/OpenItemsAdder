package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import itemsadder.m.ItemStackPlayerHolder;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PacketListenerRegistry;
import org.bukkit.plugin.Plugin;

class PacketListener_56
extends PacketAdapter {
    PacketListener_56(Plugin plugin, PacketType ... packetTypeArray) {
        super(plugin, packetTypeArray);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        EnumWrappers.PlayerDigType playerDigType = PacketListenerRegistry.uN().d(packetEvent.getPacket());
        if ((playerDigType.equals((Object)EnumWrappers.PlayerDigType.DROP_ITEM) || playerDigType.equals((Object)EnumWrappers.PlayerDigType.DROP_ALL_ITEMS)) && !ListenerBridge.b(new ItemStackPlayerHolder(packetEvent.getPlayer()))) {
            packetEvent.setCancelled(true);
            packetEvent.getPlayer().updateInventory();
        }
    }
}
