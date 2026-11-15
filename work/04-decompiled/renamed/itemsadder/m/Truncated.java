package itemsadder.m;

import itemsadder.m.BufferCapacityEnough;
import itemsadder.m.CodedInputEncounteredEmbedded;
import itemsadder.m.FluentBuilderBuilder;
import itemsadder.m.FluentBuilderBuilder_2;
import itemsadder.m.FluentBuilder_5;
import itemsadder.m.Opaque089;
import itemsadder.m.Opaque090;
import itemsadder.m.Opaque091;
import itemsadder.m.Opaque093;
import itemsadder.m.PluginContractImpl_6;
import itemsadder.m.PluginContract_14;
import itemsadder.m.RuntimeError_3;
import itemsadder.m.Truncated_2;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class Truncated {
    private Truncated() {
    }

    public static void a(byte[] byArray, Object object, PluginContract_14 pluginContract_14) {
        Truncated.a(byArray, 0, byArray.length, object, pluginContract_14);
    }

    public static void a(byte[] byArray, int n, int n2, Object object, PluginContract_14 pluginContract_14) {
        try {
            FluentBuilderBuilder fluentBuilderBuilder = new FluentBuilderBuilder(byArray, n, n2, true);
            Opaque089 opaque089 = new Opaque089(fluentBuilderBuilder);
            pluginContract_14.a(opaque089, object);
            fluentBuilderBuilder.cc(0);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new RuntimeException("Truncated.", CodedInputEncounteredEmbedded.b(arrayIndexOutOfBoundsException));
        }
        catch (IOException iOException) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", iOException);
        }
    }

    public static void a(FluentBuilderBuilder_2 fluentBuilderBuilder_2, Object object, PluginContract_14 pluginContract_14) {
        Opaque090 opaque090 = new Opaque090(fluentBuilderBuilder_2);
        pluginContract_14.a(opaque090, object);
        fluentBuilderBuilder_2.cc(0);
    }

    public static void a(InputStream inputStream, Object object, PluginContract_14 pluginContract_14) {
        FluentBuilderBuilder_2 fluentBuilderBuilder_2 = new FluentBuilderBuilder_2(inputStream, true);
        Truncated.a(fluentBuilderBuilder_2, object, pluginContract_14);
    }

    public static void a(InputStream inputStream, Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        FluentBuilderBuilder_2 fluentBuilderBuilder_2 = new FluentBuilderBuilder_2(inputStream, fluentBuilder_5.aFs, true);
        Opaque090 opaque090 = new Opaque090(fluentBuilderBuilder_2);
        pluginContract_14.a(opaque090, object);
        fluentBuilderBuilder_2.cc(0);
    }

    public static int b(InputStream inputStream, Object object, PluginContract_14 pluginContract_14) {
        int n;
        int n2 = inputStream.read();
        if (n2 == -1) {
            throw CodedInputEncounteredEmbedded.Gi();
        }
        int n3 = n = n2 < 128 ? n2 : FluentBuilderBuilder_2.c(inputStream, n2);
        if (n < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        if (n != 0) {
            if (n > 4096) {
                FluentBuilderBuilder_2 fluentBuilderBuilder_2 = new FluentBuilderBuilder_2(new Opaque093(inputStream, n), true);
                Opaque090 opaque090 = new Opaque090(fluentBuilderBuilder_2);
                pluginContract_14.a(opaque090, object);
                fluentBuilderBuilder_2.cc(0);
                return n;
            }
            byte[] byArray = new byte[n];
            Truncated_2.a(inputStream, byArray, 0, n);
            FluentBuilderBuilder fluentBuilderBuilder = new FluentBuilderBuilder(byArray, 0, n, true);
            Opaque089 opaque089 = new Opaque089(fluentBuilderBuilder);
            try {
                pluginContract_14.a(opaque089, object);
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw CodedInputEncounteredEmbedded.b(arrayIndexOutOfBoundsException);
            }
            fluentBuilderBuilder.cc(0);
        }
        return n;
    }

    public static int b(InputStream inputStream, Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        int n;
        int n2 = inputStream.read();
        if (n2 == -1) {
            throw CodedInputEncounteredEmbedded.Gi();
        }
        byte[] byArray = fluentBuilder_5.aFs;
        int n3 = n = n2 < 128 ? n2 : FluentBuilderBuilder_2.c(inputStream, n2);
        if (n < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        if (n != 0) {
            if (n > byArray.length) {
                throw new CodedInputEncounteredEmbedded("size limit exceeded. " + n + " > " + byArray.length);
            }
            Truncated_2.a(inputStream, byArray, 0, n);
            FluentBuilderBuilder fluentBuilderBuilder = new FluentBuilderBuilder(byArray, 0, n, true);
            Opaque089 opaque089 = new Opaque089(fluentBuilderBuilder);
            try {
                pluginContract_14.a(opaque089, object);
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw CodedInputEncounteredEmbedded.b(arrayIndexOutOfBoundsException);
            }
            fluentBuilderBuilder.cc(0);
        }
        return n;
    }

    public static int a(DataInput dataInput, Object object, PluginContract_14 pluginContract_14) {
        int n;
        int n2 = dataInput.readByte();
        int n3 = n = 0 == (n2 & 0x80) ? n2 : FluentBuilderBuilder_2.a(dataInput, (byte)n2);
        if (n < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        if (n != 0) {
            if (n > 4096 && dataInput instanceof InputStream) {
                FluentBuilderBuilder_2 fluentBuilderBuilder_2 = new FluentBuilderBuilder_2(new Opaque093((InputStream)((Object)dataInput), n), true);
                Opaque090 opaque090 = new Opaque090(fluentBuilderBuilder_2);
                pluginContract_14.a(opaque090, object);
                fluentBuilderBuilder_2.cc(0);
            } else {
                byte[] byArray = new byte[n];
                dataInput.readFully(byArray, 0, n);
                FluentBuilderBuilder fluentBuilderBuilder = new FluentBuilderBuilder(byArray, 0, n, true);
                Opaque089 opaque089 = new Opaque089(fluentBuilderBuilder);
                try {
                    pluginContract_14.a(opaque089, object);
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    throw CodedInputEncounteredEmbedded.b(arrayIndexOutOfBoundsException);
                }
                fluentBuilderBuilder.cc(0);
            }
        }
        if (!pluginContract_14.r(object)) {
            throw new RuntimeError_3(object, pluginContract_14);
        }
        return n;
    }

    public static byte[] a(Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        if (fluentBuilder_5.aFt != fluentBuilder_5.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        PluginContractImpl_6 pluginContractImpl_6 = new PluginContractImpl_6(fluentBuilder_5);
        Opaque091 opaque091 = new Opaque091(pluginContractImpl_6);
        try {
            pluginContract_14.a(opaque091, object);
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
        Opaque091 opaque091 = new Opaque091(pluginContractImpl_6);
        try {
            pluginContract_14.a(opaque091, object);
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
        Opaque091 opaque091 = new Opaque091(pluginContractImpl_6);
        pluginContract_14.a(opaque091, object);
        FluentBuilder_5.a(outputStream, fluentBuilder_5);
        return pluginContractImpl_6.tK;
    }

    public static int b(OutputStream outputStream, Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        if (fluentBuilder_5.aFt != fluentBuilder_5.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        PluginContractImpl_6 pluginContractImpl_6 = new PluginContractImpl_6(fluentBuilder_5);
        Opaque091 opaque091 = new Opaque091(pluginContractImpl_6);
        pluginContract_14.a(opaque091, object);
        BufferCapacityEnough.a(outputStream, pluginContractImpl_6.tK);
        FluentBuilder_5.a(outputStream, fluentBuilder_5);
        return pluginContractImpl_6.tK;
    }

    public static int a(DataOutput dataOutput, Object object, PluginContract_14 pluginContract_14) {
        FluentBuilder_5 fluentBuilder_5 = new FluentBuilder_5(256);
        PluginContractImpl_6 pluginContractImpl_6 = new PluginContractImpl_6(fluentBuilder_5);
        Opaque091 opaque091 = new Opaque091(pluginContractImpl_6);
        pluginContract_14.a(opaque091, object);
        BufferCapacityEnough.a(dataOutput, pluginContractImpl_6.tK);
        FluentBuilder_5.a(dataOutput, fluentBuilder_5);
        return pluginContractImpl_6.tK;
    }

    public static boolean c(InputStream inputStream, Object object, PluginContract_14 pluginContract_14, FluentBuilder_5 fluentBuilder_5) {
        return Truncated.a(inputStream, object, pluginContract_14, true, fluentBuilder_5);
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
        Opaque089 opaque089 = new Opaque089(fluentBuilderBuilder);
        try {
            pluginContract_14.a(opaque089, object);
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
        Opaque091 opaque091 = new Opaque091(pluginContractImpl_6);
        fluentBuilder_5.offset = fluentBuilder_5.aFt + 5;
        pluginContractImpl_6.tK += 5;
        pluginContract_14.a(opaque091, object);
        int n = pluginContractImpl_6.tK - 5;
        int n2 = Truncated_2.a(n, fluentBuilder_5.aFs, fluentBuilder_5.aFt);
        outputStream.write(fluentBuilder_5.aFs, n2, fluentBuilder_5.offset - n2);
        if (fluentBuilder_5.aFu != null) {
            FluentBuilder_5.a(outputStream, fluentBuilder_5.aFu);
        }
        return n;
    }
}
