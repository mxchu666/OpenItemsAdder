package itemsadder.m;

import itemsadder.m.BlockBreakEnum;
import itemsadder.m.ClassRefData;
import itemsadder.m.ItemStackBridge_10;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerHolder_2;
import itemsadder.m.PlayerJoinListener_9;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginContract_19;
import itemsadder.m.VersionHelper;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class ItemStackBridge_30
implements PluginContract {
    private final Plugin Eu;
    private final ItemStackRegistry Ev;

    public ItemStackBridge_30(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.Eu = plugin;
        this.Ev = itemStackRegistry;
        itemStackRegistry.ar.a(new ClassRefData(PlayerItemConsumeEvent.class, this::c));
        itemStackRegistry.ar.a(new ClassRefData(FoodLevelChangeEvent.class, this::b));
    }

    @PluginContract_19
    void c(PlayerItemConsumeEvent playerItemConsumeEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        boolean bl;
        block8: {
            block7: {
                bl = playerItemConsumeEvent.getItem().getType() == Material.POTION;
                if (itemStackBuilder_4.Gd.b(BlockBreakEnum.DRINK).stream().anyMatch(ItemStackBridge_10.class::isInstance)) break block7;
                if (bl) break block8;
                if (!itemStackBuilder_4.Gd.b(BlockBreakEnum.EAT).stream().anyMatch(ItemStackBridge_10.class::isInstance)) break block8;
            }
            playerItemConsumeEvent.setCancelled(true);
        }
        if (bl) {
            itemStackBuilder_4.a((LivingEntity)playerItemConsumeEvent.getPlayer(), BlockBreakEnum.DRINK, builder_14 -> builder_14.b(playerItemConsumeEvent, itemStackBuilder_4, itemStack));
            if (!playerItemConsumeEvent.isCancelled() && VersionHelper.Va && playerItemConsumeEvent.getReplacement() == null && !PlayerHolder_2.tX().Z(itemStack)) {
                ItemStackBridge_30.c(playerItemConsumeEvent);
            }
        } else {
            itemStackBuilder_4.a((LivingEntity)playerItemConsumeEvent.getPlayer(), BlockBreakEnum.EAT, builder_14 -> builder_14.b(playerItemConsumeEvent, itemStackBuilder_4, itemStack));
            itemStackBuilder_4.a((LivingEntity)playerItemConsumeEvent.getPlayer(), BlockBreakEnum.DRINK, builder_14 -> builder_14.b(playerItemConsumeEvent, itemStackBuilder_4, itemStack));
        }
    }

    private static void c(PlayerItemConsumeEvent playerItemConsumeEvent) {
        ItemStack itemStack = playerItemConsumeEvent.getItem();
        ItemStack itemStack2 = itemStack.clone();
        itemStack.setAmount(1);
        playerItemConsumeEvent.setItem(itemStack);
        if (playerItemConsumeEvent.getPlayer().getGameMode() != GameMode.CREATIVE) {
            if (itemStack2.getAmount() == 1) {
                itemStack2 = new ItemStack(Material.AIR);
            } else {
                itemStack2.setAmount(itemStack2.getAmount() - 1);
            }
        }
        playerItemConsumeEvent.setReplacement(itemStack2);
    }

    @PluginContract_19
    void b(FoodLevelChangeEvent foodLevelChangeEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (!itemStack.getType().isEdible() || PlayerHolder_2.tX().aa(itemStack)) {
            return;
        }
        foodLevelChangeEvent.setCancelled(true);
        if (foodLevelChangeEvent.getEntity() instanceof Player && PlayerJoinListener_9.bN.o((Player)foodLevelChangeEvent.getEntity())) {
            return;
        }
        itemStackBuilder_4.a((LivingEntity)foodLevelChangeEvent.getEntity(), BlockBreakEnum.EAT, builder_14 -> builder_14.a(foodLevelChangeEvent, itemStackBuilder_4, itemStack));
    }
}
