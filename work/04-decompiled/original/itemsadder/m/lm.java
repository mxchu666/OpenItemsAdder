package itemsadder.m;

import com.comphenix.protocol.wrappers.EnumWrappers;

class lm {
    static final /* synthetic */ int[] As;

    static {
        As = new int[EnumWrappers.PlayerDigType.values().length];
        try {
            lm.As[EnumWrappers.PlayerDigType.START_DESTROY_BLOCK.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            lm.As[EnumWrappers.PlayerDigType.ABORT_DESTROY_BLOCK.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            lm.As[EnumWrappers.PlayerDigType.STOP_DESTROY_BLOCK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
