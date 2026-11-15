package itemsadder.m;

import itemsadder.m.bcc;
import itemsadder.m.bfo;
import itemsadder.m.bfp;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class ng
extends ou {
    public final float Cs;
    public final int Ct;

    public ng(float f, int n) {
        this.Cs = f;
        this.Ct = n;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        bfo bfo2 = new bfo(player, (double)this.Ct);
        if (bfo2.a(bfp.ENTITY_AND_BLOCK)) {
            if (bfo2.EG()) {
                return pa.mk();
            }
            if (bfo2.EE() && bfo2.ED() instanceof LivingEntity && bcc.f((Entity)player, bfo2.ED())) {
                ((LivingEntity)bfo2.ED()).damage((double)this.Cs);
                return pa.ml();
            }
        }
        return pa.mk();
    }
}
