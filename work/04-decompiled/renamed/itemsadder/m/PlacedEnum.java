package itemsadder.m;

public final class PlacedEnum
extends Enum {
    public static final /* enum */ PlacedEnum PLACED = new PlacedEnum("PLACED", 0);
    public static final /* enum */ PlacedEnum NOT_PLACED = new PlacedEnum("NOT_PLACED", 1);
    public static final /* enum */ PlacedEnum NOT_PLACED_INTERACTABLE = new PlacedEnum("NOT_PLACED_INTERACTABLE", 2);
    public static final /* enum */ PlacedEnum VANILLA_ITEM_NOT_PLACED = new PlacedEnum("VANILLA_ITEM_NOT_PLACED", 3);
    private static final /* synthetic */ PlacedEnum[] $VALUES;

    public static PlacedEnum[] values() {
        return (PlacedEnum[])$VALUES.clone();
    }

    public static PlacedEnum valueOf(String string) {
        return Enum.valueOf(PlacedEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PlacedEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ PlacedEnum[] lr() {
        return new PlacedEnum[]{PLACED, NOT_PLACED, NOT_PLACED_INTERACTABLE, VANILLA_ITEM_NOT_PLACED};
    }

    static {
        $VALUES = PlacedEnum.lr();
    }
}
