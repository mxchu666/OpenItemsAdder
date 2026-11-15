package itemsadder.m;

import itemsadder.m.FluentBuilder_5;
import itemsadder.m.Opaque102;
import itemsadder.m.Opaque105;

public final class Opaque101 {
    private Opaque101() {
    }

    public static FluentBuilder_5 b(int n, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        if (n == Integer.MIN_VALUE) {
            int n2 = Opaque102.aFS.length;
            opaque105.tK += n2;
            if (fluentBuilder_5.offset + n2 > fluentBuilder_5.aFs.length) {
                fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
            }
            System.arraycopy(Opaque102.aFS, 0, fluentBuilder_5.aFs, fluentBuilder_5.offset, n2);
            fluentBuilder_5.offset += n2;
            return fluentBuilder_5;
        }
        int n3 = n < 0 ? Opaque102.cz(-n) + 1 : Opaque102.cz(n);
        opaque105.tK += n3;
        if (fluentBuilder_5.offset + n3 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
        }
        Opaque102.a(n, fluentBuilder_5.offset, n3, fluentBuilder_5.aFs);
        fluentBuilder_5.offset += n3;
        return fluentBuilder_5;
    }

    public static FluentBuilder_5 a(long l, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        if (l == Long.MIN_VALUE) {
            int n = Opaque102.aFT.length;
            opaque105.tK += n;
            if (fluentBuilder_5.offset + n > fluentBuilder_5.aFs.length) {
                fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
            }
            System.arraycopy(Opaque102.aFT, 0, fluentBuilder_5.aFs, fluentBuilder_5.offset, n);
            fluentBuilder_5.offset += n;
            return fluentBuilder_5;
        }
        int n = l < 0L ? Opaque102.t(-l) + 1 : Opaque102.t(l);
        opaque105.tK += n;
        if (fluentBuilder_5.offset + n > fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
        }
        Opaque102.a(l, fluentBuilder_5.offset, n, fluentBuilder_5.aFs);
        fluentBuilder_5.offset += n;
        return fluentBuilder_5;
    }

    public static FluentBuilder_5 a(float f, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return Opaque101.b(Float.toString(f), opaque105, fluentBuilder_5);
    }

    public static FluentBuilder_5 a(double d, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return Opaque101.b(Double.toString(d), opaque105, fluentBuilder_5);
    }

