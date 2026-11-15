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
import itemsadder.m.aaa;
import itemsadder.m.adb;
import itemsadder.m.aiq;
import itemsadder.m.bbe;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bcy;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.jj;
import itemsadder.m.mu;
import itemsadder.m.mv;
import itemsadder.m.oz;
import itemsadder.m.qo;
import itemsadder.m.qp;
import itemsadder.m.qq;
import itemsadder.m.qt;
import itemsadder.m.qu;
import itemsadder.m.qx;
import itemsadder.m.r;
import itemsadder.m.rc;
import itemsadder.m.rh;
import itemsadder.m.rj;
import itemsadder.m.rl;
import itemsadder.m.rm;
import itemsadder.m.rp;
import itemsadder.m.rq;
import itemsadder.m.rr;
import itemsadder.m.sv;
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

public class qm
extends ItemStack
implements qx {
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
    public rc FX;
    @Nullable
    public String FY;
    @Nullable
    private rm FZ;
    final bbf Ga;
    @Nullable
    Long Gb;
    bbg Gc;
    public final mv Gd;
    public final mu Ge;
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
    rr Gm;
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
    private rj Gx;
    @Nullable
    private rh Gy;
    private Set Gz = new HashSet();
    private boolean GA = true;
    static final int GB = 43520;
    static final qu GC = new qu("item.modifiers.head");
    static final qu GD = new qu("item.modifiers.chest");
    static final qu GE = new qu("item.modifiers.legs");
    static final qu GF = new qu("item.modifiers.feet");
    static final qu GG = new qu("item.modifiers.mainhand");
    static final qu GH = new qu("item.modifiers.offhand");
    static final qu GI = new qu("attribute.name.generic.attack_damage", 43520);
    static final qu GJ = new qu("attribute.name.attack_damage", 43520);
    static final qu GK = new qu("attribute.name.generic.attack_speed", 43520);
    static final qu GL = new qu("attribute.name.attack_speed", 43520);
    static final qu GM = new qu("attribute.name.generic.attack_knockback", 43520);
    static final qu GN = new qu("attribute.name.attack_knockback", 43520);
    static final qu GO = new qu("attribute.name.player.block_interaction_range", 43520);
    static final qu GP = new qu("attribute.name.block_interaction_range", 43520);
    static final qu GQ = new qu("attribute.name.player.entity_interaction_range", 43520);
    static final qu GR = new qu("attribute.name.entity_interaction_range", 43520);

    public qm(bbf bbf2, String string, String string2, Material material) {
        super(material);
        this.Ga = bbf2;
        this.Gg = string2;
        this.Gf = string;
        this.Gh = string + ":" + string2;
        this.Gi = this.Gh.hashCode();
        this.FR = new NItem((ItemStack)this);
        this.mM();
        this.Gd = new mv(this);
        this.Ge = new mu(this);
        this.Gw = bbs.V(material);
    }

    qm(bbf bbf2, String string, String string2, int n, Material material) {
        super(material);
        this.Gi = n;
        this.Ga = bbf2;
        this.Gg = string2;
        this.Gf = string;
        this.Gh = string + ":" + string2;
        this.FR = new NItem((ItemStack)this);
        this.mM();
        this.Gd = new mv(this);
        this.Ge = new mu(this);
        this.Gw = bbs.V(material);
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

    public void a(@Nullable rc rc2) {
        this.FX = rc2;
        assert (rc2 != null);
        aiq.tX().d(this, rc2.nF());
    }

    public void bD(String string) {
        this.FY = string;
        aiq.tX().d(this, string);
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
            aiq.tX().c(this.FR, string);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public qm mN() {
        qm qm2 = new qm(this.Ga, this.Gf, this.Gg, this.Gi, this.getType());
        qm2.setItemMeta(this.getItemMeta());
        qm2.bK(this.nf());
        return qm2;
    }

    public qm mO() {
        qm qm2 = new qm(this.Ga, this.Gf, this.Gg, this.Gi, this.getType());
        qm2.setItemMeta(this.getItemMeta());
        qm2.bK(this.nf());
        qm2.Ge.g(qm2);
        qm2.Gd.h(qm2);
        return qm2;
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
        return qm.a(nItem, "namespace") + ":" + qm.a(nItem, "id");
    }

    public static Integer v(ItemStack itemStack) {
        qm qm2 = d.g().a(itemStack);
        if (qm2 != null) {
            return qm2.Gi;
        }
        return null;
    }

    @Deprecated
    public static String w(ItemStack itemStack) {
        NItem nItem = new NItem(itemStack);
        return qm.a(nItem, "namespace");
    }

    @Deprecated
    public static String x(ItemStack itemStack) {
        NItem nItem = new NItem(itemStack);
        return qm.a(nItem, "id");
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
        rc rc2 = this.FX;
        if (rc2 instanceof rp) {
            rp rp2 = (rp)rc2;
            return true;
        }
        if (this.FX instanceof rq) {
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
        rc rc2 = this.FX;
        if (rc2 instanceof rp) {
            rp rp2 = (rp)rc2;
            throw new IllegalStateException("This item has a custom model path, it doesn't use textures. Use getModelPath() instead.");
        }
        rc2 = this.FX;
        if (rc2 instanceof rq) {
            rq rq2 = (rq)rc2;
            return rq2.oD().values().stream().map(string -> {
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

    public static void a(qm qm2, ItemStack itemStack) {
        itemStack.addUnsafeEnchantments((Map)qm2.nr());
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
            float f2 = d.g().an.b(player, (String)entry.getKey(), 0.0f);
            char c = ((String)entry.getValue()).charAt(0);
            float f3 = Float.parseFloat(((String)entry.getValue()).substring(1));
            if (c == '>' ? f2 > f3 : (c == '<' ? f2 < f3 : c == '=' && f2 == f3)) continue;
            player.sendTitle(" ", Main.PQ.ir("player-stat-value-insufficient").replace("{stat}", (CharSequence)entry.getKey()).replace("{rule}", (CharSequence)entry.getValue()), 3, 40, 5);
            return false;
        }
        return true;
    }

    public List a(LivingEntity livingEntity, jj jj2) {
        return this.Gd.a(livingEntity, jj2);
    }

    public void a(LivingEntity livingEntity, jj jj2, oz oz2) {
        bcp.i(() -> this.Gd.a((Entity)livingEntity, jj2, oz2));
    }

    public void a(jj jj2, PlayerInteractEvent playerInteractEvent, ItemStack itemStack) {
        this.a((LivingEntity)playerInteractEvent.getPlayer(), jj2, (Object ou2) -> ou2.j(playerInteractEvent, this, itemStack));
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
        int n = qm.b(nItem, "usages");
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
        qm.A(this);
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

    public qm f(String string, int n) {
        this.FR.getOrAddCompound("itemsadder").setInt(string, n);
        this.FR.save();
        return this;
    }

    public qm bJ(String string) {
        return this.b(bbe.gF(string));
    }

    public qm b(Component component) {
        this.FR.setItemName(bbe.p(component));
        this.FR.save();
        return this;
    }

    public qm c(Component component) {
        this.FR.setCustomName(bbe.p(component));
        this.FR.save();
        return this;
    }

    @Deprecated
    public String nb() {
        return this.getItemMeta().getDisplayName();
    }

    public Component itemName() {
        if (bbs.af(this.getType())) {
            if (aaa.Va) {
                return this.getItemMeta().displayName();
            }
            return bbe.F(this.FR.getCustomName());
        }
        if (aaa.Va) {
            return this.getItemMeta().itemName();
        }
        Object object = this.FR.getItemName();
        if (object == null) {
            return null;
        }
        return bbe.F(object);
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

    public qm af(int n) {
        this.f("max_usages", n);
        return this;
    }

    public int nd() {
        return this.bI("max_usages");
    }

    public qm ag(int n) {
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

    public boolean l(qm qm2) {
        if (qm2 == null) {
            return false;
        }
        return this.Gi == qm2.Gi;
    }

    public boolean e(ItemStack itemStack) {
        if (!qm.isCustomItem(itemStack)) {
            return false;
        }
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return false;
        }
        return this.Gi == qm2.Gi;
    }

    @Deprecated
    public static boolean b(ItemStack itemStack, ItemStack itemStack2) {
        if (!qm.isCustomItem(itemStack) || !qm.isCustomItem(itemStack2)) {
            return false;
        }
        if (itemStack == itemStack2) {
            return true;
        }
        return qm.u(itemStack).equals(qm.u(itemStack2));
    }

    @Deprecated
    public static boolean b(qm qm2, ItemStack itemStack) {
        if (qm2 == itemStack) {
            return true;
        }
        Integer n = qm.v(itemStack);
        if (n == null) {
            return false;
        }
        return qm2.Gi == n;
    }

    public static boolean a(@Nullable qm qm2, @Nullable qm qm3) {
        if (qm2 == qm3) {
            return true;
        }
        if (qm2 == null || qm3 == null) {
            return false;
        }
        return qm2.Gi == qm3.Gi;
    }

    @Deprecated
    public static boolean b(ItemStack itemStack, String string) {
        if (!qm.isCustomItem(itemStack)) {
            return false;
        }
        return qm.u(itemStack).equals(string);
    }

    public static boolean a(Integer n, ItemStack itemStack) {
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return false;
        }
        return n == qm2.Gi;
    }

    public static boolean e(ItemStack itemStack, ItemStack itemStack2) {
        if (!qm.isCustomItem(itemStack) || !qm.isCustomItem(itemStack2)) {
            return false;
        }
        if (itemStack == itemStack2) {
            return true;
        }
        boolean bl = qm.u(itemStack).equals(qm.u(itemStack2));
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

    public void a(String string, String string2, double d2, String string3) {
        qm.a(this, this.getNamespacedID(), string, string2, d2, string3);
        this.mZ();
    }

    public static void a(qm qm2, String string, String object, String string2, double d2, String string3) {
        if (qt.bQ(string2 = string2.toLowerCase()) == null) {
            bce.error("Unknown slot: '" + string2 + "' for item " + string);
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
        if (string3.equals("add") && bbs.U(qm2.getType())) {
            if (((String)object).equals("generic.attackDamage") || ((String)object).equals("generic.attack_damage") || ((String)object).equals("attack_damage")) {
                d2 = -1.0 + d2;
            } else if (((String)object).equals("generic.attackSpeed") || ((String)object).equals("generic.attack_speed") || ((String)object).equals("attack_speed")) {
                d2 = -4.0 + d2;
            }
        }
        AttributeModifier.Operation operation = AttributeModifier.Operation.ADD_NUMBER;
        if (string3.equals("multiply_base")) {
            operation = AttributeModifier.Operation.ADD_SCALAR;
        } else if (string3.equals("multiply")) {
            operation = AttributeModifier.Operation.MULTIPLY_SCALAR_1;
        }
        Attribute attribute = qm.bL((String)object);
        if (attribute == null) {
            bce.error("&cUnknown attribute modifier '&e" + (String)object + "&c' for item &e'" + string + "'&c. File " + qm2.nh());
            return;
        }
        UUID uUID = UUID.nameUUIDFromBytes((String.valueOf(attribute) + operation.name() + d2 + string2).getBytes());
        ItemMeta itemMeta = qm2.getItemMeta();
        itemMeta.addAttributeModifier(attribute, new AttributeModifier(uUID, "itemsadder", d2, operation, qt.bR(string2)));
        qm2.a(itemMeta);
        qm2.setItemMeta(itemMeta);
    }

    public static void a(qm qm2, ItemStack itemStack, NItem nItem, String string, String object, String string2, double d2, String string3) {
        if (qt.bQ(string2 = string2.toLowerCase()) == null) {
            bce.error("Unknown slot: '" + string2 + "' for item " + string);
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
        if (string3.equals("add") && bbs.U(itemStack.getType())) {
            if (((String)object).equals("generic.attackDamage") || ((String)object).equals("generic.attack_damage") || ((String)object).equals("attack_damage")) {
                d2 = -1.0 + d2;
            } else if (((String)object).equals("generic.attackSpeed") || ((String)object).equals("generic.attack_speed") || ((String)object).equals("attack_speed")) {
                d2 = -4.0 + d2;
            }
        }
        AttributeModifier.Operation operation = AttributeModifier.Operation.ADD_NUMBER;
        if (string3.equals("multiply_base")) {
            operation = AttributeModifier.Operation.ADD_SCALAR;
        } else if (string3.equals("multiply")) {
            operation = AttributeModifier.Operation.MULTIPLY_SCALAR_1;
        }
        Attribute attribute = qm.bL((String)object);
        if (attribute == null) {
            bce.error("&cUnknown attribute modifier '&e" + (String)object + "&c' for item &e'" + string + "'&c. File " + qm2.nh());
            return;
        }
        UUID uUID = UUID.nameUUIDFromBytes((String.valueOf(attribute) + operation.name() + d2 + string2).getBytes());
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.addAttributeModifier(attribute, new AttributeModifier(uUID, "itemsadder", d2, operation, qt.bR(string2)));
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
    public static Multimap a(NItem nItem, qt qt2) {
        ItemMeta itemMeta = nItem.getItem().getItemMeta();
        if (itemMeta == null) {
            return null;
        }
        Multimap multimap = itemMeta.getAttributeModifiers();
        if (multimap == null) {
            return null;
        }
        for (Map.Entry entry : multimap.entries()) {
            if (((AttributeModifier)entry.getValue()).getSlot() != qt2.bukkitSlot || entry.getKey() != Attribute.GENERIC_ATTACK_DAMAGE && entry.getKey() != Attribute.GENERIC_ATTACK_SPEED) continue;
            return multimap;
        }
        return null;
    }

    public static double a(ItemStack itemStack, double d2, qt qt2) {
        NItem nItem = new NItem(itemStack);
        NList nList = nItem.getList("AttributeModifiers", NBTType.Compound);
        if (nList == null) {
            return 1.0;
        }
        double d3 = bbs.aa(itemStack.getType());
        for (int i = 0; i < nList.size(); ++i) {
            String string;
            NCompound nCompound = nList.getOrAddCompound(i);
            String string2 = nCompound.getString("Slot");
            if (string2 == null || !string2.equals(qt2.name) || !(string = nCompound.getString("AttributeName")).equals("generic.attackDamage") && !string.equals("minecraft:generic.attack_damage") && !string.equals("attack_damage")) continue;
            d3 = nCompound.getDouble("Amount") - d2;
            break;
        }
        if (itemStack.containsEnchantment(Enchantment.SHARPNESS)) {
            float f2 = 1.0f;
            if (itemStack.getEnchantmentLevel(Enchantment.SHARPNESS) > 1) {
                f2 += (float)(itemStack.getEnchantmentLevel(Enchantment.SHARPNESS) - 1) * 0.5f;
            }
            d3 += (double)f2;
        }
        return d3;
    }

    public static double a(ItemStack itemStack, Multimap multimap, double d2, qt qt2) {
        double d3 = bbs.aa(itemStack.getType());
        for (Map.Entry entry : multimap.entries()) {
            if (((AttributeModifier)entry.getValue()).getSlot() != qt2.bukkitSlot || entry.getKey() != Attribute.GENERIC_ATTACK_DAMAGE) continue;
            d3 = ((AttributeModifier)entry.getValue()).getAmount() - d2;
        }
        Map map = itemStack.getItemMeta().getEnchants();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != Enchantment.SHARPNESS) continue;
            float f2 = 1.0f;
            if (itemStack.getEnchantmentLevel(Enchantment.SHARPNESS) > 1) {
                f2 += (float)(itemStack.getEnchantmentLevel(Enchantment.SHARPNESS) - 1) * 0.5f;
            }
            d3 += (double)f2;
            break;
        }
        return d3;
    }

    public static double a(ItemStack itemStack, qt qt2) {
        return qm.a(itemStack, -1.0, qt2);
    }

    public void b(bbg bbg2) {
        this.Gc = bbg2;
        if (bbg2 != null) {
            YamlConfiguration yamlConfiguration = new YamlConfiguration();
            yamlConfiguration.createSection(this.ne(), bbg2.azU.getValues(true));
            String string = yamlConfiguration.saveToString();
            this.Gb = r.F(string);
        }
    }

    public void h(@Nullable Integer n) {
        if (n == null) {
            return;
        }
        if (n < 1 || n > 99) {
            bce.error("[Items] '" + this.getNamespacedID() + "'. Invalid max_stack_size '" + n + "'. It must be between 1 and 99. File: " + this.nh());
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
            bbs.c((ItemStack)this, n2);
        }
        if (n != null) {
            bbs.d((ItemStack)this, n);
        }
        if (bl2 != null) {
            bbs.c(this, bl2);
        }
        this.mZ();
    }

    public void a(NamespacedKey namespacedKey, EquipmentSlot equipmentSlot, @Nullable String string, @Nullable NamespacedKey namespacedKey2, @Nullable List list, @Nullable Boolean bl, @Nullable Boolean bl2, @Nullable Boolean bl3, @Nullable Boolean bl4) {
        aiq.tX().a(this, equipmentSlot, namespacedKey, string, namespacedKey2, list, bl, bl2, bl3, bl4);
        this.mZ();
    }

    public void b(@Nullable NamespacedKey namespacedKey) {
        aiq.tX().a((ItemStack)this, namespacedKey);
    }

    public void c(@Nullable NamespacedKey namespacedKey) {
        aiq.tX().b((ItemStack)this, namespacedKey);
        this.mZ();
    }

    public void a(qm qm2, int n, float f2, boolean bl, int n2, @Nullable String string, @Nullable String string2, @Nullable Boolean bl2, @Nullable List list) {
        aiq.tX().a(qm2, n, f2, bl, n2, string, string2, bl2, list);
        this.Gy = rh.nS().ai(n).n(f2).at(bl).aj(n2).bZ(string).ca(string2).c(bl2 != null && bl2 != false).n(list).oa();
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

    public bbg ao(boolean bl) {
        if (!bl) {
            return this.fz().hj(this.ne());
        }
        return sv.a(this.fz(), this.ao(false), d.g().E(), this.Gf, this.Gg);
    }

    static qo a(ItemStack itemStack, @Nullable Multimap multimap, qt qt2) {
        qo qo2 = new qo();
        for (Map.Entry entry : multimap.entries()) {
            if (((AttributeModifier)entry.getValue()).getSlot() != qt2.bukkitSlot) continue;
            if (qo2.GU == null && entry.getKey() == Attribute.GENERIC_ATTACK_DAMAGE) {
                qo2.GU = ((AttributeModifier)entry.getValue()).getAmount() - -1.0;
            }
            if (qo2.GV == null && entry.getKey() == Attribute.GENERIC_ATTACK_SPEED) {
                qo2.GV = ((AttributeModifier)entry.getValue()).getAmount() - -4.0;
            }
            if (qo2.GW == null && entry.getKey() == Attribute.GENERIC_ATTACK_KNOCKBACK) {
                qo2.GW = ((AttributeModifier)entry.getValue()).getAmount();
            }
            String string = ((Attribute)entry.getKey()).getKey().getKey();
            if (qo2.GX == null && string.endsWith("block_interaction_range")) {
                qo2.GX = ((AttributeModifier)entry.getValue()).getAmount();
            }
            if (qo2.GY != null || !string.endsWith("entity_interaction_range")) continue;
            qo2.GY = ((AttributeModifier)entry.getValue()).getAmount();
        }
        if (qo2.GV == null) {
            qo2.GV = aiq.tX().X(itemStack);
        }
        return qo2;
    }

    public static void b(ItemStack itemStack, qt qt2) {
        if (itemStack == null || !itemStack.hasItemMeta()) {
            return;
        }
        NItem nItem = new NItem(itemStack);
        @Nullable Multimap multimap = qm.a(nItem, qt2);
        if (multimap == null) {
            return;
        }
        double d2 = qm.a(itemStack, multimap, -1.0, qt2);
        List list = Objects.requireNonNullElseGet(nItem.getLoreCopy(), ArrayList::new);
        if (Version.isAtLeast((Version)Version.v1_21_3)) {
            qm.a(nItem, list, qt2, d2, GJ);
        } else {
            qm.a(nItem, list, qt2, d2, GI);
        }
    }

    public static void a(qm qm2, qt qt2) {
        NItem nItem = qm2.FR;
        @Nullable Multimap multimap = qm.a(nItem, qt2);
        if (multimap == null) {
            return;
        }
        ItemStack itemStack = qm2.mP();
        List list = Objects.requireNonNullElseGet(nItem.getLoreCopy(), ArrayList::new);
        double d2 = qm.a(itemStack, multimap, -1.0, qt2);
        if (Version.isAtLeast((Version)Version.v1_21_3)) {
            qm.a(nItem, list, qt2, d2, GJ);
        } else {
            qm.a(nItem, list, qt2, d2, GI);
        }
        qo qo2 = qm.a(itemStack, multimap, qt2);
        if (Version.isAtLeast((Version)Version.v1_21_3)) {
            qm.a(nItem, list, qt2, qo2.GV, GL);
            qm.a(nItem, list, qt2, qo2.GW, GN);
            qm.a(nItem, list, qt2, qo2.GX, GP);
            qm.a(nItem, list, qt2, qo2.GY, GR);
        } else {
            qm.a(nItem, list, qt2, qo2.GV, GK);
            qm.a(nItem, list, qt2, qo2.GW, GM);
            qm.a(nItem, list, qt2, qo2.GX, GO);
            qm.a(nItem, list, qt2, qo2.GY, GQ);
        }
    }

    public static void a(NItem nItem, List list, qt qt2, @Nullable Double d2, qu qu2) {
        if (d2 == null) {
            return;
        }
        qu qu3 = switch (qt2.ordinal()) {
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
            Component component = bbe.F(list.get(i));
            if (!bbe.p(component).contains(qu3.Hf)) continue;
            bl = true;
            n = i;
            break;
        }
        Object object = bbe.r(qu.f((Component)Component.text((String)(" " + bcy.b(d2, false) + " "))).append(qu2.He));
        if (!bl) {
            list.add(adb.Xa);
            list.add(qu3.Hg);
            list.add(object);
        } else {
            Component component;
            int n2;
            boolean bl2 = false;
            for (n2 = n; n2 < list.size(); ++n2) {
                component = bbe.F(list.get(n2));
                if (!bbe.p(component).contains(qu2.Hf)) continue;
                list.set(n2, object);
                bl2 = true;
                break;
            }
            if (!bl2) {
                for (n2 = n + 1; n2 < list.size(); ++n2) {
                    component = bbe.F(list.get(n2));
                    String string = bbe.p(component);
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

    public static void c(ItemStack itemStack, qt qt2) {
        NItem nItem = new NItem(itemStack);
        @Nullable Multimap multimap = qm.a(nItem, qt2);
        if (multimap == null) {
            return;
        }
        List list = Objects.requireNonNullElseGet(nItem.getLoreCopy(), ArrayList::new);
        qo qo2 = qm.a(itemStack, multimap, qt2);
        qm.a(nItem, list, qt2, qo2.GV, GL);
        qm.a(nItem, list, qt2, qo2.GW, GN);
    }

    public void a(rj rj2) {
        this.Gx = rj2;
        if (rj2 != null && rj2.Ic == rl.VANILLA) {
            aiq.tX().a(this, (float)this.Gq / 20.0f, this.Gh);
            this.mZ();
        }
    }

    @Nullable
    public rj nj() {
        return this.Gx;
    }

    @Nullable
    public rl nk() {
        if (this.Gx == null) {
            return null;
        }
        return this.Gx.Ic;
    }

    public static void a(qm qm2, qp qp2) {
        qm.a(qm2, qp2, qp2);
    }

    public static void a(qm qm2, qp qp2, qp qp3) {
        qm2.mZ();
        if (qm.a(qp2, qp3, qm2.FR)) {
            qm2.mQ().save();
            qm2.mZ();
        }
    }

    public static void a(ItemStack itemStack, qp qp2, qp qp3) {
        NItem nItem = new NItem(itemStack);
        if (qm.a(qp2, qp3, nItem)) {
            nItem.save();
        }
    }

    private static boolean a(qp qp2, qp qp3, NItem nItem) {
        Object object;
        Object object2;
        boolean bl = false;
        Object object3 = nItem.getCustomName();
        if (object3 != null) {
            object2 = bbe.F(object3);
            object = qp2.run((Component)object2);
            if (((qq)object).GZ) {
                object2 = ((qq)object).component;
                nItem.setCustomName(bbe.p(object2));
                bl = true;
            }
        }
        if ((object2 = nItem.getItemName()) != null) {
            object = bbe.F(object2);
            qq qq2 = qp2.run((Component)object);
            if (qq2.GZ) {
                object = qq2.component;
                nItem.setItemName(bbe.p((Component)object));
                bl = true;
            }
        }
        if ((object = nItem.getLoreCopy()) != null) {
            boolean bl2 = false;
            for (int i = 0; i < object.size(); ++i) {
                Component component = bbe.F(object.get(i));
                qq qq3 = qp3.run(component);
                if (!qq3.GZ) continue;
                component = qq3.component;
                object.set(i, bbe.r(component));
                bl = true;
                bl2 = true;
            }
            if (bl2) {
                nItem.setLore((List)object);
            }
        }
        return bl;
    }

    public static void m(qm qm2) {
        qm.a(qm2, (Component component) -> new qq(bbe.t(component)));
    }

    public static void D(ItemStack itemStack) {
        qm.a(itemStack, qm::d, qm::d);
    }

    private static qq d(Component component) {
        return new qq(bbe.t(component));
    }

    public boolean hasCustomDurability() {
        return bbs.ap(this);
    }

    public boolean nl() {
        return this.Gl;
    }

    public static int E(ItemStack itemStack) {
        return bbs.E(itemStack);
    }

    public static void c(ItemStack itemStack, int n) {
        bbs.c(itemStack, n);
    }

    public static void d(ItemStack itemStack, int n) {
        bbs.d(itemStack, n);
    }

    public static void e(ItemStack itemStack, int n) {
        bbs.e(itemStack, n);
    }

    public static void f(ItemStack itemStack, int n) {
        bbs.f(itemStack, n);
    }

    @Deprecated
    public static boolean F(ItemStack itemStack) {
        return bbs.ap(itemStack);
    }

    public static boolean G(ItemStack itemStack) {
        if (!qm.F(itemStack)) {
            return false;
        }
        return bbs.al(itemStack) <= 0;
    }

    public static boolean H(ItemStack itemStack) {
        if (!qm.F(itemStack)) {
            return bbs.G(itemStack);
        }
        return bbs.al(itemStack) == 1;
    }

    public static void I(ItemStack itemStack) {
        bbs.an(itemStack);
    }

    @Deprecated
    public static void g(ItemStack itemStack, int n) {
        bbs.e(itemStack, n);
    }

    public static ItemStack a(ItemStack itemStack, int n, boolean bl) {
        return qm.a(itemStack, n, null, bl, true);
    }

    public static void a(int n, Player player) {
        player.getInventory().setItemInMainHand(qm.a(player.getInventory().getItemInMainHand(), n, (LivingEntity)player));
    }

    public static ItemStack a(ItemStack itemStack, int n, LivingEntity livingEntity) {
        return qm.a(itemStack, n, livingEntity, false, true);
    }

    public static ItemStack a(ItemStack itemStack, int n, LivingEntity livingEntity, boolean bl, boolean bl2) {
        int n2;
        if (n == 0) {
            return itemStack;
        }
        if (itemStack.getType() == Material.AIR) {
            return itemStack;
        }
        if (!bbs.ap(itemStack)) {
            return itemStack;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta.isUnbreakable()) {
            return itemStack;
        }
        if (itemMeta.hasEnchant(Enchantment.UNBREAKING)) {
            for (n2 = n; n2 > 0; --n2) {
                if (!bbs.bE(itemMeta.getEnchantLevel(Enchantment.UNBREAKING))) continue;
                --n;
            }
        }
        if (n == 0) {
            return itemStack;
        }
        @Nullable qm qm2 = d.g().a(itemStack);
        n2 = qm2 == null ? 1 : (int)(qm2.nl() ? 1 : 0);
        int n3 = bbs.al(itemStack);
        if (n3 == 0 && bl) {
            return itemStack;
        }
        if (n2 == 0 && n3 - 1 <= 0) {
            bbs.d(itemStack, 0);
            return itemStack;
        }
        if (livingEntity instanceof Player) {
            Player player = (Player)livingEntity;
            if (bl2 && qm.a(player, itemStack, n)) {
                return itemStack;
            }
            qm.f(itemStack, n);
            if (n3 - n <= 0 && !bl && n2 != 0) {
                bev.b((Event)new PlayerItemBreakEvent(player, itemStack));
                bbs.h(player, itemStack);
                bbs.aj(itemStack);
                if (itemStack.getType() != Material.AIR && itemStack.getAmount() > 0) {
                    qm.I(itemStack);
                }
                return itemStack;
            }
        } else {
            qm.f(itemStack, n);
            if (n3 - n <= 0 && !bl && n2 != 0) {
                bbs.a(livingEntity.getEyeLocation(), itemStack);
                bbs.aj(itemStack);
                if (itemStack.getType() != Material.AIR && itemStack.getAmount() > 0) {
                    qm.I(itemStack);
                }
            }
        }
        return itemStack;
    }

    public static boolean a(@Nullable Player player, ItemStack itemStack, int n) {
        if (player == null) {
            return false;
        }
        return !bev.b((Event)new PlayerItemDamageEvent(player, itemStack, n));
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
    public rm nn() {
        return this.FZ;
    }

    @Generated
    public void a(@Nullable rm rm2) {
        this.FZ = rm2;
    }

    @Generated
    public bbf fz() {
        return this.Ga;
    }

    @Nullable
    @Generated
    public Long no() {
        return this.Gb;
    }

    @Generated
    public bbg np() {
        return this.Gc;
    }

    @Nullable
    @Generated
    public rr nq() {
        return this.Gm;
    }

    @Generated
    public void a(@Nullable rr rr2) {
        this.Gm = rr2;
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
    public rh nv() {
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
