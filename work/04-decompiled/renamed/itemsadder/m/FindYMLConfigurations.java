package itemsadder.m;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.r;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PluginFileConfigurationHolder;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

final class FindYMLConfigurations {
    private final Cache a = CacheBuilder.newBuilder().expireAfterWrite(10L, TimeUnit.MINUTES).build();

    FindYMLConfigurations() {
    }

    Collection b() {
        return this.a.asMap().values();
    }

    Map d() {
        return this.a.asMap();
    }

    void a(String string, String string2, boolean bl, boolean bl2) {
        List list = this.a(string, bl2);
        if (bl) {
            list.addAll(this.a(string2, bl2));
        }
        if (bl2) {
            this.a.asMap().entrySet().removeIf(entry -> !list.contains(entry.getKey()));
        }
    }

    private List a(String string, boolean bl) {
        ArrayList arrayList = new ArrayList();
        File file = new File(string);
        if (!file.exists()) {
            return arrayList;
        }
        try (Stream<Path> stream = Files.walk(file.toPath(), FileVisitOption.FOLLOW_LINKS);){
            stream.forEach(path -> {
                PluginFileConfigurationHolder pluginFileConfigurationHolder;
                if (!FilenameUtils.getExtension((String)path.toString()).equals("yml")) {
                    return;
                }
                if (path.toString().contains("conversion_backup")) {
                    return;
                }
                boolean bl2 = true;
                String string = path.toString();
                arrayList.add(string);
                if (bl && (pluginFileConfigurationHolder = (PluginFileConfigurationHolder)this.a.getIfPresent(string)) != null && pluginFileConfigurationHolder.CF().longValue() == path.toFile().lastModified()) {
                    bl2 = false;
                }
                if (bl2) {
                    if (bl) {
                        this.a.invalidate(string);
                    }
                    if ((pluginFileConfigurationHolder = new PluginFileConfigurationHolder((Plugin)Main.rS(), false, string, false, false, true, false)).CD() && pluginFileConfigurationHolder.z("info.enabled", true)) {
                        if (!FindYMLConfigurations.a(pluginFileConfigurationHolder.gV("info.namespace"), pluginFileConfigurationHolder)) {
                            return;
                        }
                        String string2 = ColorBridge.H(path.toFile());
                        if (bl) {
                            if (MaterialBarColorHolder.dJ) {
                                CommandSenderBridge_5.log("Detected file changes: " + string2);
                            }
                        } else if (MaterialBarColorHolder.dI) {
                            CommandSenderBridge_5.log("Found file: " + string2);
                        }
                        pluginFileConfigurationHolder.CF();
                        this.a.put(string, pluginFileConfigurationHolder);
                    }
                }
            });
        }
        catch (IOException iOException) {
            throw new RuntimeException("Failed to find YML configurations files.", iOException);
        }
        return arrayList;
    }

    static boolean a(@Nullable String string, PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        if (string == null) {
            CommandSenderBridge_5.error("Missing namespace in file: " + pluginFileConfigurationHolder.nh());
            return false;
        }
        List list = r.eB(string);
        if (list != null) {
            CommandSenderBridge_5.error("Invalid namespace characters: '" + ColorBridge.Q(list) + "'");
            CommandSenderBridge_5.error("Do not use special or UPPERCASE characters. File: " + pluginFileConfigurationHolder.nh());
            r.ym();
            return false;
        }
        return true;
    }
}
