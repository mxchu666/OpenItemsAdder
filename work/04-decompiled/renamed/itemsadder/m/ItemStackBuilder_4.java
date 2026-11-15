package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import beer.devs.fastnbt.nms.nbt.NBT;
import beer.devs.fastnbt.nms.nbt.NBTType;
import beer.devs.fastnbt.nms.nbt.NCompound;
import beer.devs.fastnbt.nms.nbt.NItem;
import beer.devs.fastnbt.nms.nbt.NList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import dev.lone.itemsadder.Main;
import itemsadder.m.BarColorBarStyleHolder;
import itemsadder.m.Behaviours;
import itemsadder.m.BlockBreakEnum;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ComponentBoolData;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.ConfigurationSectionBridge_2;
import itemsadder.m.ConfigurationSectionBridge_4;
import itemsadder.m.Consumer_3;
import itemsadder.m.DoubleData;
import itemsadder.m.HeadEnum;
import itemsadder.m.HiddenEnum;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.MaterialBridge_10;
import itemsadder.m.MaterialBridge_11;
import itemsadder.m.MaterialBridge_12;
import itemsadder.m.Opaque130;
import itemsadder.m.Opaque131;
import itemsadder.m.PacketContainerHolder;
import itemsadder.m.PlayerHolder_2;
import itemsadder.m.PlayerJoinListener_7;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.PluginContract_20;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfNamespacedKey;
import itemsadder.m.RecordOfValue_23;
import itemsadder.m.Runner_2;
import itemsadder.m.VersionHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import lombok.Generated;
import net.kyori.adventure.text.Component;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Repairable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemStackBuilder_4
extends ItemStack
implements PluginContract_20 {
    private static final double FP = -1.0;
    private static final double FQ = -4.0;
    protected NItem FR;
    @Deprecated
    private String ps;
    @Deprecated
    private String FS;
    @Deprecated
    private List FT;
    @Deprecated
    @Nullable
    private String FU;
    @Deprecated
    @Nullable
    private String FV;
    @Deprecated
    private boolean FW;
    @Nullable
    public MaterialBridge_10 FX;
    @Nullable
    public String FY;
    @Nullable
    private RecordOfNamespacedKey FZ;
    final PluginFileConfigurationHolder Ga;
    @Nullable
    Long Gb;
    ConfigurationSectionBridge Gc;
    public final ConfigurationSectionBridge_2 Gd;
    public final Behaviours Ge;
    public final String Gf;
    public final String Gg;
    public final String Gh;
    public final int Gi;
    @Nullable
    Integer Gj;
    @Nullable
    Integer Gk;
    boolean Gl = true;
    @Nullable
    Opaque131 Gm;
    public String uI;
    @Nullable
    public ArrayList Gn;
    public boolean Go;
    ImmutableMap Gp = ImmutableMap.of();
    public long Gq = -1L;
    public String Gr;
    private HashMap Gs;
    private boolean Gt;
    private String Gu;
    public boolean Gv;
    private final boolean Gw;
    @Nullable
    private BarColorBarStyleHolder Gx;
    @Nullable
    private RecordOfValue_23 Gy;
    private Set Gz = new HashSet();
    private boolean GA = true;
    static final int GB = 43520;
    static final Opaque130 GC = new Opaque130("item.modifiers.head");
    static final Opaque130 GD = new Opaque130("item.modifiers.chest");
    static final Opaque130 GE = new Opaque130("item.modifiers.legs");
    static final Opaque130 GF = new Opaque130("item.modifiers.feet");
    static final Opaque130 GG = new Opaque130("item.modifiers.mainhand");
    static final Opaque130 GH = new Opaque130("item.modifiers.offhand");
    static final Opaque130 GI = new Opaque130("attribute.name.generic.attack_damage", 43520);
    static final Opaque130 GJ = new Opaque130("attribute.name.attack_damage", 43520);
    static final Opaque130 GK = new Opaque130("attribute.name.generic.attack_speed", 43520);
    static final Opaque130 GL = new Opaque130("attribute.name.attack_speed", 43520);
    static final Opaque130 GM = new Opaque130("attribute.name.generic.attack_knockback", 43520);
    static final Opaque130 GN = new Opaque130("attribute.name.attack_knockback", 43520);
    static final Opaque130 GO = new Opaque130("attribute.name.player.block_interaction_range", 43520);
    static final Opaque130 GP = new Opaque130("attribute.name.block_interaction_range", 43520);
    static final Opaque130 GQ = new Opaque130("attribute.name.player.entity_interaction_range", 43520);
    static final Opaque130 GR = new Opaque130("attribute.name.entity_interaction_range", 43520);

    public ItemStackBuilder_4(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, Material material) {
        super(material);
        this.Ga = pluginFileConfigurationHolder;
        this.Gg = string2;
        this.Gf = string;
        this.Gh = string + ":" + string2;
        this.Gi = this.Gh.hashCode();
        this.FR = new NItem((ItemStack)this);
        this.mM();
        this.Gd = new ConfigurationSectionBridge_2(this);
        this.Ge = new Behaviours(this);
        this.Gw = ItemStackBridge_2.V(material);
    }

    ItemStackBuilder_4(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, int n, Material material) {
        super(material);
        this.Gi = n;
        this.Ga = pluginFileConfigurationHolder;
        this.Gg = string2;
        this.Gf = string;
        this.Gh = string + ":" + string2;
        this.FR = new NItem((ItemStack)this);
        this.mM();
        this.Gd = new ConfigurationSectionBridge_2(this);
        this.Ge = new Behaviours(this);
        this.Gw = ItemStackBridge_2.V(material);
    }

    public static void a(ItemStack itemStack, String string, String string2) {
        NItem nItem = new NItem(itemStack);
        nItem.getOrAddCompound("itemsadder").setString("namespace", string);
        nItem.getOrAddCompound("itemsadder").setString("id", string2);
        nItem.save();
    }

    private void mM() {
        this.FR.getOrAddCompound("itemsadder").setString("namespace", this.Gf);
        this.FR.getOrAddCompound("itemsadder").setString("id", this.Gg);
        this.FR.save();
    }

    public void a(@Nullable MaterialBridge_10 materialBridge_10) {
        this.FX = materialBridge_10;
        assert (materialBridge_10 != null);
        PlayerHolder_2.tX().d(this, materialBridge_10.nF());
    }

    public void bD(String string) {
        this.FY = string;
        PlayerHolder_2.tX().d(this, string);
        this.mZ();
    }

    public boolean setItemMeta(@Nullable ItemMeta itemMeta) {
        boolean bl = super.setItemMeta(itemMeta);
        if (!bl) {
            return false;
        }
        this.mZ();
        return bl;
    }

    public void r(ItemStack itemStack) {
        NItem nItem = new NItem(itemStack);
        this.FR.merge(nItem);
        this.FR.save();
        this.mZ();
    }

    public void bE(String string) {
        try {
            PlayerHolder_2.tX().c(this.FR, string);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public ItemStackBuilder_4 mN() {
        ItemStackBuilder_4 itemStackBuilder_4 = new ItemStackBuilder_4(this.Ga, this.Gf, this.Gg, this.Gi, this.getType());
        itemStackBuilder_4.setItemMeta(this.getItemMeta());
        itemStackBuilder_4.bK(this.nf());
        return itemStackBuilder_4;
    }

    public ItemStackBuilder_4 mO() {
        ItemStackBuilder_4 itemStackBuilder_4 = new ItemStackBuilder_4(this.Ga, this.Gf, this.Gg, this.Gi, this.getType());
        itemStackBuilder_4.setItemMeta(this.getItemMeta());
        itemStackBuilder_4.bK(this.nf());
        itemStackBuilder_4.Ge.g(itemStackBuilder_4);
        itemStackBuilder_4.Gd.h(itemStackBuilder_4);
        return itemStackBuilder_4;
    }

    @NotNull
    public ItemStack mP() {
        ItemStack itemStack = new ItemStack(this.getType());
        itemStack.setAmount(this.getAmount());
        itemStack.setItemMeta(this.getItemMeta());
        return itemStack;
    }

    public static boolean isCustomItem(@Nullable ItemStack itemStack) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return false;
        }
        if (!NItem.hasNBT((ItemStack)itemStack)) {
            return false;
        }
        return new NItem(itemStack).hasKey("itemsadder");
    }

    public static boolean s(ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (!NItem.hasNBT((ItemStack)itemStack)) {
            return false;
        }
        return new NItem(itemStack).hasKey("itemsadder");
    }

    @Nullable
    public static String t(ItemStack itemStack) {
        if (itemStack == null) {
            return null;
        }
        if (!NItem.hasNBT((ItemStack)itemStack)) {
            return null;
        }
        NCompound nCompound = new NItem(itemStack).getCompound("itemsadder");
        if (nCompound != null) {
            return nCompound.getString("namespace") + ":" + nCompound.getString("id");
        }
        return null;
    }

    public static String u(ItemStack itemStack) {
        NItem nItem = new NItem(itemStack);
        return ItemStackBuilder_4.a(nItem, "namespace") + ":" + ItemStackBuilder_4.a(nItem, "id");
    }

    public static Integer v(ItemStack itemStack) {
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 != null) {
            return itemStackBuilder_4.Gi;
        }
        return null;
    }

    @Deprecated
    public static String w(ItemStack itemStack) {
        NItem nItem = new NItem(itemStack);
        return ItemStackBuilder_4.a(nItem, "namespace");
    }

    @Deprecated
    public static String x(ItemStack itemStack) {
        NItem nItem = new NItem(itemStack);
        return ItemStackBuilder_4.a(nItem, "id");
    }

    public NItem mQ() {
        return this.FR;
    }

    public void b(Set set) {
        ItemMeta itemMeta = this.getItemMeta();
        itemMeta.addItemFlags(set.toArray(new ItemFlag[0]));
        this.setItemMeta(itemMeta);
        this.Gz = set;
    }

    public void a(ItemFlag itemFlag) {
        ItemMeta itemMeta = this.getItemMeta();
        itemMeta.addItemFlags(new ItemFlag[]{itemFlag});
        this.setItemMeta(itemMeta);
        this.Gz.add(itemFlag);
    }

    public boolean b(@NotNull ItemFlag itemFlag) {
        return this.Gz.contains(itemFlag);
    }

    private void a(ItemMeta itemMeta) {
        if (this.Gz.isEmpty()) {
            return;
        }
        itemMeta.addItemFlags(this.Gz.toArray(new ItemFlag[0]));
    }

    @Override
    public boolean fW() {
        MaterialBridge_10 materialBridge_10 = this.FX;
        if (materialBridge_10 instanceof MaterialBridge_11) {
            MaterialBridge_11 materialBridge_11 = (MaterialBridge_11)materialBridge_10;
            return true;
        }
        if (this.FX instanceof MaterialBridge_12) {
            return false;
        }
        return this.ps != null && !this.ps.isEmpty() && !this.ps.equals(" ");
    }

    @Override
    public String ga() {
        return this.d(false, false);
    }

    @Override
    public String d(boolean bl, boolean bl2) {
        if (this.FX != null) {
            return this.FX.nH();
        }
        if (this.fW()) {
            if (this.ps.contains(":")) {
                return this.ps;
            }
            return (String)(bl2 ? this.getNamespace() + ":" : "") + this.ps;
        }
        return (String)(bl2 ? this.getNamespace() + ":" : "") + "item/ia_auto/" + this.getId() + (bl ? ".json" : "");
    }

    @Deprecated
    public void bF(String string) {
        if (string == null) {
            this.ps = null;
            return;
        }
        if (string.endsWith(".json")) {
            string = string.replace(".json", "");
        }
        this.ps = string;
    }

    public List getTextures() {
        MaterialBridge_10 materialBridge_10 = this.FX;
        if (materialBridge_10 instanceof MaterialBridge_11) {
            MaterialBridge_11 materialBridge_11 = (MaterialBridge_11)materialBridge_10;
            throw new IllegalStateException("This item has a custom model path, it doesn't use textures. Use getModelPath() instead.");
        }
        materialBridge_10 = this.FX;
        if (materialBridge_10 instanceof MaterialBridge_12) {
            MaterialBridge_12 materialBridge_12 = (MaterialBridge_12)materialBridge_10;
            return materialBridge_12.oD().values().stream().map(string -> {
                if (string.contains(":")) {
                    return string;
                }
                return this.Gf + ":" + string;
            }).toList();
        }
        return this.FT;
    }

    @Nullable
    public String mR() {
        if (this.FX != null) {
            return this.FX.mR();
        }
        return this.FU;
    }

    @Deprecated
    public void bG(String string) {
        if (string == null || string.isEmpty()) {
            this.FU = null;
            return;
        }
        if (string.contains(":")) {
            this.FU = string;
            return;
        }
        this.FU = this.Gf + ":" + string;
    }

    @Nullable
    public String mS() {
        return this.FV;
    }

    public void m(List list) {
        for (int i = 0; i < list.size(); ++i) {
            if (((String)list.get(i)).contains(":")) continue;
            list.set(i, this.Gf + ":" + (String)list.get(i));
        }
        this.FT = list;
    }

    @Override
    public boolean fZ() {
        return this.FW;
    }

    @Nullable
    public ArrayList mT() {
        return this.Gn;
    }

    public static void a(ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        itemStack.addUnsafeEnchantments((Map)itemStackBuilder_4.nr());
    }

    public long mU() {
        return (long)((float)this.Gq / 20.0f * 1000.0f);
    }

    public boolean mV() {
        return this.Gq != -1L;
    }

    public void bH(String string) {
        this.Gr = string;
    }

    public boolean mW() {
        return this.Gr != null;
    }

    public void s(String string, String string2) {
        if (this.Gs == null) {
            this.Gs = new HashMap();
        }
        this.Gs.put(string, string2);
    }

    @Nullable
    public String mX() {
        return this.Gu;
    }

    public boolean bg(Player player) {
        if (this.Gs == null) {
            return true;
        }
        for (Map.Entry entry : this.Gs.entrySet()) {
            float f = ItemStackRegistry.g().an.b(player, (String)entry.getKey(), 0.0f);
            char c = ((String)entry.getValue()).charAt(0);
            float f2 = Float.parseFloat(((String)entry.getValue()).substring(1));
            if (c == '>' ? f > f2 : (c == '<' ? f < f2 : c == '=' && f == f2)) continue;
            player.sendTitle(" ", Main.PQ.ir("player-stat-value-insufficient").replace("{stat}", (CharSequence)entry.getKey()).replace("{rule}", (CharSequence)entry.getValue()), 3, 40, 5);
            return false;
        }
        return true;
    }

    public List a(LivingEntity livingEntity, BlockBreakEnum blockBreakEnum) {
        return this.Gd.a(livingEntity, blockBreakEnum);
    }

    public void a(LivingEntity livingEntity, BlockBreakEnum blockBreakEnum, Consumer_3 consumer_3) {
        BukkitTaskBridge.i(() -> this.Gd.a((Entity)livingEntity, blockBreakEnum, consumer_3));
    }

    public void a(BlockBreakEnum blockBreakEnum, PlayerInteractEvent playerInteractEvent, ItemStack itemStack) {
        this.a((LivingEntity)playerInteractEvent.getPlayer(), blockBreakEnum, (Object builder_14) -> builder_14.j(playerInteractEvent, this, itemStack));
    }

    public static void y(ItemStack itemStack) {
        NItem nItem = new NItem(itemStack);
        NCompound nCompound = nItem.getCompound("itemsadder");
        if (nCompound != null && nCompound.hasKey("max_usages")) {
            nCompound.setInt("usages", nCompound.getInt("max_usages"));
            nItem.save();
        }
    }

    public static void a(ItemStack itemStack, int n) {
        NItem nItem = new NItem(itemStack);
        nItem.getOrAddCompound("itemsadder").setInt("usages", nItem.getOrAddCompound("itemsadder").getInt("usages") - n);
        nItem.save();
    }

    @Nullable
    public static Integer z(ItemStack itemStack) {
        NItem nItem = new NItem(itemStack);
        NCompound nCompound = nItem.getCompound("itemsadder");
        if (nCompound == null) {
            return null;
        }
        return nCompound.getInt("usages");
    }

    public static void A(ItemStack itemStack) {
        NItem nItem = new NItem(itemStack);
        int n = ItemStackBuilder_4.b(nItem, "usages");
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> list = new ArrayList();
        if (itemMeta.hasLore()) {
            list = itemMeta.getLore();
        }
        boolean bl = false;
        for (int i = 0; i < list.size(); ++i) {
            if (!ChatColor.stripColor((String)((String)list.get(i))).startsWith(StringUtils.replace((String)Main.PQ.hf("lore-usages"), (String)"{value}", (String)""))) continue;
            list.set(i, StringUtils.replace((String)Main.PQ.ir("lore-usages"), (String)"{value}", (String)("" + n)));
            bl = true;
        }
        if (!bl) {
            list.add(StringUtils.replace((String)Main.PQ.ir("lore-usages"), (String)"{value}", (String)("" + n)));
        }
        itemMeta.setLore(list);
        itemStack.setItemMeta(itemMeta);
    }

    public void mY() {
        ItemStackBuilder_4.A(this);
        this.mZ();
    }

    public static void a(ItemStack itemStack, String string) {
        NItem nItem = new NItem(itemStack);
        nItem.getOrAddCompound("itemsadder").setString("owner", string);
        nItem.save();
    }

    public static String B(ItemStack itemStack) {
        NCompound nCompound = new NItem(itemStack).getCompound("itemsadder");
        if (nCompound == null) {
            return null;
        }
        if (nCompound.hasKey("owner")) {
            return nCompound.getString("owner");
        }
        return null;
    }

    public void mZ() {
        this.FR.refreshCopy();
    }

    public void na() {
        this.FR.save();
    }

    @Nullable
    public static String a(NItem nItem, String string) {
        NCompound nCompound = nItem.getCompound("itemsadder");
        if (nCompound == null) {
            return null;
        }
        return nCompound.getString(string);
    }

    public static int b(NItem nItem, String string) {
        NCompound nCompound = nItem.getCompound("itemsadder");
        if (nCompound == null) {
            return 0;
        }
        return nCompound.getInt(string);
    }

    public int bI(String string) {
        return this.FR.getCompound("itemsadder").getInt(string);
    }

    public ItemStackBuilder_4 f(String string, int n) {
        this.FR.getOrAddCompound("itemsadder").setInt(string, n);
        this.FR.save();
        return this;
    }

    public ItemStackBuilder_4 bJ(String string) {
        return this.b(PluginBridge_6.gF(string));
    }

    public ItemStackBuilder_4 b(Component component) {
        this.FR.setItemName(PluginBridge_6.p(component));
        this.FR.save();
        return this;
    }

    public ItemStackBuilder_4 c(Component component) {
        this.FR.setCustomName(PluginBridge_6.p(component));
        this.FR.save();
        return this;
    }

    @Deprecated
    public String nb() {
        return this.getItemMeta().getDisplayName();
    }

    public Component itemName() {
        if (ItemStackBridge_2.af(this.getType())) {
            if (VersionHelper.Va) {
                return this.getItemMeta().displayName();
            }
            return PluginBridge_6.F(this.FR.getCustomName());
        }
        if (VersionHelper.Va) {
            return this.getItemMeta().itemName();
        }
        Object object = this.FR.getItemName();
        if (object == null) {
            return null;
        }
        return PluginBridge_6.F(object);
    }

    public void ae(int n) {
        ItemMeta itemMeta = this.getItemMeta();
        itemMeta.setCustomModelData(Integer.valueOf(n));
        this.setItemMeta(itemMeta);
        this.FR.refreshCopy();
    }

    public static void b(ItemStack itemStack, int n) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(Integer.valueOf(n));
        itemStack.setItemMeta(itemMeta);
    }

    @Override
    public int fX() {
        ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta.hasCustomModelData()) {
            return itemMeta.getCustomModelData();
        }
        return 0;
    }

    public boolean nc() {
        ItemMeta itemMeta = this.getItemMeta();
        return itemMeta.hasCustomModelData();
    }

    public static int C(ItemStack itemStack) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta.hasCustomModelData()) {
            return itemMeta.getCustomModelData();
        }
        return 0;
    }

    @Override
    public String getId() {
        return this.Gg;
    }

    @Override
    public String getNamespace() {
        return this.Gf;
    }

    @Override
    public String getNamespacedID() {
        return this.Gh;
    }

    public ItemStackBuilder_4 af(int n) {
        this.f("max_usages", n);
        return this;
    }

    public int nd() {
        return this.bI("max_usages");
    }

    public ItemStackBuilder_4 ag(int n) {
        this.f("usages", n);
        return this;
    }

    public int getUsages() {
        return this.bI("usages");
    }

    public String ne() {
        return "items." + this.getId();
    }

    public void bK(String string) {
        this.uI = string != null && (string.isEmpty() || string.equals(" ")) ? null : string;
    }

    @Nullable
    public String nf() {
        return this.uI;
    }

    public boolean hasPermission() {
        return this.uI != null;
    }

    public boolean l(ItemStackBuilder_4 itemStackBuilder_4) {
        if (itemStackBuilder_4 == null) {
            return false;
        }
        return this.Gi == itemStackBuilder_4.Gi;
    }

    public boolean e(ItemStack itemStack) {
        if (!ItemStackBuilder_4.isCustomItem(itemStack)) {
            return false;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 == null) {
            return false;
        }
        return this.Gi == itemStackBuilder_4.Gi;
    }

    @Deprecated
    public static boolean b(ItemStack itemStack, ItemStack itemStack2) {
        if (!ItemStackBuilder_4.isCustomItem(itemStack) || !ItemStackBuilder_4.isCustomItem(itemStack2)) {
            return false;
        }
        if (itemStack == itemStack2) {
            return true;
        }
        return ItemStackBuilder_4.u(itemStack).equals(ItemStackBuilder_4.u(itemStack2));
    }

    @Deprecated
    public static boolean b(ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (itemStackBuilder_4 == itemStack) {
            return true;
        }
        Integer n = ItemStackBuilder_4.v(itemStack);
        if (n == null) {
            return false;
        }
        return itemStackBuilder_4.Gi == n;
    }

    public static boolean a(@Nullable ItemStackBuilder_4 itemStackBuilder_4, @Nullable ItemStackBuilder_4 itemStackBuilder_42) {
        if (itemStackBuilder_4 == itemStackBuilder_42) {
            return true;
        }
        if (itemStackBuilder_4 == null || itemStackBuilder_42 == null) {
            return false;
        }
        return itemStackBuilder_4.Gi == itemStackBuilder_42.Gi;
    }

    @Deprecated
    public static boolean b(ItemStack itemStack, String string) {
        if (!ItemStackBuilder_4.isCustomItem(itemStack)) {
            return false;
        }
        return ItemStackBuilder_4.u(itemStack).equals(string);
    }

    public static boolean a(Integer n, ItemStack itemStack) {
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 == null) {
            return false;
        }
        return n == itemStackBuilder_4.Gi;
    }

    public static boolean e(ItemStack itemStack, ItemStack itemStack2) {
        if (!ItemStackBuilder_4.isCustomItem(itemStack) || !ItemStackBuilder_4.isCustomItem(itemStack2)) {
            return false;
        }
        if (itemStack == itemStack2) {
            return true;
        }
        boolean bl = ItemStackBuilder_4.u(itemStack).equals(ItemStackBuilder_4.u(itemStack2));
        if (!bl) {
            return false;
        }
        List list = itemStack.getItemMeta().getLore();
        List list2 = itemStack2.getItemMeta().getLore();
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); ++i) {
            if (((String)list.get(i)).equals(list2.get(i))) continue;
            return false;
        }
        return true;
    }

    public void a(String string, String string2, double d, String string3) {
        ItemStackBuilder_4.a(this, this.getNamespacedID(), string, string2, d, string3);
        this.mZ();
    }

    public static void a(ItemStackBuilder_4 itemStackBuilder_4, String string, String object, String string2, double d, String string3) {
        if (HeadEnum.bQ(string2 = string2.toLowerCase()) == null) {
            CommandSenderBridge_5.error("Unknown slot: '" + string2 + "' for item " + string);
            return;
        }
        object = ((String)object).replace("minecraft:", "");
        object = ((String)object).replaceAll("(.)(\\p{Upper})", "$1_$2").toLowerCase();
        if (Version.isAtLeast((Version)Version.v1_21_3)) {
            if (((String)object).startsWith("generic")) {
                object = ((String)object).replace("generic.", "");
            }
        } else if (!((String)object).contains(".") && !((String)object).startsWith("generic")) {
            object = "generic." + (String)object;
        }
        if (string3.equals("add") && ItemStackBridge_2.U(itemStackBuilder_4.getType())) {
            if (((String)object).equals("generic.attackDamage") || ((String)object).equals("generic.attack_damage") || ((String)object).equals("attack_damage")) {
                d = -1.0 + d;
            } else if (((String)object).equals("generic.attackSpeed") || ((String)object).equals("generic.attack_speed") || ((String)object).equals("attack_speed")) {
                d = -4.0 + d;
            }
        }
        AttributeModifier.Operation operation = AttributeModifier.Operation.ADD_NUMBER;
        if (string3.equals("multiply_base")) {
            operation = AttributeModifier.Operation.ADD_SCALAR;
        } else if (string3.equals("multiply")) {
            operation = AttributeModifier.Operation.MULTIPLY_SCALAR_1;
        }
        Attribute attribute = ItemStackBuilder_4.bL((String)object);
        if (attribute == null) {
            CommandSenderBridge_5.error("&cUnknown attribute modifier '&e" + (String)object + "&c' for item &e'" + string + "'&c. File " + itemStackBuilder_4.nh());
            return;
        }
        UUID uUID = UUID.nameUUIDFromBytes((String.valueOf(attribute) + operation.name() + d + string2).getBytes());
        ItemMeta itemMeta = itemStackBuilder_4.getItemMeta();
        itemMeta.addAttributeModifier(attribute, new AttributeModifier(uUID, "itemsadder", d, operation, HeadEnum.bR(string2)));
        itemStackBuilder_4.a(itemMeta);
        itemStackBuilder_4.setItemMeta(itemMeta);
    }

    public static void a(ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, NItem nItem, String string, String object, String string2, double d, String string3) {
        if (HeadEnum.bQ(string2 = string2.toLowerCase()) == null) {
            CommandSenderBridge_5.error("Unknown slot: '" + string2 + "' for item " + string);
            return;
        }
        object = ((String)object).replace("minecraft:", "");
        object = ((String)object).replaceAll("(.)(\\p{Upper})", "$1_$2").toLowerCase();
        if (Version.isAtLeast((Version)Version.v1_21_3)) {
            if (((String)object).startsWith("generic")) {
                object = ((String)object).replace("generic.", "");
            }
        } else if (!((String)object).contains(".") && !((String)object).startsWith("generic")) {
            object = "generic." + (String)object;
        }
        if (string3.equals("add") && ItemStackBridge_2.U(itemStack.getType())) {
            if (((String)object).equals("generic.attackDamage") || ((String)object).equals("generic.attack_damage") || ((String)object).equals("attack_damage")) {
                d = -1.0 + d;
            } else if (((String)object).equals("generic.attackSpeed") || ((String)object).equals("generic.attack_speed") || ((String)object).equals("attack_speed")) {
                d = -4.0 + d;
            }
        }
        AttributeModifier.Operation operation = AttributeModifier.Operation.ADD_NUMBER;
        if (string3.equals("multiply_base")) {
            operation = AttributeModifier.Operation.ADD_SCALAR;
        } else if (string3.equals("multiply")) {
            operation = AttributeModifier.Operation.MULTIPLY_SCALAR_1;
        }
        Attribute attribute = ItemStackBuilder_4.bL((String)object);
        if (attribute == null) {
            CommandSenderBridge_5.error("&cUnknown attribute modifier '&e" + (String)object + "&c' for item &e'" + string + "'&c. File " + itemStackBuilder_4.nh());
            return;
        }
        UUID uUID = UUID.nameUUIDFromBytes((String.valueOf(attribute) + operation.name() + d + string2).getBytes());
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.addAttributeModifier(attribute, new AttributeModifier(uUID, "itemsadder", d, operation, HeadEnum.bR(string2)));
        itemStack.setItemMeta(itemMeta);
        nItem.refreshCopy();
    }

    @Nullable
    private static Attribute bL(String string) {
        if ((string = string.replace("minecraft:", "")).equals("attack_reach") || string.equals("generic.attack_reach")) {
            string = "entity_interaction_range";
        }
        for (Attribute attribute : Attribute.values()) {
            if (!attribute.getKey().getKey().equalsIgnoreCase(string)) continue;
            return attribute;
        }
        String[] stringArray = string.split("\\.");
        if (stringArray.length != 2) {
            return null;
        }
        String string2 = stringArray[1];
        for (Attribute attribute : Attribute.values()) {
            String string3 = attribute.getKey().getKey();
            if (!string3.equalsIgnoreCase(string2) && !string3.endsWith("." + string2)) continue;
            return attribute;
        }
        return null;
    }

    @Nullable
    public static Multimap a(NItem nItem, HeadEnum headEnum) {
        ItemMeta itemMeta = nItem.getItem().getItemMeta();
        if (itemMeta == null) {
            return null;
        }
        Multimap multimap = itemMeta.getAttributeModifiers();
        if (multimap == null) {
            return null;
        }
        for (Map.Entry entry : multimap.entries()) {
            if (((AttributeModifier)entry.getValue()).getSlot() != headEnum.bukkitSlot || entry.getKey() != Attribute.GENERIC_ATTACK_DAMAGE && entry.getKey() != Attribute.GENERIC_ATTACK_SPEED) continue;
            return multimap;
        }
        return null;
    }

    public static double a(ItemStack itemStack, double d, HeadEnum headEnum) {
        NItem nItem = new NItem(itemStack);
        NList nList = nItem.getList("AttributeModifiers", NBTType.Compound);
        if (nList == null) {
            return 1.0;
        }
        double d2 = ItemStackBridge_2.aa(itemStack.getType());
        for (int i = 0; i < nList.size(); ++i) {
            String string;
            NCompound nCompound = nList.getOrAddCompound(i);
            String string2 = nCompound.getString("Slot");
            if (string2 == null || !string2.equals(headEnum.name) || !(string = nCompound.getString("AttributeName")).equals("generic.attackDamage") && !string.equals("minecraft:generic.attack_damage") && !string.equals("attack_damage")) continue;
            d2 = nCompound.getDouble("Amount") - d;
            break;
        }
        if (itemStack.containsEnchantment(Enchantment.SHARPNESS)) {
            float f = 1.0f;
            if (itemStack.getEnchantmentLevel(Enchantment.SHARPNESS) > 1) {
                f += (float)(itemStack.getEnchantmentLevel(Enchantment.SHARPNESS) - 1) * 0.5f;
            }
            d2 += (double)f;
        }
        return d2;
    }

    public static double a(ItemStack itemStack, Multimap multimap, double d, HeadEnum headEnum) {
        double d2 = ItemStackBridge_2.aa(itemStack.getType());
        for (Map.Entry entry : multimap.entries()) {
            if (((AttributeModifier)entry.getValue()).getSlot() != headEnum.bukkitSlot || entry.getKey() != Attribute.GENERIC_ATTACK_DAMAGE) continue;
            d2 = ((AttributeModifier)entry.getValue()).getAmount() - d;
        }
        Map map = itemStack.getItemMeta().getEnchants();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != Enchantment.SHARPNESS) continue;
            float f = 1.0f;
            if (itemStack.getEnchantmentLevel(Enchantment.SHARPNESS) > 1) {
                f += (float)(itemStack.getEnchantmentLevel(Enchantment.SHARPNESS) - 1) * 0.5f;
            }
            d2 += (double)f;
            break;
        }
        return d2;
    }

    public static double a(ItemStack itemStack, HeadEnum headEnum) {
        return ItemStackBuilder_4.a(itemStack, -1.0, headEnum);
    }

    public void b(ConfigurationSectionBridge configurationSectionBridge) {
        this.Gc = configurationSectionBridge;
        if (configurationSectionBridge != null) {
            YamlConfiguration yamlConfiguration = new YamlConfiguration();
            yamlConfiguration.createSection(this.ne(), configurationSectionBridge.azU.getValues(true));
            String string = yamlConfiguration.saveToString();
            this.Gb = PlayerJoinListener_7.F(string);
        }
    }

    public void h(@Nullable Integer n) {
        if (n == null) {
            return;
        }
        if (n < 1 || n > 99) {
            CommandSenderBridge_5.error("[Items] '" + this.getNamespacedID() + "'. Invalid max_stack_size '" + n + "'. It must be between 1 and 99. File: " + this.nh());
            return;
        }
        if (this.getMaxStackSize() == n.intValue()) {
            return;
        }
        ItemMeta itemMeta = this.getItemMeta();
        itemMeta.setMaxStackSize(n);
        this.setItemMeta(itemMeta);
    }

    public void al(boolean bl) {
        ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta.isFireResistant() == bl) {
            return;
        }
        itemMeta.setFireResistant(bl);
        this.setItemMeta(itemMeta);
    }

    public void am(boolean bl) {
        ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta.isHideTooltip() == bl) {
            return;
        }
        itemMeta.setHideTooltip(bl);
        this.setItemMeta(itemMeta);
    }

    public void ah(int n) {
        ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta instanceof Repairable) {
            Repairable repairable = (Repairable)itemMeta;
            if (!repairable.hasRepairCost() && n == 0) {
                return;
            }
            if (repairable.hasRepairCost() && repairable.getRepairCost() == n) {
                return;
            }
            repairable.setRepairCost(n);
            this.setItemMeta(itemMeta);
        }
    }

    public void an(boolean bl) {
        ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta.hasEnchantmentGlintOverride() && itemMeta.getEnchantmentGlintOverride() == bl) {
            return;
        }
        itemMeta.setEnchantmentGlintOverride(Boolean.valueOf(bl));
        this.setItemMeta(itemMeta);
    }

    public void a(@Nullable Integer n, @Nullable Integer n2, @Nullable Boolean bl, @Nullable Boolean bl2) {
        this.Gl = bl != null && bl != false;
        this.Gj = n2;
        this.Gk = n;
        if (n2 != null) {
            ItemStackBridge_2.c((ItemStack)this, n2);
        }
        if (n != null) {
            ItemStackBridge_2.d((ItemStack)this, n);
        }
        if (bl2 != null) {
            ItemStackBridge_2.c(this, bl2);
        }
        this.mZ();
    }

    public void a(NamespacedKey namespacedKey, EquipmentSlot equipmentSlot, @Nullable String string, @Nullable NamespacedKey namespacedKey2, @Nullable List list, @Nullable Boolean bl, @Nullable Boolean bl2, @Nullable Boolean bl3, @Nullable Boolean bl4) {
        PlayerHolder_2.tX().a(this, equipmentSlot, namespacedKey, string, namespacedKey2, list, bl, bl2, bl3, bl4);
        this.mZ();
    }

    public void b(@Nullable NamespacedKey namespacedKey) {
        PlayerHolder_2.tX().a((ItemStack)this, namespacedKey);
    }

    public void c(@Nullable NamespacedKey namespacedKey) {
        PlayerHolder_2.tX().b((ItemStack)this, namespacedKey);
        this.mZ();
    }

    public void a(ItemStackBuilder_4 itemStackBuilder_4, int n, float f, boolean bl, int n2, @Nullable String string, @Nullable String string2, @Nullable Boolean bl2, @Nullable List list) {
        PlayerHolder_2.tX().a(itemStackBuilder_4, n, f, bl, n2, string, string2, bl2, list);
        this.Gy = RecordOfValue_23.nS().ai(n).n(f).at(bl).aj(n2).bZ(string).ca(string2).c(bl2 != null && bl2 != false).n(list).oa();
    }

    public boolean ng() {
        return this.FX != null || this.FY != null;
    }

    public String nh() {
        return this.fz().nh();
    }

    public boolean ni() {
        return this.Gs != null && !this.Gs.isEmpty();
    }

    public ConfigurationSectionBridge ao(boolean bl) {
        if (!bl) {
            return this.fz().hj(this.ne());
        }
        return ConfigurationSectionBridge_4.a(this.fz(), this.ao(false), ItemStackRegistry.g().E(), this.Gf, this.Gg);
    }

    static DoubleData a(ItemStack itemStack, @Nullable Multimap multimap, HeadEnum headEnum) {
        DoubleData doubleData = new DoubleData();
        for (Map.Entry entry : multimap.entries()) {
            if (((AttributeModifier)entry.getValue()).getSlot() != headEnum.bukkitSlot) continue;
            if (doubleData.GU == null && entry.getKey() == Attribute.GENERIC_ATTACK_DAMAGE) {
                doubleData.GU = ((AttributeModifier)entry.getValue()).getAmount() - -1.0;
            }
            if (doubleData.GV == null && entry.getKey() == Attribute.GENERIC_ATTACK_SPEED) {
                doubleData.GV = ((AttributeModifier)entry.getValue()).getAmount() - -4.0;
            }
            if (doubleData.GW == null && entry.getKey() == Attribute.GENERIC_ATTACK_KNOCKBACK) {
                doubleData.GW = ((AttributeModifier)entry.getValue()).getAmount();
            }
            String string = ((Attribute)entry.getKey()).getKey().getKey();
            if (doubleData.GX == null && string.endsWith("block_interaction_range")) {
                doubleData.GX = ((AttributeModifier)entry.getValue()).getAmount();
            }
            if (doubleData.GY != null || !string.endsWith("entity_interaction_range")) continue;
            doubleData.GY = ((AttributeModifier)entry.getValue()).getAmount();
        }
        if (doubleData.GV == null) {
            doubleData.GV = PlayerHolder_2.tX().X(itemStack);
        }
        return doubleData;
    }

    public static void b(ItemStack itemStack, HeadEnum headEnum) {
        if (itemStack == null || !itemStack.hasItemMeta()) {
            return;
        }
        NItem nItem = new NItem(itemStack);
        @Nullable Multimap multimap = ItemStackBuilder_4.a(nItem, headEnum);
        if (multimap == null) {
            return;
        }
        double d = ItemStackBuilder_4.a(itemStack, multimap, -1.0, headEnum);
        List list = Objects.requireNonNullElseGet(nItem.getLoreCopy(), ArrayList::new);
        if (Version.isAtLeast((Version)Version.v1_21_3)) {
            ItemStackBuilder_4.a(nItem, list, headEnum, d, GJ);
        } else {
            ItemStackBuilder_4.a(nItem, list, headEnum, d, GI);
        }
    }

    public static void a(ItemStackBuilder_4 itemStackBuilder_4, HeadEnum headEnum) {
        NItem nItem = itemStackBuilder_4.FR;
        @Nullable Multimap multimap = ItemStackBuilder_4.a(nItem, headEnum);
        if (multimap == null) {
            return;
        }
        ItemStack itemStack = itemStackBuilder_4.mP();
        List list = Objects.requireNonNullElseGet(nItem.getLoreCopy(), ArrayList::new);
        double d = ItemStackBuilder_4.a(itemStack, multimap, -1.0, headEnum);
        if (Version.isAtLeast((Version)Version.v1_21_3)) {
            ItemStackBuilder_4.a(nItem, list, headEnum, d, GJ);
        } else {
            ItemStackBuilder_4.a(nItem, list, headEnum, d, GI);
        }
        DoubleData doubleData = ItemStackBuilder_4.a(itemStack, multimap, headEnum);
        if (Version.isAtLeast((Version)Version.v1_21_3)) {
            ItemStackBuilder_4.a(nItem, list, headEnum, doubleData.GV, GL);
            ItemStackBuilder_4.a(nItem, list, headEnum, doubleData.GW, GN);
            ItemStackBuilder_4.a(nItem, list, headEnum, doubleData.GX, GP);
            ItemStackBuilder_4.a(nItem, list, headEnum, doubleData.GY, GR);
        } else {
            ItemStackBuilder_4.a(nItem, list, headEnum, doubleData.GV, GK);
            ItemStackBuilder_4.a(nItem, list, headEnum, doubleData.GW, GM);
            ItemStackBuilder_4.a(nItem, list, headEnum, doubleData.GX, GO);
            ItemStackBuilder_4.a(nItem, list, headEnum, doubleData.GY, GQ);
        }
    }

    public static void a(NItem nItem, List list, HeadEnum headEnum, @Nullable Double d, Opaque130 opaque130) {
        if (d == null) {
            return;
        }
        Opaque130 opaque1302 = switch (headEnum.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> GC;
            case 1 -> GD;
            case 2 -> GE;
            case 3 -> GF;
            case 4 -> GG;
            case 5 -> GH;
        };
        boolean bl = false;
        int n = 0;
        for (int i = 0; i < list.size(); ++i) {
            Component component = PluginBridge_6.F(list.get(i));
            if (!PluginBridge_6.p(component).contains(opaque1302.Hf)) continue;
            bl = true;
            n = i;
            break;
        }
        Object object = PluginBridge_6.r(Opaque130.f((Component)Component.text((String)(" " + ColorBridge.b(d, false) + " "))).append(opaque130.He));
        if (!bl) {
            list.add(PacketContainerHolder.Xa);
            list.add(opaque1302.Hg);
            list.add(object);
        } else {
            Component component;
            int n2;
            boolean bl2 = false;
            for (n2 = n; n2 < list.size(); ++n2) {
                component = PluginBridge_6.F(list.get(n2));
                if (!PluginBridge_6.p(component).contains(opaque130.Hf)) continue;
                list.set(n2, object);
                bl2 = true;
                break;
            }
            if (!bl2) {
                for (n2 = n + 1; n2 < list.size(); ++n2) {
                    component = PluginBridge_6.F(list.get(n2));
                    String string = PluginBridge_6.p(component);
                    if (string.contains("translate.") || string.contains("attribute.name.")) continue;
                    list.add(n, object);
                    bl2 = true;
                    break;
                }
                if (!bl2) {
                    list.add(object);
                }
            }
        }
        NBT.dataComponents.setLore(nItem.getItem(), list);
        nItem.save();
    }

    public static void c(ItemStack itemStack, HeadEnum headEnum) {
        NItem nItem = new NItem(itemStack);
        @Nullable Multimap multimap = ItemStackBuilder_4.a(nItem, headEnum);
        if (multimap == null) {
            return;
        }
        List list = Objects.requireNonNullElseGet(nItem.getLoreCopy(), ArrayList::new);
        DoubleData doubleData = ItemStackBuilder_4.a(itemStack, multimap, headEnum);
        ItemStackBuilder_4.a(nItem, list, headEnum, doubleData.GV, GL);
        ItemStackBuilder_4.a(nItem, list, headEnum, doubleData.GW, GN);
    }

    public void a(BarColorBarStyleHolder barColorBarStyleHolder) {
        this.Gx = barColorBarStyleHolder;
        if (barColorBarStyleHolder != null && barColorBarStyleHolder.Ic == HiddenEnum.VANILLA) {
            PlayerHolder_2.tX().a(this, (float)this.Gq / 20.0f, this.Gh);
            this.mZ();
        }
    }

    @Nullable
    public BarColorBarStyleHolder nj() {
        return this.Gx;
    }

    @Nullable
    public HiddenEnum nk() {
        if (this.Gx == null) {
            return null;
        }
        return this.Gx.Ic;
    }

    public static void a(ItemStackBuilder_4 itemStackBuilder_4, Runner_2 runner_2) {
        ItemStackBuilder_4.a(itemStackBuilder_4, runner_2, runner_2);
    }

    public static void a(ItemStackBuilder_4 itemStackBuilder_4, Runner_2 runner_2, Runner_2 runner_22) {
        itemStackBuilder_4.mZ();
        if (ItemStackBuilder_4.a(runner_2, runner_22, itemStackBuilder_4.FR)) {
            itemStackBuilder_4.mQ().save();
            itemStackBuilder_4.mZ();
        }
    }

    public static void a(ItemStack itemStack, Runner_2 runner_2, Runner_2 runner_22) {
        NItem nItem = new NItem(itemStack);
        if (ItemStackBuilder_4.a(runner_2, runner_22, nItem)) {
            nItem.save();
        }
    }

    private static boolean a(Runner_2 runner_2, Runner_2 runner_22, NItem nItem) {
        Object object;
        Object object2;
        boolean bl = false;
        Object object3 = nItem.getCustomName();
        if (object3 != null) {
            object2 = PluginBridge_6.F(object3);
            object = runner_2.run((Component)object2);
            if (((ComponentBoolData)object).GZ) {
                object2 = ((ComponentBoolData)object).component;
                nItem.setCustomName(PluginBridge_6.p(object2));
                bl = true;
            }
        }
        if ((object2 = nItem.getItemName()) != null) {
            object = PluginBridge_6.F(object2);
            ComponentBoolData componentBoolData = runner_2.run((Component)object);
            if (componentBoolData.GZ) {
                object = componentBoolData.component;
                nItem.setItemName(PluginBridge_6.p((Component)object));
                bl = true;
            }
        }
        if ((object = nItem.getLoreCopy()) != null) {
            boolean bl2 = false;
            for (int i = 0; i < object.size(); ++i) {
                Component component = PluginBridge_6.F(object.get(i));
                ComponentBoolData componentBoolData = runner_22.run(component);
                if (!componentBoolData.GZ) continue;
                component = componentBoolData.component;
                object.set(i, PluginBridge_6.r(component));
                bl = true;
                bl2 = true;
            }
            if (bl2) {
                nItem.setLore((List)object);
            }
        }
        return bl;
    }

    public static void m(ItemStackBuilder_4 itemStackBuilder_4) {
        ItemStackBuilder_4.a(itemStackBuilder_4, (Component component) -> new ComponentBoolData(PluginBridge_6.t(component)));
    }

    public static void D(ItemStack itemStack) {
        ItemStackBuilder_4.a(itemStack, ItemStackBuilder_4::d, ItemStackBuilder_4::d);
    }

    private static ComponentBoolData d(Component component) {
        return new ComponentBoolData(PluginBridge_6.t(component));
    }

    public boolean hasCustomDurability() {
        return ItemStackBridge_2.ap(this);
    }

    public boolean nl() {
        return this.Gl;
    }

    public static int E(ItemStack itemStack) {
        return ItemStackBridge_2.E(itemStack);
    }

    public static void c(ItemStack itemStack, int n) {
        ItemStackBridge_2.c(itemStack, n);
    }

    public static void d(ItemStack itemStack, int n) {
        ItemStackBridge_2.d(itemStack, n);
    }

    public static void e(ItemStack itemStack, int n) {
        ItemStackBridge_2.e(itemStack, n);
    }

    public static void f(ItemStack itemStack, int n) {
        ItemStackBridge_2.f(itemStack, n);
    }

    @Deprecated
    public static boolean F(ItemStack itemStack) {
        return ItemStackBridge_2.ap(itemStack);
    }

    public static boolean G(ItemStack itemStack) {
        if (!ItemStackBuilder_4.F(itemStack)) {
            return false;
        }
        return ItemStackBridge_2.al(itemStack) <= 0;
    }

    public static boolean H(ItemStack itemStack) {
        if (!ItemStackBuilder_4.F(itemStack)) {
            return ItemStackBridge_2.G(itemStack);
        }
        return ItemStackBridge_2.al(itemStack) == 1;
    }

    public static void I(ItemStack itemStack) {
        ItemStackBridge_2.an(itemStack);
    }

    @Deprecated
    public static void g(ItemStack itemStack, int n) {
        ItemStackBridge_2.e(itemStack, n);
    }

    public static ItemStack a(ItemStack itemStack, int n, boolean bl) {
        return ItemStackBuilder_4.a(itemStack, n, null, bl, true);
    }

    public static void a(int n, Player player) {
        player.getInventory().setItemInMainHand(ItemStackBuilder_4.a(player.getInventory().getItemInMainHand(), n, (LivingEntity)player));
    }

    public static ItemStack a(ItemStack itemStack, int n, LivingEntity livingEntity) {
        return ItemStackBuilder_4.a(itemStack, n, livingEntity, false, true);
    }

    public static ItemStack a(ItemStack itemStack, int n, LivingEntity livingEntity, boolean bl, boolean bl2) {
        int n2;
        if (n == 0) {
            return itemStack;
        }
        if (itemStack.getType() == Material.AIR) {
            return itemStack;
        }
        if (!ItemStackBridge_2.ap(itemStack)) {
            return itemStack;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta.isUnbreakable()) {
            return itemStack;
        }
        if (itemMeta.hasEnchant(Enchantment.UNBREAKING)) {
            for (n2 = n; n2 > 0; --n2) {
                if (!ItemStackBridge_2.bE(itemMeta.getEnchantLevel(Enchantment.UNBREAKING))) continue;
                --n;
            }
        }
        if (n == 0) {
            return itemStack;
        }
        @Nullable ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        n2 = itemStackBuilder_4 == null ? 1 : (int)(itemStackBuilder_4.nl() ? 1 : 0);
        int n3 = ItemStackBridge_2.al(itemStack);
        if (n3 == 0 && bl) {
            return itemStack;
        }
        if (n2 == 0 && n3 - 1 <= 0) {
            ItemStackBridge_2.d(itemStack, 0);
            return itemStack;
        }
        if (livingEntity instanceof Player) {
            Player player = (Player)livingEntity;
            if (bl2 && ItemStackBuilder_4.a(player, itemStack, n)) {
                return itemStack;
            }
            ItemStackBuilder_4.f(itemStack, n);
            if (n3 - n <= 0 && !bl && n2 != 0) {
                ListenerBridge.b((Event)new PlayerItemBreakEvent(player, itemStack));
                ItemStackBridge_2.h(player, itemStack);
                ItemStackBridge_2.aj(itemStack);
                if (itemStack.getType() != Material.AIR && itemStack.getAmount() > 0) {
                    ItemStackBuilder_4.I(itemStack);
                }
                return itemStack;
            }
        } else {
            ItemStackBuilder_4.f(itemStack, n);
            if (n3 - n <= 0 && !bl && n2 != 0) {
                ItemStackBridge_2.a(livingEntity.getEyeLocation(), itemStack);
                ItemStackBridge_2.aj(itemStack);
                if (itemStack.getType() != Material.AIR && itemStack.getAmount() > 0) {
                    ItemStackBuilder_4.I(itemStack);
                }
            }
        }
        return itemStack;
    }

    public static boolean a(@Nullable Player player, ItemStack itemStack, int n) {
        if (player == null) {
            return false;
        }
        return !ListenerBridge.b((Event)new PlayerItemDamageEvent(player, itemStack, n));
    }

    public int hashCode() {
        return this.Gi;
    }

    @Deprecated
    @Generated
    public String nm() {
        return this.FS;
    }

    @Deprecated
    @Generated
    public void bM(String string) {
        this.FS = string;
    }

    @Deprecated
    @Generated
    public void bN(@Nullable String string) {
        this.FV = string;
    }

    @Deprecated
    @Generated
    public void ap(boolean bl) {
        this.FW = bl;
    }

    @Nullable
    @Generated
    public RecordOfNamespacedKey nn() {
        return this.FZ;
    }

    @Generated
    public void a(@Nullable RecordOfNamespacedKey recordOfNamespacedKey) {
        this.FZ = recordOfNamespacedKey;
    }

    @Generated
    public PluginFileConfigurationHolder fz() {
        return this.Ga;
    }

    @Nullable
    @Generated
    public Long no() {
        return this.Gb;
    }

    @Generated
    public ConfigurationSectionBridge np() {
        return this.Gc;
    }

    @Nullable
    @Generated
    public Opaque131 nq() {
        return this.Gm;
    }

    @Generated
    public void a(@Nullable Opaque131 opaque131) {
        this.Gm = opaque131;
    }

    @Generated
    public void a(@Nullable ArrayList arrayList) {
        this.Gn = arrayList;
    }

    @Generated
    public void aq(boolean bl) {
        this.Go = bl;
    }

    @Generated
    public boolean isBlockAllEnchants() {
        return this.Go;
    }

    @Generated
    public ImmutableMap nr() {
        return this.Gp;
    }

    @Generated
    public void c(ImmutableMap immutableMap) {
        this.Gp = immutableMap;
    }

    @Generated
    public void i(long l) {
        this.Gq = l;
    }

    @Generated
    public HashMap ns() {
        return this.Gs;
    }

    @Generated
    public void ar(boolean bl) {
        this.Gt = bl;
    }

    @Generated
    public boolean nt() {
        return this.Gt;
    }

    @Generated
    public void bO(String string) {
        this.Gu = string;
    }

    @Generated
    public boolean nu() {
        return this.Gw;
    }

    @Nullable
    @Generated
    public RecordOfValue_23 nv() {
        return this.Gy;
    }

    @Generated
    public boolean nw() {
        return this.GA;
    }

    @Generated
    public void as(boolean bl) {
        this.GA = bl;
    }

    public /* synthetic */ ItemStack clone() {
        return this.mO();
    }

    public /* synthetic */ Object clone() {
        return this.mO();
    }
}
