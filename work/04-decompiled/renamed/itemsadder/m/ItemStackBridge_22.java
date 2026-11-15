package itemsadder.m;

import itemsadder.m.BlockBridge_11;
import itemsadder.m.Builder_14;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.MaterialBridge_5;
import itemsadder.m.PlayerBlockHolder_2;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_22
extends Builder_14 {
    final BlockBridge_11 Dv;

    public ItemStackBridge_22(BlockBridge_11 blockBridge_11) {
        this.Dv = blockBridge_11;
    }

    public ItemStackBridge_22(MaterialBridge_5 materialBridge_5, MaterialBridge_5 materialBridge_52, int n, int n2, boolean bl) {
        this(new BlockBridge_11(materialBridge_5, materialBridge_52, n, n2, bl));
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        return this.a(event, player, itemStackBuilder_4, itemStack, player.getLocation().getBlock());
    }

    @Override
    public ItemStackBuilder_3 a(Event event, Block block, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        return this.a(event, player, itemStackBuilder_4, itemStack, block);
    }

    @Override
    public ItemStackBuilder_3 a(PlayerBlockHolder_2 playerBlockHolder_2, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Block block = playerBlockHolder_2.getBlock();
        Player player = playerBlockHolder_2.getPlayer();
        if (block == null) {
            return ItemStackBuilder_3.mk();
        }
        if (this.Dv.DU.ap(block)) {
            if (!LocationBridge_2.b(block, player)) {
                return ItemStackBuilder_3.mk();
            }
            playerBlockHolder_2.setCancelled(true);
            BukkitTaskBridge.c(() -> this.Dv.ao(block), 5L);
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }

    private ItemStackBuilder_3 a(Event event, Player player, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Block block) {
        if (block == null) {
            return ItemStackBuilder_3.mk();
        }
        if (itemStack == null || itemStack.getType() == Material.AIR || ItemStackBridge_2.G(itemStack) || ItemStackBuilder_4.G(itemStack)) {
            return ItemStackBuilder_3.mk();
        }
        if (!LocationBridge_2.b(block, player)) {
            return ItemStackBuilder_3.mk();
        }
        if (this.Dv.DU.ap(block)) {
            if (!LocationBridge_2.b(block, player)) {
                return ItemStackBuilder_3.mk();
            }
            if (event instanceof Cancellable) {
                ((Cancellable)event).setCancelled(true);
            }
            this.Dv.ao(block);
            if (this.Dv.DW > 0) {
                ItemStackBuilder_4.a(itemStack, this.Dv.DW, (LivingEntity)player);
            }
            if (this.Dv.DX > 0) {
                ItemStackBridge_2.i(itemStack, this.Dv.DX);
            }
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }
}
