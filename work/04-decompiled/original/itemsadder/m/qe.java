package itemsadder.m;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class qe
extends Event {
    public final Player Fh;

    public qe(Player player) {
        this.Fh = player;
    }

    @NotNull
    public HandlerList getHandlers() {
        throw new RuntimeException("DUMMY EVENT TRIGGERED!");
    }
}
