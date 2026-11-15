package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ae;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bev;
import itemsadder.m.da;
import itemsadder.m.de;
import itemsadder.m.dk;
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

public class dd
implements Listener {
    private static dd mc;
    List md = new ArrayList();
    Map me = new HashMap();

    public static dd dx() {
        if (mc == null) {
            mc = new dd();
        }
        return mc;
    }

    private dd() {
        bev.b(this, (Plugin)Main.rS());
    }

    public void a(de de2) {
        this.md.add(de2);
        Main.rS().getServer().getWorlds().forEach(world -> this.a(de2, (World)world));
    }

    public void clear() {
        this.md.clear();
        this.me.clear();
    }

    private void a(de de2, World world2) {
        if (de2.d(world2)) {
            this.me.computeIfAbsent(world2, world -> new ArrayList()).add(de2);
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
        for (de de2 : list) {
            if (!de2.a(creatureSpawnEvent.getEntityType(), location)) continue;
            if (!de2.dy()) {
                return;
            }
            int n = 0;
            Object object = location.getChunk().getEntities();
            int n2 = ((Entity[])object).length;
            for (int i = 0; i < n2; ++i) {
                Entity entity = object[i];
                if (entity.getType() != creatureSpawnEvent.getEntityType() && !da.db().f(entity) || ++n < ae.dR) continue;
                bce.iA("Too many custom entities at " + bcc.ae(location) + ". Skipping spawning of " + de2.dA().bj());
                return;
            }
            if (de2.dF().dQ() == dk.REPLACE) {
                creatureSpawnEvent.setCancelled(true);
            }
            if ((object = da.db().a(de2.dA().bj(), location, true)) != null) {
                bce.iA("Spawned custom entity " + de2.dA().bj() + " in " + location.getWorld().getName() + " at " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
                continue;
            }
            bce.iA("Failed to spawn unknown custom entity " + de2.dA().bj() + " in " + location.getWorld().getName() + " at " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    private void a(WorldLoadEvent worldLoadEvent) {
        this.md.forEach(de2 -> this.a((de)de2, worldLoadEvent.getWorld()));
    }

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    private void a(WorldUnloadEvent worldUnloadEvent) {
        List list = (List)this.me.get(worldUnloadEvent.getWorld());
        if (list != null) {
            this.me.remove(worldUnloadEvent.getWorld());
        }
    }
}
