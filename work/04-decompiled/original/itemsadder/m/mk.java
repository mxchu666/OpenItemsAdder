package itemsadder.m;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import dev.lone.itemsadder.Core.OtherPlugins.AdvancedSlimePaperWrapper;
import itemsadder.m.ae;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.mc;
import itemsadder.m.mj;
import itemsadder.m.mp;
import itemsadder.m.ms;
import itemsadder.m.mt;
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

public class mk
extends mj
implements Listener {
    Cache BC = CacheBuilder.newBuilder().expireAfterWrite(30L, TimeUnit.SECONDS).build();
    private static final ms BD = new mp();

    public mk(Plugin plugin) {
        super(plugin);
        bev.b(this, plugin);
        int n = 1300;
        bcp.b(bukkitRunnable -> {
            Iterator iterator = this.By.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = iterator.next();
                ms ms2 = (ms)entry.getValue();
                try {
                    mt mt2 = ms2.lN();
                    switch (mt2) {
                        case SAVED: {
                            iterator.remove();
                            break;
                        }
                    }
                }
                catch (Throwable throwable) {
                    bce.error("Error saving region file: " + ms2.lO(), throwable);
                }
            }
        }, n, n);
    }

    @Override
    public ms c(World world, int n, int n2) {
        ms ms2;
        if (!ae.eT.x(world)) {
            return BD;
        }
        int n3 = ms.g(world, n, n2);
        if (!this.ac(n3)) {
            ms2 = this.a(world, n, n2, null);
            if (ms2 != null) {
                this.By.put(ms2.BP, ms2);
                ms2.a(n, n2, false);
            }
        } else {
            ms2 = (ms)this.By.get(n3);
        }
        return ms2;
    }

    @Override
    public ms a(World world, int n, int n2) {
        ms ms2;
        if (!ae.eT.x(world)) {
            return BD;
        }
        int n3 = ms.f(world, n, n2);
        if (!this.ac(n3)) {
            ms2 = this.d(world, n, n2);
            if (ms2 != null) {
                this.By.put(ms2.BP, ms2);
            }
        } else {
            ms2 = (ms)this.By.get(n3);
        }
        return ms2;
    }

    public ms n(Chunk chunk) {
        return this.c(chunk.getWorld(), chunk.getX(), chunk.getZ());
    }

    public ms b(Block block) {
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
        d.g().W.f(worldUnloadEvent.getWorld());
        ae.eT.f(worldUnloadEvent.getWorld());
        this.BC.put(worldUnloadEvent.getWorld().getName(), (byte)0);
        this.a(worldUnloadEvent.getWorld(), false, true);
    }

    @EventHandler
    private void b(WorldLoadEvent worldLoadEvent) {
        ae.eT.y(worldLoadEvent.getWorld());
        this.BC.invalidate(worldLoadEvent.getWorld().getName());
    }

    @EventHandler(priority=EventPriority.LOW)
    private void a(ChunkLoadEvent chunkLoadEvent) {
        if (!ae.eT.x(chunkLoadEvent.getWorld())) {
            return;
        }
        Chunk chunk = chunkLoadEvent.getChunk();
        ms ms2 = this.n(chunk);
        if (ms2 == null) {
            bce.error("Failed to load chunk (region is null). " + chunk.getX() + " | " + chunk.getZ());
            return;
        }
        d.g().W.a(chunk, ms2);
        if (!AdvancedSlimePaperWrapper.inst().isSlimeWorld(chunk.getWorld())) {
            bcp.i(() -> mc.a(chunkLoadEvent, ms2));
        }
    }

    @EventHandler
    private void a(ChunkUnloadEvent chunkUnloadEvent) {
        d.g().W.b(chunkUnloadEvent.getWorld(), chunkUnloadEvent.getChunk().getX(), chunkUnloadEvent.getChunk().getZ());
    }
}
