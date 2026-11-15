package itemsadder.m;

import itemsadder.m.bjq;
import itemsadder.m.bks;
import itemsadder.m.blf;

public final class bkr {
    private bkr() {
    }

    public static bjq b(int n, blf blf2, bjq bjq2) {
        if (n == Integer.MIN_VALUE) {
            int n2 = bks.aFS.length;
            blf2.tK += n2;
            if (bjq2.offset + n2 > bjq2.aFs.length) {
                bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
            }
            System.arraycopy(bks.aFS, 0, bjq2.aFs, bjq2.offset, n2);
            bjq2.offset += n2;
            return bjq2;
        }
        int n3 = n < 0 ? bks.cz(-n) + 1 : bks.cz(n);
        blf2.tK += n3;
        if (bjq2.offset + n3 > bjq2.aFs.length) {
            bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
        }
        bks.a(n, bjq2.offset, n3, bjq2.aFs);
        bjq2.offset += n3;
        return bjq2;
    }

    public static bjq a(long l, blf blf2, bjq bjq2) {
        if (l == Long.MIN_VALUE) {
            int n = bks.aFT.length;
            blf2.tK += n;
            if (bjq2.offset + n > bjq2.aFs.length) {
                bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
            }
            System.arraycopy(bks.aFT, 0, bjq2.aFs, bjq2.offset, n);
            bjq2.offset += n;
            return bjq2;
        }
        int n = l < 0L ? bks.t(-l) + 1 : bks.t(l);
        blf2.tK += n;
        if (bjq2.offset + n > bjq2.aFs.length) {
            bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
        }
        bks.a(l, bjq2.offset, n, bjq2.aFs);
        bjq2.offset += n;
        return bjq2;
    }

    public static bjq a(float f, blf blf2, bjq bjq2) {
        return bkr.b(Float.toString(f), blf2, bjq2);
    }

    public static bjq a(double d, blf blf2, bjq bjq2) {
        return bkr.b(Double.toString(d), blf2, bjq2);
    }

    public static bjq a(CharSequence charSequence, blf blf2, bjq bjq2) {
        int n = charSequence.length();
        if (n == 0) {
            return bjq2;
        }
        byte[] byArray = bjq2.aFs;
        int n2 = byArray.length;
        int n3 = bjq2.offset;
        int n4 = 0;
        do {
            char c;
            if ((c = charSequence.charAt(n4++)) < '\u0080') {
                if (n3 == n2) {
                    blf2.tK += n3 - bjq2.offset;
                    bjq2.offset = n3 = blf2.m(byArray, bjq2.aFt, n3 - bjq2.aFt);
                }
                byArray[n3++] = (byte)c;
                continue;
            }
            if (c < '\u0800') {
                if (n3 + 2 > n2) {
                    blf2.tK += n3 - bjq2.offset;
                    bjq2.offset = n3 = blf2.m(byArray, bjq2.aFt, n3 - bjq2.aFt);
                }
                byArray[n3++] = (byte)(0xC0 | c >> 6 & 0x1F);
                byArray[n3++] = (byte)(0x80 | c >> 0 & 0x3F);
                continue;
            }
            if (Character.isHighSurrogate(c) && n4 < n && Character.isLowSurrogate(charSequence.charAt(n4))) {
                if (n3 + 4 > byArray.length) {
                    blf2.tK += n3 - bjq2.offset;
                    bjq2.offset = n3 = blf2.m(byArray, bjq2.aFt, n3 - bjq2.aFt);
                }
                int n5 = Character.toCodePoint(c, charSequence.charAt(n4));
                byArray[n3++] = (byte)(0xF0 | n5 >> 18 & 7);
                byArray[n3++] = (byte)(0x80 | n5 >> 12 & 0x3F);
                byArray[n3++] = (byte)(0x80 | n5 >> 6 & 0x3F);
                byArray[n3++] = (byte)(0x80 | n5 >> 0 & 0x3F);
                ++n4;
                continue;
            }
            if (n3 + 3 > n2) {
                blf2.tK += n3 - bjq2.offset;
                bjq2.offset = n3 = blf2.m(byArray, bjq2.aFt, n3 - bjq2.aFt);
            }
            byArray[n3++] = (byte)(0xE0 | c >> 12 & 0xF);
            byArray[n3++] = (byte)(0x80 | c >> 6 & 0x3F);
            byArray[n3++] = (byte)(0x80 | c >> 0 & 0x3F);
        } while (n4 < n);
        blf2.tK += n3 - bjq2.offset;
        bjq2.offset = n3;
        return bjq2;
    }

