package itemsadder.m;

import itemsadder.m.biu;
import itemsadder.m.bjn;
import itemsadder.m.bjq;
import itemsadder.m.bkr;
import itemsadder.m.blf;
import itemsadder.m.blh;

final class blj
extends blh {
    @Override
    public bjq a(blf blf2, bjq bjq2) {
        bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
        return bjq2;
    }

    @Override
    public bjq c(byte[] byArray, int n, int n2, blf blf2, bjq bjq2) {
        return biu.b(byArray, n, n2, blf2, bjq2);
    }

    @Override
    public bjq d(byte[] byArray, int n, int n2, blf blf2, bjq bjq2) {
        if (n2 == 0) {
            return bjq2;
        }
        blf2.tK += n2;
        if (bjq2.offset + n2 > bjq2.aFs.length) {
            bjq2.offset = blf2.b(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt, byArray, n, n2);
            return bjq2;
        }
        System.arraycopy(byArray, n, bjq2.aFs, bjq2.offset, n2);
        bjq2.offset += n2;
        return bjq2;
    }

    @Override
    public bjq a(byte by, blf blf2, bjq bjq2) {
        ++blf2.tK;
        if (bjq2.offset == bjq2.aFs.length) {
            bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
        }
        bjq2.aFs[bjq2.offset++] = by;
        return bjq2;
    }

    @Override
    public bjq d(int n, blf blf2, bjq bjq2) {
        blf2.tK += 2;
        if (bjq2.offset + 2 > bjq2.aFs.length) {
            bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
        }
        bjn.b(n, bjq2.aFs, bjq2.offset);
        bjq2.offset += 2;
        return bjq2;
    }

    @Override
    public bjq e(int n, blf blf2, bjq bjq2) {
        blf2.tK += 2;
        if (bjq2.offset + 2 > bjq2.aFs.length) {
            bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
        }
        bjn.c(n, bjq2.aFs, bjq2.offset);
        bjq2.offset += 2;
        return bjq2;
    }

    @Override
    public bjq c(int n, blf blf2, bjq bjq2) {
        blf2.tK += 4;
        if (bjq2.offset + 4 > bjq2.aFs.length) {
            bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
        }
        bjn.d(n, bjq2.aFs, bjq2.offset);
        bjq2.offset += 4;
        return bjq2;
    }

    @Override
    public bjq b(long l, blf blf2, bjq bjq2) {
        blf2.tK += 8;
        if (bjq2.offset + 8 > bjq2.aFs.length) {
            bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
        }
        bjn.a(l, bjq2.aFs, bjq2.offset);
        bjq2.offset += 8;
        return bjq2;
    }

    @Override
    public bjq f(int n, blf blf2, bjq bjq2) {
        blf2.tK += 4;
        if (bjq2.offset + 4 > bjq2.aFs.length) {
            bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
        }
        bjn.e(n, bjq2.aFs, bjq2.offset);
        bjq2.offset += 4;
        return bjq2;
    }

    @Override
    public bjq c(long l, blf blf2, bjq bjq2) {
        blf2.tK += 8;
        if (bjq2.offset + 8 > bjq2.aFs.length) {
            bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
        }
        bjn.b(l, bjq2.aFs, bjq2.offset);
        bjq2.offset += 8;
        return bjq2;
    }

    @Override
    public bjq g(int n, blf blf2, bjq bjq2) {
        while (true) {
            ++blf2.tK;
            if (bjq2.offset == bjq2.aFs.length) {
                bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
            }
            if ((n & 0xFFFFFF80) == 0) {
                bjq2.aFs[bjq2.offset++] = (byte)n;
                return bjq2;
            }
            bjq2.aFs[bjq2.offset++] = (byte)(n & 0x7F | 0x80);
            n >>>= 7;
        }
    }

    @Override
    public bjq d(long l, blf blf2, bjq bjq2) {
        while (true) {
            ++blf2.tK;
            if (bjq2.offset == bjq2.aFs.length) {
                bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
            }
            if ((l & 0xFFFFFFFFFFFFFF80L) == 0L) {
                bjq2.aFs[bjq2.offset++] = (byte)l;
                return bjq2;
            }
            bjq2.aFs[bjq2.offset++] = (byte)((int)l & 0x7F | 0x80);
            l >>>= 7;
        }
    }

    @Override
    public bjq h(int n, blf blf2, bjq bjq2) {
        return bkr.b(n, blf2, bjq2);
    }

    @Override
    public bjq e(long l, blf blf2, bjq bjq2) {
        return bkr.a(l, blf2, bjq2);
    }

    @Override
    public bjq d(float f, blf blf2, bjq bjq2) {
        return bkr.a(f, blf2, bjq2);
    }

    @Override
    public bjq d(double d, blf blf2, bjq bjq2) {
        return bkr.a(d, blf2, bjq2);
    }

    @Override
    public bjq e(CharSequence charSequence, blf blf2, bjq bjq2) {
        return bkr.b(charSequence, blf2, bjq2);
    }

    @Override
    public bjq f(CharSequence charSequence, blf blf2, bjq bjq2) {
        return bkr.a(charSequence, blf2, bjq2);
    }

    @Override
    public bjq g(CharSequence charSequence, blf blf2, bjq bjq2) {
        return bkr.d(charSequence, blf2, bjq2);
    }

    @Override
    public bjq b(CharSequence charSequence, boolean bl, blf blf2, bjq bjq2) {
        return bkr.a(charSequence, bl, blf2, bjq2);
    }
}
