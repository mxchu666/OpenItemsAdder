package itemsadder.m;

import com.jeff_media.armorequipevent.ArmorType;

class ArmorTypeSwitchMap {
    static final /* synthetic */ int[] xo;

    static {
        xo = new int[ArmorType.values().length];
        try {
            ArmorTypeSwitchMap.xo[ArmorType.HELMET.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ArmorTypeSwitchMap.xo[ArmorType.CHESTPLATE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ArmorTypeSwitchMap.xo[ArmorType.LEGGINGS.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ArmorTypeSwitchMap.xo[ArmorType.BOOTS.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
