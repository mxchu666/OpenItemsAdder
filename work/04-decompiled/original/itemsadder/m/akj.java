package itemsadder.m;

import itemsadder.m.akg;
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
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftMob;
import org.bukkit.craftbukkit.v1_21_R1.event.CraftEventFactory;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.NotNull;

class akj
extends PathfinderGoal {
    private static final int afq = 40;
    private static Predicate afr;
    private final EntityInsentient afs;
    private final World aft;
    private int afu;
    final /* synthetic */ Mob afv;
    final /* synthetic */ Predicate afw;

    akj(akg akg2, Mob mob, Predicate predicate) {
        this.afv = mob;
        this.afw = predicate;
        this.afs = ((CraftMob)this.afv).getHandle();
        this.aft = this.afs.dO();
        afr = this.afw == null ? iBlockData -> false : iBlockData -> {
            @NotNull BlockState blockState = iBlockData.createCraftBlockData().createBlockState();
            return this.afw.test(blockState);
        };
    }

    public boolean ub() {
        if (!((WorldServer)this.aft).I.a.b(this.afs.dq())) {
            return false;
        }
        if (this.afs.dR().a(this.afs.o_() ? 50 : 1000) != 0) {
            return false;
        }
        BlockPosition blockPosition = this.afs.do();
        return afr.test(this.aft.a_(blockPosition));
    }

    public void uc() {
        this.afu = this.a(40);
        this.aft.a((Entity)this.afs, (byte)10);
        this.afs.N().n();
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
            BlockPosition blockPosition = this.afs.do();
            IBlockData iBlockData = this.aft.a_(blockPosition);
            if (afr.test(iBlockData)) {
                if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.afs, (BlockPosition)blockPosition, (IBlockData)iBlockData.u().g(), (!this.aft.ab().b(GameRules.c) ? 1 : 0) != 0)) {
                    this.aft.b(blockPosition, false);
                }
                this.afs.Q();
            } else {
                BlockPosition blockPosition2 = blockPosition.e();
                if (this.aft.a_(blockPosition2).a(Blocks.i)) {
                    if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.afs, (BlockPosition)blockPosition2, (IBlockData)Blocks.j.o(), (!this.aft.ab().b(GameRules.c) ? 1 : 0) != 0)) {
                        this.aft.c(2001, blockPosition2, Block.i((IBlockData)Blocks.i.o()));
                        this.aft.a(blockPosition2, Blocks.j.o(), 2);
                    }
                    this.afs.Q();
                }
            }
        }
    }
}
