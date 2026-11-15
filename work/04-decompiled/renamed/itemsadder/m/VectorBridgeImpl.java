package itemsadder.m;

import itemsadder.m.VectorBridge_2;
import org.bukkit.util.NumberConversions;
import org.jetbrains.annotations.NotNull;

public class VectorBridgeImpl
extends VectorBridge_2 {
    private boolean aAh;
    private int BP;

    public VectorBridgeImpl(float f, float f2, float f3) {
        super(f, f2, f3);
    }

    VectorBridgeImpl(float f, float f2, float f3, int n) {
        super(f, f2, f3);
        this.BP = n;
        this.aAh = true;
    }

    public boolean Bc() {
        return this.aBp == 0.0f && this.aBq == 0.0f && this.aBr == 0.0f;
    }

    public double a(@NotNull VectorBridgeImpl vectorBridgeImpl) {
        return Math.sqrt(NumberConversions.square((double)(this.aBp - vectorBridgeImpl.aBp)) + NumberConversions.square((double)(this.aBq - vectorBridgeImpl.aBq)) + NumberConversions.square((double)(this.aBr - vectorBridgeImpl.aBr)));
    }

    public double b(@NotNull VectorBridgeImpl vectorBridgeImpl) {
        return Math.sqrt(NumberConversions.square((double)(this.aBp - vectorBridgeImpl.aBp)) + NumberConversions.square((double)(this.aBr - vectorBridgeImpl.aBr)));
    }

    @Override
    public String toString() {
        return "ImmutableVecF{x=" + this.aBp + ", y=" + this.aBq + ", z=" + this.aBr + "}";
    }

    public VectorBridgeImpl CW() {
        return new VectorBridgeImpl(this.aBp, this.aBq, this.aBr, this.BP);
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

    public boolean c(VectorBridgeImpl vectorBridgeImpl) {
        if (this == vectorBridgeImpl) {
            return true;
        }
        if (this.aAh && vectorBridgeImpl.aAh) {
            return this.BP == vectorBridgeImpl.BP;
        }
        return this.hashCode() == vectorBridgeImpl.hashCode();
    }

    @Override
    public /* synthetic */ VectorBridge_2 CX() {
        return this.CW();
    }
}
