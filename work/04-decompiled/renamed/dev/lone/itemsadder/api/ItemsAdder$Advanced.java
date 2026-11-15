package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.ItemsAdder$Advanced;
import dev.lone.itemsadder.api.ItemsAdder$Advanced$InjectedItemModifier;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBlockDataHolder;
import itemsadder.m.RealEnum;
import itemsadder.m.VersionHelper_3;
import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class ItemsAdder$Advanced {
    @Nullable
    public static BlockData getBlockDataByInternalId(int n) {
        RealEnum realEnum = MaterialBlockDataHolder.ap(n);
        switch (realEnum) {
            case REAL: 
            case REAL_TRANSPARENT: {
                Material material = MaterialBlockDataHolder.ao(n);
                return MaterialBlockDataHolder.a(n, null, material);
            }
            case REAL_NOTE: {
                return MaterialBlockDataHolder.ar(n);
            }
            case REAL_WIRE: {
                return MaterialBlockDataHolder.aq(n);
            }
        }
        return null;
    }

    public static void injectItemModifier(Plugin plugin, String string2, ModifierHandler modifierHandler) {
        if (!VersionHelper_3.f(plugin)) {
            throw new RuntimeException("This method can be called only from onEnable or onLoad methods!");
        }
        ItemStackRegistry.ai.computeIfAbsent(string2, string -> new ArrayList()).add(new ItemsAdder$Advanced$InjectedItemModifier(plugin.getName(), null, modifierHandler));
    }

    public static void injectItemModifier(Plugin plugin, ModifierHandler modifierHandler) {
        if (!VersionHelper_3.f(plugin)) {
            throw new RuntimeException("This method can be called only from onEnable or onLoad methods!");
        }
        ItemStackRegistry.aj.add(new ItemsAdder$Advanced$InjectedItemModifier(plugin.getName(), null, modifierHandler));
    }

    @Nullable
    public static String getItemModelResourceLocation(String string) {
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().b(string, false);
        if (itemStackBuilder_4 == null) {
            return null;
        }
        return itemStackBuilder_4.d(true, true);
    }
}
