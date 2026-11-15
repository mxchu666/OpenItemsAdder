package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import itemsadder.m.ayp;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

public class aza {
    private final ayp axm;
    private final JSONObject axn;
    @Nullable
    private final JSONObject axo;
    private final Map axp;
    private final List axq;

    public aza(ayp ayp2, Map map, @Nullable JSONObject jSONObject, List list, JSONObject jSONObject2) {
        this.axm = ayp2;
        this.axn = Objects.requireNonNull(jSONObject2, "itemJson cannot be null");
        this.axo = jSONObject;
        this.axp = Objects.requireNonNull(map, "statusModelsJsons cannot be null");
        this.axq = Objects.requireNonNull(list, "usedModelsTextures cannot be null");
    }

    @Generated
    public ayp AV() {
        return this.axm;
    }

    @Generated
    public JSONObject AW() {
        return this.axn;
    }

    @Nullable
    @Generated
    public JSONObject AX() {
        return this.axo;
    }

    @Generated
    public Map AY() {
        return this.axp;
    }

    @Generated
    public List AZ() {
        return this.axq;
    }
}
