package itemsadder.m;

import itemsadder.m.ms;
import itemsadder.m.ql;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class lg
extends Event
implements Cancellable {
    Player iW;
    Block Ae;
    ql Af;
    final ms Ag;
    private static final HandlerList Ah = new HandlerList();
    private boolean isCancelled;
    private boolean ob = true;
    private boolean Ai;

    public lg(Player player, Block block, ql ql2, ms ms2) {
        super(false);
        this.iW = player;
        this.Ae = block;
        this.Af = ql2;
        this.isCancelled = false;
        this.Ag = ms2;
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

    public ql ln() {
        return this.Af;
    }

    public void c(ql ql2) {
        this.Af = ql2;
    }

    public ms lo() {
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
