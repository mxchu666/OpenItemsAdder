package itemsadder.m;

import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;

class ServerboundPlayerActionPacketSwitchMap_3 {
    static final /* synthetic */ int[] aln;

    static {
        aln = new int[ServerboundPlayerActionPacket.Action.values().length];
        try {
            ServerboundPlayerActionPacketSwitchMap_3.aln[ServerboundPlayerActionPacket.Action.START_DESTROY_BLOCK.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ServerboundPlayerActionPacketSwitchMap_3.aln[ServerboundPlayerActionPacket.Action.ABORT_DESTROY_BLOCK.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ServerboundPlayerActionPacketSwitchMap_3.aln[ServerboundPlayerActionPacket.Action.STOP_DESTROY_BLOCK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ServerboundPlayerActionPacketSwitchMap_3.aln[ServerboundPlayerActionPacket.Action.DROP_ALL_ITEMS.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ServerboundPlayerActionPacketSwitchMap_3.aln[ServerboundPlayerActionPacket.Action.DROP_ITEM.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ServerboundPlayerActionPacketSwitchMap_3.aln[ServerboundPlayerActionPacket.Action.RELEASE_USE_ITEM.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ServerboundPlayerActionPacketSwitchMap_3.aln[ServerboundPlayerActionPacket.Action.SWAP_ITEM_WITH_OFFHAND.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ServerboundPlayerActionPacketSwitchMap_3.aln[ServerboundPlayerActionPacket.Action.STAB.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
