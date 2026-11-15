package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.f;
import itemsadder.m.CommandSenderBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PlayerBridge_30;
import itemsadder.m.PlayerBridge_31;
import itemsadder.m.PluginCommand_2;
import java.util.HashSet;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class IainfoCommand
extends PluginCommand_2 {
    public IainfoCommand() {
        Main.cM("iainfo").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.YELLOW) + "-" + String.valueOf(ChatColor.GOLD) + "=" + String.valueOf(ChatColor.DARK_GRAY) + "[" + String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.BOLD) + " ItemsAdder " + String.valueOf(ChatColor.DARK_GRAY) + "]" + String.valueOf(ChatColor.GOLD) + "=" + String.valueOf(ChatColor.YELLOW) + "-");
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GOLD) + "Version: " + String.valueOf(ChatColor.AQUA) + Main.rS().getDescription().getVersion());
        CommandSenderBridge.k(commandSender);
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GRAY) + "     Last update: " + String.valueOf(ChatColor.AQUA) + ItemStackRegistry.g().as.auh.yD());
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GRAY) + "     Host type: " + String.valueOf(ChatColor.AQUA) + ItemStackRegistry.g().as.aui.getName());
        int n2 = f.xl().xz();
        int n3 = f.xl().xA();
        int n4 = f.xl().xB();
        int n5 = f.xl().xC();
        int n6 = f.xl().xD();
        int n7 = ItemStackRegistry.g().al.hW();
        Object object = "Loading ...";
        if (ItemStackRegistry.g().bi != null && ItemStackRegistry.g().bi.Ue != null) {
            HashSet<String> hashSet = new HashSet<String>();
            for (Object object2 : ItemStackRegistry.g().bi.Ue.sD()) {
                if (((PlayerBridge_30)object2).sN()) continue;
                for (PlayerBridge_31 playerBridge_31 : ((PlayerBridge_30)object2).sP()) {
                    hashSet.add(playerBridge_31.sR().getNamespacedID());
                }
            }
            object = "" + hashSet.size();
        }
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GOLD) + "Data");
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GRAY) + " - Items: " + String.valueOf(ChatColor.AQUA) + ItemStackRegistry.g().C.size());
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GRAY) + " - Items in /ia: " + String.valueOf(ChatColor.AQUA) + (String)object);
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GRAY) + " - Namespaces: " + String.valueOf(ChatColor.AQUA) + ItemStackRegistry.g().Z.size());
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GRAY) + " - Materials: " + String.valueOf(ChatColor.AQUA) + ItemStackRegistry.g().N.size());
        if (MaterialBarColorHolder.ar()) {
            int n8 = 0;
            for (Object object2 : ItemStackRegistry.g().S) {
                if (((LocationBridgeBuilder_2)object2).FD == null || !((LocationBridgeBuilder_2)object2).FD.oX()) continue;
                ++n8;
            }
            if (MaterialBarColorHolder.cG) {
                CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GRAY) + " - REAL: " + String.valueOf(ChatColor.AQUA) + n2 + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + "188");
            }
            if (MaterialBarColorHolder.cI) {
                CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GRAY) + " - REAL_NOTE: " + String.valueOf(ChatColor.AQUA) + n3 + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + "750");
            }
            if (MaterialBarColorHolder.cH) {
                CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GRAY) + " - REAL_TRANSPARENT: " + String.valueOf(ChatColor.AQUA) + n4 + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + "63");
            }
            if (MaterialBarColorHolder.cJ) {
                CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GRAY) + " - REAL_WIRE: " + String.valueOf(ChatColor.AQUA) + n5 + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + "127");
            }
            if (MaterialBarColorHolder.cK) {
                CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GRAY) + " - FIRE: " + String.valueOf(ChatColor.AQUA) + n6 + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + "14");
            }
            if (n8 > 0) {
                CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GRAY) + " - Directional states: " + String.valueOf(ChatColor.AQUA) + n8);
            }
        }
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GRAY) + " Font images: " + String.valueOf(ChatColor.AQUA) + n7 + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + ItemStackRegistry.g().al.uj);
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        for (PlayerBridge_31 playerBridge_31 : Bukkit.getWorlds()) {
            n11 += playerBridge_31.getLoadedChunks().length;
            for (LivingEntity livingEntity : playerBridge_31.getLivingEntities()) {
                ArmorStand armorStand;
                ItemStack itemStack;
                if (!(livingEntity instanceof ArmorStand) || (itemStack = (armorStand = (ArmorStand)livingEntity).getHelmet()) == null || !ItemStackBuilder_4.isCustomItem(itemStack)) continue;
                ++n9;
            }
        }
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GOLD) + "Loaded chunks " + String.valueOf(ChatColor.GRAY) + "(" + n11 + ")");
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GRAY) + "     Armorstands: " + String.valueOf(ChatColor.AQUA) + n9);
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GRAY) + "     Mobs: " + String.valueOf(ChatColor.AQUA) + n10);
        return true;
    }
}
