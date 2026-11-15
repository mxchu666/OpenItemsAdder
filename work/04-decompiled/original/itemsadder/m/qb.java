package itemsadder.m;

import itemsadder.m.qc;
import lombok.Generated;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;
import org.jetbrains.annotations.Nullable;

class qb {
    public final ItemDisplay EZ;
    private final Trident Fa;
    @Nullable
    public final LivingEntity Fb;
    @Nullable
    private Player Fc;
    private qc Fd = qc.NONE;
    int Fe = 0;

    public qb(Trident trident, ItemDisplay itemDisplay, @Nullable LivingEntity livingEntity) {
        this.Fa = trident;
        this.EZ = itemDisplay;
        this.Fb = livingEntity;
    }

    public void bf(Player player) {
        this.Fd = qc.PICKING_UP;
        this.Fc = player;
    }

    public int mv() {
        return this.Fe++;
    }

    public boolean mw() {
        return this.Fb != null && this.Fb.isDead();
    }

    @Nullable
    @Generated
    public Player mx() {
        return this.Fc;
    }

    @Generated
    public qc my() {
        return this.Fd;
    }

    @Generated
    public void a(qc qc2) {
        this.Fd = qc2;
    }
}
