package itemsadder.m;

import itemsadder.m.BufferCapacityEnough;
import itemsadder.m.CodedInputEncounteredEmbedded;
import itemsadder.m.FluentBuilderBuilder;
import itemsadder.m.FluentBuilderBuilder_2;
import itemsadder.m.FluentBuilder_5;
import itemsadder.m.Opaque093;
import itemsadder.m.PluginContract_14;
import itemsadder.m.RuntimeError_3;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

final class Truncated_2 {
    private Truncated_2() {
    }

    static void a(byte[] byArray, int n, int n2, Object object, PluginContract_14 pluginContract_14, boolean bl) {
        try {
            FluentBuilderBuilder fluentBuilderBuilder = new FluentBuilderBuilder(byArray, n, n2, bl);
            pluginContract_14.a(fluentBuilderBuilder, object);
            fluentBuilderBuilder.cc(0);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new RuntimeException("Truncated.", CodedInputEncounteredEmbedded.b(arrayIndexOutOfBoundsException));
        }
        catch (IOException iOException) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", iOException);
        }
    }

    static void a(InputStream inputStream, byte[] byArray, Object object, PluginContract_14 pluginContract_14, boolean bl) {
        FluentBuilderBuilder_2 fluentBuilderBuilder_2 = new FluentBuilderBuilder_2(inputStream, byArray, bl);
        pluginContract_14.a(fluentBuilderBuilder_2, object);
        fluentBuilderBuilder_2.cc(0);
    }

    static void a(InputStream inputStream, Object object, PluginContract_14 pluginContract_14, boolean bl) {
        FluentBuilderBuilder_2 fluentBuilderBuilder_2 = new FluentBuilderBuilder_2(inputStream, bl);
        pluginContract_14.a(fluentBuilderBuilder_2, object);
        fluentBuilderBuilder_2.cc(0);
    }

    static int b(InputStream inputStream, byte[] byArray, Object object, PluginContract_14 pluginContract_14, boolean bl) {
        int n;
        int n2 = inputStream.read();
        if (n2 == -1) {
            throw new EOFException("mergeDelimitedFrom");
        }
        int n3 = n = n2 < 128 ? n2 : FluentBuilderBuilder_2.c(inputStream, n2);
        if (n < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        if (n != 0) {
            if (n > byArray.length) {
                throw new CodedInputEncounteredEmbedded("size limit exceeded. " + n + " > " + byArray.length);
            }
            Truncated_2.a(inputStream, byArray, 0, n);
            FluentBuilderBuilder fluentBuilderBuilder = new FluentBuilderBuilder(byArray, 0, n, bl);
            try {
                pluginContract_14.a(fluentBuilderBuilder, object);
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw CodedInputEncounteredEmbedded.b(arrayIndexOutOfBoundsException);
            }
            fluentBuilderBuilder.cc(0);
        }
        return n;
    }

    static int b(InputStream inputStream, Object object, PluginContract_14 pluginContract_14, boolean bl) {
        int n;
        int n2 = inputStream.read();
        if (n2 == -1) {
            throw new EOFException("mergeDelimitedFrom");
        }
        int n3 = n = n2 < 128 ? n2 : FluentBuilderBuilder_2.c(inputStream, n2);
        if (n < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        if (n != 0) {
            if (n > 4096) {
                FluentBuilderBuilder_2 fluentBuilderBuilder_2 = new FluentBuilderBuilder_2(new Opaque093(inputStream, n), bl);
                pluginContract_14.a(fluentBuilderBuilder_2, object);
                fluentBuilderBuilder_2.cc(0);
                return n;
            }
            byte[] byArray = new byte[n];
            Truncated_2.a(inputStream, byArray, 0, n);
            FluentBuilderBuilder fluentBuilderBuilder = new FluentBuilderBuilder(byArray, 0, n, bl);
            try {
                pluginContract_14.a(fluentBuilderBuilder, object);
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw CodedInputEncounteredEmbedded.b(arrayIndexOutOfBoundsException);
            }
            fluentBuilderBuilder.cc(0);
        }
        return n;
    }

    static int a(DataInput dataInput, Object object, PluginContract_14 pluginContract_14, boolean bl) {
        int n;
        int n2 = dataInput.readByte();
        int n3 = n = 0 == (n2 & 0x80) ? n2 : FluentBuilderBuilder_2.a(dataInput, (byte)n2);
        if (n < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        if (n != 0) {
            if (n > 4096 && dataInput instanceof InputStream) {
                FluentBuilderBuilder_2 fluentBuilderBuilder_2 = new FluentBuilderBuilder_2(new Opaque093((InputStream)((Object)dataInput), n), bl);
                pluginContract_14.a(fluentBuilderBuilder_2, object);
                fluentBuilderBuilder_2.cc(0);
            } else {
                byte[] byArray = new byte[n];
                dataInput.readFully(byArray, 0, n);
                FluentBuilderBuilder fluentBuilderBuilder = new FluentBuilderBuilder(byArray, 0, n, bl);
                try {
                    pluginContract_14.a(fluentBuilderBuilder, object);
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

    static void a(InputStream inputStream, byte[] byArray, int n, int n2) {
        int n3 = 0;
        while (n2 > 0) {
            n3 = inputStream.read(byArray, n, n2);
            if (n3 == -1) {
                throw CodedInputEncounteredEmbedded.Gi();
            }
            n2 -= n3;
            n += n3;
        }
    }

    static int a(InputStream inputStream, boolean bl, FluentBuilder_5 fluentBuilder_5) {
        int n;
        int n2;
        int n3;
        int n4;
        byte[] byArray = fluentBuilder_5.aFs;
        int n5 = fluentBuilder_5.aFt;
        int n6 = byArray.length - n5;
        int n7 = inputStream.read(byArray, n5, n6);
        if (n7 < 1) {
            throw new EOFException("fillBufferWithDelimitedMessageFrom");
        }
        int n8 = n5 + n7;
        if (0 != ((n4 = byArray[n5++]) & 0x80)) {
            n4 &= 0x7F;
            n3 = 7;
            while (true) {
                block16: {
                    if (n5 == n8) {
                        n7 = inputStream.read(byArray, n8, n6 - (n8 - fluentBuilder_5.aFt));
                        if (n7 < 1) {
                            throw new EOFException("fillBufferWithDelimitedMessageFrom");
                        }
                        n8 += n7;
                    }
                    n2 = byArray[n5++];
                    n4 |= (n2 & 0x7F) << n3;
                    if (0 == (n2 & 0x80)) break;
                    if (n3 == 28) {
                        n = 0;
                        do {
                            if (n5 == n8) {
                                n7 = inputStream.read(byArray, n8, n6 - (n8 - fluentBuilder_5.aFt));
                                if (n7 < 1) {
                                    throw new EOFException("fillBufferWithDelimitedMessageFrom");
                                }
                                n8 += n7;
                            }
                            if (byArray[n5++] >= 0) break block16;
                        } while (5 != ++n);
                        throw CodedInputEncounteredEmbedded.Gl();
                    }
                }
                n3 += 7;
            }
        }
        if (n4 == 0) {
            if (n5 != n8) {
                throw CodedInputEncounteredEmbedded.Gj();
            }
            return n4;
        }
        if (n4 < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        n3 = n8 - n5;
        if (n3 < n4) {
            n2 = n5 - fluentBuilder_5.aFt;
            if (n4 + n2 > n6) {
                if (!bl) {
                    return n4;
                }
                for (n = n4 - n3; n > 0; n -= n7) {
                    n7 = inputStream.read(byArray, fluentBuilder_5.aFt, Math.min(n, n6));
                    if (n7 >= 1) continue;
                    throw new EOFException("fillBufferWithDelimitedMessageFrom");
                }
                return n4;
            }
            Truncated_2.a(inputStream, byArray, n8, n4 - n3);
        }
        fluentBuilder_5.offset = n5;
        return n4;
    }

    static int a(int n, byte[] byArray, int n2) {
        switch (BufferCapacityEnough.cx(n)) {
            case 1: {
                byArray[n2 + 4] = (byte)n;
                return n2 + 4;
            }
            case 2: {
                byArray[n2 + 3] = (byte)(n & 0x7F | 0x80);
                byArray[n2 + 4] = (byte)(n >>> 7);
                return n2 + 3;
            }
            case 3: {
                byArray[n2 + 2] = (byte)(n & 0x7F | 0x80);
                byArray[n2 + 3] = (byte)(n >>> 7 & 0x7F | 0x80);
                byArray[n2 + 4] = (byte)(n >>> 14);
                return n2 + 2;
            }
            case 4: {
                byArray[n2 + 1] = (byte)(n & 0x7F | 0x80);
                byArray[n2 + 2] = (byte)(n >>> 7 & 0x7F | 0x80);
                byArray[n2 + 3] = (byte)(n >>> 14 & 0x7F | 0x80);
                byArray[n2 + 4] = (byte)(n >>> 21);
                return n2 + 1;
            }
        }
        byArray[n2] = (byte)(n & 0x7F | 0x80);
        byArray[n2 + 1] = (byte)(n >>> 7 & 0x7F | 0x80);
        byArray[n2 + 2] = (byte)(n >>> 14 & 0x7F | 0x80);
        byArray[n2 + 3] = (byte)(n >>> 21 & 0x7F | 0x80);
        byArray[n2 + 4] = (byte)(n >>> 28);
        return n2;
    }
}
