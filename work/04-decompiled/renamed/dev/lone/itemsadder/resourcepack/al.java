package dev.lone.itemsadder.resourcepack;

final class al
extends Enum {
    public static final /* enum */ al SELECTED_PACK_ENTRY = new al("SELECTED_PACK_ENTRY", 0);
    public static final /* enum */ al CACHED_VANILLA_ASSET = new al("CACHED_VANILLA_ASSET", 1);
    public static final /* enum */ al GENERATED_ITEMSADDER_ENTRY = new al("GENERATED_ITEMSADDER_ENTRY", 2);
    public static final /* enum */ al PLANNER_ITEM_VARIANT = new al("PLANNER_ITEM_VARIANT", 3);
    public static final /* enum */ al PLANNER_REMAP = new al("PLANNER_REMAP", 4);
    public static final /* enum */ al ORIGINAL_UNRESOLVED = new al("ORIGINAL_UNRESOLVED", 5);
    public static final /* enum */ al INTENTIONAL_MISSING_FALLBACK = new al("INTENTIONAL_MISSING_FALLBACK", 6);
    private static final /* synthetic */ al[] $VALUES;

    public static al[] values() {
        return (al[])$VALUES.clone();
    }

    public static al valueOf(String string) {
        return Enum.valueOf(al.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private al() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ al[] zh() {
        return new al[]{SELECTED_PACK_ENTRY, CACHED_VANILLA_ASSET, GENERATED_ITEMSADDER_ENTRY, PLANNER_ITEM_VARIANT, PLANNER_REMAP, ORIGINAL_UNRESOLVED, INTENTIONAL_MISSING_FALLBACK};
    }

    static {
        $VALUES = al.zh();
    }
}
