package itemsadder.m;

import dev.lone.itemsadder.Main;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class AvgPacketsSent {
    public static HashMap akw = new HashMap();
    public int akx = 1;
    float aky = 1.0f;

    public static void dK(String string2) {
        AvgPacketsSent avgPacketsSent = akw.computeIfAbsent(string2, string -> new AvgPacketsSent());
        ++avgPacketsSent.akx;
    }

    static void bV() {
        System.out.println("--------");
        System.out.println("Avg packets sent last 1 second.");
        float f = 0.0f;
        for (Map.Entry entry : akw.entrySet()) {
            System.out.println((String)entry.getKey() + " | " + ((AvgPacketsSent)entry.getValue()).uS());
            f += ((AvgPacketsSent)entry.getValue()).uS();
            ((AvgPacketsSent)entry.getValue()).akx = 0;
        }
        System.out.println("# Total AVG: " + f);
        System.out.println("--------");
    }

    static float d(float f, float f2) {
        return f + 0.75f * (f2 - f);
    }

    public float uS() {
        this.aky = AvgPacketsSent.d(this.akx, this.aky);
        return this.aky;
    }

    static {
        Bukkit.getScheduler().runTaskTimerAsynchronously((Plugin)Main.rS(), AvgPacketsSent::bV, 20L, 20L);
    }
}
