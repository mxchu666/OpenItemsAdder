package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ColorBridge;
import itemsadder.m.EnumWrappersHolder;
import itemsadder.m.ListenerBridge;
import itemsadder.m.WorldBridge_10;
import itemsadder.m.WorldBridge_11;
import itemsadder.m.WorldBridge_12;
import itemsadder.m.WorldBridge_6;
import itemsadder.m.WorldBridge_8;
import itemsadder.m.WorldBridge_9;
import java.util.List;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldUnloadEvent;

public class WorldLoadListener
implements Listener {
    WorldLoadListener() {
        ListenerBridge.a(this, Main.rT());
    }

    @EventHandler
    private void c(WorldLoadEvent worldLoadEvent) {
        WorldBridge_6.a(worldLoadEvent.getWorld(), WorldBridge_8.Oz);
        WorldBridge_6.a(worldLoadEvent.getWorld(), WorldBridge_11.Oz);
        WorldBridge_6.a(worldLoadEvent.getWorld(), WorldBridge_10.OF);
        WorldBridge_6.a(worldLoadEvent.getWorld(), WorldBridge_9.Oz);
    }

    @EventHandler
    private void a(WorldUnloadEvent worldUnloadEvent) {
        WorldBridge_6.h(worldUnloadEvent.getWorld());
    }

    @EventHandler
    private void a(ChunkPopulateEvent chunkPopulateEvent) {
        WorldBridge_12 worldBridge_12 = (WorldBridge_12)WorldBridge_12.OQ.get(chunkPopulateEvent.getWorld().getUID());
        if (worldBridge_12 == null) {
            return;
        }
        List list = EnumWrappersHolder.vC().aoJ.a(chunkPopulateEvent.getChunk(), worldBridge_12.OR, worldBridge_12.OS);
        for (WorldBridge_9 worldBridge_9 : worldBridge_12.Ow) {
            worldBridge_12.a(list, chunkPopulateEvent.getChunk(), ColorBridge.Bl, worldBridge_9);
        }
    }
}
