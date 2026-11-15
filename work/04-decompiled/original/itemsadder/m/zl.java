package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.aiq;
import itemsadder.m.bbe;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.bio;
import itemsadder.m.d;
import itemsadder.m.fw;
import itemsadder.m.il;
import itemsadder.m.zk;
import itemsadder.m.zm;
import itemsadder.m.zn;
import itemsadder.m.zo;
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
public class zl {
    public static fw Tj;
    public static int Tk;
    public static int Tl;
    static final int Tm = 45;
    public final String Tn;
    @Nullable
    private final String To;
    @Nullable
    private final String Tp;
    final zk Tq;
    public fw Tf;
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

    public zl(String string, @Nullable String string2, @Nullable String string3, zk zk2, @Nullable ItemStack itemStack, Component component, Component component2, @Nullable String string4, @Nullable String string5) {
        this.Tn = string;
        this.To = string2;
        this.Tp = string3;
        this.Tq = zk2;
        this.TC = string4;
        this.TD = string5;
        this.Tu = ((TextComponent)Component.empty().color(bbe.azD)).append(component);
        this.U(itemStack);
        @Nullable TextColor textColor = zk2.Tg.Ub.hd("settings.category_view.title_color").color();
        this.Tv = component2.color() == bbe.azD ? component2.color(textColor) : component2;
        if (this.Tv.font() != null) {
            bce.warn("[Category] '" + string + "' 'title' has a custom font. This is not supported, the font will be ignored.");
        }
        this.j(null, -1);
    }

    private String getTitle() {
        if (this.Tw != null) {
            return this.Tw;
        }
        String string = bcy.x(this.Tv);
        if (this.Tf == null) {
            bce.error(String.valueOf(ChatColor.RED) + "GUI error: can't find font_image. Check ia_gui.yml, attribute: " + String.valueOf(ChatColor.AQUA) + "settings.category_view.font_image.name");
            this.Tw = bcy.iV(string);
            return this.Tw;
        }
        this.Tw = String.valueOf(ChatColor.WHITE) + il.c(this.Tf.if(), this.TA) + il.c(string, -this.Tf.getWidth() + this.TB);
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
        bbs.d(this.Tt, arrayList);
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
        this.Tt = aiq.tX().Y(this.Tt);
        bbs.a(this.Tt, this.Tu);
    }

    public ArrayList sP() {
        return this.Tx;
    }

    public void a(String string, zn zn2) {
        this.Tx.add(zn2);
        this.Ty.put(string, zn2);
    }

    public void do(String string) {
        zl.a(this.Ty, (List)this.Tx, string);
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
        Object v2 = map.remove(string);
        list.remove(v2);
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
        zm zm2 = this.Tz.computeIfAbsent(player.getUniqueId(), uUID -> new zm(bl));
        int n = zm2.sQ();
        this.Ti = bcy.g(this.Tx.size(), 45.0f);
        bio bio2 = new bio(54, this.getTitle());
        for (int i = n; i < n + 45 && i < this.Tx.size(); ++i) {
            String string;
            int n2 = i;
            if (this.Tx.get(i) == null || ((zn)this.Tx.get(i)).sR() == null || (string = ((zn)this.Tx.get(i)).sR().nf()) != null && !s.a((HumanEntity)player, string)) continue;
            bio2.a(((zn)this.Tx.get(n2)).sR(), (T inventoryClickEvent) -> {
                if (!zo.h(inventoryClickEvent)) {
                    ((zn)this.Tx.get(n2)).a(null, this, (Player)inventoryClickEvent.getWhoClicked(), bl);
                }
            });
        }
        if (!bl) {
            bio2.a(49, zo.Uf, (T inventoryClickEvent) -> this.Tq.j(player, bl));
        }
        if (zm2.TE > 0) {
            bio2.a(52, zo.Ug, (T inventoryClickEvent) -> {
                this.bx(player);
                this.k(player, bl);
            });
        }
        if (zm2.TE + 1 < this.Ti) {
            bio2.a(53, zo.Uh, (T inventoryClickEvent) -> {
                this.by(player);
                this.k(player, bl);
            });
        }
        bio2.cG(player);
    }

    void bx(Player player) {
        zm zm2 = (zm)this.Tz.get(player.getUniqueId());
        if (zm2 != null) {
            int n;
            if ((n = zm2.TE--) - 1 >= 0) {
                // empty if block
            }
        } else {
            this.Tz.put(player.getUniqueId(), new zm());
        }
    }

    void by(Player player) {
        zm zm2 = (zm)this.Tz.get(player.getUniqueId());
        if (zm2 != null) {
            int n;
            if ((n = zm2.TE++) * 45 < this.Tx.size() - 1) {
                // empty if block
            }
        } else {
            this.Tz.put(player.getUniqueId(), new zm());
        }
    }

    public boolean dp(String string) {
        return this.Ty.containsKey(string);
    }

    public void j(String string, int n) {
        this.Tf = string == null ? Tj : (fw)d.g().al.um.get(string);
        this.TA = n == -1 ? Tl : n;
    }

    public void aC(int n) {
        this.TB = n == -1 ? Tk : n;
    }
}
