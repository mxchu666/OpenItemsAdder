package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.Events.TradeMachineEvent;
import itemsadder.m.ItemStackBridge_7;
import itemsadder.m.ItemStackBuilder_4;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class TradeMachineOpenEvent
extends TradeMachineEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public TradeMachineOpenEvent(Player player, ItemStackBridge_7 itemStackBridge_7, ItemStackBuilder_4 itemStackBuilder_4, List list) {
        super(player, itemStackBridge_7, itemStackBuilder_4, list);
    }

    @NotNull
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }
}
