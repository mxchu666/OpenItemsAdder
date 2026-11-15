package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.z;
import itemsadder.m.ae;
import itemsadder.m.azv;
import itemsadder.m.azw;
import itemsadder.m.azz;
import itemsadder.m.bab;
import itemsadder.m.bac;
import itemsadder.m.bbr;
import itemsadder.m.bce;
import itemsadder.m.bch;
import itemsadder.m.bcp;
import itemsadder.m.d;
import itemsadder.m.yp;
import itemsadder.m.yw;
import itemsadder.m.yz;
import itemsadder.m.za;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class yy
extends za {
    public static volatile boolean SE;

    public yy() {
        Main.cM("iazip").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        yy.a(commandSender, stringArray);
        return true;
    }

    public static void g(CommandSender commandSender) {
        yy.a(commandSender, new String[0]);
    }

    public static void a(CommandSender commandSender, @NotNull String[] stringArray) {
        if (!d.g().B.aB()) {
            yy.a(commandSender, String.valueOf(ChatColor.RED) + "Vanilla assets are not downloaded yet. Please wait.");
            return;
        }
        d d2 = d.g();
        if (SE || yp.SE || d2.t()) {
            yy.a(commandSender, String.valueOf(ChatColor.YELLOW) + "Already reloading... Please wait before using " + String.valueOf(ChatColor.AQUA) + "/iazip");
            return;
        }
        bch bch2 = bch.G(false);
        bch bch3 = bch.G((Object)yz.ALL);
        bch bch4 = bch.G(false);
        bch bch5 = bch.G(false);
        bch bch6 = bch.G(ae.fR);
        bch bch7 = bch.G(-1);
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            if (string.equalsIgnoreCase("--uncompressed")) {
                bch2.H(true);
                continue;
            }
            if (string.equalsIgnoreCase("--apply-to")) {
                if (i + 1 < stringArray.length) {
                    String string2 = stringArray[i + 1];
                    if (string2.equalsIgnoreCase("all")) {
                        bch3.H((Object)yz.ALL);
                        continue;
                    }
                    if (string2.equalsIgnoreCase("none")) {
                        bch3.H((Object)yz.NONE);
                        continue;
                    }
                    if (string2.equalsIgnoreCase("self")) {
                        bch3.H((Object)yz.SELF);
                        continue;
                    }
                    yy.a(commandSender, String.valueOf(ChatColor.RED) + "Invalid argument for --apply-to. Use 'all', 'none', or 'self'.");
                    return;
                }
                yy.a(commandSender, String.valueOf(ChatColor.RED) + "No argument provided for --apply-to.");
                return;
            }
            if (string.equalsIgnoreCase("--skip-recipes")) {
                bch4.H(true);
                bce.d(commandSender, "Skipping recipes reloading.");
                continue;
            }
            if (string.equalsIgnoreCase("--open-ia-menu")) {
                bch5.H(true);
                continue;
            }
            if (!string.equalsIgnoreCase("--check-duplicate-images")) continue;
            bch6.H(true);
        }
        if (!d2.s()) {
            yy.a(commandSender, String.valueOf(ChatColor.YELLOW) + "A resource-pack operation is already running. Please wait before using " + String.valueOf(ChatColor.AQUA) + "/iazip");
            return;
        }
        SE = true;
        try {
            yp.b((Boolean)bch4.aAW, () -> d2.b((Boolean)bch2.aAW, () -> bbr.c("Compressing...", 0.0), bl -> {
                try {
                    if (!bl.booleanValue()) {
                        yy.a(commandSender, String.valueOf(ChatColor.RED) + "Resource-pack generation failed. Check the console for details.");
                        return;
                    }
                    d2.as.aui.a(() -> yy.a(commandSender, (Boolean)bch2.aAW, (yz)((Object)((Object)((Object)((Object)bch3.aAW))))), commandSender);
                    yw.SH.clear();
                    bcp.c(() -> {
                        if (((Boolean)bch2.aAW).booleanValue()) {
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
                    bbr.clear();
                }
            }, d2 -> {
                int n = (int)(d2 * 100.0);
                if (n != (Integer)bch2.aAW) {
                    bch7.H(n);
                    bbr.c("Writing pack archive... " + n + "%", d2);
                }
            }, commandSender instanceof Player ? (Player)commandSender : null));
        }
        catch (Throwable throwable) {
            SE = false;
            d2.u();
            bce.error("Failed to zip resourcepack, uncaught error. Something is probably misconfigured.", throwable);
            bbr.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void a(CommandSender commandSender, Boolean bl, yz yz2) {
        d d2 = d.g();
        try {
            if (d2.as.aui.Cc()) {
                return;
            }
            if (d2.as.aui instanceof azv && ((azv)d2.as.aui).ayJ) {
                return;
            }
            if (d2.as.aui instanceof bac || d2.as.aui instanceof bab || d2.as.aui instanceof azv) {
                switch (yz2.ordinal()) {
                    case 2: {
                        if (!(commandSender instanceof Player)) break;
                        d2.as.aui.cp((Player)commandSender);
                        bce.b(commandSender, String.valueOf(ChatColor.GREEN) + "[Pack] Sent to " + String.valueOf(ChatColor.YELLOW) + commandSender.getName());
                        break;
                    }
                    case 0: {
                        int n2 = d2.as.aui.Cb();
                        bce.b(commandSender, String.valueOf(ChatColor.GREEN) + "[Pack] Sent to " + String.valueOf(ChatColor.YELLOW) + n2 + String.valueOf(ChatColor.GREEN) + " players");
                        break;
                    }
                }
            } else if (d2.as.aui instanceof azw) {
                bce.g(commandSender, "external-pack-host-guide");
                Bukkit.getOnlinePlayers().stream().filter(player -> player.isOp() && player != commandSender).forEach(player -> bce.g((CommandSender)player, "external-pack-host-guide"));
            } else if (d2.as.aui instanceof azz) {
                bce.g(commandSender, "no-host-apply-selected");
                Bukkit.getOnlinePlayers().stream().filter(player -> player.isOp() && player != commandSender).forEach(player -> bce.g((CommandSender)player, "no-host-apply-selected"));
            }
            if (bl.booleanValue()) {
                bce.b(commandSender, String.valueOf(ChatColor.AQUA) + "[Pack] Uncompressing...");
                bbr.in("Uncompressing...");
                File file = d2.as.auh.yz();
                if (file != null && file.exists()) {
                    File file2 = new File(Main.rS().getDataFolder(), "output_uncompressed");
                    z.b(file, file2);
                    bce.b(commandSender, String.valueOf(ChatColor.GREEN) + "[Pack] Uncompressed successfully.");
                }
            }
        }
        finally {
            bbr.clear();
        }
    }
}
