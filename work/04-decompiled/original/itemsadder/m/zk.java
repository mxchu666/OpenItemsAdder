package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.bbe;
import itemsadder.m.bbf;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.bio;
import itemsadder.m.d;
import itemsadder.m.fw;
import itemsadder.m.il;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.zl;
import itemsadder.m.zn;
import itemsadder.m.zo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Pattern;
import net.kyori.adventure.text.Component;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class zk {
    final Plugin SY;
    final d SZ;
    static final int Ta = 45;
    final LinkedList Tb = new LinkedList();
    final Map Tc = new HashMap();
    public final LinkedHashMap Td = new LinkedHashMap();
    String yT;
    final Component Te;
    public static fw Tf;
    final zo Tg;
    public final HashMap Th = new HashMap();
    int Ti;

    public zk(Plugin plugin, d d2, zo zo2) {
        this.SY = plugin;
        this.SZ = d2;
        this.Tg = zo2;
        this.yT = Main.PQ.ir("ia-title-menu-categories");
        this.Te = bbe.gF(zo2.Ub.hc("settings.category_view.title_color") + Main.PQ.ir("ia-search-results"));
        int n = zo2.Ub.gW("settings.categories_view.title_position_pixels");
        int n2 = zo2.Ub.gW("settings.categories_view.font_image.x_position_pixels");
        this.yT = zo2.Ub.he("settings.categories_view.title_color") + this.yT;
        if (Tf == null) {
            bce.error(String.valueOf(ChatColor.RED) + "GUI error: can't find font_image. Check ia_gui.yml, attribute: " + String.valueOf(ChatColor.AQUA) + "settings.categories_view.font_image.name");
        } else {
            this.yT = String.valueOf(ChatColor.WHITE) + il.c(Tf.if(), n2) + il.c(this.yT, -Tf.getWidth() + n);
        }
    }

    public zl dn(String string) {
        return (zl)this.Tc.get(string);
    }

    public LinkedList sD() {
        return this.Tb;
    }

    public List sE() {
        return new ArrayList(this.Tc.keySet());
    }

    public void sF() {
        for (qm qm2 : this.SZ.C.values()) {
            Object object;
            if (qm2 == null) {
                if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                bce.log(String.valueOf(ChatColor.YELLOW) + "Item '" + String.valueOf(ChatColor.AQUA) + qm2.getNamespacedID() + String.valueOf(ChatColor.YELLOW) + " 'not found for ia_gui.yml");
                continue;
            }
            if (qm2 instanceof ql) {
                object = (ql)qm2;
                if (((ql)object).FD != null && ((ql)object).FD.oX()) continue;
            }
            if (!qm2.nw()) continue;
            object = new zn(this.Tg, this, qm2, qm2.fz().z("items." + qm2.getId() + ".click_in_ia_gui", true));
            this.Td.put(qm2.getNamespacedID(), object);
        }
    }

    public void sG() {
        for (Map.Entry entry : this.Td.entrySet()) {
            ((zn)entry.getValue()).sG();
        }
    }

    public void sH() {
        int n = 0;
        bbf bbf2 = this.Tg.Ub;
        for (String string : bbf2.gR("categories")) {
            Object object;
            Object object2;
            String string2;
            String string3 = "categories." + string;
            if (!bbf2.z(string3 + ".enabled", true)) continue;
            String string4 = bbf2.gV(string3 + ".icon");
            ItemStack itemStack = this.SZ.q(string4);
            Component component = null;
            if (bbf2.gP(string3 + ".name") && (string2 = bbf2.az(string3 + ".name", null)) != null) {
                component = d.g().bg.al(string2) ? d.g().bg.ah(string2) : bbe.gK(string2);
            }
            string2 = null;
            if (bbf2.gP(string3 + ".title") && (object2 = bbf2.az(string3 + ".title", null)) != null) {
                string2 = d.g().bg.al((String)object2) ? d.g().bg.ah((String)object2) : bbe.gK((String)object2);
            }
            if (component == null) {
                component = Component.empty().append((Component)string2);
            }
            if (string2 == null) {
                string2 = component;
            }
            if (component == null && string2 == null) {
                string2 = bbe.gK(string);
                component = bbe.gK(string);
            }
            object2 = new zl(string, bbf2.az(string3 + ".permission_suffix", null), bbf2.az(string3 + ".permission", null), this, itemStack, component, (Component)string2, string4, bbf2.nh());
            if (bbf2.gY(string3 + ".show_all_items")) {
                ((zl)object2).Tx.addAll(this.Td.values());
                ((zl)object2).aH(true);
            } else {
                for (Object object3 : bbf2.hg(string3 + ".items")) {
                    object = this.SZ.e((String)object3);
                    if (object == null) {
                        if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                        bce.log(String.valueOf(ChatColor.YELLOW) + "Item '" + String.valueOf(ChatColor.AQUA) + (String)object3 + String.valueOf(ChatColor.YELLOW) + " 'not found for ia_gui.yml");
                        continue;
                    }
                    ((zl)object2).a(((qm)object).getNamespacedID(), (zn)this.Td.get(((qm)object).getNamespacedID()));
                }
            }
            if (bbf2.gP(string3 + ".hide_items")) {
                Object object3;
                List list = bbf2.hg(string3 + ".hide_items");
                object3 = list.iterator();
                while (object3.hasNext()) {
                    object = (String)object3.next();
                    qm qm2 = d.g().e((String)object);
                    if (qm2 != null) {
                        ((zl)object2).do(qm2.getNamespacedID());
                        continue;
                    }
                    if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                    bce.log(String.valueOf(ChatColor.YELLOW) + "Item '" + String.valueOf(ChatColor.AQUA) + (String)object + String.valueOf(ChatColor.YELLOW) + " 'not found for ia_gui.yml");
                }
            }
            this.Tb.add(object2);
            this.Tc.put(string, object2);
            ++n;
        }
        if (Main.KO.gY("debug.categories.log-file-loaded")) {
            bce.log(String.valueOf(ChatColor.GREEN) + "[Content] Loaded " + n + " categories from (" + bbf2.nh() + ")");
        }
    }

    /*
     * WARNING - void declaration
     */
    public void sI() {
        for (Object object : d.g().b()) {
            if (!((bbf)object).gP("categories")) continue;
            int n = 0;
            for (String string : ((bbf)object).gR("categories")) {
                zl zl2;
                Map.Entry entry3;
                Object object3;
                Object object422;
                Object object5;
                String string2 = "categories." + string;
                if (!this.Tc.containsKey(string)) {
                    void var11_21;
                    void var11_17;
                    String string3;
                    if (!((bbf)object).z(string2 + ".enabled", true)) continue;
                    object5 = ((bbf)object).az(string2 + ".icon", null);
                    object422 = this.SZ.q((String)object5);
                    object3 = null;
                    if (((bbf)object).gP(string2 + ".name") && (string3 = ((bbf)object).az(string2 + ".name", null)) != null) {
                        object3 = d.g().bg.al(string3) ? d.g().bg.ah(string3) : bbe.gK(string3);
                    }
                    Object var11_14 = null;
                    if (((bbf)object).gP(string2 + ".title") && (entry3 = ((bbf)object).az(string2 + ".title", null)) != null) {
                        if (d.g().bg.al((String)((Object)entry3))) {
                            Component component = d.g().bg.ah((String)((Object)entry3));
                        } else {
                            Component component = bbe.gK((String)((Object)entry3));
                        }
                    }
                    if (object3 == null) {
                        object3 = var11_17;
                    }
                    if (var11_17 == null) {
                        Component component = object3;
                    }
                    if (object3 == null) {
                        Component component = bbe.gK(string);
                        object3 = bbe.gK(string);
                    }
                    zl2 = new zl(string, ((bbf)object).az(string2 + ".permission_suffix", null), ((bbf)object).az(string2 + ".permission", null), this, (ItemStack)object422, (Component)object3, (Component)var11_21, (String)object5, ((bbf)object).nh());
                    zl2.j(((bbf)object).az(string2 + ".font_image.name", null), ((bbf)object).t(string2 + ".font_image.x_position_pixels", -1));
                    zl2.aC(((bbf)object).t(string2 + ".title_position_pixels", -1));
                    this.Tb.add(zl2);
                    this.Tc.put(string, zl2);
                    ++n;
                } else {
                    if (((bbf)object).z(string2 + ".skip_if_already", false)) {
                        if (!Main.KO.gY("debug.categories.log-single-skip")) continue;
                        bce.log(String.valueOf(ChatColor.YELLOW) + "Category '" + string + "' already exists. Skipped because skip_if_already=true (" + ((bbf)object).nh() + ")");
                        continue;
                    }
                    zl2 = (zl)this.Tc.get(string);
                    if (!zl2.sL()) {
                        object5 = ((bbf)object).az(string2 + ".icon", null);
                        object422 = this.SZ.q((String)object5);
                        zl2.U((ItemStack)object422);
                    }
                    if (Main.KO.gY("debug.categories.log-single-loaded-overwrite")) {
                        bce.log(String.valueOf(ChatColor.GREEN) + "Category '" + string + "' already exists. Adding items to it (" + ((bbf)object).nh() + ")");
                    }
                }
                for (Object object422 : ((bbf)object).hg(string2 + ".items")) {
                    qm qm2;
                    if (((String)object422).startsWith("*") || ((String)object422).endsWith("*")) {
                        for (Map.Entry entry2 : this.SZ.C.entrySet()) {
                            entry3 = (qm)entry2.getValue();
                            if (entry3 instanceof ql) {
                                qm2 = (ql)((Object)entry3);
                                if (((ql)qm2).FD != null && ((ql)qm2).FD.oX()) continue;
                            }
                            if (!FilenameUtils.wildcardMatch((String)((qm)((Object)entry3)).Gh, (String)object422) || zl2.dp(((qm)((Object)entry3)).getNamespacedID())) continue;
                            zl2.a(((qm)((Object)entry3)).getNamespacedID(), (zn)this.Td.get(((qm)((Object)entry3)).getNamespacedID()));
                        }
                        continue;
                    }
                    if (bcy.iU((String)object422)) {
                        object3 = Pattern.compile((String)object422);
                        for (Map.Entry entry3 : this.SZ.C.entrySet()) {
                            qm2 = (qm)entry3.getValue();
                            if (qm2 instanceof ql) {
                                qm qm3 = qm2;
                                if (((ql)qm3).FD != null && ((ql)qm3).FD.oX()) continue;
                            }
                            if (!((Pattern)object3).matcher(qm2.Gh).matches() || zl2.dp(qm2.getNamespacedID())) continue;
                            zl2.a(qm2.getNamespacedID(), (zn)this.Td.get(qm2.getNamespacedID()));
                        }
                        continue;
                    }
                    object3 = this.SZ.e((String)object422);
                    if (object3 == null) {
                        if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                        bce.log(String.valueOf(ChatColor.YELLOW) + "Item '" + String.valueOf(ChatColor.AQUA) + (String)object422 + String.valueOf(ChatColor.YELLOW) + " 'not found for ia_gui.yml");
                        continue;
                    }
                    if (object3 instanceof ql) {
                        ql ql2 = (ql)object3;
                        if (ql2.FD != null && ql2.FD.oX()) continue;
                    }
                    if (zl2.dp(((qm)object3).getNamespacedID())) continue;
                    zl2.a(((qm)object3).getNamespacedID(), (zn)this.Td.get(((qm)object3).getNamespacedID()));
                }
                if (((bbf)object).gP(string2 + ".hide_items")) {
                    object5 = ((bbf)object).hg(string2 + ".hide_items");
                    object422 = object5.iterator();
                    while (object422.hasNext()) {
                        object3 = (String)object422.next();
                        zl2.do((String)object3);
                    }
                }
                if (!Main.KO.gY("debug.other.log-ia-gui-category-loading")) continue;
                bce.log(String.valueOf(ChatColor.GREEN) + "Loaded category '" + string + "' (" + ((bbf)object).nh() + ")");
            }
            if (!Main.KO.z("debug.categories.log-file-loaded", false)) continue;
            bce.log(String.valueOf(ChatColor.GREEN) + "[Content] Loaded " + String.valueOf(ChatColor.AQUA) + n + String.valueOf(ChatColor.GREEN) + " categories (" + ((bbf)object).nh() + ")");
        }
        if (Main.KO.gY("debug.categories.log-icon-failed-load")) {
            for (Object object : this.Tb) {
                if (!((zl)object).sL()) {
                    bce.warn("Failed to find icon '" + ((zl)object).TC + "' for category '" + String.valueOf(((zl)object).Tu) + "'. File: " + ((zl)object).TD);
                }
                ((zl)object).TC = null;
                ((zl)object).TD = null;
            }
        }
    }

    public void sJ() {
        if (Main.KO.z("debug.categories.log-total-loaded", false)) {
            bce.log(String.valueOf(ChatColor.GREEN) + "[Content] Loaded " + String.valueOf(ChatColor.AQUA) + this.Tb.size() + String.valueOf(ChatColor.GREEN) + " categories");
        }
    }

    public void bw(Player player) {
        this.j(player, false);
    }

    public void j(Player player, boolean bl) {
        int n;
        if (!this.Th.containsKey(player.getUniqueId())) {
            this.Th.put(player.getUniqueId(), 0);
            n = 0;
        } else {
            n = (Integer)this.Th.get(player.getUniqueId());
        }
        int n2 = n * 45;
        this.Ti = bcy.g(this.Tb.size(), 45.0f);
        bio bio2 = new bio(54, this.yT);
        for (int i = n2; i < n2 + 45 && i < this.Tb.size(); ++i) {
            if (((zl)this.Tb.get(i)).getPermission() != null && !player.hasPermission(((zl)this.Tb.get(i)).getPermission())) continue;
            ((zl)this.Tb.get(i)).sM();
            int n3 = i;
            bio2.a(((zl)this.Tb.get(i)).sO(), (T inventoryClickEvent) -> ((zl)this.Tb.get(n3)).k((Player)inventoryClickEvent.getWhoClicked(), bl));
        }
        if (s.bm(player)) {
            bio2.a(49, zo.Ui, (T inventoryClickEvent) -> this.bz(player));
        }
        if (n > 0) {
            bio2.a(52, zo.Ug, (T inventoryClickEvent) -> {
                this.bx(player);
                this.bw(player);
            });
        }
        if (n + 1 < this.Ti) {
            bio2.a(53, zo.Uh, (T inventoryClickEvent) -> {
                this.by(player);
                this.bw(player);
            });
        }
        bio2.cG(player);
    }

    void bx(Player player) {
        if (this.Th.containsKey(player.getUniqueId())) {
            int n = (Integer)this.Th.get(player.getUniqueId());
            if (n - 1 >= 0) {
                this.Th.put(player.getUniqueId(), n - 1);
            }
        } else {
            this.Th.put(player.getUniqueId(), 0);
        }
    }

    void by(Player player) {
        if (this.Th.containsKey(player.getUniqueId())) {
            int n = (Integer)this.Th.get(player.getUniqueId());
            if (n * 45 < this.Tb.size() - 1) {
                this.Th.put(player.getUniqueId(), n + 1);
            }
        } else {
            this.Th.put(player.getUniqueId(), 0);
        }
    }

    public List b(String string, Player player) {
        string = string.toLowerCase();
        boolean bl = s.bn(player);
        ArrayList<zn> arrayList = new ArrayList<zn>();
        for (Map.Entry entry : this.Td.entrySet()) {
            try {
                String string2;
                qm qm2 = ((zn)entry.getValue()).sR();
                if (!qm2.getNamespacedID().toLowerCase().contains(string) && !ChatColor.stripColor((String)qm2.getItemMeta().getDisplayName().toLowerCase()).contains(string) || ((string2 = qm2.nf()) != null || !bl) && !s.a((HumanEntity)player, string2)) continue;
                arrayList.add((zn)entry.getValue());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return arrayList;
    }

    public void bz(Player player2) {
        Main.rS().PR.a(player2, Collections.singletonList("")).sS().a((player, stringArray) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (String string : stringArray) {
                stringBuilder.append(string);
            }
            zl zl2 = new zl("__internal_search_results", null, null, this, null, this.Te, this.Te, null, null);
            zl2.Tx.addAll(this.b(stringBuilder.toString(), (Player)player));
            Bukkit.getScheduler().runTaskLater(this.SY, () -> zl2.k((Player)player, false), 0L);
            return true;
        }).sT();
    }

    public void sK() {
        ListIterator<zl> listIterator;
        ArrayList<Object> arrayList;
        boolean bl = zo.Uj;
        boolean bl2 = zo.Uk;
        if (bl2) {
            arrayList = new ArrayList<Object>();
            for (Object object : zo.Ul) {
                zl zl3 = (zl)this.Tc.get(object);
                if (zl3 == null || !this.Tb.contains(zl3)) continue;
                arrayList.add(zl3);
            }
            listIterator = new ArrayList();
            for (zl zl3 : this.Tb) {
                if (arrayList.contains(zl3)) continue;
                listIterator.add(zl3);
            }
            if (bl) {
                listIterator.sort(Comparator.comparing(zl2 -> zl2.Tn.toLowerCase()));
            }
            arrayList.addAll((Collection<Object>)((Object)listIterator));
            this.Tb.clear();
            this.Tb.addAll(arrayList);
        } else if (bl) {
            this.Tb.sort(Comparator.comparing(zl2 -> zl2.Tn.toLowerCase()));
        }
        if (!zo.Ul.contains("all")) {
            arrayList = new ArrayList();
            listIterator = this.Tb.listIterator();
            while (listIterator.hasNext()) {
                Object object;
                object = (zl)listIterator.next();
                if (!((zl)object).sN()) continue;
                arrayList.add(object);
                listIterator.remove();
            }
            this.Tb.addAll(arrayList);
        }
    }
}
