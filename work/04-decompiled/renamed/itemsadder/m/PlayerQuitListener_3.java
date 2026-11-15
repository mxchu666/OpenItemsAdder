package itemsadder.m;

import itemsadder.m.BlockBreakEnum;
import itemsadder.m.BoolData_2;
import itemsadder.m.ClassRefData;
import itemsadder.m.ColorBridge;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginContract_19;
import itemsadder.m.StringItemStackData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class PlayerQuitListener_3
implements PluginContract {
    private final Plugin zn;
    private final ItemStackRegistry zo;
    private final Map zp = Collections.synchronizedMap(new WeakHashMap());

    public PlayerQuitListener_3(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.zn = plugin;
        this.zo = itemStackRegistry;
        ListenerBridge.a(this, plugin);
        itemStackRegistry.ar.a(new ClassRefData(PlayerInteractEvent.class, this::c));
    }

    @EventHandler(priority=EventPriority.LOW)
    private void a(PlayerQuitEvent playerQuitEvent) {
        this.zp.remove(playerQuitEvent.getPlayer());
    }

    public static boolean d(Material material) {
        return material == Material.LANTERN || material == Material.GLOWSTONE || material == Material.SEA_LANTERN || material == Material.FLOWER_POT || material == Material.REDSTONE_LAMP || material.toString().contains("GLASS") || material.toString().contains("ICE");
    }

    @EventHandler(priority=EventPriority.LOW)
    public void a(ProjectileHitEvent projectileHitEvent) {
        if (projectileHitEvent.getEntity() == null) {
            return;
        }
        if (projectileHitEvent.getEntity().getType() == EntityType.ARROW && projectileHitEvent.getEntity().hasMetadata("IAProjectile")) {
            Player player;
            Block block = projectileHitEvent.getHitBlock();
            block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, (Object)block.getType());
            if (PlayerQuitListener_3.d(block.getType()) && LocationBridge_2.a(block, player = Bukkit.getServer().getPlayer(((MetadataValue)projectileHitEvent.getEntity().getMetadata("playerName").get(0)).asString()))) {
                block.setType(Material.AIR, false);
            }
            projectileHitEvent.getEntity().remove();
        }
    }

    @EventHandler(ignoreCancelled=true)
    void a(EntityShootBowEvent entityShootBowEvent) {
        ItemStackBuilder_4 itemStackBuilder_4;
        if (entityShootBowEvent.getEntityType() != EntityType.PLAYER) {
            return;
        }
        ItemStack itemStack = ((Player)entityShootBowEvent.getEntity()).getInventory().getItemInMainHand();
        if (itemStack.getType() == Material.CROSSBOW && (itemStackBuilder_4 = this.zo.a(itemStack)) != null && itemStackBuilder_4.Ge.bm("gun")) {
            entityShootBowEvent.setCancelled(true);
            Arrow arrow = (Arrow)entityShootBowEvent.getEntity().launchProjectile(Arrow.class);
            PacketListenerRegistry.U((Entity)arrow);
            arrow.setVelocity(entityShootBowEvent.getProjectile().getVelocity());
            arrow.setMetadata("no_pickup", (MetadataValue)new FixedMetadataValue(this.zn, (Object)true));
            arrow.setMetadata("IAProjectile", (MetadataValue)new FixedMetadataValue(this.zn, (Object)true));
            arrow.setMetadata("playerName", (MetadataValue)new FixedMetadataValue(this.zn, (Object)entityShootBowEvent.getEntity().getName()));
        }
    }

    @EventHandler
    public void a(PlayerPickupArrowEvent playerPickupArrowEvent) {
        if (playerPickupArrowEvent.isCancelled()) {
            return;
        }
        if (playerPickupArrowEvent.getItem().hasMetadata("no_pickup")) {
            playerPickupArrowEvent.setCancelled(true);
            playerPickupArrowEvent.getItem().remove();
        }
    }

    @PluginContract_19
    public void c(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        CrossbowMeta crossbowMeta;
        if (ItemStackBridge_2.q(playerInteractEvent)) {
            return;
        }
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK && playerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR) {
            return;
        }
        Player player = playerInteractEvent.getPlayer();
        ItemStack itemStack2 = playerInteractEvent.getPlayer().getInventory().getItemInOffHand();
        if (!itemStackBuilder_4.Ge.bm("gun")) {
            return;
        }
        StringItemStackData stringItemStackData = (StringItemStackData)itemStackBuilder_4.Ge.bn("gun");
        if (itemStack.getType() == Material.CROSSBOW && this.av(player)) {
            playerInteractEvent.setUseItemInHand(Event.Result.DENY);
            return;
        }
        ItemStack itemStack3 = stringItemStackData.yI;
        if (playerInteractEvent.getPlayer().getInventory().getItemInOffHand().getType() != Material.FIREWORK_ROCKET && itemStack.getType() == Material.CROSSBOW) {
            BoolData_2 boolData_2 = (BoolData_2)itemStackBuilder_4;
            crossbowMeta = (CrossbowMeta)itemStack.getItemMeta();
            if (!crossbowMeta.hasChargedProjectiles()) {
                playerInteractEvent.setCancelled(true);
                if (itemStack3 == null || itemStack3.isSimilar(itemStack2)) {
                    Material material = Material.ARROW;
                    if (boolData_2.Fr) {
                        material = Material.FIREWORK_ROCKET;
                    }
                    crossbowMeta.setChargedProjectiles(new ArrayList());
                    crossbowMeta.addChargedProjectile(ColorBridge.i(new ItemStack(material), "itemsadder-arrow-1"));
                    if (boolData_2.Fq) {
                        crossbowMeta.addChargedProjectile(ColorBridge.i(new ItemStack(material), "itemsadder-arrow-2"));
                        crossbowMeta.addChargedProjectile(ColorBridge.i(new ItemStack(material), "itemsadder-arrow-3"));
                        crossbowMeta.addEnchant(Enchantment.MULTISHOT, 1, true);
                        crossbowMeta.setEnchantmentGlintOverride(Boolean.valueOf(false));
                    } else if (crossbowMeta.hasEnchant(Enchantment.MULTISHOT)) {
                        crossbowMeta.removeEnchant(Enchantment.MULTISHOT);
                        crossbowMeta.setEnchantmentGlintOverride(Boolean.valueOf(false));
                    }
                    playerInteractEvent.getPlayer().getItemInHand().setItemMeta((ItemMeta)crossbowMeta);
                    ItemStackBridge_2.cz(playerInteractEvent.getPlayer());
                    itemStackBuilder_4.a((LivingEntity)playerInteractEvent.getPlayer(), BlockBreakEnum.GUN_RELOAD, builder_14 -> builder_14.j(playerInteractEvent, itemStackBuilder_4, itemStack));
                    return;
                }
            }
        }
        if (itemStack3 == null) {
            return;
        }
        boolean bl = itemStack3 instanceof ItemStackBuilder_4;
        if (!(bl && ItemStackBuilder_4.b(itemStack3, itemStack2) || !bl && itemStack3.getType() == itemStack2.getType())) {
            itemStackBuilder_4.a((LivingEntity)player, BlockBreakEnum.GUN_NO_AMMO, builder_14 -> builder_14.j(playerInteractEvent, itemStackBuilder_4, itemStack));
            return;
        }
        if (bl && ItemStackBuilder_4.b(itemStack3, itemStack2) || !bl && itemStack3.getType() == itemStack2.getType()) {
            if (itemStack.getType() != Material.CROSSBOW) {
                crossbowMeta = player.launchProjectile(Arrow.class);
                PacketListenerRegistry.U((Entity)crossbowMeta);
                crossbowMeta.setMetadata("no_pickup", (MetadataValue)new FixedMetadataValue(this.zn, (Object)true));
                crossbowMeta.setMetadata("IAProjectile", (MetadataValue)new FixedMetadataValue(this.zn, (Object)true));
                crossbowMeta.setMetadata("playerName", (MetadataValue)new FixedMetadataValue(this.zn, (Object)player.getName()));
                ItemStackBridge_2.cz(playerInteractEvent.getPlayer());
                if (ItemStackBridge_2.ap(itemStack)) {
                    Bukkit.getPluginManager().callEvent((Event)new PlayerItemDamageEvent(player, itemStack, 1));
                }
            }
            itemStackBuilder_4.a((LivingEntity)player, BlockBreakEnum.GUN_SHOT, builder_14 -> builder_14.j(playerInteractEvent, itemStackBuilder_4, itemStack));
        }
    }

    private boolean av(Player player) {
        if (this.zp.containsKey(player)) {
            long l = (Long)this.zp.get(player);
            if (System.currentTimeMillis() - l < 500L) {
                return true;
            }
        }
        this.zp.put(player, System.currentTimeMillis());
        return false;
    }
}
