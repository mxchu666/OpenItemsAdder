package itemsadder.m;

import dev.lone.itemsadder.resourcepack.av;
import itemsadder.m.ae;
import itemsadder.m.azu;
import itemsadder.m.bak;
import itemsadder.m.d;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class bac
extends azu {
    public bac(Plugin plugin, av av2) {
        super(plugin, av2);
        bak.Ck();
    }

    @Override
    public String getName() {
        return "simple-self-host";
    }

    @Override
    public void bU() {
        bak.Cl();
    }

    @Override
    @Nullable
    public String Ca() {
        return ae.co;
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
