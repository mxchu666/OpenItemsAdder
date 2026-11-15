package itemsadder.m;

public final class agc
extends Enum {
    public static final /* enum */ agc MONSTER = new agc("MONSTER", 0);
    public static final /* enum */ agc CREATURE = new agc("CREATURE", 1);
    public static final /* enum */ agc AMBIENT = new agc("AMBIENT", 2);
    public static final /* enum */ agc AXOLOTLS = new agc("AXOLOTLS", 3);
    public static final /* enum */ agc UNDERGROUND_WATER_CREATURE = new agc("UNDERGROUND_WATER_CREATURE", 4);
    public static final /* enum */ agc WATER_CREATURE = new agc("WATER_CREATURE", 5);
    public static final /* enum */ agc WATER_AMBIENT = new agc("WATER_AMBIENT", 6);
    public static final /* enum */ agc MISC = new agc("MISC", 7);
    private static final /* synthetic */ agc[] $VALUES;

    public static agc[] values() {
        return (agc[])$VALUES.clone();
    }

    public static agc valueOf(String string) {
        return Enum.valueOf(agc.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private agc() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ agc[] tL() {
        return new agc[]{MONSTER, CREATURE, AMBIENT, AXOLOTLS, UNDERGROUND_WATER_CREATURE, WATER_CREATURE, WATER_AMBIENT, MISC};
    }

    static {
        $VALUES = agc.tL();
    }
}
