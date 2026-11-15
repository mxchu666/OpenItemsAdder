package dev.lone.itemsadder.resourcepack.generator.file.data;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

public abstract class JsonAsset {
    protected String KA;
    protected Object ayp;
    @Nullable
    Exception ayq = null;

    public boolean BN() {
        return this.ayq != null;
    }

    @Nullable
    public Exception BO() {
        return this.ayq;
    }

    public JSONArray BP() {
        return (JSONArray)this.ayp;
    }

    public JSONObject BQ() {
        return (JSONObject)this.ayp;
    }

    public JSONObject gh(String string) {
        return this.BQ().getJSONObject(string);
    }

    public JSONArray gi(String string) {
        return this.BQ().getJSONArray(string);
    }

    public JSONObject BR() {
        return (JSONObject)JSON.copy((Object)this.ayp, (JSONWriter.Feature[])new JSONWriter.Feature[0]);
    }

    @Generated
    public String getPath() {
        return this.KA;
    }
}
