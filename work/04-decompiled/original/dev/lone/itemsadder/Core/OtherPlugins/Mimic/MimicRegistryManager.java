package dev.lone.itemsadder.Core.OtherPlugins.Mimic;

import dev.lone.itemsadder.Core.OtherPlugins.Mimic.ItemsAdderItemsRegistryCreator;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.ServicePriority;
import ru.endlesscode.mimic.Mimic;
import ru.endlesscode.mimic.MimicApiLevel;
import ru.endlesscode.mimic.items.BukkitItemsRegistry;

public class MimicRegistryManager {
    public static void register(Plugin plugin) {
        if (MimicApiLevel.checkApiLevel((int)3)) {
            Mimic mimic = Mimic.getInstance();
            mimic.registerItemsRegistry((BukkitItemsRegistry)new ItemsAdderItemsRegistryCreator(), 3, plugin);
        } else {
            Bukkit.getServicesManager().register(BukkitItemsRegistry.class, (Object)new ItemsAdderItemsRegistryCreator(), plugin, ServicePriority.Normal);
        }
    }
}
