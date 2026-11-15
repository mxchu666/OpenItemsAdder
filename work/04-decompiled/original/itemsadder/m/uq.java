package itemsadder.m;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import itemsadder.m.ae;
import itemsadder.m.bce;
import itemsadder.m.d;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

public class uq {
    JSONObject LP = new JSONObject();

    public uq(String string) {
        List list = d.v("minecraft/lang/" + string + ".json");
        for (File file : list) {
            try {
                JSONObject jSONObject = JSON.parseObject((String)FileUtils.readFileToString((File)file, (String)StandardCharsets.UTF_8.toString()));
                this.LP.putAll((Map)jSONObject);
            }
            catch (Throwable throwable) {
                bce.error("Error opening minecraft lang file. Please make sure it's valid. File: " + file.getAbsolutePath(), throwable);
            }
        }
    }

    public void u(String string, String string2) {
        this.LP.put((Object)string, (Object)string2);
    }

    public String qL() {
        if (ae.di) {
            return JSON.toJSONString((Object)this.LP, (JSONWriter.Feature[])new JSONWriter.Feature[]{JSONWriter.Feature.MapSortField, JSONWriter.Feature.PrettyFormat});
        }
        return JSON.toJSONString((Object)this.LP);
    }
}
