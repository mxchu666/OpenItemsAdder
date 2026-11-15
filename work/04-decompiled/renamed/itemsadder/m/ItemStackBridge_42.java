package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PermissibleBridge;
import itemsadder.m.PlayerBridge_29;
import itemsadder.m.PlayerBridge_30;
import itemsadder.m.PlayerBridge_31;
import itemsadder.m.PlayerHolder_2;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.Worlds;
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

public class ItemStackBridge_42 {
    final PluginFileConfigurationHolder Ub;
    final ItemStackRegistry Uc;
    final HashMap Ud;
    public final PlayerBridge_29 Ue;
    public static ItemStack Uf;
    public static ItemStack Ug;
    public static ItemStack Uh;
    public static ItemStack Ui;
    public static boolean Uj;
    public static boolean Uk;
    public static List Ul;

    public ItemStackBridge_42(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.Ub = new PluginFileConfigurationHolder(plugin, true, "ia_gui.yml", true, true);
        this.Uc = itemStackRegistry;
        Uj = this.Ub.gY("settings.categories_view.order.alphabetical");
        Uk = this.Ub.gY("settings.categories_view.order.force_override.enabled");
        if (Uk) {
            Ul = this.Ub.hg("settings.categories_view.order.force_override.list");
        }
        Ui = this.K("settings.categories_view.icons.search.item", "ia-button-search");
        Uf = this.K("settings.category_view.icons.back.item", "ia-button-back");
        Ug = this.K("settings.category_view.icons.previous_page.item", "ia-button-previous-page");
        Uh = this.K("settings.category_view.icons.next_page.item", "ia-button-next-page");
        PlayerBridge_31.TQ = this.K("settings.crafting_preview.icons.loot_blocks.item", "ia-button-loot-blocks");
        PlayerBridge_31.TR = this.K("settings.crafting_preview.icons.blocks_populators.item", "ia-button-blocks-populators");
        PlayerBridge_31.TS = this.K("settings.crafting_preview.icons.surface_populators.item", "ia-button-surface-decorators");
        PlayerBridge_31.TT = this.K("settings.crafting_preview.icons.trees_populators.item", "ia-button-trees-populators");
        PlayerBridge_31.TU = this.K("settings.crafting_preview.icons.seed_result.item", "ia-button-seed-result");
        PlayerBridge_31.TV = this.K("settings.crafting_preview.icons.loot_mobs.item", "ia-button-loot-mobs");
        PlayerBridge_31.TW = this.K("settings.crafting_preview.icons.loot_fishing.item", "ia-button-loot-fishing");
        PlayerBridge_31.TX = this.K("settings.crafting_preview.icons.vehicle_fuel.item", "ia-button-vehicle-fuel-items");
        PlayerBridge_31.TY = this.K("settings.crafting_preview.icons.get_item.item", "ia-button-get-item");
        PlayerBridge_31.TZ = this.K("settings.crafting_preview.icons.previous_recipe.item", "ia-button-previous-recipe");
        PlayerBridge_31.Ua = this.K("settings.crafting_preview.icons.next_recipe.item", "ia-button-next-recipe");
        PlayerBridge_31.TK = (PermissibleBridge)itemStackRegistry.al.um.get(this.Ub.gV("settings.crafting_preview.no_recipe_font_image.name"));
        PlayerBridge_31.TL = (PermissibleBridge)itemStackRegistry.al.um.get(this.Ub.gV("settings.crafting_preview.craft_font_image.name"));
        if (PlayerBridge_31.TK == null) {
            PlayerBridge_31.TK = PlayerBridge_31.TL;
        }
        PlayerBridge_31.TM = (PermissibleBridge)itemStackRegistry.al.um.get(this.Ub.gV("settings.crafting_preview.cook_font_image.name"));
        PlayerBridge_31.TN = (PermissibleBridge)itemStackRegistry.al.um.get(this.Ub.gV("settings.crafting_preview.anvil_repair_font_image.name"));
        PlayerBridge_31.TO = (PermissibleBridge)itemStackRegistry.al.um.get(this.Ub.gV("settings.crafting_preview.smithing_font_image.name"));
        PlayerBridge_30.Tj = (PermissibleBridge)itemStackRegistry.al.um.get(this.Ub.gV("settings.category_view.font_image.name"));
        PlayerBridge_30.Tk = this.Ub.gW("settings.category_view.title_position_pixels");
        PlayerBridge_30.Tl = this.Ub.gW("settings.category_view.font_image.x_position_pixels");
        PlayerBridge_29.Tf = (PermissibleBridge)itemStackRegistry.al.um.get(this.Ub.gV("settings.categories_view.font_image.name"));
        this.Ud = new HashMap();
        for (Map.Entry entry : itemStackRegistry.C.entrySet()) {
            this.Ud.put((String)entry.getKey(), new Worlds(itemStackRegistry, (ItemStackBuilder_4)entry.getValue()));
        }
        this.Ue = new PlayerBridge_29(plugin, itemStackRegistry, this);
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
                object = ItemStackRegistry.g().a(itemStack);
                if (object != null) {
                    ItemStack itemStack2 = ((ItemStackBuilder_4)object).mP();
                    itemStack2.setAmount(1);
                    ItemStackBridge_2.f(player, itemStack2);
                    return true;
                }
                if (!itemStack.hasItemMeta()) {
                    ItemStack itemStack3 = itemStack.clone();
                    itemStack3.setAmount(1);
                    ItemStackBridge_2.f(player, itemStack3);
                    return true;
                }
            }
        }
        return false;
    }

    public Worlds V(ItemStack itemStack) {
        if (ItemStackBuilder_4.isCustomItem(itemStack)) {
            return (Worlds)this.Ud.get(ItemStackBuilder_4.u(itemStack));
        }
        return null;
    }

    ItemStack K(String string, String string2) {
        ItemStack itemStack = this.Uc.q(this.Ub.gV(string));
        if (itemStack == null) {
            itemStack = new ItemStack(Material.STONE);
        }
        itemStack = PlayerHolder_2.tX().Y(itemStack);
        ItemStackBridge_2.g(itemStack, Main.PQ.ir(string2));
        return itemStack;
    }

    static {
        Uj = true;
        Uk = false;
        Ul = new ArrayList();
    }
}
