package itemsadder.m;

import itemsadder.m.bbs;
import itemsadder.m.jj;
import itemsadder.m.qe;
import itemsadder.m.qm;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

class ps {
    public final Player EA;
    public final jj EB;
    public final jj EC;
    @Nullable
    public final qm ED;
    @Nullable
    public final ItemStack EE;
    @Nullable
    public final qm EF;
    @Nullable
    public final ItemStack EG;

    public ps(EquipmentSlot equipmentSlot, Player player, @Nullable qm qm2, @Nullable qm qm3) {
        if (bbs.b(equipmentSlot)) {
            this.EB = jj.WEAR;
            this.EC = jj.UNWEAR;
        } else {
            switch (equipmentSlot) {
                case OFF_HAND: {
                    this.EB = jj.HELD_OFFHAND;
                    this.EC = jj.UNHELD_OFFHAND;
                    break;
                }
                default: {
                    this.EB = jj.HELD;
                    this.EC = jj.UNHELD;
                }
            }
        }
        this.EA = player;
        this.ED = qm2;
        this.EE = qm2 != null ? qm2.mP() : null;
        this.EF = qm3;
        this.EG = qm3 != null ? qm3.mP() : null;
    }

    public void run() {
        this.ms();
        this.mt();
    }

    void ms() {
        if (this.ED != null) {
            this.ED.a((LivingEntity)this.EA, this.EC, ou2 -> ou2.a(new qe(this.EA), this.ED, this.EE));
        }
    }

    void mt() {
        if (this.EF != null) {
            this.EF.a((LivingEntity)this.EA, this.EB, ou2 -> ou2.a(new qe(this.EA), this.EF, this.EG));
        }
    }
}
