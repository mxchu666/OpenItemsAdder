package itemsadder.m;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.r;
import itemsadder.m.ae;
import itemsadder.m.bbf;
import itemsadder.m.bce;
import itemsadder.m.bcy;
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

final class a {
    private final Cache a = CacheBuilder.newBuilder().expireAfterWrite(10L, TimeUnit.MINUTES).build();

    a() {
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
                bbf bbf2;
                if (!FilenameUtils.getExtension((String)path.toString()).equals("yml")) {
                    return;
                }
                if (path.toString().contains("conversion_backup")) {
                    return;
                }
                boolean bl2 = true;
                String string = path.toString();
                arrayList.add(string);
                if (bl && (bbf2 = (bbf)this.a.getIfPresent(string)) != null && bbf2.CF().longValue() == path.toFile().lastModified()) {
                    bl2 = false;
                }
                if (bl2) {
                    if (bl) {
                        this.a.invalidate(string);
                    }
                    if ((bbf2 = new bbf((Plugin)Main.rS(), false, string, false, false, true, false)).CD() && bbf2.z("info.enabled", true)) {
                        if (!itemsadder.m.a.a(bbf2.gV("info.namespace"), bbf2)) {
                            return;
                        }
                        String string2 = bcy.H(path.toFile());
                        if (bl) {
                            if (ae.dJ) {
                                bce.log("Detected file changes: " + string2);
                            }
                        } else if (ae.dI) {
                            bce.log("Found file: " + string2);
                        }
                        bbf2.CF();
                        this.a.put(string, bbf2);
                    }
                }
            });
        }
        catch (IOException iOException) {
            throw new RuntimeException("Failed to find YML configurations files.", iOException);
        }
        return arrayList;
    }

    static boolean a(@Nullable String string, bbf bbf2) {
        if (string == null) {
            bce.error("Missing namespace in file: " + bbf2.nh());
            return false;
        }
        List list = r.eB(string);
        if (list != null) {
            bce.error("Invalid namespace characters: '" + bcy.Q(list) + "'");
            bce.error("Do not use special or UPPERCASE characters. File: " + bbf2.nh());
            r.ym();
            return false;
        }
        return true;
    }
}
