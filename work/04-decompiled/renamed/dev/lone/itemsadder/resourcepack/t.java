package dev.lone.itemsadder.resourcepack;

final class t
extends Enum {
    public static final /* enum */ t USER_CONTENT = new t("USER_CONTENT", 0);
    public static final /* enum */ t EXTERNAL_PACK = new t("EXTERNAL_PACK", 1);
    public static final /* enum */ t BUNDLED = new t("BUNDLED", 2);
    public static final /* enum */ t GENERATED = new t("GENERATED", 3);
    public static final /* enum */ t STREAM = new t("STREAM", 4);
    public static final /* enum */ t WRITER = new t("WRITER", 5);
    public static final /* enum */ t UNKNOWN = new t("UNKNOWN", 6);
    private static final /* synthetic */ t[] $VALUES;

    public static t[] values() {
        return (t[])$VALUES.clone();
    }

    public static t valueOf(String string) {
        return Enum.valueOf(t.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private t() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ t[] yp() {
        return new t[]{USER_CONTENT, EXTERNAL_PACK, BUNDLED, GENERATED, STREAM, WRITER, UNKNOWN};
    }

    static {
        $VALUES = t.yp();
    }
}
