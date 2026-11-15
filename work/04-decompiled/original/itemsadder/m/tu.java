package itemsadder.m;

import org.bukkit.entity.EntityType;

class tu {
    static final /* synthetic */ int[] KX;

    static {
        KX = new int[EntityType.values().length];
        try {
            tu.KX[EntityType.ITEM_FRAME.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            tu.KX[EntityType.ARMOR_STAND.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
