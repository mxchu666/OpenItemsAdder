package itemsadder.m;

public final class AllEnum
extends Enum {
    public static final /* enum */ AllEnum ALL = new AllEnum("ALL", 0);
    public static final /* enum */ AllEnum NONE = new AllEnum("NONE", 1);
    public static final /* enum */ AllEnum SELF = new AllEnum("SELF", 2);
    private static final /* synthetic */ AllEnum[] $VALUES;

    public static AllEnum[] values() {
        return (AllEnum[])$VALUES.clone();
    }

    public static AllEnum valueOf(String string) {
        return Enum.valueOf(AllEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AllEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ AllEnum[] sv() {
        return new AllEnum[]{ALL, NONE, SELF};
    }

    static {
        $VALUES = AllEnum.sv();
    }
}
