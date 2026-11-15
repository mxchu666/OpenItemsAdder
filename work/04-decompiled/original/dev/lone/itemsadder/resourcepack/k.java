package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.resourcepack.j;
import dev.lone.itemsadder.resourcepack.n;
import dev.lone.itemsadder.resourcepack.o;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class k
extends Record {
    private final String aqY;
    private final boolean aqZ;
    private final n ara;
    private final String arb;
    private final String arc;
    private final String ard;
    private final boolean are;
    private final boolean arf;

    k(String string, boolean bl, n n2, String string2, String string3, boolean bl2) {
        this(string, bl, n2, string2, string2, string3, bl2, false);
    }

    k(String string, boolean bl, n n2, String string2, String string3, boolean bl2, boolean bl3) {
        this(string, bl, n2, string2, string2, string3, bl2, bl3);
    }

    k(String string, boolean bl, n n2, String string2, String string3, String string4, boolean bl2, boolean bl3) {
        string = o.el(string);
        n2 = n2 == null ? n.UNKNOWN : n2;
        string2 = string2 == null || string2.isBlank() ? o.em(string) : string2;
        String string5 = string3 = string3 == null || string3.isBlank() ? string2 : string3;
        string4 = string4 == null || string4.isBlank() ? (bl ? "folder fallback; no blockstate root" : "folder fallback; no item declaration root") : string4;
        this.aqY = string;
        this.aqZ = bl;
        this.ara = n2;
        this.arb = string2;
        this.arc = string3;
        this.ard = string4;
        this.are = bl2;
        this.arf = bl3;
    }

    String xK() {
        return this.ara.ordinal() + "\u0000" + j.ei(this.aqY) + "\u0000" + this.aqY + "\u0000" + this.arc + "\u0000" + this.arb + "\u0000" + this.aqZ + "\u0000" + this.ard + "\u0000" + this.are + "\u0000" + this.arf;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{k.class, "model;block;provenance;physicalPath;sourcePath;reason;emitted;unusedCustomEntityModel", "aqY", "aqZ", "ara", "arb", "arc", "ard", "are", "arf"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{k.class, "model;block;provenance;physicalPath;sourcePath;reason;emitted;unusedCustomEntityModel", "aqY", "aqZ", "ara", "arb", "arc", "ard", "are", "arf"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{k.class, "model;block;provenance;physicalPath;sourcePath;reason;emitted;unusedCustomEntityModel", "aqY", "aqZ", "ara", "arb", "arc", "ard", "are", "arf"}, this, object);
    }

    public String xL() {
        return this.aqY;
    }

    public boolean xM() {
        return this.aqZ;
    }

    public n xN() {
        return this.ara;
    }

    public String xO() {
        return this.arb;
    }

    public String xP() {
        return this.arc;
    }

    public String xQ() {
        return this.ard;
    }

    public boolean xR() {
        return this.are;
    }

    public boolean xS() {
        return this.arf;
    }
}
