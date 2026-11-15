package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.EnumWrappers;
import itemsadder.m.adb;
import itemsadder.m.ae;
import itemsadder.m.bbe;
import itemsadder.m.bce;
import itemsadder.m.xe;
import itemsadder.m.xk;
import itemsadder.m.xm;
import net.kyori.adventure.text.Component;

class xh
extends PacketAdapter {
    xh(xe xe2, PacketAdapter.AdapterParameteters adapterParameteters) {
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        Component component;
        PacketContainer packetContainer = packetEvent.getPacket();
        if (packetContainer.getChatTypes().read(0) == EnumWrappers.ChatType.GAME_INFO) {
            return;
        }
        StructureModifier structureModifier = packetContainer.getModifier();
        Object object = structureModifier.read(Version.isAtLeast((Version)Version.v1_21_5) ? 5 : 4);
        if (object == null) {
            Object object2 = packetContainer.getModifier().read(Version.isAtLeast((Version)Version.v1_21_5) ? 4 : 3);
            String string = adb.tp().d(object2);
            if (!(ae.eE && xk.dk(string) || ae.fr && xm.dk(string))) {
                return;
            }
            component = bbe.gF(string);
        } else {
            String string = bbe.g(object);
            if (!(ae.eE && xk.dk(string) || ae.fr && xm.dk(string))) {
                return;
            }
            component = bbe.F(object);
        }
        if (component == null) {
            bce.error("Player chat component is null, this is a bug.");
            return;
        }
        if (ae.eN) {
            component = xm.h(component);
        }
        if (ae.eE) {
            component = xk.a(component, ae.eF, xe.Sf);
        }
        object = bbe.r(component);
        packetContainer.getModifier().write(Version.isAtLeast((Version)Version.v1_21_5) ? 5 : 4, object);
    }
}
