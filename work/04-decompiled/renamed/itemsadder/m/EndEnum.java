package itemsadder.m;

public final class EndEnum
extends Enum {
    public static final /* enum */ EndEnum End = new EndEnum("End", 0, 0);
    public static final /* enum */ EndEnum Byte = new EndEnum("Byte", 1, 1);
    public static final /* enum */ EndEnum Short = new EndEnum("Short", 2, 2);
    public static final /* enum */ EndEnum Int = new EndEnum("Int", 3, 3);
    public static final /* enum */ EndEnum Long = new EndEnum("Long", 4, 4);
    public static final /* enum */ EndEnum Float = new EndEnum("Float", 5, 5);
    public static final /* enum */ EndEnum Double = new EndEnum("Double", 6, 6);
    public static final /* enum */ EndEnum ByteArray = new EndEnum("ByteArray", 7, 7);
    public static final /* enum */ EndEnum String = new EndEnum("String", 8, 8);
    public static final /* enum */ EndEnum List = new EndEnum("List", 9, 9);
    public static final /* enum */ EndEnum Compound = new EndEnum("Compound", 10, 10);
    public static final /* enum */ EndEnum IntArray = new EndEnum("IntArray", 11, 11);
    public static final /* enum */ EndEnum LongArray = new EndEnum("LongArray", 12, 12);
    private final int id;
    private static final /* synthetic */ EndEnum[] $VALUES;

    public static EndEnum[] values() {
        return (EndEnum[])$VALUES.clone();
    }

    public static EndEnum valueOf(String string) {
        return Enum.valueOf(EndEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EndEnum() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.id = var3_2;
    }

    public int getId() {
        return this.id;
    }

    public static EndEnum ax(int n) {
        for (EndEnum endEnum : EndEnum.values()) {
            if (endEnum.getId() != n) continue;
            return endEnum;
        }
        return End;
    }

    private static /* synthetic */ EndEnum[] qE() {
        return new EndEnum[]{End, Byte, Short, Int, Long, Float, Double, ByteArray, String, List, Compound, IntArray, LongArray};
    }

    static {
        $VALUES = EndEnum.qE();
    }
}
