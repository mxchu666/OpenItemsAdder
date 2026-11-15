package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.aow;
import itemsadder.m.ap;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.pw;
import itemsadder.m.qb;
import java.util.Iterator;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;

class pz
extends PacketAdapter {
    final /* synthetic */ pw EW;

    pz(pw pw2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.EW = pw2;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        try {
            PacketContainer packetContainer = packetEvent.getPacket();
            Player player = packetEvent.getPlayer();
            if (!ap.y(player)) {
                return;
            }
            List list = (List)packetContainer.getIntLists().read(0);
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                qb qb2;
                int n = (Integer)iterator.next();
                Trident trident = (Trident)this.EW.ET.get(n);
                if (trident == null || (qb2 = (qb)this.EW.ES.get(trident)) == null) continue;
                bcp.b(() -> aow.uN().i((Entity)qb2.EZ, player), 5L);
            }
        }
        catch (Exception exception) {
            bce.warn("Failed to handle ENTITY_DESTROY packet for Trident: " + exception.getMessage());
        }
    }
}
