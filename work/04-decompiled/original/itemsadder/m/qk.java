package itemsadder.m;

import itemsadder.m.qt;
import org.bukkit.Material;

class qk {
    static final /* synthetic */ int[] Fv;
    static final /* synthetic */ int[] Fw;

    static {
        Fw = new int[Material.values().length];
        try {
            qk.Fw[Material.LEATHER_CHESTPLATE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            qk.Fw[Material.LEATHER_LEGGINGS.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            qk.Fw[Material.LEATHER_BOOTS.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        Fv = new int[qt.values().length];
        try {
            qk.Fv[qt.HEAD.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            qk.Fv[qt.CHEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            qk.Fv[qt.LEGS.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            qk.Fv[qt.FEET.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
