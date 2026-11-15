package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import dev.lone.itemsadder.Main;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.Opaque140;
import itemsadder.m.RuntimeError;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

public class VersionHelper_2 {
    public static final Version gm = Version.v1_20_6;
    private static final String gn = ".complete-shaders-v1";
    public static final Set go = Collections.unmodifiableSet(new LinkedHashSet<Version>(List.of(Version.v1_20_6, Version.v1_21_4, Version.v1_21_5, Version.v1_21_6, Version.v1_21_7, Version.v1_21_8, Version.v1_21_10, Version.v1_21_11, Version.v26_1_1, Version.v26_1_2, Version.v26_2)));
    private final Path gp;
    @Nullable
    private final Consumer gq;
    private final AtomicInteger gr = new AtomicInteger(0);
    Map gs = new ConcurrentHashMap();
    List gt;
    @Nullable
    static Version gu;

    public VersionHelper_2(Path path, @Nullable Consumer consumer) {
        this.gp = path;
        this.gq = consumer;
    }

    public static boolean a(String string) {
        return string.contains("builtin/") || string.endsWith("block/crop_cross") || string.endsWith("block/crop_billboard");
    }

    public void aw() {
        this.gr.set(0);
        for (Version version : go) {
            this.a(version);
        }
    }

    public static Version ax() {
        if (gu != null) {
            return gu;
        }
        gu = VersionHelper_2.ay();
        return gu;
    }

    private static Version ay() {
        Version version = Version.get();
        if (version == null || version.ordinal() < gm.ordinal()) {
            return gm;
        }
        if (go.contains(version)) {
            return version;
        }
        Version[] versionArray = Version.values();
        for (int i = version.ordinal() - 1; i >= 0; --i) {
            Version version2 = versionArray[i];
            if (!go.contains(version2)) continue;
            return version2;
        }
        return gm;
    }

