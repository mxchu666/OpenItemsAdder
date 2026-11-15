package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.CommandSenderBridge_6;
import itemsadder.m.CommandSenderBridge_7;
import itemsadder.m.IareloadCommand;
import itemsadder.m.ItemStackBridge_42;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MainHandEnum;
import itemsadder.m.PlayerJoinListener_7;
import itemsadder.m.PluginCommand_2;
import itemsadder.m.RefData_2;
import itemsadder.m.SoundCategoryBridge;
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

public class IaitemCommand
extends PluginCommand_2
implements TabCompleter {
    final WeakHashMap SC = new WeakHashMap();

    public IaitemCommand() {
        Main.cM("iaitem").setExecutor((CommandExecutor)this);
        Main.cM("iaitem").setTabCompleter((TabCompleter)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        Object object;
        if (!this.a(commandSender, command)) {
            return true;
        }
        ItemStackBridge_42 itemStackBridge_42 = ItemStackRegistry.g().bi;
        if (!ItemStackRegistry.g().u || itemStackBridge_42 == null) {
            return true;
        }
        if (stringArray.length == 0) {
            commandSender.sendMessage(Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iaitem <update> --player [player] --slot [slot|all] --item [item]");
            return true;
        }
        if (stringArray[0].equalsIgnoreCase("reload-update-all")) {
            if (commandSender instanceof Player) {
                Player player = (Player)commandSender;
                IareloadCommand.a(false, () -> {
                    CommandSenderBridge_5.g((CommandSender)player, "plugin-reloaded-successfully");
                    this.a(commandSender, player, null);
                });
                return true;
            }
            IaitemCommand.a(commandSender);
            return true;
        }
        Player player = commandSender instanceof Player ? (Player)commandSender : null;
        MainHandEnum mainHandEnum = MainHandEnum.ALL;
        ItemStackBuilder_4 itemStackBuilder_4 = null;
        Map map = IaitemCommand.g(stringArray);
        if (map.containsKey("player") && ((player = Bukkit.getPlayer((String)((String)map.get("player")))) == null || !player.isOnline())) {
            commandSender.sendMessage(Main.PQ.ir("player-offline"));
            return true;
        }
        if (player == null) {
            commandSender.sendMessage(String.valueOf(ChatColor.RED) + "You must specify a player or use the command ingame.");
            return true;
        }
        if (map.containsKey("slot") && !((String)(object = ((String)map.get("slot")).toUpperCase())).equalsIgnoreCase("all") && (mainHandEnum = (MainHandEnum)SoundCategoryBridge.b((String)object, MainHandEnum.class, null)) == null) {
            commandSender.sendMessage(String.valueOf(ChatColor.RED) + "Invalid slot: " + (String)object);
            return true;
        }
        if (map.containsKey("item")) {
            object = (String)map.get("item");
            itemStackBuilder_4 = ItemStackRegistry.g().e((String)object);
            if (itemStackBuilder_4 == null) {
                commandSender.sendMessage(String.valueOf(ChatColor.RED) + "Unknown custom item: " + (String)object);
                return true;
            }
        }
        object = (CommandSenderBridge_7)this.SC.get(commandSender);
        if (stringArray[0].equalsIgnoreCase("update")) {
            if (object == null || !((CommandSenderBridge_7)object).c(string, stringArray) || !((CommandSenderBridge_7)object).b(string, stringArray)) {
                CommandSenderBridge_7.a(this.SC, commandSender, string, stringArray, "This command has no automatic rollback. Use it with caution!");
                return true;
            }
            if (mainHandEnum.isSingle()) {
                EquipmentSlot equipmentSlot = mainHandEnum.ss();
                if (equipmentSlot == null) {
                    throw new IllegalStateException("Invalid slot: " + String.valueOf((Object)mainHandEnum));
                }
                ItemStack itemStack = player.getEquipment().getItem(equipmentSlot);
                ItemStackBuilder_4 itemStackBuilder_42 = ItemStackRegistry.g().a(itemStack);
                if (itemStackBuilder_42 == null) {
                    return true;
                }
                if (itemStackBuilder_4 != null && !itemStackBuilder_42.equals(itemStackBuilder_4)) {
                    return true;
                }
                ItemStack itemStack2 = PlayerJoinListener_7.f(itemStack);
                if (itemStack2 != null) {
                    player.getEquipment().setItem(equipmentSlot, itemStack2);
                    commandSender.sendMessage(String.valueOf(ChatColor.GREEN) + "Item in '" + String.valueOf((Object)mainHandEnum) + "' of " + player.getName() + " updated.");
                } else {
                    commandSender.sendMessage(String.valueOf(ChatColor.RED) + "No custom item found in '" + String.valueOf((Object)mainHandEnum) + "' of " + player.getName() + ".");
                }
            } else {
                this.a(commandSender, player, itemStackBuilder_4);
            }
            this.SC.remove(commandSender);
        } else if (stringArray[0].equalsIgnoreCase("set-itemstack-auto-update")) {
            stringArray[0] = stringArray[0].toLowerCase();
            if (stringArray.length < 2 || stringArray.length > 3) {
                commandSender.sendMessage(Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iaitem set-itemstack-auto-update <true|false> --player [player] --slot [slot|all] --item [item]");
                return true;
            }
            String string2 = stringArray[1].toLowerCase();
            if (object == null || !((CommandSenderBridge_7)object).c(string, stringArray) || !((CommandSenderBridge_7)object).b(string, stringArray)) {
                CommandSenderBridge_7.a(this.SC, commandSender, string, stringArray, "This command has no automatic rollback. Use it with caution!");
                return true;
            }
            boolean bl = string2.equalsIgnoreCase("true");
            if (mainHandEnum.isSingle()) {
                EquipmentSlot equipmentSlot = mainHandEnum.ss();
                if (equipmentSlot == null) {
                    throw new IllegalStateException("Invalid slot: " + String.valueOf((Object)mainHandEnum));
                }
                ItemStack itemStack = player.getEquipment().getItem(equipmentSlot);
                ItemStackBuilder_4 itemStackBuilder_43 = ItemStackRegistry.g().a(itemStack);
                if (itemStackBuilder_43 == null) {
                    return true;
                }
                if (itemStackBuilder_4 != null && !itemStackBuilder_43.equals(itemStackBuilder_4)) {
                    return true;
                }
                PlayerJoinListener_7.a(itemStack, bl);
                player.getEquipment().setItem(equipmentSlot, itemStack);
                commandSender.sendMessage(String.valueOf(ChatColor.GREEN) + "Item in '" + String.valueOf((Object)mainHandEnum) + "' of " + player.getName() + " auto-update flag set to " + bl + ".");
            } else {
                int n = 0;
                @Nullable ItemStack @NotNull [] itemStackArray = player.getInventory().getContents();
                for (int i = 0; i < itemStackArray.length; ++i) {
                    ItemStackBuilder_4 itemStackBuilder_44;
                    ItemStack itemStack = itemStackArray[i];
                    if (itemStack == null || (itemStackBuilder_44 = ItemStackRegistry.g().a(itemStack)) == null || itemStackBuilder_4 != null && !itemStackBuilder_44.equals(itemStackBuilder_4)) continue;
                    PlayerJoinListener_7.a(itemStack, bl);
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

    void a(@NotNull CommandSender commandSender, @NotNull Player player, @Nullable ItemStackBuilder_4 itemStackBuilder_4) {
        int n = 0;
        @Nullable ItemStack @NotNull [] itemStackArray = player.getInventory().getContents();
        for (int i = 0; i < itemStackArray.length; ++i) {
            ItemStack itemStack;
            ItemStackBuilder_4 itemStackBuilder_42;
            ItemStack itemStack2 = itemStackArray[i];
            if (itemStack2 == null || (itemStackBuilder_42 = ItemStackRegistry.g().a(itemStack2)) == null || itemStackBuilder_4 != null && !itemStackBuilder_42.equals(itemStackBuilder_4) || (itemStack = PlayerJoinListener_7.f(itemStack2)) == null) continue;
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
                return CommandSenderBridge_6.a(stringArray[stringArray.length - 1], false, commandSender);
            }
            if (((String)object).equalsIgnoreCase("item")) {
                return ItemStackRegistry.g().i(stringArray[stringArray.length - 1]);
            }
        }
        object = IaitemCommand.g(stringArray);
        RefData_2 refData_2 = new RefData_2(this);
        for (String string2 : object.keySet()) {
            refData_2.remove("--" + string2);
        }
        return refData_2;
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
        CommandSenderBridge_5.iy("command-ingame-only");
        return true;
    }
}
