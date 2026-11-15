package itemsadder.m;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class bin
extends Event
implements Cancellable {
    private boolean isCancelled;
    private static final HandlerList aDZ = new HandlerList();

    @NotNull
    public HandlerList getHandlers() {
        return aDZ;
    }

    public static HandlerList getHandlerList() {
        return aDZ;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean bl) {
        this.isCancelled = bl;
    }
}
