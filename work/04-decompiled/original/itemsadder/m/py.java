package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.afz;
import itemsadder.m.ap;
import itemsadder.m.pw;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;

class py
extends PacketAdapter {
    final /* synthetic */ pw EV;

    py(pw pw2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.EV = pw2;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        PacketContainer packetContainer = packetEvent.getPacket();
        int n = (Integer)packetContainer.getIntegers().read(1);
        Player player = packetEvent.getPlayer();
        if (!ap.y(player)) {
            return;
        }
        Entity entity = afz.tK().a(player.getWorld(), n);
        if (!(entity instanceof Player)) {
            return;
        }
        Player player2 = (Player)entity;
        if (!player.getUniqueId().equals(player2.getUniqueId())) {
            return;
        }
        int n2 = (Integer)packetContainer.getIntegers().read(0);
        Entity entity2 = afz.tK().a(player.getWorld(), n2);
        if (!(entity2 instanceof Trident)) {
            return;
        }
        Trident trident = (Trident)entity2;
        this.EV.a(trident, (qb2, itemStack) -> qb2.bf(player2));
    }
}
