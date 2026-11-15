package itemsadder.m;

public final class rs
extends Enum {
    public static final /* enum */ rs REPLACE = new rs("REPLACE", 0);
    public static final /* enum */ rs MERGE = new rs("MERGE", 1);
    private static final /* synthetic */ rs[] $VALUES;

    public static rs[] values() {
        return (rs[])$VALUES.clone();
    }

    public static rs valueOf(String string) {
        return Enum.valueOf(rs.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private rs() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ rs[] oH() {
        return new rs[]{REPLACE, MERGE};
    }

    static {
        $VALUES = rs.oH();
    }
}
