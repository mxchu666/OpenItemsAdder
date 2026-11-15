package dev.lone.itemsadder.api.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class ResourcePackSendEvent
extends PlayerEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final String url;
    private final String hash;
    private final boolean isItemsAdderPack;

    public ResourcePackSendEvent(Player player, String string, String string2, boolean bl) {
        super(player);
        this.player = player;
        this.url = string;
        this.hash = string2;
        this.isItemsAdderPack = bl;
    }

    @NotNull
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public String getUrl() {
        return this.url;
    }

    public String getHash() {
        return this.hash;
    }

    public boolean isItemsAdderPack() {
        return this.isItemsAdderPack;
    }
}
