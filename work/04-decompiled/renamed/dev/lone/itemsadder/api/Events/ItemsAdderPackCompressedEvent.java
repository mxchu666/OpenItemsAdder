package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.Events.ItemsAdderPackCompressedEvent$PackEntry;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemsAdderPackCompressedEvent
extends Event {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final Map entries;

    public ItemsAdderPackCompressedEvent() {
        this(new LinkedHashMap());
    }

    public ItemsAdderPackCompressedEvent(Map map) {
        super(true);
        this.entries = Objects.requireNonNull(map, "entries");
    }

    public Map getEntries() {
        return this.entries;
    }

    @Nullable
    public ItemsAdderPackCompressedEvent$PackEntry getEntry(String string) {
        return (ItemsAdderPackCompressedEvent$PackEntry)this.entries.get(string);
    }

    public void setEntry(String string, byte[] byArray) {
        this.entries.put(string, ItemsAdderPackCompressedEvent$PackEntry.bytes(string, byArray));
    }

    public void setTextEntry(String string, String string2) {
        this.setEntry(string, string2.getBytes(StandardCharsets.UTF_8));
    }

    public void removeEntry(String string) {
        ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry = (ItemsAdderPackCompressedEvent$PackEntry)this.entries.remove(string);
        if (itemsAdderPackCompressedEvent$PackEntry != null) {
            itemsAdderPackCompressedEvent$PackEntry.remove();
        }
    }

    @NotNull
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }
}
