package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.InstanceHolder_3;
import itemsadder.m.InventoryClickListener;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBarColorHolder;
import org.bukkit.entity.AbstractVillager;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.MerchantInventory;

class PacketListener
extends PacketAdapter {
    PacketListener(InventoryClickListener inventoryClickListener, PacketAdapter.AdapterParameteters adapterParameteters) {
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        boolean bl;
        if (packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        if (ItemStackRegistry.g().aM.az(packetEvent.getPlayer()) && MaterialBarColorHolder.fw) {
            InstanceHolder_3.vv().d(packetEvent);
            return;
        }
        Player player = packetEvent.getPlayer();
        Inventory inventory = player.getOpenInventory().getTopInventory();
        if (inventory instanceof MerchantInventory) {
            bl = inventory.getHolder() == null ? false : inventory.getHolder() instanceof AbstractVillager;
        } else {
            return;
        }
        if (!bl && MaterialBarColorHolder.fw) {
            InstanceHolder_3.vv().d(packetEvent);
            return;
        }
        if (bl && MaterialBarColorHolder.fx) {
            InstanceHolder_3.vv().d(packetEvent);
            return;
        }
    }
}
