package itemsadder.m;

import dev.lone.itemsadder.resourcepack.av;
import itemsadder.m.CommandSenderBridge;
import itemsadder.m.CommandSenderBridge_5;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class PluginBridge_2
extends CommandSenderBridge {
    public PluginBridge_2(Plugin plugin, av av2) {
        super(plugin, av2);
    }

    @Override
    public String getName() {
        return "no-host";
    }

    @Override
    @Nullable
    public String Ca() {
        return null;
    }

    @Override
    public void cp(Player player) {
        if (!this.cr(player)) {
            return;
        }
        CommandSenderBridge_5.g((CommandSender)player, "no-host-apply-selected");
    }

    @Override
    public void bU() {
    }

    @Override
    public void a(@Nullable Runnable runnable, CommandSender commandSender) {
        if (runnable != null) {
            runnable.run();
        }
        CommandSenderBridge.k(commandSender);
    }
}
