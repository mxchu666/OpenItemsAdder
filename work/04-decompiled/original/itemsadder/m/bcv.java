package itemsadder.m;

import itemsadder.m.aow;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

public class bcv {
    public static void a(Location location, String string, SoundCategory soundCategory, float f, float f2) {
        aow.uN().a(string, f, f2, soundCategory, location);
    }

    public static void a(Location location, String string, SoundCategory soundCategory) {
        bcv.a(location, string, soundCategory, 1.0f, 1.0f);
    }

    public static void a(Location location, Sound sound, SoundCategory soundCategory) {
        bcv.a(location, sound, soundCategory, 1.0f, 1.0f);
    }

    public static void a(Player player, Location location, String string, SoundCategory soundCategory, float f, float f2) {
        player.playSound(location, string, soundCategory, f, f2);
    }

    public static void a(Location location, SoundCategory soundCategory, String string) {
        aow.uN().a(string, soundCategory, location);
    }

    public static void a(Location location, Sound sound, SoundCategory soundCategory, float f, float f2) {
        aow.uN().a(sound.getKey().toString(), f, f2, soundCategory, location);
    }
}
