package itemsadder.m;

public final class SuccessEnum_2
extends Enum {
    public static final /* enum */ SuccessEnum_2 SUCCESS = new SuccessEnum_2("SUCCESS", 0);
    public static final /* enum */ SuccessEnum_2 FAILED = new SuccessEnum_2("FAILED", 1);
    private static final /* synthetic */ SuccessEnum_2[] $VALUES;

    public static SuccessEnum_2[] values() {
        return (SuccessEnum_2[])$VALUES.clone();
    }

    public static SuccessEnum_2 valueOf(String string) {
        return Enum.valueOf(SuccessEnum_2.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SuccessEnum_2() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ SuccessEnum_2[] mm() {
        return new SuccessEnum_2[]{SUCCESS, FAILED};
    }

    static {
        $VALUES = SuccessEnum_2.mm();
    }
}
