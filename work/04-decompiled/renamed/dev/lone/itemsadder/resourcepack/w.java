package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.api.Events.ItemsAdderPackCompressedEvent;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class w
extends Record {
    private final String arP;
    private final ItemsAdderPackCompressedEvent.PackEntry arQ;

    private w(String string, ItemsAdderPackCompressedEvent.PackEntry packEntry) {
        this.arP = string;
        this.arQ = packEntry;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{w.class, "mapKey;entry", "arP", "arQ"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{w.class, "mapKey;entry", "arP", "arQ"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{w.class, "mapKey;entry", "arP", "arQ"}, this, object);
    }

    public String yt() {
        return this.arP;
    }

    public ItemsAdderPackCompressedEvent.PackEntry yu() {
        return this.arQ;
    }
}
