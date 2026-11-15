package itemsadder.m;

public final class NothingEnum
extends Enum {
    public static final /* enum */ NothingEnum NOTHING = new NothingEnum("NOTHING", 0);
    public static final /* enum */ NothingEnum MATCHED_BLOCK = new NothingEnum("MATCHED_BLOCK", 1);
    public static final /* enum */ NothingEnum ANOTHER_BLOCK = new NothingEnum("ANOTHER_BLOCK", 2);
    private static final /* synthetic */ NothingEnum[] $VALUES;

    public static NothingEnum[] values() {
        return (NothingEnum[])$VALUES.clone();
    }

    public static NothingEnum valueOf(String string) {
        return Enum.valueOf(NothingEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private NothingEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ NothingEnum[] vi() {
        return new NothingEnum[]{NOTHING, MATCHED_BLOCK, ANOTHER_BLOCK};
    }

    static {
        $VALUES = NothingEnum.vi();
    }
}
