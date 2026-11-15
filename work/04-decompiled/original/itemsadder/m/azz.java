package itemsadder.m;

import dev.lone.itemsadder.resourcepack.av;
import itemsadder.m.azu;
import itemsadder.m.bce;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class azz
extends azu {
    public azz(Plugin plugin, av av2) {
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
        bce.g((CommandSender)player, "no-host-apply-selected");
    }

    @Override
    public void bU() {
    }

    @Override
    public void a(@Nullable Runnable runnable, CommandSender commandSender) {
        if (runnable != null) {
            runnable.run();
        }
        azu.k(commandSender);
    }
}
