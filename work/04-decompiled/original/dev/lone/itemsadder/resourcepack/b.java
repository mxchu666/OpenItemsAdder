package dev.lone.itemsadder.resourcepack;

final class b
extends Enum {
    public static final /* enum */ b BLOCK = new b("BLOCK", 0);
    public static final /* enum */ b ITEM = new b("ITEM", 1);
    public static final /* enum */ b ENTITY = new b("ENTITY", 2);
    private static final /* synthetic */ b[] $VALUES;

    public static b[] values() {
        return (b[])$VALUES.clone();
    }

    public static b valueOf(String string) {
        return Enum.valueOf(b.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private b() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ b[] xk() {
        return new b[]{BLOCK, ITEM, ENTITY};
    }

    static {
        $VALUES = b.xk();
    }
}
