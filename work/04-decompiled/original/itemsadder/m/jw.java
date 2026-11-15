package itemsadder.m;

import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.js;
import itemsadder.m.ki;
import itemsadder.m.qm;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class jw
extends ki {
    public static final String yw = "furniture_consumable";
    public final int yx;
    public final float yy;
    public final List yz;

    public jw(qm qm2, int n, float f, List list, boolean bl) {
        super(qm2);
        this.yx = n;
        this.yy = f;
        this.yz = list;
        this.yz.addFirst(qm2);
        if (bl) {
            for (qm qm3 : list) {
                qm3.Ge.a(yw, this);
            }
        }
    }

    public int d(qm qm2) {
        for (int i = 0; i < this.yz.size(); ++i) {
            if (!((qm)this.yz.get(i)).getNamespacedID().equals(qm2.getNamespacedID())) continue;
            return i;
        }
        return -1;
    }

    public boolean e(qm qm2) {
        int n = this.d(qm2);
        return n < 0 || n >= this.yz.size() - 1;
    }

    public void a(Player player, Entity entity, jw jw2, qm qm2) {
        if (this.e(qm2)) {
            this.e(entity, player);
            return;
        }
        int n = this.d(qm2);
        qm qm3 = (qm)this.yz.get(n + 1);
        jw jw3 = (jw)qm3.Ge.bn(yw);
        if (jw3 == null) {
            bce.error("Item '" + qm3.getNamespacedID() + "' has no 'furniture_consumable' behaviour, but is referenced in the item '" + qm2.getNamespacedID() + "' consumable stages list.");
            this.e(entity, player);
            return;
        }
        boolean bl = js.a(qm3, jw2.zk, entity);
        if (!bl) {
            this.e(entity, player);
        } else {
            this.at(player);
        }
    }

    private void at(Player player) {
        player.getFoodLevel();
        player.setFoodLevel(Math.min(20, player.getFoodLevel() + this.yx));
        player.setSaturation(Math.min(20.0f, player.getSaturation() + this.yy));
    }

    private void e(Entity entity, Player player) {
        d.g().aC.a(entity, player, false, false, false);
        this.at(player);
    }
}
