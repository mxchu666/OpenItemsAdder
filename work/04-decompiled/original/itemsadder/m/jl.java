package itemsadder.m;

import itemsadder.m.aaf;
import itemsadder.m.afz;
import itemsadder.m.bcc;
import itemsadder.m.bci;
import itemsadder.m.bcp;
import itemsadder.m.bfo;
import itemsadder.m.bfp;
import itemsadder.m.d;
import itemsadder.m.js;
import itemsadder.m.ki;
import itemsadder.m.qm;
import itemsadder.m.rf;
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

public abstract class jl
extends ki {
    public static final NamespacedKey xp = new NamespacedKey("itemsadder", "placeable_entity_item");
    public static final NamespacedKey xq = new NamespacedKey("itemsadder", "placeable_behaviour_type");
    public final EntityType xr;
    boolean xs = true;
    boolean xt = false;
    public rf xu;
    public float xv = 1.0f;
    public float xw = 1.0f;
    public float xx = 1.0f;
    public float xy;
    public float xz;
    public float xA;
    protected boolean xB;
    protected boolean xC;
    protected boolean xD;

    public jl(qm qm2, EntityType entityType, boolean bl, boolean bl2) {
        super(qm2);
        this.xr = entityType;
        this.xs = bl;
        this.xt = bl2;
        this.xu = new rf();
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

    public void a(Entity entity, qm qm2) {
        entity.getPersistentDataContainer().set(xp, PersistentDataType.STRING, (Object)qm2.getNamespacedID());
    }

    public static boolean m(Entity entity) {
        return entity instanceof ArmorStand || entity instanceof ItemFrame || entity instanceof ItemDisplay;
    }

    public static boolean n(Entity entity) {
        if (!jl.m(entity)) {
            return false;
        }
        return entity.getPersistentDataContainer().has(xp, PersistentDataType.STRING);
    }

    @Nullable
    public static jl c(Entity entity, String string) {
        qm qm2 = d.g().e((String)entity.getPersistentDataContainer().get(xp, PersistentDataType.STRING));
        if (qm2 == null) {
            return null;
        }
        return (jl)qm2.Ge.bn(string);
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
    public static qm p(Entity entity) {
        ItemStack itemStack = jl.o(entity);
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return null;
        }
        return qm2;
    }

    @Nullable
    public static Entity ao(Player player) {
        @Nullable bci bci2 = jl.ap(player);
        if (bci2 == null) {
            return null;
        }
        return (Entity)bci2.aAX;
    }

    @Nullable
    public static bci ap(Player player) {
        bfo bfo2 = bfo.a(player, 5.0, 0.02);
        if (bfo2.a(bfp.ENTITY)) {
            Entity entity;
            if (bfo2.EE()) {
                entity = bfo2.ED();
                if (!jl.n(entity)) {
                    return null;
                }
                bfo bfo3 = new bfo(player, 5.0);
                if (bfo3.a(bfp.BLOCK) && bfo3.EG()) {
                    Block block = bfo3.EF();
                    if (block.getType() != Material.BARRIER) {
                        Location location = player.getEyeLocation();
                        if (bfo3.EH().distance(location) < bfo2.EH().distance(location) && !block.getBoundingBox().contains(entity.getBoundingBox())) {
                            return null;
                        }
                    }
                    bcp.a(() -> js.x(entity), 2L, entity.getType() != EntityType.ARMOR_STAND);
                    if (block.getType() == Material.BARRIER && !entity.getBoundingBox().contains(block.getBoundingBox().expand(-0.5))) {
                        return null;
                    }
                }
            } else {
                return null;
            }
            return new bci(entity, bfo2.EH());
        }
        return null;
    }

    public void q(Entity entity) {
        afz.a(entity, this.xv, this.xx, this.xw);
    }

    public void r(Entity entity) {
        this.a(entity, (Player)null);
    }

    public void a(Entity entity, @Nullable Player player) {
        BoundingBox boundingBox = entity.getBoundingBox().expand(-0.5);
        List list = js.b(entity.getWorld(), boundingBox.getMinX(), boundingBox.getMaxX(), boundingBox.getMinY(), boundingBox.getMaxY(), boundingBox.getMinZ(), boundingBox.getMaxZ());
        if (list.size() > 15) {
            AtomicInteger atomicInteger = new AtomicInteger();
            bcp.c(bukkitRunnable -> {
                try {
                    int n;
                    for (n = atomicInteger.get(); n < atomicInteger.get() + 5; ++n) {
                        Block block = ((Location)list.get(n)).getBlock();
                        if (!bcc.br(block) || !aaf.aJ(block) || player != null && !bcc.b(block, player)) continue;
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
                if (!bcc.br(block) || !aaf.aJ(block) || player != null && !bcc.b(block, player)) continue;
                block.setType(Material.BARRIER, false);
            }
        }
    }

    public void s(Entity entity) {
        jl.b(entity, null);
    }

    public static void b(Entity entity, @Nullable Player player) {
        BoundingBox boundingBox = entity.getBoundingBox().expand(-0.5);
        List list = js.b(entity.getWorld(), boundingBox.getMinX(), boundingBox.getMaxX(), boundingBox.getMinY(), boundingBox.getMaxY(), boundingBox.getMinZ(), boundingBox.getMaxZ());
        if (list.size() > 15) {
            AtomicInteger atomicInteger = new AtomicInteger();
            bcp.c(bukkitRunnable -> {
                try {
                    int n;
                    for (n = atomicInteger.get(); n < atomicInteger.get() + 5; ++n) {
                        Block block = ((Location)list.get(n)).getBlock();
                        if (block.getType() != Material.BARRIER || player != null && !bcc.b(block, player)) continue;
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
                if (block.getType() != Material.BARRIER || player != null && !bcc.b(block, player)) continue;
                block.setType(Material.AIR, false);
            }
        }
    }
}
