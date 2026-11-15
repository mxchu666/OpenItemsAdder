package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_4;
import itemsadder.m.ItemStackBridge_42;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.Opaque123;
import itemsadder.m.PermissibleBridge;
import itemsadder.m.PlayerBridge_30;
import itemsadder.m.PlayerBridge_31;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.PluginFileConfigurationHolder;
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

public class PlayerBridge_29 {
    final Plugin SY;
    final ItemStackRegistry SZ;
    static final int Ta = 45;
    final LinkedList Tb = new LinkedList();
    final Map Tc = new HashMap();
    public final LinkedHashMap Td = new LinkedHashMap();
    String yT;
    final Component Te;
    public static PermissibleBridge Tf;
    final ItemStackBridge_42 Tg;
    public final HashMap Th = new HashMap();
    int Ti;

    public PlayerBridge_29(Plugin plugin, ItemStackRegistry itemStackRegistry, ItemStackBridge_42 itemStackBridge_42) {
        this.SY = plugin;
        this.SZ = itemStackRegistry;
        this.Tg = itemStackBridge_42;
        this.yT = Main.PQ.ir("ia-title-menu-categories");
        this.Te = PluginBridge_6.gF(itemStackBridge_42.Ub.hc("settings.category_view.title_color") + Main.PQ.ir("ia-search-results"));
        int n = itemStackBridge_42.Ub.gW("settings.categories_view.title_position_pixels");
        int n2 = itemStackBridge_42.Ub.gW("settings.categories_view.font_image.x_position_pixels");
        this.yT = itemStackBridge_42.Ub.he("settings.categories_view.title_color") + this.yT;
        if (Tf == null) {
            CommandSenderBridge_5.error(String.valueOf(ChatColor.RED) + "GUI error: can't find font_image. Check ia_gui.yml, attribute: " + String.valueOf(ChatColor.AQUA) + "settings.categories_view.font_image.name");
        } else {
            this.yT = String.valueOf(ChatColor.WHITE) + Opaque123.c(Tf.if(), n2) + Opaque123.c(this.yT, -Tf.getWidth() + n);
        }
    }

    public PlayerBridge_30 dn(String string) {
        return (PlayerBridge_30)this.Tc.get(string);
    }

    public LinkedList sD() {
        return this.Tb;
    }

    public List sE() {
        return new ArrayList(this.Tc.keySet());
    }

