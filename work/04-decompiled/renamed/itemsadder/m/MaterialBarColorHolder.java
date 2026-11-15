package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import dev.lone.itemsadder.Main;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LobfileEnum;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.PluginFileConfigurationHolder_2;
import itemsadder.m.RealEnum;
import itemsadder.m.ReplaceEnum_2;
import itemsadder.m.SecretYml;
import itemsadder.m.SoundCategoryBridge;
import itemsadder.m.VersionHelper;
import itemsadder.m.WorldBridge;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.configuration.MemorySection;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers detected
 */
public class MaterialBarColorHolder {
    public static boolean ck;
    public static boolean cl;
    public static String cm;
    public static boolean cn;
    public static String co;
    public static boolean cp;
    public static int cq;
    public static int cr;
    @Nullable
    public static String cs;
    public static boolean ct;
    public static boolean cu;
    public static int cv;
    public static int cw;
    public static boolean cx;
    public static int cy;
    public static int cz;
    public static boolean cA;
    public static boolean cB;
    public static boolean cC;
    public static boolean cD;
    public static boolean cE;
    public static String cF;
    public static boolean cG;
    public static boolean cH;
    public static boolean cI;
    public static boolean cJ;
    public static boolean cK;
    public static boolean cL;
    public static int cM;
    public static int cN;
    public static int cO;
    public static Material cP;
    public static int cQ;
    public static int cR;
    public static boolean cS;
    public static boolean cT;
    public static boolean cU;
    @Deprecated
    public static String cV;
    @Deprecated
    public static String cW;
    @Deprecated
    public static String cX;
    @Deprecated
    public static String cY;
    public static boolean cZ;
    public static boolean da;
    public static boolean db;
    public static boolean dc;
    public static int dd;
    public static boolean de;
    public static boolean df;
    public static LobfileEnum dg;
    public static boolean dh;
    public static boolean di;
    public static boolean dj;
    public static boolean dk;
    public static boolean dl;
    public static int dm;
    public static boolean dn;
    public static boolean do;
    public static boolean dp;
    public static boolean dq;
    public static Set dr;
    public static boolean ds;
    public static boolean dt;
    public static boolean du;
    public static boolean dv;
    public static boolean dw;
    public static boolean dx;
    public static boolean dy;
    public static boolean dz;
    public static boolean dA;
    public static boolean dB;
    public static boolean dC;
    public static boolean dD;
    public static boolean dE;
    public static boolean dF;
    public static int dG;
    public static boolean dH;
    public static boolean dI;
    public static boolean dJ;
    public static boolean dK;
    public static boolean dL;
    public static boolean dM;
    public static boolean dN;
    public static boolean dO;
    public static boolean dP;
    public static boolean dQ;
    public static int dR;
    public static int dS;
    public static boolean dT;
    public static boolean dU;
    public static int dV;
    public static int dW;
    public static boolean dX;
    public static int dY;
    public static int dZ;
    public static int ea;
    public static int eb;
    public static int ec;
    public static boolean ed;
    public static boolean ee;
    public static boolean ef;
    public static boolean eg;
    public static boolean eh;
    public static boolean ei;
    public static boolean ej;
    public static boolean ek;
    public static boolean el;
    public static boolean em;
    public static boolean en;
    public static boolean eo;
    public static boolean ep;
    public static boolean eq;
    public static boolean er;
    public static List es;
    public static List et;
    public static boolean eu;
    public static boolean ev;
    public static boolean ew;
    public static boolean ex;
    public static boolean ey;
    public static boolean ez;
    public static boolean eA;
    public static boolean eB;
    public static boolean eC;
    public static boolean eD;
    public static boolean eE;
    public static boolean eF;
    public static boolean eG;
    public static boolean eH;
    public static boolean eI;
    public static boolean eJ;
    public static boolean eK;
    public static List eL;
    public static boolean eM;
    public static boolean eN;
    public static boolean eO;
    public static boolean eP;
    public static boolean eQ;
    public static boolean eR;
    public static boolean eS;
    public static WorldBridge eT;
    public static int eU;
    public static String eV;
    public static boolean eW;
    public static boolean eX;
    public static boolean eY;
    public static boolean eZ;
    public static boolean fa;
    public static boolean fb;
    public static boolean fc;
    public static boolean fd;
    public static Integer fe;
    public static boolean ff;
    public static int fg;
    public static BarColor fh;
    public static BarStyle fi;
    public static boolean fj;
    public static boolean fk;
    public static boolean fl;
    public static boolean fm;
    public static boolean fn;
    public static boolean fo;
    public static boolean fp;
    public static boolean fq;
    public static boolean fr;
    public static boolean fs;
    public static boolean ft;
    public static boolean fu;
    public static boolean fv;
    public static boolean fw;
    public static boolean fx;
    public static boolean fy;
    public static boolean fz;
    public static boolean fA;
    public static boolean fB;
    public static boolean fC;
    public static boolean fD;
    public static int fE;
    public static int fF;
    public static boolean fG;
    public static boolean fH;
    public static boolean fI;
    public static ReplaceEnum_2 fJ;
    public static boolean fK;
    public static boolean fL;
    public static boolean fM;
    public static String fN;
    public static boolean fO;
    public static boolean fP;
    public static boolean fQ;
    public static boolean fR;
    public static boolean fS;
    public static boolean fT;
    public static boolean fU;
    public static boolean fV;
    public static boolean fW;
    public static boolean fX;
    public static boolean fY;
    public static String fZ;
    public static int ga;

