package itemsadder.m;

public final class HiddenEnum
extends Enum {
    public static final /* enum */ HiddenEnum HIDDEN = new HiddenEnum("HIDDEN", 0);
    public static final /* enum */ HiddenEnum VANILLA = new HiddenEnum("VANILLA", 1);
    public static final /* enum */ HiddenEnum TITLE = new HiddenEnum("TITLE", 2);
    public static final /* enum */ HiddenEnum HUD = new HiddenEnum("HUD", 3);
    public static final /* enum */ HiddenEnum BOSSBAR = new HiddenEnum("BOSSBAR", 4);
    private static final /* synthetic */ HiddenEnum[] $VALUES;

    public static HiddenEnum[] values() {
        return (HiddenEnum[])$VALUES.clone();
    }

    public static HiddenEnum valueOf(String string) {
        return Enum.valueOf(HiddenEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private HiddenEnum() {
        void var2_-1;
        void var1_-1;
    }

    public boolean isVisible() {
        return this != HIDDEN && this != VANILLA;
    }

    private static /* synthetic */ HiddenEnum[] om() {
        return new HiddenEnum[]{HIDDEN, VANILLA, TITLE, HUD, BOSSBAR};
    }

    static {
        $VALUES = HiddenEnum.om();
    }
}
