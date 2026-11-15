package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import dev.lone.itemsadder.Main;
import itemsadder.m.BlockHolder;
import itemsadder.m.BlockHolder_2;
import itemsadder.m.BlocksEnum;
import itemsadder.m.Builder;
import itemsadder.m.Builder_2;
import itemsadder.m.Builder_3;
import itemsadder.m.ChunkBridge_2;
import itemsadder.m.ChunkStreamSomehowImpl;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.Error;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque022;
import itemsadder.m.Opaque028;
import itemsadder.m.PluginContractBuilder_2;
import itemsadder.m.PluginContractBuilder_3;
import itemsadder.m.SavedEnum;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.BiConsumer;
import org.apache.commons.io.FileUtils;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockBridge_9 {
    private static final long BN = 60000L;
    public final World BO;
    public final int BP;
    final int BQ;
    final int BR;
    final String BS;
    public final ChunkBridge_2 BT;
    private final Lock BU;
    private long BV;
    private final Map BW = Collections.synchronizedMap(new HashMap());
    final AtomicBoolean BX = new AtomicBoolean();
    public final ChunkStreamSomehowImpl BY;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public BlockBridge_9(File file, World world) {
        this.BO = world;
        this.BU = new ReentrantReadWriteLock().writeLock();
        this.BS = file.getName();
        String[] stringArray = this.BS.split("\\.");
        this.BQ = Integer.parseInt(stringArray[1]);
        this.BR = Integer.parseInt(stringArray[2]);
        this.BP = BlockBridge_9.f(world, this.BQ, this.BR);
        try {
            this.BU.lock();
            this.BT = new ChunkBridge_2(file.getParentFile());
            this.BT.lV();
            this.BY = new ChunkStreamSomehowImpl(file);
        }
        finally {
            this.BU.unlock();
        }
        this.lU();
    }

    BlockBridge_9() {
        this.BO = null;
        this.BU = new ReentrantReadWriteLock().writeLock();
        this.BS = "dummy";
        this.BQ = 0;
        this.BR = 0;
        this.BP = 0;
        this.BT = null;
        this.BY = null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public Builder_3 a(int n, int n2, boolean bl) {
        String string2 = BlockBridge_9.l(n, n2);
        this.bk(string2);
        @Nullable Builder_3 builder_3 = (Builder_3)this.BY.ja(string2);
        if (builder_3 != null) {
            return builder_3;
        }
        if (!bl && !this.BY.jb(string2)) {
            return null;
        }
        try {
            this.BU.lock();
            Opaque028 opaque028 = new Opaque028();
            if (bl) {
                long l;
                AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                builder_3 = (Builder_3)this.BY.a(string2, (Object string) -> {
                    atomicBoolean.set(false);
                    if (MaterialBarColorHolder.dF) {
                        CommandSenderBridge_5.log("Created chunk '" + n + "," + n2 + "' " + this.lO());
                    }
                    return Builder_3.wt();
                });
                if (atomicBoolean.get() && MaterialBarColorHolder.dF && (l = opaque028.DJ()) >= (long)MaterialBarColorHolder.dG) {
                    CommandSenderBridge_5.log("Loaded chunk '" + n + "," + n2 + "' in " + l + "ms | " + this.lO());
                }
            } else {
                long l;
                try {
                    builder_3 = (Builder_3)this.BY.jd(string2);
                }
                catch (EOFException eOFException) {
                    builder_3 = Builder_3.wt();
                    CommandSenderBridge_5.error("Empty chunk will be used to avoid problems for chunk " + string2 + " | " + this.lO());
                }
                if (builder_3 != null && MaterialBarColorHolder.dF && (l = opaque028.DJ()) >= (long)MaterialBarColorHolder.dG) {
                    CommandSenderBridge_5.log("Loaded chunk '" + n + "," + n2 + "' of '" + this.BS + "' in " + l + "ms | " + this.lO());
                }
            }
            Builder_3 builder_32 = builder_3;
            return builder_32;
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Failed to load chunk '" + n + ", " + n2 + "' | " + this.lO(), throwable);
            CommandSenderBridge_5.error("Empty chunk will be used to avoid problems for chunk " + string2 + " | " + this.lO());
            Builder_3 builder_33 = Builder_3.wt();
            return builder_33;
        }
        finally {
            this.BU.unlock();
        }
    }

    @Nullable
    private Builder_3 j(int n, int n2) {
        return this.a(n, n2, false);
    }

    @Nullable
    private Builder_3 u(Chunk chunk) {
        return this.j(chunk.getX(), chunk.getZ());
    }

    @NotNull
    private Builder_3 k(int n, int n2) {
        return this.a(n, n2, true);
    }

    @NotNull
    private Builder_3 v(Chunk chunk) {
        return this.k(chunk.getX(), chunk.getZ());
    }

    public boolean i(int n, int n2) {
        return this.j(n, n2) != null;
    }

    public boolean o(Chunk chunk) {
        return this.i(chunk.getX(), chunk.getZ());
    }

    @Nullable
    private Builder_2 f(Chunk chunk, int n, int n2, int n3) {
        return this.a(chunk.getX(), chunk.getZ(), n, n2, n3);
    }

    @Nullable
    private Builder_2 a(int n, int n2, int n3, int n4, int n5) {
        Builder_3 builder_3 = this.j(n, n2);
        if (builder_3 == null) {
            return null;
        }
        return builder_3.dU(BlockBridge_9.i(n3, n4, n5));
    }

    @Nullable
    private Builder_2 I(Location location) {
        if (!location.getWorld().isChunkLoaded(location.getBlockX() >> 4, location.getBlockZ() >> 4)) {
            throw new Error("Chunk is not loaded!");
        }
        return this.a(location.getBlockX() >> 4, location.getBlockZ() >> 4, location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    @Nullable
    private Builder_2 J(Location location) {
        return this.a(location.getBlockX() >> 4, location.getBlockZ() >> 4, location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    @Nullable
    private Builder_2 ai(Block block) {
        return this.a(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ());
    }

    @NotNull
    private Builder_2 g(Chunk chunk, int n, int n2, int n3) {
        return this.b(chunk.getX(), chunk.getZ(), n, n2, n3);
    }

    @NotNull
    private Builder_2 b(int n, int n2, int n3, int n4, int n5) {
        String string = BlockBridge_9.i(n3, n4, n5);
        Builder_3 builder_3 = this.k(n, n2);
        Builder_2 builder_2 = builder_3.dU(string);
        if (builder_2 != null) {
            return builder_2;
        }
        builder_2 = Builder_2.wk().aU(0);
        this.BX.set(true);
        builder_3.a(string, builder_2);
        return builder_2;
    }

    @NotNull
    private Builder_2 aj(Block block) {
        return this.b(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ());
    }

    public boolean d(Chunk chunk, int n, int n2, int n3) {
        return this.c(chunk.getX(), chunk.getZ(), n, n2, n3);
    }

    public boolean c(int n, int n2, int n3, int n4, int n5) {
        Builder_3 builder_3 = this.j(n, n2);
        if (builder_3 == null) {
            return false;
        }
        return builder_3.dT(BlockBridge_9.i(n3, n4, n5));
    }

    public boolean T(Block block) {
        return this.c(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ());
    }

    @Nullable
    private Builder ak(Block block) {
        Builder_2 builder_2 = this.ai(block);
        if (builder_2 == null) {
            return null;
        }
        return builder_2.wo();
    }

    private Builder al(Block block) {
        return this.d(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ());
    }

    private Builder d(int n, int n2, int n3, int n4, int n5) {
        Builder_2 builder_2 = this.b(n, n2, n3, n4, n5);
        Builder builder = builder_2.wo();
        if (builder != null) {
            return builder;
        }
        builder = Builder.vE();
        this.BX.set(true);
        builder_2.b(builder);
        return builder;
    }

    @Nullable
    public List U(Block block) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        PluginContractBuilder_2 pluginContractBuilder_2 = this.W(block);
        if (pluginContractBuilder_2 == null) {
            return null;
        }
        if (pluginContractBuilder_2.wV() != null && pluginContractBuilder_2.wV().size() > 0) {
            for (String string : pluginContractBuilder_2.wV()) {
                arrayList.add(NItem.compoundStrToBukkitItem((String)string));
            }
        }
        return arrayList;
    }

    @Nullable
    public ItemStack V(Block block) {
        PluginContractBuilder_2 pluginContractBuilder_2 = this.W(block);
        if (pluginContractBuilder_2 == null) {
            return null;
        }
        if (pluginContractBuilder_2.wV() != null && pluginContractBuilder_2.wV().size() > 0) {
            return NItem.compoundStrToBukkitItem((String)((String)pluginContractBuilder_2.wV().get(0)));
        }
        return null;
    }

    @Nullable
    PluginContractBuilder_2 W(Block block) {
        Builder_2 builder_2 = this.ai(block);
        if (builder_2 == null) {
            return null;
        }
        Builder builder = this.ak(block);
        if (builder == null) {
            return null;
        }
        return builder.vF();
    }

    public boolean X(Block block) {
        Builder_2 builder_2 = this.ai(block);
        if (builder_2 == null) {
            return false;
        }
        Builder builder = this.ak(block);
        if (builder == null) {
            return false;
        }
        return builder.vH();
    }

    public boolean isCustomBlock(Block block) {
        return this.G(block.getLocation());
    }

    public boolean F(Location location) {
        if (this.E(location) != null) {
            return true;
        }
        Builder_2 builder_2 = this.I(location);
        if (builder_2 == null) {
            return false;
        }
        return builder_2.wl() > 0;
    }

    public boolean G(Location location) {
        if (this.E(location) != null) {
            return true;
        }
        Builder_2 builder_2 = this.J(location);
        if (builder_2 == null) {
            return false;
        }
        return builder_2.wl() > 0;
    }

    @Nullable
    public String E(Location location) {
        String string;
        if (Main.rS().Pw && ItemStackRegistry.g().T.containsKey(string = BlockHolder.tl().bb(location.getBlock()))) {
            return string;
        }
        return null;
    }

    @Nullable
    public String e(int n, int n2, int n3, int n4, int n5) {
        Builder_2 builder_2 = this.a(n4, n5, n, n2, n3);
        if (builder_2 == null) {
            return null;
        }
        int n6 = builder_2.wl();
        if (n6 == 0) {
            return null;
        }
        return this.a(this.j(n4, n5), n6);
    }

    @Nullable
    public String a(int n, int n2, int n3, Chunk chunk) {
        return this.e(n, n2, n3, chunk.getX(), chunk.getZ());
    }

    @Nullable
    public String Y(Block block) {
        String string = this.E(block.getLocation());
        if (string != null) {
            return string;
        }
        return this.e(block.getX(), block.getY(), block.getZ(), block.getX() >> 4, block.getZ() >> 4);
    }

    @Nullable
    public String H(Location location) {
        String string = this.E(location);
        if (string != null) {
            return string;
        }
        return this.e(location.getBlockX(), location.getBlockY(), location.getBlockZ(), location.getBlockX() >> 4, location.getBlockZ() >> 4);
    }

    @Nullable
    private String a(@NotNull Builder_3 builder_3, BlocksEnum blocksEnum, int n) {
        PluginContractBuilder_3 pluginContractBuilder_3;
        if (blocksEnum == BlocksEnum.BLOCKS) {
            pluginContractBuilder_3 = builder_3.ww();
        } else if (blocksEnum == BlocksEnum.BIOMES) {
            pluginContractBuilder_3 = builder_3.wz();
        } else if (blocksEnum == BlocksEnum.CROPS_SEEDS) {
            pluginContractBuilder_3 = builder_3.wC();
        } else {
            throw new RuntimeException("Unknown palette! " + String.valueOf((Object)blocksEnum));
        }
        if (pluginContractBuilder_3 != null) {
            return pluginContractBuilder_3.L(n);
        }
        return null;
    }

    @Nullable
    private String a(@NotNull Builder_3 builder_3, int n) {
        return this.a(builder_3, BlocksEnum.BLOCKS, n);
    }

    private int a(Builder_3 builder_3, String string) {
        return this.a(builder_3, BlocksEnum.BLOCKS, string);
    }

    private int a(Builder_3 builder_3, BlocksEnum blocksEnum, String string) {
        Integer n;
        PluginContractBuilder_3 pluginContractBuilder_3;
        if (blocksEnum == BlocksEnum.BLOCKS) {
            pluginContractBuilder_3 = builder_3.ww();
        } else if (blocksEnum == BlocksEnum.BIOMES) {
            pluginContractBuilder_3 = builder_3.wz();
        } else if (blocksEnum == BlocksEnum.CROPS_SEEDS) {
            pluginContractBuilder_3 = builder_3.wC();
        } else {
            throw new RuntimeException("Unknown palette! " + String.valueOf((Object)blocksEnum));
        }
        if (pluginContractBuilder_3 == null) {
            n = 1;
            pluginContractBuilder_3 = PluginContractBuilder_3.wZ();
            this.a(blocksEnum, pluginContractBuilder_3, n, string, builder_3);
        } else {
            n = (Integer)Opaque022.b(pluginContractBuilder_3.xa(), (Object)string);
            for (Map.Entry entry : pluginContractBuilder_3.xa().entrySet()) {
                if (!((String)entry.getValue()).equals(string)) continue;
                n = (Integer)entry.getKey();
                break;
            }
            if (n == null) {
                n = Math.max(1, pluginContractBuilder_3.xb() + 1);
                this.a(blocksEnum, pluginContractBuilder_3, n, string, null);
            }
        }
        return n;
    }

    private void a(BlocksEnum blocksEnum, PluginContractBuilder_3 pluginContractBuilder_3, Integer n, String string, @Nullable Builder_3 builder_3) {
        this.BX.set(true);
        pluginContractBuilder_3.c(n, string);
        if (builder_3 != null) {
            if (blocksEnum == BlocksEnum.BLOCKS) {
                builder_3.a(pluginContractBuilder_3);
            } else if (blocksEnum == BlocksEnum.BIOMES) {
                builder_3.b(pluginContractBuilder_3);
            } else if (blocksEnum == BlocksEnum.CROPS_SEEDS) {
                builder_3.c(pluginContractBuilder_3);
            } else {
                throw new RuntimeException("Unknown palette! " + String.valueOf((Object)blocksEnum));
            }
        }
    }

    @Nullable
    public String Z(Block block) {
        Builder builder = this.ak(block);
        if (builder == null) {
            return null;
        }
        return builder.vR();
    }

    public void a(Block block, String string) {
        this.BX.set(true);
        Builder builder = this.al(block);
        builder.dR(string);
    }

    public void a(int n, int n2, int n3, int n4, int n5, String string) {
        this.BX.set(true);
        Builder builder = this.d(n, n2, n3, n4, n5);
        builder.dR(string);
    }

    @Nullable
    public String aa(Block block) {
        Builder builder = this.ak(block);
        if (builder == null) {
            return null;
        }
        int n = builder.vI();
        if (n == 0) {
            return null;
        }
        Builder_3 builder_3 = this.j(block.getX() >> 4, block.getZ() >> 4);
        if (builder_3 == null) {
            return null;
        }
        return this.a(builder_3, BlocksEnum.CROPS_SEEDS, n);
    }

    public void b(Block block, String string) {
        this.BX.set(true);
        Builder_3 builder_3 = this.k(block.getX() >> 4, block.getZ() >> 4);
        int n = this.a(builder_3, BlocksEnum.CROPS_SEEDS, string);
        Builder builder = this.al(block);
        builder.aP(n);
    }

    public void b(int n, int n2, int n3, int n4, int n5, String string) {
        this.BX.set(true);
        Builder_3 builder_3 = this.k(n, n2);
        int n6 = this.a(builder_3, BlocksEnum.CROPS_SEEDS, string);
        Builder builder = this.d(n, n2, n3, n4, n5);
        builder.aP(n6);
    }

    @Nullable
    public String ab(Block block) {
        Builder builder = this.ak(block);
        if (builder == null) {
            return null;
        }
        return builder.vL() ? this.Y(block) : null;
    }

    public void c(Block block, String string) {
        this.e(block, string);
        this.al(block).aJ(true);
    }

    public List p(Chunk chunk) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (!this.o(chunk)) {
            return arrayList;
        }
        Builder_3 builder_3 = this.u(chunk);
        if (builder_3 == null) {
            return arrayList;
        }
        for (Map.Entry entry : builder_3.wu().entrySet()) {
            Builder_2 builder_2;
            int n;
            Builder builder = ((Builder_2)entry.getValue()).wo();
            if (builder == null || !builder.vL() || (n = (builder_2 = (Builder_2)entry.getValue()).wl()) == 0) continue;
            arrayList.add(this.a(builder_3, n));
        }
        return arrayList;
    }

    @Nullable
    public List getAllBlocksLocationsList(Chunk chunk) {
        if (!this.o(chunk)) {
            return null;
        }
        Builder_3 builder_3 = this.u(chunk);
        if (builder_3 == null) {
            return null;
        }
        ArrayList<Location> arrayList = new ArrayList<Location>();
        for (Map.Entry entry : builder_3.wu().entrySet()) {
            Builder_2 builder_2 = (Builder_2)entry.getValue();
            int n = builder_2.wl();
            if (n == 0) continue;
            arrayList.add(BlockBridge_9.a(this.BO, chunk, (String)entry.getKey()));
        }
        return arrayList;
    }

    @Nullable
    public Map getAllBlocksLocations(Chunk chunk) {
        if (!this.o(chunk)) {
            return null;
        }
        Builder_3 builder_3 = this.u(chunk);
        if (builder_3 == null) {
            return null;
        }
        HashMap<Location, String> hashMap = new HashMap<Location, String>();
        for (Map.Entry entry : builder_3.wu().entrySet()) {
            Builder_2 builder_2 = (Builder_2)entry.getValue();
            int n = builder_2.wl();
            if (n == 0) continue;
            hashMap.put(BlockBridge_9.a(this.BO, chunk, (String)entry.getKey()), this.a(builder_3, n));
        }
        return hashMap;
    }

    public void a(Chunk chunk, BiConsumer biConsumer) {
        if (!this.o(chunk)) {
            return;
        }
        Builder_3 builder_3 = this.u(chunk);
        if (builder_3 == null) {
            return;
        }
        for (Map.Entry entry : builder_3.wu().entrySet()) {
            Builder_2 builder_2 = (Builder_2)entry.getValue();
            int n = builder_2.wl();
            if (n == 0) continue;
            biConsumer.accept(this.a(builder_3, n), BlockBridge_9.a(this.BO, chunk, (String)entry.getKey()));
        }
    }

    @Nullable
    public String ac(Block block) {
        Builder builder = this.ak(block);
        if (builder == null) {
            return null;
        }
        int n = builder.vO();
        if (n == 0) {
            return null;
        }
        Builder_3 builder_3 = this.j(block.getX() >> 4, block.getZ() >> 4);
        if (builder_3 == null) {
            return null;
        }
        return this.a(builder_3, n);
    }

    public void d(Block block, String string) {
        this.c(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ(), string);
    }

    public void c(int n, int n2, int n3, int n4, int n5, String string) {
        this.BX.set(true);
        Builder_3 builder_3 = this.k(n, n2);
        int n6 = this.a(builder_3, string);
        Builder builder = this.d(n, n2, n3, n4, n5);
        builder.aQ(n6);
    }

    @Nullable
    public Byte ad(Block block) {
        Builder builder = this.ak(block);
        if (builder == null) {
            return null;
        }
        return (byte)builder.vU();
    }

    public byte b(Block block, byte by) {
        Builder builder = this.ak(block);
        if (builder == null) {
            return by;
        }
        return (byte)builder.vU();
    }

    public void a(Block block, int n) {
        this.BX.set(true);
        Builder builder = this.al(block);
        builder.aR(n);
    }

    public void a(int n, int n2, int n3, int n4, int n5, int n6) {
        this.BX.set(true);
        Builder builder = this.d(n, n2, n3, n4, n5);
        builder.aR(n6);
    }

    @Nullable
    public Integer ae(Block block) {
        Builder builder = this.ak(block);
        if (builder == null) {
            return null;
        }
        return builder.vX();
    }

    public void b(Block block, int n) {
        this.BX.set(true);
        Builder builder = this.al(block);
        builder.aS(n);
    }

    public void b(int n, int n2, int n3, int n4, int n5, int n6) {
        this.BX.set(true);
        Builder builder = this.d(n, n2, n3, n4, n5);
        builder.aS(n6);
    }

    public boolean af(Block block) {
        Builder builder = this.ak(block);
        if (builder == null) {
            return false;
        }
        return builder.wa();
    }

    public void b(Block block, boolean bl) {
        this.a(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ(), bl);
    }

    public void a(int n, int n2, int n3, int n4, int n5, boolean bl) {
        this.BX.set(true);
        Builder builder = this.d(n, n2, n3, n4, n5);
        builder.aK(bl);
    }

    public void d(int n, int n2, int n3, int n4, int n5, String string) {
        this.BX.set(true);
        Builder_3 builder_3 = this.k(n, n2);
        int n6 = this.a(builder_3, string);
        Builder_2 builder_2 = Builder_2.wk().aU(n6);
        builder_3.a(BlockBridge_9.i(n3, n4, n5), builder_2);
        ItemStackRegistry.g().W.a(this.BO, n, n2, n3, n4, n5, string);
    }

    public void a(Chunk chunk, int n, int n2, int n3, String string) {
        this.d(chunk.getX(), chunk.getZ(), n, n2, n3, string);
    }

    public void e(Block block, String string) {
        this.d(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ(), string);
    }

    public void a(Location location, String string) {
        this.d(location.getBlockX() >> 4, location.getBlockZ() >> 4, location.getBlockX(), location.getBlockY(), location.getBlockZ(), string);
    }

    public void e(Chunk chunk, int n, int n2, int n3) {
        this.f(chunk.getX(), chunk.getZ(), n, n2, n3);
    }

    public void f(int n, int n2, int n3, int n4, int n5) {
        Builder_3 builder_3 = this.j(n, n2);
        if (builder_3 == null) {
            return;
        }
        this.BX.set(true);
        builder_3.dV(BlockBridge_9.i(n3, n4, n5));
        ItemStackRegistry.g().W.a(this.BO, n, n2, n3, n4, n5);
    }

    public void ag(Block block) {
        this.f(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ());
    }

    public void c(Block block, boolean bl) {
        this.a(block, bl, false);
    }

    public void a(Block block, boolean bl, boolean bl2) {
        if (bl) {
            BlockHolder_2.tN().l(block, bl2);
        }
        this.f(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ());
    }

    public void q(Chunk chunk) {
        Builder_3 builder_3 = this.u(chunk);
        if (builder_3 == null) {
            return;
        }
        this.BX.set(true);
        builder_3.wu().clear();
        ItemStackRegistry.g().W.b(this.BO, chunk.getX(), chunk.getZ());
    }

    public void a(Block block, List list) {
        this.BX.set(true);
        PluginContractBuilder_2 pluginContractBuilder_2 = PluginContractBuilder_2.wU();
        pluginContractBuilder_2.G(new ArrayList());
        for (int i = 0; i < list.size(); ++i) {
            pluginContractBuilder_2.wV().add(NItem.bukkitItemToCompoundStr((ItemStack)((ItemStack)list.get(i))));
        }
        this.al(block).a(pluginContractBuilder_2);
    }

    public void a(Block block, ItemStack itemStack) {
        this.a(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ(), itemStack);
    }

    public void a(int n, int n2, int n3, int n4, int n5, ItemStack itemStack) {
        this.BX.set(true);
        PluginContractBuilder_2 pluginContractBuilder_2 = PluginContractBuilder_2.wU();
        pluginContractBuilder_2.G(new ArrayList());
        pluginContractBuilder_2.wV().add(NItem.bukkitItemToCompoundStr((ItemStack)itemStack));
        this.d(n, n2, n3, n4, n5).a(pluginContractBuilder_2);
    }

    public void ah(Block block) {
        Builder_2 builder_2 = this.ai(block);
        if (builder_2 == null) {
            return;
        }
        Builder builder = builder_2.wo();
        if (builder == null) {
            return;
        }
        this.BX.set(true);
        builder.vG();
    }

    public static String w(Chunk chunk) {
        return BlockBridge_9.l(chunk.getX(), chunk.getZ());
    }

    public static String l(int n, int n2) {
        return n + "." + n2;
    }

    public static String m(int n, int n2) {
        return (n >> 4) + "." + (n2 >> 4);
    }

    private static String i(int n, int n2, int n3) {
        return (n & 0xF) + "." + n2 + "." + (n3 & 0xF);
    }

    private static Location a(World world, Chunk chunk, String string) {
        int n = string.indexOf(46);
        int n2 = string.lastIndexOf(46);
        int n3 = Integer.parseInt(string.substring(0, n));
        int n4 = Integer.parseInt(string.substring(n + 1, n2));
        int n5 = Integer.parseInt(string.substring(n2 + 1));
        return new Location(world, (double)(chunk.getX() * 16 + n3), (double)n4, (double)(chunk.getZ() * 16 + n5));
    }

    public static int f(World world, int n, int n2) {
        int n3 = 1;
        n3 = 31 * n3 + world.hashCode();
        n3 = 31 * n3 + n;
        n3 = 31 * n3 + n2;
        return n3;
    }

    public static int g(World world, int n, int n2) {
        int n3 = 1;
        n3 = 31 * n3 + world.hashCode();
        n3 = 31 * n3 + (n >> 5);
        n3 = 31 * n3 + (n2 >> 5);
        return n3;
    }

    public static int x(Chunk chunk) {
        return BlockBridge_9.g(chunk.getWorld(), chunk.getX(), chunk.getZ());
    }

    public void save() {
        this.ag(true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void ag(boolean bl) {
        try {
            long l;
            this.BU.lock();
            if (this.BT != null) {
                this.BT.lW();
            }
            if (this.BY.aBS.isEmpty()) {
                return;
            }
            if (!this.BX.get()) {
                this.BY.aBS.clear();
                return;
            }
            this.BX.set(false);
            Opaque028 opaque028 = new Opaque028();
            if (MaterialBarColorHolder.dF && MaterialBarColorHolder.dG == 0) {
                CommandSenderBridge_5.log("Saving region " + this.lO());
            }
            this.BY.h(bl, bl);
            if (MaterialBarColorHolder.dF && (l = opaque028.DJ()) >= (long)MaterialBarColorHolder.dG) {
                CommandSenderBridge_5.log("Saved " + this.BY.aBS.size() + " chunks of " + this.BS + " region in " + l + "ms | " + this.lO());
            }
        }
        catch (IOException iOException) {
            CommandSenderBridge_5.error("Failed to save region '" + this.BQ + "," + this.BR + "' | " + this.lO(), iOException);
        }
        finally {
            if (bl) {
                this.lS();
            }
            this.BU.unlock();
        }
    }

    public int lM() {
        int n = 0;
        boolean bl = false;
        Iterator iterator = this.BY.aBS.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String string = (String)entry.getKey();
            if (!this.bj(string)) continue;
            ++n;
            if (!bl) {
                if (MaterialBarColorHolder.dF) {
                    CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + string + " is expired, so I save the whole region " + this.lO());
                }
                this.ag(false);
                bl = true;
            }
            iterator.remove();
            this.bi(string);
            if (!MaterialBarColorHolder.dF) continue;
            CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "---- " + string + " is expired, removed it from cache " + this.lO());
        }
        return n;
    }

    public SavedEnum lN() {
        if (this.lT()) {
            this.ag(true);
            if (MaterialBarColorHolder.dF) {
                CommandSenderBridge_5.log("Unloaded and saved region " + this.lO());
            }
            this.lS();
            return SavedEnum.SAVED;
        }
        int n = this.lM();
        if (n > 0 && MaterialBarColorHolder.dF) {
            CommandSenderBridge_5.log("Saved region (" + n + " chunks) " + this.lO());
        }
        return SavedEnum.SAVED_CHUNK;
    }

    private int[] bl(String string) {
        String[] stringArray = string.split("\\.");
        return new int[]{Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1])};
    }

    public void r(Chunk chunk) {
        this.bi(BlockBridge_9.w(chunk));
    }

    public void bi(String string) {
        this.BY.jc(string);
    }

    public String lO() {
        return this.BO.getName() + " -> " + this.BY.aBP.getAbsolutePath().replace(this.BO.getWorldFolder().getAbsolutePath(), "");
    }

    public int lP() {
        return this.BY.aBS.size();
    }

    public String lQ() {
        return this.BS;
    }

    public String lR() {
        return FileUtils.byteCountToDisplaySize((long)this.BY.aBP.length());
    }

    public void lS() {
        this.BY.lS();
    }

    public boolean lT() {
        return System.currentTimeMillis() - this.BV > 60000L;
    }

    void lU() {
        this.BV = System.currentTimeMillis();
    }

    public boolean bj(String string) {
        Long l = (Long)this.BW.get(string);
        if (l == null) {
            return false;
        }
        if (System.currentTimeMillis() - l < 60000L) {
            return false;
        }
        int[] nArray = this.bl(string);
        return !this.BO.isChunkLoaded(nArray[0], nArray[1]);
    }

    void bk(String string) {
        this.lU();
        this.BW.put(string, System.currentTimeMillis());
    }
}
