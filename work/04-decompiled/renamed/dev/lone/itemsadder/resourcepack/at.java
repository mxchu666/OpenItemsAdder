package dev.lone.itemsadder.resourcepack;

import com.alibaba.fastjson2.JSONObject;

public class at {
    JSONObject LP;
    int aud;

    public at(int n, JSONObject jSONObject) {
        this.LP = jSONObject;
        this.aud = n;
    }

    public static at w(JSONObject jSONObject) {
        int n = jSONObject.hashCode();
        return new at(n, jSONObject);
    }
}
