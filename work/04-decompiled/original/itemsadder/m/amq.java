package itemsadder.m;

import itemsadder.m.amo;
import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.LevelReader;
import org.bukkit.block.BlockState;
import org.jetbrains.annotations.NotNull;

class amq
extends MoveToBlockGoal {
    final /* synthetic */ Predicate aiH;

    amq(amo amo2, PathfinderMob pathfinderMob, double d, int n, Predicate predicate) {
        this.aiH = predicate;
        super(pathfinderMob, d, n);
    }

    protected boolean a(@NotNull LevelReader levelReader, @NotNull BlockPos blockPos) {
        net.minecraft.world.level.block.state.BlockState blockState = levelReader.getBlockState(blockPos);
        if (blockState.isAir()) {
            return false;
        }
        @NotNull BlockState blockState2 = blockState.asBlockData().createBlockState();
        return this.aiH == null || this.aiH.test(blockState2);
    }
}
