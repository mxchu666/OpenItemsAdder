package dev.lone.itemsadder.resourcepack;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.ItemsAdderPackCompressedEvent;
import dev.lone.itemsadder.api.Events.ItemsAdderPackCompressedEvent$PackEntry;
import dev.lone.itemsadder.resourcepack.ad;
import dev.lone.itemsadder.resourcepack.be;
import dev.lone.itemsadder.resourcepack.bi;
import dev.lone.itemsadder.resourcepack.bj;
import dev.lone.itemsadder.resourcepack.bk;
import dev.lone.itemsadder.resourcepack.bl;
import dev.lone.itemsadder.resourcepack.bm;
import dev.lone.itemsadder.resourcepack.ch;
import dev.lone.itemsadder.resourcepack.generator.file.data.g;
import dev.lone.itemsadder.resourcepack.s;
import dev.lone.itemsadder.resourcepack.t;
import dev.lone.itemsadder.resourcepack.u;
import dev.lone.itemsadder.resourcepack.v;
import dev.lone.itemsadder.resourcepack.w;
import dev.lone.itemsadder.resourcepack.x;
import dev.lone.itemsadder.resourcepack.z;
import dev.lone.itemsadder.utils.json.b;
import dev.lone.itemsadder.utils.json.c;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import itemsadder.m.BossBarBridge_2;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Runner;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.runtime.SwitchBootstraps;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.Nullable;

public class r {
    public static final boolean ary = false;
    protected final String arz;
    public Set arA;
    public List arB;
    public Object2ObjectOpenHashMap arC;
    public Multimap arD;
    public Multimap arE;
    private final Map arF = new HashMap();
    private final Map arG = new LinkedHashMap();
    private final Map arH = new HashMap();
    private final Set arI = new HashSet();
    private final Set arJ = Collections.newSetFromMap(new IdentityHashMap());
    private final Map arK = new IdentityHashMap();

    public r(String string, Set set) {
        set.add("iaentitymodel");
        set.add("bbmodel");
        set.add("metadata");
        set.add("uuid");
        set.add("vscode");
        set.add("yml");
        set.add("player_animations");
        set.add("player_advanced_animations");
        set.add("jspp");
        set.add("js");
        set.add("java");
        set.add("kts");
        this.arA = set;
        this.arz = string;
        this.arC = new Object2ObjectOpenHashMap();
        this.arD = ArrayListMultimap.create();
        this.arE = ArrayListMultimap.create();
    }

    public void eo(String string) {
        if (this.arB == null) {
            this.arB = new ArrayList();
        }
        this.arB.add(ColorBridge.iR(string));
    }

    public boolean a(File file, String string, boolean bl) {
        return this.a(file, string, bl, false);
    }

