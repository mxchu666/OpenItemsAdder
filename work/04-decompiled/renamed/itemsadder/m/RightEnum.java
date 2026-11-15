package itemsadder.m;

public final class RightEnum
extends Enum {
    public static final /* enum */ RightEnum RIGHT = new RightEnum("RIGHT", 0, "RIGHT");
    public static final /* enum */ RightEnum LEFT = new RightEnum("LEFT", 1, "LEFT");
    private final String text;
    private static final /* synthetic */ RightEnum[] $VALUES;

    public static RightEnum[] values() {
        return (RightEnum[])$VALUES.clone();
    }

    public static RightEnum valueOf(String string) {
        return Enum.valueOf(RightEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private RightEnum() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.text = var3_2;
    }

    public String toString() {
        return this.text;
    }

    private static /* synthetic */ RightEnum[] kd() {
        return new RightEnum[]{RIGHT, LEFT};
    }

    static {
        $VALUES = RightEnum.kd();
    }
}
