package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.CommandSenderBridge_7;
import itemsadder.m.IareloadCommand;
import itemsadder.m.ItemStackBridge_34;
import itemsadder.m.ItemStackBridge_35;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBridge_18;
import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.PluginCommand_2;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Function;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class IaconfigCommand
extends PluginCommand_2 {
    final WeakHashMap Sx = new WeakHashMap();

    public IaconfigCommand() {
        Main.cM("iaconfig").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        this.a(commandSender, string, stringArray);
        return true;
    }

    private void a(CommandSender commandSender, String string, String[] stringArray) {
        if (stringArray.length < 3) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("wrong-command-usage"));
            return;
        }
        block5 : switch (stringArray[0]) {
            case "item": {
                switch (stringArray[1]) {
                    case "delete": {
                        if (!s.b((Permissible)commandSender, "ia.admin.iaconfig.item.delete", true)) {
                            return;
                        }
                        this.a(commandSender, string, stringArray, ColorBridge.gH("&cWARNING: if you delete this item you won't be able to use the command to delete recipes of this item.\nConsider using &6/iaconfig recipes deleteofitem " + stringArray[2] + "&c before."), true, itemStackBuilder_4 -> {
                            itemStackBuilder_4.fz().gQ("items." + itemStackBuilder_4.getId());
                            itemStackBuilder_4.fz().save();
                            CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&aDeleted &e" + itemStackBuilder_4.getNamespacedID() + "&a from file: &e" + itemStackBuilder_4.nh()));
                            return true;
                        });
                        break;
                    }
                    case "disable": {
                        if (!s.b((Permissible)commandSender, "ia.admin.iaconfig.item.disable", true)) {
                            return;
                        }
                        this.a(commandSender, string, stringArray, ColorBridge.gH("&cWARNING: if you disable this item you won't be able to use the command to disable/delete recipes of this item. You will have to re-enable it manually.\nConsider using &6/iaconfig recipes disableofitem " + stringArray[2] + "&c before."), true, itemStackBuilder_4 -> {
                            itemStackBuilder_4.fz().d("items." + itemStackBuilder_4.getId() + ".enabled", false);
                            itemStackBuilder_4.fz().save();
                            CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&aDisabled &e" + itemStackBuilder_4.getNamespacedID() + "&a from file: &e" + itemStackBuilder_4.nh()));
                            return true;
                        });
                    }
                }
                break;
            }
            case "namespace": {
                switch (stringArray[1]) {
                    case "delete": {
                        if (!s.b((Permissible)commandSender, "ia.admin.iaconfig.namespace.delete", true)) {
                            return;
                        }
                        this.b(commandSender, string, stringArray, String.valueOf(ChatColor.RED) + "WARNING: if you delete this namespace it will delete both items and recipes which use these items!", true, itemStackBuilder_4 -> {
                            itemStackBuilder_4.fz().gQ("items." + itemStackBuilder_4.getId());
                            itemStackBuilder_4.fz().save();
                            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.GREEN) + "Deleted " + itemStackBuilder_4.getNamespacedID() + " from file: " + itemStackBuilder_4.nh());
                            int n = 0;
                            n += this.a(ItemStackBridge_35.class, (ItemStackBuilder_4)itemStackBuilder_4, this::c);
                            n += this.a(MaterialBridge_18.class, (ItemStackBuilder_4)itemStackBuilder_4, this::c);
                            if ((n += this.a(ItemStackBridge_34.class, (ItemStackBuilder_4)itemStackBuilder_4, this::c)) > 0) {
                                CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&aDeleted &e" + n + "&a recipes which use/create item &e" + itemStackBuilder_4.getNamespacedID()));
                                return true;
                            }
                            return true;
                        });
                        break;
                    }
                    case "disable": {
                        if (!s.b((Permissible)commandSender, "ia.admin.iaconfig.namespace.disable", true)) {
                            return;
                        }
                        this.b(commandSender, string, stringArray, null, false, itemStackBuilder_4 -> {
                            itemStackBuilder_4.fz().d("items." + itemStackBuilder_4.getId() + ".enabled", false);
                            itemStackBuilder_4.fz().save();
                            CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&aDisabled &e" + itemStackBuilder_4.getNamespacedID() + "&a from file: &e" + itemStackBuilder_4.nh()));
                            int n = 0;
                            n += this.a(ItemStackBridge_35.class, (ItemStackBuilder_4)itemStackBuilder_4, this::d);
                            n += this.a(MaterialBridge_18.class, (ItemStackBuilder_4)itemStackBuilder_4, this::d);
                            if ((n += this.a(ItemStackBridge_34.class, (ItemStackBuilder_4)itemStackBuilder_4, this::d)) > 0) {
                                CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&aDisabled &e" + n + "&a recipes which use/create item &e" + itemStackBuilder_4.getNamespacedID()));
                            }
                            return true;
                        });
                    }
                }
                break;
            }
            case "recipes": {
                switch (stringArray[1]) {
                    case "deleteofitem": {
                        if (!s.b((Permissible)commandSender, "ia.admin.iaconfig.recipes.deleteofitem", true)) {
                            return;
                        }
                        this.a(commandSender, string, stringArray, null, false, itemStackBuilder_4 -> {
                            int n = 0;
                            n += this.a(ItemStackBridge_35.class, (ItemStackBuilder_4)itemStackBuilder_4, this::c);
                            n += this.a(MaterialBridge_18.class, (ItemStackBuilder_4)itemStackBuilder_4, this::c);
                            if ((n += this.a(ItemStackBridge_34.class, (ItemStackBuilder_4)itemStackBuilder_4, this::c)) > 0) {
                                CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&aDeleted &e" + n + "&a recipes which use/create item &e" + itemStackBuilder_4.getNamespacedID()));
                                return true;
                            }
                            return false;
                        });
                        break block5;
                    }
                    case "disableofitem": {
                        if (!s.b((Permissible)commandSender, "ia.admin.iaconfig.recipes.disableofitem", true)) {
                            return;
                        }
                        this.a(commandSender, string, stringArray, null, false, itemStackBuilder_4 -> {
                            int n = 0;
                            n += this.a(ItemStackBridge_35.class, (ItemStackBuilder_4)itemStackBuilder_4, this::d);
                            n += this.a(MaterialBridge_18.class, (ItemStackBuilder_4)itemStackBuilder_4, this::d);
                            if ((n += this.a(ItemStackBridge_34.class, (ItemStackBuilder_4)itemStackBuilder_4, this::d)) > 0) {
                                CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&aDisabled &e" + n + "&a recipes which use/create item &e" + itemStackBuilder_4.getNamespacedID()));
                                return true;
                            }
                            return false;
                        });
                    }
                }
            }
        }
    }

    private Function c(NamespacedKeyItemStackHolder namespacedKeyItemStackHolder) {
        if (namespacedKeyItemStackHolder.nP != null) {
            CommandSenderBridge_5.log(ColorBridge.gH("&eDeleted recipe: &2" + namespacedKeyItemStackHolder.LY + "&e from file: &2" + namespacedKeyItemStackHolder.nP.nh()));
            namespacedKeyItemStackHolder.nP.gQ(namespacedKeyItemStackHolder.LY);
        }
        return null;
    }

    private Function d(NamespacedKeyItemStackHolder namespacedKeyItemStackHolder) {
        if (namespacedKeyItemStackHolder.nP != null) {
            CommandSenderBridge_5.log(ColorBridge.gH("&eDisabled recipe: &2" + namespacedKeyItemStackHolder.LY + "&e from file: &2" + namespacedKeyItemStackHolder.nP.nh()));
            namespacedKeyItemStackHolder.nP.d(namespacedKeyItemStackHolder.LY + ".enabled", false);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(CommandSender commandSender, String string, String[] stringArray, String string2, boolean bl, Function function) {
        String string3 = stringArray[2];
        if (!string3.contains(":")) {
            CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&eSpecify the complete identifier for the item &2" + string3 + "&e. For example &2myitems:red_sword"));
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e(string3);
        if (itemStackBuilder_4 == null) {
            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.YELLOW) + "Can't find item " + string3);
            return;
        }
        CommandSenderBridge_7 commandSenderBridge_7 = (CommandSenderBridge_7)this.Sx.get(commandSender);
        if (commandSenderBridge_7 == null || !commandSenderBridge_7.c(string, stringArray)) {
            CommandSenderBridge_7.a(this.Sx, commandSender, string, stringArray, string2);
            return;
        }
        if (!commandSenderBridge_7.b(string, stringArray)) {
            CommandSenderBridge_7.a(this.Sx, commandSender, string, stringArray, string2);
            return;
        }
        if (((Boolean)function.apply(itemStackBuilder_4)).booleanValue()) {
            this.a(commandSender, bl);
            return;
        }
        CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&eNo operation done for item &2" + itemStackBuilder_4.getNamespacedID() + "&e, failed to find anything to change."));
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(CommandSender commandSender, String string, String[] stringArray, String string2, boolean bl, Function function) {
        String string3 = stringArray[2];
        if (string3.contains(":")) {
            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.YELLOW) + "Specify enter a valid namespace.");
            return;
        }
        if (!ItemStackRegistry.g().Z.contains(string3)) {
            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.YELLOW) + "Can't find namespace " + string3);
            return;
        }
        CommandSenderBridge_7 commandSenderBridge_7 = (CommandSenderBridge_7)this.Sx.get(commandSender);
        if (commandSenderBridge_7 == null || !commandSenderBridge_7.c(string, stringArray)) {
            CommandSenderBridge_7.a(this.Sx, commandSender, string, stringArray, string2);
            return;
        }
        if (!commandSenderBridge_7.b(string, stringArray)) {
            CommandSenderBridge_7.a(this.Sx, commandSender, string, stringArray, string2);
            return;
        }
        boolean bl2 = false;
        HashMap hashMap = (HashMap)ItemStackRegistry.g().M.get(string3);
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String string4 = (String)entry.getKey();
                ItemStackBuilder_4 itemStackBuilder_4 = (ItemStackBuilder_4)entry.getValue();
                if (!((Boolean)function.apply(itemStackBuilder_4)).booleanValue()) continue;
                bl2 = true;
            }
        }
        if (bl2) {
            this.a(commandSender, bl);
            return;
        }
        CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&eNo operation done for namespace &2" + string3 + "&e, failed to find anything to change."));
    }

    private void a(CommandSender commandSender, boolean bl) {
        if (bl) {
            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.YELLOW) + "WARNING: Textures and models are not automatically deleted from the resource_pack folder to avoid mistakes.");
        }
        CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.YELLOW) + "Reloading the plugin in 5 seconds...");
        BukkitTaskBridge.c(() -> IareloadCommand.a(false, () -> CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.GREEN) + "Reloaded plugin.")), 100L);
    }

    private int a(Class clazz, ItemStackBuilder_4 itemStackBuilder_4, Function function) {
        int n = 0;
        for (NamespacedKeyItemStackHolder namespacedKeyItemStackHolder : ItemStackRegistry.g().aW.b(clazz, itemStackBuilder_4)) {
            function.apply(namespacedKeyItemStackHolder);
            if (namespacedKeyItemStackHolder.nP == null) continue;
            namespacedKeyItemStackHolder.nP.save();
            ++n;
        }
        return n;
    }
}
