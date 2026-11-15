package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PluginCommand_2;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class IaplayerstatCommand
extends PluginCommand_2 {
    public IaplayerstatCommand() {
        Main.cM("iaplayerstat").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (stringArray.length == 3) {
            if (stringArray[0].equalsIgnoreCase("read")) {
                if (!s.c((Permissible)commandSender, "ia.admin.iaplayerstat.read")) {
                    return true;
                }
                Player player = Bukkit.getPlayer((String)stringArray[1]);
                if (player == null) {
                    CommandSenderBridge_5.g(commandSender, "player-offline");
                    return true;
                }
                if (ItemStackRegistry.g().an.a(player, stringArray[2])) {
                    String string2 = "" + ItemStackRegistry.g().an.b(player, stringArray[2], 0.0f);
                    commandSender.sendMessage(Main.PQ.ir("player-stat-value-read").replace("{value}", string2));
                } else {
                    commandSender.sendMessage(Main.PQ.ir("player-stat-value-read").replace("{value}", String.valueOf(ChatColor.WHITE) + "stat " + String.valueOf(ChatColor.AQUA) + stringArray[2] + String.valueOf(ChatColor.WHITE) + " not found"));
                }
                return true;
            }
        } else if (stringArray.length >= 4) {
            if (stringArray[0].equalsIgnoreCase("write")) {
                if (!s.c((Permissible)commandSender, "ia.admin.iaplayerstat.write")) {
                    return true;
                }
                Player player = Bukkit.getPlayer((String)stringArray[1]);
                if (player == null) {
                    CommandSenderBridge_5.g(commandSender, "player-offline");
                    return true;
                }
                boolean bl = stringArray[stringArray.length - 1].equals("silent");
                if (ItemStackRegistry.g().an.a(player, stringArray[2])) {
                    if (ItemStackRegistry.g().ao.a(stringArray[2], player)) {
                        if (player != commandSender) {
                            if (!bl) {
                                commandSender.sendMessage(Main.PQ.ir("player-stat-value-write-bypass"));
                            }
                            return true;
                        }
                        if (!bl) {
                            commandSender.sendMessage(Main.PQ.ir("player-stat-value-write-bypass-self"));
                        }
                    }
                    ItemStackRegistry.g().ao.c(player, stringArray[2], Float.valueOf(stringArray[3]).floatValue());
                    if (!bl) {
                        commandSender.sendMessage(Main.PQ.ir("player-stat-value-write"));
                    }
                } else if (!bl) {
                    commandSender.sendMessage(Main.PQ.ir("player-stat-value-read").replace("{value}", String.valueOf(ChatColor.WHITE) + "stat " + String.valueOf(ChatColor.AQUA) + stringArray[2] + String.valueOf(ChatColor.WHITE) + " not found"));
                }
            } else if (stringArray[0].equalsIgnoreCase("increment") || stringArray[0].equalsIgnoreCase("decrement")) {
                if (!s.c((Permissible)commandSender, "ia.admin.iaplayerstat.write")) {
                    return true;
                }
                Player player = Bukkit.getPlayer((String)stringArray[1]);
                if (player == null) {
                    CommandSenderBridge_5.g(commandSender, "player-offline");
                    return true;
                }
                boolean bl = stringArray[stringArray.length - 1].equals("silent");
                if (ItemStackRegistry.g().an.a(player, stringArray[2])) {
                    if (ItemStackRegistry.g().ao.a(stringArray[2], player)) {
                        if (player != commandSender) {
                            if (!bl) {
                                commandSender.sendMessage(Main.PQ.ir("player-stat-value-write-bypass"));
                            }
                            return true;
                        }
                        if (!bl) {
                            commandSender.sendMessage(Main.PQ.ir("player-stat-value-write-bypass-self"));
                        }
                    }
                    float f = IaplayerstatCommand.b(stringArray, 3);
                    if (stringArray[0].equalsIgnoreCase("decrement")) {
                        f = -f;
                    }
                    ItemStackRegistry.g().ao.c(player, stringArray[2], ItemStackRegistry.g().an.b(player, stringArray[2], 0.0f) + f);
                    if (!bl) {
                        commandSender.sendMessage(Main.PQ.ir("player-stat-value-write"));
                    }
                } else if (!bl) {
                    commandSender.sendMessage(Main.PQ.ir("player-stat-value-not-found").replace("{value}", stringArray[2]));
                }
            }
            return true;
        }
        commandSender.sendMessage(Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iaplayerstat <read|write|increment|decrement> <player> <attribute> [value]");
        return true;
    }

    private static float b(String[] stringArray, int n) {
        try {
            return Float.valueOf(stringArray[n]).floatValue();
        }
        catch (Exception exception) {
            return 1.0f;
        }
    }
}
