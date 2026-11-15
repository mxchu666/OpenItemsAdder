package dev.lone.itemsadder.utils.json;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.google.gson.JsonSyntaxException;
import com.jayway.jsonpath.DocumentContext;
import dev.lone.itemsadder.utils.json.a;
import dev.lone.itemsadder.utils.json.d;
import itemsadder.m.PermissibleBridge;
import itemsadder.m.VectorBridgeImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class c {
    private static final Set aCQ = Set.of(Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class);

    public static VectorBridgeImpl c(JSONArray jSONArray) {
        return new VectorBridgeImpl(jSONArray.getFloat(0).floatValue() / 16.0f, jSONArray.getFloat(1).floatValue() / 16.0f, jSONArray.getFloat(2).floatValue() / 16.0f);
    }

    public static double a(JSONObject jSONObject, String string, double d) {
        if (!jSONObject.containsKey(string)) {
            return d;
        }
        return jSONObject.getDouble(string);
    }

    public static VectorBridgeImpl d(JSONArray jSONArray) {
        return new VectorBridgeImpl(jSONArray.getFloat(0).floatValue(), jSONArray.getFloat(1).floatValue(), jSONArray.getFloat(2).floatValue());
    }

    public static boolean o(JSONObject jSONObject, String string) {
        return c.d(jSONObject, string, false);
    }

    public static boolean d(JSONObject jSONObject, String string, boolean bl) {
        if (!jSONObject.containsKey(string)) {
            return bl;
        }
        return jSONObject.getBoolean(string);
    }

    public static String c(JSONObject jSONObject, String string, String string2) {
        if (!jSONObject.containsKey(string)) {
            return string2;
        }
        return jSONObject.getString(string);
    }

    public static String[] e(JSONArray jSONArray) {
        String[] stringArray = new String[jSONArray != null ? jSONArray.size() : 0];
        if (jSONArray != null) {
            int n = 0;
            for (Object e : jSONArray) {
                stringArray[n++] = (String)e;
            }
        }
        return stringArray;
    }

    public static JSONObject N(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath(), new OpenOption[0]), StandardCharsets.UTF_8));){
            JSONObject jSONObject = JSONReader.of((Reader)bufferedReader).readJSONObject();
            return jSONObject;
        }
    }

    public static JSONObject jh(String string) {
        return JSON.parseObject((String)string);
    }

    public static void ji(String string) {
        try {
            a.aCP.fromJson(string, Object.class);
        }
        catch (JsonSyntaxException jsonSyntaxException) {
            String string2 = jsonSyntaxException.getMessage();
            if (string2 != null && string2.contains("line")) {
                String[] stringArray = string2.split("\n");
                String string3 = stringArray[0];
                try {
                    int n = string3.indexOf("line ");
                    int n2 = string3.indexOf(" column ");
                    if (n != -1 && n2 != -1) {
                        int n3 = Integer.parseInt(string3.substring(n + 5, string3.indexOf(" ", n + 5)));
                        int n4 = Integer.parseInt(string3.substring(n2 + 8, string3.indexOf(" ", n2 + 8)));
                        StringBuilder stringBuilder = new StringBuilder("Error at line ").append(n3).append(", column ").append(n4);
                        if (n3 > 1) {
                            stringBuilder.append("\n...");
                        }
                        stringBuilder.append("\n");
                        String[] stringArray2 = string.split("\\r?\\n");
                        for (int i = n3 - 1; i < Math.min(stringArray2.length, n3 + 5); ++i) {
                            String string4 = stringArray2[i];
                            stringBuilder.append(i + 1).append(": ").append(string4).append("\n");
                        }
                        if (n3 + 5 < stringArray2.length) {
                            stringBuilder.append("...\n");
                        }
                        throw new ExecutionException(stringBuilder.toString(), jsonSyntaxException);
                    }
                }
                catch (NumberFormatException numberFormatException) {
                    throw new ExecutionException("Failed to parse line/column information: " + string3, numberFormatException);
                }
            }
            throw new ExecutionException("Unexpected JSON error: " + string2, jsonSyntaxException);
        }
    }

    public static String J(JSONObject jSONObject) {
        try (JSONWriter jSONWriter = JSONWriter.of((JSONWriter.Feature[])new JSONWriter.Feature[]{JSONWriter.Feature.LargeObject});){
            jSONWriter.setRootObject((Object)jSONObject);
            jSONWriter.write(jSONObject);
            String string = jSONWriter.toString();
            return string;
        }
    }

    public static String K(JSONObject jSONObject) {
        return JSON.toJSONString((Object)jSONObject);
    }

    public static String p(Map map) {
        return JSON.toJSONString((Object)new JSONObject(map));
    }

    public static Map jj(String string) {
        return (Map)c.jh(string).toJavaObject(Map.class, new JSONReader.Feature[0]);
    }

    public static JSONObject e(JSONObject jSONObject, String string, JSONObject jSONObject2) {
        if (jSONObject.containsKey(string)) {
            return jSONObject.getJSONObject(string);
        }
        return jSONObject2;
    }

    public static JSONArray f(JSONArray jSONArray) {
        return (JSONArray)JSON.copy((Object)jSONArray, (JSONWriter.Feature[])new JSONWriter.Feature[0]);
    }

    public static JSONObject a(JSONObject jSONObject) {
        return (JSONObject)JSON.copy((Object)jSONObject, (JSONWriter.Feature[])new JSONWriter.Feature[0]);
    }

    public static void d(JSONObject jSONObject, JSONObject jSONObject2) {
        jSONObject.putAll((Map)jSONObject2);
    }

    public static DocumentContext L(JSONObject jSONObject) {
        return d.aCR.parse(jSONObject.toString());
    }

    public static boolean N(Object object) {
        if (object == JSONObject.class || object == JSONArray.class) {
            return false;
        }
        return aCQ.contains(object.getClass());
    }

    public static String a(JSONObject jSONObject, boolean bl, boolean bl2) {
        String string = bl2 ? JSON.toJSONString((Object)jSONObject, (JSONWriter.Feature[])new JSONWriter.Feature[]{JSONWriter.Feature.MapSortField, JSONWriter.Feature.PrettyFormat}) : JSON.toJSONString((Object)jSONObject);
        return bl ? PermissibleBridge.aX(string) : string;
    }

    public static void a(File file, JSONObject jSONObject) {
        try {
            Files.writeString(file.toPath(), (CharSequence)c.K(jSONObject), StandardCharsets.UTF_8, new OpenOption[0]);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Failed to write JSON to file: " + file.getAbsolutePath(), iOException);
        }
    }
}
