package itemsadder.m;

import itemsadder.m.BlockNms_26_2_24;
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

class MobLevelHolder_3
extends Goal {
    private static final int aiY = 40;
    private static Predicate afr;
    private final net.minecraft.world.entity.Mob aiZ;
    private final Level aja;
    private int afu;
    final /* synthetic */ Mob ajb;
    final /* synthetic */ Predicate ajc;

    MobLevelHolder_3(BlockNms_26_2_24 blockNms_26_2_24, Mob mob, Predicate predicate) {
        this.ajb = mob;
        this.ajc = predicate;
        this.aiZ = ((CraftMob)this.ajb).getHandle();
        this.aja = this.aiZ.level();
        afr = this.ajc == null ? blockState -> false : blockState -> {
            @NotNull BlockState blockState2 = blockState.asBlockData().createBlockState();
            return this.ajc.test(blockState2);
        };
    }

    public boolean uj() {
        if (!((ServerLevel)this.aja).getChunkSource().chunkMap.anyPlayerCloseEnoughForSpawning(this.aiZ.chunkPosition())) {
            return false;
        }
        if (this.aiZ.getRandom().nextInt(this.aiZ.isBaby() ? 50 : 1000) != 0) {
            return false;
        }
        BlockPos blockPos = this.aiZ.blockPosition();
        return afr.test(this.aja.getBlockState(blockPos));
    }

    public void hn() {
        this.afu = this.adjustedTickDelay(40);
        this.aja.broadcastEntityEvent((Entity)this.aiZ, (byte)10);
        this.aiZ.getNavigation().stop();
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
            BlockPos blockPos = this.aiZ.blockPosition();
            net.minecraft.world.level.block.state.BlockState blockState = this.aja.getBlockState(blockPos);
            if (afr.test(blockState)) {
                if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.aiZ, (BlockPos)blockPos, (net.minecraft.world.level.block.state.BlockState)blockState.getFluidState().createLegacyBlock(), ((Boolean)MobLevelHolder_3.getServerLevel((Level)this.aja).getGameRules().get(GameRules.MOB_GRIEFING) == false ? 1 : 0) != 0)) {
                    this.aja.destroyBlock(blockPos, false);
                }
                this.aiZ.ate();
            } else {
                BlockPos blockPos2 = blockPos.below();
                if (this.aja.getBlockState(blockPos2).is((Object)Blocks.GRASS_BLOCK)) {
                    if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.aiZ, (BlockPos)blockPos2, (net.minecraft.world.level.block.state.BlockState)Blocks.DIRT.defaultBlockState(), ((Boolean)MobLevelHolder_3.getServerLevel((Level)this.aja).getGameRules().get(GameRules.MOB_GRIEFING) == false ? 1 : 0) != 0)) {
                        this.aja.levelEvent(2001, blockPos2, Block.getId((net.minecraft.world.level.block.state.BlockState)Blocks.GRASS_BLOCK.defaultBlockState()));
                        this.aja.setBlock(blockPos2, Blocks.DIRT.defaultBlockState(), 2);
                    }
                    this.aiZ.ate();
                }
            }
        }
    }
}
