package itemsadder.m;

public final class dk
extends Enum {
    public static final /* enum */ dk REPLACE = new dk("REPLACE", 0);
    public static final /* enum */ dk SPAWN_NEAR = new dk("SPAWN_NEAR", 1);
    private static final /* synthetic */ dk[] $VALUES;

    public static dk[] values() {
        return (dk[])$VALUES.clone();
    }

    public static dk valueOf(String string) {
        return Enum.valueOf(dk.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private dk() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ dk[] dS() {
        return new dk[]{REPLACE, SPAWN_NEAR};
    }

    static {
        $VALUES = dk.dS();
    }
}
