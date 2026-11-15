package dev.lone.itemsadder.resourcepack;

final class cb
extends Enum {
    public static final /* enum */ cb ERROR = new cb("ERROR", 0);
    public static final /* enum */ cb WARNING = new cb("WARNING", 1);
    public static final /* enum */ cb INFO = new cb("INFO", 2);
    private static final /* synthetic */ cb[] $VALUES;

    public static cb[] values() {
        return (cb[])$VALUES.clone();
    }

    public static cb valueOf(String string) {
        return Enum.valueOf(cb.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private cb() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ cb[] AH() {
        return new cb[]{ERROR, WARNING, INFO};
    }

    static {
        $VALUES = cb.AH();
    }
}