    public boolean a(File file, String string, boolean bl2, boolean bl3) {
        boolean bl4;
        Object object;
        String string2;
        Object object2;
        JSONObject jSONObject = null;
        if (file.getName().startsWith(".")) {
            return false;
        }
        if (file.getName().endsWith(".json") && ColorBridge.iR(file.getAbsolutePath()).contains("minecraft/blockstates/")) {
            try {
                jSONObject = c.N(file);
                object2 = b.M(jSONObject);
                ItemStackRegistry.g().as.auh.asu.addAll(object2);
                CommandSenderBridge_5.iA("Found " + object2.size() + " models using block textures in blockstates JSON: " + ColorBridge.I(file));
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }
        if (this.arC.containsKey((Object)file)) {
            return false;
        }
        string = ColorBridge.iR(string);
        if (bl2 && this.eq(string)) {
            CommandSenderBridge_5.warn("Duplicate found. Already added as stream. " + ColorBridge.I(file) + " -> " + ColorBridge.iO(string));
            return false;
        }
        object2 = (File)this.arF.get(string);
        if (object2 != null) {
            if (!bl3) {
                CommandSenderBridge_5.warn("Duplicate found. " + ColorBridge.I(file) + " -> " + ColorBridge.iO(string));
                CommandSenderBridge_5.warn("Previous file: " + ColorBridge.I((File)object2));
                return false;
            }
            this.arC.remove(object2);
            this.arF.remove(string);
        }
        if (this.ev(string) || this.arA.contains(FilenameUtils.getExtension((String)string))) {
            return false;
        }
        if (bl.d(file, string)) {
            return false;
        }
        if (MaterialBarColorHolder.dq && string.matches("assets/[^/]+/items/.*\\.json")) {
            try {
                string2 = c.N(file);
                object = "ia_overlay_modern_atlas/" + string;
                bl4 = this.a((String)object, false, arg_0 -> r.a((String)object, arg_0));
                if (bl4) {
                    this.arH.put(object, file);
                    ItemStackRegistry.g().as.auh.g(string, (JSONObject)string2);
                }
            }
            catch (IOException iOException) {
                CommandSenderBridge_5.error("Failed to prepare modern item definition: " + ColorBridge.I(file), iOException);
            }
        }
        if (string.matches("assets/[^/]+/models/.*\\.json")) {
            object = string;
            string2 = g.gl(string);
            bl4 = this.a((String)object, false, arg_0 -> r.a((String)object, file, string2, arg_0));
            if (bl4) {
                this.arH.put(object, file);
            }
            if (MaterialBarColorHolder.dq && bl4) {
                this.arI.add(object);
                try {
                    ad ad2 = ItemStackRegistry.g().as.auh;
                    if (!ad2.a((String)object, file)) {
                        ad2.d((String)object, c.N(file));
                    }
                }
                catch (IOException iOException) {
                    throw new IllegalStateException("Failed to plan model before compression: '" + (String)object + "'", iOException);
                }
            }
            return true;
        }
        this.arC.put((Object)file, (Object)string);
        this.arF.put(string, file);
        if (jSONObject != null) {
            ItemStackRegistry.g().as.auh.h(string, jSONObject);
        }
        return true;
    }

    public void P(String string, String string2) {
        this.d(string, string2, false);
    }

    public void d(String string, String string2, boolean bl2) {
        if (!bl2 && this.arD.containsEntry(string, string2)) {
            return;
        }
        this.arD.put(string, string2);
    }

    public void Q(String string, String string2) {
        this.a(new ByteArrayInputStream(string.getBytes(StandardCharsets.UTF_8)), string2, false);
    }

    public void a(JSONObject jSONObject, String string, boolean bl2) {
        Objects.requireNonNull(jSONObject, "json");
        if (!MaterialBarColorHolder.dq) {
            ItemStackRegistry.g().as.auh.f(g.gl(string), jSONObject);
        }
        boolean bl3 = this.a(string, bl2, (OutputStream outputStream) -> {
            JSONObject jSONObject2 = MaterialBarColorHolder.dq ? ItemStackRegistry.g().as.auh.eI(string) : jSONObject;
            JSON.writeTo((OutputStream)outputStream, (Object)jSONObject2, (JSONWriter.Feature[])new JSONWriter.Feature[]{JSONWriter.Feature.LargeObject});
        });
        if (MaterialBarColorHolder.dq && bl3) {
            this.arI.add(ColorBridge.iR(string));
            ItemStackRegistry.g().as.auh.d(string, jSONObject);
        }
    }

    public void b(JSONObject jSONObject, String string, boolean bl2) {
        Objects.requireNonNull(jSONObject, "json");
        this.a(string, bl2, (OutputStream outputStream) -> JSON.writeTo((OutputStream)outputStream, (Object)jSONObject, (JSONWriter.Feature[])new JSONWriter.Feature[]{JSONWriter.Feature.LargeObject}));
    }

    private boolean a(String string, boolean bl2, u u2) {
        Objects.requireNonNull(string, "destination");
        Objects.requireNonNull(u2, "writer");
        if (!bl2 && this.eq(string)) {
            return false;
        }
        this.arH.remove(string);
        this.arG.put(string, u2);
        return true;
    }

    boolean ep(String string) {
        String string2;
        block3: {
            block2: {
                string2 = ColorBridge.iR(string);
                if (!this.arI.contains(string2) || this.arE.containsKey(string2)) break block2;
                if (this.arD.values().stream().map(ColorBridge::iR).anyMatch(string2::equals)) break block2;
                if (!this.arC.values().stream().map(ColorBridge::iR).anyMatch(string2::equals)) break block3;
            }
            return false;
        }
        return this.arG.containsKey(string2);
    }

    Set yi() {
        HashSet<String> hashSet = new HashSet<String>(this.arI);
        hashSet.removeIf(string -> !this.arG.containsKey(string));
        hashSet.removeAll(this.arE.keySet());
        this.arD.values().forEach(string -> hashSet.remove(ColorBridge.iR(string)));
        this.arC.values().forEach(string -> hashSet.remove(ColorBridge.iR(string)));
        return hashSet;
    }

    Set yj() {
        HashSet hashSet = new HashSet();
        this.arE.keySet().stream().map(ColorBridge::iR).forEach(hashSet::add);
        this.arG.keySet().stream().map(ColorBridge::iR).forEach(hashSet::add);
        this.arD.values().stream().map(ColorBridge::iR).forEach(hashSet::add);
        this.arC.values().stream().map(ColorBridge::iR).forEach(hashSet::add);
        return hashSet;
    }

    public void a(InputStream inputStream, String string) {
        this.a(inputStream, string, false);
    }

    public void a(InputStream inputStream, String string, boolean bl2) {
        if (!bl2 && this.eq(string)) {
            return;
        }
        this.arE.put(string, inputStream);
    }

    void a(byte[] byArray, String string) {
        boolean bl2 = this.eq(string);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        this.a(byteArrayInputStream, string, false);
        if (!bl2 && r.es(ColorBridge.iR(string))) {
            this.arJ.add(byteArrayInputStream);
        }
    }

    public void a(byte[] byArray, String string, boolean bl2) {
        this.a(new ByteArrayInputStream(byArray), string, bl2);
    }

    public void b(JSONObject jSONObject, String string) {
        ad.b(g.gl(string), jSONObject);
        this.e(jSONObject, string);
    }

    public void c(JSONObject jSONObject, String string) {
        this.e(c.J(jSONObject), string, false);
    }

    public void d(JSONObject jSONObject, String string) {
        this.b(jSONObject, string, false);
    }

    public void e(JSONObject jSONObject, String string) {
        this.a(jSONObject, string, false);
    }

    public void e(String string, String string2, boolean bl2) {
        this.a(string.getBytes(StandardCharsets.UTF_8), string2, bl2);
    }

    public void a(ByteArrayOutputStream byteArrayOutputStream, String string) {
        this.a(byteArrayOutputStream, string, false);
    }

    public void a(ByteArrayOutputStream byteArrayOutputStream, String string, boolean bl2) {
        if (!bl2 && this.eq(string)) {
            return;
        }
        this.a(byteArrayOutputStream.toByteArray(), string, bl2);
    }

    private boolean eq(String string) {
        return this.arE.containsKey(string) || this.arG.containsKey(string);
    }

    LinkedHashMap yk() {
        Object object;
        Object object2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.arK.clear();
        v v2 = v.yq();
        for (Map.Entry entry : this.arC.entrySet()) {
            object2 = (File)entry.getKey();
            object = ColorBridge.iR((String)entry.getValue());
            this.a(linkedHashMap, ItemsAdderPackCompressedEvent$PackEntry.stream((String)object, () -> r.p((File)object2)), r.es((String)object) ? r.a((File)object2, v2) : t.UNKNOWN, (File)object2);
        }
        for (Map.Entry entry : this.arD.entries()) {
            object2 = (String)entry.getKey();
            object = ColorBridge.iR((String)entry.getValue());
            this.a(linkedHashMap, ItemsAdderPackCompressedEvent$PackEntry.stream((String)object, () -> this.eC((String)object2)), t.BUNDLED);
        }
        for (Map.Entry entry : this.arE.entries()) {
            object2 = ColorBridge.iR((String)entry.getKey());
            this.a(linkedHashMap, r.a((String)object2, (InputStream)entry.getValue()), this.arJ.contains(entry.getValue()) ? t.GENERATED : t.STREAM);
        }
        for (Map.Entry entry : this.arG.entrySet()) {
            object2 = ColorBridge.iR((String)entry.getKey());
            object = (u)entry.getValue();
            File file = (File)this.arH.get(entry.getKey());
            this.a(linkedHashMap, ItemsAdderPackCompressedEvent$PackEntry.writer((String)object2, ((u)object)::writeTo), file == null ? t.WRITER : r.a(file, v2), file);
        }
        return linkedHashMap;
    }

    private static ItemsAdderPackCompressedEvent$PackEntry a(String string, InputStream inputStream) {
        byte[][] byArrayArray = new byte[1][];
        return ItemsAdderPackCompressedEvent$PackEntry.stream(string, () -> {
            if (byArrayArray[0] == null) {
                try (InputStream inputStream2 = inputStream;){
                    byArray[0] = inputStream2.readAllBytes();
                }
            }
            return new ByteArrayInputStream(byArrayArray[0]);
        });
    }

    private static void a(Map map, ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry) {
        map.putIfAbsent(ColorBridge.iR(itemsAdderPackCompressedEvent$PackEntry.getPath()), itemsAdderPackCompressedEvent$PackEntry);
    }

    private void a(Map map, ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry, t t2) {
        this.a(map, itemsAdderPackCompressedEvent$PackEntry, t2, null);
    }

    private void a(Map map, ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry, t t2, @Nullable File file) {
        String string = ColorBridge.iR(itemsAdderPackCompressedEvent$PackEntry.getPath());
        map.putIfAbsent(string, itemsAdderPackCompressedEvent$PackEntry);
        if (map.get(string) == itemsAdderPackCompressedEvent$PackEntry && (r.es(string) || file != null && bm.fK(string))) {
            this.arK.put(itemsAdderPackCompressedEvent$PackEntry, new z(string, t2, file));
        }
    }

    List a(LinkedHashMap linkedHashMap) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        linkedHashMap.forEach((string, itemsAdderPackCompressedEvent$PackEntry) -> {
            String string2 = ColorBridge.iR(itemsAdderPackCompressedEvent$PackEntry.getPath());
            w w2 = new w((String)string, (ItemsAdderPackCompressedEvent$PackEntry)itemsAdderPackCompressedEvent$PackEntry);
            if (itemsAdderPackCompressedEvent$PackEntry.isRemoved()) {
                hashMap2.putIfAbsent(string2, w2);
                return;
            }
            w w3 = hashMap.putIfAbsent(string2, w2);
            if (w3 != null) {
                arrayList.add("Normalized pack path collision: selected " + this.a(w3, string2) + ", discarded " + this.a(w2, string2) + ", ZIP path '" + r.er(string2) + "'");
            }
        });
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap.forEach((string, itemsAdderPackCompressedEvent$PackEntry) -> {
            String string2 = ColorBridge.iR(itemsAdderPackCompressedEvent$PackEntry.getPath());
            w w2 = hashMap.getOrDefault(string2, (w)hashMap2.get(string2));
            if (w2 != null && w2.yt().equals(string) && w2.yu() == itemsAdderPackCompressedEvent$PackEntry) {
                linkedHashMap2.putIfAbsent(string2, itemsAdderPackCompressedEvent$PackEntry);
            }
        });
        linkedHashMap.clear();
        linkedHashMap.putAll(linkedHashMap2);
        return List.copyOf(arrayList);
    }

