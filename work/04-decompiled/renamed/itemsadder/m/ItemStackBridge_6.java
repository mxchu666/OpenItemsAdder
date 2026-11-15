package itemsadder.m;

import itemsadder.m.BlockRegistry;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.Opaque126;
import itemsadder.m.WorldBridge_11;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_6
extends Opaque126 {
    public static final String yR = "sapling";
    private final WorldBridge_11 yS;

    public ItemStackBridge_6(ItemStackBuilder_4 itemStackBuilder_4, WorldBridge_11 worldBridge_11) {
        super(itemStackBuilder_4);
        this.yS = worldBridge_11;
    }

    public WorldBridge_11 kV() {
        return this.yS;
    }

    public void a(ItemStack itemStack, Player player, Block block) {
        if (this.yS == null) {
            return;
        }
        if (!LocationBridge_2.b(block, player)) {
            return;
        }
        if (BlockRegistry.aJ(block)) {
            block.setType(Material.AIR, false);
        }
        if (this.yS.j(block, false)) {
            ItemStackBridge_2.aj(itemStack);
        }
    }
}
