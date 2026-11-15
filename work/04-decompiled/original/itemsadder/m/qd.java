package itemsadder.m;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class qd
extends Event
implements Cancellable {
    public final Player Ff;
    public final Entity Fg;
    boolean isCancelled;

    public qd(Player player, Entity entity) {
        this.Ff = player;
        this.Fg = entity;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean bl) {
        this.isCancelled = bl;
    }

    @NotNull
    public HandlerList getHandlers() {
        throw new RuntimeException("DUMMY EVENT TRIGGERED!");
    }
}
