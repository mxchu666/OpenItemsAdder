package itemsadder.m;

import itemsadder.m.AirEnum;
import itemsadder.m.BlockNms;
import itemsadder.m.BlockRegistry;
import itemsadder.m.InstrumentByteStringData;
import itemsadder.m.VersionHelper_3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.LayeredRegistryAccess;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ClientboundUpdateTagsPacket;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.players.PlayerList;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagNetworkSerialization;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.NoteBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.MapColor;
import org.bukkit.Chunk;
import org.bukkit.HeightMap;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.CraftChunk;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.block.CraftBlock;
import org.bukkit.craftbukkit.util.CraftMagicNumbers;
import org.jetbrains.annotations.Nullable;

public class BlockNms_26_1_2
implements BlockNms {
    private Packet Vu;
    List Vv = Arrays.asList(Material.SHORT_GRASS, Material.FERN, Material.DEAD_BUSH, Material.VINE, Material.GLOW_LICHEN, Material.SUNFLOWER, Material.LILAC, Material.ROSE_BUSH, Material.PEONY, Material.TALL_GRASS, Material.LARGE_FERN, Material.HANGING_ROOTS, Material.PITCHER_PLANT, Material.SEAGRASS);

    @Override
    @Deprecated
    public Class tj() {
        return MapColor.class;
    }

    @Override
    @Deprecated
    public boolean a(org.bukkit.block.Block block, AirEnum airEnum) {
        throw new RuntimeException("Not supported on 1.20");
    }

    @Override
    public boolean aK(org.bukkit.block.Block block) {
        ServerLevel serverLevel = ((CraftWorld)block.getWorld()).getHandle();
        BlockPos blockPos = new BlockPos(block.getX(), block.getY(), block.getZ());
        return serverLevel.isRainingAt(blockPos);
    }

    @Override
    public boolean B(Material material) {
        return CraftMagicNumbers.getBlock((Material)material) instanceof EntityBlock;
    }

    @Override
    public boolean aL(org.bukkit.block.Block block) {
        ServerLevel serverLevel = ((CraftWorld)block.getWorld()).getHandle();
        BlockPos blockPos = new BlockPos(block.getX(), block.getY(), block.getZ());
        LevelChunk levelChunk = serverLevel.getChunk(block.getX() >> 4, block.getZ() >> 4);
        Block block2 = levelChunk.getBlockState(blockPos).getBlock();
        return block2 instanceof EntityBlock;
    }

    @Override
    public boolean aJ(org.bukkit.block.Block block) {
        return ((CraftBlock)block).getBlockState().canBeReplaced();
    }

    @Override
    public boolean aN(org.bukkit.block.Block block) {
        return ((CraftBlock)block).getBlockState().liquid();
    }

    @Override
    public boolean aQ(org.bukkit.block.Block block) {
        return ((CraftBlock)block.getRelative(BlockFace.DOWN)).getBlockState().isAir();
    }

    @Override
    public int a(Chunk chunk, int n, int n2, HeightMap heightMap) {
        return BlockNms_26_1_2.z(chunk).getHeight(this.b(heightMap), n, n2);
    }

    public static LevelChunk z(Chunk chunk) {
        return (LevelChunk)((CraftChunk)chunk).getHandle(ChunkStatus.FULL);
    }

    public Heightmap.Types b(HeightMap heightMap) {
        return switch (heightMap) {
            case HeightMap.MOTION_BLOCKING -> Heightmap.Types.MOTION_BLOCKING;
            case HeightMap.MOTION_BLOCKING_NO_LEAVES -> Heightmap.Types.MOTION_BLOCKING_NO_LEAVES;
            case HeightMap.OCEAN_FLOOR -> Heightmap.Types.OCEAN_FLOOR;
            case HeightMap.OCEAN_FLOOR_WG -> Heightmap.Types.OCEAN_FLOOR_WG;
            case HeightMap.WORLD_SURFACE -> Heightmap.Types.WORLD_SURFACE;
            case HeightMap.WORLD_SURFACE_WG -> Heightmap.Types.WORLD_SURFACE_WG;
            default -> throw new EnumConstantNotPresentException(Heightmap.Types.class, heightMap.name());
        };
    }

    @Override
    public void a(BlockRegistry blockRegistry) {
    }

    @Override
    public int C(Material material) {
        Integer n = (Integer)Vo.get(material);
        if (n == null) {
            n = Item.getId((Item)CraftMagicNumbers.getItem((Material)material));
            Vo.put(material, n);
        }
        return n;
    }

    @Override
    public Instrument aR(org.bukkit.block.Block block) {
        NoteBlockInstrument noteBlockInstrument = ((CraftBlock)block).getBlockState().instrument();
        return BlockRegistry.c((byte)noteBlockInstrument.ordinal());
    }

    @Override
    @Nullable
    public InstrumentByteStringData aS(org.bukkit.block.Block block) {
        BlockState blockState = ((CraftBlock)block).getBlockState();
        ServerLevel serverLevel = ((CraftWorld)block.getWorld()).getHandle();
        return this.a(blockState, serverLevel, new BlockPos(block.getX(), block.getY(), block.getZ()));
    }

    @Override
    @Nullable
    public InstrumentByteStringData c(org.bukkit.block.Block block, byte by) {
        BlockState blockState = ((CraftBlock)block).getBlockState();
        ServerLevel serverLevel = ((CraftWorld)block.getWorld()).getHandle();
        return this.a(by, blockState, serverLevel, new BlockPos(block.getX(), block.getY(), block.getZ()));
    }

    @Override
    public Instrument aT(org.bukkit.block.Block block) {
        BlockPos blockPos;
        BlockState blockState = ((CraftBlock)block).getBlockState();
        ServerLevel serverLevel = ((CraftWorld)block.getWorld()).getHandle();
        NoteBlockInstrument noteBlockInstrument = serverLevel.getBlockState((blockPos = new BlockPos(block.getX(), block.getY(), block.getZ())).below()).instrument();
        InstrumentByteStringData instrumentByteStringData = this.a((byte)noteBlockInstrument.ordinal(), blockState, (Level)serverLevel, blockPos);
        if (instrumentByteStringData == null) {
            return Instrument.PIANO;
        }
        return instrumentByteStringData.Vp;
    }

    @Override
    public boolean D(Material material) {
        return this.Vv.contains(material);
    }

    @Nullable
    public InstrumentByteStringData a(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos) {
        NoteBlockInstrument noteBlockInstrument = serverLevel.getBlockState(blockPos.below()).instrument();
        return this.a((byte)noteBlockInstrument.ordinal(), blockState, serverLevel, blockPos);
    }

    public InstrumentByteStringData a(byte by, BlockState blockState, ServerLevel serverLevel, BlockPos blockPos) {
        InstrumentByteStringData instrumentByteStringData = this.a(by, blockState, (Level)serverLevel, blockPos);
        if (instrumentByteStringData.Vt) {
            serverLevel.sendParticles((ParticleOptions)ParticleTypes.NOTE, (double)blockPos.getX() + 0.5, (double)blockPos.getY() + 1.2, (double)blockPos.getZ() + 0.5, 1, 0.0, 0.0, 0.0, (double)instrumentByteStringData.Vq / 24.0);
        }
        serverLevel.playSeededSound((Entity)((Player)null), (double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, (Holder)instrumentByteStringData.Vs, SoundSource.RECORDS, 3.0f, instrumentByteStringData.pc, serverLevel.getRandom().nextLong());
        return instrumentByteStringData;
    }

    public InstrumentByteStringData a(byte by, BlockState blockState, Level level, BlockPos blockPos) {
        Holder holder;
        NoteBlockInstrument noteBlockInstrument = level.getBlockState(blockPos.above()).instrument();
        NoteBlockInstrument noteBlockInstrument2 = NoteBlockInstrument.values()[by];
        int n = (Integer)blockState.getValue((Property)NoteBlock.NOTE);
        InstrumentByteStringData instrumentByteStringData = new InstrumentByteStringData();
        instrumentByteStringData.Vq = (byte)n;
        if (noteBlockInstrument.worksAboveNoteBlock()) {
            Identifier identifier = BlockNms_26_1_2.a(level, blockPos);
            if (noteBlockInstrument.hasCustomSound() && identifier != null) {
                holder = Holder.direct((Object)SoundEvent.createVariableRangeEvent((Identifier)identifier));
                instrumentByteStringData.Vr = identifier.toString();
            } else {
                holder = noteBlockInstrument.getSoundEvent();
            }
            instrumentByteStringData.Vp = BlockRegistry.c((byte)noteBlockInstrument.ordinal());
            instrumentByteStringData.pc = noteBlockInstrument.isTunable() ? NoteBlock.getPitchFromNote((int)n) : 1.0f;
        } else {
            holder = noteBlockInstrument2.getSoundEvent();
            instrumentByteStringData.Vp = BlockRegistry.c((byte)noteBlockInstrument2.ordinal());
            instrumentByteStringData.pc = noteBlockInstrument2.isTunable() ? NoteBlock.getPitchFromNote((int)n) : 1.0f;
            instrumentByteStringData.Vt = true;
        }
        instrumentByteStringData.Vs = holder;
        return instrumentByteStringData;
    }

    @Nullable
    private static Identifier a(Level level, BlockPos blockPos) {
        Identifier identifier;
        BlockEntity blockEntity = level.getBlockEntity(blockPos.above());
        if (blockEntity instanceof SkullBlockEntity) {
            SkullBlockEntity skullBlockEntity = (SkullBlockEntity)blockEntity;
            identifier = skullBlockEntity.getNoteBlockSound();
        } else {
            identifier = null;
        }
        return identifier;
    }

    @Override
    public void bH(@Nullable org.bukkit.entity.Player player) {
        Registry registry;
        MinecraftServer minecraftServer = MinecraftServer.getServer();
        PlayerList playerList = minecraftServer.getPlayerList();
        if (this.Vu == null) {
            registry = minecraftServer.registries().compositeAccess().lookupOrThrow(BlockTags.MINEABLE_WITH_AXE.registry());
            HolderSet.Named named = (HolderSet.Named)registry.get(BlockTags.MINEABLE_WITH_AXE).get();
            List list = (List)VersionHelper_3.a(HolderSet.Named.class, List.class, (Object)named, 0);
            ArrayList<Holder> arrayList = new ArrayList<Holder>(list);
            arrayList.removeIf(holder -> ((Block)holder.value()).equals(Blocks.CHORUS_PLANT) || ((Block)holder.value()).equals(Blocks.NOTE_BLOCK) || ((Block)holder.value()).equals(Blocks.BROWN_MUSHROOM_BLOCK) || ((Block)holder.value()).equals(Blocks.RED_MUSHROOM_BLOCK) || ((Block)holder.value()).equals(Blocks.MUSHROOM_STEM));
            try {
                VersionHelper_3.a(HolderSet.Named.class, List.class, (Object)named, arrayList);
                this.Vu = new ClientboundUpdateTagsPacket(TagNetworkSerialization.serializeTagsToNetwork((LayeredRegistryAccess)minecraftServer.registries()));
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException(illegalAccessException);
            }
            finally {
                try {
                    VersionHelper_3.a(HolderSet.Named.class, List.class, (Object)named, list);
                }
                catch (IllegalAccessException illegalAccessException) {
                    throw new RuntimeException(illegalAccessException);
                }
            }
        }
        if (player == null) {
            for (HolderSet.Named named : playerList.players) {
                named.connection.send(this.Vu);
            }
        } else {
            registry = playerList.getPlayer(player.getUniqueId());
            if (registry != null) {
                registry.connection.send(this.Vu);
            }
        }
    }
}
