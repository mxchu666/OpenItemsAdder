package itemsadder.m;

import itemsadder.m.PickingUpEnum;
import lombok.Generated;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;
import org.jetbrains.annotations.Nullable;

class ItemDisplayTridentHolder {
    public final ItemDisplay EZ;
    private final Trident Fa;
    @Nullable
    public final LivingEntity Fb;
    @Nullable
    private Player Fc;
    private PickingUpEnum Fd = PickingUpEnum.NONE;
    int Fe = 0;

    public ItemDisplayTridentHolder(Trident trident, ItemDisplay itemDisplay, @Nullable LivingEntity livingEntity) {
        this.Fa = trident;
        this.EZ = itemDisplay;
        this.Fb = livingEntity;
    }

    public void bf(Player player) {
        this.Fd = PickingUpEnum.PICKING_UP;
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
    public PickingUpEnum my() {
        return this.Fd;
    }

    @Generated
    public void a(PickingUpEnum pickingUpEnum) {
        this.Fd = pickingUpEnum;
    }
}
