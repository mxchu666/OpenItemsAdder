package itemsadder.m;

import itemsadder.m.BlockRegistry;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.EntityAndBlockEnum;
import itemsadder.m.EntityHolder;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationHolder_3;
import itemsadder.m.NamespacedKeyItemDisplayHolder;
import itemsadder.m.Opaque021;
import itemsadder.m.Opaque126;
import itemsadder.m.PlayerLocationHolder_2;
import java.lang.runtime.SwitchBootstraps;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.BoundingBox;
import org.jetbrains.annotations.Nullable;

public abstract class NamespacedKeyEntityTypeHolder
extends Opaque126 {
    public static final NamespacedKey xp = new NamespacedKey("itemsadder", "placeable_entity_item");
    public static final NamespacedKey xq = new NamespacedKey("itemsadder", "placeable_behaviour_type");
    public final EntityType xr;
    boolean xs = true;
    boolean xt = false;
    public LocationHolder_3 xu;
    public float xv = 1.0f;
    public float xw = 1.0f;
    public float xx = 1.0f;
    public float xy;
    public float xz;
    public float xA;
    protected boolean xB;
    protected boolean xC;
    protected boolean xD;

    public NamespacedKeyEntityTypeHolder(ItemStackBuilder_4 itemStackBuilder_4, EntityType entityType, boolean bl, boolean bl2) {
        super(itemStackBuilder_4);
        this.xr = entityType;
        this.xs = bl;
        this.xt = bl2;
        this.xu = new LocationHolder_3();
    }

    public boolean kB() {
        return this.xs;
    }

    public boolean kC() {
        return this.xt;
    }

    public void a(float f, float f2, float f3) {
        this.xv = f;
        this.xw = f2;
        this.xx = f3;
    }

    public void b(float f, float f2, float f3) {
        this.xy = f;
        this.xz = f2;
        this.xA = f3;
    }

    public void d(boolean bl, boolean bl2, boolean bl3) {
        this.xB = bl;
        this.xC = bl2;
        this.xD = bl3;
    }

    public void a(Entity entity, ItemStackBuilder_4 itemStackBuilder_4) {
        entity.getPersistentDataContainer().set(xp, PersistentDataType.STRING, (Object)itemStackBuilder_4.getNamespacedID());
    }

    public static boolean m(Entity entity) {
        return entity instanceof ArmorStand || entity instanceof ItemFrame || entity instanceof ItemDisplay;
    }

    public static boolean n(Entity entity) {
        if (!NamespacedKeyEntityTypeHolder.m(entity)) {
            return false;
        }
        return entity.getPersistentDataContainer().has(xp, PersistentDataType.STRING);
    }

    @Nullable
    public static NamespacedKeyEntityTypeHolder c(Entity entity, String string) {
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e((String)entity.getPersistentDataContainer().get(xp, PersistentDataType.STRING));
        if (itemStackBuilder_4 == null) {
            return null;
        }
        return (NamespacedKeyEntityTypeHolder)itemStackBuilder_4.Ge.bn(string);
    }

    public static ItemStack o(Entity entity) {
        Entity entity2 = entity;
        int n = 0;
        return switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{ArmorStand.class, ItemFrame.class, ItemDisplay.class}, (Object)entity2, n)) {
            case 0 -> {
                ArmorStand var3_3 = (ArmorStand)entity2;
                yield var3_3.getHelmet();
            }
            case 1 -> {
                ItemFrame var4_4 = (ItemFrame)entity2;
                yield var4_4.getItem();
            }
            case 2 -> {
                ItemDisplay var5_5 = (ItemDisplay)entity2;
                yield var5_5.getItemStack();
            }
            case -1 -> throw new RuntimeException("Failed to get ItemStack. Null entity.");
            default -> throw new RuntimeException("Failed to get ItemStack. Entity '" + String.valueOf(entity.getType()) + "' can't be a furniture!");
        };
    }

    @Nullable
    public static ItemStackBuilder_4 p(Entity entity) {
        ItemStack itemStack = NamespacedKeyEntityTypeHolder.o(entity);
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 == null) {
            return null;
        }
        return itemStackBuilder_4;
    }

    @Nullable
    public static Entity ao(Player player) {
        @Nullable Opaque021 opaque021 = NamespacedKeyEntityTypeHolder.ap(player);
        if (opaque021 == null) {
            return null;
        }
        return (Entity)opaque021.aAX;
    }

    @Nullable
    public static Opaque021 ap(Player player) {
        PlayerLocationHolder_2 playerLocationHolder_2 = PlayerLocationHolder_2.a(player, 5.0, 0.02);
        if (playerLocationHolder_2.a(EntityAndBlockEnum.ENTITY)) {
            Entity entity;
            if (playerLocationHolder_2.EE()) {
                entity = playerLocationHolder_2.ED();
                if (!NamespacedKeyEntityTypeHolder.n(entity)) {
                    return null;
                }
                PlayerLocationHolder_2 playerLocationHolder_22 = new PlayerLocationHolder_2(player, 5.0);
                if (playerLocationHolder_22.a(EntityAndBlockEnum.BLOCK) && playerLocationHolder_22.EG()) {
                    Block block = playerLocationHolder_22.EF();
                    if (block.getType() != Material.BARRIER) {
                        Location location = player.getEyeLocation();
                        if (playerLocationHolder_22.EH().distance(location) < playerLocationHolder_2.EH().distance(location) && !block.getBoundingBox().contains(entity.getBoundingBox())) {
                            return null;
                        }
                    }
                    BukkitTaskBridge.a(() -> NamespacedKeyItemDisplayHolder.x(entity), 2L, entity.getType() != EntityType.ARMOR_STAND);
                    if (block.getType() == Material.BARRIER && !entity.getBoundingBox().contains(block.getBoundingBox().expand(-0.5))) {
                        return null;
                    }
                }
            } else {
                return null;
            }
            return new Opaque021(entity, playerLocationHolder_2.EH());
        }
        return null;
    }

    public void q(Entity entity) {
        EntityHolder.a(entity, this.xv, this.xx, this.xw);
    }

    public void r(Entity entity) {
        this.a(entity, (Player)null);
    }

    public void a(Entity entity, @Nullable Player player) {
        BoundingBox boundingBox = entity.getBoundingBox().expand(-0.5);
        List list = NamespacedKeyItemDisplayHolder.b(entity.getWorld(), boundingBox.getMinX(), boundingBox.getMaxX(), boundingBox.getMinY(), boundingBox.getMaxY(), boundingBox.getMinZ(), boundingBox.getMaxZ());
        if (list.size() > 15) {
            AtomicInteger atomicInteger = new AtomicInteger();
            BukkitTaskBridge.c(bukkitRunnable -> {
                try {
                    int n;
                    for (n = atomicInteger.get(); n < atomicInteger.get() + 5; ++n) {
                        Block block = ((Location)list.get(n)).getBlock();
                        if (!LocationBridge_2.br(block) || !BlockRegistry.aJ(block) || player != null && !LocationBridge_2.b(block, player)) continue;
                        block.setType(Material.BARRIER, false);
                    }
                    atomicInteger.set(n);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    bukkitRunnable.cancel();
                }
            }, 0L, 1L);
        } else {
            for (Location location : list) {
                Block block = location.getBlock();
                if (!LocationBridge_2.br(block) || !BlockRegistry.aJ(block) || player != null && !LocationBridge_2.b(block, player)) continue;
                block.setType(Material.BARRIER, false);
            }
        }
    }

    public void s(Entity entity) {
        NamespacedKeyEntityTypeHolder.b(entity, null);
    }

    public static void b(Entity entity, @Nullable Player player) {
        BoundingBox boundingBox = entity.getBoundingBox().expand(-0.5);
        List list = NamespacedKeyItemDisplayHolder.b(entity.getWorld(), boundingBox.getMinX(), boundingBox.getMaxX(), boundingBox.getMinY(), boundingBox.getMaxY(), boundingBox.getMinZ(), boundingBox.getMaxZ());
        if (list.size() > 15) {
            AtomicInteger atomicInteger = new AtomicInteger();
            BukkitTaskBridge.c(bukkitRunnable -> {
                try {
                    int n;
                    for (n = atomicInteger.get(); n < atomicInteger.get() + 5; ++n) {
                        Block block = ((Location)list.get(n)).getBlock();
                        if (block.getType() != Material.BARRIER || player != null && !LocationBridge_2.b(block, player)) continue;
                        block.setType(Material.AIR, false);
                    }
                    atomicInteger.set(n);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    bukkitRunnable.cancel();
                }
            }, 0L, 1L);
        } else {
            for (Location location : list) {
                Block block = location.getBlock();
                if (block.getType() != Material.BARRIER || player != null && !LocationBridge_2.b(block, player)) continue;
                block.setType(Material.AIR, false);
            }
        }
    }
}
