package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import itemsadder.m.ae;
import itemsadder.m.bbe;
import itemsadder.m.bce;
import itemsadder.m.bch;
import itemsadder.m.xe;
import itemsadder.m.xk;
import itemsadder.m.xm;
import java.util.Objects;
import net.kyori.adventure.text.Component;

class xf
extends PacketAdapter {
    final /* synthetic */ xe Sm;

    xf(xe xe2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.Sm = xe2;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        String string;
        Object object;
        PacketContainer packetContainer = packetEvent.getPacket();
        int n = -1;
        if (ae.eD) {
            object = packetEvent.getPacket().getModifier();
            n = Objects.hash(object.read(0) == null ? null : Integer.valueOf(object.read(0).hashCode()));
            string = (PacketContainer)this.Sm.gf.getIfPresent(n);
            if (string != null) {
                StructureModifier structureModifier = string.getModifier();
                object.write(0, structureModifier.read(0));
                return;
            }
        }
        object = packetContainer.getModifier().read(0);
        string = bbe.g(object);
        bce.iA(string);
        if (ae.eE && !xk.dk(string) && ae.eN && !xm.dk(string)) {
            return;
        }
        Component component = bbe.F(object);
        if (component == null) {
            bce.iA("Disguised chat component is null, ignoring.");
            return;
        }
        bch bch2 = bch.G(false);
        if (ae.eE) {
            component = xk.a(null, component, ae.eF, xe.Sf, bch2);
        }
        if (ae.eN) {
            component = xm.a(component, bch2);
        }
        if (!((Boolean)bch2.aAW).booleanValue()) {
            return;
        }
        packetContainer.getModifier().write(0, bbe.r(component));
        if (ae.eD) {
            this.Sm.gf.put(n, packetContainer);
        }
    }
}
