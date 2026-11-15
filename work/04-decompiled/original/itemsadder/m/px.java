package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.afz;
import itemsadder.m.aow;
import itemsadder.m.ap;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.pw;
import itemsadder.m.qm;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Trident;
import org.bukkit.inventory.ItemStack;

class px
extends PacketAdapter {
    final /* synthetic */ pw EU;

    px(pw pw2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.EU = pw2;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        try {
            PacketContainer packetContainer = packetEvent.getPacket();
            Player player = packetEvent.getPlayer();
            if (!ap.y(player)) {
                return;
            }
            if (packetContainer.getEntityTypeModifier().read(0) != EntityType.TRIDENT) {
                return;
            }
            Entity entity = afz.tK().a(player.getWorld(), (int)((Integer)packetContainer.getIntegers().read(0)));
            if (!(entity instanceof Trident)) {
                return;
            }
            Trident trident = (Trident)entity;
            ItemStack itemStack = afz.c((Projectile)trident);
            qm qm2 = d.g().a(itemStack);
            if (qm2 == null) {
                return;
            }
            packetEvent.setCancelled(true);
            ItemDisplay itemDisplay = this.EU.a((Trident)trident, (ItemStack)itemStack).EZ;
            aow.uN().h((Entity)itemDisplay, player);
        }
        catch (Exception exception) {
            bce.warn("Failed to handle SPAWN_ENTITY packet for Trident: " + exception.getMessage());
        }
    }
}
