package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.aaf;
import itemsadder.m.axi;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbi;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.da;
import itemsadder.m.dn;
import itemsadder.m.dp;
import itemsadder.m.ql;
import itemsadder.m.ru;
import itemsadder.m.rw;
import itemsadder.m.rx;
import itemsadder.m.ry;
import itemsadder.m.tx;
import itemsadder.m.ub;
import itemsadder.m.uc;
import itemsadder.m.ud;
import itemsadder.m.ue;
import itemsadder.m.uf;
import itemsadder.m.ug;
import itemsadder.m.uj;
import itemsadder.m.ul;
import itemsadder.m.um;
import itemsadder.m.uo;
import itemsadder.m.up;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class ty {
    static final NamespacedKey KZ = new NamespacedKey(Main.rT(), "spawned_from_spawner");
    final Plugin La;
    final d Lb;
    public HashMap Lc = new HashMap();
    public HashMap Ld = new HashMap();
    public List Le = new ArrayList();
    public List Lf = new ArrayList();
    public HashMap Lg = new HashMap();
    public HashMap Lh = new HashMap();
    public tx Li;

    public ty(Plugin plugin, d d2) {
        this.Lb = d2;
        this.La = plugin;
        this.Li = new tx();
        this.Li.qm();
    }

    public void a(Collection collection) {
        for (bbf bbf2 : collection) {
            this.g(bbf2);
        }
    }

    public void g(bbf bbf2) {
        if (!bbf2.gP("loots")) {
            if (Main.KO.gY("debug.items.log-loots-loading")) {
                bce.log(String.valueOf(ChatColor.YELLOW) + "    No loots found in file " + bbf2.qd());
            }
            return;
        }
        block10: for (String string2 : bbf2.gR("loots")) {
            String string3 = "loots." + string2;
            switch (string2) {
                case "mobs": {
                    Object object;
                    String string4;
                    Object object2;
                    Object object3;
                    EntityType entityType2;
                    Object object4;
                    String string5;
                    for (String string6 : bbf2.gR(string3)) {
                        string5 = string3 + "." + string6;
                        if (!bbf2.z(string5 + ".enabled", true)) {
                            if (!Main.KO.gY("debug.items.log-loots-loading-disabled")) continue;
                            bce.log("    Ignored disabled loot: " + string6);
                            continue;
                        }
                        object4 = bbf2.gV(string5 + ".type");
                        if (object4 == null) {
                            bce.error("Missing 'type' in loot '" + string6 + "'. File " + bbf2.nh());
                            continue;
                        }
                        entityType2 = bbi.ih((String)object4);
                        if (entityType2 != null) {
                            object3 = new up(entityType2, bbf2.z(string5 + ".ignore_spawner", true));
                            object2 = (up)object3;
                            this.Lg.computeIfAbsent(((up)object2).getType(), entityType -> new ArrayList()).add(object2);
                        } else {
                            object2 = (dp)da.db().lJ.get(object4);
                            if (object2 == null) {
                                bce.error("Unknown entity '" + (String)object4 + "' not found for loot '" + string6 + "'. File: " + bbf2.nh());
                                continue;
                            }
                            object3 = new uc(((dp)object2).nO.getNamespacedID(), bbf2.z(string5 + ".ignore_spawner", true));
                            Object object5 = (uc)object3;
                            this.Lh.computeIfAbsent(((uc)object5).nL(), string -> new ArrayList()).add(object5);
                        }
                        if (bbf2.gP(string5 + ".nbt")) {
                            for (Object object5 : bbf2.gR(string5 + ".nbt")) {
                                string4 = string5 + ".nbt." + (String)object5;
                                object = new um(bbf2.gV((String)string4 + ".path"), bbf2.gV((String)string4 + ".value"), bbf2.gV((String)string4 + ".type"));
                                ((ud)object3).a((um)object);
                            }
                        }
                        if (bbf2.gP(string5 + ".metadata")) {
                            for (Object object5 : bbf2.gR(string5 + ".metadata")) {
                                string4 = string5 + ".metadata." + (String)object5;
                                object = bbf2.gV((String)string4 + ".name");
                                if (((String)object).equals("ItemsAdderMob")) {
                                    object = "ItemsAdderEntity";
                                }
                                uj uj2 = new uj((String)object, bbf2.gV((String)string4 + ".value"), bbf2.az((String)string4 + ".type", "string"));
                                ((ud)object3).a(uj2);
                            }
                        }
                        this.a((ug)object3, bbf2, string5);
                        this.Lf.add(object3);
                    }
                    continue block10;
                }
                case "blocks": {
                    Object object;
                    String string4;
                    Object object2;
                    Object object3;
                    EntityType entityType2;
                    Object object4;
                    String string5;
                    for (String string6 : bbf2.gR(string3)) {
                        string5 = string3 + "." + string6;
                        if (!bbf2.z(string5 + ".enabled", true)) {
                            if (!Main.KO.gY("debug.items.log-loots-loading-disabled")) continue;
                            bce.log("    Ignored disabled loot: " + string6);
                            continue;
                        }
                        object4 = bbf2.gV(string5 + ".type");
                        if (object4 == null) {
                            bce.error("Missing 'type' in loot '" + string6 + "'. File " + bbf2.nh());
                            continue;
                        }
                        entityType2 = bbi.ig((String)object4);
                        if (entityType2 != null) {
                            object3 = new uo((Material)entityType2);
                            if (bbf2.gP(string5 + ".nbt")) {
                                if (aaf.B(((uo)object3).nM())) {
                                    for (Object object5 : bbf2.gR(string5 + ".nbt")) {
                                        string4 = string5 + ".nbt." + (String)object5;
                                        object = new um(bbf2.gV(string4 + ".path"), bbf2.gV(string4 + ".value"), bbf2.gV(string4 + ".type"));
                                        ((ul)object3).a((um)object);
                                    }
                                } else {
                                    bce.error("Ignored NBT rule of loot for block: " + String.valueOf(ChatColor.AQUA) + string6 + String.valueOf(ChatColor.RED) + ". File " + String.valueOf(ChatColor.AQUA) + bbf2.nh() + String.valueOf(ChatColor.RED) + " (" + String.valueOf(ChatColor.AQUA) + String.valueOf(((uo)object3).nM()) + String.valueOf(ChatColor.RED) + " is not a tile entity!)");
                                }
                            }
                            this.a((ug)object3, bbf2, string5);
                            this.Lc.computeIfAbsent(Material.getMaterial((String)object4), material -> new ArrayList()).add(object3);
                            if (!Main.KO.gY("debug.items.log-loots-loading")) continue;
                            bce.log(String.valueOf(ChatColor.AQUA) + "Registered block loot: " + String.valueOf(((uo)object3).nM()));
                            continue;
                        }
                        if (!this.Lb.f((String)object4)) {
                            bce.error("Block '" + (String)object4 + "' not found for loot '" + string6 + "'. File: " + bbf2.nh());
                            continue;
                        }
                        object3 = this.Lb.e((String)object4);
                        if (object3 instanceof ql) {
                            object2 = new ub((ql)object3);
                            this.a((ug)object2, bbf2, string5);
                            this.Ld.computeIfAbsent((ql)object3, ql2 -> new ArrayList()).add(object2);
                            if (!Main.KO.gY("debug.items.log-loots-loading")) continue;
                            bce.log(String.valueOf(ChatColor.AQUA) + "Registered block loot: " + ((ub)object2).ln().getNamespacedID());
                            continue;
                        }
                        bce.error("Error: You have to set a valid BLOCK as the 'type' of block loot '" + string6 + "'. You set " + (String)object4 + "' which is NOT a block. File: " + bbf2.qd());
                    }
                    continue block10;
                }
                case "fishing": {
                    Object object4;
                    String string5;
                    for (String string6 : bbf2.gR(string3)) {
                        string5 = string3 + "." + string6;
                        if (!bbf2.z(string5 + ".enabled", true)) {
                            if (!Main.KO.gY("debug.items.log-loots-loading-disabled")) continue;
                            bce.log("    Ignored disabled loot: " + string6);
                            continue;
                        }
                        object4 = new ue();
                        this.a((ug)object4, bbf2, string5);
                        this.Le.add(object4);
                    }
                    break;
                }
            }
        }
    }

    private void a(ug ug2, bbf bbf2, String string) {
        Object object;
        Object object2;
        Object object32;
        for (Object object4 : bbf2.gR(string + ".items")) {
            object32 = string + ".items." + (String)object4;
            object2 = bbf2.gV((String)object32 + ".item");
            object = this.Lb.o((String)object2);
            if (object == null) {
                bce.error("Item '" + (String)object2 + "' not found for loot '" + string + "'. File: " + bbf2.nh());
                continue;
            }
            ry ry2 = new ry((ItemStack)object, bbf2.t((String)object32 + ".min_amount", 1), bbf2.t((String)object32 + ".max_amount", 1), bbf2.a((String)object32 + ".chance", 100.0f), bbf2.z((String)object32 + ".ignore_fortune", false));
            if (ry2.oR() > ry2.oS()) {
                bce.error("Invalid loot. 'min_amount' " + ry2.oR() + " greater than 'max_amount' " + ry2.oS() + "! Must be lower. Loot '" + string + "'. File: " + bbf2.nh());
                continue;
            }
            ug2.c(ry2);
        }
        if (bbf2.gP(string + ".exp")) {
            for (Object object4 : bbf2.gR(string + ".exp")) {
                object32 = string + ".exp." + (String)object4;
                object2 = new rx(bbf2.gW((String)object32 + ".min_amount"), bbf2.gW((String)object32 + ".max_amount"), bbf2.gX((String)object32 + ".chance"));
                ug2.a((rx)object2);
            }
        }
        if (bbf2.gP(string + ".commands")) {
            Iterator iterator = bbf2.hj(string + ".commands");
            assert (iterator != null);
            for (Object object32 : ((bbg)((Object)iterator)).CK()) {
                object2 = ((bbg)((Object)iterator)).hj((String)object32);
                assert (object2 != null);
                object = new ArrayList();
                for (String string2 : ((bbg)object2).CK()) {
                    if (string2.equals("chance")) continue;
                    bbg bbg2 = ((bbg)object2).hj(string2);
                    assert (bbg2 != null);
                    object.add(new rw(bbg2.gV("command"), bbg2.C("as_console", true), bbg2.C("silent", false)));
                }
                ug2.a(new ru((List)object, ((bbg)object2).gW("chance")));
            }
        }
        if (bbf2.gP(string + ".biomes")) {
            for (Object object4 : bbf2.hg(string + ".biomes")) {
                object32 = axi.vC().aoJ.dO(((String)object4).toUpperCase());
                if (object32 == null) continue;
                ug2.d((NamespacedKey)object32);
            }
        }
        if (bbf2.gP(string + ".worlds")) {
            for (Object object4 : bbf2.hg(string + ".worlds")) {
                ug2.cv((String)object4);
            }
        }
        ug2.aA(bbf2.z(string + ".stop_on_first_success", bbf2.z(string + ".drop_only_first", false)));
    }

    @Nullable
    public List c(Block block, Material material) {
        ArrayList<uo> arrayList = new ArrayList<uo>();
        List list = (List)this.Lc.get(material);
        if (list == null) {
            return null;
        }
        Biome biome = block.getBiome();
        World world = block.getWorld();
        for (uo uo2 : list) {
            if (!uo2.a(biome) || !uo2.i(world)) continue;
            arrayList.add(uo2);
        }
        return arrayList;
    }

    @Nullable
    public List e(Block block, ql ql2) {
        ArrayList<ub> arrayList = new ArrayList<ub>();
        List list = (List)this.Ld.get(ql2);
        if (list == null) {
            return null;
        }
        Biome biome = block.getBiome();
        World world = block.getWorld();
        for (ub ub2 : list) {
            if (!ub2.a(biome) || !ub2.i(world)) continue;
            arrayList.add(ub2);
        }
        return arrayList;
    }

    @Nullable
    public List aC(Block block) {
        ArrayList<ue> arrayList = new ArrayList<ue>();
        Biome biome = block.getBiome();
        World world = block.getWorld();
        for (ue ue2 : this.Le) {
            if (!ue2.a(biome) || !ue2.i(world)) continue;
            arrayList.add(ue2);
        }
        return arrayList;
    }

    @Nullable
    public List h(LivingEntity livingEntity) {
        ArrayList<up> arrayList = new ArrayList<up>();
        List list = (List)this.Lg.get(livingEntity.getType());
        if (list == null) {
            return null;
        }
        Block block = livingEntity.getLocation().getBlock();
        Biome biome = block.getBiome();
        World world = block.getWorld();
        for (up up2 : list) {
            if (!ty.a(livingEntity, biome, world, up2)) continue;
            arrayList.add(up2);
        }
        return arrayList;
    }

    @Nullable
    public List m(dn dn2) {
        LivingEntity livingEntity = dn2.eh();
        if (livingEntity == null) {
            return null;
        }
        ArrayList<uc> arrayList = new ArrayList<uc>();
        List list = (List)this.Lh.get(dn2.my.nO.getNamespacedID());
        if (list == null) {
            return null;
        }
        Block block = livingEntity.getLocation().getBlock();
        Biome biome = block.getBiome();
        World world = block.getWorld();
        for (uc uc2 : list) {
            if (!ty.a(livingEntity, biome, world, uc2)) continue;
            arrayList.add(uc2);
        }
        return arrayList;
    }

    private static boolean a(LivingEntity livingEntity, Biome biome, World world, ud ud2) {
        if (ud2.a(biome) && ud2.i(world)) {
            if (ud2.qq() && ((Boolean)livingEntity.getPersistentDataContainer().getOrDefault(KZ, PersistentDataType.BOOLEAN, (Object)false)).booleanValue()) {
                return false;
            }
            if (ud2.qn()) {
                for (uf uf2 : ud2.qp()) {
                    if (uf2.I((Entity)livingEntity)) continue;
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
