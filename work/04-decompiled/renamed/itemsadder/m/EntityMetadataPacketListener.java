package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.EntityHolder;
import itemsadder.m.PlayerJoinListener;

class EntityMetadataPacketListener
extends PacketAdapter {
    EntityMetadataPacketListener(PlayerJoinListener playerJoinListener, PacketAdapter.AdapterParameteters adapterParameteters) {
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        if (PlayerJoinListener.Vi.contains(packetEvent.getPacket().getIntegers().read(0)) && packetEvent.getPacket().getType() == PacketType.Play.Server.ENTITY_METADATA) {
            EntityHolder.tK().a(packetEvent, true);
        }
    }
}
