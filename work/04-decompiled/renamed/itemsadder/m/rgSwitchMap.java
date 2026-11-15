package itemsadder.m;

import itemsadder.m.BlockEnum;

class rgSwitchMap {
    static final /* synthetic */ int[] Js;

    static {
        Js = new int[BlockEnum.values().length];
        try {
            rgSwitchMap.Js[BlockEnum.BLOCK.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            rgSwitchMap.Js[BlockEnum.ITEM.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            rgSwitchMap.Js[BlockEnum.VANILLA.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
