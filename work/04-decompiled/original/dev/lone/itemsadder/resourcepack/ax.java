package dev.lone.itemsadder.resourcepack;

public final class ax
extends Enum {
    public static final /* enum */ ax SERVER_SENT = new ax("SERVER_SENT", 0);
    public static final /* enum */ ax PLAYER_DOWNLOADING = new ax("PLAYER_DOWNLOADING", 1);
    public static final /* enum */ ax DECLINED = new ax("DECLINED", 2);
    public static final /* enum */ ax FAILED_DOWNLOAD = new ax("FAILED_DOWNLOAD", 3);
    public static final /* enum */ ax INSTALLED = new ax("INSTALLED", 4);
    public static final /* enum */ ax NONE = new ax("NONE", 5);
    private static final /* synthetic */ ax[] $VALUES;

    public static ax[] values() {
        return (ax[])$VALUES.clone();
    }

    public static ax valueOf(String string) {
        return Enum.valueOf(ax.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ax() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ ax[] zC() {
        return new ax[]{SERVER_SENT, PLAYER_DOWNLOADING, DECLINED, FAILED_DOWNLOAD, INSTALLED, NONE};
    }

    static {
        $VALUES = ax.zC();
    }
}
