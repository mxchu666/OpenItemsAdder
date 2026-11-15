package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBridge_34;
import itemsadder.m.ItemStackBridge_35;
import itemsadder.m.ItemStackBridge_4;
import itemsadder.m.ItemStackBridge_41;
import itemsadder.m.ItemStackBridge_42;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBridge_18;
import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.NamespacedKeyWrapper;
import itemsadder.m.Opaque123;
import itemsadder.m.PermissibleBridge;
import itemsadder.m.PlayerBridge_29;
import itemsadder.m.PlayerBridge_30;
import itemsadder.m.PlayerBridge_33;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.RecipeChoiceItemStackHolder_2;
import itemsadder.m.VersionHelper;
import itemsadder.m.Worlds;
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

public class PlayerBridge_31 {
    PlayerBridge_29 Tq;
    ItemStackBridge_42 bi;
    private final ItemStackBuilder_4 TG;
    ItemStackBuilder_4 TH;
    public ArrayList TI;
    boolean TJ;
    public static PermissibleBridge TK;
    public static PermissibleBridge TL;
    public static PermissibleBridge TM;
    public static PermissibleBridge TN;
    public static PermissibleBridge TO;
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

    public PlayerBridge_31(ItemStackBridge_42 itemStackBridge_42, PlayerBridge_29 playerBridge_29, ItemStackBuilder_4 itemStackBuilder_4, boolean bl) {
        this.TG = itemStackBuilder_4;
        this.TJ = !bl;
        this.bi = itemStackBridge_42;
        this.Tq = playerBridge_29;
        this.TH = itemStackBuilder_4.mN();
    }

    public void sG() {
        this.TI = new ArrayList(NamespacedKeyWrapper.b(this.TG, true));
    }

    public ItemStackBuilder_4 sR() {
        return this.TH;
    }

