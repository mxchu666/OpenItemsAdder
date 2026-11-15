package itemsadder.m;

import itemsadder.m.ami;
import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.LevelReader;
import org.bukkit.block.BlockState;
import org.jetbrains.annotations.NotNull;

class amk
extends MoveToBlockGoal {
    final /* synthetic */ Predicate aiq;

    amk(ami ami2, PathfinderMob pathfinderMob, double d, int n, Predicate predicate) {
        this.aiq = predicate;
        super(pathfinderMob, d, n);
    }

    protected boolean a(@NotNull LevelReader levelReader, @NotNull BlockPos blockPos) {
        net.minecraft.world.level.block.state.BlockState blockState = levelReader.getBlockState(blockPos);
        if (blockState.isAir()) {
            return false;
        }
        @NotNull BlockState blockState2 = blockState.asBlockData().createBlockState();
        return this.aiq == null || this.aiq.test(blockState2);
    }
}
