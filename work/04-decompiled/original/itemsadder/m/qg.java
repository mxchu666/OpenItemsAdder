package itemsadder.m;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;

public class qg
extends Event {
    public final Player Fk;
    public final Entity entity;
    public final boolean Fl;
    public final EquipmentSlot Fm;

    qg(Player player, Entity entity, boolean bl, EquipmentSlot equipmentSlot) {
        this.Fk = player;
        this.entity = entity;
        this.Fl = bl;
        this.Fm = equipmentSlot;
    }

    public static qg a(Player player, Entity entity, boolean bl, EquipmentSlot equipmentSlot) {
        return new qg(player, entity, bl, equipmentSlot);
    }

    @NotNull
    public HandlerList getHandlers() {
        throw new RuntimeException("DUMMY EVENT TRIGGERED!");
    }
}
