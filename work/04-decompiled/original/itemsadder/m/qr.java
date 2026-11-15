package itemsadder.m;

import itemsadder.m.qm;
import itemsadder.m.qs;
import java.util.Collections;
import java.util.List;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

public class qr
extends qs {
    @Nullable
    private final String Ha;

    public qr(Material material, String string, String string2, @Nullable qm qm2, @Nullable String string3) {
        super(material, string, string2, qm2);
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
