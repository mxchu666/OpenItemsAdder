package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ColorBridge;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PlayerBlockHolder_2;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_14
extends Builder_14 {
    public final double CB;
    public final int CC;
    public final int CD;

    public ItemStackBridge_14(double d, int n, int n2) {
        this.CB = d;
        this.CC = n;
        this.CD = n2;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        double d = Math.random();
        if (d * 100.0 > this.CB) {
            return ItemStackBuilder_3.mk();
        }
        ((ExperienceOrb)player.getWorld().spawn(player.getEyeLocation(), ExperienceOrb.class)).setExperience(ColorBridge.v(this.CC, this.CD));
        return ItemStackBuilder_3.ml();
    }

    @Override
    public ItemStackBuilder_3 a(BlockBreakEvent blockBreakEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Block block = blockBreakEvent.getBlock();
        Player player = blockBreakEvent.getPlayer();
        return this.c(player, block);
    }

    @Override
    public ItemStackBuilder_3 a(PlayerBlockHolder_2 playerBlockHolder_2, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Block block = playerBlockHolder_2.getBlock();
        Player player = playerBlockHolder_2.getPlayer();
        return this.c(player, block);
    }

    private ItemStackBuilder_3 c(Player player, Block block) {
        if (block.getType().getHardness() == 0.0f) {
            return ItemStackBuilder_3.mk();
        }
        if (block.getType() == Material.CHEST || block.getType() == Material.TRAPPED_CHEST || block.getType() == Material.ENDER_CHEST) {
            return ItemStackBuilder_3.mk();
        }
        double d = Math.random();
        if (d * 100.0 > this.CB) {
            return ItemStackBuilder_3.mk();
        }
        ((ExperienceOrb)player.getWorld().spawn(block.getLocation(), ExperienceOrb.class)).setExperience(ColorBridge.v(this.CC, this.CD));
        return ItemStackBuilder_3.ml();
    }
}
