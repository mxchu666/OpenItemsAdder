package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import itemsadder.m.aow;
import itemsadder.m.bev;
import itemsadder.m.zj;
import org.bukkit.plugin.Plugin;

class zf
extends PacketAdapter {
    zf(Plugin plugin, PacketType ... packetTypeArray) {
        super(plugin, packetTypeArray);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        EnumWrappers.PlayerDigType playerDigType = aow.uN().d(packetEvent.getPacket());
        if ((playerDigType.equals((Object)EnumWrappers.PlayerDigType.DROP_ITEM) || playerDigType.equals((Object)EnumWrappers.PlayerDigType.DROP_ALL_ITEMS)) && !bev.b(new zj(packetEvent.getPlayer()))) {
            packetEvent.setCancelled(true);
            packetEvent.getPlayer().updateInventory();
        }
    }
}
