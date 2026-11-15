package itemsadder.m;

import itemsadder.m.aks;
import java.util.function.Predicate;
import net.minecraft.core.BlockPosition;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.level.World;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.level.gamerules.GameRules;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.v1_21_R7.entity.CraftMob;
import org.bukkit.craftbukkit.v1_21_R7.event.CraftEventFactory;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.NotNull;

class akv
extends PathfinderGoal {
    private static final int agc = 40;
    private static Predicate afr;
    private final EntityInsentient agd;
    private final World age;
    private int afu;
    final /* synthetic */ Mob agf;
    final /* synthetic */ Predicate agg;

    akv(aks aks2, Mob mob, Predicate predicate) {
        this.agf = mob;
        this.agg = predicate;
        this.agd = ((CraftMob)this.agf).getHandle();
        this.age = this.agd.ao();
        afr = this.agg == null ? iBlockData -> false : iBlockData -> {
            @NotNull BlockState blockState = iBlockData.createCraftBlockData().createBlockState();
            return this.agg.test(blockState);
        };
    }

    public boolean ub() {
        if (!((WorldServer)this.age).G.a.b(this.agd.dM())) {
            return false;
        }
        if (this.agd.ep().a(this.agd.e_() ? 50 : 1000) != 0) {
            return false;
        }
        BlockPosition blockPosition = this.agd.dK();
        return afr.test(this.age.a_(blockPosition));
    }

    public void uc() {
        this.afu = this.a(40);
        this.age.a((Entity)this.agd, (byte)10);
        this.agd.N().n();
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
            BlockPosition blockPosition = this.agd.dK();
            IBlockData iBlockData = this.age.a_(blockPosition);
            if (afr.test(iBlockData)) {
                if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.agd, (BlockPosition)blockPosition, (IBlockData)iBlockData.y().g(), ((Boolean)akv.a((World)this.age).U().a(GameRules.F) == false ? 1 : 0) != 0)) {
                    this.age.b(blockPosition, false);
                }
                this.agd.R();
            } else {
                BlockPosition blockPosition2 = blockPosition.e();
                if (this.age.a_(blockPosition2).a(Blocks.i)) {
                    if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.agd, (BlockPosition)blockPosition2, (IBlockData)Blocks.j.m(), ((Boolean)akv.a((World)this.age).U().a(GameRules.F) == false ? 1 : 0) != 0)) {
                        this.age.c(2001, blockPosition2, Block.j((IBlockData)Blocks.i.m()));
                        this.age.a(blockPosition2, Blocks.j.m(), 2);
                    }
                    this.agd.R();
                }
            }
        }
    }
}
