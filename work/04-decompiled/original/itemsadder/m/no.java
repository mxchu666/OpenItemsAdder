package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.mmoitems.MmoItemsHook;
import itemsadder.m.bcy;
import itemsadder.m.bdf;
import itemsadder.m.lg;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qd;
import itemsadder.m.qm;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class no
extends ou {
    public final ItemStack CE;
    public final double CF;
    public final int CG;
    public final int CH;

    public no(ItemStack itemStack, double d, int n, int n2) {
        this.CE = itemStack;
        this.CF = d;
        this.CG = n;
        this.CH = n2;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        return this.K(player.getEyeLocation());
    }

    @Override
    public pa a(BlockBreakEvent blockBreakEvent, qm qm2, ItemStack itemStack) {
        Block block = blockBreakEvent.getBlock();
        return this.d(block, true);
    }

    @Override
    public pa b(qd qd2, qm qm2, ItemStack itemStack) {
        return this.d(qd2.Fg.getLocation().getBlock(), false);
    }

    @Override
    public pa a(lg lg2, qm qm2, ItemStack itemStack) {
        Block block = lg2.getBlock();
        return this.d(block, false);
    }

    private pa d(Block block, boolean bl) {
        if (bl && block.getType().getHardness() == 0.0f) {
            return pa.mk();
        }
        if (block.getType() == Material.CHEST || block.getType() == Material.TRAPPED_CHEST || block.getType() == Material.ENDER_CHEST) {
            return pa.mk();
        }
        return this.K(block.getLocation());
    }

    private pa K(Location location) {
        if (this.CF != 100.0 && Math.random() * 100.0 > this.CF) {
            return pa.mk();
        }
        ItemStack itemStack = this.CE.clone();
        MmoItemsHook.injectMmoItem(itemStack);
        itemStack.setAmount(bcy.v(this.CG, this.CH));
        bdf.b(location, itemStack);
        return pa.ml();
    }
}
