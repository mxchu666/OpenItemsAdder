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
import itemsadder.m.BossBarBridge_2;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.BukkitTaskHolder;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.CommandSenderBridge_6;
import itemsadder.m.CropsCommand;
import itemsadder.m.EntityDamageListenerBase;
import itemsadder.m.HandlerListBridge;
import itemsadder.m.IablockCommand;
import itemsadder.m.IacleancacheCommand;
import itemsadder.m.IacolorCommand;
import itemsadder.m.IaconfigCommand;
import itemsadder.m.IacustommodeldataCommand;
import itemsadder.m.IadebugCommand;
import itemsadder.m.IadisguiseCommand;
import itemsadder.m.IadropCommand;
import itemsadder.m.IadurabilityCommand;
import itemsadder.m.IaemoteCommand;
import itemsadder.m.IaentityCommand;
import itemsadder.m.IagetCommand;
import itemsadder.m.IagiveCommand;
import itemsadder.m.IahitboxCommand;
import itemsadder.m.IahudCommand;
import itemsadder.m.IaimageCommand;
import itemsadder.m.IainfoCommand;
import itemsadder.m.IaitemCommand;
import itemsadder.m.IaliquidCommand;
import itemsadder.m.IaplayerstatCommand;
import itemsadder.m.IaplaysoundCommand;
import itemsadder.m.IaplaytotemanimationCommand;
import itemsadder.m.IarecipeCommand;
import itemsadder.m.IareloadCommand;
import itemsadder.m.IaremoveCommand;
import itemsadder.m.IarenameCommand;
import itemsadder.m.IarepairCommand;
import itemsadder.m.Iasha1Command;
import itemsadder.m.IatagCommand;
import itemsadder.m.IaundisguiseCommand;
import itemsadder.m.IazipCommand;
import itemsadder.m.InstanceHolder_4;
import itemsadder.m.InventoryClickListener_4;
import itemsadder.m.InventoryClickListener_5;
import itemsadder.m.InventoryClickListener_7;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ItemsAdderLoadDataEventHelper;
import itemsadder.m.Json_2;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationWrapper_3;
import itemsadder.m.MainHelper;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.MaterialBlockDataHolder;
import itemsadder.m.PacketAdapterHelper;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerCommandPreprocessListener;
import itemsadder.m.PlayerHolder_5;
import itemsadder.m.PlayerInteractListener_8;
import itemsadder.m.PlayerJoinListener;
import itemsadder.m.PlayerJoinListener_2;
import itemsadder.m.PlayerJoinListener_9;
import itemsadder.m.PlayerQuitListener_5;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.PluginBridge_7;
import itemsadder.m.PluginBridge_9;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginEnableListener;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.VersionHelper;
import itemsadder.m.VersionHelper_2;
import itemsadder.m.VersionHelper_3;
import itemsadder.m.WorldBridge_6;
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
implements PluginContract {
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
    private ItemStackRegistry cc;
    @Nullable
    public static LocationWrapper_3 Pv;
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
    public static PluginFileConfigurationHolder KO;
    public static PluginBridge_7 PQ;
    public PacketAdapterHelper PR;
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
            Set<String> set = !VersionHelper_3.sZ() ? Set.of("net.kyori:adventure-api:4.23.0", "net.kyori:adventure-text-minimessage:4.23.0", "net.kyori:adventure-text-serializer-gson:4.23.0", "net.kyori:adventure-text-serializer-gson-legacy-impl:4.23.0", "net.kyori:adventure-platform-bukkit:4.4.1") : (Version.isOlderThan((Version)Version.v26_1_2) ? Set.of("net.kyori:adventure-text-serializer-gson:4.23.0", "net.kyori:adventure-text-serializer-gson-legacy-impl:4.23.0", "net.kyori:adventure-platform-bukkit:4.4.1") : Set.of("net.kyori:adventure-text-serializer-gson:5.1.1", "net.kyori:adventure-text-serializer-gson-legacy-impl:4.26.1", "net.kyori:adventure-platform-bukkit:4.4.1"));
            b2.d(set);
        }
        catch (Exception | LinkageError throwable) {
            CommandSenderBridge_5.error("Failed to load libraries, please check the console for more details.", throwable);
            Main.bU();
            return;
        }
        ProtectionPlugins.register();
    }

    public void onEnable() {
        Object object;
        Main.loadConfig0();
        if (!VersionHelper.te()) {
            return;
        }
        PacketListenerRegistry.init();
        VersionHelper_3.init();
        InstanceHolder_4.vB().vw();
        Ps = MainHelper.iG(b);
        if (!MainHelper.a(this, Ps)) {
            return;
        }
        this.rY();
        CommandSenderBridge_5.Dj();
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
                        CommandSenderBridge_5.log(String.valueOf(org.bukkit.ChatColor.GREEN) + "[License] Spigot product licensed to: " + String.valueOf(org.bukkit.ChatColor.AQUA) + string + " (" + b + ")");
                    }
                    catch (RuntimeException runtimeException) {
                    }
                    catch (Exception exception) {
                        CommandSenderBridge_5.log(String.valueOf(org.bukkit.ChatColor.YELLOW) + "You can ignore this message: Can't connect to SpigotMC.org, probably internet connection is blocked.\n" + String.valueOf(org.bukkit.ChatColor.GRAY) + "( " + exception.getMessage() + " ) - User ID: " + b);
                    }
                    if (string == null) {
                        CommandSenderBridge_5.error("[License] Unknown Spigot user: " + String.valueOf(org.bukkit.ChatColor.AQUA) + b);
                    }
                } else {
                    string = Pq;
                    if (Pr.contains("POLYMART")) {
                        if (string != null) {
                            CommandSenderBridge_5.log(String.valueOf(org.bukkit.ChatColor.GREEN) + "[License] BuiltByBit product licensed to: " + String.valueOf(org.bukkit.ChatColor.AQUA) + string + " (" + b + ")");
                        } else {
                            CommandSenderBridge_5.error("[License] Unknown BuiltByBit user: " + String.valueOf(org.bukkit.ChatColor.AQUA) + b);
                        }
                    } else if (string != null) {
                        CommandSenderBridge_5.log(String.valueOf(org.bukkit.ChatColor.GREEN) + "[License] Polymart product licensed to: " + String.valueOf(org.bukkit.ChatColor.AQUA) + string + " (" + b + ")");
                    } else {
                        CommandSenderBridge_5.error("[License] Unknown Polymart user: " + String.valueOf(org.bukkit.ChatColor.AQUA) + b);
                    }
                }
            });
        } else {
            CommandSenderBridge_5.log(String.valueOf(org.bukkit.ChatColor.GREEN) + "[License] Discord public beta build.");
        }
        Bukkit.getPluginManager().registerEvents((Listener)new PluginEnableListener(f), f);
        PluginBridge_6.b((Plugin)this);
        if (KO.z("update-checker", true)) {
            new w(this, 1851, this.getDescription().getVersion()).a(x2 -> {
                CommandSenderBridge_5.log(String.valueOf(org.bukkit.ChatColor.GREEN) + " ");
                CommandSenderBridge_5.log(String.valueOf(org.bukkit.ChatColor.GOLD) + String.valueOf(org.bukkit.ChatColor.YELLOW) + "\ud83d\ude80 New version available!");
                CommandSenderBridge_5.log(String.valueOf(org.bukkit.ChatColor.GOLD) + String.valueOf(org.bukkit.ChatColor.YELLOW) + "- Released on: " + x2.sn());
                CommandSenderBridge_5.log(String.valueOf(org.bukkit.ChatColor.GOLD) + String.valueOf(org.bukkit.ChatColor.YELLOW) + "- Version: " + x2.so());
                if (x2.sr() > 0) {
                    CommandSenderBridge_5.log(String.valueOf(org.bukkit.ChatColor.GOLD) + String.valueOf(org.bukkit.ChatColor.YELLOW) + "- You are " + x2.sr() + " versions behind.");
                }
                CommandSenderBridge_5.log(String.valueOf(org.bukkit.ChatColor.GREEN) + " ");
                this.PU = true;
            }, x2 -> {});
        }
        if (Main.rW()) {
            CommandSenderBridge_5.error(" ");
            CommandSenderBridge_5.error(String.valueOf(org.bukkit.ChatColor.RED) + "YOU RELOADED THE PLUGIN/SERVER, this may cause bugs.");
            CommandSenderBridge_5.error(String.valueOf(org.bukkit.ChatColor.DARK_GRAY) + "Next time use &b/iareload" + String.valueOf(org.bukkit.ChatColor.DARK_GRAY) + " to reload configurations.");
            CommandSenderBridge_5.error(String.valueOf(org.bukkit.ChatColor.DARK_GRAY) + "&bRestart the server" + String.valueOf(org.bukkit.ChatColor.DARK_GRAY) + " if you want to update the plugin jar.\n\n");
        }
        System.setProperty("ItemsAdderLoaded", "yeaboi");
        this.Pw = Main.cO("ItemsAdderBlocksInjector");
        PP = Main.cO("MythicMobs");
        if (!(!PP || VersionHelper_3.ds("io.lumine.mythic.api.skills.ISkillMechanic") && VersionHelper_3.ds("io.lumine.mythic.bukkit.adapters.item.ItemComponentBukkitItemStack") && VersionHelper_3.dt("io.lumine.mythic.bukkit.adapters.BukkitItemStack"))) {
            PP = false;
            CommandSenderBridge_5.error("Update MythicMobs, you are running an old version.");
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
            CustomCraftingWrapper.init(CommandSenderBridge_5::error);
        }
        PF = Main.cO("CraftEnhance");
        if (Version.isOlderThan((Version)Version.v26_1_2)) {
            Glow.init((Plugin)this, LocationBridge_2::ad, CommandSenderBridge_5::error);
        }
        PH = Main.cO("Orebfuscator");
        PI = Main.cO("ExecutableItems");
        PJ = Main.cO("AdvancedEnchantments");
        PK = Main.cN("Citizens");
        PL = Main.cO("ViaVersion");
        if (PL) {
            CommandSenderBridge_5.warn("");
            CommandSenderBridge_5.warn("ViaVersion detected.");
            CommandSenderBridge_5.warn("Joining via different game versions can cause issues and some are not fixable due to game limitations.");
            CommandSenderBridge_5.warn("Make sure that you are aware of these limitations before reporting issues.");
            CommandSenderBridge_5.warn("Info: https://a.devs.beer/ia-via-load");
            CommandSenderBridge_5.warn("");
            PlayerJoinListener_2.register();
        }
        PM = Main.cO("ModelEngine");
        PN = Main.cO("Denizen");
        PO = Main.cO("EpicBackpacks");
        PG = Main.cO("Slimefun");
        Pv = LocationWrapper_3.El();
        if (!Main.cO("ProtocolLib")) {
            CommandSenderBridge_5.error("ProtocolLib not installed, please install it: " + String.valueOf(org.bukkit.ChatColor.AQUA) + "www.spigotmc.org/resources/1997/");
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
            VulcanHook.register(f, player -> ItemStackRegistry.g().as.aug.cn((Player)player), CommandSenderBridge_5::error);
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
                CommandSenderBridge_5.error("Failed to hook into Citizens. Please update make sure you're running a compatible version.", throwable);
            }
        }
        if (Main.cO("DirectionalBlock")) {
            CommandSenderBridge_5.warn("DirectionalBlocks plugin detected. The plugin is unofficial.");
            CommandSenderBridge_5.warn("You should instead use the directional blocks feature of ItemsAdder.");
            CommandSenderBridge_5.warn("Read more: http://a.devs.beer/ia-directional-blocks");
        }
        try {
            PluginBridge_9.register((Plugin)this);
        }
        catch (IllegalStateException illegalStateException) {
            // empty catch block
        }
        PlayerJoinListener_9.b((Plugin)this);
        try {
            object = new VersionHelper_2(new File(Main.rS().getDataFolder(), "storage" + File.separator + "cache" + File.separator + "vanilla_assets").toPath(), this::a);
            ((VersionHelper_2)object).aw();
        }
        catch (Exception exception) {
            CommandSenderBridge_5.error("Failed to download or load vanilla assets. Please check your internet connection or the plugin configuration.", exception);
            Main.bU();
        }
        new Json_2().register();
        object = new HandlerListBridge();
        Bukkit.getServer().getPluginManager().callEvent((Event)object);
        if (((HandlerListBridge)((Object)object)).isCancelled()) {
            Bukkit.getScheduler().runTaskAsynchronously((Plugin)this, () -> {
                while (!this.cc.u || !this.cc.v) {
                }
                Bukkit.getScheduler().runTaskLater((Plugin)this, () -> {
                    Random random = new Random();
                    Material[] materialArray = Material.values();
                    ItemStackRegistry.g().C.forEach((string, itemStackBuilder_4) -> {
                        itemStackBuilder_4.setType(materialArray[random.nextInt(materialArray.length - 1)]);
                        itemStackBuilder_4.mZ();
                    });
                    ItemStackRegistry.g().aW.b(false);
                    ItemStackRegistry.g().bi.Ue.sD().clear();
                    ItemStackRegistry.g().a(false);
                    Json_2.q();
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
                }, (long)ColorBridge.v(15, 32) * 20L);
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
                    PlayerHolder_5.vq().h(keyed.getKey());
                    bl2 = true;
                    if (!bl) continue;
                    CommandSenderBridge_5.warn("Removed recipe " + String.valueOf(keyed.getKey()));
                }
            }
            if (bl2) {
                PlayerHolder_5.vq().vo();
            }
        }
        EntityDamageListenerBase.register();
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)this);
    }

    public static void bU() {
        Bukkit.getPluginManager().disablePlugin((Plugin)Main.rS());
        Bukkit.getServer().shutdown();
    }

    private void a(VersionHelper_2 versionHelper_2) {
        this.cc = ItemStackRegistry.a((Plugin)this, versionHelper_2);
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
            CommandSenderBridge_5.log(String.valueOf(org.bukkit.ChatColor.YELLOW) + "[!] Waiting for Cyclic dependencies to load before loading ItemsAdder contents: " + String.valueOf(org.bukkit.ChatColor.AQUA) + String.join((CharSequence)", ", this.PV));
        } else {
            this.rV();
        }
    }

    private void rV() {
        this.cc.f();
        this.rX();
        new PlayerCommandPreprocessListener().register((Plugin)this);
        new InventoryClickListener_7().register((Plugin)this);
        ListenerBridge.a(new InventoryClickListener_5(), (Plugin)this);
        ListenerBridge.a(new InventoryClickListener_4(), (Plugin)this);
        this.PR = new PacketAdapterHelper((Plugin)this);
        ArmorEquipEvent.registerListener((JavaPlugin)this);
    }

    public static boolean rW() {
        return System.getProperties().containsKey("ItemsAdderLoaded");
    }

    private void rX() {
        new PlayerQuitListener_5();
        new IazipCommand();
        new itemsadder.m.PluginCommand();
        new IagetCommand();
        new IaremoveCommand();
        new IagiveCommand();
        new IadropCommand();
        new IarepairCommand();
        new IarenameCommand();
        new IadurabilityCommand();
        new IablockCommand();
        new IaconfigCommand();
        new IaliquidCommand();
        new IaplayerstatCommand();
        new IaimageCommand();
        new IatagCommand();
        new IacustommodeldataCommand();
        new IahudCommand();
        new IareloadCommand();
        new IarecipeCommand();
        new IainfoCommand();
        new PlayerInteractListener_8();
        new IaplaytotemanimationCommand();
        new IaplaysoundCommand();
        new IacleancacheCommand();
        new Iasha1Command();
        new IahitboxCommand();
        new IaentityCommand();
        new IaemoteCommand();
        new IacolorCommand();
        new IadebugCommand();
        new IaitemCommand();
        new IadisguiseCommand();
        new IaundisguiseCommand();
        new CropsCommand();
        new CommandSenderBridge_6();
    }

    public void rY() {
        KO = new PluginFileConfigurationHolder((Plugin)this, true, "config.yml", true, false);
        PQ = new PluginBridge_7((Plugin)this, KO.az("config_files.lang", "en"), true);
        if (VersionHelper_3.sW()) {
            Set.of("cz", "de", "en", "es", "fr", "it", "jp", "ko", "nl", "pl", "pt", "ru", "th", "tr", "zh_cn").forEach(string -> {
                PluginBridge_7 pluginBridge_7 = new PluginBridge_7((Plugin)this, (String)string, true);
                if (pluginBridge_7.CE()) {
                    CommandSenderBridge_5.iA("Updating " + string + " file...");
                }
            });
            CommandSenderBridge_5.iA("Iterated lang files to update missing properties.");
        }
        if (!KO.z("update-checker", true)) {
            this.PU = false;
        }
        CommandSenderBridge_5.w(VersionHelper_3.sV() ? PQ.it("prefix") : PluginBridge_6.gF("<rw [DEV]> ").append(PQ.it("prefix")));
        CommandSenderBridge_5.ix((String)(VersionHelper_3.sV() ? "" : String.valueOf(ChatColor.YELLOW) + "!!DEV> " + String.valueOf(ChatColor.RESET)) + PluginBridge_6.u(PQ.it("prefix")));
        MaterialBarColorHolder.c((Plugin)this);
        KO = new PluginFileConfigurationHolder((Plugin)this, true, "config.yml", true, true);
        MaterialBarColorHolder.an();
    }

    @EventHandler
    private void a(PluginEnableEvent pluginEnableEvent) {
        switch (pluginEnableEvent.getPlugin().getName()) {
            case "CustomCrafting": {
                PE = true;
                CustomCraftingWrapper.init(CommandSenderBridge_5::error);
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
            CommandSenderBridge_5.log(String.valueOf(org.bukkit.ChatColor.AQUA) + "[OK] Cyclic dependency has loaded: " + String.valueOf(org.bukkit.ChatColor.AQUA) + pluginEnableEvent.getPlugin().getName());
            if (this.PV.isEmpty()) {
                CommandSenderBridge_5.log(String.valueOf(org.bukkit.ChatColor.GREEN) + "[OK] All Cyclic dependencies loaded, now loading ItemsAdder contents...");
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
        InstanceHolder_4.vx();
        BossBarBridge_2.CZ();
        BossBarBridge_2.clear();
        if (PK) {
            CitizensHook.unregister();
        }
        if (PP) {
            MythicMobsHook.inst().unregister();
        }
        if (PN) {
            DenizenHook.unhook();
        }
        if (LivingEntityRegistry.P()) {
            LivingEntityRegistry.db().O();
        }
        if (this.cc != null) {
            this.cc.a(false, false);
            this.cc.b(false);
            this.cc.n();
            PlayerJoinListener.O();
            WorldBridge_6.pW();
        }
        MaterialBlockDataHolder.mc();
        ProtocolLibrary.getProtocolManager().removePacketListeners((Plugin)this);
        PlayerHolder_5.unregister();
        PluginBridge_6.O();
        if (PacketListenerRegistry.P()) {
            PacketListenerRegistry.uN().cy();
        }
        ItemsAdderLoadDataEventHelper.Z();
        BukkitTaskHolder.O();
        EntityDamageListenerBase.O();
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
            BukkitTaskBridge.c(() -> CommandSenderBridge_5.f((CommandSender)playerJoinEvent.getPlayer(), String.valueOf(org.bukkit.ChatColor.GREEN) + "UPDATE available: " + String.valueOf(org.bukkit.ChatColor.AQUA) + "https://www.spigotmc.org/resources/73355/"), 80L);
        }
    }

    @EventHandler
    private void a(PlayerQuitEvent playerQuitEvent) {
        if (PacketListenerRegistry.P()) {
            PacketListenerRegistry.ak(playerQuitEvent.getPlayer());
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