    void a(Version version) {
        try {
            if (this.b(version)) {
                CommandSenderBridge_5.iA("Vanilla files already downloaded for version " + String.valueOf(version));
                this.gr.incrementAndGet();
                this.c(version);
                if (this.gq != null && this.aB()) {
                    this.gq.accept(this);
                }
                return;
            }
            CommandSenderBridge_5.iA("Vanilla files missing or incomplete for version " + String.valueOf(version) + ", downloading...");
        }
        catch (Exception exception) {
            CommandSenderBridge_5.error("Error checking if files exist for Minecraft assets version " + String.valueOf(version), exception);
            return;
        }
        BukkitTaskBridge.h(() -> {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * 
             * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK], 1[TRYBLOCK]], but top level block is 6[TRYBLOCK]
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
             *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
             *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1050)
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
        });
    }

    private boolean b(Version version) {
        boolean bl;
        Path path = this.gp.resolve(version.getName());
        Path path2 = path.resolve(gn);
        if (Files.isRegularFile(path2, new LinkOption[0])) {
            return true;
        }
        boolean bl2 = bl = version.ordinal() >= Version.v1_21_4.ordinal();
        if (!VersionHelper_2.a(path, bl)) {
            return false;
        }
        try {
            Files.writeString(path2, (CharSequence)"", new OpenOption[0]);
        }
        catch (IOException iOException) {
            CommandSenderBridge_5.warn("Failed to mark vanilla assets cache as complete for version " + version.getName() + ": " + iOException.getMessage());
        }
        return true;
    }

    static boolean a(Path path, boolean bl) {
        Path path2 = path.resolve("assets-list.txt");
        if (!Files.isRegularFile(path2, new LinkOption[0])) {
            return false;
        }
        Path path3 = path.resolve("assets/minecraft").normalize();
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = !bl;
        boolean bl5 = false;
        try {
            for (String string : Files.readAllLines(path2)) {
                Path path4;
                if ((string = string.trim()).isEmpty() || string.startsWith("#")) continue;
                if (string.startsWith("models/")) {
                    bl2 = true;
                } else if (string.startsWith("blockstates/")) {
                    bl3 = true;
                } else if (bl && string.startsWith("items/")) {
                    bl4 = true;
                } else {
                    if (!string.startsWith("shaders/")) continue;
                    bl5 = true;
                }
                if ((path4 = path3.resolve(string).normalize()).startsWith(path3) && Files.isRegularFile(path4, new LinkOption[0])) continue;
                return false;
            }
        }
        catch (IOException iOException) {
            return false;
        }
        return bl2 && bl3 && bl4 && bl5;
    }

    private void c(Version version2) {
        String string = this.c("assets-list.txt", version2);
        if (string != null) {
            this.gs.computeIfAbsent(version2, version -> Arrays.stream(string.split("\n")).map(String::trim).filter(string -> !string.isEmpty() && !string.startsWith("#")).collect(Collectors.toList()));
        }
    }

    public List d(Version version) {
        if (!this.gs.containsKey(version)) {
            version = VersionHelper_2.ax();
        }
        return this.gs.getOrDefault(version, Collections.emptyList());
    }

    public List az() {
        return this.gs.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    public List aA() {
        if (this.gt != null) {
            return this.gt;
        }
        if (this.gs.isEmpty()) {
            return Collections.emptyList();
        }
        Iterator iterator = this.gs.values().iterator();
        HashSet hashSet = new HashSet((Collection)iterator.next());
        while (iterator.hasNext()) {
            hashSet.retainAll((Collection)iterator.next());
            if (!hashSet.isEmpty()) continue;
        }
        this.gt = new ArrayList(hashSet);
        return this.gt;
    }

    public boolean aB() {
        return this.gr.get() == go.size();
    }

    private void a(Version version, String string) {
        Path path = this.gp.resolve(version.getName());
        try {
            boolean bl;
            byte[] byArray;
            String string2 = "https://mc-assets-downloader.lonedev.workers.dev/" + version.getName() + "/" + string;
            CommandSenderBridge_5.log("Downloading Vanilla Assets of '" + version.getName() + "' (" + string + ") ...");
            URL uRL = new URL(string2);
            HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
            httpURLConnection.setRequestProperty("Accept", "*/*");
            httpURLConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.9");
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
            try (InputStream inputStream = httpURLConnection.getInputStream();){
                byArray = inputStream.readAllBytes();
            }
            boolean bl2 = bl = byArray.length >= 4 && byArray[0] == 80 && byArray[1] == 75;
            if (bl) {
                CommandSenderBridge_5.iA("Detected ZIP archive, extracting...");
                try (ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(byArray));){
                    ZipEntry zipEntry;
                    while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                        if (zipEntry.isDirectory()) {
                            zipInputStream.closeEntry();
                            continue;
                        }
                        Path path2 = path.resolve(zipEntry.getName());
                        Files.createDirectories(path2.getParent(), new FileAttribute[0]);
                        try (OutputStream outputStream = Files.newOutputStream(path2, new OpenOption[0]);){
                            zipInputStream.transferTo(outputStream);
                        }
                        zipInputStream.closeEntry();
                    }
                }
            }
            Path path3 = path.resolve(string);
            Files.createDirectories(path3.getParent(), new FileAttribute[0]);
            Files.write(path3, byArray, new OpenOption[0]);
            CommandSenderBridge_5.log("Downloaded Vanilla Assets of '" + version.getName() + "' (" + string + ")");
        }
        catch (Exception exception) {
            throw new RuntimeError(exception);
        }
    }

    public InputStream a(String string, Version version) {
        InputStream inputStream = this.b(string, version);
        if (inputStream != null) {
            return inputStream;
        }
        Version version2 = VersionHelper_2.ax();
        if (version != version2) {
            return this.b(string, version2);
        }
        return null;
    }

    @Nullable
    private InputStream b(String string, @Nullable Version version) {
        if (version == null) {
            return null;
        }
        Path path = this.gp.resolve(version.getName()).resolve(string);
        if (Files.exists(path, new LinkOption[0])) {
            try {
                return Files.newInputStream(path, new OpenOption[0]);
            }
            catch (Exception exception) {
                CommandSenderBridge_5.error("Failed to open input stream for: " + String.valueOf(path), exception);
            }
        }
        return null;
    }

    @Nullable
    public String c(String string, Version version) {
        Path path = this.gp.resolve(version.getName()).resolve(string);
        if (Files.exists(path, new LinkOption[0])) {
            try {
                return Files.readString(path);
            }
            catch (Exception exception) {
                CommandSenderBridge_5.error("Failed to read text from: " + String.valueOf(path), exception);
            }
        }
        return null;
    }

    public boolean P(String string) {
        int n = 0;
        for (Version version : go) {
            for (String string2 : ItemStackRegistry.g().B.d(version)) {
                if (!string2.equals(string)) continue;
                ++n;
            }
        }
        return n == go.size();
    }

    public boolean Q(String string) {
        Opaque140 opaque140 = Opaque140.j(string, "minecraft");
        if (opaque140 == null) {
            return false;
        }
        String string2 = "models/" + opaque140.bM + ".json";
        return this.d(Version.get()).contains(string2);
    }

    public boolean R(String string) {
        Opaque140 opaque140 = Opaque140.j(string, "minecraft");
        if (opaque140 == null) {
            return false;
        }
        String string2 = "textures/" + opaque140.bM + ".png";
        return this.d(Version.get()).contains(string2);
    }

    @Nullable
    public File S(String string) {
        return this.b(VersionHelper_2.ax(), string);
    }

    @Nullable
    public File b(Version version, String string) {
        String string2;
        Opaque140 opaque140 = Opaque140.j(string, "minecraft");
        if (opaque140 == null) {
            return null;
        }
        File file = new File(Main.rS().getDataFolder(), "storage" + File.separator + "cache" + File.separator + "vanilla_assets" + File.separator + version.getName() + File.separator + "assets" + File.separator + "minecraft");
        File file2 = new File(file, string2 = "models/" + opaque140.bM + ".json");
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    @Nullable
    public File a(Material material) {
        return this.S("minecraft:item/" + material.name().toLowerCase());
    }

    private /* synthetic */ void aC() {
        this.gq.accept(this);
    }

    private /* synthetic */ Void f(Version version) {
        this.a(version, "shaders.zip");
        return null;
    }

    private /* synthetic */ Void g(Version version) {
        this.a(version, "assets-list.txt");
        return null;
    }

    private /* synthetic */ Void h(Version version) {
        this.a(version, "blockstates.zip");
        return null;
    }

    private /* synthetic */ Void i(Version version) {
        if (version.ordinal() >= Version.v1_21_4.ordinal()) {
            this.a(version, "items.zip");
        }
        return null;
    }

    private /* synthetic */ Void j(Version version) {
        this.a(version, "models.zip");
        return null;
    }
}