    private String a(w w2, String string) {
        ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry = w2.yu();
        t t2 = this.a(itemsAdderPackCompressedEvent$PackEntry, string);
        return "{map key='" + r.er(w2.yt()) + "', entry path='" + r.er(itemsAdderPackCompressedEvent$PackEntry.getPath()) + "'" + (String)(t2 == null ? "" : ", origin=" + String.valueOf((Object)t2)) + "}";
    }

    private static String er(String string) {
        return string.length() <= 256 ? string : string.substring(0, 253) + "...";
    }

    t a(ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry, String string) {
        z z2 = (z)this.arK.get(itemsAdderPackCompressedEvent$PackEntry);
        return z2 != null && z2.pK().equals(ColorBridge.iR(string)) ? z2.yw() : null;
    }

    @Nullable
    String b(ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry, String string) {
        File file = this.c(itemsAdderPackCompressedEvent$PackEntry, string);
        return file == null ? null : ColorBridge.I(file);
    }

    @Nullable
    File c(ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry, String string) {
        z z2 = (z)this.arK.get(itemsAdderPackCompressedEvent$PackEntry);
        if (z2 == null || !z2.pK().equals(ColorBridge.iR(string))) {
            return null;
        }
        return z2.yx();
    }

    private static boolean es(String string) {
        return ad.eG(string);
    }

    private static t a(File file, v v2) {
        try {
            Path path = r.d(file.toPath());
            if (v2.yr().stream().anyMatch(path::startsWith)) {
                return t.USER_CONTENT;
            }
            if (v2.ys().stream().anyMatch(path::startsWith)) {
                return t.EXTERNAL_PACK;
            }
            return t.UNKNOWN;
        }
        catch (RuntimeException runtimeException) {
            return t.UNKNOWN;
        }
    }

    private static Path d(Path path) {
        try {
            return path.toRealPath(new LinkOption[0]);
        }
        catch (IOException iOException) {
            return path.toAbsolutePath().normalize();
        }
    }

    static void a(Map map, x x2) {
        if (!MaterialBarColorHolder.cD) {
            return;
        }
        HashSet<String> hashSet = new HashSet<String>();
        for (ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry : map.values()) {
            String string = ColorBridge.iR(itemsAdderPackCompressedEvent$PackEntry.getPath());
            if (itemsAdderPackCompressedEvent$PackEntry.isRemoved() || !string.toLowerCase(Locale.ROOT).endsWith(".png") || !hashSet.add(string)) continue;
            try {
                InputStream inputStream = itemsAdderPackCompressedEvent$PackEntry.openStream();
                try {
                    byte[] byArray = r.b(inputStream);
                    if (byArray == null) {
                        x2.a(string, bj.UNSUPPORTED_FORMAT, "PNG exceeds size limit");
                        continue;
                    }
                    bi bi2 = be.g(byArray);
                    x2.a(string, bi2.yv(), bi2.xQ());
                    if (bi2.yv() != bj.APPLIED) continue;
                    itemsAdderPackCompressedEvent$PackEntry.setBytes(bi2.zT());
                }
                finally {
                    if (inputStream == null) continue;
                    inputStream.close();
                }
            }
            catch (Exception exception) {
                x2.a(string, bj.READ_ERROR, "read error");
            }
        }
    }

    static int f(Map map) {
        int n2 = 0;
        for (ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry : map.values()) {
            String string;
            String string2 = ColorBridge.iR(itemsAdderPackCompressedEvent$PackEntry.getPath());
            if (itemsAdderPackCompressedEvent$PackEntry.isRemoved() || !string2.toLowerCase(Locale.ROOT).endsWith(".png")) continue;
            try (InputStream inputStream = itemsAdderPackCompressedEvent$PackEntry.openStream();){
                string = be.d(inputStream.readNBytes(24));
            }
            catch (IOException iOException) {
                string = "cannot read PNG header";
            }
            if (string == null) continue;
            itemsAdderPackCompressedEvent$PackEntry.remove();
            ++n2;
            bk.k("Invalid PNG files", "File: " + r.et(string2) + "\nReason: " + string + "\nThe file was excluded and referenced models use the ItemsAdder missing texture.");
        }
        return n2;
    }

    static List a(Map map, Collection collection) {
        return r.b(map, collection, List.of());
    }

