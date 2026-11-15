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

public final class HostileEnum
extends Enum {
    public static final /* enum */ HostileEnum HOSTILE = new HostileEnum("HOSTILE", 0, "HOSTILE");
    public static final /* enum */ HostileEnum PLAYERS = new HostileEnum("PLAYERS", 1, "PLAYERS");
    public static final /* enum */ HostileEnum PASSIVE = new HostileEnum("PASSIVE", 2, "PASSIVE");
    private final String name;
    private static final /* synthetic */ HostileEnum[] $VALUES;

    public static HostileEnum[] values() {
        return (HostileEnum[])$VALUES.clone();
    }

    public static HostileEnum valueOf(String string) {
        return Enum.valueOf(HostileEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private HostileEnum() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.name = var3_2;
    }

    @Nullable
    public static HostileEnum F(Entity entity) {
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
    public static HostileEnum bu(String string) {
        for (HostileEnum hostileEnum : HostileEnum.values()) {
            if (!hostileEnum.name.equals(string)) continue;
            return hostileEnum;
        }
        return null;
    }

    private static /* synthetic */ HostileEnum[] mf() {
        return new HostileEnum[]{HOSTILE, PLAYERS, PASSIVE};
    }

    static {
        $VALUES = HostileEnum.mf();
    }
}
