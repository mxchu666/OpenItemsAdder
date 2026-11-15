package itemsadder.m;

import itemsadder.m.fm;
import itemsadder.m.fq;
import java.util.Arrays;
import org.bukkit.World;

final class fo {
    private short[] tH = new short[8];
    private int[] tI = new int[8];
    private byte[] tJ = new byte[8];
    private int tK;

    private fo() {
    }

    private void a(short s, int n) {
        if (this.tK == this.tH.length) {
            this.tH = Arrays.copyOf(this.tH, this.tK * 2);
            this.tI = Arrays.copyOf(this.tI, this.tK * 2);
            this.tJ = Arrays.copyOf(this.tJ, this.tK * 2);
        }
        this.tH[this.tK] = s;
        this.tI[this.tK++] = n;
    }

    private void a(World world, int n, int n2, int n3) {
        for (int i = 0; i < this.tK; ++i) {
            int n4 = this.tH[i] & 0xFFFF;
            int n5 = n << 4 | n4 & 0xF;
            int n6 = n2 << 4 | n4 >>> 8 & 0xF;
            int n7 = n3 << 4 | n4 >>> 4 & 0xF;
            this.tJ[i] = fm.a(world, n5, n6, n7, 0, 0, 0, null);
        }
    }

    private fq hM() {
        long[] lArray = new long[this.tK];
        for (int i = 0; i < this.tK; ++i) {
            lArray[i] = (long)(this.tH[i] & 0xFFFF) << 40 | ((long)this.tI[i] & 0xFFFFFFFFL) << 8 | (long)(this.tJ[i] & 0x3F);
        }
        Arrays.sort(lArray);
        short[] sArray = new short[this.tK];
        int[] nArray = new int[this.tK];
        byte[] byArray = new byte[this.tK];
        for (int i = 0; i < this.tK; ++i) {
            sArray[i] = (short)(lArray[i] >>> 40);
            nArray[i] = (int)(lArray[i] >>> 8);
            byArray[i] = (byte)(lArray[i] & 0x3FL);
        }
        return new fq(sArray, nArray, byArray);
    }
}
