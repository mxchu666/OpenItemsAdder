package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.adq;
import itemsadder.m.bbr;
import itemsadder.m.bce;
import itemsadder.m.bch;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.fu;
import itemsadder.m.te;
import itemsadder.m.yw;
import itemsadder.m.za;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class yp
extends za {
    public static volatile boolean SE;

    public yp() {
        Main.cM("iareload").setExecutor((CommandExecutor)this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        int n;
        boolean bl;
        if (!this.a(commandSender, command)) {
            return true;
        }
        adq.Xq.asMap().clear();
        if (!d.g().B.aB()) {
            yp.a(commandSender, String.valueOf(ChatColor.RED) + "Vanilla assets are not downloaded yet. Please wait.");
            return true;
        }
        if (SE || d.g().t()) {
            yp.a(commandSender, String.valueOf(ChatColor.YELLOW) + "Already reloading... Please wait before using " + String.valueOf(ChatColor.AQUA) + "/" + command.getName());
            return true;
        }
        if (!s.c((Permissible)commandSender, "ia.admin.iareload")) {
            return true;
        }
        if (d.g().H().lK() || d.g().H() != null && d.g().H().lK()) {
            yp.a(commandSender, String.valueOf(ChatColor.YELLOW) + "Saving regions data... Please wait before using " + String.valueOf(ChatColor.AQUA) + "/" + command.getName());
            return true;
        }
        bce.log(String.valueOf(ChatColor.YELLOW) + "Reloading...");
        boolean bl2 = bl = stringArray.length > 0 && stringArray[0].equalsIgnoreCase("--scripts-only");
        if (bl) {
            SE = true;
            try {
                yp.a(commandSender, String.valueOf(ChatColor.YELLOW) + "Reloading scripts...");
                te.az(true);
                yp.a(commandSender, String.valueOf(ChatColor.GREEN) + "Reload completed.");
                boolean bl3 = true;
                return bl3;
            }
            finally {
                SE = false;
                bbr.clear();
            }
        }
        bch bch2 = bch.G(false);
        for (n = 0; n < stringArray.length; ++n) {
            String string2 = stringArray[n];
            if (!string2.equalsIgnoreCase("--skip-recipes")) continue;
            bch2.H(true);
            bce.d(commandSender, "Skipping recipes reloading.");
        }
        try {
            bev.b(new fu());
            n = yp.a((Boolean)bch2.aAW, () -> {
                d.g().as.aui.a(null, commandSender);
                yw.SH.clear();
                yp.a(commandSender, String.valueOf(ChatColor.GREEN) + "Reload completed.");
                bbr.clear();
            }) ? 1 : 0;
            if (n == 0) {
                yp.a(commandSender, String.valueOf(ChatColor.YELLOW) + "A resource-pack operation is already running. Please wait before using " + String.valueOf(ChatColor.AQUA) + "/" + command.getName());
            }
        }
        catch (Exception exception) {
            SE = false;
            bbr.clear();
            exception.printStackTrace();
            bce.error("Failed to reload the plugin. Please check before this message for more information.");
        }
        return true;
    }

    public static boolean a(boolean bl, @Nullable Runnable runnable) {
        d d2 = d.g();
        if (!d2.s()) {
            return false;
        }
        SE = true;
        try {
            yp.b(bl, () -> {
                try {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                finally {
                    SE = false;
                    d2.u();
                }
            });
            return true;
        }
        catch (Error | RuntimeException throwable) {
            SE = false;
            d2.u();
            bbr.clear();
            throw throwable;
        }
    }

    static void b(boolean bl, @Nullable Runnable runnable) {
        d d2 = d.g();
        Main.rS().rY();
        d2.a(true);
        d2.a(runnable, bl, true);
    }
}
