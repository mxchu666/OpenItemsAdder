package itemsadder.m;

import org.bukkit.World;

public final class AnyEnum
extends Enum {
    public static final /* enum */ AnyEnum ANY = new AnyEnum("ANY", 0, -1, -1);
    public static final /* enum */ AnyEnum UNKNOWN = new AnyEnum("UNKNOWN", 1, -1, -1);
    public static final /* enum */ AnyEnum DAY = new AnyEnum("DAY", 2, 1000, 6000);
    public static final /* enum */ AnyEnum NOON = new AnyEnum("NOON", 3, 6000, 13000);
    public static final /* enum */ AnyEnum NIGHT = new AnyEnum("NIGHT", 4, 13000, 18000);
    public static final /* enum */ AnyEnum MIDNIGHT = new AnyEnum("MIDNIGHT", 5, 18000, 23999);
    final int start;
    final int end;
    private static final /* synthetic */ AnyEnum[] $VALUES;

    public static AnyEnum[] values() {
        return (AnyEnum[])$VALUES.clone();
    }

    public static AnyEnum valueOf(String string) {
        return Enum.valueOf(AnyEnum.class, string);
    }

    /*
     * WARNING - void declaration
     */
    private AnyEnum() {
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

    public static AnyEnum l(long l) {
        for (AnyEnum anyEnum : AnyEnum.values()) {
            if (l < (long)anyEnum.DA() || l >= (long)anyEnum.DB()) continue;
            return anyEnum;
        }
        return UNKNOWN;
    }

    public static AnyEnum A(World world) {
        return AnyEnum.l(world.getTime());
    }

    public AnyEnum iZ(String string) {
        string = string.toUpperCase();
        try {
            return AnyEnum.valueOf(string);
        }
        catch (Exception exception) {
            return UNKNOWN;
        }
    }

    public static boolean a(World world, AnyEnum anyEnum, AnyEnum anyEnum2) {
        return world.getTime() >= (long)anyEnum.DA() && world.getTime() <= (long)anyEnum2.DB();
    }

    private static /* synthetic */ AnyEnum[] DC() {
        return new AnyEnum[]{ANY, UNKNOWN, DAY, NOON, NIGHT, MIDNIGHT};
    }

    static {
        $VALUES = AnyEnum.DC();
    }
}
