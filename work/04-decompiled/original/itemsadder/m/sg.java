package itemsadder.m;

import itemsadder.m.bcc;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

public class sg {
    String JG;
    Sound JH;
    Sound JI;
    float pb;
    float pc;

    public sg(String string, Sound sound) {
        this.JI = sound;
        this.pc = 1.0f;
        this.pb = 1.0f;
        if (string == null) {
            return;
        }
        try {
            this.JH = Sound.valueOf((String)string);
        }
        catch (Exception exception) {
            this.JG = string;
        }
    }

    public float pm() {
        return this.pb;
    }

    public void o(float f) {
        this.pb = f;
    }

    public float pn() {
        return this.pc;
    }

    public void p(float f) {
        this.pc = f;
    }

    public void f(Player player, Location location) {
        this.a(player, location, SoundCategory.MASTER);
    }

    public void a(Player player, Location location, SoundCategory soundCategory) {
        if (!this.po()) {
            return;
        }
        if (this.JH != null) {
            player.playSound(location, this.JH, soundCategory, this.pb, this.pc);
        } else if (this.JG != null) {
            player.playSound(location, this.JG, soundCategory, this.pb, this.pc);
        } else if (this.JI != null) {
            player.playSound(location, this.JI, soundCategory, this.pb, this.pc);
        }
    }

    public void a(Location location, SoundCategory soundCategory) {
        if (!this.po()) {
            return;
        }
        for (Player player : bcc.a(location, 16)) {
            this.a(player, location, soundCategory);
        }
    }

    public boolean po() {
        return this.JH != null || this.JG != null || this.JI != null;
    }
}
