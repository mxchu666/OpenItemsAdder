package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.api.Events.ItemsAdderPackCompressedEvent;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class aj
extends Record {
    private final String atm;
    private final ItemsAdderPackCompressedEvent.PackEntry atn;

    private aj(String string, ItemsAdderPackCompressedEvent.PackEntry packEntry) {
        this.atm = string;
        this.atn = packEntry;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{aj.class, "path;entry", "atm", "atn"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{aj.class, "path;entry", "atm", "atn"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{aj.class, "path;entry", "atm", "atn"}, this, object);
    }

    public String pK() {
        return this.atm;
    }

    public ItemsAdderPackCompressedEvent.PackEntry yu() {
        return this.atn;
    }
}
