package itemsadder.m;

import itemsadder.m.aaf;
import itemsadder.m.aah;
import itemsadder.m.aai;
import itemsadder.m.aaj;
import itemsadder.m.zw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.core.BlockPosition;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.IRegistry;
import net.minecraft.core.LayeredRegistryAccess;
import net.minecraft.core.particles.ParticleParam;
import net.minecraft.core.particles.Particles;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ClientboundUpdateTagsPacket;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.WorldServer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.sounds.SoundCategory;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.tags.TagNetworkSerialization;
import net.minecraft.tags.TagsBlock;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.World;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BlockNote;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ITileEntity;
import net.minecraft.world.level.block.entity.TileEntity;
import net.minecraft.world.level.block.entity.TileEntitySkull;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.level.block.state.properties.BlockPropertyInstrument;
import net.minecraft.world.level.block.state.properties.IBlockState;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.levelgen.HeightMap;
import net.minecraft.world.level.material.MaterialMapColor;
import org.bukkit.Chunk;
import org.bukkit.HeightMap;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_21_R5.CraftChunk;
import org.bukkit.craftbukkit.v1_21_R5.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R5.block.CraftBlock;
import org.bukkit.craftbukkit.v1_21_R5.util.CraftMagicNumbers;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class abc
implements aai {
    private Packet Vu;
    List Vv = Arrays.asList(Material.SHORT_GRASS, Material.FERN, Material.DEAD_BUSH, Material.VINE, Material.GLOW_LICHEN, Material.SUNFLOWER, Material.LILAC, Material.ROSE_BUSH, Material.PEONY, Material.TALL_GRASS, Material.LARGE_FERN, Material.HANGING_ROOTS, Material.PITCHER_PLANT, Material.SEAGRASS);

    @Override
    @Deprecated
    public Class tj() {
        return MaterialMapColor.class;
    }

    @Override
    @Deprecated
    public boolean a(org.bukkit.block.Block block, aah aah2) {
        throw new RuntimeException("Not supported on 1.20");
    }

    @Override
    public boolean aK(org.bukkit.block.Block block) {
        WorldServer worldServer = ((CraftWorld)block.getWorld()).getHandle();
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        return worldServer.r(blockPosition);
    }

    @Override
    public boolean B(Material material) {
        return CraftMagicNumbers.getBlock((Material)material) instanceof ITileEntity;
    }

    @Override
    public boolean aL(org.bukkit.block.Block block) {
        WorldServer worldServer = ((CraftWorld)block.getWorld()).getHandle();
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        net.minecraft.world.level.chunk.Chunk chunk = worldServer.d(block.getX() >> 4, block.getZ() >> 4);
        Block block2 = chunk.a_(blockPosition).b();
        return block2 instanceof ITileEntity;
    }

    @Override
    public boolean aJ(org.bukkit.block.Block block) {
        return ((CraftBlock)block).getNMS().v();
    }

    @Override
    public boolean aN(org.bukkit.block.Block block) {
        return ((CraftBlock)block).getNMS().n();
    }

    @Override
    public boolean aQ(org.bukkit.block.Block block) {
        return ((CraftBlock)block.getRelative(BlockFace.DOWN)).getNMS().l();
    }

    @Override
    public int a(Chunk chunk, int n, int n2, HeightMap heightMap) {
        return abc.y(chunk).a(this.a(heightMap), n, n2);
    }

    public static net.minecraft.world.level.chunk.Chunk y(Chunk chunk) {
        return (net.minecraft.world.level.chunk.Chunk)((CraftChunk)chunk).getHandle(ChunkStatus.n);
    }

    public HeightMap.Type a(HeightMap heightMap) {
        return switch (heightMap) {
            case HeightMap.MOTION_BLOCKING -> HeightMap.Type.e;
            case HeightMap.MOTION_BLOCKING_NO_LEAVES -> HeightMap.Type.f;
            case HeightMap.OCEAN_FLOOR -> HeightMap.Type.d;
            case HeightMap.OCEAN_FLOOR_WG -> HeightMap.Type.c;
            case HeightMap.WORLD_SURFACE -> HeightMap.Type.b;
            case HeightMap.WORLD_SURFACE_WG -> HeightMap.Type.a;
            default -> throw new EnumConstantNotPresentException(HeightMap.Type.class, heightMap.name());
        };
    }

    @Override
    public void a(aaf aaf2) {
    }

    @Override
    public int C(Material material) {
        Integer n = (Integer)Vo.get(material);
        if (n == null) {
            n = Item.a((Item)CraftMagicNumbers.getItem((Material)material));
            Vo.put(material, n);
        }
        return n;
    }

    @Override
    public Instrument aR(org.bukkit.block.Block block) {
        BlockPropertyInstrument blockPropertyInstrument = ((CraftBlock)block).getNMS().E();
        return aaf.c((byte)blockPropertyInstrument.ordinal());
    }

    @Override
    @Nullable
    public aaj aS(org.bukkit.block.Block block) {
        IBlockData iBlockData = ((CraftBlock)block).getNMS();
        WorldServer worldServer = ((CraftWorld)block.getWorld()).getHandle();
        return this.a(iBlockData, worldServer, new BlockPosition(block.getX(), block.getY(), block.getZ()));
    }

    @Override
    @Nullable
    public aaj c(org.bukkit.block.Block block, byte by) {
        IBlockData iBlockData = ((CraftBlock)block).getNMS();
        WorldServer worldServer = ((CraftWorld)block.getWorld()).getHandle();
        return this.a(by, iBlockData, worldServer, new BlockPosition(block.getX(), block.getY(), block.getZ()));
    }

    @Override
    public Instrument aT(org.bukkit.block.Block block) {
        BlockPosition blockPosition;
        IBlockData iBlockData = ((CraftBlock)block).getNMS();
        WorldServer worldServer = ((CraftWorld)block.getWorld()).getHandle();
        BlockPropertyInstrument blockPropertyInstrument = worldServer.a_((blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ())).e()).E();
        aaj aaj2 = this.a((byte)blockPropertyInstrument.ordinal(), iBlockData, (World)worldServer, blockPosition);
        if (aaj2 == null) {
            return Instrument.PIANO;
        }
        return aaj2.Vp;
    }

    @Override
    public boolean D(Material material) {
        return this.Vv.contains(material);
    }

    @Nullable
    public aaj a(IBlockData iBlockData, WorldServer worldServer, BlockPosition blockPosition) {
        BlockPropertyInstrument blockPropertyInstrument = worldServer.a_(blockPosition.e()).E();
        return this.a((byte)blockPropertyInstrument.ordinal(), iBlockData, worldServer, blockPosition);
    }

    public aaj a(byte by, IBlockData iBlockData, WorldServer worldServer, BlockPosition blockPosition) {
        aaj aaj2 = this.a(by, iBlockData, (World)worldServer, blockPosition);
        if (aaj2.Vt) {
            worldServer.a((ParticleParam)Particles.ad, (double)blockPosition.u() + 0.5, (double)blockPosition.v() + 1.2, (double)blockPosition.w() + 0.5, 1, 0.0, 0.0, 0.0, (double)aaj2.Vq / 24.0);
        }
        worldServer.a((Entity)((EntityHuman)null), (double)blockPosition.u() + 0.5, (double)blockPosition.v() + 0.5, (double)blockPosition.w() + 0.5, (Holder)aaj2.Vs, SoundCategory.c, 3.0f, aaj2.pc, worldServer.A.g());
        return aaj2;
    }

    public aaj a(byte by, IBlockData iBlockData, World world, BlockPosition blockPosition) {
        Holder holder;
        BlockPropertyInstrument blockPropertyInstrument = world.a_(blockPosition.d()).E();
        BlockPropertyInstrument blockPropertyInstrument2 = BlockPropertyInstrument.values()[by];
        int n = (Integer)iBlockData.c((IBlockState)BlockNote.d);
        aaj aaj2 = new aaj();
        aaj2.Vq = (byte)n;
        if (blockPropertyInstrument.e()) {
            MinecraftKey minecraftKey = abc.a(world, blockPosition);
            if (blockPropertyInstrument.d() && minecraftKey != null) {
                holder = Holder.a((Object)SoundEffect.a((MinecraftKey)minecraftKey));
                aaj2.Vr = minecraftKey.toString();
            } else {
                holder = blockPropertyInstrument.a();
            }
            aaj2.Vp = aaf.c((byte)blockPropertyInstrument.ordinal());
            aaj2.pc = blockPropertyInstrument.b() ? BlockNote.b((int)n) : 1.0f;
        } else {
            holder = blockPropertyInstrument2.a();
            aaj2.Vp = aaf.c((byte)blockPropertyInstrument2.ordinal());
            aaj2.pc = blockPropertyInstrument2.b() ? BlockNote.b((int)n) : 1.0f;
            aaj2.Vt = true;
        }
        aaj2.Vs = holder;
        return aaj2;
    }

    @Nullable
    private static MinecraftKey a(World world, BlockPosition blockPosition) {
        MinecraftKey minecraftKey;
        TileEntity tileEntity = world.c_(blockPosition.d());
        if (tileEntity instanceof TileEntitySkull) {
            TileEntitySkull tileEntitySkull = (TileEntitySkull)tileEntity;
            minecraftKey = tileEntitySkull.d();
        } else {
            minecraftKey = null;
        }
        return minecraftKey;
    }

    @Override
    public void bH(@Nullable Player player) {
        IRegistry iRegistry;
        MinecraftServer minecraftServer = MinecraftServer.getServer();
        PlayerList playerList = minecraftServer.ag();
        if (this.Vu == null) {
            iRegistry = minecraftServer.bb().a().f(TagsBlock.bE.a());
            HolderSet.Named named = (HolderSet.Named)iRegistry.a(TagsBlock.bE).get();
            List list = (List)zw.a(HolderSet.Named.class, List.class, (Object)named, 0);
            ArrayList<Holder> arrayList = new ArrayList<Holder>(list);
            arrayList.removeIf(holder -> ((Block)holder.a()).equals(Blocks.la) || ((Block)holder.a()).equals(Blocks.bf) || ((Block)holder.a()).equals(Blocks.fl) || ((Block)holder.a()).equals(Blocks.fm) || ((Block)holder.a()).equals(Blocks.fn));
            try {
                zw.a(HolderSet.Named.class, List.class, (Object)named, arrayList);
                this.Vu = new ClientboundUpdateTagsPacket(TagNetworkSerialization.a((LayeredRegistryAccess)minecraftServer.bb()));
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException(illegalAccessException);
            }
            finally {
                try {
                    zw.a(HolderSet.Named.class, List.class, (Object)named, list);
                }
                catch (IllegalAccessException illegalAccessException) {
                    throw new RuntimeException(illegalAccessException);
                }
            }
        }
        if (player == null) {
            for (HolderSet.Named named : playerList.l) {
                named.g.b(this.Vu);
            }
        } else {
            iRegistry = playerList.a(player.getUniqueId());
            if (iRegistry != null) {
                iRegistry.g.b(this.Vu);
            }
        }
    }
}
