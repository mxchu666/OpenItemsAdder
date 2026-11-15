package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.BossBarBridge_2;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.HandlerListBridge_2;
import itemsadder.m.InfoNamespace_3;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationEquipmentSlotHolder;
import itemsadder.m.Opaque020;
import itemsadder.m.PlayerQuitListener_5;
import itemsadder.m.PluginCommand_2;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IareloadCommand
extends PluginCommand_2 {
    public static volatile boolean SE;

    public IareloadCommand() {
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
        LocationEquipmentSlotHolder.Xq.asMap().clear();
        if (!ItemStackRegistry.g().B.aB()) {
            IareloadCommand.a(commandSender, String.valueOf(ChatColor.RED) + "Vanilla assets are not downloaded yet. Please wait.");
            return true;
        }
        if (SE || ItemStackRegistry.g().t()) {
            IareloadCommand.a(commandSender, String.valueOf(ChatColor.YELLOW) + "Already reloading... Please wait before using " + String.valueOf(ChatColor.AQUA) + "/" + command.getName());
            return true;
        }
        if (!s.c((Permissible)commandSender, "ia.admin.iareload")) {
            return true;
        }
        if (ItemStackRegistry.g().H().lK() || ItemStackRegistry.g().H() != null && ItemStackRegistry.g().H().lK()) {
            IareloadCommand.a(commandSender, String.valueOf(ChatColor.YELLOW) + "Saving regions data... Please wait before using " + String.valueOf(ChatColor.AQUA) + "/" + command.getName());
            return true;
        }
        CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "Reloading...");
        boolean bl2 = bl = stringArray.length > 0 && stringArray[0].equalsIgnoreCase("--scripts-only");
        if (bl) {
            SE = true;
            try {
                IareloadCommand.a(commandSender, String.valueOf(ChatColor.YELLOW) + "Reloading scripts...");
                InfoNamespace_3.az(true);
                IareloadCommand.a(commandSender, String.valueOf(ChatColor.GREEN) + "Reload completed.");
                boolean bl3 = true;
                return bl3;
            }
            finally {
                SE = false;
                BossBarBridge_2.clear();
            }
        }
        Opaque020 opaque020 = Opaque020.G(false);
        for (n = 0; n < stringArray.length; ++n) {
            String string2 = stringArray[n];
            if (!string2.equalsIgnoreCase("--skip-recipes")) continue;
            opaque020.H(true);
            CommandSenderBridge_5.d(commandSender, "Skipping recipes reloading.");
        }
        try {
            ListenerBridge.b(new HandlerListBridge_2());
            n = IareloadCommand.a((Boolean)opaque020.aAW, () -> {
                ItemStackRegistry.g().as.aui.a(null, commandSender);
                PlayerQuitListener_5.SH.clear();
                IareloadCommand.a(commandSender, String.valueOf(ChatColor.GREEN) + "Reload completed.");
                BossBarBridge_2.clear();
            }) ? 1 : 0;
            if (n == 0) {
                IareloadCommand.a(commandSender, String.valueOf(ChatColor.YELLOW) + "A resource-pack operation is already running. Please wait before using " + String.valueOf(ChatColor.AQUA) + "/" + command.getName());
            }
        }
        catch (Exception exception) {
            SE = false;
            BossBarBridge_2.clear();
            exception.printStackTrace();
            CommandSenderBridge_5.error("Failed to reload the plugin. Please check before this message for more information.");
        }
        return true;
    }

    public static boolean a(boolean bl, @Nullable Runnable runnable) {
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        if (!itemStackRegistry.s()) {
            return false;
        }
        SE = true;
        try {
            IareloadCommand.b(bl, () -> {
                try {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                finally {
                    SE = false;
                    itemStackRegistry.u();
                }
            });
            return true;
        }
        catch (Error | RuntimeException throwable) {
            SE = false;
            itemStackRegistry.u();
            BossBarBridge_2.clear();
            throw throwable;
        }
    }

    static void b(boolean bl, @Nullable Runnable runnable) {
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        Main.rS().rY();
        itemStackRegistry.a(true);
        itemStackRegistry.a(runnable, bl, true);
    }
}
