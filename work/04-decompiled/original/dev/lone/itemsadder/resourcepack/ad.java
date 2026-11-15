package dev.lone.itemsadder.resourcepack;

import beer.devs.fastnbt.nms.Version;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.google.common.io.BaseEncoding;
import com.jayway.jsonpath.Predicate;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.ItemsAdderPackCompressedEvent$PackEntry;
import dev.lone.itemsadder.resourcepack.af;
import dev.lone.itemsadder.resourcepack.ag;
import dev.lone.itemsadder.resourcepack.ah;
import dev.lone.itemsadder.resourcepack.aj;
import dev.lone.itemsadder.resourcepack.ak;
import dev.lone.itemsadder.resourcepack.al;
import dev.lone.itemsadder.resourcepack.am;
import dev.lone.itemsadder.resourcepack.an;
import dev.lone.itemsadder.resourcepack.ao;
import dev.lone.itemsadder.resourcepack.ap;
import dev.lone.itemsadder.resourcepack.aq;
import dev.lone.itemsadder.resourcepack.ar;
import dev.lone.itemsadder.resourcepack.as;
import dev.lone.itemsadder.resourcepack.at;
import dev.lone.itemsadder.resourcepack.au;
import dev.lone.itemsadder.resourcepack.av;
import dev.lone.itemsadder.resourcepack.ba;
import dev.lone.itemsadder.resourcepack.be;
import dev.lone.itemsadder.resourcepack.bk;
import dev.lone.itemsadder.resourcepack.c;
import dev.lone.itemsadder.resourcepack.d;
import dev.lone.itemsadder.resourcepack.generator.file.data.a;
import dev.lone.itemsadder.resourcepack.generator.file.data.g;
import dev.lone.itemsadder.resourcepack.h;
import dev.lone.itemsadder.resourcepack.i;
import dev.lone.itemsadder.resourcepack.j;
import dev.lone.itemsadder.resourcepack.k;
import dev.lone.itemsadder.resourcepack.n;
import dev.lone.itemsadder.resourcepack.o;
import dev.lone.itemsadder.resourcepack.p;
import dev.lone.itemsadder.resourcepack.r;
import dev.lone.itemsadder.resourcepack.t;
import dev.lone.itemsadder.utils.json.b;
import itemsadder.m.ae;
import itemsadder.m.aiq;
import itemsadder.m.ayw;
import itemsadder.m.ayz;
import itemsadder.m.aza;
import itemsadder.m.azg;
import itemsadder.m.azh;
import itemsadder.m.azj;
import itemsadder.m.azk;
import itemsadder.m.azm;
import itemsadder.m.azn;
import itemsadder.m.azq;
import itemsadder.m.azr;
import itemsadder.m.azs;
import itemsadder.m.azt;
import itemsadder.m.azz;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbr;
import itemsadder.m.bce;
import itemsadder.m.bcm;
import itemsadder.m.bcp;
import itemsadder.m.bcy;
import itemsadder.m.bdb;
import itemsadder.m.bdq;
import itemsadder.m.bea;
import itemsadder.m.beb;
import itemsadder.m.da;
import itemsadder.m.dx;
import itemsadder.m.fw;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.qs;
import itemsadder.m.rc;
import itemsadder.m.sd;
import itemsadder.m.sk;
import itemsadder.m.tf;
import itemsadder.m.tg;
import itemsadder.m.ti;
import itemsadder.m.v;
import itemsadder.m.zw;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.invoke.CallSite;
import java.lang.runtime.SwitchBootstraps;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.security.CodeSource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ad {
    public static final String asb = "ia_overlay_1_21_4_plus";
    private static final int asc = 65;
    static final int asd = 88;
    private static final int ase = 9999;
    private static final int asf = 512;
    private static final String asg = "resource-pack-diagnostics.txt";
    private static final JSONObject ash = JSON.parseObject((String)"{\n  \"sources\": [\n    {\"type\":\"minecraft:directory\",\"prefix\":\"item/\",\"source\":\"item\"},\n    {\n      \"type\":\"minecraft:paletted_permutations\",\n      \"palette_key\":\"minecraft:trims/color_palettes/trim_palette\",\n      \"textures\":[\n        \"minecraft:trims/items/helmet_trim\",\n        \"minecraft:trims/items/chestplate_trim\",\n        \"minecraft:trims/items/leggings_trim\",\n        \"minecraft:trims/items/boots_trim\"\n      ],\n      \"permutations\":{\n        \"amethyst\":\"minecraft:trims/color_palettes/amethyst\",\n        \"copper\":\"minecraft:trims/color_palettes/copper\",\n        \"copper_darker\":\"minecraft:trims/color_palettes/copper_darker\",\n        \"diamond\":\"minecraft:trims/color_palettes/diamond\",\n        \"diamond_darker\":\"minecraft:trims/color_palettes/diamond_darker\",\n        \"emerald\":\"minecraft:trims/color_palettes/emerald\",\n        \"gold\":\"minecraft:trims/color_palettes/gold\",\n        \"gold_darker\":\"minecraft:trims/color_palettes/gold_darker\",\n        \"iron\":\"minecraft:trims/color_palettes/iron\",\n        \"iron_darker\":\"minecraft:trims/color_palettes/iron_darker\",\n        \"lapis\":\"minecraft:trims/color_palettes/lapis\",\n        \"netherite\":\"minecraft:trims/color_palettes/netherite\",\n        \"netherite_darker\":\"minecraft:trims/color_palettes/netherite_darker\",\n        \"quartz\":\"minecraft:trims/color_palettes/quartz\",\n        \"redstone\":\"minecraft:trims/color_palettes/redstone\",\n        \"resin\":\"minecraft:trims/color_palettes/resin\"\n      }\n    }\n  ]\n}\n");
    private static final JSONObject asi = JSON.parseObject((String)"{\n  \"sources\": [\n    {\"type\":\"minecraft:directory\",\"prefix\":\"block/\",\"source\":\"block\"},\n    {\"type\":\"minecraft:directory\",\"prefix\":\"entity/conduit/\",\"source\":\"entity/conduit\"},\n    {\"type\":\"minecraft:single\",\"resource\":\"minecraft:entity/bell/bell_body\"},\n    {\"type\":\"minecraft:single\",\"resource\":\"minecraft:entity/enchanting_table_book\"}\n  ]\n}\n");
    private final HashSet asj;
    public volatile boolean ask = false;
    public volatile boolean asl = false;
    azg asm;
    public HashMap asn;
    public HashMap aso;
    public HashMap asp;
    public HashMap asq;
    private final Map asr = new HashMap();
    public HashMap ass;
    Set ast;
    Set asu;
    Set asv = Set.of();
    final Map asw = new TreeMap();
    final Map asx = new TreeMap();
    final Map asy = new TreeMap();
    final Map asz = new TreeMap();
    final Map asA = new HashMap();
    p asB;
    final Map asC = new TreeMap();
    final Map asD = new HashMap();
    final Map asE = new TreeMap();
    final Map asF = new HashMap();
    private as asG = new as();
    private Consumer asH;
    private Consumer asI;
    private final am asJ;
    private final Map asK;
    private Set asL;
    @Nullable
    private ah asM;
    private Map asN;
    public JSONObject asO;
    public HashMap asP;
    public HashMap asQ;
    public JSONObject asR;
    public JSONObject asS;
    private Map asT;
    static Map asU = new HashMap();
    beb asV;
    private final Set asW;
    public List asX;
    JSONObject asY;
    static c asZ = new c();
    Set ata;
    r atb;

    ad() {
        this.asH = string -> {};
        this.asI = string -> {};
        this.asJ = new am();
        this.asK = new IdentityHashMap();
        this.asL = Set.of();
        this.asN = Map.of();
        this.asT = Map.of();
        this.asV = new beb();
        this.asW = new HashSet();
        this.asY = new JSONObject();
        this.ata = new HashSet();
        azr.Bu();
        bk.gr();
        this.asj = new HashSet();
    }

    public ad(av av2) {
        this.asH = string -> {};
        this.asI = string -> {};
        this.asJ = new am();
        this.asK = new IdentityHashMap();
        this.asL = Set.of();
        this.asN = Map.of();
        this.asT = Map.of();
        this.asV = new beb();
        this.asW = new HashSet();
        this.asY = new JSONObject();
        this.ata = new HashSet();
        azr.Bu();
        bk.gr();
        this.asj = new HashSet(Main.KO.hg("resource-pack.zip.ignore-files-ext"));
        this.asm = azg.aV(true);
        this.asn = new HashMap();
        this.aso = new HashMap();
        this.asp = new HashMap();
        this.asq = new HashMap();
        if (!(av2.aui instanceof azz) && ad.yX()) {
            bce.error(" ");
            bce.error(" ");
            bce.error(" ");
            bce.error(" ");
            bce.error("[Pack] &cERROR: please remove the &6resource-pack &csetting from &6server.properties &cfile. It's in the root folder of the server. Remove it and restart.");
            bce.error(" ");
            bce.error(" ");
            bce.error(" ");
            bce.error(" ");
        }
    }

    public static void yy() {
        CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
        if (codeSource != null) {
            Plugin plugin = Main.rT();
            boolean bl = false;
            int n2 = 0;
            try {
                InputStream inputStream;
                JarEntry jarEntry;
                Object object;
                File file = new File(codeSource.getLocation().toURI());
                try (JarFile jarFile = new JarFile(file);){
                    object = jarFile.entries();
                    while (object.hasMoreElements()) {
                        File file2;
                        jarEntry = object.nextElement();
                        String string = jarEntry.getName();
                        if (!string.startsWith("contents/") || jarEntry.isDirectory() || (file2 = new File(plugin.getDataFolder(), string)).exists()) continue;
                        inputStream = jarFile.getInputStream(jarEntry);
                        try {
                            if (!bl) {
                                bce.log(String.valueOf(ChatColor.AQUA) + "[Pack] Extracting default files...");
                                bl = true;
                            }
                            FileUtils.copyInputStreamToFile((InputStream)inputStream, (File)file2);
                            bce.log(String.valueOf(ChatColor.AQUA) + "[Pack] - Extracted " + (String)string);
                            ++n2;
                        }
                        finally {
                            if (inputStream == null) continue;
                            inputStream.close();
                        }
                    }
                }
                try {
                    boolean bl2 = false;
                    object = new File(String.valueOf(plugin.getDataFolder()) + "/contents/_iainternal/resourcepack/assets/_iainternal/font/gui.json");
                    if (((File)object).exists()) {
                        jarEntry = dev.lone.itemsadder.utils.json.c.N((File)object);
                        for (File file2 : jarEntry.getJSONArray("providers")) {
                            inputStream = (JSONObject)file2;
                            if (!inputStream.getString("file").equals("base/black.png")) continue;
                            inputStream.put("file", "char/black.png");
                            bl2 = true;
                        }
                        if (bl2) {
                            FileUtils.write((File)object, (CharSequence)dev.lone.itemsadder.utils.json.c.K((JSONObject)jarEntry));
                            ++n2;
                        }
                    }
                }
                catch (Throwable throwable) {
                    bce.error("[Pack] Failed to update old 'contents/_iainternal' files. Consider deleting the folder and regenerate your pack.", throwable);
                }
                if (n2 > 0) {
                    bce.log(String.valueOf(ChatColor.AQUA) + "[Pack] Extracted " + n2 + " default files.");
                }
            }
            catch (IOException | URISyntaxException exception) {
                bce.error("[Pack] ERROR EXTRACTING internal contents!", exception);
            }
        } else {
            bce.error("[Pack] ERROR EXTRACTING internal contents! Try to download the plugin JAR again and restart.");
        }
    }

    public static void f(JSONObject jSONObject) {
        if (jSONObject.containsKey("parent") && !jSONObject.getString("parent").equals("item/generated")) {
            return;
        }
        if (jSONObject.containsKey("gui_light")) {
            return;
        }
        jSONObject.put((Object)"gui_light", (Object)"front");
    }

    public static void b(String string, JSONObject jSONObject) {
        asU.put(string, jSONObject.getString("parent"));
        if (ae.di) {
            ad.r(jSONObject);
        }
        if (ae.dn) {
            ad.s(jSONObject);
        }
        if (ae.do) {
            ad.f(jSONObject);
        }
    }

    public File yz() {
        return new File(itemsadder.m.d.k);
    }

    public long yA() {
        return this.yz().length();
    }

    public boolean yB() {
        return this.yz().exists();
    }

    public String yC() {
        return FileUtils.byteCountToDisplaySize((long)this.yz().length());
    }

    public String yD() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.yz().lastModified()));
    }

    public String yE() {
        return bcy.K(this.yz()).replace("\\", "/");
    }

    public String yF() {
        return ad.q(this.yz());
    }

    private static String q(File file) {
        String string;
        try {
            byte[] byArray;
            try (FileInputStream fileInputStream = new FileInputStream(file);){
                byArray = DigestUtils.sha1((InputStream)fileInputStream);
            }
            string = byArray != null ? ad.c(byArray) : BaseEncoding.base16().lowerCase().encode("null".getBytes());
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return string;
    }

    private String b(String object, Function function) {
        InputStream inputStream;
        if (!((String)object).startsWith("/")) {
            object = "/" + (String)object;
        }
        if ((inputStream = this.getClass().getResourceAsStream((String)object)) != null) {
            String string = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
            string = (String)function.apply(string);
            return string;
        }
        throw new FileNotFoundException("Corrupted JAR! Can't find '" + (String)object + "' file inside the JAR!");
    }

    private String eF(String object) {
        InputStream inputStream;
        if (!((String)object).startsWith("/")) {
            object = "/" + (String)object;
        }
        if ((inputStream = this.getClass().getResourceAsStream((String)object)) != null) {
            return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
        }
        throw new FileNotFoundException("Corrupted JAR! Can't find '" + (String)object + "' file inside the JAR!");
    }

    public void a(@Nullable Consumer consumer, @Nullable bcm bcm2) {
        this.asl = false;
        this.ask = true;
        bcp.h(() -> {
            Object object;
            Throwable throwable;
            block81: {
                String string3;
                String string4;
                bce.log(String.valueOf(ChatColor.AQUA) + "[Pack] Compressing resource_pack ... ");
                boolean bl = false;
                throwable = null;
                File file = tf.py();
                @Nullable bbf bbf2 = tf.pz();
                Path path = bcy.iQ(itemsadder.m.d.k);
                Path path2 = path.resolveSibling(String.valueOf(path.getFileName()) + ".tmp");
                bbr.c("Preparing pack: version overlays...", 0.0);
                this.atb = new r(path2.toString(), this.asj);
                if (!this.asY.containsKey("overlays")) {
                    this.asY.put((Object)"overlays", (Object)new JSONObject());
                }
                if (!this.asY.getJSONObject("overlays").containsKey("entries")) {
                    this.asY.getJSONObject("overlays").put((Object)"entries", (Object)new JSONArray());
                }
                if (ae.dP) {
                    object = new JSONObject();
                    object.put((Object)"directory", (Object)"ia_overlay_1_20_5_plus");
                    ad.c((JSONObject)object, zw.k(Version.v1_20_5), 9999);
                    this.asY.getJSONObject("overlays").getJSONArray("entries").add(object);
                }
                object = new JSONObject();
                object.put((Object)"directory", (Object)"ia_overlay_1_21_2_plus");
                ad.c((JSONObject)object, zw.k(Version.v1_21_3), 9999);
                this.asY.getJSONObject("overlays").getJSONArray("entries").add(object);
                object = new JSONObject();
                object.put((Object)"directory", (Object)"ia_overlay_1_21_4_to_5");
                ad.c((JSONObject)object, zw.k(Version.v1_21_4), zw.k(Version.v1_21_5));
                this.asY.getJSONObject("overlays").getJSONArray("entries").add(object);
                object = new JSONObject();
                object.put((Object)"directory", (Object)asb);
                ad.c((JSONObject)object, zw.k(Version.v1_21_4), 9999);
                this.asY.getJSONObject("overlays").getJSONArray("entries").add(object);
                object = new JSONObject();
                object.put((Object)"directory", (Object)"ia_overlay_1_21_5");
                ad.c((JSONObject)object, zw.k(Version.v1_21_5), zw.k(Version.v1_21_5));
                this.asY.getJSONObject("overlays").getJSONArray("entries").add(object);
                object = new JSONObject();
                object.put((Object)"directory", (Object)"ia_overlay_1_21_6_to_11");
                ad.c((JSONObject)object, zw.k(Version.v1_21_6), zw.k(Version.v1_21_11));
                this.asY.getJSONObject("overlays").getJSONArray("entries").add(object);
                object = new JSONObject();
                object.put((Object)"directory", (Object)"ia_overlay_1_21_6_plus");
                ad.c((JSONObject)object, zw.k(Version.v1_21_6), 9999);
                this.asY.getJSONObject("overlays").getJSONArray("entries").add(object);
                object = new JSONObject();
                object.put((Object)"directory", (Object)"ia_overlay_modern_atlas");
                ad.c((JSONObject)object, zw.k(Version.v1_21_11), 9999);
                this.asY.getJSONObject("overlays").getJSONArray("entries").add(object);
                object = new JSONObject();
                object.put((Object)"directory", (Object)"ia_overlay_26_1_plus");
                ad.c((JSONObject)object, zw.k(Version.v26_1_2), 9999);
                this.asY.getJSONObject("overlays").getJSONArray("entries").add(object);
                object = new JSONObject();
                object.put((Object)"directory", (Object)"ia_overlay_26_2_plus");
                ad.c((JSONObject)object, 88, 9999);
                this.asY.getJSONObject("overlays").getJSONArray("entries").add(object);
                bbr.bf("Preparing pack: generating " + this.asn.size() + " modern item definitions...");
                this.asn.forEach((string, jSONObject) -> {
                    new h().a(this.aso, i.v_1_21_4_to_5, (String)string, (JSONObject)jSONObject);
                    new h().a(this.aso, i.v_1_21_6_plus, (String)string, (JSONObject)jSONObject);
                    new h().a(this.aso, i.v_26_1_plus, (String)string, (JSONObject)jSONObject);
                });
                object = (HashMap)this.aso.get((Object)i.v_1_21_6_plus);
                HashMap hashMap2 = (HashMap)this.aso.get((Object)i.v_26_1_plus);
                ((HashMap)object).forEach((string, at2) -> {
                    if (hashMap2.containsKey(string)) {
                        at at3 = (at)hashMap2.get(string);
                        if (at2.aud == at3.aud) {
                            hashMap2.remove(string);
                        }
                    }
                });
                bbr.bf("Preparing pack: text shaders...");
                if (ae.ap()) {
                    try {
                        string4 = this.b("internal/shaders/text_effects/legacy/rendertype_text.vsh", ad::eO);
                        this.atb.Q(string4, "assets/minecraft/shaders/core/rendertype_text.vsh");
                        string3 = this.b("internal/shaders/text_effects/ia_overlay_1_21_6_to_11/rendertype_text.vsh", ad::eO);
                        this.atb.Q(string3, "ia_overlay_1_21_6_to_11/assets/minecraft/shaders/core/rendertype_text.vsh");
                        string3 = this.b("internal/shaders/text_effects/ia_overlay_26_1_plus/rendertype_text.vsh", ad::eO);
                        this.atb.Q(string3, "ia_overlay_26_1_plus/assets/minecraft/shaders/core/rendertype_text.vsh");
                        string3 = this.b("internal/shaders/text_effects/ia_overlay_26_2_plus/text.vsh", ad::eO);
                        this.atb.Q(string3, "ia_overlay_26_2_plus/assets/minecraft/shaders/core/text.vsh");
                        this.atb.P("internal/shaders/text_effects/legacy/rendertype_text.json", "assets/minecraft/shaders/core/rendertype_text.json");
                        this.atb.P("internal/shaders/text_effects/ia_overlay_1_21_2_plus/rendertype_text.json", "ia_overlay_1_21_2_plus/assets/minecraft/shaders/core/rendertype_text.json");
                    }
                    catch (FileNotFoundException fileNotFoundException) {
                        bce.error("Error replacing placeholders in shader.", fileNotFoundException);
                    }
                }
                string4 = null;
                string3 = null;
                String string5 = null;
                bbr.bf("Preparing pack: armor shaders and textures...");
                if (ae.ds) {
                    if (this.asm.Bh()) {
                        if (ae.dv) {
                            var14_20 = this.b("internal/shaders/armors/legacy/rendertype_armor_cutout_no_cull.fsh", (T string) -> {
                                string = string.replace("%TEX_RES%", String.valueOf(this.asm.axA));
                                return string;
                            });
                            this.atb.Q((String)var14_20, "assets/minecraft/shaders/core/rendertype_armor_cutout_no_cull.fsh");
                            this.atb.P("internal/shaders/armors/legacy/rendertype_armor_cutout_no_cull.json", "assets/minecraft/shaders/core/rendertype_armor_cutout_no_cull.json");
                            this.atb.P("internal/shaders/armors/legacy/rendertype_armor_cutout_no_cull.vsh", "assets/minecraft/shaders/core/rendertype_armor_cutout_no_cull.vsh");
                            this.atb.P("internal/shaders/armors/ia_overlay_1_21_2_plus/rendertype_armor_cutout_no_cull.json", "ia_overlay_1_21_2_plus/assets/minecraft/shaders/core/rendertype_armor_cutout_no_cull.json");
                        }
                        if (ae.dw) {
                            string4 = this.b("internal/shaders/armors_emotes/ia_overlay_1_21_5/entity.fsh", this::eP);
                            string3 = this.b("internal/shaders/armors_emotes/ia_overlay_1_21_6_plus/entity.fsh", this::eP);
                            string5 = this.r(this.eF("internal/shaders/armors_emotes/ia_overlay_26_1_plus/entity.fsh"), true);
                        }
                        this.atb.a(this.asm.axD, "assets/minecraft/textures/models/armor/leather_layer_1.png");
                        this.atb.a(this.asm.axE, "assets/minecraft/textures/models/armor/leather_layer_2.png");
                        this.atb.a(this.asm.axD, "ia_overlay_1_21_2_plus/assets/minecraft/textures/entity/equipment/humanoid/leather.png", true);
                        this.atb.a(this.asm.axE, "ia_overlay_1_21_2_plus/assets/minecraft/textures/entity/equipment/humanoid_leggings/leather.png", true);
                        this.atb.P("internal/textures/models/armor/leather_layer_1_overlay.png", "assets/minecraft/textures/models/armor/leather_layer_1_overlay.png");
                        this.atb.P("internal/textures/models/armor/leather_layer_2_overlay.png", "assets/minecraft/textures/models/armor/leather_layer_2_overlay.png");
                        this.atb.P("internal/textures/models/armor/leather_layer_1_overlay.png", "ia_overlay_1_21_2_plus/assets/minecraft/textures/entity/equipment/humanoid/leather_overlay.png");
                        this.atb.P("internal/textures/models/armor/leather_layer_2_overlay.png", "ia_overlay_1_21_2_plus/assets/minecraft/textures/entity/equipment/humanoid_leggings/leather_overlay.png");
                    } else {
                        var14_20 = this.asm.axD == null ? "assets/minecraft/textures/models/armor/leather_layer_1.png" : "assets/minecraft/textures/models/armor/leather_layer_2.png";
                        bce.error("Failed to generate custom armor atlas: '" + (String)var14_20 + "' was not generated.");
                    }
                    if (ae.dt) {
                        this.asm.axL.forEach((string, byteArrayOutputStream) -> this.atb.a((ByteArrayOutputStream)byteArrayOutputStream, (String)string));
                    }
                    for (Map.Entry entry : this.asm.axM) {
                        this.atb.eo((String)((Object)entry));
                    }
                    this.atb.eo("assets/minecraft/textures/models/armor/leather_layer_1.png");
                    this.atb.eo("assets/minecraft/textures/models/armor/leather_layer_2.png");
                    this.atb.eo("assets/minecraft/textures/models/armor/leather_layer_1_overlay.png");
                    this.atb.eo("assets/minecraft/textures/models/armor/leather_layer_2_overlay.png");
                    this.atb.eo("assets/minecraft/textures/entity/equipment/humanoid/leather.png");
                    this.atb.eo("assets/minecraft/textures/entity/equipment/humanoid_leggings/leather.png");
                    this.atb.P("internal/emissive.properties", "assets/minecraft/optifine/emissive.properties");
                    this.asm.clear();
                } else {
                    this.a(this.atb);
                    if (itemsadder.m.d.g().w()) {
                        bce.warn("Found custom armors but you disabled `generate-custom-armors-textures`. Armors might not show.");
                    }
                }
                bbr.bf("Preparing pack: emote models and shaders...");
                if (ae.dM) {
                    this.atb.P("internal/player/parm_left_3.json", "assets/_iainternal/models/entity/player/parm_left_3.json");
                    this.atb.P("internal/player/parm_right_4.json", "assets/_iainternal/models/entity/player/parm_right_4.json");
                    this.atb.P("internal/player/pbody_2.json", "assets/_iainternal/models/entity/player/pbody_2.json");
                    this.atb.P("internal/player/phead_0.json", "assets/_iainternal/models/entity/player/phead_0.json");
                    this.atb.P("internal/player/pleg_left_1.json", "assets/_iainternal/models/entity/player/pleg_left_1.json");
                    this.atb.P("internal/player/pleg_right_5.json", "assets/_iainternal/models/entity/player/pleg_right_5.json");
                    this.atb.P("internal/player/sus_6.json", "assets/_iainternal/models/entity/player/sus_6.json");
                    for (int i3 = 0; i3 < 6; ++i3) {
                        this.atb.P("internal/player/sus_6.json", "assets/_iainternal/models/entity/player/dummy_" + i3 + ".json");
                    }
                    if (ae.dP) {
                        this.atb.P("internal/shaders/emotes/legacy/rendertype_entity_translucent.fsh", "assets/minecraft/shaders/core/rendertype_entity_translucent.fsh");
                        this.atb.P("internal/shaders/emotes/legacy/rendertype_entity_translucent.vsh", "assets/minecraft/shaders/core/rendertype_entity_translucent.vsh");
                        this.atb.P("internal/shaders/emotes/legacy/rendertype_entity_translucent.json", "assets/minecraft/shaders/core/rendertype_entity_translucent.json");
                        this.atb.P("internal/shaders/emotes/ia_overlay_1_21_2_plus/rendertype_entity_translucent.json", "ia_overlay_1_21_2_plus/assets/minecraft/shaders/core/rendertype_entity_translucent.json");
                        this.atb.P("internal/shaders/emotes/ia_overlay_1_20_5_plus/rendertype_entity_translucent.vsh", "ia_overlay_1_20_5_plus/assets/minecraft/shaders/core/rendertype_entity_translucent.vsh");
                    }
                    if (ae.dx) {
                        if (string4 == null) {
                            string4 = this.eF("internal/shaders/armors_emotes/ia_overlay_1_21_5/entity.fsh");
                        }
                        if (string3 == null) {
                            string3 = this.eF("internal/shaders/armors_emotes/ia_overlay_1_21_6_plus/entity.fsh");
                        }
                        if (string5 == null) {
                            string5 = this.r(this.eF("internal/shaders/armors_emotes/ia_overlay_26_1_plus/entity.fsh"), false);
                        }
                    }
                    if (ae.dy) {
                        this.atb.P("internal/player/1_21_4_plus/_iainternal/textures/item/player_model/player_model_pixel.png", "ia_overlay_1_21_4_plus/assets/_iainternal/textures/item/player_model/player_model_pixel.png");
                        Map map = new ba().zG();
                        for (Object object2 : map.entrySet()) {
                            this.atb.a((byte[])object2.getValue(), "assets/" + bcy.iR((String)object2.getKey()));
                        }
                    }
                }
                if (string4 != null) {
                    if (!ae.dw) {
                        string4 = string4.replaceAll("(?s)//%START_CUSTOM_ARMORS_VARS%.*?//%END_CUSTOM_ARMORS_VARS%", "").replaceAll("(?s)//%START_CUSTOM_ARMORS%.*?//%END_CUSTOM_ARMORS%", "");
                    }
                    String string6 = this.eF("internal/shaders/armors_emotes/ia_overlay_1_21_5/entity.vsh");
                    if (!ae.dM || !ae.dx) {
                        string6 = string6.replaceAll("(?s)//%START_EMOTES%.*?//%END_EMOTES%", "");
                    }
                    this.atb.Q(string4, "ia_overlay_1_21_5/assets/minecraft/shaders/core/entity.fsh");
                    this.atb.Q(string6, "ia_overlay_1_21_5/assets/minecraft/shaders/core/entity.vsh");
                }
                if (string3 != null) {
                    Map.Entry entry;
                    if (!ae.dw) {
                        string3 = string3.replaceAll("(?s)//%START_CUSTOM_ARMORS_VARS%.*?//%END_CUSTOM_ARMORS_VARS%", "").replaceAll("(?s)//%START_CUSTOM_ARMORS%.*?//%END_CUSTOM_ARMORS%", "");
                    }
                    String string7 = this.eF("internal/shaders/armors_emotes/ia_overlay_1_21_6_plus/entity.vsh");
                    if (!ae.dM || !ae.dx) {
                        string7 = string7.replaceAll("(?s)//%START_EMOTES%.*?//%END_EMOTES%", "");
                    }
                    this.atb.Q(string3, "ia_overlay_1_21_6_plus/assets/minecraft/shaders/core/entity.fsh");
                    this.atb.Q(string7, "ia_overlay_1_21_6_plus/assets/minecraft/shaders/core/entity.vsh");
                    entry = this.eF("internal/shaders/armors_emotes/ia_overlay_26_1_plus/entity.vsh");
                    if (!ae.dw) {
                        string5 = string5.replaceAll("(?s)//%START_CUSTOM_ARMORS_VARS%.*?//%END_CUSTOM_ARMORS_VARS%", "").replaceAll("(?s)//%START_CUSTOM_ARMORS%.*?//%END_CUSTOM_ARMORS%", "");
                    }
                    if (!ae.dM || !ae.dx) {
                        entry = ((String)((Object)entry)).replaceAll("(?s)//%START_EMOTES%.*?//%END_EMOTES%", "");
                    }
                    this.atb.Q(string5, "ia_overlay_26_1_plus/assets/minecraft/shaders/core/entity.fsh");
                    this.atb.Q((String)((Object)entry), "ia_overlay_26_1_plus/assets/minecraft/shaders/core/entity.vsh");
                }
                bbr.bf("Preparing pack: generated models, textures and languages...");
                this.atb.P("internal/textures/item/empty.png", "assets/minecraft/textures/item/empty.png");
                this.atb.P("internal/textures/char/black.png", "assets/minecraft/textures/char/black.png");
                this.atb.P("internal/textures/item/iamissing.png", "assets/minecraft/textures/item/iamissing.png");
                this.atb.P("internal/models/item/base/furniture_big_painting.json", "assets/minecraft/models/item/base/furniture_big_painting.json");
                this.atb.P("internal/models/item/base/furniture_long_painting.json", "assets/minecraft/models/item/base/furniture_long_painting.json");
                this.atb.P("internal/models/item/base/furniture_painting.json", "assets/minecraft/models/item/base/furniture_painting.json");
                this.atb.P("internal/models/item/base/furniture_tall_painting.json", "assets/minecraft/models/item/base/furniture_tall_painting.json");
                this.atb.P("internal/models/block/base/block_tile.json", "assets/minecraft/models/block/base/block_tile.json");
                this.atb.P("internal/models/block/original/brown_mushroom_block.json", "assets/minecraft/models/block/original/brown_mushroom_block.json");
                this.atb.P("internal/models/block/original/chorus_plant.json", "assets/minecraft/models/block/original/chorus_plant.json");
                this.atb.P("internal/models/block/original/mushroom_stem.json", "assets/minecraft/models/block/original/mushroom_stem.json");
                this.atb.P("internal/models/block/original/note_block.json", "assets/minecraft/models/block/original/note_block.json");
                this.atb.P("internal/models/block/original/red_mushroom_block.json", "assets/minecraft/models/block/original/red_mushroom_block.json");
                this.atb.P("internal/models/block/crop_cross.json", "assets/minecraft/models/block/crop_cross.json");
                this.atb.P("internal/models/block/spawner.json", "assets/minecraft/models/block/spawner.json");
                this.atb.P("internal/models/block/crop_billboard.json", "assets/minecraft/models/block/crop_billboard.json");
                this.asn.forEach((string, jSONObject) -> this.atb.d((JSONObject)jSONObject, "assets/minecraft/models/item/" + string + ".json"));
                this.asp.forEach((string, jSONObject) -> this.atb.b((JSONObject)jSONObject, (String)string));
                this.asq.forEach((string, jSONObject) -> this.atb.d((JSONObject)jSONObject, (String)string));
                this.asr.forEach((string, byArray) -> this.atb.a(new ByteArrayInputStream((byte[])byArray), (String)string, false));
                this.ass.forEach((string, jSONObject) -> this.atb.d((JSONObject)jSONObject, (String)string));
                this.asP.forEach((string, string2) -> this.atb.e((String)string2, "assets/minecraft/lang/" + string + ".json", false));
                this.atb.c(this.asO, "assets/minecraft/font/default.json");
                if (ae.ez) {
                    this.atb.c(this.asO, "assets/minecraft/font/uniform.json");
                }
                this.atb.P("internal/block_outline/block_outline.json", "assets/minecraft/items/block_outline.json");
                this.atb.P("internal/block_outline/block_outline_model.json", "assets/minecraft/models/item/block_outline.json");
                bbr.bf("Preparing pack: equipment and tooltip assets...");
                if (Version.isAtLeast((Version)Version.v1_21_3)) {
                    itemsadder.m.d.g().F().forEach((namespacedKey, ro2) -> {
                        bce.log("###### Generating equipment: " + String.valueOf(namespacedKey));
                        JSONObject jSONObject = ro2.ow();
                        if (ro2.ov()) {
                            File file = itemsadder.m.d.s(itemsadder.m.d.g(ro2.ox().getNamespace(), ro2.oA()));
                            if (file == null) {
                                bce.error("Failed to find equipment wings texture for " + String.valueOf(namespacedKey) + ". This is probably a bug.");
                                return;
                            }
                            this.atb.a(file, "ia_overlay_1_21_2_plus/assets/" + namespacedKey.getNamespace() + "/textures/entity/equipment/wings/" + namespacedKey.getKey() + ".png", false);
                            this.atb.d(jSONObject, "ia_overlay_1_21_2_plus/assets/" + namespacedKey.getNamespace() + "/models/equipment/" + namespacedKey.getKey() + ".json");
                            this.atb.d(jSONObject, "ia_overlay_1_21_4_plus/assets/" + namespacedKey.getNamespace() + "/equipment/" + namespacedKey.getKey() + ".json");
                            return;
                        }
                        File file = itemsadder.m.d.s(itemsadder.m.d.g(ro2.ox().getNamespace(), ro2.oy()));
                        File file2 = itemsadder.m.d.s(itemsadder.m.d.g(ro2.ox().getNamespace(), ro2.oz()));
                        if (file == null || file2 == null) {
                            bce.error("Failed to find equipment texture for " + String.valueOf(namespacedKey) + ". This may be an ItemsAdder bug.");
                            return;
                        }
                        this.atb.a(file, "ia_overlay_1_21_2_plus/assets/" + namespacedKey.getNamespace() + "/textures/entity/equipment/humanoid/" + namespacedKey.getKey() + ".png", false);
                        this.atb.a(file2, "ia_overlay_1_21_2_plus/assets/" + namespacedKey.getNamespace() + "/textures/entity/equipment/humanoid_leggings/" + namespacedKey.getKey() + ".png", false);
                        this.atb.d(jSONObject, "ia_overlay_1_21_2_plus/assets/" + namespacedKey.getNamespace() + "/models/equipment/" + namespacedKey.getKey() + ".json");
                        this.atb.d(jSONObject, "ia_overlay_1_21_4_plus/assets/" + namespacedKey.getNamespace() + "/equipment/" + namespacedKey.getKey() + ".json");
                        for (a a2 : this.asV) {
                            String string;
                            File file3 = a2.BE();
                            if (file3.equals(file)) {
                                string = a2.BF();
                                bce.iA("----Found used model texture: " + a2.ayo + " -> " + string);
                                try {
                                    this.atb.a(FileUtils.openInputStream((File)file), string, false);
                                }
                                catch (IOException iOException) {
                                    iOException.printStackTrace();
                                }
                                continue;
                            }
                            if (!file3.equals(file2)) continue;
                            string = a2.BF();
                            bce.iA("----Found used model texture: " + a2.ayo + " -> " + string);
                            try {
                                this.atb.a(FileUtils.openInputStream((File)file2), string, false);
                            }
                            catch (IOException iOException) {
                                iOException.printStackTrace();
                            }
                        }
                    });
                    itemsadder.m.d.g().G().forEach(namespacedKey -> {
                        File file;
                        File file2 = itemsadder.m.d.s(itemsadder.m.d.g(null, String.valueOf(namespacedKey) + "_background"));
                        File file3 = itemsadder.m.d.s(itemsadder.m.d.g(null, String.valueOf(namespacedKey) + "_frame"));
                        if (file2 == null || file3 == null) {
                            bce.error("Failed to find tooltip background texture for " + String.valueOf(namespacedKey) + ". This may be an ItemsAdder bug.");
                            return;
                        }
                        bce.log(String.valueOf(ChatColor.AQUA) + "###### Generating tooltip: " + String.valueOf(namespacedKey));
                        this.atb.a(file2, "ia_overlay_1_21_2_plus/assets/" + namespacedKey.getNamespace() + "/textures/gui/sprites/tooltip/" + namespacedKey.getKey() + "_background.png", false);
                        this.atb.a(file3, "ia_overlay_1_21_2_plus/assets/" + namespacedKey.getNamespace() + "/textures/gui/sprites/tooltip/" + namespacedKey.getKey() + "_frame.png", false);
                        File file4 = itemsadder.m.d.s(itemsadder.m.d.g(null, String.valueOf(namespacedKey) + "_background") + ".mcmeta");
                        if (file4 != null) {
                            this.atb.a(file4, "ia_overlay_1_21_2_plus/assets/" + namespacedKey.getNamespace() + "/textures/gui/sprites/tooltip/" + namespacedKey.getKey() + "_background.png.mcmeta", false);
                        }
                        if ((file = itemsadder.m.d.s(itemsadder.m.d.g(null, String.valueOf(namespacedKey) + "_frame") + ".mcmeta")) != null) {
                            this.atb.a(file, "ia_overlay_1_21_2_plus/assets/" + namespacedKey.getNamespace() + "/textures/gui/sprites/tooltip/" + namespacedKey.getKey() + "_frame.png.mcmeta", false);
                        }
                    });
                }
                bbr.bf("Preparing pack: collecting referenced textures...");
                this.asV.forEach(a2 -> {
                    File file = a2.BE();
                    if (!file.exists()) {
                        return;
                    }
                    this.atb.a(file, a2.BF(), false);
                });
                this.atb.d(this.asY, "pack.mcmeta");
                this.aso.forEach((i2, hashMap) -> hashMap.forEach((string, at2) -> this.atb.d(at2.LP, i2.mj() + "/assets/minecraft/items/" + string + ".json")));
                bbr.bf("Preparing pack: scanning remaining files...");
                this.atb.yl();
                this.asD.clear();
                bbr.bf("Preparing pack: planning modern atlases...");
                this.yK();
                if (this.asB != null) {
                    this.asB.yh().forEach((string, jSONObject) -> {
                        String string2 = "ia_overlay_modern_atlas/" + o.em(string);
                        this.atb.b(this.eI(string2), string2, true);
                    });
                    ((HashMap)object).forEach((string, at2) -> this.atb.b(this.p(at2.LP), "ia_overlay_modern_atlas/assets/minecraft/items/" + string + ".json", true));
                    hashMap2.forEach((string, at2) -> {
                        JSONObject jSONObject = this.p(at2.LP);
                        at2.LP.clear();
                        at2.LP.putAll((Map)jSONObject);
                        at2.aud = at2.LP.hashCode();
                    });
                    this.asq.forEach((string, jSONObject) -> this.atb.b(this.p((JSONObject)jSONObject), "ia_overlay_modern_atlas/" + string, true));
                }
                bbr.bf("Preparing pack: writing atlas metadata...");
                this.yV();
                this.asQ.forEach((string, jSONObject) -> {
                    JSONObject jSONObject2 = this.q((JSONObject)jSONObject);
                    this.atb.d(jSONObject2, "ia_overlay_modern_atlas/assets/minecraft/atlases/" + string);
                });
                this.atb.d(this.q(this.asR), "assets/minecraft/atlases/blocks.json");
                bbr.bf("Preparing pack: validating final contents...");
                this.yH();
                bbr.bf("Processing pack sounds...");
                if (!tf.pA().isEmpty()) {
                    for (Map.Entry entry : tf.pA().entrySet()) {
                        Object object2;
                        object2 = (String)entry.getKey();
                        List list = (List)entry.getValue();
                        bce.iA("\ud83d\udd0a Generating sounds: " + (String)object2);
                        JSONObject jSONObject2 = this.asT.computeIfAbsent(object2, string -> new JSONObject());
                        for (tg tg2 : list) {
                            JSONObject jSONObject3 = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            jSONObject3.put((Object)"sounds", (Object)jSONArray);
                            if (tg2.pF() != null) {
                                jSONObject3.put((Object)"replace", (Object)tg2.pF());
                            }
                            if (tg2.pE() != null) {
                                jSONObject3.put((Object)"subtitle", (Object)tg2.pE());
                            }
                            for (ti ti2 : tg2.pC()) {
                                JSONObject jSONObject4 = ad.a(ti2, (String)object2);
                                jSONArray.add((Object)jSONObject4);
                                if (itemsadder.m.h.M().P()) {
                                    File file2 = ti2.pL();
                                    itemsadder.m.i i4 = new itemsadder.m.i(ti2.pT(), ti2.pU());
                                    if (i4.U()) {
                                        String string8 = "assets/" + (String)object2 + "/sounds/" + ti2.pK() + ".ogg";
                                        File file3 = new File(file, ti2.pK() + ".ogg");
                                        bbg bbg2 = tf.a(bbf2, file2);
                                        if (bbg2.a("last_modified", 0L) >= file2.lastModified() && bbg2.gP("duration") && Objects.equals(bbg2.c("bitrate_quality", (Integer)null), i4.bv) && Objects.equals(bbg2.a("mono", (Boolean)null), i4.bw)) {
                                            this.atb.a(file3, string8, false, true);
                                            bce.iA("Processed sound: " + ti2.pK() + ". Namespace '" + (String)object2 + "' (cached).");
                                        } else {
                                            try {
                                                float f2 = (float)itemsadder.m.h.M().d(file2);
                                                file3 = itemsadder.m.h.M().a(file2, file3, i4);
                                                bbg2.d("duration", Float.valueOf(f2));
                                                bbg2.d("last_modified", file2.lastModified());
                                                bbg2.d("path_source", (Object)file2.getAbsolutePath());
                                                bbg2.d("path_destination", (Object)file2.getAbsolutePath());
                                                bbg2.d("bitrate_quality", i4.bv);
                                                bbg2.d("mono", i4.bw);
                                                this.atb.a(file3, string8, false, true);
                                                bce.iA("Processed sound: " + ti2.pK() + ". Namespace '" + (String)object2 + "'.");
                                            }
                                            catch (IOException | InterruptedException exception) {
                                                bce.warn("Failed to process sound " + ti2.pK() + ".ogg. " + exception.getMessage());
                                            }
                                        }
                                    }
                                }
                                jSONObject2.put((Object)tg2.fN(), (Object)jSONObject3);
                            }
                        }
                        bce.iA("Saved sounds: " + jSONObject2.toJSONString(new JSONWriter.Feature[0]));
                    }
                }
                if (this.asS != null) {
                    azt.H(this.asS);
                }
                this.asT.forEach((string, jSONObject) -> this.atb.d((JSONObject)jSONObject, "assets/" + string + "/sounds.json"));
                bl = this.atb.a(bcm2);
                if (bl) {
                    bbr.bf("Calculating pack hash...");
                    ad.q(path2.toFile());
                    bbr.bf("Publishing pack...");
                    ad.b(path2, path);
                }
                if (bcm2 != null) {
                    bcm2.run(1.0);
                }
                this.ask = false;
                bbr.bf("Cleaning temporary pack data...");
                this.yG();
                try {
                    this.cy();
                    tf.f(bbf2);
                    bbf2.save();
                    sk.pq();
                }
                catch (Throwable throwable2) {
                    if (throwable == null) {
                        throwable = throwable2;
                    }
                    throwable.addSuppressed(throwable2);
                }
                try {
                    Files.deleteIfExists(path2);
                }
                catch (IOException iOException) {
                    if (throwable == null) {
                        throwable = iOException;
                    }
                    throwable.addSuppressed(iOException);
                }
                boolean bl2 = this.asl = bl && throwable == null;
                if (consumer != null) {
                    consumer.accept(bl && throwable == null);
                }
                break block81;
                catch (Throwable throwable3) {
                    block78: {
                        block77: {
                            try {
                                throwable = throwable3;
                                this.ask = false;
                            }
                            catch (Throwable throwable4) {
                                block80: {
                                    block79: {
                                        this.ask = false;
                                        bbr.bf("Cleaning temporary pack data...");
                                        this.yG();
                                        try {
                                            this.cy();
                                            tf.f(bbf2);
                                            bbf2.save();
                                            sk.pq();
                                        }
                                        catch (Throwable throwable5) {
                                            if (throwable == null) {
                                                throwable = throwable5;
                                                break block79;
                                            }
                                            throwable.addSuppressed(throwable5);
                                        }
                                    }
                                    try {
                                        Files.deleteIfExists(path2);
                                    }
                                    catch (IOException iOException) {
                                        if (throwable == null) {
                                            throwable = iOException;
                                            break block80;
                                        }
                                        throwable.addSuppressed(iOException);
                                    }
                                }
                                boolean bl3 = this.asl = bl && throwable == null;
                                if (consumer != null) {
                                    consumer.accept(bl && throwable == null);
                                }
                                throw throwable4;
                            }
                            bbr.bf("Cleaning temporary pack data...");
                            this.yG();
                            try {
                                this.cy();
                                tf.f(bbf2);
                                bbf2.save();
                                sk.pq();
                            }
                            catch (Throwable throwable6) {
                                if (throwable == null) {
                                    throwable = throwable6;
                                    break block77;
                                }
                                throwable.addSuppressed(throwable6);
                            }
                        }
                        try {
                            Files.deleteIfExists(path2);
                        }
                        catch (IOException iOException) {
                            if (throwable == null) {
                                throwable = iOException;
                                break block78;
                            }
                            throwable.addSuppressed(iOException);
                        }
                    }
                    boolean bl4 = this.asl = bl && throwable == null;
                    if (consumer != null) {
                        consumer.accept(bl && throwable == null);
                    }
                }
            }
            if (throwable instanceof Error) {
                object = (Error)throwable;
                throw object;
            }
            if (throwable != null) {
                bce.error("Failed to generate the resourcepack. ", throwable);
            }
        });
    }

    static void b(Path path, Path path2) {
        try {
            Files.move(path, path2, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (AtomicMoveNotSupportedException atomicMoveNotSupportedException) {
            Files.move(path, path2, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private void yG() {
        Path path = bcy.iQ(itemsadder.m.d.k).resolveSibling(asg);
        Path path2 = path.resolveSibling(String.valueOf(path.getFileName()) + ".tmp");
        try {
            if (bk.isEmpty()) {
                Files.deleteIfExists(path);
                return;
            }
            Files.createDirectories(path.getParent(), new FileAttribute[0]);
            Files.writeString(path2, (CharSequence)bk.xJ(), StandardCharsets.UTF_8, new OpenOption[0]);
            ad.b(path2, path);
        }
        catch (IOException iOException) {
            try {
                Files.deleteIfExists(path2);
            }
            catch (IOException iOException2) {
                // empty catch block
            }
            bce.warn("[Pack] Failed to write diagnostics report: " + iOException.getMessage());
        }
    }

    private void yH() {
        TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
        Set set = this.atb.yj();
        for (Map.Entry entry : asU.entrySet()) {
            String string3 = (String)entry.getKey();
            String string4 = (String)entry.getValue();
            if (this.asB != null && this.asB.yg().containsValue(string3) || string4 == null || itemsadder.m.an.a(string4)) continue;
            String string5 = o.el(string4);
            String string6 = o.em(string5);
            if (asU.containsKey(string5) || set.contains(string6) || itemsadder.m.d.g().B.b(Version.get(), string5) != null) continue;
            String string7 = "Model '" + string3 + "' references missing parent '" + string4 + "'.";
            String string8 = string5.substring(string5.indexOf(58) + 1);
            String string9 = string3.substring(string3.lastIndexOf(47) + 1);
            if (o.el(string3).equals(string5) || !string8.contains("/") && string8.equals(string9)) {
                string7 = string7 + " Remove this self-parent reference or use the intended namespaced parent path.";
            }
            treeMap.put(o.em(string3), string7);
            bk.k("Missing model parents", string7);
        }
        if (!treeMap.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("[Pack] Found ").append(treeMap.size()).append(" model").append(treeMap.size() == 1 ? "" : "s").append(" with missing parents. Files:");
            treeMap.forEach((string, string2) -> stringBuilder.append("\n  - ").append((String)string).append(" \u2014 ").append((String)string2));
            stringBuilder.append("\n  Full details: ItemsAdder/output/").append(asg);
            bce.warn(stringBuilder.toString());
        }
    }

    @NotNull
    private static JSONObject a(ti ti2, String string) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((Object)"name", (Object)(string + ":" + ti2.pK()));
        if (ti2.pM() != null) {
            jSONObject.put((Object)"volume", (Object)ti2.pM());
        }
        if (ti2.pN() != null) {
            jSONObject.put((Object)"pitch", (Object)ti2.pN());
        }
        if (ti2.pO() != null) {
            jSONObject.put((Object)"weight", (Object)ti2.pO());
        }
        if (ti2.pP() != null) {
            jSONObject.put((Object)"stream", (Object)ti2.pP());
        }
        if (ti2.pQ() != null) {
            jSONObject.put((Object)"attenuation_distance", (Object)ti2.pQ());
        }
        if (ti2.pR() != null) {
            jSONObject.put((Object)"preload", (Object)ti2.pR());
        }
        return jSONObject;
    }

    private void a(r r2) {
        if (!ae.du) {
            return;
        }
        r2.P("internal/textures/models/armor/leather_layer_1.png", "assets/minecraft/textures/models/armor/leather_layer_1.png");
        r2.P("internal/textures/models/armor/leather_layer_2.png", "assets/minecraft/textures/models/armor/leather_layer_2.png");
        r2.P("internal/textures/models/armor/leather_layer_1_overlay.png", "assets/minecraft/textures/models/armor/leather_layer_1_overlay.png");
        r2.P("internal/textures/models/armor/leather_layer_2_overlay.png", "assets/minecraft/textures/models/armor/leather_layer_2_overlay.png");
        r2.d("internal/textures/models/armor/leather_layer_1.png", "ia_overlay_1_21_2_plus/assets/minecraft/textures/entity/equipment/humanoid/leather.png", true);
        r2.d("internal/textures/models/armor/leather_layer_2.png", "ia_overlay_1_21_2_plus/assets/minecraft/textures/entity/equipment/humanoid_leggings/leather.png", true);
        r2.d("internal/textures/models/armor/leather_layer_1_overlay.png", "ia_overlay_1_21_2_plus/assets/minecraft/textures/entity/equipment/humanoid/leather_overlay.png", true);
        r2.d("internal/textures/models/armor/leather_layer_2_overlay.png", "ia_overlay_1_21_2_plus/assets/minecraft/textures/entity/equipment/humanoid_leggings/leather_overlay.png", true);
    }

    public static String c(byte[] byArray) {
        return BaseEncoding.base16().lowerCase().encode(byArray);
    }

    public void J(List list) {
        for (qs qs2 : list) {
            Map.Entry entry2;
            Object object;
            if (qs2.getNamespace().equals("minecraft")) {
                bce.error("Please don't use 'minecraft' as namespace. Item '" + qs2.getNamespacedID() + "'. File: " + (qs2.Hb != null ? qs2.Hb.nh() : "unknown"));
                continue;
            }
            if (qs2.fZ()) {
                object = new azk(qs2).Bo();
                for (Map.Entry entry2 : ((HashMap)object).entrySet()) {
                    g g2 = new azr((String)entry2.getKey()).C((JSONObject)entry2.getValue());
                    if (g2 == null) continue;
                    this.asp.put(g2.ays, g2.ayt);
                    g2.ayu.forEach(a2 -> {
                        if (a2.BG()) {
                            return;
                        }
                        this.asV.add(a2);
                    });
                }
                continue;
            }
            object = new azj(qs2).Bn();
            if (object == null) continue;
            this.asp.put(((g)object).ays, ((g)object).ayt);
            ((g)object).ayu.forEach(a2 -> {
                if (a2.BG()) {
                    return;
                }
                this.asV.add(a2);
            });
            if (qs2.Hb == null || qs2.Hb.nn() == null || qs2.Hb.nn().op() == null) continue;
            String string = ((g)object).ays.replaceFirst("\\.json$", "_broken.json");
            entry2 = new azr(string).C(ayw.l(((g)object).ayt, qs2.Hb.nn().op()));
            this.asp.put(((g)((Object)entry2)).ays, ((g)((Object)entry2)).ayt);
            ((g)((Object)entry2)).ayu.stream().filter(a2 -> !a2.BG()).forEach(this.asV::add);
        }
    }

    public void b(HashMap hashMap) {
        azh azh2 = new azh(hashMap.values());
        this.ass = azh2.Bm();
        this.ast = this.yU();
    }

    public void c(HashMap hashMap) {
        azm azm2 = new azm(hashMap.values());
        this.asO = azm2.Bq();
    }

    void yI() {
        JSONObject jSONObject2;
        Object object;
        Object object2;
        Object object3;
        bbr.bf("Generating atlases: merging custom atlases...");
        this.asQ = new HashMap();
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONObject3.put((Object)"sources", (Object)jSONArray);
        this.asQ.put("blocks.json", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        JSONArray jSONArray2 = new JSONArray();
        jSONObject4.put((Object)"sources", (Object)jSONArray2);
        this.asQ.put("items.json", jSONObject4);
        this.asR = new JSONObject();
        JSONArray jSONArray3 = new JSONArray();
        this.asR.put((Object)"sources", (Object)jSONArray3);
        bce.iA("Merging atlases from resourcepacks...");
        List list = itemsadder.m.d.g().x;
        for (File file2 : list) {
            File file3 = new File(file2, "minecraft/atlases/");
            if (!file3.exists()) continue;
            object3 = bcy.a(file3, (File file) -> file.getName().endsWith(".json"));
            object2 = object3.iterator();
            while (object2.hasNext()) {
                object = (File)object2.next();
                try {
                    jSONObject2 = dev.lone.itemsadder.utils.json.c.N((File)object);
                    if (jSONObject2.containsKey("sources") && jSONObject2.get("sources") instanceof JSONArray) {
                        if ((((File)object).getName().equals("blocks.json") || ((File)object).getName().equals("items.json")) && ad.a(jSONObject2.getJSONArray("sources"))) {
                            bce.warn("[Pack] Atlas directory source could include vanilla sprites owned by dedicated atlases; those vanilla sprites were excluded. File: " + bcy.iP(((File)object).getAbsolutePath()));
                        }
                        if (!this.asQ.containsKey(((File)object).getName())) {
                            this.asQ.put(((File)object).getName(), jSONObject2);
                            continue;
                        }
                        ((JSONObject)this.asQ.get(((File)object).getName())).getJSONArray("sources").addAll((Collection)jSONObject2.getJSONArray("sources"));
                        continue;
                    }
                    throw new RuntimeException("Atlas file has invalid 'sources' attribute.");
                }
                catch (JSONException jSONException) {
                    bce.error("Malformed JSON file. File: " + bcy.iP(((File)object).getAbsolutePath()));
                    bce.error(jSONException.getMessage());
                }
                catch (Throwable throwable) {
                    bce.error("Error opening a custom atlas file. Make sure it's valid or delete it. File: " + bcy.iP(((File)object).getAbsolutePath()), throwable);
                }
            }
        }
        bbr.bf("Generating atlases: loading fallback rules...");
        this.yJ();
        bbr.bf("Generating atlases: collecting blockstate models...");
        bce.iA("Collecting models from blockstates to generate atlas files...");
        this.ass.forEach((string, jSONObject) -> {
            List list = b.M(jSONObject);
            this.asu.addAll(list);
        });
        bce.iA("Collecting textures from models to generate atlas files...");
        List list2 = itemsadder.m.d.D();
        int n2 = 0;
        int n3 = list2.size();
        this.asC.clear();
        this.asD.clear();
        object3 = list2.iterator();
        while (object3.hasNext()) {
            object2 = (File)object3.next();
            if (++n2 == 1 || n2 % 100 == 0 || n2 == n3) {
                bbr.bf("Generating atlases: validating models " + n2 + "/" + n3 + "...");
            }
            if ((object = new azq((File)object2).Bt()) == null) continue;
            ((g)object).BY().removeIf(this::eM);
            jSONObject2 = ((g)object).ayt;
            this.asC.put(o.em(((g)object).BW()), jSONObject2);
            this.asD.put(bcy.iR(((File)object2).getAbsolutePath()), jSONObject2);
            this.ata.addAll(((g)object).BY());
            if (ae.dq) continue;
            boolean bl = ((g)object).BX() || this.ast.contains(((g)object).BW()) || this.asu.contains(((g)object).BW());
            for (String string2 : ((g)object).BV()) {
                if (!bl && string2.contains("block/")) {
                    bl = true;
                }
                if (asZ.j(string2, bl)) continue;
                if (((g)object).gn(string2)) {
                    string2 = "minecraft:item/iamissing";
                }
                String string3 = asZ.k(string2, bl);
                dev.lone.itemsadder.resourcepack.a a2 = new dev.lone.itemsadder.resourcepack.a(string2, string3);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put((Object)"type", (Object)"single");
                jSONObject5.put((Object)"resource", (Object)a2.aqm);
                jSONObject5.put((Object)"sprite", (Object)a2.aqn);
                if (bl) {
                    jSONArray.add((Object)jSONObject5);
                } else {
                    jSONArray2.add((Object)jSONObject5);
                }
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put((Object)"type", (Object)"single");
                jSONObject6.put((Object)"resource", (Object)a2.aqm);
                jSONObject6.put((Object)"sprite", (Object)a2.aqn);
                jSONArray3.add((Object)jSONObject6);
            }
        }
        bbr.bf("Generating atlases: checking missing textures...");
        azr.c(this::eM);
    }

    static boolean a(JSONArray jSONArray) {
        boolean bl = jSONArray.stream().filter(JSONObject.class::isInstance).map(JSONObject.class::cast).anyMatch(jSONObject -> {
            String string = jSONObject.getString("type");
            String string2 = jSONObject.getString("source");
            return string != null && string.endsWith("directory") && string2 != null && (string2.isEmpty() || string2.equals("entity") || string2.equals("entity/banner") || string2.startsWith("entity/banner/") || string2.equals("entity/chest") || string2.startsWith("entity/chest/") || string2.equals("entity/decorated_pot") || string2.startsWith("entity/decorated_pot/") || string2.equals("entity/shield") || string2.startsWith("entity/shield/") || string2.equals("entity/shulker") || string2.startsWith("entity/shulker/"));
        });
        if (!bl) {
            return false;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put((Object)"namespace", (Object)"^minecraft$");
        jSONObject2.put((Object)"path", (Object)"^entity/(?:banner|chest|decorated_pot|shield|shulker)(?:/.*)?$");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put((Object)"type", (Object)"filter");
        jSONObject3.put((Object)"pattern", (Object)jSONObject2);
        if (jSONArray.contains((Object)jSONObject3)) {
            return false;
        }
        jSONArray.add((Object)jSONObject3);
        return true;
    }

    void yJ() {
        this.c(bce::warn, bce::iB);
    }

    void d(Consumer consumer) {
        this.c(consumer, consumer);
    }

    private void c(Consumer consumer, Consumer consumer2) {
        this.asu = new HashSet();
        this.asv = Set.of();
        if (!ae.dq) {
            this.asB = null;
            this.asE.clear();
            this.asF.clear();
            this.asz.clear();
            asZ.clear();
            this.asW.clear();
            consumer.accept("[Pack] Modern atlas planner rollback is enabled; the old workaround may restore mixed-atlas or glint limitations.");
            return;
        }
        if (ae.dr != null && !ae.dr.isEmpty()) {
            HashSet hashSet = new HashSet();
            consumer2.accept("The 1.21.11 atlas material list is deprecated and is used only for unreachable models.");
            for (String string : ae.dr) {
                this.asn.forEach((string2, jSONObject) -> {
                    if (string2.equals(string.toLowerCase())) {
                        List list = b.M(jSONObject);
                        hashSet.addAll(list);
                        this.asu.addAll(list);
                    }
                });
            }
            this.asv = Set.copyOf(hashSet);
        }
    }

    void c(String string, JSONObject jSONObject) {
        this.asC.putIfAbsent(bcy.iR(string), (JSONObject)JSON.copy((Object)jSONObject, (JSONWriter.Feature[])new JSONWriter.Feature[0]));
    }

    boolean a(String string, File file) {
        JSONObject jSONObject = (JSONObject)this.asD.get(bcy.iR(file.getAbsolutePath()));
        if (jSONObject == null) {
            return false;
        }
        this.asC.put(bcy.iR(string), jSONObject);
        return true;
    }

    void d(String string, JSONObject jSONObject) {
        this.asC.put(bcy.iR(string), jSONObject);
    }

    void yK() {
        if (!ae.dq) {
            return;
        }
        this.asC.keySet().retainAll(this.atb.yi());
        Map map = ad.k(this.asw);
        this.asn.forEach((string, jSONObject) -> map.put("assets/minecraft/items/" + string + ".json", new TreeSet(b.M(jSONObject))));
        this.asq.forEach((string, jSONObject) -> map.put(string, new TreeSet(b.M(jSONObject))));
        Map map2 = ad.k(this.asx);
        this.ass.forEach((string, jSONObject) -> map2.putIfAbsent(string, new TreeSet(b.M(jSONObject))));
        TreeSet treeSet = new TreeSet();
        map.values().forEach(treeSet::addAll);
        TreeSet treeSet2 = new TreeSet();
        map2.values().forEach(treeSet2::addAll);
        this.a(treeSet, treeSet2, (T string) -> {});
    }

    void i(Map map) {
        Consumer consumer = this.asH;
        Consumer consumer2 = this.asI;
        this.asH = bce::warn;
        this.asI = bce::log;
        try {
            this.a(map, null, this::c, (Collection)ad.yT(), (T string) -> itemsadder.m.d.b(string) || itemsadder.m.d.g().B.R((String)string));
        }
        catch (IOException iOException) {
            throw new IllegalStateException("Failed to finalize modern atlas entries", iOException);
        }
        finally {
            this.asH = consumer;
            this.asI = consumer2;
        }
    }

    void a(Map map, java.util.function.Predicate predicate) {
        this.a(map, predicate, (T version, U string) -> null, List.of(Version.UNKNOWN), (T string) -> string.startsWith("minecraft:"));
    }

    void a(Map map, java.util.function.Predicate predicate, java.util.function.Predicate predicate2) {
        this.a(map, predicate, (T version, U string) -> null, List.of(Version.UNKNOWN), predicate2);
    }

    void a(Map map, BiFunction biFunction, Collection collection, java.util.function.Predicate predicate) {
        this.a(map, itemsadder.m.an::a, biFunction, collection, predicate);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(Map map, @Nullable java.util.function.Predicate predicate, BiFunction biFunction, Collection collection, java.util.function.Predicate predicate2) {
        j j2 = new j();
        try {
            Object object;
            Object object22;
            Object object3;
            ah ah2;
            this.asJ.gr();
            this.asM = ah2 = ah.a(map, this.asJ);
            this.asN = Map.of();
            this.asL = this.a(ah2);
            Set set = ad.i(ah2.ati);
            java.util.function.Predicate<String> predicate3 = predicate;
            if (predicate3 == null) {
                object3 = ah2.ati.stream().filter(ad::eG).map(g::gl).map(o::el).collect(Collectors.toUnmodifiableSet());
                predicate3 = arg_0 -> ad.j((Set)object3, arg_0);
            }
            object3 = ad.a(ah2, "pack.mcmeta");
            if (collection.stream().noneMatch(arg_0 -> Version.UNKNOWN.equals(arg_0))) {
                if (object3 == null) {
                    throw new IllegalStateException("Modern atlas planning requires final pack entry 'pack.mcmeta', but it is missing or removed");
                }
                this.a(map, ah2, (JSONObject)object3, biFunction, collection, predicate2, j2);
                return;
            }
            p p2 = this.asB;
            TreeMap treeMap = new TreeMap(this.asC);
            TreeMap treeMap2 = new TreeMap(this.asE);
            HashMap hashMap = new HashMap(this.asF);
            Set set2 = ah2.ati;
            HashSet hashSet = new HashSet(treeMap2.keySet());
            hashSet.removeAll(set2);
            Set set3 = this.yM();
            set3.removeAll(set2);
            String string2 = "ia_overlay_modern_atlas/assets/minecraft/atlases/items.json";
            String string3 = "ia_overlay_modern_atlas/assets/minecraft/atlases/blocks.json";
            String string4 = "assets/minecraft/atlases/blocks.json";
            boolean bl = set2.contains(string2);
            boolean bl2 = set2.contains(string3);
            boolean bl3 = set2.contains(string4);
            JSONObject jSONObject2 = ad.a(ah2, string2);
            JSONObject jSONObject3 = ad.a(ah2, string3);
            JSONObject jSONObject4 = ad.a(ah2, string4);
            if (jSONObject2 != null) {
                this.asQ.put("items.json", jSONObject2);
            } else {
                this.asQ.put("items.json", ad.yN());
            }
            if (jSONObject3 != null) {
                this.asQ.put("blocks.json", jSONObject3);
            } else {
                this.asQ.put("blocks.json", ad.yN());
            }
            this.asR = jSONObject4 != null ? jSONObject4 : ad.yN();
            this.asW.clear();
            ad.a(jSONObject2, false);
            ad.a(jSONObject3, true);
            this.asC.clear();
            TreeMap<Object, JSONObject> treeMap3 = new TreeMap<Object, JSONObject>();
            TreeMap treeMap4 = new TreeMap();
            HashSet<Object> hashSet2 = new HashSet<Object>();
            TreeMap<Object, JSONObject> treeMap5 = new TreeMap<Object, JSONObject>();
            for (Object object22 : ah2.ath) {
                Object object4;
                JSONObject jSONObject5;
                object = ((aj)object22).pK();
                ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry = ((aj)object22).yu();
                if (itemsAdderPackCompressedEvent$PackEntry.isRemoved()) continue;
                if (ad.eG((String)object)) {
                    JSONObject jSONObject6;
                    jSONObject5 = ad.d(itemsAdderPackCompressedEvent$PackEntry, (String)object);
                    object4 = (JSONObject)treeMap2.get(object);
                    JSONObject jSONObject7 = (JSONObject)treeMap.get(object);
                    if (object4 != null && object4.equals((Object)jSONObject5)) {
                        jSONObject6 = jSONObject7;
                    } else {
                        ad.i(jSONObject5);
                        if (p2 != null) {
                            p2.u(jSONObject5);
                        }
                        jSONObject6 = jSONObject5;
                        if (object4 != null && jSONObject7 == null) {
                            treeMap5.put(object, jSONObject5);
                            jSONObject6 = null;
                        }
                    }
                    if (jSONObject6 != null) {
                        this.asC.put(object, jSONObject6);
                        continue;
                    }
                    if (!((String)object).startsWith("ia_overlay_modern_atlas/")) continue;
                    hashSet2.add(object);
                    continue;
                }
                if (ad.U((String)object, "items")) {
                    jSONObject5 = ad.d(itemsAdderPackCompressedEvent$PackEntry, (String)object);
                    if (p2 != null) {
                        p2.u(jSONObject5);
                    }
                    object4 = ad.eH((String)object);
                    if (!((String)object).startsWith("ia_overlay_modern_atlas/") && treeMap3.containsKey(object4)) continue;
                    treeMap3.put(object4, jSONObject5);
                    continue;
                }
                if (!ad.U((String)object, "blockstates")) continue;
                jSONObject5 = ad.d(itemsAdderPackCompressedEvent$PackEntry, (String)object);
                object4 = ad.eH((String)object);
                if (!((String)object).startsWith("ia_overlay_modern_atlas/") && treeMap4.containsKey(object4)) continue;
                treeMap4.put((JSONObject)object4, new TreeSet(b.M(jSONObject5)));
            }
            TreeMap treeMap6 = new TreeMap();
            treeMap3.forEach((string, jSONObject) -> treeMap6.put(string, new TreeSet(b.M(jSONObject))));
            this.asw.clear();
            this.asw.putAll(treeMap6);
            this.asx.clear();
            this.asx.putAll(treeMap4);
            object22 = new TreeSet();
            treeMap6.values().forEach(((Set)object22)::addAll);
            object = new TreeSet();
            treeMap4.values().forEach(((Set)object)::addAll);
            this.asy.clear();
            this.asy.putAll(treeMap3);
            this.a(set, predicate2);
            this.k((JSONObject)this.asQ.get("items.json"));
            this.k((JSONObject)this.asQ.get("blocks.json"));
            this.k(this.asR);
            this.a((Collection)object22, (Collection)object, Map.of(), this.asH, j2, List.of(Version.UNKNOWN));
            hashSet2.stream().filter(string -> !this.asE.containsKey(string)).forEach(map::remove);
            treeMap5.forEach((string, jSONObject) -> {
                boolean bl = hashMap.getOrDefault(string, false);
                this.a((String)string, g.gl(string), (JSONObject)jSONObject, bl);
                this.a((String)string, (JSONObject)this.asE.get(string), bl);
            });
            hashSet.forEach(string -> {
                this.asE.remove(string);
                this.asF.remove(string);
            });
            set3.forEach(this.asz::remove);
            boolean bl4 = this.aT(false);
            boolean bl5 = this.aT(true);
            if (!bl && bl4) {
                throw new IllegalStateException("Modern atlas validation failed: listener removed required atlas entry '" + string2 + "'");
            }
            if (!bl2 && bl5) {
                throw new IllegalStateException("Modern atlas validation failed: listener removed required atlas entry '" + string3 + "'");
            }
            if (!bl3 && (bl4 || bl5)) {
                throw new IllegalStateException("Modern atlas validation failed: listener removed required atlas entry '" + string4 + "'");
            }
            this.a((Map)treeMap6, treeMap4, predicate3, biFunction, collection, set, predicate2, j2);
            this.asE.forEach((string, jSONObject) -> map.put(string, ad.e(string, jSONObject)));
            this.asz.forEach((string, jSONObject) -> map.put(string, ad.e(string, jSONObject)));
            this.yV();
            this.asQ.forEach((string, jSONObject) -> {
                String string2 = "ia_overlay_modern_atlas/assets/minecraft/atlases/" + string;
                if (set2.contains(string2)) {
                    map.put(string2, ad.e(string2, this.q((JSONObject)jSONObject)));
                }
            });
            if (bl3) {
                map.put(string4, ad.e(string4, this.q(this.asR)));
            }
        }
        finally {
            this.a(j2);
            this.asM = null;
            this.asN = Map.of();
        }
    }

    private void a(Map map, ah ah2, JSONObject jSONObject2, BiFunction biFunction, Collection collection, java.util.function.Predicate predicate, j j2) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        String string3;
        Object object52;
        p p2 = this.asB;
        TreeMap treeMap = new TreeMap(this.asC);
        TreeMap treeMap2 = new TreeMap(this.asy);
        TreeMap treeMap3 = new TreeMap(this.asE);
        TreeMap treeMap4 = new TreeMap(this.asz);
        HashMap hashMap = new HashMap(ad.asZ.aqo);
        HashMap hashMap2 = new HashMap(ad.asZ.aqp);
        Set set = this.yL();
        HashSet<String> hashSet = new HashSet<String>();
        TreeMap<String, Object> treeMap5 = new TreeMap<String, Object>();
        for (Object object52 : ah2.ath) {
            string3 = ((aj)object52).pK();
            object4 = ((aj)object52).yu();
            if (((ItemsAdderPackCompressedEvent$PackEntry)object4).isRemoved() || !string3.endsWith(".json") || !ad.eG(string3) && !ad.U(string3, "items") && !ad.U(string3, "blockstates") && !ad.U(string3, "atlases")) continue;
            object3 = ad.d((ItemsAdderPackCompressedEvent$PackEntry)object4, string3);
            if (ad.eG(string3)) {
                object2 = (JSONObject)treeMap3.get(string3);
                object = (JSONObject)treeMap.get(string3);
                if (object2 != null && object2.equals(object3)) {
                    if (object == null) {
                        hashSet.add(string3);
                        continue;
                    }
                    object3 = object;
                } else {
                    ad.i((JSONObject)object3);
                    if (p2 != null) {
                        p2.u(object3);
                    }
                }
            } else if (ad.U(string3, "items")) {
                object2 = (JSONObject)treeMap4.get(string3);
                object = (JSONObject)treeMap2.get(string3);
                if (object2 != null && object2.equals(object3) && object != null) {
                    object3 = (JSONObject)JSON.copy((Object)object, (JSONWriter.Feature[])new JSONWriter.Feature[0]);
                } else if (object2 != null && object2.equals(object3) && !set.contains(string3)) {
                    hashSet.add(string3);
                    continue;
                }
                if (p2 != null) {
                    p2.u(object3);
                }
            }
            treeMap5.put(string3, object3);
        }
        ah ah3 = ah2.j(hashSet);
        object52 = "assets/minecraft/atlases/blocks.json";
        string3 = (JSONObject)treeMap5.get(object52);
        this.asR = ad.a((JSONObject)(string3 == null ? ad.yN() : string3), hashMap, hashMap2);
        asZ.clear();
        object4 = new TreeMap();
        collection.forEach(arg_0 -> ad.a((Map)object4, arg_0));
        object3 = new TreeMap();
        object2 = new HashMap();
        object = new TreeMap();
        TreeMap treeMap6 = new TreeMap();
        TreeMap treeMap7 = new TreeMap();
        TreeMap treeMap8 = new TreeMap();
        TreeMap treeMap9 = new TreeMap();
        TreeMap treeMap10 = new TreeMap();
        HashSet hashSet2 = new HashSet();
        HashMap hashMap3 = new HashMap();
        Map map2 = ad.g(jSONObject2);
        TreeSet treeSet = new TreeSet();
        String string4 = "assets/minecraft/models/item/";
        treeMap5.forEach((string2, jSONObject) -> {
            String string3 = ad.eH(string2);
            if (string3.startsWith(string4) && string3.indexOf(47, string4.length()) < 0) {
                treeSet.addAll(b.M(jSONObject));
            }
        });
        as as2 = new as();
        for (List list : object4.values()) {
            Map map3;
            Version version = (Version)list.getFirst();
            this.asN = map3 = ad.a(ah3, jSONObject2, version);
            String string5 = ad.a(jSONObject2, version);
            String string6 = ad.a(jSONObject2, map3, "assets/minecraft/atlases/items.json", string5, version);
            String string7 = ad.a(jSONObject2, map3, "assets/minecraft/atlases/blocks.json", string5, version);
            Map map4 = ad.a(map3, treeMap5, "models", true);
            Map map5 = ad.a(map3, treeMap5, "items", false);
            Map map6 = ad.a(map3, treeMap5, "blockstates", false);
            Map map7 = ad.j(map5);
            Map map8 = ad.j(map6);
            map4.forEach(treeMap7::putIfAbsent);
            map5.forEach((string, jSONObject) -> {
                String string2 = (String)map3.get(string);
                if (string2 != null) {
                    treeMap8.putIfAbsent(string2, jSONObject);
                }
            });
            treeMap9.putAll(map7);
            treeMap10.putAll(map8);
            this.asC.clear();
            this.asC.putAll(map4);
            this.asy.clear();
            this.asy.putAll(map5);
            this.asQ = new HashMap();
            this.asQ.put("items.json", ad.a(map3, treeMap5, "assets/minecraft/atlases/items.json", hashMap, Map.of()));
            this.asQ.put("blocks.json", ad.a(map3, treeMap5, "assets/minecraft/atlases/blocks.json", Map.of(), hashMap2));
            ad.a((JSONObject)this.asQ.get("items.json"), false);
            ad.a((JSONObject)this.asQ.get("blocks.json"), true);
            HashSet hashSet3 = new HashSet(map3.keySet());
            this.a(hashSet3, predicate);
            this.k((JSONObject)this.asQ.get("items.json"));
            this.k((JSONObject)this.asQ.get("blocks.json"));
            TreeSet treeSet2 = new TreeSet();
            map7.values().forEach(treeSet2::addAll);
            treeSet2.addAll(treeSet);
            TreeSet treeSet3 = new TreeSet();
            map8.values().forEach(treeSet3::addAll);
            Set set2 = map4.keySet().stream().map(g::gl).map(o::el).collect(Collectors.toSet());
            Map map9 = ad.a(map7, treeSet3, map4, version, biFunction);
            this.asW.clear();
            this.a(treeSet2, treeSet3, map9, this.asH, j2, list);
            Set set3 = map4.keySet();
            this.asE.forEach((arg_0, arg_1) -> this.a(set3, string5, (Map)object3, version, (Map)object2, hashSet2, arg_0, arg_1));
            map5.forEach((arg_0, arg_1) -> this.a(map3, jSONObject2, (Map)object, version, hashMap3, map2, arg_0, arg_1));
            this.asz.forEach((arg_0, arg_1) -> ad.a(string5, map5, map3, map2, hashMap3, (Map)object, version, arg_0, arg_1));
            this.a(map7, map8, (T string) -> itemsadder.m.an.a(string) || set2.contains(o.el(string)), biFunction, list, hashSet3, predicate, j2);
            as2.b(this.asG);
            ad.a(treeMap6, string6, this.q((JSONObject)this.asQ.get("items.json")), version);
            ad.a(treeMap6, string7, this.q((JSONObject)this.asQ.get("blocks.json")), version);
        }
        this.asw.clear();
        this.asw.putAll(treeMap9);
        this.asx.clear();
        this.asx.putAll(treeMap10);
        this.asC.clear();
        this.asC.putAll(treeMap7);
        this.asy.clear();
        this.asy.putAll(treeMap8);
        this.asE.clear();
        this.asE.putAll(object3);
        this.asF.clear();
        this.asF.putAll(object2);
        this.asz.clear();
        this.asz.putAll(object);
        this.asG = as2;
        HashSet hashSet4 = new HashSet(object3.keySet());
        hashSet4.addAll(object.keySet());
        hashSet4.addAll(treeMap6.keySet());
        hashSet.stream().filter(string -> !hashSet4.contains(string)).forEach(map::remove);
        ad.b(map, (Map)object3);
        ad.b(map, (Map)object);
        ad.b(map, treeMap6);
        if (map.containsKey(object52) && !((ItemsAdderPackCompressedEvent$PackEntry)map.get(object52)).isRemoved()) {
            map.put(object52, ad.e((String)object52, this.q(this.asR)));
        }
    }

    private Set yL() {
        Map map;
        HashSet hashSet = new HashSet();
        if (this.asq != null) {
            this.asq.keySet().forEach(string -> hashSet.add("ia_overlay_modern_atlas/" + bcy.iR(string)));
        }
        if (this.aso != null && (map = (Map)this.aso.get((Object)i.v_1_21_6_plus)) != null) {
            map.keySet().forEach(string -> hashSet.add("ia_overlay_modern_atlas/assets/minecraft/items/" + string + ".json"));
        }
        return hashSet;
    }

    private static Map a(Map map, Map map2, String string, boolean bl) {
        TreeMap treeMap = new TreeMap();
        map.forEach((string2, string3) -> {
            if (!ad.U(string2, string)) {
                return;
            }
            JSONObject jSONObject = (JSONObject)map2.get(string3);
            if (jSONObject != null) {
                treeMap.put(bl ? string3 : string2, jSONObject);
            }
        });
        return treeMap;
    }

    private static Map j(Map map) {
        TreeMap treeMap = new TreeMap();
        map.forEach((string, jSONObject) -> treeMap.put(string, new TreeSet(b.M(jSONObject))));
        return treeMap;
    }

    private static JSONObject a(Map map, Map map2, String string, Map map3, Map map4) {
        String string2 = (String)map.get(string);
        JSONObject jSONObject = string2 == null ? null : (JSONObject)map2.get(string2);
        return ad.a(jSONObject == null ? ad.yN() : jSONObject, map3, map4);
    }

    private static JSONObject a(JSONObject jSONObject, Map map, Map map2) {
        JSONObject jSONObject2 = (JSONObject)JSON.copy((Object)jSONObject, (JSONWriter.Feature[])new JSONWriter.Feature[0]);
        Object object2 = jSONObject2.get("sources");
        if (!(object2 instanceof JSONArray)) {
            return jSONObject2;
        }
        JSONArray jSONArray = (JSONArray)object2;
        jSONArray.removeIf(object -> {
            JSONObject jSONObject;
            if (!(object instanceof JSONObject && (jSONObject = (JSONObject)object).containsKey("resource") && jSONObject.containsKey("sprite"))) {
                return false;
            }
            String string = jSONObject.getString("resource");
            String string2 = jSONObject.getString("sprite");
            return Objects.equals(string2, map.get(string)) || Objects.equals(string2, map2.get(string));
        });
        return jSONObject2;
    }

    private static Map g(JSONObject jSONObject) {
        JSONArray jSONArray;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        JSONObject jSONObject2 = jSONObject.getJSONObject("overlays");
        JSONArray jSONArray2 = jSONArray = jSONObject2 == null ? null : jSONObject2.getJSONArray("entries");
        if (jSONArray == null) {
            return hashMap;
        }
        for (int i2 = 0; i2 < jSONArray.size(); ++i2) {
            String string = jSONArray.getJSONObject(i2).getString("directory");
            if (string == null) continue;
            hashMap.put(bcy.iR(string), i2);
        }
        return hashMap;
    }

    private static int b(@Nullable String string, Map map) {
        if (string == null) {
            return Integer.MIN_VALUE;
        }
        if ((string = bcy.iR(string)).startsWith("assets/")) {
            return -1;
        }
        int n2 = string.indexOf("/assets/");
        return n2 < 0 ? Integer.MIN_VALUE : map.getOrDefault(string.substring(0, n2), -1);
    }

    static String a(JSONObject jSONObject, Version version) {
        Object object;
        JSONObject jSONObject2 = jSONObject.getJSONObject("overlays");
        if (jSONObject2 == null || !((object = jSONObject2.get("entries")) instanceof JSONArray)) {
            throw new IllegalStateException("Modern atlas planning requires pack.mcmeta overlay entries");
        }
        JSONArray jSONArray = (JSONArray)object;
        object = null;
        String string = null;
        int n2 = Integer.MIN_VALUE;
        int n3 = zw.k(version);
        for (Object e2 : jSONArray) {
            int[] nArray;
            JSONObject jSONObject3;
            String string2;
            if (!(e2 instanceof JSONObject) || !"ia_overlay_modern_atlas".equals(string2 = (jSONObject3 = (JSONObject)e2).getString("directory")) && !"ia_overlay_26_1_plus".equals(string2) || n3 < (nArray = ad.j(jSONObject3))[0] || n3 > nArray[1]) continue;
            object = string2;
            if (nArray[0] < n2) continue;
            string = string2;
            n2 = nArray[0];
        }
        if (object == null) {
            throw new IllegalStateException("No ItemsAdder modern atlas overlay applies to client " + version.getName() + " (pack format " + n3 + ")");
        }
        if (!((String)object).equals(string)) {
            throw new IllegalStateException("ItemsAdder modern atlas overlay precedence selects '" + (String)object + "' after the more specific '" + string + "' for client " + version.getName() + " (pack format " + n3 + ")");
        }
        return object;
    }

    private static String a(JSONObject jSONObject, Map map, String string, String string2, Version version) {
        String string3 = string2 + "/" + string;
        String string4 = (String)map.get(string);
        if (string4 == null || string4.equals(string3)) {
            return string3;
        }
        JSONArray jSONArray = jSONObject.getJSONObject("overlays").getJSONArray("entries");
        int n2 = zw.k(version);
        int n3 = -1;
        int n4 = -1;
        for (int i2 = 0; i2 < jSONArray.size(); ++i2) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            int[] nArray = ad.j(jSONObject2);
            if (n2 < nArray[0] || n2 > nArray[1]) continue;
            String string5 = StringUtils.strip((String)bcy.iR(jSONObject2.getString("directory")), (String)"/");
            if (string2.equals(string5)) {
                n3 = i2;
            }
            if (!string4.startsWith(string5 + "/assets/")) continue;
            n4 = i2;
        }
        if (n4 <= n3) {
            return string3;
        }
        if (!ad.f(jSONObject, string4)) {
            throw new IllegalStateException("Modern atlas planning cannot rewrite effective atlas '" + string4 + "' for client " + version.getName() + " (pack format " + n2 + ") because its later overlay also spans legacy formats; move the atlas to a modern-only overlay or declare it before ItemsAdder overlay '" + string2 + "'");
        }
        return string4;
    }

    private static boolean f(JSONObject jSONObject, String string) {
        Object object;
        JSONObject jSONObject2 = jSONObject.getJSONObject("overlays");
        if (jSONObject2 == null || !((object = jSONObject2.get("entries")) instanceof JSONArray)) {
            return false;
        }
        JSONArray jSONArray = (JSONArray)object;
        int n2 = zw.k(Version.v1_21_11);
        boolean bl = false;
        for (Object e2 : jSONArray) {
            JSONObject jSONObject3;
            String string2;
            if (!(e2 instanceof JSONObject) || StringUtils.isBlank((String)(string2 = StringUtils.strip((String)bcy.iR((jSONObject3 = (JSONObject)e2).getString("directory")), (String)"/"))) || !string.startsWith(string2 + "/")) continue;
            bl = true;
            if (ad.j(jSONObject3)[0] >= n2) continue;
            return false;
        }
        return bl;
    }

    private static void a(Map map, String string, JSONObject jSONObject, Version version) {
        JSONObject jSONObject2 = map.putIfAbsent(string = bcy.iR(string), jSONObject);
        if (jSONObject2 != null && !jSONObject2.equals((Object)jSONObject)) {
            throw new IllegalStateException("Modern atlas planning produced different JSON for physical entry '" + string + "' across client versions, including " + version.getName());
        }
    }

    @Nullable
    static JSONObject h(JSONObject jSONObject) {
        Object object = jSONObject.get("elements");
        if (!(object instanceof JSONArray)) {
            return null;
        }
        JSONArray jSONArray = (JSONArray)object;
        JSONObject jSONObject2 = null;
        JSONArray jSONArray2 = null;
        for (int i2 = 0; i2 < jSONArray.size(); ++i2) {
            JSONObject jSONObject3;
            Iterator iterator;
            Object object2 = jSONArray.get(i2);
            if (!(object2 instanceof JSONObject) || !((iterator = (jSONObject3 = (JSONObject)object2).get("faces")) instanceof JSONObject)) continue;
            JSONObject jSONObject4 = (JSONObject)iterator;
            iterator = jSONObject4.entrySet().iterator();
            while (iterator.hasNext()) {
                JSONArray jSONArray3;
                JSONObject jSONObject5;
                Object object3;
                Map.Entry entry = (Map.Entry)iterator.next();
                Object v2 = entry.getValue();
                if (!(v2 instanceof JSONObject) || !((object3 = (jSONObject5 = (JSONObject)v2).get("uv")) instanceof JSONArray) || (jSONArray3 = (JSONArray)object3).size() != 4) continue;
                for (int i3 = 0; i3 < jSONArray3.size(); ++i3) {
                    Number number;
                    double d2;
                    Object object4 = jSONArray3.get(i3);
                    if (!(object4 instanceof Number) || !Double.isFinite(d2 = (number = (Number)object4).doubleValue()) || d2 >= 0.0 && d2 <= 16.0) continue;
                    if (jSONObject2 == null) {
                        jSONObject2 = (JSONObject)JSON.copy((Object)jSONObject, (JSONWriter.Feature[])new JSONWriter.Feature[0]);
                        jSONArray2 = jSONObject2.getJSONArray("elements");
                    }
                    jSONArray2.getJSONObject(i2).getJSONObject("faces").getJSONObject((String)entry.getKey()).getJSONArray("uv").set(i3, (Object)(d2 < 0.0 ? 0 : 16));
                }
            }
        }
        return jSONObject2;
    }

    private static void b(Map map, Map map2) {
        map2.forEach((string, jSONObject) -> {
            ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry = (ItemsAdderPackCompressedEvent$PackEntry)map.get(string);
            if (itemsAdderPackCompressedEvent$PackEntry == null || !itemsAdderPackCompressedEvent$PackEntry.isRemoved()) {
                map.put(string, ad.e(string, jSONObject));
            }
        });
    }

    private Set yM() {
        Map map;
        HashSet hashSet = new HashSet(this.asz.keySet());
        if (this.asq != null) {
            this.asq.keySet().forEach(string -> hashSet.add("ia_overlay_modern_atlas/" + bcy.iR(string)));
        }
        if (this.aso != null && (map = (Map)this.aso.get((Object)i.v_1_21_6_plus)) != null) {
            map.keySet().forEach(string -> hashSet.add("ia_overlay_modern_atlas/assets/minecraft/items/" + string + ".json"));
        }
        return hashSet;
    }

    private boolean aT(boolean bl) {
        return this.asE.entrySet().stream().anyMatch(entry -> {
            if ((Boolean)this.asF.get(entry.getKey()) != bl) {
                return false;
            }
            JSONObject jSONObject = ((JSONObject)entry.getValue()).getJSONObject("textures");
            return jSONObject != null && jSONObject.values().stream().map(ad::w).filter(Objects::nonNull).anyMatch(string -> !a.gf(string));
        });
    }

    private static JSONObject yN() {
        return new JSONObject().fluentPut("sources", (Object)new JSONArray());
    }

    private static void a(@Nullable JSONObject jSONObject, boolean bl) {
        Object object;
        if (jSONObject == null || !((object = jSONObject.get("sources")) instanceof JSONArray)) {
            return;
        }
        JSONArray jSONArray = (JSONArray)object;
        for (Object e2 : jSONArray) {
            JSONObject jSONObject2;
            if (!(e2 instanceof JSONObject) || !(jSONObject2 = (JSONObject)e2).containsKey("resource") || !jSONObject2.containsKey("sprite")) continue;
            asZ.b(jSONObject2.getString("resource"), jSONObject2.getString("sprite"), bl);
        }
    }

    private static void i(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("textures");
        if (jSONObject2 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        ad.asZ.aqo.forEach((string, string2) -> hashMap.put(string2, (String)string));
        ad.asZ.aqp.forEach((string, string2) -> hashMap.put(string2, (String)string));
        for (Map.Entry entry : jSONObject2.entrySet()) {
            String string3 = ad.w(entry.getValue());
            if (string3 == null) continue;
            ad.b(entry, hashMap.getOrDefault(string3, string3));
        }
    }

    private static boolean U(String string, String string2) {
        int n2 = string.indexOf("assets/");
        if (n2 < 0 || !string.endsWith(".json")) {
            return false;
        }
        String string3 = string.substring(n2 + "assets/".length());
        int n3 = string3.indexOf(47);
        return n3 > 0 && string3.startsWith(string2 + "/", n3 + 1);
    }

    static boolean eG(String string) {
        return ad.U(string, "models") && (!string.startsWith("ia_overlay_1_21_2_plus/") || !ad.U(string, "models/equipment"));
    }

    private static String eH(String string) {
        int n2 = string.indexOf("assets/");
        return n2 < 0 ? string : string.substring(n2);
    }

    static Map a(Map map, JSONObject jSONObject, Version version) {
        return (Map)ad.a(map, jSONObject).apply(version);
    }

    static Function a(Map map, JSONObject jSONObject) {
        ah ah2 = ah.a(map, new am());
        return version -> ad.a(ah2, jSONObject, version);
    }

    private static Map a(ah ah2, JSONObject jSONObject, Version version) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ah2.ath.forEach(aj2 -> {
            if (!aj2.yu().isRemoved() && aj2.pK().startsWith("assets/")) {
                linkedHashMap.put(aj2.pK(), aj2.pK());
            }
        });
        Object object = jSONObject.get("overlays");
        if (object == null) {
            return linkedHashMap;
        }
        if (!(object instanceof JSONObject)) {
            throw new IllegalStateException("Invalid overlays in final pack entry 'pack.mcmeta': " + String.valueOf(object));
        }
        JSONObject jSONObject2 = (JSONObject)object;
        Object object2 = jSONObject2.get("entries");
        if (!(object2 instanceof JSONArray)) {
            throw new IllegalStateException("Invalid overlay entries in final pack entry 'pack.mcmeta': " + String.valueOf(jSONObject2.get("entries")));
        }
        JSONArray jSONArray = (JSONArray)object2;
        int n2 = zw.k(version);
        for (Object e2 : jSONArray) {
            if (!(e2 instanceof JSONObject)) {
                throw new IllegalStateException("Invalid overlay entry in final pack entry 'pack.mcmeta': " + String.valueOf(e2));
            }
            JSONObject jSONObject3 = (JSONObject)e2;
            String string = ad.c(jSONObject3);
            int[] nArray = ad.j(jSONObject3);
            if (n2 < nArray[0] || n2 > nArray[1]) continue;
            String string2 = StringUtils.strip((String)string, (String)"/") + "/";
            ah2.ath.forEach(aj2 -> {
                if (aj2.yu().isRemoved() || !aj2.pK().startsWith(string2 + "assets/")) {
                    return;
                }
                linkedHashMap.put(aj2.pK().substring(string2.length()), aj2.pK());
            });
        }
        return linkedHashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static int[] j(JSONObject jSONObject) {
        try {
            Object object;
            boolean bl = jSONObject.containsKey("min_format");
            if (bl != jSONObject.containsKey("max_format")) {
                throw new IllegalArgumentException();
            }
            if (bl) {
                int[] nArray;
                int[] nArray2 = ad.a(jSONObject.get("min_format"), 0);
                if (nArray2[0] > (nArray = ad.a(jSONObject.get("max_format"), Integer.MAX_VALUE))[0]) throw new IllegalArgumentException();
                if (nArray2[0] == nArray[0] && nArray2[1] > nArray[1]) {
                    throw new IllegalArgumentException();
                }
                return new int[]{nArray2[0] + (nArray2[1] == 0 ? 0 : 1), nArray[0]};
            }
            Object object2 = object = jSONObject.get("formats");
            int n2 = 0;
            block7: while (true) {
                switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{Integer.class, JSONArray.class, JSONObject.class}, (Object)object2, n2)) {
                    case 0: {
                        Integer n3 = (Integer)object2;
                        int[] nArray = new int[2];
                        nArray[0] = n3;
                        int[] nArray3 = nArray;
                        nArray[1] = n3;
                        return nArray3;
                    }
                    case 1: {
                        Object object3;
                        int[] nArray3;
                        JSONArray jSONArray = (JSONArray)object2;
                        if (jSONArray.size() == 2 && (object3 = jSONArray.get(0)) instanceof Integer) {
                            Integer n4 = (Integer)object3;
                            Object object4 = jSONArray.get(1);
                            if (object4 instanceof Integer) {
                                Integer n5 = (Integer)object4;
                                nArray3 = ad.s(n4, n5);
                                return nArray3;
                            }
                        }
                        n2 = 2;
                        continue block7;
                    }
                    case 2: {
                        int[] nArray3;
                        JSONObject jSONObject2 = (JSONObject)object2;
                        Object object5 = jSONObject2.get("min_inclusive");
                        if (object5 instanceof Integer) {
                            Integer n6 = (Integer)object5;
                            object5 = jSONObject2.get("max_inclusive");
                            if (object5 instanceof Integer) {
                                Integer n7 = (Integer)object5;
                                nArray3 = ad.s(n6, n7);
                                return nArray3;
                            }
                        }
                        n2 = 3;
                        continue block7;
                    }
                }
                break;
            }
            throw new IllegalArgumentException();
        }
        catch (RuntimeException runtimeException) {
            throw new IllegalStateException("Invalid overlay format range in final pack entry 'pack.mcmeta' for directory '" + jSONObject.getString("directory") + "'", runtimeException);
        }
    }

    private static int[] s(int n2, int n3) {
        if (n2 > n3) {
            throw new IllegalArgumentException();
        }
        return new int[]{n2, n3};
    }

    static String c(JSONObject jSONObject) {
        String string;
        Object object = jSONObject.get("directory");
        if (!(object instanceof String) || !(string = (String)object).matches("[-_a-zA-Z0-9.]+")) {
            throw new IllegalStateException("Invalid overlay directory in final pack entry 'pack.mcmeta': '" + String.valueOf(object) + "'");
        }
        return string;
    }

    static int v(Object object) {
        return ad.a(object, 0)[0];
    }

    private static int[] a(Object object2, int n2) {
        int[] nArray;
        Object object3 = object2;
        int n3 = 0;
        block4: while (true) {
            switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{Integer.class, JSONArray.class}, (Object)object3, n3)) {
                case 0: {
                    Integer n4 = (Integer)object3;
                    if (n4 < 0) {
                        n3 = 1;
                        continue block4;
                    }
                    int[] nArray2 = new int[2];
                    nArray2[0] = n4;
                    nArray = nArray2;
                    nArray2[1] = n2;
                    break block4;
                }
                case 1: {
                    JSONArray jSONArray = (JSONArray)object3;
                    if (jSONArray.size() < 1 || jSONArray.size() > 256 || !jSONArray.stream().allMatch(object -> {
                        Integer n2;
                        return object instanceof Integer && (n2 = (Integer)object) >= 0;
                    })) {
                        n3 = 2;
                        continue block4;
                    }
                    int[] nArray3 = new int[2];
                    nArray3[0] = jSONArray.getIntValue(0);
                    nArray = nArray3;
                    nArray3[1] = jSONArray.size() > 1 ? jSONArray.getIntValue(1) : n2;
                    break block4;
                }
                default: {
                    throw new IllegalArgumentException("Invalid pack format: " + String.valueOf(object2));
                }
            }
            break;
        }
        return nArray;
    }

    private static Set i(Set set) {
        return set.stream().map(ad::eH).filter(string -> string.startsWith("assets/")).collect(Collectors.toUnmodifiableSet());
    }

    private void a(Set set, java.util.function.Predicate predicate) {
        this.ata.clear();
        this.asC.values().forEach(jSONObject -> {
            JSONObject jSONObject2 = jSONObject.getJSONObject("textures");
            if (jSONObject2 == null) {
                return;
            }
            for (Object e : jSONObject2.values()) {
                String string;
                String string2 = ad.w(e);
                if (string2 == null || a.gf(string2) || ad.c(set, string = ad.ch(string2)) || predicate.test(string) || this.eM(string)) continue;
                this.ata.add(string);
            }
        });
    }

    private static boolean c(Set set, String string) {
        String string2 = ad.a(string, ak.TEXTURES, "png");
        return set.contains(string2);
    }

    private void k(JSONObject jSONObject) {
        Object object2;
        if (jSONObject == null || !((object2 = jSONObject.get("sources")) instanceof JSONArray)) {
            return;
        }
        JSONArray jSONArray = (JSONArray)object2;
        jSONArray.removeIf(object -> {
            JSONObject jSONObject;
            return object instanceof JSONObject && (jSONObject = (JSONObject)object).containsKey("resource") && jSONObject.containsKey("sprite") && this.ata.contains(ad.ch(jSONObject.getString("resource")));
        });
    }

    @Nullable
    private static JSONObject a(Map map, String string) {
        ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry = (ItemsAdderPackCompressedEvent$PackEntry)map.get(string);
        return itemsAdderPackCompressedEvent$PackEntry == null || itemsAdderPackCompressedEvent$PackEntry.isRemoved() ? null : ad.d(itemsAdderPackCompressedEvent$PackEntry, string);
    }

    @Nullable
    private static JSONObject a(ah ah2, String string) {
        ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry = ah2.fp(string);
        return itemsAdderPackCompressedEvent$PackEntry == null ? null : ad.d(itemsAdderPackCompressedEvent$PackEntry, string);
    }

    private static JSONObject d(ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry, String string) {
        byte[] byArray = itemsAdderPackCompressedEvent$PackEntry.getBytes();
        itemsAdderPackCompressedEvent$PackEntry.setBytes(byArray);
        try {
            return JSON.parseObject((byte[])byArray);
        }
        catch (JSONException jSONException) {
            throw new IllegalStateException("Malformed JSON in final pack entry '" + string + "'", jSONException);
        }
    }

    private static ItemsAdderPackCompressedEvent$PackEntry e(String string, JSONObject jSONObject) {
        return ItemsAdderPackCompressedEvent$PackEntry.bytes(string, JSON.toJSONBytes((Object)jSONObject, (JSONWriter.Feature[])new JSONWriter.Feature[]{JSONWriter.Feature.LargeObject}));
    }

    private static Map k(Map map) {
        TreeMap treeMap = new TreeMap();
        map.forEach((string, set) -> treeMap.put(string, new TreeSet(set)));
        return treeMap;
    }

    void b(Collection collection, Collection collection2) {
        this.a(collection, collection2, bce::warn);
    }

    void a(Collection collection, Collection collection2, Consumer consumer) {
        this.a(collection, collection2, Map.of(), consumer);
    }

    void a(Collection collection, Collection collection2, Map map, Consumer consumer) {
        this.a(collection, collection2, map, consumer, null, List.of(Version.UNKNOWN));
    }

    private void a(Collection collection, Collection collection2, Map map, Consumer consumer, @Nullable j j2, Collection collection3) {
        TreeSet treeSet;
        String string3;
        TreeMap<String, JSONObject> treeMap = new TreeMap<String, JSONObject>();
        map.forEach((string, jSONObject) -> treeMap.put(o.el(string), (JSONObject)jSONObject));
        this.asC.forEach((string, jSONObject) -> {
            String string2 = g.gl(string);
            if (string.startsWith("ia_overlay_modern_atlas/")) {
                treeMap.put(string2, (JSONObject)jSONObject);
            } else {
                treeMap.putIfAbsent(string2, (JSONObject)jSONObject);
            }
        });
        TreeSet treeSet2 = new TreeSet(collection);
        String string4 = "assets/minecraft/models/item/";
        this.asC.forEach((string2, jSONObject) -> {
            String string3 = ad.eH(string2);
            if (string3.startsWith(string4) && string3.indexOf(47, string4.length()) < 0) {
                treeSet2.add(g.gl(string2));
                treeSet2.addAll(b.M(jSONObject));
            }
        });
        this.asB = o.a(treeMap, treeSet2, collection2);
        this.asE.clear();
        this.asF.clear();
        asU.clear();
        treeMap.forEach((string, jSONObject) -> asU.put(string, jSONObject.getString("parent")));
        Set set = Set.copyOf(this.asv);
        af af2 = ad.yO();
        HashMap hashMap = new HashMap();
        TreeMap<String, Boolean> treeMap2 = new TreeMap<String, Boolean>();
        ArrayList<k> arrayList = new ArrayList<k>();
        for (Map.Entry object : this.asC.entrySet()) {
            boolean bl;
            String string5 = (String)object.getKey();
            JSONObject bl2 = (JSONObject)object.getValue();
            string3 = g.gl(string5);
            if (this.asB.ye().contains(string3)) {
                bl = true;
            } else if (this.asB.yd().contains(string3)) {
                bl = false;
            } else if (af2.atd.contains(string3)) {
                bl = false;
            } else {
                boolean bl3;
                boolean jSONObject3 = g.gk(string3);
                boolean bl4 = !jSONObject3 && set.contains(string3);
                bl = jSONObject3 || bl4;
                boolean bl5 = bl3 = af2.fo(string3) || this.c(string5, hashMap);
                if (!bl3) {
                    treeMap2.put(string3, bl);
                    arrayList.add(this.b(string5, string3, bl, bl4));
                }
            }
            this.a(string5, string3, bl2, bl);
        }
        this.asJ.atx += (long)treeMap2.size();
        if (!treeMap2.isEmpty()) {
            if (j2 != null) {
                j2.a(collection3, arrayList);
            } else {
                treeSet = new j();
                ((j)((Object)treeSet)).a(collection3, treeMap2);
                ++this.asJ.aty;
                consumer.accept(((j)((Object)treeSet)).xJ());
            }
        }
        this.asB.yh().forEach((string, jSONObject) -> this.a("ia_overlay_modern_atlas/" + o.em(string), (String)string, (JSONObject)jSONObject, false));
        treeSet = new TreeSet();
        this.asE.forEach((string, jSONObject) -> {
            JSONObject jSONObject2 = jSONObject.getJSONObject("textures");
            if (jSONObject2 == null) {
                return;
            }
            boolean bl = (Boolean)this.asF.get(string);
            for (Object e : jSONObject2.values()) {
                String string2 = ad.w(e);
                if (string2 == null || a.gf(string2)) continue;
                treeSet.add((bl ? "b:" : "i:") + this.eK(string2));
            }
        });
        for (String string5 : treeSet) {
            boolean bl = string5.startsWith("b:");
            string3 = string5.substring(2);
            if (this.o(string3, bl)) continue;
            String string6 = asZ.l(string3, bl);
            if (string6 == null) {
                string6 = asZ.k(string3, bl);
            }
            if (bl) {
                this.X(string3, string6);
            } else {
                this.W(string3, string6);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put((Object)"type", (Object)"single");
            jSONObject2.put((Object)"resource", (Object)string3);
            jSONObject2.put((Object)"sprite", (Object)string6);
            this.asR.getJSONArray("sources").add((Object)jSONObject2);
        }
        this.asE.forEach((string, jSONObject) -> this.a((String)string, (JSONObject)jSONObject, (Boolean)this.asF.get(string)));
        this.asz.clear();
        this.asy.forEach((string, jSONObject) -> this.asz.put("ia_overlay_modern_atlas/" + string, this.p((JSONObject)jSONObject)));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static af yO() {
        Map map;
        if (!da.P()) {
            return new af(Set.of(), Set.of());
        }
        Map map2 = map = da.db().lJ;
        synchronized (map2) {
            List list = map.values().stream().flatMap(dp2 -> dp2.nO.pC.values().stream()).toList();
            return new af(ad.b(list), ad.c(list));
        }
    }

    private boolean c(String string, Map map) {
        String string2 = this.asN.getOrDefault(string, string);
        ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry = this.asM == null ? null : this.asM.fp(string2);
        File file = itemsAdderPackCompressedEvent$PackEntry == null || this.atb == null ? null : this.atb.c(itemsAdderPackCompressedEvent$PackEntry, string2);
        return ad.a(file, map);
    }

    static boolean a(@Nullable File file, Map map) {
        if (file == null) {
            return false;
        }
        File file2 = file.getParentFile();
        return file2 != null && map.computeIfAbsent(file2, ad::s) != false;
    }

    public static boolean r(@Nullable File file) {
        return file != null && ad.s(file.getParentFile());
    }

    private static boolean s(@Nullable File file) {
        return file != null && (new File(file, ".metadata").isFile() || new File(file, ".uuid").isFile());
    }

    static Set b(Collection collection) {
        return collection.stream().filter(dx2 -> !dx2.po.ge()).map(dx::ga).map(o::el).collect(Collectors.toUnmodifiableSet());
    }

    static Set c(Collection collection) {
        return collection.stream().map(dx::ga).map(o::el).filter(string -> string.lastIndexOf(47) > string.indexOf(58)).map(string -> string.substring(0, string.lastIndexOf(47))).collect(Collectors.toUnmodifiableSet());
    }

    static Set d(Collection collection) {
        return collection.stream().map(dx::ga).map(o::el).collect(Collectors.toUnmodifiableSet());
    }

    private k b(String string, String string2, boolean bl, boolean bl2) {
        String string3;
        String string4 = this.asN.getOrDefault(string, string);
        ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry = this.asM == null ? null : this.asM.fp(string4);
        t t2 = itemsAdderPackCompressedEvent$PackEntry == null || this.atb == null ? null : this.atb.a(itemsAdderPackCompressedEvent$PackEntry, string4);
        String string5 = itemsAdderPackCompressedEvent$PackEntry == null || this.atb == null ? string4 : Objects.requireNonNullElse(this.atb.b(itemsAdderPackCompressedEvent$PackEntry, string4), string4);
        n n2 = ad.a(itemsAdderPackCompressedEvent$PackEntry != null, t2, this.asL.contains(string2), this.asA.values().stream().anyMatch(map -> map.containsKey(string2)));
        String string6 = string3 = bl ? "blockstate" : "item declaration";
        String string7 = n2 == n.ITEMSADDER_BUNDLED ? "no " + string3 + " root; bundled runtime support model" : (n2 == n.ITEMSADDER_GENERATED ? "no " + string3 + " root; generated internal support model" : (bl2 ? "configuration fallback; no " + string3 + " root" : "folder fallback; no " + string3 + " root"));
        return new k(string2, bl, n2, string4, string5, string7, itemsAdderPackCompressedEvent$PackEntry != null, false);
    }

    static n a(boolean bl, @Nullable t t2, boolean bl2, boolean bl3) {
        if (bl) {
            if (t2 == null) {
                return n.EVENT_STREAM_OR_WRITER;
            }
            if (t2 == t.STREAM || t2 == t.WRITER) {
                return bl2 ? n.ITEMSADDER_GENERATED : n.EVENT_STREAM_OR_WRITER;
            }
            return switch (t2) {
                default -> throw new MatchException(null, null);
                case t.BUNDLED -> n.ITEMSADDER_BUNDLED;
                case t.GENERATED -> n.ITEMSADDER_GENERATED;
                case t.USER_CONTENT -> n.USER_CONTENT_PACK;
                case t.EXTERNAL_PACK -> n.EXTERNAL_RESOURCE_PACK;
                case t.UNKNOWN -> n.UNKNOWN;
                case t.STREAM, t.WRITER -> throw new IllegalStateException("handled above");
            };
        }
        if (bl2) {
            return n.ITEMSADDER_GENERATED;
        }
        if (bl3) {
            return n.VANILLA_CLIENT_ASSET;
        }
        return n.UNKNOWN;
    }

    static Map a(Map map, Set set, Map map2, Version version2, BiFunction biFunction) {
        TreeMap treeMap = new TreeMap();
        HashMap hashMap = new HashMap();
        map2.forEach((string, jSONObject) -> hashMap.put(o.el(g.gl(string)), jSONObject));
        BiFunction<Version, String, JSONObject> biFunction2 = (version, string) -> {
            JSONObject jSONObject = (JSONObject)hashMap.get(o.el(string));
            return jSONObject != null ? jSONObject : (JSONObject)biFunction.apply(version, string);
        };
        map.values().forEach(set2 -> {
            Set set3 = set2.stream().map(o::el).collect(Collectors.toCollection(TreeSet::new));
            boolean bl = set3.stream().anyMatch(string -> !string.startsWith("minecraft:"));
            Set set4 = set3.stream().filter(string -> string.startsWith("minecraft:block/") || bl && ad.a(version2, string, biFunction2, new HashSet())).collect(Collectors.toCollection(TreeSet::new));
            if (set4.isEmpty()) {
                return;
            }
            if (set4.size() == set3.size() && set3.stream().noneMatch(string -> set.contains(string) && hashMap.containsKey(string))) {
                return;
            }
            set.addAll(set4);
            set4.stream().forEach(string -> ad.a(version2, string, biFunction2, hashMap.keySet(), treeMap, new HashSet()));
        });
        return treeMap;
    }

    private static boolean a(Version version, String string2, BiFunction biFunction, Set set) {
        String string3 = o.el(string2);
        if (!set.add(string3)) {
            return false;
        }
        if (string3.startsWith("minecraft:block/")) {
            return true;
        }
        JSONObject jSONObject = (JSONObject)biFunction.apply(version, string3);
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("textures");
        if (jSONObject2 != null && jSONObject2.values().stream().map(ad::w).filter(Objects::nonNull).filter(string -> !a.gf(string)).map(string -> string.contains(":") ? string : "minecraft:" + string).anyMatch(string -> string.contains(":block/"))) {
            return true;
        }
        String string4 = jSONObject.getString("parent");
        return string4 != null && !string4.isBlank() && ad.a(version, string4, biFunction, set);
    }

    private static void a(Version version, String string, BiFunction biFunction, Set set, Map map, Set set2) {
        String string2;
        String string3 = o.el(string);
        if (map.containsKey(string3) || itemsadder.m.an.a(string3) || !set2.add(string3)) {
            return;
        }
        JSONObject jSONObject = (JSONObject)biFunction.apply(version, string3);
        if (jSONObject == null) {
            return;
        }
        if (!set.contains(string3)) {
            map.put(string3, (JSONObject)JSON.copy((Object)jSONObject, (JSONWriter.Feature[])new JSONWriter.Feature[0]));
        }
        if ((string2 = jSONObject.getString("parent")) != null && !string2.isBlank()) {
            ad.a(version, string2, biFunction, set, map, set2);
        }
        set2.remove(string3);
    }

    private void a(String string, String string2, JSONObject jSONObject, boolean bl) {
        JSONObject jSONObject2 = ad.l(jSONObject);
        ad.b(string2, jSONObject2);
        string = bcy.iR(string);
        this.asE.put(string, jSONObject2);
        this.asF.put(string, bl);
    }

    static JSONObject l(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject((Map)jSONObject);
        JSONObject jSONObject3 = jSONObject.getJSONObject("textures");
        if (jSONObject3 == null) {
            return jSONObject2;
        }
        JSONObject jSONObject4 = new JSONObject((Map)jSONObject3);
        jSONObject3.forEach((string, object) -> {
            if (object instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject)object;
                jSONObject4.put(string, (Object)new JSONObject((Map)jSONObject2));
            }
        });
        jSONObject2.put((Object)"textures", (Object)jSONObject4);
        return jSONObject2;
    }

    JSONObject eI(String string) {
        JSONObject jSONObject = (JSONObject)this.asE.get(string = bcy.iR(string));
        if (jSONObject == null) {
            throw new IllegalStateException("Modern atlas model was not planned before compression: '" + string + "'");
        }
        return jSONObject;
    }

    JSONObject eJ(String string) {
        JSONObject jSONObject = (JSONObject)this.asz.get(string = bcy.iR(string));
        if (jSONObject == null) {
            throw new IllegalStateException("Modern item definition was not planned before compression: '" + string + "'");
        }
        return (JSONObject)JSON.copy((Object)jSONObject, (JSONWriter.Feature[])new JSONWriter.Feature[0]);
    }

    private String eK(String string) {
        String string2 = ad.ch(string);
        return this.ata.contains(string2) || string2.equals("minecraft:missingno") ? "minecraft:item/iamissing" : string2;
    }

    private static String ch(String string) {
        return string.contains(":") ? string : "minecraft:" + string;
    }

    @Nullable
    private static String w(Object object) {
        if (object instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject)object;
            return jSONObject.getString("sprite");
        }
        return object == null ? null : String.valueOf(object);
    }

    private static void b(Map.Entry entry, String string) {
        Object v2 = entry.getValue();
        if (v2 instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject)v2;
            jSONObject.put((Object)"sprite", (Object)string);
        } else {
            entry.setValue(string);
        }
    }

    private void a(String string, JSONObject jSONObject, boolean bl) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("textures");
        if (jSONObject2 == null) {
            return;
        }
        for (Map.Entry entry : jSONObject2.entrySet()) {
            String string2 = ad.w(entry.getValue());
            if (string2 == null || string2.isBlank()) {
                throw new IllegalStateException("Cannot read texture in model '" + string + "': " + String.valueOf(entry.getValue()));
            }
            if (a.gf(string2)) continue;
            String string3 = this.eK(string2);
            JSONObject jSONObject3 = (JSONObject)this.asQ.get(bl ? "blocks.json" : "items.json");
            if (this.j(jSONObject3, string3) != null) {
                ad.b(entry, string3);
                continue;
            }
            String string4 = asZ.l(string3, bl);
            if (string4 == null) {
                throw new IllegalStateException("Modern atlas alias was not planned for model '" + string + "', texture '" + string3 + "', context '" + (bl ? "block" : "item") + "'");
            }
            ad.b(entry, string4);
        }
    }

    void a(Map map, Map map2, java.util.function.Predicate predicate) {
        this.a(map, map2, predicate, null, null);
    }

    void a(Map map, Map map2, java.util.function.Predicate predicate, Function function) {
        this.a(map, map2, predicate, function, null, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void a(Map map, Map map2, java.util.function.Predicate predicate, BiFunction biFunction, Collection collection, @Nullable Set set, @Nullable java.util.function.Predicate predicate2) {
        j j2 = new j();
        try {
            this.a(map, map2, predicate, biFunction, collection, set, predicate2, j2);
        }
        finally {
            this.a(j2);
        }
    }

    private void a(Map map, Map map2, java.util.function.Predicate predicate, BiFunction biFunction, Collection collection, @Nullable Set set, @Nullable java.util.function.Predicate predicate2, j j2) {
        Set set2 = collection.stream().filter(version -> version != Version.UNKNOWN).map(zw::k).collect(Collectors.toSet());
        if (set2.size() > 1) {
            this.asG = new as();
            this.asG.a(ar.VANILLA_VERSION_SELECTION_ERROR, al.CACHED_VANILLA_ASSET, "one selected declaration view cannot be validated across different pack formats " + String.valueOf(set2) + "; select declarations separately for each format");
            throw ad.a(this.asG);
        }
        as as2 = new as();
        for (Version version2 : collection) {
            Function<String, JSONObject> function = string -> (JSONObject)biFunction.apply(version2, string);
            as as3 = this.a(map, map2, predicate, function, set, predicate2, version2);
            as3.zz().forEach(aq2 -> {
                j2.a(version2, (aq)aq2);
                as2.a(aq2.xU(), aq2.xV(), "Vanilla client assets " + version2.getName() + ": " + aq2.xY());
            });
        }
        this.asG = as2;
        if (as2.zA()) {
            throw ad.a(as2);
        }
    }

    private void a(j j2) {
        if (j2.isEmpty()) {
            return;
        }
        if (j2.xH()) {
            ++this.asJ.aty;
        }
        bk.k("Modern atlas", ChatColor.stripColor((String)j2.aS(true)));
        Consumer consumer = j2.xI() ? this.asH : this.asI;
        consumer.accept(j2.ed("ItemsAdder/output/resource-pack-diagnostics.txt"));
    }

    private Set a(ah ah2) {
        if (this.asp == null || this.asp.isEmpty()) {
            return Set.of();
        }
        HashSet<String> hashSet = new HashSet<String>();
        for (String string : this.asp.keySet()) {
            String string2 = (String)ah2.atj.get(string);
            if (string2 == null) {
                string2 = bcy.iR(string);
            }
            hashSet.add(o.el(g.gl(string2)));
        }
        return Set.copyOf(hashSet);
    }

    an yP() {
        return this.asJ.zi();
    }

    void yQ() {
        this.yR();
        this.asL = Set.of();
        this.asR = null;
    }

    private void yR() {
        this.asw.clear();
        this.asx.clear();
        this.asy.clear();
        this.asz.clear();
        this.asA.clear();
        this.asB = null;
        this.asC.clear();
        this.asD.clear();
        this.asE.clear();
        this.asF.clear();
        this.asK.clear();
        this.asQ.clear();
        this.asW.clear();
        this.ata.clear();
        asZ.clear();
    }

    void a(Map map, Map map2, java.util.function.Predicate predicate, @Nullable Set set, @Nullable java.util.function.Predicate predicate2) {
        this.a(map, map2, predicate, (T string) -> null, set, predicate2);
    }

    private void a(Map map, Map map2, java.util.function.Predicate predicate, Function function, @Nullable Set set, @Nullable java.util.function.Predicate predicate2) {
        this.asG = this.a(map, map2, predicate, function, set, predicate2, Version.UNKNOWN);
        if (this.asG.zA()) {
            throw ad.a(this.asG);
        }
    }

    as yS() {
        as as2 = new as();
        as2.b(this.asG);
        return as2;
    }

    private as a(Map map, Map map2, java.util.function.Predicate predicate, Function function, @Nullable Set set, @Nullable java.util.function.Predicate predicate2, Version version) {
        as as2 = new as();
        ao ao2 = new ao(this, predicate, function);
        Set set3 = ad.o((JSONObject)this.asQ.get("items.json"));
        Set set4 = ad.o((JSONObject)this.asQ.get("blocks.json"));
        TreeSet treeSet = new TreeSet(set3);
        treeSet.retainAll(set4);
        if (!treeSet.isEmpty()) {
            as2.a(ar.PLANNER_FATAL, al.PLANNER_REMAP, "sprite IDs are emitted by both items.json and blocks.json: " + String.valueOf(treeSet));
        }
        map.forEach((string, set2) -> this.a((String)string, (Set)set2, ao2, set, predicate2, version, as2));
        map2.forEach((string, set2) -> set2.forEach(string2 -> this.a((String)string, (String)string2, false, ao2, set, predicate2, version, as2)));
        if (set != null && predicate2 != null) {
            this.a((JSONObject)this.asQ.get("items.json"), false, set, predicate2, as2);
            this.a((JSONObject)this.asQ.get("blocks.json"), true, set, predicate2, as2);
        }
        return as2;
    }

    private void a(String string2, Set set, ao ao2, @Nullable Set set2, @Nullable java.util.function.Predicate predicate, Version version, as as2) {
        TreeSet treeSet = new TreeSet();
        TreeSet treeSet2 = new TreeSet();
        for (String string3 : new TreeSet(set)) {
            String string4 = o.el(string3);
            String string5 = this.asB.yg().getOrDefault(string4, string4);
            al al2 = string5.equals(string4) ? al.SELECTED_PACK_ENTRY : al.PLANNER_REMAP;
            Set set3 = o.a(string5, (T string) -> ao2.fq((String)string).zf());
            if (!set3.isEmpty()) {
                as2.a(this.asB.yd().contains(string4) || this.asB.yg().containsValue(string5) ? ar.PLANNER_FATAL : ar.PRE_EXISTING_WARNING, al2, this.a(string2, string3, string5, List.of(string5), "item model has unresolved face texture slots " + String.valueOf(set3)));
            }
            this.a(string2, string3, string5, true, al2, ao2, new HashSet(), new ArrayList(), Set.of(), treeSet, treeSet2, set2, predicate, version, as2);
        }
        if (!treeSet.isEmpty() && !treeSet2.isEmpty()) {
            as2.a(ar.PLANNER_FATAL, al.PLANNER_REMAP, this.a(string2, String.join((CharSequence)", ", new TreeSet(set)), "<declaration>", List.of(), "item declaration mixes atlas resources; item textures=" + String.valueOf(treeSet) + ", block textures=" + String.valueOf(treeSet2)));
        }
    }

    private void a(String string, String string2, boolean bl, ao ao2, @Nullable Set set, @Nullable java.util.function.Predicate predicate, Version version, as as2) {
        Object object;
        Object object2 = o.el(string2);
        al al2 = al.SELECTED_PACK_ENTRY;
        if (bl) {
            object = this.asB.yg().getOrDefault(object2, object2);
            if (!((String)object).equals(object2)) {
                al2 = al.PLANNER_REMAP;
            }
            object2 = object;
        }
        object = new TreeSet();
        TreeSet treeSet = new TreeSet();
        this.a(string, string2, (String)object2, bl, al2, ao2, new HashSet(), new ArrayList(), Set.of(), (Set)object, treeSet, set, predicate, version, as2);
        if (bl && !treeSet.isEmpty() || !bl && !object.isEmpty()) {
            String string3 = bl ? "item" : "block";
            as2.a(ar.PLANNER_FATAL, al2, this.a(string, string2, (String)object2, List.of(object2), "expected only " + string3 + " atlas aliases; item textures=" + String.valueOf(object) + ", block textures=" + String.valueOf(treeSet)));
        }
    }

    private void a(String string, String string2, String string3, boolean bl, al al2, ao ao2, Set set, List list, Set set2, Set set3, Set set4, @Nullable Set set5, @Nullable java.util.function.Predicate predicate, Version version, as as2) {
        Object object;
        Object object22;
        Object object3;
        Object object4;
        if (!set.add(string3 = o.el(string3))) {
            return;
        }
        ++this.asJ.atq;
        ArrayList<String> arrayList = new ArrayList<String>(list);
        arrayList.add(string3);
        au au2 = ao2.fq(string3);
        JSONObject jSONObject = au2.zf();
        al al3 = au2.xV();
        if (jSONObject != null && al3 != al.CACHED_VANILLA_ASSET) {
            ++this.asJ.atr;
        }
        if (jSONObject == null) {
            boolean bl2;
            if (ao2.fr(string3)) {
                return;
            }
            boolean bl3 = this.asB.yd().contains(string3) || this.asB.ye().contains(string3) || this.asB.yg().containsValue(string3);
            boolean bl4 = bl2 = bl3 && version != Version.UNKNOWN && string3.startsWith("minecraft:") && !ao2.ft(string3);
            if (al2 == al.PLANNER_REMAP || al2 == al.PLANNER_ITEM_VARIANT || bl3) {
                as2.a(bl2 ? ar.VANILLA_VERSION_SELECTION_ERROR : ar.PLANNER_FATAL, bl2 ? al.CACHED_VANILLA_ASSET : (bl3 ? ao2.fs(string3) : al2), this.a(string, string2, string3, arrayList, "planner-generated model target is absent"));
            } else {
                as2.a(ar.PRE_EXISTING_WARNING, al.ORIGINAL_UNRESOLVED, this.a(string, string2, string3, arrayList, "original model reference is unresolved; no selected pack entry" + (String)(version == Version.UNKNOWN ? "" : " or matching Vanilla model for " + version.getName())));
            }
            return;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("textures");
        if (jSONObject2 != null) {
            object4 = jSONObject2.entrySet().iterator();
            while (object4.hasNext()) {
                String string4;
                boolean bl5;
                object3 = (Map.Entry)object4.next();
                if (set2.contains(object3.getKey())) continue;
                object22 = object3.getValue();
                object = ad.w(object22);
                if (object == null || ((String)object).isBlank()) {
                    as2.a(al3 == al.CACHED_VANILLA_ASSET ? ar.PRE_EXISTING_WARNING : ar.PLANNER_FATAL, al3, this.a(string, string2, string3, arrayList, "cannot read texture value '" + String.valueOf(object22) + "'"));
                    continue;
                }
                if (a.gf((String)object)) continue;
                String string5 = string3 + "=" + (String)object;
                String string6 = ad.ch((String)object);
                boolean bl6 = bl5 = this.j((JSONObject)this.asQ.get(bl ? "items.json" : "blocks.json"), string6) != null;
                if (bl5) {
                    if (bl) {
                        set3.add(string5);
                    } else {
                        set4.add(string5);
                    }
                } else if (asZ.n((String)object, false) != null) {
                    set3.add(string5);
                    if (!bl) {
                        as2.a(ar.PLANNER_FATAL, al3, this.a(string, string2, string3, arrayList, "conflicting textures: block tree resolved item atlas alias '" + (String)object + "'"));
                    }
                } else if (asZ.n((String)object, true) != null) {
                    set4.add(string5);
                    if (bl) {
                        as2.a(ar.PLANNER_FATAL, al3, this.a(string, string2, string3, arrayList, "conflicting textures: item tree resolved block atlas alias '" + (String)object + "'"));
                    }
                } else if (al3 == al.CACHED_VANILLA_ASSET) {
                    if (string6.equals("minecraft:missingno")) {
                        set3.add(string3 + "=minecraft:item/iamissing");
                        as2.a(ar.INTENTIONAL_MISSING_FALLBACK, al.INTENTIONAL_MISSING_FALLBACK, "minecraft:missingno is normalized to the item-context fallback minecraft:item/iamissing");
                    } else if (ad.g((JSONObject)this.asQ.get("items.json"), string6) || ad.g(ash, string6)) {
                        set3.add(string5);
                    } else if (ad.g((JSONObject)this.asQ.get("blocks.json"), string6) || ad.g(asi, string6)) {
                        set4.add(string5);
                    } else {
                        as2.a(ar.PRE_EXISTING_WARNING, al3, this.a(string, string2, string3, arrayList, "texture '" + (String)object + "' is not selected by the effective item or block atlas"));
                    }
                } else {
                    as2.a(ar.PLANNER_FATAL, al3, this.a(string, string2, string3, arrayList, "texture was not rewritten to a planned atlas alias: '" + (String)object + "'"));
                }
                String string7 = string4 = bl5 ? string6 : ad.p((String)object, bl);
                if ("minecraft:item/iamissing".equals(string4)) {
                    as2.a(ar.INTENTIONAL_MISSING_FALLBACK, al.INTENTIONAL_MISSING_FALLBACK, "atlas context '" + (bl ? "item" : "block") + "' uses the intentional missing fallback minecraft:item/iamissing");
                }
                if (set5 == null || predicate == null || string4 == null || "minecraft:item/iamissing".equals(string4) || this.a(string4, set5, predicate)) continue;
                as2.a(this.V(string4, (String)object) ? ar.PLANNER_FATAL : ar.PRE_EXISTING_WARNING, this.V(string4, (String)object) ? al.PLANNER_REMAP : al.SELECTED_PACK_ENTRY, this.a(string, string2, string3, arrayList, "texture reference '" + (String)object + "', resolved resource location '" + string4 + "', atlas context '" + (bl ? "item" : "block") + "' has no selected pack entry '" + ad.a(string4, ak.TEXTURES, "png") + "'"));
            }
        }
        if ((object4 = jSONObject.getString("parent")) != null && !((String)object4).isBlank()) {
            object3 = o.el((String)object4);
            object22 = this.eL((String)object3);
            object = new HashSet(set2);
            if (jSONObject2 != null) {
                object.addAll(jSONObject2.keySet());
            }
            this.a(string, string2, (String)object4, bl, (al)((Object)object22), ao2, set, arrayList, (Set)object, set3, set4, set5, predicate, version, as2);
        }
        for (Object object22 : ad.m(jSONObject)) {
            object = o.el((String)object22);
            this.a(string, string2, (String)object22, bl, this.eL((String)object), ao2, set, arrayList, Set.of(), set3, set4, set5, predicate, version, as2);
        }
    }

    private al eL(String string) {
        return this.asB.yg().containsValue(string) ? al.PLANNER_REMAP : al.SELECTED_PACK_ENTRY;
    }

    private static List m(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putAll((Map)jSONObject);
        jSONObject2.remove((Object)"overrides");
        return b.M(jSONObject2);
    }

    static boolean g(JSONObject jSONObject, String string) {
        return ad.c(jSONObject, string, true);
    }

    static boolean h(JSONObject jSONObject, String string) {
        return ad.i(jSONObject, string) != null;
    }

    private static boolean c(JSONObject jSONObject, String string, boolean bl) {
        Object object;
        if (jSONObject == null || !((object = jSONObject.get("sources")) instanceof JSONArray)) {
            return false;
        }
        JSONArray jSONArray = (JSONArray)object;
        object = ad.ch(string);
        if (ad.i(jSONObject, (String)object) != null) {
            return true;
        }
        if (!bl) {
            return false;
        }
        int n2 = ((String)object).indexOf(58);
        String string2 = ((String)object).substring(0, n2);
        String string3 = ((String)object).substring(n2 + 1);
        for (Object e2 : jSONArray) {
            String string4;
            JSONObject jSONObject2;
            String string5;
            if (!(e2 instanceof JSONObject) || (string5 = (jSONObject2 = (JSONObject)e2).getString("type")) == null) continue;
            if ("directory".equals(string5 = string5.substring(string5.indexOf(58) + 1))) {
                string4 = ad.ch(jSONObject2.getString("source"));
                String string6 = string4.substring(0, string4.indexOf(58));
                String string7 = StringUtils.strip((String)StringUtils.defaultString((String)jSONObject2.getString("prefix")), (String)"/");
                if (!string2.equals(string6) || !string7.isEmpty() && !string3.equals(string7) && !string3.startsWith(string7 + "/")) continue;
                return true;
            }
            if (!"single".equals(string5)) continue;
            string4 = jSONObject2.getString("sprite");
            if (string4 == null) {
                string4 = jSONObject2.getString("resource");
            }
            if (string4 == null || !((String)object).equals(ad.ch(string4))) continue;
            return true;
        }
        return false;
    }

    @Nullable
    private static JSONObject i(JSONObject jSONObject, String string) {
        Object object;
        if (jSONObject == null || !((object = jSONObject.get("sources")) instanceof JSONArray)) {
            return null;
        }
        JSONArray jSONArray = (JSONArray)object;
        object = ad.ch(string);
        for (Object e2 : jSONArray) {
            Object object2;
            JSONObject jSONObject2;
            String string2;
            if (!(e2 instanceof JSONObject) || (string2 = (jSONObject2 = (JSONObject)e2).getString("type")) == null || !"paletted_permutations".equals(string2.substring(string2.indexOf(58) + 1)) || !((object2 = jSONObject2.get("textures")) instanceof JSONArray)) continue;
            JSONArray jSONArray2 = (JSONArray)object2;
            object2 = jSONObject2.get("permutations");
            if (!(object2 instanceof JSONObject)) continue;
            JSONObject jSONObject3 = (JSONObject)object2;
            object2 = StringUtils.defaultString((String)jSONObject2.getString("separator"), (String)"_");
            for (Object e3 : jSONArray2) {
                String string3 = ad.ch(String.valueOf(e3));
                if (!jSONObject3.keySet().stream().anyMatch(arg_0 -> ad.a((String)object, string3, (String)object2, arg_0))) continue;
                return jSONObject2;
            }
        }
        return null;
    }

    @Nullable
    private JSONObject j(JSONObject jSONObject, String string) {
        if (jSONObject == null) {
            return null;
        }
        return (JSONObject)this.asK.computeIfAbsent(jSONObject, ad::n).get(ad.ch(string));
    }

    private static Map n(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Object object = jSONObject.get("sources");
        if (!(object instanceof JSONArray)) {
            return hashMap;
        }
        JSONArray jSONArray = (JSONArray)object;
        for (Object e2 : jSONArray) {
            Object object2;
            JSONObject jSONObject2;
            String string;
            if (!(e2 instanceof JSONObject) || (string = (jSONObject2 = (JSONObject)e2).getString("type")) == null || !"paletted_permutations".equals(string.substring(string.indexOf(58) + 1)) || !((object2 = jSONObject2.get("textures")) instanceof JSONArray)) continue;
            JSONArray jSONArray2 = (JSONArray)object2;
            object2 = jSONObject2.get("permutations");
            if (!(object2 instanceof JSONObject)) continue;
            JSONObject jSONObject3 = (JSONObject)object2;
            object2 = StringUtils.defaultString((String)jSONObject2.getString("separator"), (String)"_");
            for (Object e3 : jSONArray2) {
                String string2 = ad.ch(String.valueOf(e3));
                jSONObject3.keySet().forEach(arg_0 -> ad.a(hashMap, string2, (String)object2, jSONObject2, arg_0));
            }
        }
        return hashMap;
    }

    private boolean o(String string, boolean bl) {
        JSONObject jSONObject = (JSONObject)this.asQ.get(bl ? "blocks.json" : "items.json");
        JSONObject jSONObject2 = this.j(jSONObject, string);
        if (jSONObject2 == null) {
            jSONObject2 = this.j((JSONObject)this.asQ.get(bl ? "items.json" : "blocks.json"), string);
        }
        if (jSONObject2 == null) {
            jSONObject2 = this.j(this.asR, string);
        }
        if (jSONObject2 == null) {
            jSONObject2 = this.j(ash, string);
        }
        if (jSONObject2 == null) {
            jSONObject2 = this.j(asi, string);
        }
        if (jSONObject2 == null) {
            return false;
        }
        if (this.j(jSONObject, string) == null) {
            jSONObject.getJSONArray("sources").add(JSON.copy((Object)jSONObject2, (JSONWriter.Feature[])new JSONWriter.Feature[0]));
            this.asK.remove(jSONObject);
        }
        if (this.j(this.asR, string) == null) {
            this.asR.getJSONArray("sources").add(JSON.copy((Object)jSONObject2, (JSONWriter.Feature[])new JSONWriter.Feature[0]));
            this.asK.remove(this.asR);
        }
        return true;
    }

    private boolean eM(String string) {
        return this.asQ != null && this.asQ.values().stream().anyMatch(jSONObject -> this.j((JSONObject)jSONObject, string) != null) || this.j(this.asR, string) != null || this.j(ash, string) != null || this.j(asi, string) != null;
    }

    static List yT() {
        List<Version> list = Arrays.stream(Version.values()).filter(version -> version.getOrdinal() >= Version.v1_21_11.getOrdinal()).toList();
        List<Version> list2 = list.stream().filter(version -> !itemsadder.m.an.go.contains(version)).toList();
        if (!list2.isEmpty()) {
            throw new IllegalStateException("Cached Vanilla assets are unavailable for supported modern client versions: " + String.valueOf(list2.stream().map(Version::getName).toList()));
        }
        return list;
    }

    @Nullable
    private JSONObject c(Version version2, String string2) {
        String string3 = o.el(string2);
        if (itemsadder.m.an.a(string3) || !string3.startsWith("minecraft:")) {
            return null;
        }
        Map map = this.asA.computeIfAbsent(version2, version -> new HashMap());
        return map.computeIfAbsent(string3, string -> {
            File file = itemsadder.m.d.g().B.b(version2, (String)string);
            if (file == null) {
                return null;
            }
            try {
                return dev.lone.itemsadder.utils.json.c.N(file);
            }
            catch (JSONException | IOException throwable) {
                throw new IllegalStateException("Failed to read cached Vanilla model '" + string + "' for client version " + version2.getName() + " from " + String.valueOf(file), throwable);
            }
        });
    }

    @Nullable
    private static String p(String string, boolean bl) {
        return asZ.n(string, !bl);
    }

    private void a(JSONObject jSONObject, boolean bl, Set set, java.util.function.Predicate predicate, as as2) {
        Object object;
        if (jSONObject == null || !((object = jSONObject.get("sources")) instanceof JSONArray)) {
            return;
        }
        JSONArray jSONArray = (JSONArray)object;
        for (Object e2 : jSONArray) {
            JSONObject jSONObject2;
            if (!(e2 instanceof JSONObject) || !(jSONObject2 = (JSONObject)e2).containsKey("resource") || !jSONObject2.containsKey("sprite")) continue;
            String string = ad.ch(jSONObject2.getString("resource"));
            if (this.a(string, set, predicate)) {
                if (!"minecraft:item/iamissing".equals(string)) continue;
                as2.a(ar.INTENTIONAL_MISSING_FALLBACK, al.INTENTIONAL_MISSING_FALLBACK, "atlas context '" + (bl ? "block" : "item") + "' intentionally maps sprite '" + jSONObject2.getString("sprite") + "' to minecraft:item/iamissing");
                continue;
            }
            boolean bl2 = this.V(string, jSONObject2.getString("sprite"));
            as2.a(bl2 ? ar.PLANNER_FATAL : ar.PRE_EXISTING_WARNING, bl2 ? al.PLANNER_REMAP : al.SELECTED_PACK_ENTRY, "atlas texture reference '" + jSONObject2.getString("sprite") + "', resolved resource location '" + string + "', atlas context '" + (bl ? "block" : "item") + "' has no selected pack entry '" + ad.a(string, ak.TEXTURES, "png") + "'");
        }
    }

    private boolean V(String string, String string2) {
        return this.asW.contains("rs:" + string + "->" + string2);
    }

    private boolean a(String string, Set set, java.util.function.Predicate predicate) {
        return "minecraft:item/iamissing".equals(string) || ad.c(set, string) || predicate.test(string) || this.eM(string);
    }

    private ap a(String string, String string2, String string3, List list, String string4) {
        String string5 = this.asN.getOrDefault(string, string);
        ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry = this.asM == null ? null : this.asM.fp(string5);
        String string6 = itemsAdderPackCompressedEvent$PackEntry == null || this.atb == null ? string : Objects.requireNonNullElse(this.atb.b(itemsAdderPackCompressedEvent$PackEntry, string5), string);
        return new ap(string6, string2, string3, List.copyOf(list), string4);
    }

    private static IllegalStateException a(as as2) {
        String string = as2.zz().stream().filter(aq::zw).map(aq2 -> "[" + String.valueOf((Object)aq2.xU()) + "/" + String.valueOf((Object)aq2.xV()) + "] " + aq2.xY()).collect(Collectors.joining("\n - ", "\n - ", ""));
        return new IllegalStateException("Modern atlas validation failed:" + string);
    }

    private static Set o(JSONObject jSONObject) {
        Object object;
        TreeSet<String> treeSet = new TreeSet<String>();
        if (jSONObject == null || !((object = jSONObject.get("sources")) instanceof JSONArray)) {
            return treeSet;
        }
        JSONArray jSONArray = (JSONArray)object;
        for (Object e2 : jSONArray) {
            JSONObject jSONObject2;
            if (!(e2 instanceof JSONObject) || !(jSONObject2 = (JSONObject)e2).containsKey("resource")) continue;
            treeSet.add(jSONObject2.getString(jSONObject2.containsKey("sprite") ? "sprite" : "resource"));
        }
        return treeSet;
    }

    public void f(String string, JSONObject jSONObject) {
        Object object;
        Object object2;
        boolean bl;
        if (ae.dq && this.asB != null) {
            boolean bl2;
            String string2 = o.el(string);
            boolean bl3 = this.asB.yg().containsValue(string2);
            boolean bl4 = bl2 = !bl3 && this.asB.ye().contains(string2);
            if (!(bl2 || bl3 || this.asB.yd().contains(string2))) {
                throw new IllegalStateException("Modern atlas context was not planned for model '" + string2 + "'");
            }
            this.a(string2, jSONObject, bl2);
            return;
        }
        Object object3 = jSONObject.get("textures");
        if (!(object3 instanceof JSONObject)) {
            return;
        }
        JSONObject jSONObject2 = (JSONObject)object3;
        boolean bl5 = bl = g.gk(string) || this.ast.contains(string) || this.asu.contains(string);
        if (!bl && jSONObject.containsKey("elements")) {
            for (Map.Entry entry : jSONObject.getJSONArray("elements")) {
                if (!(entry instanceof JSONObject) || !(object2 = (JSONObject)entry).containsKey("faces")) continue;
                object = object2.getJSONObject("faces");
                for (String string3 : object.keySet()) {
                    String string4;
                    JSONObject jSONObject3 = object.getJSONObject(string3);
                    if (!jSONObject3.containsKey("texture") || !(string4 = jSONObject3.getString("texture")).equals("#missing")) continue;
                    jSONObject3.put((Object)"texture", (Object)"#particle");
                }
            }
        }
        for (Map.Entry entry : jSONObject2.entrySet()) {
            object2 = ad.w(entry.getValue());
            if (object2 == null || ((String)object2).isBlank() || a.gf((String)object2)) continue;
            if (!((String)object2).contains(":")) {
                object2 = "minecraft:" + (String)object2;
            }
            if (this.ata.contains(object2)) {
                object2 = "minecraft:item/iamissing";
            }
            if ((object = this.q((String)object2, bl)) == null) continue;
            ad.b(entry, (String)object);
        }
    }

    @Nullable
    private String q(String string, boolean bl) {
        String string2 = this.eK(string);
        if (this.o(string2, bl)) {
            return string2;
        }
        String string3 = asZ.m(string2, bl);
        if (string3 == null) {
            return null;
        }
        if (bl) {
            this.X(string2, string3);
        } else {
            this.W(string2, string3);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((Object)"type", (Object)"single");
        jSONObject.put((Object)"resource", (Object)string2);
        jSONObject.put((Object)"sprite", (Object)string3);
        this.asR.getJSONArray("sources").add((Object)jSONObject);
        return string3;
    }

    void g(String string, JSONObject jSONObject) {
        string = bcy.iR(string);
        TreeSet treeSet = new TreeSet(b.M(jSONObject));
        this.asw.put(string, treeSet);
        this.asy.put(string, (JSONObject)JSON.copy((Object)jSONObject, (JSONWriter.Feature[])new JSONWriter.Feature[0]));
    }

    void h(String string, JSONObject jSONObject) {
        TreeSet treeSet = new TreeSet(b.M(jSONObject));
        this.asx.put(bcy.iR(string), treeSet);
    }

    JSONObject p(JSONObject jSONObject) {
        JSONObject jSONObject2 = (JSONObject)JSON.copy((Object)jSONObject, (JSONWriter.Feature[])new JSONWriter.Feature[0]);
        if (this.asB != null) {
            this.asB.t(jSONObject2);
        }
        return jSONObject2;
    }

    private void W(String string, String string2) {
        String string3;
        String string4 = string3 = string2 == null ? "r:" + string : "rs:" + string + "->" + string2;
        if (!this.asW.add(string3)) {
            return;
        }
        JSONObject jSONObject = (JSONObject)this.asQ.get("items.json");
        JSONArray jSONArray = jSONObject.getJSONArray("sources");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put((Object)"type", (Object)"single");
        jSONObject2.put((Object)"resource", (Object)string);
        if (string2 != null) {
            jSONObject2.put((Object)"sprite", (Object)string2);
        }
        jSONArray.add((Object)jSONObject2);
    }

    private void X(String string, String string2) {
        String string3;
        String string4 = string3 = string2 == null ? "r:" + string : "rs:" + string + "->" + string2;
        if (!this.asW.add(string3)) {
            return;
        }
        JSONObject jSONObject = (JSONObject)this.asQ.get("blocks.json");
        JSONArray jSONArray = jSONObject.getJSONArray("sources");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put((Object)"type", (Object)"single");
        jSONObject2.put((Object)"resource", (Object)string);
        if (string2 != null) {
            jSONObject2.put((Object)"sprite", (Object)string2);
        }
        jSONArray.add((Object)jSONObject2);
    }

    Set yU() {
        HashSet hashSet = new HashSet();
        this.ass.forEach((string, jSONObject) -> {
            if (jSONObject.containsKey("variants")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("variants");
                for (String string2 : jSONObject2.keySet()) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(string2);
                    if (jSONObject3 == null || !jSONObject3.containsKey("model")) continue;
                    String string3 = jSONObject3.getString("model");
                    hashSet.add(string3);
                }
            }
        });
        return hashSet;
    }

    JSONObject q(JSONObject jSONObject) {
        String string;
        HashSet<CallSite> hashSet2;
        JSONObject jSONObject2 = new JSONObject();
        for (HashSet<CallSite> hashSet2 : jSONObject.entrySet()) {
            string = (String)hashSet2.getKey();
            Object v2 = hashSet2.getValue();
            if ("sources".equals(string)) continue;
            jSONObject2.put((Object)string, v2);
        }
        if (jSONObject.containsKey("sources") && (hashSet2 = jSONObject.get("sources")) instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray)hashSet2;
            hashSet2 = new HashSet<CallSite>();
            string = new JSONArray();
            for (Object e2 : jSONArray) {
                if (!(e2 instanceof JSONObject)) {
                    string.add(e2);
                    continue;
                }
                JSONObject jSONObject3 = (JSONObject)e2;
                String string2 = null;
                if (jSONObject3.containsKey("resource") && jSONObject3.containsKey("sprite")) {
                    var10_10 = jSONObject3.getString("resource");
                    String string3 = jSONObject3.getString("sprite");
                    string2 = "rs:" + var10_10 + "->" + string3;
                } else if (jSONObject3.containsKey("resource")) {
                    var10_10 = jSONObject3.getString("resource");
                    string2 = "r:" + var10_10;
                }
                if (string2 != null && !hashSet2.add((CallSite)((Object)string2))) continue;
                string.add((Object)jSONObject3);
            }
            jSONObject2.put((Object)"sources", (Object)string);
        }
        return jSONObject2;
    }

    void yV() {
        Object object;
        String string;
        JSONObject jSONObject;
        Object e2;
        JSONArray jSONArray;
        Object object2;
        JSONObject jSONObject2 = (JSONObject)this.asQ.get("blocks.json");
        JSONObject jSONObject3 = (JSONObject)this.asQ.get("items.json");
        HashSet<CallSite> hashSet = new HashSet<CallSite>();
        if (jSONObject2.containsKey("sources") && (object2 = jSONObject2.get("sources")) instanceof JSONArray) {
            jSONArray = (JSONArray)object2;
            object2 = jSONArray.iterator();
            while (object2.hasNext()) {
                e2 = object2.next();
                if (!(e2 instanceof JSONObject)) continue;
                jSONObject = (JSONObject)e2;
                if (jSONObject.containsKey("resource") && jSONObject.containsKey("sprite")) {
                    string = jSONObject.getString("resource");
                    object = jSONObject.getString("sprite");
                    hashSet.add((CallSite)((Object)("rs:" + string + "->" + (String)object)));
                    continue;
                }
                if (!jSONObject.containsKey("resource")) continue;
                string = jSONObject.getString("resource");
                hashSet.add((CallSite)((Object)("r:" + string)));
            }
        }
        if (jSONObject3.containsKey("sources") && (object2 = jSONObject3.get("sources")) instanceof JSONArray) {
            jSONArray = (JSONArray)object2;
            object2 = jSONArray.iterator();
            while (object2.hasNext()) {
                e2 = object2.next();
                if (!(e2 instanceof JSONObject)) continue;
                jSONObject = (JSONObject)e2;
                if (jSONObject.containsKey("resource") && jSONObject.containsKey("sprite")) {
                    string = jSONObject.getString("resource");
                    String string2 = "rs:" + string + "->" + (String)(object = jSONObject.getString("sprite"));
                    if (!hashSet.contains(string2)) continue;
                    object2.remove();
                    continue;
                }
                if (!jSONObject.containsKey("resource") || !hashSet.contains(object = "r:" + (string = jSONObject.getString("resource")))) continue;
                object2.remove();
            }
        }
    }

    public void d(HashMap hashMap) {
        for (Map.Entry entry : hashMap.entrySet()) {
            azn azn2 = new azn((Material)entry.getKey(), (List)entry.getValue());
            this.asn.put(azn2.Br(), azn2.zd());
        }
    }

    public void yW() {
        if (ae.ds) {
            this.asm.Be();
        }
        if (ae.dt) {
            this.asm.Bi();
        }
    }

    void cy() {
        this.yR();
        if (this.atb != null) {
            this.atb.clear();
            this.atb = null;
        }
        asU.clear();
        this.asn.clear();
        this.asp.clear();
        this.asq.clear();
        this.asr.clear();
        this.ass.clear();
        this.asP.clear();
        this.asX.clear();
        this.asV.clear();
        this.asO = null;
        this.asS = null;
        this.asT = Map.of();
        this.asY = new JSONObject();
        this.asm.cy();
        this.asv = Set.of();
        if (this.asu != null) {
            this.asu.clear();
        }
    }

    public static boolean yX() {
        String string;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("server.properties"));
            Properties properties = new Properties();
            properties.load(bufferedReader);
            bufferedReader.close();
            string = properties.getProperty("resource-pack");
        }
        catch (Exception exception) {
            bce.error("Failed to read server.properties (you can probably ignore this): " + exception.getMessage());
            exception.printStackTrace();
            return false;
        }
        return string != null && !string.isEmpty() && !string.equals(" ");
    }

    public void yY() {
        if (!this.asY.containsKey("pack")) {
            this.asY.put((Object)"pack", (Object)new JSONObject());
        }
        JSONObject jSONObject = this.asY.getJSONObject("pack");
        int n2 = 0;
        @Nullable Object object = null;
        for (File file : itemsadder.m.d.g().y) {
            File file2 = new File(file, "pack.mcmeta");
            if (!file2.exists()) continue;
            try {
                JSONObject jSONObject2;
                Object object2;
                Object object3;
                Object object4;
                Object object5;
                JSONObject jSONObject3 = dev.lone.itemsadder.utils.json.c.N(file2);
                if (jSONObject3.containsKey("pack")) {
                    int n3;
                    object5 = jSONObject3.getJSONObject("pack");
                    if (object == null && object5.containsKey("description") && (object4 = object5.get("description")) != null) {
                        object = object4;
                    }
                    if (object5.containsKey("pack_format") && (n3 = object5.getIntValue("pack_format")) > n2) {
                        n2 = n3;
                    }
                    if (object5.containsKey("supported_formats")) {
                        object3 = object4 = object5.get("supported_formats");
                        int n4 = 0;
                        switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{Integer.class, JSONArray.class, JSONObject.class}, (Object)object3, n4)) {
                            case 0: {
                                object2 = (Integer)object3;
                                if (!jSONObject.containsKey("supported_formats")) {
                                    jSONObject.put((Object)"supported_formats", object2);
                                    break;
                                }
                                if (!(jSONObject.get("supported_formats") instanceof Integer)) break;
                                int n5 = jSONObject.getIntValue("supported_formats");
                                if ((Integer)object2 <= n5) break;
                                jSONObject.put((Object)"supported_formats", object2);
                                break;
                            }
                            case 1: {
                                JSONArray jSONArray = (JSONArray)object3;
                                if (jSONArray.size() == 2) {
                                    if (!jSONObject.containsKey("supported_formats")) {
                                        jSONObject.put((Object)"supported_formats", (Object)jSONArray);
                                        break;
                                    }
                                    if (!(jSONObject.get("supported_formats") instanceof JSONArray)) break;
                                    jSONObject2 = jSONObject.getJSONArray("supported_formats");
                                    if (jSONArray.getInteger(1) <= jSONObject2.getInteger(1)) break;
                                    jSONObject2.set(1, (Object)jSONArray.getInteger(1));
                                    break;
                                }
                                bce.error("Invalid 'supported_formats' array size in pack.mcmeta file. File: " + bcy.iP(file2.getAbsolutePath()));
                                break;
                            }
                            case 2: {
                                jSONObject2 = (JSONObject)object3;
                                if (jSONObject2.containsKey("min_inclusive") && jSONObject2.containsKey("max_inclusive")) {
                                    if (!jSONObject.containsKey("supported_formats")) {
                                        jSONObject.put((Object)"supported_formats", (Object)jSONObject2);
                                        break;
                                    }
                                    if (!(jSONObject.get("supported_formats") instanceof JSONObject)) break;
                                    JSONObject jSONObject4 = jSONObject.getJSONObject("supported_formats");
                                    if (jSONObject2.getIntValue("max_inclusive") <= jSONObject4.getIntValue("max_inclusive")) break;
                                    jSONObject4.put((Object)"max_inclusive", (Object)jSONObject2.getIntValue("max_inclusive"));
                                    break;
                                }
                                bce.error("Invalid 'supported_formats' object in pack.mcmeta file. File: " + bcy.iP(file2.getAbsolutePath()));
                                break;
                            }
                            default: {
                                bce.error("Invalid 'supported_formats' type in pack.mcmeta file. File: " + bcy.iP(file2.getAbsolutePath()));
                            }
                        }
                    }
                }
                if (jSONObject3.containsKey("overlays") && (object5 = jSONObject3.getJSONObject("overlays")).containsKey("entries")) {
                    if (!this.asY.containsKey("overlays")) {
                        this.asY.put((Object)"overlays", (Object)new JSONObject());
                    }
                    object4 = this.asY.getJSONObject("overlays");
                    object3 = object5.getJSONArray("entries");
                    if (!object4.containsKey("entries")) {
                        object4.put((Object)"entries", (Object)new JSONArray());
                    }
                    JSONArray jSONArray = object4.getJSONArray("entries");
                    object2 = object3.iterator();
                    block9: while (object2.hasNext()) {
                        Object e2 = object2.next();
                        jSONObject2 = (JSONObject)e2;
                        ad.u(jSONObject2);
                        for (Object e3 : jSONArray) {
                            JSONObject jSONObject5 = (JSONObject)e3;
                            if (!jSONObject2.getString("directory").equals(jSONObject5.getString("directory"))) continue;
                            bce.warn("Duplicate overlay entry '" + jSONObject2.getString("directory") + "' in pack.mcmeta file. File: " + bcy.iP(file2.getAbsolutePath()));
                            break block9;
                        }
                        jSONArray.add(e2);
                    }
                }
                object5 = jSONObject3.keySet().iterator();
                while (object5.hasNext()) {
                    object4 = (String)object5.next();
                    if (((String)object4).equals("pack") || ((String)object4).equals("overlays")) continue;
                    this.asY.put(object4, jSONObject3.get((String)object4));
                }
            }
            catch (JSONException jSONException) {
                bce.error("Malformed JSON in pack.mcmeta file. File: " + bcy.iP(file2.getAbsolutePath()));
                bce.error(jSONException.getMessage());
            }
            catch (Throwable throwable) {
                bce.error("Error opening pack.mcmeta file. File: " + bcy.iP(file2.getAbsolutePath()), throwable);
            }
        }
        int n6 = Math.max(n2, zw.sX());
        jSONObject.put((Object)"pack_format", (Object)n6);
        ad.b(jSONObject, zw.k(Version.v1_20_6), 9999);
        jSONObject.put((Object)"description", (Object)Objects.requireNonNullElse(object, "ItemsAdder generated resourcepack"));
    }

    void yZ() {
    }

    public void aU(boolean bl) {
        HashMap<String, List> hashMap = new HashMap<String, List>();
        for (File file : itemsadder.m.d.g().x) {
            ad.t(file);
            if (!bl) continue;
            ArrayList arrayList = new ArrayList(FileUtils.listFiles((File)file, (String[])new String[]{"png"}, (boolean)true));
            int n2 = arrayList.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                File file2 = (File)arrayList.get(i2);
                if (file2.getPath().contains("tooltip") || file2.getPath().endsWith("_e.png") || file2.getPath().contains("optifine/cit/") || file2.getPath().contains("gui")) continue;
                try {
                    byte[] byArray = FileUtils.readFileToByteArray((File)file2);
                    String string2 = DigestUtils.md5Hex((byte[])byArray);
                    hashMap.computeIfAbsent(string2, string -> new ArrayList()).add(bcy.iP(file2.getAbsolutePath()));
                    continue;
                }
                catch (IOException iOException) {
                    bce.warn("Failed to calculate hash for image: " + bcy.iP(file2.getAbsolutePath()));
                }
            }
        }
        if (bl) {
            List<Map.Entry> list = hashMap.entrySet().stream().filter(entry -> ((List)entry.getValue()).size() > 1).toList();
            if (!list.isEmpty()) {
                bce.warn(" ");
                bce.warn(" ");
                bce.warn("Duplicate images found in resourcepacks: " + list.size());
                bce.warn("Consider reusing the same textures instead of creating multiple copies.");
                bce.warn(" ");
                bce.warn(" ");
            }
            list.forEach(entry -> {
                bce.warn((String)((List)entry.getValue()).getFirst());
                ((List)entry.getValue()).forEach(string -> bce.warn("  - " + string));
            });
        }
    }

    public static void t(File file) {
        ad.u(file);
    }

    public static void u(File file) {
        bdq bdq2 = new bdq();
        int n2 = 0;
        long l2 = 0L;
        long l3 = 0L;
        if (file.exists()) {
            boolean bl = false;
            ImageWriter imageWriter = null;
            ImageWriteParam imageWriteParam = null;
            ArrayList arrayList = new ArrayList(FileUtils.listFiles((File)file, (String[])new String[]{"png"}, (boolean)true));
            int n3 = arrayList.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                File file2 = (File)arrayList.get(i2);
                try {
                    BufferedImage bufferedImage;
                    Object object;
                    block31: {
                        if (ad.w(file2)) continue;
                        try (InputStream inputStream = Files.newInputStream(file2.toPath(), new OpenOption[0]);){
                            if (be.d(inputStream.readNBytes(24)) == null) break block31;
                            continue;
                        }
                    }
                    long l4 = file2.length();
                    l2 += l4;
                    try (Closeable closeable = ImageIO.createImageInputStream(Files.newInputStream(file2.toPath(), new OpenOption[0]));){
                        object = ImageIO.getImageReadersByFormatName("png").next();
                        ((ImageReader)object).setInput(closeable, true, false);
                        bufferedImage = ((ImageReader)object).read(0);
                        ((ImageReader)object).dispose();
                    }
                    closeable = new bea();
                    object = new MemoryCacheImageOutputStream((OutputStream)closeable);
                    try {
                        if (!bl) {
                            ImageTypeSpecifier imageTypeSpecifier = ImageTypeSpecifier.createFromRenderedImage(bufferedImage);
                            imageWriter = ImageIO.getImageWriters(imageTypeSpecifier, "png").next();
                            imageWriteParam = imageWriter.getDefaultWriteParam();
                            bl = true;
                        }
                        imageWriter.setOutput(object);
                        imageWriter.write(null, new IIOImage(bufferedImage, null, null), imageWriteParam);
                        long l5 = ((ByteArrayOutputStream)closeable).size();
                        if (l5 < l4) {
                            byte[] byArray = ((bea)closeable).DW();
                            try (FileOutputStream fileOutputStream = new FileOutputStream(file2);){
                                ((OutputStream)fileOutputStream).write(byArray, 0, ((ByteArrayOutputStream)closeable).size());
                                ++n2;
                            }
                        }
                        l3 += l5;
                        ad.v(file2);
                        continue;
                    }
                    finally {
                        ((MemoryCacheImageOutputStream)object).close();
                    }
                }
                catch (Throwable throwable) {
                    bce.error("Error stripping metadata of file '" + file2.getAbsolutePath().replace(file.getAbsolutePath(), "") + "': " + throwable.getMessage());
                }
            }
            if (imageWriter != null) {
                imageWriter.dispose();
            }
        } else {
            bce.error("Error stripping metadata. Respack folder not found!");
        }
        if (n2 > 0) {
            bce.log(String.valueOf(ChatColor.GREEN) + "Compressed " + n2 + " PNGs in " + bdq2.DJ() + "ms. " + bcy.k(l2) + "->" + bcy.k(l3));
        }
    }

    private static void v(File file) {
        d.b(file, "ia_compression_handled");
    }

    private static boolean w(File file) {
        return d.c(file, "ia_compression_handled");
    }

    public static void r(JSONObject jSONObject) {
        jSONObject.remove((Object)"groups");
    }

    public static void s(JSONObject jSONObject) {
        Optional<String> optional;
        if (!jSONObject.containsKey("textures")) {
            return;
        }
        Object object = jSONObject.get("textures");
        if (!(object instanceof JSONObject)) {
            return;
        }
        JSONObject jSONObject2 = (JSONObject)object;
        Optional<String> optional2 = optional = jSONObject2.containsKey("layer0") ? Optional.of("layer0") : jSONObject2.keySet().stream().findFirst();
        if (optional.isEmpty() && jSONObject.containsKey("parent")) {
            return;
        }
        String string2 = optional.map(string -> "#" + string).orElse("minecraft:item/iamissing");
        @Nullable String string3 = jSONObject2.getString("particle");
        if (string3 == null || string3.isEmpty()) {
            jSONObject2.put((Object)"particle", (Object)string2);
        }
    }

    private static void a(String string, File file, int[] nArray, int n2, int n3) {
        String string2 = ad.a(nArray, n2);
        if (n3 < 0) {
            bce.warn("Duplicate CustomModelData values for item '" + string + "': " + string2 + ". More values follow. File: " + bcy.I(file));
            return;
        }
        if (n3 == n2) {
            bce.warn("Found " + n3 + " duplicate CustomModelData override" + (n3 == 1 ? "" : "s") + " for item '" + string + "': " + string2 + ". File: " + bcy.I(file));
        } else {
            bce.warn("Duplicate CustomModelData values for item '" + string + "': " + string2 + ". Total duplicate overrides: " + n3 + ". File: " + bcy.I(file));
        }
    }

    static String a(int[] nArray, int n2) {
        int n3;
        if (n2 == 0) {
            return "";
        }
        Arrays.sort(nArray, 0, n2);
        StringBuilder stringBuilder = new StringBuilder(Math.min(n2 * 6, 4096));
        int n4 = n3 = nArray[0];
        for (int i2 = 1; i2 < n2; ++i2) {
            int n5 = nArray[i2];
            if (n5 == n4) continue;
            if ((long)n5 == (long)n4 + 1L) {
                n4 = n5;
                continue;
            }
            ad.a(stringBuilder, n3, n4);
            n3 = n4 = n5;
        }
        ad.a(stringBuilder, n3, n4);
        return stringBuilder.toString();
    }

    private static void a(StringBuilder stringBuilder, int n2, int n3) {
        if (!stringBuilder.isEmpty()) {
            stringBuilder.append(", ");
        }
        stringBuilder.append(n2);
        if (n2 != n3) {
            stringBuilder.append('-').append(n3);
        }
    }

    public void za() {
        JSONArray jSONArray;
        Object object;
        Object object2;
        Object object3;
        String string2;
        Object object4;
        Object object5;
        File file2;
        Object object6;
        bbr.c("Processing packs: merging item overrides...", 0.0);
        this.asX = new ArrayList();
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        List list = itemsadder.m.d.g().x;
        for (File object7 : list) {
            object6 = object7.listFiles(File::isDirectory);
            if (object6 == null || !(file2 = new File(object7, "minecraft/models")).exists() || !((File)(object5 = new File(file2, "item"))).exists() || (object4 = ((File)object5).listFiles(file -> file.isFile() && file.getName().endsWith(".json") && !file.getName().startsWith("."))) == null) continue;
            for (JSONArray jSONArray2 : object4) {
                try {
                    JSONObject jSONObject = dev.lone.itemsadder.utils.json.c.N((File)jSONArray2);
                    string2 = jSONArray2.getName();
                    String string3 = FilenameUtils.removeExtension((String)string2);
                    if (jSONObject.containsKey("overrides")) {
                        if (hashMap.containsKey(string3)) {
                            object3 = (JSONObject)hashMap.get(string3);
                            JSONArray jSONArray3 = jSONObject.getJSONArray("overrides");
                            if (object3.containsKey("overrides")) {
                                object2 = object3.getJSONArray("overrides");
                                object = new int[Math.min(jSONArray3.size(), 512)];
                                int n2 = 0;
                                int n3 = 0;
                                JSONArray jSONArray4 = (JSONArray)dev.lone.itemsadder.utils.json.c.L(object3).read("$.overrides[?(@.predicate)].predicate[?(@.custom_model_data)].custom_model_data", new Predicate[0]);
                                for (Object e2 : jSONArray3) {
                                    Object object8 = ((JSONArray)dev.lone.itemsadder.utils.json.c.L((JSONObject)e2).read("$.predicate[?(@.custom_model_data)]", new Predicate[0])).getJSONObject(0).get("custom_model_data");
                                    if (object8 == null) continue;
                                    if (jSONArray4.contains(object8)) {
                                        if (n2 == ((int[])object).length) {
                                            ad.a(string3, (File)jSONArray2, (int[])object, n2, -1);
                                            n2 = 0;
                                        }
                                        object[n2++] = (Integer)object8;
                                        ++n3;
                                        continue;
                                    }
                                    Material material = aiq.dD(string3);
                                    if (material != null) {
                                        qm qm2 = itemsadder.m.d.g().a(material, (Integer)object8);
                                        if (qm2 == null) {
                                            object2.add(e2);
                                            continue;
                                        }
                                        bce.warn("Skipped CustomModelData '" + String.valueOf(object8) + "' for item override '" + string2 + "'. Already used by ItemsAdder custom item '" + qm2.Gh + "'. Item file: " + qm2.nh());
                                        continue;
                                    }
                                    bce.warn("Cannot find Bukkit material for model file: " + bcy.I((File)jSONArray2));
                                }
                                if (n3 <= 0) continue;
                                ad.a(string3, (File)jSONArray2, (int[])object, n2, n3);
                                continue;
                            }
                            object3.put((Object)"overrides", (Object)jSONArray3);
                            continue;
                        }
                        hashMap.put(string3, jSONObject);
                        continue;
                    }
                    hashMap.put(string3, jSONObject);
                }
                catch (IOException iOException) {
                    bce.error("Failed to process item file: " + bcy.I((File)jSONArray2), iOException);
                }
                catch (Throwable throwable) {
                    bce.error("Malformed JSON " + bcy.I((File)jSONArray2));
                    bce.error(throwable.getMessage());
                }
            }
        }
        bbr.bf("Processing packs: merging " + this.asn.size() + " generated predicates...");
        for (Map.Entry entry : this.asn.entrySet()) {
            try {
                object6 = (String)entry.getKey();
                file2 = (JSONObject)entry.getValue();
                object5 = (JSONObject)hashMap.get(object6);
                if (object5 != null) {
                    if (!object5.containsKey("overrides")) {
                        object5.put((Object)"overrides", (Object)new JSONArray());
                    }
                    object5.getJSONArray("overrides").addAll((Collection)file2.getJSONArray("overrides"));
                } else {
                    object5 = file2;
                    hashMap.put(object6, object5);
                }
                azn.B((JSONObject)object5);
                object4 = object5.getJSONArray("overrides");
                try {
                    if (object4.getJSONObject(object4.size() - 1).getString("model").equals("item/" + (String)entry.getKey())) continue;
                    jSONArray = new JSONObject();
                    int n4 = object4.getJSONObject(object4.size() - 1).getJSONObject("predicate").getInteger("custom_model_data");
                    jSONArray.put((Object)"predicate", (Object)new JSONObject());
                    jSONArray.getJSONObject("predicate").put((Object)"custom_model_data", (Object)(n4 + 1));
                    jSONArray.put((Object)"model", (Object)("item/" + (String)entry.getKey()));
                    object4.add((Object)jSONArray);
                }
                catch (Exception exception) {
                }
            }
            catch (Throwable throwable) {
                bce.error("Failed to process item file: " + (String)entry.getKey(), throwable);
            }
        }
        this.asn.clear();
        this.asn.putAll(hashMap);
        hashMap.clear();
        bbr.bf("Processing packs: merging font providers...");
        if (!this.asO.containsKey("providers")) {
            this.asO.put((Object)"providers", (Object)new JSONArray());
        }
        for (File file3 : list) {
            object6 = new File(file3, "minecraft/font/default.json");
            if (!((File)object6).exists()) continue;
            try {
                file2 = dev.lone.itemsadder.utils.json.c.N((File)object6);
            }
            catch (JSONException jSONException) {
                bce.error("Malformed JSON file. File: " + bcy.iP(((File)object6).getAbsolutePath()));
                bce.error(jSONException.getMessage());
                continue;
            }
            catch (Throwable throwable) {
                bce.error("Error opening a custom font file. Make sure it's valid or delete it. File: " + bcy.iP(((File)object6).getAbsolutePath()), throwable);
                continue;
            }
            if (file2 == null || !file2.containsKey("providers")) continue;
            object5 = this.t(this.asO);
            object4 = new ArrayList();
            jSONArray = this.asO.getJSONArray("providers");
            for (Object e3 : file2.getJSONArray("providers")) {
                try {
                    JSONArray jSONArray2;
                    jSONArray2 = (JSONObject)e3;
                    if (jSONArray.contains((Object)jSONArray2)) continue;
                    if (jSONArray2.containsKey("type") && jSONArray2.getString("type").equals("bitmap")) {
                        int n5;
                        int n6;
                        if (!jSONArray2.containsKey("file")) {
                            bce.warn("Missing 'file' property for provider. File: " + bcy.I((File)object6));
                            bce.warn(dev.lone.itemsadder.utils.json.c.a((JSONObject)jSONArray2, true, true).replace("\\\"", "\""));
                            continue;
                        }
                        if (!jSONArray2.containsKey("chars")) {
                            bce.warn("Missing 'chars' property for provider '" + jSONArray2.getString("file") + "'. File: " + bcy.I((File)object6));
                            continue;
                        }
                        boolean bl = true;
                        string2 = jSONArray2.getJSONArray("chars");
                        Iterator iterator = string2.iterator();
                        while (iterator.hasNext()) {
                            object3 = iterator.next();
                            String string4 = (String)object5.get(object3);
                            if (string4 == null) continue;
                            object2 = fw.aX(String.valueOf(object3)) + " in '" + jSONArray2.getString("file") + "' is already supplied by '" + string4 + "'";
                            if (dev.lone.itemsadder.utils.json.c.N(object3) && (object = (Object)itemsadder.m.d.g().al.aS((String)object3)) != null) {
                                object2 = (String)object2 + " (ItemsAdder font_image '" + ((v)object).getNamespacedID() + "')";
                            }
                            object4.add(object2);
                            bk.k("Duplicate font characters", (String)object2 + "\nFile: " + bcy.I((File)object6) + "\nThe existing provider wins; this bitmap provider was skipped.");
                            bl = false;
                        }
                        if (!bl) continue;
                        int n7 = jSONArray.size();
                        if (jSONArray2.containsKey("ascent") && jSONArray2.containsKey("height") && (n6 = jSONArray2.getInteger("ascent").intValue()) > (n5 = jSONArray2.getInteger("height").intValue())) {
                            this.a("Ascent " + n6 + " higher than height " + n5 + " ", (Object)string2, (JSONObject)jSONArray2, (File)object6);
                        }
                        if ((object3 = jSONArray2.getString("file")).startsWith("minecraft:") && this.eN((String)object3)) {
                            jSONArray.add(e3);
                        } else {
                            File file4 = itemsadder.m.d.s(ad.Y((String)(object3 = object3.contains(":") ? "assets/" + object3.replace(":", "/textures/") : "assets/minecraft/textures/" + (String)object3), "png"));
                            if (file4 != null && file4.exists()) {
                                jSONArray.add(e3);
                                this.asX.add(file4);
                            } else if (object3.startsWith("minecraft:")) {
                                bce.warn("Failed to add font glyph entry. Vanilla resource '" + (String)object3 + "' does not exist. File: " + bcy.I((File)object6));
                            } else {
                                this.a("png not found for ", (Object)string2, (JSONObject)jSONArray2, (File)object6);
                            }
                        }
                        if (jSONArray.size() <= n7) continue;
                        string2.forEach(arg_0 -> ad.b((Map)object5, (JSONObject)jSONArray2, arg_0));
                        continue;
                    }
                    jSONArray.add(e3);
                }
                catch (Throwable throwable) {
                    bce.error("Error reading JSON file: " + bcy.I((File)object6), throwable);
                }
            }
            if (object4.isEmpty()) continue;
            bce.warn("Skipped bitmap font providers with " + object4.size() + " duplicate character" + (object4.size() == 1 ? "" : "s") + ". Existing providers win. Conflicts:\n- " + String.join((CharSequence)"\n- ", (Iterable<? extends CharSequence>)object4) + "\nFile: " + bcy.I((File)object6));
        }
        bbr.bf("Processing packs: collecting font textures...");
        for (Map.Entry entry : itemsadder.m.d.g().al.um.entrySet()) {
            object6 = ((fw)entry.getValue()).hZ();
            if (object6 == null) continue;
            this.asX.add(object6);
        }
        bbr.bf("Processing packs: generating atlases...");
        this.yI();
        bbr.bf("Processing packs: generating sounds metadata...");
        this.asT = azt.BC();
        this.asS = this.asT.computeIfAbsent("minecraft", string -> new JSONObject());
    }

    public boolean eN(String object) {
        if (!itemsadder.m.d.g().B.aB()) {
            bce.warn("Cannot check if the vanilla texture exists by location '" + (String)object + "' because the vanilla assets are not downloaded yet. Retry later.");
            return false;
        }
        if (((String)object).startsWith("minecraft:")) {
            object = ((String)object).replace("minecraft:", "");
        } else {
            object = FilenameUtils.removeExtension((String)object);
            object = ((String)object).replace("assets/minecraft/", "");
        }
        if (!((String)object).endsWith(".png")) {
            object = (String)object + ".png";
        }
        return itemsadder.m.d.g().B.P((String)object);
    }

    private void a(String string, Object object, JSONObject jSONObject, File file) {
        String string2 = "'. File: " + bcy.I(file);
        String string3 = jSONObject.getString("file");
        if (object instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray)object;
            if (jSONArray.size() == 1) {
                String string4 = jSONArray.getString(0);
                bce.warn(string + string4 + " (" + fw.aX(string4) + ") '" + string3 + string2);
            } else {
                bce.warn(string + String.valueOf(object) + " (" + fw.aX(object.toString()) + ") '" + string3 + string2);
            }
        } else {
            bce.warn(string + String.valueOf(object) + " (" + fw.aX(object.toString()) + ") '" + string3 + string2);
        }
    }

    Map t(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = jSONObject.getJSONArray("providers");
        if (jSONArray == null) {
            return hashMap;
        }
        for (Object e2 : jSONArray) {
            JSONObject jSONObject2;
            JSONArray jSONArray2;
            if (!(e2 instanceof JSONObject) || (jSONArray2 = (jSONObject2 = (JSONObject)e2).getJSONArray("chars")) == null) continue;
            jSONArray2.forEach(object -> hashMap.putIfAbsent(object, Objects.requireNonNullElse(jSONObject2.getString("file"), "provider without a file property")));
        }
        return hashMap;
    }

    private static String eO(String string) {
        if (!ae.ft) {
            string = string.replaceAll("//<SCOREBOARD_HIDE_RED_NUMBERS>.*?//</SCOREBOARD_HIDE_RED_NUMBERS>", "");
        }
        if (!ae.fr) {
            string = string.replaceAll("//<TEXT_EFFECTS>.*?//</TEXT_EFFECTS>", "");
        }
        if (!ae.fs) {
            string = string.replaceAll("//<LEGACY_TEXT_EFFECTS>.*?//</LEGACY_TEXT_EFFECTS>", "");
        }
        if (ae.dj) {
            string = new azs(string).Bx();
        }
        return string;
    }

    private String eP(String string) {
        bdb bdb2 = this.asm.Bl();
        if (bdb2 == null) {
            bdb2 = new bdb(64, 32, 0);
        }
        string = string.replace("%TEX_RES%", String.valueOf(this.asm.axA));
        string = string.replace("%TEX_WIDTH%", String.valueOf(bdb2.ha));
        string = string.replace("%TEX_HEIGHT%", String.valueOf(bdb2.gW));
        return string;
    }

    String r(String string, boolean bl) {
        return bl ? this.eP(string) : string;
    }

    public static String Y(String string, String string2) {
        Object object = "";
        if (!string.startsWith("assets/")) {
            object = "assets/";
        }
        if (!((String)(object = (String)object + string.replace(":", "/"))).endsWith(string2)) {
            object = (String)object + "." + string2;
        }
        return object;
    }

    public static String a(String object, ak ak2, String string) {
        if (!((String)object).startsWith("assets/") && !((String)object).contains(":")) {
            object = "minecraft:" + (String)object;
        }
        Object object2 = "";
        if (!((String)object).startsWith("assets/")) {
            object2 = "assets/";
        }
        if (!((String)(object2 = (String)object2 + ((String)object).replace(":", "/" + ak2.str + "/"))).endsWith(string)) {
            object2 = (String)object2 + "." + string;
        }
        return object2;
    }

    public static boolean eQ(String string) {
        return string.startsWith("minecraft:") || !string.contains(":");
    }

    public static String x(File file) {
        String string = bcy.H(file);
        string = bcy.aE(string, "contents/");
        string = bcy.aE(string, "/contents/");
        return StringUtils.substringBefore((String)string, (String)"/");
    }

    private static JSONArray t(int n2, int n3) {
        return new JSONArray().fluentAdd((Object)Math.min(n2, n3)).fluentAdd((Object)Math.max(n2, n3));
    }

    private static JSONArray u(int n2, int n3) {
        int n4 = Math.min(n2, n3);
        int n5 = Math.max(n2, n3);
        if (n4 < 65 && n5 >= 65) {
            n5 = 64;
        }
        return ad.t(n4, n5);
    }

    private static void a(JSONObject jSONObject, int n2, int n3) {
        int n4 = Math.min(n2, n3);
        int n5 = Math.max(n2, n3);
        jSONObject.put((Object)"min_format", (Object)n4);
        jSONObject.put((Object)"max_format", (Object)n5);
    }

    static void b(JSONObject jSONObject, int n2, int n3) {
        jSONObject.put((Object)"supported_formats", (Object)ad.u(n2, n3));
        ad.a(jSONObject, n2, n3);
    }

    static void c(JSONObject jSONObject, int n2, int n3) {
        jSONObject.put((Object)"formats", (Object)ad.u(n2, n3));
        ad.a(jSONObject, n2, n3);
    }

    static void u(JSONObject jSONObject) {
        Object object = jSONObject.get("formats");
        if (!jSONObject.containsKey("min_format") || !jSONObject.containsKey("max_format")) {
            Object object2 = object;
            int n2 = 0;
            block5: while (true) {
                switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{Integer.class, JSONArray.class, JSONObject.class}, (Object)object2, n2)) {
                    case 0: {
                        Integer n3 = (Integer)object2;
                        ad.a(jSONObject, (int)n3, (int)n3);
                        break block5;
                    }
                    case 1: {
                        JSONArray jSONArray = (JSONArray)object2;
                        if (jSONArray.size() != 2) {
                            n2 = 2;
                            continue block5;
                        }
                        ad.a(jSONObject, jSONArray.getIntValue(0), jSONArray.getIntValue(1));
                        break block5;
                    }
                    case 2: {
                        JSONObject jSONObject2 = (JSONObject)object2;
                        if (!jSONObject2.containsKey("min_inclusive") || !jSONObject2.containsKey("max_inclusive")) {
                            n2 = 3;
                            continue block5;
                        }
                        ad.a(jSONObject, jSONObject2.getIntValue("min_inclusive"), jSONObject2.getIntValue("max_inclusive"));
                        break block5;
                    }
                }
                break;
            }
        }
        if (!jSONObject.containsKey("formats") && jSONObject.containsKey("min_format") && jSONObject.containsKey("max_format")) {
            jSONObject.put((Object)"formats", (Object)ad.u(ad.v(jSONObject.get("min_format")), ad.v(jSONObject.get("max_format"))));
        }
    }

    public void A(qm qm2) {
        if (qm2.FX != null) {
            this.b(qm2.FX);
        }
        if (qm2 instanceof ql) {
            ql ql2 = (ql)qm2;
            if (ql2.Hq == sd.ENTITY) {
                Map map;
                String string = qm2.d(false, true);
                this.i(ad.aa(ql2.getNamespace(), ql2.getId()), ad.s(string, false));
                this.i(ad.ab(ql2.getNamespace(), ql2.getId()), ad.s(string, true));
                Map map2 = ql2.mF();
                if (map2 != null && !(map = this.a(ql2.getNamespace(), ql2.getId(), map2)).isEmpty()) {
                    this.i(ad.ac(ql2.getNamespace(), ql2.getId()), ad.eR(ad.ad(ql2.getNamespace(), ql2.getId())));
                    this.asp.put(ad.ae(ql2.getNamespace(), ql2.getId()), ad.l(map));
                }
                for (int i2 = 0; i2 < 10; ++i2) {
                    this.asp.putIfAbsent(ad.ba(i2), ad.bd(i2));
                    this.asp.putIfAbsent(ad.bb(i2), ad.be(i2));
                }
            }
        }
    }

    private void i(String string, JSONObject jSONObject) {
        String string2 = ad.eH(string);
        File file = itemsadder.m.d.s(string2);
        if (file != null) {
            throw new IllegalArgumentException("ENTITY block item definition path collides with user content: " + string2);
        }
        JSONObject jSONObject2 = this.asq.putIfAbsent(string, jSONObject);
        if (jSONObject2 != null && !jSONObject2.equals((Object)jSONObject)) {
            throw new IllegalStateException("Conflicting ENTITY block item definition: " + string);
        }
    }

    static String Z(String string, String string2) {
        return "_iainternal:entity_blocks/" + string + "/" + string2;
    }

    static String aa(String string, String string2) {
        return "ia_overlay_1_21_4_plus/assets/_iainternal/items/entity_blocks/" + string + "/" + string2 + ".json";
    }

    static String ab(String string, String string2) {
        return "ia_overlay_26_1_plus/assets/_iainternal/items/entity_blocks/" + string + "/" + string2 + ".json";
    }

    static String ac(String string, String string2) {
        return "ia_overlay_1_21_4_plus/assets/_iainternal/items/entity_blocks/" + string + "/" + string2 + "/group_3x3x1.json";
    }

    static String ad(String string, String string2) {
        return "_iainternal:entity_blocks/" + string + "/" + string2 + "/group_3x3x1";
    }

    static String ae(String string, String string2) {
        return "assets/_iainternal/models/entity_blocks/" + string + "/" + string2 + "/group_3x3x1.json";
    }

    static String af(String string, String string2) {
        return "_iainternal:block/entity_blocks/" + string + "/" + string2 + "/group_3x3x1";
    }

    static String ag(String string, String string2) {
        return "assets/_iainternal/textures/block/entity_blocks/" + string + "/" + string2 + "/group_3x3x1.png";
    }

    static String e(String string, String string2, String string3) {
        return "all".equals(string3) ? ad.af(string, string2) : ad.af(string, string2) + "/" + string3;
    }

    static String f(String string, String string2, String string3) {
        return "all".equals(string3) ? ad.ag(string, string2) : ad.ag(string, string2).replace(".png", "/" + string3 + ".png");
    }

    private Map a(String string, String string2, Map map) {
        HashMap<String, File> hashMap = new HashMap<String, File>();
        for (Map.Entry entry : map.entrySet()) {
            File object = itemsadder.m.d.t((String)entry.getValue());
            if (object == null) {
                return Map.of();
            }
            hashMap.put((String)entry.getKey(), object);
        }
        HashMap hashMap2 = new HashMap();
        try {
            for (Map.Entry entry : hashMap.entrySet()) {
                String string3 = (String)entry.getKey();
                File file = (File)entry.getValue();
                String string4 = ad.f(string, string2, string3);
                BufferedImage bufferedImage = ImageIO.read(file);
                if (bufferedImage == null) {
                    throw new IOException("Invalid PNG: " + String.valueOf(file));
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (!ImageIO.write((RenderedImage)ad.b(bufferedImage), "PNG", byteArrayOutputStream)) {
                    throw new IOException("PNG writer unavailable");
                }
                this.asr.put(string4, byteArrayOutputStream.toByteArray());
                File file2 = new File(file.getPath() + ".mcmeta");
                if (file2.isFile()) {
                    this.asr.put(string4 + ".mcmeta", Files.readAllBytes(file2.toPath()));
                }
                hashMap2.put(string3, ad.e(string, string2, string3));
            }
            return hashMap2;
        }
        catch (IOException iOException) {
            throw new IllegalStateException("Failed to generate ENTITY block group textures", iOException);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static BufferedImage b(BufferedImage bufferedImage) {
        int n2 = bufferedImage.getWidth();
        if (n2 < 1 || bufferedImage.getHeight() % n2 != 0) {
            throw new IllegalArgumentException("ENTITY block texture frames must be square: " + bufferedImage.getWidth() + "x" + bufferedImage.getHeight());
        }
        int n3 = 3;
        int n4 = bufferedImage.getHeight() / n2;
        BufferedImage bufferedImage2 = new BufferedImage(n2 * n3, n2 * n3 * n4, 2);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        try {
            for (int i2 = 0; i2 < n4; ++i2) {
                for (int i3 = 0; i3 < n3; ++i3) {
                    for (int i4 = 0; i4 < n3; ++i4) {
                        graphics2D.drawImage(bufferedImage, i4 * n2, (i2 * n3 + i3) * n2, (i4 + 1) * n2, (i2 * n3 + i3 + 1) * n2, 0, i2 * n2, n2, (i2 + 1) * n2, null);
                    }
                }
            }
        }
        finally {
            graphics2D.dispose();
        }
        return bufferedImage2;
    }

    static JSONObject eR(String string) {
        return new JSONObject().fluentPut("model", (Object)new JSONObject().fluentPut("type", (Object)"minecraft:model").fluentPut("model", (Object)string));
    }

    static JSONObject s(String string, boolean bl) {
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < 10; ++i2) {
            jSONArray.add((Object)new JSONObject().fluentPut("threshold", (Object)(i2 + 1)).fluentPut("model", bl ? ad.p(string, i2).get("model") : ad.o(string, i2).get("model")));
        }
        return new JSONObject().fluentPut("model", (Object)new JSONObject().fluentPut("type", (Object)"minecraft:range_dispatch").fluentPut("property", (Object)"minecraft:custom_model_data").fluentPut("index", (Object)0).fluentPut("entries", (Object)jSONArray).fluentPut("fallback", ad.eR(string).get("model")));
    }

    static JSONObject eS(String string) {
        return ad.l(Map.of("all", string));
    }

    static JSONObject l(Map map) {
        boolean bl = map.containsKey("all");
        JSONObject jSONObject = new JSONObject();
        map.forEach((string, string2) -> jSONObject.put(string, (Object)string2.replace(".png", "")));
        jSONObject.put((Object)"particle", (Object)jSONObject.getString(bl ? "all" : "down"));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put((Object)"down", (Object)ad.a(bl ? "all" : "down", 16.0, 5.333333333333333));
        jSONObject2.put((Object)"up", (Object)ad.a(bl ? "all" : "up", 16.0, 5.333333333333333));
        jSONObject2.put((Object)"north", (Object)ad.a(bl ? "all" : "north", 16.0, 16.0));
        jSONObject2.put((Object)"south", (Object)ad.a(bl ? "all" : "south", 16.0, 16.0));
        jSONObject2.put((Object)"west", (Object)ad.a(bl ? "all" : "west", 5.333333333333333, 16.0));
        jSONObject2.put((Object)"east", (Object)ad.a(bl ? "all" : "east", 5.333333333333333, 16.0));
        JSONArray jSONArray = new JSONArray().fluentAdd((Object)new JSONObject().fluentPut("from", (Object)new JSONArray().fluentAdd((Object)0).fluentAdd((Object)0).fluentAdd((Object)0)).fluentPut("to", (Object)new JSONArray().fluentAdd((Object)16).fluentAdd((Object)16).fluentAdd((Object)16)).fluentPut("faces", (Object)jSONObject2));
        return new JSONObject().fluentPut("parent", (Object)"minecraft:block/block").fluentPut("textures", (Object)jSONObject).fluentPut("elements", (Object)jSONArray);
    }

    private static JSONObject a(String string, double d2, double d3) {
        return new JSONObject().fluentPut("texture", (Object)("#" + string)).fluentPut("uv", (Object)new JSONArray().fluentAdd((Object)0).fluentAdd((Object)0).fluentAdd((Object)d2).fluentAdd((Object)d3));
    }

    static JSONObject o(String string, int n2) {
        return ad.ah(string, ad.aZ(n2));
    }

    static JSONObject p(String string, int n2) {
        return ad.ah(string, ad.bc(n2));
    }

    private static JSONObject ah(String string, String string2) {
        return new JSONObject().fluentPut("model", (Object)new JSONObject().fluentPut("type", (Object)"minecraft:composite").fluentPut("models", (Object)new JSONArray().fluentAdd((Object)new JSONObject().fluentPut("type", (Object)"minecraft:model").fluentPut("model", (Object)string)).fluentAdd((Object)new JSONObject().fluentPut("type", (Object)"minecraft:model").fluentPut("model", (Object)string2))));
    }

    static String aZ(int n2) {
        return "_iainternal:entity_blocks/breaking/stage_" + n2;
    }

    static String ba(int n2) {
        return "assets/_iainternal/models/entity_blocks/breaking/stage_" + n2 + ".json";
    }

    static String bb(int n2) {
        return "ia_overlay_26_1_plus/assets/_iainternal/models/entity_blocks/breaking_translucent/stage_" + n2 + ".json";
    }

    static String bc(int n2) {
        return "_iainternal:entity_blocks/breaking_translucent/stage_" + n2;
    }

    static JSONObject bd(int n2) {
        return ad.c(n2, false);
    }

    static JSONObject be(int n2) {
        return ad.c(n2, true);
    }

    private static JSONObject c(int n2, boolean bl) {
        JSONObject jSONObject = new JSONObject();
        for (String string : new String[]{"down", "up", "north", "south", "west", "east"}) {
            jSONObject.put((Object)string, (Object)new JSONObject().fluentPut("texture", (Object)"#crack").fluentPut("uv", (Object)new JSONArray().fluentAdd((Object)0).fluentAdd((Object)0).fluentAdd((Object)16).fluentAdd((Object)16)));
        }
        JSONObject jSONObject2 = "minecraft:block/destroy_stage_" + n2;
        if (bl) {
            jSONObject2 = new JSONObject().fluentPut("sprite", (Object)jSONObject2).fluentPut("force_translucent", (Object)true);
        }
        return new JSONObject().fluentPut("gui_light", (Object)"side").fluentPut("display", (Object)new JSONObject().fluentPut("fixed", (Object)new JSONObject().fluentPut("rotation", (Object)new JSONArray().fluentAdd((Object)0).fluentAdd((Object)0).fluentAdd((Object)0)).fluentPut("translation", (Object)new JSONArray().fluentAdd((Object)0).fluentAdd((Object)0).fluentAdd((Object)0)).fluentPut("scale", (Object)new JSONArray().fluentAdd((Object)0.5).fluentAdd((Object)0.5).fluentAdd((Object)0.5)))).fluentPut("ambientocclusion", (Object)false).fluentPut("textures", (Object)new JSONObject().fluentPut("crack", (Object)jSONObject2).fluentPut("particle", (Object)"#crack")).fluentPut("elements", (Object)new JSONArray().fluentAdd((Object)new JSONObject().fluentPut("from", (Object)new JSONArray().fluentAdd((Object)-0.01).fluentAdd((Object)-0.01).fluentAdd((Object)-0.01)).fluentPut("to", (Object)new JSONArray().fluentAdd((Object)16.01).fluentAdd((Object)16.01).fluentAdd((Object)16.01)).fluentPut("shade", (Object)false).fluentPut("faces", (Object)jSONObject)));
    }

    public void b(rc rc2) {
        if (rc2 == null) {
            throw new RuntimeException(" wtf, you should call this only if the itemGraphics are set!");
        }
        aza aza2 = new ayz(rc2).AU();
        this.asV.addAll(aza2.AZ());
        aza2.AY().forEach((string, ayp2) -> {
            if (ayp2.AT()) {
                return;
            }
            this.asp.put(ayp2.axf, ayp2.axg);
        });
        if (aza2.AV() != null && !aza2.AV().AT()) {
            this.asp.put(aza2.AV().axf, aza2.AV().axg);
        }
        if (aza2.AX() != null) {
            this.asp.put(rc2.nI(), aza2.AX());
        }
        this.asq.put(rc2.nE(), aza2.AW());
    }

    private static /* synthetic */ void b(Map map, JSONObject jSONObject, Object object) {
        map.putIfAbsent(object, jSONObject.getString("file"));
    }

    private static /* synthetic */ void a(Map map, String string, String string2, JSONObject jSONObject, String string3) {
        map.putIfAbsent(string + string2 + string3, jSONObject);
    }

    private static /* synthetic */ boolean a(String string, String string2, String string3, String string4) {
        return string.equals(string2 + string3 + string4);
    }

    private static /* synthetic */ void a(String string, Map map, Map map2, Map map3, Map map4, Map map5, Version version, String string2, JSONObject jSONObject) {
        int n2;
        String string3 = ad.eH(string2);
        String string4 = string + "/" + string3;
        ag ag2 = new ag((JSONObject)map.get(string3), ad.b((String)map2.get(string3), map3));
        ag ag3 = (ag)map4.get(string3);
        if (ag3 != null && ag3.ze() > ag2.ze()) {
            ag2 = ag3;
        }
        if ((n2 = ad.b(string4, map3)) > ag2.ze() && !Objects.equals(jSONObject, ag2.zd())) {
            ad.a(map5, string4, jSONObject, version);
            map4.put(string3, new ag(jSONObject, n2));
        } else {
            map4.put(string3, ag2);
        }
    }

    private /* synthetic */ void a(Map map, JSONObject jSONObject, Map map2, Version version, Map map3, Map map4, String string, JSONObject jSONObject2) {
        String string2 = (String)map.get(string);
        if (string2 != null && ad.f(jSONObject, string2)) {
            JSONObject jSONObject3 = this.p(jSONObject2);
            ad.a(map2, string2, jSONObject3, version);
            map3.put(string, new ag(jSONObject3, ad.b(string2, map4)));
        }
    }

    private /* synthetic */ void a(Set set, String string, Map map, Version version, Map map2, Set set2, String string2, JSONObject jSONObject) {
        JSONObject jSONObject2 = ad.h(jSONObject);
        JSONObject jSONObject3 = jSONObject2 == null ? jSONObject : jSONObject2;
        String string3 = set.contains(string2) ? string2 : string + "/" + ad.eH(string2);
        ad.a(map, string3, jSONObject3, version);
        map2.put(string3, (Boolean)this.asF.get(string2));
        if (jSONObject2 != null && set2.add(string3)) {
            bk.k("Minecraft 26.1+ UV compatibility", "Model: " + string2 + "\nClamped UV coordinates outside 0..16 in the shared model asset.");
        }
    }

    private static /* synthetic */ void a(Map map, Version version) {
        map.computeIfAbsent(zw.k(version), n2 -> new ArrayList()).add(version);
    }

    private static /* synthetic */ boolean j(Set set, String string) {
        return itemsadder.m.an.a(string) || set.contains(o.el(string));
    }
}
