package itemsadder.m;

import itemsadder.m.sb;
import org.bukkit.block.BlockFace;

class sn {
    static final /* synthetic */ int[] JS;
    static final /* synthetic */ int[] JT;

    static {
        JT = new int[sb.values().length];
        try {
            sn.JT[sb.ALL.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            sn.JT[sb.LOG.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            sn.JT[sb.FURNACE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            sn.JT[sb.DROPPER.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        JS = new int[BlockFace.values().length];
        try {
            sn.JS[BlockFace.SOUTH.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            sn.JS[BlockFace.NORTH.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            sn.JS[BlockFace.EAST.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            sn.JS[BlockFace.WEST.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            sn.JS[BlockFace.DOWN.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            sn.JS[BlockFace.UP.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
