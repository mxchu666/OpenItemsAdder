package itemsadder.m;

public final class dc
extends Enum {
    public static final /* enum */ dc PLAY = new dc("PLAY", 0);
    public static final /* enum */ dc UNKNOWN_EMOTE = new dc("UNKNOWN_EMOTE", 1);
    public static final /* enum */ dc CANCELLED = new dc("CANCELLED", 2);
    private static final /* synthetic */ dc[] $VALUES;

    public static dc[] values() {
        return (dc[])$VALUES.clone();
    }

    public static dc valueOf(String string) {
        return Enum.valueOf(dc.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private dc() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ dc[] dw() {
        return new dc[]{PLAY, UNKNOWN_EMOTE, CANCELLED};
    }

    static {
        $VALUES = dc.dw();
    }
}
