package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bcy;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.uw;
import itemsadder.m.vb;
import itemsadder.m.ve;
import itemsadder.m.vk;
import itemsadder.m.yp;
import itemsadder.m.za;
import itemsadder.m.zc;
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

public class xt
extends za {
    final WeakHashMap Sx = new WeakHashMap();

    public xt() {
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
            bce.f(commandSender, Main.PQ.ir("wrong-command-usage"));
            return;
        }
        block5 : switch (stringArray[0]) {
            case "item": {
                switch (stringArray[1]) {
                    case "delete": {
                        if (!s.b((Permissible)commandSender, "ia.admin.iaconfig.item.delete", true)) {
                            return;
                        }
                        this.a(commandSender, string, stringArray, bcy.gH("&cWARNING: if you delete this item you won't be able to use the command to delete recipes of this item.\nConsider using &6/iaconfig recipes deleteofitem " + stringArray[2] + "&c before."), true, qm2 -> {
                            qm2.fz().gQ("items." + qm2.getId());
                            qm2.fz().save();
                            bce.f(commandSender, bcy.gH("&aDeleted &e" + qm2.getNamespacedID() + "&a from file: &e" + qm2.nh()));
                            return true;
                        });
                        break;
                    }
                    case "disable": {
                        if (!s.b((Permissible)commandSender, "ia.admin.iaconfig.item.disable", true)) {
                            return;
                        }
                        this.a(commandSender, string, stringArray, bcy.gH("&cWARNING: if you disable this item you won't be able to use the command to disable/delete recipes of this item. You will have to re-enable it manually.\nConsider using &6/iaconfig recipes disableofitem " + stringArray[2] + "&c before."), true, qm2 -> {
                            qm2.fz().d("items." + qm2.getId() + ".enabled", false);
                            qm2.fz().save();
                            bce.f(commandSender, bcy.gH("&aDisabled &e" + qm2.getNamespacedID() + "&a from file: &e" + qm2.nh()));
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
                        this.b(commandSender, string, stringArray, String.valueOf(ChatColor.RED) + "WARNING: if you delete this namespace it will delete both items and recipes which use these items!", true, qm2 -> {
                            qm2.fz().gQ("items." + qm2.getId());
                            qm2.fz().save();
                            bce.f(commandSender, String.valueOf(ChatColor.GREEN) + "Deleted " + qm2.getNamespacedID() + " from file: " + qm2.nh());
                            int n = 0;
                            n += this.a(vk.class, (qm)qm2, this::c);
                            n += this.a(ve.class, (qm)qm2, this::c);
                            if ((n += this.a(vb.class, (qm)qm2, this::c)) > 0) {
                                bce.f(commandSender, bcy.gH("&aDeleted &e" + n + "&a recipes which use/create item &e" + qm2.getNamespacedID()));
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
                        this.b(commandSender, string, stringArray, null, false, qm2 -> {
                            qm2.fz().d("items." + qm2.getId() + ".enabled", false);
                            qm2.fz().save();
                            bce.f(commandSender, bcy.gH("&aDisabled &e" + qm2.getNamespacedID() + "&a from file: &e" + qm2.nh()));
                            int n = 0;
                            n += this.a(vk.class, (qm)qm2, this::d);
                            n += this.a(ve.class, (qm)qm2, this::d);
                            if ((n += this.a(vb.class, (qm)qm2, this::d)) > 0) {
                                bce.f(commandSender, bcy.gH("&aDisabled &e" + n + "&a recipes which use/create item &e" + qm2.getNamespacedID()));
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
                        this.a(commandSender, string, stringArray, null, false, qm2 -> {
                            int n = 0;
                            n += this.a(vk.class, (qm)qm2, this::c);
                            n += this.a(ve.class, (qm)qm2, this::c);
                            if ((n += this.a(vb.class, (qm)qm2, this::c)) > 0) {
                                bce.f(commandSender, bcy.gH("&aDeleted &e" + n + "&a recipes which use/create item &e" + qm2.getNamespacedID()));
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
                        this.a(commandSender, string, stringArray, null, false, qm2 -> {
                            int n = 0;
                            n += this.a(vk.class, (qm)qm2, this::d);
                            n += this.a(ve.class, (qm)qm2, this::d);
                            if ((n += this.a(vb.class, (qm)qm2, this::d)) > 0) {
                                bce.f(commandSender, bcy.gH("&aDisabled &e" + n + "&a recipes which use/create item &e" + qm2.getNamespacedID()));
                                return true;
                            }
                            return false;
                        });
                    }
                }
            }
        }
    }

    private Function c(uw uw2) {
        if (uw2.nP != null) {
            bce.log(bcy.gH("&eDeleted recipe: &2" + uw2.LY + "&e from file: &2" + uw2.nP.nh()));
            uw2.nP.gQ(uw2.LY);
        }
        return null;
    }

    private Function d(uw uw2) {
        if (uw2.nP != null) {
            bce.log(bcy.gH("&eDisabled recipe: &2" + uw2.LY + "&e from file: &2" + uw2.nP.nh()));
            uw2.nP.d(uw2.LY + ".enabled", false);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(CommandSender commandSender, String string, String[] stringArray, String string2, boolean bl, Function function) {
        String string3 = stringArray[2];
        if (!string3.contains(":")) {
            bce.f(commandSender, bcy.gH("&eSpecify the complete identifier for the item &2" + string3 + "&e. For example &2myitems:red_sword"));
            return;
        }
        qm qm2 = d.g().e(string3);
        if (qm2 == null) {
            bce.f(commandSender, String.valueOf(ChatColor.YELLOW) + "Can't find item " + string3);
            return;
        }
        zc zc2 = (zc)this.Sx.get(commandSender);
        if (zc2 == null || !zc2.c(string, stringArray)) {
            zc.a(this.Sx, commandSender, string, stringArray, string2);
            return;
        }
        if (!zc2.b(string, stringArray)) {
            zc.a(this.Sx, commandSender, string, stringArray, string2);
            return;
        }
        if (((Boolean)function.apply(qm2)).booleanValue()) {
            this.a(commandSender, bl);
            return;
        }
        bce.f(commandSender, bcy.gH("&eNo operation done for item &2" + qm2.getNamespacedID() + "&e, failed to find anything to change."));
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(CommandSender commandSender, String string, String[] stringArray, String string2, boolean bl, Function function) {
        String string3 = stringArray[2];
        if (string3.contains(":")) {
            bce.f(commandSender, String.valueOf(ChatColor.YELLOW) + "Specify enter a valid namespace.");
            return;
        }
        if (!d.g().Z.contains(string3)) {
            bce.f(commandSender, String.valueOf(ChatColor.YELLOW) + "Can't find namespace " + string3);
            return;
        }
        zc zc2 = (zc)this.Sx.get(commandSender);
        if (zc2 == null || !zc2.c(string, stringArray)) {
            zc.a(this.Sx, commandSender, string, stringArray, string2);
            return;
        }
        if (!zc2.b(string, stringArray)) {
            zc.a(this.Sx, commandSender, string, stringArray, string2);
            return;
        }
        boolean bl2 = false;
        HashMap hashMap = (HashMap)d.g().M.get(string3);
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String string4 = (String)entry.getKey();
                qm qm2 = (qm)entry.getValue();
                if (!((Boolean)function.apply(qm2)).booleanValue()) continue;
                bl2 = true;
            }
        }
        if (bl2) {
            this.a(commandSender, bl);
            return;
        }
        bce.f(commandSender, bcy.gH("&eNo operation done for namespace &2" + string3 + "&e, failed to find anything to change."));
    }

    private void a(CommandSender commandSender, boolean bl) {
        if (bl) {
            bce.f(commandSender, String.valueOf(ChatColor.YELLOW) + "WARNING: Textures and models are not automatically deleted from the resource_pack folder to avoid mistakes.");
        }
        bce.f(commandSender, String.valueOf(ChatColor.YELLOW) + "Reloading the plugin in 5 seconds...");
        bcp.c(() -> yp.a(false, () -> bce.f(commandSender, String.valueOf(ChatColor.GREEN) + "Reloaded plugin.")), 100L);
    }

    private int a(Class clazz, qm qm2, Function function) {
        int n = 0;
        for (uw uw2 : d.g().aW.b(clazz, qm2)) {
            function.apply(uw2);
            if (uw2.nP == null) continue;
            uw2.nP.save();
            ++n;
        }
        return n;
    }
}
