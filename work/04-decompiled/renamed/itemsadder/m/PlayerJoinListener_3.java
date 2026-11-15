package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketListener;
import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.ProtectionPlugins;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.FurniturePreSitEvent;
import dev.lone.itemsadder.api.Events.FurnitureSitEvent;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EntityHolder;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.NamespacedKeyBridge;
import itemsadder.m.NamespacedKeyItemDisplayHolder;
import itemsadder.m.Opaque125;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PacketListener_48;
import itemsadder.m.PluginContract;
import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDismountEvent;
import org.bukkit.event.entity.EntityMountEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerJoinListener_3
implements PluginContract {
    private static PlayerJoinListener_3 bx;
    public static final NamespacedKey by;
    public static final NamespacedKey bz;
    private final WeakHashMap bA = new WeakHashMap();
    private final WeakHashMap bB = new WeakHashMap();
    private final WeakHashMap bC = new WeakHashMap();

    PlayerJoinListener_3() {
        bx = this;
        ListenerBridge.a(this, Main.rT());
        PacketListenerRegistry.b((PacketListener)new PacketListener_48(this, (Plugin)Main.rS(), ListenerPriority.NORMAL, PacketType.Play.Client.LOOK));
    }

    @EventHandler
    private void a(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        if (!player.isInsideVehicle()) {
            return;
        }
        Entity entity = player.getVehicle();
        if (entity instanceof ArmorStand && entity.getPersistentDataContainer().has(by, PersistentDataType.BYTE)) {
            this.bA.put(player, entity);
        }
    }

    @EventHandler
    private void a(PlayerQuitEvent playerQuitEvent) {
        Player player = playerQuitEvent.getPlayer();
        if (this.bA.containsKey(player)) {
            this.c(player);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    private void a(EntityMountEvent entityMountEvent) {
        if (entityMountEvent.isCancelled()) {
            Entity entity = entityMountEvent.getEntity();
            if (!(entity instanceof Player)) {
                return;
            }
            Player player = (Player)entity;
            if (!ProtectionPlugins.hasWorldGuard) {
                return;
            }
            entity = entityMountEvent.getMount();
            if (!this.bA.containsKey(player)) {
                return;
            }
            if (ProtectionPlugins.canSitOnFurniture(player, entity)) {
                entityMountEvent.setCancelled(false);
            }
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(EntityDismountEvent entityDismountEvent) {
        Entity entity = entityDismountEvent.getEntity();
        if (!(entity instanceof Player)) {
            return;
        }
        Player player = (Player)entity;
        if (this.bA.containsKey(player)) {
            this.c(player);
        }
    }

    public static PlayerJoinListener_3 V() {
        if (bx == null) {
            bx = new PlayerJoinListener_3();
        }
        return bx;
    }

    public boolean a(Player player, Entity entity, @Nullable Block block, double d, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        return this.a(player, entity, block, d, bl2 ? -0.9875 : -2.185, bl, bl2, bl3, bl4, bl5);
    }

    public boolean a(Player player, Entity entity, @Nullable Block block, double d, double d2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        NamespacedKeyItemDisplayHolder namespacedKeyItemDisplayHolder;
        Opaque125 opaque125;
        Object object;
        ItemFrame itemFrame;
        Location location;
        if (block != null) {
            location = block.getLocation();
            location.add(0.5, 0.0, 0.5);
        } else {
            location = entity.getLocation().clone();
        }
        location.setYaw(player.getLocation().getYaw());
        location.setPitch(player.getLocation().getPitch());
        if (EntityHolder.i(entity.getType())) {
            location.setPitch(0.0f);
            itemFrame = (ItemFrame)entity;
            object = LocationBridge_2.a(itemFrame.getRotation());
            if (!bl4) {
                object = object.getOppositeFace();
            }
            location.setYaw((float)LocationBridge_2.b(object));
        } else if (bl4) {
            location.setYaw(entity.getLocation().getYaw() + 180.0f);
        }
        if (!LocationBridge_2.a(location, 0.5, EntityType.PLAYER).isEmpty()) {
            return false;
        }
        itemFrame = NamespacedKeyItemDisplayHolder.o(entity);
        object = ItemStackRegistry.g().a((ItemStack)itemFrame);
        if (object != null) {
            opaque125 = (Opaque125)object.Ge.bn("furniture_sit");
            namespacedKeyItemDisplayHolder = (NamespacedKeyItemDisplayHolder)object.Ge.bn("furniture");
            if (!ListenerBridge.b((Event)new FurniturePreSitEvent(player, entity, namespacedKeyItemDisplayHolder))) {
                return false;
            }
        } else {
            return false;
        }
        this.bC.put(player, opaque125);
        NamespacedKeyBridge.a((PersistentDataHolder)player, bz, player.getLocation());
        if (bl5) {
            opaque125 = location.clone();
            opaque125.add(0.0, 0.5, 0.0);
            player.teleport((Location)opaque125);
        }
        opaque125 = (ArmorStand)location.getWorld().spawn(location.add(0.0, d2 + d, 0.0), ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setAI(false);
            armorStand.setBasePlate(false);
            armorStand.setCanPickupItems(false);
            armorStand.setRemoveWhenFarAway(true);
            armorStand.setInvulnerable(false);
            armorStand.setSilent(true);
            armorStand.setGravity(bl);
            armorStand.setSmall(bl2);
            armorStand.setCollidable(bl3);
            armorStand.getPersistentDataContainer().set(by, PersistentDataType.BYTE, (Object)1);
            armorStand.setMaxHealth(0.5);
        });
        if (!this.bA.containsKey(player)) {
            this.bA.put(player, opaque125);
        }
        this.bB.put(player, entity);
        if (bl5) {
            BukkitTaskBridge.c(() -> PlayerJoinListener_3.a((ArmorStand)opaque125, player), 5L);
        } else {
            opaque125.addPassenger((Entity)player);
        }
        ListenerBridge.b((Event)new FurnitureSitEvent(player, entity, namespacedKeyItemDisplayHolder));
        return true;
    }

    public void c(Player player) {
        if (this.bA.containsKey(player)) {
            ((Entity)this.bA.get(player)).remove();
        }
        this.bB.remove(player);
        this.bC.remove(player);
        this.bA.remove(player);
        Optional.ofNullable(NamespacedKeyBridge.a((PersistentDataHolder)player, bz)).ifPresent(location -> {
            if (location.getWorld() == player.getWorld()) {
                Location location2 = location.clone();
                double d = location.distance(player.getLocation());
                if (d > 2.5) {
                    double d2 = 2.5 / d;
                    location2.add((player.getLocation().getX() - location.getX()) * d2, (player.getLocation().getY() - location.getY()) * d2, (player.getLocation().getZ() - location.getZ()) * d2);
                }
                if (LocationBridge_2.cE(player)) {
                    CommandSenderBridge_5.iA("Teleporting player to raycast hit location");
                    player.teleport(location);
                }
            }
            NamespacedKeyBridge.b((PersistentDataHolder)player, bz);
        });
    }

    public void a(Entity entity) {
        for (Map.Entry entry : this.bB.entrySet()) {
            if (!((Entity)entry.getValue()).getUniqueId().equals(entity.getUniqueId())) continue;
            this.c((Player)entry.getKey());
            return;
        }
    }

    public boolean d(@NotNull Player player) {
        return this.bA.containsKey(player);
    }

    private static /* synthetic */ void a(ArmorStand armorStand, Player player) {
        armorStand.addPassenger((Entity)player);
    }

    static {
        by = new NamespacedKey("itemsadder", "sit_manager_seat");
        bz = new NamespacedKey("itemsadder", "sit_manager_original_location");
    }
}
