package itemsadder.m;

import itemsadder.m.BlockNms_1_21_4_24;
import java.util.function.Predicate;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.ai.goal.PathfinderGoalGotoTarget;
import net.minecraft.world.level.IWorldReader;
import net.minecraft.world.level.block.state.IBlockData;
import org.bukkit.block.BlockState;
import org.jetbrains.annotations.NotNull;

class EntityCreatureBridge_5
extends PathfinderGoalGotoTarget {
    final /* synthetic */ Predicate agJ;

    EntityCreatureBridge_5(BlockNms_1_21_4_24 blockNms_1_21_4_24, EntityCreature entityCreature, double d, int n, Predicate predicate) {
        this.agJ = predicate;
        super(entityCreature, d, n);
    }

    protected boolean a(@NotNull IWorldReader iWorldReader, @NotNull BlockPosition blockPosition) {
        IBlockData iBlockData = iWorldReader.a_(blockPosition);
        if (iBlockData.l()) {
            return false;
        }
        @NotNull BlockState blockState = iBlockData.createCraftBlockData().createBlockState();
        return this.agJ == null || this.agJ.test(blockState);
    }
}
