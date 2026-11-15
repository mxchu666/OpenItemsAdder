package itemsadder.m;

import com.comphenix.protocol.wrappers.EnumWrappers;
import itemsadder.m.aab;
import itemsadder.m.axh;
import org.apache.commons.lang.StringUtils;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.jetbrains.annotations.Nullable;

public class axi {
    public final axh aoJ = (axh)aab.n(axh.class);
    private static axi aoK;

    axi() {
    }

    public static axi vC() {
        if (aoK == null) {
            aoK = new axi();
        }
        return aoK;
    }

    public static boolean t(World world) {
        return axi.vC().aoJ.t(world);
    }

    public static BlockFace a(EnumWrappers.Direction direction) {
        switch (direction) {
            case UP: {
                return BlockFace.UP;
            }
            case DOWN: {
                return BlockFace.DOWN;
            }
            case NORTH: {
                return BlockFace.NORTH;
            }
            case SOUTH: {
                return BlockFace.SOUTH;
            }
            case WEST: {
                return BlockFace.WEST;
            }
            case EAST: {
                return BlockFace.EAST;
            }
        }
        return BlockFace.SELF;
    }

    public Object bg(Block block) {
        return this.aoJ.bg(block);
    }

    public Object j(NamespacedKey namespacedKey) {
        return this.aoJ.j(namespacedKey);
    }

    @Nullable
    public static NamespacedKey dQ(String string) {
        String[] stringArray;
        NamespacedKey namespacedKey = axi.vC().aoJ.dO(string);
        if (namespacedKey != null) {
            return namespacedKey;
        }
        if (string.contains(":") && (stringArray = string.split(":")).length == 2) {
            if (!StringUtils.isAllLowerCase((String)stringArray[0]) || !StringUtils.isAllLowerCase((String)stringArray[1])) {
                return null;
            }
            return new NamespacedKey(stringArray[0], stringArray[1]);
        }
        return null;
    }
}
