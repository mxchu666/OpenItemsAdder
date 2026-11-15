package itemsadder.m;

import itemsadder.m.ChunkBridge_3;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.WorldBridge_10;
import itemsadder.m.WorldBridge_11;
import itemsadder.m.WorldBridge_12;
import itemsadder.m.WorldBridge_13;
import itemsadder.m.WorldBridge_14;
import itemsadder.m.WorldBridge_7;
import itemsadder.m.WorldBridge_8;
import itemsadder.m.WorldBridge_9;
import itemsadder.m.WorldLoadListener;
import java.util.List;
import java.util.Map;
import org.bukkit.World;
import org.bukkit.event.Listener;

public class WorldBridge_6
implements Listener {
    static WorldLoadListener KL;

    public static void reload() {
        WorldBridge_6.pW();
        KL = new WorldLoadListener();
        for (PluginFileConfigurationHolder pluginFileConfigurationHolder : ItemStackRegistry.g().b()) {
            WorldBridge_8.h(pluginFileConfigurationHolder);
            WorldBridge_11.h(pluginFileConfigurationHolder);
            WorldBridge_10.h(pluginFileConfigurationHolder);
            WorldBridge_9.h(pluginFileConfigurationHolder);
        }
        WorldBridge_6.q(ChunkBridge_3.md);
        WorldBridge_6.q(WorldBridge_14.md);
        WorldBridge_6.q(WorldBridge_13.md);
        WorldBridge_6.q(WorldBridge_12.md);
    }

    public static void pW() {
        if (KL != null) {
            ListenerBridge.b(KL);
        }
        WorldBridge_6.mc();
    }

    public static void mc() {
        for (WorldBridge_7 worldBridge_7 : ChunkBridge_3.md) {
            ((ChunkBridge_3)worldBridge_7).rN();
        }
        ChunkBridge_3.md.clear();
        for (WorldBridge_7 worldBridge_7 : WorldBridge_14.md) {
            ((WorldBridge_14)worldBridge_7).rN();
        }
        WorldBridge_14.md.clear();
        for (WorldBridge_7 worldBridge_7 : WorldBridge_13.md) {
            ((WorldBridge_13)worldBridge_7).rN();
        }
        WorldBridge_13.md.clear();
        for (WorldBridge_7 worldBridge_7 : WorldBridge_12.md) {
            ((WorldBridge_12)worldBridge_7).rN();
        }
        WorldBridge_12.md.clear();
        WorldBridge_12.OQ.clear();
    }

    static void p(List list) {
        list.removeIf(worldBridge_7 -> {
            worldBridge_7.rN();
            return true;
        });
    }

    static void q(List list) {
        list.forEach(worldBridge_7 -> worldBridge_7.hn());
    }

    static void a(World world, Map map) {
        map.forEach((string, materialBridge_20) -> materialBridge_20.k(world));
    }

    static void a(World world, List list) {
        world.getPopulators().removeIf(blockPopulator -> blockPopulator instanceof WorldBridge_7);
        list.removeIf(worldBridge_7 -> {
            if (!world.equals((Object)worldBridge_7.cE())) {
                return false;
            }
            worldBridge_7.rN();
            return true;
        });
    }

    public static void h(World world) {
        WorldBridge_6.a(world, ChunkBridge_3.md);
        WorldBridge_6.a(world, WorldBridge_14.md);
        WorldBridge_6.a(world, WorldBridge_13.md);
        WorldBridge_6.a(world, WorldBridge_12.md);
        WorldBridge_12.OQ.remove(world.getUID());
    }
}
