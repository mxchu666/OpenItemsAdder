package dev.lone.itemsadder.resourcepack;

import com.alibaba.fastjson2.JSONObject;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class ai
extends Record {
    private final JSONObject atk;
    private final int atl;

    private ai(JSONObject jSONObject, int n) {
        this.atk = jSONObject;
        this.atl = n;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{ai.class, "model;priority", "atk", "atl"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{ai.class, "model;priority", "atk", "atl"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{ai.class, "model;priority", "atk", "atl"}, this, object);
    }

    public JSONObject zf() {
        return this.atk;
    }

    public int ze() {
        return this.atl;
    }
}
