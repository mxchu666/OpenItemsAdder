package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.aow;
import itemsadder.m.lj;

class lk
extends PacketAdapter {
    final /* synthetic */ lj Aq;

    lk(lj lj2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.Aq = lj2;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        Object object = packetEvent.getPacket().getHandle();
        String string = aow.uN().j(object);
        if (this.Aq.An.containsKey(string)) {
            aow.uN().c(object, this.Aq.An.get(string));
        }
    }
}
