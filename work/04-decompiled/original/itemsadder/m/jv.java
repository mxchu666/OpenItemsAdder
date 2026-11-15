package itemsadder.m;

public final class jv
extends Enum {
    public static final /* enum */ jv CEILING = new jv("CEILING", 0);
    public static final /* enum */ jv FLOOR = new jv("FLOOR", 1);
    public static final /* enum */ jv WALL = new jv("WALL", 2);
    private static final /* synthetic */ jv[] $VALUES;

    public static jv[] values() {
        return (jv[])$VALUES.clone();
    }

    public static jv valueOf(String string) {
        return Enum.valueOf(jv.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private jv() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ jv[] kP() {
        return new jv[]{CEILING, FLOOR, WALL};
    }

    static {
        $VALUES = jv.kP();
    }
}
