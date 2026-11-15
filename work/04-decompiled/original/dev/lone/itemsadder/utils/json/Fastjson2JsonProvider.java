package dev.lone.itemsadder.utils.json;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONReader;
import com.jayway.jsonpath.JsonPathException;
import com.jayway.jsonpath.spi.json.AbstractJsonProvider;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.bcg;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@bcg
public class Fastjson2JsonProvider
extends AbstractJsonProvider {
    public Object unwrap(Object object) {
        return object;
    }

    public Object parse(String string) {
        return JSON.parse((String)string);
    }

    public Object parse(InputStream inputStream, String string) {
        try {
            JSONReader jSONReader = JSONReader.of((Reader)new InputStreamReader(inputStream, string));
            JSONObject jSONObject = jSONReader.readJSONObject();
            jSONReader.close();
            return jSONObject;
        }
        catch (Throwable throwable) {
            throw new JsonPathException(throwable);
        }
    }

    public String toJson(Object object) {
        return JSON.toJSONString((Object)object);
    }

    public Object createArray() {
        return new JSONArray();
    }

    public Object createMap() {
        return new JSONObject();
    }

    public boolean isArray(Object object) {
        return object instanceof JSONObject || object instanceof List;
    }

    public Object getArrayIndex(Object object, int n) {
        return this.toJsonArray(object).get(n);
    }

    public void setArrayIndex(Object object, int n, Object object2) {
        if (!this.isArray(object)) {
            throw new UnsupportedOperationException();
        }
        JSONArray jSONArray = this.toJsonArray(object);
        if (n == jSONArray.size()) {
            jSONArray.add(object2);
        } else {
            jSONArray.set(n, object2);
        }
    }

    public Object getMapValue(Object object, String string) {
        JSONObject jSONObject = this.toJsonObject(object);
        Object object2 = jSONObject.get(string);
        if (!jSONObject.containsKey(string)) {
            return UNDEFINED;
        }
        return this.unwrap(object2);
    }

    public void setProperty(Object object, Object object2, Object object3) {
        if (this.isMap(object)) {
            this.toJsonObject(object).put((Object)object2.toString(), object3);
        } else {
            JSONArray jSONArray;
            int n = object2 != null ? (object2 instanceof Integer ? (Integer)object2 : Integer.parseInt(object2.toString())) : jSONArray.size();
            if (n == (jSONArray = this.toJsonArray(object)).size()) {
                jSONArray.add(object3);
            } else {
                jSONArray.set(n, object3);
            }
        }
    }

    public void removeProperty(Object object, Object object2) {
        if (this.isMap(object)) {
            this.toJsonObject(object).remove((Object)object2.toString());
        } else {
            JSONArray jSONArray = this.toJsonArray(object);
            int n = object2 instanceof Integer ? (Integer)object2 : Integer.parseInt(object2.toString());
            jSONArray.remove(n);
        }
    }

    public boolean isMap(Object object) {
        return object instanceof JSONObject;
    }

    public Collection getPropertyKeys(Object object) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Map.Entry entry : this.toJsonObject(object).entrySet()) {
            arrayList.add((String)entry.getKey());
        }
        return arrayList;
    }

    public int length(Object object) {
        if (this.isArray(object)) {
            return this.toJsonArray(object).size();
        }
        if (this.isMap(object)) {
            return this.toJsonObject(object).entrySet().size();
        }
        if (c.N(object)) {
            return object.toString().length();
        }
        throw new JsonPathException("length operation can not applied to " + (object != null ? object.getClass().getName() : "null"));
    }

    public Iterable toIterable(Object object) {
        JSONArray jSONArray = this.toJsonArray(object);
        ArrayList<Object> arrayList = new ArrayList<Object>(jSONArray.size());
        for (Object e : jSONArray) {
            arrayList.add(this.unwrap(e));
        }
        return arrayList;
    }

    private JSONArray toJsonArray(Object object) {
        return (JSONArray)object;
    }

    private JSONObject toJsonObject(Object object) {
        return (JSONObject)object;
    }
}
