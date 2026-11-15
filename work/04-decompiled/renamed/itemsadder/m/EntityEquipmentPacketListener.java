package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import dev.lone.itemsadder.Main;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.PacketListenerRegistry;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

class EntityEquipmentPacketListener
extends PacketAdapter {
    public EntityEquipmentPacketListener() {
        super(new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).listenerPriority(ListenerPriority.HIGHEST).types(new PacketType[]{PacketType.Play.Server.ENTITY_EQUIPMENT, PacketType.Play.Server.SET_SLOT}));
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (packetEvent.isCancelled()) {
            return;
        }
        PacketContainer packetContainer = packetEvent.getPacket();
        Player player = packetEvent.getPlayer();
        if (packetContainer.getType() == PacketType.Play.Server.ENTITY_EQUIPMENT) {
            if (LivingEntityRegistry.db().j((Integer)packetContainer.getIntegers().read(0)) != null) {
                PacketListenerRegistry.uN().f(packetContainer);
            }
        } else {
            LivingEntityBuilder livingEntityBuilder;
            Integer n = (Integer)packetContainer.getIntegers().read(2);
            if ((n >= 5 && n <= 8 || n == 45 || player.getInventory().getHeldItemSlot() == n.intValue()) && (livingEntityBuilder = LivingEntityRegistry.db().U(player)) != null) {
                packetContainer.getItemModifier().write(0, (Object)new ItemStack(Material.AIR));
            }
        }
    }
}
