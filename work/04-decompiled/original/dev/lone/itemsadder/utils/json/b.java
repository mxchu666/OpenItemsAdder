package dev.lone.itemsadder.utils.json;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class b {
    public static List M(Object object) {
        ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
        b.a(object, arrayList);
        for (int i = 0; i < arrayList.size(); ++i) {
            String string = (String)arrayList.get(i);
            if (string.contains(":")) continue;
            arrayList.set(i, (CallSite)((Object)("minecraft:" + string)));
        }
        return arrayList;
    }

    private static void a(Object object, List list) {
        block4: {
            block3: {
                if (!(object instanceof JSONObject)) break block3;
                JSONObject jSONObject = (JSONObject)object;
                for (Map.Entry entry : jSONObject.entrySet()) {
                    String string = (String)entry.getKey();
                    Object v = entry.getValue();
                    if ("model".equals(string) && v instanceof String) {
                        list.add((String)v);
                    }
                    b.a(v, list);
                }
                break block4;
            }
            if (!(object instanceof JSONArray)) break block4;
            JSONArray jSONArray = (JSONArray)object;
            for (Object e : jSONArray) {
                b.a(e, list);
            }
        }
    }
}
