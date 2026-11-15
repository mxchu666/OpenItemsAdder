package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.f;
import itemsadder.m.ae;
import itemsadder.m.azu;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.za;
import itemsadder.m.zl;
import itemsadder.m.zn;
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

public class yg
extends za {
    public yg() {
        Main.cM("iainfo").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        bce.e(commandSender, String.valueOf(ChatColor.YELLOW) + "-" + String.valueOf(ChatColor.GOLD) + "=" + String.valueOf(ChatColor.DARK_GRAY) + "[" + String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.BOLD) + " ItemsAdder " + String.valueOf(ChatColor.DARK_GRAY) + "]" + String.valueOf(ChatColor.GOLD) + "=" + String.valueOf(ChatColor.YELLOW) + "-");
        bce.e(commandSender, String.valueOf(ChatColor.GOLD) + "Version: " + String.valueOf(ChatColor.AQUA) + Main.rS().getDescription().getVersion());
        azu.k(commandSender);
        bce.e(commandSender, String.valueOf(ChatColor.GRAY) + "     Last update: " + String.valueOf(ChatColor.AQUA) + d.g().as.auh.yD());
        bce.e(commandSender, String.valueOf(ChatColor.GRAY) + "     Host type: " + String.valueOf(ChatColor.AQUA) + d.g().as.aui.getName());
        int n2 = f.xl().xz();
        int n3 = f.xl().xA();
        int n4 = f.xl().xB();
        int n5 = f.xl().xC();
        int n6 = f.xl().xD();
        int n7 = d.g().al.hW();
        Object object = "Loading ...";
        if (d.g().bi != null && d.g().bi.Ue != null) {
            HashSet<String> hashSet = new HashSet<String>();
            for (Object object2 : d.g().bi.Ue.sD()) {
                if (((zl)object2).sN()) continue;
                for (zn zn2 : ((zl)object2).sP()) {
                    hashSet.add(zn2.sR().getNamespacedID());
                }
            }
            object = "" + hashSet.size();
        }
        bce.e(commandSender, String.valueOf(ChatColor.GOLD) + "Data");
        bce.e(commandSender, String.valueOf(ChatColor.GRAY) + " - Items: " + String.valueOf(ChatColor.AQUA) + d.g().C.size());
        bce.e(commandSender, String.valueOf(ChatColor.GRAY) + " - Items in /ia: " + String.valueOf(ChatColor.AQUA) + (String)object);
        bce.e(commandSender, String.valueOf(ChatColor.GRAY) + " - Namespaces: " + String.valueOf(ChatColor.AQUA) + d.g().Z.size());
        bce.e(commandSender, String.valueOf(ChatColor.GRAY) + " - Materials: " + String.valueOf(ChatColor.AQUA) + d.g().N.size());
        if (ae.ar()) {
            int n8 = 0;
            for (Object object2 : d.g().S) {
                if (((ql)object2).FD == null || !((ql)object2).FD.oX()) continue;
                ++n8;
            }
            if (ae.cG) {
                bce.e(commandSender, String.valueOf(ChatColor.GRAY) + " - REAL: " + String.valueOf(ChatColor.AQUA) + n2 + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + "188");
            }
            if (ae.cI) {
                bce.e(commandSender, String.valueOf(ChatColor.GRAY) + " - REAL_NOTE: " + String.valueOf(ChatColor.AQUA) + n3 + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + "750");
            }
            if (ae.cH) {
                bce.e(commandSender, String.valueOf(ChatColor.GRAY) + " - REAL_TRANSPARENT: " + String.valueOf(ChatColor.AQUA) + n4 + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + "63");
            }
            if (ae.cJ) {
                bce.e(commandSender, String.valueOf(ChatColor.GRAY) + " - REAL_WIRE: " + String.valueOf(ChatColor.AQUA) + n5 + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + "127");
            }
            if (ae.cK) {
                bce.e(commandSender, String.valueOf(ChatColor.GRAY) + " - FIRE: " + String.valueOf(ChatColor.AQUA) + n6 + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + "14");
            }
            if (n8 > 0) {
                bce.e(commandSender, String.valueOf(ChatColor.GRAY) + " - Directional states: " + String.valueOf(ChatColor.AQUA) + n8);
            }
        }
        bce.e(commandSender, String.valueOf(ChatColor.GRAY) + " Font images: " + String.valueOf(ChatColor.AQUA) + n7 + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + d.g().al.uj);
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        for (zn zn2 : Bukkit.getWorlds()) {
            n11 += zn2.getLoadedChunks().length;
            for (LivingEntity livingEntity : zn2.getLivingEntities()) {
                ArmorStand armorStand;
                ItemStack itemStack;
                if (!(livingEntity instanceof ArmorStand) || (itemStack = (armorStand = (ArmorStand)livingEntity).getHelmet()) == null || !qm.isCustomItem(itemStack)) continue;
                ++n9;
            }
        }
        bce.e(commandSender, String.valueOf(ChatColor.GOLD) + "Loaded chunks " + String.valueOf(ChatColor.GRAY) + "(" + n11 + ")");
        bce.e(commandSender, String.valueOf(ChatColor.GRAY) + "     Armorstands: " + String.valueOf(ChatColor.AQUA) + n9);
        bce.e(commandSender, String.valueOf(ChatColor.GRAY) + "     Mobs: " + String.valueOf(ChatColor.AQUA) + n10);
        return true;
    }
}
