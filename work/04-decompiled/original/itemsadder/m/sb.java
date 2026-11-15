package itemsadder.m;

public final class sb
extends Enum {
    public static final /* enum */ sb NONE = new sb("NONE", 0);
    public static final /* enum */ sb ALL = new sb("ALL", 1);
    public static final /* enum */ sb LOG = new sb("LOG", 2);
    public static final /* enum */ sb FURNACE = new sb("FURNACE", 3);
    public static final /* enum */ sb DROPPER = new sb("DROPPER", 4);
    private static final /* synthetic */ sb[] $VALUES;

    public static sb[] values() {
        return (sb[])$VALUES.clone();
    }

    public static sb valueOf(String string) {
        return Enum.valueOf(sb.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private sb() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ sb[] pe() {
        return new sb[]{NONE, ALL, LOG, FURNACE, DROPPER};
    }

    static {
        $VALUES = sb.pe();
    }
}
