package itemsadder.m;

public final class yz
extends Enum {
    public static final /* enum */ yz ALL = new yz("ALL", 0);
    public static final /* enum */ yz NONE = new yz("NONE", 1);
    public static final /* enum */ yz SELF = new yz("SELF", 2);
    private static final /* synthetic */ yz[] $VALUES;

    public static yz[] values() {
        return (yz[])$VALUES.clone();
    }

    public static yz valueOf(String string) {
        return Enum.valueOf(yz.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private yz() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ yz[] sv() {
        return new yz[]{ALL, NONE, SELF};
    }

    static {
        $VALUES = yz.sv();
    }
}
