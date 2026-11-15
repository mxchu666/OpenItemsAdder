package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.SoundCategoryBridge;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class SoundCategoryBridge_3
extends Builder_14 {
    public final String Di;
    public final float Dj;
    public final float Dk;
    public final SoundCategory Dl;
    public final boolean Dm;

    public SoundCategoryBridge_3(String string, float f, float f2, @Nullable String string2, @Nullable Boolean bl) {
        this.Di = string;
        this.Dj = f;
        this.Dk = f2;
        this.Dl = SoundCategoryBridge.ib(string2);
        this.Dm = bl != null && bl != false;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        if (this.Dm) {
            PacketListenerRegistry.uN().b(this.Di, this.Dj, this.Dk, this.Dl, player.getLocation());
        } else {
            PacketListenerRegistry.uN().a(this.Di, this.Dj, this.Dk, this.Dl, player.getLocation());
        }
        return ItemStackBuilder_3.ml();
    }
}
