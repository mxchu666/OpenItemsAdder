package itemsadder.m;

import itemsadder.m.BufferCapacityEnough;
import itemsadder.m.CodedInputEncounteredEmbedded;
import itemsadder.m.FluentBuilderBuilder;
import itemsadder.m.FluentBuilderBuilder_2;
import itemsadder.m.FluentBuilder_5;
import itemsadder.m.Opaque096;
import itemsadder.m.Opaque099;
import itemsadder.m.Opaque100;
import itemsadder.m.Opaque105;
import itemsadder.m.PluginContractImpl_6;
import itemsadder.m.PluginContract_14;
import itemsadder.m.Truncated_2;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BufferPreviouslyUsed_2 {
    private BufferPreviouslyUsed_2() {
    }

    public static Opaque096 w(byte[] byArray) {
        return BufferPreviouslyUsed_2.j(byArray, 0, byArray.length);
    }

    public static Opaque096 j(byte[] byArray, int n, int n2) {
        FluentBuilderBuilder fluentBuilderBuilder = new FluentBuilderBuilder(byArray, n, n2, true);
        return new Opaque099(fluentBuilderBuilder);
    }

    public static Opaque096 g(InputStream inputStream) {
        FluentBuilderBuilder_2 fluentBuilderBuilder_2 = new FluentBuilderBuilder_2(inputStream, true);
        return new Opaque100(fluentBuilderBuilder_2);
    }

    public static void a(byte[] byArray, Object object, PluginContract_14 pluginContract_14) {
        Truncated_2.a(byArray, 0, byArray.length, object, pluginContract_14, true);
    }

    public static void a(byte[] byArray, int n, int n2, Object object, PluginContract_14 pluginContract_14) {
        Truncated_2.a(byArray, n, n2, object, pluginContract_14, true);
    }

    public static void a(InputStream inputStream, Object object, PluginContract_14 pluginContract_14) {
        Truncated_2.a(inputStream, object, pluginContract_14, true);
    }

    public static void a(InputStream inputStream, Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        Truncated_2.a(inputStream, fluentBuilder_5.aFs, object, pluginContract_14, true);
    }

    public static int b(InputStream inputStream, Object object, PluginContract_14 pluginContract_14) {
        return Truncated_2.b(inputStream, object, pluginContract_14, true);
    }

    public static int b(InputStream inputStream, Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        return Truncated_2.b(inputStream, fluentBuilder_5.aFs, object, pluginContract_14, true);
    }

    public static int a(DataInput dataInput, Object object, PluginContract_14 pluginContract_14) {
        return Truncated_2.a(dataInput, object, pluginContract_14, true);
    }

    public static byte[] a(Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        if (fluentBuilder_5.aFt != fluentBuilder_5.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        PluginContractImpl_6 pluginContractImpl_6 = new PluginContractImpl_6(fluentBuilder_5);
        try {
            pluginContract_14.a(pluginContractImpl_6, object);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", iOException);
        }
        return pluginContractImpl_6.GE();
    }

    public static int a(FluentBuilder_5 fluentBuilder_5, Object object, PluginContract_14 pluginContract_14) {
        if (fluentBuilder_5.aFt != fluentBuilder_5.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        PluginContractImpl_6 pluginContractImpl_6 = new PluginContractImpl_6(fluentBuilder_5);
        try {
            pluginContract_14.a(pluginContractImpl_6, object);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Serializing to a LinkedBuffer threw an IOException (should never happen).", iOException);
        }
        return pluginContractImpl_6.GD();
    }

    public static int a(OutputStream outputStream, Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        if (fluentBuilder_5.aFt != fluentBuilder_5.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        PluginContractImpl_6 pluginContractImpl_6 = new PluginContractImpl_6(fluentBuilder_5, outputStream);
        pluginContract_14.a(pluginContractImpl_6, object);
        FluentBuilder_5.a(outputStream, fluentBuilder_5);
        return pluginContractImpl_6.tK;
    }

    public static int b(OutputStream outputStream, Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        if (fluentBuilder_5.aFt != fluentBuilder_5.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        PluginContractImpl_6 pluginContractImpl_6 = new PluginContractImpl_6(fluentBuilder_5);
        pluginContract_14.a(pluginContractImpl_6, object);
        BufferCapacityEnough.a(outputStream, pluginContractImpl_6.tK);
        FluentBuilder_5.a(outputStream, fluentBuilder_5);
        return pluginContractImpl_6.tK;
    }

    public static int a(DataOutput dataOutput, Object object, PluginContract_14 pluginContract_14) {
        FluentBuilder_5 fluentBuilder_5 = new FluentBuilder_5(256);
        PluginContractImpl_6 pluginContractImpl_6 = new PluginContractImpl_6(fluentBuilder_5);
        pluginContract_14.a(pluginContractImpl_6, object);
        BufferCapacityEnough.a(dataOutput, pluginContractImpl_6.tK);
        FluentBuilder_5.a(dataOutput, fluentBuilder_5);
        return pluginContractImpl_6.tK;
    }

    public static int a(OutputStream outputStream, List list, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        if (fluentBuilder_5.aFt != fluentBuilder_5.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        int n = list.size();
        if (n == 0) {
            return 0;
        }
        PluginContractImpl_6 pluginContractImpl_6 = new PluginContractImpl_6(fluentBuilder_5, outputStream);
        pluginContractImpl_6.aGG.g(n, (Opaque105)pluginContractImpl_6, fluentBuilder_5);
        for (Object e : list) {
            pluginContract_14.a(pluginContractImpl_6, e);
            pluginContractImpl_6.aGG.a((byte)7, (Opaque105)pluginContractImpl_6, fluentBuilder_5);
        }
        FluentBuilder_5.a(outputStream, fluentBuilder_5);
        return pluginContractImpl_6.tK;
    }

    public static List a(InputStream inputStream, PluginContract_14 pluginContract_14) {
        int n = inputStream.read();
        if (n == -1) {
            return Collections.emptyList();
        }
        if (n > 127) {
            n = FluentBuilderBuilder_2.c(inputStream, n);
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(n);
        FluentBuilderBuilder_2 fluentBuilderBuilder_2 = new FluentBuilderBuilder_2(inputStream, true);
        for (int i = 0; i < n; ++i) {
            Object object = pluginContract_14.wi();
            arrayList.add(object);
            pluginContract_14.a(fluentBuilderBuilder_2, object);
            fluentBuilderBuilder_2.cc(0);
        }
        assert (inputStream.read() == -1);
        return arrayList;
    }

    public static boolean c(InputStream inputStream, Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        return BufferPreviouslyUsed_2.a(inputStream, object, pluginContract_14, true, fluentBuilder_5);
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
        FluentBuilderBuilder fluentBuilderBuilder = new FluentBuilderBuilder(fluentBuilder_5.aFs, fluentBuilder_5.offset, n, true);
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
        PluginContractImpl_6 pluginContractImpl_6 = new PluginContractImpl_6(fluentBuilder_5);
        fluentBuilder_5.offset = fluentBuilder_5.aFt + 5;
        pluginContractImpl_6.tK += 5;
        pluginContract_14.a(pluginContractImpl_6, object);
        int n = pluginContractImpl_6.tK - 5;
        int n2 = Truncated_2.a(n, fluentBuilder_5.aFs, fluentBuilder_5.aFt);
        outputStream.write(fluentBuilder_5.aFs, n2, fluentBuilder_5.offset - n2);
        if (fluentBuilder_5.aFu != null) {
            FluentBuilder_5.a(outputStream, fluentBuilder_5.aFu);
        }
        return n;
    }
}
