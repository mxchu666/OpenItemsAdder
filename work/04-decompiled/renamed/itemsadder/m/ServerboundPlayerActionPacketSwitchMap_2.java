package itemsadder.m;

import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;

class ServerboundPlayerActionPacketSwitchMap_2 {
    static final /* synthetic */ int[] alj;

    static {
        alj = new int[ServerboundPlayerActionPacket.Action.values().length];
        try {
            ServerboundPlayerActionPacketSwitchMap_2.alj[ServerboundPlayerActionPacket.Action.START_DESTROY_BLOCK.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ServerboundPlayerActionPacketSwitchMap_2.alj[ServerboundPlayerActionPacket.Action.ABORT_DESTROY_BLOCK.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ServerboundPlayerActionPacketSwitchMap_2.alj[ServerboundPlayerActionPacket.Action.STOP_DESTROY_BLOCK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ServerboundPlayerActionPacketSwitchMap_2.alj[ServerboundPlayerActionPacket.Action.DROP_ALL_ITEMS.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ServerboundPlayerActionPacketSwitchMap_2.alj[ServerboundPlayerActionPacket.Action.DROP_ITEM.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ServerboundPlayerActionPacketSwitchMap_2.alj[ServerboundPlayerActionPacket.Action.RELEASE_USE_ITEM.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ServerboundPlayerActionPacketSwitchMap_2.alj[ServerboundPlayerActionPacket.Action.SWAP_ITEM_WITH_OFFHAND.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ServerboundPlayerActionPacketSwitchMap_2.alj[ServerboundPlayerActionPacket.Action.STAB.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
