package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionEffectTypeBridge
extends Builder_14 {
    public final PotionEffectType Do;
    public final int Dp;
    public final int Dq;
    public final boolean Dr;
    public final boolean Ds;
    public final boolean Dt;

    public PotionEffectTypeBridge(PotionEffectType potionEffectType, int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        this.Do = potionEffectType;
        this.Dp = n;
        this.Dq = n2;
        this.Dr = bl;
        this.Ds = bl2;
        this.Dt = bl3;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        if (player.addPotionEffect(new PotionEffect(this.Do, this.Dq, this.Dp, this.Dr, this.Ds, this.Dt))) {
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }
}
