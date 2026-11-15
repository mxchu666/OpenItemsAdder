package itemsadder.m;

import itemsadder.m.ry;
import itemsadder.m.ug;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public class ue
extends ug {
    public void a(Item item, Player player) {
        for (ry ry2 : this.qx()) {
            if (!ry2.dy()) continue;
            item.setItemStack(ry2.b(player.getItemInHand(), true));
            if (!this.Lu) continue;
            return;
        }
    }
}
