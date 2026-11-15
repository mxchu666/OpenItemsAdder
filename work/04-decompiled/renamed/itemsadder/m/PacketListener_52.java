package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EntityHolder;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerJoinListener_2;
import itemsadder.m.ProjectileLaunchListener;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Trident;
import org.bukkit.inventory.ItemStack;

class PacketListener_52
extends PacketAdapter {
    final /* synthetic */ ProjectileLaunchListener EU;

    PacketListener_52(ProjectileLaunchListener projectileLaunchListener, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.EU = projectileLaunchListener;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        try {
            PacketContainer packetContainer = packetEvent.getPacket();
            Player player = packetEvent.getPlayer();
            if (!PlayerJoinListener_2.y(player)) {
                return;
            }
            if (packetContainer.getEntityTypeModifier().read(0) != EntityType.TRIDENT) {
                return;
            }
            Entity entity = EntityHolder.tK().a(player.getWorld(), (int)((Integer)packetContainer.getIntegers().read(0)));
            if (!(entity instanceof Trident)) {
                return;
            }
            Trident trident = (Trident)entity;
            ItemStack itemStack = EntityHolder.c((Projectile)trident);
            ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
            if (itemStackBuilder_4 == null) {
                return;
            }
            packetEvent.setCancelled(true);
            ItemDisplay itemDisplay = this.EU.a((Trident)trident, (ItemStack)itemStack).EZ;
            PacketListenerRegistry.uN().h((Entity)itemDisplay, player);
        }
        catch (Exception exception) {
            CommandSenderBridge_5.warn("Failed to handle SPAWN_ENTITY packet for Trident: " + exception.getMessage());
        }
    }
}
