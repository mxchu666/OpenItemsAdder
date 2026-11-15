package itemsadder.m;

public final class pb
extends Enum {
    public static final /* enum */ pb SUCCESS = new pb("SUCCESS", 0);
    public static final /* enum */ pb FAILED = new pb("FAILED", 1);
    private static final /* synthetic */ pb[] $VALUES;

    public static pb[] values() {
        return (pb[])$VALUES.clone();
    }

    public static pb valueOf(String string) {
        return Enum.valueOf(pb.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private pb() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ pb[] mm() {
        return new pb[]{SUCCESS, FAILED};
    }

    static {
        $VALUES = pb.mm();
    }
}
