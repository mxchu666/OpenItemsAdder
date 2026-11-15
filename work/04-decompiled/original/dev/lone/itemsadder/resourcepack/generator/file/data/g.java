package dev.lone.itemsadder.resourcepack.generator.file.data;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.a;
import itemsadder.m.bcy;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

public class g {
    public final String ays;
    public final JSONObject ayt;
    public final List ayu;
    public final List ayv = new ArrayList();

    public g(String string, JSONObject jSONObject) {
        this.ays = bcy.iR(string);
        this.ayt = jSONObject;
        this.ayu = new ArrayList();
    }

    public void e(a a2) {
        this.ayu.add(a2);
    }

    public void aw(String string, String string2) {
        this.e(new a(string, string2));
    }

    public void e(File file, String string) {
        this.e(new a(file, string));
    }

    public String BU() {
        return this.ays.substring(this.ays.indexOf("assets") + "assets".length() + 1);
    }

    public Set BV() {
        HashSet<String> hashSet = new HashSet<String>();
        JSONObject jSONObject = this.ayt.getJSONObject("textures");
        if (jSONObject == null) {
            return hashSet;
        }
        for (Map.Entry entry : jSONObject.entrySet()) {
            Object object = (String)entry.getValue();
            if (a.gf((String)object)) continue;
            if (!((String)object).contains(":")) {
                object = "minecraft:" + (String)object;
            }
            hashSet.add((String)object);
        }
        return hashSet;
    }

    @Nullable
    public String oC() {
        return this.ayt.getString("parent");
    }

    public String BW() {
        return g.gl(this.ays);
    }

    public boolean BX() {
        String string = this.BW();
        return g.gk(string);
    }

    public static boolean gk(String string) {
        String string2 = string.split(":")[1];
        return string2.startsWith("block/") || string2.startsWith("blocks/");
    }

    public static String C(File file) {
        String string = bcy.iR(file.getPath());
        return g.gl(string);
    }

    public static String gl(String string) {
        int n;
        String string2;
        if ((string = bcy.iR(string)).contains(":") && !string.contains(":/") && !string.contains(":\\")) {
            return string;
        }
        int n2 = g.ax(string, "assets");
        if (n2 != -1) {
            string2 = string.substring(n2 + "assets".length() + 1);
        } else {
            n = g.ax(string, "contents");
            if (n == -1) {
                throw new IllegalArgumentException("Path does not contain 'assets' or 'contents' folder: " + string);
            }
            string2 = string.substring(n + "contents".length() + 1);
        }
        n = string2.indexOf(47);
        if (n == -1) {
            throw new IllegalArgumentException("Cannot read namespace from path: " + string);
        }
        String string3 = string2.substring(0, n);
        int n3 = g.ax(string2, "models");
        if (n3 == -1) {
            throw new IllegalArgumentException("Path does not contain 'models' folder after assets/contents: " + string);
        }
        String string4 = string2.substring(n3 + "models".length() + 1);
        String string5 = string4.endsWith(".json") ? string4.substring(0, string4.length() - ".json".length()) : string4;
        return string3 + ":" + string5;
    }

    private static int ax(String string, String string2) {
        String string3 = "/" + string2 + "/";
        int n = string.indexOf(string3);
        if (n != -1) {
            return n + 1;
        }
        if (string.startsWith(string2 + "/")) {
            return 0;
        }
        return -1;
    }

    public void gm(String string) {
        this.ayv.add(string);
    }

    public boolean gn(String string) {
        return this.ayv.contains(string);
    }

    @Generated
    public List BY() {
        return this.ayv;
    }
}
