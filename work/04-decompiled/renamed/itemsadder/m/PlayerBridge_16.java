package itemsadder.m;

import dev.lone.itemsadder.api.Events.ComplexFurnitureBreakEvent;
import dev.lone.itemsadder.s;
import itemsadder.m.BlockBreakEnum;
import itemsadder.m.BlockBridge_2;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EntityBridge_2;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.LocationHolder_3;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.NamespacedKeyBridge;
import itemsadder.m.NamespacedKeyItemDisplayHolder;
import itemsadder.m.Opaque126;
import itemsadder.m.PlayerBuilder;
import itemsadder.m.RecordOfValue_20;
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

public class PlayerBridge_16
extends Opaque126 {
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
    public LocationHolder_3 xS;

    public static PlayerBridge_16 c(ItemStackBuilder_4 itemStackBuilder_4) {
        return (PlayerBridge_16)itemStackBuilder_4.Ge.bn(xF);
    }

    public PlayerBridge_16(ItemStackBuilder_4 itemStackBuilder_4, String object, @Nullable Boolean bl, @Nullable Integer n, @Nullable Integer n2, @Nullable Boolean bl2, @Nullable Boolean bl3, @Nullable Boolean bl4, @Nullable Boolean bl5, @Nullable Boolean bl6, @Nullable String string, @Nullable LocationHolder_3 locationHolder_3, double d, double d2, double d3) {
        super(itemStackBuilder_4);
        this.mF = bl != null && bl != false;
        this.gN = n;
        this.xI = n2;
        this.xJ = bl2;
        this.xK = bl3;
        this.xL = bl4;
        this.xM = bl5;
        this.xN = bl6;
        this.xR = string;
        this.xS = locationHolder_3;
        this.xO = d;
        this.xP = d2;
        this.xQ = d3;
        if (!((String)object).contains(":")) {
            object = itemStackBuilder_4.getNamespace() + ":" + (String)object;
        }
        if (!LivingEntityRegistry.db().lJ.containsKey(object)) {
            throw new IllegalArgumentException("Invalid custom entity id: " + (String)object);
        }
        this.gL = object;
    }

    @Nullable
    public void a(@Nullable Player player, ItemStackBuilder_4 itemStackBuilder_4, @Nullable ItemStack itemStack, Location location, @Nullable BlockFace blockFace) {
        this.a(player, itemStackBuilder_4, itemStack, location, blockFace, false);
    }

    /*
     * Exception decompiling
     */
    @Nullable
    public RecordOfValue_20 a(@Nullable Player var1_1, ItemStackBuilder_4 var2_2, @Nullable ItemStack var3_3, Location var4_4, @Nullable BlockFace var5_5, boolean var6_6) {
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

    public static void a(RecordOfValue_20 recordOfValue_20) {
        LivingEntity livingEntity = recordOfValue_20.xV.eg();
        assert (livingEntity != null);
        BoundingBox boundingBox = livingEntity.getBoundingBox();
        PlayerBridge_16.a(livingEntity.getWorld(), boundingBox, false).forEach(location -> {
            Block block = location.getBlock();
            if (block.getType() == Material.BARRIER) {
                block.setType(Material.AIR);
            }
            BlockBridge_2.bk(block);
        });
    }

    public static void b(RecordOfValue_20 recordOfValue_20) {
        LivingEntity livingEntity = recordOfValue_20.xV.eg();
        assert (livingEntity != null);
        BoundingBox boundingBox = livingEntity.getBoundingBox();
        PlayerBridge_16.a(livingEntity.getWorld(), boundingBox, false).forEach(location -> {
            Block block = location.getBlock();
            if (recordOfValue_20.xX.xI != null && recordOfValue_20.xX.xI > 0) {
                BlockBridge_2.d(block, recordOfValue_20.xX.xI);
            }
            if (recordOfValue_20.xX.xJ != null && recordOfValue_20.xX.xJ.booleanValue() && !block.getType().isSolid()) {
                block.setType(Material.BARRIER);
            }
        });
    }

    public static void a(Player player, RecordOfValue_20 recordOfValue_20) {
        if (!s.f((HumanEntity)player, recordOfValue_20.xX.xR)) {
            return;
        }
        if (!LocationBridge_2.f((Entity)player, (Entity)recordOfValue_20.kD().eg())) {
            return;
        }
        LivingEntity livingEntity = recordOfValue_20.xV.eg();
        assert (livingEntity != null);
        boolean bl = false;
        PlayerBridge_16 playerBridge_16 = PlayerBridge_16.c(recordOfValue_20.xW);
        if (playerBridge_16.xK != null && playerBridge_16.xK.booleanValue() && player.getGameMode() != GameMode.CREATIVE) {
            bl = true;
        }
        ComplexFurnitureBreakEvent complexFurnitureBreakEvent = new ComplexFurnitureBreakEvent(player, livingEntity, recordOfValue_20.kD(), bl);
        ListenerBridge.b(complexFurnitureBreakEvent);
        if (complexFurnitureBreakEvent.isCancelled()) {
            return;
        }
        BoundingBox boundingBox = livingEntity.getBoundingBox();
        PlayerBridge_16.a(player.getWorld(), boundingBox, false).forEach(location -> {
            Block block = location.getBlock();
            if (LocationBridge_2.a(block, player)) {
                if (block.getType() == Material.BARRIER) {
                    block.setType(Material.AIR);
                }
                BlockBridge_2.bk(block);
            }
        });
        LivingEntityRegistry.db().a(recordOfValue_20.xV, true, false);
        if (complexFurnitureBreakEvent.isDropItem()) {
            LocationBridge_4.a(livingEntity.getLocation(), recordOfValue_20.xW.mP(), player);
        }
        NamespacedKeyItemDisplayHolder.a(boundingBox, player, true);
        PlayerBridge_16.b(player, recordOfValue_20);
        playerBridge_16.xS.O(livingEntity.getLocation());
    }

    private static void b(Player player, RecordOfValue_20 recordOfValue_20) {
        EntityBridge_2 entityBridge_2 = new EntityBridge_2((Entity)player, (Entity)recordOfValue_20.xV.eg(), EntityDamageEvent.DamageCause.ENTITY_ATTACK, 0.0);
        recordOfValue_20.xW.a((LivingEntity)player, BlockBreakEnum.PLACED_FURNITURE_BREAK, (Object builder_14) -> {
            ItemStack itemStack = recordOfValue_20.xW.mP();
            return builder_14.a(entityBridge_2, recordOfValue_20.xW, itemStack);
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
                    if (!LocationBridge_2.h(world, i >> 4, k >> 4)) continue;
                    if (!bl) {
                        hashSet.add(new Location(world, (double)i, (double)j, (double)k));
                        continue;
                    }
                    Block block = world.getBlockAt(i, j, k);
                    BoundingBox boundingBox2 = BoundingBox.of((Block)block);
                    if (!boundingBox2.overlaps(boundingBox)) continue;
                    BoundingBox boundingBox3 = boundingBox2.clone().intersection(boundingBox);
                    double d = boundingBox3.getWidthX() * boundingBox3.getHeight() * boundingBox3.getWidthZ();
                    double d2 = 1.0;
                    CommandSenderBridge_5.iA(d / d2 + " " + String.valueOf(block.getType()) + " " + LocationBridge_2.ae(block.getLocation()));
                    if (!(d / d2 >= 0.3)) continue;
                    hashSet.add(block.getLocation());
                }
            }
        }
        return new ArrayList(hashSet);
    }

    @Nullable
    public static RecordOfValue_20 aq(Player player) {
        if (!MaterialBarColorHolder.dL) {
            return null;
        }
        RayTraceResult rayTraceResult = player.getWorld().rayTraceEntities(player.getEyeLocation(), player.getEyeLocation().getDirection(), 5.0, 0.1, entity -> entity.getEntityId() != player.getEntityId() && NamespacedKeyBridge.d((PersistentDataHolder)entity, xG) != null && LivingEntityRegistry.db().d(entity.getUniqueId()));
        if (rayTraceResult != null && rayTraceResult.getHitEntity() != null) {
            Entity entity2 = rayTraceResult.getHitEntity();
            LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().e(entity2.getUniqueId());
            if (livingEntityBuilder == null) {
                return null;
            }
            String string = NamespacedKeyBridge.d((PersistentDataHolder)entity2, xG);
            ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e(string);
            if (itemStackBuilder_4 == null) {
                CommandSenderBridge_5.warn("Unknown custom item: " + string + ". Probably was removed from config or was disabled.");
                LivingEntityRegistry.db().a(livingEntityBuilder, true, false);
                return null;
            }
            if (PlayerBuilder.a(xH, player).g(() -> CommandSenderBridge_5.g((CommandSender)player, "interact-too-fast"))) {
                return null;
            }
            return new RecordOfValue_20(livingEntityBuilder, itemStackBuilder_4, PlayerBridge_16.c(itemStackBuilder_4));
        }
        return null;
    }

    @Nullable
    public static RecordOfValue_20 g(LivingEntity livingEntity) {
        if (!MaterialBarColorHolder.dL) {
            return null;
        }
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().e(livingEntity.getUniqueId());
        if (livingEntityBuilder == null) {
            return null;
        }
        String string = NamespacedKeyBridge.d((PersistentDataHolder)livingEntity, xG);
        if (string == null) {
            return null;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e(string);
        if (itemStackBuilder_4 == null) {
            CommandSenderBridge_5.warn("Unknown custom item: " + string + ". Probably was removed from config or was disabled.");
            LivingEntityRegistry.db().a(livingEntityBuilder, true, false);
            return null;
        }
        return new RecordOfValue_20(livingEntityBuilder, itemStackBuilder_4, PlayerBridge_16.c(itemStackBuilder_4));
    }

    private /* synthetic */ void a(Player player, boolean bl, Location location) {
        Block block = location.getBlock();
        if (player == null || LocationBridge_2.b(block, player)) {
            if (this.xI != null && this.xI > 0) {
                BlockBridge_2.d(block, this.xI);
            }
            if (!bl && this.xJ != null && this.xJ.booleanValue() && !block.getType().isSolid()) {
                block.setType(Material.BARRIER);
            }
        }
    }

    private /* synthetic */ void a(ItemStackBuilder_4 itemStackBuilder_4, Player player, ItemStack itemStack, LivingEntity livingEntity) {
        livingEntity.setInvulnerable(true);
        livingEntity.setAI(false);
        livingEntity.setRemoveWhenFarAway(false);
        if (this.xJ != null && this.xJ.booleanValue() || this.xI != null && this.xI > 0) {
            livingEntity.setGravity(false);
        }
        livingEntity.getPersistentDataContainer().set(xG, PersistentDataType.STRING, (Object)itemStackBuilder_4.getNamespacedID());
        if (player != null && player.getGameMode() != GameMode.CREATIVE) {
            ItemStackBridge_2.aj(itemStack);
        }
    }

    private static /* synthetic */ boolean u(Entity entity) {
        return LivingEntityRegistry.db().f(entity);
    }

    static {
        PlayerBuilder.a(xH);
    }
}
