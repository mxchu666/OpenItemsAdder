package itemsadder.m;

public final class oo
extends Enum {
    public static final /* enum */ oo RELATIVE = new oo("RELATIVE", 0);
    public static final /* enum */ oo CLICKED = new oo("CLICKED", 1);
    private static final /* synthetic */ oo[] $VALUES;

    public static oo[] values() {
        return (oo[])$VALUES.clone();
    }

    public static oo valueOf(String string) {
        return Enum.valueOf(oo.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private oo() {
        void var2_-1;
        void var1_-1;
    }

    public static oo bv(String string) {
        switch (string) {
            case "RELATIVE": {
                return RELATIVE;
            }
            case "CLICKED": {
                return CLICKED;
            }
        }
        return CLICKED;
    }

    private static /* synthetic */ oo[] mg() {
        return new oo[]{RELATIVE, CLICKED};
    }

    static {
        $VALUES = oo.mg();
    }
}
