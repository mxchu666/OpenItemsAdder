package itemsadder.m;

public final class ReplaceEnum
extends Enum {
    public static final /* enum */ ReplaceEnum REPLACE = new ReplaceEnum("REPLACE", 0);
    public static final /* enum */ ReplaceEnum SPAWN_NEAR = new ReplaceEnum("SPAWN_NEAR", 1);
    private static final /* synthetic */ ReplaceEnum[] $VALUES;

    public static ReplaceEnum[] values() {
        return (ReplaceEnum[])$VALUES.clone();
    }

    public static ReplaceEnum valueOf(String string) {
        return Enum.valueOf(ReplaceEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ReplaceEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ ReplaceEnum[] dS() {
        return new ReplaceEnum[]{REPLACE, SPAWN_NEAR};
    }

    static {
        $VALUES = ReplaceEnum.dS();
    }
}
