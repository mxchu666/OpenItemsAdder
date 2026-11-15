package itemsadder.m;

import itemsadder.m.HeadEnum;
import org.bukkit.Material;

class qtSwitchMap {
    static final /* synthetic */ int[] Fv;
    static final /* synthetic */ int[] Fw;

    static {
        Fw = new int[Material.values().length];
        try {
            qtSwitchMap.Fw[Material.LEATHER_CHESTPLATE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            qtSwitchMap.Fw[Material.LEATHER_LEGGINGS.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            qtSwitchMap.Fw[Material.LEATHER_BOOTS.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        Fv = new int[HeadEnum.values().length];
        try {
            qtSwitchMap.Fv[HeadEnum.HEAD.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            qtSwitchMap.Fv[HeadEnum.CHEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            qtSwitchMap.Fv[HeadEnum.LEGS.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            qtSwitchMap.Fv[HeadEnum.FEET.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
