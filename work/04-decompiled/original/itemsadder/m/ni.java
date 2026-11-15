package itemsadder.m;

import org.bukkit.entity.Ambient;
import org.bukkit.entity.Animals;
import org.bukkit.entity.ComplexLivingEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Flying;
import org.bukkit.entity.Monster;
import org.bukkit.entity.NPC;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.WaterMob;
import org.jetbrains.annotations.Nullable;

public final class ni
extends Enum {
    public static final /* enum */ ni HOSTILE = new ni("HOSTILE", 0, "HOSTILE");
    public static final /* enum */ ni PLAYERS = new ni("PLAYERS", 1, "PLAYERS");
    public static final /* enum */ ni PASSIVE = new ni("PASSIVE", 2, "PASSIVE");
    private final String name;
    private static final /* synthetic */ ni[] $VALUES;

    public static ni[] values() {
        return (ni[])$VALUES.clone();
    }

    public static ni valueOf(String string) {
        return Enum.valueOf(ni.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ni() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.name = var3_2;
    }

    @Nullable
    public static ni F(Entity entity) {
        if (entity instanceof Monster || entity instanceof ComplexLivingEntity || entity instanceof Flying || entity instanceof Slime) {
            return HOSTILE;
        }
        if (entity instanceof Player) {
            return PLAYERS;
        }
        if (entity instanceof Animals || entity instanceof NPC || entity instanceof Snowman || entity instanceof WaterMob || entity instanceof Ambient) {
            return PASSIVE;
        }
        return null;
    }

    @Nullable
    public static ni bu(String string) {
        for (ni ni2 : ni.values()) {
            if (!ni2.name.equals(string)) continue;
            return ni2;
        }
        return null;
    }

    private static /* synthetic */ ni[] mf() {
        return new ni[]{HOSTILE, PLAYERS, PASSIVE};
    }

    static {
        $VALUES = ni.mf();
    }
}
