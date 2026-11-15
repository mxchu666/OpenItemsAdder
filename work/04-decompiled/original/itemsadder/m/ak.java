package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.ae;
import itemsadder.m.aj;
import itemsadder.m.avn;
import itemsadder.m.d;
import org.bukkit.entity.AbstractVillager;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.MerchantInventory;

class ak
extends PacketAdapter {
    ak(aj aj2, PacketAdapter.AdapterParameteters adapterParameteters) {
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        boolean bl;
        if (packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        if (d.g().aM.az(packetEvent.getPlayer()) && ae.fw) {
            avn.vv().d(packetEvent);
            return;
        }
        Player player = packetEvent.getPlayer();
        Inventory inventory = player.getOpenInventory().getTopInventory();
        if (inventory instanceof MerchantInventory) {
            bl = inventory.getHolder() == null ? false : inventory.getHolder() instanceof AbstractVillager;
        } else {
            return;
        }
        if (!bl && ae.fw) {
            avn.vv().d(packetEvent);
            return;
        }
        if (bl && ae.fx) {
            avn.vv().d(packetEvent);
            return;
        }
    }
}
