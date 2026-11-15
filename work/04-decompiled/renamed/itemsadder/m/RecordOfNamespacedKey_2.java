package itemsadder.m;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.Nullable;

public final class RecordOfNamespacedKey_2
extends Record {
    private final NamespacedKey Iy;
    @Nullable
    private final String Iz;
    @Nullable
    private final String IA;
    @Nullable
    private final String IB;

    public RecordOfNamespacedKey_2(NamespacedKey namespacedKey, String string, String string2) {
        this(namespacedKey, string, string2, null);
    }

    public RecordOfNamespacedKey_2(NamespacedKey namespacedKey, @Nullable String string, @Nullable String string2, @Nullable String string3) {
        this.Iy = namespacedKey;
        this.Iz = string;
        this.IA = string2;
        this.IB = string3;
    }

    public static RecordOfNamespacedKey_2 a(NamespacedKey namespacedKey, String string) {
        return new RecordOfNamespacedKey_2(namespacedKey, null, null, string);
    }

    public boolean ov() {
        return this.IB != null;
    }

    public JSONObject ow() {
        JSONObject jSONObject = new JSONObject();
        if (this.ov()) {
            jSONObject.put((Object)"wings", (Object)RecordOfNamespacedKey_2.cb(this.Iy.toString()));
        } else {
            jSONObject.put((Object)"humanoid", (Object)RecordOfNamespacedKey_2.cb(this.Iy.toString()));
            jSONObject.put((Object)"humanoid_leggings", (Object)RecordOfNamespacedKey_2.cb(this.Iy.toString()));
        }
        return new JSONObject().fluentPut("layers", (Object)jSONObject);
    }

    private static JSONArray cb(String string) {
        return new JSONArray().fluentAdd((Object)new JSONObject().fluentPut("texture", (Object)string));
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfNamespacedKey_2.class, "id;layer1;layer2;wings", "Iy", "Iz", "IA", "IB"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfNamespacedKey_2.class, "id;layer1;layer2;wings", "Iy", "Iz", "IA", "IB"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfNamespacedKey_2.class, "id;layer1;layer2;wings", "Iy", "Iz", "IA", "IB"}, this, object);
    }

    public NamespacedKey ox() {
        return this.Iy;
    }

    @Nullable
    public String oy() {
        return this.Iz;
    }

    @Nullable
    public String oz() {
        return this.IA;
    }

    @Nullable
    public String oA() {
        return this.IB;
    }
}
