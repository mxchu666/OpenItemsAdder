package itemsadder.m;

import itemsadder.m.aow;
import itemsadder.m.bbi;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class od
extends ou {
    public final String Di;
    public final float Dj;
    public final float Dk;
    public final SoundCategory Dl;
    public final boolean Dm;

    public od(String string, float f, float f2, @Nullable String string2, @Nullable Boolean bl) {
        this.Di = string;
        this.Dj = f;
        this.Dk = f2;
        this.Dl = bbi.ib(string2);
        this.Dm = bl != null && bl != false;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        if (this.Dm) {
            aow.uN().b(this.Di, this.Dj, this.Dk, this.Dl, player.getLocation());
        } else {
            aow.uN().a(this.Di, this.Dj, this.Dk, this.Dl, player.getLocation());
        }
        return pa.ml();
    }
}
