package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bcc;
import itemsadder.m.bfo;
import itemsadder.m.bfp;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import java.util.Collection;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

public class op
extends ou {
    public final Particle DG;
    @Nullable
    public final Object DH;
    public final int DI;

    public op(Particle particle, @Nullable Object object, int n) {
        this.DG = particle;
        this.DH = object;
        this.DI = n;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        int n = 10;
        Location location = player.getEyeLocation();
        Location location2 = null;
        location = qm.b(itemStack, player.getInventory().getItemInMainHand()) ? location.add(op.aW(player).multiply(0.5f)) : location.add(op.aX(player).multiply(0.5f));
        bfo bfo2 = new bfo(player, (double)this.DI);
        if (bfo2.a(bfp.ENTITY_AND_BLOCK) && bfo2.EI()) {
            location2 = bfo2.EH();
        }
        if (location2 == null) {
            location2 = player.getEyeLocation().add(player.getLocation().getDirection().multiply(this.DI));
        }
        double d = location.distance(location2) / (double)n;
        int[] nArray = new int[]{0};
        Location location3 = location2;
        Location location4 = location;
        Collection collection = bcc.a(location, this.DI);
        Bukkit.getScheduler().runTaskTimerAsynchronously((Plugin)Main.rS(), bukkitTask -> {
            if (nArray[0] >= n) {
                bukkitTask.cancel();
            }
            Location location3 = location4.clone();
            Vector vector = location3.toVector().subtract(location4.toVector()).normalize();
            Vector vector2 = vector.multiply((double)nArray[0] * d);
            location3.add(vector2.getX(), vector2.getY(), vector2.getZ());
            for (Player player : collection) {
                player.spawnParticle(this.DG, location3, 1, 0.0, 0.0, 0.0, 0.0, this.DH);
            }
            nArray[0] = nArray[0] + 1;
        }, 0L, 0L);
        return pa.ml();
    }

    private static Vector aW(Player player) {
        Vector vector = player.getLocation().getDirection().normalize();
        return new Vector(-vector.getZ(), 0.0, vector.getX()).normalize();
    }

    public static Vector aX(Player player) {
        Vector vector = player.getLocation().getDirection().normalize();
        return new Vector(vector.getZ(), 0.0, -vector.getX()).normalize();
    }
}
