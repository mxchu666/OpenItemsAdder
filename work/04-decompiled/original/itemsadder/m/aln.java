package itemsadder.m;

import itemsadder.m.alk;
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
import org.bukkit.craftbukkit.v1_21_R4.entity.CraftMob;
import org.bukkit.craftbukkit.v1_21_R4.event.CraftEventFactory;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.NotNull;

class aln
extends PathfinderGoal {
    private static final int ahb = 40;
    private static Predicate afr;
    private final EntityInsentient ahc;
    private final World ahd;
    private int afu;
    final /* synthetic */ Mob ahe;
    final /* synthetic */ Predicate ahf;

    aln(alk alk2, Mob mob, Predicate predicate) {
        this.ahe = mob;
        this.ahf = predicate;
        this.ahc = ((CraftMob)this.ahe).getHandle();
        this.ahd = this.ahc.dV();
        afr = this.ahf == null ? iBlockData -> false : iBlockData -> {
            @NotNull BlockState blockState = iBlockData.createCraftBlockData().createBlockState();
            return this.ahf.test(blockState);
        };
    }

    public boolean ub() {
        if (!((WorldServer)this.ahd).J.a.b(this.ahc.dx())) {
            return false;
        }
        if (this.ahc.dY().a(this.ahc.e_() ? 50 : 1000) != 0) {
            return false;
        }
        BlockPosition blockPosition = this.ahc.dv();
        return afr.test(this.ahd.a_(blockPosition));
    }

    public void uc() {
        this.afu = this.a(40);
        this.ahd.a((Entity)this.ahc, (byte)10);
        this.ahc.N().m();
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
            BlockPosition blockPosition = this.ahc.dv();
            IBlockData iBlockData = this.ahd.a_(blockPosition);
            if (afr.test(iBlockData)) {
                if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.ahc, (BlockPosition)blockPosition, (IBlockData)iBlockData.y().g(), (!aln.a((World)this.ahd).O().c(GameRules.d) ? 1 : 0) != 0)) {
                    this.ahd.b(blockPosition, false);
                }
                this.ahc.Q();
            } else {
                BlockPosition blockPosition2 = blockPosition.e();
                if (this.ahd.a_(blockPosition2).a(Blocks.i)) {
                    if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.ahc, (BlockPosition)blockPosition2, (IBlockData)Blocks.j.m(), (!aln.a((World)this.ahd).O().c(GameRules.d) ? 1 : 0) != 0)) {
                        this.ahd.c(2001, blockPosition2, Block.j((IBlockData)Blocks.i.m()));
                        this.ahd.a(blockPosition2, Blocks.j.m(), 2);
                    }
                    this.ahc.Q();
                }
            }
        }
    }
}
