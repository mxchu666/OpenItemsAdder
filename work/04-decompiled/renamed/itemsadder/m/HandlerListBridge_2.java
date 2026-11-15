package itemsadder.m;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class HandlerListBridge_2
extends Event {
    private static final HandlerList uh = new HandlerList();

    @NotNull
    public HandlerList getHandlers() {
        return uh;
    }

    public static HandlerList getHandlerList() {
        return uh;
    }
}
