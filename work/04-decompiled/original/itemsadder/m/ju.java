package itemsadder.m;

public final class ju
extends Enum {
    public static final /* enum */ ju ARMOR_STAND = new ju("ARMOR_STAND", 0);
    public static final /* enum */ ju SMALL_ARMOR_STAND = new ju("SMALL_ARMOR_STAND", 1);
    public static final /* enum */ ju ITEM_FRAME = new ju("ITEM_FRAME", 2);
    private static final /* synthetic */ ju[] $VALUES;

    public static ju[] values() {
        return (ju[])$VALUES.clone();
    }

    public static ju valueOf(String string) {
        return Enum.valueOf(ju.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ju() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ ju[] kO() {
        return new ju[]{ARMOR_STAND, SMALL_ARMOR_STAND, ITEM_FRAME};
    }

    static {
        $VALUES = ju.kO();
    }
}
