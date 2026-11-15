package itemsadder.m;

public final class PlayEnum
extends Enum {
    public static final /* enum */ PlayEnum PLAY = new PlayEnum("PLAY", 0);
    public static final /* enum */ PlayEnum UNKNOWN_EMOTE = new PlayEnum("UNKNOWN_EMOTE", 1);
    public static final /* enum */ PlayEnum CANCELLED = new PlayEnum("CANCELLED", 2);
    private static final /* synthetic */ PlayEnum[] $VALUES;

    public static PlayEnum[] values() {
        return (PlayEnum[])$VALUES.clone();
    }

    public static PlayEnum valueOf(String string) {
        return Enum.valueOf(PlayEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PlayEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ PlayEnum[] dw() {
        return new PlayEnum[]{PLAY, UNKNOWN_EMOTE, CANCELLED};
    }

    static {
        $VALUES = PlayEnum.dw();
    }
}
