package itemsadder.m;

import itemsadder.m.bce;
import itemsadder.m.uf;
import itemsadder.m.uk;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.metadata.MetadataValue;

public class uj
implements uf {
    String oz;
    Object LG;
    uk LH;

    public uj(String string, Object object, String string2) {
        this.oz = string;
        this.LG = object;
        String string3 = StringUtils.capitalize((String)string2.toLowerCase());
        try {
            this.LH = uk.valueOf(string3);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            bce.error("Unknown metadata.type '" + string2 + "' for metadata of name '" + string + "'." + String.valueOf(ChatColor.GRAY) + " Allowed: string, int, float, double, byte, short");
        }
    }

    public String getName() {
        return this.oz;
    }

    public Object qD() {
        return this.LG;
    }

    @Override
    public boolean I(Entity entity) {
        if (!entity.hasMetadata(this.oz)) {
            return false;
        }
        return ((MetadataValue)entity.getMetadata(this.oz).get(0)).value().equals(this.LG);
    }

    @Override
    public boolean aD(Block block) {
        return false;
    }
}
