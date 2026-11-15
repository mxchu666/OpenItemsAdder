package itemsadder.m;

public final class q
extends Enum {
    public static final /* enum */ q REGEX = new q("REGEX", 0);
    public static final /* enum */ q WILDCARD = new q("WILDCARD", 1);
    public static final /* enum */ q EXACT = new q("EXACT", 2);
    private static final /* synthetic */ q[] $VALUES;

    public static q[] values() {
        return (q[])$VALUES.clone();
    }

    public static q valueOf(String string) {
        return Enum.valueOf(q.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private q() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ q[] Y() {
        return new q[]{REGEX, WILDCARD, EXACT};
    }

    static {
        $VALUES = q.Y();
    }
}
