package itemsadder.m;

public final class ji
extends Enum {
    public static final /* enum */ ji STOP_IF_LAST_SUCCESS = new ji("STOP_IF_LAST_SUCCESS", 0, "flow.stop_if_last_success");
    public static final /* enum */ ji STOP_IF_LAST_FAIL = new ji("STOP_IF_LAST_FAIL", 1, "flow.stop_if_last_fail");
    public static final /* enum */ ji SKIP_IF_LAST_SUCCESS = new ji("SKIP_IF_LAST_SUCCESS", 2, "flow.skip_if_last_success");
    public static final /* enum */ ji SKIP_IF_LAST_FAIL = new ji("SKIP_IF_LAST_FAIL", 3, "flow.skip_if_last_fail");
    public static final /* enum */ ji STOP_IF_ANY_SUCCESS = new ji("STOP_IF_ANY_SUCCESS", 4, "flow.stop_if_any_success");
    public static final /* enum */ ji STOP_IF_ANY_FAIL = new ji("STOP_IF_ANY_FAIL", 5, "flow.stop_if_any_fail");
    public static final /* enum */ ji SKIP_IF_ANY_SUCCESS = new ji("SKIP_IF_ANY_SUCCESS", 6, "flow.skip_if_any_success");
    public static final /* enum */ ji SKIP_IF_ANY_FAIL = new ji("SKIP_IF_ANY_FAIL", 7, "flow.skip_if_any_fail");
    public static final /* enum */ ji STOP_IF_SUCCESS = new ji("STOP_IF_SUCCESS", 8, "flow.stop_if_success");
    public static final /* enum */ ji STOP_IF_FAIL = new ji("STOP_IF_FAIL", 9, "flow.stop_if_fail");
    public static final /* enum */ ji SKIP_IF_SUCCESS = new ji("SKIP_IF_SUCCESS", 10, "flow.skip_if_success");
    public static final /* enum */ ji SKIP_IF_FAIL = new ji("SKIP_IF_FAIL", 11, "flow.skip_if_fail");
    public final String key;
    private static final /* synthetic */ ji[] $VALUES;

    public static ji[] values() {
        return (ji[])$VALUES.clone();
    }

    public static ji valueOf(String string) {
        return Enum.valueOf(ji.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ji() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.key = var3_2;
    }

    private static /* synthetic */ ji[] kz() {
        return new ji[]{STOP_IF_LAST_SUCCESS, STOP_IF_LAST_FAIL, SKIP_IF_LAST_SUCCESS, SKIP_IF_LAST_FAIL, STOP_IF_ANY_SUCCESS, STOP_IF_ANY_FAIL, SKIP_IF_ANY_SUCCESS, SKIP_IF_ANY_FAIL, STOP_IF_SUCCESS, STOP_IF_FAIL, SKIP_IF_SUCCESS, SKIP_IF_FAIL};
    }

    static {
        $VALUES = ji.kz();
    }
}
