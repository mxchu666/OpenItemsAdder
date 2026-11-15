package itemsadder.m;

import itemsadder.m.BufferCapacityEnough;
import itemsadder.m.CodedInputEncounteredEmbedded;
import itemsadder.m.FluentBuilderBuilder;
import itemsadder.m.FluentBuilderBuilder_2;
import itemsadder.m.FluentBuilder_5;
import itemsadder.m.Opaque093;
import itemsadder.m.Opaque096;
import itemsadder.m.Opaque097;
import itemsadder.m.Opaque098;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_14;
import itemsadder.m.Truncated_2;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class BufferPreviouslyUsed {
    private BufferPreviouslyUsed() {
    }

    public static Opaque096 w(byte[] byArray) {
        return BufferPreviouslyUsed.j(byArray, 0, byArray.length);
    }

    public static Opaque096 j(byte[] byArray, int n, int n2) {
        FluentBuilderBuilder fluentBuilderBuilder = new FluentBuilderBuilder(byArray, n, n2, false);
        return new Opaque097(fluentBuilderBuilder);
    }

    public static Opaque096 g(InputStream inputStream) {
        FluentBuilderBuilder_2 fluentBuilderBuilder_2 = new FluentBuilderBuilder_2(inputStream, false);
        return new Opaque098(fluentBuilderBuilder_2);
    }

    public static void a(byte[] byArray, Object object, PluginContract_14 pluginContract_14) {
        Truncated_2.a(byArray, 0, byArray.length, object, pluginContract_14, false);
    }

    public static void a(byte[] byArray, int n, int n2, Object object, PluginContract_14 pluginContract_14) {
        Truncated_2.a(byArray, n, n2, object, pluginContract_14, false);
    }

    public static void a(InputStream inputStream, Object object, PluginContract_14 pluginContract_14) {
        Truncated_2.a(inputStream, object, pluginContract_14, false);
    }

    public static void a(InputStream inputStream, Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        Truncated_2.a(inputStream, fluentBuilder_5.aFs, object, pluginContract_14, false);
    }

    public static int b(InputStream inputStream, Object object, PluginContract_14 pluginContract_14) {
        return Truncated_2.b(inputStream, object, pluginContract_14, false);
    }

    public static int b(InputStream inputStream, Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        return Truncated_2.b(inputStream, fluentBuilder_5.aFs, object, pluginContract_14, false);
    }

    public static int a(DataInput dataInput, Object object, PluginContract_14 pluginContract_14) {
        return Truncated_2.a(dataInput, object, pluginContract_14, false);
    }

    public static byte[] a(Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        if (fluentBuilder_5.aFt != fluentBuilder_5.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        BufferCapacityEnough bufferCapacityEnough = new BufferCapacityEnough(fluentBuilder_5);
        try {
            pluginContract_14.a(bufferCapacityEnough, object);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", iOException);
        }
        return bufferCapacityEnough.GE();
    }

    public static int a(FluentBuilder_5 fluentBuilder_5, Object object, PluginContract_14 pluginContract_14) {
        if (fluentBuilder_5.aFt != fluentBuilder_5.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        BufferCapacityEnough bufferCapacityEnough = new BufferCapacityEnough(fluentBuilder_5);
        try {
            pluginContract_14.a(bufferCapacityEnough, object);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Serializing to a LinkedBuffer threw an IOException (should never happen).", iOException);
        }
        return bufferCapacityEnough.GD();
    }

    public static int a(OutputStream outputStream, Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        if (fluentBuilder_5.aFt != fluentBuilder_5.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        BufferCapacityEnough bufferCapacityEnough = new BufferCapacityEnough(fluentBuilder_5);
        pluginContract_14.a(bufferCapacityEnough, object);
        return FluentBuilder_5.a(outputStream, fluentBuilder_5);
    }

    public static int b(OutputStream outputStream, Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        if (fluentBuilder_5.aFt != fluentBuilder_5.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        BufferCapacityEnough bufferCapacityEnough = new BufferCapacityEnough(fluentBuilder_5);
        pluginContract_14.a(bufferCapacityEnough, object);
        int n = bufferCapacityEnough.GD();
        BufferCapacityEnough.a(outputStream, n);
        int n2 = FluentBuilder_5.a(outputStream, fluentBuilder_5);
        assert (n == n2);
        return n;
    }

    public static int a(DataOutput dataOutput, Object object, PluginContract_14 pluginContract_14) {
        FluentBuilder_5 fluentBuilder_5 = new FluentBuilder_5(256);
        BufferCapacityEnough bufferCapacityEnough = new BufferCapacityEnough(fluentBuilder_5);
        pluginContract_14.a(bufferCapacityEnough, object);
        int n = bufferCapacityEnough.GD();
        BufferCapacityEnough.a(dataOutput, n);
        int n2 = FluentBuilder_5.a(dataOutput, fluentBuilder_5);
        assert (n == n2);
        return n;
    }

    public static int a(OutputStream outputStream, List list, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        if (fluentBuilder_5.aFt != fluentBuilder_5.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        BufferCapacityEnough bufferCapacityEnough = new BufferCapacityEnough(fluentBuilder_5);
        int n = 0;
        for (Object e : list) {
            pluginContract_14.a(bufferCapacityEnough, e);
            int n2 = bufferCapacityEnough.GD();
            BufferCapacityEnough.a(outputStream, n2);
            int n3 = FluentBuilder_5.a(outputStream, fluentBuilder_5);
            assert (n2 == n3);
            n += n2;
            bufferCapacityEnough.Gr();
        }
        return n;
    }

    public static List a(InputStream inputStream, PluginContract_14 pluginContract_14) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        byte[] byArray = null;
        int n = 0;
        Opaque093 opaque093 = null;
        int n2 = inputStream.read();
        while (n2 != -1) {
            int n3;
            Object object = pluginContract_14.wi();
            arrayList.add(object);
            int n4 = n3 = n2 < 128 ? n2 : FluentBuilderBuilder_2.c(inputStream, n2);
            if (n3 != 0) {
                PluginContract_11 pluginContract_11;
                if (n3 > 4096) {
                    if (opaque093 == null) {
                        opaque093 = new Opaque093(inputStream);
                    }
                    pluginContract_11 = new FluentBuilderBuilder_2(opaque093.co(n3), false);
                    pluginContract_14.a(pluginContract_11, object);
                    ((FluentBuilderBuilder_2)pluginContract_11).cc(0);
                } else {
                    if (n < n3) {
                        byArray = new byte[n3];
                        n = n3;
                    }
                    Truncated_2.a(inputStream, byArray, 0, n3);
                    pluginContract_11 = new FluentBuilderBuilder(byArray, 0, n3, false);
                    try {
                        pluginContract_14.a(pluginContract_11, object);
                    }
                    catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                        throw CodedInputEncounteredEmbedded.b(arrayIndexOutOfBoundsException);
                    }
                    ((FluentBuilderBuilder)pluginContract_11).cc(0);
                }
            }
            n2 = inputStream.read();
        }
        return arrayList;
    }

    public static boolean c(InputStream inputStream, Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        return BufferPreviouslyUsed.a(inputStream, object, pluginContract_14, true, fluentBuilder_5);
    }

    public static boolean a(InputStream inputStream, Object object, PluginContract_14 pluginContract_14, boolean bl, FluentBuilder_5 fluentBuilder_5) {
        if (fluentBuilder_5.aFt != fluentBuilder_5.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        int n = Truncated_2.a(inputStream, bl, fluentBuilder_5);
        if (n == 0) {
            return true;
        }
        if (fluentBuilder_5.aFt == fluentBuilder_5.offset) {
            return false;
        }
        FluentBuilderBuilder fluentBuilderBuilder = new FluentBuilderBuilder(fluentBuilder_5.aFs, fluentBuilder_5.offset, n, false);
        try {
            pluginContract_14.a(fluentBuilderBuilder, object);
            fluentBuilderBuilder.cc(0);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw CodedInputEncounteredEmbedded.b(arrayIndexOutOfBoundsException);
        }
        finally {
            fluentBuilder_5.offset = fluentBuilder_5.aFt;
        }
        return true;
    }

    public static int c(OutputStream outputStream, Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        if (fluentBuilder_5.aFt != fluentBuilder_5.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        BufferCapacityEnough bufferCapacityEnough = new BufferCapacityEnough(fluentBuilder_5);
        fluentBuilder_5.offset = fluentBuilder_5.aFt + 5;
        bufferCapacityEnough.tK += 5;
        pluginContract_14.a(bufferCapacityEnough, object);
        int n = bufferCapacityEnough.tK - 5;
        int n2 = Truncated_2.a(n, fluentBuilder_5.aFs, fluentBuilder_5.aFt);
        outputStream.write(fluentBuilder_5.aFs, n2, fluentBuilder_5.offset - n2);
        if (fluentBuilder_5.aFu != null) {
            FluentBuilder_5.a(outputStream, fluentBuilder_5.aFu);
        }
        return n;
    }
}
