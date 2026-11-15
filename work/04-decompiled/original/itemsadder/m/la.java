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
import itemsadder.m.aaf;
import itemsadder.m.afz;
import itemsadder.m.aov;
import itemsadder.m.aow;
import itemsadder.m.aqp;
import itemsadder.m.auxx;
import itemsadder.m.bay;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.da;
import itemsadder.m.dp;
import itemsadder.m.ek;
import itemsadder.m.j;
import itemsadder.m.kh;
import itemsadder.m.lb;
import itemsadder.m.lc;
import itemsadder.m.ld;
import itemsadder.m.lf;
import itemsadder.m.lq;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.qm;
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

public class la
extends lq {
    private final Plugin zK;
    private final d zL;
    public static PacketAdapter zM;
    public static PacketAdapter zN;
    public static final WeakHashMap zO;
    public static final WeakHashMap zP;
    public static final WeakHashMap zQ;

    public la(Plugin plugin, d d2) {
        this.zK = plugin;
        this.zL = d2;
        bev.a(this, plugin);
        d2.ar.a(new my(BlockPlaceEvent.class, this::c));
        d2.ar.a(new my(BlockMultiPlaceEvent.class, this::c));
        d2.ar.a(new my(PlayerInteractEvent.class, this::g));
        la.lg();
    }

    private static void lg() {
        if (Version.isOlderThan((Version)Version.v1_21_3)) {
            zM = new lb((Plugin)Main.rS(), ListenerPriority.NORMAL, PacketType.Play.Client.STEER_VEHICLE);
            aow.b((PacketListener)zM);
        }
        if (Version.isAtLeast((Version)Version.v1_21_3)) {
            zN = new lc((Plugin)Main.rS(), ListenerPriority.NORMAL, PacketType.Play.Client.STEER_VEHICLE);
            aow.b((PacketListener)zN);
            bcp.b(bukkitRunnable -> {
                Vector vector;
                dp dp2;
                LivingEntity livingEntity;
                ek ek2;
                aov aov2;
                Object object;
                Player player;
                for (Map.Entry entry : zO.entrySet()) {
                    Object object2;
                    player = (Player)entry.getKey();
                    if (player.getVehicle() == null || player.getVehicle().getType() != EntityType.SLIME && !(player.getVehicle() instanceof ArmorStand) || !zO.containsKey(player)) continue;
                    if (!d.g().v) {
                        bcp.i(() -> {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 200, 5));
                            la.aB(player);
                        });
                        continue;
                    }
                    object = (lf)zO.get(player);
                    if (object == null || ((lf)object).zY == null) {
                        la.aB(player);
                        continue;
                    }
                    aov2 = (aov)zQ.get(player);
                    if (aov2 == null) continue;
                    ek2 = ((lf)object).zY;
                    livingEntity = ek2.getLocation().subtract(0.0, 1.0, 0.0);
                    if (aov2.uL()) {
                        if (livingEntity.getBlock().getType().isSolid() || livingEntity.getBlock().getType() == Material.WATER || livingEntity.getBlock().getType() == Material.LAVA) {
                            la.aB(player);
                            continue;
                        }
                        if (((lf)object).zW.fu() > 0.0f) {
                            dp2 = player.getLocation().getDirection();
                            dp2 = dp2.multiply(((lf)object).zW.fu());
                            dp2.setY(-1);
                            ek2.setVelocity((Vector)dp2);
                        }
                    }
                    dp2 = ((lf)object).zZ;
                    if (((lf)object).zW.le() != -1 && dp2.getInt("Fuel") <= 0) continue;
                    ((lf)object).Ab = ek2.getLocation().getYaw();
                    afz.a((Entity)ek2, player.getLocation().getYaw());
                    if (ek2.getPassenger() != null && ek2.getPassenger().getType() == EntityType.SLIME) {
                        afz.a(ek2.getPassenger(), ek2.getLocation().getYaw());
                    }
                    if ((aov2.uG() || aov2.uH() || aov2.uK()) && ((lf)object).zW.le() != -1 && System.currentTimeMillis() - ((lf)object).Aa >= 1000L) {
                        ((lf)object).Aa = System.currentTimeMillis();
                        dp2.setInt("Fuel", dp2.getInt("Fuel") - 1);
                        object2 = la.aA(player);
                        ((ld)object2).gF();
                        ((ld)object2).bf(Main.PQ.ir("fuel-indicator").replace("{value}", "" + dp2.getInt("Fuel")).replace("{max}", "" + ((lf)object).zW.le()));
                        dp2.save();
                        ek2.setHelmet(dp2.getItem());
                    }
                    if (aov2.uG()) {
                        boolean bl = ek2.getLocation().subtract(0.0, 2.0, 0.0).getBlock().getType().isSolid();
                        double d2 = ((lf)object).zW.lb();
                        if (((lf)object).zW.fu() > 0.0f && !bl) {
                            d2 = ((lf)object).zW.fu();
                        }
                        vector = ek2.getLocation().getDirection();
                        if (((lf)object).zW.fu() > 0.0f) {
                            vector.setY(0.078);
                        } else {
                            vector.setY(-1);
                        }
                        vector = vector.multiply(d2);
                        ek2.setVelocity(vector);
                        if (((lf)object).zW.fu() > 0.0f && !bl) {
                            continue;
                        }
                    } else if (aov2.uH()) {
                        object2 = ek2.getLocation().getDirection();
                        object2 = object2.multiply(-((lf)object).zW.lb() / 2.0f);
                        object2.setY(ek2.getVelocity().getY());
                        ek2.setVelocity((Vector)object2);
                    } else if (((lf)object).zW.kY() > 0) {
                        ((lf)object).z(ek2.getLocation());
                    }
                    if (!aov2.uK()) continue;
                    if (livingEntity.getBlock().getType().isSolid() && !ek2.getLocation().subtract(0.0, 0.0, 0.0).getBlock().getType().isSolid()) {
                        if (!(((lf)object).zW.lc() > 0.0f)) continue;
                        Vector vector2 = ek2.getVelocity();
                        vector2.setY(1);
                        vector2 = vector2.multiply(((lf)object).zW.lc());
                        ek2.setVelocity(vector2);
                        continue;
                    }
                    if (!(((lf)object).zW.fu() > 0.0f)) continue;
                    Vector vector3 = player.getLocation().getDirection();
                    vector3.setY(1);
                    vector3 = vector3.multiply(((lf)object).zW.fu());
                    ek2.setVelocity(vector3);
                }
                if (da.P()) {
                    for (Map.Entry entry : da.db().df().entrySet()) {
                        player = (LivingEntity)entry.getKey();
                        if (!(player instanceof Player) || (aov2 = (aov)zQ.get(object = player)) == null) continue;
                        ek2 = (ek)entry.getValue();
                        livingEntity = ek2.oy;
                        dp2 = ek2.gH().my;
                        if (ek2.canControl()) {
                            float f2;
                            boolean bl = dp2.fu() > 0.0f;
                            Vector vector4 = livingEntity.getVelocity();
                            Location location = livingEntity.getLocation().clone();
                            location.setPitch(0.0f);
                            vector = location.getDirection();
                            vector.normalize();
                            if (aov2.uG() || aov2.uH()) {
                                double d3 = dp2.ft();
                                if (livingEntity.isOnGround()) {
                                    if (aov2.uK()) {
                                        vector4.setY(0.5);
                                    }
                                } else if (bl) {
                                    d3 = dp2.fu();
                                }
                                if (aov2.uG()) {
                                    vector.multiply(d3);
                                } else {
                                    vector.multiply(-d3);
                                }
                                if (aov2.uL() && bl && !livingEntity.isOnGround()) {
                                    vector.setY(-dp2.fu() * 4.0f);
                                }
                                vector4 = vector4.add(vector);
                            } else {
                                if (aov2.uK()) {
                                    if (livingEntity.isOnGround()) {
                                        vector4.setY(0.5);
                                        livingEntity.setVelocity(vector4);
                                    } else if (bl) {
                                        vector4.setY(dp2.fu() * 4.0f);
                                    }
                                }
                                if (aov2.uL()) {
                                    if (!ek2.isLocked() && livingEntity.isOnGround()) {
                                        bcp.i(() -> la.aD((Player)object));
                                    } else if (bl && !livingEntity.isOnGround()) {
                                        vector4.setY(-dp2.fu() * 4.0f);
                                    }
                                }
                            }
                            if (dp2.fu() <= 0.0f) {
                                vector4.setY(-1);
                            }
                            livingEntity.setVelocity(vector4);
                            float f3 = object.getEyeLocation().getYaw();
                            float f4 = location.getYaw();
                            if (aov2.eu()) {
                                f2 = bcc.e(f4, f3, 0.6f);
                                livingEntity.setRotation(f2, livingEntity.getEyeLocation().getPitch());
                                continue;
                            }
                            f2 = Math.abs(bcc.D(f4 - f3));
                            if (!(f2 > 60.0f)) continue;
                            float f5 = bcc.e(f4, f3, 0.1f);
                            livingEntity.setRotation(f5, livingEntity.getEyeLocation().getPitch());
                            continue;
                        }
                        if (!aov2.uL() || ek2.isLocked()) continue;
                        bcp.i(() -> la.aC((Player)object));
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

    private static ld aA(Player player) {
        ld ld2 = (ld)zP.get(player);
        if (ld2 == null) {
            zP.put(player, new ld(player, "", BarColor.BLUE, BarStyle.SOLID));
            ld2 = (ld)zP.get(player);
        }
        return ld2;
    }

    private static void ak(Player player) {
        zQ.remove(player);
        if (zO.containsKey(player)) {
            ((lf)zO.get(player)).ll();
            zO.remove(player);
        }
        if (zP.containsKey(player)) {
            ((ld)zP.get(player)).li();
        }
        zP.remove(player);
    }

    void a(kh kh2, ItemStack itemStack, Block block, Player player, EquipmentSlot equipmentSlot) {
        if (this.aJ(player)) {
            return;
        }
        Location location = block.getLocation();
        location.setX(location.getX() + 0.5);
        location.setY(location.getY());
        location.setZ(location.getZ() + 0.5);
        if (kh2.kB()) {
            location.setYaw((float)bcc.b(player.getLocation().getYaw(), false));
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
            armorStand.setSmall(kh2.kC());
            armorStand.setGravity(true);
            armorStand.setCollidable(true);
            ItemStack itemStack2 = kh2.zk.getType() == itemStack.getType() ? itemStack.clone() : kh2.zk.mP();
            qm.a(itemStack2, player.getUniqueId().toString());
            NItem nItem = new NItem(itemStack2);
            if (!nItem.hasKey("Fuel")) {
                nItem.setInt("Fuel", kh2.ld());
            }
            nItem.save();
            bcp.c(() -> armorStand.setHelmet(itemStack2), 2L);
            kh2.q((Entity)armorStand);
        });
        kh2.xu.HQ.f(player, location);
        aqp.a(player, equipmentSlot);
        if (player.getGameMode() != GameMode.CREATIVE) {
            itemStack.setAmount(itemStack.getAmount() - 1);
        }
        this.aK(player);
        kh2.a((Entity)armorStand2, kh2.zk);
        this.zL.aC.aw(player);
    }

    static void f(Player player, boolean bl) {
        Location location = player.getVehicle() != null ? player.getVehicle().getLocation() : player.getLocation().clone();
        location.add(0.0, 0.5, 0.0);
        lf lf2 = (lf)zO.get(player);
        la.ak(player);
        if (lf2 != null) {
            ArmorStand armorStand = lf2.zY;
            player.leaveVehicle();
            player.teleport(location);
            if (bl && armorStand != null) {
                afz.a(armorStand, false);
            }
            bcp.c(() -> lf2.zW.q((Entity)armorStand), 20L);
        } else {
            player.leaveVehicle();
            player.teleport(location);
        }
    }

    static void aB(Player player) {
        Location location = player.getVehicle() != null ? player.getVehicle().getLocation() : player.getLocation().clone();
        location.add(0.0, 0.5, 0.0);
        bcp.i(() -> {
            lf lf2 = (lf)zO.get(player);
            la.ak(player);
            if (lf2 == null) {
                return;
            }
            ArmorStand armorStand = lf2.zY;
            player.leaveVehicle();
            player.teleport(location);
            if (armorStand != null) {
                afz.a(armorStand, false);
            }
            bcp.c(() -> lf2.zW.q((Entity)armorStand), 20L);
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
            int n = aaf.a(player.getVehicle().getLocation().getChunk(), location.getBlockX() >> 4, location.getBlockZ() >> 4, HeightMap.MOTION_BLOCKING);
            la.f(player, n <= 1);
        }
    }

    @mz
    void c(BlockPlaceEvent blockPlaceEvent, qm qm2, ItemStack itemStack) {
        if (!qm2.Ge.bm("vehicle")) {
            return;
        }
        blockPlaceEvent.setCancelled(true);
        if (blockPlaceEvent.getBlockAgainst() == null) {
            return;
        }
        kh kh2 = (kh)qm2.Ge.bn("vehicle");
        Block block = blockPlaceEvent.getBlockPlaced();
        this.a(kh2, itemStack, block, blockPlaceEvent.getPlayer(), blockPlaceEvent.getHand());
    }

    @mz
    void g(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        Block block;
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (itemStack.getType().isBlock()) {
            return;
        }
        if (!qm2.Ge.bm("vehicle")) {
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
        if (bcc.e(player, block)) {
            return;
        }
        if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND && d.g().hasBehaviour(playerInteractEvent.getPlayer().getItemInHand(), "furniture")) {
            return;
        }
        if (bay.a(block, EntityType.ARMOR_STAND) != null) {
            return;
        }
        kh kh2 = (kh)qm2.Ge.bn("vehicle");
        this.a(kh2, itemStack, block, playerInteractEvent.getPlayer(), playerInteractEvent.getHand());
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void e(PlayerInteractAtEntityEvent playerInteractAtEntityEvent) {
        if (bbs.d((PlayerInteractEntityEvent)playerInteractAtEntityEvent)) {
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
        qm qm2 = this.zL.a(itemStack);
        if (qm2 == null) {
            return;
        }
        if (!qm2.Ge.bm("vehicle")) {
            return;
        }
        kh kh2 = (kh)qm2.Ge.bn("vehicle");
        if (!ProtectionPlugins.canSitOnVehicle(playerInteractAtEntityEvent, itemStack)) {
            return;
        }
        playerInteractAtEntityEvent.setCancelled(true);
        NItem nItem = new NItem(itemStack);
        Player player = playerInteractAtEntityEvent.getPlayer();
        if (kh2.le() != -1) {
            ld ld2 = la.aA(player);
            ld2.gF();
            ld2.bf(Main.PQ.ir("fuel-indicator").replace("{value}", "" + nItem.getInt("Fuel")).replace("{max}", "" + kh2.le()));
            ld2.lh();
            ItemStack itemStack2 = bbs.cA(player);
            if (kh2.i(itemStack2)) {
                int n = kh2.j(itemStack2);
                if (nItem.getInt("Fuel") + n <= kh2.le()) {
                    ItemStack itemStack3 = kh2.k(itemStack2);
                    bbs.cy(player);
                    nItem.setInt("Fuel", nItem.getInt("Fuel") + n);
                    nItem.save();
                    armorStand.setHelmet(itemStack);
                    if (itemStack3 != null) {
                        bbs.f(player, itemStack3);
                    }
                    return;
                }
            }
        }
        if (nItem.getInt("Fuel") == 0) {
            return;
        }
        if (!j.V().d(player)) {
            double d2 = kh2.la();
            if ((int)d2 - 2 != 0) {
                Slime slime2 = (Slime)player.getWorld().spawn(player.getLocation(), Slime.class, slime -> {
                    auxx.a((Entity)slime, (int)d2 - 1);
                    slime.setPersistent(false);
                    slime.setAI(false);
                    slime.setSilent(true);
                    slime.setInvulnerable(true);
                    slime.setCustomNameVisible(false);
                    armorStand.setPassenger((Entity)slime);
                    slime.setPassenger((Entity)player);
                    slime.setCustomName("IASlimeVehicle");
                    afz.tK().a(player, (LivingEntity)slime);
                });
                bcp.c(() -> {
                    afz.b((Entity)slime2, true);
                    slime2.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, false, false));
                }, 5L);
            } else {
                armorStand.setPassenger((Entity)player);
                afz.tK().a(player, (LivingEntity)armorStand);
            }
            lf lf2 = new lf(kh2, armorStand, player.getVehicle(), new NItem(itemStack), System.currentTimeMillis());
            zO.put(player, lf2);
            lf2.lk();
            afz.a(armorStand, true);
            kh2.q((Entity)armorStand);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    private void b(EntityDismountEvent entityDismountEvent) {
        Entity entity;
        if (entityDismountEvent.getEntity().getType() == EntityType.PLAYER && entityDismountEvent.getDismounted() instanceof ArmorStand && (entity = entityDismountEvent.getEntity()) instanceof Player) {
            Player player = (Player)entity;
            if (zO.containsKey(player)) {
                la.f((Player)entityDismountEvent.getEntity(), false);
            }
        } else if (entityDismountEvent.getEntity().getType() == EntityType.SLIME) {
            if (entityDismountEvent.getEntity().getCustomName() != null && entityDismountEvent.getEntity().getCustomName().equals("IASlimeVehicle")) {
                entityDismountEvent.getEntity().eject();
                entityDismountEvent.getEntity().remove();
            }
        } else if (entityDismountEvent.getEntity().getType() == EntityType.PLAYER && entityDismountEvent.getDismounted().getType() == EntityType.SLIME && entityDismountEvent.getDismounted().getCustomName() != null && entityDismountEvent.getDismounted().getCustomName().equals("IASlimeVehicle")) {
            entityDismountEvent.getDismounted().remove();
            la.f((Player)entityDismountEvent.getEntity(), false);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void b(PlayerArmorStandManipulateEvent playerArmorStandManipulateEvent) {
        ArmorStand armorStand = playerArmorStandManipulateEvent.getRightClicked();
        ItemStack itemStack = armorStand.getHelmet();
        if (!qm.isCustomItem(itemStack)) {
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
        la.ak(playerQuitEvent.getPlayer());
    }

    private static /* synthetic */ void aC(Player player) {
        da.db().removePassenger((LivingEntity)player);
    }

    private static /* synthetic */ void aD(Player player) {
        da.db().removePassenger((LivingEntity)player);
    }

    static {
        zO = new WeakHashMap();
        zP = new WeakHashMap();
        zQ = new WeakHashMap();
    }
}
