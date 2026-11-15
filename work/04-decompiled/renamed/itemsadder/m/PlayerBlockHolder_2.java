package itemsadder.m;

import itemsadder.m.BlockBridge_9;
import itemsadder.m.LocationBridgeBuilder_2;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerBlockHolder_2
extends Event
implements Cancellable {
    Player iW;
    Block Ae;
    LocationBridgeBuilder_2 Af;
    final BlockBridge_9 Ag;
    private static final HandlerList Ah = new HandlerList();
    private boolean isCancelled;
    private boolean ob = true;
    private boolean Ai;

    public PlayerBlockHolder_2(Player player, Block block, LocationBridgeBuilder_2 locationBridgeBuilder_2, BlockBridge_9 blockBridge_9) {
        super(false);
        this.iW = player;
        this.Ae = block;
        this.Af = locationBridgeBuilder_2;
        this.isCancelled = false;
        this.Ag = blockBridge_9;
    }

    @NotNull
    public HandlerList getHandlers() {
        return Ah;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return Ah;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean bl) {
        this.isCancelled = bl;
    }

    @NotNull
    public Player getPlayer() {
        return this.iW;
    }

    public void aH(Player player) {
        this.iW = player;
    }

    public Block getBlock() {
        return this.Ae;
    }

    public void r(Block block) {
        this.Ae = block;
    }

    public LocationBridgeBuilder_2 ln() {
        return this.Af;
    }

    public void c(LocationBridgeBuilder_2 locationBridgeBuilder_2) {
        this.Af = locationBridgeBuilder_2;
    }

    public BlockBridge_9 lo() {
        return this.Ag;
    }

    public void ac(boolean bl) {
        this.ob = bl;
    }

    public boolean lp() {
        return this.ob;
    }

    public void ad(boolean bl) {
        this.Ai = bl;
    }

    public boolean lq() {
        return this.Ai;
    }
}
