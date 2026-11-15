package itemsadder.m;

public final class zx
extends Enum {
    public static final /* enum */ zx SERVER_JAR = new zx("SERVER_JAR", 0);
    public static final /* enum */ zx ANOTHER_JAR = new zx("ANOTHER_JAR", 1);
    public static final /* enum */ zx NOT_FOUND = new zx("NOT_FOUND", 2);
    private static final /* synthetic */ zx[] $VALUES;

    public static zx[] values() {
        return (zx[])$VALUES.clone();
    }

    public static zx valueOf(String string) {
        return Enum.valueOf(zx.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zx() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ zx[] ta() {
        return new zx[]{SERVER_JAR, ANOTHER_JAR, NOT_FOUND};
    }

    static {
        $VALUES = zx.ta();
    }
}
