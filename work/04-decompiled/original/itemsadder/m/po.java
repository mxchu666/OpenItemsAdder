package itemsadder.m;

import itemsadder.m.aaa;
import itemsadder.m.ai;
import itemsadder.m.aiq;
import itemsadder.m.d;
import itemsadder.m.jj;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.ne;
import itemsadder.m.qm;
import itemsadder.m.w;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class po
implements ai {
    private final Plugin Eu;
    private final d Ev;

    public po(Plugin plugin, d d2) {
        this.Eu = plugin;
        this.Ev = d2;
        d2.ar.a(new my(PlayerItemConsumeEvent.class, this::c));
        d2.ar.a(new my(FoodLevelChangeEvent.class, this::b));
    }

    @mz
    void c(PlayerItemConsumeEvent playerItemConsumeEvent, qm qm2, ItemStack itemStack) {
        boolean bl;
        block8: {
            block7: {
                bl = playerItemConsumeEvent.getItem().getType() == Material.POTION;
                if (qm2.Gd.b(jj.DRINK).stream().anyMatch(ne.class::isInstance)) break block7;
                if (bl) break block8;
                if (!qm2.Gd.b(jj.EAT).stream().anyMatch(ne.class::isInstance)) break block8;
            }
            playerItemConsumeEvent.setCancelled(true);
        }
        if (bl) {
            qm2.a((LivingEntity)playerItemConsumeEvent.getPlayer(), jj.DRINK, ou2 -> ou2.b(playerItemConsumeEvent, qm2, itemStack));
            if (!playerItemConsumeEvent.isCancelled() && aaa.Va && playerItemConsumeEvent.getReplacement() == null && !aiq.tX().Z(itemStack)) {
                po.c(playerItemConsumeEvent);
            }
        } else {
            qm2.a((LivingEntity)playerItemConsumeEvent.getPlayer(), jj.EAT, ou2 -> ou2.b(playerItemConsumeEvent, qm2, itemStack));
            qm2.a((LivingEntity)playerItemConsumeEvent.getPlayer(), jj.DRINK, ou2 -> ou2.b(playerItemConsumeEvent, qm2, itemStack));
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

    @mz
    void b(FoodLevelChangeEvent foodLevelChangeEvent, qm qm2, ItemStack itemStack) {
        if (!itemStack.getType().isEdible() || aiq.tX().aa(itemStack)) {
            return;
        }
        foodLevelChangeEvent.setCancelled(true);
        if (foodLevelChangeEvent.getEntity() instanceof Player && w.bN.o((Player)foodLevelChangeEvent.getEntity())) {
            return;
        }
        qm2.a((LivingEntity)foodLevelChangeEvent.getEntity(), jj.EAT, ou2 -> ou2.a(foodLevelChangeEvent, qm2, itemStack));
    }
}
