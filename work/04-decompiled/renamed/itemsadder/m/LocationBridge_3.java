package itemsadder.m;

import itemsadder.m.PacketListenerRegistry;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

public class LocationBridge_3 {
    public static void a(Location location, String string, SoundCategory soundCategory, float f, float f2) {
        PacketListenerRegistry.uN().a(string, f, f2, soundCategory, location);
    }

    public static void a(Location location, String string, SoundCategory soundCategory) {
        LocationBridge_3.a(location, string, soundCategory, 1.0f, 1.0f);
    }

    public static void a(Location location, Sound sound, SoundCategory soundCategory) {
        LocationBridge_3.a(location, sound, soundCategory, 1.0f, 1.0f);
    }

    public static void a(Player player, Location location, String string, SoundCategory soundCategory, float f, float f2) {
        player.playSound(location, string, soundCategory, f, f2);
    }

    public static void a(Location location, SoundCategory soundCategory, String string) {
        PacketListenerRegistry.uN().a(string, soundCategory, location);
    }

    public static void a(Location location, Sound sound, SoundCategory soundCategory, float f, float f2) {
        PacketListenerRegistry.uN().a(sound.getKey().toString(), f, f2, soundCategory, location);
    }
}
