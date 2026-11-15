package itemsadder.m;

import itemsadder.m.amo;
import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gamerules.GameRules;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.entity.CraftMob;
import org.bukkit.craftbukkit.event.CraftEventFactory;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.NotNull;

class amr
extends Goal {
    private static final int aiI = 40;
    private static Predicate afr;
    private final net.minecraft.world.entity.Mob aiJ;
    private final Level aiK;
    private int afu;
    final /* synthetic */ Mob aiL;
    final /* synthetic */ Predicate aiM;

    amr(amo amo2, Mob mob, Predicate predicate) {
        this.aiL = mob;
        this.aiM = predicate;
        this.aiJ = ((CraftMob)this.aiL).getHandle();
        this.aiK = this.aiJ.level();
        afr = this.aiM == null ? blockState -> false : blockState -> {
            @NotNull BlockState blockState2 = blockState.asBlockData().createBlockState();
            return this.aiM.test(blockState2);
        };
    }

    public boolean uj() {
        if (!((ServerLevel)this.aiK).chunkSource.chunkMap.anyPlayerCloseEnoughForSpawning(this.aiJ.chunkPosition())) {
            return false;
        }
        if (this.aiJ.getRandom().nextInt(this.aiJ.isBaby() ? 50 : 1000) != 0) {
            return false;
        }
        BlockPos blockPos = this.aiJ.blockPosition();
        return afr.test(this.aiK.getBlockState(blockPos));
    }

    public void hn() {
        this.afu = this.adjustedTickDelay(40);
        this.aiK.broadcastEntityEvent((Entity)this.aiJ, (byte)10);
        this.aiJ.getNavigation().stop();
    }

    public void bU() {
        this.afu = 0;
    }

    public boolean uk() {
        return this.afu > 0;
    }

    public void bV() {
        this.afu = Math.max(0, this.afu - 1);
        if (this.afu == this.adjustedTickDelay(4)) {
            BlockPos blockPos = this.aiJ.blockPosition();
            net.minecraft.world.level.block.state.BlockState blockState = this.aiK.getBlockState(blockPos);
            if (afr.test(blockState)) {
                if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.aiJ, (BlockPos)blockPos, (net.minecraft.world.level.block.state.BlockState)blockState.getFluidState().createLegacyBlock(), ((Boolean)amr.getServerLevel((Level)this.aiK).getGameRules().get(GameRules.MOB_GRIEFING) == false ? 1 : 0) != 0)) {
                    this.aiK.destroyBlock(blockPos, false);
                }
                this.aiJ.ate();
            } else {
                BlockPos blockPos2 = blockPos.below();
                if (this.aiK.getBlockState(blockPos2).is((Object)Blocks.GRASS_BLOCK)) {
                    if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.aiJ, (BlockPos)blockPos2, (net.minecraft.world.level.block.state.BlockState)Blocks.DIRT.defaultBlockState(), ((Boolean)amr.getServerLevel((Level)this.aiK).getGameRules().get(GameRules.MOB_GRIEFING) == false ? 1 : 0) != 0)) {
                        this.aiK.levelEvent(2001, blockPos2, Block.getId((net.minecraft.world.level.block.state.BlockState)Blocks.GRASS_BLOCK.defaultBlockState()));
                        this.aiK.setBlock(blockPos2, Blocks.DIRT.defaultBlockState(), 2);
                    }
                    this.aiJ.ate();
                }
            }
        }
    }
}
