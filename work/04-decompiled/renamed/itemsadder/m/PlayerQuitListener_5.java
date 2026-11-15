package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PluginCommand_2;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.WeakHashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.Permissible;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class PlayerQuitListener_5
extends PluginCommand_2
implements Listener {
    public static WeakHashMap SH = new WeakHashMap();
    private final long SI = (long)Main.KO.t("resource-pack.command.usage-cooldown-seconds", 0) * 1000L;

    public PlayerQuitListener_5() {
        Main.cM("iatexture").setExecutor((CommandExecutor)this);
        ListenerBridge.a(this, (Plugin)Main.rS());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (stringArray.length > 0) {
            if (s.c((Permissible)commandSender, "ia.user.iatexture.all")) {
                if (stringArray[0].equals("all")) {
                    CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "[Pack] Applying every player... ");
                    int n = ItemStackRegistry.g().as.aui.Cb();
                    CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "[Pack] Applied to " + String.valueOf(ChatColor.YELLOW) + n + String.valueOf(ChatColor.GREEN) + " players");
                } else {
                    Player player = Bukkit.getPlayer((String)stringArray[0]);
                    if (player == null) {
                        CommandSenderBridge_5.f(commandSender, Main.PQ.ir("player-offline"));
                        return true;
                    }
                    this.bs(player);
                }
            }
        } else {
            if (this.SI > 0L && SH.containsKey(commandSender) && System.currentTimeMillis() - (Long)SH.get(commandSender) < this.SI) {
                String string2 = new SimpleDateFormat("mm:ss").format(new Date(this.SI - (System.currentTimeMillis() - (Long)SH.get(commandSender))));
                CommandSenderBridge_5.f(commandSender, Main.PQ.ir("please-wait-command-cooldown").replace("{interval}", string2));
                return true;
            }
            if (commandSender instanceof Player) {
                this.bs((Player)commandSender);
                SH.put(commandSender, System.currentTimeMillis());
            } else {
                commandSender.sendMessage(Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iatexture [all|player]. Example: /iatexture all");
                CommandSenderBridge_5.iy("command-ingame-only");
            }
        }
        return true;
    }

    private void bs(Player player) {
        ItemStackRegistry.g().as.aui.cp(player);
    }

    @EventHandler
    private void a(PlayerQuitEvent playerQuitEvent) {
        SH.remove(playerQuitEvent.getPlayer());
    }
}
