package itemsadder.m;

import org.bukkit.entity.EntityType;

class EntityTypeSwitchMap_2 {
    static final /* synthetic */ int[] KX;

    static {
        KX = new int[EntityType.values().length];
        try {
            EntityTypeSwitchMap_2.KX[EntityType.ITEM_FRAME.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EntityTypeSwitchMap_2.KX[EntityType.ARMOR_STAND.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
