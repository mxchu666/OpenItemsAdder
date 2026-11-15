package itemsadder.m;

import itemsadder.m.BufferedEnum;
import itemsadder.m.FluentBuilder_5;
import itemsadder.m.Happen;
import itemsadder.m.Opaque092;
import itemsadder.m.Opaque101;
import itemsadder.m.Opaque105;

final class BufferedEnumImpl_2
extends BufferedEnum {
    @Override
    public FluentBuilder_5 a(Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
        return fluentBuilder_5;
    }

    @Override
    public FluentBuilder_5 c(byte[] byArray, int n, int n2, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return Happen.b(byArray, n, n2, opaque105, fluentBuilder_5);
    }

    @Override
    public FluentBuilder_5 d(byte[] byArray, int n, int n2, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        if (n2 == 0) {
            return fluentBuilder_5;
        }
        opaque105.tK += n2;
        if (fluentBuilder_5.offset + n2 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = opaque105.b(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt, byArray, n, n2);
            return fluentBuilder_5;
        }
        System.arraycopy(byArray, n, fluentBuilder_5.aFs, fluentBuilder_5.offset, n2);
        fluentBuilder_5.offset += n2;
        return fluentBuilder_5;
    }

    @Override
    public FluentBuilder_5 a(byte by, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        ++opaque105.tK;
        if (fluentBuilder_5.offset == fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
        }
        fluentBuilder_5.aFs[fluentBuilder_5.offset++] = by;
        return fluentBuilder_5;
    }

    @Override
    public FluentBuilder_5 d(int n, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        opaque105.tK += 2;
        if (fluentBuilder_5.offset + 2 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
        }
        Opaque092.b(n, fluentBuilder_5.aFs, fluentBuilder_5.offset);
        fluentBuilder_5.offset += 2;
        return fluentBuilder_5;
    }

    @Override
    public FluentBuilder_5 e(int n, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        opaque105.tK += 2;
        if (fluentBuilder_5.offset + 2 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
        }
        Opaque092.c(n, fluentBuilder_5.aFs, fluentBuilder_5.offset);
        fluentBuilder_5.offset += 2;
        return fluentBuilder_5;
    }

    @Override
    public FluentBuilder_5 c(int n, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        opaque105.tK += 4;
        if (fluentBuilder_5.offset + 4 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
        }
        Opaque092.d(n, fluentBuilder_5.aFs, fluentBuilder_5.offset);
        fluentBuilder_5.offset += 4;
        return fluentBuilder_5;
    }

    @Override
    public FluentBuilder_5 b(long l, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        opaque105.tK += 8;
        if (fluentBuilder_5.offset + 8 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
        }
        Opaque092.a(l, fluentBuilder_5.aFs, fluentBuilder_5.offset);
        fluentBuilder_5.offset += 8;
        return fluentBuilder_5;
    }

    @Override
    public FluentBuilder_5 f(int n, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        opaque105.tK += 4;
        if (fluentBuilder_5.offset + 4 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
        }
        Opaque092.e(n, fluentBuilder_5.aFs, fluentBuilder_5.offset);
        fluentBuilder_5.offset += 4;
        return fluentBuilder_5;
    }

    @Override
    public FluentBuilder_5 c(long l, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        opaque105.tK += 8;
        if (fluentBuilder_5.offset + 8 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
        }
        Opaque092.b(l, fluentBuilder_5.aFs, fluentBuilder_5.offset);
        fluentBuilder_5.offset += 8;
        return fluentBuilder_5;
    }

    @Override
    public FluentBuilder_5 g(int n, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        while (true) {
            ++opaque105.tK;
            if (fluentBuilder_5.offset == fluentBuilder_5.aFs.length) {
                fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
            }
            if ((n & 0xFFFFFF80) == 0) {
                fluentBuilder_5.aFs[fluentBuilder_5.offset++] = (byte)n;
                return fluentBuilder_5;
            }
            fluentBuilder_5.aFs[fluentBuilder_5.offset++] = (byte)(n & 0x7F | 0x80);
            n >>>= 7;
        }
    }

    @Override
    public FluentBuilder_5 d(long l, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        while (true) {
            ++opaque105.tK;
            if (fluentBuilder_5.offset == fluentBuilder_5.aFs.length) {
                fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
            }
            if ((l & 0xFFFFFFFFFFFFFF80L) == 0L) {
                fluentBuilder_5.aFs[fluentBuilder_5.offset++] = (byte)l;
                return fluentBuilder_5;
            }
            fluentBuilder_5.aFs[fluentBuilder_5.offset++] = (byte)((int)l & 0x7F | 0x80);
            l >>>= 7;
        }
    }

    @Override
    public FluentBuilder_5 h(int n, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return Opaque101.b(n, opaque105, fluentBuilder_5);
    }

    @Override
    public FluentBuilder_5 e(long l, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return Opaque101.a(l, opaque105, fluentBuilder_5);
    }

    @Override
    public FluentBuilder_5 d(float f, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return Opaque101.a(f, opaque105, fluentBuilder_5);
    }

    @Override
    public FluentBuilder_5 d(double d, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return Opaque101.a(d, opaque105, fluentBuilder_5);
    }

    @Override
    public FluentBuilder_5 e(CharSequence charSequence, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return Opaque101.b(charSequence, opaque105, fluentBuilder_5);
    }

    @Override
    public FluentBuilder_5 f(CharSequence charSequence, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return Opaque101.a(charSequence, opaque105, fluentBuilder_5);
    }

    @Override
    public FluentBuilder_5 g(CharSequence charSequence, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return Opaque101.d(charSequence, opaque105, fluentBuilder_5);
    }

    @Override
    public FluentBuilder_5 b(CharSequence charSequence, boolean bl, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return Opaque101.a(charSequence, bl, opaque105, fluentBuilder_5);
    }
}
