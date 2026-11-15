package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.PacketAdapterHolder;
import itemsadder.m.PacketListenerRegistry;

class PacketListener_55
extends PacketAdapter {
    PacketListener_55(PacketAdapterHolder packetAdapterHolder, PacketAdapter.AdapterParameteters adapterParameteters) {
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        PacketListenerRegistry.uN().g(packetEvent.getPacket());
    }
}
