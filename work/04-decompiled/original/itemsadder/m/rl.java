package itemsadder.m;

public final class rl
extends Enum {
    public static final /* enum */ rl HIDDEN = new rl("HIDDEN", 0);
    public static final /* enum */ rl VANILLA = new rl("VANILLA", 1);
    public static final /* enum */ rl TITLE = new rl("TITLE", 2);
    public static final /* enum */ rl HUD = new rl("HUD", 3);
    public static final /* enum */ rl BOSSBAR = new rl("BOSSBAR", 4);
    private static final /* synthetic */ rl[] $VALUES;

    public static rl[] values() {
        return (rl[])$VALUES.clone();
    }

    public static rl valueOf(String string) {
        return Enum.valueOf(rl.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private rl() {
        void var2_-1;
        void var1_-1;
    }

    public boolean isVisible() {
        return this != HIDDEN && this != VANILLA;
    }

    private static /* synthetic */ rl[] om() {
        return new rl[]{HIDDEN, VANILLA, TITLE, HUD, BOSSBAR};
    }

    static {
        $VALUES = rl.om();
    }
}
