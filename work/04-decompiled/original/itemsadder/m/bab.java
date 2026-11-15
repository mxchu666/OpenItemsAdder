package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.av;
import itemsadder.m.ae;
import itemsadder.m.azu;
import itemsadder.m.bar;
import itemsadder.m.bce;
import itemsadder.m.d;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class bab
extends azu {
    private bar ayL;

    public bab(Plugin plugin, av av2) {
        super(plugin, av2);
        int n = Main.KO.gW("resource-pack.hosting.self-host.pack-port");
        bce.log(String.valueOf(ChatColor.AQUA) + "[Host] Started self-host webserver on port: " + n);
        this.ayL = new bar(plugin, d.h(), n);
        this.ayL.f((T bl) -> {
            if (bl.booleanValue()) {
                bce.log(String.valueOf(ChatColor.AQUA) + "[Host] Stopped self-host webserver on port: " + n);
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
        return ae.cs;
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
        if (!d.g().as.auh.yB()) {
            azu.m(commandSender);
            return;
        }
        this.hash = this.ayx.auh.yF();
        this.go(this.hash);
        if (!this.ayB) {
            this.BZ();
            azu.k(commandSender);
        }
        if (runnable != null) {
            runnable.run();
        }
    }
}
