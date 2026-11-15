package itemsadder.m;

import org.bukkit.Rotation;
import org.bukkit.block.BlockFace;

class BlockFaceSwitchMap {
    static final /* synthetic */ int[] aAR;
    static final /* synthetic */ int[] aAS;

    static {
        aAS = new int[Rotation.values().length];
        try {
            BlockFaceSwitchMap.aAS[Rotation.FLIPPED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAS[Rotation.FLIPPED_45.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAS[Rotation.COUNTER_CLOCKWISE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAS[Rotation.COUNTER_CLOCKWISE_45.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAS[Rotation.NONE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAS[Rotation.CLOCKWISE_45.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAS[Rotation.CLOCKWISE.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAS[Rotation.CLOCKWISE_135.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        aAR = new int[BlockFace.values().length];
        try {
            BlockFaceSwitchMap.aAR[BlockFace.NORTH.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAR[BlockFace.WEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAR[BlockFace.NORTH_WEST.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAR[BlockFace.SOUTH_WEST.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAR[BlockFace.EAST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAR[BlockFace.NORTH_EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAR[BlockFace.SOUTH_EAST.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAR[BlockFace.SOUTH.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAR[BlockFace.EAST_NORTH_EAST.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAR[BlockFace.WEST_NORTH_WEST.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAR[BlockFace.NORTH_NORTH_EAST.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAR[BlockFace.NORTH_NORTH_WEST.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAR[BlockFace.EAST_SOUTH_EAST.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAR[BlockFace.WEST_SOUTH_WEST.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAR[BlockFace.SOUTH_SOUTH_EAST.ordinal()] = 15;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BlockFaceSwitchMap.aAR[BlockFace.SOUTH_SOUTH_WEST.ordinal()] = 16;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
