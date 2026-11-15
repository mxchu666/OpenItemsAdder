package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.z;
import itemsadder.m.AllEnum;
import itemsadder.m.BossBarBridge_2;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_2;
import itemsadder.m.CommandSenderBridge_3;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.IareloadCommand;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque020;
import itemsadder.m.PlayerQuitListener_5;
import itemsadder.m.PluginBridge_2;
import itemsadder.m.PluginBridge_3;
import itemsadder.m.PluginBridge_4;
import itemsadder.m.PluginCommand_2;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class IazipCommand
extends PluginCommand_2 {
    public static volatile boolean SE;

    public IazipCommand() {
        Main.cM("iazip").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        IazipCommand.a(commandSender, stringArray);
        return true;
    }

    public static void g(CommandSender commandSender) {
        IazipCommand.a(commandSender, new String[0]);
    }

    public static void a(CommandSender commandSender, @NotNull String[] stringArray) {
        if (!ItemStackRegistry.g().B.aB()) {
            IazipCommand.a(commandSender, String.valueOf(ChatColor.RED) + "Vanilla assets are not downloaded yet. Please wait.");
            return;
        }
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        if (SE || IareloadCommand.SE || itemStackRegistry.t()) {
            IazipCommand.a(commandSender, String.valueOf(ChatColor.YELLOW) + "Already reloading... Please wait before using " + String.valueOf(ChatColor.AQUA) + "/iazip");
            return;
        }
        Opaque020 opaque020 = Opaque020.G(false);
        Opaque020 opaque0202 = Opaque020.G((Object)AllEnum.ALL);
        Opaque020 opaque0203 = Opaque020.G(false);
        Opaque020 opaque0204 = Opaque020.G(false);
        Opaque020 opaque0205 = Opaque020.G(MaterialBarColorHolder.fR);
        Opaque020 opaque0206 = Opaque020.G(-1);
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            if (string.equalsIgnoreCase("--uncompressed")) {
                opaque020.H(true);
                continue;
            }
            if (string.equalsIgnoreCase("--apply-to")) {
                if (i + 1 < stringArray.length) {
                    String string2 = stringArray[i + 1];
                    if (string2.equalsIgnoreCase("all")) {
                        opaque0202.H((Object)AllEnum.ALL);
                        continue;
                    }
                    if (string2.equalsIgnoreCase("none")) {
                        opaque0202.H((Object)AllEnum.NONE);
                        continue;
                    }
                    if (string2.equalsIgnoreCase("self")) {
                        opaque0202.H((Object)AllEnum.SELF);
                        continue;
                    }
                    IazipCommand.a(commandSender, String.valueOf(ChatColor.RED) + "Invalid argument for --apply-to. Use 'all', 'none', or 'self'.");
                    return;
                }
                IazipCommand.a(commandSender, String.valueOf(ChatColor.RED) + "No argument provided for --apply-to.");
                return;
            }
            if (string.equalsIgnoreCase("--skip-recipes")) {
                opaque0203.H(true);
                CommandSenderBridge_5.d(commandSender, "Skipping recipes reloading.");
                continue;
            }
            if (string.equalsIgnoreCase("--open-ia-menu")) {
                opaque0204.H(true);
                continue;
            }
            if (!string.equalsIgnoreCase("--check-duplicate-images")) continue;
            opaque0205.H(true);
        }
        if (!itemStackRegistry.s()) {
            IazipCommand.a(commandSender, String.valueOf(ChatColor.YELLOW) + "A resource-pack operation is already running. Please wait before using " + String.valueOf(ChatColor.AQUA) + "/iazip");
            return;
        }
        SE = true;
        try {
            IareloadCommand.b((Boolean)opaque0203.aAW, () -> itemStackRegistry.b((Boolean)opaque020.aAW, () -> BossBarBridge_2.c("Compressing...", 0.0), bl -> {
                try {
                    if (!bl.booleanValue()) {
                        IazipCommand.a(commandSender, String.valueOf(ChatColor.RED) + "Resource-pack generation failed. Check the console for details.");
                        return;
                    }
                    itemStackRegistry.as.aui.a(() -> IazipCommand.a(commandSender, (Boolean)opaque020.aAW, (AllEnum)((Object)((Object)((Object)((Object)opaque0202.aAW))))), commandSender);
                    PlayerQuitListener_5.SH.clear();
                    BukkitTaskBridge.c(() -> {
                        if (((Boolean)opaque020.aAW).booleanValue()) {
                            if (commandSender instanceof Player) {
                                Player player = (Player)commandSender;
                                player.performCommand("ia");
                            } else {
                                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                                    player.performCommand("ia");
                                }
                            }
                        }
                    }, 20L);
                }
                finally {
                    SE = false;
                    BossBarBridge_2.clear();
                }
            }, d -> {
                int n = (int)(d * 100.0);
                if (n != (Integer)opaque020.aAW) {
                    opaque0206.H(n);
                    BossBarBridge_2.c("Writing pack archive... " + n + "%", d);
                }
            }, commandSender instanceof Player ? (Player)commandSender : null));
        }
        catch (Throwable throwable) {
            SE = false;
            itemStackRegistry.u();
            CommandSenderBridge_5.error("Failed to zip resourcepack, uncaught error. Something is probably misconfigured.", throwable);
            BossBarBridge_2.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void a(CommandSender commandSender, Boolean bl, AllEnum allEnum) {
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        try {
            if (itemStackRegistry.as.aui.Cc()) {
                return;
            }
            if (itemStackRegistry.as.aui instanceof CommandSenderBridge_2 && ((CommandSenderBridge_2)itemStackRegistry.as.aui).ayJ) {
                return;
            }
            if (itemStackRegistry.as.aui instanceof PluginBridge_4 || itemStackRegistry.as.aui instanceof PluginBridge_3 || itemStackRegistry.as.aui instanceof CommandSenderBridge_2) {
                switch (allEnum.ordinal()) {
                    case 2: {
                        if (!(commandSender instanceof Player)) break;
                        itemStackRegistry.as.aui.cp((Player)commandSender);
                        CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.GREEN) + "[Pack] Sent to " + String.valueOf(ChatColor.YELLOW) + commandSender.getName());
                        break;
                    }
                    case 0: {
                        int n2 = itemStackRegistry.as.aui.Cb();
                        CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.GREEN) + "[Pack] Sent to " + String.valueOf(ChatColor.YELLOW) + n2 + String.valueOf(ChatColor.GREEN) + " players");
                        break;
                    }
                }
            } else if (itemStackRegistry.as.aui instanceof CommandSenderBridge_3) {
                CommandSenderBridge_5.g(commandSender, "external-pack-host-guide");
                Bukkit.getOnlinePlayers().stream().filter(player -> player.isOp() && player != commandSender).forEach(player -> CommandSenderBridge_5.g((CommandSender)player, "external-pack-host-guide"));
            } else if (itemStackRegistry.as.aui instanceof PluginBridge_2) {
                CommandSenderBridge_5.g(commandSender, "no-host-apply-selected");
                Bukkit.getOnlinePlayers().stream().filter(player -> player.isOp() && player != commandSender).forEach(player -> CommandSenderBridge_5.g((CommandSender)player, "no-host-apply-selected"));
            }
            if (bl.booleanValue()) {
                CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.AQUA) + "[Pack] Uncompressing...");
                BossBarBridge_2.in("Uncompressing...");
                File file = itemStackRegistry.as.auh.yz();
                if (file != null && file.exists()) {
                    File file2 = new File(Main.rS().getDataFolder(), "output_uncompressed");
                    z.b(file, file2);
                    CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.GREEN) + "[Pack] Uncompressed successfully.");
                }
            }
        }
        finally {
            BossBarBridge_2.clear();
        }
    }
}
