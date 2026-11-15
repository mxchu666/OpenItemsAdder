package dev.lone.itemsadder.resourcepack;

import itemsadder.m.ae;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public class c {
    public Map aqo = new HashMap();
    public Map aqp = new HashMap();
    private final Map aqq = new HashMap();
    private final Map aqr = new HashMap();
    public Map aqs = new HashMap();
    int aqt = 0;

    public boolean j(String string, boolean bl) {
        if (bl) {
            return this.aqp.containsKey(string);
        }
        return this.aqo.containsKey(string);
    }

    public String k(String string, boolean bl) {
        return this.a(string, ae.cE, bl);
    }

    public String a(String string, boolean bl, boolean bl2) {
        String string2;
        if (bl) {
            String string3 = (bl2 ? "b_" : "i_") + string;
            Integer n = (Integer)this.aqs.get(string3);
            if (n == null) {
                this.aqs.put(string3, this.aqt++);
                n = (Integer)this.aqs.get(string3);
            }
            string2 = "ia:" + n;
        } else {
            string2 = string.contains(":") ? "_" + (bl2 ? "b_" : "") + string : "_alias:" + (bl2 ? "b_" : "") + string;
        }
        this.c(string, string2, bl2);
        return string2;
    }

    @Nullable
    public String l(String string, boolean bl) {
        if (bl) {
            return (String)this.aqp.get(string);
        }
        return (String)this.aqo.get(string);
    }

    @Nullable
    public String m(String string, boolean bl) {
        String string2 = this.l(string, bl);
        if (string2 != null) {
            return string2;
        }
        return this.k(string, bl);
    }

    void b(String string, String string2, boolean bl) {
        this.c(string, string2, bl);
        if (!string2.startsWith("ia:")) {
            return;
        }
        try {
            int n = Integer.parseInt(string2.substring("ia:".length()));
            this.aqs.put((bl ? "b_" : "i_") + string, n);
            this.aqt = Math.max(this.aqt, n + 1);
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    public void clear() {
        this.aqo.clear();
        this.aqp.clear();
        this.aqq.clear();
        this.aqr.clear();
        this.aqs.clear();
        this.aqt = 0;
    }

    @Nullable
    String n(String string, boolean bl) {
        return (String)(bl ? this.aqr : this.aqq).get(string);
    }

    private void c(String string, String string2, boolean bl) {
        Map map = bl ? this.aqp : this.aqo;
        Map map2 = bl ? this.aqr : this.aqq;
        String string3 = map.put(string, string2);
        if (string3 != null) {
            map2.remove(string3, string);
        }
        map2.putIfAbsent(string2, string);
    }
}
