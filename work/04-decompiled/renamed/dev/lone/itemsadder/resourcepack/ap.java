package dev.lone.itemsadder.resourcepack;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

final class ap
extends Record {
    private final String atT;
    private final String atU;
    private final String atV;
    private final List atW;
    private final String atX;

    ap(String string, String string2, String string3, List list, String string4) {
        list = List.copyOf(list);
        this.atT = string;
        this.atU = string2;
        this.atV = string3;
        this.atW = list;
        this.atX = string4;
    }

    String xY() {
        return "Modern atlas validation failed for material '" + FilenameUtils.getBaseName((String)this.atT) + "', item declaration '" + this.atT + "', root '" + this.atU + "', model '" + this.atV + "', parent chain '" + (this.atW.isEmpty() ? "<none>" : String.join((CharSequence)" -> ", this.atW)) + "': " + this.atX;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{ap.class, "declaration;root;model;chain;reason", "atT", "atU", "atV", "atW", "atX"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{ap.class, "declaration;root;model;chain;reason", "atT", "atU", "atV", "atW", "atX"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{ap.class, "declaration;root;model;chain;reason", "atT", "atU", "atV", "atW", "atX"}, this, object);
    }

    public String xX() {
        return this.atT;
    }

    public String zu() {
        return this.atU;
    }

    public String xL() {
        return this.atV;
    }

    public List zv() {
        return this.atW;
    }

    public String xQ() {
        return this.atX;
    }
}
