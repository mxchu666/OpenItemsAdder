package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.adb;
import itemsadder.m.ae;
import itemsadder.m.bbe;
import itemsadder.m.bce;
import itemsadder.m.bch;
import itemsadder.m.xe;
import itemsadder.m.xk;
import itemsadder.m.xm;
import net.kyori.adventure.text.Component;

class xg
extends PacketAdapter {
    final /* synthetic */ xe Sn;

    xg(xe xe2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.Sn = xe2;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        Object object;
        PacketContainer packetContainer = packetEvent.getPacket();
        if (adb.b(packetContainer)) {
            return;
        }
        int n = -1;
        if (ae.eD && (object = (PacketContainer)this.Sn.gf.getIfPresent(n = adb.c(packetContainer).intValue())) != null) {
            adb.a((PacketContainer)object, packetContainer);
            return;
        }
        object = packetContainer.getModifier().read(0);
        String string = bbe.g(object);
        if (!(ae.eE && xk.dk(string) || ae.fr && xm.dk(string))) {
            return;
        }
        Component component = bbe.F(object);
        if (component == null) {
            bce.iA("System chat component is null, ignoring.");
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
            this.Sn.gf.put(n, packetContainer);
        }
    }
}
