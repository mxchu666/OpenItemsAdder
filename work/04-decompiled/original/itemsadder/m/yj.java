package itemsadder.m;

import org.bukkit.inventory.EquipmentSlot;

final class yj
extends Enum {
    public static final /* enum */ yj MAIN_HAND = new yj("MAIN_HAND", 0);
    public static final /* enum */ yj OFF_HAND = new yj("OFF_HAND", 1);
    public static final /* enum */ yj HEAD = new yj("HEAD", 2);
    public static final /* enum */ yj CHEST = new yj("CHEST", 3);
    public static final /* enum */ yj LEGS = new yj("LEGS", 4);
    public static final /* enum */ yj FEET = new yj("FEET", 5);
    public static final /* enum */ yj ALL = new yj("ALL", 6);
    private static final /* synthetic */ yj[] $VALUES;

    public static yj[] values() {
        return (yj[])$VALUES.clone();
    }

    public static yj valueOf(String string) {
        return Enum.valueOf(yj.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private yj() {
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

    private static /* synthetic */ yj[] st() {
        return new yj[]{MAIN_HAND, OFF_HAND, HEAD, CHEST, LEGS, FEET, ALL};
    }

    static {
        $VALUES = yj.st();
    }
}
