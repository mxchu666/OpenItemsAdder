package itemsadder.m;

import itemsadder.m.arn;
import itemsadder.m.arp;
import java.util.HashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.bukkit.Location;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

public class asa
implements arn {
    public arp a(net.minecraft.world.entity.Entity entity, BlockPos blockPos, BlockPos blockPos2, HashSet hashSet) {
        boolean bl = true;
        Level level = entity.level();
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        if (level.hasChunksAt(blockPos, blockPos2)) {
            for (int i = blockPos.getX(); i <= blockPos2.getX(); ++i) {
                for (int j = blockPos.getY(); j <= blockPos2.getY(); ++j) {
                    for (int k = blockPos.getZ(); k <= blockPos2.getZ(); ++k) {
                        mutableBlockPos.set(i, j, k);
                        BlockState blockState = level.getBlockState((BlockPos)mutableBlockPos);
                        if (blockState.isAir()) continue;
                        bl = false;
                        if (!hashSet.contains(blockState.getBlock())) continue;
                        return arp.MATCHED_BLOCK;
                    }
                }
            }
        }
        if (bl) {
            return arp.NOTHING;
        }
        return arp.ANOTHER_BLOCK;
    }

    @Override
    public arp a(Entity entity, HashSet hashSet) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        AABB aABB = entity2.getBoundingBox();
        BlockPos blockPos = new BlockPos(Mth.floor((double)(aABB.minX - 0.001)), Mth.floor((double)(aABB.minY - 0.001)), Mth.floor((double)(aABB.minZ - 0.001)));
        BlockPos blockPos2 = new BlockPos(Mth.floor((double)(aABB.maxX + 0.001)), Mth.floor((double)(aABB.maxY + 0.001)), Mth.floor((double)(aABB.maxZ + 0.001)));
        return this.a(entity2, blockPos, blockPos2, hashSet);
    }

    @Override
    @Nullable
    public Vector a(Location location, Location location2, boolean bl) {
        CraftWorld craftWorld = (CraftWorld)location.getWorld();
        ServerLevel serverLevel = craftWorld.getHandle();
        BlockHitResult blockHitResult = serverLevel.clip(new ClipContext(new Vec3(location.getX(), location.getY(), location.getZ()), new Vec3(location2.getX(), location2.getY(), location2.getZ()), bl ? ClipContext.Block.COLLIDER : ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, (net.minecraft.world.entity.Entity)null));
        if (blockHitResult.getType() == HitResult.Type.MISS) {
            return null;
        }
        return new Vector(blockHitResult.getLocation().x, blockHitResult.getLocation().y, blockHitResult.getLocation().z);
    }
}
