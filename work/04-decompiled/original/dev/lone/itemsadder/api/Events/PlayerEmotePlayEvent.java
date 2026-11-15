package dev.lone.itemsadder.api.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerEmotePlayEvent
extends PlayerEvent
implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    boolean cancelled;
    private final String emoteName;

    public PlayerEmotePlayEvent(@NotNull Player player, @NotNull String string) {
        super(player);
        this.emoteName = string;
    }

    public String getEmoteName() {
        return this.emoteName;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean bl) {
        this.cancelled = bl;
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
