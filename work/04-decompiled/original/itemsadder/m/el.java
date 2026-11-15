package itemsadder.m;

import dev.lone.itemsadder.Main;
import java.util.LinkedList;
import java.util.Queue;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class el {
    volatile int ra;
    volatile int rb;
    Queue rc = new LinkedList();

    public el() {
        Bukkit.getScheduler().runTaskTimer((Plugin)Main.rS(), () -> {
            this.rc.add(this.ra);
            if (this.rc.size() > 4) {
                int n = 0;
                for (Integer n2 : this.rc) {
                    n += n2.intValue();
                }
                this.rb = n / this.rc.size();
                this.rc.remove();
            }
            this.ra = 0;
        }, 20L, 20L);
    }

    public void gP() {
        ++this.ra;
    }
}
