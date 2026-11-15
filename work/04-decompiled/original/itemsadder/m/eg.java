package itemsadder.m;

import itemsadder.m.eb;
import org.bukkit.Location;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

public class eg
extends eb {
    public String oz;
    public float pb;
    public float pc;

    public eg(String string, float f, float f2) {
        this.oz = string;
        this.pb = f;
        this.pc = f2;
    }

    @Override
    public void t(Location location) {
        for (Player player : location.getWorld().getPlayers()) {
            if (!(location.distance(player.getLocation()) < 64.0)) continue;
            player.playSound(location, this.oz, SoundCategory.MASTER, this.pb, this.pc);
        }
    }

    public void u(Location location) {
        for (Player player : location.getWorld().getPlayers()) {
            if (!(location.distance(player.getLocation()) < 64.0)) continue;
            player.stopSound(this.oz, SoundCategory.MASTER);
        }
    }
}
