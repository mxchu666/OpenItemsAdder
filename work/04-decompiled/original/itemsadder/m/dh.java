package itemsadder.m;

import org.jetbrains.annotations.Nullable;

public class dh {
    @Nullable
    public Integer mr;
    @Nullable
    public Integer ms;
    @Nullable
    public Integer mt;

    public dh(@Nullable Integer n, @Nullable Integer n2, @Nullable Integer n3) {
        this.mr = n;
        this.ms = n2;
        this.mt = n3;
    }

    public String toString() {
        return "Side{x=" + this.mr + ", y=" + this.ms + ", z=" + this.mt + "}";
    }

    public dh dN() {
        return new dh(this.mr, this.ms, this.mt);
    }
}
