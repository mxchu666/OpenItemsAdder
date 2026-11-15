package dev.lone.itemsadder.resourcepack;

final class bj
extends Enum {
    public static final /* enum */ bj APPLIED = new bj("APPLIED", 0);
    public static final /* enum */ bj ALREADY_PROCESSED = new bj("ALREADY_PROCESSED", 1);
    public static final /* enum */ bj UNSUPPORTED_FORMAT = new bj("UNSUPPORTED_FORMAT", 2);
    public static final /* enum */ bj INVALID_PNG = new bj("INVALID_PNG", 3);
    public static final /* enum */ bj NOT_NEEDED = new bj("NOT_NEEDED", 4);
    public static final /* enum */ bj READ_ERROR = new bj("READ_ERROR", 5);
    public static final /* enum */ bj WRITE_ERROR = new bj("WRITE_ERROR", 6);
    private static final /* synthetic */ bj[] $VALUES;

    public static bj[] values() {
        return (bj[])$VALUES.clone();
    }

    public static bj valueOf(String string) {
        return Enum.valueOf(bj.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private bj() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ bj[] zU() {
        return new bj[]{APPLIED, ALREADY_PROCESSED, UNSUPPORTED_FORMAT, INVALID_PNG, NOT_NEEDED, READ_ERROR, WRITE_ERROR};
    }

    static {
        $VALUES = bj.zU();
    }
}
