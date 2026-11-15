package itemsadder.m;

import java.util.Locale;
import org.bukkit.inventory.EquipmentSlot;

public final class qt
extends Enum {
    public static final /* enum */ qt HEAD = new qt("HEAD", 0, "head", 1, EquipmentSlot.HEAD);
    public static final /* enum */ qt CHEST = new qt("CHEST", 1, "chest", 2, EquipmentSlot.CHEST);
    public static final /* enum */ qt LEGS = new qt("LEGS", 2, "legs", 3, EquipmentSlot.LEGS);
    public static final /* enum */ qt FEET = new qt("FEET", 3, "feet", 4, EquipmentSlot.FEET);
    public static final /* enum */ qt MAINHAND = new qt("MAINHAND", 4, "mainhand", 5, EquipmentSlot.HAND);
    public static final /* enum */ qt OFFHAND = new qt("OFFHAND", 5, "offhand", 6, EquipmentSlot.OFF_HAND);
    public final String name;
    public final int numVal;
    public final EquipmentSlot bukkitSlot;
    private static final /* synthetic */ qt[] $VALUES;

    public static qt[] values() {
        return (qt[])$VALUES.clone();
    }

    public static qt valueOf(String string) {
        return Enum.valueOf(qt.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private qt(EquipmentSlot equipmentSlot) {
        void var5_3;
        void var4_2;
        void var2_-1;
        void var1_-1;
        this.name = equipmentSlot;
        this.numVal = var4_2;
        this.bukkitSlot = var5_3;
    }

    public static qt bQ(String string) {
        if (string == null) {
            return null;
        }
        string = string.toLowerCase(Locale.ROOT);
        for (qt qt2 : qt.values()) {
            if (!qt2.name.equals(string)) continue;
            return qt2;
        }
        return null;
    }

    public static EquipmentSlot bR(String string) {
        if (string == null) {
            return null;
        }
        string = string.toLowerCase(Locale.ROOT);
        for (qt qt2 : qt.values()) {
            if (!qt2.name.equals(string)) continue;
            return qt2.bukkitSlot;
        }
        return null;
    }

    public static String bS(String string) {
        if (string == null) {
            return null;
        }
        return switch (string) {
            case "HAND" -> qt.MAINHAND.name;
            case "OFF_HAND" -> qt.OFFHAND.name;
            case "HEAD" -> qt.HEAD.name;
            case "CHEST" -> qt.CHEST.name;
            case "LEGS" -> qt.LEGS.name;
            case "FEET" -> qt.FEET.name;
            default -> null;
        };
    }

    private static /* synthetic */ qt[] nx() {
        return new qt[]{HEAD, CHEST, LEGS, FEET, MAINHAND, OFFHAND};
    }

    static {
        $VALUES = qt.nx();
    }
}
