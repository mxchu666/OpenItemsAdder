package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.Events.TradeMachineEvent;
import itemsadder.m.kg;
import itemsadder.m.qm;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class TradeMachinePreOpenEvent
extends TradeMachineEvent
implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;

    public TradeMachinePreOpenEvent(Player player, kg kg2, qm qm2, List list) {
        super(player, kg2, qm2, list);
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean bl) {
        this.isCancelled = bl;
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
