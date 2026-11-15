package itemsadder.m;

import itemsadder.m.BlockBreakEnum;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ClassRefData;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginContract_19;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_29
implements PluginContract {
    public ItemStackBridge_29(ItemStackRegistry itemStackRegistry) {
        itemStackRegistry.ar.a(new ClassRefData(PlayerInteractEvent.class, this::k));
        itemStackRegistry.ar.a(new ClassRefData(PlayerEditBookEvent.class, this::b));
    }

    @PluginContract_19
    void k(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (playerInteractEvent.getItem() == null) {
            return;
        }
        if (playerInteractEvent.getItem().getType() != Material.WRITTEN_BOOK && playerInteractEvent.getItem().getType() != Material.WRITABLE_BOOK) {
            return;
        }
        itemStackBuilder_4.a((LivingEntity)playerInteractEvent.getPlayer(), BlockBreakEnum.BOOK_READ, builder_14 -> builder_14.j(playerInteractEvent, itemStackBuilder_4, itemStack));
    }

    @PluginContract_19
    void b(PlayerEditBookEvent playerEditBookEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (!itemStackBuilder_4.Gd.a(BlockBreakEnum.BOOK_WRITE)) {
            return;
        }
        BukkitTaskBridge.c(() -> {
            ItemStackBuilder_4.a(itemStack, itemStackBuilder_4.getNamespace(), itemStackBuilder_4.getId());
            itemStackBuilder_4.a((LivingEntity)playerEditBookEvent.getPlayer(), BlockBreakEnum.BOOK_WRITE, builder_14 -> builder_14.a(playerEditBookEvent, itemStackBuilder_4, itemStack));
        }, 2L);
    }
}
