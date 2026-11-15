package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.EntityAndBlockEnum;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.PlayerLocationHolder_2;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class EventBridge_4
extends Builder_14 {
    public final float Cs;
    public final int Ct;

    public EventBridge_4(float f, int n) {
        this.Cs = f;
        this.Ct = n;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        PlayerLocationHolder_2 playerLocationHolder_2 = new PlayerLocationHolder_2(player, (double)this.Ct);
        if (playerLocationHolder_2.a(EntityAndBlockEnum.ENTITY_AND_BLOCK)) {
            if (playerLocationHolder_2.EG()) {
                return ItemStackBuilder_3.mk();
            }
            if (playerLocationHolder_2.EE() && playerLocationHolder_2.ED() instanceof LivingEntity && LocationBridge_2.f((Entity)player, playerLocationHolder_2.ED())) {
                ((LivingEntity)playerLocationHolder_2.ED()).damage((double)this.Cs);
                return ItemStackBuilder_3.ml();
            }
        }
        return ItemStackBuilder_3.mk();
    }
}
