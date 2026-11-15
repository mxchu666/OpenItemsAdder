package itemsadder.m;

import itemsadder.m.StepFunction;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import org.jetbrains.annotations.NotNull;

class Opaque050
extends FilterOutputStream {
    private final StepFunction aCT;
    private long aCU;

    Opaque050(OutputStream outputStream, StepFunction stepFunction) {
        super(outputStream);
        this.aCT = stepFunction;
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
