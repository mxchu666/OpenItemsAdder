package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.r;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbr;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.wj;
import itemsadder.m.wk;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.FileTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.ChatColor;

public class te {
    static Map Kl = new HashMap();

    public static void az(boolean bl) {
        if (bl) {
            te.px();
        }
        d d2 = d.g();
        for (bbf bbf2 : d2.b()) {
            String string = bbf2.gV("info.namespace");
            d2.Z.add(string);
            List list = bbf2.gR("scripts");
            if (list == null) {
                if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                bce.log(String.valueOf(ChatColor.YELLOW) + "    No script found in file " + bbf2.qd());
                continue;
            }
            bbr.bf("Scripts '" + string + "'...");
            for (String string2 : list) {
                Object object;
                Object object2;
                bbg bbg2 = bbf2.hj("scripts." + string2);
                assert (bbg2 != null);
                if (!bbg2.C("enabled", true)) {
                    if (!Main.KO.gY("debug.items.log-items-loading-disabled")) continue;
                    bce.log("    Ignored disabled script: " + string2 + ", namespace: " + string);
                    continue;
                }
                if (Main.KO.gY("debug.items.log-items-loading")) {
                    bce.log("    Loading script: " + string2);
                }
                if (!r.ex(string2)) {
                    bce.error("[Items] Non [a-z0-9_.-] character in script '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
                    r.ym();
                    continue;
                }
                String string3 = bbg2.gV("path");
                if (string3 == null) {
                    bce.error("[Items] No path found for script '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
                    continue;
                }
                String[] stringArray = new String[]{".java", ".jspp", ".js"};
                File file = null;
                Object object3 = stringArray;
                int n = ((String[])object3).length;
                for (int i = 0; i < n && !(file = new File(new File(d.l, string), (String)(object2 = string3.endsWith((String)(object = object3[i])) ? string3 : string3 + (String)object))).exists(); ++i) {
                }
                if (!file.exists()) {
                    bce.error("[Items] Script '" + string + ":" + string2 + "' not found in yml file: " + bbf2.nh());
                    continue;
                }
                object3 = string + ":" + string2;
                if (Kl.containsKey(object3)) {
                    bce.warn("[Scripts] '" + (String)object3 + "' is already loaded. Skipping (" + String.valueOf(file) + ")");
                    continue;
                }
                String string4 = null;
                FileTime fileTime = null;
                try {
                    string4 = Files.readString(file.toPath());
                    fileTime = Files.getLastModifiedTime(file.toPath(), new LinkOption[0]);
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                if (string4 == null) continue;
                object = object3;
                if (file.getName().endsWith(".java")) {
                    if (((String)object).contains(":")) {
                        object = ((String)object).substring(((String)object).indexOf(58) + 1);
                    }
                } else {
                    object = ((String)object).replace(":", "_").replace("-", "_").replace(".", "_");
                }
                try {
                    object2 = d.g().A.a(file, string4, (String)object, fileTime);
                    if (!((wj)object2).rC()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (Object object4 : ((wj)object2).rz()) {
                            stringBuilder.append((String)object4).append("\n");
                        }
                        bce.warn("Errors compiling script: " + String.valueOf(file) + "\n" + String.valueOf(stringBuilder));
                        for (Object object4 : ((wj)object2).rA()) {
                            if (object4 == null) continue;
                            bce.warn("Trace: " + ((Throwable)object4).getMessage());
                            for (StackTraceElement stackTraceElement : ((Throwable)object4).getStackTrace()) {
                                bce.warn("    at " + String.valueOf(stackTraceElement));
                            }
                        }
                        if (!((wj)object2).rD()) continue;
                        bce.error("[Scripts] '" + (String)object3 + "' is disabled due to serious compilation errors");
                        bbg2.d("enabled", false);
                        bbf2.save();
                        continue;
                    }
                    Kl.put(object3, ((wj)object2).ry());
                    bce.log("[Scripts] '" + (String)object3 + "' loaded in " + ((wj)object2).rB() + "ms");
                }
                catch (Exception exception) {
                    bce.warn("Unexpected exception compiling script: " + String.valueOf(file), exception);
                }
            }
        }
    }

    public static void px() {
        Kl.clear();
    }

    public static wk ck(String string) {
        return (wk)Kl.get(string);
    }
}
