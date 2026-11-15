package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.PluginCommand_2;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class IadropCommand
extends PluginCommand_2 {
    public IadropCommand() {
        Main.cM("iadrop").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string2, @NotNull String[] stringArray) {
        Location location;
        boolean bl;
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!PluginCommand_2.a(2, stringArray)) {
            this.e(commandSender);
            return true;
        }
        boolean bl2 = false;
        boolean bl3 = bl = stringArray.length == 4 && stringArray[3].equalsIgnoreCase("silent");
        if (!ItemStackRegistry.g().f(stringArray[0])) {
            if (!bl) {
                CommandSenderBridge_5.f(commandSender, Main.PQ.ir("item-not-found").replace("{item}", stringArray[0]));
            }
            return true;
        }
        ItemStack itemStack = ItemStackRegistry.g().e(stringArray[0]).mP();
        if (ColorBridge.iJ(stringArray[1])) {
            World world;
            if (stringArray.length < 5) {
                this.e(commandSender);
                return true;
            }
            if (ColorBridge.iJ(stringArray[1]) && ColorBridge.iJ(stringArray[2]) && ColorBridge.iJ(stringArray[3])) {
                world = Bukkit.getWorld((String)stringArray[4]);
                if (world == null) {
                    if (!bl) {
                        CommandSenderBridge_5.a(commandSender, "world-not-found", (Object string) -> string.replace("{world}", stringArray[4]));
                    }
                    return true;
                }
            } else {
                this.e(commandSender);
                return true;
            }
            location = new Location(world, (double)ColorBridge.b(stringArray[1], 0.0f), (double)ColorBridge.b(stringArray[2], 0.0f), (double)ColorBridge.b(stringArray[3], 0.0f));
            int n = 1;
            if (stringArray.length > 5) {
                n = ColorBridge.w(stringArray[5], 1);
            }
            itemStack.setAmount(n);
        } else {
            Player player = Bukkit.getPlayer((String)stringArray[1]);
            if (player == null) {
                if (!bl) {
                    CommandSenderBridge_5.f(commandSender, Main.PQ.ir("player-offline"));
                }
                return true;
            }
            location = player.getLocation();
            int n = 1;
            if (stringArray.length > 2) {
                n = ColorBridge.w(stringArray[2], 1);
            }
            itemStack.setAmount(n);
            bl2 = true;
        }
        LocationBridge_4.b(location, itemStack);
        if (!bl) {
            if (bl2) {
                CommandSenderBridge_5.f(commandSender, Main.PQ.ir("dropped-item-player").replace("{item}", stringArray[0]).replace("{player}", stringArray[1]));
            } else {
                CommandSenderBridge_5.f(commandSender, Main.PQ.ir("dropped-item-coords").replace("{item}", stringArray[0]).replace("{coords}", location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ() + " " + location.getWorld().getName()));
            }
        }
        return true;
    }

    private void e(CommandSender commandSender) {
        CommandSenderBridge_5.f(commandSender, Main.PQ.ir("wrong-command-usage"));
        CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&e/iadrop <itemname> <player|x y z world> [amount]"));
        CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&6Example: &e/iadrop ruby Notch 3"));
    }
}
