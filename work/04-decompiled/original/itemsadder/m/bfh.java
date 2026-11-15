package itemsadder.m;

import itemsadder.m.bfi;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import org.jetbrains.annotations.NotNull;

class bfh
extends FilterOutputStream {
    private final bfi aCT;
    private long aCU;

    bfh(OutputStream outputStream, bfi bfi2) {
        super(outputStream);
        this.aCT = bfi2;
        this.aCU = 0L;
    }

    @Override
    public void write(byte @NotNull [] byArray, int n, int n2) {
        this.out.write(byArray, n, n2);
        this.aCU += (long)n2;
        this.aCT.step(this.aCU);
    }

    @Override
    public void write(int n) {
        this.out.write(n);
        ++this.aCU;
        this.aCT.step(this.aCU);
    }
}
