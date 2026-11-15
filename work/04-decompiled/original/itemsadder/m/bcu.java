package itemsadder.m;

import itemsadder.m.bcp;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class bcu {
    public static void a(Sound sound, Player player, SoundCategory soundCategory, long l, Runnable runnable) {
        for (Entity entity : player.getNearbyEntities(30.0, 30.0, 30.0)) {
            if (entity.getType() != EntityType.PLAYER) continue;
            bcu.b(sound, (Player)entity, soundCategory, l, runnable);
        }
    }

    public static void b(Sound sound, Player player, SoundCategory soundCategory, long l, Runnable runnable) {
        BukkitTask bukkitTask = bcp.b(bukkitRunnable -> player.stopSound(sound, soundCategory), 0L, 0L);
        player.stopSound(sound, soundCategory);
        runnable.run();
        player.stopSound(sound, soundCategory);
        bcp.b(() -> ((BukkitTask)bukkitTask).cancel(), l);
    }
}
