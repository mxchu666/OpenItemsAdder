package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;
import itemsadder.m.aow;
import itemsadder.m.cg;
import itemsadder.m.co;
import org.bukkit.plugin.Plugin;

class cp
extends PacketAdapter {
    final /* synthetic */ co kT;

    cp(co co2, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        this.kT = co2;
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        if (!this.kT.cU() || packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        EnumWrappers.PlayerDigType playerDigType = aow.uN().d(packetEvent.getPacket());
        if (!aow.a(playerDigType)) {
            return;
        }
        cg cg2 = this.kT.kQ.F(packetEvent.getPlayer());
        if (cg2 == null) {
            return;
        }
        BlockPosition blockPosition = (BlockPosition)packetEvent.getPacket().getBlockPositionModifier().read(0);
        if (cg2.e(blockPosition.getX(), blockPosition.getY(), blockPosition.getZ())) {
            packetEvent.setCancelled(true);
        }
    }
}
