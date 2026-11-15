package itemsadder.m;

import itemsadder.m.aaa;
import itemsadder.m.bbe;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.bio;
import itemsadder.m.d;
import itemsadder.m.fw;
import itemsadder.m.il;
import itemsadder.m.qm;
import itemsadder.m.uw;
import itemsadder.m.uy;
import itemsadder.m.vb;
import itemsadder.m.ve;
import itemsadder.m.vj;
import itemsadder.m.vk;
import itemsadder.m.wc;
import itemsadder.m.zk;
import itemsadder.m.zl;
import itemsadder.m.zo;
import itemsadder.m.zs;
import itemsadder.m.zv;
import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TranslatableComponent;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class zn {
    zk Tq;
    zo bi;
    private final qm TG;
    qm TH;
    public ArrayList TI;
    boolean TJ;
    public static fw TK;
    public static fw TL;
    public static fw TM;
    public static fw TN;
    public static fw TO;
    public final HashMap TP = new HashMap();
    public static ItemStack TQ;
    public static ItemStack TR;
    public static ItemStack TS;
    public static ItemStack TT;
    public static ItemStack TU;
    public static ItemStack TV;
    public static ItemStack TW;
    public static ItemStack TX;
    public static ItemStack TY;
    public static ItemStack TZ;
    public static ItemStack Ua;

    public zn(zo zo2, zk zk2, qm qm2, boolean bl) {
        this.TG = qm2;
        this.TJ = !bl;
        this.bi = zo2;
        this.Tq = zk2;
        this.TH = qm2.mN();
    }

    public void sG() {
        this.TI = new ArrayList(uy.b(this.TG, true));
    }

    public qm sR() {
        return this.TH;
    }

    public void a(zn zn2, zl zl2, Player player, boolean bl) {
        Object object;
        uw uw2;
        fw fw2;
        uw uw3;
        qm qm2;
        int n;
        if (this.TJ) {
            return;
        }
        if (!this.TP.containsKey(player.getUniqueId())) {
            this.TP.put(player.getUniqueId(), 0);
            n = 0;
        } else {
            n = (Integer)this.TP.get(player.getUniqueId());
        }
        uw uw4 = (uw)this.TI.get(n);
        zs zs2 = this.bi.V(uw4.qN());
        int n2 = this.Tq.Tg.Ub.gW("settings.crafting_preview.title_position_pixels");
        String string = this.Tq.Tg.Ub.hc("settings.crafting_preview.title_color");
        Object object2 = bbs.h(uw4.qN(), string);
        object2 = ((String)object2).replace(ChatColor.WHITE.toString(), string);
        int n3 = this.Tq.Tg.Ub.t("settings.cut_titles_with_length_grether_than", 25);
        int n4 = ChatColor.stripColor((String)object2).length();
        if (n4 > n3) {
            int n5;
            int n6 = 0;
            for (n5 = 0; n5 < ((String)object2).length(); ++n5) {
                if (((String)object2).charAt(n5) == '\u00a7') {
                    ++n5;
                } else {
                    ++n6;
                }
                if (n6 >= n3) break;
            }
            object2 = ((String)object2).substring(0, n5) + "...";
        }
        Component component = (qm2 = d.g().a(uw4.qN())) == null ? null : qm2.itemName();
        boolean bl2 = component instanceof TranslatableComponent;
        int n7 = 0;
        uw uw5 = uw4;
        Objects.requireNonNull(uw5);
        uw uw6 = uw5;
        int n8 = 0;
        switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{vk.class, ve.class, vb.class, wc.class}, (Object)uw6, n8)) {
            case 0: {
                uw3 = (vk)uw6;
                if (uw4.qS()) {
                    fw2 = TL;
                    n7 = this.Tq.Tg.Ub.gW("settings.crafting_preview.craft_font_image.x_position_pixels");
                    break;
                }
                fw2 = TK;
                n7 = this.Tq.Tg.Ub.t("settings.crafting_preview.no_recipe_font_image.x_position_pixels", this.Tq.Tg.Ub.gW("settings.crafting_preview.craft_font_image.x_position_pixels"));
                break;
            }
            case 1: {
                ve ve2 = (ve)uw6;
                fw2 = TM;
                n7 = this.Tq.Tg.Ub.gW("settings.crafting_preview.cook_font_image.x_position_pixels");
                break;
            }
            case 2: {
                uw2 = (vb)uw6;
                fw2 = TN;
                n7 = this.Tq.Tg.Ub.gW("settings.crafting_preview.anvil_repair_font_image.x_position_pixels");
                break;
            }
            case 3: {
                object = (wc)uw6;
                fw2 = TO;
                n7 = this.Tq.Tg.Ub.gW("settings.crafting_preview.smithing_font_image.x_position_pixels");
                break;
            }
            default: {
                throw new RuntimeException("Unknown recipe type!");
            }
        }
        uw6 = null;
        if (fw2 != null && bl2) {
            uw6 = zn.a(il.a(Component.text((String)fw2.if()).color(bbe.azD), n7), (Component)bbe.azG.deserialize(string), component, -fw2.getWidth() + n2);
        } else if (fw2 != null) {
            object2 = String.valueOf(ChatColor.WHITE) + il.c(fw2.if(), n7) + il.c((String)object2, -fw2.getWidth() + n2);
        } else {
            bce.error("GUI error: can't find font_image for recipe GUI. Check ia_gui.yml file.");
            object2 = " ";
        }
        bio bio2 = new bio(54, (String)(uw6 == null ? object2 : "IA_CUST_GUI"));
        uw uw7 = uw4;
        Objects.requireNonNull(uw7);
        uw3 = uw7;
        int n9 = 0;
        switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{vk.class, ve.class, vb.class, wc.class}, (Object)uw3, n9)) {
            case 0: {
                uw2 = uw3;
                if (!((vk)uw2).MS && ((vk)uw2).MM != null) {
                    for (int i = 0; i < ((vk)uw2).MM.length; ++i) {
                        String string2 = ((vk)uw2).MM[i];
                        for (int j = 0; j < string2.length(); ++j) {
                            ItemStack itemStack = ((vk)uw2).b(Character.valueOf(string2.charAt(j)));
                            if (itemStack == null || itemStack.getType().isAir()) continue;
                            bio2.a(1 + j + i * 9, itemStack, inventoryClickEvent -> {
                                if (zo.h(inventoryClickEvent)) {
                                    return;
                                }
                                this.a(inventoryClickEvent.getCurrentItem(), zl2, this, player, bl);
                            });
                        }
                    }
                } else {
                    object = ((vk)uw2).rl();
                    int n10 = 0;
                    int n11 = 0;
                    while (n10 < object.size()) {
                        for (int i = 0; i < 3 && n10 < object.size(); ++n10, ++i) {
                            bio2.a(i + 1 + n11 * 9, ((vj)object.get(n10)).getItem(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), zl2, this, player, bl));
                        }
                        ++n11;
                    }
                }
                if (!((vk)uw2).qS()) {
                    bio2.a(13, uw4.qN());
                    break;
                }
                bio2.a(16, uw4.qN(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), zl2, this, player, bl));
                break;
            }
            case 1: {
                object = (ve)uw3;
                bio2.a(2, ((ve)object).re().getItemStack(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), zl2, this, player, bl));
                bio2.a(20, new ItemStack(Material.COAL));
                bio2.a(10, new ItemStack(((ve)object).rh()));
                bio2.a(14, uw4.qN(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), zl2, this, player, bl));
                break;
            }
            case 2: {
                vb vb2 = (vb)uw3;
                bio2.a(10, vb2.rb(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), zl2, this, player, bl));
                bio2.a(13, vb2.rc(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), zl2, this, player, bl));
                bio2.a(16, uw4.qN(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), zl2, this, player, bl));
                break;
            }
            case 3: {
                wc wc2 = (wc)uw3;
                bio2.a(10, wc2.Nj.getItem(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), zl2, this, player, bl));
                bio2.a(13, wc2.Nk.getItem(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), zl2, this, player, bl));
                bio2.a(16, uw4.qN(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), zl2, this, player, bl));
                break;
            }
            default: {
                throw new RuntimeException("Unknown recipe type!");
            }
        }
        if (zs2 != null) {
            int n12 = 37;
            if (!zs2.UI.isEmpty()) {
                ItemStack itemStack = TQ.clone();
                if (aaa.Vc) {
                    bbs.e(itemStack, zs2.UJ);
                } else {
                    bbs.d(itemStack, zs2.UI);
                }
                bio2.a(n12, itemStack);
                ++n12;
            }
            if (!zs2.UC.isEmpty()) {
                ItemStack itemStack = TR.clone();
                bbs.d(itemStack, zs2.UC);
                bio2.a(n12, itemStack);
                ++n12;
            }
            if (!zs2.UD.isEmpty()) {
                ItemStack itemStack = TS.clone();
                bbs.d(itemStack, zs2.UD);
                bio2.a(n12, itemStack);
                ++n12;
            }
            if (!zs2.UE.isEmpty()) {
                ItemStack itemStack = TT.clone();
                bbs.d(itemStack, zs2.UE);
                bio2.a(n12, itemStack);
                ++n12;
            }
            if (!zs2.UF.isEmpty()) {
                ItemStack itemStack = TU.clone();
                bbs.d(itemStack, zs2.UF);
                bio2.a(n12, itemStack);
                ++n12;
            }
            if (!zs2.UG.isEmpty()) {
                ItemStack itemStack = TV.clone();
                if (aaa.Vc) {
                    bbs.e(itemStack, zs2.UH);
                } else {
                    bbs.d(itemStack, zs2.UG);
                }
                bio2.a(n12, itemStack);
                ++n12;
            }
            if (!zs2.UK.isEmpty()) {
                ItemStack itemStack = TW.clone();
                bbs.d(itemStack, zs2.UK);
                bio2.a(n12, itemStack);
                ++n12;
            }
            if (!zs2.UL.isEmpty()) {
                ItemStack itemStack = TX.clone();
                bbs.d(itemStack, zs2.UL);
                bio2.a(n12, itemStack);
                ++n12;
            }
        }
        bio2.a(49, zo.Uf, inventoryClickEvent -> {
            if (zn2 != null) {
                zn2.a(null, zl2, player, bl);
            } else if (zl2 != null) {
                zl2.k(player, bl);
            } else {
                player.closeInventory();
            }
        });
        if (n > 0) {
            bio2.a(52, TZ, inventoryClickEvent -> {
                this.bx(player);
                this.a(zn2, zl2, player, bl);
            });
        }
        if (n < this.TI.size() - 1) {
            bio2.a(53, Ua, inventoryClickEvent -> {
                this.by(player);
                this.a(zn2, zl2, player, bl);
            });
        }
        if (player.hasPermission("ia.admin.iaget")) {
            bio2.a(!uw4.qS() ? 31 : 34, TY, inventoryClickEvent -> bbs.f(player, uw4.qP()));
        }
        if (uw6 != null) {
            zv.a(player, (Component)uw6);
        }
        bio2.cG(player);
        player.setCompassTarget(player.getLocation());
    }

    static Component a(Component component, Component component2, Component component3, int n) {
        return component.append(il.a(component2.append(component3.color(null)), n));
    }

    void a(ItemStack itemStack, zl zl2, zn zn2, Player player, boolean bl) {
        if (qm.isCustomItem(itemStack)) {
            ((zn)this.Tq.Td.get(qm.u(itemStack))).a(zn2, zl2, player, bl);
        }
    }

    void bx(Player player) {
        if (this.TP.containsKey(player.getUniqueId())) {
            int n = (Integer)this.TP.get(player.getUniqueId());
            if (n - 1 >= 0) {
                this.TP.put(player.getUniqueId(), n - 1);
            }
        } else {
            this.TP.put(player.getUniqueId(), 0);
        }
    }

    void by(Player player) {
        if (this.TP.containsKey(player.getUniqueId())) {
            int n = (Integer)this.TP.get(player.getUniqueId());
            if (n < this.TI.size() - 1) {
                this.TP.put(player.getUniqueId(), n + 1);
            }
        } else {
            this.TP.put(player.getUniqueId(), 0);
        }
    }
}
