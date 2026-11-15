package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import beer.devs.fastnbt.nms.nbt.NItem;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketListener;
import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.ProtectionPlugins;
import dev.lone.itemsadder.Main;
import itemsadder.m.BlockBridge_2;
import itemsadder.m.BlockRegistry;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ClassRefData;
import itemsadder.m.EntityArmorStandHolder;
import itemsadder.m.EntityHolder;
import itemsadder.m.EntityHolder_2;
import itemsadder.m.EntityTypeBarStyleHolder;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LivingEntityArmorStandHolder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.NamespacedKeyVectorHolder;
import itemsadder.m.OnIAVehicleListener;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PacketListener_49;
import itemsadder.m.PlayerBossBarHolder;
import itemsadder.m.PlayerBridge_18;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PlayerJoinListener_3;
import itemsadder.m.PluginContract_19;
import itemsadder.m.RecordOfValue_3;
import java.util.Map;
import java.util.WeakHashMap;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.HeightMap;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDismountEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class PluginDisableListener
extends PlayerBridge_18 {
    private final Plugin zK;
    private final ItemStackRegistry zL;
    public static PacketAdapter zM;
    public static PacketAdapter zN;
    public static final WeakHashMap zO;
    public static final WeakHashMap zP;
    public static final WeakHashMap zQ;

    public PluginDisableListener(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.zK = plugin;
        this.zL = itemStackRegistry;
        ListenerBridge.a(this, plugin);
        itemStackRegistry.ar.a(new ClassRefData(BlockPlaceEvent.class, this::c));
        itemStackRegistry.ar.a(new ClassRefData(BlockMultiPlaceEvent.class, this::c));
        itemStackRegistry.ar.a(new ClassRefData(PlayerInteractEvent.class, this::g));
        PluginDisableListener.lg();
    }

    private static void lg() {
        if (Version.isOlderThan((Version)Version.v1_21_3)) {
            zM = new OnIAVehicleListener((Plugin)Main.rS(), ListenerPriority.NORMAL, PacketType.Play.Client.STEER_VEHICLE);
            PacketListenerRegistry.b((PacketListener)zM);
        }
        if (Version.isAtLeast((Version)Version.v1_21_3)) {
            zN = new PacketListener_49((Plugin)Main.rS(), ListenerPriority.NORMAL, PacketType.Play.Client.STEER_VEHICLE);
            PacketListenerRegistry.b((PacketListener)zN);
            BukkitTaskBridge.b(bukkitRunnable -> {
                Vector vector;
                EntityTypeBarStyleHolder entityTypeBarStyleHolder;
                LivingEntity livingEntity;
                LivingEntityArmorStandHolder livingEntityArmorStandHolder;
                RecordOfValue_3 recordOfValue_3;
                Object object;
                Player player;
                for (Map.Entry entry : zO.entrySet()) {
                    Object object2;
                    player = (Player)entry.getKey();
                    if (player.getVehicle() == null || player.getVehicle().getType() != EntityType.SLIME && !(player.getVehicle() instanceof ArmorStand) || !zO.containsKey(player)) continue;
                    if (!ItemStackRegistry.g().v) {
                        BukkitTaskBridge.i(() -> {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 200, 5));
                            PluginDisableListener.aB(player);
                        });
                        continue;
                    }
                    object = (EntityArmorStandHolder)zO.get(player);
                    if (object == null || ((EntityArmorStandHolder)object).zY == null) {
                        PluginDisableListener.aB(player);
                        continue;
                    }
                    recordOfValue_3 = (RecordOfValue_3)zQ.get(player);
                    if (recordOfValue_3 == null) continue;
                    livingEntityArmorStandHolder = ((EntityArmorStandHolder)object).zY;
                    livingEntity = livingEntityArmorStandHolder.getLocation().subtract(0.0, 1.0, 0.0);
                    if (recordOfValue_3.uL()) {
                        if (livingEntity.getBlock().getType().isSolid() || livingEntity.getBlock().getType() == Material.WATER || livingEntity.getBlock().getType() == Material.LAVA) {
                            PluginDisableListener.aB(player);
                            continue;
                        }
                        if (((EntityArmorStandHolder)object).zW.fu() > 0.0f) {
                            entityTypeBarStyleHolder = player.getLocation().getDirection();
                            entityTypeBarStyleHolder = entityTypeBarStyleHolder.multiply(((EntityArmorStandHolder)object).zW.fu());
                            entityTypeBarStyleHolder.setY(-1);
                            livingEntityArmorStandHolder.setVelocity((Vector)entityTypeBarStyleHolder);
                        }
                    }
                    entityTypeBarStyleHolder = ((EntityArmorStandHolder)object).zZ;
                    if (((EntityArmorStandHolder)object).zW.le() != -1 && entityTypeBarStyleHolder.getInt("Fuel") <= 0) continue;
                    ((EntityArmorStandHolder)object).Ab = livingEntityArmorStandHolder.getLocation().getYaw();
                    EntityHolder.a((Entity)livingEntityArmorStandHolder, player.getLocation().getYaw());
                    if (livingEntityArmorStandHolder.getPassenger() != null && livingEntityArmorStandHolder.getPassenger().getType() == EntityType.SLIME) {
                        EntityHolder.a(livingEntityArmorStandHolder.getPassenger(), livingEntityArmorStandHolder.getLocation().getYaw());
                    }
                    if ((recordOfValue_3.uG() || recordOfValue_3.uH() || recordOfValue_3.uK()) && ((EntityArmorStandHolder)object).zW.le() != -1 && System.currentTimeMillis() - ((EntityArmorStandHolder)object).Aa >= 1000L) {
                        ((EntityArmorStandHolder)object).Aa = System.currentTimeMillis();
                        entityTypeBarStyleHolder.setInt("Fuel", entityTypeBarStyleHolder.getInt("Fuel") - 1);
                        object2 = PluginDisableListener.aA(player);
                        ((PlayerBossBarHolder)object2).gF();
                        ((PlayerBossBarHolder)object2).bf(Main.PQ.ir("fuel-indicator").replace("{value}", "" + entityTypeBarStyleHolder.getInt("Fuel")).replace("{max}", "" + ((EntityArmorStandHolder)object).zW.le()));
                        entityTypeBarStyleHolder.save();
                        livingEntityArmorStandHolder.setHelmet(entityTypeBarStyleHolder.getItem());
                    }
                    if (recordOfValue_3.uG()) {
                        boolean bl = livingEntityArmorStandHolder.getLocation().subtract(0.0, 2.0, 0.0).getBlock().getType().isSolid();
                        double d = ((EntityArmorStandHolder)object).zW.lb();
                        if (((EntityArmorStandHolder)object).zW.fu() > 0.0f && !bl) {
                            d = ((EntityArmorStandHolder)object).zW.fu();
                        }
                        vector = livingEntityArmorStandHolder.getLocation().getDirection();
                        if (((EntityArmorStandHolder)object).zW.fu() > 0.0f) {
                            vector.setY(0.078);
                        } else {
                            vector.setY(-1);
                        }
                        vector = vector.multiply(d);
                        livingEntityArmorStandHolder.setVelocity(vector);
                        if (((EntityArmorStandHolder)object).zW.fu() > 0.0f && !bl) {
                            continue;
                        }
                    } else if (recordOfValue_3.uH()) {
                        object2 = livingEntityArmorStandHolder.getLocation().getDirection();
                        object2 = object2.multiply(-((EntityArmorStandHolder)object).zW.lb() / 2.0f);
                        object2.setY(livingEntityArmorStandHolder.getVelocity().getY());
                        livingEntityArmorStandHolder.setVelocity((Vector)object2);
                    } else if (((EntityArmorStandHolder)object).zW.kY() > 0) {
                        ((EntityArmorStandHolder)object).z(livingEntityArmorStandHolder.getLocation());
                    }
                    if (!recordOfValue_3.uK()) continue;
                    if (livingEntity.getBlock().getType().isSolid() && !livingEntityArmorStandHolder.getLocation().subtract(0.0, 0.0, 0.0).getBlock().getType().isSolid()) {
                        if (!(((EntityArmorStandHolder)object).zW.lc() > 0.0f)) continue;
                        Vector vector2 = livingEntityArmorStandHolder.getVelocity();
                        vector2.setY(1);
                        vector2 = vector2.multiply(((EntityArmorStandHolder)object).zW.lc());
                        livingEntityArmorStandHolder.setVelocity(vector2);
                        continue;
                    }
                    if (!(((EntityArmorStandHolder)object).zW.fu() > 0.0f)) continue;
                    Vector vector3 = player.getLocation().getDirection();
                    vector3.setY(1);
                    vector3 = vector3.multiply(((EntityArmorStandHolder)object).zW.fu());
                    livingEntityArmorStandHolder.setVelocity(vector3);
                }
                if (LivingEntityRegistry.P()) {
                    for (Map.Entry entry : LivingEntityRegistry.db().df().entrySet()) {
                        player = (LivingEntity)entry.getKey();
                        if (!(player instanceof Player) || (recordOfValue_3 = (RecordOfValue_3)zQ.get(object = player)) == null) continue;
                        livingEntityArmorStandHolder = (LivingEntityArmorStandHolder)entry.getValue();
                        livingEntity = livingEntityArmorStandHolder.oy;
                        entityTypeBarStyleHolder = livingEntityArmorStandHolder.gH().my;
                        if (livingEntityArmorStandHolder.canControl()) {
                            float f;
                            boolean bl = entityTypeBarStyleHolder.fu() > 0.0f;
                            Vector vector4 = livingEntity.getVelocity();
                            Location location = livingEntity.getLocation().clone();
                            location.setPitch(0.0f);
                            vector = location.getDirection();
                            vector.normalize();
                            if (recordOfValue_3.uG() || recordOfValue_3.uH()) {
                                double d = entityTypeBarStyleHolder.ft();
                                if (livingEntity.isOnGround()) {
                                    if (recordOfValue_3.uK()) {
                                        vector4.setY(0.5);
                                    }
                                } else if (bl) {
                                    d = entityTypeBarStyleHolder.fu();
                                }
                                if (recordOfValue_3.uG()) {
                                    vector.multiply(d);
                                } else {
                                    vector.multiply(-d);
                                }
                                if (recordOfValue_3.uL() && bl && !livingEntity.isOnGround()) {
                                    vector.setY(-entityTypeBarStyleHolder.fu() * 4.0f);
                                }
                                vector4 = vector4.add(vector);
                            } else {
                                if (recordOfValue_3.uK()) {
                                    if (livingEntity.isOnGround()) {
                                        vector4.setY(0.5);
                                        livingEntity.setVelocity(vector4);
                                    } else if (bl) {
                                        vector4.setY(entityTypeBarStyleHolder.fu() * 4.0f);
                                    }
                                }
                                if (recordOfValue_3.uL()) {
                                    if (!livingEntityArmorStandHolder.isLocked() && livingEntity.isOnGround()) {
                                        BukkitTaskBridge.i(() -> PluginDisableListener.aD((Player)object));
                                    } else if (bl && !livingEntity.isOnGround()) {
                                        vector4.setY(-entityTypeBarStyleHolder.fu() * 4.0f);
                                    }
                                }
                            }
                            if (entityTypeBarStyleHolder.fu() <= 0.0f) {
                                vector4.setY(-1);
                            }
                            livingEntity.setVelocity(vector4);
                            float f2 = object.getEyeLocation().getYaw();
                            float f3 = location.getYaw();
                            if (recordOfValue_3.eu()) {
                                f = LocationBridge_2.e(f3, f2, 0.6f);
                                livingEntity.setRotation(f, livingEntity.getEyeLocation().getPitch());
                                continue;
                            }
                            f = Math.abs(LocationBridge_2.D(f3 - f2));
                            if (!(f > 60.0f)) continue;
                            float f4 = LocationBridge_2.e(f3, f2, 0.1f);
                            livingEntity.setRotation(f4, livingEntity.getEyeLocation().getPitch());
                            continue;
                        }
                        if (!recordOfValue_3.uL() || livingEntityArmorStandHolder.isLocked()) continue;
                        BukkitTaskBridge.i(() -> PluginDisableListener.aC((Player)object));
                    }
                }
            }, 1L, 1L);
        }
    }

    @Override
    public void unregister() {
        super.unregister();
        ProtocolLibrary.getProtocolManager().removePacketListener((PacketListener)zM);
    }

    private static PlayerBossBarHolder aA(Player player) {
        PlayerBossBarHolder playerBossBarHolder = (PlayerBossBarHolder)zP.get(player);
        if (playerBossBarHolder == null) {
            zP.put(player, new PlayerBossBarHolder(player, "", BarColor.BLUE, BarStyle.SOLID));
            playerBossBarHolder = (PlayerBossBarHolder)zP.get(player);
        }
        return playerBossBarHolder;
    }

    private static void ak(Player player) {
        zQ.remove(player);
        if (zO.containsKey(player)) {
            ((EntityArmorStandHolder)zO.get(player)).ll();
            zO.remove(player);
        }
        if (zP.containsKey(player)) {
            ((PlayerBossBarHolder)zP.get(player)).li();
        }
        zP.remove(player);
    }

    void a(NamespacedKeyVectorHolder namespacedKeyVectorHolder, ItemStack itemStack, Block block, Player player, EquipmentSlot equipmentSlot) {
        if (this.aJ(player)) {
            return;
        }
        Location location = block.getLocation();
        location.setX(location.getX() + 0.5);
        location.setY(location.getY());
        location.setZ(location.getZ() + 0.5);
        if (namespacedKeyVectorHolder.kB()) {
            location.setYaw((float)LocationBridge_2.b(player.getLocation().getYaw(), false));
        } else {
            location.setYaw(player.getLocation().getYaw());
        }
        ArmorStand armorStand2 = (ArmorStand)block.getWorld().spawn(location, ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setAI(true);
            armorStand.setRemoveWhenFarAway(false);
            armorStand.setCanPickupItems(false);
            armorStand.setInvulnerable(false);
            armorStand.setSilent(true);
            armorStand.setSmall(namespacedKeyVectorHolder.kC());
            armorStand.setGravity(true);
            armorStand.setCollidable(true);
            ItemStack itemStack2 = namespacedKeyVectorHolder.zk.getType() == itemStack.getType() ? itemStack.clone() : namespacedKeyVectorHolder.zk.mP();
            ItemStackBuilder_4.a(itemStack2, player.getUniqueId().toString());
            NItem nItem = new NItem(itemStack2);
            if (!nItem.hasKey("Fuel")) {
                nItem.setInt("Fuel", namespacedKeyVectorHolder.ld());
            }
            nItem.save();
            BukkitTaskBridge.c(() -> armorStand.setHelmet(itemStack2), 2L);
            namespacedKeyVectorHolder.q((Entity)armorStand);
        });
        namespacedKeyVectorHolder.xu.HQ.f(player, location);
        PlayerHolder_4.a(player, equipmentSlot);
        if (player.getGameMode() != GameMode.CREATIVE) {
            itemStack.setAmount(itemStack.getAmount() - 1);
        }
        this.aK(player);
        namespacedKeyVectorHolder.a((Entity)armorStand2, namespacedKeyVectorHolder.zk);
        this.zL.aC.aw(player);
    }

    static void f(Player player, boolean bl) {
        Location location = player.getVehicle() != null ? player.getVehicle().getLocation() : player.getLocation().clone();
        location.add(0.0, 0.5, 0.0);
        EntityArmorStandHolder entityArmorStandHolder = (EntityArmorStandHolder)zO.get(player);
        PluginDisableListener.ak(player);
        if (entityArmorStandHolder != null) {
            ArmorStand armorStand = entityArmorStandHolder.zY;
            player.leaveVehicle();
            player.teleport(location);
            if (bl && armorStand != null) {
                EntityHolder.a(armorStand, false);
            }
            BukkitTaskBridge.c(() -> entityArmorStandHolder.zW.q((Entity)armorStand), 20L);
        } else {
            player.leaveVehicle();
            player.teleport(location);
        }
    }

    static void aB(Player player) {
        Location location = player.getVehicle() != null ? player.getVehicle().getLocation() : player.getLocation().clone();
        location.add(0.0, 0.5, 0.0);
        BukkitTaskBridge.i(() -> {
            EntityArmorStandHolder entityArmorStandHolder = (EntityArmorStandHolder)zO.get(player);
            PluginDisableListener.ak(player);
            if (entityArmorStandHolder == null) {
                return;
            }
            ArmorStand armorStand = entityArmorStandHolder.zY;
            player.leaveVehicle();
            player.teleport(location);
            if (armorStand != null) {
                EntityHolder.a(armorStand, false);
            }
            BukkitTaskBridge.c(() -> entityArmorStandHolder.zW.q((Entity)armorStand), 20L);
        });
    }

    @EventHandler
    void a(PluginDisableEvent pluginDisableEvent) {
        if (!pluginDisableEvent.getPlugin().getName().equals(this.zK.getName())) {
            return;
        }
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getVehicle() == null || !zO.containsKey(player)) continue;
            Location location = player.getVehicle().getLocation();
            int n = BlockRegistry.a(player.getVehicle().getLocation().getChunk(), location.getBlockX() >> 4, location.getBlockZ() >> 4, HeightMap.MOTION_BLOCKING);
            PluginDisableListener.f(player, n <= 1);
        }
    }

    @PluginContract_19
    void c(BlockPlaceEvent blockPlaceEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (!itemStackBuilder_4.Ge.bm("vehicle")) {
            return;
        }
        blockPlaceEvent.setCancelled(true);
        if (blockPlaceEvent.getBlockAgainst() == null) {
            return;
        }
        NamespacedKeyVectorHolder namespacedKeyVectorHolder = (NamespacedKeyVectorHolder)itemStackBuilder_4.Ge.bn("vehicle");
        Block block = blockPlaceEvent.getBlockPlaced();
        this.a(namespacedKeyVectorHolder, itemStack, block, blockPlaceEvent.getPlayer(), blockPlaceEvent.getHand());
    }

    @PluginContract_19
    void g(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Block block;
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (itemStack.getType().isBlock()) {
            return;
        }
        if (!itemStackBuilder_4.Ge.bm("vehicle")) {
            return;
        }
        playerInteractEvent.setCancelled(true);
        Block block2 = playerInteractEvent.getClickedBlock();
        if (block2 == null) {
            return;
        }
        Player player = playerInteractEvent.getPlayer();
        if (!ProtectionPlugins.canPlaceVehicle(player, block = playerInteractEvent.getClickedBlock().getRelative(playerInteractEvent.getBlockFace()))) {
            return;
        }
        if (LocationBridge_2.e(player, block)) {
            return;
        }
        if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND && ItemStackRegistry.g().hasBehaviour(playerInteractEvent.getPlayer().getItemInHand(), "furniture")) {
            return;
        }
        if (BlockBridge_2.a(block, EntityType.ARMOR_STAND) != null) {
            return;
        }
        NamespacedKeyVectorHolder namespacedKeyVectorHolder = (NamespacedKeyVectorHolder)itemStackBuilder_4.Ge.bn("vehicle");
        this.a(namespacedKeyVectorHolder, itemStack, block, playerInteractEvent.getPlayer(), playerInteractEvent.getHand());
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void e(PlayerInteractAtEntityEvent playerInteractAtEntityEvent) {
        if (ItemStackBridge_2.d((PlayerInteractEntityEvent)playerInteractAtEntityEvent)) {
            return;
        }
        if (!(playerInteractAtEntityEvent.getRightClicked() instanceof ArmorStand)) {
            return;
        }
        ArmorStand armorStand = (ArmorStand)playerInteractAtEntityEvent.getRightClicked();
        if (armorStand.getLocation().getBlock().getType() == Material.WATER) {
            return;
        }
        ItemStack itemStack = armorStand.getHelmet();
        if (itemStack == null) {
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = this.zL.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        if (!itemStackBuilder_4.Ge.bm("vehicle")) {
            return;
        }
        NamespacedKeyVectorHolder namespacedKeyVectorHolder = (NamespacedKeyVectorHolder)itemStackBuilder_4.Ge.bn("vehicle");
        if (!ProtectionPlugins.canSitOnVehicle(playerInteractAtEntityEvent, itemStack)) {
            return;
        }
        playerInteractAtEntityEvent.setCancelled(true);
        NItem nItem = new NItem(itemStack);
        Player player = playerInteractAtEntityEvent.getPlayer();
        if (namespacedKeyVectorHolder.le() != -1) {
            PlayerBossBarHolder playerBossBarHolder = PluginDisableListener.aA(player);
            playerBossBarHolder.gF();
            playerBossBarHolder.bf(Main.PQ.ir("fuel-indicator").replace("{value}", "" + nItem.getInt("Fuel")).replace("{max}", "" + namespacedKeyVectorHolder.le()));
            playerBossBarHolder.lh();
            ItemStack itemStack2 = ItemStackBridge_2.cA(player);
            if (namespacedKeyVectorHolder.i(itemStack2)) {
                int n = namespacedKeyVectorHolder.j(itemStack2);
                if (nItem.getInt("Fuel") + n <= namespacedKeyVectorHolder.le()) {
                    ItemStack itemStack3 = namespacedKeyVectorHolder.k(itemStack2);
                    ItemStackBridge_2.cy(player);
                    nItem.setInt("Fuel", nItem.getInt("Fuel") + n);
                    nItem.save();
                    armorStand.setHelmet(itemStack);
                    if (itemStack3 != null) {
                        ItemStackBridge_2.f(player, itemStack3);
                    }
                    return;
                }
            }
        }
        if (nItem.getInt("Fuel") == 0) {
            return;
        }
        if (!PlayerJoinListener_3.V().d(player)) {
            double d = namespacedKeyVectorHolder.la();
            if ((int)d - 2 != 0) {
                Slime slime2 = (Slime)player.getWorld().spawn(player.getLocation(), Slime.class, slime -> {
                    EntityHolder_2.a((Entity)slime, (int)d - 1);
                    slime.setPersistent(false);
                    slime.setAI(false);
                    slime.setSilent(true);
                    slime.setInvulnerable(true);
                    slime.setCustomNameVisible(false);
                    armorStand.setPassenger((Entity)slime);
                    slime.setPassenger((Entity)player);
                    slime.setCustomName("IASlimeVehicle");
                    EntityHolder.tK().a(player, (LivingEntity)slime);
                });
                BukkitTaskBridge.c(() -> {
                    EntityHolder.b((Entity)slime2, true);
                    slime2.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, false, false));
                }, 5L);
            } else {
                armorStand.setPassenger((Entity)player);
                EntityHolder.tK().a(player, (LivingEntity)armorStand);
            }
            EntityArmorStandHolder entityArmorStandHolder = new EntityArmorStandHolder(namespacedKeyVectorHolder, armorStand, player.getVehicle(), new NItem(itemStack), System.currentTimeMillis());
            zO.put(player, entityArmorStandHolder);
            entityArmorStandHolder.lk();
            EntityHolder.a(armorStand, true);
            namespacedKeyVectorHolder.q((Entity)armorStand);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    private void b(EntityDismountEvent entityDismountEvent) {
        Entity entity;
        if (entityDismountEvent.getEntity().getType() == EntityType.PLAYER && entityDismountEvent.getDismounted() instanceof ArmorStand && (entity = entityDismountEvent.getEntity()) instanceof Player) {
            Player player = (Player)entity;
            if (zO.containsKey(player)) {
                PluginDisableListener.f((Player)entityDismountEvent.getEntity(), false);
            }
        } else if (entityDismountEvent.getEntity().getType() == EntityType.SLIME) {
            if (entityDismountEvent.getEntity().getCustomName() != null && entityDismountEvent.getEntity().getCustomName().equals("IASlimeVehicle")) {
                entityDismountEvent.getEntity().eject();
                entityDismountEvent.getEntity().remove();
            }
        } else if (entityDismountEvent.getEntity().getType() == EntityType.PLAYER && entityDismountEvent.getDismounted().getType() == EntityType.SLIME && entityDismountEvent.getDismounted().getCustomName() != null && entityDismountEvent.getDismounted().getCustomName().equals("IASlimeVehicle")) {
            entityDismountEvent.getDismounted().remove();
            PluginDisableListener.f((Player)entityDismountEvent.getEntity(), false);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void b(PlayerArmorStandManipulateEvent playerArmorStandManipulateEvent) {
        ArmorStand armorStand = playerArmorStandManipulateEvent.getRightClicked();
        ItemStack itemStack = armorStand.getHelmet();
        if (!ItemStackBuilder_4.isCustomItem(itemStack)) {
            return;
        }
        if (!this.zL.a((ItemStack)itemStack).Ge.bm("vehicle")) {
            return;
        }
        playerArmorStandManipulateEvent.setCancelled(true);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void a(EntityDamageEvent entityDamageEvent) {
        Player player;
        if (entityDamageEvent.getEntity().getType() != EntityType.PLAYER) {
            return;
        }
        if (entityDamageEvent.getCause() != EntityDamageEvent.DamageCause.FALL && entityDamageEvent.getCause() != EntityDamageEvent.DamageCause.SUFFOCATION) {
            return;
        }
        Entity entity = entityDamageEvent.getEntity();
        if (entity instanceof Player && zO.containsKey(player = (Player)entity) && entityDamageEvent.getEntity().getVehicle() != null) {
            entityDamageEvent.setCancelled(true);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void a(PlayerQuitEvent playerQuitEvent) {
        PluginDisableListener.ak(playerQuitEvent.getPlayer());
    }

    private static /* synthetic */ void aC(Player player) {
        LivingEntityRegistry.db().removePassenger((LivingEntity)player);
    }

    private static /* synthetic */ void aD(Player player) {
        LivingEntityRegistry.db().removePassenger((LivingEntity)player);
    }

    static {
        zO = new WeakHashMap();
        zP = new WeakHashMap();
        zQ = new WeakHashMap();
    }
}
