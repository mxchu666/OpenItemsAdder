package itemsadder.m;

import itemsadder.m.BlockNms_1_21_7_24;
import java.util.function.Predicate;
import net.minecraft.core.BlockPosition;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.World;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.IBlockData;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.v1_21_R5.entity.CraftMob;
import org.bukkit.craftbukkit.v1_21_R5.event.CraftEventFactory;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.NotNull;

class EntityInsentientWorldHolder_8
extends PathfinderGoal {
    private static final int ahJ = 40;
    private static Predicate afr;
    private final EntityInsentient ahK;
    private final World ahL;
    private int afu;
    final /* synthetic */ Mob ahM;
    final /* synthetic */ Predicate ahN;

    EntityInsentientWorldHolder_8(BlockNms_1_21_7_24 blockNms_1_21_7_24, Mob mob, Predicate predicate) {
        this.ahM = mob;
        this.ahN = predicate;
        this.ahK = ((CraftMob)this.ahM).getHandle();
        this.ahL = this.ahK.ai();
        afr = this.ahN == null ? iBlockData -> false : iBlockData -> {
            @NotNull BlockState blockState = iBlockData.createCraftBlockData().createBlockState();
            return this.ahN.test(blockState);
        };
    }

    public boolean ub() {
        if (!((WorldServer)this.ahL).J.a.b(this.ahK.dz())) {
            return false;
        }
        if (this.ahK.ec().a(this.ahK.g_() ? 50 : 1000) != 0) {
            return false;
        }
        BlockPosition blockPosition = this.ahK.dx();
        return afr.test(this.ahL.a_(blockPosition));
    }

    public void uc() {
        this.afu = this.a(40);
        this.ahL.a((Entity)this.ahK, (byte)10);
        this.ahK.S().n();
    }

    public void ue() {
        this.afu = 0;
    }

    public boolean c() {
        return this.afu > 0;
    }

    public void a() {
        this.afu = Math.max(0, this.afu - 1);
        if (this.afu == this.a(4)) {
            BlockPosition blockPosition = this.ahK.dx();
            IBlockData iBlockData = this.ahL.a_(blockPosition);
            if (afr.test(iBlockData)) {
                if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.ahK, (BlockPosition)blockPosition, (IBlockData)iBlockData.y().g(), (!EntityInsentientWorldHolder_8.a((World)this.ahL).P().c(GameRules.d) ? (byte)1 : 0) != 0)) {
                    this.ahL.b(blockPosition, false);
                }
                this.ahK.V();
            } else {
                BlockPosition blockPosition2 = blockPosition.e();
                if (this.ahL.a_(blockPosition2).a(Blocks.i)) {
                    if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.ahK, (BlockPosition)blockPosition2, (IBlockData)Blocks.j.m(), (!EntityInsentientWorldHolder_8.a((World)this.ahL).P().c(GameRules.d) ? (byte)1 : 0) != 0)) {
                        this.ahL.c(2001, blockPosition2, Block.j((IBlockData)Blocks.i.m()));
                        this.ahL.a(blockPosition2, Blocks.j.m(), 2);
                    }
                    this.ahK.V();
                }
            }
        }
    }
}
