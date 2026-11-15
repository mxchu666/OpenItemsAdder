package itemsadder.m;

public final class aw
extends Enum {
    public static final /* enum */ aw SUCCESS = new aw("SUCCESS", 0);
    public static final /* enum */ aw FAILED = new aw("FAILED", 1);
    private static final /* synthetic */ aw[] $VALUES;

    public static aw[] values() {
        return (aw[])$VALUES.clone();
    }

    public static aw valueOf(String string) {
        return Enum.valueOf(aw.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private aw() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ aw[] aP() {
        return new aw[]{SUCCESS, FAILED};
    }

    static {
        $VALUES = aw.aP();
    }
}
