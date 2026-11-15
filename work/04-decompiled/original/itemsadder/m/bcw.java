package itemsadder.m;

import itemsadder.m.bce;
import org.bukkit.entity.Player;

public class bcw {
    public final Player aBf;
    private final int aBg;
    private final int aBh;
    private final int aBi;
    public long aBj = System.currentTimeMillis();
    public long aBk = System.currentTimeMillis();
    public long aBl = -1L;
    public int aBm = 0;

    public bcw(Player player, int n, int n2, int n3) {
        this.aBf = player;
        this.aBg = n;
        this.aBh = n2;
        this.aBi = n3;
    }

    public void Do() {
        if (this.aBl == -1L || System.currentTimeMillis() - this.aBl >= 350L) {
            bce.error("Warning! " + this.aBf.getName() + " " + String.valueOf(this.aBf.getUniqueId()) + " is spamming recipe click packets!");
            this.aBl = System.currentTimeMillis();
        }
    }

    public void Dp() {
        this.aBj = System.currentTimeMillis();
        ++this.aBm;
        if (System.currentTimeMillis() - this.aBk >= (long)this.aBh) {
            this.aBm = 0;
        }
    }

    public boolean Dq() {
        return System.currentTimeMillis() - this.aBj < (long)this.aBg;
    }

    public boolean Dr() {
        if (System.currentTimeMillis() - this.aBk >= (long)this.aBh) {
            this.aBk = System.currentTimeMillis();
            boolean bl = this.aBm > this.aBi;
            this.aBm = 0;
            return bl;
        }
        return false;
    }
}
