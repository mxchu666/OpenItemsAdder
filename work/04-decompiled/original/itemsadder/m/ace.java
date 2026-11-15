package itemsadder.m;

import com.mojang.logging.LogUtils;
import itemsadder.m.abl;
import itemsadder.m.bce;
import itemsadder.m.bdf;
import itemsadder.m.ql;
import itemsadder.m.uk;
import itemsadder.m.um;
import java.util.List;
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
import net.minecraft.util.ProblemReporter;
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
import net.minecraft.world.level.ScheduledTickAccess;
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
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueOutput;
import org.bukkit.Chunk;
import org.bukkit.ExplosionResult;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_21_R5.CraftChunk;
import org.bukkit.craftbukkit.v1_21_R5.CraftSound;
import org.bukkit.craftbukkit.v1_21_R5.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R5.block.CraftBlock;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_21_R5.util.CraftMagicNumbers;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ace
implements abl {
    IBlockData VO = CraftMagicNumbers.getBlock((Material)Material.SPAWNER).m();
    static final EnumDirection[] Wq = new EnumDirection[]{EnumDirection.e, EnumDirection.f, EnumDirection.c, EnumDirection.d, EnumDirection.a, EnumDirection.b};
    static final EnumDirection[] Wr = new EnumDirection[]{EnumDirection.a, EnumDirection.f, EnumDirection.c, EnumDirection.d, EnumDirection.b, EnumDirection.e};

    @Override
    public boolean a(Event event) {
        EntityExplodeEvent entityExplodeEvent;
        BlockExplodeEvent blockExplodeEvent;
        return event instanceof BlockExplodeEvent && (blockExplodeEvent = (BlockExplodeEvent)event).getExplosionResult() == ExplosionResult.TRIGGER_BLOCK || event instanceof EntityExplodeEvent && (entityExplodeEvent = (EntityExplodeEvent)event).getExplosionResult() == ExplosionResult.TRIGGER_BLOCK;
    }

    @Override
    public void f(org.bukkit.block.Block block, ql ql2) {
        MobSpawnerAbstract mobSpawnerAbstract;
        if (ql2.FD == null) {
            bce.error("Failed to place TILE block. Can't load placeable model obj.");
            return;
        }
        Location location = block.getLocation();
        BlockPosition blockPosition = new BlockPosition(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        net.minecraft.world.level.chunk.Chunk chunk = ace.y(block.getChunk());
        WorldServer worldServer = ((CraftWorld)block.getWorld()).getHandle();
        chunk.a(blockPosition, this.VO, 0);
        TileEntityMobSpawner tileEntityMobSpawner = (TileEntityMobSpawner)chunk.a(blockPosition, Chunk.EnumTileEntityState.a);
        if (tileEntityMobSpawner == null) {
            bce.error("Failed to place TILE block, spawner is null: " + bdf.ai(location));
            return;
        }
        MobSpawnerData mobSpawnerData = (MobSpawnerData)ql2.FD.pd();
        if (mobSpawnerData == null) {
            mobSpawnerAbstract = new EntityArmorStand(EntityTypes.g, (World)worldServer);
            mobSpawnerAbstract.l(true);
            mobSpawnerAbstract.b(true);
            mobSpawnerAbstract.v(true);
            mobSpawnerAbstract.v(0.0f);
            mobSpawnerAbstract.r(0.0f);
            Item item = CraftMagicNumbers.getItem((Material)ql2.getType());
            net.minecraft.world.item.ItemStack itemStack = new net.minecraft.world.item.ItemStack((IMaterial)item, 1);
            CustomModelData customModelData = new CustomModelData(List.of(Float.valueOf(ql2.fX())), List.of(), List.of(), List.of());
            DataComponentPatch.a a2 = DataComponentPatch.a();
            a2.a(DataComponents.p, (Object)customModelData);
            itemStack.b(a2.a());
            mobSpawnerAbstract.a(EnumItemSlot.f, itemStack);
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            TagValueOutput tagValueOutput = TagValueOutput.createWrappingGlobal((ProblemReporter)new ProblemReporter.j(LogUtils.getLogger()), (NBTTagCompound)nBTTagCompound);
            mobSpawnerAbstract.b((ValueOutput)tagValueOutput);
            mobSpawnerData = new MobSpawnerData(nBTTagCompound, Optional.empty(), Optional.empty());
            ql2.FD.b(mobSpawnerData);
        }
        mobSpawnerAbstract = tileEntityMobSpawner.c();
        mobSpawnerAbstract.a((World)worldServer, blockPosition, mobSpawnerData);
        mobSpawnerAbstract.u = 0;
        mobSpawnerAbstract.t = 0;
        mobSpawnerAbstract.p = 0;
        mobSpawnerAbstract.q = 0;
        mobSpawnerAbstract.r = 0;
        mobSpawnerAbstract.k = 0;
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
        SoundEffectType soundEffectType = block.m().A();
        return CraftSound.minecraftToBukkit((SoundEffect)soundEffectType.c());
    }

    @Override
    public Sound F(Material material) {
        if (material == Material.AIR) {
            return null;
        }
        Block block = CraftMagicNumbers.getBlock((Material)material);
        SoundEffectType soundEffectType = block.m().A();
        return CraftSound.minecraftToBukkit((SoundEffect)soundEffectType.e());
    }

    @Override
    public Sound G(Material material) {
        if (material == Material.AIR) {
            return null;
        }
        Block block = CraftMagicNumbers.getBlock((Material)material);
        SoundEffectType soundEffectType = block.m().A();
        return CraftSound.minecraftToBukkit((SoundEffect)soundEffectType.f());
    }

    @Override
    public Sound H(Material material) {
        if (material == Material.AIR) {
            return null;
        }
        Block block = CraftMagicNumbers.getBlock((Material)material);
        SoundEffectType soundEffectType = block.m().A();
        return CraftSound.minecraftToBukkit((SoundEffect)soundEffectType.d());
    }

    @Override
    public Sound I(Material material) {
        if (material == Material.AIR) {
            return null;
        }
        Block block = CraftMagicNumbers.getBlock((Material)material);
        SoundEffectType soundEffectType = block.m().A();
        return CraftSound.minecraftToBukkit((SoundEffect)soundEffectType.g());
    }

    @Override
    public void aX(org.bukkit.block.Block block) {
        net.minecraft.world.level.chunk.Chunk chunk = ace.y(block.getChunk());
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        IBlockData iBlockData = chunk.a_(blockPosition);
        BlockPosition.MutableBlockPosition mutableBlockPosition = new BlockPosition.MutableBlockPosition();
        World world = chunk.I();
        for (EnumDirection enumDirection : Wq) {
            mutableBlockPosition.a((BaseBlockPosition)blockPosition, enumDirection);
            IBlockData iBlockData2 = world.a_((BlockPosition)mutableBlockPosition);
            Material material = CraftMagicNumbers.getMaterial((Block)iBlockData2.b());
            if (material == Material.CHORUS_PLANT || material == Material.MUSHROOM_STEM || material == Material.BROWN_MUSHROOM_BLOCK || material == Material.RED_MUSHROOM_BLOCK) continue;
            IBlockData iBlockData3 = iBlockData2.a((IWorldReader)chunk.r, (ScheduledTickAccess)chunk.r, (BlockPosition)mutableBlockPosition, enumDirection, blockPosition, iBlockData, chunk.r.A);
            Block.a((IBlockData)iBlockData2, (IBlockData)iBlockData3, (GeneratorAccess)world, (BlockPosition)mutableBlockPosition, (int)0, (int)512);
        }
    }

    @Override
    public void aY(org.bukkit.block.Block block) {
        net.minecraft.world.level.chunk.Chunk chunk = ace.y(block.getChunk());
        WorldServer worldServer = ((CraftChunk)block.getChunk()).getCraftWorld().getHandle();
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        IBlockData iBlockData = chunk.a_(blockPosition);
        Block block2 = iBlockData.b();
        worldServer.a(blockPosition, block2, 2);
    }

    @Override
    public void k(org.bukkit.block.Block block, boolean bl) {
        net.minecraft.world.level.chunk.Chunk chunk = ace.y(block.getChunk());
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        IBlockData iBlockData = chunk.a_(blockPosition);
        iBlockData.b((IBlockState)BlockObserver.c, (Comparable)Boolean.valueOf(bl));
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
            for (EnumDirection enumDirection : Wr) {
                BlockPosition blockPosition2 = blockPosition.a(enumDirection);
                IBlockData iBlockData = worldServer.a_(blockPosition2);
                if (!iBlockData.l() && iBlockData.b() != Blocks.iz) continue;
                worldServer.a(blockPosition2, false);
            }
        } else {
            IBlockData iBlockData = Blocks.iz.m();
            iBlockData = (IBlockData)iBlockData.b((IBlockState)LightBlock.c, (Comparable)Integer.valueOf(Math.min(n, 15)));
            for (EnumDirection enumDirection : Wr) {
                BlockPosition blockPosition3 = blockPosition.a(enumDirection);
                IBlockData iBlockData2 = worldServer.a_(blockPosition3);
                if (!iBlockData2.l() && iBlockData2.b() != Blocks.iz) continue;
                worldServer.a(blockPosition3, iBlockData, 2, 0);
            }
        }
    }

    @Override
    public boolean a(org.bukkit.block.Block block, um um2) {
        Location location = block.getLocation();
        WorldServer worldServer = ((CraftWorld)block.getWorld()).getHandle();
        BlockPosition blockPosition = new BlockPosition(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        net.minecraft.world.level.chunk.Chunk chunk = ace.y(block.getChunk());
        TileEntityMobSpawner tileEntityMobSpawner = (TileEntityMobSpawner)chunk.a(blockPosition, Chunk.EnumTileEntityState.a);
        if (tileEntityMobSpawner == null) {
            return false;
        }
        NBTTagCompound nBTTagCompound = tileEntityMobSpawner.b((HolderLookup.a)worldServer.K_());
        return ace.a(nBTTagCompound, um2);
    }

    @Override
    public boolean b(org.bukkit.block.Block block, ItemStack itemStack) {
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        IBlockData iBlockData = ((CraftWorld)block.getWorld()).getHandle().a_(blockPosition);
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        return itemStack2.a(iBlockData) > 1.0f && (!iBlockData.C() || itemStack2.b(iBlockData));
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

    public static boolean a(NBTTagCompound nBTTagCompound, um um2) {
        uk uk2 = um2.qK();
        NBTTagType nBTTagType = switch (uk2) {
            case uk.String -> NBTTagString.a;
            case uk.Int -> NBTTagInt.a;
            case uk.Double -> NBTTagDouble.b;
            case uk.Float -> NBTTagFloat.b;
            case uk.Byte -> NBTTagByte.a;
            case uk.Short -> NBTTagShort.a;
            default -> throw new RuntimeException("Unknown NBT type: " + String.valueOf((Object)uk2));
        };
        String[] stringArray = um2.qJ();
        Object object = um2.qI();
        NBTBase nBTBase = nBTTagCompound.a(stringArray[0]);
        if (nBTBase == null) {
            return false;
        }
        NBTTagType nBTTagType2 = nBTBase.c();
        String string2 = stringArray[stringArray.length - 1];
        if (nBTTagType2 == NBTTagCompound.b) {
            nBTTagCompound = (NBTTagCompound)nBTTagCompound.m(stringArray[0]).get();
            for (int i = 1; i < stringArray.length - 1; ++i) {
                if (!nBTTagCompound.b(stringArray[i])) {
                    return false;
                }
                nBTTagCompound = (NBTTagCompound)nBTTagCompound.m(stringArray[i]).get();
            }
            NBTBase nBTBase2 = nBTTagCompound.a(string2);
            if (nBTBase2 == null) {
                return false;
            }
            nBTTagType2 = nBTBase2.c();
            if (nBTTagType2 != nBTTagType) {
                return false;
            }
        }
        if (nBTTagType2 == NBTTagString.a) {
            return nBTTagCompound.i(string2).map(string -> string.equals(object)).orElse(false);
        }
        if (nBTTagType2 == NBTTagInt.a) {
            return nBTTagCompound.e(string2).map(n -> n.equals(object)).orElse(false);
        }
        if (nBTTagType2 == NBTTagDouble.b) {
            return nBTTagCompound.h(string2).map(d -> d.equals(object)).orElse(false);
        }
        if (nBTTagType2 == NBTTagFloat.b) {
            return nBTTagCompound.g(string2).map(f -> f.equals(object)).orElse(false);
        }
        if (nBTTagType2 == NBTTagByte.a) {
            return nBTTagCompound.c(string2).map(by -> by.equals(object)).orElse(false);
        }
        if (nBTTagType2 == NBTTagShort.a) {
            return nBTTagCompound.d(string2).map(s -> s.equals(object)).orElse(false);
        }
        return false;
    }
}
