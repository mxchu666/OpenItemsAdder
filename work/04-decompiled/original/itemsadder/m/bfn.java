package itemsadder.m;

final class bfn
extends Enum {
    public static final /* enum */ bfn WAITING = new bfn("WAITING", 0);
    public static final /* enum */ bfn RUNNING_NO_TASKS = new bfn("RUNNING_NO_TASKS", 1);
    public static final /* enum */ bfn RUNNING_GOT_TASKS = new bfn("RUNNING_GOT_TASKS", 2);
    private static final /* synthetic */ bfn[] $VALUES;

    public static bfn[] values() {
        return (bfn[])$VALUES.clone();
    }

    public static bfn valueOf(String string) {
        return Enum.valueOf(bfn.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private bfn() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ bfn[] Eq() {
        return new bfn[]{WAITING, RUNNING_NO_TASKS, RUNNING_GOT_TASKS};
    }

    static {
        $VALUES = bfn.Eq();
    }
}
