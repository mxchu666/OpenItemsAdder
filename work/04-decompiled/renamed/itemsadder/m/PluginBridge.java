package itemsadder.m;

import dev.lone.itemsadder.resourcepack.av;
import itemsadder.m.BossBarBridge;
import itemsadder.m.CommandSenderBridge_2;
import org.bukkit.plugin.Plugin;

public class PluginBridge
extends CommandSenderBridge_2 {
    public PluginBridge(Plugin plugin, av av2) {
        super(plugin, "lobfile", av2, "https://lobfile.com/privacy-policy", "lobfile");
        this.a(new BossBarBridge());
    }
}