    public static bjq b(CharSequence charSequence, blf blf2, bjq bjq2) {
        int n = charSequence.length();
        if (n == 0) {
            return bjq2;
        }
        int n2 = bjq2.offset;
        int n3 = bjq2.aFs.length;
        byte[] byArray = bjq2.aFs;
        blf2.tK += n;
        if (n2 + n > n3) {
            int n4 = 0;
            int n5 = bjq2.aFt;
            int n6 = n3 - n5;
            int n7 = n3 - n2;
            int n8 = n - n7;
            while (n7-- > 0) {
                byArray[n2++] = (byte)charSequence.charAt(n4++);
            }
            n2 = blf2.m(byArray, n5, n6);
            while (n8-- > 0) {
                if (n2 == n3) {
                    n2 = blf2.m(byArray, n5, n6);
                }
                byArray[n2++] = (byte)charSequence.charAt(n4++);
            }
        } else {
            for (int i = 0; i < n; ++i) {
                byArray[n2++] = (byte)charSequence.charAt(i);
            }
        }
        bjq2.offset = n2;
        return bjq2;
    }

    private static void a(bjq bjq2, blf blf2) {
        do {
            int n;
            if ((n = bjq2.offset - bjq2.aFt) <= 0) continue;
            bjq2.offset = blf2.a(bjq2, bjq2.aFs, bjq2.aFt, n);
        } while ((bjq2 = bjq2.aFu) != null);
    }

    public static bjq c(CharSequence charSequence, blf blf2, bjq bjq2) {
        return bkr.a(charSequence, false, blf2, bjq2);
    }

    public static bjq a(CharSequence charSequence, boolean bl, blf blf2, bjq bjq2) {
        int n = blf2.tK;
        int n2 = bjq2.offset + 2;
        int n3 = charSequence.length();
        if (n2 + n3 > bjq2.aFs.length) {
            bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
            n2 = bjq2.offset + 2;
            if (n3 == 0) {
                bks.a(0, bjq2.aFs, n2 - 2, bl);
                bjq2.offset = n2;
                blf2.tK += 2;
                return bjq2;
            }
            if (n2 + n3 > bjq2.aFs.length) {
                bjq2.offset = n2;
                bjq bjq3 = bks.a(charSequence, 0, n3, bjq2.aFs, n2, bjq2.aFs.length, blf2, bjq2);
                bks.a(blf2.tK - n, bjq2.aFs, n2 - 2, bl);
                blf2.tK += 2;
                assert (bjq3 != bjq2);
                bkr.a(bjq2, blf2);
                return bjq2;
            }
        } else if (n3 == 0) {
            bks.a(0, bjq2.aFs, n2 - 2, bl);
            bjq2.offset = n2;
            blf2.tK += 2;
            return bjq2;
        }
        bjq2.offset = n2;
        bjq bjq4 = bks.b(charSequence, 0, n3, blf2, bjq2);
        bks.a(blf2.tK - n, bjq2.aFs, n2 - 2, bl);
        blf2.tK += 2;
        if (bjq4 != bjq2) {
            bkr.a(bjq2, blf2);
        }
        return bjq2;
    }

    private static bjq a(CharSequence charSequence, int n, int n2, blf blf2, bjq bjq2) {
        int n3 = blf2.tK;
        int n4 = bjq2.offset + 1;
        if (n4 + n2 > bjq2.aFs.length) {
            bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
            n4 = bjq2.offset + 1;
        }
        bjq2.offset = n4;
        bjq bjq3 = bks.b(charSequence, n, n2, blf2, bjq2);
        bjq2.aFs[n4 - 1] = (byte)(blf2.tK - n3);
        ++blf2.tK;
        if (bjq3 != bjq2) {
            bkr.a(bjq2, blf2);
        }
        return bjq2;
    }

