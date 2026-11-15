package itemsadder.m;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class qf
extends Event {
    public final Player Fi;
    public final LivingEntity Fj;

    public qf(Player player, LivingEntity livingEntity) {
        this.Fi = player;
        this.Fj = livingEntity;
    }

    @NotNull
    public HandlerList getHandlers() {
        throw new RuntimeException("DUMMY EVENT TRIGGERED!");
    }
}
