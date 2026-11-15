package itemsadder.m;

import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.MaterialBridge_8;
import java.util.Collections;
import java.util.List;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

public class MaterialBridge_7
extends MaterialBridge_8 {
    @Nullable
    private final String Ha;

    public MaterialBridge_7(Material material, String string, String string2, @Nullable ItemStackBuilder_4 itemStackBuilder_4, @Nullable String string3) {
        super(material, string, string2, itemStackBuilder_4);
        this.Ha = string3;
    }

    @Override
    @Nullable
    public String nm() {
        return "item/generated";
    }

    @Override
    public List getTextures() {
        return Collections.singletonList(this.Ha);
    }

    @Override
    public boolean fZ() {
        return true;
    }
}
