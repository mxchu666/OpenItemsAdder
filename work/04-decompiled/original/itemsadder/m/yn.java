package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.za;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class yn
extends za {
    public yn() {
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
                    bce.g(commandSender, "player-offline");
                    return true;
                }
                if (d.g().an.a(player, stringArray[2])) {
                    String string2 = "" + d.g().an.b(player, stringArray[2], 0.0f);
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
                    bce.g(commandSender, "player-offline");
                    return true;
                }
                boolean bl = stringArray[stringArray.length - 1].equals("silent");
                if (d.g().an.a(player, stringArray[2])) {
                    if (d.g().ao.a(stringArray[2], player)) {
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
                    d.g().ao.c(player, stringArray[2], Float.valueOf(stringArray[3]).floatValue());
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
                    bce.g(commandSender, "player-offline");
                    return true;
                }
                boolean bl = stringArray[stringArray.length - 1].equals("silent");
                if (d.g().an.a(player, stringArray[2])) {
                    if (d.g().ao.a(stringArray[2], player)) {
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
                    float f2 = yn.b(stringArray, 3);
                    if (stringArray[0].equalsIgnoreCase("decrement")) {
                        f2 = -f2;
                    }
                    d.g().ao.c(player, stringArray[2], d.g().an.b(player, stringArray[2], 0.0f) + f2);
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
