package itemsadder.m;

import itemsadder.m.BlockNms_1_21_8_24;
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

class EntityInsentientWorldHolder_9
extends PathfinderGoal {
    private static final int aia = 40;
    private static Predicate afr;
    private final EntityInsentient aib;
    private final World aic;
    private int afu;
    final /* synthetic */ Mob aid;
    final /* synthetic */ Predicate aie;

    EntityInsentientWorldHolder_9(BlockNms_1_21_8_24 blockNms_1_21_8_24, Mob mob, Predicate predicate) {
        this.aid = mob;
        this.aie = predicate;
        this.aib = ((CraftMob)this.aid).getHandle();
        this.aic = this.aib.ai();
        afr = this.aie == null ? iBlockData -> false : iBlockData -> {
            @NotNull BlockState blockState = iBlockData.createCraftBlockData().createBlockState();
            return this.aie.test(blockState);
        };
    }

    public boolean ub() {
        if (!((WorldServer)this.aic).J.a.b(this.aib.dz())) {
            return false;
        }
        if (this.aib.ec().a(this.aib.g_() ? 50 : 1000) != 0) {
            return false;
        }
        BlockPosition blockPosition = this.aib.dx();
        return afr.test(this.aic.a_(blockPosition));
    }

    public void uc() {
        this.afu = this.a(40);
        this.aic.a((Entity)this.aib, (byte)10);
        this.aib.S().n();
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
            BlockPosition blockPosition = this.aib.dx();
            IBlockData iBlockData = this.aic.a_(blockPosition);
            if (afr.test(iBlockData)) {
                if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.aib, (BlockPosition)blockPosition, (IBlockData)iBlockData.y().g(), (!EntityInsentientWorldHolder_9.a((World)this.aic).P().c(GameRules.d) ? (byte)1 : 0) != 0)) {
                    this.aic.b(blockPosition, false);
                }
                this.aib.V();
            } else {
                BlockPosition blockPosition2 = blockPosition.e();
                if (this.aic.a_(blockPosition2).a(Blocks.i)) {
                    if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.aib, (BlockPosition)blockPosition2, (IBlockData)Blocks.j.m(), (!EntityInsentientWorldHolder_9.a((World)this.aic).P().c(GameRules.d) ? (byte)1 : 0) != 0)) {
                        this.aic.c(2001, blockPosition2, Block.j((IBlockData)Blocks.i.m()));
                        this.aic.a(blockPosition2, Blocks.j.m(), 2);
                    }
                    this.aib.V();
                }
            }
        }
    }
}