    static List b(Map map, Collection collection, Collection collection2) {
        Object object;
        HashSet<String> hashSet = new HashSet<String>(collection);
        hashSet.addAll(collection2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        map.values().stream().filter(itemsAdderPackCompressedEvent$PackEntry -> !itemsAdderPackCompressedEvent$PackEntry.isRemoved() && ColorBridge.iR(itemsAdderPackCompressedEvent$PackEntry.getPath()).endsWith("assets/minecraft/atlases/blocks.json")).forEach(itemsAdderPackCompressedEvent$PackEntry -> r.a(itemsAdderPackCompressedEvent$PackEntry, hashSet, arrayList, arrayList2));
        if (!arrayList.isEmpty()) {
            for (Object object2 : map.values()) {
                String string;
                if (((ItemsAdderPackCompressedEvent$PackEntry)object2).isRemoved() || (string = r.eu(ColorBridge.iR(((ItemsAdderPackCompressedEvent$PackEntry)object2).getPath()))) == null || arrayList2.stream().anyMatch(s2 -> s2.eE(string))) continue;
                object = string.substring(string.indexOf(58) + 1);
                if (!arrayList.stream().anyMatch(((String)object)::startsWith)) continue;
                hashSet.add(string);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (String string : new TreeSet(hashSet)) {
            int n2;
            object = string.contains(":") ? string : "minecraft:" + string;
            String string2 = "assets/" + ((String)object).substring(0, n2 = ((String)object).indexOf(58)) + "/textures/" + ((String)object).substring(n2 + 1) + ".png";
            ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry2 = (ItemsAdderPackCompressedEvent$PackEntry)map.get(string2);
            if (itemsAdderPackCompressedEvent$PackEntry2 == null || itemsAdderPackCompressedEvent$PackEntry2.isRemoved()) continue;
            try {
                InputStream inputStream = itemsAdderPackCompressedEvent$PackEntry2.openStream();
                try {
                    byte[] byArray = inputStream.readNBytes(24);
                    if (be.d(byArray) != null) continue;
                    long l = be.e(byArray);
                    long l2 = be.f(byArray);
                    if (l % 16L == 0L && l2 % 16L == 0L) continue;
                    long l3 = (l + 15L) / 16L * 16L;
                    long l4 = (l2 + 15L) / 16L * 16L;
                    int n3 = Math.min(Long.numberOfTrailingZeros(l), Long.numberOfTrailingZeros(l2));
                    arrayList3.add((String)object + " (" + r.et(string2) + "): " + l + "x" + l2 + " -> recommended canvas " + l3 + "x" + l4 + "; limits mip level to " + n3);
                }
                finally {
                    if (inputStream == null) continue;
                    inputStream.close();
                }
            }
            catch (IOException iOException) {}
        }
        return arrayList3;
    }

    private static String et(String string) {
        String string2 = ColorBridge.iR(string);
        if (Main.rS() == null) {
            return string2;
        }
        try {
            File file = string2.startsWith("assets/") ? ItemStackRegistry.s(string2) : ItemStackRegistry.r(string2);
            return file == null ? string2 : ColorBridge.I(file);
        }
        catch (RuntimeException runtimeException) {
            return string2;
        }
    }

    private static void a(ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry, Set set, List list, List list2) {
        try {
            JSONObject jSONObject = c.jh(itemsAdderPackCompressedEvent$PackEntry.getText());
            Object object = jSONObject.get("sources");
            if (!(object instanceof JSONArray)) {
                return;
            }
            JSONArray jSONArray = (JSONArray)object;
            for (Object e : jSONArray) {
                Object object2;
                if (!(e instanceof JSONObject)) continue;
                JSONObject jSONObject2 = (JSONObject)e;
                String string = jSONObject2.getString("type");
                if (string != null) {
                    string = string.substring(string.indexOf(58) + 1);
                }
                if ("single".equals(string) || "unstitch".equals(string)) {
                    object2 = jSONObject2.getString("resource");
                    if (object2 == null) continue;
                    set.add(object2);
                    continue;
                }
                if ("directory".equals(string)) {
                    object2 = jSONObject2.getString("source");
                    if (object2 == null) continue;
                    list.add((String)object2 + "/");
                    continue;
                }
                if (!"filter".equals(string) || !((object2 = jSONObject2.get("pattern")) instanceof JSONObject)) continue;
                JSONObject jSONObject3 = (JSONObject)object2;
                list2.add(new s(Pattern.compile(StringUtils.defaultString((String)jSONObject3.getString("namespace"), (String)".*")), Pattern.compile(StringUtils.defaultString((String)jSONObject3.getString("path"), (String)".*"))));
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Nullable
    private static String eu(String string) {
        if (!string.startsWith("assets/") || !string.endsWith(".png")) {
            return null;
        }
        int n2 = string.indexOf(47, "assets/".length());
        if (n2 < 0 || !string.startsWith("textures/", n2 + 1)) {
            return null;
        }
        return string.substring("assets/".length(), n2) + ":" + string.substring(n2 + "/textures/".length(), string.length() - ".png".length());
    }

    private static void c(Map map, Collection collection, Collection collection2) {
        List list = r.b(map, collection, collection2);
        if (list.isEmpty()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("[Pack] ").append(list.size()).append(" PNG texture").append(list.size() == 1 ? "" : "s").append(" included in the block atlas limit mipmap quality. ").append("Textures do not need power-of-two dimensions: for mip level 4, both width and height must be divisible by 2^4 = 16. ").append("ItemsAdder does not resize user textures; update or re-export these PNGs:");
        list.forEach(string -> stringBuilder.append("\n  - ").append((String)string));
        CommandSenderBridge_5.warn(stringBuilder.toString());
    }

    private static byte[] b(InputStream inputStream) {
        int n2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        byte[] byArray = new byte[8192];
        while ((n2 = inputStream.read(byArray)) >= 0) {
            if (n2 == 0) {
                int n3 = inputStream.read();
                if (n3 < 0) break;
                if (byteArrayOutputStream.size() == 0x8000000) {
                    return null;
                }
                byteArrayOutputStream.write(n3);
                continue;
            }
            if (byteArrayOutputStream.size() > 0x8000000 - n2) {
                return null;
            }
            byteArrayOutputStream.write(byArray, 0, n2);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void a(ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry, ZipOutputStream zipOutputStream, byte[] byArray, x x2) {
        String string = ColorBridge.iR(itemsAdderPackCompressedEvent$PackEntry.getPath());
        ZipEntry zipEntry = new ZipEntry(string);
        try {
            zipOutputStream.putNextEntry(zipEntry);
            try (InputStream inputStream = itemsAdderPackCompressedEvent$PackEntry.openStream();){
                int n2;
                while ((n2 = inputStream.read(byArray)) >= 0) {
                    zipOutputStream.write(byArray, 0, n2);
                }
            }
        }
        catch (ZipException zipException) {
            x2.T(string, zipException.getMessage());
            CommandSenderBridge_5.warn("File compression skipped. Duplicate found: '" + string + "' | " + zipException.getMessage());
        }
        catch (Throwable throwable) {
            x2.T(string, throwable.getMessage());
            CommandSenderBridge_5.warn("File compression skipped '" + string + "'");
            CommandSenderBridge_5.error("Uncaught error", throwable);
        }
        finally {
            zipOutputStream.closeEntry();
            if (MaterialBarColorHolder.cB) {
                ch.a(zipEntry);
            }
        }
    }

    private void a(ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry, ZipOutputStream zipOutputStream, byte[] byArray) {
        this.a(itemsAdderPackCompressedEvent$PackEntry, zipOutputStream, byArray, new x());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive exception aggregation
     */
    public boolean a(@Nullable Runner runner) {
        Object object;
        try {
            object = ColorBridge.iQ(this.arz);
            Files.deleteIfExists((Path)object);
            Files.createDirectories(object.getParent(), new FileAttribute[0]);
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Failed to delete file or create folders for 'generated.zip'", throwable);
            return false;
        }
        BossBarBridge_2.bf("Collecting pack files...");
        object = this.yk();
        BossBarBridge_2.bf("Calling pack finalization event...");
        ListenerBridge.b(new ItemsAdderPackCompressedEvent((Map)object));
        BossBarBridge_2.bf("Validating final pack entries...");
        LinkedHashMap linkedHashMap = new LinkedHashMap(object);
        this.a(linkedHashMap).forEach(CommandSenderBridge_5::warn);
        int n2 = r.f(linkedHashMap);
        if (n2 > 0) {
            CommandSenderBridge_5.warn("[Pack] Excluded " + n2 + " invalid PNG file" + (n2 == 1 ? "" : "s") + ". Referenced models use the ItemsAdder missing texture. Details: ItemsAdder/output/resource-pack-diagnostics.txt");
        }
        if (MaterialBarColorHolder.dq) {
            BossBarBridge_2.bf("Finalizing modern atlas entries...");
            long l = System.nanoTime();
            ad ad2 = ItemStackRegistry.g().as.auh;
            try {
                ad2.i(linkedHashMap);
                r.c(linkedHashMap, ad.asZ.aqp.keySet(), ad.asZ.aqo.keySet());
            }
            finally {
                CommandSenderBridge_5.iA("[Pack] Modern atlas entries finalized in " + (System.nanoTime() - l) / 1000000L + "ms");
                ad2.yQ();
            }
        }
        bl.m(linkedHashMap);
        if (MaterialBarColorHolder.dk) {
            BossBarBridge_2.bf("Validating pack shaders...");
            bm.a(linkedHashMap, this::b);
        }
        x x2 = new x();
        BossBarBridge_2.bf("Processing pack images...");
        r.a(linkedHashMap, x2);
        try {
            int n3;
            int n4 = r.h(linkedHashMap);
            if (n4 > 0) {
                CommandSenderBridge_5.iA("[Pack] Removed " + n4 + " empty overlay declarations.");
            }
            if ((n3 = r.g(linkedHashMap)) > 0) {
                CommandSenderBridge_5.iA("[Pack] Flattened " + n3 + " resources into the 26.2+ overlay.");
            }
        }
        catch (IOException | RuntimeException exception) {
            CommandSenderBridge_5.iB("[Pack] Failed to remove empty overlay declarations: " + exception.getMessage());
        }
        double d = 0.0;
        double d2 = linkedHashMap.values().stream().filter(itemsAdderPackCompressedEvent$PackEntry -> !itemsAdderPackCompressedEvent$PackEntry.isRemoved()).count();
        if (MaterialBarColorHolder.cC) {
            d2 *= 2.0;
        }
        byte[] byArray = new byte[8192];
        BossBarBridge_2.bf("Writing pack archive...");
        try (FileOutputStream fileOutputStream = new FileOutputStream(this.arz);){
            boolean bl2;
            try (ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);){
                zipOutputStream.setLevel(9);
                zipOutputStream.setMethod(8);
                for (ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry2 : linkedHashMap.values()) {
                    if (itemsAdderPackCompressedEvent$PackEntry2.isRemoved()) continue;
                    d += 1.0;
                    if (runner != null) {
                        runner.run(Math.min(d2 == 0.0 ? 1.0 : d / d2, 1.0));
                    }
                    this.a(itemsAdderPackCompressedEvent$PackEntry2, zipOutputStream, byArray, x2);
                }
                zipOutputStream.finish();
                zipOutputStream.flush();
                zipOutputStream.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                try {
                    if (MaterialBarColorHolder.cC) {
                        BossBarBridge_2.bf("Protecting pack archive...");
                        ch.A(new File(this.arz));
                    }
                }
                catch (Throwable throwable) {
                    CommandSenderBridge_5.error("Error protecting resourcepack", throwable);
                }
                if (runner != null) {
                    runner.run(1.0);
                }
                x2.L();
                bl2 = true;
            }
            return bl2;
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Error compressing the zip file", throwable);
            x2.L();
            if (runner != null) {
                runner.run(1.0);
            }
            return false;
        }
    }

    static int g(Map map) {
        JSONArray jSONArray;
        ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry2 = (ItemsAdderPackCompressedEvent$PackEntry)map.get("pack.mcmeta");
        if (itemsAdderPackCompressedEvent$PackEntry2 == null || itemsAdderPackCompressedEvent$PackEntry2.isRemoved()) {
            return 0;
        }
        JSONObject jSONObject3 = JSON.parseObject((String)itemsAdderPackCompressedEvent$PackEntry2.getText());
        JSONObject jSONObject4 = jSONObject3.getJSONObject("overlays");
        JSONArray jSONArray2 = jSONArray = jSONObject4 == null ? null : jSONObject4.getJSONArray("entries");
        if (jSONArray == null) {
            return 0;
        }
        int n2 = 88;
        JSONObject jSONObject5 = jSONArray.stream().filter(JSONObject.class::isInstance).map(JSONObject.class::cast).filter(jSONObject -> "ia_overlay_26_2_plus".equals(jSONObject.getString("directory"))).findFirst().orElse(null);
        if (jSONObject5 == null) {
            return 0;
        }
        int[] nArray = ad.j(jSONObject5);
        if (jSONArray.stream().filter(JSONObject.class::isInstance).map(JSONObject.class::cast).filter(jSONObject2 -> jSONObject2 != jSONObject5).map(ad::j).anyMatch(nArray2 -> nArray2[1] >= nArray[0] && (nArray2[0] > nArray[0] || nArray2[1] != nArray[1]))) {
            return 0;
        }
        List<JSONObject> list = jSONArray.stream().filter(JSONObject.class::isInstance).map(JSONObject.class::cast).filter(jSONObject -> {
            int[] nArray = ad.j(jSONObject);
            return n2 >= nArray[0] && n2 <= nArray[1];
        }).toList();
        if (list.size() < 2 || list.stream().anyMatch(jSONObject -> !jSONObject.containsKey("max_format"))) {
            return 0;
        }
        List<Map.Entry> list2 = map.entrySet().stream().filter(entry -> !((ItemsAdderPackCompressedEvent$PackEntry)entry.getValue()).isRemoved()).toList();
        LinkedHashMap<String, ItemsAdderPackCompressedEvent$PackEntry> linkedHashMap = new LinkedHashMap<String, ItemsAdderPackCompressedEvent$PackEntry>();
        HashSet<String> hashSet = new HashSet<String>();
        for (JSONObject jSONObject6 : list) {
            String string = r.c(jSONObject6);
            String string3 = string + "/";
            list2.stream().filter(entry -> ((String)entry.getKey()).startsWith(string3)).forEach(entry -> linkedHashMap.put(((String)entry.getKey()).substring(string3.length()), (ItemsAdderPackCompressedEvent$PackEntry)entry.getValue()));
            if (jSONObject6 == jSONObject5) continue;
            if (ad.j(jSONObject6)[0] >= n2) {
                hashSet.add(string);
                continue;
            }
            r.a(jSONObject6, n2 - 1);
        }
        String string = r.c(jSONObject5);
        jSONArray.removeIf(object -> {
            JSONObject jSONObject;
            return object instanceof JSONObject && hashSet.contains(r.c(jSONObject = (JSONObject)object));
        });
        map.entrySet().removeIf(entry -> hashSet.stream().anyMatch(string -> ((String)entry.getKey()).startsWith(string + "/")));
        linkedHashMap.forEach((string2, itemsAdderPackCompressedEvent$PackEntry) -> {
            String string3 = string + "/" + string2;
            if (!string3.equals(ColorBridge.iR(itemsAdderPackCompressedEvent$PackEntry.getPath()))) {
                map.put(string3, ItemsAdderPackCompressedEvent$PackEntry.stream(string3, itemsAdderPackCompressedEvent$PackEntry::openStream));
            }
        });
        itemsAdderPackCompressedEvent$PackEntry2.setBytes(JSON.toJSONBytes((Object)jSONObject3, (JSONWriter.Feature[])new JSONWriter.Feature[]{JSONWriter.Feature.LargeObject}));
        return linkedHashMap.size();
    }

    private static void a(JSONObject jSONObject, int n2) {
        int n3 = ad.v(jSONObject.get("max_format"));
        jSONObject.put((Object)"max_format", (Object)n2);
        Object object = jSONObject.get("formats");
        Objects.requireNonNull(object);
        Object object2 = object;
        int n4 = 0;
        block4: while (true) {
            switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{JSONArray.class, JSONObject.class}, (Object)object2, n4)) {
                case 0: {
                    JSONArray jSONArray = (JSONArray)object2;
                    if (jSONArray.size() != 2 || jSONArray.getIntValue(1) != n3) {
                        n4 = 1;
                        continue block4;
                    }
                    jSONArray.set(1, (Object)n2);
                    break block4;
                }
                case 1: {
                    JSONObject jSONObject2 = (JSONObject)object2;
                    if (jSONObject2.getIntValue("max_inclusive") != n3) {
                        n4 = 2;
                        continue block4;
                    }
                    jSONObject2.put((Object)"max_inclusive", (Object)n2);
                    break block4;
                }
            }
            break;
        }
    }

    private static String c(JSONObject jSONObject) {
        return ad.c(jSONObject);
    }

    static int h(Map map) {
        JSONArray jSONArray;
        ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry = (ItemsAdderPackCompressedEvent$PackEntry)map.get("pack.mcmeta");
        if (itemsAdderPackCompressedEvent$PackEntry == null || itemsAdderPackCompressedEvent$PackEntry.isRemoved()) {
            return 0;
        }
        JSONObject jSONObject = JSON.parseObject((String)itemsAdderPackCompressedEvent$PackEntry.getText());
        JSONObject jSONObject2 = jSONObject.getJSONObject("overlays");
        JSONArray jSONArray2 = jSONArray = jSONObject2 == null ? null : jSONObject2.getJSONArray("entries");
        if (jSONArray == null) {
            return 0;
        }
        List<String> list = map.entrySet().stream().filter(entry -> !((ItemsAdderPackCompressedEvent$PackEntry)entry.getValue()).isRemoved()).map(Map.Entry::getKey).toList();
        int n2 = jSONArray.size();
        jSONArray.removeIf(object -> {
            if (!(object instanceof JSONObject)) {
                return false;
            }
            JSONObject jSONObject = (JSONObject)object;
            String string = r.c(jSONObject);
            if (StringUtils.isBlank((String)string)) {
                return false;
            }
            return list.stream().noneMatch(string2 -> string2.startsWith(string + "/"));
        });
        int n3 = n2 - jSONArray.size();
        if (n3 > 0) {
            itemsAdderPackCompressedEvent$PackEntry.setBytes(JSON.toJSONBytes((Object)jSONObject, (JSONWriter.Feature[])new JSONWriter.Feature[]{JSONWriter.Feature.LargeObject}));
        }
        return n3;
    }

    void clear() {
        for (InputStream inputStream : this.arE.values()) {
            try {
                inputStream.close();
            }
            catch (IOException iOException) {}
        }
        this.arC.clear();
        this.arF.clear();
        this.arD.clear();
        this.arE.clear();
        this.arG.clear();
        this.arH.clear();
        this.arI.clear();
        this.arJ.clear();
        this.arK.clear();
    }

    private boolean ev(String string) {
        if (this.arB == null) {
            return false;
        }
        for (String string2 : this.arB) {
            if (!string.endsWith(string2)) continue;
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(InputStream inputStream, String string, ZipOutputStream zipOutputStream, byte[] byArray) {
        string = ColorBridge.iR(string);
        ZipEntry zipEntry = new ZipEntry(string);
        try {
            zipOutputStream.putNextEntry(zipEntry);
            try {
                int n2;
                while ((n2 = inputStream.read(byArray)) >= 0) {
                    zipOutputStream.write(byArray, 0, n2);
                }
            }
            finally {
                zipOutputStream.closeEntry();
                if (MaterialBarColorHolder.cB) {
                    ch.a(zipEntry);
                }
            }
        }
        catch (ZipException zipException) {
            CommandSenderBridge_5.warn("Stream compression skipped. Duplicate found: (stream) -> '" + string + "' | " + zipException.getMessage());
        }
        finally {
            zipOutputStream.closeEntry();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(String string, String string2, ZipOutputStream zipOutputStream, byte[] byArray) {
        string2 = ColorBridge.iR(string2);
        ZipEntry zipEntry = new ZipEntry(string2);
        try {
            zipOutputStream.putNextEntry(zipEntry);
            try (FileInputStream fileInputStream = new FileInputStream(string);){
                int n2;
                while ((n2 = fileInputStream.read(byArray)) >= 0) {
                    zipOutputStream.write(byArray, 0, n2);
                }
            }
            finally {
                zipOutputStream.closeEntry();
                if (MaterialBarColorHolder.cB) {
                    ch.a(zipEntry);
                }
            }
        }
        catch (ZipException zipException) {
            CommandSenderBridge_5.warn("File compression skipped. Duplicate found: '" + ColorBridge.iP(string) + "' -> '" + string2 + "' | " + zipException.getMessage());
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.warn("File compression skipped. Duplicate found '" + ColorBridge.iP(string) + "' -> '" + string2 + "'");
            CommandSenderBridge_5.error("Uncaught error", throwable);
        }
        finally {
            zipOutputStream.closeEntry();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void b(String string, String string2, ZipOutputStream zipOutputStream, byte[] byArray) {
        string2 = ColorBridge.iR(string2);
        ZipEntry zipEntry = new ZipEntry(string2);
        try {
            zipOutputStream.putNextEntry(zipEntry);
        }
        catch (ZipException zipException) {
            CommandSenderBridge_5.warn("Bundled file compression skipped. Duplicate found '" + ColorBridge.iP(string) + "' -> '" + string2 + "' | " + zipException.getMessage());
            zipOutputStream.closeEntry();
            return;
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Bundled file compression skipped. Duplicate found '" + ColorBridge.iP(string) + "' -> '" + string2 + "'");
            CommandSenderBridge_5.error("Uncaught error", throwable);
            zipOutputStream.closeEntry();
            return;
        }
        try (InputStream inputStream = this.getClass().getResourceAsStream("/" + string);){
            int n2;
            if (inputStream == null) {
                CommandSenderBridge_5.warn("Bundled file compression failed '" + ColorBridge.iP(string) + "' -> '" + string2 + "'");
                CommandSenderBridge_5.warn("Bundled file is null.");
                zipOutputStream.closeEntry();
                return;
            }
            while ((n2 = inputStream.read(byArray)) >= 0) {
                zipOutputStream.write(byArray, 0, n2);
            }
        }
        finally {
            zipOutputStream.closeEntry();
            if (MaterialBarColorHolder.cB) {
                ch.a(zipEntry);
            }
        }
    }

    void yl() {
        File file;
        File file2;
        Object object22;
        ArrayList arrayList = new ArrayList();
        CommandSenderBridge_5.iA("Adding remaining files in namespaces folders...");
        try {
            for (Object object22 : ItemStackRegistry.g().y) {
                if (((File)object22).getName().startsWith(".")) continue;
                CommandSenderBridge_5.iA("------- RESOURCE PACK FOLDER: " + String.valueOf(object22) + " -------");
                file2 = new File((File)object22, "pack.mcmeta");
                if (!file2.exists()) continue;
                file = c.N(file2);
                File file3 = file2.getParentFile();
                if (!file.containsKey("overlays") || !file.getJSONObject("overlays").containsKey("entries")) continue;
                file.getJSONObject("overlays").getJSONArray("entries").forEach(object -> {
                    try {
                        JSONObject jSONObject = (JSONObject)object;
                        String string = jSONObject.getString("directory");
                        if (StringUtils.isBlank((String)string)) {
                            CommandSenderBridge_5.warn("Overlay 'directory' attribute is empty in: " + ColorBridge.I(file3));
                            return;
                        }
                        File file2 = new File(file3, string);
                        if (file2.exists()) {
                            Collection collection = FileUtils.listFiles((File)file2, null, (boolean)true);
                            for (File file3 : collection) {
                                if (this.arA.contains(FilenameUtils.getExtension((String)file3.getName()))) continue;
                                String string2 = ColorBridge.iR(file3.getAbsolutePath().replace(file3.getAbsolutePath(), ""));
                                this.a(file3, string2, true);
                                if (MaterialBarColorHolder.fQ) {
                                    CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "[Pack] Added overlay file: " + string2);
                                }
                                arrayList.add(file3);
                            }
                        } else {
                            CommandSenderBridge_5.warn("Overlay directory '" + string + "' not found in: " + ColorBridge.I(file3));
                        }
                    }
                    catch (Exception exception) {
                        CommandSenderBridge_5.error("Error adding overlay.", exception);
                    }
                });
            }
        }
        catch (Exception exception) {
            CommandSenderBridge_5.error("Error adding overlays.", exception);
        }
        CommandSenderBridge_5.iA("Adding all the files in the namespaces folders...");
        List list = ItemStackRegistry.C();
        object22 = list.iterator();
        while (object22.hasNext()) {
            file2 = (File)object22.next();
            file = new File(file2, "assets");
            boolean bl2 = file.isDirectory() && list.contains(file);
            Collection collection = FileUtils.listFiles((File)file2, null, (boolean)true);
            for (File file4 : collection) {
                boolean bl3;
                if (this.arA.contains(FilenameUtils.getExtension((String)file4.getName())) || r.c(file2, file4) || arrayList.contains(file4) || bl2 && file4.toPath().startsWith(file.toPath())) continue;
                Object object3 = "assets/" + ColorBridge.iR(file4.getAbsolutePath()).replace(ColorBridge.iR(file2.getParentFile().getAbsolutePath()), "").replaceFirst("^/?(resourcepack|resource_pack)/?", "");
                if (((String)(object3 = ColorBridge.iR((String)object3))).startsWith("assets/assets/")) {
                    object3 = ((String)object3).substring("assets/".length());
                }
                if (((String)object3).startsWith("assets/minecraft/atlases/")) continue;
                if (this.eq((String)object3)) {
                    if (((String)object3).startsWith("assets/minecraft/atlases/") || ((String)object3).equals("assets/minecraft/font/default.json") || ((String)object3).startsWith("assets/minecraft/lang/") || ((String)object3).startsWith("assets/minecraft/blockstates/") || !((String)object3).startsWith("assets/minecraft/models/item/")) continue;
                    continue;
                }
                if (!r.ew(ColorBridge.H(file4)) || !(bl3 = this.a(file4, (String)object3, false)) || !MaterialBarColorHolder.fP) continue;
                CommandSenderBridge_5.log("[Pack] Added file: " + ColorBridge.I(file4));
            }
        }
        object22 = ItemStackRegistry.r("pack.png");
        if (object22 != null) {
            this.a((File)object22, ((File)object22).getName(), false);
        }
    }

    public static boolean c(File file, File file2) {
        try {
            String string = file.getCanonicalPath().replace('\\', '/');
            String string2 = file2.getCanonicalPath().replace('\\', '/');
            if (!string2.startsWith(string)) {
                return false;
            }
            if (file.getName().startsWith(".")) {
                return true;
            }
            String string3 = string2.substring(string.length());
            if (string3.startsWith("/")) {
                string3 = string3.substring(1);
            }
            if (string3.isEmpty()) {
                return false;
            }
            String[] stringArray = string3.split("/");
            for (int i2 = stringArray.length - 1; i2 >= 0; --i2) {
                String string4 = stringArray[i2];
                if (!string4.startsWith(".")) continue;
                return true;
            }
            return false;
        }
        catch (IOException iOException) {
            return file2.getName().startsWith(".");
        }
    }

    public static void ym() {
        CommandSenderBridge_5.error("Allowed characters: _ . - abcdefghijklmnopqrstuvwxyz 1234567890");
    }

    public static boolean ew(String string) {
        try {
            String string2;
            String[] stringArray;
            if (!string.contains("minecraft/texts/") && string.endsWith(".txt")) {
                return true;
            }
            String string3 = ColorBridge.iR(string);
            if ((string3 = ColorBridge.iO(string3)).startsWith("assets/")) {
                string3 = string3.substring(7);
            }
            if ((stringArray = string3.split("/")).length < 2) {
                string2 = string3;
            } else {
                String string4 = stringArray[1];
                string2 = string3.substring(string3.indexOf(string4));
                if (!r.ez(string4)) {
                    CommandSenderBridge_5.error("Invalid character in namespace '" + string4 + "' of file: " + ColorBridge.iO(string));
                    return false;
                }
            }
            if (!r.ex(string2)) {
                CommandSenderBridge_5.error("Invalid character in folders/name of file: " + ColorBridge.iO(string));
                return false;
            }
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return true;
    }

    public static boolean ex(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (r.n(string, i2)) continue;
            return false;
        }
        return true;
    }

    public static boolean ey(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (c2 == '#' || c2 == '_' || c2 >= 'a' && c2 <= 'z' || c2 >= '0' && c2 <= '9') continue;
            return false;
        }
        return true;
    }

    private static boolean n(String string, int n2) {
        char c2 = string.charAt(n2);
        return c2 == '/' || c2 == ':' || c2 == '_' || c2 == '-' || c2 >= 'a' && c2 <= 'z' || c2 >= '0' && c2 <= '9' || c2 == '.';
    }

    public static boolean ez(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (c2 == '_' || c2 == '-' || c2 >= 'a' && c2 <= 'z' || c2 >= '0' && c2 <= '9' || c2 == '.') continue;
            return false;
        }
        return true;
    }

    @Nullable
    public static List eA(String string) {
        @Nullable ArrayList<Character> arrayList = null;
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (c2 == '/' || c2 == ':' || c2 == '_' || c2 == '-' || c2 >= 'a' && c2 <= 'z' || c2 >= '0' && c2 <= '9' || c2 == '.') continue;
            if (arrayList == null) {
                arrayList = new ArrayList<Character>();
            }
            arrayList.add(Character.valueOf(c2));
        }
        return arrayList;
    }

    @Nullable
    public static List eB(String string) {
        @Nullable ArrayList<Character> arrayList = null;
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (c2 == '/' || c2 == ':' || c2 == '_' || c2 == '-' || c2 >= 'a' && c2 <= 'z' || c2 >= '0' && c2 <= '9') continue;
            if (arrayList == null) {
                arrayList = new ArrayList<Character>();
            }
            arrayList.add(Character.valueOf(c2));
        }
        return arrayList;
    }

    public void c(Consumer consumer) {
        Object object22;
        ArrayList arrayList = new ArrayList();
        this.arC.forEach((file, string) -> {
            if (string.matches("assets/[^/]+/models/.*\\.json")) {
                try {
                    JSONObject jSONObject = c.N(file);
                    consumer.accept(jSONObject);
                    this.d(jSONObject, (String)string);
                    arrayList.add(file);
                }
                catch (IOException iOException) {
                    CommandSenderBridge_5.warn("Failed to read JSON file: " + ColorBridge.H(file));
                }
            }
        });
        for (Object object22 : arrayList) {
            String object3 = (String)this.arC.remove(object22);
            if (object3 == null) continue;
            this.arF.remove(object3);
        }
        HashMap hashMap = new HashMap();
        this.arE.forEach((string, inputStream) -> {
            if (string.matches("assets/[^/]+/models/.*\\.json")) {
                try {
                    String string2 = ColorBridge.d(inputStream);
                    JSONObject jSONObject = c.jh(string2);
                    consumer.accept(jSONObject);
                    hashMap.put(string, new ByteArrayInputStream(c.K(jSONObject).getBytes(StandardCharsets.UTF_8)));
                }
                catch (Throwable throwable) {
                    CommandSenderBridge_5.warn("Failed to read JSON file from stream: " + string);
                }
            }
        });
        for (String string3 : hashMap.keySet()) {
            this.arE.removeAll(string3);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            this.arE.put((String)entry.getKey(), (InputStream)entry.getValue());
        }
        object22 = new HashMap();
        this.arD.forEach((arg_0, arg_1) -> this.a(consumer, (Map)object22, arg_0, arg_1));
        object22.forEach((string, string2) -> this.arD.removeAll(string));
    }

    private /* synthetic */ void a(Consumer consumer, Map map, String string, String string2) {
        if (string2.matches("assets/[^/]+/models/.*\\.json")) {
            try (InputStream inputStream = this.getClass().getResourceAsStream("/" + string);){
                if (inputStream == null) {
                    CommandSenderBridge_5.warn("Bundled file compression failed '" + ColorBridge.iP(string) + "' -> '" + string2 + "'");
                    CommandSenderBridge_5.warn("Bundled file is null.");
                    return;
                }
                String string3 = ColorBridge.d(inputStream);
                JSONObject jSONObject = c.jh(string3);
                consumer.accept(jSONObject);
                this.d(jSONObject, string2);
                map.put(string, string2);
                this.arE.put(string2, new ByteArrayInputStream(c.K(jSONObject).getBytes(StandardCharsets.UTF_8)));
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.warn("Failed to read JSON file from bundled file: " + ColorBridge.iP(string));
            }
        }
    }

    private /* synthetic */ InputStream eC(String string) {
        InputStream inputStream = this.getClass().getResourceAsStream("/" + string);
        if (inputStream == null) {
            throw new FileNotFoundException("Bundled file is null: " + string);
        }
        return inputStream;
    }

    private static /* synthetic */ InputStream p(File file) {
        return new FileInputStream(file);
    }

    private static /* synthetic */ void a(String string, File file, String string2, OutputStream outputStream) {
        JSONObject jSONObject;
        if (MaterialBarColorHolder.dq) {
            jSONObject = ItemStackRegistry.g().as.auh.eI(string);
        } else {
            jSONObject = c.N(file);
            ad.b(string2, jSONObject);
            ItemStackRegistry.g().as.auh.f(string2, jSONObject);
        }
        JSON.writeTo((OutputStream)outputStream, (Object)jSONObject, (JSONWriter.Feature[])new JSONWriter.Feature[]{JSONWriter.Feature.LargeObject});
    }

    private static /* synthetic */ void a(String string, OutputStream outputStream) {
        JSONObject jSONObject = ItemStackRegistry.g().as.auh.eJ(string);
        JSON.writeTo((OutputStream)outputStream, (Object)jSONObject, (JSONWriter.Feature[])new JSONWriter.Feature[]{JSONWriter.Feature.LargeObject});
    }
}
