package itemsadder.m;

public final class dz
extends Enum {
    public static final /* enum */ dz NORMAL = new dz("NORMAL", 0, "normal");
    public static final /* enum */ dz HEAD = new dz("HEAD", 1, "head");
    public static final /* enum */ dz HAT_PIVOT = new dz("HAT_PIVOT", 2, "hatPivot");
    public static final /* enum */ dz LEFT_HAND_PIVOT = new dz("LEFT_HAND_PIVOT", 3, "leftHandPivot");
    public static final /* enum */ dz RIGHT_HAND_PIVOT = new dz("RIGHT_HAND_PIVOT", 4, "rightHandPivot");
    public static final /* enum */ dz MOUNT_PIVOT = new dz("MOUNT_PIVOT", 5, "mount");
    public static final /* enum */ dz LOCATOR_PIVOT = new dz("LOCATOR_PIVOT", 6, "locator");
    private final String str;
    private static final /* synthetic */ dz[] $VALUES;

    public static dz[] values() {
        return (dz[])$VALUES.clone();
    }

    public static dz valueOf(String string) {
        return Enum.valueOf(dz.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private dz() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.str = var3_2;
    }

    public static dz aG(String string) {
        for (dz dz2 : dz.values()) {
            if (!dz2.str.equals(string)) continue;
            return dz2;
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

    private static /* synthetic */ dz[] gg() {
        return new dz[]{NORMAL, HEAD, HAT_PIVOT, LEFT_HAND_PIVOT, RIGHT_HAND_PIVOT, MOUNT_PIVOT, LOCATOR_PIVOT};
    }

    static {
        $VALUES = dz.gg();
    }
}
