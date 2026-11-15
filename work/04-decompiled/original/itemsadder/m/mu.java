package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.afz;
import itemsadder.m.bbg;
import itemsadder.m.bbi;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.jl;
import itemsadder.m.jm;
import itemsadder.m.jn;
import itemsadder.m.jq;
import itemsadder.m.jr;
import itemsadder.m.js;
import itemsadder.m.ju;
import itemsadder.m.jw;
import itemsadder.m.jx;
import itemsadder.m.jy;
import itemsadder.m.jz;
import itemsadder.m.ka;
import itemsadder.m.kb;
import itemsadder.m.kc;
import itemsadder.m.kd;
import itemsadder.m.ke;
import itemsadder.m.kf;
import itemsadder.m.kg;
import itemsadder.m.kh;
import itemsadder.m.ki;
import itemsadder.m.mm;
import itemsadder.m.qm;
import itemsadder.m.rf;
import itemsadder.m.sh;
import itemsadder.m.wz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Transformation;
import org.jetbrains.annotations.Nullable;
import org.joml.AxisAngle4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class mu {
    public final Map BZ = new ConcurrentHashMap();
    final qm Ca;

    public mu(qm qm2) {
        this.Ca = qm2;
    }

    public void a(d d2) {
        String string = this.Ca.nh();
        bbg bbg2 = this.Ca.np();
        List list = bbg2.gR("behaviours");
        if (list == null) {
            return;
        }
        block49: for (String string3 : list) {
            Object object;
            String string4 = "behaviours." + string3;
            if (!bbg2.C(string4 + ".enabled", true)) continue;
            switch (string3) {
                case "gun": {
                    String string5 = bbg2.gV(string4 + ".projectile");
                    ItemStack itemStack = d2.q(string5);
                    if (itemStack == null) {
                        if (string5 == null) {
                            bce.error("Projectile item not found for gun '" + this.Ca.getNamespacedID() + "'. File " + string);
                            continue block49;
                        }
                        bce.error("Projectile item '" + string5 + "' not found for gun '" + this.Ca.getNamespacedID() + "'. File " + string);
                        continue block49;
                    }
                    jz jz2 = new jz(this.Ca, itemStack);
                    this.BZ.put("gun", jz2);
                    break;
                }
                case "hat": {
                    if (!bbg2.hq(string4)) break;
                    ka ka2 = new ka(this.Ca);
                    this.BZ.put("hat", ka2);
                    break;
                }
                case "keep_on_death": {
                    if (!bbg2.hq(string4)) break;
                    kb kb2 = new kb(this.Ca);
                    this.BZ.put("keep_on_death", kb2);
                    break;
                }
                case "fuel": {
                    int n = bbg2.t(string4 + ".burn_ticks", 1600);
                    if (n > Short.MAX_VALUE) {
                        n = Short.MAX_VALUE;
                        bce.warn("'burn_ticks' for fuel '" + this.Ca.getNamespacedID() + "' is greater than the max value '32767'. Capped to it. File: " + string);
                    }
                    jr jr2 = new jr(this.Ca, (short)n);
                    if (bbg2.gP(string4 + ".machines")) {
                        List list2 = bbg2.hg(string4 + ".machines");
                        for (String string6 : list2) {
                            if (bbi.d(string6, Material.class)) {
                                jr2.yd.add(Material.valueOf((String)string6.toUpperCase()));
                                continue;
                            }
                            bce.error("machine '" + string6 + "' set for fuel '" + this.Ca.getNamespacedID() + "' is not a furnace machine. Please fix it. File: " + string);
                        }
                    }
                    this.BZ.put("fuel", jr2);
                    break;
                }
                case "music_disc": {
                    ke ke2 = new ke(this.Ca, bbg2.gV(string4 + ".song.description"), bbg2.gV(string4 + ".song.name"));
                    this.BZ.put("music_disc", ke2);
                    break;
                }
                case "vehicle": {
                    kh kh2 = new kh(this.Ca, bbg2.C(string4 + ".fixed_rotation", false), bbg2.C(string4 + ".small", bbg2.C(string4 + ".small_hitbox", true)), bbg2.a(string4 + ".step_height", 0.3f), bbg2.a(string4 + ".sit_height", 1.0f), bbg2.a(string4 + ".speed.drive", 0.3f), bbg2.a(string4 + ".speed.jump", 0.3f), bbg2.a(string4 + ".speed.fly", 0.0f), bbg2.t(string4 + ".fuel.start", -1), bbg2.t(string4 + ".fuel.max", -1));
                    float f2 = bbg2.a(string4 + ".hitbox.length", bbg2.a(string4 + ".size.x", 1.0f));
                    float f3 = bbg2.a(string4 + ".hitbox.width", bbg2.a(string4 + ".size.y", 1.0f));
                    float f4 = bbg2.a(string4 + ".hitbox.height", bbg2.a(string4 + ".size.z", 1.0f));
                    if (f2 > 6.0f || f3 > 6.0f || f4 > 6.0f) {
                        bce.error("Hitbox too big (max 6) for item " + this.Ca.getNamespacedID() + "'. File " + string);
                    } else {
                        kh2.a(f2, f3, f4);
                    }
                    kh2.a(bbg2.t(string4 + ".smoke.amount", 0), bbg2.b(string4 + ".smoke.offset.x", 0.0), bbg2.b(string4 + ".smoke.offset.y", 0.0), bbg2.b(string4 + ".smoke.offset.z", -0.8));
                    String string7 = string4 + ".fuel.items.";
                    for (String string8 : bbg2.gR(string4 + ".fuel.items")) {
                        ItemStack itemStack = d2.q(string8);
                        if (itemStack == null) {
                            bce.error("Fuel item '" + string8 + "' not found for vehicle '" + this.Ca.getNamespacedID() + "'. File " + string);
                            continue;
                        }
                        if (bbg2.hp(string7 + string8)) {
                            kh2.a(new mm(itemStack, null, bbg2.gW(string7 + "." + string8)));
                            continue;
                        }
                        String string9 = bbg2.az(string7 + "." + string8 + ".return_item", null);
                        ItemStack itemStack2 = string9 != null ? d2.q(string9) : null;
                        kh2.a(new mm(itemStack, itemStack2, bbg2.t(string7 + "." + string8 + ".fuel_amount", 1)));
                    }
                    this.BZ.put("vehicle", kh2);
                    break;
                }
                case "furniture": {
                    bbg bbg3 = bbg2.hj(string4);
                    boolean bl = bbg2.C(string4 + ".small_hitbox", bbg2.C(string4 + ".small", false));
                    EntityType entityType = bbg2.a(string4 + ".entity", EntityType.ARMOR_STAND, string2 -> bce.error("Entity type '" + string2 + "' not valid for item '" + this.Ca.getNamespacedID() + "'. File " + string));
                    if (entityType == null) break;
                    if (entityType != EntityType.ARMOR_STAND && !afz.i(entityType) && entityType != EntityType.ITEM_DISPLAY) {
                        bce.error("Entity type '" + String.valueOf(entityType) + "' not allowed (only ARMOR_STAND, ITEM_FRAME or GLOW_ITEM_FRAME, ITEM_DISPLAY) for item '" + this.Ca.getNamespacedID() + "'. File " + string);
                        break;
                    }
                    Object object2 = new js(this.Ca, entityType, bbg2.C(string4 + ".gravity", false), bbg2.C(string4 + ".fixed_rotation", false), bl, bbg2.t(string4 + ".light_level", -1), bbg2.C(string4 + ".solid", false), bbg2.C(string4 + ".opposite_direction", false), bbg2.C(string4 + ".drop_when_mined", !bbg2.C(string4 + ".cancel_drop", false)), bbg2.C(string4 + ".shift_interact_rotate", true));
                    float f5 = bbg2.a(string4 + ".hitbox.length", 1.0f);
                    float f6 = bbg2.a(string4 + ".hitbox.width", 1.0f);
                    float f7 = bbg2.a(string4 + ".hitbox.height", 1.0f);
                    if (((js)object2).kI() && (f5 > 4.0f || f6 > 4.0f || f7 > 4.0f)) {
                        bce.error("Solid hitbox too big (max 4) for furniture '" + this.Ca.getNamespacedID() + "'. File " + string);
                    } else {
                        ((jl)object2).a(Math.min(f5, 4.0f), Math.min(f6, 4.0f), Math.min(f7, 4.0f));
                    }
                    float f8 = bbg2.a(string4 + ".hitbox.length_offset", 0.0f);
                    float f9 = bbg2.a(string4 + ".hitbox.width_offset", 0.0f);
                    float f10 = bbg2.a(string4 + ".hitbox.height_offset", 0.0f);
                    if (f8 > 5.0f || f9 > 5.0f || f10 > 5.0f) {
                        bce.error("Hitbox offsets too big (max 5) for furniture '" + this.Ca.getNamespacedID() + "'. File " + string);
                    } else {
                        ((jl)object2).b(f8, f9, f10);
                    }
                    if (bbg3.gP("display_transformation")) {
                        if (entityType != EntityType.ITEM_DISPLAY) {
                            bce.error("Error loading furniture '" + this.Ca.getNamespacedID() + "'. 'display_transformation' is available only for 'item_display'. File " + string);
                        } else {
                            bbg bbg4 = bbg3.hj("display_transformation");
                            if (bbg4 != null) {
                                if (!ae.fC) {
                                    ((js)object2).ab(false);
                                } else {
                                    ((js)object2).ab(bbg4.C("auto_update_in_world", true));
                                }
                                if (bbg4.gP("adjust_legacy_model")) {
                                    switch (bbg4.az("adjust_legacy_model", "").toLowerCase(Locale.ROOT)) {
                                        case "armor_stand": {
                                            ((js)object2).a(ItemDisplay.ItemDisplayTransform.HEAD);
                                            ((js)object2).a(new Transformation(new Vector3f(f9 == 0.5f ? -1.0f : 0.0f, 1.7f, 0.0f), new Quaternionf(), new Vector3f(0.65f, 0.65f, 0.65f), new Quaternionf()));
                                            ((js)object2).a(ju.ARMOR_STAND);
                                            break;
                                        }
                                        case "small_armor_stand": {
                                            ((js)object2).a(ItemDisplay.ItemDisplayTransform.HEAD);
                                            ((js)object2).a(new Transformation(new Vector3f(f9 == 0.5f ? -1.0f : 0.0f, 0.92f, 0.0f), new Quaternionf(), new Vector3f(0.45f, 0.45f, 0.45f), new Quaternionf()));
                                            ((js)object2).a(ju.SMALL_ARMOR_STAND);
                                            break;
                                        }
                                        case "item_frame": {
                                            ((js)object2).a(ItemDisplay.ItemDisplayTransform.FIXED);
                                            ((js)object2).a(new Transformation(new Vector3f(0.0f, 0.0f, 0.0f), new Quaternionf(), new Vector3f(0.5f, 0.5f, 0.5f), new Quaternionf(new AxisAngle4f((float)Math.toRadians(270.0), 1.0f, 0.0f, 0.0f))));
                                            ((js)object2).a(ju.ITEM_FRAME);
                                        }
                                    }
                                } else {
                                    ((js)object2).a((ItemDisplay.ItemDisplayTransform)bbi.b(bbg4.gV("transform"), ItemDisplay.ItemDisplayTransform.class, (Enum)ItemDisplay.ItemDisplayTransform.FIXED));
                                    String string10 = mu.a(bbg4, "right_rotation");
                                    Quaternionf quaternionf = mu.a(bbg4, "left_rotation");
                                    Vector3f vector3f = new Vector3f(1.0f, 1.0f, 1.0f);
                                    Vector3f vector3f2 = new Vector3f(0.0f, 0.0f, 0.0f);
                                    if (bbg4.gP("scale")) {
                                        vector3f = new Vector3f(bbg4.gX("scale.x"), bbg4.gX("scale.y"), bbg4.gX("scale.z"));
                                    }
                                    if (bbg4.gP("translation")) {
                                        vector3f2 = new Vector3f(bbg4.gX("translation.x"), bbg4.gX("translation.y"), bbg4.gX("translation.z"));
                                    }
                                    ((js)object2).b(bbg4.a("render_size.width", f6), bbg4.a("render_size.height", f7));
                                    ((js)object2).a(new Transformation(vector3f2, quaternionf, vector3f, (Quaternionf)string10));
                                }
                            }
                        }
                    }
                    ((jl)object2).d(bbg2.C(string4 + ".placeable_on.walls", true), bbg2.C(string4 + ".placeable_on.ceiling", true), bbg2.C(string4 + ".placeable_on.floor", true));
                    if (bbg2.gP(string4 + ".permission_suffix.break")) {
                        ((js)object2).bc(bbg2.az(string4 + ".permission_suffix.break", null));
                    }
                    if (bbg2.gP(string4 + ".permission_suffix.place")) {
                        ((js)object2).bd(bbg2.az(string4 + ".permission_suffix.place", null));
                    }
                    this.BZ.put("furniture", object2);
                    break;
                }
                case "furniture_sit": {
                    jx jx2 = new jx(this.Ca, bbg2.b(string4 + ".sit_height", 0.0), bbg2.C(string4 + ".opposite_direction", true), bbg2.C(string4 + ".sit_all_solid_blocks", true), bbg2.C(string4 + ".passenger_front_view_on_sit", true), bbg2.C(string4 + ".passenger_rotate_body", false));
                    this.BZ.put("furniture_sit", jx2);
                    break;
                }
                case "furniture_consumable": {
                    List list3 = bbg2.hg(string4 + ".furniture_list");
                    ArrayList<qm> arrayList = new ArrayList<qm>();
                    for (Object object2 : list3) {
                        qm qm2 = d.g().e((String)object2);
                        if (qm2 == null) {
                            bce.error("Unknown item '" + (String)object2 + "' in furniture_list of furniture_consumable '" + this.Ca.getNamespacedID() + "'. File " + string);
                            continue;
                        }
                        arrayList.add(qm2);
                    }
                    jw jw2 = new jw(this.Ca, bbg2.t(string4 + ".hunger", 0), bbg2.a(string4 + ".saturation", 0.0f), arrayList, true);
                    this.BZ.put("furniture_consumable", jw2);
                    break;
                }
                case "furniture_trade_machine": 
                case "block_trade_machine": {
                    kg kg2 = null;
                    if (string3.equals("furniture_trade_machine")) {
                        kg2 = new jy(this.Ca, bbg2.az(string4 + ".title", "Trades"));
                        this.BZ.put("furniture_trade_machine", kg2);
                    } else {
                        kg2 = new jm(this.Ca, bbg2.az(string4 + ".title", "Trades"));
                        this.BZ.put("block_trade_machine", kg2);
                    }
                    if (bbg2.gP(string4 + ".permission")) {
                        kg2.be(bbg2.gV(string4 + ".permission"));
                    }
                    if (bbg2.gP(string4 + ".gui_texture")) {
                        if (!bbg2.gP(string4 + ".gui_texture.left") || !bbg2.gP(string4 + ".gui_texture.right")) {
                            bce.error("Missing texture for furniture_trade_machine " + this.Ca.getNamespacedID() + ". Check if left and right textures exist. File " + string);
                        } else {
                            kg2.b(d.g().al.aR(bbg2.gV(string4 + ".gui_texture.left")));
                            kg2.c(d.g().al.aR(bbg2.gV(string4 + ".gui_texture.right")));
                            kg2.aa(bbg2.t(string4 + ".gui_texture.title_offset", -97));
                            kg2.kW();
                        }
                    }
                    String string11 = string4 + ".trades_list";
                    if (!bbg2.gP(string4 + ".trades_list")) {
                        bce.error("No trades_list found for item '" + this.Ca.getNamespacedID() + "'. File " + string);
                        continue block49;
                    }
                    for (Object object2 : bbg2.gR(string4 + ".trades_list")) {
                        if (!bbg2.gP(string11 + "." + (String)object2 + ".result.item")) {
                            bce.error("No result for trade '" + (String)object2 + "' of " + this.Ca.getNamespacedID() + ". File " + string);
                            continue;
                        }
                        ItemStack itemStack = d2.f(bbg2.gV(string11 + "." + (String)object2 + ".result.item"), string);
                        if (itemStack == null) continue;
                        itemStack.setAmount(bbg2.t(string11 + "." + (String)object2 + ".result.amount", 1));
                        ItemStack itemStack3 = d2.f(bbg2.gV(string11 + "." + (String)object2 + ".ingredients.slot1.item"), string);
                        if (itemStack3 == null) continue;
                        itemStack3.setAmount(bbg2.t(string11 + "." + (String)object2 + ".ingredients.slot1.amount", 1));
                        ItemStack itemStack4 = null;
                        if (bbg2.gP(string11 + "." + (String)object2 + ".ingredients.slot2.item")) {
                            itemStack4 = d2.f(bbg2.gV(string11 + "." + (String)object2 + ".ingredients.slot2.item"), string);
                            if (itemStack4 == null) continue;
                            itemStack4.setAmount(bbg2.t(string11 + "." + (String)object2 + ".ingredients.slot2.amount", 1));
                        }
                        kg2.a(itemStack, itemStack3, itemStack4);
                    }
                    break;
                }
                case "entity_summoner": {
                    String string12 = bbg2.az(string4 + ".entity", null);
                    try {
                        jq jq2 = new jq(this.Ca, string12, bbg2.c(string4 + ".max_per_chunk", (Integer)null), bbg2.c(string4 + ".decrement_durability", (Integer)null), bbg2.t(string4 + ".decrement_amount", 1));
                        this.BZ.put("entity_summoner", jq2);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        bce.error("Invalid 'entity' on 'entity_summoner' behaviour of '" + this.Ca.getNamespacedID() + "'. File " + string);
                    }
                    break;
                }
                case "complex_furniture": {
                    if (!ae.dL) {
                        bce.error("Can't load complex_furniture for item '" + this.Ca.getNamespacedID() + "'. Custom entities are disabled in config.yml. File " + string);
                        break;
                    }
                    String string13 = bbg2.az(string4 + ".entity", null);
                    try {
                        rf rf2 = rf.HO;
                        if (bbg2.gP(string4 + ".sound.place") || bbg2.gP(string4 + ".sound.break")) {
                            rf2 = new rf();
                            rf2.b(bbg2.az(string4 + ".sound.place.name", null), bbg2.a(string4 + ".sound.place.volume", 1.0f), bbg2.a(string4 + ".sound.place.pitch", 1.0f));
                            rf2.a(bbg2.az(string4 + ".sound.break.name", null), bbg2.a(string4 + ".sound.break.volume", 1.0f), bbg2.a(string4 + ".sound.break.pitch", 1.0f));
                        }
                        jn jn2 = new jn(this.Ca, string13, bbg2.a(string4 + ".static", (Boolean)null), bbg2.c(string4 + ".max_per_chunk", (Integer)null), bbg2.c(string4 + ".light_level", (Integer)null), bbg2.a(string4 + ".solid", (Boolean)null), bbg2.a(string4 + ".drop_when_mined", (Boolean)null), bbg2.C(string4 + ".fixed_rotation", false), bbg2.C(string4 + ".fixed_position", true), bbg2.C(string4 + ".opposite_direction", false), bbg2.az(string4 + ".permission_suffix", null), rf2, bbg2.b(string4 + ".placement_offset.ceiling", 0.0), bbg2.b(string4 + ".placement_offset.floor", 0.0), bbg2.b(string4 + ".placement_offset.wall", 0.0));
                        this.BZ.put("complex_furniture", jn2);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        bce.error("Invalid 'entity' on 'complex_furniture' behaviour of '" + this.Ca.getNamespacedID() + "'. File " + string);
                    }
                    break;
                }
                case "liquid_bucket": {
                    if (!ae.cS) break;
                    String string14 = bbg2.az(string4 + ".name", null);
                    sh sh2 = (sh)d.g().af.get(string14);
                    if (sh2 == null) {
                        bce.error("Liquid with name '" + string14 + "' not found for liquid bucket '" + this.Ca.getNamespacedID() + "'. File " + string);
                        continue block49;
                    }
                    kd kd2 = new kd(this.Ca, sh2);
                    this.BZ.put("liquid_bucket", kd2);
                    d.g().bf.put(kd2.kU().getNamespacedID(), this.Ca.getNamespacedID());
                    break;
                }
                case "liquid_analyzer": {
                    if (!bbg2.hq(string4) || !ae.cS) break;
                    kc kc2 = new kc(this.Ca);
                    this.BZ.put("liquid_analyzer", kc2);
                    break;
                }
                case "sapling": {
                    String string15 = bbg2.az(string4 + ".tree_populator", null);
                    if (string15 == null) {
                        bce.error("Cannot create sapling '" + this.Ca.getNamespacedID() + ". You didn't set tree_populator in sapling behaviour. File " + string);
                        break;
                    }
                    wz wz2 = (wz)wz.Oz.get(string15);
                    if (wz2 == null) {
                        bce.error("Cannot create sapling '" + this.Ca.getNamespacedID() + "'. tree_populator '" + string15 + "' doesn't exist. File " + string);
                        break;
                    }
                    kf kf2 = new kf(this.Ca, wz2);
                    this.BZ.put("sapling", kf2);
                }
            }
            if ((object = this.mb()) == null) continue;
            ((jl)object).xu.a(bbg2.az(string4 + ".sound.break.name", "minecraft:entity.armor_stand.break"), bbg2.a(string4 + ".sound.break.volume", 1.0f), bbg2.a(string4 + ".sound.break.pitch", 0.8f));
            ((jl)object).xu.b(bbg2.az(string4 + ".sound.place.name", "minecraft:entity.armor_stand.place"), bbg2.a(string4 + ".sound.place.volume", 1.0f), bbg2.a(string4 + ".sound.place.pitch", 0.8f));
        }
        this.ma();
    }

    private void ma() {
        for (Map.Entry entry : this.BZ.entrySet()) {
            d.g().P.computeIfAbsent((String)entry.getKey(), string -> new HashMap()).put(this.Ca.getNamespacedID(), this.Ca);
            d.g().Q.computeIfAbsent((String)entry.getKey(), string -> new ArrayList()).add(this.Ca.getNamespacedID());
            d.g().R.computeIfAbsent((String)entry.getKey(), string -> new ArrayList()).add(this.Ca.getId());
        }
    }

    public void a(String string2, ki ki2) {
        this.BZ.put(string2, ki2);
        d.g().P.computeIfAbsent(string2, string -> new HashMap()).put(this.Ca.getNamespacedID(), this.Ca);
        d.g().Q.computeIfAbsent(string2, string -> new ArrayList()).add(this.Ca.getNamespacedID());
        d.g().R.computeIfAbsent(string2, string -> new ArrayList()).add(this.Ca.getId());
    }

    public boolean bm(String string) {
        return this.BZ.containsKey(string);
    }

    @Nullable
    public ki bn(String string) {
        return (ki)this.BZ.get(string);
    }

    @Nullable
    public jl mb() {
        jl jl2 = (jl)this.Ca.Ge.bn("furniture");
        if (jl2 == null) {
            jl2 = (jl)this.Ca.Ge.bn("vehicle");
        }
        return jl2;
    }

    public void g(qm qm2) {
        for (Map.Entry entry : this.BZ.entrySet()) {
            if (qm2.Ge.BZ.containsKey(entry.getKey())) continue;
            ki ki2 = ((ki)entry.getValue()).f(qm2);
            qm2.Ge.BZ.put((String)entry.getKey(), ki2);
            qm2.Ge.ma();
        }
    }

    private static Quaternionf a(bbg bbg2, String string) {
        if (bbg2.gP(string)) {
            if (bbg2.gP(string + ".quaternion")) {
                return new Quaternionf(bbg2.gX(string + ".quaternion.x"), bbg2.gX(string + ".quaternion.y"), bbg2.gX(string + ".quaternion.z"), bbg2.gX(string + ".quaternion.w"));
            }
            if (bbg2.gP(string + ".axis_angle")) {
                return new Quaternionf(new AxisAngle4f((float)Math.toRadians(bbg2.gX(string + ".axis_angle.angle")), bbg2.gX(string + ".axis_angle.axis.x"), bbg2.gX(string + ".axis_angle.axis.y"), bbg2.gX(string + ".axis_angle.axis.z")));
            }
        }
        return new Quaternionf();
    }
}
