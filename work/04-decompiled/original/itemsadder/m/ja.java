package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ij;
import itemsadder.m.jb;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class ja
implements jb {
    public final int wP;
    public final float wQ;
    public final int wR;
    public final int wS;
    protected int wK = 0;

    public ja(int n, float f, int n2, int n3) {
        this.wP = n;
        this.wQ = f;
        this.wR = n2;
        this.wS = n3;
    }

    public ja km() {
        return new ja(this.wP, this.wQ, this.wR, this.wS);
    }

    @Override
    public void a(ij ij2, Player player, int n) {
        if (this.b(ij2, player, n)) {
            this.c(ij2, player, n);
        }
    }

    boolean b(ij ij2, Player player, int n) {
        if (player.getGameMode() == GameMode.CREATIVE) {
            return false;
        }
        if (!ij2.g(player.getWorld())) {
            return false;
        }
        this.wK += n;
        if (this.wK < this.wP) {
            return false;
        }
        this.wK = 0;
        return this.wR == -1 || this.wS == -1 || player.getLocation().getBlock().getLightFromSky() >= this.wR && player.getLocation().getBlock().getLightFromSky() <= this.wS;
    }

    void c(ij ij2, Player player, int n) {
        float f2 = ij2.jW();
        ij2.k(f2 + this.wQ);
        d.g().ao.al(player);
        if (Main.KO.gY("debug.huds.log-triggers")) {
            bce.log("GenericOverTime " + this.wQ);
        }
    }

    @Override
    public /* synthetic */ jb kn() {
        return this.km();
    }
}
