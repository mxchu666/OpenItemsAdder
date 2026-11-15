package itemsadder.m;

public final class arp
extends Enum {
    public static final /* enum */ arp NOTHING = new arp("NOTHING", 0);
    public static final /* enum */ arp MATCHED_BLOCK = new arp("MATCHED_BLOCK", 1);
    public static final /* enum */ arp ANOTHER_BLOCK = new arp("ANOTHER_BLOCK", 2);
    private static final /* synthetic */ arp[] $VALUES;

    public static arp[] values() {
        return (arp[])$VALUES.clone();
    }

    public static arp valueOf(String string) {
        return Enum.valueOf(arp.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private arp() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ arp[] vi() {
        return new arp[]{NOTHING, MATCHED_BLOCK, ANOTHER_BLOCK};
    }

    static {
        $VALUES = arp.vi();
    }
}
