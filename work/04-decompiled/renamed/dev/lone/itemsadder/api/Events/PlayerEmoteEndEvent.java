package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.Events.PlayerEmoteEndEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerEmoteEndEvent
extends PlayerEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final String emoteName;
    private final Cause cause;

    public PlayerEmoteEndEvent(@NotNull Player player, String string, Cause cause) {
        super(player);
        this.emoteName = string;
        this.cause = cause;
    }

    public String getEmoteName() {
        return this.emoteName;
    }

    public Cause getCause() {
        return this.cause;
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
