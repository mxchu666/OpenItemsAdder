package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.ItemsAdder$Advanced;
import dev.lone.itemsadder.api.ItemsAdder$Advanced$InjectedItemModifier;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.rz;
import itemsadder.m.sd;
import itemsadder.m.zw;
import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class ItemsAdder$Advanced {
    @Nullable
    public static BlockData getBlockDataByInternalId(int n) {
        sd sd2 = rz.ap(n);
        switch (sd2) {
            case REAL: 
            case REAL_TRANSPARENT: {
                Material material = rz.ao(n);
                return rz.a(n, null, material);
            }
            case REAL_NOTE: {
                return rz.ar(n);
            }
            case REAL_WIRE: {
                return rz.aq(n);
            }
        }
        return null;
    }

    public static void injectItemModifier(Plugin plugin, String string2, ModifierHandler modifierHandler) {
        if (!zw.f(plugin)) {
            throw new RuntimeException("This method can be called only from onEnable or onLoad methods!");
        }
        d.ai.computeIfAbsent(string2, string -> new ArrayList()).add(new ItemsAdder$Advanced$InjectedItemModifier(plugin.getName(), null, modifierHandler));
    }

    public static void injectItemModifier(Plugin plugin, ModifierHandler modifierHandler) {
        if (!zw.f(plugin)) {
            throw new RuntimeException("This method can be called only from onEnable or onLoad methods!");
        }
        d.aj.add(new ItemsAdder$Advanced$InjectedItemModifier(plugin.getName(), null, modifierHandler));
    }

    @Nullable
    public static String getItemModelResourceLocation(String string) {
        qm qm2 = d.g().b(string, false);
        if (qm2 == null) {
            return null;
        }
        return qm2.d(true, true);
    }
}
