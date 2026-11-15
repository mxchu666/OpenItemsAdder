package itemsadder.m;

import itemsadder.m.LocationWrapper;
import itemsadder.m.NothingEnum;
import java.util.HashSet;
import net.minecraft.core.BlockPosition;
import net.minecraft.server.level.WorldServer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.level.RayTrace;
import net.minecraft.world.level.World;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.phys.AxisAlignedBB;
import net.minecraft.world.phys.MovingObjectPosition;
import net.minecraft.world.phys.MovingObjectPositionBlock;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_21_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R2.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

public class BlockNms_1_21_3_16
implements LocationWrapper {
    public NothingEnum a(net.minecraft.world.entity.Entity entity, BlockPosition blockPosition, BlockPosition blockPosition2, HashSet hashSet) {
        boolean bl = true;
        World world = entity.dW();
        BlockPosition.MutableBlockPosition mutableBlockPosition = new BlockPosition.MutableBlockPosition();
        if (world.a(blockPosition, blockPosition2)) {
            for (int i = blockPosition.u(); i <= blockPosition2.u(); ++i) {
                for (int j = blockPosition.v(); j <= blockPosition2.v(); ++j) {
                    for (int k = blockPosition.w(); k <= blockPosition2.w(); ++k) {
                        mutableBlockPosition.d(i, j, k);
                        IBlockData iBlockData = world.a_((BlockPosition)mutableBlockPosition);
                        if (iBlockData.l()) continue;
                        bl = false;
                        if (!hashSet.contains(iBlockData.b())) continue;
                        return NothingEnum.MATCHED_BLOCK;
                    }
                }
            }
        }
        if (bl) {
            return NothingEnum.NOTHING;
        }
        return NothingEnum.ANOTHER_BLOCK;
    }

    @Override
    public NothingEnum a(Entity entity, HashSet hashSet) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        AxisAlignedBB axisAlignedBB = entity2.cR();
        BlockPosition blockPosition = new BlockPosition(MathHelper.a((double)(axisAlignedBB.a - 0.001)), MathHelper.a((double)(axisAlignedBB.b - 0.001)), MathHelper.a((double)(axisAlignedBB.c - 0.001)));
        BlockPosition blockPosition2 = new BlockPosition(MathHelper.a((double)(axisAlignedBB.d + 0.001)), MathHelper.a((double)(axisAlignedBB.e + 0.001)), MathHelper.a((double)(axisAlignedBB.f + 0.001)));
        return this.a(entity2, blockPosition, blockPosition2, hashSet);
    }

    @Override
    @Nullable
    public Vector a(Location location, Location location2, boolean bl) {
        CraftWorld craftWorld = (CraftWorld)location.getWorld();
        WorldServer worldServer = craftWorld.getHandle();
        MovingObjectPositionBlock movingObjectPositionBlock = worldServer.a(new RayTrace(new Vec3D(location.getX(), location.getY(), location.getZ()), new Vec3D(location2.getX(), location2.getY(), location2.getZ()), bl ? RayTrace.BlockCollisionOption.a : RayTrace.BlockCollisionOption.b, RayTrace.FluidCollisionOption.c, (net.minecraft.world.entity.Entity)null));
        if (movingObjectPositionBlock.d() == MovingObjectPosition.EnumMovingObjectType.a) {
            return null;
        }
        return new Vector(movingObjectPositionBlock.g().d, movingObjectPositionBlock.g().e, movingObjectPositionBlock.g().f);
    }
}
