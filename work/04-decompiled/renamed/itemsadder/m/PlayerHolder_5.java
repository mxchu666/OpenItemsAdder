package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.NmsWrapperFactory;
import itemsadder.m.PlayerQuitListenerBase;
import itemsadder.m.TriedLoadUnrecognized;
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

public final class PlayerHolder_5 {
    private final PlayerQuitListenerBase amr = (PlayerQuitListenerBase)NmsWrapperFactory.n(PlayerQuitListenerBase.class);
    private static PlayerHolder_5 ams;

    PlayerHolder_5() {
    }

    public static void a(Player player, LinkedList linkedList) {
        if (linkedList != null && !linkedList.isEmpty()) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            for (NamespacedKeyItemStackHolder namespacedKeyItemStackHolder : linkedList) {
                if (!s.a((HumanEntity)player, namespacedKeyItemStackHolder)) continue;
                arrayList.add(namespacedKeyItemStackHolder.Hg);
            }
            if (!arrayList.isEmpty()) {
                PlayerHolder_5.c(player, arrayList);
            }
        }
    }

    public static void e(Player player, NamespacedKeyItemStackHolder namespacedKeyItemStackHolder) {
        PlayerHolder_5.a(player, namespacedKeyItemStackHolder, true);
    }

    public static void a(Player player, NamespacedKeyItemStackHolder namespacedKeyItemStackHolder, boolean bl) {
        if (namespacedKeyItemStackHolder != null && (!bl || s.a((HumanEntity)player, namespacedKeyItemStackHolder))) {
            PlayerHolder_5.c(player, Collections.singletonList(namespacedKeyItemStackHolder.Hg));
        }
    }

    public static void cg(Player player) {
        PlayerHolder_5.vq().b(player, ItemStackRegistry.g().aW.qY());
    }

    public static void c(Player player, List list) {
        PlayerHolder_5.vq().b(player, list);
    }

    private void register() {
        if (this.amr != null) {
            this.amr.register();
        } else {
            CommandSenderBridge_5.error("Failed to register VanillaRecipebook");
        }
    }

    private static PlayerHolder_5 vp() {
        if (ams == null) {
            ams = new PlayerHolder_5();
        }
        return ams;
    }

    public static PlayerQuitListenerBase vq() {
        return PlayerHolder_5.vp().amr;
    }

    public static void vr() {
        PlayerHolder_5.unregister();
        PlayerHolder_5.vs();
        PlayerHolder_5 playerHolder_5 = PlayerHolder_5.vp();
        playerHolder_5.register();
    }

    public static void unregister() {
        if (ams != null && PlayerHolder_5.ams.amr != null) {
            PlayerHolder_5.ams.amr.unregister();
        }
        PlayerHolder_5.vt();
    }

    private static void vs() {
        if (Main.KO.z("recipes.hide-vanilla-unrecognized-recipe-errors", true)) {
            ((Logger)LogManager.getRootLogger()).addFilter((Filter)new TriedLoadUnrecognized());
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
