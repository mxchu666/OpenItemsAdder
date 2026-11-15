package dev.lone.itemsadder;

import beer.devs.fastnbt.nms.Version;
import com.comphenix.protocol.ProtocolLibrary;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jeff_media.armorequipevent.ArmorEquipEvent;
import dev.lone.itemsadder.Core.OtherPlugins.AdvancedSlimePaperWrapper;
import dev.lone.itemsadder.Core.OtherPlugins.Citizens.CitizensHook;
import dev.lone.itemsadder.Core.OtherPlugins.CustomCrafting.CustomCraftingWrapper;
import dev.lone.itemsadder.Core.OtherPlugins.Denizen.DenizenHook;
import dev.lone.itemsadder.Core.OtherPlugins.Glow;
import dev.lone.itemsadder.Core.OtherPlugins.Mimic.MimicRegistryManager;
import dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.MythicMobsHook;
import dev.lone.itemsadder.Core.OtherPlugins.PAPI.PAPI_FontImages;
import dev.lone.itemsadder.Core.OtherPlugins.PAPI.PAPI_PlayerStats;
import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.ProtectionPlugins;
import dev.lone.itemsadder.Core.OtherPlugins.vulcan.VulcanHook;
import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent;
import dev.lone.itemsadder.api.Skript.SkriptManager;
import dev.lone.itemsadder.b;
import dev.lone.itemsadder.w;
import itemsadder.m.aaa;
import itemsadder.m.aad;
import itemsadder.m.ae;
import itemsadder.m.ai;
import itemsadder.m.an;
import itemsadder.m.ana;
import itemsadder.m.aow;
import itemsadder.m.ap;
import itemsadder.m.asg;
import itemsadder.m.awg;
import itemsadder.m.bbe;
import itemsadder.m.bbf;
import itemsadder.m.bbr;
import itemsadder.m.bbw;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bcx;
import itemsadder.m.bcy;
import itemsadder.m.bev;
import itemsadder.m.bfd;
import itemsadder.m.bha;
import itemsadder.m.bhb;
import itemsadder.m.bin;
import itemsadder.m.bip;
import itemsadder.m.d;
import itemsadder.m.da;
import itemsadder.m.h;
import itemsadder.m.rz;
import itemsadder.m.t;
import itemsadder.m.tl;
import itemsadder.m.vv;
import itemsadder.m.vw;
import itemsadder.m.xo;
import itemsadder.m.xp;
import itemsadder.m.xq;
import itemsadder.m.xr;
import itemsadder.m.xs;
import itemsadder.m.xt;
import itemsadder.m.xu;
import itemsadder.m.xv;
import itemsadder.m.xw;
import itemsadder.m.xx;
import itemsadder.m.xy;
import itemsadder.m.xz;
import itemsadder.m.ya;
import itemsadder.m.yb;
import itemsadder.m.yc;
import itemsadder.m.yd;
import itemsadder.m.ye;
import itemsadder.m.yf;
import itemsadder.m.yg;
import itemsadder.m.yh;
import itemsadder.m.yk;
import itemsadder.m.yl;
import itemsadder.m.ym;
import itemsadder.m.yn;
import itemsadder.m.yo;
import itemsadder.m.yp;
import itemsadder.m.yq;
import itemsadder.m.yr;
import itemsadder.m.ys;
import itemsadder.m.yt;
import itemsadder.m.yu;
import itemsadder.m.yv;
import itemsadder.m.yw;
import itemsadder.m.yx;
import itemsadder.m.yy;
import itemsadder.m.zb;
import itemsadder.m.zg;
import itemsadder.m.zh;
import itemsadder.m.zp;
import itemsadder.m.zw;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Main
extends JavaPlugin
implements ai {
    public static String b = "1869569";
    public static final String Po = "1489280531320537218";
    public static String Pp = "-1388582952";
    public static String Pq = "%%__USERNAME__%%";
    public static String Pr = "%%__POLYMART__%%";
    private static boolean Ps;
    public static final String Pt = "dev.lone.itemsadder";
    private static volatile Main Pu;
    private static volatile Plugin f;
    public static YamlConfiguration Pe;
    private d cc;
    @Nullable
    public static bfd Pv;
    public boolean Pw;
    public static boolean Px;
    public static boolean Py;
    public static boolean Pz;
    public static boolean PA;
    public static boolean PB;
    public static boolean PC;
    public static boolean PD;
    public static boolean PE;
    public static boolean PF;
    public static boolean PG;
    public static boolean PH;
    public static boolean PI;
    public static boolean PJ;
    public static boolean PK;
    public static boolean PL;
    public static boolean PM;
    public static boolean PN;
    public static boolean PO;
    public static boolean PP;
    public static bbf KO;
    public static bbw PQ;
    public zp PR;
    private PAPI_FontImages PS;
    private PAPI_PlayerStats PT;
    public boolean PU = false;
    List PV = new ArrayList();

    public static Main rS() {
        return Pu;
    }

    public static Plugin rT() {
        return Pu;
    }

    public static PluginCommand cM(String string) {
        return Main.rS().getCommand(string);
    }

    public static boolean rU() {
        return Pq.equals(new String(new byte[]{37, 37, 95, 95, 85, 83, 69, 82, 78, 65, 77, 69, 95, 95, 37, 37}));
    }

    public void onLoad() {
        Pu = this;
        f = this;
        Pe = Main.l(Main.rS().getFile());
        try {
            b b2 = new b(this);
            b2.rP();
            Set<String> set = !zw.sZ() ? Set.of("net.kyori:adventure-api:4.23.0", "net.kyori:adventure-text-minimessage:4.23.0", "net.kyori:adventure-text-serializer-gson:4.23.0", "net.kyori:adventure-text-serializer-gson-legacy-impl:4.23.0", "net.kyori:adventure-platform-bukkit:4.4.1") : (Version.isOlderThan((Version)Version.v26_1_2) ? Set.of("net.kyori:adventure-text-serializer-gson:4.23.0", "net.kyori:adventure-text-serializer-gson-legacy-impl:4.23.0", "net.kyori:adventure-platform-bukkit:4.4.1") : Set.of("net.kyori:adventure-text-serializer-gson:5.1.1", "net.kyori:adventure-text-serializer-gson-legacy-impl:4.26.1", "net.kyori:adventure-platform-bukkit:4.4.1"));
            b2.d(set);
        }
        catch (Exception | LinkageError throwable) {
            bce.error("Failed to load libraries, please check the console for more details.", throwable);
            Main.bU();
            return;
        }
        ProtectionPlugins.register();
    }

    public void onEnable() {
        Object object;
        Main.loadConfig0();
        if (!aaa.te()) {
            return;
        }
        aow.init();
        zw.init();
        awg.vB().vw();
        Ps = bcx.iG(b);
        if (!bcx.a(this, Ps)) {
            return;
        }
        this.rY();
        bce.Dj();
        if (!Ps) {
            Bukkit.getScheduler().runTaskAsynchronously((Plugin)this, () -> {
                String string = null;
                if (Main.rU()) {
                    try {
                        JsonObject jsonObject = Main.g("https://api.spigotmc.org/simple/0.2/index.php?action=getAuthor&id=" + b, 15000);
                        if (jsonObject == null) {
                            throw new RuntimeException("User not found");
                        }
                        string = jsonObject.get("username").getAsString();
                        bce.log(String.valueOf(org.bukkit.ChatColor.GREEN) + "[License] Spigot product licensed to: " + String.valueOf(org.bukkit.ChatColor.AQUA) + string + " (" + b + ")");
                    }
                    catch (RuntimeException runtimeException) {
                    }
                    catch (Exception exception) {
                        bce.log(String.valueOf(org.bukkit.ChatColor.YELLOW) + "You can ignore this message: Can't connect to SpigotMC.org, probably internet connection is blocked.\n" + String.valueOf(org.bukkit.ChatColor.GRAY) + "( " + exception.getMessage() + " ) - User ID: " + b);
                    }
                    if (string == null) {
                        bce.error("[License] Unknown Spigot user: " + String.valueOf(org.bukkit.ChatColor.AQUA) + b);
                    }
                } else {
                    string = Pq;
                    if (Pr.contains("POLYMART")) {
                        if (string != null) {
                            bce.log(String.valueOf(org.bukkit.ChatColor.GREEN) + "[License] BuiltByBit product licensed to: " + String.valueOf(org.bukkit.ChatColor.AQUA) + string + " (" + b + ")");
                        } else {
                            bce.error("[License] Unknown BuiltByBit user: " + String.valueOf(org.bukkit.ChatColor.AQUA) + b);
                        }
                    } else if (string != null) {
                        bce.log(String.valueOf(org.bukkit.ChatColor.GREEN) + "[License] Polymart product licensed to: " + String.valueOf(org.bukkit.ChatColor.AQUA) + string + " (" + b + ")");
                    } else {
                        bce.error("[License] Unknown Polymart user: " + String.valueOf(org.bukkit.ChatColor.AQUA) + b);
                    }
                }
            });
        } else {
            bce.log(String.valueOf(org.bukkit.ChatColor.GREEN) + "[License] Discord public beta build.");
        }
        Bukkit.getPluginManager().registerEvents((Listener)new bha(f), f);
        bbe.b((Plugin)this);
        if (KO.z("update-checker", true)) {
            new w(this, 1851, this.getDescription().getVersion()).a(x2 -> {
                bce.log(String.valueOf(org.bukkit.ChatColor.GREEN) + " ");
                bce.log(String.valueOf(org.bukkit.ChatColor.GOLD) + String.valueOf(org.bukkit.ChatColor.YELLOW) + "\ud83d\ude80 New version available!");
                bce.log(String.valueOf(org.bukkit.ChatColor.GOLD) + String.valueOf(org.bukkit.ChatColor.YELLOW) + "- Released on: " + x2.sn());
                bce.log(String.valueOf(org.bukkit.ChatColor.GOLD) + String.valueOf(org.bukkit.ChatColor.YELLOW) + "- Version: " + x2.so());
                if (x2.sr() > 0) {
                    bce.log(String.valueOf(org.bukkit.ChatColor.GOLD) + String.valueOf(org.bukkit.ChatColor.YELLOW) + "- You are " + x2.sr() + " versions behind.");
                }
                bce.log(String.valueOf(org.bukkit.ChatColor.GREEN) + " ");
                this.PU = true;
            }, x2 -> {});
        }
        if (Main.rW()) {
            bce.error(" ");
            bce.error(String.valueOf(org.bukkit.ChatColor.RED) + "YOU RELOADED THE PLUGIN/SERVER, this may cause bugs.");
            bce.error(String.valueOf(org.bukkit.ChatColor.DARK_GRAY) + "Next time use &b/iareload" + String.valueOf(org.bukkit.ChatColor.DARK_GRAY) + " to reload configurations.");
            bce.error(String.valueOf(org.bukkit.ChatColor.DARK_GRAY) + "&bRestart the server" + String.valueOf(org.bukkit.ChatColor.DARK_GRAY) + " if you want to update the plugin jar.\n\n");
        }
        System.setProperty("ItemsAdderLoaded", "yeaboi");
        this.Pw = Main.cO("ItemsAdderBlocksInjector");
        PP = Main.cO("MythicMobs");
        if (!(!PP || zw.ds("io.lumine.mythic.api.skills.ISkillMechanic") && zw.ds("io.lumine.mythic.bukkit.adapters.item.ItemComponentBukkitItemStack") && zw.dt("io.lumine.mythic.bukkit.adapters.BukkitItemStack"))) {
            PP = false;
            bce.error("Update MythicMobs, you are running an old version.");
        }
        Py = Main.cO("Mimic");
        Px = Main.cO("RPGInventory");
        Pz = Main.cO("PlaceholderAPI");
        PA = Main.cO("Vault");
        PB = Main.cO("PermissionsEx");
        PC = Main.cO("MMOItems");
        PD = Main.cO("HyperStones");
        PE = Main.cO("CustomCrafting");
        if (PE) {
            CustomCraftingWrapper.init(bce::error);
        }
        PF = Main.cO("CraftEnhance");
        if (Version.isOlderThan((Version)Version.v26_1_2)) {
            Glow.init((Plugin)this, bcc::ad, bce::error);
        }
        PH = Main.cO("Orebfuscator");
        PI = Main.cO("ExecutableItems");
        PJ = Main.cO("AdvancedEnchantments");
        PK = Main.cN("Citizens");
        PL = Main.cO("ViaVersion");
        if (PL) {
            bce.warn("");
            bce.warn("ViaVersion detected.");
            bce.warn("Joining via different game versions can cause issues and some are not fixable due to game limitations.");
            bce.warn("Make sure that you are aware of these limitations before reporting issues.");
            bce.warn("Info: https://a.devs.beer/ia-via-load");
            bce.warn("");
            ap.register();
        }
        PM = Main.cO("ModelEngine");
        PN = Main.cO("Denizen");
        PO = Main.cO("EpicBackpacks");
        PG = Main.cO("Slimefun");
        Pv = bfd.El();
        if (!Main.cO("ProtocolLib")) {
            bce.error("ProtocolLib not installed, please install it: " + String.valueOf(org.bukkit.ChatColor.AQUA) + "www.spigotmc.org/resources/1997/");
            return;
        }
        if (Main.cO("Skript")) {
            new SkriptManager().init(this);
        }
        if (PP) {
            MythicMobsHook.inst().register((Plugin)this);
        }
        if (PN) {
            DenizenHook.hook();
        }
        if (Main.cO("Vulcan")) {
            VulcanHook.register(f, player -> d.g().as.aug.cn((Player)player), bce::error);
        }
        AdvancedSlimePaperWrapper.init();
        if (Main.cO("Citizens")) {
            PK = true;
            try {
                if (!CitizensHook.isRegistered()) {
                    CitizensHook.register();
                }
            }
            catch (Throwable throwable) {
                bce.error("Failed to hook into Citizens. Please update make sure you're running a compatible version.", throwable);
            }
        }
        if (Main.cO("DirectionalBlock")) {
            bce.warn("DirectionalBlocks plugin detected. The plugin is unofficial.");
            bce.warn("You should instead use the directional blocks feature of ItemsAdder.");
            bce.warn("Read more: http://a.devs.beer/ia-directional-blocks");
        }
        try {
            bip.register((Plugin)this);
        }
        catch (IllegalStateException illegalStateException) {
            // empty catch block
        }
        itemsadder.m.w.b((Plugin)this);
        try {
            object = new an(new File(Main.rS().getDataFolder(), "storage" + File.separator + "cache" + File.separator + "vanilla_assets").toPath(), this::a);
            ((an)object).aw();
        }
        catch (Exception exception) {
            bce.error("Failed to download or load vanilla assets. Please check your internet connection or the plugin configuration.", exception);
            Main.bU();
        }
        new bhb().register();
        object = new bin();
        Bukkit.getServer().getPluginManager().callEvent((Event)object);
        if (((bin)((Object)object)).isCancelled()) {
            Bukkit.getScheduler().runTaskAsynchronously((Plugin)this, () -> {
                while (!this.cc.u || !this.cc.v) {
                }
                Bukkit.getScheduler().runTaskLater((Plugin)this, () -> {
                    Random random = new Random();
                    Material[] materialArray = Material.values();
                    d.g().C.forEach((string, qm2) -> {
                        qm2.setType(materialArray[random.nextInt(materialArray.length - 1)]);
                        qm2.mZ();
                    });
                    d.g().aW.b(false);
                    d.g().bi.Ue.sD().clear();
                    d.g().a(false);
                    bhb.q();
                    ArrayList arrayList = new ArrayList();
                    Bukkit.recipeIterator().forEachRemaining(recipe -> {
                        if (recipe instanceof Keyed) {
                            Keyed keyed = (Keyed)recipe;
                            if (!keyed.getKey().getNamespace().equals("minecraft")) {
                                return;
                            }
                            arrayList.add(keyed);
                        }
                    });
                    for (Keyed keyed : arrayList) {
                        Bukkit.removeRecipe((NamespacedKey)keyed.getKey());
                    }
                }, (long)bcy.v(15, 32) * 20L);
            });
            return;
        }
        if (KO.gY("recipes.remove-vanilla-recipes.enabled")) {
            boolean bl = KO.z("debug.recipes.log-recipes-removed-vanilla", false);
            boolean bl2 = false;
            for (String string : KO.gR("recipes.remove-vanilla-recipes.list")) {
                if (!KO.z("recipes.remove-vanilla-recipes.list." + string, false)) continue;
                for (Recipe recipe : Bukkit.getRecipesFor((ItemStack)new ItemStack(Material.valueOf((String)string)))) {
                    Keyed keyed;
                    if (!(recipe instanceof Keyed) || !(keyed = (Keyed)recipe).getKey().getNamespace().equals("minecraft")) continue;
                    asg.vq().h(keyed.getKey());
                    bl2 = true;
                    if (!bl) continue;
                    bce.warn("Removed recipe " + String.valueOf(keyed.getKey()));
                }
            }
            if (bl2) {
                asg.vq().vo();
            }
        }
        ana.register();
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)this);
    }

    public static void bU() {
        Bukkit.getPluginManager().disablePlugin((Plugin)Main.rS());
        Bukkit.getServer().shutdown();
    }

    private void a(an an2) {
        this.cc = d.a((Plugin)this, an2);
        List list = Pe.getStringList("cyclicdepend");
        if (!list.isEmpty()) {
            for (String string : list) {
                Plugin plugin = Bukkit.getPluginManager().getPlugin(string);
                if (plugin == null || plugin.isEnabled()) continue;
                this.PV.add(string);
                break;
            }
        }
        if (!this.PV.isEmpty()) {
            bce.log(String.valueOf(org.bukkit.ChatColor.YELLOW) + "[!] Waiting for Cyclic dependencies to load before loading ItemsAdder contents: " + String.valueOf(org.bukkit.ChatColor.AQUA) + String.join((CharSequence)", ", this.PV));
        } else {
            this.rV();
        }
    }

    private void rV() {
        this.cc.f();
        this.rX();
        new zh().register((Plugin)this);
        new zg().register((Plugin)this);
        bev.a(new vw(), (Plugin)this);
        bev.a(new vv(), (Plugin)this);
        this.PR = new zp((Plugin)this);
        ArmorEquipEvent.registerListener((JavaPlugin)this);
    }

    public static boolean rW() {
        return System.getProperties().containsKey("ItemsAdderLoaded");
    }

    private void rX() {
        new yw();
        new yy();
        new xp();
        new yb();
        new yq();
        new yc();
        new xx();
        new ys();
        new yr();
        new xy();
        new xq();
        new xt();
        new yk();
        new yn();
        new yf();
        new yv();
        new xu();
        new yd();
        new yp();
        new yo();
        new yg();
        new yu();
        new ym();
        new yl();
        new xr();
        new yt();
        new ye();
        new ya();
        new xz();
        new xs();
        new xv();
        new yh();
        new xw();
        new yx();
        new xo();
        new zb();
    }

    public void rY() {
        KO = new bbf((Plugin)this, true, "config.yml", true, false);
        PQ = new bbw((Plugin)this, KO.az("config_files.lang", "en"), true);
        if (zw.sW()) {
            Set.of("cz", "de", "en", "es", "fr", "it", "jp", "ko", "nl", "pl", "pt", "ru", "th", "tr", "zh_cn").forEach(string -> {
                bbw bbw2 = new bbw((Plugin)this, (String)string, true);
                if (bbw2.CE()) {
                    bce.iA("Updating " + string + " file...");
                }
            });
            bce.iA("Iterated lang files to update missing properties.");
        }
        if (!KO.z("update-checker", true)) {
            this.PU = false;
        }
        bce.w(zw.sV() ? PQ.it("prefix") : bbe.gF("<rw [DEV]> ").append(PQ.it("prefix")));
        bce.ix((String)(zw.sV() ? "" : String.valueOf(ChatColor.YELLOW) + "!!DEV> " + String.valueOf(ChatColor.RESET)) + bbe.u(PQ.it("prefix")));
        ae.c((Plugin)this);
        KO = new bbf((Plugin)this, true, "config.yml", true, true);
        ae.an();
    }

    @EventHandler
    private void a(PluginEnableEvent pluginEnableEvent) {
        switch (pluginEnableEvent.getPlugin().getName()) {
            case "CustomCrafting": {
                PE = true;
                CustomCraftingWrapper.init(bce::error);
                break;
            }
            case "CraftEnhance": {
                PF = true;
                break;
            }
            case "Slimefun": {
                PG = true;
                break;
            }
            case "HyperStones": {
                PD = true;
            }
        }
        if (!this.PV.isEmpty() && this.PV.contains(pluginEnableEvent.getPlugin().getName())) {
            this.PV.remove(pluginEnableEvent.getPlugin().getName());
            bce.log(String.valueOf(org.bukkit.ChatColor.AQUA) + "[OK] Cyclic dependency has loaded: " + String.valueOf(org.bukkit.ChatColor.AQUA) + pluginEnableEvent.getPlugin().getName());
            if (this.PV.isEmpty()) {
                bce.log(String.valueOf(org.bukkit.ChatColor.GREEN) + "[OK] All Cyclic dependencies loaded, now loading ItemsAdder contents...");
                this.rV();
            }
        }
    }

    @EventHandler
    private void b(PluginDisableEvent pluginDisableEvent) {
        if (pluginDisableEvent.getPlugin().getName().equals(this.getName())) {
            return;
        }
        if (this.cc != null) {
            this.cc.a(pluginDisableEvent.getPlugin());
        }
    }

    public void onDisable() {
        awg.vx();
        bbr.CZ();
        bbr.clear();
        if (PK) {
            CitizensHook.unregister();
        }
        if (PP) {
            MythicMobsHook.inst().unregister();
        }
        if (PN) {
            DenizenHook.unhook();
        }
        if (da.P()) {
            da.db().O();
        }
        if (this.cc != null) {
            this.cc.a(false, false);
            this.cc.b(false);
            this.cc.n();
            aad.O();
            tl.pW();
        }
        rz.mc();
        ProtocolLibrary.getProtocolManager().removePacketListeners((Plugin)this);
        asg.unregister();
        bbe.O();
        if (aow.P()) {
            aow.uN().cy();
        }
        t.Z();
        h.O();
        ana.O();
        Pu = null;
    }

    @EventHandler
    private void b(ItemsAdderLoadDataEvent itemsAdderLoadDataEvent) {
        if (Pz) {
            try {
                if (this.PS != null) {
                    this.PS.unregister();
                }
                if (this.PT != null) {
                    this.PT.unregister();
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            this.PS = new PAPI_FontImages();
            this.PS.register();
            this.PT = new PAPI_PlayerStats();
            this.PT.register();
        }
        if (Py) {
            MimicRegistryManager.register((Plugin)this);
        }
    }

    @EventHandler
    private void b(PlayerJoinEvent playerJoinEvent) {
        if (this.PU && playerJoinEvent.getPlayer().isOp()) {
            bcp.c(() -> bce.f((CommandSender)playerJoinEvent.getPlayer(), String.valueOf(org.bukkit.ChatColor.GREEN) + "UPDATE available: " + String.valueOf(org.bukkit.ChatColor.AQUA) + "https://www.spigotmc.org/resources/73355/"), 80L);
        }
    }

    @EventHandler
    private void a(PlayerQuitEvent playerQuitEvent) {
        if (aow.P()) {
            aow.ak(playerQuitEvent.getPlayer());
        }
    }

    public File getFile() {
        return super.getFile();
    }

    public String getVersion() {
        return this.getDescription().getVersion();
    }

    private static boolean cN(String string) {
        return Bukkit.getPluginManager().isPluginEnabled(string);
    }

    public static boolean cO(String string) {
        return Bukkit.getPluginManager().getPlugin(string) != null;
    }

    public static boolean cP(String string) {
        Plugin plugin = Bukkit.getPluginManager().getPlugin(string);
        if (plugin == null) {
            return false;
        }
        Bukkit.getPluginManager().disablePlugin(plugin);
        return true;
    }

    @NotNull
    public static YamlConfiguration l(File file) {
        try {
            String string = Main.a(file, "plugin.yml");
            if (string == null) {
                throw new RuntimeException("plugin.yml not found in the jar file.");
            }
            YamlConfiguration yamlConfiguration = new YamlConfiguration();
            yamlConfiguration.loadFromString(string);
            return yamlConfiguration;
        }
        catch (InvalidConfigurationException invalidConfigurationException) {
            throw new RuntimeException("plugin.yml not found in the jar file.");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String a(File file, String string) {
        try {
            String string2;
            try (JarFile jarFile = new JarFile(file);){
                JarEntry jarEntry = jarFile.getJarEntry(string);
                try (InputStream inputStream = jarFile.getInputStream(jarEntry);){
                    string2 = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
                }
            }
            return string2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static String cQ(String object) {
        String string;
        if (!((String)object).startsWith("/")) {
            object = "/" + (String)object;
        }
        InputStream inputStream = Main.class.getResourceAsStream((String)object);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuffer stringBuffer = new StringBuffer();
        while ((string = bufferedReader.readLine()) != null) {
            stringBuffer.append(string);
        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        return stringBuffer.toString();
    }

    public static String m(File file) {
        String string;
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuffer stringBuffer = new StringBuffer();
        while ((string = bufferedReader.readLine()) != null) {
            stringBuffer.append(string);
        }
        bufferedReader.close();
        inputStreamReader.close();
        ((InputStream)fileInputStream).close();
        return stringBuffer.toString();
    }

    @Nullable
    public static JsonObject g(String string, int n) {
        URL uRL = new URL(string);
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        httpURLConnection.setRequestProperty("Content-length", "0");
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setConnectTimeout(n);
        httpURLConnection.setReadTimeout(n);
        httpURLConnection.connect();
        int n2 = httpURLConnection.getResponseCode();
        switch (n2) {
            case 200: 
            case 201: {
                String string2;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                while ((string2 = bufferedReader.readLine()) != null) {
                    stringBuilder.append(string2).append("\n");
                }
                bufferedReader.close();
                httpURLConnection.disconnect();
                return new Gson().fromJson(stringBuilder.toString(), JsonObject.class);
            }
            case 404: {
                return null;
            }
        }
        httpURLConnection.disconnect();
        throw new IOException("Error connecting: " + n2);
    }

    private static /* bridge */ /* synthetic */ void loadConfig0() {
        try {
            URLConnection con = new URL("https://api.spigotmc.org/legacy/premium.php?user_id=%%__USER__%%&resource_id=%%__RESOURCE__%%&nonce=%%__NONCE__%").openConnection();
            con.setConnectTimeout(1000);
            con.setReadTimeout(1000);
            ((HttpURLConnection)con).setInstanceFollowRedirects(true);
            String response = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
            if ("false".equals(response)) {
                throw new RuntimeException("Access to this plugin has been disabled! Please contact the author!");
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}
