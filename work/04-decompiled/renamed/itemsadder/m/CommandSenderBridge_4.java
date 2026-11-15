package itemsadder.m;

import dev.lone.itemsadder.resourcepack.av;
import itemsadder.m.CommandSenderBridge;
import itemsadder.m.CommandSenderBridge_5;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class CommandSenderBridge_4
extends CommandSenderBridge {
    public CommandSenderBridge_4(Plugin plugin, av av2) {
        super(plugin, av2);
        this.Ci();
    }

    @Override
    public String getName() {
        return "auto-external-legacy";
    }

    private void Ci() {
        CommandSenderBridge_5.error("");
        CommandSenderBridge_5.error("");
        CommandSenderBridge_5.error("ERROR: auto-external-host won't work anymore because the hosting platform (PloudOS) is shutting down.");
        CommandSenderBridge_5.error("Use another hosting method: https://a.devs.beer/ia-host-pack");
        CommandSenderBridge_5.error("I do not own PloudOS so I cannot do anything, thanks for the patience.");
        CommandSenderBridge_5.error("");
        CommandSenderBridge_5.error("");
    }

    @Override
    public void bU() {
    }

    @Override
    public boolean j(CommandSender commandSender) {
        return false;
    }

    @Override
    public void cp(Player player) {
        this.Ci();
    }

    @Override
    @Nullable
    public String Ca() {
        return null;
    }

    @Override
    public void a(@Nullable Runnable runnable, CommandSender commandSender) {
    }

    @Override
    public void f(PlayerJoinEvent playerJoinEvent) {
    }
}
