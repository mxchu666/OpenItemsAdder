package itemsadder.m;

public final class SmoothEnum
extends Enum {
    public static final /* enum */ SmoothEnum SMOOTH = new SmoothEnum("SMOOTH", 0, "smooth");
    public static final /* enum */ SmoothEnum PRECISE = new SmoothEnum("PRECISE", 1, "precise");
    private final String str;
    private static final /* synthetic */ SmoothEnum[] $VALUES;

    public static SmoothEnum[] values() {
        return (SmoothEnum[])$VALUES.clone();
    }

    public static SmoothEnum valueOf(String string) {
        return Enum.valueOf(SmoothEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SmoothEnum() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.str = var3_2;
    }

    public static SmoothEnum aF(String string) {
        for (SmoothEnum smoothEnum : SmoothEnum.values()) {
            if (!smoothEnum.str.equals(string)) continue;
            return smoothEnum;
        }
        return PRECISE;
    }

    public String toString() {
        return this.str;
    }

    private static /* synthetic */ SmoothEnum[] gc() {
        return new SmoothEnum[]{SMOOTH, PRECISE};
    }

    static {
        $VALUES = SmoothEnum.gc();
    }
}
