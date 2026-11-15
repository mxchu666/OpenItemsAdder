package dev.lone.itemsadder.resourcepack;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class by
extends Record {
    private final String awz;
    private final String awA;

    private by(String string, String string2) {
        this.awz = string;
        this.awA = string2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{by.class, "vertex;fragment", "awz", "awA"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{by.class, "vertex;fragment", "awz", "awA"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{by.class, "vertex;fragment", "awz", "awA"}, this, object);
    }

    public String Ay() {
        return this.awz;
    }

    public String Az() {
        return this.awA;
    }
}
