package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.r;
import itemsadder.m.ColorBridge;
import itemsadder.m.MaterialBarColorHolder;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

final class v
extends Record {
    private final List arN;
    private final List arO;

    private v(List list, List list2) {
        this.arN = list;
        this.arO = list2;
    }

    private static v yq() {
        if (Main.rS() == null) {
            return new v(List.of(), List.of());
        }
        try {
            Path path = r.d(Main.rS().getDataFolder().toPath());
            List<Path> list = List.of(r.d(path.resolve("contents")), r.d(path.resolve("data/resource_pack")), r.d(path.resolve("data/items_packs")));
            ArrayList<Path> arrayList = new ArrayList<Path>();
            Path path2 = path.getParent();
            if (path2 != null && MaterialBarColorHolder.et != null) {
                for (String string : MaterialBarColorHolder.et) {
                    String string2 = ColorBridge.aE(string, "plugins/");
                    arrayList.add(r.d(path2.resolve(string2)));
                }
            }
            return new v(list, List.copyOf(arrayList));
        }
        catch (RuntimeException runtimeException) {
            return new v(List.of(), List.of());
        }
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{v.class, "user;external", "arN", "arO"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{v.class, "user;external", "arN", "arO"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{v.class, "user;external", "arN", "arO"}, this, object);
    }

    public List yr() {
        return this.arN;
    }

    public List ys() {
        return this.arO;
    }
}
