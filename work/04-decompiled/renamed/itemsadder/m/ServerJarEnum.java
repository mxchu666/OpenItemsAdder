package itemsadder.m;

public final class ServerJarEnum
extends Enum {
    public static final /* enum */ ServerJarEnum SERVER_JAR = new ServerJarEnum("SERVER_JAR", 0);
    public static final /* enum */ ServerJarEnum ANOTHER_JAR = new ServerJarEnum("ANOTHER_JAR", 1);
    public static final /* enum */ ServerJarEnum NOT_FOUND = new ServerJarEnum("NOT_FOUND", 2);
    private static final /* synthetic */ ServerJarEnum[] $VALUES;

    public static ServerJarEnum[] values() {
        return (ServerJarEnum[])$VALUES.clone();
    }

    public static ServerJarEnum valueOf(String string) {
        return Enum.valueOf(ServerJarEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ServerJarEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ ServerJarEnum[] ta() {
        return new ServerJarEnum[]{SERVER_JAR, ANOTHER_JAR, NOT_FOUND};
    }

    static {
        $VALUES = ServerJarEnum.ta();
    }
}
