package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.lone.itemsadder.Core.OtherPlugins.mmoitems.MmoItemsHook;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.ItemsAdderFirstLoadEvent;
import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent;
import dev.lone.itemsadder.api.ItemsAdder$Advanced$InjectedItemModifier;
import dev.lone.itemsadder.resourcepack.ad;
import dev.lone.itemsadder.resourcepack.av;
import dev.lone.itemsadder.resourcepack.bk;
import dev.lone.itemsadder.resourcepack.f;
import itemsadder.m.AllEnum;
import itemsadder.m.ArmorsRendering;
import itemsadder.m.Assets;
import itemsadder.m.BlockBridge_13;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BlockIgniteListener;
import itemsadder.m.BlockPistonExtendListener;
import itemsadder.m.BlockPlaceListener;
import itemsadder.m.BlockPlaceListener_2;
import itemsadder.m.BossBarBridge_2;
import itemsadder.m.BukkitRunnableBridge;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.BukkitTaskHolder;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge_2;
import itemsadder.m.ConfigurationSectionBridge_4;
import itemsadder.m.ConfigurationSectionBridge_5;
import itemsadder.m.Crops;
import itemsadder.m.Dictionary;
import itemsadder.m.EnchantItemListener;
import itemsadder.m.EntitiesLoadListener_2;
import itemsadder.m.EntityDamageByEntityListener;
import itemsadder.m.EntityToggleGlideListener;
import itemsadder.m.Equipments;
import itemsadder.m.FindYMLConfigurations;
import itemsadder.m.FurnaceBurnListener;
import itemsadder.m.FurnaceStartSmeltListener;
import itemsadder.m.IareloadCommand;
import itemsadder.m.IazipCommand;
import itemsadder.m.InfoNamespace;
import itemsadder.m.InfoNamespace_2;
import itemsadder.m.InfoNamespace_3;
import itemsadder.m.InventoryClickListener;
import itemsadder.m.InventoryOpenListener;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBridge_29;
import itemsadder.m.ItemStackBridge_30;
import itemsadder.m.ItemStackBridge_37;
import itemsadder.m.ItemStackBridge_38;
import itemsadder.m.ItemStackBridge_40;
import itemsadder.m.ItemStackBridge_42;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemsAdderLoadDataEventHelper;
import itemsadder.m.Json;
import itemsadder.m.KabKab;
import itemsadder.m.LastModified;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.MaterialBlockDataHolder;
import itemsadder.m.MaterialBridge_19;
import itemsadder.m.MaterialBridge_3;
import itemsadder.m.MaterialBridge_9;
import itemsadder.m.NamespacedKeyPluginHolder;
import itemsadder.m.Opaque028;
import itemsadder.m.Opaque109;
import itemsadder.m.Opaque117;
import itemsadder.m.Opaque126;
import itemsadder.m.Opaque150;
import itemsadder.m.PacketAdapterHolder;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.Parent_2;
import itemsadder.m.PlayerBridge;
import itemsadder.m.PlayerBridge_26;
import itemsadder.m.PlayerBridge_27;
import itemsadder.m.PlayerBridge_28;
import itemsadder.m.PlayerDeathListener;
import itemsadder.m.PlayerFishEventBridge;
import itemsadder.m.PlayerHolder_5;
import itemsadder.m.PlayerInteractAtEntityListener;
import itemsadder.m.PlayerInteractAtEntityListener_2;
import itemsadder.m.PlayerInteractAtEntityListener_3;
import itemsadder.m.PlayerInteractListener;
import itemsadder.m.PlayerInteractListener_2;
import itemsadder.m.PlayerInteractListener_3;
import itemsadder.m.PlayerInteractListener_5;
import itemsadder.m.PlayerInteractListener_6;
import itemsadder.m.PlayerInteractListener_7;
import itemsadder.m.PlayerItemDamageListener;
import itemsadder.m.PlayerJoinListener;
import itemsadder.m.PlayerJoinListener_10;
import itemsadder.m.PlayerJoinListener_4;
import itemsadder.m.PlayerJoinListener_5;
import itemsadder.m.PlayerJoinListener_7;
import itemsadder.m.PlayerMoveListener;
import itemsadder.m.PlayerPickupItemListener;
import itemsadder.m.PlayerQuitListener;
import itemsadder.m.PlayerQuitListener_3;
import itemsadder.m.PluginBridge_10;
import itemsadder.m.PluginBridge_11;
import itemsadder.m.PluginBridge_12;
import itemsadder.m.PluginBridge_13;
import itemsadder.m.PluginBridge_14;
import itemsadder.m.PluginBridge_15;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.PluginBridge_9;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginContract_20;
import itemsadder.m.PluginDisableListener;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.PrepareAnvilListener;
import itemsadder.m.PrepareAnvilListener_2;
import itemsadder.m.PrepareItemCraftListener;
import itemsadder.m.PrepareItemEnchantListener;
import itemsadder.m.PrepareSmithingListener;
import itemsadder.m.ProjectileHitListener;
import itemsadder.m.ProjectileLaunchListener;
import itemsadder.m.RecipeBridge;
import itemsadder.m.RecordOfNamespacedKey_2;
import itemsadder.m.Runner;
import itemsadder.m.SoundCategoryBridge;
import itemsadder.m.VersionHelper_2;
import itemsadder.m.VersionHelper_3;
import itemsadder.m.WorldBridge_11;
import itemsadder.m.WorldBridge_2;
import itemsadder.m.WorldBridge_6;
import itemsadder.m.WorldSaveListener;
import itemsadder.m.YamlConfigurationBridge;
import itemsadder.m.YyyyMMDd;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.stream.Collectors;
import lombok.Generated;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class ItemStackRegistry {
    private final AtomicBoolean c = new AtomicBoolean();
    @Deprecated
    public static Gson d;
    static ItemStackRegistry e;
    final Plugin f;
    public static final String g;
    public static final String i;
    public static final String j = "generated.zip";
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q = "__manually_handled";
    public static final char r = '~';
    static Set s;
    static Set t;
    public volatile boolean u;
    public volatile boolean v;
    public List w = new ArrayList();
    public List x = new ArrayList();
    public List y = new ArrayList();
    public boolean z;
    public PluginBridge_15 A;
    public VersionHelper_2 B;
    public LinkedHashMap C = new LinkedHashMap();
    public LinkedHashMap D = new LinkedHashMap();
    public LinkedHashMap E = new LinkedHashMap();
    public LinkedHashMap F = new LinkedHashMap();
    @Deprecated
    public LinkedHashMap G = new LinkedHashMap();
    public LinkedHashMap H = new LinkedHashMap();
    public LinkedHashMap I = new LinkedHashMap();
    Map J = new HashMap();
    public HashMap K = new HashMap();
    public HashMap L = new HashMap();
    public HashMap M = new HashMap();
    public HashMap N = new HashMap();
    public HashMap O = new HashMap();
    public HashMap P = new HashMap();
    public HashMap Q = new HashMap();
    public HashMap R = new HashMap();
    public final LinkedHashSet S = new LinkedHashSet();
    public LinkedHashMap T = new LinkedHashMap();
    public LinkedHashMap U = new LinkedHashMap();
    public final MaterialBridge_3 V = new MaterialBridge_3();
    public final WorldBridge_2 W = new WorldBridge_2();
    public final PlayerMoveListener X = new PlayerMoveListener(this.W, this.V);
    public final Map Y = new HashMap();
    public final HashSet Z = new HashSet();
    public List aa = new ArrayList();
    public HashMap ab = new HashMap();
    public HashMap ac = new HashMap();
    Map ad = new HashMap();
    List ae = new ArrayList();
    public HashMap af = new HashMap();
    public HashMap ag = new HashMap();
    public HashMap ah = new HashMap();
    public static final HashMap ai;
    public static final List aj;
    private final FindYMLConfigurations ak;
    public PluginBridge_10 al;
    public PluginBridge_11 am;
    public PlayerBridge_27 an;
    public PlayerJoinListener_4 ao;
    public WorldSaveListener ap;
    public NamespacedKeyPluginHolder aq;
    public PlayerInteractListener_5 ar;
    public av as;
    private PlayerBridge at;
    public ItemStackBridge_29 au;
    public EntityDamageByEntityListener av;
    public PlayerFishEventBridge aw;
    public ItemStackBridge_30 ax;
    public PlayerItemDamageListener ay;
    public PlayerInteractListener_6 az;
    public EntityToggleGlideListener aA;
    public ProjectileHitListener aB;
    public EntitiesLoadListener_2 aC;
    public PlayerInteractListener_2 aD;
    public BlockPlaceListener_2 aE;
    public PlayerInteractAtEntityListener aF;
    public PlayerQuitListener_3 aG;
    public PlayerInteractAtEntityListener_2 aH;
    public PluginBridge_12 aI;
    public PlayerDeathListener aJ;
    public PlayerInteractListener_3 aK;
    public BlockPlaceListener aL;
    public PlayerInteractAtEntityListener_3 aM;
    public FurnaceBurnListener aN;
    public PluginDisableListener aO;
    public BlockPistonExtendListener aP;
    public PluginBridge_13 aQ;
    public PluginBridge_14 aR;
    public PlayerInteractListener_7 aS;
    public BlockIgniteListener aT;
    public PrepareItemEnchantListener aU;
    public EnchantItemListener aV;
    public RecipeBridge aW;
    @Nullable
    public PrepareItemCraftListener aX;
    @Nullable
    public FurnaceStartSmeltListener aY;
    @Nullable
    public PrepareSmithingListener aZ;
    @Nullable
    public PrepareAnvilListener ba;
    public PrepareAnvilListener_2 bb;
    public ItemStackBridge_40 bc;
    public PlayerPickupItemListener bd;
    @Nullable
    private PlayerInteractListener be;
    public final HashMap bf = new HashMap();
    public final Opaque109 bg = new Opaque109();
    public final KabKab bh = new KabKab();
    public ItemStackBridge_42 bi;
    public PlayerBridge_26 bj;
    public PlayerJoinListener_10 bk;
    public boolean bl;

    private ItemStackRegistry(Plugin plugin, VersionHelper_2 versionHelper_2) {
        e = this;
        this.f = plugin;
        this.B = versionHelper_2;
        this.ak = new FindYMLConfigurations();
        d = !MaterialBarColorHolder.di ? new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create() : new GsonBuilder().disableHtmlEscaping().create();
        try {
            s = ColorBridge.a("internal/models", (T string) -> string.endsWith(".json")).stream().map(string -> {
                String string2 = FilenameUtils.removeExtension((String)string);
                string2 = string2.replace("internal/models/", "");
                return "minecraft:" + string2;
            }).collect(Collectors.toSet());
            t = ColorBridge.a("internal/textures", (T string) -> string.endsWith(".png")).stream().map(string -> {
                String string2 = FilenameUtils.removeExtension((String)string);
                string2 = string2.replace("internal/textures/", "");
                return "minecraft:" + string2;
            }).collect(Collectors.toSet());
        }
        catch (IOException iOException) {
            CommandSenderBridge_5.error("Error while loading builtin assets from plugin resources.", iOException);
        }
        Opaque150.init();
        new InventoryOpenListener();
        BukkitTaskBridge.a(new BukkitRunnableBridge(this), 54000L, 54000L);
        new ItemsAdderLoadDataEventHelper().register();
        this.A = new PluginBridge_15();
    }

    public static boolean a(String string) {
        return s.contains(string);
    }

    public static boolean b(String string) {
        return t.contains(string.contains(":") ? string : "minecraft:" + string);
    }

    public void f() {
        this.a(() -> {
            if (!this.as.auh.yB()) {
                this.a(false, () -> CommandSenderBridge_5.log("Resourcepack not found. Generating..."), bl -> {
                    if (bl.booleanValue()) {
                        CommandSenderBridge_5.log("Resourcepack generated.");
                        this.as.aui.a(null, (CommandSender)Bukkit.getConsoleSender());
                        IazipCommand.a(null, false, AllEnum.ALL);
                    } else {
                        BossBarBridge_2.clear();
                    }
                }, BossBarBridge_2::s, null);
            } else {
                this.as.aui.a(null, (CommandSender)Bukkit.getConsoleSender());
                BossBarBridge_2.clear();
            }
        }, false, false);
    }

    public static ItemStackRegistry g() {
        return e;
    }

    public static ItemStackRegistry a(Plugin plugin, VersionHelper_2 versionHelper_2) {
        if (e != null) {
            plugin.getLogger().severe("Core already initialized. Use the Core.inst() method instead of Core.inst(plugin).");
            return e;
        }
        e = new ItemStackRegistry(plugin, versionHelper_2);
        return e;
    }

    public static boolean a(Block block) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        if (!blockBridge_9.isCustomBlock(block)) {
            return false;
        }
        BlockBridge_13 blockBridge_13 = (BlockBridge_13)ItemStackRegistry.g().e(blockBridge_9.Y(block));
        if (blockBridge_13 == null) {
            return false;
        }
        return blockBridge_13.Ge.bm("block_trade_machine");
    }

    public static File h() {
        return new File(Main.rS().getDataFolder(), "output");
    }

    public static boolean a(@Nullable String string, PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        return FindYMLConfigurations.a(string, pluginFileConfigurationHolder);
    }

    public boolean i() {
        return this.u;
    }

    public boolean k() {
        return this.v;
    }

    public static Material l() {
        return Material.BARRIER;
    }

    public Collection b() {
        return this.ak.b();
    }

    public Map d() {
        return this.ak.d();
    }

    public void a(boolean bl) {
        this.a(true, bl);
    }

    public void a(boolean bl, boolean bl2) {
        BukkitTaskBridge.r(this.getClass());
        this.X.bU();
        WorldBridge_6.mc();
        PluginBridge_9.EX();
        if (this.as != null) {
            this.as.bU();
        }
        if (this.ap != null) {
            this.ap.af(bl);
        }
        if (this.an != null) {
            this.an.e(bl);
        }
        if (this.ao != null) {
            this.ao.kp();
        }
        PluginContract.a(this.ar);
        PluginContract.a(this.az);
        PluginContract.a(this.aA);
        PluginContract.a(this.ay);
        PluginContract.a(this.ax);
        PluginContract.a(this.av);
        PluginContract.a(this.au);
        PluginContract.a(this.aw);
        PluginContract.a(this.aB);
        PluginContract.a(this.aE);
        PluginContract.a(this.aL);
        PluginContract.a(this.aG);
        PluginContract.a(this.aH);
        PluginContract.a(this.aI);
        PluginContract.a(this.aJ);
        PluginContract.a(this.aK);
        PluginContract.a(this.aO);
        PluginContract.a(this.aC);
        PluginContract.a(this.aD);
        PluginContract.a(this.aF);
        PluginContract.a(this.aM);
        PluginContract.a(this.aN);
        PluginContract.a(this.aP);
        PluginContract.a(this.aQ);
        PluginContract.a(this.aR);
        PluginContract.a(this.aS);
        if (this.aT != null) {
            this.aT.unregister();
        }
        PluginContract.a(this.aU);
        PluginContract.a(this.aV);
        PluginContract.a(this.aX);
        PluginContract.a(this.aY);
        PluginContract.a(this.aZ);
        PluginContract.a(this.ba);
        if (this.an instanceof PluginContract) {
            PluginContract.a((PluginContract)((Object)this.an));
        }
        PluginContract.a(this.ao);
        if (this.aq != null) {
            PluginContract.a(this.aq.Li);
        }
        PluginContract.a(this.bk);
        if (!bl2) {
            ProjectileLaunchListener.unregister();
        }
        if (this.be != null) {
            if (bl2) {
                this.be.bU();
            } else {
                this.be.O();
            }
        }
    }

    public void b(boolean bl) {
        ConfigurationSectionBridge_2.Cb = false;
        InfoNamespace_3.px();
        PlayerJoinListener.tf().mc();
        this.C.clear();
        this.E.clear();
        this.D.clear();
        this.F.clear();
        this.G.clear();
        this.J.clear();
        this.H.clear();
        this.I.clear();
        this.ab.clear();
        this.ac.clear();
        this.K.clear();
        this.L.clear();
        this.M.clear();
        this.N.clear();
        this.O.clear();
        this.P.clear();
        this.Q.clear();
        this.R.clear();
        this.Y.clear();
        this.ad.clear();
        this.ae.clear();
        if (this.al != null) {
            this.al.cy();
        }
        this.S.clear();
        this.T.clear();
        this.X.bU();
        this.V.clear();
        this.W.clear();
        this.Z.clear();
        this.aa.clear();
        this.af.clear();
        this.ag.clear();
        this.ah.clear();
        if (this.aW != null) {
            this.aW.b(bl);
        }
        if (LivingEntityRegistry.P()) {
            LivingEntityRegistry.db().de();
        }
        MaterialBlockDataHolder.mc();
        PlayerJoinListener_5.lF().unregister();
    }

    public boolean m() {
        return ai != null && !ai.isEmpty() || aj != null && !aj.isEmpty();
    }

    public void n() {
        aj.clear();
        ai.clear();
    }

    public void a(Plugin plugin) {
        ai.forEach((string, list) -> list.removeIf(itemsAdder$Advanced$InjectedItemModifier -> plugin.getName().equals(itemsAdder$Advanced$InjectedItemModifier.owner)));
        aj.removeIf(itemsAdder$Advanced$InjectedItemModifier -> plugin.getName().equals(itemsAdder$Advanced$InjectedItemModifier.owner));
    }

    public void a(@Nullable Runnable runnable, boolean bl, boolean bl2) {
        BossBarBridge_2.bf("Cleaning up...");
        this.b(bl2);
        if (MaterialBarColorHolder.fV) {
            try {
                BukkitTaskHolder.c(new File(this.f.getDataFolder(), "storage" + File.separator + "cache" + File.separator + "ffmpeg"));
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.warn("Error while initializing FFMPEG library: " + throwable.getMessage());
            }
        } else {
            BukkitTaskHolder.N();
        }
        new PlayerJoinListener_7();
        BossBarBridge_2.bf("Refreshing contents...");
        this.d(false);
        dev.lone.itemsadder.resourcepack.f.xl().init();
        BossBarBridge_2.bf("Initializing...");
        if (this.ap == null) {
            this.ap = new WorldSaveListener(this.f);
        }
        this.as = new av(this.f);
        this.at = new PlayerBridge(this.f, this.as);
        this.o();
        this.p();
        this.bd = new PlayerPickupItemListener(this.f);
        this.r();
        PacketAdapterHolder.i(MaterialBarColorHolder.fu);
        InventoryClickListener.i(MaterialBarColorHolder.fw);
        if (!this.B.aB()) {
            CommandSenderBridge_5.warn("Vanilla assets are not downloaded yet. Please wait until download ends.");
            BossBarBridge_2.clear();
            this.u();
            IareloadCommand.SE = false;
            IazipCommand.SE = false;
            return;
        }
        this.v = false;
        BukkitTaskBridge.i(() -> {
            try {
                this.b(() -> {
                    ProjectileLaunchListener.i(this.y());
                    if (runnable != null) {
                        runnable.run();
                    }
                }, bl, bl2);
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.error("Error loading the plugin, something is not configured right or an exception occurred.", throwable);
                BossBarBridge_2.clear();
                this.v = true;
                this.u();
                IareloadCommand.SE = false;
                IazipCommand.SE = false;
            }
        });
        this.c(bl2);
    }

    private void o() {
        this.ar = new PlayerInteractListener_5(this.f, this);
        this.az = new PlayerInteractListener_6(this.f, this);
        this.aA = new EntityToggleGlideListener(this.f, this);
        this.ay = new PlayerItemDamageListener(this.f, this);
        this.ax = new ItemStackBridge_30(this.f, this);
        this.av = new EntityDamageByEntityListener(this.f, this);
        this.au = new ItemStackBridge_29(this);
        this.aw = new PlayerFishEventBridge(this.f, this);
        this.aB = new ProjectileHitListener(this.f, this);
        this.aE = new BlockPlaceListener_2();
        this.aL = new BlockPlaceListener(this.f, this);
        this.aG = new PlayerQuitListener_3(this.f, this);
        this.aH = new PlayerInteractAtEntityListener_2(this.f, this);
        this.aI = new PluginBridge_12(this.f);
        this.aJ = new PlayerDeathListener(this.f, this);
        this.aK = new PlayerInteractListener_3(this.f);
        this.aO = new PluginDisableListener(this.f, this);
        this.aC = new EntitiesLoadListener_2(this.f);
        this.aD = new PlayerInteractListener_2(this.f);
        this.aF = new PlayerInteractAtEntityListener(this.f);
        this.aM = new PlayerInteractAtEntityListener_3(this.f, this);
        this.aN = new FurnaceBurnListener(this.f, this);
        this.aR = new PluginBridge_14(this.f, this);
        if (VersionHelper_3.sZ()) {
            this.aS = new PlayerInteractListener_7();
        }
        this.aT = BlockIgniteListener.lH();
        this.aU = new PrepareItemEnchantListener(this.f, this);
        this.aV = new EnchantItemListener(this.f, this);
    }

    private void p() {
        this.aW = new RecipeBridge();
        if (MaterialBarColorHolder.fa) {
            this.aX = new PrepareItemCraftListener(this.f, this);
        }
        if (MaterialBarColorHolder.fb) {
            this.aY = new FurnaceStartSmeltListener(this.f, this);
        }
        if (MaterialBarColorHolder.fd) {
            this.aZ = new PrepareSmithingListener(this.f, this);
        }
        if (MaterialBarColorHolder.fc) {
            this.ba = new PrepareAnvilListener(this.f);
        }
        PlayerHolder_5.vr();
        if (this.bb == null) {
            this.bb = new PrepareAnvilListener_2(this.f);
        }
        if (this.bc == null) {
            this.bc = new ItemStackBridge_40(this.f);
        }
    }

    private void r() {
        this.an = MaterialBarColorHolder.fv ? new PlayerBridge_28(this.f, this) : new PlayerQuitListener(this.f, this);
        this.al = new PluginBridge_10(this.f, this);
        this.am = new PluginBridge_11(this.f, this);
        if (this.ao == null) {
            this.ao = new PlayerJoinListener_4(this.f, this);
        }
        this.aq = new NamespacedKeyPluginHolder(this.f, this);
    }

    private void c(boolean bl) {
        if (Version.isAtLeast((Version)Version.v1_21_4)) {
            if (!this.ab.isEmpty()) {
                if (!bl) {
                    this.be = new PlayerInteractListener();
                    this.be.onEnable();
                } else if (this.be != null) {
                    this.be.cS();
                } else {
                    this.be = new PlayerInteractListener();
                    this.be.onEnable();
                }
            } else if (this.be != null) {
                this.be.O();
                this.be = null;
            }
        }
    }

    public static void a(Runnable runnable) {
        if (MaterialBarColorHolder.cA) {
            runnable.run();
        } else {
            BukkitTaskBridge.h(runnable);
        }
    }

    private void b(@Nullable Runnable runnable, boolean bl, boolean bl2) {
        BossBarBridge_2.bf("Preparing content load...");
        this.u = false;
        Parent_2.Bu();
        dev.lone.itemsadder.resourcepack.bk.gr();
        YamlConfigurationBridge.gr();
        dev.lone.itemsadder.resourcepack.f.xl().xm();
        Opaque028 opaque028 = new Opaque028();
        Opaque117 opaque117 = new Opaque117();
        BossBarBridge_2.bf("Extracting internal files...");
        opaque117.A("extract-internal-files");
        if (MaterialBarColorHolder.eu) {
            dev.lone.itemsadder.resourcepack.ad.yy();
        }
        BossBarBridge_2.bf("Refreshing content file cache...");
        if (MaterialBarColorHolder.dI) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "[Content] Loading content...");
        }
        opaque117.A("contents-cache");
        this.d(true);
        BossBarBridge_2.bf("Finding files...");
        opaque117.A("find-files");
        if (MaterialBarColorHolder.dI) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "[Content] Loading YML files...");
        }
        this.ak.a(l, p, this.z, bl2);
        opaque117.A("compiling-scripts");
        BossBarBridge_2.bf("Compiling Scripts...");
        InfoNamespace_3.az(bl2);
        opaque117.A("font-images");
        BossBarBridge_2.bf("Font images...");
        this.al.hU();
        if (Main.KO.gY("huds.enabled")) {
            BossBarBridge_2.bf("HUDs...");
            opaque117.A("huds");
            this.am.jG();
        } else {
            this.am.Z(false);
        }
        opaque117.A("langs");
        BossBarBridge_2.bf("Languages...");
        this.bh.clear();
        BossBarBridge_2.bf("Loading dictionaries...");
        for (Object object : this.b()) {
            Dictionary.a((PluginFileConfigurationHolder)object, this.bg);
            Dictionary.a((PluginFileConfigurationHolder)object, this.bh);
        }
        ConfigurationSectionBridge_4 configurationSectionBridge_4 = new ConfigurationSectionBridge_4(this);
        BossBarBridge_2.bf("Converting legacy configurations...");
        opaque117.A("convert-legacy-configs");
        YyyyMMDd.pt();
        BossBarBridge_2.bf("Legacy Armors...");
        opaque117.A("armors-legacy");
        ArmorsRendering.a(this.b(), this.K, this.L);
        BossBarBridge_2.bf("Sounds...");
        opaque117.A("sounds");
        LastModified.aR();
        BossBarBridge_2.bf("Equipments...");
        opaque117.A("equipments");
        Equipments.a(this.b(), this.ad, this.x, this.w);
        BossBarBridge_2.bf("Items...");
        opaque117.A("items");
        try {
            configurationSectionBridge_4.aR();
            this.bl = false;
            for (Map.Entry entry : this.C.entrySet()) {
                ItemStackBuilder_4 itemStackBuilder_4 = (ItemStackBuilder_4)entry.getValue();
                if (!itemStackBuilder_4.ng()) continue;
                this.bl = true;
                break;
            }
        }
        catch (Exception exception) {
            dev.lone.itemsadder.resourcepack.f.xl().xn();
            CommandSenderBridge_5.error("");
            CommandSenderBridge_5.error("ITEMS LOADING INTERRUPTED!");
            CommandSenderBridge_5.error("Something unexpected happened while loading items.");
            CommandSenderBridge_5.error("Remove configurations until you find out the cause of the issue.");
            CommandSenderBridge_5.error("Please report this issue on GitHub.", exception);
            CommandSenderBridge_5.error("");
        }
        BossBarBridge_2.bf("Crops...");
        opaque117.A("crops");
        Crops.aR();
        BossBarBridge_2.bf("Registering cooldown indicators...");
        this.ar.me();
        if (MaterialBarColorHolder.dL) {
            Object object;
            BossBarBridge_2.bf("Entities...");
            opaque117.A("entities");
            if (MaterialBarColorHolder.dO) {
                CommandSenderBridge_5.warn("Custom entities 'delay_packets' is enabled. This helps client/server performance but might cause stuttering animations. More info: https://a.devs.beer/ia-delaypackets");
            }
            object = new InfoNamespace();
            ((InfoNamespace)object).c(this);
            BossBarBridge_2.bf("Entities Populators...");
            opaque117.A("entities_populators");
            InfoNamespace_2.aR();
        }
        if (!this.af.isEmpty()) {
            BossBarBridge_2.bf("Liquids...");
            PluginContract.a(this.aP);
            PluginContract.a(this.aQ);
            if (MaterialBarColorHolder.cS) {
                this.aP = new BlockPistonExtendListener(this.f, this);
                this.aQ = new PluginBridge_13(this.f, this);
            }
        }
        this.u = true;
        BossBarBridge_2.clear();
        ItemStackRegistry.a(() -> {
            try {
                ConfigurationSectionBridge_5 configurationSectionBridge_5;
                if (!bl) {
                    BossBarBridge_2.bf("Preloading recipes...");
                    opaque117.A("recipes");
                    configurationSectionBridge_5 = new ConfigurationSectionBridge_5();
                    configurationSectionBridge_5.a(this, this.d(), this.ba);
                } else {
                    configurationSectionBridge_5 = null;
                }
                BossBarBridge_2.bf("Reloading worlds configuration...");
                opaque117.A("various");
                WorldBridge_6.reload();
                BossBarBridge_2.bf("Finalizing loaded items...");
                configurationSectionBridge_4.ps();
                if (MaterialBarColorHolder.dM) {
                    BossBarBridge_2.bf("Registering emotes...");
                    opaque117.A("emotes");
                    LivingEntityRegistry.db().dh();
                    LivingEntityRegistry.db().dg();
                    BossBarBridge_2.bf("Caching emote models...");
                    LivingEntityRegistry.db().do();
                    BossBarBridge_2.bf("Loading emote overrides...");
                    for (PluginFileConfigurationHolder pluginFileConfigurationHolder : this.b()) {
                        LivingEntityRegistry.db().c(pluginFileConfigurationHolder);
                    }
                    BossBarBridge_2.bf("Loading emote events and goals...");
                    LivingEntityRegistry.db().di();
                }
                BossBarBridge_2.bf("Saving content IDs and statistics...");
                opaque117.A("stats");
                CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "[Content] Loaded " + String.valueOf(ChatColor.AQUA) + this.C.size() + String.valueOf(ChatColor.GREEN) + " items");
                dev.lone.itemsadder.resourcepack.f.xl().sJ();
                opaque117.A("cache");
                dev.lone.itemsadder.resourcepack.f.xl().xq();
                dev.lone.itemsadder.resourcepack.f.xl().xo();
                if (Main.KO.gY("huds.enabled") && this.am.vF.size() > 0) {
                    BossBarBridge_2.bf("Initializing HUDs...");
                    opaque117.A("huds");
                    this.ao.init();
                }
                BossBarBridge_2.bf("Loots...");
                opaque117.A("loots");
                this.aq.a(this.b());
                BossBarBridge_2.bf("Initializing content categories...");
                this.bi = new ItemStackBridge_42(this.f, this);
                BossBarBridge_2.bf("Initializing font images book...");
                opaque117.A("chat-packet-handler");
                opaque117.A("font-images-book");
                this.bj = new PlayerBridge_26();
                BossBarBridge_2.bf("Initializing chat packet handlers...");
                opaque117.A("chat-packets-replace-handlers");
                this.bk = new PlayerJoinListener_10(this.f, this);
                opaque117.K();
                BukkitTaskBridge.i(() -> {
                    try {
                        BossBarBridge_2.bf("Registering recipes...");
                        if (!bl) {
                            opaque117.A("recipes-2");
                            configurationSectionBridge_5.a(this.aX, this.aY, this.aZ);
                        }
                        BossBarBridge_2.bf("Loading recipe categories...");
                        this.bi.Ue.sG();
                        if (!Bukkit.getWorlds().isEmpty()) {
                            BossBarBridge_2.bf("Rebuilding entity block cache...");
                            this.V.a((World)Bukkit.getWorlds().get(0), this.S);
                            this.W.a(this.ap);
                            this.X.hn();
                        }
                        BossBarBridge_2.bf("Calling content load events...");
                        ListenerBridge.b(new ItemsAdderFirstLoadEvent());
                        ListenerBridge.b(new ItemsAdderLoadDataEvent(bl2, bl));
                        if (Main.KO.gY("debug.performance.loading-ms")) {
                            if (bl2) {
                                CommandSenderBridge_5.a(String.format("&a[Content] Loaded successfully in &b%dms", opaque028.DJ()), Level.INFO);
                                opaque117.L();
                            } else {
                                CommandSenderBridge_5.log("&a[Content] Contents loaded successfully!");
                            }
                        }
                        BossBarBridge_2.bf("Registering gameplay watchers...");
                        this.ay.mr();
                        this.v = true;
                        if (configurationSectionBridge_4.Ka) {
                            BossBarBridge_2.bf("Refreshing biome registry...");
                            ItemStackRegistry.A();
                        }
                        BossBarBridge_2.bf("Finalizing content load...");
                        this.at.h(bl2);
                        BossBarBridge_2.clear();
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                    catch (Error | RuntimeException throwable) {
                        BossBarBridge_2.clear();
                        throw throwable;
                    }
                });
            }
            catch (Error | RuntimeException throwable) {
                BossBarBridge_2.clear();
                throw throwable;
            }
        });
    }

    public void a(@Nullable Plugin plugin, ItemStackBuilder_4 itemStackBuilder_4) {
        ItemsAdder$Advanced$InjectedItemModifier itemsAdder$Advanced$InjectedItemModifier = null;
        try {
            List list = (List)ai.get(itemStackBuilder_4.getNamespacedID());
            if (list != null) {
                for (ItemsAdder$Advanced$InjectedItemModifier itemsAdder$Advanced$InjectedItemModifier2 : list) {
                    if (plugin != null && !itemsAdder$Advanced$InjectedItemModifier2.owner.equals(plugin.getName())) continue;
                    itemsAdder$Advanced$InjectedItemModifier = itemsAdder$Advanced$InjectedItemModifier2;
                    itemsAdder$Advanced$InjectedItemModifier2.call(itemStackBuilder_4.getNamespacedID(), itemStackBuilder_4);
                }
            }
            for (ItemsAdder$Advanced$InjectedItemModifier itemsAdder$Advanced$InjectedItemModifier2 : aj) {
                if (plugin != null && !itemsAdder$Advanced$InjectedItemModifier2.owner.equals(plugin.getName())) continue;
                itemsAdder$Advanced$InjectedItemModifier = itemsAdder$Advanced$InjectedItemModifier2;
                itemsAdder$Advanced$InjectedItemModifier2.call(itemStackBuilder_4.getNamespacedID(), itemStackBuilder_4);
            }
        }
        catch (Exception exception) {
            if (itemsAdder$Advanced$InjectedItemModifier != null) {
                if (itemsAdder$Advanced$InjectedItemModifier.item != null) {
                    CommandSenderBridge_5.error("Error calling injected item modifier of plugin " + itemsAdder$Advanced$InjectedItemModifier.owner + " for item " + itemsAdder$Advanced$InjectedItemModifier.item);
                } else {
                    CommandSenderBridge_5.error("Error calling injected items modifier of plugin " + itemsAdder$Advanced$InjectedItemModifier.owner);
                }
            } else {
                CommandSenderBridge_5.error("Error calling injected item modifiers");
            }
            exception.printStackTrace();
        }
    }

    public boolean a(boolean bl, @Nullable Runnable runnable, @Nullable Consumer consumer, @Nullable Runner runner, @Nullable Player player) {
        return this.a(bl, runnable, consumer, runner, player, false);
    }

    public boolean b(boolean bl, @Nullable Runnable runnable, @Nullable Consumer consumer, @Nullable Runner runner, @Nullable Player player) {
        return this.a(bl, runnable, consumer, runner, player, true);
    }

    private boolean a(boolean bl, @Nullable Runnable runnable, @Nullable Consumer consumer, @Nullable Runner runner, @Nullable Player player, boolean bl2) {
        return this.at.a(this.N, this.C, this.be != null, this.al.um, this.bh, bl, runnable, consumer, runner, player, bl2);
    }

    public boolean s() {
        return this.c.compareAndSet(false, true);
    }

    public boolean t() {
        return this.c.get();
    }

    public void u() {
        this.c.set(false);
    }

    public PlayerInteractListener v() {
        if (this.be == null) {
            throw new RuntimeException("Crops are not available for this server version!");
        }
        return this.be;
    }

    @Nullable
    public Collection c(String string) {
        HashMap hashMap = (HashMap)this.P.get(string);
        if (hashMap == null) {
            return null;
        }
        return hashMap.values();
    }

    @Nullable
    public Set d(String string) {
        HashMap hashMap = (HashMap)this.P.get(string);
        if (hashMap == null) {
            return null;
        }
        return hashMap.keySet();
    }

    @Nullable
    public Opaque126 c(String string, String string2) {
        HashMap hashMap = (HashMap)ItemStackRegistry.g().P.get(string);
        if (hashMap == null) {
            return null;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = (ItemStackBuilder_4)hashMap.get(string2);
        if (itemStackBuilder_4 != null) {
            return itemStackBuilder_4.Ge.bn(string);
        }
        if (!string2.contains(":")) {
            for (ItemStackBuilder_4 itemStackBuilder_42 : hashMap.values()) {
                if (!itemStackBuilder_42.Gg.equals(string2)) continue;
                return itemStackBuilder_42.Ge.bn(string);
            }
        }
        return null;
    }

    @Nullable
    public ItemStackBuilder_4 a(@Nullable ItemStack itemStack, boolean bl) {
        if (!ItemStackBuilder_4.isCustomItem(itemStack)) {
            if (bl) {
                CommandSenderBridge_5.error("Warning, ITEM " + String.valueOf(itemStack.getType()) + " is not a custom item.");
            }
            return null;
        }
        String string = ItemStackBuilder_4.u(itemStack);
        if (!this.u) {
            throw new RuntimeException("Items not finished loading, can't get item " + string);
        }
        ItemStackBuilder_4 itemStackBuilder_4 = (ItemStackBuilder_4)this.C.get(ItemStackBuilder_4.u(itemStack));
        if (itemStackBuilder_4 == null) {
            if (bl) {
                CommandSenderBridge_5.error("ERROR, ITEM " + string + " not found in configs! Maybe an old item?");
            } else {
                return null;
            }
        }
        return itemStackBuilder_4;
    }

    @Nullable
    public ItemStackBuilder_4 a(ItemStack itemStack) {
        return this.a(itemStack, false);
    }

    @Nullable
    public ItemStackBuilder_4 a(Class clazz, ItemStack itemStack) {
        ItemStackBuilder_4 itemStackBuilder_4 = this.a(itemStack, false);
        if (itemStackBuilder_4 == null) {
            return null;
        }
        if (clazz.isInstance(itemStackBuilder_4)) {
            return itemStackBuilder_4;
        }
        return null;
    }

    @Nullable
    public ItemStackBuilder_4 b(String string, boolean bl) {
        if (string == null) {
            if (bl) {
                CommandSenderBridge_5.error("ERROR, ITEM is null. Maybe an old item?");
            }
            return null;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = null;
        if (string.contains(":")) {
            itemStackBuilder_4 = (ItemStackBuilder_4)this.C.get(string);
        } else {
            itemStackBuilder_4 = (ItemStackBuilder_4)this.E.get(string);
            if (itemStackBuilder_4 != null && Main.KO.gY("debug.items.log-warnings")) {
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "Guessed item namespace for item '" + string + "' -> " + itemStackBuilder_4.getNamespacedID());
            }
        }
        if (itemStackBuilder_4 == null) {
            if (bl) {
                CommandSenderBridge_5.error("ERROR, ITEM " + string + " not found in configs! Maybe an old item?");
            } else {
                return null;
            }
        }
        return itemStackBuilder_4;
    }

    @Nullable
    public ItemStackBuilder_4 c(String string, boolean bl) {
        ItemStackBuilder_4 itemStackBuilder_4 = null;
        if (string.contains(":")) {
            itemStackBuilder_4 = (ItemStackBuilder_4)this.F.get(string);
        } else {
            itemStackBuilder_4 = (ItemStackBuilder_4)this.G.get(string);
            if (Main.KO.gY("debug.items.log-warnings")) {
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "Guessed item namespace for item '" + string + "' -> " + itemStackBuilder_4.getNamespacedID());
            }
        }
        if (itemStackBuilder_4 == null) {
            if (bl) {
                CommandSenderBridge_5.error("ERROR, VARIANT " + string + " not found in configs! Maybe an old item?");
            } else {
                return null;
            }
        }
        return itemStackBuilder_4;
    }

    @Nullable
    public Object a(Class clazz, String string) {
        ItemStackBuilder_4 itemStackBuilder_4 = this.e(string);
        if (clazz.isInstance(itemStackBuilder_4)) {
            return itemStackBuilder_4;
        }
        return null;
    }

    @Nullable
    public ItemStackBuilder_4 e(String string) {
        return this.b(string, false);
    }

    public boolean f(String string) {
        return this.e(string) != null;
    }

    public boolean isCustomItem(ItemStack itemStack) {
        return this.a(itemStack) != null;
    }

    public boolean b(ItemStack itemStack) {
        ItemStackBuilder_4 itemStackBuilder_4 = this.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return false;
        }
        return itemStackBuilder_4 instanceof LocationBridgeBuilder_2;
    }

    public boolean a(LocationBridgeBuilder_2 locationBridgeBuilder_2) {
        return this.aa.contains(locationBridgeBuilder_2);
    }

    public boolean g(String string) {
        if (string.contains(":")) {
            return this.C.containsKey(string);
        }
        return this.E.containsKey(string);
    }

    @Nullable
    public LocationBridgeBuilder_2 c(ItemStack itemStack) {
        ItemStackBuilder_4 itemStackBuilder_4 = this.a(itemStack);
        if (!(itemStackBuilder_4 instanceof LocationBridgeBuilder_2)) {
            return null;
        }
        return (LocationBridgeBuilder_2)itemStackBuilder_4;
    }

    @Nullable
    public LocationBridgeBuilder_2 h(String string) {
        ItemStackBuilder_4 itemStackBuilder_4 = this.e(string);
        if (!(itemStackBuilder_4 instanceof LocationBridgeBuilder_2)) {
            return null;
        }
        return (LocationBridgeBuilder_2)itemStackBuilder_4;
    }

    public boolean a(Block block, Consumer consumer) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        if (!blockBridge_9.isCustomBlock(block)) {
            return false;
        }
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(blockBridge_9.Y(block));
        if (locationBridgeBuilder_2 == null) {
            return false;
        }
        consumer.accept(locationBridgeBuilder_2);
        return true;
    }

    public boolean hasBehaviour(ItemStack itemStack, String string) {
        ItemStackBuilder_4 itemStackBuilder_4 = this.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return false;
        }
        return itemStackBuilder_4.Ge.bm(string);
    }

    public boolean w() {
        if (!ItemStackRegistry.g().H.isEmpty()) {
            for (Map.Entry entry : ItemStackRegistry.g().H.entrySet()) {
                if (((HashMap)entry.getValue()).isEmpty()) continue;
                return true;
            }
        }
        return false;
    }

    public boolean y() {
        return ItemStackRegistry.g().N.containsKey(Material.TRIDENT);
    }

    @Nullable
    public ItemStackBuilder_4 a(Material material, int n2) {
        List list = (List)this.N.get(material);
        if (list == null) {
            return null;
        }
        for (ItemStackBuilder_4 itemStackBuilder_4 : list) {
            if (itemStackBuilder_4.fX() != n2) continue;
            return itemStackBuilder_4;
        }
        return null;
    }

    @Deprecated
    public LocationBridgeBuilder_2 a(Material material, HashMap hashMap) {
        for (LocationBridgeBuilder_2 locationBridgeBuilder_2 : this.S) {
            if (!material.equals((Object)locationBridgeBuilder_2.FD.pc()) || !hashMap.equals(locationBridgeBuilder_2.FD.pa())) continue;
            return locationBridgeBuilder_2;
        }
        return null;
    }

    @Nullable
    public static LocationBridgeBuilder_2 a(BlockData blockData) {
        for (LocationBridgeBuilder_2 locationBridgeBuilder_2 : ItemStackRegistry.g().S) {
            if (!blockData.matches(locationBridgeBuilder_2.FD.pb())) continue;
            return locationBridgeBuilder_2;
        }
        return null;
    }

    public boolean d(ItemStack itemStack) {
        return this.a(itemStack) instanceof MaterialBridge_9;
    }

    public List i(String string) {
        LinkedList<String> linkedList = new LinkedList<String>();
        if (string == null || string.isEmpty() || string.equals(" ")) {
            for (Map.Entry entry : this.C.entrySet()) {
                ItemStackBuilder_4 itemStackBuilder_4 = (ItemStackBuilder_4)entry.getValue();
                if (itemStackBuilder_4 instanceof LocationBridgeBuilder_2) {
                    LocationBridgeBuilder_2 locationBridgeBuilder_2 = (LocationBridgeBuilder_2)itemStackBuilder_4;
                    if (locationBridgeBuilder_2.FD != null && locationBridgeBuilder_2.FD.oX()) continue;
                }
                linkedList.add((String)entry.getKey());
            }
            return linkedList;
        }
        string = ItemStackRegistry.j(string);
        for (Map.Entry entry : this.C.entrySet()) {
            Object object;
            ItemStackBuilder_4 itemStackBuilder_4 = (ItemStackBuilder_4)entry.getValue();
            if (itemStackBuilder_4 instanceof LocationBridgeBuilder_2) {
                object = (LocationBridgeBuilder_2)itemStackBuilder_4;
                if (((LocationBridgeBuilder_2)object).FD != null && ((LocationBridgeBuilder_2)object).FD.oX()) continue;
            }
            if (!((String)(object = ItemStackRegistry.j((String)entry.getKey()))).contains(string)) continue;
            linkedList.add((String)entry.getKey());
        }
        return linkedList;
    }

    private static String j(String string) {
        return string.toLowerCase().replace(":", "").replace("_", "").replace("-", "");
    }

    public List k(String string) {
        if (string == null || string.isEmpty() || string.equals(" ")) {
            return new ArrayList(WorldBridge_11.Oz.keySet());
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : WorldBridge_11.Oz.keySet()) {
            if (!string2.contains(string)) continue;
            arrayList.add(string2);
        }
        return arrayList;
    }

    public List a(Material material, String string) {
        if (!this.O.containsKey(material)) {
            return new ArrayList();
        }
        if (string == null || string.isEmpty() || string.equals(" ")) {
            return new ArrayList(((HashMap)this.O.get(material)).keySet());
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : ((HashMap)this.O.get(material)).keySet()) {
            if (!string2.contains(string)) continue;
            arrayList.add(string2);
        }
        return arrayList;
    }

    public List l(String string) {
        if (string == null || string.isEmpty() || string.equals(" ")) {
            return this.am.vH;
        }
        LinkedList<String> linkedList = new LinkedList<String>();
        for (String string2 : this.am.vH) {
            if (!string2.contains(string)) continue;
            linkedList.add(string2);
        }
        return linkedList;
    }

    @Nullable
    public ItemStack m(String string) {
        if (string != null && this.f(string)) {
            ItemStackBuilder_4 itemStackBuilder_4 = this.e(string);
            if (itemStackBuilder_4 == null) {
                return null;
            }
            itemStackBuilder_4 = itemStackBuilder_4.clone();
            MmoItemsHook.injectMmoItem(itemStackBuilder_4);
            return itemStackBuilder_4;
        }
        return null;
    }

    @Deprecated
    @Nullable
    public Object d(String string, @Nullable String string2) {
        if (string != null) {
            @Nullable Material material = SoundCategoryBridge.ig(string);
            if (material != null) {
                return material;
            }
            if (this.f(string)) {
                return this.e(string).mO();
            }
        }
        if (string2 != null) {
            CommandSenderBridge_5.warn("Can't find item '" + string + "' to load some settings. File '" + string2 + "'");
            return ItemStackRegistry.l();
        }
        return null;
    }

    @Nullable
    public ItemStackBridge_37 e(String string, @Nullable String string2) {
        if (string != null) {
            @Nullable Material material = SoundCategoryBridge.ig(string);
            if (material != null) {
                return new MaterialBridge_19(material);
            }
            if (this.f(string)) {
                return new ItemStackBridge_38(this.e(string));
            }
        }
        if (string2 != null) {
            CommandSenderBridge_5.warn("Can't find item '" + string + "' to load some settings. File '" + string2 + "'");
            return new MaterialBridge_19(ItemStackRegistry.l());
        }
        return null;
    }

    public ItemStackBridge_37 n(String string) {
        return this.e(string, null);
    }

    @Nullable
    public ItemStack f(String string, String string2) {
        if (string != null) {
            @Nullable Material material = SoundCategoryBridge.ig(string);
            if (material != null) {
                return new ItemStack(material);
            }
            ItemStackBuilder_4 itemStackBuilder_4 = this.e(string);
            if (itemStackBuilder_4 == null) {
                return null;
            }
            return itemStackBuilder_4.mP();
        }
        if (string2 != null) {
            CommandSenderBridge_5.warn("Can't find item '" + string + "' to load some settings. File '" + string2 + "'");
            return new ItemStack(ItemStackRegistry.l());
        }
        return null;
    }

    @Nullable
    public ItemStack o(String string) {
        if (string != null) {
            @Nullable Material material = SoundCategoryBridge.ig(string);
            if (material != null) {
                return new ItemStack(material);
            }
            ItemStackBuilder_4 itemStackBuilder_4 = this.e(string);
            if (itemStackBuilder_4 == null) {
                return null;
            }
            return itemStackBuilder_4;
        }
        return null;
    }

    @Nullable
    public ItemStack q(String string) {
        return this.f(string, null);
    }

    public static boolean a(ItemStack itemStack, ItemStack itemStack2) {
        if (ItemStackBridge_2.at(itemStack) && ItemStackBridge_2.at(itemStack2)) {
            return true;
        }
        if (itemStack == null || itemStack2 == null) {
            return false;
        }
        if (itemStack.getType() != itemStack2.getType()) {
            return false;
        }
        if (itemStack.hasItemMeta() != itemStack2.hasItemMeta()) {
            return false;
        }
        if (ItemStackBuilder_4.s(itemStack) && ItemStackBuilder_4.s(itemStack2)) {
            return ItemStackBuilder_4.b(itemStack, itemStack2);
        }
        return itemStack.isSimilar(itemStack2);
    }

    public ItemStack a(Player player, Material material) {
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        ItemStack itemStack2 = player.getInventory().getItemInOffHand();
        if (itemStack.getType() == material) {
            if (ItemStackBuilder_4.isCustomItem(itemStack)) {
                return itemStack;
            }
            if (itemStack2.getType() == material && ItemStackBuilder_4.isCustomItem(itemStack2)) {
                return itemStack2;
            }
        }
        return null;
    }

    public BlockBridge_9 a(Chunk chunk) {
        return this.ap.m(chunk);
    }

    public BlockBridge_9 b(Block block) {
        return this.ap.b(block);
    }

    public BlockBridge_9 a(Location location) {
        return this.ap.D(location);
    }

    public BlockBridge_9 a(World world, int n2, int n3) {
        return this.ap.a(world, n2, n3);
    }

    public static boolean isCustomBlock(Block block) {
        return e.b(block).isCustomBlock(block);
    }

    @Nullable
    public static String c(Block block) {
        return e.b(block).Y(block);
    }

    @Nullable
    public static LocationBridgeBuilder_2 d(Block block) {
        String string = ItemStackRegistry.c(block);
        if (string == null) {
            return null;
        }
        return ItemStackRegistry.g().h(string);
    }

    public static boolean e(Block block) {
        BlockBridge_9 blockBridge_9 = e.b(block);
        return blockBridge_9.aa(block) != null;
    }

    public static boolean b(Location location) {
        return PlayerJoinListener_5.lF().b(location);
    }

    public static void A() {
        if (MaterialBarColorHolder.fX) {
            if (!Bukkit.getServer().isAcceptingTransfers()) {
                CommandSenderBridge_5.warn("Temporarily enabling 'accepts-transfers' to automatically re-join players after content refresh.");
            }
            Bukkit.getOnlinePlayers().forEach(player -> PacketListenerRegistry.uN().a((Player)player, MaterialBarColorHolder.fZ, MaterialBarColorHolder.ga));
        } else if (MaterialBarColorHolder.fY) {
            Bukkit.getOnlinePlayers().forEach(player -> {
                if (VersionHelper_3.sZ()) {
                    player.kick(Main.PQ.it("server-content-changed-join-again"));
                } else {
                    player.kickPlayer(PluginBridge_6.u(Main.PQ.it("server-content-changed-join-again")));
                }
            });
        }
    }

    public static String a(List list, int n2, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = list.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            PluginContract_20 pluginContract_20 = (PluginContract_20)list.get(i2);
            if (i2 > n2) {
                stringBuilder.setLength(stringBuilder.length() - 2);
                stringBuilder.append(string);
                return stringBuilder.toString();
            }
            stringBuilder.append(pluginContract_20.getNamespacedID()).append(", ");
        }
        return stringBuilder.toString();
    }

    public boolean B() {
        for (Map.Entry entry : this.C.entrySet()) {
            ItemStackBuilder_4 itemStackBuilder_4 = (ItemStackBuilder_4)entry.getValue();
            if (!itemStackBuilder_4.mV() || !itemStackBuilder_4.nk().isVisible()) continue;
            return true;
        }
        return false;
    }

    @Nullable
    public static File r(String string) {
        return Assets.a(ItemStackRegistry.e.y, string);
    }

    public static String g(@Nullable String string, String string2) {
        return Json.g(string, string2);
    }

    public static String h(@Nullable String string, String string2) {
        return Json.h(string, string2);
    }

    public static String a(int n2, @Nullable String string, String string2) {
        return Json.a(n2, string, string2);
    }

    @Nullable
    public static File s(String string) {
        return Assets.a(ItemStackRegistry.e.x, ItemStackRegistry.e.w, string);
    }

    @Nullable
    public static File t(String string) {
        String string2 = ItemStackRegistry.g(null, string);
        if (string2 == null) {
            return null;
        }
        string2 = ColorBridge.iR(string2);
        return ItemStackRegistry.s(string2);
    }

    @Nullable
    public static File u(String string) {
        String string2 = ItemStackRegistry.h(null, string);
        if (string2 == null) {
            return null;
        }
        string2 = ColorBridge.iR(string2);
        return ItemStackRegistry.s(string2);
    }

    public static List v(String string) {
        return Assets.b(ItemStackRegistry.e.x, ItemStackRegistry.e.w, string);
    }

    public static List a(File file) {
        return Assets.a(file);
    }

    public static List C() {
        return Assets.a(ItemStackRegistry.g().x);
    }

    public static List D() {
        return Assets.b(ItemStackRegistry.g().x);
    }

    private void d(boolean bl) {
        this.w = Assets.a(l, p);
        this.x = Assets.a(l, p, o);
        this.y = Assets.b(l, p, n);
        this.z = Assets.b(p, o);
        if (bl && this.z) {
            CommandSenderBridge_5.warn("Detected legacy ItemsAdder pack (pre 3.3.0). Loading anyway. Info: https://a.devs.beer/ia-new-guidelines-330");
        }
    }

    public int a(int n2) {
        for (Map.Entry entry : this.H.entrySet()) {
            for (Map.Entry entry2 : ((HashMap)entry.getValue()).entrySet()) {
                if (((ItemStackBuilder_4)entry2.getValue()).fX() != n2) continue;
                return (Integer)entry2.getKey();
            }
        }
        throw new IllegalArgumentException("Armor color not found for custom model data " + n2);
    }

    public RecordOfNamespacedKey_2 a(NamespacedKey namespacedKey) {
        return (RecordOfNamespacedKey_2)this.ad.get(namespacedKey);
    }

    public void a(ItemStackBuilder_4 itemStackBuilder_4) {
        this.D.remove(itemStackBuilder_4.Gi);
        this.C.remove(itemStackBuilder_4.getNamespacedID());
        this.E.remove(itemStackBuilder_4.getId());
        ((HashMap)this.O.get(itemStackBuilder_4.getType())).remove(itemStackBuilder_4.getNamespacedID());
        if (((HashMap)this.O.get(itemStackBuilder_4.getType())).isEmpty()) {
            this.O.remove(itemStackBuilder_4.getType());
        }
        this.F.remove(itemStackBuilder_4.getNamespacedID());
        this.G.remove(itemStackBuilder_4.getId());
    }

    @Generated
    public Map E() {
        return this.J;
    }

    @Generated
    public void a(Map map) {
        this.J = map;
    }

    @Generated
    public Map F() {
        return this.ad;
    }

    @Generated
    public List G() {
        return this.ae;
    }

    @Generated
    public WorldSaveListener H() {
        return this.ap;
    }

    static {
        g = Main.rS().getDataFolder().getAbsolutePath();
        i = g + "/storage/";
        k = g + "/output/generated.zip";
        l = g + "/contents/";
        m = l + "vanilla/resourcepack/";
        n = g + "/data/resource_pack/";
        o = n + "assets/";
        p = g + "/data/items_packs/";
        s = new HashSet();
        t = new HashSet();
        ai = new HashMap();
        aj = new ArrayList();
    }
}
