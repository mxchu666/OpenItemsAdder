package itemsadder.m;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class Opaque093
extends FilterInputStream {
    private int aEA;

    public Opaque093(InputStream inputStream) {
        super(inputStream);
    }

    public Opaque093(InputStream inputStream, int n) {
        super(inputStream);
        this.aEA = n;
    }

    Opaque093 co(int n) {
        this.aEA = n;
        return this;
    }

    @Override
    public int available() {
        return Math.min(super.available(), this.aEA);
    }

    @Override
    public int read() {
        if (this.aEA <= 0) {
            return -1;
        }
        int n = super.read();
        if (n >= 0) {
            --this.aEA;
        }
        return n;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (this.aEA <= 0) {
            return -1;
        }
        int n3 = super.read(byArray, n, n2 = Math.min(n2, this.aEA));
        if (n3 >= 0) {
            this.aEA -= n3;
        }
        return n3;
    }

    @Override
    public long skip(long l) {
        long l2 = super.skip(Math.min(l, (long)this.aEA));
        if (l2 >= 0L) {
            this.aEA = (int)((long)this.aEA - l2);
        }
        return l2;
    }
}
