package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.Events.TradeMachineEvent$Type;
import itemsadder.m.ItemStackBridge_7;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LocationBridgeBuilder_2;
import java.util.List;
import lombok.Generated;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;

public abstract class TradeMachineEvent
extends PlayerEvent {
    private final ItemStackBridge_7 internal;
    private final TradeMachineEvent$Type type;
    private List merchantRecipes;

    public TradeMachineEvent(Player player, ItemStackBridge_7 itemStackBridge_7, ItemStackBuilder_4 itemStackBuilder_4, List list) {
        super(player, false);
        this.internal = itemStackBridge_7;
        this.merchantRecipes = list;
        if (itemStackBuilder_4 instanceof LocationBridgeBuilder_2) {
            this.type = TradeMachineEvent$Type.BLOCK;
        } else if (itemStackBuilder_4.Ge.bm("furniture")) {
            this.type = TradeMachineEvent$Type.FURNITURE;
        } else if (itemStackBuilder_4.Ge.bm("complex_furniture")) {
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
