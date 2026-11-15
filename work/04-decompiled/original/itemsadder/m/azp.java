package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import java.util.Comparator;

public class azp
implements Comparator {
    public int c(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            int n = -100;
            int n2 = -100;
            if (jSONObject.getJSONObject("predicate").containsKey("custom_model_data")) {
                n = jSONObject.getJSONObject("predicate").getInteger("custom_model_data");
            }
            if (jSONObject2.getJSONObject("predicate").containsKey("custom_model_data")) {
                n2 = jSONObject2.getJSONObject("predicate").getInteger("custom_model_data");
            }
            return Integer.compare(n, n2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return 0;
        }
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.c((JSONObject)object, (JSONObject)object2);
    }
}
