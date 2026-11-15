package itemsadder.m;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerBridge_24
extends Event {
    public final Player Fh;

    public PlayerBridge_24(Player player) {
        this.Fh = player;
    }

    @NotNull
    public HandlerList getHandlers() {
        throw new RuntimeException("DUMMY EVENT TRIGGERED!");
    }
}
