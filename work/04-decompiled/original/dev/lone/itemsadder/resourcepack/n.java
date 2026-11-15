package dev.lone.itemsadder.resourcepack;

final class n
extends Enum {
    public static final /* enum */ n ITEMSADDER_GENERATED = new n("ITEMSADDER_GENERATED", 0, "ItemsAdder generated");
    public static final /* enum */ n ITEMSADDER_BUNDLED = new n("ITEMSADDER_BUNDLED", 1, "ItemsAdder bundled");
    public static final /* enum */ n USER_CONTENT_PACK = new n("USER_CONTENT_PACK", 2, "user content pack");
    public static final /* enum */ n EXTERNAL_RESOURCE_PACK = new n("EXTERNAL_RESOURCE_PACK", 3, "external or third-party resource pack");
    public static final /* enum */ n EVENT_STREAM_OR_WRITER = new n("EVENT_STREAM_OR_WRITER", 4, "added by pack event, stream, or writer");
    public static final /* enum */ n VANILLA_CLIENT_ASSET = new n("VANILLA_CLIENT_ASSET", 5, "Vanilla client asset");
    public static final /* enum */ n UNKNOWN = new n("UNKNOWN", 6, "source could not be determined");
    private final String label;
    private static final /* synthetic */ n[] $VALUES;

    public static n[] values() {
        return (n[])$VALUES.clone();
    }

    public static n valueOf(String string) {
        return Enum.valueOf(n.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private n() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.label = var3_2;
    }

    String xZ() {
        return this.label;
    }

    boolean ya() {
        return this == ITEMSADDER_GENERATED || this == ITEMSADDER_BUNDLED;
    }

    boolean yb() {
        return !this.ya() && this != VANILLA_CLIENT_ASSET;
    }

    private static /* synthetic */ n[] yc() {
        return new n[]{ITEMSADDER_GENERATED, ITEMSADDER_BUNDLED, USER_CONTENT_PACK, EXTERNAL_RESOURCE_PACK, EVENT_STREAM_OR_WRITER, VANILLA_CLIENT_ASSET, UNKNOWN};
    }

    static {
        $VALUES = n.yc();
    }
}
