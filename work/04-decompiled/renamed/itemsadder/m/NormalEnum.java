package itemsadder.m;

public final class NormalEnum
extends Enum {
    public static final /* enum */ NormalEnum NORMAL = new NormalEnum("NORMAL", 0, "normal");
    public static final /* enum */ NormalEnum HEAD = new NormalEnum("HEAD", 1, "head");
    public static final /* enum */ NormalEnum HAT_PIVOT = new NormalEnum("HAT_PIVOT", 2, "hatPivot");
    public static final /* enum */ NormalEnum LEFT_HAND_PIVOT = new NormalEnum("LEFT_HAND_PIVOT", 3, "leftHandPivot");
    public static final /* enum */ NormalEnum RIGHT_HAND_PIVOT = new NormalEnum("RIGHT_HAND_PIVOT", 4, "rightHandPivot");
    public static final /* enum */ NormalEnum MOUNT_PIVOT = new NormalEnum("MOUNT_PIVOT", 5, "mount");
    public static final /* enum */ NormalEnum LOCATOR_PIVOT = new NormalEnum("LOCATOR_PIVOT", 6, "locator");
    private final String str;
    private static final /* synthetic */ NormalEnum[] $VALUES;

    public static NormalEnum[] values() {
        return (NormalEnum[])$VALUES.clone();
    }

    public static NormalEnum valueOf(String string) {
        return Enum.valueOf(NormalEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private NormalEnum() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.str = var3_2;
    }

    public static NormalEnum aG(String string) {
        for (NormalEnum normalEnum : NormalEnum.values()) {
            if (!normalEnum.str.equals(string)) continue;
            return normalEnum;
        }
        return NORMAL;
    }

    public String toString() {
        return this.str;
    }

    public boolean gd() {
        return this == HEAD || this == HAT_PIVOT;
    }

    public boolean ge() {
        return this != MOUNT_PIVOT && this != LEFT_HAND_PIVOT && this != RIGHT_HAND_PIVOT && this != HAT_PIVOT && this != LOCATOR_PIVOT;
    }

    public boolean gf() {
        return this == LEFT_HAND_PIVOT || this == RIGHT_HAND_PIVOT || this == HAT_PIVOT;
    }

    private static /* synthetic */ NormalEnum[] gg() {
        return new NormalEnum[]{NORMAL, HEAD, HAT_PIVOT, LEFT_HAND_PIVOT, RIGHT_HAND_PIVOT, MOUNT_PIVOT, LOCATOR_PIVOT};
    }

    static {
        $VALUES = NormalEnum.gg();
    }
}
