package itemsadder.m;

import itemsadder.m.DoubleEnumImpl;
import itemsadder.m.DoubleEnumImpl_2;
import itemsadder.m.DoubleEnumImpl_3;
import itemsadder.m.DoubleEnumImpl_4;
import itemsadder.m.IntEnum;
import itemsadder.m.Opaque104;

public class DoubleEnum
extends Enum {
    public static final /* enum */ DoubleEnum DOUBLE = new DoubleEnum("DOUBLE", 0, IntEnum.DOUBLE, 1);
    public static final /* enum */ DoubleEnum FLOAT = new DoubleEnum("FLOAT", 1, IntEnum.FLOAT, 5);
    public static final /* enum */ DoubleEnum INT64 = new DoubleEnum("INT64", 2, IntEnum.LONG, 0);
    public static final /* enum */ DoubleEnum UINT64 = new DoubleEnum("UINT64", 3, IntEnum.LONG, 0);
    public static final /* enum */ DoubleEnum INT32 = new DoubleEnum("INT32", 4, IntEnum.INT, 0);
    public static final /* enum */ DoubleEnum FIXED64 = new DoubleEnum("FIXED64", 5, IntEnum.LONG, 1);
    public static final /* enum */ DoubleEnum FIXED32 = new DoubleEnum("FIXED32", 6, IntEnum.INT, 5);
    public static final /* enum */ DoubleEnum BOOL = new DoubleEnum("BOOL", 7, IntEnum.BOOLEAN, 0);
    public static final /* enum */ DoubleEnum STRING = new DoubleEnumImpl(IntEnum.STRING, 2);
    public static final /* enum */ DoubleEnum GROUP = new DoubleEnumImpl_2(IntEnum.MESSAGE, 3);
    public static final /* enum */ DoubleEnum MESSAGE = new DoubleEnumImpl_3(IntEnum.MESSAGE, 2);
    public static final /* enum */ DoubleEnum BYTES = new DoubleEnumImpl_4(IntEnum.BYTE_STRING, 2);
    public static final /* enum */ DoubleEnum UINT32 = new DoubleEnum("UINT32", 12, IntEnum.INT, 0);
    public static final /* enum */ DoubleEnum ENUM = new DoubleEnum("ENUM", 13, IntEnum.ENUM, 0);
    public static final /* enum */ DoubleEnum SFIXED32 = new DoubleEnum("SFIXED32", 14, IntEnum.INT, 5);
    public static final /* enum */ DoubleEnum SFIXED64 = new DoubleEnum("SFIXED64", 15, IntEnum.LONG, 1);
    public static final /* enum */ DoubleEnum SINT32 = new DoubleEnum("SINT32", 16, IntEnum.INT, 0);
    public static final /* enum */ DoubleEnum SINT64 = new DoubleEnum("SINT64", 17, IntEnum.LONG, 0);
    public final IntEnum javaType;
    public final int wireType;
    private static final /* synthetic */ DoubleEnum[] $VALUES;

    public static DoubleEnum[] values() {
        return (DoubleEnum[])$VALUES.clone();
    }

    public static DoubleEnum valueOf(String string) {
        return Enum.valueOf(DoubleEnum.class, string);
    }

    /*
     * WARNING - void declaration
     */
    private DoubleEnum() {
        void var4_1;
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.javaType = var3_2;
        this.wireType = var4_1;
    }

    public IntEnum Gz() {
        return this.javaType;
    }

    public int GA() {
        return this.wireType;
    }

    public boolean GB() {
        return true;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    /* synthetic */ DoubleEnum(IntEnum intEnum, int n, Opaque104 opaque104) {
        this((String)var1_-1, n, (IntEnum)((Object)opaque104), (int)var4_3);
        void var4_3;
        void var1_-1;
    }

    static {
        $VALUES = new DoubleEnum[]{DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, GROUP, MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64};
    }
}
