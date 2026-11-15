package itemsadder.m;

import java.util.Locale;
import org.bukkit.inventory.EquipmentSlot;

public final class HeadEnum
extends Enum {
    public static final /* enum */ HeadEnum HEAD = new HeadEnum("HEAD", 0, "head", 1, EquipmentSlot.HEAD);
    public static final /* enum */ HeadEnum CHEST = new HeadEnum("CHEST", 1, "chest", 2, EquipmentSlot.CHEST);
    public static final /* enum */ HeadEnum LEGS = new HeadEnum("LEGS", 2, "legs", 3, EquipmentSlot.LEGS);
    public static final /* enum */ HeadEnum FEET = new HeadEnum("FEET", 3, "feet", 4, EquipmentSlot.FEET);
    public static final /* enum */ HeadEnum MAINHAND = new HeadEnum("MAINHAND", 4, "mainhand", 5, EquipmentSlot.HAND);
    public static final /* enum */ HeadEnum OFFHAND = new HeadEnum("OFFHAND", 5, "offhand", 6, EquipmentSlot.OFF_HAND);
    public final String name;
    public final int numVal;
    public final EquipmentSlot bukkitSlot;
    private static final /* synthetic */ HeadEnum[] $VALUES;

    public static HeadEnum[] values() {
        return (HeadEnum[])$VALUES.clone();
    }

    public static HeadEnum valueOf(String string) {
        return Enum.valueOf(HeadEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private HeadEnum(EquipmentSlot equipmentSlot) {
        void var5_3;
        void var4_2;
        void var2_-1;
        void var1_-1;
        this.name = equipmentSlot;
        this.numVal = var4_2;
        this.bukkitSlot = var5_3;
    }

    public static HeadEnum bQ(String string) {
        if (string == null) {
            return null;
        }
        string = string.toLowerCase(Locale.ROOT);
        for (HeadEnum headEnum : HeadEnum.values()) {
            if (!headEnum.name.equals(string)) continue;
            return headEnum;
        }
        return null;
    }

    public static EquipmentSlot bR(String string) {
        if (string == null) {
            return null;
        }
        string = string.toLowerCase(Locale.ROOT);
        for (HeadEnum headEnum : HeadEnum.values()) {
            if (!headEnum.name.equals(string)) continue;
            return headEnum.bukkitSlot;
        }
        return null;
    }

    public static String bS(String string) {
        if (string == null) {
            return null;
        }
        return switch (string) {
            case "HAND" -> HeadEnum.MAINHAND.name;
            case "OFF_HAND" -> HeadEnum.OFFHAND.name;
            case "HEAD" -> HeadEnum.HEAD.name;
            case "CHEST" -> HeadEnum.CHEST.name;
            case "LEGS" -> HeadEnum.LEGS.name;
            case "FEET" -> HeadEnum.FEET.name;
            default -> null;
        };
    }

    private static /* synthetic */ HeadEnum[] nx() {
        return new HeadEnum[]{HEAD, CHEST, LEGS, FEET, MAINHAND, OFFHAND};
    }

    static {
        $VALUES = HeadEnum.nx();
    }
}
