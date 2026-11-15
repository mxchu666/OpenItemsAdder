package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.aab;
import itemsadder.m.asf;
import itemsadder.m.ash;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.uw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Logger;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

public final class asg {
    private final asf amr = (asf)aab.n(asf.class);
    private static asg ams;

    asg() {
    }

    public static void a(Player player, LinkedList linkedList) {
        if (linkedList != null && !linkedList.isEmpty()) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            for (uw uw2 : linkedList) {
                if (!s.a((HumanEntity)player, uw2)) continue;
                arrayList.add(uw2.Hg);
            }
            if (!arrayList.isEmpty()) {
                asg.c(player, arrayList);
            }
        }
    }

    public static void e(Player player, uw uw2) {
        asg.a(player, uw2, true);
    }

    public static void a(Player player, uw uw2, boolean bl) {
        if (uw2 != null && (!bl || s.a((HumanEntity)player, uw2))) {
            asg.c(player, Collections.singletonList(uw2.Hg));
        }
    }

    public static void cg(Player player) {
        asg.vq().b(player, d.g().aW.qY());
    }

    public static void c(Player player, List list) {
        asg.vq().b(player, list);
    }

    private void register() {
        if (this.amr != null) {
            this.amr.register();
        } else {
            bce.error("Failed to register VanillaRecipebook");
        }
    }

    private static asg vp() {
        if (ams == null) {
            ams = new asg();
        }
        return ams;
    }

    public static asf vq() {
        return asg.vp().amr;
    }

    public static void vr() {
        asg.unregister();
        asg.vs();
        asg asg2 = asg.vp();
        asg2.register();
    }

    public static void unregister() {
        if (ams != null && asg.ams.amr != null) {
            asg.ams.amr.unregister();
        }
        asg.vt();
    }

    private static void vs() {
        if (Main.KO.z("recipes.hide-vanilla-unrecognized-recipe-errors", true)) {
            ((Logger)LogManager.getRootLogger()).addFilter((Filter)new ash());
        }
    }

    private static void vt() {
        Logger logger = (Logger)LogManager.getRootLogger();
        logger.getFilters().forEachRemaining(filter -> {
            if (filter.getClass().toString().contains("dev.lone.itemsadder")) {
                logger.get().removeFilter(filter);
            }
        });
    }

    public static String[] a(String[] stringArray, Map map) {
        for (int i = 0; i < stringArray.length; ++i) {
            char[] cArray;
            String string = stringArray[i];
            StringBuilder stringBuilder = new StringBuilder(string.length());
            for (char c : cArray = string.toCharArray()) {
                stringBuilder.append(map.get(Character.valueOf(c)) == null ? (char)' ' : c);
            }
            stringArray[i] = stringBuilder.toString();
        }
        return stringArray;
    }
}
