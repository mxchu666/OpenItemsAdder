package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bbi;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.r;
import itemsadder.m.yi;
import itemsadder.m.yj;
import itemsadder.m.yp;
import itemsadder.m.za;
import itemsadder.m.zb;
import itemsadder.m.zc;
import itemsadder.m.zo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class yh
extends za
implements TabCompleter {
    final WeakHashMap SC = new WeakHashMap();

    public yh() {
        Main.cM("iaitem").setExecutor((CommandExecutor)this);
        Main.cM("iaitem").setTabCompleter((TabCompleter)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        Object object;
        if (!this.a(commandSender, command)) {
            return true;
        }
        zo zo2 = d.g().bi;
        if (!d.g().u || zo2 == null) {
            return true;
        }
        if (stringArray.length == 0) {
            commandSender.sendMessage(Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iaitem <update> --player [player] --slot [slot|all] --item [item]");
            return true;
        }
        if (stringArray[0].equalsIgnoreCase("reload-update-all")) {
            if (commandSender instanceof Player) {
                Player player = (Player)commandSender;
                yp.a(false, () -> {
                    bce.g((CommandSender)player, "plugin-reloaded-successfully");
                    this.a(commandSender, player, null);
                });
                return true;
            }
            yh.a(commandSender);
            return true;
        }
        Player player = commandSender instanceof Player ? (Player)commandSender : null;
        yj yj2 = yj.ALL;
        qm qm2 = null;
        Map map = yh.g(stringArray);
        if (map.containsKey("player") && ((player = Bukkit.getPlayer((String)((String)map.get("player")))) == null || !player.isOnline())) {
            commandSender.sendMessage(Main.PQ.ir("player-offline"));
            return true;
        }
        if (player == null) {
            commandSender.sendMessage(String.valueOf(ChatColor.RED) + "You must specify a player or use the command ingame.");
            return true;
        }
        if (map.containsKey("slot") && !((String)(object = ((String)map.get("slot")).toUpperCase())).equalsIgnoreCase("all") && (yj2 = (yj)bbi.b((String)object, yj.class, null)) == null) {
            commandSender.sendMessage(String.valueOf(ChatColor.RED) + "Invalid slot: " + (String)object);
            return true;
        }
        if (map.containsKey("item")) {
            object = (String)map.get("item");
            qm2 = d.g().e((String)object);
            if (qm2 == null) {
                commandSender.sendMessage(String.valueOf(ChatColor.RED) + "Unknown custom item: " + (String)object);
                return true;
            }
        }
        object = (zc)this.SC.get(commandSender);
        if (stringArray[0].equalsIgnoreCase("update")) {
            if (object == null || !((zc)object).c(string, stringArray) || !((zc)object).b(string, stringArray)) {
                zc.a(this.SC, commandSender, string, stringArray, "This command has no automatic rollback. Use it with caution!");
                return true;
            }
            if (yj2.isSingle()) {
                EquipmentSlot equipmentSlot = yj2.ss();
                if (equipmentSlot == null) {
                    throw new IllegalStateException("Invalid slot: " + String.valueOf((Object)yj2));
                }
                ItemStack itemStack = player.getEquipment().getItem(equipmentSlot);
                qm qm3 = d.g().a(itemStack);
                if (qm3 == null) {
                    return true;
                }
                if (qm2 != null && !qm3.equals(qm2)) {
                    return true;
                }
                ItemStack itemStack2 = r.f(itemStack);
                if (itemStack2 != null) {
                    player.getEquipment().setItem(equipmentSlot, itemStack2);
                    commandSender.sendMessage(String.valueOf(ChatColor.GREEN) + "Item in '" + String.valueOf((Object)yj2) + "' of " + player.getName() + " updated.");
                } else {
                    commandSender.sendMessage(String.valueOf(ChatColor.RED) + "No custom item found in '" + String.valueOf((Object)yj2) + "' of " + player.getName() + ".");
                }
            } else {
                this.a(commandSender, player, qm2);
            }
            this.SC.remove(commandSender);
        } else if (stringArray[0].equalsIgnoreCase("set-itemstack-auto-update")) {
            stringArray[0] = stringArray[0].toLowerCase();
            if (stringArray.length < 2 || stringArray.length > 3) {
                commandSender.sendMessage(Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iaitem set-itemstack-auto-update <true|false> --player [player] --slot [slot|all] --item [item]");
                return true;
            }
            String string2 = stringArray[1].toLowerCase();
            if (object == null || !((zc)object).c(string, stringArray) || !((zc)object).b(string, stringArray)) {
                zc.a(this.SC, commandSender, string, stringArray, "This command has no automatic rollback. Use it with caution!");
                return true;
            }
            boolean bl = string2.equalsIgnoreCase("true");
            if (yj2.isSingle()) {
                EquipmentSlot equipmentSlot = yj2.ss();
                if (equipmentSlot == null) {
                    throw new IllegalStateException("Invalid slot: " + String.valueOf((Object)yj2));
                }
                ItemStack itemStack = player.getEquipment().getItem(equipmentSlot);
                qm qm4 = d.g().a(itemStack);
                if (qm4 == null) {
                    return true;
                }
                if (qm2 != null && !qm4.equals(qm2)) {
                    return true;
                }
                r.a(itemStack, bl);
                player.getEquipment().setItem(equipmentSlot, itemStack);
                commandSender.sendMessage(String.valueOf(ChatColor.GREEN) + "Item in '" + String.valueOf((Object)yj2) + "' of " + player.getName() + " auto-update flag set to " + bl + ".");
            } else {
                int n = 0;
                @Nullable ItemStack @NotNull [] itemStackArray = player.getInventory().getContents();
                for (int i = 0; i < itemStackArray.length; ++i) {
                    qm qm5;
                    ItemStack itemStack = itemStackArray[i];
                    if (itemStack == null || (qm5 = d.g().a(itemStack)) == null || qm2 != null && !qm5.equals(qm2)) continue;
                    r.a(itemStack, bl);
                    player.getInventory().setItem(i, itemStack);
                    ++n;
                }
                commandSender.sendMessage(String.valueOf(ChatColor.GREEN) + "Set auto-update flag to " + bl + " of " + n + " items in inventory of " + player.getName() + ".");
            }
            this.SC.remove(commandSender);
        } else {
            commandSender.sendMessage(Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iaitem <update> --player [player] --slot [slot|all] --item [item]");
        }
        return true;
    }

    void a(@NotNull CommandSender commandSender, @NotNull Player player, @Nullable qm qm2) {
        int n = 0;
        @Nullable ItemStack @NotNull [] itemStackArray = player.getInventory().getContents();
        for (int i = 0; i < itemStackArray.length; ++i) {
            ItemStack itemStack;
            qm qm3;
            ItemStack itemStack2 = itemStackArray[i];
            if (itemStack2 == null || (qm3 = d.g().a(itemStack2)) == null || qm2 != null && !qm3.equals(qm2) || (itemStack = r.f(itemStack2)) == null) continue;
            player.getInventory().setItem(i, itemStack);
            ++n;
        }
        commandSender.sendMessage(String.valueOf(ChatColor.GREEN) + "Updated " + n + " items in inventory of " + player.getName() + ".");
    }

    public List onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        Object object;
        if (stringArray.length == 1) {
            return List.of("update", "reload-update-all", "set-itemstack-auto-update");
        }
        if (stringArray[0].equalsIgnoreCase("reload-update-all")) {
            return List.of();
        }
        if (stringArray[0].equalsIgnoreCase("set-itemstack-auto-update")) {
            return List.of("true", "false");
        }
        if (stringArray.length >= 3 && stringArray[stringArray.length - 2].startsWith("--")) {
            object = stringArray[stringArray.length - 2].substring(2);
            if (((String)object).equalsIgnoreCase("slot")) {
                return List.of("main_hand", "off_hand", "head", "chest", "legs", "feet", "all");
            }
            if (((String)object).equalsIgnoreCase("player")) {
                return zb.a(stringArray[stringArray.length - 1], false, commandSender);
            }
            if (((String)object).equalsIgnoreCase("item")) {
                return d.g().i(stringArray[stringArray.length - 1]);
            }
        }
        object = yh.g(stringArray);
        yi yi2 = new yi(this);
        for (String string2 : object.keySet()) {
            yi2.remove("--" + string2);
        }
        return yi2;
    }

    private static Map g(String[] stringArray) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (int i = 1; i < stringArray.length; ++i) {
            if (!stringArray[i].startsWith("--")) continue;
            String string = stringArray[i].substring(2);
            if (i + 1 < stringArray.length) {
                String string2 = stringArray[i + 1];
                hashMap.put(string, string2);
                continue;
            }
            hashMap.put(string, "");
        }
        return hashMap;
    }

    public static boolean a(CommandSender commandSender) {
        bce.iy("command-ingame-only");
        return true;
    }
}
