package itemsadder.m;

public final class mt
extends Enum {
    public static final /* enum */ mt SAVED = new mt("SAVED", 0);
    public static final /* enum */ mt SAVED_CHUNK = new mt("SAVED_CHUNK", 1);
    private static final /* synthetic */ mt[] $VALUES;

    public static mt[] values() {
        return (mt[])$VALUES.clone();
    }

    public static mt valueOf(String string) {
        return Enum.valueOf(mt.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private mt() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ mt[] lZ() {
        return new mt[]{SAVED, SAVED_CHUNK};
    }

    static {
        $VALUES = mt.lZ();
    }
}
