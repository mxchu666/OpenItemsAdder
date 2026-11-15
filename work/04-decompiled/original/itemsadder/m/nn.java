package itemsadder.m;

import itemsadder.m.bcy;
import itemsadder.m.lg;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class nn
extends ou {
    public final double CB;
    public final int CC;
    public final int CD;

    public nn(double d, int n, int n2) {
        this.CB = d;
        this.CC = n;
        this.CD = n2;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        double d = Math.random();
        if (d * 100.0 > this.CB) {
            return pa.mk();
        }
        ((ExperienceOrb)player.getWorld().spawn(player.getEyeLocation(), ExperienceOrb.class)).setExperience(bcy.v(this.CC, this.CD));
        return pa.ml();
    }

    @Override
    public pa a(BlockBreakEvent blockBreakEvent, qm qm2, ItemStack itemStack) {
        Block block = blockBreakEvent.getBlock();
        Player player = blockBreakEvent.getPlayer();
        return this.c(player, block);
    }

    @Override
    public pa a(lg lg2, qm qm2, ItemStack itemStack) {
        Block block = lg2.getBlock();
        Player player = lg2.getPlayer();
        return this.c(player, block);
    }

    private pa c(Player player, Block block) {
        if (block.getType().getHardness() == 0.0f) {
            return pa.mk();
        }
        if (block.getType() == Material.CHEST || block.getType() == Material.TRAPPED_CHEST || block.getType() == Material.ENDER_CHEST) {
            return pa.mk();
        }
        double d = Math.random();
        if (d * 100.0 > this.CB) {
            return pa.mk();
        }
        ((ExperienceOrb)player.getWorld().spawn(block.getLocation(), ExperienceOrb.class)).setExperience(bcy.v(this.CC, this.CD));
        return pa.ml();
    }
}
