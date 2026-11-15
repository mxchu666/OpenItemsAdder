package itemsadder.m;

public final class zy
extends Enum {
    public static final /* enum */ zy PUBLIC = new zy("PUBLIC", 0);
    public static final /* enum */ zy PROTECTED = new zy("PROTECTED", 1);
    public static final /* enum */ zy PRIVATE = new zy("PRIVATE", 2);
    public static final /* enum */ zy PACKAGE_PRIVATE = new zy("PACKAGE_PRIVATE", 3);
    private static final /* synthetic */ zy[] $VALUES;

    public static zy[] values() {
        return (zy[])$VALUES.clone();
    }

    public static zy valueOf(String string) {
        return Enum.valueOf(zy.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zy() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ zy[] tb() {
        return new zy[]{PUBLIC, PROTECTED, PRIVATE, PACKAGE_PRIVATE};
    }

    static {
        $VALUES = zy.tb();
    }
}