    public static FluentBuilder_5 a(CharSequence charSequence, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n = charSequence.length();
        if (n == 0) {
            return fluentBuilder_5;
        }
        byte[] byArray = fluentBuilder_5.aFs;
        int n2 = byArray.length;
        int n3 = fluentBuilder_5.offset;
        int n4 = 0;
        do {
            char c;
            if ((c = charSequence.charAt(n4++)) < '\u0080') {
                if (n3 == n2) {
                    opaque105.tK += n3 - fluentBuilder_5.offset;
                    fluentBuilder_5.offset = n3 = opaque105.m(byArray, fluentBuilder_5.aFt, n3 - fluentBuilder_5.aFt);
                }
                byArray[n3++] = (byte)c;
                continue;
            }
            if (c < '\u0800') {
                if (n3 + 2 > n2) {
                    opaque105.tK += n3 - fluentBuilder_5.offset;
                    fluentBuilder_5.offset = n3 = opaque105.m(byArray, fluentBuilder_5.aFt, n3 - fluentBuilder_5.aFt);
                }
                byArray[n3++] = (byte)(0xC0 | c >> 6 & 0x1F);
                byArray[n3++] = (byte)(0x80 | c >> 0 & 0x3F);
                continue;
            }
            if (Character.isHighSurrogate(c) && n4 < n && Character.isLowSurrogate(charSequence.charAt(n4))) {
                if (n3 + 4 > byArray.length) {
                    opaque105.tK += n3 - fluentBuilder_5.offset;
                    fluentBuilder_5.offset = n3 = opaque105.m(byArray, fluentBuilder_5.aFt, n3 - fluentBuilder_5.aFt);
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
                opaque105.tK += n3 - fluentBuilder_5.offset;
                fluentBuilder_5.offset = n3 = opaque105.m(byArray, fluentBuilder_5.aFt, n3 - fluentBuilder_5.aFt);
            }
            byArray[n3++] = (byte)(0xE0 | c >> 12 & 0xF);
            byArray[n3++] = (byte)(0x80 | c >> 6 & 0x3F);
            byArray[n3++] = (byte)(0x80 | c >> 0 & 0x3F);
        } while (n4 < n);
        opaque105.tK += n3 - fluentBuilder_5.offset;
        fluentBuilder_5.offset = n3;
        return fluentBuilder_5;
    }

    public static FluentBuilder_5 b(CharSequence charSequence, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n = charSequence.length();
        if (n == 0) {
            return fluentBuilder_5;
        }
        int n2 = fluentBuilder_5.offset;
        int n3 = fluentBuilder_5.aFs.length;
        byte[] byArray = fluentBuilder_5.aFs;
        opaque105.tK += n;
        if (n2 + n > n3) {
            int n4 = 0;
            int n5 = fluentBuilder_5.aFt;
            int n6 = n3 - n5;
            int n7 = n3 - n2;
            int n8 = n - n7;
            while (n7-- > 0) {
                byArray[n2++] = (byte)charSequence.charAt(n4++);
            }
            n2 = opaque105.m(byArray, n5, n6);
            while (n8-- > 0) {
                if (n2 == n3) {
                    n2 = opaque105.m(byArray, n5, n6);
                }
                byArray[n2++] = (byte)charSequence.charAt(n4++);
            }
        } else {
            for (int i = 0; i < n; ++i) {
                byArray[n2++] = (byte)charSequence.charAt(i);
            }
        }
        fluentBuilder_5.offset = n2;
        return fluentBuilder_5;
    }

    private static void a(FluentBuilder_5 fluentBuilder_5, Opaque105 opaque105) {
        do {
            int n;
            if ((n = fluentBuilder_5.offset - fluentBuilder_5.aFt) <= 0) continue;
            fluentBuilder_5.offset = opaque105.a(fluentBuilder_5, fluentBuilder_5.aFs, fluentBuilder_5.aFt, n);
        } while ((fluentBuilder_5 = fluentBuilder_5.aFu) != null);
    }

    public static FluentBuilder_5 c(CharSequence charSequence, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return Opaque101.a(charSequence, false, opaque105, fluentBuilder_5);
    }

    public static FluentBuilder_5 a(CharSequence charSequence, boolean bl, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n = opaque105.tK;
        int n2 = fluentBuilder_5.offset + 2;
        int n3 = charSequence.length();
        if (n2 + n3 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
            n2 = fluentBuilder_5.offset + 2;
            if (n3 == 0) {
                Opaque102.a(0, fluentBuilder_5.aFs, n2 - 2, bl);
                fluentBuilder_5.offset = n2;
                opaque105.tK += 2;
                return fluentBuilder_5;
            }
            if (n2 + n3 > fluentBuilder_5.aFs.length) {
                fluentBuilder_5.offset = n2;
                FluentBuilder_5 fluentBuilder_52 = Opaque102.a(charSequence, 0, n3, fluentBuilder_5.aFs, n2, fluentBuilder_5.aFs.length, opaque105, fluentBuilder_5);
                Opaque102.a(opaque105.tK - n, fluentBuilder_5.aFs, n2 - 2, bl);
                opaque105.tK += 2;
                assert (fluentBuilder_52 != fluentBuilder_5);
                Opaque101.a(fluentBuilder_5, opaque105);
                return fluentBuilder_5;
            }
        } else if (n3 == 0) {
            Opaque102.a(0, fluentBuilder_5.aFs, n2 - 2, bl);
            fluentBuilder_5.offset = n2;
            opaque105.tK += 2;
            return fluentBuilder_5;
        }
        fluentBuilder_5.offset = n2;
        FluentBuilder_5 fluentBuilder_53 = Opaque102.b(charSequence, 0, n3, opaque105, fluentBuilder_5);
        Opaque102.a(opaque105.tK - n, fluentBuilder_5.aFs, n2 - 2, bl);
        opaque105.tK += 2;
        if (fluentBuilder_53 != fluentBuilder_5) {
            Opaque101.a(fluentBuilder_5, opaque105);
        }
        return fluentBuilder_5;
    }

    private static FluentBuilder_5 a(CharSequence charSequence, int n, int n2, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n3 = opaque105.tK;
        int n4 = fluentBuilder_5.offset + 1;
        if (n4 + n2 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
            n4 = fluentBuilder_5.offset + 1;
        }
        fluentBuilder_5.offset = n4;
        FluentBuilder_5 fluentBuilder_52 = Opaque102.b(charSequence, n, n2, opaque105, fluentBuilder_5);
        fluentBuilder_5.aFs[n4 - 1] = (byte)(opaque105.tK - n3);
        ++opaque105.tK;
        if (fluentBuilder_52 != fluentBuilder_5) {
            Opaque101.a(fluentBuilder_5, opaque105);
        }
        return fluentBuilder_5;
    }

    private static FluentBuilder_5 a(CharSequence charSequence, int n, int n2, int n3, int n4, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n5 = opaque105.tK;
        int n6 = fluentBuilder_5.offset;
        int n7 = n6 + n4;
        if (n7 + n2 > fluentBuilder_5.aFs.length && (n7 = (n6 = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt)) + n4) + n2 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = n7;
            FluentBuilder_5 fluentBuilder_52 = Opaque102.a(charSequence, n, n2, fluentBuilder_5.aFs, n7, fluentBuilder_5.aFs.length, opaque105, fluentBuilder_5);
            int n8 = opaque105.tK - n5;
            if (n8 < n3) {
                opaque105.tK += --n4;
                int n9 = ++n6;
                while (--n4 > 0) {
                    fluentBuilder_5.aFs[n9++] = (byte)(n8 & 0x7F | 0x80);
                    n8 >>>= 7;
                }
                fluentBuilder_5.aFs[n9] = (byte)n8;
                fluentBuilder_5.offset = opaque105.a(fluentBuilder_5, fluentBuilder_5.aFs, n6, fluentBuilder_5.offset - n6);
                assert (fluentBuilder_52 != fluentBuilder_5);
                Opaque101.a(fluentBuilder_5.aFu, opaque105);
                return fluentBuilder_5;
            }
            opaque105.tK += n4;
            while (--n4 > 0) {
                fluentBuilder_5.aFs[n6++] = (byte)(n8 & 0x7F | 0x80);
                n8 >>>= 7;
            }
            fluentBuilder_5.aFs[n6] = (byte)n8;
            assert (fluentBuilder_52 != fluentBuilder_5);
            Opaque101.a(fluentBuilder_5, opaque105);
            return fluentBuilder_5;
        }
        fluentBuilder_5.offset = n7;
        FluentBuilder_5 fluentBuilder_53 = Opaque102.b(charSequence, n, n2, opaque105, fluentBuilder_5);
        int n10 = opaque105.tK - n5;
        if (n10 < n3) {
            if (fluentBuilder_53 != fluentBuilder_5 || n4 != 2) {
                opaque105.tK += --n4;
                int n11 = n6++;
                int n12 = n6;
                while (--n4 > 0) {
                    fluentBuilder_5.aFs[n12++] = (byte)(n10 & 0x7F | 0x80);
                    n10 >>>= 7;
                }
                fluentBuilder_5.aFs[n12] = (byte)n10;
                fluentBuilder_5.offset = n11 == fluentBuilder_5.aFt ? opaque105.a(fluentBuilder_5, fluentBuilder_5.aFs, n6, fluentBuilder_5.offset - n6) : opaque105.b(fluentBuilder_5.aFs, fluentBuilder_5.aFt, n11 - fluentBuilder_5.aFt, fluentBuilder_5.aFs, n6, fluentBuilder_5.offset - n6);
                if (fluentBuilder_53 != fluentBuilder_5) {
                    Opaque101.a(fluentBuilder_5.aFu, opaque105);
                }
                return fluentBuilder_5;
            }
            System.arraycopy(fluentBuilder_5.aFs, n7, fluentBuilder_5.aFs, n7 - 1, fluentBuilder_5.offset - n7);
            --n4;
            --fluentBuilder_5.offset;
        }
        opaque105.tK += n4;
        while (--n4 > 0) {
            fluentBuilder_5.aFs[n6++] = (byte)(n10 & 0x7F | 0x80);
            n10 >>>= 7;
        }
        fluentBuilder_5.aFs[n6] = (byte)n10;
        if (fluentBuilder_53 != fluentBuilder_5) {
            Opaque101.a(fluentBuilder_5, opaque105);
        }
        return fluentBuilder_5;
    }

    public static FluentBuilder_5 d(CharSequence charSequence, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n = charSequence.length();
        if (n == 0) {
            if (fluentBuilder_5.offset == fluentBuilder_5.aFs.length) {
                fluentBuilder_5.offset = opaque105.m(fluentBuilder_5.aFs, fluentBuilder_5.aFt, fluentBuilder_5.offset - fluentBuilder_5.aFt);
            }
            fluentBuilder_5.aFs[fluentBuilder_5.offset++] = 0;
            ++opaque105.tK;
            return fluentBuilder_5;
        }
        if (n < 43) {
            return Opaque101.a(charSequence, 0, n, opaque105, fluentBuilder_5);
        }
        if (n < 5462) {
            return Opaque101.a(charSequence, 0, n, 128, 2, opaque105, fluentBuilder_5);
        }
        if (n < 699051) {
            return Opaque101.a(charSequence, 0, n, 16384, 3, opaque105, fluentBuilder_5);
        }
        if (n < 0x5555556) {
            return Opaque101.a(charSequence, 0, n, 0x200000, 4, opaque105, fluentBuilder_5);
        }
        return Opaque101.a(charSequence, 0, n, 0x10000000, 5, opaque105, fluentBuilder_5);
    }
}
