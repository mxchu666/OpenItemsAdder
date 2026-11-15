package itemsadder.m;

import itemsadder.m.bbv;
import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.Nullable;

public class bbu {
    public PlayerInventory aAt;
    public int aAu;
    private final Player aAv;
    HashMap aAw = new HashMap();

    public bbu(Player player) {
        this.aAt = player.getInventory();
        this.aAu = this.aAt.getSize();
        this.aAv = player;
        for (int i = 0; i < this.aAt.getSize(); ++i) {
            ItemStack itemStack = this.aAt.getItem(i);
            if (itemStack == null) continue;
            this.aAw.put(i, new bbv(itemStack));
        }
    }

    public Player getPlayer() {
        return this.aAv;
    }

    public int Dd() {
        return this.aAu;
    }

    public ItemStack bF(int n) {
        return ((bbv)this.aAw.get((Object)Integer.valueOf((int)n))).aAx;
    }

    public int bG(int n) {
        return ((bbv)this.aAw.get((Object)Integer.valueOf((int)n))).mh;
    }

    public void x(int n, int n2) {
        ((bbv)this.aAw.get((Object)Integer.valueOf((int)n))).mh = n2;
    }

    public void bH(int n) {
        ((bbv)this.aAw.get(n)).Dg();
    }

    public void y(int n, int n2) {
        ((bbv)this.aAw.get(n)).bH(n2);
    }

    public boolean bI(int n) {
        bbv bbv2 = (bbv)this.aAw.get(n);
        if (bbv2 == null) {
            return true;
        }
        return bbv2.aAy;
    }

    @Deprecated
    public ItemStack z(int n, int n2) {
        ItemStack itemStack = this.bF(n);
        itemStack.setAmount(n2);
        return itemStack;
    }

    public void applyChanges() {
        this.aAw.forEach((n, bbv2) -> bbv2.Dh());
    }

    @Nullable
    public bbv bJ(int n) {
        return (bbv)this.aAw.get(n);
    }
}
