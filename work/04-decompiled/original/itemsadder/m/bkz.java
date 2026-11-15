package itemsadder.m;

import itemsadder.m.bky;
import itemsadder.m.bla;
import itemsadder.m.blb;
import itemsadder.m.blc;
import itemsadder.m.bld;
import itemsadder.m.ble;

public class bkz
extends Enum {
    public static final /* enum */ bkz DOUBLE = new bkz("DOUBLE", 0, ble.DOUBLE, 1);
    public static final /* enum */ bkz FLOAT = new bkz("FLOAT", 1, ble.FLOAT, 5);
    public static final /* enum */ bkz INT64 = new bkz("INT64", 2, ble.LONG, 0);
    public static final /* enum */ bkz UINT64 = new bkz("UINT64", 3, ble.LONG, 0);
    public static final /* enum */ bkz INT32 = new bkz("INT32", 4, ble.INT, 0);
    public static final /* enum */ bkz FIXED64 = new bkz("FIXED64", 5, ble.LONG, 1);
    public static final /* enum */ bkz FIXED32 = new bkz("FIXED32", 6, ble.INT, 5);
    public static final /* enum */ bkz BOOL = new bkz("BOOL", 7, ble.BOOLEAN, 0);
    public static final /* enum */ bkz STRING = new bla(ble.STRING, 2);
    public static final /* enum */ bkz GROUP = new blb(ble.MESSAGE, 3);
    public static final /* enum */ bkz MESSAGE = new blc(ble.MESSAGE, 2);
    public static final /* enum */ bkz BYTES = new bld(ble.BYTE_STRING, 2);
    public static final /* enum */ bkz UINT32 = new bkz("UINT32", 12, ble.INT, 0);
    public static final /* enum */ bkz ENUM = new bkz("ENUM", 13, ble.ENUM, 0);
    public static final /* enum */ bkz SFIXED32 = new bkz("SFIXED32", 14, ble.INT, 5);
    public static final /* enum */ bkz SFIXED64 = new bkz("SFIXED64", 15, ble.LONG, 1);
    public static final /* enum */ bkz SINT32 = new bkz("SINT32", 16, ble.INT, 0);
    public static final /* enum */ bkz SINT64 = new bkz("SINT64", 17, ble.LONG, 0);
    public final ble javaType;
    public final int wireType;
    private static final /* synthetic */ bkz[] $VALUES;

    public static bkz[] values() {
        return (bkz[])$VALUES.clone();
    }

    public static bkz valueOf(String string) {
        return Enum.valueOf(bkz.class, string);
    }

    /*
     * WARNING - void declaration
     */
    private bkz() {
        void var4_1;
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.javaType = var3_2;
        this.wireType = var4_1;
    }

    public ble Gz() {
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
    /* synthetic */ bkz(ble ble2, int n, bky bky2) {
        this((String)var1_-1, n, (ble)((Object)bky2), (int)var4_3);
        void var4_3;
        void var1_-1;
    }

    static {
        $VALUES = new bkz[]{DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, GROUP, MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64};
    }
}
