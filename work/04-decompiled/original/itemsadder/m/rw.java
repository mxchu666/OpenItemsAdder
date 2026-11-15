package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class rw
extends Record {
    private final String IJ;
    private final boolean IK;
    private final boolean IL;

    public rw(String string, boolean bl, boolean bl2) {
        this.IJ = string;
        this.IK = bl;
        this.IL = bl2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{rw.class, "command;asConsole;silent", "IJ", "IK", "IL"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{rw.class, "command;asConsole;silent", "IJ", "IK", "IL"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{rw.class, "command;asConsole;silent", "IJ", "IK", "IL"}, this, object);
    }

    public String oK() {
        return this.IJ;
    }

    public boolean oL() {
        return this.IK;
    }

    public boolean oM() {
        return this.IL;
    }
}
