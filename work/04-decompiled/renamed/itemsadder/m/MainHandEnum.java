package itemsadder.m;

import org.bukkit.inventory.EquipmentSlot;

final class MainHandEnum
extends Enum {
    public static final /* enum */ MainHandEnum MAIN_HAND = new MainHandEnum("MAIN_HAND", 0);
    public static final /* enum */ MainHandEnum OFF_HAND = new MainHandEnum("OFF_HAND", 1);
    public static final /* enum */ MainHandEnum HEAD = new MainHandEnum("HEAD", 2);
    public static final /* enum */ MainHandEnum CHEST = new MainHandEnum("CHEST", 3);
    public static final /* enum */ MainHandEnum LEGS = new MainHandEnum("LEGS", 4);
    public static final /* enum */ MainHandEnum FEET = new MainHandEnum("FEET", 5);
    public static final /* enum */ MainHandEnum ALL = new MainHandEnum("ALL", 6);
    private static final /* synthetic */ MainHandEnum[] $VALUES;

    public static MainHandEnum[] values() {
        return (MainHandEnum[])$VALUES.clone();
    }

    public static MainHandEnum valueOf(String string) {
        return Enum.valueOf(MainHandEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MainHandEnum() {
        void var2_-1;
        void var1_-1;
    }

    public EquipmentSlot ss() {
        return switch (this.ordinal()) {
            case 0 -> EquipmentSlot.HAND;
            case 1 -> EquipmentSlot.OFF_HAND;
            case 2 -> EquipmentSlot.HEAD;
            case 3 -> EquipmentSlot.CHEST;
            case 4 -> EquipmentSlot.LEGS;
            case 5 -> EquipmentSlot.FEET;
            default -> null;
        };
    }

    public boolean isSingle() {
        return this != ALL;
    }

    private static /* synthetic */ MainHandEnum[] st() {
        return new MainHandEnum[]{MAIN_HAND, OFF_HAND, HEAD, CHEST, LEGS, FEET, ALL};
    }

    static {
        $VALUES = MainHandEnum.st();
    }
}
