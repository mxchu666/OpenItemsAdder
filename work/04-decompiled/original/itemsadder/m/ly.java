package itemsadder.m;

import com.comphenix.protocol.wrappers.EnumWrappers;

class ly {
    static final /* synthetic */ int[] Bf;

    static {
        Bf = new int[EnumWrappers.PlayerDigType.values().length];
        try {
            ly.Bf[EnumWrappers.PlayerDigType.START_DESTROY_BLOCK.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ly.Bf[EnumWrappers.PlayerDigType.ABORT_DESTROY_BLOCK.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ly.Bf[EnumWrappers.PlayerDigType.STOP_DESTROY_BLOCK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
