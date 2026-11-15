package itemsadder.m;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;

public class PlayerEntityHolder_2
extends Event {
    public final Player Fk;
    public final Entity entity;
    public final boolean Fl;
    public final EquipmentSlot Fm;

    PlayerEntityHolder_2(Player player, Entity entity, boolean bl, EquipmentSlot equipmentSlot) {
        this.Fk = player;
        this.entity = entity;
        this.Fl = bl;
        this.Fm = equipmentSlot;
    }

    public static PlayerEntityHolder_2 a(Player player, Entity entity, boolean bl, EquipmentSlot equipmentSlot) {
        return new PlayerEntityHolder_2(player, entity, bl, equipmentSlot);
    }

    @NotNull
    public HandlerList getHandlers() {
        throw new RuntimeException("DUMMY EVENT TRIGGERED!");
    }
}
