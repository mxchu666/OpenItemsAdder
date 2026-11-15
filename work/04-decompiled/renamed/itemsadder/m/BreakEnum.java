package itemsadder.m;

public final class BreakEnum
extends Enum {
    public static final /* enum */ BreakEnum BREAK = new BreakEnum("BREAK", 0);
    public static final /* enum */ BreakEnum INTERACT = new BreakEnum("INTERACT", 1);
    public static final /* enum */ BreakEnum TRAMPLE = new BreakEnum("TRAMPLE", 2);
    public static final /* enum */ BreakEnum WATER = new BreakEnum("WATER", 3);
    public static final /* enum */ BreakEnum LAVA = new BreakEnum("LAVA", 4);
    public static final /* enum */ BreakEnum FARMLAND_DRY = new BreakEnum("FARMLAND_DRY", 5);
    private static final /* synthetic */ BreakEnum[] $VALUES;

    public static BreakEnum[] values() {
        return (BreakEnum[])$VALUES.clone();
    }

    public static BreakEnum valueOf(String string) {
        return Enum.valueOf(BreakEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BreakEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ BreakEnum[] bS() {
        return new BreakEnum[]{BREAK, INTERACT, TRAMPLE, WATER, LAVA, FARMLAND_DRY};
    }

    static {
        $VALUES = BreakEnum.bS();
    }
}
