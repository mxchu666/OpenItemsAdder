package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.CustomEntity;
import dev.lone.itemsadder.api.CustomStack;
import dev.lone.itemsadder.api.scriptinginternal.EntityScript;
import dev.lone.itemsadder.api.scriptinginternal.EntityUtils;
import dev.lone.itemsadder.api.scriptinginternal.ItemScript;
import dev.lone.itemsadder.api.scriptinginternal.ItemsUtils;
import dev.lone.itemsadder.api.scriptinginternal.PlayerUtils;
import dev.lone.itemsadder.api.scriptinginternal.ScriptingUtils;
import dev.lone.itemsadder.api.scriptinginternal.WorldUtils;
import ia.sh.customblockdata.CustomBlockData;
import itemsadder.m.ae;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bce;
import itemsadder.m.bch;
import itemsadder.m.wf;
import itemsadder.m.wg;
import itemsadder.m.wj;
import itemsadder.m.wk;
import itemsadder.m.wl;
import itemsadder.m.wm;
import itemsadder.m.wn;
import itemsadder.m.wo;
import itemsadder.m.ws;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.CallSite;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class wi {
    private static final String NA = "iascript_generated";
    private static final String NB = "Plugin $plugin, Event $event, Player $player, CustomStack $customStack, ItemStack $itemStack";
    private static final String NC = "Plugin $plugin, Event $event, Player $player, CustomEntity $customEntity";
    private static final Set ND = Set.of(ScriptingUtils.class.getName(), PlayerUtils.class.getName(), WorldUtils.class.getName(), ItemsUtils.class.getName(), EntityUtils.class.getName());
    private static final Set NE = Set.of("itemsadder.m", "java.lang.reflect", "java.lang.invoke", "java.io", "java.nio.file", "java.net", "java.util.concurrent", "java.util.function", "java.lang.management", "java.security", "javax.security", "javax.script", "javax.tools", "java.sql", "javax.sql", "java.rmi", "javax.naming", "sun.reflect", "sun.misc", "sun.security", "jdk.internal", "jdk.nashorn", "jdk.jshell", "jdk.jfr", "jdk.vm", "com.sun.tools", "com.sun.jdi", "com.sun.management", "com.sun.net", "java.awt", "javax.swing", "java.applet", "org.apache.bcel", "org.objectweb", "net.bytebuddy", "javassist", "org.reflections", "org.codehaus.groovy", "org.mozilla.javascript", "org.python", "clojure", "bsh", "groovy", "scala.tools");
    List NF = List.of("org.bukkit.Bukkit", "org.bukkit.event.Event", "org.bukkit.plugin.Plugin", "org.bukkit.entity.Player", "org.bukkit.Location", "org.bukkit.inventory.ItemStack", "dev.lone.itemsadder.api.CustomStack", "dev.lone.itemsadder.api.CustomEntity");
    List NG = List.of("dev.lone.itemsadder.api.FontImages.FontImageWrapper", "dev.lone.itemsadder.api.FontImages.PlayerCustomHudWrapper", "dev.lone.itemsadder.api.FontImages.PlayerHudsHolderWrapper", "dev.lone.itemsadder.api.FontImages.PlayerHudWrapper", "dev.lone.itemsadder.api.FontImages.PlayerQuantityHudWrapper", "dev.lone.itemsadder.api.FontImages.TexturedInventoryWrapper", "dev.lone.itemsadder.api.CustomBlock", "dev.lone.itemsadder.api.CustomCrop", "dev.lone.itemsadder.api.CustomEntity", "dev.lone.itemsadder.api.CustomFire", "dev.lone.itemsadder.api.CustomFurniture", "dev.lone.itemsadder.api.CustomPlayer", "dev.lone.itemsadder.api.CustomStack", "dev.lone.itemsadder.api.ItemsAdder", "java.util.ArrayList", "java.util.HashMap", "java.util.List", "java.util.Map");
    private static final List NH = List.of(new wn(Pattern.compile("^cancelEvent\\(\\);?.*$"), matcher -> "try {\n    if ($event instanceof org.bukkit.event.Cancellable cancellableEvent)\n        cancellableEvent.setCancelled(true);\n} catch (Exception ignored) {}\n"), new wn(Pattern.compile("^let\\s+(\\w+)\\s*=\\s*(.*);?$"), matcher -> {
        String string = "var " + matcher.group(1) + " = " + matcher.group(2);
        return string.endsWith("}") || string.endsWith("{") ? string : string + ";";
    }), new wn(Pattern.compile("^const\\s+(\\w+)\\s*=\\s*(.*);?$"), matcher -> {
        String string = "final var " + matcher.group(1) + " = " + matcher.group(2);
        return string.endsWith("}") || string.endsWith("{") ? string : string + ";";
    }), new wn(Pattern.compile("^undefined\\s*;?$"), matcher -> "null"));
    private final bbf NI = new bbf((Plugin)Main.rS(), true, "storage/cache/compiled_scripts/cached_files.yml", false, false);
    private boolean NJ = false;

    public void rx() {
        if (this.NJ) {
            return;
        }
        CustomBlockData.registerListener((Plugin)Main.rS());
        this.NJ = true;
    }

    private Optional cz(String string) {
        Matcher matcher = Pattern.compile("^\\s*package\\s+([a-zA-Z_][a-zA-Z0-9_.]*);", 8).matcher(string);
        if (matcher.find()) {
            return Optional.of(matcher.group(1));
        }
        return Optional.empty();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public wj a(File file, String string, String string2, FileTime fileTime) {
        List list;
        Object object2;
        String string3;
        Object object3;
        Path path;
        Path path2;
        String string4;
        ClassLoader classLoader;
        wk wk2;
        wj wj2;
        block52: {
            wj2 = new wj();
            wk2 = new wk();
            wk2.NQ = ae.fT;
            wj2.gK = wk2;
            classLoader = Main.class.getClassLoader();
            string4 = this.cz(string).orElse(NA) + "." + string2;
            path2 = new File(Main.rS().getDataFolder(), "storage/cache/compiled_scripts").toPath();
            try {
                Files.createDirectories(path2, new FileAttribute[0]);
            }
            catch (IOException iOException) {
                wj2.NK.add("Error creating cache directory: " + iOException.getMessage());
                return wj2;
            }
            String string5 = string4.replace(".", "/");
            path = path2.resolve(string5 + ".class");
            try {
                Object object4;
                Object object5;
                object3 = this.NI.hj(string5);
                if (object3 == null || !Files.exists(path, new LinkOption[0]) || Files.getLastModifiedTime(path, new LinkOption[0]).toMillis() != fileTime.toMillis() || ((bbg)object3).a("last_modified", 0L) != fileTime.toMillis() || !((bbg)object3).aC("itemsadder_version", "").equals(Main.rS().getVersion())) break block52;
                HashMap<CallSite, byte[]> hashMap = new HashMap<CallSite, byte[]>();
                hashMap.put((CallSite)((Object)string4), Files.readAllBytes(path));
                Path path3 = path.getParent();
                String string6 = path.getFileName().toString().replace(".class", "");
                try {
                    object5 = Files.newDirectoryStream(path3, string6 + "$*.class");
                    try {
                        object4 = object5.iterator();
                        while (object4.hasNext()) {
                            Path path4 = object4.next();
                            String string7 = this.cz(string).orElse(NA) + "." + path4.getFileName().toString().replace(".class", "");
                            hashMap.put((CallSite)((Object)string7), Files.readAllBytes(path4));
                        }
                    }
                    finally {
                        if (object5 != null) {
                            object5.close();
                        }
                    }
                }
                catch (IOException iOException) {
                    wj2.NK.add("Error reading cached sub-classes: " + iOException.getMessage());
                    wj2.NL.add(iOException);
                }
                object5 = new wf(hashMap, classLoader);
                wk2.NP = object4 = ((ClassLoader)object5).loadClass(string4);
                wk2.NO = string;
                wi.G("Loaded cached class: " + ((Class)object4).getName() + " from " + String.valueOf(path));
                return wj2;
            }
            catch (ClassNotFoundException classNotFoundException) {
                wj2.NK.add("Cached class not found: " + classNotFoundException.getMessage());
                wj2.NL.add(classNotFoundException);
            }
            catch (IOException iOException) {
                wj2.NK.add("Error reading cached class: " + iOException.getMessage());
            }
            catch (Throwable throwable) {
                wj2.NK.add("Unexpected error while checking cached class. Recompiling it. Error: " + throwable.getMessage());
                wj2.NL.add(throwable);
                try {
                    if (Files.exists(path, new LinkOption[0])) {
                        Files.delete(path);
                        wi.G("Deleted cached file: " + String.valueOf(path));
                    }
                }
                catch (IOException iOException) {
                    wj2.NK.add("Error deleting cached file: " + iOException.getMessage());
                    wj2.NL.add(iOException);
                }
            }
        }
        if (ae.fS) {
            this.log(" ");
            this.log("Compiling script: " + string2);
        }
        object3 = new HashSet(this.l(Bukkit.class));
        string = this.cD(string);
        try {
            string3 = this.w(string, string2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            wj2.NK.add("Preprocessing error: " + illegalArgumentException.getMessage());
            return wj2;
        }
        String[] stringArray = string3.split("\n");
        String[] stringArray2 = string.split("\n");
        for (String object6 : stringArray2) {
            object2 = object6.trim();
            if (((String)object2).isEmpty() || (!((String)object2).startsWith("import \"") || !((String)object2).endsWith("\"")) && (!((String)object2).startsWith("import \"") || !((String)object2).endsWith("\";"))) continue;
            list = ((String)object2).substring(8, ((String)object2).length() - (((String)object2).endsWith("\";") ? 2 : 1));
            wi.G("Found explicit import: " + (String)((Object)list));
            try {
                object3.addAll(this.cG((String)((Object)list)));
            }
            catch (ClassNotFoundException i) {
                wj2.NK.add("Class not found: " + (String)((Object)list));
            }
        }
        try {
            Diagnostic diagnostic22;
            Object n2;
            Object exception;
            Object object4;
            Object object5;
            boolean list3;
            JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
            if (ae.fS) {
                bce.log("[Scripts] JavaCompiler implementation: " + javaCompiler.getClass().getName());
            }
            DiagnosticCollector diagnosticCollector = new DiagnosticCollector();
            StandardJavaFileManager standardJavaFileManager = javaCompiler.getStandardFileManager(diagnosticCollector, null, null);
            wg wg2 = new wg(standardJavaFileManager);
            object2 = new ws(string4, string3);
            if (ae.fS) {
                bce.log("[Scripts] MemoryFileManager class: " + wg2.getClass().getName());
                bce.log("[Scripts] Creating JavaFileObject for: " + string4);
                bce.log("[Scripts] Class name in Java source: " + wi.cA(string3));
                bce.log("[Scripts] JavaFileObject className: " + string4);
                bce.log("[Scripts] Submitting JavaFileObject for: " + object2.getName());
            }
            object3.add(System.getProperty("java.class.path"));
            list = new ArrayList();
            int n = 0;
            for (int i = 2; n < i && !(list3 = (object5 = javaCompiler.getTask(ae.fS ? new PrintWriter(System.out) : null, wg2, (DiagnosticListener<? super JavaFileObject>)(object4 = new DiagnosticCollector()), (Iterable<String>)(exception = List.of("-g", "-sourcepath", file.getParentFile().getAbsolutePath(), "-classpath", String.join((CharSequence)File.pathSeparator, (Iterable<? extends CharSequence>)object3), "-proc:none", "-Xlint:-options")), null, List.of(object2))).call().booleanValue()) && !(n2 = (diagnostic22 = List.copyOf(((DiagnosticCollector)object4).getDiagnostics())).stream().map(diagnostic -> diagnostic.getMessage(Locale.ENGLISH)).collect(Collectors.toList())).equals(list); ++i) {
                list = n2;
                Set set = this.u((List)((Object)diagnostic22));
                object3.addAll(set);
            }
            object4 = List.of("-g", "-sourcepath", file.getParentFile().getAbsolutePath(), "-classpath", String.join((CharSequence)File.pathSeparator, (Iterable<? extends CharSequence>)object3), "-proc:none", "-Xlint:-options");
            try {
                exception = new wo(javaCompiler, wg2, (List)object4, (JavaFileObject)object2, string, NE).rL();
                if (!exception.isEmpty()) {
                    wj2.NK.addAll(exception);
                    wj2.NN = true;
                    object5 = wj2;
                    return object5;
                }
            }
            catch (Exception exception2) {
                throw new RuntimeException(exception2);
            }
            exception = javaCompiler.getTask(ae.fS ? new PrintWriter(System.out) : null, wg2, diagnosticCollector, (Iterable<String>)object4, null, List.of(object2));
            if (ae.fS) {
                bce.log("[Scripts] Compiling JavaFileObject: " + object2.getName());
            }
            if ((object5 = exception.call()) == null || !((Boolean)object5).booleanValue()) {
                for (Diagnostic diagnostic22 : List.copyOf(diagnosticCollector.getDiagnostics())) {
                    if (diagnostic22.getLineNumber() == -1L && diagnostic22.getMessage(Locale.ENGLISH).contains("uses or overrides a deprecated API") || diagnostic22.getLineNumber() == -1L && diagnostic22.getMessage(Locale.ENGLISH).contains("Recompile with -Xlint:deprecation") || diagnostic22.getLineNumber() == -1L && diagnostic22.getMessage(Locale.ENGLISH).contains("Some messages have been simplified") || diagnostic22.getLineNumber() == -1L && diagnostic22.getMessage(Locale.ENGLISH).contains("Some messages have been suppressed")) continue;
                    wj2.NK.add("Error at line " + diagnostic22.getLineNumber() + ": " + diagnostic22.getMessage(Locale.ENGLISH));
                    int throwable = (int)diagnostic22.getLineNumber();
                    if (throwable - 1 < 0) continue;
                    wj2.NK.add("Code: " + stringArray[throwable - 1]);
                }
                wj object12 = wj2;
                return object12;
            }
            if (ae.fS) {
                bce.log("[Scripts] Task call success: " + (Boolean)object5);
                bce.log("[Scripts] Compiled class keys: " + String.valueOf(wg2.rv().keySet()));
            }
            wk2.NO = string3;
            exception = wg2.rv();
            if (ae.fS) {
                bce.log("[Scripts] Compiled class keys: " + String.valueOf(exception.keySet()));
            }
            diagnostic22 = new wf((Map)exception, classLoader);
            try {
                wk2.NP = ((ClassLoader)((Object)diagnostic22)).loadClass(string4);
                if (ae.fS) {
                    bce.log("[Scripts] Loaded class: " + wk2.NP.getName());
                }
            }
            catch (Throwable iOException) {
                wj2.NK.add("Failed to load class: " + string4 + " - " + iOException.getClass().getName() + ": " + iOException.getMessage());
                wj2.NL.add(iOException);
                wj wj3 = wj2;
                if (ae.fS) {
                    List list2 = wj2.NK;
                    bce.log("[Scripts] Generated Java code for: '" + string2 + "'\n" + Arrays.stream(string3.split("\n")).map(object -> {
                        int n = Arrays.asList(string3.split("\n")).indexOf(object) + 1;
                        String string3 = list2.stream().anyMatch(string -> string.contains("Error at line " + n + ":")) ? String.valueOf(ChatColor.RED) + " <- Error" + String.valueOf(ChatColor.RESET) : "";
                        object = ((String)object).stripTrailing();
                        if (!string3.equals("")) {
                            object = String.valueOf(ChatColor.YELLOW) + (String)object;
                        }
                        return (String)object + " // " + n + string3;
                    }).collect(Collectors.joining("\n")));
                }
                return wj3;
            }
            try {
                try {
                    for (Map.Entry entry : exception.entrySet()) {
                        String string5 = ((String)entry.getKey()).replace(".", "/");
                        byte[] byArray = (byte[])entry.getValue();
                        Path path3 = path2.resolve(string5 + ".class");
                        Files.createDirectories(path3.getParent(), new FileAttribute[0]);
                        Files.write(path3, byArray, new OpenOption[0]);
                        Files.setLastModifiedTime(path3, fileTime);
                        bbg bbg2 = this.NI.hk(string5);
                        bbg2.d("file_path", (Object)path3.toString());
                        bbg2.d("last_modified", fileTime.toMillis());
                        bbg2.d("class_name", (Object)string4);
                        bbg2.d("itemsadder_version", (Object)Main.rS().getVersion());
                        this.NI.save();
                    }
                    wi.G("Compiled class: " + string4 + " to " + String.valueOf(path));
                }
                catch (IOException iOException) {
                    wj2.NK.add("Error writing compiled classes to disk: " + iOException.getMessage());
                }
            }
            catch (Exception exception3) {
                wj2.NK.add("Class loading error: " + String.valueOf(exception3.getClass()) + " - " + exception3.getMessage());
            }
            exception = wj2;
            return exception;
        }
        finally {
            if (ae.fS) {
                List wj3 = wj2.NK;
                bce.log("[Scripts] Generated Java code for: '" + string2 + "'\n" + Arrays.stream(string3.split("\n")).map(object -> {
                    int n = Arrays.asList(string3.split("\n")).indexOf(object) + 1;
                    String string3 = list2.stream().anyMatch(string -> string.contains("Error at line " + n + ":")) ? String.valueOf(ChatColor.RED) + " <- Error" + String.valueOf(ChatColor.RESET) : "";
                    object = ((String)object).stripTrailing();
                    if (!string3.equals("")) {
                        object = String.valueOf(ChatColor.YELLOW) + (String)object;
                    }
                    return (String)object + " // " + n + string3;
                }).collect(Collectors.joining("\n")));
            }
        }
    }

    private static String cA(String string) {
        Matcher matcher = Pattern.compile("public class (\\w+)").matcher(string);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "<not found>";
    }

    private StringBuilder e(String[] stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = false;
        for (String string : stringArray) {
            Object object;
            String string2 = string.trim();
            Matcher matcher = Pattern.compile("^delay\\(([^,]+),\\s*\\(\\)\\s*=>\\s*\\{(.*?)\\}\\);\\s*$").matcher(string2);
            if (matcher.matches()) {
                stringBuilder.append("_runDelayed(").append(matcher.group(1).trim()).append(", () -> {\n").append(matcher.group(2).trim()).append("\n});\n");
                continue;
            }
            Matcher matcher2 = Pattern.compile("^delay\\(([^,]+),\\s*\\(\\)\\s*=>\\s*(.+?)\\);\\s*$").matcher(string2);
            if (matcher2.matches()) {
                object = matcher2.group(2).trim();
                if (!((String)object).endsWith(";")) {
                    object = (String)object + ";";
                }
                stringBuilder.append("_runDelayed(").append(matcher2.group(1).trim()).append(", () -> {\n").append((String)object).append("\n});\n");
                continue;
            }
            object = Pattern.compile("^delay\\(([^,]+),\\s*\\(\\)\\s*=>\\s*\\{\\s*$").matcher(string2);
            if (((Matcher)object).matches()) {
                bl = true;
                stringBuilder.append("_runDelayed(").append(((Matcher)object).group(1).trim()).append(", () -> {\n");
                continue;
            }
            if (bl && string2.matches("^\\}\\);\\s*$")) {
                bl = false;
                stringBuilder.append("});\n");
                continue;
            }
            stringBuilder.append(string).append("\n");
        }
        return stringBuilder;
    }

    private StringBuilder f(String[] stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = false;
        int n = 0;
        for (String string : stringArray) {
            String string2 = string.trim();
            Matcher matcher = Pattern.compile("^([a-zA-Z_][a-zA-Z0-9_<>]*)\\s+(\\w+)\\s*\\(([^)]*)\\)\\s*\\{\\s*$").matcher(string2);
            if (matcher.matches() && !bl) {
                bl = true;
                n = 1;
                String string3 = matcher.group(1);
                String string4 = matcher.group(2);
                String string5 = matcher.group(3);
                stringBuilder.append("public static ").append(string3).append(" ").append(string4).append("(").append(string5).append(") {\n");
                continue;
            }
            if (bl) {
                if (string2.contains("{")) {
                    ++n;
                }
                if (string2.contains("}")) {
                    --n;
                }
                stringBuilder.append(string).append("\n");
                if (n != 0) continue;
                bl = false;
                continue;
            }
            stringBuilder.append(string).append("\n");
        }
        return stringBuilder;
    }

    public wl a(wk wk2, Plugin plugin, Event event, Player player, CustomStack customStack, ItemStack itemStack) {
        long l = System.currentTimeMillis();
        if (wk2.NQ) {
            this.log("Looking for main method in: " + wk2.NP.getName());
            this.log("Compiled class loader: " + String.valueOf(wk2.NP.getClassLoader()));
        }
        try {
            if (ItemScript.class.isAssignableFrom(wk2.NP)) {
                ItemScript itemScript = (ItemScript)wk2.NP.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                itemScript.handleEvent(plugin, event, player, customStack, itemStack);
                return new wl(System.currentTimeMillis() - l);
            }
        }
        catch (Throwable throwable) {
            return new wl(System.currentTimeMillis() - l, throwable);
        }
        for (Method method : wk2.NP.getDeclaredMethods()) {
            if (wk2.NQ) {
                this.log("Method: " + method.getName() + " with params: " + Arrays.toString(method.getParameterTypes()));
            }
            if (!method.getName().equals("main") || method.getParameterCount() != 5) continue;
            if (method.getParameterTypes()[0].equals(Plugin.class) && method.getParameterTypes()[1].equals(Event.class) && method.getParameterTypes()[2].equals(Player.class) && method.getParameterTypes()[3].equals(CustomStack.class) && method.getParameterTypes()[4].equals(ItemStack.class)) {
                method.setAccessible(true);
                try {
                    method.invoke(null, plugin, event, player, customStack, itemStack);
                }
                catch (InvocationTargetException invocationTargetException) {
                    Throwable throwable = invocationTargetException.getCause();
                    if (throwable != null) {
                        int n;
                        String string = wk2.NP.getName();
                        String string2 = null;
                        StackTraceElement[] stackTraceElementArray = throwable.getStackTrace();
                        StackTraceElement stackTraceElement = stackTraceElementArray[0];
                        if (stackTraceElement.getClassName().equals(string) && (n = stackTraceElement.getLineNumber()) > 0 && n <= wk2.NO.split("\n").length) {
                            string2 = wk2.NO.split("\n")[n - 1];
                            string2 = string2.trim();
                        }
                        if (string2 != null) {
                            String[] stringArray = new String[]{throwable.getMessage(), "  at line " + stackTraceElementArray[0].getLineNumber() + ": " + string2};
                            return new wl(System.currentTimeMillis() - l, stringArray);
                        }
                        return new wl(System.currentTimeMillis() - l, throwable);
                    }
                    return new wl(System.currentTimeMillis() - l, invocationTargetException);
                }
            }
            return new wl(System.currentTimeMillis() - l);
        }
        return new wl(System.currentTimeMillis() - l, new RuntimeException("No main method found in class: " + wk2.NP.getName()));
    }

    public wl a(wk wk2, Plugin plugin, Event event, @Nullable Player player, @Nullable CustomEntity customEntity) {
        long l = System.currentTimeMillis();
        if (wk2.NQ) {
            this.log("Looking for main method in: " + wk2.NP.getName());
            this.log("Compiled class loader: " + String.valueOf(wk2.NP.getClassLoader()));
        }
        try {
            if (EntityScript.class.isAssignableFrom(wk2.NP)) {
                EntityScript entityScript = (EntityScript)wk2.NP.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                entityScript.handleEvent(plugin, event, player, customEntity);
                return new wl(System.currentTimeMillis() - l);
            }
        }
        catch (Throwable throwable) {
            return new wl(System.currentTimeMillis() - l, throwable);
        }
        for (Method method : wk2.NP.getDeclaredMethods()) {
            if (wk2.NQ) {
                this.log("Method: " + method.getName() + " with params: " + Arrays.toString(method.getParameterTypes()));
            }
            if (!method.getName().equals("main") || method.getParameterCount() != 4 || !method.getParameterTypes()[0].equals(Plugin.class) || !method.getParameterTypes()[1].equals(Event.class) || !method.getParameterTypes()[2].equals(Player.class) || !method.getParameterTypes()[3].equals(CustomEntity.class)) continue;
            method.setAccessible(true);
            try {
                method.invoke(null, plugin, event, player, customEntity);
            }
            catch (InvocationTargetException invocationTargetException) {
                Throwable throwable = invocationTargetException.getCause();
                if (throwable != null) {
                    int n;
                    String string = wk2.NP.getName();
                    String string2 = null;
                    StackTraceElement[] stackTraceElementArray = throwable.getStackTrace();
                    StackTraceElement stackTraceElement = stackTraceElementArray[0];
                    if (stackTraceElement.getClassName().equals(string) && (n = stackTraceElement.getLineNumber()) > 0 && n <= wk2.NO.split("\n").length) {
                        string2 = wk2.NO.split("\n")[n - 1];
                        string2 = string2.trim();
                    }
                    if (string2 != null) {
                        String[] stringArray = new String[]{throwable.getMessage(), "  at line " + stackTraceElementArray[0].getLineNumber() + ": " + string2};
                        return new wl(System.currentTimeMillis() - l, stringArray);
                    }
                    return new wl(System.currentTimeMillis() - l, throwable);
                }
                return new wl(System.currentTimeMillis() - l, invocationTargetException);
            }
            return new wl(System.currentTimeMillis() - l);
        }
        return new wl(System.currentTimeMillis() - l, new RuntimeException("No main custom entity method found in class: " + wk2.NP.getName()));
    }

    private String w(String string2, String string3) {
        Object object5;
        Object object2;
        if ((string2.contains("extends EntityScript") || string2.contains("extends ItemScript")) && string2.contains("class ")) {
            bce.log("Detected new script format with main method and class declaration. Adjusting script structure.");
            if (!string2.contains("public class ")) {
                throw new IllegalArgumentException("Script must contain a public class declaration. Found: " + string2);
            }
            StringBuilder stringBuilder = new StringBuilder(string2);
            if (!stringBuilder.toString().contains("package ")) {
                String[] stringArray = string3.split("\\.");
                String string4 = String.join((CharSequence)".", Arrays.copyOf(stringArray, stringArray.length - 1));
                stringBuilder.insert(0, "package iascript_generated." + string4 + ";\n\n");
            }
            return stringBuilder.toString();
        }
        wm wm2 = wm.cI(string2);
        if (wm2 == wm.BOTH) {
            throw new IllegalArgumentException("Script contains $customItem and $customEntity! Decide one of them or create two different scripts.");
        }
        HashSet<Object> hashSet = new HashSet<Object>();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        String[] stringArray = string2.split("\n");
        boolean bl = false;
        int n = 0;
        for (String string4 : stringArray) {
            object2 = string4.trim();
            if (((String)object2).isEmpty()) continue;
            if (((String)object2).startsWith("import \"") && ((String)object2).endsWith("\";")) {
                object5 = ((String)object2).substring(8, ((String)object2).length() - 2);
                hashSet.add(object5);
                continue;
            }
            if (((String)object2).contains("ChatColor.") && !((Object)hashSet).toString().contains("org.bukkit.ChatColor")) {
                hashSet.add("org.bukkit.ChatColor");
            }
            if (((String)object2).contains("Material.") && !((Object)hashSet).toString().contains("org.bukkit.Material")) {
                hashSet.add("org.bukkit.Material");
            }
            for (Object object3 : this.NG) {
                String string5 = ((String)object3).substring(((String)object3).lastIndexOf(46) + 1);
                if (!((String)object2).contains(string5) || ((Object)hashSet).toString().contains((CharSequence)object3)) continue;
                hashSet.add(object3);
            }
            boolean bl2 = ((String)object2).matches("^(public\\s+)?(class|record|interface|enum)\\s+\\w+.*");
            if (bl2 || bl) {
                stringBuilder.append(string4).append("\n");
                for (Object object4 : (Object)string4.toCharArray()) {
                    if (object4 == 123) {
                        ++n;
                        continue;
                    }
                    if (object4 != 125) continue;
                    --n;
                }
                bl = n > 0;
                continue;
            }
            stringBuilder2.append(string4).append("\n");
        }
        stringBuilder2 = this.e(stringBuilder2.toString().split("\n"));
        stringBuilder2 = this.f(stringBuilder2.toString().split("\n"));
        bch bch2 = bch.G(stringBuilder2);
        String string6 = this.a(bch2);
        stringBuilder2 = (StringBuilder)bch2.aAW;
        hashSet.addAll(this.NF);
        ArrayList arrayList = new ArrayList(ND);
        StringBuilder stringBuilder3 = new StringBuilder(hashSet.stream().map(string -> "import " + string + ";").collect(Collectors.joining("\n")));
        for (Object object5 : arrayList) {
            stringBuilder3.append("\nimport static ").append((String)object5).append(".*").append(";");
        }
        object2 = wm2 == wm.ITEM ? NB : (wm2 == wm.CUSTOM_ENTITY ? NC : NB);
        object5 = "package iascript_generated;\n" + String.valueOf(stringBuilder3) + "\n\npublic class " + string3 + " {\n\n" + this.cC(stringBuilder.toString()) + "\n    public static void main(" + (String)object2 + ") {\n" + this.cC(stringBuilder2.toString()) + "    }\n\n" + this.cC(string6) + "}";
        return this.cC((String)object5);
    }

    private String a(bch bch2) {
        String[] stringArray = ((StringBuilder)bch2.aAW).toString().split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        boolean bl = false;
        int n = 0;
        for (String string : stringArray) {
            String string2 = string.trim();
            if (!bl) {
                if (string2.matches("^(public|private|protected|static|final|\\s)*\\s*\\w+\\s+\\w+\\s*\\(.*\\)\\s*\\{?\\s*$")) {
                    bl = true;
                    n = this.cB(string);
                    stringBuilder2.append(string).append("\n");
                    continue;
                }
                stringBuilder.append(string).append("\n");
                continue;
            }
            stringBuilder2.append(string).append("\n");
            if ((n += this.cB(string)) > 0) continue;
            bl = false;
            stringBuilder2.append("\n");
        }
        bch2.aAW = stringBuilder;
        return stringBuilder2.toString();
    }

    private int cB(String string) {
        int n = 0;
        for (char c : string.toCharArray()) {
            if (c == '{') {
                ++n;
            }
            if (c != '}') continue;
            --n;
        }
        return n;
    }

    private String cC(String string2) {
        try {
            AtomicInteger atomicInteger = new AtomicInteger();
            return Arrays.stream(string2.split("\n")).map(string -> {
                if (string.trim().startsWith("}")) {
                    atomicInteger.getAndDecrement();
                }
                String string2 = "    ".repeat(atomicInteger.get()) + string.trim();
                if (string.trim().endsWith("{")) {
                    atomicInteger.getAndIncrement();
                }
                return string2;
            }).collect(Collectors.joining("\n"));
        }
        catch (Exception exception) {
            this.a("Error indenting code: " + exception.getMessage(), exception);
            return string2;
        }
    }

    public String cD(String string) {
        return Arrays.stream(string.split("\n")).map(this::cE).collect(Collectors.joining("\n"));
    }

    private String cE(String string) {
        String string2 = string.trim();
        for (wn wn2 : NH) {
            Matcher matcher = wn2.NU.matcher(string2);
            if (!matcher.matches()) continue;
            return (String)wn2.NV.apply(matcher);
        }
        return string;
    }

    private Set u(List list) {
        HashSet<String> hashSet = new HashSet<String>();
        for (Diagnostic diagnostic : list) {
            String string = diagnostic.getMessage(Locale.ENGLISH);
            String string2 = wi.cF(string);
            if (string2 == null || !string2.contains(".")) continue;
            try {
                Class<?> clazz = Class.forName(string2);
                CodeSource codeSource = clazz.getProtectionDomain().getCodeSource();
                if (codeSource == null) continue;
                File file = new File(codeSource.getLocation().toURI());
                hashSet.add(file.getAbsolutePath());
                wi.G("Resolved missing class: " + string2 + " from " + file.getName());
            }
            catch (Throwable throwable) {
                bce.error("[Scripts] Could not resolve class: " + string2);
            }
        }
        return hashSet;
    }

    @Nullable
    private static String cF(String string) {
        string = string.replace("\n", " ").replace("\r", " ");
        String string2 = null;
        if (string.contains("class file for")) {
            int n = string.indexOf("class file for") + "class file for".length();
            int n2 = string.indexOf("not found", n);
            if (n2 > n) {
                string2 = string.substring(n, n2).trim();
            }
        } else if (string.contains("cannot access")) {
            int n = string.indexOf("cannot access") + "cannot access".length();
            int n3 = string.indexOf(" ", n + 1);
            if (n3 == -1) {
                n3 = string.length();
            }
            string2 = string.substring(n, n3).trim();
        }
        return string2;
    }

    private Set l(Class clazz) {
        HashSet<String> hashSet = new HashSet<String>();
        try {
            Plugin[] pluginArray = clazz.getProtectionDomain().getCodeSource();
            if (pluginArray != null) {
                File file = new File(pluginArray.getLocation().toURI());
                hashSet.add(file.getAbsolutePath());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            try {
                CodeSource codeSource = plugin.getClass().getProtectionDomain().getCodeSource();
                if (codeSource == null) continue;
                File file = new File(codeSource.getLocation().toURI());
                hashSet.add(file.getAbsolutePath());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return hashSet;
    }

    private Set cG(String string) {
        Class<?> clazz = Class.forName(string);
        return this.l(clazz);
    }

    private void log(String string) {
        bce.log(string);
    }

    public static void G(String string) {
    }

    private void a(String string, Exception exception) {
    }
}
