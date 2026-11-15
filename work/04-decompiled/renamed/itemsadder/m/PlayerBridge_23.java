package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.Builder_14;
import itemsadder.m.EntityAndBlockEnum;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.PlayerLocationHolder_2;
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

public class PlayerBridge_23
extends Builder_14 {
    public final Particle DG;
    @Nullable
    public final Object DH;
    public final int DI;

    public PlayerBridge_23(Particle particle, @Nullable Object object, int n) {
        this.DG = particle;
        this.DH = object;
        this.DI = n;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        int n = 10;
        Location location = player.getEyeLocation();
        Location location2 = null;
        location = ItemStackBuilder_4.b(itemStack, player.getInventory().getItemInMainHand()) ? location.add(PlayerBridge_23.aW(player).multiply(0.5f)) : location.add(PlayerBridge_23.aX(player).multiply(0.5f));
        PlayerLocationHolder_2 playerLocationHolder_2 = new PlayerLocationHolder_2(player, (double)this.DI);
        if (playerLocationHolder_2.a(EntityAndBlockEnum.ENTITY_AND_BLOCK) && playerLocationHolder_2.EI()) {
            location2 = playerLocationHolder_2.EH();
        }
        if (location2 == null) {
            location2 = player.getEyeLocation().add(player.getLocation().getDirection().multiply(this.DI));
        }
        double d = location.distance(location2) / (double)n;
        int[] nArray = new int[]{0};
        Location location3 = location2;
        Location location4 = location;
        Collection collection = LocationBridge_2.a(location, this.DI);
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
        return ItemStackBuilder_3.ml();
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
