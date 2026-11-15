package itemsadder.m;

@Deprecated
final class ItemEnum
extends Enum {
    public static final /* enum */ ItemEnum ITEM = new ItemEnum("ITEM", 0);
    public static final /* enum */ ItemEnum CUSTOM_ENTITY = new ItemEnum("CUSTOM_ENTITY", 1);
    public static final /* enum */ ItemEnum BOTH = new ItemEnum("BOTH", 2);
    public static final /* enum */ ItemEnum UNKNOWN = new ItemEnum("UNKNOWN", 3);
    private static final /* synthetic */ ItemEnum[] $VALUES;

    public static ItemEnum[] values() {
        return (ItemEnum[])$VALUES.clone();
    }

    public static ItemEnum valueOf(String string) {
        return Enum.valueOf(ItemEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ItemEnum() {
        void var2_-1;
        void var1_-1;
    }

    public static ItemEnum cI(String string) {
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

    private static /* synthetic */ ItemEnum[] rI() {
        return new ItemEnum[]{ITEM, CUSTOM_ENTITY, BOTH, UNKNOWN};
    }

    static {
        $VALUES = ItemEnum.rI();
    }
}
