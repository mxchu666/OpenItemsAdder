package itemsadder.m;

public final class uk
extends Enum {
    public static final /* enum */ uk End = new uk("End", 0, 0);
    public static final /* enum */ uk Byte = new uk("Byte", 1, 1);
    public static final /* enum */ uk Short = new uk("Short", 2, 2);
    public static final /* enum */ uk Int = new uk("Int", 3, 3);
    public static final /* enum */ uk Long = new uk("Long", 4, 4);
    public static final /* enum */ uk Float = new uk("Float", 5, 5);
    public static final /* enum */ uk Double = new uk("Double", 6, 6);
    public static final /* enum */ uk ByteArray = new uk("ByteArray", 7, 7);
    public static final /* enum */ uk String = new uk("String", 8, 8);
    public static final /* enum */ uk List = new uk("List", 9, 9);
    public static final /* enum */ uk Compound = new uk("Compound", 10, 10);
    public static final /* enum */ uk IntArray = new uk("IntArray", 11, 11);
    public static final /* enum */ uk LongArray = new uk("LongArray", 12, 12);
    private final int id;
    private static final /* synthetic */ uk[] $VALUES;

    public static uk[] values() {
        return (uk[])$VALUES.clone();
    }

    public static uk valueOf(String string) {
        return Enum.valueOf(uk.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private uk() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.id = var3_2;
    }

    public int getId() {
        return this.id;
    }

    public static uk ax(int n) {
        for (uk uk2 : uk.values()) {
            if (uk2.getId() != n) continue;
            return uk2;
        }
        return End;
    }

    private static /* synthetic */ uk[] qE() {
        return new uk[]{End, Byte, Short, Int, Long, Float, Double, ByteArray, String, List, Compound, IntArray, LongArray};
    }

    static {
        $VALUES = uk.qE();
    }
}
