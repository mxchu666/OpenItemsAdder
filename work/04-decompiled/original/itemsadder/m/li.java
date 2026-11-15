package itemsadder.m;

public final class li
extends Enum {
    public static final /* enum */ li PLACED = new li("PLACED", 0);
    public static final /* enum */ li NOT_PLACED = new li("NOT_PLACED", 1);
    public static final /* enum */ li NOT_PLACED_INTERACTABLE = new li("NOT_PLACED_INTERACTABLE", 2);
    public static final /* enum */ li VANILLA_ITEM_NOT_PLACED = new li("VANILLA_ITEM_NOT_PLACED", 3);
    private static final /* synthetic */ li[] $VALUES;

    public static li[] values() {
        return (li[])$VALUES.clone();
    }

    public static li valueOf(String string) {
        return Enum.valueOf(li.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private li() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ li[] lr() {
        return new li[]{PLACED, NOT_PLACED, NOT_PLACED_INTERACTABLE, VANILLA_ITEM_NOT_PLACED};
    }

    static {
        $VALUES = li.lr();
    }
}
