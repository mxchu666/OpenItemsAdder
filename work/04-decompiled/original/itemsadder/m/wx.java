package itemsadder.m;

public final class wx
extends Enum {
    public static final /* enum */ wx SURFACE = new wx("SURFACE", 0);
    public static final /* enum */ wx CEILING = new wx("CEILING", 1);
    private static final /* synthetic */ wx[] $VALUES;

    public static wx[] values() {
        return (wx[])$VALUES.clone();
    }

    public static wx valueOf(String string) {
        return Enum.valueOf(wx.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private wx() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ wx[] rO() {
        return new wx[]{SURFACE, CEILING};
    }

    static {
        $VALUES = wx.rO();
    }
}
