package itemsadder.m;

import dev.lone.itemsadder.resourcepack.generator.file.data.e;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.Opaque140;
import java.util.Collections;
import java.util.List;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

public class MaterialBridge_8
extends Opaque140 {
    @Nullable
    public final ItemStackBuilder_4 Hb;
    public final Material Hc;
    e Hd;

    public MaterialBridge_8(Material material, String string, String string2, @Nullable ItemStackBuilder_4 itemStackBuilder_4) {
        super(string, string2);
        this.Hc = material;
        this.Hb = itemStackBuilder_4;
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
        if ((this.Hc.isBlock() || this.Hb instanceof LocationBridgeBuilder_2) && this.Hb instanceof LocationBridgeBuilder_2) {
            switch (((LocationBridgeBuilder_2)this.Hb).Hq) {
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
