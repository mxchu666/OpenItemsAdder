package itemsadder.m;

import itemsadder.m.aky;
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
import org.bukkit.craftbukkit.v1_21_R2.entity.CraftMob;
import org.bukkit.craftbukkit.v1_21_R2.event.CraftEventFactory;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.NotNull;

class alb
extends PathfinderGoal {
    private static final int agt = 40;
    private static Predicate afr;
    private final EntityInsentient agu;
    private final World agv;
    private int afu;
    final /* synthetic */ Mob agw;
    final /* synthetic */ Predicate agx;

    alb(aky aky2, Mob mob, Predicate predicate) {
        this.agw = mob;
        this.agx = predicate;
        this.agu = ((CraftMob)this.agw).getHandle();
        this.agv = this.agu.dW();
        afr = this.agx == null ? iBlockData -> false : iBlockData -> {
            @NotNull BlockState blockState = iBlockData.createCraftBlockData().createBlockState();
            return this.agx.test(blockState);
        };
    }

    public boolean ub() {
        if (!((WorldServer)this.agv).J.a.b(this.agu.dy())) {
            return false;
        }
        if (this.agu.dZ().a(this.agu.e_() ? 50 : 1000) != 0) {
            return false;
        }
        BlockPosition blockPosition = this.agu.dw();
        return afr.test(this.agv.a_(blockPosition));
    }

    public void uc() {
        this.afu = this.a(40);
        this.agv.a((Entity)this.agu, (byte)10);
        this.agu.L().o();
    }

    public void ue() {
        this.afu = 0;
    }

    public boolean c() {
        return this.afu > 0;
    }

    public int uf() {
        return this.afu;
    }

    public void a() {
        this.afu = Math.max(0, this.afu - 1);
        if (this.afu == this.a(4)) {
            BlockPosition blockPosition = this.agu.dw();
            IBlockData iBlockData = this.agv.a_(blockPosition);
            if (afr.test(iBlockData)) {
                if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.agu, (BlockPosition)blockPosition, (IBlockData)iBlockData.y().g(), (!alb.a((World)this.agv).N().b(GameRules.c) ? 1 : 0) != 0)) {
                    this.agv.b(blockPosition, false);
                }
                this.agu.P();
            } else {
                BlockPosition blockPosition2 = blockPosition.e();
                if (this.agv.a_(blockPosition2).a(Blocks.i)) {
                    if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.agu, (BlockPosition)blockPosition2, (IBlockData)Blocks.j.m(), (!alb.a((World)this.agv).N().b(GameRules.c) ? 1 : 0) != 0)) {
                        this.agv.c(2001, blockPosition2, Block.j((IBlockData)Blocks.i.m()));
                        this.agv.a(blockPosition2, Blocks.j.m(), 2);
                    }
                    this.agu.P();
                }
            }
        }
    }
}
