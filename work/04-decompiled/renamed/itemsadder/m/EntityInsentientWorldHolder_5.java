package itemsadder.m;

import itemsadder.m.BlockNms_1_21_4_24;
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
import org.bukkit.craftbukkit.v1_21_R3.entity.CraftMob;
import org.bukkit.craftbukkit.v1_21_R3.event.CraftEventFactory;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.NotNull;

class EntityInsentientWorldHolder_5
extends PathfinderGoal {
    private static final int agK = 40;
    private static Predicate afr;
    private final EntityInsentient agL;
    private final World agM;
    private int afu;
    final /* synthetic */ Mob agN;
    final /* synthetic */ Predicate agO;

    EntityInsentientWorldHolder_5(BlockNms_1_21_4_24 blockNms_1_21_4_24, Mob mob, Predicate predicate) {
        this.agN = mob;
        this.agO = predicate;
        this.agL = ((CraftMob)this.agN).getHandle();
        this.agM = this.agL.dV();
        afr = this.agO == null ? iBlockData -> false : iBlockData -> {
            @NotNull BlockState blockState = iBlockData.createCraftBlockData().createBlockState();
            return this.agO.test(blockState);
        };
    }

    public boolean ub() {
        if (!((WorldServer)this.agM).J.a.b(this.agL.dx())) {
            return false;
        }
        if (this.agL.dY().a(this.agL.e_() ? 50 : 1000) != 0) {
            return false;
        }
        BlockPosition blockPosition = this.agL.dv();
        return afr.test(this.agM.a_(blockPosition));
    }

    public void uc() {
        this.afu = this.a(40);
        this.agM.a((Entity)this.agL, (byte)10);
        this.agL.P().m();
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
            BlockPosition blockPosition = this.agL.dv();
            IBlockData iBlockData = this.agM.a_(blockPosition);
            if (afr.test(iBlockData)) {
                if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.agL, (BlockPosition)blockPosition, (IBlockData)iBlockData.y().g(), (!EntityInsentientWorldHolder_5.a((World)this.agM).O().b(GameRules.c) ? (byte)1 : 0) != 0)) {
                    this.agM.b(blockPosition, false);
                }
                this.agL.S();
            } else {
                BlockPosition blockPosition2 = blockPosition.e();
                if (this.agM.a_(blockPosition2).a(Blocks.i)) {
                    if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.agL, (BlockPosition)blockPosition2, (IBlockData)Blocks.j.m(), (!EntityInsentientWorldHolder_5.a((World)this.agM).O().b(GameRules.c) ? (byte)1 : 0) != 0)) {
                        this.agM.c(2001, blockPosition2, Block.j((IBlockData)Blocks.i.m()));
                        this.agM.a(blockPosition2, Blocks.j.m(), 2);
                    }
                    this.agL.S();
                }
            }
        }
    }
}
