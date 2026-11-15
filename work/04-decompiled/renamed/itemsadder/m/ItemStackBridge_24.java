package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.MaterialBridge_5;
import itemsadder.m.RefData;
import itemsadder.m.VectorBridge_2;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_24
extends Builder_14 {
    final RefData Dz;

    public ItemStackBridge_24(RefData refData) {
        this.Dz = refData;
    }

    public ItemStackBridge_24(MaterialBridge_5 materialBridge_5, MaterialBridge_5 materialBridge_52, int n, int n2, int n3, int n4, int n5, boolean bl) {
        this(new RefData(materialBridge_5, materialBridge_52, new VectorBridge_2(Math.max(n - 1, 1), Math.max(n2 - 1, 1), Math.max(n3 - 1, 1)), n4, n5, bl));
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        return this.a(player, itemStack, player.getLocation().getBlock());
    }

    @Override
    public ItemStackBuilder_3 a(Event event, Block block, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        return this.a(player, itemStack, block);
    }

    private ItemStackBuilder_3 a(Player player, ItemStack itemStack, Block block) {
        if (block == null) {
            return ItemStackBuilder_3.mk();
        }
        if (itemStack == null || itemStack.getType() == Material.AIR || ItemStackBridge_2.G(itemStack) || ItemStackBuilder_4.G(itemStack)) {
            return ItemStackBuilder_3.mk();
        }
        boolean bl = false;
        float f = -(this.Dz.Eb.aBp / 2.0f);
        while (f < this.Dz.Eb.aBp) {
            float f2 = -(this.Dz.Eb.aBq / 2.0f);
            while (f2 < this.Dz.Eb.aBq) {
                float f3 = -(this.Dz.Eb.aBr / 2.0f);
                while (f3 < this.Dz.Eb.aBr) {
                    Block block2 = block.getLocation().add((double)f, (double)f2, (double)f3).getBlock();
                    if (this.Dz.DU.ap(block2) && LocationBridge_2.b(block, player)) {
                        bl = true;
                        this.Dz.ao(block2);
                    }
                    f3 = (float)((double)f3 + 0.5);
                }
                f2 = (float)((double)f2 + 0.5);
            }
            f = (float)((double)f + 0.5);
        }
        if (this.Dz.DW > 0 && bl) {
            ItemStackBuilder_4.a(itemStack, this.Dz.DW, (LivingEntity)player);
        }
        if (this.Dz.DX > 0) {
            ItemStackBridge_2.i(itemStack, this.Dz.DX);
        }
        return bl ? ItemStackBuilder_3.ml() : ItemStackBuilder_3.mk();
    }
}
