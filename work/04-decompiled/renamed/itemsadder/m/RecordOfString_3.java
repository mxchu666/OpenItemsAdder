package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class RecordOfString_3
extends Record {
    private final String aBA;
    private final int aBB;
    private final int aBC;

    RecordOfString_3(String string, int n, int n2) {
        this.aBA = string;
        this.aBB = n;
        this.aBC = n2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfString_3.class, "path;firstLine;repeatedLine", "aBA", "aBB", "aBC"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfString_3.class, "path;firstLine;repeatedLine", "aBA", "aBB", "aBC"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfString_3.class, "path;firstLine;repeatedLine", "aBA", "aBB", "aBC"}, this, object);
    }

    public String pK() {
        return this.aBA;
    }

    public int DD() {
        return this.aBB;
    }

    public int DE() {
        return this.aBC;
    }
}
