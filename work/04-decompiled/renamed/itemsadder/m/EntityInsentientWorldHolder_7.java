package itemsadder.m;

import itemsadder.m.BlockNms_1_21_6_24;
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

class EntityInsentientWorldHolder_7
extends PathfinderGoal {
    private static final int ahs = 40;
    private static Predicate afr;
    private final EntityInsentient aht;
    private final World ahu;
    private int afu;
    final /* synthetic */ Mob ahv;
    final /* synthetic */ Predicate ahw;

    EntityInsentientWorldHolder_7(BlockNms_1_21_6_24 blockNms_1_21_6_24, Mob mob, Predicate predicate) {
        this.ahv = mob;
        this.ahw = predicate;
        this.aht = ((CraftMob)this.ahv).getHandle();
        this.ahu = this.aht.ai();
        afr = this.ahw == null ? iBlockData -> false : iBlockData -> {
            @NotNull BlockState blockState = iBlockData.createCraftBlockData().createBlockState();
            return this.ahw.test(blockState);
        };
    }

    public boolean ub() {
        if (!((WorldServer)this.ahu).J.a.b(this.aht.dz())) {
            return false;
        }
        if (this.aht.ec().a(this.aht.g_() ? 50 : 1000) != 0) {
            return false;
        }
        BlockPosition blockPosition = this.aht.dx();
        return afr.test(this.ahu.a_(blockPosition));
    }

    public void uc() {
        this.afu = this.a(40);
        this.ahu.a((Entity)this.aht, (byte)10);
        this.aht.S().n();
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
            BlockPosition blockPosition = this.aht.dx();
            IBlockData iBlockData = this.ahu.a_(blockPosition);
            if (afr.test(iBlockData)) {
                if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.aht, (BlockPosition)blockPosition, (IBlockData)iBlockData.y().g(), (!EntityInsentientWorldHolder_7.a((World)this.ahu).P().c(GameRules.d) ? (byte)1 : 0) != 0)) {
                    this.ahu.b(blockPosition, false);
                }
                this.aht.V();
            } else {
                BlockPosition blockPosition2 = blockPosition.e();
                if (this.ahu.a_(blockPosition2).a(Blocks.i)) {
                    if (CraftEventFactory.callEntityChangeBlockEvent((Entity)this.aht, (BlockPosition)blockPosition2, (IBlockData)Blocks.j.m(), (!EntityInsentientWorldHolder_7.a((World)this.ahu).P().c(GameRules.d) ? (byte)1 : 0) != 0)) {
                        this.ahu.c(2001, blockPosition2, Block.j((IBlockData)Blocks.i.m()));
                        this.ahu.a(blockPosition2, Blocks.j.m(), 2);
                    }
                    this.aht.V();
                }
            }
        }
    }
}
