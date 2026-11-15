package itemsadder.m;

import itemsadder.m.akm;
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
import org.bukkit.craftbukkit.v1_21_R6.entity.CraftMob;
import org.bukkit.craftbukkit.v1_21_R6.event.CraftEventFactory;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.NotNull;

class akp
extends PathfinderGoal {
    private static final int afL = 40;
    private static Predicate afr;
    private final EntityInsentient afM;
    private final World afN;
    private int afu;
    final /* synthetic */ Mob afO;
    final /* synthetic */ Predicate afP;

    akp(akm akm2, Mob mob, Predicate predicate) {
        this.afO = mob;
        this.afP = predicate;
        this.afM = ((CraftMob)this.afO).getHandle();
        this.afN = this.afM.an();
        afr = this.afP == null ? iBlockData -> false : iBlockData -> {
            @NotNull BlockState blockState = iBlockData.createCraftBlockData().createBlockState();
            return this.afP.test(blockState);
        };
    }

    public boolean ub() {
        if (!((WorldServer)this.afN).H.a.b(this.afM.dH())) {
            return false;
        }
        if (this.afM.ek().a(this.afM.g_() ? 50 : 1000) != 0) {
            return false;
        }
        BlockPosition blockPosition = this.afM.dF();
        return afr.test(this.afN.a_(blockPosition));
    }

    public void uc() {
        this.afu = this.a(40);
        this.afN.a((Entity)this.afM, (byte)10);
        this.afM.S().n();
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
            BlockPosition blockPosition = this.afM.dF();
            IBlockData iBlockData = this.afN.a_(blockPosition);
            if (afr.test(iBlockData)) {
                if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.afM, (BlockPosition)blockPosition, (IBlockData)iBlockData.y().g(), (!akp.a((World)this.afN).S().c(GameRules.d) ? 1 : 0) != 0)) {
                    this.afN.b(blockPosition, false);
                }
                this.afM.V();
            } else {
                BlockPosition blockPosition2 = blockPosition.e();
                if (this.afN.a_(blockPosition2).a(Blocks.i)) {
                    if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.afM, (BlockPosition)blockPosition2, (IBlockData)Blocks.j.m(), (!akp.a((World)this.afN).S().c(GameRules.d) ? 1 : 0) != 0)) {
                        this.afN.c(2001, blockPosition2, Block.j((IBlockData)Blocks.i.m()));
                        this.afN.a(blockPosition2, Blocks.j.m(), 2);
                    }
                    this.afM.V();
                }
            }
        }
    }
}
