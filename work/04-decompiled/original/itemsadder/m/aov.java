package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class aov
extends Record {
    private final boolean akj;
    private final boolean akk;
    private final boolean akl;
    private final boolean akm;
    private final boolean akn;
    private final boolean ako;
    private final boolean akp;

    public aov(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.akj = bl;
        this.akk = bl2;
        this.akl = bl3;
        this.akm = bl4;
        this.akn = bl5;
        this.ako = bl6;
        this.akp = bl7;
    }

    public boolean eu() {
        return this.akj || this.akk || this.akl || this.akm;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{aov.class, "forward;backward;left;right;jump;shift;sprint", "akj", "akk", "akl", "akm", "akn", "ako", "akp"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{aov.class, "forward;backward;left;right;jump;shift;sprint", "akj", "akk", "akl", "akm", "akn", "ako", "akp"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{aov.class, "forward;backward;left;right;jump;shift;sprint", "akj", "akk", "akl", "akm", "akn", "ako", "akp"}, this, object);
    }

    public boolean uG() {
        return this.akj;
    }

    public boolean uH() {
        return this.akk;
    }

    public boolean uI() {
        return this.akl;
    }

    public boolean uJ() {
        return this.akm;
    }

    public boolean uK() {
        return this.akn;
    }

    public boolean uL() {
        return this.ako;
    }

    public boolean uM() {
        return this.akp;
    }
}
