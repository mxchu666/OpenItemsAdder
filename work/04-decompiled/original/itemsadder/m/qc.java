package itemsadder.m;

final class qc
extends Enum {
    public static final /* enum */ qc PICKING_UP = new qc("PICKING_UP", 0);
    public static final /* enum */ qc LOYAL_PICKING_UP = new qc("LOYAL_PICKING_UP", 1);
    public static final /* enum */ qc NONE = new qc("NONE", 2);
    private static final /* synthetic */ qc[] $VALUES;

    public static qc[] values() {
        return (qc[])$VALUES.clone();
    }

    public static qc valueOf(String string) {
        return Enum.valueOf(qc.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private qc() {
        void var2_-1;
        void var1_-1;
    }

    public boolean mz() {
        return this == PICKING_UP || this == LOYAL_PICKING_UP;
    }

    private static /* synthetic */ qc[] mA() {
        return new qc[]{PICKING_UP, LOYAL_PICKING_UP, NONE};
    }

    static {
        $VALUES = qc.mA();
    }
}
