package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.aiq;
import itemsadder.m.bbf;
import itemsadder.m.bbs;
import itemsadder.m.d;
import itemsadder.m.fw;
import itemsadder.m.qm;
import itemsadder.m.zk;
import itemsadder.m.zl;
import itemsadder.m.zn;
import itemsadder.m.zs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permissible;
import org.bukkit.plugin.Plugin;

public class zo {
    final bbf Ub;
    final d Uc;
    final HashMap Ud;
    public final zk Ue;
    public static ItemStack Uf;
    public static ItemStack Ug;
    public static ItemStack Uh;
    public static ItemStack Ui;
    public static boolean Uj;
    public static boolean Uk;
    public static List Ul;

    public zo(Plugin plugin, d d2) {
        this.Ub = new bbf(plugin, true, "ia_gui.yml", true, true);
        this.Uc = d2;
        Uj = this.Ub.gY("settings.categories_view.order.alphabetical");
        Uk = this.Ub.gY("settings.categories_view.order.force_override.enabled");
        if (Uk) {
            Ul = this.Ub.hg("settings.categories_view.order.force_override.list");
        }
        Ui = this.K("settings.categories_view.icons.search.item", "ia-button-search");
        Uf = this.K("settings.category_view.icons.back.item", "ia-button-back");
        Ug = this.K("settings.category_view.icons.previous_page.item", "ia-button-previous-page");
        Uh = this.K("settings.category_view.icons.next_page.item", "ia-button-next-page");
        zn.TQ = this.K("settings.crafting_preview.icons.loot_blocks.item", "ia-button-loot-blocks");
        zn.TR = this.K("settings.crafting_preview.icons.blocks_populators.item", "ia-button-blocks-populators");
        zn.TS = this.K("settings.crafting_preview.icons.surface_populators.item", "ia-button-surface-decorators");
        zn.TT = this.K("settings.crafting_preview.icons.trees_populators.item", "ia-button-trees-populators");
        zn.TU = this.K("settings.crafting_preview.icons.seed_result.item", "ia-button-seed-result");
        zn.TV = this.K("settings.crafting_preview.icons.loot_mobs.item", "ia-button-loot-mobs");
        zn.TW = this.K("settings.crafting_preview.icons.loot_fishing.item", "ia-button-loot-fishing");
        zn.TX = this.K("settings.crafting_preview.icons.vehicle_fuel.item", "ia-button-vehicle-fuel-items");
        zn.TY = this.K("settings.crafting_preview.icons.get_item.item", "ia-button-get-item");
        zn.TZ = this.K("settings.crafting_preview.icons.previous_recipe.item", "ia-button-previous-recipe");
        zn.Ua = this.K("settings.crafting_preview.icons.next_recipe.item", "ia-button-next-recipe");
        zn.TK = (fw)d2.al.um.get(this.Ub.gV("settings.crafting_preview.no_recipe_font_image.name"));
        zn.TL = (fw)d2.al.um.get(this.Ub.gV("settings.crafting_preview.craft_font_image.name"));
        if (zn.TK == null) {
            zn.TK = zn.TL;
        }
        zn.TM = (fw)d2.al.um.get(this.Ub.gV("settings.crafting_preview.cook_font_image.name"));
        zn.TN = (fw)d2.al.um.get(this.Ub.gV("settings.crafting_preview.anvil_repair_font_image.name"));
        zn.TO = (fw)d2.al.um.get(this.Ub.gV("settings.crafting_preview.smithing_font_image.name"));
        zl.Tj = (fw)d2.al.um.get(this.Ub.gV("settings.category_view.font_image.name"));
        zl.Tk = this.Ub.gW("settings.category_view.title_position_pixels");
        zl.Tl = this.Ub.gW("settings.category_view.font_image.x_position_pixels");
        zk.Tf = (fw)d2.al.um.get(this.Ub.gV("settings.categories_view.font_image.name"));
        this.Ud = new HashMap();
        for (Map.Entry entry : d2.C.entrySet()) {
            this.Ud.put((String)entry.getKey(), new zs(d2, (qm)entry.getValue()));
        }
        this.Ue = new zk(plugin, d2, this);
        this.Ue.sF();
        this.Ue.sI();
        this.Ue.sH();
        this.Ue.sJ();
        this.Ue.sK();
    }

    public static boolean h(InventoryClickEvent inventoryClickEvent) {
        ItemStack itemStack = inventoryClickEvent.getCurrentItem();
        if (itemStack == null) {
            return false;
        }
        Object object = inventoryClickEvent.getWhoClicked();
        if (object instanceof Player) {
            Player player = (Player)object;
            if (inventoryClickEvent.isShiftClick() && s.b((Permissible)player, "ia.admin.iaget", true)) {
                object = d.g().a(itemStack);
                if (object != null) {
                    ItemStack itemStack2 = ((qm)object).mP();
                    itemStack2.setAmount(1);
                    bbs.f(player, itemStack2);
                    return true;
                }
                if (!itemStack.hasItemMeta()) {
                    ItemStack itemStack3 = itemStack.clone();
                    itemStack3.setAmount(1);
                    bbs.f(player, itemStack3);
                    return true;
                }
            }
        }
        return false;
    }

    public zs V(ItemStack itemStack) {
        if (qm.isCustomItem(itemStack)) {
            return (zs)this.Ud.get(qm.u(itemStack));
        }
        return null;
    }

    ItemStack K(String string, String string2) {
        ItemStack itemStack = this.Uc.q(this.Ub.gV(string));
        if (itemStack == null) {
            itemStack = new ItemStack(Material.STONE);
        }
        itemStack = aiq.tX().Y(itemStack);
        bbs.g(itemStack, Main.PQ.ir(string2));
        return itemStack;
    }

    static {
        Uj = true;
        Uk = false;
        Ul = new ArrayList();
    }
}
