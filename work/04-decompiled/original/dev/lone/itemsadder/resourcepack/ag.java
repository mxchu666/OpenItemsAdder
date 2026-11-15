package dev.lone.itemsadder.resourcepack;

import com.alibaba.fastjson2.JSONObject;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.Nullable;

final class ag
extends Record {
    @Nullable
    private final JSONObject atf;
    private final int atg;

    private ag(@Nullable JSONObject jSONObject, int n) {
        this.atf = jSONObject;
        this.atg = n;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{ag.class, "json;priority", "atf", "atg"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{ag.class, "json;priority", "atf", "atg"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{ag.class, "json;priority", "atf", "atg"}, this, object);
    }

    @Nullable
    public JSONObject zd() {
        return this.atf;
    }

    public int ze() {
        return this.atg;
    }
}
