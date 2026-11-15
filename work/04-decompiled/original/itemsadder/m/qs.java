package itemsadder.m;

import dev.lone.itemsadder.resourcepack.generator.file.data.e;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.v;
import java.util.Collections;
import java.util.List;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

public class qs
extends v {
    @Nullable
    public final qm Hb;
    public final Material Hc;
    e Hd;

    public qs(Material material, String string, String string2, @Nullable qm qm2) {
        super(string, string2);
        this.Hc = material;
        this.Hb = qm2;
        this.Hd = e.R(material);
    }

    public String getModelPath() {
        return this.g(false, false);
    }

    public String g(boolean bl, boolean bl2) {
        if (this.fZ()) {
            return (String)(bl2 ? this.getNamespace() + ":" : "") + "item/ia_auto/" + this.getId() + (bl ? ".json" : "");
        }
        if (this.Hb != null) {
            return this.Hb.d(bl, bl2);
        }
        return (String)(bl2 ? this.getNamespace() + ":" : "") + "item/ia_auto/" + this.getId() + (bl ? ".json" : "");
    }

    public List getTextures() {
        if (this.Hb != null) {
            return this.Hb.getTextures();
        }
        return Collections.emptyList();
    }

    public boolean fZ() {
        if (this.Hb != null) {
            return this.Hb.fZ();
        }
        throw new RuntimeException("Cannot generate model for " + String.valueOf(this) + ", no texture or custom item provided.");
    }

    @Nullable
    public String nm() {
        if (this.Hb != null && this.Hb.nm() != null) {
            return this.Hb.nm();
        }
        if ((this.Hc.isBlock() || this.Hb instanceof ql) && this.Hb instanceof ql) {
            switch (((ql)this.Hb).Hq) {
                case REAL: 
                case REAL_TRANSPARENT: 
                case REAL_NOTE: 
                case ENTITY: {
                    return "block/cube_all";
                }
                case TILE: {
                    return "block/base/block_tile";
                }
            }
        }
        if (this.Hd.BN() || this.Hd.oC() == null) {
            return "item/generated";
        }
        return this.Hd.oC();
    }
}
