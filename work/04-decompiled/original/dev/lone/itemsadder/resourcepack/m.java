package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.resourcepack.al;
import dev.lone.itemsadder.resourcepack.ap;
import dev.lone.itemsadder.resourcepack.aq;
import dev.lone.itemsadder.resourcepack.ar;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Locale;

final class m
extends Record {
    private final ar arj;
    private final al ark;
    private final boolean arl;
    private final String arm;
    private final String arn;
    private final String aro;
    private final String arp;

    private m(ar ar2, al al2, boolean bl, String string, String string2, String string3, String string4) {
        this.arj = ar2;
        this.ark = al2;
        this.arl = bl;
        this.arm = string;
        this.arn = string2;
        this.aro = string3;
        this.arp = string4;
    }

    static m a(aq aq2) {
        return new m(aq2.xU(), aq2.xV(), false, "", "", "", aq2.xY());
    }

    static m a(aq aq2, ap ap2) {
        String string = ap2.xQ();
        int n = string.indexOf(" or matching Vanilla model for ");
        if (n >= 0) {
            string = string.substring(0, n);
        }
        return new m(aq2.xU(), aq2.xV(), true, ap2.xX(), ap2.xL(), string, "");
    }

    boolean xT() {
        return this.arl && this.aro.startsWith("original model reference is unresolved");
    }

    String sp() {
        if (this.xT()) {
            return "Missing model: " + this.arn;
        }
        if (this.arl && this.aro.startsWith("item model has unresolved face texture slots")) {
            return "Model has unresolved textures: " + this.arn;
        }
        if (this.arl && this.aro.startsWith("cannot read texture value")) {
            return "Invalid texture value in model: " + this.arn;
        }
        if (this.arl && this.aro.contains("has no selected pack entry")) {
            return "Missing texture file referenced by model: " + this.arn;
        }
        if (this.arl && this.aro.contains("atlas")) {
            return "Texture is missing from the item/block atlas: " + this.arn;
        }
        return this.arj.name().toLowerCase(Locale.ROOT).replace('_', ' ') + (String)(this.arl ? ": " + this.arn : "");
    }

    String xK() {
        return this.sp() + "\u0000" + this.arm + "\u0000" + this.arn + "\u0000" + String.valueOf((Object)this.ark) + "\u0000" + this.aro + "\u0000" + this.arp;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{m.class, "kind;provenance;tree;declaration;model;reason;message", "arj", "ark", "arl", "arm", "arn", "aro", "arp"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{m.class, "kind;provenance;tree;declaration;model;reason;message", "arj", "ark", "arl", "arm", "arn", "aro", "arp"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{m.class, "kind;provenance;tree;declaration;model;reason;message", "arj", "ark", "arl", "arm", "arn", "aro", "arp"}, this, object);
    }

    public ar xU() {
        return this.arj;
    }

    public al xV() {
        return this.ark;
    }

    public boolean xW() {
        return this.arl;
    }

    public String xX() {
        return this.arm;
    }

    public String xL() {
        return this.arn;
    }

    public String xQ() {
        return this.aro;
    }

    public String xY() {
        return this.arp;
    }
}
