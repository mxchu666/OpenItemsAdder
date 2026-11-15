package itemsadder.m;

public final class cd
extends Enum {
    public static final /* enum */ cd BREAK = new cd("BREAK", 0);
    public static final /* enum */ cd INTERACT = new cd("INTERACT", 1);
    public static final /* enum */ cd TRAMPLE = new cd("TRAMPLE", 2);
    public static final /* enum */ cd WATER = new cd("WATER", 3);
    public static final /* enum */ cd LAVA = new cd("LAVA", 4);
    public static final /* enum */ cd FARMLAND_DRY = new cd("FARMLAND_DRY", 5);
    private static final /* synthetic */ cd[] $VALUES;

    public static cd[] values() {
        return (cd[])$VALUES.clone();
    }

    public static cd valueOf(String string) {
        return Enum.valueOf(cd.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private cd() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ cd[] bS() {
        return new cd[]{BREAK, INTERACT, TRAMPLE, WATER, LAVA, FARMLAND_DRY};
    }

    static {
        $VALUES = cd.bS();
    }
}
