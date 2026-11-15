package dev.lone.itemsadder.api.Events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ItemsAdderFirstLoadEvent
extends Event {
    private String message;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    @NotNull
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String string) {
        this.message = string;
    }
}
