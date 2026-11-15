package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.RecordOfValue_12;
import itemsadder.m.ReplaceEnum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldUnloadEvent;
import org.bukkit.plugin.Plugin;

public class CreatureSpawnListener
implements Listener {
    private static CreatureSpawnListener mc;
    List md = new ArrayList();
    Map me = new HashMap();

    public static CreatureSpawnListener dx() {
        if (mc == null) {
            mc = new CreatureSpawnListener();
        }
        return mc;
    }

    private CreatureSpawnListener() {
        ListenerBridge.b(this, (Plugin)Main.rS());
    }

    public void a(RecordOfValue_12 recordOfValue_12) {
        this.md.add(recordOfValue_12);
        Main.rS().getServer().getWorlds().forEach(world -> this.a(recordOfValue_12, (World)world));
    }

    public void clear() {
        this.md.clear();
        this.me.clear();
    }

    private void a(RecordOfValue_12 recordOfValue_12, World world2) {
        if (recordOfValue_12.d(world2)) {
            this.me.computeIfAbsent(world2, world -> new ArrayList()).add(recordOfValue_12);
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    private void a(CreatureSpawnEvent creatureSpawnEvent) {
        if (creatureSpawnEvent.getSpawnReason() == CreatureSpawnEvent.SpawnReason.CUSTOM) {
            return;
        }
        if (creatureSpawnEvent.getSpawnReason() != CreatureSpawnEvent.SpawnReason.NATURAL) {
            return;
        }
        Location location = creatureSpawnEvent.getLocation();
        List list = (List)this.me.get(location.getWorld());
        if (list == null) {
            return;
        }
        for (RecordOfValue_12 recordOfValue_12 : list) {
            if (!recordOfValue_12.a(creatureSpawnEvent.getEntityType(), location)) continue;
            if (!recordOfValue_12.dy()) {
                return;
            }
            int n = 0;
            Object object = location.getChunk().getEntities();
            int n2 = ((Entity[])object).length;
            for (int i = 0; i < n2; ++i) {
                Entity entity = object[i];
                if (entity.getType() != creatureSpawnEvent.getEntityType() && !LivingEntityRegistry.db().f(entity) || ++n < MaterialBarColorHolder.dR) continue;
                CommandSenderBridge_5.iA("Too many custom entities at " + LocationBridge_2.ae(location) + ". Skipping spawning of " + recordOfValue_12.dA().bj());
                return;
            }
            if (recordOfValue_12.dF().dQ() == ReplaceEnum.REPLACE) {
                creatureSpawnEvent.setCancelled(true);
            }
            if ((object = LivingEntityRegistry.db().a(recordOfValue_12.dA().bj(), location, true)) != null) {
                CommandSenderBridge_5.iA("Spawned custom entity " + recordOfValue_12.dA().bj() + " in " + location.getWorld().getName() + " at " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
                continue;
            }
            CommandSenderBridge_5.iA("Failed to spawn unknown custom entity " + recordOfValue_12.dA().bj() + " in " + location.getWorld().getName() + " at " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    private void a(WorldLoadEvent worldLoadEvent) {
        this.md.forEach(recordOfValue_12 -> this.a((RecordOfValue_12)recordOfValue_12, worldLoadEvent.getWorld()));
    }

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    private void a(WorldUnloadEvent worldUnloadEvent) {
        List list = (List)this.me.get(worldUnloadEvent.getWorld());
        if (list != null) {
            this.me.remove(worldUnloadEvent.getWorld());
        }
    }
}
