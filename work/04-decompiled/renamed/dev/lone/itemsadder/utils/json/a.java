package dev.lone.itemsadder.utils.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PermissibleBridge;
import java.util.Map;

public class a {
    public static final Gson aCO = new GsonBuilder().disableHtmlEscaping().create();
    public static final Gson aCP = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

    public static JsonObject jf(String string) {
        return ItemStackRegistry.d.fromJson(string, JsonObject.class);
    }

    public static String a(JsonObject jsonObject, boolean bl, boolean bl2) {
        String string = bl2 ? aCO.toJson(jsonObject) : aCP.toJson(jsonObject);
        return bl ? PermissibleBridge.aX(string) : string;
    }

    public static JsonElement a(JsonElement jsonElement) {
        Class<?> clazz = jsonElement.getClass();
        return (JsonElement)ItemStackRegistry.d.fromJson(jsonElement.toString(), clazz);
    }

    public static String d(JsonObject jsonObject) {
        return ItemStackRegistry.d.toJson(jsonObject);
    }

    public static void a(JsonObject jsonObject, JsonObject jsonObject2) {
        for (Map.Entry<String, JsonElement> entry : jsonObject2.entrySet()) {
            jsonObject.add(entry.getKey(), entry.getValue());
        }
    }

    public static String jg(String string) {
        return aCP.toJson(a.jf(string));
    }
}
