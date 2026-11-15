package itemsadder.m;

public final class LobfileEnum
extends Enum {
    public static final /* enum */ LobfileEnum LOBFILE = new LobfileEnum("LOBFILE", 0);
    public static final /* enum */ LobfileEnum AUTO_EXTERNAL_LEGACY = new LobfileEnum("AUTO_EXTERNAL_LEGACY", 1);
    public static final /* enum */ LobfileEnum EXTERNAL = new LobfileEnum("EXTERNAL", 2);
    public static final /* enum */ LobfileEnum SIMPLE_SELF_HOST = new LobfileEnum("SIMPLE_SELF_HOST", 3);
    public static final /* enum */ LobfileEnum SELF_HOST = new LobfileEnum("SELF_HOST", 4);
    public static final /* enum */ LobfileEnum NO_HOST = new LobfileEnum("NO_HOST", 5);
    public static final /* enum */ LobfileEnum UNKNOWN = new LobfileEnum("UNKNOWN", 6);
    private static final /* synthetic */ LobfileEnum[] $VALUES;

    public static LobfileEnum[] values() {
        return (LobfileEnum[])$VALUES.clone();
    }

    public static LobfileEnum valueOf(String string) {
        return Enum.valueOf(LobfileEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LobfileEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ LobfileEnum[] as() {
        return new LobfileEnum[]{LOBFILE, AUTO_EXTERNAL_LEGACY, EXTERNAL, SIMPLE_SELF_HOST, SELF_HOST, NO_HOST, UNKNOWN};
    }

    static {
        $VALUES = LobfileEnum.as();
    }
}
