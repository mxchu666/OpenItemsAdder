package itemsadder.m;

public final class io
extends Enum {
    public static final /* enum */ io RIGHT = new io("RIGHT", 0, "RIGHT");
    public static final /* enum */ io LEFT = new io("LEFT", 1, "LEFT");
    private final String text;
    private static final /* synthetic */ io[] $VALUES;

    public static io[] values() {
        return (io[])$VALUES.clone();
    }

    public static io valueOf(String string) {
        return Enum.valueOf(io.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private io() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.text = var3_2;
    }

    public String toString() {
        return this.text;
    }

    private static /* synthetic */ io[] kd() {
        return new io[]{RIGHT, LEFT};
    }

    static {
        $VALUES = io.kd();
    }
}
