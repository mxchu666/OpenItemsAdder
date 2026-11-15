package itemsadder.m;

import org.jetbrains.annotations.Nullable;

public class Opaque110 {
    @Nullable
    public Integer mr;
    @Nullable
    public Integer ms;
    @Nullable
    public Integer mt;

    public Opaque110(@Nullable Integer n, @Nullable Integer n2, @Nullable Integer n3) {
        this.mr = n;
        this.ms = n2;
        this.mt = n3;
    }

    public String toString() {
        return "Side{x=" + this.mr + ", y=" + this.ms + ", z=" + this.mt + "}";
    }

    public Opaque110 dN() {
        return new Opaque110(this.mr, this.ms, this.mt);
    }
}
