package itemsadder.m;

import org.bukkit.inventory.EquipmentSlot;

class EquipmentSlotSwitchMap {
    static final /* synthetic */ int[] alG;

    static {
        alG = new int[EquipmentSlot.values().length];
        try {
            EquipmentSlotSwitchMap.alG[EquipmentSlot.HAND.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EquipmentSlotSwitchMap.alG[EquipmentSlot.OFF_HAND.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EquipmentSlotSwitchMap.alG[EquipmentSlot.FEET.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EquipmentSlotSwitchMap.alG[EquipmentSlot.LEGS.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EquipmentSlotSwitchMap.alG[EquipmentSlot.CHEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EquipmentSlotSwitchMap.alG[EquipmentSlot.HEAD.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
