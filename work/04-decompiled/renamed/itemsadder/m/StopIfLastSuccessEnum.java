package itemsadder.m;

public final class StopIfLastSuccessEnum
extends Enum {
    public static final /* enum */ StopIfLastSuccessEnum STOP_IF_LAST_SUCCESS = new StopIfLastSuccessEnum("STOP_IF_LAST_SUCCESS", 0, "flow.stop_if_last_success");
    public static final /* enum */ StopIfLastSuccessEnum STOP_IF_LAST_FAIL = new StopIfLastSuccessEnum("STOP_IF_LAST_FAIL", 1, "flow.stop_if_last_fail");
    public static final /* enum */ StopIfLastSuccessEnum SKIP_IF_LAST_SUCCESS = new StopIfLastSuccessEnum("SKIP_IF_LAST_SUCCESS", 2, "flow.skip_if_last_success");
    public static final /* enum */ StopIfLastSuccessEnum SKIP_IF_LAST_FAIL = new StopIfLastSuccessEnum("SKIP_IF_LAST_FAIL", 3, "flow.skip_if_last_fail");
    public static final /* enum */ StopIfLastSuccessEnum STOP_IF_ANY_SUCCESS = new StopIfLastSuccessEnum("STOP_IF_ANY_SUCCESS", 4, "flow.stop_if_any_success");
    public static final /* enum */ StopIfLastSuccessEnum STOP_IF_ANY_FAIL = new StopIfLastSuccessEnum("STOP_IF_ANY_FAIL", 5, "flow.stop_if_any_fail");
    public static final /* enum */ StopIfLastSuccessEnum SKIP_IF_ANY_SUCCESS = new StopIfLastSuccessEnum("SKIP_IF_ANY_SUCCESS", 6, "flow.skip_if_any_success");
    public static final /* enum */ StopIfLastSuccessEnum SKIP_IF_ANY_FAIL = new StopIfLastSuccessEnum("SKIP_IF_ANY_FAIL", 7, "flow.skip_if_any_fail");
    public static final /* enum */ StopIfLastSuccessEnum STOP_IF_SUCCESS = new StopIfLastSuccessEnum("STOP_IF_SUCCESS", 8, "flow.stop_if_success");
    public static final /* enum */ StopIfLastSuccessEnum STOP_IF_FAIL = new StopIfLastSuccessEnum("STOP_IF_FAIL", 9, "flow.stop_if_fail");
    public static final /* enum */ StopIfLastSuccessEnum SKIP_IF_SUCCESS = new StopIfLastSuccessEnum("SKIP_IF_SUCCESS", 10, "flow.skip_if_success");
    public static final /* enum */ StopIfLastSuccessEnum SKIP_IF_FAIL = new StopIfLastSuccessEnum("SKIP_IF_FAIL", 11, "flow.skip_if_fail");
    public final String key;
    private static final /* synthetic */ StopIfLastSuccessEnum[] $VALUES;

    public static StopIfLastSuccessEnum[] values() {
        return (StopIfLastSuccessEnum[])$VALUES.clone();
    }

    public static StopIfLastSuccessEnum valueOf(String string) {
        return Enum.valueOf(StopIfLastSuccessEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private StopIfLastSuccessEnum() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.key = var3_2;
    }

    private static /* synthetic */ StopIfLastSuccessEnum[] kz() {
        return new StopIfLastSuccessEnum[]{STOP_IF_LAST_SUCCESS, STOP_IF_LAST_FAIL, SKIP_IF_LAST_SUCCESS, SKIP_IF_LAST_FAIL, STOP_IF_ANY_SUCCESS, STOP_IF_ANY_FAIL, SKIP_IF_ANY_SUCCESS, SKIP_IF_ANY_FAIL, STOP_IF_SUCCESS, STOP_IF_FAIL, SKIP_IF_SUCCESS, SKIP_IF_FAIL};
    }

    static {
        $VALUES = StopIfLastSuccessEnum.kz();
    }
}
