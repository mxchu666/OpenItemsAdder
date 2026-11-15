package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.EntityHolder;
import itemsadder.m.PlayerJoinListener_2;
import itemsadder.m.ProjectileLaunchListener;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;

class PacketListener_53
extends PacketAdapter {
    final /* synthetic */ ProjectileLaunchListener EV;

    PacketListener_53(ProjectileLaunchListener projectileLaunchListener, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.EV = projectileLaunchListener;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        PacketContainer packetContainer = packetEvent.getPacket();
        int n = (Integer)packetContainer.getIntegers().read(1);
        Player player = packetEvent.getPlayer();
        if (!PlayerJoinListener_2.y(player)) {
            return;
        }
        Entity entity = EntityHolder.tK().a(player.getWorld(), n);
        if (!(entity instanceof Player)) {
            return;
        }
        Player player2 = (Player)entity;
        if (!player.getUniqueId().equals(player2.getUniqueId())) {
            return;
        }
        int n2 = (Integer)packetContainer.getIntegers().read(0);
        Entity entity2 = EntityHolder.tK().a(player.getWorld(), n2);
        if (!(entity2 instanceof Trident)) {
            return;
        }
        Trident trident = (Trident)entity2;
        this.EV.a(trident, (itemDisplayTridentHolder, itemStack) -> itemDisplayTridentHolder.bf(player2));
    }
}
