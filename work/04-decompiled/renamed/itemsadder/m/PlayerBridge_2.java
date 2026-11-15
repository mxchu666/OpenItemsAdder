package itemsadder.m;

import dev.lone.itemsadder.resourcepack.av;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge;
import itemsadder.m.CommandSenderBridge_5;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class PlayerBridge_2
extends CommandSenderBridge {
    public PlayerBridge_2(Plugin plugin, av av2) {
        super(plugin, av2);
    }

    @Override
    public String getName() {
        return "unknown";
    }

    @Override
    @Nullable
    public String Ca() {
        return null;
    }

    @Override
    public void cp(Player player) {
        if (player.isOp()) {
            BukkitTaskBridge.c(() -> this.a(null, (CommandSender)player), 60L);
        }
        CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "[Pack] " + String.valueOf(ChatColor.RED) + "Failed to apply resourcepack to player {player}.".replace("{player}", player.getName()));
        CommandSenderBridge_5.log(String.valueOf(ChatColor.RED) + "You have to setup the resourcepack hosting before using the plugin: https://a.devs.beer/ia-host-pack");
    }

    @Override
    public void bU() {
    }

    @Override
    public void f(PlayerJoinEvent playerJoinEvent) {
        this.cp(playerJoinEvent.getPlayer());
    }

    @Override
    public void a(@Nullable Runnable runnable, CommandSender commandSender) {
        PlayerBridge_2.l(commandSender);
        if (runnable != null) {
            runnable.run();
        }
    }
}
