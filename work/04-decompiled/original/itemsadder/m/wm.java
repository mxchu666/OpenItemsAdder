package itemsadder.m;

@Deprecated
final class wm
extends Enum {
    public static final /* enum */ wm ITEM = new wm("ITEM", 0);
    public static final /* enum */ wm CUSTOM_ENTITY = new wm("CUSTOM_ENTITY", 1);
    public static final /* enum */ wm BOTH = new wm("BOTH", 2);
    public static final /* enum */ wm UNKNOWN = new wm("UNKNOWN", 3);
    private static final /* synthetic */ wm[] $VALUES;

    public static wm[] values() {
        return (wm[])$VALUES.clone();
    }

    public static wm valueOf(String string) {
        return Enum.valueOf(wm.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private wm() {
        void var2_-1;
        void var1_-1;
    }

    public static wm cI(String string) {
        boolean bl = string.contains("$customStack") || string.contains("$itemStack");
        boolean bl2 = string.contains("$customEntity");
        if (bl && bl2) {
            return BOTH;
        }
        if (bl) {
            return ITEM;
        }
        if (bl2) {
            return CUSTOM_ENTITY;
        }
        return UNKNOWN;
    }

    private static /* synthetic */ wm[] rI() {
        return new wm[]{ITEM, CUSTOM_ENTITY, BOTH, UNKNOWN};
    }

    static {
        $VALUES = wm.rI();
    }
}
