package itemsadder.m;

public final class ReplaceEnum_2
extends Enum {
    public static final /* enum */ ReplaceEnum_2 REPLACE = new ReplaceEnum_2("REPLACE", 0);
    public static final /* enum */ ReplaceEnum_2 MERGE = new ReplaceEnum_2("MERGE", 1);
    private static final /* synthetic */ ReplaceEnum_2[] $VALUES;

    public static ReplaceEnum_2[] values() {
        return (ReplaceEnum_2[])$VALUES.clone();
    }

    public static ReplaceEnum_2 valueOf(String string) {
        return Enum.valueOf(ReplaceEnum_2.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ReplaceEnum_2() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ ReplaceEnum_2[] oH() {
        return new ReplaceEnum_2[]{REPLACE, MERGE};
    }

    static {
        $VALUES = ReplaceEnum_2.oH();
    }
}
