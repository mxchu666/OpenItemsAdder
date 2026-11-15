package itemsadder.m;

import itemsadder.m.BlockWrapper;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EndEnum;
import itemsadder.m.EntityBridge_5;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridge_4;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.core.BaseBlockPosition;
import net.minecraft.core.BlockPosition;
import net.minecraft.core.EnumDirection;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagShort;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.nbt.NBTTagType;
import net.minecraft.server.level.WorldServer;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.EnumItemSlot;
import net.minecraft.world.entity.decoration.EntityArmorStand;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.level.GeneratorAccess;
import net.minecraft.world.level.IMaterial;
import net.minecraft.world.level.IWorldReader;
import net.minecraft.world.level.MobSpawnerAbstract;
import net.minecraft.world.level.MobSpawnerData;
import net.minecraft.world.level.World;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BlockFluids;
import net.minecraft.world.level.block.BlockObserver;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LightBlock;
import net.minecraft.world.level.block.SoundEffectType;
import net.minecraft.world.level.block.entity.TileEntity;
import net.minecraft.world.level.block.entity.TileEntityMobSpawner;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.level.block.state.properties.IBlockState;
import net.minecraft.world.level.chunk.Chunk;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidType;
import org.bukkit.Chunk;
import org.bukkit.ExplosionResult;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_21_R1.CraftChunk;
import org.bukkit.craftbukkit.v1_21_R1.CraftSound;
import org.bukkit.craftbukkit.v1_21_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R1.block.CraftBlock;
import org.bukkit.craftbukkit.v1_21_R1.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_21_R1.util.CraftMagicNumbers;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BlockNms_1_21_1_2
implements BlockWrapper {
    IBlockData VO = CraftMagicNumbers.getBlock((Material)Material.SPAWNER).o();
    static final EnumDirection[] VS = new EnumDirection[]{EnumDirection.e, EnumDirection.f, EnumDirection.c, EnumDirection.d, EnumDirection.a, EnumDirection.b};
    static final EnumDirection[] VT = new EnumDirection[]{EnumDirection.a, EnumDirection.f, EnumDirection.c, EnumDirection.d, EnumDirection.b, EnumDirection.e};

    @Override
    public boolean a(Event event) {
        EntityExplodeEvent entityExplodeEvent;
        BlockExplodeEvent blockExplodeEvent;
        return event instanceof BlockExplodeEvent && (blockExplodeEvent = (BlockExplodeEvent)event).getExplosionResult() == ExplosionResult.TRIGGER_BLOCK || event instanceof EntityExplodeEvent && (entityExplodeEvent = (EntityExplodeEvent)event).getExplosionResult() == ExplosionResult.TRIGGER_BLOCK;
    }

    @Override
    public void f(org.bukkit.block.Block block, LocationBridgeBuilder_2 locationBridgeBuilder_2) {
        MobSpawnerAbstract mobSpawnerAbstract;
        if (locationBridgeBuilder_2.FD == null) {
            CommandSenderBridge_5.error("Failed to place TILE block. Can't load placeable model obj.");
            return;
        }
        Location location = block.getLocation();
        BlockPosition blockPosition = new BlockPosition(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        net.minecraft.world.level.chunk.Chunk chunk = BlockNms_1_21_1_2.y(block.getChunk());
        WorldServer worldServer = ((CraftWorld)block.getWorld()).getHandle();
        chunk.a(blockPosition, this.VO, false);
        TileEntityMobSpawner tileEntityMobSpawner = (TileEntityMobSpawner)chunk.a(blockPosition, Chunk.EnumTileEntityState.a);
        if (tileEntityMobSpawner == null) {
            CommandSenderBridge_5.error("Failed to place TILE block, spawner is null: " + LocationBridge_4.ai(location));
            return;
        }
        MobSpawnerData mobSpawnerData = (MobSpawnerData)locationBridgeBuilder_2.FD.pd();
        if (mobSpawnerData == null) {
            mobSpawnerAbstract = new EntityArmorStand(EntityTypes.d, (World)worldServer);
            mobSpawnerAbstract.k(true);
            mobSpawnerAbstract.b(true);
            mobSpawnerAbstract.v(true);
            mobSpawnerAbstract.t(0.0f);
            mobSpawnerAbstract.o(0.0f);
            Item item = CraftMagicNumbers.getItem((Material)locationBridgeBuilder_2.getType());
            net.minecraft.world.item.ItemStack itemStack = new net.minecraft.world.item.ItemStack((IMaterial)item, 1);
            CustomModelData customModelData = new CustomModelData(locationBridgeBuilder_2.fX());
            DataComponentPatch.a a2 = DataComponentPatch.a();
            a2.a(DataComponents.o, (Object)customModelData);
            itemStack.b(a2.a());
            mobSpawnerAbstract.a(EnumItemSlot.f, itemStack);
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            mobSpawnerAbstract.d(nBTTagCompound);
            mobSpawnerData = new MobSpawnerData(nBTTagCompound, Optional.empty(), Optional.empty());
            locationBridgeBuilder_2.FD.b(mobSpawnerData);
        }
        mobSpawnerAbstract = tileEntityMobSpawner.c();
        mobSpawnerAbstract.a((World)worldServer, blockPosition, mobSpawnerData);
        mobSpawnerAbstract.n = 0;
        mobSpawnerAbstract.m = 0;
        mobSpawnerAbstract.i = 0;
        mobSpawnerAbstract.j = 0;
        mobSpawnerAbstract.k = 0;
        mobSpawnerAbstract.d = 0;
        tileEntityMobSpawner.e();
        chunk.a((TileEntity)tileEntityMobSpawner);
    }

    public static net.minecraft.world.level.chunk.Chunk y(Chunk chunk) {
        return (net.minecraft.world.level.chunk.Chunk)((CraftChunk)chunk).getHandle(ChunkStatus.n);
    }

    @Override
    public Sound E(Material material) {
        if (material == Material.AIR) {
            return null;
        }
        Block block = CraftMagicNumbers.getBlock((Material)material);
        SoundEffectType soundEffectType = block.o().w();
        return CraftSound.minecraftToBukkit((SoundEffect)soundEffectType.c());
    }

    @Override
    public Sound F(Material material) {
        if (material == Material.AIR) {
            return null;
        }
        Block block = CraftMagicNumbers.getBlock((Material)material);
        SoundEffectType soundEffectType = block.o().w();
        return CraftSound.minecraftToBukkit((SoundEffect)soundEffectType.e());
    }

    @Override
    public Sound G(Material material) {
        if (material == Material.AIR) {
            return null;
        }
        Block block = CraftMagicNumbers.getBlock((Material)material);
        SoundEffectType soundEffectType = block.o().w();
        return CraftSound.minecraftToBukkit((SoundEffect)soundEffectType.f());
    }

    @Override
    public Sound H(Material material) {
        if (material == Material.AIR) {
            return null;
        }
        Block block = CraftMagicNumbers.getBlock((Material)material);
        SoundEffectType soundEffectType = block.o().w();
        return CraftSound.minecraftToBukkit((SoundEffect)soundEffectType.d());
    }

    @Override
    public Sound I(Material material) {
        if (material == Material.AIR) {
            return null;
        }
        Block block = CraftMagicNumbers.getBlock((Material)material);
        SoundEffectType soundEffectType = block.o().w();
        return CraftSound.minecraftToBukkit((SoundEffect)soundEffectType.g());
    }

    @Override
    public void aX(org.bukkit.block.Block block) {
        net.minecraft.world.level.chunk.Chunk chunk = BlockNms_1_21_1_2.y(block.getChunk());
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        IBlockData iBlockData = chunk.a_(blockPosition);
        BlockPosition.MutableBlockPosition mutableBlockPosition = new BlockPosition.MutableBlockPosition();
        World world = chunk.F();
        for (EnumDirection enumDirection : VS) {
            mutableBlockPosition.a((BaseBlockPosition)blockPosition, enumDirection);
            IBlockData iBlockData2 = world.a_((BlockPosition)mutableBlockPosition);
            Material material = CraftMagicNumbers.getMaterial((Block)iBlockData2.b());
            if (material == Material.CHORUS_PLANT || material == Material.MUSHROOM_STEM || material == Material.BROWN_MUSHROOM_BLOCK || material == Material.RED_MUSHROOM_BLOCK) continue;
            IBlockData iBlockData3 = iBlockData2.a(enumDirection.g(), iBlockData, (GeneratorAccess)world, (BlockPosition)mutableBlockPosition, blockPosition);
            Block.a((IBlockData)iBlockData2, (IBlockData)iBlockData3, (GeneratorAccess)world, (BlockPosition)mutableBlockPosition, (int)0, (int)512);
        }
    }

    @Override
    public void aY(org.bukkit.block.Block block) {
        net.minecraft.world.level.chunk.Chunk chunk = BlockNms_1_21_1_2.y(block.getChunk());
        WorldServer worldServer = ((CraftChunk)block.getChunk()).getCraftWorld().getHandle();
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        IBlockData iBlockData = chunk.a_(blockPosition);
        Block block2 = iBlockData.b();
        worldServer.a(blockPosition, block2, 2);
    }

    @Override
    public void k(org.bukkit.block.Block block, boolean bl) {
        net.minecraft.world.level.chunk.Chunk chunk = BlockNms_1_21_1_2.y(block.getChunk());
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        IBlockData iBlockData = chunk.a_(blockPosition);
        iBlockData.a((IBlockState)BlockObserver.c, (Comparable)Boolean.valueOf(bl));
    }

    @Override
    public boolean aZ(org.bukkit.block.Block block) {
        WorldServer worldServer = ((CraftWorld)block.getWorld()).getHandle();
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        boolean bl = false;
        for (EnumDirection enumDirection : BlockFluids.e) {
            BlockPosition blockPosition2 = blockPosition.a(enumDirection);
            Fluid fluid = worldServer.b_(blockPosition2);
            if (fluid.c()) continue;
            FluidType fluidType = fluid.a();
            worldServer.a(blockPosition2, fluidType, fluidType.a((IWorldReader)worldServer));
            bl = true;
        }
        return bl;
    }

    @Override
    public void c(org.bukkit.block.Block block, int n) {
        WorldServer worldServer = ((CraftWorld)block.getWorld()).getHandle();
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        if (n <= 0) {
            for (EnumDirection enumDirection : VT) {
                BlockPosition blockPosition2 = blockPosition.a(enumDirection);
                IBlockData iBlockData = worldServer.a_(blockPosition2);
                if (!iBlockData.i() && iBlockData.b() != Blocks.hX) continue;
                worldServer.a(blockPosition2, false);
            }
        } else {
            IBlockData iBlockData = Blocks.hX.o();
            iBlockData = (IBlockData)iBlockData.a((IBlockState)LightBlock.c, (Comparable)Integer.valueOf(Math.min(n, 15)));
            for (EnumDirection enumDirection : VT) {
                BlockPosition blockPosition3 = blockPosition.a(enumDirection);
                IBlockData iBlockData2 = worldServer.a_(blockPosition3);
                if (!iBlockData2.i() && iBlockData2.b() != Blocks.hX) continue;
                worldServer.a(blockPosition3, iBlockData, 2, 0);
            }
        }
    }

    @Override
    public boolean a(org.bukkit.block.Block block, EntityBridge_5 entityBridge_5) {
        Location location = block.getLocation();
        WorldServer worldServer = ((CraftWorld)block.getWorld()).getHandle();
        BlockPosition blockPosition = new BlockPosition(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        net.minecraft.world.level.chunk.Chunk chunk = BlockNms_1_21_1_2.y(block.getChunk());
        TileEntityMobSpawner tileEntityMobSpawner = (TileEntityMobSpawner)chunk.a(blockPosition, Chunk.EnumTileEntityState.a);
        if (tileEntityMobSpawner == null) {
            return false;
        }
        NBTTagCompound nBTTagCompound = tileEntityMobSpawner.b((HolderLookup.a)worldServer.H_());
        return BlockNms_1_21_1_2.a(nBTTagCompound, entityBridge_5);
    }

    @Override
    public boolean b(org.bukkit.block.Block block, ItemStack itemStack) {
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        IBlockData iBlockData = ((CraftWorld)block.getWorld()).getHandle().a_(blockPosition);
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        return itemStack2.a(iBlockData) > 1.0f && (!iBlockData.y() || itemStack2.b(iBlockData));
    }

    @Override
    public String bb(@NotNull org.bukkit.block.Block block) {
        if (block.getType() == Material.AIR) {
            return "minecraft:air";
        }
        Location location = block.getLocation();
        Block block2 = ((CraftBlock)block).getHandle().a_(new BlockPosition(location.getBlockX(), location.getBlockY(), location.getBlockZ())).b();
        return BuiltInRegistries.e.e((Object)block2).g();
    }

    public static boolean a(NBTTagCompound nBTTagCompound, EntityBridge_5 entityBridge_5) {
        EndEnum endEnum = entityBridge_5.qK();
        NBTTagType nBTTagType = switch (endEnum) {
            case EndEnum.String -> NBTTagString.a;
            case EndEnum.Int -> NBTTagInt.a;
            case EndEnum.Double -> NBTTagDouble.b;
            case EndEnum.Float -> NBTTagFloat.b;
            case EndEnum.Byte -> NBTTagByte.a;
            case EndEnum.Short -> NBTTagShort.a;
            default -> throw new RuntimeException("Unknown NBT type: " + String.valueOf((Object)endEnum));
        };
        String[] stringArray = entityBridge_5.qJ();
        Object object = entityBridge_5.qI();
        NBTBase nBTBase = nBTTagCompound.c(stringArray[0]);
        if (nBTBase == null) {
            return false;
        }
        NBTTagType nBTTagType2 = nBTBase.c();
        if (nBTTagType2 == NBTTagCompound.b) {
            nBTTagCompound = nBTTagCompound.p(stringArray[0]);
            for (int i = 1; i < stringArray.length - 1; ++i) {
                if (!nBTTagCompound.e(stringArray[i])) {
                    return false;
                }
                nBTTagCompound = nBTTagCompound.p(stringArray[i]);
            }
            NBTBase nBTBase2 = nBTTagCompound.c(stringArray[stringArray.length - 1]);
            if (nBTBase2 == null) {
                return false;
            }
            nBTTagType2 = nBTBase2.c();
            if (nBTTagType2 != nBTTagType) {
                return false;
            }
        }
        if (nBTTagType2 == NBTTagString.a) {
            return nBTTagCompound.l(stringArray[stringArray.length - 1]).equals(object);
        }
        if (nBTTagType2 == NBTTagInt.a) {
            return Objects.equals(nBTTagCompound.h(stringArray[stringArray.length - 1]), object);
        }
        if (nBTTagType2 == NBTTagDouble.b) {
            return Objects.equals(nBTTagCompound.k(stringArray[stringArray.length - 1]), object);
        }
        if (nBTTagType2 == NBTTagFloat.b) {
            return Objects.equals(Float.valueOf(nBTTagCompound.j(stringArray[stringArray.length - 1])), object);
        }
        if (nBTTagType2 == NBTTagByte.a) {
            return Objects.equals(nBTTagCompound.f(stringArray[stringArray.length - 1]), object);
        }
        if (nBTTagType2 == NBTTagShort.a) {
            return Objects.equals(nBTTagCompound.g(stringArray[stringArray.length - 1]), object);
        }
        return false;
    }
}
