package itemsadder.m;

import itemsadder.m.bda;
import org.bukkit.util.NumberConversions;
import org.jetbrains.annotations.NotNull;

public class bbq
extends bda {
    private boolean aAh;
    private int BP;

    public bbq(float f, float f2, float f3) {
        super(f, f2, f3);
    }

    bbq(float f, float f2, float f3, int n) {
        super(f, f2, f3);
        this.BP = n;
        this.aAh = true;
    }

    public boolean Bc() {
        return this.aBp == 0.0f && this.aBq == 0.0f && this.aBr == 0.0f;
    }

    public double a(@NotNull bbq bbq2) {
        return Math.sqrt(NumberConversions.square((double)(this.aBp - bbq2.aBp)) + NumberConversions.square((double)(this.aBq - bbq2.aBq)) + NumberConversions.square((double)(this.aBr - bbq2.aBr)));
    }

    public double b(@NotNull bbq bbq2) {
        return Math.sqrt(NumberConversions.square((double)(this.aBp - bbq2.aBp)) + NumberConversions.square((double)(this.aBr - bbq2.aBr)));
    }

    @Override
    public String toString() {
        return "ImmutableVecF{x=" + this.aBp + ", y=" + this.aBq + ", z=" + this.aBr + "}";
    }

    public bbq CW() {
        return new bbq(this.aBp, this.aBq, this.aBr, this.BP);
    }

    @Override
    public int hashCode() {
        if (this.aAh) {
            return this.BP;
        }
        this.BP = 7;
        this.BP = 79 * this.BP + (int)(Double.doubleToLongBits(this.aBp) ^ Double.doubleToLongBits(this.aBp) >>> 32);
        this.BP = 79 * this.BP + (int)(Double.doubleToLongBits(this.aBq) ^ Double.doubleToLongBits(this.aBq) >>> 32);
        this.BP = 79 * this.BP + (int)(Double.doubleToLongBits(this.aBr) ^ Double.doubleToLongBits(this.aBr) >>> 32);
        this.aAh = true;
        return this.BP;
    }

    public boolean c(bbq bbq2) {
        if (this == bbq2) {
            return true;
        }
        if (this.aAh && bbq2.aAh) {
            return this.BP == bbq2.BP;
        }
        return this.hashCode() == bbq2.hashCode();
    }

    @Override
    public /* synthetic */ bda CX() {
        return this.CW();
    }
}
