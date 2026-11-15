package itemsadder.m;

public final class dy
extends Enum {
    public static final /* enum */ dy SMOOTH = new dy("SMOOTH", 0, "smooth");
    public static final /* enum */ dy PRECISE = new dy("PRECISE", 1, "precise");
    private final String str;
    private static final /* synthetic */ dy[] $VALUES;

    public static dy[] values() {
        return (dy[])$VALUES.clone();
    }

    public static dy valueOf(String string) {
        return Enum.valueOf(dy.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private dy() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.str = var3_2;
    }

    public static dy aF(String string) {
        for (dy dy2 : dy.values()) {
            if (!dy2.str.equals(string)) continue;
            return dy2;
        }
        return PRECISE;
    }

    public String toString() {
        return this.str;
    }

    private static /* synthetic */ dy[] gc() {
        return new dy[]{SMOOTH, PRECISE};
    }

    static {
        $VALUES = dy.gc();
    }
}
