package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.SoundBridge;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class PlayerBridge_22
extends Builder_14 {
    public final ItemStackBuilder_4 Dn;

    public PlayerBridge_22(ItemStackBuilder_4 itemStackBuilder_4) {
        this.Dn = itemStackBuilder_4;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        SoundBridge.b(Sound.ITEM_TOTEM_USE, player, SoundCategory.PLAYERS, 20L, () -> PlayerHolder_4.e(player, this.Dn));
        return ItemStackBuilder_3.ml();
    }
}
