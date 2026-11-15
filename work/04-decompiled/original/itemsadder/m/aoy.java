package itemsadder.m;

import dev.lone.itemsadder.Main;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class aoy {
    public static HashMap akw = new HashMap();
    public int akx = 1;
    float aky = 1.0f;

    public static void dK(String string2) {
        aoy aoy2 = akw.computeIfAbsent(string2, string -> new aoy());
        ++aoy2.akx;
    }

    static void bV() {
        System.out.println("--------");
        System.out.println("Avg packets sent last 1 second.");
        float f = 0.0f;
        for (Map.Entry entry : akw.entrySet()) {
            System.out.println((String)entry.getKey() + " | " + ((aoy)entry.getValue()).uS());
            f += ((aoy)entry.getValue()).uS();
            ((aoy)entry.getValue()).akx = 0;
        }
        System.out.println("# Total AVG: " + f);
        System.out.println("--------");
    }

    static float d(float f, float f2) {
        return f + 0.75f * (f2 - f);
    }

    public float uS() {
        this.aky = aoy.d(this.akx, this.aky);
        return this.aky;
    }

    static {
        Bukkit.getScheduler().runTaskTimerAsynchronously((Plugin)Main.rS(), aoy::bV, 20L, 20L);
    }
}
