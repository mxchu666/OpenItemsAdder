package itemsadder.m;

public final class rg
extends Enum {
    public static final /* enum */ rg BLOCK = new rg("BLOCK", 0, "BLOCK");
    public static final /* enum */ rg ITEM = new rg("ITEM", 1, "ITEM");
    public static final /* enum */ rg VANILLA = new rg("VANILLA", 2, "VANILLA");
    private final String text;
    private static final /* synthetic */ rg[] $VALUES;

    public static rg[] values() {
        return (rg[])$VALUES.clone();
    }

    public static rg valueOf(String string) {
        return Enum.valueOf(rg.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private rg() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.text = var3_2;
    }

    public String toString() {
        return this.text;
    }

    private static /* synthetic */ rg[] nR() {
        return new rg[]{BLOCK, ITEM, VANILLA};
    }

    static {
        $VALUES = rg.nR();
    }
}
