package itemsadder.m;

public final class ArmorStandEnum
extends Enum {
    public static final /* enum */ ArmorStandEnum ARMOR_STAND = new ArmorStandEnum("ARMOR_STAND", 0);
    public static final /* enum */ ArmorStandEnum SMALL_ARMOR_STAND = new ArmorStandEnum("SMALL_ARMOR_STAND", 1);
    public static final /* enum */ ArmorStandEnum ITEM_FRAME = new ArmorStandEnum("ITEM_FRAME", 2);
    private static final /* synthetic */ ArmorStandEnum[] $VALUES;

    public static ArmorStandEnum[] values() {
        return (ArmorStandEnum[])$VALUES.clone();
    }

    public static ArmorStandEnum valueOf(String string) {
        return Enum.valueOf(ArmorStandEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ArmorStandEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ ArmorStandEnum[] kO() {
        return new ArmorStandEnum[]{ARMOR_STAND, SMALL_ARMOR_STAND, ITEM_FRAME};
    }

    static {
        $VALUES = ArmorStandEnum.kO();
    }
}
