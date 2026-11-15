package itemsadder.m;

import itemsadder.m.ai;
import itemsadder.m.aow;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bcy;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.jj;
import itemsadder.m.jz;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.qi;
import itemsadder.m.qm;
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

public class ko
implements ai {
    private final Plugin zn;
    private final d zo;
    private final Map zp = Collections.synchronizedMap(new WeakHashMap());

    public ko(Plugin plugin, d d2) {
        this.zn = plugin;
        this.zo = d2;
        bev.a(this, plugin);
        d2.ar.a(new my(PlayerInteractEvent.class, this::c));
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
            if (ko.d(block.getType()) && bcc.a(block, player = Bukkit.getServer().getPlayer(((MetadataValue)projectileHitEvent.getEntity().getMetadata("playerName").get(0)).asString()))) {
                block.setType(Material.AIR, false);
            }
            projectileHitEvent.getEntity().remove();
        }
    }

    @EventHandler(ignoreCancelled=true)
    void a(EntityShootBowEvent entityShootBowEvent) {
        qm qm2;
        if (entityShootBowEvent.getEntityType() != EntityType.PLAYER) {
            return;
        }
        ItemStack itemStack = ((Player)entityShootBowEvent.getEntity()).getInventory().getItemInMainHand();
        if (itemStack.getType() == Material.CROSSBOW && (qm2 = this.zo.a(itemStack)) != null && qm2.Ge.bm("gun")) {
            entityShootBowEvent.setCancelled(true);
            Arrow arrow = (Arrow)entityShootBowEvent.getEntity().launchProjectile(Arrow.class);
            aow.U((Entity)arrow);
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

    @mz
    public void c(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        CrossbowMeta crossbowMeta;
        if (bbs.q(playerInteractEvent)) {
            return;
        }
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK && playerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR) {
            return;
        }
        Player player = playerInteractEvent.getPlayer();
        ItemStack itemStack2 = playerInteractEvent.getPlayer().getInventory().getItemInOffHand();
        if (!qm2.Ge.bm("gun")) {
            return;
        }
        jz jz2 = (jz)qm2.Ge.bn("gun");
        if (itemStack.getType() == Material.CROSSBOW && this.av(player)) {
            playerInteractEvent.setUseItemInHand(Event.Result.DENY);
            return;
        }
        ItemStack itemStack3 = jz2.yI;
        if (playerInteractEvent.getPlayer().getInventory().getItemInOffHand().getType() != Material.FIREWORK_ROCKET && itemStack.getType() == Material.CROSSBOW) {
            qi qi2 = (qi)qm2;
            crossbowMeta = (CrossbowMeta)itemStack.getItemMeta();
            if (!crossbowMeta.hasChargedProjectiles()) {
                playerInteractEvent.setCancelled(true);
                if (itemStack3 == null || itemStack3.isSimilar(itemStack2)) {
                    Material material = Material.ARROW;
                    if (qi2.Fr) {
                        material = Material.FIREWORK_ROCKET;
                    }
                    crossbowMeta.setChargedProjectiles(new ArrayList());
                    crossbowMeta.addChargedProjectile(bcy.i(new ItemStack(material), "itemsadder-arrow-1"));
                    if (qi2.Fq) {
                        crossbowMeta.addChargedProjectile(bcy.i(new ItemStack(material), "itemsadder-arrow-2"));
                        crossbowMeta.addChargedProjectile(bcy.i(new ItemStack(material), "itemsadder-arrow-3"));
                        crossbowMeta.addEnchant(Enchantment.MULTISHOT, 1, true);
                        crossbowMeta.setEnchantmentGlintOverride(Boolean.valueOf(false));
                    } else if (crossbowMeta.hasEnchant(Enchantment.MULTISHOT)) {
                        crossbowMeta.removeEnchant(Enchantment.MULTISHOT);
                        crossbowMeta.setEnchantmentGlintOverride(Boolean.valueOf(false));
                    }
                    playerInteractEvent.getPlayer().getItemInHand().setItemMeta((ItemMeta)crossbowMeta);
                    bbs.cz(playerInteractEvent.getPlayer());
                    qm2.a((LivingEntity)playerInteractEvent.getPlayer(), jj.GUN_RELOAD, ou2 -> ou2.j(playerInteractEvent, qm2, itemStack));
                    return;
                }
            }
        }
        if (itemStack3 == null) {
            return;
        }
        boolean bl = itemStack3 instanceof qm;
        if (!(bl && qm.b(itemStack3, itemStack2) || !bl && itemStack3.getType() == itemStack2.getType())) {
            qm2.a((LivingEntity)player, jj.GUN_NO_AMMO, ou2 -> ou2.j(playerInteractEvent, qm2, itemStack));
            return;
        }
        if (bl && qm.b(itemStack3, itemStack2) || !bl && itemStack3.getType() == itemStack2.getType()) {
            if (itemStack.getType() != Material.CROSSBOW) {
                crossbowMeta = player.launchProjectile(Arrow.class);
                aow.U((Entity)crossbowMeta);
                crossbowMeta.setMetadata("no_pickup", (MetadataValue)new FixedMetadataValue(this.zn, (Object)true));
                crossbowMeta.setMetadata("IAProjectile", (MetadataValue)new FixedMetadataValue(this.zn, (Object)true));
                crossbowMeta.setMetadata("playerName", (MetadataValue)new FixedMetadataValue(this.zn, (Object)player.getName()));
                bbs.cz(playerInteractEvent.getPlayer());
                if (bbs.ap(itemStack)) {
                    Bukkit.getPluginManager().callEvent((Event)new PlayerItemDamageEvent(player, itemStack, 1));
                }
            }
            qm2.a((LivingEntity)player, jj.GUN_SHOT, ou2 -> ou2.j(playerInteractEvent, qm2, itemStack));
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
