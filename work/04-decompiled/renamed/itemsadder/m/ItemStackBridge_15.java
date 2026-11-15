package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.mmoitems.MmoItemsHook;
import itemsadder.m.Builder_14;
import itemsadder.m.ColorBridge;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.PlayerBlockHolder_2;
import itemsadder.m.PlayerEntityHolder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_15
extends Builder_14 {
    public final ItemStack CE;
    public final double CF;
    public final int CG;
    public final int CH;

    public ItemStackBridge_15(ItemStack itemStack, double d, int n, int n2) {
        this.CE = itemStack;
        this.CF = d;
        this.CG = n;
        this.CH = n2;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        return this.K(player.getEyeLocation());
    }

    @Override
    public ItemStackBuilder_3 a(BlockBreakEvent blockBreakEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Block block = blockBreakEvent.getBlock();
        return this.d(block, true);
    }

    @Override
    public ItemStackBuilder_3 b(PlayerEntityHolder playerEntityHolder, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.d(playerEntityHolder.Fg.getLocation().getBlock(), false);
    }

    @Override
    public ItemStackBuilder_3 a(PlayerBlockHolder_2 playerBlockHolder_2, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Block block = playerBlockHolder_2.getBlock();
        return this.d(block, false);
    }

    private ItemStackBuilder_3 d(Block block, boolean bl) {
        if (bl && block.getType().getHardness() == 0.0f) {
            return ItemStackBuilder_3.mk();
        }
        if (block.getType() == Material.CHEST || block.getType() == Material.TRAPPED_CHEST || block.getType() == Material.ENDER_CHEST) {
            return ItemStackBuilder_3.mk();
        }
        return this.K(block.getLocation());
    }

    private ItemStackBuilder_3 K(Location location) {
        if (this.CF != 100.0 && Math.random() * 100.0 > this.CF) {
            return ItemStackBuilder_3.mk();
        }
        ItemStack itemStack = this.CE.clone();
        MmoItemsHook.injectMmoItem(itemStack);
        itemStack.setAmount(ColorBridge.v(this.CG, this.CH));
        LocationBridge_4.b(location, itemStack);
        return ItemStackBuilder_3.ml();
    }
}
