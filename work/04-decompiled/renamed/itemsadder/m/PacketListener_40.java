package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;
import itemsadder.m.LocationBoundingBoxHolder;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerInteractListener;
import org.bukkit.plugin.Plugin;

class PacketListener_40
extends PacketAdapter {
    final /* synthetic */ PlayerInteractListener kT;

    PacketListener_40(PlayerInteractListener playerInteractListener, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        this.kT = playerInteractListener;
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        if (!this.kT.cU() || packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        EnumWrappers.PlayerDigType playerDigType = PacketListenerRegistry.uN().d(packetEvent.getPacket());
        if (!PacketListenerRegistry.a(playerDigType)) {
            return;
        }
        LocationBoundingBoxHolder locationBoundingBoxHolder = this.kT.kQ.F(packetEvent.getPlayer());
        if (locationBoundingBoxHolder == null) {
            return;
        }
        BlockPosition blockPosition = (BlockPosition)packetEvent.getPacket().getBlockPositionModifier().read(0);
        if (locationBoundingBoxHolder.e(blockPosition.getX(), blockPosition.getY(), blockPosition.getZ())) {
            packetEvent.setCancelled(true);
        }
    }
}
