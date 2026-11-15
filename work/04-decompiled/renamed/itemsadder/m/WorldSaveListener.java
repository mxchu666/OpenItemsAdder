package itemsadder.m;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import dev.lone.itemsadder.Core.OtherPlugins.AdvancedSlimePaperWrapper;
import itemsadder.m.BlockBridge_8;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BlockIgniteListener;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.SavedEnum;
import itemsadder.m.WorldBridge_5;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.event.world.WorldUnloadEvent;
import org.bukkit.plugin.Plugin;

public class WorldSaveListener
extends WorldBridge_5
implements Listener {
    Cache BC = CacheBuilder.newBuilder().expireAfterWrite(30L, TimeUnit.SECONDS).build();
    private static final BlockBridge_9 BD = new BlockBridge_8();

    public WorldSaveListener(Plugin plugin) {
        super(plugin);
        ListenerBridge.b(this, plugin);
        int n = 1300;
        BukkitTaskBridge.b(bukkitRunnable -> {
            Iterator iterator = this.By.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = iterator.next();
                BlockBridge_9 blockBridge_9 = (BlockBridge_9)entry.getValue();
                try {
                    SavedEnum savedEnum = blockBridge_9.lN();
                    switch (savedEnum) {
                        case SAVED: {
                            iterator.remove();
                            break;
                        }
                    }
                }
                catch (Throwable throwable) {
                    CommandSenderBridge_5.error("Error saving region file: " + blockBridge_9.lO(), throwable);
                }
            }
        }, n, n);
    }

    @Override
    public BlockBridge_9 c(World world, int n, int n2) {
        BlockBridge_9 blockBridge_9;
        if (!MaterialBarColorHolder.eT.x(world)) {
            return BD;
        }
        int n3 = BlockBridge_9.g(world, n, n2);
        if (!this.ac(n3)) {
            blockBridge_9 = this.a(world, n, n2, null);
            if (blockBridge_9 != null) {
                this.By.put(blockBridge_9.BP, blockBridge_9);
                blockBridge_9.a(n, n2, false);
            }
        } else {
            blockBridge_9 = (BlockBridge_9)this.By.get(n3);
        }
        return blockBridge_9;
    }

    @Override
    public BlockBridge_9 a(World world, int n, int n2) {
        BlockBridge_9 blockBridge_9;
        if (!MaterialBarColorHolder.eT.x(world)) {
            return BD;
        }
        int n3 = BlockBridge_9.f(world, n, n2);
        if (!this.ac(n3)) {
            blockBridge_9 = this.d(world, n, n2);
            if (blockBridge_9 != null) {
                this.By.put(blockBridge_9.BP, blockBridge_9);
            }
        } else {
            blockBridge_9 = (BlockBridge_9)this.By.get(n3);
        }
        return blockBridge_9;
    }

    public BlockBridge_9 n(Chunk chunk) {
        return this.c(chunk.getWorld(), chunk.getX(), chunk.getZ());
    }

    public BlockBridge_9 b(Block block) {
        return this.c(block.getWorld(), block.getX() >> 4, block.getZ() >> 4);
    }

    @EventHandler
    private void b(WorldSaveEvent worldSaveEvent) {
        if (this.BC.getIfPresent(worldSaveEvent.getWorld().getName()) != null) {
            this.BC.invalidate(worldSaveEvent.getWorld().getName());
            return;
        }
        this.a(worldSaveEvent.getWorld(), true, false);
    }

    @EventHandler
    private void a(WorldUnloadEvent worldUnloadEvent) {
        ItemStackRegistry.g().W.f(worldUnloadEvent.getWorld());
        MaterialBarColorHolder.eT.f(worldUnloadEvent.getWorld());
        this.BC.put(worldUnloadEvent.getWorld().getName(), (byte)0);
        this.a(worldUnloadEvent.getWorld(), false, true);
    }

    @EventHandler
    private void b(WorldLoadEvent worldLoadEvent) {
        MaterialBarColorHolder.eT.y(worldLoadEvent.getWorld());
        this.BC.invalidate(worldLoadEvent.getWorld().getName());
    }

    @EventHandler(priority=EventPriority.LOW)
    private void a(ChunkLoadEvent chunkLoadEvent) {
        if (!MaterialBarColorHolder.eT.x(chunkLoadEvent.getWorld())) {
            return;
        }
        Chunk chunk = chunkLoadEvent.getChunk();
        BlockBridge_9 blockBridge_9 = this.n(chunk);
        if (blockBridge_9 == null) {
            CommandSenderBridge_5.error("Failed to load chunk (region is null). " + chunk.getX() + " | " + chunk.getZ());
            return;
        }
        ItemStackRegistry.g().W.a(chunk, blockBridge_9);
        if (!AdvancedSlimePaperWrapper.inst().isSlimeWorld(chunk.getWorld())) {
            BukkitTaskBridge.i(() -> BlockIgniteListener.a(chunkLoadEvent, blockBridge_9));
        }
    }

    @EventHandler
    private void a(ChunkUnloadEvent chunkUnloadEvent) {
        ItemStackRegistry.g().W.b(chunkUnloadEvent.getWorld(), chunkUnloadEvent.getChunk().getX(), chunkUnloadEvent.getChunk().getZ());
    }
}
