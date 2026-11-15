package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.bdf;
import itemsadder.m.d;
import itemsadder.m.za;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class xx
extends za {
    public xx() {
        Main.cM("iadrop").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string2, @NotNull String[] stringArray) {
        Location location;
        boolean bl;
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!za.a(2, stringArray)) {
            this.e(commandSender);
            return true;
        }
        boolean bl2 = false;
        boolean bl3 = bl = stringArray.length == 4 && stringArray[3].equalsIgnoreCase("silent");
        if (!d.g().f(stringArray[0])) {
            if (!bl) {
                bce.f(commandSender, Main.PQ.ir("item-not-found").replace("{item}", stringArray[0]));
            }
            return true;
        }
        ItemStack itemStack = d.g().e(stringArray[0]).mP();
        if (bcy.iJ(stringArray[1])) {
            World world;
            if (stringArray.length < 5) {
                this.e(commandSender);
                return true;
            }
            if (bcy.iJ(stringArray[1]) && bcy.iJ(stringArray[2]) && bcy.iJ(stringArray[3])) {
                world = Bukkit.getWorld((String)stringArray[4]);
                if (world == null) {
                    if (!bl) {
                        bce.a(commandSender, "world-not-found", (Object string) -> string.replace("{world}", stringArray[4]));
                    }
                    return true;
                }
            } else {
                this.e(commandSender);
                return true;
            }
            location = new Location(world, (double)bcy.b(stringArray[1], 0.0f), (double)bcy.b(stringArray[2], 0.0f), (double)bcy.b(stringArray[3], 0.0f));
            int n = 1;
            if (stringArray.length > 5) {
                n = bcy.w(stringArray[5], 1);
            }
            itemStack.setAmount(n);
        } else {
            Player player = Bukkit.getPlayer((String)stringArray[1]);
            if (player == null) {
                if (!bl) {
                    bce.f(commandSender, Main.PQ.ir("player-offline"));
                }
                return true;
            }
            location = player.getLocation();
            int n = 1;
            if (stringArray.length > 2) {
                n = bcy.w(stringArray[2], 1);
            }
            itemStack.setAmount(n);
            bl2 = true;
        }
        bdf.b(location, itemStack);
        if (!bl) {
            if (bl2) {
                bce.f(commandSender, Main.PQ.ir("dropped-item-player").replace("{item}", stringArray[0]).replace("{player}", stringArray[1]));
            } else {
                bce.f(commandSender, Main.PQ.ir("dropped-item-coords").replace("{item}", stringArray[0]).replace("{coords}", location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ() + " " + location.getWorld().getName()));
            }
        }
        return true;
    }

    private void e(CommandSender commandSender) {
        bce.f(commandSender, Main.PQ.ir("wrong-command-usage"));
        bce.f(commandSender, bcy.gH("&e/iadrop <itemname> <player|x y z world> [amount]"));
        bce.f(commandSender, bcy.gH("&6Example: &e/iadrop ruby Notch 3"));
    }
}
