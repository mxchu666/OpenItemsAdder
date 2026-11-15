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
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Vec3i;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.ByteTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.ShortTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.TagType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.SpawnData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LightBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.ObserverBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueOutput;
import org.bukkit.Chunk;
import org.bukkit.ExplosionResult;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.CraftChunk;
import org.bukkit.craftbukkit.CraftSound;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.block.CraftBlock;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.craftbukkit.util.CraftMagicNumbers;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class aci
implements abl {
    BlockState Wt = CraftMagicNumbers.getBlock((Material)Material.SPAWNER).defaultBlockState();
    static final Direction[] Wx = new Direction[]{Direction.WEST, Direction.EAST, Direction.NORTH, Direction.SOUTH, Direction.DOWN, Direction.UP};
    static final Direction[] Wy = new Direction[]{Direction.DOWN, Direction.EAST, Direction.NORTH, Direction.SOUTH, Direction.UP, Direction.WEST};

    @Override
    public boolean a(Event event) {
        EntityExplodeEvent entityExplodeEvent;
        BlockExplodeEvent blockExplodeEvent;
        return event instanceof BlockExplodeEvent && (blockExplodeEvent = (BlockExplodeEvent)event).getExplosionResult() == ExplosionResult.TRIGGER_BLOCK || event instanceof EntityExplodeEvent && (entityExplodeEvent = (EntityExplodeEvent)event).getExplosionResult() == ExplosionResult.TRIGGER_BLOCK;
    }

    @Override
    public void f(org.bukkit.block.Block block, ql ql2) {
        BaseSpawner baseSpawner;
        if (ql2.FD == null) {
            bce.error("Failed to place TILE block. Can't load placeable model obj.");
            return;
        }
        Location location = block.getLocation();
        BlockPos blockPos = new BlockPos(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        LevelChunk levelChunk = aci.z(block.getChunk());
        ServerLevel serverLevel = ((CraftWorld)block.getWorld()).getHandle();
        levelChunk.setBlockState(blockPos, this.Wt, 0);
        SpawnerBlockEntity spawnerBlockEntity = (SpawnerBlockEntity)levelChunk.getBlockEntity(blockPos, LevelChunk.EntityCreationType.IMMEDIATE);
        if (spawnerBlockEntity == null) {
            bce.error("Failed to place TILE block, spawner is null: " + bdf.ai(location));
            return;
        }
        SpawnData spawnData = (SpawnData)ql2.FD.pd();
        if (spawnData == null) {
            baseSpawner = new ArmorStand(EntityType.ARMOR_STAND, (Level)serverLevel);
            baseSpawner.setInvisible(true);
            baseSpawner.setNoBasePlate(true);
            baseSpawner.setMarker(true);
            baseSpawner.setYRot(0.0f);
            baseSpawner.setYHeadRot(0.0f);
            Item item = CraftMagicNumbers.getItem((Material)ql2.getType());
            net.minecraft.world.item.ItemStack itemStack = new net.minecraft.world.item.ItemStack((ItemLike)item, 1);
            CustomModelData customModelData = new CustomModelData(List.of(Float.valueOf(ql2.fX())), List.of(), List.of(), List.of());
            DataComponentPatch.Builder builder = DataComponentPatch.builder();
            builder.set(DataComponents.CUSTOM_MODEL_DATA, (Object)customModelData);
            itemStack.applyComponents(builder.build());
            baseSpawner.setItemSlot(EquipmentSlot.HEAD, itemStack);
            CompoundTag compoundTag = new CompoundTag();
            TagValueOutput tagValueOutput = TagValueOutput.createWrappingGlobal((ProblemReporter)new ProblemReporter.ScopedCollector(LogUtils.getLogger()), (CompoundTag)compoundTag);
            baseSpawner.saveAsPassenger((ValueOutput)tagValueOutput);
            spawnData = new SpawnData(compoundTag, Optional.empty(), Optional.empty());
            ql2.FD.b(spawnData);
        }
        baseSpawner = spawnerBlockEntity.getSpawner();
        baseSpawner.setNextSpawnData((Level)serverLevel, blockPos, spawnData);
        baseSpawner.requiredPlayerRange = 0;
        baseSpawner.maxNearbyEntities = 0;
        baseSpawner.minSpawnDelay = 0;
        baseSpawner.maxSpawnDelay = 0;
        baseSpawner.spawnCount = 0;
        baseSpawner.spawnDelay = 0;
        spawnerBlockEntity.setChanged();
        levelChunk.setBlockEntity((BlockEntity)spawnerBlockEntity);
    }

    public static LevelChunk z(Chunk chunk) {
        return (LevelChunk)((CraftChunk)chunk).getHandle(ChunkStatus.FULL);
    }

    @Override
    public Sound E(Material material) {
        if (material == Material.AIR) {
            return null;
        }
        Block block = CraftMagicNumbers.getBlock((Material)material);
        SoundType soundType = block.defaultBlockState().getSoundType();
        return CraftSound.minecraftToBukkit((SoundEvent)soundType.getBreakSound());
    }

    @Override
    public Sound F(Material material) {
        if (material == Material.AIR) {
            return null;
        }
        Block block = CraftMagicNumbers.getBlock((Material)material);
        SoundType soundType = block.defaultBlockState().getSoundType();
        return CraftSound.minecraftToBukkit((SoundEvent)soundType.getPlaceSound());
    }

    @Override
    public Sound G(Material material) {
        if (material == Material.AIR) {
            return null;
        }
        Block block = CraftMagicNumbers.getBlock((Material)material);
        SoundType soundType = block.defaultBlockState().getSoundType();
        return CraftSound.minecraftToBukkit((SoundEvent)soundType.getHitSound());
    }

    @Override
    public Sound H(Material material) {
        if (material == Material.AIR) {
            return null;
        }
        Block block = CraftMagicNumbers.getBlock((Material)material);
        SoundType soundType = block.defaultBlockState().getSoundType();
        return CraftSound.minecraftToBukkit((SoundEvent)soundType.getStepSound());
    }

    @Override
    public Sound I(Material material) {
        if (material == Material.AIR) {
            return null;
        }
        Block block = CraftMagicNumbers.getBlock((Material)material);
        SoundType soundType = block.defaultBlockState().getSoundType();
        return CraftSound.minecraftToBukkit((SoundEvent)soundType.getFallSound());
    }

    @Override
    public void aX(org.bukkit.block.Block block) {
        LevelChunk levelChunk = aci.z(block.getChunk());
        BlockPos blockPos = new BlockPos(block.getX(), block.getY(), block.getZ());
        BlockState blockState = levelChunk.getBlockState(blockPos);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        Level level = levelChunk.getLevel();
        for (Direction direction : Wx) {
            mutableBlockPos.setWithOffset((Vec3i)blockPos, direction);
            BlockState blockState2 = level.getBlockState((BlockPos)mutableBlockPos);
            Material material = CraftMagicNumbers.getMaterial((Block)blockState2.getBlock());
            if (material == Material.CHORUS_PLANT || material == Material.MUSHROOM_STEM || material == Material.BROWN_MUSHROOM_BLOCK || material == Material.RED_MUSHROOM_BLOCK) continue;
            BlockState blockState3 = blockState2.updateShape((LevelReader)levelChunk.level, (ScheduledTickAccess)levelChunk.level, (BlockPos)mutableBlockPos, direction, blockPos, blockState, levelChunk.level.getRandom());
            Block.updateOrDestroy((BlockState)blockState2, (BlockState)blockState3, (LevelAccessor)level, (BlockPos)mutableBlockPos, (int)0, (int)512);
        }
    }

    @Override
    public void aY(org.bukkit.block.Block block) {
        LevelChunk levelChunk = aci.z(block.getChunk());
        ServerLevel serverLevel = ((CraftChunk)block.getChunk()).getCraftWorld().getHandle();
        BlockPos blockPos = new BlockPos(block.getX(), block.getY(), block.getZ());
        BlockState blockState = levelChunk.getBlockState(blockPos);
        Block block2 = blockState.getBlock();
        serverLevel.scheduleTick(blockPos, block2, 2);
    }

    @Override
    public void k(org.bukkit.block.Block block, boolean bl) {
        LevelChunk levelChunk = aci.z(block.getChunk());
        BlockPos blockPos = new BlockPos(block.getX(), block.getY(), block.getZ());
        BlockState blockState = levelChunk.getBlockState(blockPos);
        blockState.setValue((Property)ObserverBlock.POWERED, (Comparable)Boolean.valueOf(bl));
    }

    @Override
    public boolean aZ(org.bukkit.block.Block block) {
        ServerLevel serverLevel = ((CraftWorld)block.getWorld()).getHandle();
        BlockPos blockPos = new BlockPos(block.getX(), block.getY(), block.getZ());
        boolean bl = false;
        for (Direction direction : LiquidBlock.POSSIBLE_FLOW_DIRECTIONS) {
            BlockPos blockPos2 = blockPos.relative(direction);
            FluidState fluidState = serverLevel.getFluidState(blockPos2);
            if (fluidState.isEmpty()) continue;
            Fluid fluid = fluidState.getType();
            serverLevel.scheduleTick(blockPos2, fluid, fluid.getTickDelay((LevelReader)serverLevel));
            bl = true;
        }
        return bl;
    }

    @Override
    public void c(org.bukkit.block.Block block, int n) {
        ServerLevel serverLevel = ((CraftWorld)block.getWorld()).getHandle();
        BlockPos blockPos = new BlockPos(block.getX(), block.getY(), block.getZ());
        if (n <= 0) {
            for (Direction direction : Wy) {
                BlockPos blockPos2 = blockPos.relative(direction);
                BlockState blockState = serverLevel.getBlockState(blockPos2);
                if (!blockState.isAir() && blockState.getBlock() != Blocks.LIGHT) continue;
                serverLevel.removeBlock(blockPos2, false);
            }
        } else {
            BlockState blockState = Blocks.LIGHT.defaultBlockState();
            blockState = (BlockState)blockState.setValue((Property)LightBlock.LEVEL, (Comparable)Integer.valueOf(Math.min(n, 15)));
            for (Direction direction : Wy) {
                BlockPos blockPos3 = blockPos.relative(direction);
                BlockState blockState2 = serverLevel.getBlockState(blockPos3);
                if (!blockState2.isAir() && blockState2.getBlock() != Blocks.LIGHT) continue;
                serverLevel.setBlock(blockPos3, blockState, 2, 0);
            }
        }
    }

    @Override
    public boolean a(org.bukkit.block.Block block, um um2) {
        Location location = block.getLocation();
        ServerLevel serverLevel = ((CraftWorld)block.getWorld()).getHandle();
        BlockPos blockPos = new BlockPos(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        LevelChunk levelChunk = aci.z(block.getChunk());
        SpawnerBlockEntity spawnerBlockEntity = (SpawnerBlockEntity)levelChunk.getBlockEntity(blockPos, LevelChunk.EntityCreationType.IMMEDIATE);
        if (spawnerBlockEntity == null) {
            return false;
        }
        CompoundTag compoundTag = spawnerBlockEntity.saveWithFullMetadata((HolderLookup.Provider)serverLevel.registryAccess());
        return aci.a(compoundTag, um2);
    }

    @Override
    public boolean b(org.bukkit.block.Block block, ItemStack itemStack) {
        BlockPos blockPos = new BlockPos(block.getX(), block.getY(), block.getZ());
        BlockState blockState = ((CraftWorld)block.getWorld()).getHandle().getBlockState(blockPos);
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        return itemStack2.getDestroySpeed(blockState) > 1.0f && (!blockState.requiresCorrectToolForDrops() || itemStack2.isCorrectToolForDrops(blockState));
    }

    @Override
    public String bb(@NotNull org.bukkit.block.Block block) {
        if (block.getType() == Material.AIR) {
            return "minecraft:air";
        }
        Location location = block.getLocation();
        Block block2 = ((CraftBlock)block).getBlockState().getBlock();
        return BuiltInRegistries.BLOCK.wrapAsHolder((Object)block2).getRegisteredName();
    }

    public static boolean a(CompoundTag compoundTag, um um2) {
        uk uk2 = um2.qK();
        TagType tagType = switch (uk2) {
            case uk.String -> StringTag.TYPE;
            case uk.Int -> IntTag.TYPE;
            case uk.Double -> DoubleTag.TYPE;
            case uk.Float -> FloatTag.TYPE;
            case uk.Byte -> ByteTag.TYPE;
            case uk.Short -> ShortTag.TYPE;
            default -> throw new RuntimeException("Unknown NBT type: " + String.valueOf((Object)uk2));
        };
        String[] stringArray = um2.qJ();
        Object object = um2.qI();
        Tag tag = compoundTag.get(stringArray[0]);
        if (tag == null) {
            return false;
        }
        TagType tagType2 = tag.getType();
        String string2 = stringArray[stringArray.length - 1];
        if (tagType2 == CompoundTag.TYPE) {
            compoundTag = (CompoundTag)compoundTag.getCompound(stringArray[0]).get();
            for (int i = 1; i < stringArray.length - 1; ++i) {
                if (!compoundTag.contains(stringArray[i])) {
                    return false;
                }
                compoundTag = (CompoundTag)compoundTag.getCompound(stringArray[i]).get();
            }
            Tag tag2 = compoundTag.get(string2);
            if (tag2 == null) {
                return false;
            }
            tagType2 = tag2.getType();
            if (tagType2 != tagType) {
                return false;
            }
        }
        if (tagType2 == StringTag.TYPE) {
            return compoundTag.getString(string2).map(string -> string.equals(object)).orElse(false);
        }
        if (tagType2 == IntTag.TYPE) {
            return compoundTag.getInt(string2).map(n -> n.equals(object)).orElse(false);
        }
        if (tagType2 == DoubleTag.TYPE) {
            return compoundTag.getDouble(string2).map(d -> d.equals(object)).orElse(false);
        }
        if (tagType2 == FloatTag.TYPE) {
            return compoundTag.getFloat(string2).map(f -> f.equals(object)).orElse(false);
        }
        if (tagType2 == ByteTag.TYPE) {
            return compoundTag.getByte(string2).map(by -> by.equals(object)).orElse(false);
        }
        if (tagType2 == ShortTag.TYPE) {
            return compoundTag.getShort(string2).map(s -> s.equals(object)).orElse(false);
        }
        return false;
    }
}
