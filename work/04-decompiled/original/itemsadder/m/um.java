package itemsadder.m;

import itemsadder.m.abk;
import itemsadder.m.afz;
import itemsadder.m.bce;
import itemsadder.m.uf;
import itemsadder.m.uk;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

public class um
implements uf {
    final String LJ;
    Object LK;
    String[] LL;
    uk LH;

    public um(String string, String string2, String string3) {
        this.LJ = string;
        this.LK = string2;
        try {
            this.LH = uk.valueOf(StringUtils.capitalize((String)string3.toLowerCase()));
        }
        catch (Throwable throwable) {
            bce.error("Unknown nbt.type '" + string3 + "' for nbt path '" + string + "'." + String.valueOf(ChatColor.GRAY) + " Allowed: string, int, float, double, byte, short");
            return;
        }
        switch (this.LH) {
            case String: {
                break;
            }
            case Int: {
                this.LK = Integer.parseInt(string2);
                break;
            }
            case Float: {
                this.LK = Float.valueOf(Float.parseFloat(string2));
                break;
            }
            case Double: {
                this.LK = Double.parseDouble(string2);
                break;
            }
            case Byte: {
                this.LK = Byte.parseByte(string2);
                break;
            }
            case Short: {
                this.LK = Short.parseShort(string2);
            }
        }
        this.LL = string.split("\\.");
    }

    public String qH() {
        return this.LJ;
    }

    public Object qI() {
        return this.LK;
    }

    public String[] qJ() {
        return this.LL;
    }

    public uk qK() {
        return this.LH;
    }

    @Override
    public boolean I(Entity entity) {
        return afz.tK().a(entity, this);
    }

    @Override
    public boolean aD(Block block) {
        return abk.tl().a(block, this);
    }
}
