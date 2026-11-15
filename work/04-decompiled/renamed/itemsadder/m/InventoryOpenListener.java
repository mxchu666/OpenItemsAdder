package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NCompound;
import beer.devs.fastnbt.nms.nbt.NItem;
import dev.lone.itemsadder.Main;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.MaterialBarColorHolder;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class InventoryOpenListener
implements Listener {
    public InventoryOpenListener() {
        ListenerBridge.b(this, (Plugin)Main.rS());
    }

    @EventHandler(ignoreCancelled=true)
    private void a(InventoryOpenEvent inventoryOpenEvent) {
        if (!MaterialBarColorHolder.fH) {
            return;
        }
        InventoryOpenListener.d(inventoryOpenEvent.getInventory());
    }

    @EventHandler(ignoreCancelled=true)
    private void a(PlayerJoinEvent playerJoinEvent) {
        if (!MaterialBarColorHolder.fH) {
            return;
        }
        PlayerInventory playerInventory = playerJoinEvent.getPlayer().getInventory();
        InventoryOpenListener.d((Inventory)playerInventory);
    }

    @EventHandler(ignoreCancelled=true)
    private void c(PlayerChangedWorldEvent playerChangedWorldEvent) {
        if (!MaterialBarColorHolder.fH) {
            return;
        }
        BukkitTaskBridge.c(() -> {
            PlayerInventory playerInventory = playerChangedWorldEvent.getPlayer().getInventory();
            InventoryOpenListener.d((Inventory)playerInventory);
        }, 25L);
    }

    @EventHandler(ignoreCancelled=true)
    private void b(PlayerPickupItemEvent playerPickupItemEvent) {
        if (!MaterialBarColorHolder.fH) {
            return;
        }
        InventoryOpenListener.o(playerPickupItemEvent.getItem().getItemStack());
    }

    @EventHandler(ignoreCancelled=true)
    private void a(EntityDamageEvent entityDamageEvent) {
        LivingEntity livingEntity;
        ItemStack[] itemStackArray;
        if ((entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK || entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK) && (itemStackArray = entityDamageEvent.getDamageSource().getCausingEntity()) instanceof LivingEntity && (livingEntity = (LivingEntity)itemStackArray).getEquipment() != null && this.n(livingEntity.getEquipment().getItemInMainHand())) {
            ItemStackBuilder_4.a(livingEntity.getEquipment().getItemInMainHand(), 1, livingEntity);
        }
        if ((itemStackArray = entityDamageEvent.getEntity()) instanceof LivingEntity && (livingEntity = (LivingEntity)itemStackArray).getEquipment() != null) {
            for (ItemStack itemStack : livingEntity.getEquipment().getArmorContents()) {
                if (!this.n(itemStack)) continue;
                ItemStackBuilder_4.a(itemStack, 1, livingEntity);
            }
        }
    }

    @EventHandler(ignoreCancelled=true)
    private void c(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        ItemStack[] itemStackArray;
        Entity entity = entityDamageByEntityEvent.getDamager();
        if (!(entity instanceof LivingEntity)) {
            return;
        }
        LivingEntity livingEntity = (LivingEntity)entity;
        if (livingEntity.getEquipment() != null && this.n(livingEntity.getEquipment().getItemInMainHand())) {
            ItemStackBuilder_4.a(livingEntity.getEquipment().getItemInMainHand(), 1, livingEntity);
        }
        if ((itemStackArray = entityDamageByEntityEvent.getEntity()) instanceof LivingEntity && (entity = (LivingEntity)itemStackArray).getEquipment() != null) {
            for (ItemStack itemStack : entity.getEquipment().getArmorContents()) {
                if (!this.n(itemStack)) continue;
                ItemStackBuilder_4.a(itemStack, 1, (LivingEntity)entity);
            }
        }
    }

    @EventHandler(ignoreCancelled=true)
    private void b(BlockBreakEvent blockBreakEvent) {
        Player player = blockBreakEvent.getPlayer();
        if (this.n(player.getEquipment().getItemInMainHand())) {
            ItemStackBuilder_4.a(player.getEquipment().getItemInMainHand(), 1, (LivingEntity)player);
        }
    }

    boolean n(ItemStack itemStack) {
        return !ItemStackBridge_2.at(itemStack) && !ItemStackBridge_2.X(itemStack.getType()) && ItemStackBridge_2.ap(itemStack) && ItemStackRegistry.g().isCustomItem(itemStack);
    }

    private static void d(Inventory inventory) {
        for (ItemStack itemStack : inventory.getContents()) {
            InventoryOpenListener.o(itemStack);
        }
    }

    private static void o(ItemStack itemStack) {
        if (ItemStackBridge_2.at(itemStack)) {
            return;
        }
        Object object = itemStack.getItemMeta();
        if (!(object instanceof Damageable)) {
            return;
        }
        Damageable damageable = (Damageable)object;
        object = null;
        @Nullable Integer n = null;
        NItem nItem = new NItem(itemStack);
        if (nItem.hasKey("itemsadder")) {
            NCompound nCompound = nItem.getCompound("itemsadder");
            if (nCompound.hasKey("max_custom_durability")) {
                object = nCompound.getInt("max_custom_durability");
            }
            if (nCompound.hasKey("custom_durability")) {
                n = nCompound.getInt("custom_durability");
            }
            nCompound.remove("max_custom_durability");
            nCompound.remove("custom_durability");
            nCompound.remove("fake_durability");
            nItem.save();
            if (object != null) {
                damageable.setMaxDamage((Integer)object);
            }
            if (n != null && damageable.hasMaxDamage()) {
                damageable.setDamage(damageable.getMaxDamage() - n);
            }
            itemStack.setItemMeta((ItemMeta)damageable);
        }
    }
}
