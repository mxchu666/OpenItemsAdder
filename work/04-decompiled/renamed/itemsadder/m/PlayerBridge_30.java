package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBridge_4;
import itemsadder.m.ItemStackBridge_42;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.Opaque123;
import itemsadder.m.Opaque151;
import itemsadder.m.PermissibleBridge;
import itemsadder.m.PlayerBridge_29;
import itemsadder.m.PlayerBridge_31;
import itemsadder.m.PlayerHolder_2;
import itemsadder.m.PluginBridge_6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers detected
 */
public class PlayerBridge_30 {
    public static PermissibleBridge Tj;
    public static int Tk;
    public static int Tl;
    static final int Tm = 45;
    public final String Tn;
    @Nullable
    private final String To;
    @Nullable
    private final String Tp;
    final PlayerBridge_29 Tq;
    public PermissibleBridge Tf;
    boolean Tr;
    boolean Ts;
    ItemStack Tt;
    Component Tu;
    Component Tv;
    String Tw;
    final ArrayList Tx = new ArrayList();
    final Map Ty = new HashMap();
    public final HashMap Tz = new HashMap();
    int Ti;
    private int TA;
    private int TB;
    @Nullable
    public String TC;
    @Nullable
    public String TD;

    public PlayerBridge_30(String string, @Nullable String string2, @Nullable String string3, PlayerBridge_29 playerBridge_29, @Nullable ItemStack itemStack, Component component, Component component2, @Nullable String string4, @Nullable String string5) {
        this.Tn = string;
        this.To = string2;
        this.Tp = string3;
        this.Tq = playerBridge_29;
        this.TC = string4;
        this.TD = string5;
        this.Tu = ((TextComponent)Component.empty().color(PluginBridge_6.azD)).append(component);
        this.U(itemStack);
        @Nullable TextColor textColor = playerBridge_29.Tg.Ub.hd("settings.category_view.title_color").color();
        this.Tv = component2.color() == PluginBridge_6.azD ? component2.color(textColor) : component2;
        if (this.Tv.font() != null) {
            CommandSenderBridge_5.warn("[Category] '" + string + "' 'title' has a custom font. This is not supported, the font will be ignored.");
        }
        this.j(null, -1);
    }

    private String getTitle() {
        if (this.Tw != null) {
            return this.Tw;
        }
        String string = ColorBridge.x(this.Tv);
        if (this.Tf == null) {
            CommandSenderBridge_5.error(String.valueOf(ChatColor.RED) + "GUI error: can't find font_image. Check ia_gui.yml, attribute: " + String.valueOf(ChatColor.AQUA) + "settings.category_view.font_image.name");
            this.Tw = ColorBridge.iV(string);
            return this.Tw;
        }
        this.Tw = String.valueOf(ChatColor.WHITE) + Opaque123.c(this.Tf.if(), this.TA) + Opaque123.c(string, -this.Tf.getWidth() + this.TB);
        return this.Tw;
    }

    public boolean sL() {
        return this.Ts;
    }

    public void sM() {
        if (this.Tt.getItemMeta().hasLore()) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(Main.PQ.ir("items-count").replace("{count}", "" + this.Tx.size()));
        ItemStackBridge_2.d(this.Tt, arrayList);
    }

    public boolean sN() {
        return this.Tr;
    }

    public void aH(boolean bl) {
        this.Tr = bl;
    }

    public ItemStack sO() {
        return this.Tt;
    }

    public void U(@Nullable ItemStack itemStack) {
        if (this.Ts) {
            return;
        }
        if (itemStack == null || itemStack.getType() == Material.AIR || itemStack.getAmount() == 0) {
            this.Tt = new ItemStack(Material.STONE);
            this.Ts = false;
        } else {
            this.Tt = itemStack;
            this.Ts = true;
        }
        this.Tt = PlayerHolder_2.tX().Y(this.Tt);
        ItemStackBridge_2.a(this.Tt, this.Tu);
    }

