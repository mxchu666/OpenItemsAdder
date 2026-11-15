package dev.lone.itemsadder.resourcepack;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.al;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.Nullable;

final class au
extends Record {
    @Nullable
    private final JSONObject aue;
    private final al auf;

    private au(@Nullable JSONObject jSONObject, al al2) {
        this.aue = jSONObject;
        this.auf = al2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{au.class, "model;provenance", "aue", "auf"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{au.class, "model;provenance", "aue", "auf"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{au.class, "model;provenance", "aue", "auf"}, this, object);
    }

    @Nullable
    public JSONObject zf() {
        return this.aue;
    }

    public al xV() {
        return this.auf;
    }
}
