package itemsadder.m;

final class lv
extends Enum {
    public static final /* enum */ lv MSG = new lv("MSG", 0);
    public static final /* enum */ lv CANCEL = new lv("CANCEL", 1);
    public static final /* enum */ lv CREATIVE_ALLOW = new lv("CREATIVE_ALLOW", 2);
    public static final /* enum */ lv WRONG_BUT_DO_NOTHING = new lv("WRONG_BUT_DO_NOTHING", 3);
    public static final /* enum */ lv RIGHT_TOOL = new lv("RIGHT_TOOL", 4);
    private static final /* synthetic */ lv[] $VALUES;

    public static lv[] values() {
        return (lv[])$VALUES.clone();
    }

    public static lv valueOf(String string) {
        return Enum.valueOf(lv.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private lv() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ lv[] lE() {
        return new lv[]{MSG, CANCEL, CREATIVE_ALLOW, WRONG_BUT_DO_NOTHING, RIGHT_TOOL};
    }

    static {
        $VALUES = lv.lE();
    }
}
