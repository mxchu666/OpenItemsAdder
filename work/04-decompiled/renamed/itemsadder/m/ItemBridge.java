package itemsadder.m;

import itemsadder.m.ItemStackBridge_32;
import itemsadder.m.LocationBridge_14;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public class ItemBridge
extends LocationBridge_14 {
    public void a(Item item, Player player) {
        for (ItemStackBridge_32 itemStackBridge_32 : this.qx()) {
            if (!itemStackBridge_32.dy()) continue;
            item.setItemStack(itemStackBridge_32.b(player.getItemInHand(), true));
            if (!this.Lu) continue;
            return;
        }
    }
}
