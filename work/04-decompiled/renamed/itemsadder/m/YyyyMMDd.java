package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.Enabled;
import itemsadder.m.Error_3;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.Opaque015;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.ResourceGraphics;
import itemsadder.m.YyyyMMddHHmmss;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.bukkit.ChatColor;

public class YyyyMMDd {
    public static void pt() {
        String string = "conversion_backup_" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        for (PluginFileConfigurationHolder pluginFileConfigurationHolder : ItemStackRegistry.g().b()) {
            List list = pluginFileConfigurationHolder.gR("items");
            if (list == null) {
                if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No item found in file " + pluginFileConfigurationHolder.qd());
                continue;
            }
            YyyyMMDd.a(pluginFileConfigurationHolder, list, string);
        }
    }

    private static void a(PluginFileConfigurationHolder pluginFileConfigurationHolder, List list, String string) {
        Opaque015 opaque015 = null;
        try {
            Enabled enabled = new Enabled(pluginFileConfigurationHolder, list);
            ResourceGraphics resourceGraphics = enabled.qk();
            if (resourceGraphics.isEmpty()) {
                return;
            }
            opaque015 = YyyyMMddHHmmss.f(pluginFileConfigurationHolder.getFile(), string);
            resourceGraphics.qg();
            pluginFileConfigurationHolder.save();
            opaque015.CU();
            CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "[Converter] Successfully converted " + resourceGraphics.size() + " item(s) in file: " + pluginFileConfigurationHolder.nh());
        }
        catch (Error_3 error_3) {
            CommandSenderBridge_5.error("[Converter] Conversion failed, rolling back. File: " + pluginFileConfigurationHolder.nh(), error_3);
            YyyyMMDd.a(pluginFileConfigurationHolder, opaque015);
        }
        catch (Exception exception) {
            CommandSenderBridge_5.error("[Converter] Unexpected error during conversion, rolling back. File: " + pluginFileConfigurationHolder.nh(), exception);
            YyyyMMDd.a(pluginFileConfigurationHolder, opaque015);
        }
    }

    private static void a(PluginFileConfigurationHolder pluginFileConfigurationHolder, Opaque015 opaque015) {
        if (opaque015 == null) {
            return;
        }
        try {
            opaque015.CT();
            pluginFileConfigurationHolder.reload();
            CommandSenderBridge_5.warn("[Converter] Rolled back changes for file: " + pluginFileConfigurationHolder.nh());
        }
        catch (Exception exception) {
            CommandSenderBridge_5.error("[Converter] Failed to rollback file: " + pluginFileConfigurationHolder.nh(), exception);
        }
    }
}
