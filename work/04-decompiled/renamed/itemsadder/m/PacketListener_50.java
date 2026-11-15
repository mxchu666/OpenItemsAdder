package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.GenericGameListener;
import itemsadder.m.PacketListenerRegistry;

class PacketListener_50
extends PacketAdapter {
    final /* synthetic */ GenericGameListener Aq;

    PacketListener_50(GenericGameListener genericGameListener, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.Aq = genericGameListener;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        Object object = packetEvent.getPacket().getHandle();
        String string = PacketListenerRegistry.uN().j(object);
        if (this.Aq.An.containsKey(string)) {
            PacketListenerRegistry.uN().c(object, this.Aq.An.get(string));
        }
    }
}
