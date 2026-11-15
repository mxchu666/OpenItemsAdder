package itemsadder.m;

public final class iw
extends Enum {
    public static final /* enum */ iw EQUAL = new iw("EQUAL", 0);
    public static final /* enum */ iw LESS = new iw("LESS", 1);
    public static final /* enum */ iw MORE = new iw("MORE", 2);
    public static final /* enum */ iw MORE_EQUAL = new iw("MORE_EQUAL", 3);
    public static final /* enum */ iw LESS_EQUAL = new iw("LESS_EQUAL", 4);
    private static final /* synthetic */ iw[] $VALUES;

    public static iw[] values() {
        return (iw[])$VALUES.clone();
    }

    public static iw valueOf(String string) {
        return Enum.valueOf(iw.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private iw() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ iw[] kj() {
        return new iw[]{EQUAL, LESS, MORE, MORE_EQUAL, LESS_EQUAL};
    }

    static {
        $VALUES = iw.kj();
    }
}
