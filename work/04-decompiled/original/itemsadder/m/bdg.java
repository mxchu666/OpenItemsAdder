package itemsadder.m;

import org.bukkit.World;

public final class bdg
extends Enum {
    public static final /* enum */ bdg ANY = new bdg("ANY", 0, -1, -1);
    public static final /* enum */ bdg UNKNOWN = new bdg("UNKNOWN", 1, -1, -1);
    public static final /* enum */ bdg DAY = new bdg("DAY", 2, 1000, 6000);
    public static final /* enum */ bdg NOON = new bdg("NOON", 3, 6000, 13000);
    public static final /* enum */ bdg NIGHT = new bdg("NIGHT", 4, 13000, 18000);
    public static final /* enum */ bdg MIDNIGHT = new bdg("MIDNIGHT", 5, 18000, 23999);
    final int start;
    final int end;
    private static final /* synthetic */ bdg[] $VALUES;

    public static bdg[] values() {
        return (bdg[])$VALUES.clone();
    }

    public static bdg valueOf(String string) {
        return Enum.valueOf(bdg.class, string);
    }

    /*
     * WARNING - void declaration
     */
    private bdg() {
        void var4_1;
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.start = var3_2;
        this.end = var4_1;
    }

    public int DA() {
        return this.start;
    }

    public int DB() {
        return this.end;
    }

    public static bdg l(long l) {
        for (bdg bdg2 : bdg.values()) {
            if (l < (long)bdg2.DA() || l >= (long)bdg2.DB()) continue;
            return bdg2;
        }
        return UNKNOWN;
    }

    public static bdg A(World world) {
        return bdg.l(world.getTime());
    }

    public bdg iZ(String string) {
        string = string.toUpperCase();
        try {
            return bdg.valueOf(string);
        }
        catch (Exception exception) {
            return UNKNOWN;
        }
    }

    public static boolean a(World world, bdg bdg2, bdg bdg3) {
        return world.getTime() >= (long)bdg2.DA() && world.getTime() <= (long)bdg3.DB();
    }

    private static /* synthetic */ bdg[] DC() {
        return new bdg[]{ANY, UNKNOWN, DAY, NOON, NIGHT, MIDNIGHT};
    }

    static {
        $VALUES = bdg.DC();
    }
}
