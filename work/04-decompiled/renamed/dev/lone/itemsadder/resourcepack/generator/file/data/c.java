package dev.lone.itemsadder.resourcepack.generator.file.data;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.b;

public class c
extends b {
    public c(String string) {
        super(string);
    }

    public String oC() {
        return ((JSONObject)this.ayp).getString("parent");
    }

    public boolean BI() {
        return ((JSONObject)this.ayp).containsKey("display");
    }

    public JSONObject BJ() {
        return ((JSONObject)this.ayp).getJSONObject("display");
    }

    public JSONObject BK() {
        return ((JSONObject)this.ayp).getJSONObject("textures");
    }

    public boolean BL() {
        return ((JSONObject)this.ayp).containsKey("textures");
    }

    public int BM() {
        if (!this.BL()) {
            return 0;
        }
        return this.BK().entrySet().size();
    }
}
