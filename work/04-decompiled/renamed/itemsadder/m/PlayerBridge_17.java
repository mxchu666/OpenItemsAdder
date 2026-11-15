package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.NamespacedKeyItemDisplayHolder;
import itemsadder.m.Opaque126;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class PlayerBridge_17
extends Opaque126 {
    public static final String yw = "furniture_consumable";
    public final int yx;
    public final float yy;
    public final List yz;

    public PlayerBridge_17(ItemStackBuilder_4 itemStackBuilder_4, int n, float f, List list, boolean bl) {
        super(itemStackBuilder_4);
        this.yx = n;
        this.yy = f;
        this.yz = list;
        this.yz.addFirst(itemStackBuilder_4);
        if (bl) {
            for (ItemStackBuilder_4 itemStackBuilder_42 : list) {
                itemStackBuilder_42.Ge.a(yw, this);
            }
        }
    }

    public int d(ItemStackBuilder_4 itemStackBuilder_4) {
        for (int i = 0; i < this.yz.size(); ++i) {
            if (!((ItemStackBuilder_4)this.yz.get(i)).getNamespacedID().equals(itemStackBuilder_4.getNamespacedID())) continue;
            return i;
        }
        return -1;
    }

    public boolean e(ItemStackBuilder_4 itemStackBuilder_4) {
        int n = this.d(itemStackBuilder_4);
        return n < 0 || n >= this.yz.size() - 1;
    }

    public void a(Player player, Entity entity, PlayerBridge_17 playerBridge_17, ItemStackBuilder_4 itemStackBuilder_4) {
        if (this.e(itemStackBuilder_4)) {
            this.e(entity, player);
            return;
        }
        int n = this.d(itemStackBuilder_4);
        ItemStackBuilder_4 itemStackBuilder_42 = (ItemStackBuilder_4)this.yz.get(n + 1);
        PlayerBridge_17 playerBridge_172 = (PlayerBridge_17)itemStackBuilder_42.Ge.bn(yw);
        if (playerBridge_172 == null) {
            CommandSenderBridge_5.error("Item '" + itemStackBuilder_42.getNamespacedID() + "' has no 'furniture_consumable' behaviour, but is referenced in the item '" + itemStackBuilder_4.getNamespacedID() + "' consumable stages list.");
            this.e(entity, player);
            return;
        }
        boolean bl = NamespacedKeyItemDisplayHolder.a(itemStackBuilder_42, playerBridge_17.zk, entity);
        if (!bl) {
            this.e(entity, player);
        } else {
            this.at(player);
        }
    }

    private void at(Player player) {
        player.getFoodLevel();
        player.setFoodLevel(Math.min(20, player.getFoodLevel() + this.yx));
        player.setSaturation(Math.min(20.0f, player.getSaturation() + this.yy));
    }

    private void e(Entity entity, Player player) {
        ItemStackRegistry.g().aC.a(entity, player, false, false, false);
        this.at(player);
    }
}
