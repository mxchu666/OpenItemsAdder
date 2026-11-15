package itemsadder.m;

public final class NoneEnum
extends Enum {
    public static final /* enum */ NoneEnum NONE = new NoneEnum("NONE", 0);
    public static final /* enum */ NoneEnum ALL = new NoneEnum("ALL", 1);
    public static final /* enum */ NoneEnum LOG = new NoneEnum("LOG", 2);
    public static final /* enum */ NoneEnum FURNACE = new NoneEnum("FURNACE", 3);
    public static final /* enum */ NoneEnum DROPPER = new NoneEnum("DROPPER", 4);
    private static final /* synthetic */ NoneEnum[] $VALUES;

    public static NoneEnum[] values() {
        return (NoneEnum[])$VALUES.clone();
    }

    public static NoneEnum valueOf(String string) {
        return Enum.valueOf(NoneEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private NoneEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ NoneEnum[] pe() {
        return new NoneEnum[]{NONE, ALL, LOG, FURNACE, DROPPER};
    }

    static {
        $VALUES = NoneEnum.pe();
    }
}