    public static void an() {
        String string2;
        Object object;
        String string3;
        PluginFileConfigurationHolder pluginFileConfigurationHolder = Main.KO;
        ck = pluginFileConfigurationHolder.z("show_plugin_logo_on_enable", true);
        cl = pluginFileConfigurationHolder.z("debug.benchmark", false);
        cA = pluginFileConfigurationHolder.z("config_files.force-sync-loading", false);
        cB = pluginFileConfigurationHolder.z("resource-pack.zip.protect-file-from-unzip.protection_1", true);
        cC = pluginFileConfigurationHolder.z("resource-pack.zip.protect-file-from-unzip.protection_2", true);
        cD = pluginFileConfigurationHolder.z("resource-pack.zip.protect-file-from-unzip.protection_3", true);
        cE = pluginFileConfigurationHolder.z("resource-pack.zip.protect-file-from-unzip.short_texture_references", true);
        cF = pluginFileConfigurationHolder.gV("config_files.dictionaries-lang");
        cG = pluginFileConfigurationHolder.z("blocks.custom.mushroom", true);
        cH = pluginFileConfigurationHolder.z("blocks.custom.chorus", true);
        cI = pluginFileConfigurationHolder.z("blocks.custom.note", true);
        cJ = pluginFileConfigurationHolder.z("blocks.custom.wire", false);
        cK = pluginFileConfigurationHolder.z("blocks.custom.fire", false);
        cL = pluginFileConfigurationHolder.z("blocks.custom.entity.enabled", true);
        cM = pluginFileConfigurationHolder.t("blocks.custom.entity.render-radius", 48);
        cN = pluginFileConfigurationHolder.t("blocks.custom.entity.max-displays-per-player", 512);
        cO = pluginFileConfigurationHolder.t("blocks.custom.entity.max-blocks-per-chunk", 256);
        String string4 = "blocks.custom.entity.fallback-vanilla-block";
        Material material = cP = pluginFileConfigurationHolder.gP(string4) ? pluginFileConfigurationHolder.a(string4, (Material)null) : Material.GRAY_CONCRETE;
        if (!RealEnum.q(cP)) {
            CommandSenderBridge_5.warn("Invalid blocks.custom.entity.fallback-vanilla-block: it must be a solid, occluding, non-interactable vanilla block without gravity. Using GRAY_CONCRETE.");
            cP = Material.GRAY_CONCRETE;
        }
        cQ = pluginFileConfigurationHolder.t("blocks.custom.entity.update-interval", 2);
        cR = pluginFileConfigurationHolder.t("blocks.custom.entity.warm-slot-timeout", 40);
        cM = Math.max(1, cM);
        cN = Math.max(9, cN);
        cO = Math.max(0, cO);
        cQ = Math.max(1, cQ);
        cR = Math.max(0, cR);
        if (cL && (cM > 128 || cN > 2048)) {
            CommandSenderBridge_5.warn("High ENTITY block limits can scale poorly with many players: render-radius=" + cM + ", max-displays-per-player=" + cN + ".");
        }
        cS = pluginFileConfigurationHolder.z("liquids.enabled", false);
        cT = pluginFileConfigurationHolder.z("blocks.fix-liquids-flow", true);
        cU = pluginFileConfigurationHolder.z("blocks.fix-floating-blocks", true);
        cZ = Main.PQ.gP("attribute-attack-damage");
        cV = Main.PQ.aB("lore-durability", "&7Durability: {value} / {max}").replace("{value}", "").replace("{max}", "");
        cW = Main.PQ.aB("attribute-attack-damage", " &2{value} Attack Damage").replace("{value}", "");
        cX = Main.PQ.aB("attribute-attack-speed", " &2{value} Attack Speed").replace("{value}", "");
        cY = ChatColor.stripColor((String)Main.PQ.f("attribute-when-in-main-hand", "", false));
        dh = pluginFileConfigurationHolder.gY("resource-pack.zip.compress-png-files");
        di = pluginFileConfigurationHolder.gY("resource-pack.zip.compress-json-files");
        dj = pluginFileConfigurationHolder.gY("resource-pack.zip.compress-shader-files");
        dk = pluginFileConfigurationHolder.z("resource-pack.zip.validate-shader-files", true);
        dl = pluginFileConfigurationHolder.z("resource-pack.zip.compress_sounds.enabled", true);
        dm = pluginFileConfigurationHolder.t("resource-pack.zip.compress_sounds.bitrate_quality", 100);
        dn = pluginFileConfigurationHolder.z("resource-pack.zip.models.fix_missing_particle", true);
        do = pluginFileConfigurationHolder.z("resource-pack.zip.models.fix_dark_in_inventory", true);
        dp = pluginFileConfigurationHolder.z("resource-pack.zip.models.log_non_standard_rotations", true);
        dq = pluginFileConfigurationHolder.z("resource-pack.zip.models.fix_1_21_11_plus_atlas_items_models.enabled", true);
        dr = pluginFileConfigurationHolder.hh("resource-pack.zip.models.fix_1_21_11_plus_atlas_items_models.models");
        dr.removeIf(string -> string.endsWith(".json"));
        dr = dr.stream().map(string -> string.toLowerCase()).collect(Collectors.toSet());
        dc = pluginFileConfigurationHolder.gY("resource-pack.auto_apply.enabled");
        db = pluginFileConfigurationHolder.gY("resource-pack.auto_apply.before_join");
        dd = pluginFileConfigurationHolder.t("resource-pack.apply_on_join.delay_ticks", 0);
        de = pluginFileConfigurationHolder.z("resource-pack.kick-player-on-decline", true);
        MaterialBarColorHolder.b(pluginFileConfigurationHolder);
        du = pluginFileConfigurationHolder.z("resource-pack.zip.custom_armors_shaders_legacy.vanilla.overwrite_leather_layers", true);
        dv = pluginFileConfigurationHolder.z("resource-pack.zip.custom_armors_shaders_legacy.vanilla.generate_shader.1_21_4_lower", true);
        dw = pluginFileConfigurationHolder.z("resource-pack.zip.custom_armors_shaders_legacy.vanilla.generate_shader.1_21_5_plus", true);
        dt = pluginFileConfigurationHolder.z("resource-pack.zip.custom_armors_shaders_legacy.optifine.generate_cit.1_20_4_lower", false);
        ds = dv || dw || dt;
        dP = pluginFileConfigurationHolder.z("resource-pack.zip.emotes.legacy_shaders", false);
        dx = pluginFileConfigurationHolder.z("resource-pack.zip.emotes.1_21_5_to_1_21_9_shaders", true);
        dy = pluginFileConfigurationHolder.z("resource-pack.zip.emotes.1_21_4_plus_modern_method", true);
        if (dx && dy) {
            CommandSenderBridge_5.warn("Both `1_21_5_to_1_21_9_shaders` and `1_21_4_plus_modern_method` are enabled, only one method is needed. Enabling only `1_21_4_plus_modern_method`.");
            dx = false;
            dy = true;
        }
        if (dy && !Version.isAtLeast((Version)Version.v1_21_4)) {
            CommandSenderBridge_5.warn("You enabled `1_21_4_plus_modern_method` but your server is not 1.21.4+. Disabling the setting.");
            dy = false;
        }
        dz = pluginFileConfigurationHolder.z("debug.items.log-armors-loading", false);
        dA = pluginFileConfigurationHolder.z("debug.recipes.log-fix-packet-too-large", false);
        dB = pluginFileConfigurationHolder.z("debug.blocks.log-convert-vanilla-blocks", false);
        dC = pluginFileConfigurationHolder.z("debug.blocks.log-fix-bugged-blocks", false);
        dD = pluginFileConfigurationHolder.z("debug.blocks.log-unusual-block-break", false);
        dE = pluginFileConfigurationHolder.z("debug.blocks.log-unknown-block-break", false);
        dF = Main.KO.gY("debug.blocks.log-save-load.enabled");
        dG = Main.KO.gW("debug.blocks.log-save-load.min-ms");
        dH = pluginFileConfigurationHolder.z("resource-pack.hosting.external-host.skip_url_file_type_check", false);
        dI = pluginFileConfigurationHolder.z("debug.items.log-files-loading", false);
        dJ = pluginFileConfigurationHolder.z("debug.items.log-files-reloading", true);
        dK = pluginFileConfigurationHolder.z("recipes.fix-packet-too-large-kick", false);
        dL = pluginFileConfigurationHolder.z("entities.custom_entities.enabled", true);
        dM = dL && pluginFileConfigurationHolder.z("entities.custom_entities.emotes.enabled", true);
        dN = dL && pluginFileConfigurationHolder.z("entities.custom_entities.emotes.third_person_view", true);
        dO = pluginFileConfigurationHolder.z("entities.custom_entities.expert_users.delay_packets", false);
        dQ = pluginFileConfigurationHolder.z("entities.custom_entities.expert_users.disguises_lag_compensation", true);
        dR = pluginFileConfigurationHolder.t("entities.custom_entities.max_per_chunk", 5);
        dS = pluginFileConfigurationHolder.t("crops.avg_seconds_per_stage", 240);
        dT = pluginFileConfigurationHolder.z("crops.rendering.fov_render_limit", true);
        dU = pluginFileConfigurationHolder.z("crops.rendering.checkerboard_pattern.enabled", true);
        dV = pluginFileConfigurationHolder.t("crops.rendering.checkerboard_pattern.distance", 4);
        dW = pluginFileConfigurationHolder.t("crops.rendering.max_shown_per_player", 1400);
        dW = Math.max(200, Math.min(dW, 1800));
        dX = pluginFileConfigurationHolder.z("crops.rendering.billboard.enabled", true);
        dY = pluginFileConfigurationHolder.t("crops.rendering.billboard.distance", 6);
        dY = Math.max(0, Math.min(dY, 10));
        dZ = pluginFileConfigurationHolder.t("crops.rendering.tick_interval", 2);
        dZ = Math.max(1, Math.min(dZ, 10));
        ea = pluginFileConfigurationHolder.t("crops.rendering.radius_blocks", 32);
        ea = Math.max(16, Math.min(ea, 64));
        eb = pluginFileConfigurationHolder.t("crops.max_crops_in_area", 800);
        eb = Math.max(0, eb);
        ec = pluginFileConfigurationHolder.t("crops.area_limit_radius", 32);
        ec = Math.max(16, Math.min(ec, 64));
        ed = pluginFileConfigurationHolder.z("crops.interaction.precise_hitbox_targeting", true);
        ee = pluginFileConfigurationHolder.z("crops.interaction.continuous_harvesting_assistance", true);
        ef = pluginFileConfigurationHolder.z("loots.allow-loots-drop-from-spawners-using-silk-touch", false);
        eg = pluginFileConfigurationHolder.z("items.fix-show-attack-and-damage-as-lore", true);
        eh = Main.KO.gY("debug.surface-decorators.log-generation");
        ei = pluginFileConfigurationHolder.z("debug.cave-decorators.log-generation", false);
        ej = pluginFileConfigurationHolder.z("debug.cave-decorators.log-loading", false);
        ek = pluginFileConfigurationHolder.gY("debug.blocks-populators.log-generation");
        el = pluginFileConfigurationHolder.gY("debug.trees-populators.log-generation");
        en = pluginFileConfigurationHolder.z("blocks.convert-vanilla-blocks.enabled", false);
        eo = pluginFileConfigurationHolder.z("blocks.convert-vanilla-blocks.only-new-chunks", true);
        ep = pluginFileConfigurationHolder.z("blocks.fix-reverted-custom-blockstates.enabled", true);
        eq = Main.KO.z("blocks.fix-glitched-blocks.only-new-chunks", false);
        er = Main.KO.z("blocks.fix-glitched-blocks.enabled", true);
        if (en && er) {
            CommandSenderBridge_5.error("Can't use both 'fix-glitched-blocks' and 'convert-vanilla-blocks'. Decide one of them. Check config.yml");
            en = false;
            er = false;
        }
        es = pluginFileConfigurationHolder.hg("resource-pack.zip.contents-folders-priority");
        Collections.reverse(es);
        et = pluginFileConfigurationHolder.hg("resource-pack.zip.merge_other_plugins_resourcepacks_folders");
        Collections.reverse(et);
        cm = pluginFileConfigurationHolder.az("resource-pack.uuid", "d69238f2-b7ce-30b0-8262-17cd9490f29d");
        if (MaterialBarColorHolder.a(pluginFileConfigurationHolder)) {
            CommandSenderBridge_5.error("You have multiple hosting methods enabled at the same time, please select only one. Defaulting to simple_self_host.");
            pluginFileConfigurationHolder.d("resource-pack.hosting.simple_self_host.enabled", true);
            pluginFileConfigurationHolder.d("resource-pack.hosting.no-host.enabled", false);
            pluginFileConfigurationHolder.d("resource-pack.hosting.lobfile.enabled", false);
            pluginFileConfigurationHolder.d("resource-pack.hosting.external-host.enabled", false);
            pluginFileConfigurationHolder.d("resource-pack.hosting.self-host.enabled", false);
            pluginFileConfigurationHolder.save();
        }
        if (pluginFileConfigurationHolder.gY("resource-pack.hosting.self-host.enabled")) {
            cs = !pluginFileConfigurationHolder.z("resource-pack.hosting.self-host.append-port", true) ? pluginFileConfigurationHolder.gV("resource-pack.hosting.self-host.server-ip") : String.format("%s:%s", pluginFileConfigurationHolder.gV("resource-pack.hosting.self-host.server-ip"), pluginFileConfigurationHolder.gV("resource-pack.hosting.self-host.pack-port"));
            if (!cs.startsWith("http://") && !cs.startsWith("https://")) {
                cs = "http://" + cs;
            }
            cs = cs + "/generated.zip";
        } else {
            cs = null;
        }
        cu = pluginFileConfigurationHolder.z("resource-pack.hosting.self-host.protection.rate_limit.enabled", false);
        if (cu) {
            cv = pluginFileConfigurationHolder.t("resource-pack.hosting.self-host.protection.rate_limit.max_requests", 3);
            cw = pluginFileConfigurationHolder.t("resource-pack.hosting.self-host.protection.rate_limit.period_seconds", 2);
        }
        ct = pluginFileConfigurationHolder.z("resource-pack.hosting.self-host.protection.block_non_game_requests", false);
        cx = pluginFileConfigurationHolder.z("resource-pack.hosting.self-host.protection.rate_limit.cooldown.enabled", false);
        if (cx) {
            cy = pluginFileConfigurationHolder.t("resource-pack.hosting.self-host.protection.rate_limit.cooldown.duration_minutes", 30);
            cz = pluginFileConfigurationHolder.t("resource-pack.hosting.self-host.protection.rate_limit.cooldown.trigger_on_failed_times", 5);
        }
        if ((string3 = Main.rS().getServer().getIp()).isEmpty()) {
            string3 = "127.0.1.1";
        }
        if (pluginFileConfigurationHolder.gY("resource-pack.hosting.simple_self_host.enabled")) {
            cn = true;
            co = pluginFileConfigurationHolder.az("resource-pack.hosting.simple_self_host.server_address", "127.0.0.1");
            if (co.startsWith("http://") || co.startsWith("https://")) {
                co = co.replaceFirst("http://", "").replaceFirst("https://", "");
            }
            if (co.equals("auto")) {
                co = string3 + ":" + Main.rS().getServer().getPort();
            }
            if (co.endsWith("/")) {
                co = co.substring(0, co.length() - 1);
            }
            if (!co.endsWith("resourcepack")) {
                co = co + "/resourcepack";
            }
            co = "http://" + co;
            cp = pluginFileConfigurationHolder.z("resource-pack.hosting.simple_self_host.optimization.block_non_game_requests", true);
            cq = pluginFileConfigurationHolder.t("resource-pack.hosting.simple_self_host.optimization.max_downloads_per_ip", 5);
            cr = pluginFileConfigurationHolder.t("resource-pack.hosting.simple_self_host.optimization.max_speed_in_megabyte_ps", 30);
        } else {
            cn = false;
        }
        eX = Main.KO.z("recipes.custom-recipes.unlock.all-on-join", false);
        eY = Main.KO.z("recipes.custom-recipes.unlock.automatically", false);
        eu = pluginFileConfigurationHolder.z("resource-pack.zip.extract_internal_utility_assets", true);
        ev = pluginFileConfigurationHolder.z("resource-pack.protect-player.lock-player", true);
        ew = pluginFileConfigurationHolder.z("resource-pack.protect-player.cancel_commands", true);
        ex = pluginFileConfigurationHolder.z("resource-pack.protect-player.cancel_teleport", true);
        ey = pluginFileConfigurationHolder.z("resource-pack.protect-player.force_cancel_movement", true);
        eB = pluginFileConfigurationHolder.z("recipes.show-no-permission-popup-in-recipebook", true);
        eC = pluginFileConfigurationHolder.z("recipes.show-no-permission-chat-message", true);
        eD = pluginFileConfigurationHolder.z("cache_font_images_and_effects_replacements", true);
        if (eD && Main.cO("InteractiveChat")) {
            eD = false;
            CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "InteractiveChat detected, disabling `cache_font_images_and_effects_replacements`.");
        }
        eE = pluginFileConfigurationHolder.z("font_images.chat.enabled", true);
        eF = pluginFileConfigurationHolder.z("font_images.chat.add_hover_suggestion", true);
        eG = pluginFileConfigurationHolder.z("font_images.sign.enabled", true);
        if (eG && !VersionHelper.Va) {
            CommandSenderBridge_5.warn("Feature disabled, requires Paper: font_images on signs.");
        }
        if ((eH = pluginFileConfigurationHolder.z("font_images.book.enabled", true)) && !VersionHelper.Va) {
            CommandSenderBridge_5.warn("Feature disabled, requires Paper: font_images on books.");
        }
        if ((eI = pluginFileConfigurationHolder.z("font_images.anvil.enabled", true)) && !VersionHelper.Va) {
            CommandSenderBridge_5.warn("Feature disabled, requires Paper: font_images on anvils.");
        }
        da = pluginFileConfigurationHolder.gY("font_images.inventory-title.enabled");
        eJ = pluginFileConfigurationHolder.gY("font_images.command.commandblocks");
        eL = pluginFileConfigurationHolder.hg("font_images.command.excluded");
        eM = pluginFileConfigurationHolder.gY("font_images.scoreboard-teams.enabled");
        eK = pluginFileConfigurationHolder.z("font_images.chat.tab_autocompletion_1_19_1_plus", true);
        fr = pluginFileConfigurationHolder.z("text_effects.enabled", true);
        fs = pluginFileConfigurationHolder.z("text_effects.legacy_colors_compatibility", true);
        eN = fr && pluginFileConfigurationHolder.gY("text_effects.chat.enabled");
        boolean bl = eO = fr && pluginFileConfigurationHolder.gY("text_effects.sign.enabled");
        if (eO && !VersionHelper.Va) {
            CommandSenderBridge_5.warn("Feature disabled, requires Paper: text_effects on signs.");
        }
        boolean bl2 = eP = fr && pluginFileConfigurationHolder.gY("text_effects.sign.enabled");
        if (eP && !VersionHelper.Va) {
            CommandSenderBridge_5.warn("Feature disabled, requires Paper: text_effects on books.");
        }
        boolean bl3 = eQ = fr && pluginFileConfigurationHolder.gY("text_effects.anvil.enabled");
        if (eQ && !VersionHelper.Va) {
            CommandSenderBridge_5.warn("Feature disabled, requires Paper: text_effects on anvils.");
        }
        fk = fr && pluginFileConfigurationHolder.z("text_effects.customitem_name_and_lore.enabled", true);
        eR = pluginFileConfigurationHolder.z("blocks.remove-unused-palettes-on-region-save", true);
        eS = pluginFileConfigurationHolder.z("blocks.convert_paper_to_block_in_inventory", false);
        eT = new WorldBridge(pluginFileConfigurationHolder.hg("blocks.worlds"));
        eU = pluginFileConfigurationHolder.t("font_images.iaimage-book.max-line-length", 16);
        eV = pluginFileConfigurationHolder.az("font_images.iaimage-book.placeholder-font", "minecraft:default");
        ez = pluginFileConfigurationHolder.z("resource-pack.fix_force_unicode_font_images", true);
        eA = pluginFileConfigurationHolder.z("resource-pack.allow_other_plugins_resourcepacks", true);
        df = pluginFileConfigurationHolder.z("resource-pack.notify_other_plugins_resourcepacks", true);
        eW = pluginFileConfigurationHolder.z("compatibility.advanced_enchantments.enable_custom_enchants_in_items_configs", false);
        fa = pluginFileConfigurationHolder.z("recipes.crafting.enabled", true);
        fb = pluginFileConfigurationHolder.z("recipes.cooking.enabled", true);
        fc = pluginFileConfigurationHolder.z("recipes.anvil.enabled", true);
        fd = pluginFileConfigurationHolder.z("recipes.smithing.enabled", true);
        boolean bl4 = eZ = fa || fb || fc || fd;
        if (pluginFileConfigurationHolder.z("huds.enabled", true) && pluginFileConfigurationHolder.z("huds.force_color.enabled", true)) {
            object = ColorBridge.iL(pluginFileConfigurationHolder.az("huds.force_color.color", "#FFFFFF"));
            fe = object.asRGB();
        } else {
            fe = null;
        }
        ff = pluginFileConfigurationHolder.z("cooldown_bars.enabled", true);
        fg = pluginFileConfigurationHolder.t("cooldown_bars.refresh_ticks", 1);
        fh = (BarColor)pluginFileConfigurationHolder.a("cooldown_bars.bossbar.color", BarColor.class, (Enum)BarColor.WHITE, string -> CommandSenderBridge_5.error("Invalid color for cooldown bossbar in config.yml. Using default WHITE."));
        fi = (BarStyle)pluginFileConfigurationHolder.a("cooldown_bars.bossbar.style", BarStyle.class, (Enum)BarStyle.SOLID, string -> CommandSenderBridge_5.error("Invalid style for cooldown bossbar in config.yml. Using default SOLID."));
        fj = pluginFileConfigurationHolder.z("font_images.customitem_name_and_lore.enabled", true);
        fl = pluginFileConfigurationHolder.z("resource-pack.custom_blocks_sounds_patch.enabled", true);
        fm = pluginFileConfigurationHolder.z("resource-pack.custom_blocks_sounds_patch.step", true);
        fn = pluginFileConfigurationHolder.z("resource-pack.custom_blocks_sounds_patch.other", true);
        fo = pluginFileConfigurationHolder.z("resource-pack.pre_1_21_2_shaders_fix.enabled", false);
        fp = pluginFileConfigurationHolder.z("blocks.cancel-break-wrong-tool.enabled", true);
        fq = pluginFileConfigurationHolder.z("blocks.cancel-break-wrong-tool.send-actionbar", true);
        ft = pluginFileConfigurationHolder.z("text_effects.hide_scoreboard_numbers_old_clients", false);
        fu = pluginFileConfigurationHolder.z("text_effects.hide_scoreboard_numbers", false);
        em = pluginFileConfigurationHolder.gY("debug.items.log-font-images-loading");
        object = pluginFileConfigurationHolder.az("player_stats.save_type", "CUSTOM_NBT");
        if (((String)object).equals("CUSTOM_NBT") || ((String)object).equals("PLAYER_DAT")) {
            fv = ((String)object).equals("PLAYER_DAT");
        } else {
            fv = true;
            CommandSenderBridge_5.warn("'player_stats.save_type' has invalid value. Supported values: 'CUSTOM_NBT', 'PLAYER_DAT'.");
        }
        fw = pluginFileConfigurationHolder.z("items.fix_trades_guis_match_custom_items.itemsadder_trade_machines", true);
        fx = pluginFileConfigurationHolder.z("items.fix_trades_guis_match_custom_items.vanilla_villagers", true);
        fy = pluginFileConfigurationHolder.z("items.fix_trades_guis_match_custom_items.other_plugins", true);
        fz = pluginFileConfigurationHolder.gY("debug.issues.log_font_image_replace_json_syntax_exception");
        fA = pluginFileConfigurationHolder.gY("debug.resourcepacks.log_player_install");
        fB = pluginFileConfigurationHolder.gY("entities.furniture.auto_convert_to_item_display");
        fC = pluginFileConfigurationHolder.z("entities.furniture.auto_update_transformations", true);
        fD = pluginFileConfigurationHolder.gY("items.optimizations.kick_on_quickbar_spam.enabled");
        if (fD) {
            fE = pluginFileConfigurationHolder.t("items.optimizations.kick_on_quickbar_spam.ms", 200);
            fF = pluginFileConfigurationHolder.t("items.optimizations.kick_on_quickbar_spam.clicks", 6);
        }
        fH = (fG = pluginFileConfigurationHolder.z("items.update-legacy-items.enabled", true)) && pluginFileConfigurationHolder.z("items.update-legacy-items.update_durability", true);
        fI = pluginFileConfigurationHolder.z("items.auto_update.enabled", true);
        fJ = (ReplaceEnum_2)pluginFileConfigurationHolder.a("items.auto_update.enchantment_mode", ReplaceEnum_2.class, ReplaceEnum_2.MERGE);
        fK = pluginFileConfigurationHolder.z("items.auto_update.fix_unstackable_items_on_click", true);
        fL = pluginFileConfigurationHolder.z("advanced.legacy_shader_armor_conversion.append_new_equipment_tag.enabled", false);
        fM = pluginFileConfigurationHolder.z("advanced.legacy_shader_armor_conversion.completely_convert_to_new_equipment_tag.enabled", false);
        fN = pluginFileConfigurationHolder.az("advanced.legacy_shader_armor_conversion.completely_convert_to_new_equipment_tag.new_armor_material", null);
        if (fM && !SoundCategoryBridge.d(fN + "_HELMET", Material.class)) {
            CommandSenderBridge_5.error("Invalid material for 'completely_convert_to_new_equipment_tag.new_armor_material'. For example 'IRON', 'DIAMOND'. Check config.yml");
            fN = null;
            fM = false;
        }
        if (fL && fM) {
            CommandSenderBridge_5.error("Can't use both 'append_new_equipment_tag' and 'completely_convert_to_new_equipment_tag'. Decide one of them or none. Check config.yml");
            fL = false;
            fM = false;
        }
        fO = pluginFileConfigurationHolder.z("advanced.update_resource_to_graphics", false);
        fP = pluginFileConfigurationHolder.z("debug.resourcepacks.compression.files", false);
        fQ = pluginFileConfigurationHolder.z("debug.resourcepacks.compression.overlays", false);
        fR = pluginFileConfigurationHolder.z("debug.resourcepacks.compression.duplicate_textures", false);
        fS = pluginFileConfigurationHolder.z("debug.scripts.log_compilation", true);
        fT = pluginFileConfigurationHolder.z("debug.scripts.log_execution", true);
        fU = pluginFileConfigurationHolder.z("debug.entities.log_bones_spawning", false);
        fV = pluginFileConfigurationHolder.z("advanced.ffmpeg.enabled", true);
        fW = pluginFileConfigurationHolder.z("advanced.ffmpeg.download", true);
        fX = pluginFileConfigurationHolder.z("advanced.on_registries_changes.auto_re_join.enabled", true);
        fZ = pluginFileConfigurationHolder.az("server.address", string3);
        if (fZ.equals("auto") || fZ.isEmpty()) {
            fZ = string3;
            CommandSenderBridge_5.warn("Using default server address: " + fZ + ". Consider setting it in the `config.yml`");
        }
        if (fZ.startsWith("http://") || fZ.startsWith("https://")) {
            fZ = fZ.replaceFirst("https?://", "");
        }
        if ((string2 = pluginFileConfigurationHolder.az("server.port", String.valueOf(Main.rS().getServer().getPort()))).equals("auto") || string2.isEmpty()) {
            string2 = String.valueOf(Main.rS().getServer().getPort());
            CommandSenderBridge_5.warn("Using default server port: " + string2 + ". Consider setting it in the `config.yml`");
        }
        try {
            ga = Integer.parseInt(string2);
        }
        catch (NumberFormatException numberFormatException) {
            CommandSenderBridge_5.error("Invalid port for 'server.port'. Check config.yml");
            ga = Main.rS().getServer().getPort();
        }
        fY = pluginFileConfigurationHolder.z("advanced.on_registries_changes.kick.enabled", false);
        SecretYml.an();
    }

    public static boolean a(PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        int n = 0;
        if (pluginFileConfigurationHolder.gY("resource-pack.hosting.self-host.enabled")) {
            ++n;
        }
        if (pluginFileConfigurationHolder.gY("resource-pack.hosting.simple_self_host.enabled")) {
            ++n;
        }
        if (pluginFileConfigurationHolder.gY("resource-pack.hosting.external-host.enabled")) {
            ++n;
        }
        if (pluginFileConfigurationHolder.gY("resource-pack.hosting.lobfile.enabled")) {
            ++n;
        }
        if (pluginFileConfigurationHolder.gY("resource-pack.hosting.no-host.enabled")) {
            ++n;
        }
        return n > 1;
    }

    public static void c(Plugin plugin) {
        Object object;
        PluginFileConfigurationHolder_2 pluginFileConfigurationHolder_2;
        try {
            pluginFileConfigurationHolder_2 = new PluginFileConfigurationHolder_2(plugin, true, "config.yml", true, null);
        }
        catch (FileNotFoundException fileNotFoundException) {
            return;
        }
        pluginFileConfigurationHolder_2.gQ("config_files.legacy_pack");
        pluginFileConfigurationHolder_2.gQ("config_files.extract-default-items");
        pluginFileConfigurationHolder_2.gQ("config_files.extract-default-configs");
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "resource-pack.no-host.enabled", "resource-pack.hosting.no-host.enabled", false);
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "resource-pack.auto-external-host.enabled", "resource-pack.hosting.auto-external-host.enabled", false);
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "resource-pack.self-host.enabled", "resource-pack.hosting.self-host.enabled", false);
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "resource-pack.self-host.server-ip", "resource-pack.hosting.self-host.server-ip", "127.0.0.1");
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "resource-pack.self-host.pack-port", "resource-pack.hosting.self-host.pack-port", 8163);
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "resource-pack.external-host.enabled", "resource-pack.hosting.external-host.enabled", false);
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "resource-pack.external-host.url", "resource-pack.hosting.external-host.url", "");
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "resource-pack.zip.protect-file-from-unzip__DISABLE_IF_ANY_PROBLEM", "resource-pack.zip.protect-file-from-unzip.enabled", true);
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "resource-pack.zip.protect-file-from-unzip.enabled", "resource-pack.zip.protect-file-from-unzip.protection_1", true);
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "resource-pack.zip.protect-file-from-unzip.extreme", "resource-pack.zip.protect-file-from-unzip.protection_2", true);
        if (pluginFileConfigurationHolder_2.e("resource-pack.zip.protect-file-from-unzip", null) instanceof Boolean) {
            MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "resource-pack.zip.protect-file-from-unzip", "resource-pack.zip.protect-file-from-unzip.enabled", true);
        }
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "resource-pack.zip.overwrite-vanilla-lang-json__DISABLE_AT_YOUR_OWN_RISK", "resource-pack.zip.overwrite-vanilla-lang-json", false);
        pluginFileConfigurationHolder_2.gQ("resource-pack.zip.overwrite-vanilla-lang-json");
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "font_images.chat.add-hover-suggestion_PAPER_ONLY", "font_images.chat.add-hover-suggestion", true);
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "font_images.chat.replace-in-customitems-name-and-lore", "font_images.replace-in-customitems-name-and-lore", true);
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "config_files.minify-json", "resource-pack.zip.compress-json-files", true);
        pluginFileConfigurationHolder_2.gQ("font_images.chat.reset-color-to-white");
        pluginFileConfigurationHolder_2.gQ("resource-pack.zip.fix_transparent_noteblocks__disable-for-more-performance");
        pluginFileConfigurationHolder_2.gQ("resource-pack.zip.generate-custom-armors-textures.enabled");
        pluginFileConfigurationHolder_2.gQ("resource-pack.zip.generate-custom-armors-textures.mode");
        pluginFileConfigurationHolder_2.gQ("resource-pack.zip.generate-custom-armors-textures._");
        if (pluginFileConfigurationHolder_2.gP("resource-pack.zip.generate-custom-armors-textures.vanilla_1_17") && !pluginFileConfigurationHolder_2.gP("resource-pack.zip.generate-custom-armors-textures.vanilla")) {
            pluginFileConfigurationHolder_2.d("resource-pack.zip.generate-custom-armors-textures.vanilla", pluginFileConfigurationHolder_2.hq("resource-pack.zip.generate-custom-armors-textures.vanilla_1_17"));
            pluginFileConfigurationHolder_2.gQ("resource-pack.zip.generate-custom-armors-textures.vanilla_1_17");
        }
        pluginFileConfigurationHolder_2.gQ("font_images.tab-header-footer");
        pluginFileConfigurationHolder_2.gQ("effects.text-effects.tab-header-footer");
        pluginFileConfigurationHolder_2.gQ("blocks.fix-glitched-blocks.search-also-in-these-biomes");
        pluginFileConfigurationHolder_2.gQ("resource-pack.zip.overwrite-vanilla-models__DISABLE_AT_YOUR_OWN_RISK");
        pluginFileConfigurationHolder_2.gQ("resource-pack.zip.overwrite-vanilla-models");
        pluginFileConfigurationHolder_2.gQ("debug.blocks.log-save-on-unload");
        if (pluginFileConfigurationHolder_2.gP("debug.blocks.log-save")) {
            pluginFileConfigurationHolder_2.d("debug.blocks.log-save-load.enabled", pluginFileConfigurationHolder_2.a("debug.blocks.log-save", false));
            pluginFileConfigurationHolder_2.gQ("debug.blocks.log-save");
        }
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "blocks.campfire.unlit-on-place", "blocks.campfire_enhancements.unlit_on_place", true);
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "blocks.campfire.allow-any-item", "blocks.campfire_enhancements.allow_any_item", true);
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "blocks.campfire.drop_when_broken", "blocks.campfire_enhancements.drop_when_broken", true);
        if (!pluginFileConfigurationHolder_2.gP("compatibility.worldguard.show_legacy_furniture_flags")) {
            pluginFileConfigurationHolder_2.d("compatibility.worldguard.show_legacy_furniture_flags", true);
        }
        if (!pluginFileConfigurationHolder_2.gP("resource-pack.custom_blocks_sounds_patch.enabled")) {
            pluginFileConfigurationHolder_2.d("resource-pack.custom_blocks_sounds_patch.enabled", false);
        }
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "effects.text-effects.replace-in-customitems-name-and-lore", "effects.text-effects.customitems-name-and-lore.enabled", true);
        if (pluginFileConfigurationHolder_2.gP("items.fix_trades_guis_match_custom_items") && !(pluginFileConfigurationHolder_2.e("items.fix_trades_guis_match_custom_items", null) instanceof MemorySection)) {
            pluginFileConfigurationHolder_2.gQ("items.fix_trades_guis_match_custom_items");
        }
        if (pluginFileConfigurationHolder_2.gP("items.fix_trades_guis_match_custom_items.itemsadder_trade_machines.itemsadder_trade_machines")) {
            pluginFileConfigurationHolder_2.gQ("items.fix_trades_guis_match_custom_items.itemsadder_trade_machines.itemsadder_trade_machines");
        }
        pluginFileConfigurationHolder_2.gQ("items.show_item_durability");
        pluginFileConfigurationHolder_2.gQ("resource-pack.protect-player.black-screen");
        pluginFileConfigurationHolder_2.gQ("resource-pack.protect-player.hide-hud");
        pluginFileConfigurationHolder_2.gQ("resource-pack.protect-player.cancel-movement");
        if (pluginFileConfigurationHolder_2.gP("disable-MOB-behaviour__DISABLE_AT_YOUR_OWN_RISK")) {
            pluginFileConfigurationHolder_2.d("mobs.enabled", !pluginFileConfigurationHolder_2.hq("disable-MOB-behaviour__DISABLE_AT_YOUR_OWN_RISK"));
            pluginFileConfigurationHolder_2.gQ("disable-MOB-behaviour__DISABLE_AT_YOUR_OWN_RISK");
        }
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, true, true, "blocks.custom.mushroom", "blocks.disable-REAL-behaviour__DISABLE_AT_YOUR_OWN_RISK", "blocks.disable-REAL");
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, true, true, "blocks.custom.chorus", "blocks.disable-REAL_TRANSPARENT-behaviour__DISABLE_AT_YOUR_OWN_RISK", "blocks.disable-REAL_TRANSPARENT");
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, true, true, "blocks.custom.note", "blocks.disable-REAL_NOTE-behaviour__DISABLE_AT_YOUR_OWN_RISK", "blocks.disable-REAL_NOTE");
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, false, true, "blocks.custom.wire", "blocks.disable-REAL_WIRE-behaviour__DISABLE_AT_YOUR_OWN_RISK", "blocks.disable-REAL_WIRE");
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, false, true, "blocks.custom.fire", "blocks.disable-CUSTOM_FIRE-behaviour", "blocks.disable-FIRE");
        pluginFileConfigurationHolder_2.gQ("blocks.convert-legacy-ia-region-files");
        pluginFileConfigurationHolder_2.gQ("disable-plugin-loading-messages_DONT_ASK_ME_FOR_SUPPORT_IF_YOU_SET_TRUE__THANKS");
        pluginFileConfigurationHolder_2.gQ("items.handle-wear-held-actions-on-unexpected-inventory-changes");
        pluginFileConfigurationHolder_2.gQ("ignore-server-compatibility-check");
        pluginFileConfigurationHolder_2.gQ("entities.custom-entitites.expert_users.bundle_packets");
        pluginFileConfigurationHolder_2.gQ("entities.custom-entitites.expert_users.fast_packets_creation");
        pluginFileConfigurationHolder_2.gQ("entities.allow-removing-old-furnitures_2_3_11");
        pluginFileConfigurationHolder_2.gQ("debug.worlds-populators.log-loading-no-world");
        pluginFileConfigurationHolder_2.gQ("debug.trees-populators.log-loading-no-world");
        pluginFileConfigurationHolder_2.gQ("debug.surface-decorators.log-loading-no-world");
        pluginFileConfigurationHolder_2.gQ("debug.cave-decorators.log-loading-no-world");
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, "debug.worlds-populators.log-generation", "debug.blocks-populators.log-generation", false);
        if (pluginFileConfigurationHolder_2.hq("recipes.custom-recipes.unlock.on-pickup.any") || pluginFileConfigurationHolder_2.hq("recipes.custom-recipes.unlock.on-pickup.ingredients")) {
            eY = true;
            pluginFileConfigurationHolder_2.d("recipes.custom-recipes.unlock.automatically", eY);
        }
        pluginFileConfigurationHolder_2.gQ("recipes.custom-recipes.unlock.on-pickup.any");
        pluginFileConfigurationHolder_2.gQ("recipes.custom-recipes.unlock.on-pickup.ingredients");
        pluginFileConfigurationHolder_2.gQ("recipes.custom-recipes.unlock.on-item-click.any");
        pluginFileConfigurationHolder_2.gQ("recipes.custom-recipes.unlock.on-item-click.ingredients");
        pluginFileConfigurationHolder_2.gQ("blocks.light-api");
        if (pluginFileConfigurationHolder_2.gP("resource-pack.apply-during-chunk-load-phase")) {
            pluginFileConfigurationHolder_2.d("resource-pack.apply_during_chunk_load_phase", pluginFileConfigurationHolder_2.hq("resource-pack.apply-during-chunk-load-phase"));
            pluginFileConfigurationHolder_2.gQ("resource-pack.apply-during-chunk-load-phase");
        }
        if (pluginFileConfigurationHolder_2.gP("resource-pack.apply-on-join")) {
            pluginFileConfigurationHolder_2.d("resource-pack.apply_on_join.enabled", pluginFileConfigurationHolder_2.hq("resource-pack.apply-on-join"));
            pluginFileConfigurationHolder_2.gQ("resource-pack.apply-on-join");
        }
        if (pluginFileConfigurationHolder_2.gP("resource-pack.delay-ticks")) {
            pluginFileConfigurationHolder_2.d("resource-pack.apply_on_join.delay_ticks", pluginFileConfigurationHolder_2.gW("resource-pack.delay-ticks"));
            pluginFileConfigurationHolder_2.gQ("resource-pack.delay-ticks");
        }
        if (pluginFileConfigurationHolder_2.gP("resource-pack.notify-other-plugins-interfering")) {
            pluginFileConfigurationHolder_2.d("resource-pack.notify_other_plugins_resourcepacks", pluginFileConfigurationHolder_2.hq("resource-pack.notify-other-plugins-interfering"));
            pluginFileConfigurationHolder_2.gQ("resource-pack.notify-other-plugins-interfering");
        }
        if (pluginFileConfigurationHolder_2.gP("resource-pack.expert_users.allow_other_plugins_resourcepacks")) {
            pluginFileConfigurationHolder_2.d("resource-pack.allow_other_plugins_resourcepacks", pluginFileConfigurationHolder_2.hq("resource-pack.expert_users.allow_other_plugins_resourcepacks"));
            pluginFileConfigurationHolder_2.gQ("resource-pack.expert_users.allow_other_plugins_resourcepacks");
        }
        pluginFileConfigurationHolder_2.gQ("debug.resource-pack");
        if (pluginFileConfigurationHolder_2.gP("resource-pack.pre_1_21_3_shaders_fix.enabled")) {
            pluginFileConfigurationHolder_2.d("resource-pack.pre_1_21_2_shaders_fix.enabled", pluginFileConfigurationHolder_2.hq("resource-pack.pre_1_21_3_shaders_fix.enabled"));
            pluginFileConfigurationHolder_2.gQ("resource-pack.pre_1_21_3_shaders_fix.enabled");
        }
        if (pluginFileConfigurationHolder_2.gP("resource-pack.apply_on_join.enabled")) {
            pluginFileConfigurationHolder_2.d("resource-pack.auto_apply.enabled", pluginFileConfigurationHolder_2.hq("resource-pack.apply_on_join.enabled"));
        }
        if (pluginFileConfigurationHolder_2.gP("resource-pack.apply_during_chunk_load_phase")) {
            pluginFileConfigurationHolder_2.d("resource-pack.auto_apply.before_join", pluginFileConfigurationHolder_2.hq("resource-pack.apply_during_chunk_load_phase"));
        }
        pluginFileConfigurationHolder_2.gQ("resource-pack.apply_during_chunk_load_phase");
        pluginFileConfigurationHolder_2.gQ("resource-pack.apply_on_join");
        pluginFileConfigurationHolder_2.gQ("debug.recipes.log-recipes-unknown-item");
        if (pluginFileConfigurationHolder_2.gP("effects.text-effects.hide-scoreboard-numbers")) {
            pluginFileConfigurationHolder_2.d("effects.text-effects.hide_scoreboard_numbers", pluginFileConfigurationHolder_2.hq("effects.text-effects.hide-scoreboard-numbers"));
            pluginFileConfigurationHolder_2.gQ("effects.text-effects.hide-scoreboard-numbers");
        }
        if (pluginFileConfigurationHolder_2.gP("effects.text-effects.hide-scoreboard-numbers-old-clients")) {
            pluginFileConfigurationHolder_2.d("effects.text-effects.hide_scoreboard_numbers_old_clients", pluginFileConfigurationHolder_2.hq("effects.text-effects.hide-scoreboard-numbers-old-clients"));
            pluginFileConfigurationHolder_2.gQ("effects.text-effects.hide-scoreboard-numbers-old-clients");
        }
        if (pluginFileConfigurationHolder_2.gP("effects.text-effects.customitem-name-and-lore")) {
            pluginFileConfigurationHolder_2.d("effects.text-effects.customitem_name_and_lore.enabled", pluginFileConfigurationHolder_2.hq("effects.text-effects.customitem-name-and-lore.enabled"));
            pluginFileConfigurationHolder_2.gQ("effects.text-effects.customitem-name-and-lore");
        }
        if (pluginFileConfigurationHolder_2.gP("font_images.replace-in-customitems-name-and-lore")) {
            pluginFileConfigurationHolder_2.d("font_images.customitem_name_and_lore.enabled", pluginFileConfigurationHolder_2.hq("font_images.replace-in-customitems-name-and-lore"));
            pluginFileConfigurationHolder_2.gQ("font_images.replace-in-customitems-name-and-lore");
        }
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, true, false, "font_images.chat.add_hover_suggestion", "font_images.chat.add-hover-suggestion");
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, true, false, "font_images.chat.tab_autocompletion_1_19_1_plus", "font_images.chat.tab-autocompletion_1_19_1_plus");
        if (pluginFileConfigurationHolder_2.gP("effects.text-effects")) {
            pluginFileConfigurationHolder_2.d("text_effects", pluginFileConfigurationHolder_2.CI().get("effects.text-effects"));
            pluginFileConfigurationHolder_2.gQ("effects.text-effects");
        }
        if (pluginFileConfigurationHolder_2.gP("effects")) {
            pluginFileConfigurationHolder_2.gQ("effects");
        }
        pluginFileConfigurationHolder_2.gQ("resource-pack.zip.fix_transparent_noteblocks");
        if (pluginFileConfigurationHolder_2.gP("entities.custom-entitites")) {
            pluginFileConfigurationHolder_2.d("entities.custom_entities", pluginFileConfigurationHolder_2.CI().get("entities.custom-entitites"));
            pluginFileConfigurationHolder_2.gQ("entities.custom-entitites");
        }
        pluginFileConfigurationHolder_2.gQ("blocks.campfire_enhancements");
        pluginFileConfigurationHolder_2.gQ("font_images.player-display-name.enabled");
        pluginFileConfigurationHolder_2.gQ("font_images.vault-prefix-suffix.enabled");
        pluginFileConfigurationHolder_2.gQ("huds.hide_if_pack_not_accepted");
        pluginFileConfigurationHolder_2.gQ("compatibility.worldguard.show_legacy_furniture_flags");
        if (pluginFileConfigurationHolder_2.gP("resource-pack.zip.generate-custom-armors-textures.optifine_nbt")) {
            pluginFileConfigurationHolder_2.d("resource-pack.zip.custom_armors_shaders_legacy.optifine.generate_cit.1_20_4_lower", pluginFileConfigurationHolder_2.hq("resource-pack.zip.generate-custom-armors-textures.optifine_nbt"));
            pluginFileConfigurationHolder_2.gQ("resource-pack.zip.generate-custom-armors-textures.optifine_nbt");
        }
        if (pluginFileConfigurationHolder_2.gP("resource-pack.zip.generate-custom-armors-textures.vanilla")) {
            pluginFileConfigurationHolder_2.d("resource-pack.zip.custom_armors_shaders_legacy.vanilla.generate_textures", pluginFileConfigurationHolder_2.hq("resource-pack.zip.generate-custom-armors-textures.vanilla"));
            pluginFileConfigurationHolder_2.gQ("resource-pack.zip.generate-custom-armors-textures.vanilla");
        }
        if (pluginFileConfigurationHolder_2.gP("resource-pack.zip.generate-custom-armors-textures.overwrite_leather_armor_layers_textures")) {
            pluginFileConfigurationHolder_2.d("resource-pack.zip.custom_armors_shaders_legacy.vanilla.overwrite_leather_layers", pluginFileConfigurationHolder_2.hq("resource-pack.zip.generate-custom-armors-textures.overwrite_leather_armor_layers_textures"));
            pluginFileConfigurationHolder_2.gQ("resource-pack.zip.generate-custom-armors-textures.overwrite_leather_armor_layers_textures");
        }
        if (pluginFileConfigurationHolder_2.gP("resource-pack.zip.generate-custom-armors-textures.1_21_5_plus_armors_shaders")) {
            pluginFileConfigurationHolder_2.d("resource-pack.zip.custom_armors_shaders_legacy.vanilla.generate_shader.1_21_5_plus", pluginFileConfigurationHolder_2.hq("resource-pack.zip.generate-custom-armors-textures.1_21_5_plus_armors_shaders"));
            pluginFileConfigurationHolder_2.gQ("resource-pack.zip.generate-custom-armors-textures.1_21_5_plus_armors_shaders");
        }
        if (pluginFileConfigurationHolder_2.gP("items.fix_unstackable_items_on_click")) {
            pluginFileConfigurationHolder_2.d("items.auto_update.on_stack_merge", pluginFileConfigurationHolder_2.hq("items.fix_unstackable_items_on_click"));
            pluginFileConfigurationHolder_2.d("items.auto_update.on_inventory_open", pluginFileConfigurationHolder_2.hq("items.fix_unstackable_items_on_click"));
            pluginFileConfigurationHolder_2.gQ("items.fix_unstackable_items_on_click");
        }
        if (pluginFileConfigurationHolder_2.gP("resource-pack.zip.custom_armors_shaders_legacy.vanilla.generate_textures")) {
            pluginFileConfigurationHolder_2.d("resource-pack.zip.custom_armors_shaders_legacy.enabled", pluginFileConfigurationHolder_2.hq("resource-pack.zip.custom_armors_shaders_legacy.vanilla.generate_textures"));
            pluginFileConfigurationHolder_2.gQ("resource-pack.zip.custom_armors_shaders_legacy.vanilla.generate_textures");
        }
        if (pluginFileConfigurationHolder_2.hq("resource-pack.zip.custom_armors_shaders_legacy.enabled")) {
            pluginFileConfigurationHolder_2.d("resource-pack.zip.custom_armors_shaders_legacy.vanilla.overwrite_leather_layers", false);
            pluginFileConfigurationHolder_2.d("resource-pack.zip.custom_armors_shaders_legacy.vanilla.generate_shader.1_21_4_lower", true);
            pluginFileConfigurationHolder_2.d("resource-pack.zip.custom_armors_shaders_legacy.vanilla.generate_shader.1_21_5_plus", true);
            pluginFileConfigurationHolder_2.d("resource-pack.zip.custom_armors_shaders_legacy.optifine.generate_cit.1_20_4_lower", false);
        }
        pluginFileConfigurationHolder_2.gQ("resource-pack.zip.custom_armors_shaders_legacy.enabled");
        if (pluginFileConfigurationHolder_2.gP("resource-pack.custom_blocks_sounds_patch.step.enabled")) {
            pluginFileConfigurationHolder_2.d("resource-pack.custom_blocks_sounds_patch.step", pluginFileConfigurationHolder_2.hq("resource-pack.custom_blocks_sounds_patch.step.enabled"));
            pluginFileConfigurationHolder_2.gQ("resource-pack.custom_blocks_sounds_patch.step.enabled");
            pluginFileConfigurationHolder_2.gQ("resource-pack.custom_blocks_sounds_patch.step.allow_non_player");
        }
        pluginFileConfigurationHolder_2.gQ("resource-pack.atlas_support");
        pluginFileConfigurationHolder_2.gQ("resource-pack.1_19_3_atlas_support");
        if (pluginFileConfigurationHolder_2.gP("resource-pack.zip.emotes.1_21_5_plus_shaders")) {
            pluginFileConfigurationHolder_2.d("resource-pack.zip.emotes.1_21_5_to_1_21_9_shaders", pluginFileConfigurationHolder_2.hq("resource-pack.zip.emotes.1_21_5_plus_shaders"));
            pluginFileConfigurationHolder_2.gQ("resource-pack.zip.emotes.1_21_5_plus_shaders");
        }
        if (pluginFileConfigurationHolder_2.gP("entities.custom_entities.expert_users.extract_shaders")) {
            pluginFileConfigurationHolder_2.d("resource-pack.zip.emotes.legacy_shaders", pluginFileConfigurationHolder_2.hq("entities.custom_entities.expert_users.extract_shaders"));
            pluginFileConfigurationHolder_2.gQ("entities.custom_entities.expert_users.extract_shaders");
        }
        if ((object = pluginFileConfigurationHolder_2.e("entities.custom_entities.emotes", null)) instanceof Boolean) {
            Boolean bl = (Boolean)object;
            pluginFileConfigurationHolder_2.gQ("entities.custom_entities.emotes");
            pluginFileConfigurationHolder_2.d("entities.custom_entities.emotes.enabled", bl);
        }
        if (pluginFileConfigurationHolder_2.gP("resource-pack.hosting.external-host.skip-url-file-type-check___DONT_ASK_HELP_IF_SET_TRUE")) {
            pluginFileConfigurationHolder_2.d("resource-pack.hosting.external-host.skip_url_file_type_check", pluginFileConfigurationHolder_2.hq("resource-pack.hosting.external-host.skip-url-file-type-check___DONT_ASK_HELP_IF_SET_TRUE"));
            pluginFileConfigurationHolder_2.gQ("resource-pack.hosting.external-host.skip-url-file-type-check___DONT_ASK_HELP_IF_SET_TRUE");
        }
        MaterialBarColorHolder.a(pluginFileConfigurationHolder_2, true, false, "resource-pack.zip.protect-file-from-unzip.short_texture_references", "resource-pack.zip.protect-file-from-unzip.obfuscate_texture_references");
        pluginFileConfigurationHolder_2.gQ("resource-pack.zip.protect-file-from-unzip.protection_4");
        pluginFileConfigurationHolder_2.save();
    }

    private static void a(PluginFileConfigurationHolder_2 pluginFileConfigurationHolder_2, boolean bl, boolean bl2, String string, String ... stringArray) {
        if (pluginFileConfigurationHolder_2.gP(string)) {
            for (String string2 : stringArray) {
                pluginFileConfigurationHolder_2.gQ(string2);
            }
            return;
        }
        boolean bl3 = bl;
        for (String string3 : stringArray) {
            if (!pluginFileConfigurationHolder_2.gP(string3)) continue;
            bl3 = pluginFileConfigurationHolder_2.hq(string3);
            pluginFileConfigurationHolder_2.gQ(string3);
        }
        if (bl2) {
            bl3 = !bl3;
        }
        pluginFileConfigurationHolder_2.d(string, bl3);
    }

    private static void a(PluginFileConfigurationHolder_2 pluginFileConfigurationHolder_2, String string, String string2, Object object) {
        if (pluginFileConfigurationHolder_2.gP(string)) {
            Object object2 = pluginFileConfigurationHolder_2.e(string, object);
            pluginFileConfigurationHolder_2.d(string, null);
            pluginFileConfigurationHolder_2.d(string2, object2);
        }
    }

    private static void b(PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        int n = 0;
        dg = null;
        if (pluginFileConfigurationHolder.gY("resource-pack.hosting.lobfile.enabled")) {
            if (!Version.isAtLeast((Version)Version.v1_17_R1)) {
                CommandSenderBridge_5.error(" ");
                CommandSenderBridge_5.error(" ");
                CommandSenderBridge_5.error("Error: lobfile hosting is only supported on Spigot 1.17+.");
                CommandSenderBridge_5.error(" ");
                CommandSenderBridge_5.error(" ");
                dg = LobfileEnum.NO_HOST;
            } else {
                dg = LobfileEnum.LOBFILE;
            }
            ++n;
        }
        if (pluginFileConfigurationHolder.gY("resource-pack.hosting.auto-external-host.enabled")) {
            dg = LobfileEnum.AUTO_EXTERNAL_LEGACY;
            ++n;
        }
        if (pluginFileConfigurationHolder.gY("resource-pack.hosting.simple_self_host.enabled")) {
            dg = LobfileEnum.SIMPLE_SELF_HOST;
            ++n;
        }
        if (pluginFileConfigurationHolder.gY("resource-pack.hosting.self-host.enabled")) {
            dg = LobfileEnum.SELF_HOST;
            ++n;
        }
        if (pluginFileConfigurationHolder.gY("resource-pack.hosting.external-host.enabled")) {
            dg = LobfileEnum.EXTERNAL;
            ++n;
        }
        if (pluginFileConfigurationHolder.gY("resource-pack.hosting.no-host.enabled")) {
            dg = LobfileEnum.NO_HOST;
            ++n;
        }
        if (dg == null) {
            dg = LobfileEnum.UNKNOWN;
            ++n;
        }
        if (n > 1) {
            CommandSenderBridge_5.error(" ");
            CommandSenderBridge_5.error(" ");
            CommandSenderBridge_5.error("Error: Please check your config.yml and see if you have enabled multiple host types.\nYou must enable one of them not all or none.");
            CommandSenderBridge_5.error(" ");
            CommandSenderBridge_5.error(" ");
            dg = LobfileEnum.UNKNOWN;
        }
    }

    public static boolean ao() {
        return eE || fr && eN;
    }

    public static boolean ap() {
        return fr || ft;
    }

    public static boolean aq() {
        return dP && dM;
    }

    public static boolean a(RealEnum realEnum) {
        switch (realEnum) {
            case REAL: {
                return cG;
            }
            case REAL_TRANSPARENT: {
                return cH;
            }
            case REAL_NOTE: {
                return cI;
            }
            case REAL_WIRE: {
                return cJ;
            }
            case FIRE: {
                return cK;
            }
            case TILE: {
                return true;
            }
            case ENTITY: {
                return cL;
            }
        }
        throw new IllegalArgumentException("Unknown type: " + String.valueOf((Object)realEnum));
    }

    public static boolean ar() {
        return cG || cH || cI || cJ || cK || cL;
    }

    static {
        fe = null;
    }
}
