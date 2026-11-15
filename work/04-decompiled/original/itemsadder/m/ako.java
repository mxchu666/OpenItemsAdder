package itemsadder.m;

import itemsadder.m.akm;
import java.util.function.Predicate;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.ai.goal.PathfinderGoalGotoTarget;
import net.minecraft.world.level.IWorldReader;
import net.minecraft.world.level.block.state.IBlockData;
import org.bukkit.block.BlockState;
import org.jetbrains.annotations.NotNull;

class ako
extends PathfinderGoalGotoTarget {
    final /* synthetic */ Predicate afK;

    ako(akm akm2, EntityCreature entityCreature, double d, int n, Predicate predicate) {
        this.afK = predicate;
        super(entityCreature, d, n);
    }

    protected boolean a(@NotNull IWorldReader iWorldReader, @NotNull BlockPosition blockPosition) {
        IBlockData iBlockData = iWorldReader.a_(blockPosition);
        if (iBlockData.l()) {
            return false;
        }
        @NotNull BlockState blockState = iBlockData.createCraftBlockData().createBlockState();
        return this.afK == null || this.afK.test(blockState);
    }
}
