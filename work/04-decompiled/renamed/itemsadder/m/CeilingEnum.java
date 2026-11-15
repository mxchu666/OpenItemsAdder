package itemsadder.m;

public final class CeilingEnum
extends Enum {
    public static final /* enum */ CeilingEnum CEILING = new CeilingEnum("CEILING", 0);
    public static final /* enum */ CeilingEnum FLOOR = new CeilingEnum("FLOOR", 1);
    public static final /* enum */ CeilingEnum WALL = new CeilingEnum("WALL", 2);
    private static final /* synthetic */ CeilingEnum[] $VALUES;

    public static CeilingEnum[] values() {
        return (CeilingEnum[])$VALUES.clone();
    }

    public static CeilingEnum valueOf(String string) {
        return Enum.valueOf(CeilingEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CeilingEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ CeilingEnum[] kP() {
        return new CeilingEnum[]{CEILING, FLOOR, WALL};
    }

    static {
        $VALUES = CeilingEnum.kP();
    }
}
