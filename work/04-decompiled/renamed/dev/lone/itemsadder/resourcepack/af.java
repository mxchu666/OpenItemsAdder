package dev.lone.itemsadder.resourcepack;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Set;

final class af
extends Record {
    private final Set atd;
    private final Set ate;

    private af(Set set, Set set2) {
        this.atd = set;
        this.ate = set2;
    }

    boolean fo(String string) {
        int n = string.lastIndexOf(47);
        return n > 0 && this.ate.contains(string.substring(0, n));
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{af.class, "supportModels;modelFolders", "atd", "ate"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{af.class, "supportModels;modelFolders", "atd", "ate"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{af.class, "supportModels;modelFolders", "atd", "ate"}, this, object);
    }

    public Set zb() {
        return this.atd;
    }

    public Set zc() {
        return this.ate;
    }
}
