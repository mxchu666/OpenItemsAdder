package itemsadder.m;

import org.jetbrains.annotations.Nullable;

public class i {
    @Nullable
    public Integer bv;
    @Nullable
    public Boolean bw;

    public i(@Nullable Integer n, @Nullable Boolean bl) {
        this.bv = n;
        this.bw = bl;
    }

    public boolean U() {
        return this.bv != null || this.bw != null;
    }
}
