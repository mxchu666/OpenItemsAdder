package itemsadder.m;

final class WaitingEnum
extends Enum {
    public static final /* enum */ WaitingEnum WAITING = new WaitingEnum("WAITING", 0);
    public static final /* enum */ WaitingEnum RUNNING_NO_TASKS = new WaitingEnum("RUNNING_NO_TASKS", 1);
    public static final /* enum */ WaitingEnum RUNNING_GOT_TASKS = new WaitingEnum("RUNNING_GOT_TASKS", 2);
    private static final /* synthetic */ WaitingEnum[] $VALUES;

    public static WaitingEnum[] values() {
        return (WaitingEnum[])$VALUES.clone();
    }

    public static WaitingEnum valueOf(String string) {
        return Enum.valueOf(WaitingEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private WaitingEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ WaitingEnum[] Eq() {
        return new WaitingEnum[]{WAITING, RUNNING_NO_TASKS, RUNNING_GOT_TASKS};
    }

    static {
        $VALUES = WaitingEnum.Eq();
    }
}