    public void a(PlayerBridge_31 playerBridge_31, PlayerBridge_30 playerBridge_30, Player player, boolean bl) {
        Object object;
        NamespacedKeyItemStackHolder namespacedKeyItemStackHolder;
        PermissibleBridge permissibleBridge;
        NamespacedKeyItemStackHolder namespacedKeyItemStackHolder2;
        ItemStackBuilder_4 itemStackBuilder_4;
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
        NamespacedKeyItemStackHolder namespacedKeyItemStackHolder3 = (NamespacedKeyItemStackHolder)this.TI.get(n);
        Worlds worlds = this.bi.V(namespacedKeyItemStackHolder3.qN());
        int n2 = this.Tq.Tg.Ub.gW("settings.crafting_preview.title_position_pixels");
        String string = this.Tq.Tg.Ub.hc("settings.crafting_preview.title_color");
        Object object2 = ItemStackBridge_2.h(namespacedKeyItemStackHolder3.qN(), string);
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
        Component component = (itemStackBuilder_4 = ItemStackRegistry.g().a(namespacedKeyItemStackHolder3.qN())) == null ? null : itemStackBuilder_4.itemName();
        boolean bl2 = component instanceof TranslatableComponent;
        int n7 = 0;
        NamespacedKeyItemStackHolder namespacedKeyItemStackHolder4 = namespacedKeyItemStackHolder3;
        Objects.requireNonNull(namespacedKeyItemStackHolder4);
        NamespacedKeyItemStackHolder namespacedKeyItemStackHolder5 = namespacedKeyItemStackHolder4;
        int n8 = 0;
        switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{ItemStackBridge_35.class, MaterialBridge_18.class, ItemStackBridge_34.class, ItemStackBridge_41.class}, (Object)namespacedKeyItemStackHolder5, n8)) {
            case 0: {
                namespacedKeyItemStackHolder2 = (ItemStackBridge_35)namespacedKeyItemStackHolder5;
                if (namespacedKeyItemStackHolder3.qS()) {
                    permissibleBridge = TL;
                    n7 = this.Tq.Tg.Ub.gW("settings.crafting_preview.craft_font_image.x_position_pixels");
                    break;
                }
                permissibleBridge = TK;
                n7 = this.Tq.Tg.Ub.t("settings.crafting_preview.no_recipe_font_image.x_position_pixels", this.Tq.Tg.Ub.gW("settings.crafting_preview.craft_font_image.x_position_pixels"));
                break;
            }
            case 1: {
                MaterialBridge_18 materialBridge_18 = (MaterialBridge_18)namespacedKeyItemStackHolder5;
                permissibleBridge = TM;
                n7 = this.Tq.Tg.Ub.gW("settings.crafting_preview.cook_font_image.x_position_pixels");
                break;
            }
            case 2: {
                namespacedKeyItemStackHolder = (ItemStackBridge_34)namespacedKeyItemStackHolder5;
                permissibleBridge = TN;
                n7 = this.Tq.Tg.Ub.gW("settings.crafting_preview.anvil_repair_font_image.x_position_pixels");
                break;
            }
            case 3: {
                object = (ItemStackBridge_41)namespacedKeyItemStackHolder5;
                permissibleBridge = TO;
                n7 = this.Tq.Tg.Ub.gW("settings.crafting_preview.smithing_font_image.x_position_pixels");
                break;
            }
            default: {
                throw new RuntimeException("Unknown recipe type!");
            }
        }
        namespacedKeyItemStackHolder5 = null;
        if (permissibleBridge != null && bl2) {
            namespacedKeyItemStackHolder5 = PlayerBridge_31.a(Opaque123.a(Component.text((String)permissibleBridge.if()).color(PluginBridge_6.azD), n7), (Component)PluginBridge_6.azG.deserialize(string), component, -permissibleBridge.getWidth() + n2);
        } else if (permissibleBridge != null) {
            object2 = String.valueOf(ChatColor.WHITE) + Opaque123.c(permissibleBridge.if(), n7) + Opaque123.c((String)object2, -permissibleBridge.getWidth() + n2);
        } else {
            CommandSenderBridge_5.error("GUI error: can't find font_image for recipe GUI. Check ia_gui.yml file.");
            object2 = " ";
        }
        ItemStackBridge_4 itemStackBridge_4 = new ItemStackBridge_4(54, (String)(namespacedKeyItemStackHolder5 == null ? object2 : "IA_CUST_GUI"));
        NamespacedKeyItemStackHolder namespacedKeyItemStackHolder6 = namespacedKeyItemStackHolder3;
        Objects.requireNonNull(namespacedKeyItemStackHolder6);
        namespacedKeyItemStackHolder2 = namespacedKeyItemStackHolder6;
        int n9 = 0;
        switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{ItemStackBridge_35.class, MaterialBridge_18.class, ItemStackBridge_34.class, ItemStackBridge_41.class}, (Object)namespacedKeyItemStackHolder2, n9)) {
            case 0: {
                namespacedKeyItemStackHolder = namespacedKeyItemStackHolder2;
                if (!((ItemStackBridge_35)namespacedKeyItemStackHolder).MS && ((ItemStackBridge_35)namespacedKeyItemStackHolder).MM != null) {
                    for (int i = 0; i < ((ItemStackBridge_35)namespacedKeyItemStackHolder).MM.length; ++i) {
                        String string2 = ((ItemStackBridge_35)namespacedKeyItemStackHolder).MM[i];
                        for (int j = 0; j < string2.length(); ++j) {
                            ItemStack itemStack = ((ItemStackBridge_35)namespacedKeyItemStackHolder).b(Character.valueOf(string2.charAt(j)));
                            if (itemStack == null || itemStack.getType().isAir()) continue;
                            itemStackBridge_4.a(1 + j + i * 9, itemStack, inventoryClickEvent -> {
                                if (ItemStackBridge_42.h(inventoryClickEvent)) {
                                    return;
                                }
                                this.a(inventoryClickEvent.getCurrentItem(), playerBridge_30, this, player, bl);
                            });
                        }
                    }
                } else {
                    object = ((ItemStackBridge_35)namespacedKeyItemStackHolder).rl();
                    int n10 = 0;
                    int n11 = 0;
                    while (n10 < object.size()) {
                        for (int i = 0; i < 3 && n10 < object.size(); ++n10, ++i) {
                            itemStackBridge_4.a(i + 1 + n11 * 9, ((RecipeChoiceItemStackHolder_2)object.get(n10)).getItem(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), playerBridge_30, this, player, bl));
                        }
                        ++n11;
                    }
                }
                if (!((ItemStackBridge_35)namespacedKeyItemStackHolder).qS()) {
                    itemStackBridge_4.a(13, namespacedKeyItemStackHolder3.qN());
                    break;
                }
                itemStackBridge_4.a(16, namespacedKeyItemStackHolder3.qN(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), playerBridge_30, this, player, bl));
                break;
            }
            case 1: {
                object = (MaterialBridge_18)namespacedKeyItemStackHolder2;
                itemStackBridge_4.a(2, ((MaterialBridge_18)object).re().getItemStack(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), playerBridge_30, this, player, bl));
                itemStackBridge_4.a(20, new ItemStack(Material.COAL));
                itemStackBridge_4.a(10, new ItemStack(((MaterialBridge_18)object).rh()));
                itemStackBridge_4.a(14, namespacedKeyItemStackHolder3.qN(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), playerBridge_30, this, player, bl));
                break;
            }
            case 2: {
                ItemStackBridge_34 itemStackBridge_34 = (ItemStackBridge_34)namespacedKeyItemStackHolder2;
                itemStackBridge_4.a(10, itemStackBridge_34.rb(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), playerBridge_30, this, player, bl));
                itemStackBridge_4.a(13, itemStackBridge_34.rc(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), playerBridge_30, this, player, bl));
                itemStackBridge_4.a(16, namespacedKeyItemStackHolder3.qN(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), playerBridge_30, this, player, bl));
                break;
            }
            case 3: {
                ItemStackBridge_41 itemStackBridge_41 = (ItemStackBridge_41)namespacedKeyItemStackHolder2;
                itemStackBridge_4.a(10, itemStackBridge_41.Nj.getItem(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), playerBridge_30, this, player, bl));
                itemStackBridge_4.a(13, itemStackBridge_41.Nk.getItem(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), playerBridge_30, this, player, bl));
                itemStackBridge_4.a(16, namespacedKeyItemStackHolder3.qN(), inventoryClickEvent -> this.a(inventoryClickEvent.getCurrentItem(), playerBridge_30, this, player, bl));
                break;
            }
            default: {
                throw new RuntimeException("Unknown recipe type!");
            }
        }
        if (worlds != null) {
            int n12 = 37;
            if (!worlds.UI.isEmpty()) {
                ItemStack itemStack = TQ.clone();
                if (VersionHelper.Vc) {
                    ItemStackBridge_2.e(itemStack, worlds.UJ);
                } else {
                    ItemStackBridge_2.d(itemStack, worlds.UI);
                }
                itemStackBridge_4.a(n12, itemStack);
                ++n12;
            }
            if (!worlds.UC.isEmpty()) {
                ItemStack itemStack = TR.clone();
                ItemStackBridge_2.d(itemStack, worlds.UC);
                itemStackBridge_4.a(n12, itemStack);
                ++n12;
            }
            if (!worlds.UD.isEmpty()) {
                ItemStack itemStack = TS.clone();
                ItemStackBridge_2.d(itemStack, worlds.UD);
                itemStackBridge_4.a(n12, itemStack);
                ++n12;
            }
            if (!worlds.UE.isEmpty()) {
                ItemStack itemStack = TT.clone();
                ItemStackBridge_2.d(itemStack, worlds.UE);
                itemStackBridge_4.a(n12, itemStack);
                ++n12;
            }
            if (!worlds.UF.isEmpty()) {
                ItemStack itemStack = TU.clone();
                ItemStackBridge_2.d(itemStack, worlds.UF);
                itemStackBridge_4.a(n12, itemStack);
                ++n12;
            }
            if (!worlds.UG.isEmpty()) {
                ItemStack itemStack = TV.clone();
                if (VersionHelper.Vc) {
                    ItemStackBridge_2.e(itemStack, worlds.UH);
                } else {
                    ItemStackBridge_2.d(itemStack, worlds.UG);
                }
                itemStackBridge_4.a(n12, itemStack);
                ++n12;
            }
            if (!worlds.UK.isEmpty()) {
                ItemStack itemStack = TW.clone();
                ItemStackBridge_2.d(itemStack, worlds.UK);
                itemStackBridge_4.a(n12, itemStack);
                ++n12;
            }
            if (!worlds.UL.isEmpty()) {
                ItemStack itemStack = TX.clone();
                ItemStackBridge_2.d(itemStack, worlds.UL);
                itemStackBridge_4.a(n12, itemStack);
                ++n12;
            }
        }
        itemStackBridge_4.a(49, ItemStackBridge_42.Uf, inventoryClickEvent -> {
            if (playerBridge_31 != null) {
                playerBridge_31.a(null, playerBridge_30, player, bl);
            } else if (playerBridge_30 != null) {
                playerBridge_30.k(player, bl);
            } else {
                player.closeInventory();
            }
        });
        if (n > 0) {
            itemStackBridge_4.a(52, TZ, inventoryClickEvent -> {
                this.bx(player);
                this.a(playerBridge_31, playerBridge_30, player, bl);
            });
        }
        if (n < this.TI.size() - 1) {
            itemStackBridge_4.a(53, Ua, inventoryClickEvent -> {
                this.by(player);
                this.a(playerBridge_31, playerBridge_30, player, bl);
            });
        }
        if (player.hasPermission("ia.admin.iaget")) {
            itemStackBridge_4.a(!namespacedKeyItemStackHolder3.qS() ? 31 : 34, TY, inventoryClickEvent -> ItemStackBridge_2.f(player, namespacedKeyItemStackHolder3.qP()));
        }
        if (namespacedKeyItemStackHolder5 != null) {
            PlayerBridge_33.a(player, (Component)namespacedKeyItemStackHolder5);
        }
        itemStackBridge_4.cG(player);
        player.setCompassTarget(player.getLocation());
    }

    static Component a(Component component, Component component2, Component component3, int n) {
        return component.append(Opaque123.a(component2.append(component3.color(null)), n));
    }

    void a(ItemStack itemStack, PlayerBridge_30 playerBridge_30, PlayerBridge_31 playerBridge_31, Player player, boolean bl) {
        if (ItemStackBuilder_4.isCustomItem(itemStack)) {
            ((PlayerBridge_31)this.Tq.Td.get(ItemStackBuilder_4.u(itemStack))).a(playerBridge_31, playerBridge_30, player, bl);
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