    public void sF() {
        for (ItemStackBuilder_4 itemStackBuilder_4 : this.SZ.C.values()) {
            Object object;
            if (itemStackBuilder_4 == null) {
                if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "Item '" + String.valueOf(ChatColor.AQUA) + itemStackBuilder_4.getNamespacedID() + String.valueOf(ChatColor.YELLOW) + " 'not found for ia_gui.yml");
                continue;
            }
            if (itemStackBuilder_4 instanceof LocationBridgeBuilder_2) {
                object = (LocationBridgeBuilder_2)itemStackBuilder_4;
                if (((LocationBridgeBuilder_2)object).FD != null && ((LocationBridgeBuilder_2)object).FD.oX()) continue;
            }
            if (!itemStackBuilder_4.nw()) continue;
            object = new PlayerBridge_31(this.Tg, this, itemStackBuilder_4, itemStackBuilder_4.fz().z("items." + itemStackBuilder_4.getId() + ".click_in_ia_gui", true));
            this.Td.put(itemStackBuilder_4.getNamespacedID(), object);
        }
    }

    public void sG() {
        for (Map.Entry entry : this.Td.entrySet()) {
            ((PlayerBridge_31)entry.getValue()).sG();
        }
    }

    public void sH() {
        int n = 0;
        PluginFileConfigurationHolder pluginFileConfigurationHolder = this.Tg.Ub;
        for (String string : pluginFileConfigurationHolder.gR("categories")) {
            Object object;
            Object object2;
            String string2;
            String string3 = "categories." + string;
            if (!pluginFileConfigurationHolder.z(string3 + ".enabled", true)) continue;
            String string4 = pluginFileConfigurationHolder.gV(string3 + ".icon");
            ItemStack itemStack = this.SZ.q(string4);
            Component component = null;
            if (pluginFileConfigurationHolder.gP(string3 + ".name") && (string2 = pluginFileConfigurationHolder.az(string3 + ".name", null)) != null) {
                component = ItemStackRegistry.g().bg.al(string2) ? ItemStackRegistry.g().bg.ah(string2) : PluginBridge_6.gK(string2);
            }
            string2 = null;
            if (pluginFileConfigurationHolder.gP(string3 + ".title") && (object2 = pluginFileConfigurationHolder.az(string3 + ".title", null)) != null) {
                string2 = ItemStackRegistry.g().bg.al((String)object2) ? ItemStackRegistry.g().bg.ah((String)object2) : PluginBridge_6.gK((String)object2);
            }
            if (component == null) {
                component = Component.empty().append((Component)string2);
            }
            if (string2 == null) {
                string2 = component;
            }
            if (component == null && string2 == null) {
                string2 = PluginBridge_6.gK(string);
                component = PluginBridge_6.gK(string);
            }
            object2 = new PlayerBridge_30(string, pluginFileConfigurationHolder.az(string3 + ".permission_suffix", null), pluginFileConfigurationHolder.az(string3 + ".permission", null), this, itemStack, component, (Component)string2, string4, pluginFileConfigurationHolder.nh());
            if (pluginFileConfigurationHolder.gY(string3 + ".show_all_items")) {
                ((PlayerBridge_30)object2).Tx.addAll(this.Td.values());
                ((PlayerBridge_30)object2).aH(true);
            } else {
                for (Object object3 : pluginFileConfigurationHolder.hg(string3 + ".items")) {
                    object = this.SZ.e((String)object3);
                    if (object == null) {
                        if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                        CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "Item '" + String.valueOf(ChatColor.AQUA) + (String)object3 + String.valueOf(ChatColor.YELLOW) + " 'not found for ia_gui.yml");
                        continue;
                    }
                    ((PlayerBridge_30)object2).a(((ItemStackBuilder_4)object).getNamespacedID(), (PlayerBridge_31)this.Td.get(((ItemStackBuilder_4)object).getNamespacedID()));
                }
            }
            if (pluginFileConfigurationHolder.gP(string3 + ".hide_items")) {
                Object object3;
                List list = pluginFileConfigurationHolder.hg(string3 + ".hide_items");
                object3 = list.iterator();
                while (object3.hasNext()) {
                    object = (String)object3.next();
                    ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e((String)object);
                    if (itemStackBuilder_4 != null) {
                        ((PlayerBridge_30)object2).do(itemStackBuilder_4.getNamespacedID());
                        continue;
                    }
                    if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                    CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "Item '" + String.valueOf(ChatColor.AQUA) + (String)object + String.valueOf(ChatColor.YELLOW) + " 'not found for ia_gui.yml");
                }
            }
            this.Tb.add(object2);
            this.Tc.put(string, object2);
            ++n;
        }
        if (Main.KO.gY("debug.categories.log-file-loaded")) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "[Content] Loaded " + n + " categories from (" + pluginFileConfigurationHolder.nh() + ")");
        }
    }

    /*
     * WARNING - void declaration
     */
    public void sI() {
        for (Object object : ItemStackRegistry.g().b()) {
            if (!((PluginFileConfigurationHolder)object).gP("categories")) continue;
            int n = 0;
            for (String string : ((PluginFileConfigurationHolder)object).gR("categories")) {
                PlayerBridge_30 playerBridge_30;
                Map.Entry entry3;
                Object object3;
                Object object422;
                Object object5;
                String string2 = "categories." + string;
                if (!this.Tc.containsKey(string)) {
                    void var11_21;
                    void var11_17;
                    String string3;
                    if (!((PluginFileConfigurationHolder)object).z(string2 + ".enabled", true)) continue;
                    object5 = ((PluginFileConfigurationHolder)object).az(string2 + ".icon", null);
                    object422 = this.SZ.q((String)object5);
                    object3 = null;
                    if (((PluginFileConfigurationHolder)object).gP(string2 + ".name") && (string3 = ((PluginFileConfigurationHolder)object).az(string2 + ".name", null)) != null) {
                        object3 = ItemStackRegistry.g().bg.al(string3) ? ItemStackRegistry.g().bg.ah(string3) : PluginBridge_6.gK(string3);
                    }
                    Object var11_14 = null;
                    if (((PluginFileConfigurationHolder)object).gP(string2 + ".title") && (entry3 = ((PluginFileConfigurationHolder)object).az(string2 + ".title", null)) != null) {
                        if (ItemStackRegistry.g().bg.al((String)((Object)entry3))) {
                            Component component = ItemStackRegistry.g().bg.ah((String)((Object)entry3));
                        } else {
                            Component component = PluginBridge_6.gK((String)((Object)entry3));
                        }
                    }
                    if (object3 == null) {
                        object3 = var11_17;
                    }
                    if (var11_17 == null) {
                        Component component = object3;
                    }
                    if (object3 == null) {
                        Component component = PluginBridge_6.gK(string);
                        object3 = PluginBridge_6.gK(string);
                    }
                    playerBridge_30 = new PlayerBridge_30(string, ((PluginFileConfigurationHolder)object).az(string2 + ".permission_suffix", null), ((PluginFileConfigurationHolder)object).az(string2 + ".permission", null), this, (ItemStack)object422, (Component)object3, (Component)var11_21, (String)object5, ((PluginFileConfigurationHolder)object).nh());
                    playerBridge_30.j(((PluginFileConfigurationHolder)object).az(string2 + ".font_image.name", null), ((PluginFileConfigurationHolder)object).t(string2 + ".font_image.x_position_pixels", -1));
                    playerBridge_30.aC(((PluginFileConfigurationHolder)object).t(string2 + ".title_position_pixels", -1));
                    this.Tb.add(playerBridge_30);
                    this.Tc.put(string, playerBridge_30);
                    ++n;
                } else {
                    if (((PluginFileConfigurationHolder)object).z(string2 + ".skip_if_already", false)) {
                        if (!Main.KO.gY("debug.categories.log-single-skip")) continue;
                        CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "Category '" + string + "' already exists. Skipped because skip_if_already=true (" + ((PluginFileConfigurationHolder)object).nh() + ")");
                        continue;
                    }
                    playerBridge_30 = (PlayerBridge_30)this.Tc.get(string);
                    if (!playerBridge_30.sL()) {
                        object5 = ((PluginFileConfigurationHolder)object).az(string2 + ".icon", null);
                        object422 = this.SZ.q((String)object5);
                        playerBridge_30.U((ItemStack)object422);
                    }
                    if (Main.KO.gY("debug.categories.log-single-loaded-overwrite")) {
                        CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "Category '" + string + "' already exists. Adding items to it (" + ((PluginFileConfigurationHolder)object).nh() + ")");
                    }
                }
                for (Object object422 : ((PluginFileConfigurationHolder)object).hg(string2 + ".items")) {
                    ItemStackBuilder_4 itemStackBuilder_4;
                    if (((String)object422).startsWith("*") || ((String)object422).endsWith("*")) {
                        for (Map.Entry entry2 : this.SZ.C.entrySet()) {
                            entry3 = (ItemStackBuilder_4)entry2.getValue();
                            if (entry3 instanceof LocationBridgeBuilder_2) {
                                itemStackBuilder_4 = (LocationBridgeBuilder_2)((Object)entry3);
                                if (((LocationBridgeBuilder_2)itemStackBuilder_4).FD != null && ((LocationBridgeBuilder_2)itemStackBuilder_4).FD.oX()) continue;
                            }
                            if (!FilenameUtils.wildcardMatch((String)((ItemStackBuilder_4)((Object)entry3)).Gh, (String)object422) || playerBridge_30.dp(((ItemStackBuilder_4)((Object)entry3)).getNamespacedID())) continue;
                            playerBridge_30.a(((ItemStackBuilder_4)((Object)entry3)).getNamespacedID(), (PlayerBridge_31)this.Td.get(((ItemStackBuilder_4)((Object)entry3)).getNamespacedID()));
                        }
                        continue;
                    }
                    if (ColorBridge.iU((String)object422)) {
                        object3 = Pattern.compile((String)object422);
                        for (Map.Entry entry3 : this.SZ.C.entrySet()) {
                            itemStackBuilder_4 = (ItemStackBuilder_4)entry3.getValue();
                            if (itemStackBuilder_4 instanceof LocationBridgeBuilder_2) {
                                ItemStackBuilder_4 itemStackBuilder_42 = itemStackBuilder_4;
                                if (((LocationBridgeBuilder_2)itemStackBuilder_42).FD != null && ((LocationBridgeBuilder_2)itemStackBuilder_42).FD.oX()) continue;
                            }
                            if (!((Pattern)object3).matcher(itemStackBuilder_4.Gh).matches() || playerBridge_30.dp(itemStackBuilder_4.getNamespacedID())) continue;
                            playerBridge_30.a(itemStackBuilder_4.getNamespacedID(), (PlayerBridge_31)this.Td.get(itemStackBuilder_4.getNamespacedID()));
                        }
                        continue;
                    }
                    object3 = this.SZ.e((String)object422);
                    if (object3 == null) {
                        if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                        CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "Item '" + String.valueOf(ChatColor.AQUA) + (String)object422 + String.valueOf(ChatColor.YELLOW) + " 'not found for ia_gui.yml");
                        continue;
                    }
                    if (object3 instanceof LocationBridgeBuilder_2) {
                        LocationBridgeBuilder_2 locationBridgeBuilder_2 = (LocationBridgeBuilder_2)object3;
                        if (locationBridgeBuilder_2.FD != null && locationBridgeBuilder_2.FD.oX()) continue;
                    }
                    if (playerBridge_30.dp(((ItemStackBuilder_4)object3).getNamespacedID())) continue;
                    playerBridge_30.a(((ItemStackBuilder_4)object3).getNamespacedID(), (PlayerBridge_31)this.Td.get(((ItemStackBuilder_4)object3).getNamespacedID()));
                }
                if (((PluginFileConfigurationHolder)object).gP(string2 + ".hide_items")) {
                    object5 = ((PluginFileConfigurationHolder)object).hg(string2 + ".hide_items");
                    object422 = object5.iterator();
                    while (object422.hasNext()) {
                        object3 = (String)object422.next();
                        playerBridge_30.do((String)object3);
                    }
                }
                if (!Main.KO.gY("debug.other.log-ia-gui-category-loading")) continue;
                CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "Loaded category '" + string + "' (" + ((PluginFileConfigurationHolder)object).nh() + ")");
            }
            if (!Main.KO.z("debug.categories.log-file-loaded", false)) continue;
            CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "[Content] Loaded " + String.valueOf(ChatColor.AQUA) + n + String.valueOf(ChatColor.GREEN) + " categories (" + ((PluginFileConfigurationHolder)object).nh() + ")");
        }
        if (Main.KO.gY("debug.categories.log-icon-failed-load")) {
            for (Object object : this.Tb) {
                if (!((PlayerBridge_30)object).sL()) {
                    CommandSenderBridge_5.warn("Failed to find icon '" + ((PlayerBridge_30)object).TC + "' for category '" + String.valueOf(((PlayerBridge_30)object).Tu) + "'. File: " + ((PlayerBridge_30)object).TD);
                }
                ((PlayerBridge_30)object).TC = null;
                ((PlayerBridge_30)object).TD = null;
            }
        }
    }

    public void sJ() {
        if (Main.KO.z("debug.categories.log-total-loaded", false)) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "[Content] Loaded " + String.valueOf(ChatColor.AQUA) + this.Tb.size() + String.valueOf(ChatColor.GREEN) + " categories");
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
        this.Ti = ColorBridge.g(this.Tb.size(), 45.0f);
        ItemStackBridge_4 itemStackBridge_4 = new ItemStackBridge_4(54, this.yT);
        for (int i = n2; i < n2 + 45 && i < this.Tb.size(); ++i) {
            if (((PlayerBridge_30)this.Tb.get(i)).getPermission() != null && !player.hasPermission(((PlayerBridge_30)this.Tb.get(i)).getPermission())) continue;
            ((PlayerBridge_30)this.Tb.get(i)).sM();
            int n3 = i;
            itemStackBridge_4.a(((PlayerBridge_30)this.Tb.get(i)).sO(), (T inventoryClickEvent) -> ((PlayerBridge_30)this.Tb.get(n3)).k((Player)inventoryClickEvent.getWhoClicked(), bl));
        }
        if (s.bm(player)) {
            itemStackBridge_4.a(49, ItemStackBridge_42.Ui, (T inventoryClickEvent) -> this.bz(player));
        }
        if (n > 0) {
            itemStackBridge_4.a(52, ItemStackBridge_42.Ug, (T inventoryClickEvent) -> {
                this.bx(player);
                this.bw(player);
            });
        }
        if (n + 1 < this.Ti) {
            itemStackBridge_4.a(53, ItemStackBridge_42.Uh, (T inventoryClickEvent) -> {
                this.by(player);
                this.bw(player);
            });
        }
        itemStackBridge_4.cG(player);
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
        ArrayList<PlayerBridge_31> arrayList = new ArrayList<PlayerBridge_31>();
        for (Map.Entry entry : this.Td.entrySet()) {
            try {
                String string2;
                ItemStackBuilder_4 itemStackBuilder_4 = ((PlayerBridge_31)entry.getValue()).sR();
                if (!itemStackBuilder_4.getNamespacedID().toLowerCase().contains(string) && !ChatColor.stripColor((String)itemStackBuilder_4.getItemMeta().getDisplayName().toLowerCase()).contains(string) || ((string2 = itemStackBuilder_4.nf()) != null || !bl) && !s.a((HumanEntity)player, string2)) continue;
                arrayList.add((PlayerBridge_31)entry.getValue());
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
            PlayerBridge_30 playerBridge_30 = new PlayerBridge_30("__internal_search_results", null, null, this, null, this.Te, this.Te, null, null);
            playerBridge_30.Tx.addAll(this.b(stringBuilder.toString(), (Player)player));
            Bukkit.getScheduler().runTaskLater(this.SY, () -> playerBridge_30.k((Player)player, false), 0L);
            return true;
        }).sT();
    }

    public void sK() {
        ListIterator<PlayerBridge_30> listIterator;
        ArrayList<Object> arrayList;
        boolean bl = ItemStackBridge_42.Uj;
        boolean bl2 = ItemStackBridge_42.Uk;
        if (bl2) {
            arrayList = new ArrayList<Object>();
            for (Object object : ItemStackBridge_42.Ul) {
                PlayerBridge_30 playerBridge_302 = (PlayerBridge_30)this.Tc.get(object);
                if (playerBridge_302 == null || !this.Tb.contains(playerBridge_302)) continue;
                arrayList.add(playerBridge_302);
            }
            listIterator = new ArrayList();
            for (PlayerBridge_30 playerBridge_302 : this.Tb) {
                if (arrayList.contains(playerBridge_302)) continue;
                listIterator.add(playerBridge_302);
            }
            if (bl) {
                listIterator.sort(Comparator.comparing(playerBridge_30 -> playerBridge_30.Tn.toLowerCase()));
            }
            arrayList.addAll((Collection<Object>)((Object)listIterator));
            this.Tb.clear();
            this.Tb.addAll(arrayList);
        } else if (bl) {
            this.Tb.sort(Comparator.comparing(playerBridge_30 -> playerBridge_30.Tn.toLowerCase()));
        }
        if (!ItemStackBridge_42.Ul.contains("all")) {
            arrayList = new ArrayList();
            listIterator = this.Tb.listIterator();
            while (listIterator.hasNext()) {
                Object object;
                object = (PlayerBridge_30)listIterator.next();
                if (!((PlayerBridge_30)object).sN()) continue;
                arrayList.add(object);
                listIterator.remove();
            }
            this.Tb.addAll(arrayList);
        }
    }
}
