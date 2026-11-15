package itemsadder.m;

public final class EqualEnum
extends Enum {
    public static final /* enum */ EqualEnum EQUAL = new EqualEnum("EQUAL", 0);
    public static final /* enum */ EqualEnum LESS = new EqualEnum("LESS", 1);
    public static final /* enum */ EqualEnum MORE = new EqualEnum("MORE", 2);
    public static final /* enum */ EqualEnum MORE_EQUAL = new EqualEnum("MORE_EQUAL", 3);
    public static final /* enum */ EqualEnum LESS_EQUAL = new EqualEnum("LESS_EQUAL", 4);
    private static final /* synthetic */ EqualEnum[] $VALUES;

    public static EqualEnum[] values() {
        return (EqualEnum[])$VALUES.clone();
    }

    public static EqualEnum valueOf(String string) {
        return Enum.valueOf(EqualEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EqualEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ EqualEnum[] kj() {
        return new EqualEnum[]{EQUAL, LESS, MORE, MORE_EQUAL, LESS_EQUAL};
    }

    static {
        $VALUES = EqualEnum.kj();
    }
}
