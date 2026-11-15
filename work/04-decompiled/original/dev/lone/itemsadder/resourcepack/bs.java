package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.resourcepack.cb;
import dev.lone.itemsadder.resourcepack.cd;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Objects;

final class bs
extends Record {
    private final cb avZ;
    private final String awa;
    private final cd awb;
    private final String awc;
    private final String awd;
    private final int awe;
    private final int awf;
    private final String awg;
    private final List awh;

    bs(cb cb2, String string, cd cd2, String string2, String string3, int n, int n2, String string4, List list) {
        list = list == null ? List.of() : List.copyOf(list);
        this.avZ = cb2;
        this.awa = string;
        this.awb = cd2;
        this.awc = string2;
        this.awd = string3;
        this.awe = n;
        this.awf = n2;
        this.awg = string4;
        this.awh = list;
    }

    String Af() {
        StringBuilder stringBuilder = new StringBuilder("[").append((Object)this.avZ).append("] ").append(this.awa);
        if (this.awd != null) {
            stringBuilder.append("\nFile: ").append(this.awd);
            if (this.awe > 0) {
                stringBuilder.append(':').append(this.awe);
            }
            if (this.awf > 0) {
                stringBuilder.append(':').append(this.awf);
            }
        }
        if (this.awb != cd.NONE) {
            stringBuilder.append("\nStage: ").append((Object)this.awb);
        }
        if (this.awc != null && !Objects.equals(this.awc, this.awd)) {
            stringBuilder.append("\nResource: ").append(this.awc);
        }
        stringBuilder.append("\n").append(this.awg);
        if (this.awh.size() > 1) {
            stringBuilder.append("\nInclude stack: ").append(String.join((CharSequence)" -> ", this.awh));
        }
        return stringBuilder.toString();
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{bs.class, "severity;code;stage;resourcePath;originalFile;line;column;message;includeStack", "avZ", "awa", "awb", "awc", "awd", "awe", "awf", "awg", "awh"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{bs.class, "severity;code;stage;resourcePath;originalFile;line;column;message;includeStack", "avZ", "awa", "awb", "awc", "awd", "awe", "awf", "awg", "awh"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{bs.class, "severity;code;stage;resourcePath;originalFile;line;column;message;includeStack", "avZ", "awa", "awb", "awc", "awd", "awe", "awf", "awg", "awh"}, this, object);
    }

    public cb Ag() {
        return this.avZ;
    }

    public String Ah() {
        return this.awa;
    }

    public cd Ai() {
        return this.awb;
    }

    public String Aj() {
        return this.awc;
    }

    public String Ak() {
        return this.awd;
    }

    public int Ad() {
        return this.awe;
    }

    public int Ae() {
        return this.awf;
    }

    public String xY() {
        return this.awg;
    }

    public List Al() {
        return this.awh;
    }
}
