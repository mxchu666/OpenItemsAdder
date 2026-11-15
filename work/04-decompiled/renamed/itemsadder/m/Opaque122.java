package itemsadder.m;

import org.jetbrains.annotations.Nullable;

public class Opaque122 {
    @Nullable
    public Integer bv;
    @Nullable
    public Boolean bw;

    public Opaque122(@Nullable Integer n, @Nullable Boolean bl) {
        this.bv = n;
        this.bw = bl;
    }

    public boolean U() {
        return this.bv != null || this.bw != null;
    }
}
