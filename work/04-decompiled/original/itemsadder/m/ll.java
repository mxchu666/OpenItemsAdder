package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;
import itemsadder.m.aow;
import itemsadder.m.lj;
import itemsadder.m.ln;
import org.bukkit.entity.Player;

class ll
extends PacketAdapter {
    final /* synthetic */ lj Ar;

    ll(lj lj2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.Ar = lj2;
        super(adapterParameteters);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        if (packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        PacketContainer packetContainer = packetEvent.getPacket();
        Player player2 = packetEvent.getPlayer();
        EnumWrappers.PlayerDigType playerDigType = aow.uN().d(packetEvent.getPacket());
        switch (playerDigType) {
            case START_DESTROY_BLOCK: {
                BlockPosition blockPosition = (BlockPosition)packetContainer.getBlockPositionModifier().getValues().get(0);
                this.Ar.Ap.computeIfAbsent(player2, player -> new ln(blockPosition, player.getWorld())).a(blockPosition);
                break;
            }
            case ABORT_DESTROY_BLOCK: 
            case STOP_DESTROY_BLOCK: {
                this.Ar.Ap.remove(player2);
            }
        }
    }
}
