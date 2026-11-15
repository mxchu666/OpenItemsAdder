package itemsadder.m;

import dev.lone.itemsadder.api.Events.ComplexFurnitureBreakEvent;
import dev.lone.itemsadder.s;
import itemsadder.m.ae;
import itemsadder.m.bas;
import itemsadder.m.bay;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcj;
import itemsadder.m.bdf;
import itemsadder.m.bev;
import itemsadder.m.bfb;
import itemsadder.m.d;
import itemsadder.m.da;
import itemsadder.m.dn;
import itemsadder.m.jj;
import itemsadder.m.jp;
import itemsadder.m.js;
import itemsadder.m.ki;
import itemsadder.m.qm;
import itemsadder.m.rf;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.WeakHashMap;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.jetbrains.annotations.Nullable;

public class jn
extends ki {
    public static final String xF = "complex_furniture";
    public static final NamespacedKey xG = new NamespacedKey("itemsadder", "complex_furniture");
    public static WeakHashMap xH = new WeakHashMap();
    public String gL;
    public boolean mF;
    public Integer gN;
    @Nullable
    public final Integer xI;
    @Nullable
    public final Boolean xJ;
    @Nullable
    public final Boolean xK;
    @Nullable
    public final Boolean xL;
    @Nullable
    public final Boolean xM;
    @Nullable
    public final Boolean xN;
    public final double xO;
    public final double xP;
    public final double xQ;
    @Nullable
    public final String xR;
    public rf xS;

    public static jn c(qm qm2) {
        return (jn)qm2.Ge.bn(xF);
    }

    public jn(qm qm2, String object, @Nullable Boolean bl, @Nullable Integer n, @Nullable Integer n2, @Nullable Boolean bl2, @Nullable Boolean bl3, @Nullable Boolean bl4, @Nullable Boolean bl5, @Nullable Boolean bl6, @Nullable String string, @Nullable rf rf2, double d2, double d3, double d4) {
        super(qm2);
        this.mF = bl != null && bl != false;
        this.gN = n;
        this.xI = n2;
        this.xJ = bl2;
        this.xK = bl3;
        this.xL = bl4;
        this.xM = bl5;
        this.xN = bl6;
        this.xR = string;
        this.xS = rf2;
        this.xO = d2;
        this.xP = d3;
        this.xQ = d4;
        if (!((String)object).contains(":")) {
            object = qm2.getNamespace() + ":" + (String)object;
        }
        if (!da.db().lJ.containsKey(object)) {
            throw new IllegalArgumentException("Invalid custom entity id: " + (String)object);
        }
        this.gL = object;
    }

    @Nullable
    public void a(@Nullable Player player, qm qm2, @Nullable ItemStack itemStack, Location location, @Nullable BlockFace blockFace) {
        this.a(player, qm2, itemStack, location, blockFace, false);
    }

    /*
     * Exception decompiling
     */
    @Nullable
    public jp a(@Nullable Player var1_1, qm var2_2, @Nullable ItemStack var3_3, Location var4_4, @Nullable BlockFace var5_5, boolean var6_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 20[FORLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at software.coley.recaf.services.decompile.cfr.CfrDecompiler.decompileInternal(CfrDecompiler.java:61)
         *     at software.coley.recaf.services.decompile.AbstractJvmDecompiler.decompile(AbstractJvmDecompiler.java:49)
         *     at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
         *     at java.base/java.lang.reflect.Method.invoke(Method.java:580)
         *     at org.jboss.weld.bean.proxy.AbstractBeanInstance.invoke(AbstractBeanInstance.java:39)
         *     at org.jboss.weld.bean.proxy.ProxyMethodHandler.invoke(ProxyMethodHandler.java:109)
         *     at software.coley.recaf.services.decompile.Decompiler$JvmDecompiler$1269202896$Proxy$_$$_WeldClientProxy.decompile(Unknown Source)
         *     at software.coley.recaf.services.decompile.DecompilerManager.lambda$decompile$2(DecompilerManager.java:156)
         *     at java.base/java.util.concurrent.CompletableFuture$AsyncSupply.run(CompletableFuture.java:1768)
         *     at software.coley.recaf.util.threading.ThreadUtil.lambda$wrap$2(ThreadUtil.java:250)
         *     at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
         *     at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
         *     at java.base/java.lang.Thread.run(Thread.java:1570)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static void a(jp jp2) {
        LivingEntity livingEntity = jp2.xV.eg();
        assert (livingEntity != null);
        BoundingBox boundingBox = livingEntity.getBoundingBox();
        jn.a(livingEntity.getWorld(), boundingBox, false).forEach(location -> {
            Block block = location.getBlock();
            if (block.getType() == Material.BARRIER) {
                block.setType(Material.AIR);
            }
            bay.bk(block);
        });
    }

    public static void b(jp jp2) {
        LivingEntity livingEntity = jp2.xV.eg();
        assert (livingEntity != null);
        BoundingBox boundingBox = livingEntity.getBoundingBox();
        jn.a(livingEntity.getWorld(), boundingBox, false).forEach(location -> {
            Block block = location.getBlock();
            if (jp2.xX.xI != null && jp2.xX.xI > 0) {
                bay.d(block, jp2.xX.xI);
            }
            if (jp2.xX.xJ != null && jp2.xX.xJ.booleanValue() && !block.getType().isSolid()) {
                block.setType(Material.BARRIER);
            }
        });
    }

    public static void a(Player player, jp jp2) {
        if (!s.f((HumanEntity)player, jp2.xX.xR)) {
            return;
        }
        if (!bcc.f((Entity)player, (Entity)jp2.kD().eg())) {
            return;
        }
        LivingEntity livingEntity = jp2.xV.eg();
        assert (livingEntity != null);
        boolean bl = false;
        jn jn2 = jn.c(jp2.xW);
        if (jn2.xK != null && jn2.xK.booleanValue() && player.getGameMode() != GameMode.CREATIVE) {
            bl = true;
        }
        ComplexFurnitureBreakEvent complexFurnitureBreakEvent = new ComplexFurnitureBreakEvent(player, livingEntity, jp2.kD(), bl);
        bev.b(complexFurnitureBreakEvent);
        if (complexFurnitureBreakEvent.isCancelled()) {
            return;
        }
        BoundingBox boundingBox = livingEntity.getBoundingBox();
        jn.a(player.getWorld(), boundingBox, false).forEach(location -> {
            Block block = location.getBlock();
            if (bcc.a(block, player)) {
                if (block.getType() == Material.BARRIER) {
                    block.setType(Material.AIR);
                }
                bay.bk(block);
            }
        });
        da.db().a(jp2.xV, true, false);
        if (complexFurnitureBreakEvent.isDropItem()) {
            bdf.a(livingEntity.getLocation(), jp2.xW.mP(), player);
        }
        js.a(boundingBox, player, true);
        jn.b(player, jp2);
        jn2.xS.O(livingEntity.getLocation());
    }

    private static void b(Player player, jp jp2) {
        bfb bfb2 = new bfb((Entity)player, (Entity)jp2.xV.eg(), EntityDamageEvent.DamageCause.ENTITY_ATTACK, 0.0);
        jp2.xW.a((LivingEntity)player, jj.PLACED_FURNITURE_BREAK, (Object ou2) -> {
            ItemStack itemStack = jp2.xW.mP();
            return ou2.a(bfb2, jp2.xW, itemStack);
        });
    }

    public static List a(World world, BoundingBox boundingBox, boolean bl) {
        HashSet<Location> hashSet = new HashSet<Location>();
        int n = (int)Math.floor(boundingBox.getMinX());
        int n2 = (int)Math.floor(boundingBox.getMaxX());
        int n3 = (int)Math.floor(boundingBox.getMinY());
        int n4 = (int)Math.floor(boundingBox.getMaxY());
        int n5 = (int)Math.floor(boundingBox.getMinZ());
        int n6 = (int)Math.floor(boundingBox.getMaxZ());
        for (int i = n; i <= n2; ++i) {
            for (int j = n3; j <= n4; ++j) {
                for (int k = n5; k <= n6; ++k) {
                    if (!bcc.h(world, i >> 4, k >> 4)) continue;
                    if (!bl) {
                        hashSet.add(new Location(world, (double)i, (double)j, (double)k));
                        continue;
                    }
                    Block block = world.getBlockAt(i, j, k);
                    BoundingBox boundingBox2 = BoundingBox.of((Block)block);
                    if (!boundingBox2.overlaps(boundingBox)) continue;
                    BoundingBox boundingBox3 = boundingBox2.clone().intersection(boundingBox);
                    double d2 = boundingBox3.getWidthX() * boundingBox3.getHeight() * boundingBox3.getWidthZ();
                    double d3 = 1.0;
                    bce.iA(d2 / d3 + " " + String.valueOf(block.getType()) + " " + bcc.ae(block.getLocation()));
                    if (!(d2 / d3 >= 0.3)) continue;
                    hashSet.add(block.getLocation());
                }
            }
        }
        return new ArrayList(hashSet);
    }

    @Nullable
    public static jp aq(Player player) {
        if (!ae.dL) {
            return null;
        }
        RayTraceResult rayTraceResult = player.getWorld().rayTraceEntities(player.getEyeLocation(), player.getEyeLocation().getDirection(), 5.0, 0.1, entity -> entity.getEntityId() != player.getEntityId() && bcj.d((PersistentDataHolder)entity, xG) != null && da.db().d(entity.getUniqueId()));
        if (rayTraceResult != null && rayTraceResult.getHitEntity() != null) {
            Entity entity2 = rayTraceResult.getHitEntity();
            dn dn2 = da.db().e(entity2.getUniqueId());
            if (dn2 == null) {
                return null;
            }
            String string = bcj.d((PersistentDataHolder)entity2, xG);
            qm qm2 = d.g().e(string);
            if (qm2 == null) {
                bce.warn("Unknown custom item: " + string + ". Probably was removed from config or was disabled.");
                da.db().a(dn2, true, false);
                return null;
            }
            if (bas.a(xH, player).g(() -> bce.g((CommandSender)player, "interact-too-fast"))) {
                return null;
            }
            return new jp(dn2, qm2, jn.c(qm2));
        }
        return null;
    }

    @Nullable
    public static jp g(LivingEntity livingEntity) {
        if (!ae.dL) {
            return null;
        }
        dn dn2 = da.db().e(livingEntity.getUniqueId());
        if (dn2 == null) {
            return null;
        }
        String string = bcj.d((PersistentDataHolder)livingEntity, xG);
        if (string == null) {
            return null;
        }
        qm qm2 = d.g().e(string);
        if (qm2 == null) {
            bce.warn("Unknown custom item: " + string + ". Probably was removed from config or was disabled.");
            da.db().a(dn2, true, false);
            return null;
        }
        return new jp(dn2, qm2, jn.c(qm2));
    }

    private /* synthetic */ void a(Player player, boolean bl, Location location) {
        Block block = location.getBlock();
        if (player == null || bcc.b(block, player)) {
            if (this.xI != null && this.xI > 0) {
                bay.d(block, this.xI);
            }
            if (!bl && this.xJ != null && this.xJ.booleanValue() && !block.getType().isSolid()) {
                block.setType(Material.BARRIER);
            }
        }
    }

    private /* synthetic */ void a(qm qm2, Player player, ItemStack itemStack, LivingEntity livingEntity) {
        livingEntity.setInvulnerable(true);
        livingEntity.setAI(false);
        livingEntity.setRemoveWhenFarAway(false);
        if (this.xJ != null && this.xJ.booleanValue() || this.xI != null && this.xI > 0) {
            livingEntity.setGravity(false);
        }
        livingEntity.getPersistentDataContainer().set(xG, PersistentDataType.STRING, (Object)qm2.getNamespacedID());
        if (player != null && player.getGameMode() != GameMode.CREATIVE) {
            bbs.aj(itemStack);
        }
    }

    private static /* synthetic */ boolean u(Entity entity) {
        return da.db().f(entity);
    }

    static {
        bas.a(xH);
    }
}
