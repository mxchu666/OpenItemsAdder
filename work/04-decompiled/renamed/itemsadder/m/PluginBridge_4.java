package itemsadder.m;

import dev.lone.itemsadder.resourcepack.av;
import itemsadder.m.CommandSenderBridge;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ItemsadderHttpPacket;
import itemsadder.m.MaterialBarColorHolder;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class PluginBridge_4
extends CommandSenderBridge {
    public PluginBridge_4(Plugin plugin, av av2) {
        super(plugin, av2);
        ItemsadderHttpPacket.Ck();
    }

    @Override
    public String getName() {
        return "simple-self-host";
    }

    @Override
    public void bU() {
        ItemsadderHttpPacket.Cl();
    }

    @Override
    @Nullable
    public String Ca() {
        return MaterialBarColorHolder.co;
    }

    @Override
    public void cp(Player player) {
        if (!this.cr(player)) {
            return;
        }
        this.cs(player);
    }

    @Override
    public void a(@Nullable Runnable runnable, CommandSender commandSender) {
        this.ayy = null;
        if (this.a(true, commandSender)) {
            return;
        }
        if (!ItemStackRegistry.g().as.auh.yB()) {
            CommandSenderBridge.m(commandSender);
            return;
        }
        this.hash = this.ayx.auh.yF();
        this.go(this.hash);
        if (!this.ayB) {
            this.BZ();
            CommandSenderBridge.k(commandSender);
        }
        if (runnable != null) {
            runnable.run();
        }
    }
}
