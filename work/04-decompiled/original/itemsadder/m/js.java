package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import com.google.common.util.concurrent.AtomicDouble;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.FurniturePlaceSuccessEvent;
import dev.lone.itemsadder.api.Events.FurniturePlacedEvent;
import dev.lone.itemsadder.api.Events.FurniturePrePlaceEvent;
import itemsadder.m.afz;
import itemsadder.m.aqp;
import itemsadder.m.bay;
import itemsadder.m.bbh;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bcy;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.jl;
import itemsadder.m.ju;
import itemsadder.m.jv;
import itemsadder.m.kh;
import itemsadder.m.lq;
import itemsadder.m.qm;
import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import lombok.Generated;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.GlowItemFrame;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Transformation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.AxisAngle4f;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;

public class js
extends jl {
    public static final String ye = "furniture";
    static NamespacedKey yf = new NamespacedKey("itemsadder", "has_edited_transformation");
    final boolean yg;
    final int yh;
    final boolean yi;
    final boolean yj;
    final boolean yk;
    final boolean yl;
    private ItemDisplay.ItemDisplayTransform ym;
    @Nullable
    String yn;
    @Nullable
    String yo;
    @Nullable
    private Transformation yp;
    @Nullable
    private ju yq;
    private boolean yr;
    private float ys;
    private float yt;

    public js(qm qm2, EntityType entityType, boolean bl, boolean bl2, boolean bl3, int n, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        super(qm2, entityType, bl2, bl3);
        this.yg = bl;
        this.yh = bcy.p(n, 0, 15);
        this.yi = bl4;
        this.yj = bl5;
        this.yk = bl6;
        this.yl = bl7;
        this.ym = ItemDisplay.ItemDisplayTransform.FIXED;
    }

    public static String getName() {
        return ye;
    }

    public static void a(Entity entity, ItemStack itemStack) {
        Entity entity2 = entity;
        int n = 0;
        switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{ArmorStand.class, ItemFrame.class, ItemDisplay.class}, (Object)entity2, n)) {
            case 0: {
                ArmorStand armorStand = (ArmorStand)entity2;
                armorStand.setHelmet(itemStack.clone());
                break;
            }
            case 1: {
                ItemFrame itemFrame = (ItemFrame)entity2;
                itemFrame.setItem(itemStack.clone(), false);
                break;
            }
            case 2: {
                ItemDisplay itemDisplay = (ItemDisplay)entity2;
                itemDisplay.setItemStack(itemStack.clone());
                break;
            }
            default: {
                throw new IllegalArgumentException("Entity is not ArmorStand, ItemFrame or ItemDisplay.");
            }
        }
    }

    public static boolean a(qm qm2, qm qm3, Entity entity) {
        js js2 = (js)qm2.Ge.bn(ye);
        js js3 = (js)qm3.Ge.bn(ye);
        if (js2 != null && js3 != null) {
            js3.s(entity);
            js2.a(entity, qm2);
            js2.q(entity);
            if (js2.kI()) {
                bcp.a(() -> js2.r(entity), 5L, js3.kI());
            }
            bay.bk(entity.getLocation().getBlock());
            bay.d(entity.getLocation().getBlock(), js2.kH());
            ItemStack itemStack = qm2.mP();
            itemStack = js.h(itemStack);
            js.a(entity, itemStack);
            return true;
        }
        if (js2 == null) {
            bce.warn("Cannot replace furniture. New item is not a furniture: " + qm2.getNamespacedID());
        }
        if (js3 == null) {
            bce.warn("Cannot replace furniture. Old item is not a furniture: " + qm3.getNamespacedID());
        }
        return false;
    }

    public static void v(Entity entity) {
        Location location;
        ItemStack itemStack = js.o(entity);
        if (!qm.isCustomItem(itemStack)) {
            return;
        }
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return;
        }
        js js2 = (js)qm2.Ge.bn(ye);
        if (js2 == null) {
            return;
        }
        if (js2.xr == entity.getType()) {
            if (js2.xr == EntityType.ITEM_DISPLAY) {
                ItemDisplay itemDisplay;
                Boolean bl;
                if (js2.yr && ((bl = (Boolean)(itemDisplay = (ItemDisplay)entity).getPersistentDataContainer().get(yf, PersistentDataType.BOOLEAN)) == null || !bl.booleanValue())) {
                    if (js2.yp != null) {
                        itemDisplay.setTransformation(js2.yp);
                    }
                    if (js2.ym != null) {
                        itemDisplay.setItemDisplayTransform(js2.ym);
                    }
                }
                js2.q(entity);
                if (js2.yi) {
                    js2.r(entity);
                }
            }
            return;
        }
        if (js2.xz != 0.0f && js2.yi && js2.xr == EntityType.ITEM_DISPLAY) {
            location = entity.getBoundingBox();
            for (BlockFace blockFace : js.b(entity.getWorld(), location.getMinX(), location.getMaxX(), location.getMinY(), location.getMaxY(), location.getMinZ(), location.getMaxZ())) {
                if (blockFace.getBlock().getType() != Material.BARRIER) continue;
                blockFace.getBlock().setType(Material.AIR);
            }
        }
        location = entity.getLocation();
        if (entity instanceof ItemFrame) {
            BlockFace blockFace;
            ItemFrame itemFrame = (ItemFrame)entity;
            blockFace = itemFrame.getFacing();
            switch (blockFace) {
                case NORTH: {
                    location.setZ(location.getZ() - 0.5);
                    location.setY(location.getY() - 0.5);
                    break;
                }
                case SOUTH: {
                    location.setZ(location.getZ() + 0.5);
                    location.setY(location.getY() - 0.5);
                    break;
                }
                case EAST: {
                    location.setX(location.getX() + 0.5);
                    location.setY(location.getY() - 0.5);
                    break;
                }
                case WEST: {
                    location.setX(location.getX() - 0.5);
                    location.setY(location.getY() - 0.5);
                    break;
                }
                case UP: {
                    location.setYaw(0.0f);
                    location.setPitch(0.0f);
                    break;
                }
                case DOWN: {
                    location.setY(location.getY() - 1.0);
                }
            }
            switch (itemFrame.getRotation()) {
                case CLOCKWISE_45: {
                    location.setYaw(45.0f);
                    break;
                }
                case CLOCKWISE: {
                    location.setYaw(90.0f);
                    break;
                }
                case CLOCKWISE_135: {
                    location.setYaw(135.0f);
                    break;
                }
                case FLIPPED: {
                    location.setYaw(180.0f);
                    break;
                }
                case FLIPPED_45: {
                    location.setYaw(-135.0f);
                    break;
                }
                case COUNTER_CLOCKWISE: {
                    location.setYaw(-90.0f);
                    break;
                }
                case COUNTER_CLOCKWISE_45: {
                    location.setYaw(-45.0f);
                }
            }
            js2.a(null, location, itemStack, null, blockFace, (T entity2) -> entity.remove());
        } else {
            js2.a(location, itemStack, (T entity2) -> entity.remove());
        }
    }

    public boolean kG() {
        return this.yg;
    }

    public int kH() {
        return this.yh;
    }

    public boolean kI() {
        return this.yi;
    }

    public boolean kJ() {
        return this.yk;
    }

    public boolean kK() {
        return this.yl;
    }

    @Nullable
    public String kL() {
        return this.yn;
    }

    public void bc(String string) {
        this.yn = string;
    }

    @Nullable
    public String kM() {
        return this.yo;
    }

    public void bd(String string) {
        this.yo = string;
    }

    public void a(Transformation transformation) {
        this.yp = transformation;
    }

    public void a(ItemDisplay.ItemDisplayTransform itemDisplayTransform) {
        this.ym = itemDisplayTransform;
    }

    public void a(@Nullable ju ju2) {
        this.yq = ju2;
    }

    @Override
    public void q(Entity entity) {
        if (entity instanceof ItemFrame) {
            this.z(entity);
        } else if (entity instanceof ItemDisplay) {
            ItemDisplay itemDisplay = (ItemDisplay)entity;
            this.b(itemDisplay);
        } else {
            this.y(entity);
        }
    }

    @Override
    public void a(Entity entity, qm qm2) {
        super.a(entity, qm2);
        entity.getPersistentDataContainer().set(xq, PersistentDataType.STRING, (Object)ye);
        entity.setCustomName("ItemsAdder_furniture");
        entity.setCustomNameVisible(false);
    }

    public static boolean w(Entity entity) {
        String string = (String)entity.getPersistentDataContainer().get(xq, PersistentDataType.STRING);
        return string != null && string.equals(ye);
    }

    @Nullable
    public Entity a(ItemStack itemStack, Block block) {
        return this.a(itemStack, null, block, null, null, null, null);
    }

    @Nullable
    public Entity a(ItemStack itemStack, Location location) {
        return this.a(itemStack, location, null, null, null, null, null);
    }

    @Nullable
    public Entity a(ItemStack itemStack, Block block, @Nullable EquipmentSlot equipmentSlot, @Nullable Player player, @Nullable lq lq2, @Nullable BlockFace blockFace) {
        return this.a(itemStack, null, block, equipmentSlot, player, lq2, blockFace);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    public Entity a(ItemStack itemStack, @Nullable Location location, @Nullable Block block, @Nullable EquipmentSlot equipmentSlot, @Nullable Player player, @Nullable lq lq2, @Nullable BlockFace blockFace) {
        Location location2;
        if (player != null && lq2 != null && lq2.aJ(player)) {
            return null;
        }
        if (blockFace != null) {
            if (blockFace.equals((Object)BlockFace.DOWN)) {
                if (!this.xC) {
                    return null;
                }
            } else if (blockFace.equals((Object)BlockFace.UP)) {
                if (!this.xD) {
                    return null;
                }
            } else if (!this.xB) {
                if (block == null || !block.getRelative(BlockFace.DOWN).getType().isSolid()) return null;
                if (!this.xD) return null;
                blockFace = BlockFace.UP;
            }
        } else {
            blockFace = BlockFace.UP;
        }
        if (block == null) {
            location2 = location.clone();
        } else {
            location2 = block.getLocation();
            location2.setX(location2.getX() + 0.5);
            location2.setY(location2.getY());
            location2.setZ(location2.getZ() + 0.5);
        }
        if (!bev.b((Event)new FurniturePrePlaceEvent(player, this, location2))) {
            return null;
        }
        int n = Main.KO.t("entities.max-furniture-vehicles-per-chunk", 0);
        long l = Arrays.stream(location2.getChunk().getEntities()).filter(entity -> js.w(entity) || kh.D(entity)).count();
        if (n > 0 && l + 1L > (long)n) {
            if (player == null) return null;
            bce.f((CommandSender)player, Main.PQ.ir("max-furnitures-vehicles-reached").replace("{value}", "" + n));
            return null;
        }
        if (player != null) {
            if (this.kB()) {
                location2.setYaw((float)bcc.b(player.getLocation().getYaw(), false));
            } else {
                location2.setYaw(player.getLocation().getYaw());
            }
            if (this.yj) {
                location2.setYaw(location2.getYaw() + 180.0f);
            }
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Entity entity2 = this.a(player, location2, itemStack, block, blockFace, (T entity) -> {
            FurniturePlacedEvent furniturePlacedEvent = new FurniturePlacedEvent(player, (Entity)entity, this);
            if (!bev.b((Event)furniturePlacedEvent)) {
                entity.remove();
                this.s((Entity)entity);
                atomicBoolean.set(true);
                return;
            }
            bev.b((Event)new FurniturePlaceSuccessEvent(player, (Entity)entity, this));
        });
        if (atomicBoolean.get()) {
            return null;
        }
        if (entity2 == null) return entity2;
        bay.d(location2.getBlock(), this.yh);
        if (player == null) return entity2;
        this.xu.HQ.f(player, location2);
        aqp.a(player, equipmentSlot);
        if (player.getGameMode() != GameMode.CREATIVE) {
            itemStack.setAmount(itemStack.getAmount() - 1);
        }
        if (lq2 == null) return entity2;
        lq2.aK(player);
        return entity2;
    }

    @Nullable
    private Entity a(Location location, ItemStack itemStack, Consumer consumer) {
        return this.a(null, location, itemStack, null, null, consumer);
    }

    @Nullable
    private Entity a(@Nullable Player player, Location location, ItemStack itemStack, @Nullable Block block, @Nullable BlockFace blockFace, Consumer consumer) {
        ItemStack itemStack2;
        Transformation transformation = null;
        boolean bl = false;
        Entity entity = null;
        if (this.xr == EntityType.ARMOR_STAND) {
            entity = location.getWorld().spawn(location, ArmorStand.class, armorStand -> {
                armorStand.setVisible(false);
                armorStand.setAI(true);
                armorStand.setRemoveWhenFarAway(false);
                armorStand.setCanPickupItems(false);
                armorStand.setInvulnerable(false);
                armorStand.setSilent(true);
                armorStand.setSmall(this.kC());
                armorStand.setGravity(this.kG());
                armorStand.setCollidable(true);
                afz.a(armorStand, false);
                ItemStack itemStack2 = this.zk.getType() == itemStack.getType() ? itemStack.clone() : this.zk.mP();
                itemStack2.setAmount(1);
                bcp.c(() -> {
                    armorStand.setHelmet(itemStack2);
                    consumer.accept(armorStand);
                }, 2L);
            });
        } else if (afz.i(this.xr)) {
            itemStack2 = js.h(itemStack);
            try {
                @NotNull Class clazz = this.xr == EntityType.GLOW_ITEM_FRAME ? GlowItemFrame.class : ItemFrame.class;
                entity = location.getWorld().spawn(location, clazz, itemFrame -> {
                    itemFrame.setItem(itemStack2, false);
                    itemFrame.setVisible(false);
                    itemFrame.setFixed(true);
                    if (blockFace != null) {
                        itemFrame.setFacingDirection(blockFace);
                    }
                    jv jv2 = js.A((Entity)itemFrame);
                    switch (jv2.ordinal()) {
                        case 2: {
                            itemFrame.setRotation(bcc.C(bcc.b(this.yj ? BlockFace.SOUTH : BlockFace.NORTH)));
                            break;
                        }
                        case 0: 
                        case 1: {
                            itemFrame.setRotation(this.kB() ? bcc.C(bcc.b(location.getYaw(), false)) : bcc.C(location.getYaw()));
                        }
                    }
                    consumer.accept(itemFrame);
                });
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return null;
            }
        } else if (this.xr == EntityType.ITEM_DISPLAY) {
            if (this.yp != null) {
                transformation = bbh.b(this.yp);
            }
            if (blockFace != null) {
                double d2 = 0.001;
                if (this.xD && blockFace == BlockFace.UP) {
                    location.setY(location.getY() + d2);
                }
                if (this.xC && blockFace == BlockFace.DOWN) {
                    location.setY(location.getY() - d2);
                    location.add(0.0, 1.0, 0.0);
                    if (transformation == null) {
                        transformation = bbh.CQ();
                    }
                    transformation.getLeftRotation().set((Quaternionfc)new Quaternionf(new AxisAngle4f((float)Math.toRadians(180.0), 0.0f, 0.0f, 1.0f)));
                    if (this.yq == ju.ARMOR_STAND) {
                        transformation.getTranslation().add(0.0f, -2.45f, 0.0f);
                    } else if (this.yq == ju.SMALL_ARMOR_STAND) {
                        transformation.getTranslation().add(0.0f, -0.82f, 0.0f);
                    }
                    bl = true;
                }
                if (this.xB) {
                    switch (blockFace) {
                        case NORTH: {
                            location.setZ(location.getZ() + 0.5 - d2);
                            location.setY(location.getY() + 0.5);
                            location.setYaw(180.0f);
                            location.setPitch(90.0f);
                            break;
                        }
                        case SOUTH: {
                            location.setZ(location.getZ() - 0.5 + d2);
                            location.setY(location.getY() + 0.5);
                            location.setYaw(0.0f);
                            location.setPitch(90.0f);
                            break;
                        }
                        case EAST: {
                            location.setX(location.getX() - 0.5 + d2);
                            location.setY(location.getY() + 0.5);
                            location.setYaw(-90.0f);
                            location.setPitch(90.0f);
                            break;
                        }
                        case WEST: {
                            location.setX(location.getX() + 0.5 - d2);
                            location.setY(location.getY() + 0.5);
                            location.setYaw(90.0f);
                            location.setPitch(90.0f);
                        }
                    }
                } else {
                    switch (blockFace) {
                        case NORTH: 
                        case SOUTH: 
                        case EAST: 
                        case WEST: {
                            location.setY(location.getY() + d2);
                        }
                    }
                }
            }
            itemStack2 = transformation;
            boolean bl2 = bl;
            entity = location.getWorld().spawn(location, ItemDisplay.class, arg_0 -> this.a(itemStack, (Transformation)itemStack2, bl2, consumer, arg_0));
        }
        if (entity != null) {
            this.q(entity);
            if (this.yi && block != null) {
                if (this.zk.getType().isSolid()) {
                    itemStack2 = entity;
                    bcp.c(() -> this.d((Entity)itemStack2, player), 1L);
                } else {
                    this.a(entity, player);
                }
            }
            this.a(entity, this.zk);
            if (player != null && player.hasMetadata("DrawFurnitureHitbox")) {
                js.c(entity, player);
            }
        }
        return entity;
    }

    public static ItemStack h(ItemStack itemStack) {
        ItemStack itemStack2 = itemStack.clone();
        itemStack2.setAmount(1);
        NItem nItem = new NItem(itemStack2);
        String string = bbs.ag(itemStack2);
        if (string != null) {
            nItem.setString("IAOrigName", string);
            nItem.save();
            ItemMeta itemMeta = itemStack2.getItemMeta();
            itemMeta.setDisplayName(null);
            itemStack2.setItemMeta(itemMeta);
        }
        return itemStack2;
    }

    public static void c(Entity entity, Player player) {
        js.a(entity, player, true);
    }

    public static void a(Entity entity, Player player, boolean bl) {
        AtomicDouble atomicDouble = new AtomicDouble();
        bcp.b(bukkitRunnable -> {
            if (entity.isDead() || !entity.isValid() || bl && !player.hasMetadata("DrawFurnitureHitbox") || !player.isOnline() || !player.getWorld().equals((Object)entity.getWorld()) || atomicDouble.get() >= 50.0) {
                bukkitRunnable.cancel();
            }
            js.a(entity.getWorld(), entity.getBoundingBox().getMinX(), entity.getBoundingBox().getMaxX(), entity.getBoundingBox().getMinY(), entity.getBoundingBox().getMaxY(), entity.getBoundingBox().getMinZ(), entity.getBoundingBox().getMaxZ());
            atomicDouble.set(atomicDouble.get() + 1.0);
        }, 0L, 2L);
    }

    public static void a(BoundingBox boundingBox, Player player, boolean bl) {
        AtomicDouble atomicDouble = new AtomicDouble();
        bcp.b(bukkitRunnable -> {
            if (!player.isOnline() || bl && !player.hasMetadata("DrawFurnitureHitbox") || !player.getWorld().equals((Object)player.getWorld()) || atomicDouble.get() >= 50.0) {
                bukkitRunnable.cancel();
            }
            js.a(player.getWorld(), boundingBox.getMinX(), boundingBox.getMaxX(), boundingBox.getMinY(), boundingBox.getMaxY(), boundingBox.getMinZ(), boundingBox.getMaxZ());
            atomicDouble.set(atomicDouble.get() + 1.0);
        }, 0L, 2L);
    }

    public static void x(Entity entity) {
        js js2 = (js)js.c(entity, ye);
        if (js2 != null) {
            js2.q(entity);
        }
    }

    private void y(Entity entity) {
        Location location = entity.getLocation();
        BlockFace blockFace = bcc.B(location.getYaw());
        BoundingBox boundingBox = null;
        float f2 = this.xz;
        switch (blockFace) {
            case NORTH: 
            case NORTH_WEST: 
            case NORTH_EAST: {
                boundingBox = new BoundingBox(location.getX() - (double)(this.xw / 2.0f) + (double)f2, location.getY() + (double)this.xA, location.getZ() - (double)(this.xv / 2.0f) + (double)this.xy, location.getX() + (double)(this.xw / 2.0f) + (double)f2, location.getY() + (double)this.xx + (double)this.xA, location.getZ() + (double)(this.xv / 2.0f) + (double)this.xy);
                break;
            }
            case SOUTH: 
            case SOUTH_WEST: 
            case SOUTH_EAST: {
                boundingBox = new BoundingBox(location.getX() - (double)(this.xw / 2.0f) - (double)f2, location.getY() + (double)this.xA, location.getZ() - (double)(this.xv / 2.0f) - (double)this.xy, location.getX() + (double)(this.xw / 2.0f) - (double)f2, location.getY() + (double)this.xx + (double)this.xA, location.getZ() + (double)(this.xv / 2.0f) - (double)this.xy);
                break;
            }
            case WEST: {
                boundingBox = new BoundingBox(location.getX() - (double)(this.xv / 2.0f) + (double)this.xy, location.getY() + (double)this.xA, location.getZ() - (double)(this.xw / 2.0f) - (double)f2, location.getX() + (double)(this.xv / 2.0f) + (double)this.xy, location.getY() + (double)this.xx + (double)this.xA, location.getZ() + (double)(this.xw / 2.0f) - (double)f2);
                break;
            }
            case EAST: {
                boundingBox = new BoundingBox(location.getX() - (double)(this.xv / 2.0f) - (double)this.xy, location.getY() + (double)this.xA, location.getZ() - (double)(this.xw / 2.0f) + (double)f2, location.getX() + (double)(this.xv / 2.0f) - (double)this.xy, location.getY() + (double)this.xx + (double)this.xA, location.getZ() + (double)(this.xw / 2.0f) + (double)f2);
            }
        }
        if (boundingBox != null) {
            afz.a(entity, boundingBox);
        }
    }

    private void b(ItemDisplay itemDisplay) {
        boolean bl;
        Location location = itemDisplay.getLocation();
        BlockFace blockFace = bcc.B(location.getYaw());
        BoundingBox boundingBox = null;
        float f2 = -this.xz;
        boolean bl2 = itemDisplay.getTransformation().getLeftRotation().equals((Object)new Quaternionf(new AxisAngle4f((float)Math.toRadians(180.0), 0.0f, 0.0f, 1.0f)));
        boolean bl3 = bl = location.getPitch() == 90.0f;
        if (bl2) {
            switch (blockFace) {
                case NORTH: 
                case NORTH_WEST: 
                case NORTH_EAST: {
                    boundingBox = new BoundingBox(location.getX() - (double)(this.xw / 2.0f) + (double)f2, location.getY() + (double)this.xA, location.getZ() - (double)(this.xv / 2.0f) + (double)this.xy, location.getX() + (double)(this.xw / 2.0f) + (double)f2, location.getY() + (double)this.xx + (double)this.xA, location.getZ() + (double)(this.xv / 2.0f) + (double)this.xy);
                    if (this.xw != 2.0f) break;
                    boundingBox.shift(0.5, 0.0, 0.0);
                    break;
                }
                case SOUTH: 
                case SOUTH_WEST: 
                case SOUTH_EAST: {
                    boundingBox = new BoundingBox(location.getX() - (double)(this.xw / 2.0f) - (double)f2, location.getY() + (double)this.xA, location.getZ() - (double)(this.xv / 2.0f) - (double)this.xy, location.getX() + (double)(this.xw / 2.0f) - (double)f2, location.getY() + (double)this.xx + (double)this.xA, location.getZ() + (double)(this.xv / 2.0f) - (double)this.xy);
                    if (this.xw != 2.0f) break;
                    boundingBox.shift(-0.5, 0.0, 0.0);
                    break;
                }
                case WEST: {
                    boundingBox = new BoundingBox(location.getX() - (double)(this.xv / 2.0f) + (double)this.xy, location.getY() + (double)this.xA, location.getZ() - (double)(this.xw / 2.0f) - (double)f2, location.getX() + (double)(this.xv / 2.0f) + (double)this.xy, location.getY() + (double)this.xx + (double)this.xA, location.getZ() + (double)(this.xw / 2.0f) - (double)f2);
                    if (this.xw != 2.0f) break;
                    boundingBox.shift(0.0, 0.0, -0.5);
                    break;
                }
                case EAST: {
                    boundingBox = new BoundingBox(location.getX() - (double)(this.xv / 2.0f) - (double)this.xy, location.getY() + (double)this.xA, location.getZ() - (double)(this.xw / 2.0f) + (double)f2, location.getX() + (double)(this.xv / 2.0f) - (double)this.xy, location.getY() + (double)this.xx + (double)this.xA, location.getZ() + (double)(this.xw / 2.0f) + (double)f2);
                    if (this.xw != 2.0f) break;
                    boundingBox.shift(0.0, 0.0, 0.5);
                }
            }
            if (this.xx >= 2.0f) {
                boundingBox.shift(0.0, (double)(-(this.xx / 2.0f)), 0.0);
            }
        } else if (bl) {
            switch (blockFace) {
                case NORTH: 
                case NORTH_WEST: 
                case NORTH_EAST: {
                    boundingBox = new BoundingBox(location.getX() - (double)(this.xw / 2.0f) + (double)f2, location.getY() + (double)this.xA - 0.5, location.getZ() - (double)(this.xv / 2.0f) + (double)this.xy + 0.5, location.getX() + (double)(this.xw / 2.0f) + (double)f2, location.getY() + (double)this.xx + (double)this.xA - 0.5, location.getZ() + (double)(this.xv / 2.0f) + (double)this.xy + 0.5);
                    if (this.xw != 2.0f) break;
                    boundingBox.shift(-0.5, 0.0, 0.0);
                    break;
                }
                case SOUTH: 
                case SOUTH_WEST: 
                case SOUTH_EAST: {
                    boundingBox = new BoundingBox(location.getX() - (double)(this.xw / 2.0f) - (double)f2, location.getY() + (double)this.xA - 0.5, location.getZ() - (double)(this.xv / 2.0f) - (double)this.xy - 0.5, location.getX() + (double)(this.xw / 2.0f) - (double)f2, location.getY() + (double)this.xx + (double)this.xA - 0.5, location.getZ() + (double)(this.xv / 2.0f) - (double)this.xy - 0.5);
                    if (this.xw != 2.0f) break;
                    boundingBox.shift(0.5, 0.0, 0.0);
                    break;
                }
                case WEST: {
                    boundingBox = new BoundingBox(location.getX() - (double)(this.xv / 2.0f) + (double)this.xy + 0.5, location.getY() + (double)this.xA - 0.5, location.getZ() - (double)(this.xw / 2.0f) - (double)f2, location.getX() + (double)(this.xv / 2.0f) + (double)this.xy + 0.5, location.getY() + (double)this.xx + (double)this.xA - 0.5, location.getZ() + (double)(this.xw / 2.0f) - (double)f2);
                    if (this.xw != 2.0f) break;
                    boundingBox.shift(0.0, 0.0, 0.5);
                    break;
                }
                case EAST: {
                    boundingBox = new BoundingBox(location.getX() - (double)(this.xv / 2.0f) - (double)this.xy - 0.5, location.getY() + (double)this.xA - 0.5, location.getZ() - (double)(this.xw / 2.0f) + (double)f2, location.getX() + (double)(this.xv / 2.0f) - (double)this.xy - 0.5, location.getY() + (double)this.xx + (double)this.xA - 0.5, location.getZ() + (double)(this.xw / 2.0f) + (double)f2);
                    if (this.xw != 2.0f) break;
                    boundingBox.shift(0.0, 0.0, -0.5);
                }
            }
        } else {
            switch (blockFace) {
                case NORTH: 
                case NORTH_WEST: 
                case NORTH_EAST: {
                    boundingBox = new BoundingBox(location.getX() - (double)(this.xw / 2.0f) + (double)f2, location.getY() + (double)this.xA, location.getZ() - (double)(this.xv / 2.0f) + (double)this.xy, location.getX() + (double)(this.xw / 2.0f) + (double)f2, location.getY() + (double)this.xx + (double)this.xA, location.getZ() + (double)(this.xv / 2.0f) + (double)this.xy);
                    if (this.xw != 2.0f) break;
                    boundingBox.shift(-0.5, 0.0, 0.0);
                    break;
                }
                case SOUTH: 
                case SOUTH_WEST: 
                case SOUTH_EAST: {
                    boundingBox = new BoundingBox(location.getX() - (double)(this.xw / 2.0f) - (double)f2, location.getY() + (double)this.xA, location.getZ() - (double)(this.xv / 2.0f) - (double)this.xy, location.getX() + (double)(this.xw / 2.0f) - (double)f2, location.getY() + (double)this.xx + (double)this.xA, location.getZ() + (double)(this.xv / 2.0f) - (double)this.xy);
                    if (this.xw != 2.0f) break;
                    boundingBox.shift(0.5, 0.0, 0.0);
                    break;
                }
                case WEST: {
                    boundingBox = new BoundingBox(location.getX() - (double)(this.xv / 2.0f) + (double)this.xy, location.getY() + (double)this.xA, location.getZ() - (double)(this.xw / 2.0f) - (double)f2, location.getX() + (double)(this.xv / 2.0f) + (double)this.xy, location.getY() + (double)this.xx + (double)this.xA, location.getZ() + (double)(this.xw / 2.0f) - (double)f2);
                    if (this.xw != 2.0f) break;
                    boundingBox.shift(0.0, 0.0, 0.5);
                    break;
                }
                case EAST: {
                    boundingBox = new BoundingBox(location.getX() - (double)(this.xv / 2.0f) - (double)this.xy, location.getY() + (double)this.xA, location.getZ() - (double)(this.xw / 2.0f) + (double)f2, location.getX() + (double)(this.xv / 2.0f) - (double)this.xy, location.getY() + (double)this.xx + (double)this.xA, location.getZ() + (double)(this.xw / 2.0f) + (double)f2);
                    if (this.xw != 2.0f) break;
                    boundingBox.shift(0.0, 0.0, -0.5);
                }
            }
        }
        if (boundingBox != null) {
            afz.a((Entity)itemDisplay, boundingBox);
        }
    }

    private void z(Entity entity) {
        ItemFrame itemFrame = (ItemFrame)entity;
        Location location = entity.getLocation();
        BlockFace blockFace = bcc.a(location.getDirection());
        BlockFace blockFace2 = bcc.a(itemFrame.getRotation());
        BoundingBox boundingBox = null;
        switch (blockFace) {
            case DOWN: {
                switch (blockFace2) {
                    case NORTH: 
                    case NORTH_WEST: 
                    case NORTH_EAST: {
                        boundingBox = afz.a(entity, location.getX() - (double)(this.xw / 2.0f), location.getX() + (double)(this.xw / 2.0f), location.getY(), location.getY() - (double)this.xx, location.getZ() - (double)(this.xv / 2.0f), location.getZ() + (double)(this.xv / 2.0f)).shift((double)this.xz, (double)this.xA, (double)this.xy);
                        break;
                    }
                    case EAST: {
                        boundingBox = afz.a(entity, location.getX() - (double)(this.xv / 2.0f), location.getX() + (double)(this.xv / 2.0f), location.getY(), location.getY() - (double)this.xx, location.getZ() - (double)(this.xw / 2.0f), location.getZ() + (double)(this.xw / 2.0f)).shift((double)this.xy, (double)this.xA, (double)(-this.xz));
                        break;
                    }
                    case WEST: {
                        boundingBox = afz.a(entity, location.getX() - (double)(this.xv / 2.0f), location.getX() + (double)(this.xv / 2.0f), location.getY(), location.getY() - (double)this.xx, location.getZ() - (double)(this.xw / 2.0f), location.getZ() + (double)(this.xw / 2.0f)).shift((double)(-this.xy), (double)this.xA, (double)this.xz);
                        break;
                    }
                    case SOUTH: 
                    case SOUTH_WEST: 
                    case SOUTH_EAST: {
                        boundingBox = afz.a(entity, location.getX() - (double)(this.xw / 2.0f), location.getX() + (double)(this.xw / 2.0f), location.getY(), location.getY() - (double)this.xx, location.getZ() - (double)(this.xv / 2.0f), location.getZ() + (double)(this.xv / 2.0f)).shift((double)(-this.xz), (double)this.xA, (double)(-this.xy));
                    }
                }
                break;
            }
            case UP: {
                switch (blockFace2) {
                    case NORTH: 
                    case NORTH_WEST: 
                    case NORTH_EAST: {
                        boundingBox = afz.a(entity, location.getX() + (double)(this.xw / 2.0f), location.getX() - (double)(this.xw / 2.0f), location.getY(), location.getY() + (double)this.xx, location.getZ() - (double)(this.xv / 2.0f), location.getZ() + (double)(this.xv / 2.0f)).shift((double)this.xz, (double)this.xA, (double)(-this.xy));
                        break;
                    }
                    case EAST: {
                        boundingBox = afz.a(entity, location.getX() + (double)(this.xv / 2.0f), location.getX() - (double)(this.xv / 2.0f), location.getY(), location.getY() + (double)this.xx, location.getZ() - (double)(this.xw / 2.0f), location.getZ() + (double)(this.xw / 2.0f)).shift((double)this.xy, (double)this.xA, (double)this.xz);
                        break;
                    }
                    case WEST: {
                        boundingBox = afz.a(entity, location.getX() + (double)(this.xv / 2.0f), location.getX() - (double)(this.xv / 2.0f), location.getY(), location.getY() + (double)this.xx, location.getZ() - (double)(this.xw / 2.0f), location.getZ() + (double)(this.xw / 2.0f)).shift((double)(-this.xy), (double)this.xA, (double)(-this.xz));
                        break;
                    }
                    case SOUTH: 
                    case SOUTH_WEST: 
                    case SOUTH_EAST: {
                        boundingBox = afz.a(entity, location.getX() + (double)(this.xw / 2.0f), location.getX() - (double)(this.xw / 2.0f), location.getY(), location.getY() + (double)this.xx, location.getZ() - (double)(this.xv / 2.0f), location.getZ() + (double)(this.xv / 2.0f)).shift((double)(-this.xz), (double)this.xA, (double)this.xy);
                    }
                }
                break;
            }
            case NORTH: {
                boundingBox = afz.a(entity, location.getX() - (double)(this.xw / 2.0f), location.getX() + (double)(this.xw / 2.0f), location.getY() - (double)(this.xv / 2.0f), location.getY() + (double)(this.xv / 2.0f), location.getZ(), location.getZ() - (double)this.xx).shift((double)this.xz, (double)this.xA, (double)this.xy);
                break;
            }
            case SOUTH: {
                boundingBox = afz.a(entity, location.getX() - (double)(this.xw / 2.0f), location.getX() + (double)(this.xw / 2.0f), location.getY() - (double)(this.xv / 2.0f), location.getY() + (double)(this.xv / 2.0f), location.getZ(), location.getZ() + (double)this.xx).shift((double)(-this.xz), (double)this.xA, (double)this.xy);
                break;
            }
            case WEST: {
                boundingBox = afz.a(entity, location.getX(), location.getX() - (double)this.xx, location.getY() - (double)(this.xv / 2.0f), location.getY() + (double)(this.xv / 2.0f), location.getZ() - (double)(this.xw / 2.0f), location.getZ() + (double)(this.xw / 2.0f)).shift((double)this.xy, (double)this.xA, (double)(-this.xz));
                break;
            }
            case EAST: {
                boundingBox = afz.a(entity, location.getX(), location.getX() + (double)this.xx, location.getY() - (double)(this.xv / 2.0f), location.getY() + (double)(this.xv / 2.0f), location.getZ() - (double)(this.xw / 2.0f), location.getZ() + (double)(this.xw / 2.0f)).shift((double)(-this.xy), (double)this.xA, (double)this.xz);
            }
        }
        if (boundingBox != null) {
            afz.a(entity, boundingBox);
        }
    }

    public static jv A(Entity entity) {
        if (!afz.i(entity.getType())) {
            return jv.FLOOR;
        }
        BlockFace blockFace = bcc.a(entity.getLocation().getDirection());
        switch (blockFace) {
            case DOWN: {
                return jv.CEILING;
            }
            case UP: {
                return jv.FLOOR;
            }
        }
        return jv.WALL;
    }

    public static void a(World world, double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8;
        double d9;
        double d10 = 0.2;
        for (d9 = d2; d9 <= d3; d9 += d10) {
            for (d8 = d4; d8 <= d5; d8 += d10) {
                world.spawnParticle(Particle.DUST, d9, d8, d6, 0, 0.0, 0.0, 0.0, 1.0, (Object)new Particle.DustOptions(Color.ORANGE, 0.5f));
                world.spawnParticle(Particle.DUST, d9, d8, d7, 0, 0.0, 0.0, 0.0, 1.0, (Object)new Particle.DustOptions(Color.ORANGE, 0.5f));
            }
            for (d8 = d6; d8 <= d7; d8 += d10) {
                world.spawnParticle(Particle.DUST, d9, d4, d8, 0, 0.0, 0.0, 0.0, 1.0, (Object)new Particle.DustOptions(Color.ORANGE, 0.5f));
                world.spawnParticle(Particle.DUST, d9, d5, d8, 0, 0.0, 0.0, 0.0, 1.0, (Object)new Particle.DustOptions(Color.ORANGE, 0.5f));
            }
        }
        for (d9 = d4; d9 <= d5; d9 += d10) {
            for (d8 = d6; d8 <= d7; d8 += d10) {
                world.spawnParticle(Particle.DUST, d2, d9, d8, 0, 0.0, 0.0, 0.0, 1.0, (Object)new Particle.DustOptions(Color.ORANGE, 0.5f));
                world.spawnParticle(Particle.DUST, d3, d9, d8, 0, 0.0, 0.0, 0.0, 1.0, (Object)new Particle.DustOptions(Color.ORANGE, 0.5f));
            }
        }
    }

    public static List b(World world, double d2, double d3, double d4, double d5, double d6, double d7) {
        HashSet<Location> hashSet = new HashSet<Location>();
        for (double d8 = d2; d8 <= d3; d8 += 1.0) {
            for (double d9 = d4; d9 <= d5; d9 += 1.0) {
                for (double d10 = d6; d10 <= d7; d10 += 1.0) {
                    hashSet.add(new Location(world, d8, d9, d10));
                }
            }
        }
        return new ArrayList(hashSet);
    }

    public void b(float f2, float f3) {
        this.ys = f2;
        this.yt = f3;
    }

    @Generated
    public void ab(boolean bl) {
        this.yr = bl;
    }

    @Generated
    public boolean kN() {
        return this.yr;
    }

    private /* synthetic */ void d(Entity entity, Player player) {
        this.a(entity, player);
    }

    private /* synthetic */ void a(ItemStack itemStack, Transformation transformation, boolean bl, Consumer consumer, ItemDisplay itemDisplay) {
        itemDisplay.setInvulnerable(false);
        itemDisplay.setSilent(true);
        itemDisplay.setGravity(this.kG());
        itemDisplay.setDisplayWidth(this.ys);
        itemDisplay.setDisplayHeight(this.yt);
        ItemStack itemStack2 = this.zk.getType() == itemStack.getType() ? itemStack.clone() : this.zk.mP();
        itemStack2.setAmount(1);
        itemDisplay.setItemStack(itemStack2);
        if (transformation != null) {
            itemDisplay.setTransformation(transformation);
        }
        if (this.ym != null) {
            itemDisplay.setItemDisplayTransform(this.ym);
        }
        if (bl) {
            itemDisplay.getPersistentDataContainer().set(yf, PersistentDataType.BOOLEAN, (Object)true);
        }
        consumer.accept(itemDisplay);
    }
}
