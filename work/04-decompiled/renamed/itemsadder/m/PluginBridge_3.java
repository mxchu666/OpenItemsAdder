package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.av;
import itemsadder.m.CommandSenderBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PluginBridge_5;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class PluginBridge_3
extends CommandSenderBridge {
    private PluginBridge_5 ayL;

    public PluginBridge_3(Plugin plugin, av av2) {
        super(plugin, av2);
        int n = Main.KO.gW("resource-pack.hosting.self-host.pack-port");
        CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "[Host] Started self-host webserver on port: " + n);
        this.ayL = new PluginBridge_5(plugin, ItemStackRegistry.h(), n);
        this.ayL.f((T bl) -> {
            if (bl.booleanValue()) {
                CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "[Host] Stopped self-host webserver on port: " + n);
            }
        });
    }

    @Override
    public String getName() {
        return "self-host";
    }

    @Override
    public void bU() {
        if (this.ayL != null) {
            this.ayL.bU();
            this.ayL = null;
        }
    }

    @Override
    @Nullable
    public String Ca() {
        return MaterialBarColorHolder.cs;
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
