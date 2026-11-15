package itemsadder.m;

public final class SuccessEnum
extends Enum {
    public static final /* enum */ SuccessEnum SUCCESS = new SuccessEnum("SUCCESS", 0);
    public static final /* enum */ SuccessEnum FAILED = new SuccessEnum("FAILED", 1);
    private static final /* synthetic */ SuccessEnum[] $VALUES;

    public static SuccessEnum[] values() {
        return (SuccessEnum[])$VALUES.clone();
    }

    public static SuccessEnum valueOf(String string) {
        return Enum.valueOf(SuccessEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SuccessEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ SuccessEnum[] aP() {
        return new SuccessEnum[]{SUCCESS, FAILED};
    }

    static {
        $VALUES = SuccessEnum.aP();
    }
}