    public ArrayList sP() {
        return this.Tx;
    }

    public void a(String string, PlayerBridge_31 playerBridge_31) {
        this.Tx.add(playerBridge_31);
        this.Ty.put(string, playerBridge_31);
    }

    public void do(String string) {
        PlayerBridge_30.a(this.Ty, (List)this.Tx, string);
    }

    static void a(Map map, List list, String string) {
        if (string.indexOf(42) >= 0 || string.indexOf(63) >= 0) {
            map.entrySet().removeIf(entry -> {
                if (!FilenameUtils.wildcardMatch((String)((String)entry.getKey()), (String)string)) {
                    return false;
                }
                list.remove(entry.getValue());
                return true;
            });
            return;
        }
        Object v = map.remove(string);
        list.remove(v);
    }

    @Deprecated
    @Nullable
    public String getPermission() {
        if (this.Tp != null) {
            return this.Tp;
        }
        if (this.To == null) {
            return null;
        }
        return "ia.menu.seecategory." + this.To;
    }

    public void k(Player player, boolean bl) {
        Opaque151 opaque151 = this.Tz.computeIfAbsent(player.getUniqueId(), uUID -> new Opaque151(bl));
        int n = opaque151.sQ();
        this.Ti = ColorBridge.g(this.Tx.size(), 45.0f);
        ItemStackBridge_4 itemStackBridge_4 = new ItemStackBridge_4(54, this.getTitle());
        for (int i = n; i < n + 45 && i < this.Tx.size(); ++i) {
            String string;
            int n2 = i;
            if (this.Tx.get(i) == null || ((PlayerBridge_31)this.Tx.get(i)).sR() == null || (string = ((PlayerBridge_31)this.Tx.get(i)).sR().nf()) != null && !s.a((HumanEntity)player, string)) continue;
            itemStackBridge_4.a(((PlayerBridge_31)this.Tx.get(n2)).sR(), (T inventoryClickEvent) -> {
                if (!ItemStackBridge_42.h(inventoryClickEvent)) {
                    ((PlayerBridge_31)this.Tx.get(n2)).a(null, this, (Player)inventoryClickEvent.getWhoClicked(), bl);
                }
            });
        }
        if (!bl) {
            itemStackBridge_4.a(49, ItemStackBridge_42.Uf, (T inventoryClickEvent) -> this.Tq.j(player, bl));
        }
        if (opaque151.TE > 0) {
            itemStackBridge_4.a(52, ItemStackBridge_42.Ug, (T inventoryClickEvent) -> {
                this.bx(player);
                this.k(player, bl);
            });
        }
        if (opaque151.TE + 1 < this.Ti) {
            itemStackBridge_4.a(53, ItemStackBridge_42.Uh, (T inventoryClickEvent) -> {
                this.by(player);
                this.k(player, bl);
            });
        }
        itemStackBridge_4.cG(player);
    }

    void bx(Player player) {
        Opaque151 opaque151 = (Opaque151)this.Tz.get(player.getUniqueId());
        if (opaque151 != null) {
            int n;
            if ((n = opaque151.TE--) - 1 >= 0) {
                // empty if block
            }
        } else {
            this.Tz.put(player.getUniqueId(), new Opaque151());
        }
    }

    void by(Player player) {
        Opaque151 opaque151 = (Opaque151)this.Tz.get(player.getUniqueId());
        if (opaque151 != null) {
            int n;
            if ((n = opaque151.TE++) * 45 < this.Tx.size() - 1) {
                // empty if block
            }
        } else {
            this.Tz.put(player.getUniqueId(), new Opaque151());
        }
    }

    public boolean dp(String string) {
        return this.Ty.containsKey(string);
    }

    public void j(String string, int n) {
        this.Tf = string == null ? Tj : (PermissibleBridge)ItemStackRegistry.g().al.um.get(string);
        this.TA = n == -1 ? Tl : n;
    }

    public void aC(int n) {
        this.TB = n == -1 ? Tk : n;
    }
}
