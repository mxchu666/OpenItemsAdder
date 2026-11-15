package itemsadder.m;

import itemsadder.m.BlockNms_26_1_1_24;
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

class MobLevelHolder
extends Goal {
    private static final int air = 40;
    private static Predicate afr;
    private final net.minecraft.world.entity.Mob ais;
    private final Level ait;
    private int afu;
    final /* synthetic */ Mob aiu;
    final /* synthetic */ Predicate aiv;

    MobLevelHolder(BlockNms_26_1_1_24 blockNms_26_1_1_24, Mob mob, Predicate predicate) {
        this.aiu = mob;
        this.aiv = predicate;
        this.ais = ((CraftMob)this.aiu).getHandle();
        this.ait = this.ais.level();
        afr = this.aiv == null ? blockState -> false : blockState -> {
            @NotNull BlockState blockState2 = blockState.asBlockData().createBlockState();
            return this.aiv.test(blockState2);
        };
    }

    public boolean uj() {
        if (!((ServerLevel)this.ait).chunkSource.chunkMap.anyPlayerCloseEnoughForSpawning(this.ais.chunkPosition())) {
            return false;
        }
        if (this.ais.getRandom().nextInt(this.ais.isBaby() ? 50 : 1000) != 0) {
            return false;
        }
        BlockPos blockPos = this.ais.blockPosition();
        return afr.test(this.ait.getBlockState(blockPos));
    }

    public void hn() {
        this.afu = this.adjustedTickDelay(40);
        this.ait.broadcastEntityEvent((Entity)this.ais, (byte)10);
        this.ais.getNavigation().stop();
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
            BlockPos blockPos = this.ais.blockPosition();
            net.minecraft.world.level.block.state.BlockState blockState = this.ait.getBlockState(blockPos);
            if (afr.test(blockState)) {
                if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.ais, (BlockPos)blockPos, (net.minecraft.world.level.block.state.BlockState)blockState.getFluidState().createLegacyBlock(), ((Boolean)MobLevelHolder.getServerLevel((Level)this.ait).getGameRules().get(GameRules.MOB_GRIEFING) == false ? (byte)1 : 0) != 0)) {
                    this.ait.destroyBlock(blockPos, false);
                }
                this.ais.ate();
            } else {
                BlockPos blockPos2 = blockPos.below();
                if (this.ait.getBlockState(blockPos2).is((Object)Blocks.GRASS_BLOCK)) {
                    if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.ais, (BlockPos)blockPos2, (net.minecraft.world.level.block.state.BlockState)Blocks.DIRT.defaultBlockState(), ((Boolean)MobLevelHolder.getServerLevel((Level)this.ait).getGameRules().get(GameRules.MOB_GRIEFING) == false ? (byte)1 : 0) != 0)) {
                        this.ait.levelEvent(2001, blockPos2, Block.getId((net.minecraft.world.level.block.state.BlockState)Blocks.GRASS_BLOCK.defaultBlockState()));
                        this.ait.setBlock(blockPos2, Blocks.DIRT.defaultBlockState(), 2);
                    }
                    this.ais.ate();
                }
            }
        }
    }
}
