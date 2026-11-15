package itemsadder.m;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBarColorHolder;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

public class Opaque137 {
    JSONObject LP = new JSONObject();

    public Opaque137(String string) {
        List list = ItemStackRegistry.v("minecraft/lang/" + string + ".json");
        for (File file : list) {
            try {
                JSONObject jSONObject = JSON.parseObject((String)FileUtils.readFileToString((File)file, (String)StandardCharsets.UTF_8.toString()));
                this.LP.putAll((Map)jSONObject);
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.error("Error opening minecraft lang file. Please make sure it's valid. File: " + file.getAbsolutePath(), throwable);
            }
        }
    }

    public void u(String string, String string2) {
        this.LP.put((Object)string, (Object)string2);
    }

    public String qL() {
        if (MaterialBarColorHolder.di) {
            return JSON.toJSONString((Object)this.LP, (JSONWriter.Feature[])new JSONWriter.Feature[]{JSONWriter.Feature.MapSortField, JSONWriter.Feature.PrettyFormat});
        }
        return JSON.toJSONString((Object)this.LP);
    }
}
