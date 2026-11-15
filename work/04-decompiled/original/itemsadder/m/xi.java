package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.ae;
import itemsadder.m.bbe;
import itemsadder.m.bce;
import itemsadder.m.bch;
import itemsadder.m.xe;
import itemsadder.m.xk;
import itemsadder.m.xm;
import itemsadder.m.zv;
import net.kyori.adventure.text.Component;

class xi
extends PacketAdapter {
    xi(xe xe2, PacketAdapter.AdapterParameteters adapterParameteters) {
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        Object object = zv.bA(packetEvent.getPlayer());
        if (object != null) {
            packetEvent.getPacket().getModifier().write(2, object);
            zv.bB(packetEvent.getPlayer());
            return;
        }
        if (ae.da) {
            Component component = bbe.F(packetEvent.getPacket().getModifier().read(2));
            if (component == null) {
                bce.iA("Disguised chat component is null, ignoring.");
                return;
            }
            bch bch2 = bch.G(false);
            component = xk.a(component, bch2);
            if (ae.fr) {
                component = xm.a(component, bch2);
            }
            if (!((Boolean)bch2.aAW).booleanValue()) {
                return;
            }
            packetEvent.getPacket().getModifier().write(2, bbe.r(component));
        }
    }
}
