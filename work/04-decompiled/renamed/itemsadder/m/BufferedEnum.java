package itemsadder.m;

import itemsadder.m.BufferedEnumImpl;
import itemsadder.m.BufferedEnumImpl_2;
import itemsadder.m.FluentBuilder_5;
import itemsadder.m.Opaque105;

public abstract class BufferedEnum
extends Enum {
    public static final /* enum */ BufferedEnum BUFFERED = new BufferedEnumImpl();
    public static final /* enum */ BufferedEnum STREAMED = new BufferedEnumImpl_2();
    private static final /* synthetic */ BufferedEnum[] $VALUES;

    public static BufferedEnum[] values() {
        return (BufferedEnum[])$VALUES.clone();
    }

    public static BufferedEnum valueOf(String string) {
        return Enum.valueOf(BufferedEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BufferedEnum() {
        void var2_-1;
        void var1_-1;
    }

    public abstract FluentBuilder_5 a(Opaque105 var1, FluentBuilder_5 var2);

    public final FluentBuilder_5 a(byte[] byArray, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return this.c(byArray, 0, byArray.length, opaque105, fluentBuilder_5);
    }

    public abstract FluentBuilder_5 c(byte[] var1, int var2, int var3, Opaque105 var4, FluentBuilder_5 var5);

    public final FluentBuilder_5 b(byte[] byArray, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return this.d(byArray, 0, byArray.length, opaque105, fluentBuilder_5);
    }

    public abstract FluentBuilder_5 d(byte[] var1, int var2, int var3, Opaque105 var4, FluentBuilder_5 var5);

    public abstract FluentBuilder_5 a(byte var1, Opaque105 var2, FluentBuilder_5 var3);

    public abstract FluentBuilder_5 c(int var1, Opaque105 var2, FluentBuilder_5 var3);

    public abstract FluentBuilder_5 b(long var1, Opaque105 var3, FluentBuilder_5 var4);

    public final FluentBuilder_5 b(float f, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return this.c(Float.floatToRawIntBits(f), opaque105, fluentBuilder_5);
    }

    public final FluentBuilder_5 b(double d, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return this.b(Double.doubleToRawLongBits(d), opaque105, fluentBuilder_5);
    }

    public abstract FluentBuilder_5 d(int var1, Opaque105 var2, FluentBuilder_5 var3);

    public abstract FluentBuilder_5 e(int var1, Opaque105 var2, FluentBuilder_5 var3);

    public abstract FluentBuilder_5 f(int var1, Opaque105 var2, FluentBuilder_5 var3);

    public abstract FluentBuilder_5 c(long var1, Opaque105 var3, FluentBuilder_5 var4);

    public final FluentBuilder_5 c(float f, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return this.f(Float.floatToRawIntBits(f), opaque105, fluentBuilder_5);
    }

    public final FluentBuilder_5 c(double d, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return this.c(Double.doubleToRawLongBits(d), opaque105, fluentBuilder_5);
    }

    public abstract FluentBuilder_5 g(int var1, Opaque105 var2, FluentBuilder_5 var3);

    public abstract FluentBuilder_5 d(long var1, Opaque105 var3, FluentBuilder_5 var4);

    public abstract FluentBuilder_5 h(int var1, Opaque105 var2, FluentBuilder_5 var3);

    public abstract FluentBuilder_5 e(long var1, Opaque105 var3, FluentBuilder_5 var4);

    public abstract FluentBuilder_5 d(float var1, Opaque105 var2, FluentBuilder_5 var3);

    public abstract FluentBuilder_5 d(double var1, Opaque105 var3, FluentBuilder_5 var4);

    public abstract FluentBuilder_5 e(CharSequence var1, Opaque105 var2, FluentBuilder_5 var3);

    public abstract FluentBuilder_5 f(CharSequence var1, Opaque105 var2, FluentBuilder_5 var3);

    public abstract FluentBuilder_5 g(CharSequence var1, Opaque105 var2, FluentBuilder_5 var3);

    public abstract FluentBuilder_5 b(CharSequence var1, boolean var2, Opaque105 var3, FluentBuilder_5 var4);

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    /* synthetic */ BufferedEnum(BufferedEnumImpl bufferedEnumImpl) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    static {
        $VALUES = new BufferedEnum[]{BUFFERED, STREAMED};
    }
}
