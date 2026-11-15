package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.Events.TradeMachineEvent$Type;
import itemsadder.m.kg;
import itemsadder.m.ql;
import itemsadder.m.qm;
import java.util.List;
import lombok.Generated;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;

public abstract class TradeMachineEvent
extends PlayerEvent {
    private final kg internal;
    private final TradeMachineEvent$Type type;
    private List merchantRecipes;

    public TradeMachineEvent(Player player, kg kg2, qm qm2, List list) {
        super(player, false);
        this.internal = kg2;
        this.merchantRecipes = list;
        if (qm2 instanceof ql) {
            this.type = TradeMachineEvent$Type.BLOCK;
        } else if (qm2.Ge.bm("furniture")) {
            this.type = TradeMachineEvent$Type.FURNITURE;
        } else if (qm2.Ge.bm("complex_furniture")) {
            this.type = TradeMachineEvent$Type.COMPLEX_FURNITURE;
        } else {
            throw new IllegalArgumentException("The provided item does not have a valid behaviour for this event.");
        }
    }

    public String getNamespacedID() {
        return this.internal.zk.getNamespacedID();
    }

    public String getTitle() {
        return this.internal.getTitle();
    }

    public String getPermission() {
        return this.internal.getPermission();
    }

    public List getRecipes() {
        return this.merchantRecipes;
    }

    public void setRecipes(List list) {
        this.merchantRecipes = list;
    }

    @Generated
    public TradeMachineEvent$Type getType() {
        return this.type;
    }
}