    private static bjq a(CharSequence charSequence, int n, int n2, int n3, int n4, blf blf2, bjq bjq2) {
        int n5 = blf2.tK;
        int n6 = bjq2.offset;
        int n7 = n6 + n4;
        if (n7 + n2 > bjq2.aFs.length && (n7 = (n6 = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt)) + n4) + n2 > bjq2.aFs.length) {
            bjq2.offset = n7;
            bjq bjq3 = bks.a(charSequence, n, n2, bjq2.aFs, n7, bjq2.aFs.length, blf2, bjq2);
            int n8 = blf2.tK - n5;
            if (n8 < n3) {
                blf2.tK += --n4;
                int n9 = ++n6;
                while (--n4 > 0) {
                    bjq2.aFs[n9++] = (byte)(n8 & 0x7F | 0x80);
                    n8 >>>= 7;
                }
                bjq2.aFs[n9] = (byte)n8;
                bjq2.offset = blf2.a(bjq2, bjq2.aFs, n6, bjq2.offset - n6);
                assert (bjq3 != bjq2);
                bkr.a(bjq2.aFu, blf2);
                return bjq2;
            }
            blf2.tK += n4;
            while (--n4 > 0) {
                bjq2.aFs[n6++] = (byte)(n8 & 0x7F | 0x80);
                n8 >>>= 7;
            }
            bjq2.aFs[n6] = (byte)n8;
            assert (bjq3 != bjq2);
            bkr.a(bjq2, blf2);
            return bjq2;
        }
        bjq2.offset = n7;
        bjq bjq4 = bks.b(charSequence, n, n2, blf2, bjq2);
        int n10 = blf2.tK - n5;
        if (n10 < n3) {
            if (bjq4 != bjq2 || n4 != 2) {
                blf2.tK += --n4;
                int n11 = n6++;
                int n12 = n6;
                while (--n4 > 0) {
                    bjq2.aFs[n12++] = (byte)(n10 & 0x7F | 0x80);
                    n10 >>>= 7;
                }
                bjq2.aFs[n12] = (byte)n10;
                bjq2.offset = n11 == bjq2.aFt ? blf2.a(bjq2, bjq2.aFs, n6, bjq2.offset - n6) : blf2.b(bjq2.aFs, bjq2.aFt, n11 - bjq2.aFt, bjq2.aFs, n6, bjq2.offset - n6);
                if (bjq4 != bjq2) {
                    bkr.a(bjq2.aFu, blf2);
                }
                return bjq2;
            }
            System.arraycopy(bjq2.aFs, n7, bjq2.aFs, n7 - 1, bjq2.offset - n7);
            --n4;
            --bjq2.offset;
        }
        blf2.tK += n4;
        while (--n4 > 0) {
            bjq2.aFs[n6++] = (byte)(n10 & 0x7F | 0x80);
            n10 >>>= 7;
        }
        bjq2.aFs[n6] = (byte)n10;
        if (bjq4 != bjq2) {
            bkr.a(bjq2, blf2);
        }
        return bjq2;
    }

    public static bjq d(CharSequence charSequence, blf blf2, bjq bjq2) {
        int n = charSequence.length();
        if (n == 0) {
            if (bjq2.offset == bjq2.aFs.length) {
                bjq2.offset = blf2.m(bjq2.aFs, bjq2.aFt, bjq2.offset - bjq2.aFt);
            }
            bjq2.aFs[bjq2.offset++] = 0;
            ++blf2.tK;
            return bjq2;
        }
        if (n < 43) {
            return bkr.a(charSequence, 0, n, blf2, bjq2);
        }
        if (n < 5462) {
            return bkr.a(charSequence, 0, n, 128, 2, blf2, bjq2);
        }
        if (n < 699051) {
            return bkr.a(charSequence, 0, n, 16384, 3, blf2, bjq2);
        }
        if (n < 0x5555556) {
            return bkr.a(charSequence, 0, n, 0x200000, 4, blf2, bjq2);
        }
        return bkr.a(charSequence, 0, n, 0x10000000, 5, blf2, bjq2);
    }
}
