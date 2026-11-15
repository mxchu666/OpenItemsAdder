package itemsadder.m;

import itemsadder.m.ArmorStandEnum;
import itemsadder.m.BlockBridge_6;
import itemsadder.m.BlockBridge_7;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.EntityHolder;
import itemsadder.m.EntityTypeBridge_4;
import itemsadder.m.ItemStackBridge_6;
import itemsadder.m.ItemStackBridge_7;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackIntData;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationHolder_3;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.NamespacedKeyEntityTypeHolder;
import itemsadder.m.NamespacedKeyItemDisplayHolder;
import itemsadder.m.NamespacedKeyVectorHolder;
import itemsadder.m.Opaque125;
import itemsadder.m.Opaque126;
import itemsadder.m.Opaque133;
import itemsadder.m.PlayerBridge_16;
import itemsadder.m.PlayerBridge_17;
import itemsadder.m.SoundCategoryBridge;
import itemsadder.m.StringData_2;
import itemsadder.m.StringData_3;
import itemsadder.m.StringData_4;
import itemsadder.m.StringData_5;
import itemsadder.m.StringData_6;
import itemsadder.m.StringData_7;
import itemsadder.m.StringItemStackData;
import itemsadder.m.WorldBridge_11;
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

public class Behaviours {
    public final Map BZ = new ConcurrentHashMap();
    final ItemStackBuilder_4 Ca;

    public Behaviours(ItemStackBuilder_4 itemStackBuilder_4) {
        this.Ca = itemStackBuilder_4;
    }

    public void a(ItemStackRegistry itemStackRegistry) {
        String string = this.Ca.nh();
        ConfigurationSectionBridge configurationSectionBridge = this.Ca.np();
        List list = configurationSectionBridge.gR("behaviours");
        if (list == null) {
            return;
        }
        block49: for (String string3 : list) {
            Object object;
            String string4 = "behaviours." + string3;
            if (!configurationSectionBridge.C(string4 + ".enabled", true)) continue;
            switch (string3) {
                case "gun": {
                    String string5 = configurationSectionBridge.gV(string4 + ".projectile");
                    ItemStack itemStack = itemStackRegistry.q(string5);
                    if (itemStack == null) {
                        if (string5 == null) {
                            CommandSenderBridge_5.error("Projectile item not found for gun '" + this.Ca.getNamespacedID() + "'. File " + string);
                            continue block49;
                        }
                        CommandSenderBridge_5.error("Projectile item '" + string5 + "' not found for gun '" + this.Ca.getNamespacedID() + "'. File " + string);
                        continue block49;
                    }
                    StringItemStackData stringItemStackData = new StringItemStackData(this.Ca, itemStack);
                    this.BZ.put("gun", stringItemStackData);
                    break;
                }
                case "hat": {
                    if (!configurationSectionBridge.hq(string4)) break;
                    StringData_4 stringData_4 = new StringData_4(this.Ca);
                    this.BZ.put("hat", stringData_4);
                    break;
                }
                case "keep_on_death": {
                    if (!configurationSectionBridge.hq(string4)) break;
                    StringData_5 stringData_5 = new StringData_5(this.Ca);
                    this.BZ.put("keep_on_death", stringData_5);
                    break;
                }
                case "fuel": {
                    int n = configurationSectionBridge.t(string4 + ".burn_ticks", 1600);
                    if (n > Short.MAX_VALUE) {
                        n = Short.MAX_VALUE;
                        CommandSenderBridge_5.warn("'burn_ticks' for fuel '" + this.Ca.getNamespacedID() + "' is greater than the max value '32767'. Capped to it. File: " + string);
                    }
                    BlockBridge_6 blockBridge_6 = new BlockBridge_6(this.Ca, (short)n);
                    if (configurationSectionBridge.gP(string4 + ".machines")) {
                        List list2 = configurationSectionBridge.hg(string4 + ".machines");
                        for (String string6 : list2) {
                            if (SoundCategoryBridge.d(string6, Material.class)) {
                                blockBridge_6.yd.add(Material.valueOf((String)string6.toUpperCase()));
                                continue;
                            }
                            CommandSenderBridge_5.error("machine '" + string6 + "' set for fuel '" + this.Ca.getNamespacedID() + "' is not a furnace machine. Please fix it. File: " + string);
                        }
                    }
                    this.BZ.put("fuel", blockBridge_6);
                    break;
                }
                case "music_disc": {
                    StringData_7 stringData_7 = new StringData_7(this.Ca, configurationSectionBridge.gV(string4 + ".song.description"), configurationSectionBridge.gV(string4 + ".song.name"));
                    this.BZ.put("music_disc", stringData_7);
                    break;
                }
                case "vehicle": {
                    NamespacedKeyVectorHolder namespacedKeyVectorHolder = new NamespacedKeyVectorHolder(this.Ca, configurationSectionBridge.C(string4 + ".fixed_rotation", false), configurationSectionBridge.C(string4 + ".small", configurationSectionBridge.C(string4 + ".small_hitbox", true)), configurationSectionBridge.a(string4 + ".step_height", 0.3f), configurationSectionBridge.a(string4 + ".sit_height", 1.0f), configurationSectionBridge.a(string4 + ".speed.drive", 0.3f), configurationSectionBridge.a(string4 + ".speed.jump", 0.3f), configurationSectionBridge.a(string4 + ".speed.fly", 0.0f), configurationSectionBridge.t(string4 + ".fuel.start", -1), configurationSectionBridge.t(string4 + ".fuel.max", -1));
                    float f = configurationSectionBridge.a(string4 + ".hitbox.length", configurationSectionBridge.a(string4 + ".size.x", 1.0f));
                    float f2 = configurationSectionBridge.a(string4 + ".hitbox.width", configurationSectionBridge.a(string4 + ".size.y", 1.0f));
                    float f3 = configurationSectionBridge.a(string4 + ".hitbox.height", configurationSectionBridge.a(string4 + ".size.z", 1.0f));
                    if (f > 6.0f || f2 > 6.0f || f3 > 6.0f) {
                        CommandSenderBridge_5.error("Hitbox too big (max 6) for item " + this.Ca.getNamespacedID() + "'. File " + string);
                    } else {
                        namespacedKeyVectorHolder.a(f, f2, f3);
                    }
                    namespacedKeyVectorHolder.a(configurationSectionBridge.t(string4 + ".smoke.amount", 0), configurationSectionBridge.b(string4 + ".smoke.offset.x", 0.0), configurationSectionBridge.b(string4 + ".smoke.offset.y", 0.0), configurationSectionBridge.b(string4 + ".smoke.offset.z", -0.8));
                    String string7 = string4 + ".fuel.items.";
                    for (String string8 : configurationSectionBridge.gR(string4 + ".fuel.items")) {
                        ItemStack itemStack = itemStackRegistry.q(string8);
                        if (itemStack == null) {
                            CommandSenderBridge_5.error("Fuel item '" + string8 + "' not found for vehicle '" + this.Ca.getNamespacedID() + "'. File " + string);
                            continue;
                        }
                        if (configurationSectionBridge.hp(string7 + string8)) {
                            namespacedKeyVectorHolder.a(new ItemStackIntData(itemStack, null, configurationSectionBridge.gW(string7 + "." + string8)));
                            continue;
                        }
                        String string9 = configurationSectionBridge.az(string7 + "." + string8 + ".return_item", null);
                        ItemStack itemStack2 = string9 != null ? itemStackRegistry.q(string9) : null;
                        namespacedKeyVectorHolder.a(new ItemStackIntData(itemStack, itemStack2, configurationSectionBridge.t(string7 + "." + string8 + ".fuel_amount", 1)));
                    }
                    this.BZ.put("vehicle", namespacedKeyVectorHolder);
                    break;
                }
                case "furniture": {
                    ConfigurationSectionBridge configurationSectionBridge2 = configurationSectionBridge.hj(string4);
                    boolean bl = configurationSectionBridge.C(string4 + ".small_hitbox", configurationSectionBridge.C(string4 + ".small", false));
                    EntityType entityType = configurationSectionBridge.a(string4 + ".entity", EntityType.ARMOR_STAND, string2 -> CommandSenderBridge_5.error("Entity type '" + string2 + "' not valid for item '" + this.Ca.getNamespacedID() + "'. File " + string));
                    if (entityType == null) break;
                    if (entityType != EntityType.ARMOR_STAND && !EntityHolder.i(entityType) && entityType != EntityType.ITEM_DISPLAY) {
                        CommandSenderBridge_5.error("Entity type '" + String.valueOf(entityType) + "' not allowed (only ARMOR_STAND, ITEM_FRAME or GLOW_ITEM_FRAME, ITEM_DISPLAY) for item '" + this.Ca.getNamespacedID() + "'. File " + string);
                        break;
                    }
                    Object object2 = new NamespacedKeyItemDisplayHolder(this.Ca, entityType, configurationSectionBridge.C(string4 + ".gravity", false), configurationSectionBridge.C(string4 + ".fixed_rotation", false), bl, configurationSectionBridge.t(string4 + ".light_level", -1), configurationSectionBridge.C(string4 + ".solid", false), configurationSectionBridge.C(string4 + ".opposite_direction", false), configurationSectionBridge.C(string4 + ".drop_when_mined", !configurationSectionBridge.C(string4 + ".cancel_drop", false)), configurationSectionBridge.C(string4 + ".shift_interact_rotate", true));
                    float f = configurationSectionBridge.a(string4 + ".hitbox.length", 1.0f);
                    float f4 = configurationSectionBridge.a(string4 + ".hitbox.width", 1.0f);
                    float f5 = configurationSectionBridge.a(string4 + ".hitbox.height", 1.0f);
                    if (((NamespacedKeyItemDisplayHolder)object2).kI() && (f > 4.0f || f4 > 4.0f || f5 > 4.0f)) {
                        CommandSenderBridge_5.error("Solid hitbox too big (max 4) for furniture '" + this.Ca.getNamespacedID() + "'. File " + string);
                    } else {
                        ((NamespacedKeyEntityTypeHolder)object2).a(Math.min(f, 4.0f), Math.min(f4, 4.0f), Math.min(f5, 4.0f));
                    }
                    float f6 = configurationSectionBridge.a(string4 + ".hitbox.length_offset", 0.0f);
                    float f7 = configurationSectionBridge.a(string4 + ".hitbox.width_offset", 0.0f);
                    float f8 = configurationSectionBridge.a(string4 + ".hitbox.height_offset", 0.0f);
                    if (f6 > 5.0f || f7 > 5.0f || f8 > 5.0f) {
                        CommandSenderBridge_5.error("Hitbox offsets too big (max 5) for furniture '" + this.Ca.getNamespacedID() + "'. File " + string);
                    } else {
                        ((NamespacedKeyEntityTypeHolder)object2).b(f6, f7, f8);
                    }
                    if (configurationSectionBridge2.gP("display_transformation")) {
                        if (entityType != EntityType.ITEM_DISPLAY) {
                            CommandSenderBridge_5.error("Error loading furniture '" + this.Ca.getNamespacedID() + "'. 'display_transformation' is available only for 'item_display'. File " + string);
                        } else {
                            ConfigurationSectionBridge configurationSectionBridge3 = configurationSectionBridge2.hj("display_transformation");
                            if (configurationSectionBridge3 != null) {
                                if (!MaterialBarColorHolder.fC) {
                                    ((NamespacedKeyItemDisplayHolder)object2).ab(false);
                                } else {
                                    ((NamespacedKeyItemDisplayHolder)object2).ab(configurationSectionBridge3.C("auto_update_in_world", true));
                                }
                                if (configurationSectionBridge3.gP("adjust_legacy_model")) {
                                    switch (configurationSectionBridge3.az("adjust_legacy_model", "").toLowerCase(Locale.ROOT)) {
                                        case "armor_stand": {
                                            ((NamespacedKeyItemDisplayHolder)object2).a(ItemDisplay.ItemDisplayTransform.HEAD);
                                            ((NamespacedKeyItemDisplayHolder)object2).a(new Transformation(new Vector3f(f7 == 0.5f ? -1.0f : 0.0f, 1.7f, 0.0f), new Quaternionf(), new Vector3f(0.65f, 0.65f, 0.65f), new Quaternionf()));
                                            ((NamespacedKeyItemDisplayHolder)object2).a(ArmorStandEnum.ARMOR_STAND);
                                            break;
                                        }
                                        case "small_armor_stand": {
                                            ((NamespacedKeyItemDisplayHolder)object2).a(ItemDisplay.ItemDisplayTransform.HEAD);
                                            ((NamespacedKeyItemDisplayHolder)object2).a(new Transformation(new Vector3f(f7 == 0.5f ? -1.0f : 0.0f, 0.92f, 0.0f), new Quaternionf(), new Vector3f(0.45f, 0.45f, 0.45f), new Quaternionf()));
                                            ((NamespacedKeyItemDisplayHolder)object2).a(ArmorStandEnum.SMALL_ARMOR_STAND);
                                            break;
                                        }
                                        case "item_frame": {
                                            ((NamespacedKeyItemDisplayHolder)object2).a(ItemDisplay.ItemDisplayTransform.FIXED);
                                            ((NamespacedKeyItemDisplayHolder)object2).a(new Transformation(new Vector3f(0.0f, 0.0f, 0.0f), new Quaternionf(), new Vector3f(0.5f, 0.5f, 0.5f), new Quaternionf(new AxisAngle4f((float)Math.toRadians(270.0), 1.0f, 0.0f, 0.0f))));
                                            ((NamespacedKeyItemDisplayHolder)object2).a(ArmorStandEnum.ITEM_FRAME);
                                        }
                                    }
                                } else {
                                    ((NamespacedKeyItemDisplayHolder)object2).a((ItemDisplay.ItemDisplayTransform)SoundCategoryBridge.b(configurationSectionBridge3.gV("transform"), ItemDisplay.ItemDisplayTransform.class, (Enum)ItemDisplay.ItemDisplayTransform.FIXED));
                                    String string10 = Behaviours.a(configurationSectionBridge3, "right_rotation");
                                    Quaternionf quaternionf = Behaviours.a(configurationSectionBridge3, "left_rotation");
                                    Vector3f vector3f = new Vector3f(1.0f, 1.0f, 1.0f);
                                    Vector3f vector3f2 = new Vector3f(0.0f, 0.0f, 0.0f);
                                    if (configurationSectionBridge3.gP("scale")) {
                                        vector3f = new Vector3f(configurationSectionBridge3.gX("scale.x"), configurationSectionBridge3.gX("scale.y"), configurationSectionBridge3.gX("scale.z"));
                                    }
                                    if (configurationSectionBridge3.gP("translation")) {
                                        vector3f2 = new Vector3f(configurationSectionBridge3.gX("translation.x"), configurationSectionBridge3.gX("translation.y"), configurationSectionBridge3.gX("translation.z"));
                                    }
                                    ((NamespacedKeyItemDisplayHolder)object2).b(configurationSectionBridge3.a("render_size.width", f4), configurationSectionBridge3.a("render_size.height", f5));
                                    ((NamespacedKeyItemDisplayHolder)object2).a(new Transformation(vector3f2, quaternionf, vector3f, (Quaternionf)string10));
                                }
                            }
                        }
                    }
                    ((NamespacedKeyEntityTypeHolder)object2).d(configurationSectionBridge.C(string4 + ".placeable_on.walls", true), configurationSectionBridge.C(string4 + ".placeable_on.ceiling", true), configurationSectionBridge.C(string4 + ".placeable_on.floor", true));
                    if (configurationSectionBridge.gP(string4 + ".permission_suffix.break")) {
                        ((NamespacedKeyItemDisplayHolder)object2).bc(configurationSectionBridge.az(string4 + ".permission_suffix.break", null));
                    }
                    if (configurationSectionBridge.gP(string4 + ".permission_suffix.place")) {
                        ((NamespacedKeyItemDisplayHolder)object2).bd(configurationSectionBridge.az(string4 + ".permission_suffix.place", null));
                    }
                    this.BZ.put("furniture", object2);
                    break;
                }
                case "furniture_sit": {
                    Opaque125 opaque125 = new Opaque125(this.Ca, configurationSectionBridge.b(string4 + ".sit_height", 0.0), configurationSectionBridge.C(string4 + ".opposite_direction", true), configurationSectionBridge.C(string4 + ".sit_all_solid_blocks", true), configurationSectionBridge.C(string4 + ".passenger_front_view_on_sit", true), configurationSectionBridge.C(string4 + ".passenger_rotate_body", false));
                    this.BZ.put("furniture_sit", opaque125);
                    break;
                }
                case "furniture_consumable": {
                    List list3 = configurationSectionBridge.hg(string4 + ".furniture_list");
                    ArrayList<ItemStackBuilder_4> arrayList = new ArrayList<ItemStackBuilder_4>();
                    for (Object object2 : list3) {
                        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e((String)object2);
                        if (itemStackBuilder_4 == null) {
                            CommandSenderBridge_5.error("Unknown item '" + (String)object2 + "' in furniture_list of furniture_consumable '" + this.Ca.getNamespacedID() + "'. File " + string);
                            continue;
                        }
                        arrayList.add(itemStackBuilder_4);
                    }
                    PlayerBridge_17 playerBridge_17 = new PlayerBridge_17(this.Ca, configurationSectionBridge.t(string4 + ".hunger", 0), configurationSectionBridge.a(string4 + ".saturation", 0.0f), arrayList, true);
                    this.BZ.put("furniture_consumable", playerBridge_17);
                    break;
                }
                case "furniture_trade_machine": 
                case "block_trade_machine": {
                    ItemStackBridge_7 itemStackBridge_7 = null;
                    if (string3.equals("furniture_trade_machine")) {
                        itemStackBridge_7 = new StringData_3(this.Ca, configurationSectionBridge.az(string4 + ".title", "Trades"));
                        this.BZ.put("furniture_trade_machine", itemStackBridge_7);
                    } else {
                        itemStackBridge_7 = new StringData_2(this.Ca, configurationSectionBridge.az(string4 + ".title", "Trades"));
                        this.BZ.put("block_trade_machine", itemStackBridge_7);
                    }
                    if (configurationSectionBridge.gP(string4 + ".permission")) {
                        itemStackBridge_7.be(configurationSectionBridge.gV(string4 + ".permission"));
                    }
                    if (configurationSectionBridge.gP(string4 + ".gui_texture")) {
                        if (!configurationSectionBridge.gP(string4 + ".gui_texture.left") || !configurationSectionBridge.gP(string4 + ".gui_texture.right")) {
                            CommandSenderBridge_5.error("Missing texture for furniture_trade_machine " + this.Ca.getNamespacedID() + ". Check if left and right textures exist. File " + string);
                        } else {
                            itemStackBridge_7.b(ItemStackRegistry.g().al.aR(configurationSectionBridge.gV(string4 + ".gui_texture.left")));
                            itemStackBridge_7.c(ItemStackRegistry.g().al.aR(configurationSectionBridge.gV(string4 + ".gui_texture.right")));
                            itemStackBridge_7.aa(configurationSectionBridge.t(string4 + ".gui_texture.title_offset", -97));
                            itemStackBridge_7.kW();
                        }
                    }
                    String string11 = string4 + ".trades_list";
                    if (!configurationSectionBridge.gP(string4 + ".trades_list")) {
                        CommandSenderBridge_5.error("No trades_list found for item '" + this.Ca.getNamespacedID() + "'. File " + string);
                        continue block49;
                    }
                    for (Object object2 : configurationSectionBridge.gR(string4 + ".trades_list")) {
                        if (!configurationSectionBridge.gP(string11 + "." + (String)object2 + ".result.item")) {
                            CommandSenderBridge_5.error("No result for trade '" + (String)object2 + "' of " + this.Ca.getNamespacedID() + ". File " + string);
                            continue;
                        }
                        ItemStack itemStack = itemStackRegistry.f(configurationSectionBridge.gV(string11 + "." + (String)object2 + ".result.item"), string);
                        if (itemStack == null) continue;
                        itemStack.setAmount(configurationSectionBridge.t(string11 + "." + (String)object2 + ".result.amount", 1));
                        ItemStack itemStack3 = itemStackRegistry.f(configurationSectionBridge.gV(string11 + "." + (String)object2 + ".ingredients.slot1.item"), string);
                        if (itemStack3 == null) continue;
                        itemStack3.setAmount(configurationSectionBridge.t(string11 + "." + (String)object2 + ".ingredients.slot1.amount", 1));
                        ItemStack itemStack4 = null;
                        if (configurationSectionBridge.gP(string11 + "." + (String)object2 + ".ingredients.slot2.item")) {
                            itemStack4 = itemStackRegistry.f(configurationSectionBridge.gV(string11 + "." + (String)object2 + ".ingredients.slot2.item"), string);
                            if (itemStack4 == null) continue;
                            itemStack4.setAmount(configurationSectionBridge.t(string11 + "." + (String)object2 + ".ingredients.slot2.amount", 1));
                        }
                        itemStackBridge_7.a(itemStack, itemStack3, itemStack4);
                    }
                    break;
                }
                case "entity_summoner": {
                    String string12 = configurationSectionBridge.az(string4 + ".entity", null);
                    try {
                        EntityTypeBridge_4 entityTypeBridge_4 = new EntityTypeBridge_4(this.Ca, string12, configurationSectionBridge.c(string4 + ".max_per_chunk", (Integer)null), configurationSectionBridge.c(string4 + ".decrement_durability", (Integer)null), configurationSectionBridge.t(string4 + ".decrement_amount", 1));
                        this.BZ.put("entity_summoner", entityTypeBridge_4);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        CommandSenderBridge_5.error("Invalid 'entity' on 'entity_summoner' behaviour of '" + this.Ca.getNamespacedID() + "'. File " + string);
                    }
                    break;
                }
                case "complex_furniture": {
                    if (!MaterialBarColorHolder.dL) {
                        CommandSenderBridge_5.error("Can't load complex_furniture for item '" + this.Ca.getNamespacedID() + "'. Custom entities are disabled in config.yml. File " + string);
                        break;
                    }
                    String string13 = configurationSectionBridge.az(string4 + ".entity", null);
                    try {
                        LocationHolder_3 locationHolder_3 = LocationHolder_3.HO;
                        if (configurationSectionBridge.gP(string4 + ".sound.place") || configurationSectionBridge.gP(string4 + ".sound.break")) {
                            locationHolder_3 = new LocationHolder_3();
                            locationHolder_3.b(configurationSectionBridge.az(string4 + ".sound.place.name", null), configurationSectionBridge.a(string4 + ".sound.place.volume", 1.0f), configurationSectionBridge.a(string4 + ".sound.place.pitch", 1.0f));
                            locationHolder_3.a(configurationSectionBridge.az(string4 + ".sound.break.name", null), configurationSectionBridge.a(string4 + ".sound.break.volume", 1.0f), configurationSectionBridge.a(string4 + ".sound.break.pitch", 1.0f));
                        }
                        PlayerBridge_16 playerBridge_16 = new PlayerBridge_16(this.Ca, string13, configurationSectionBridge.a(string4 + ".static", (Boolean)null), configurationSectionBridge.c(string4 + ".max_per_chunk", (Integer)null), configurationSectionBridge.c(string4 + ".light_level", (Integer)null), configurationSectionBridge.a(string4 + ".solid", (Boolean)null), configurationSectionBridge.a(string4 + ".drop_when_mined", (Boolean)null), configurationSectionBridge.C(string4 + ".fixed_rotation", false), configurationSectionBridge.C(string4 + ".fixed_position", true), configurationSectionBridge.C(string4 + ".opposite_direction", false), configurationSectionBridge.az(string4 + ".permission_suffix", null), locationHolder_3, configurationSectionBridge.b(string4 + ".placement_offset.ceiling", 0.0), configurationSectionBridge.b(string4 + ".placement_offset.floor", 0.0), configurationSectionBridge.b(string4 + ".placement_offset.wall", 0.0));
                        this.BZ.put("complex_furniture", playerBridge_16);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        CommandSenderBridge_5.error("Invalid 'entity' on 'complex_furniture' behaviour of '" + this.Ca.getNamespacedID() + "'. File " + string);
                    }
                    break;
                }
                case "liquid_bucket": {
                    if (!MaterialBarColorHolder.cS) break;
                    String string14 = configurationSectionBridge.az(string4 + ".name", null);
                    Opaque133 opaque133 = (Opaque133)ItemStackRegistry.g().af.get(string14);
                    if (opaque133 == null) {
                        CommandSenderBridge_5.error("Liquid with name '" + string14 + "' not found for liquid bucket '" + this.Ca.getNamespacedID() + "'. File " + string);
                        continue block49;
                    }
                    BlockBridge_7 blockBridge_7 = new BlockBridge_7(this.Ca, opaque133);
                    this.BZ.put("liquid_bucket", blockBridge_7);
                    ItemStackRegistry.g().bf.put(blockBridge_7.kU().getNamespacedID(), this.Ca.getNamespacedID());
                    break;
                }
                case "liquid_analyzer": {
                    if (!configurationSectionBridge.hq(string4) || !MaterialBarColorHolder.cS) break;
                    StringData_6 stringData_6 = new StringData_6(this.Ca);
                    this.BZ.put("liquid_analyzer", stringData_6);
                    break;
                }
                case "sapling": {
                    String string15 = configurationSectionBridge.az(string4 + ".tree_populator", null);
                    if (string15 == null) {
                        CommandSenderBridge_5.error("Cannot create sapling '" + this.Ca.getNamespacedID() + ". You didn't set tree_populator in sapling behaviour. File " + string);
                        break;
                    }
                    WorldBridge_11 worldBridge_11 = (WorldBridge_11)WorldBridge_11.Oz.get(string15);
                    if (worldBridge_11 == null) {
                        CommandSenderBridge_5.error("Cannot create sapling '" + this.Ca.getNamespacedID() + "'. tree_populator '" + string15 + "' doesn't exist. File " + string);
                        break;
                    }
                    ItemStackBridge_6 itemStackBridge_6 = new ItemStackBridge_6(this.Ca, worldBridge_11);
                    this.BZ.put("sapling", itemStackBridge_6);
                }
            }
            if ((object = this.mb()) == null) continue;
            ((NamespacedKeyEntityTypeHolder)object).xu.a(configurationSectionBridge.az(string4 + ".sound.break.name", "minecraft:entity.armor_stand.break"), configurationSectionBridge.a(string4 + ".sound.break.volume", 1.0f), configurationSectionBridge.a(string4 + ".sound.break.pitch", 0.8f));
            ((NamespacedKeyEntityTypeHolder)object).xu.b(configurationSectionBridge.az(string4 + ".sound.place.name", "minecraft:entity.armor_stand.place"), configurationSectionBridge.a(string4 + ".sound.place.volume", 1.0f), configurationSectionBridge.a(string4 + ".sound.place.pitch", 0.8f));
        }
        this.ma();
    }

    private void ma() {
        for (Map.Entry entry : this.BZ.entrySet()) {
            ItemStackRegistry.g().P.computeIfAbsent((String)entry.getKey(), string -> new HashMap()).put(this.Ca.getNamespacedID(), this.Ca);
            ItemStackRegistry.g().Q.computeIfAbsent((String)entry.getKey(), string -> new ArrayList()).add(this.Ca.getNamespacedID());
            ItemStackRegistry.g().R.computeIfAbsent((String)entry.getKey(), string -> new ArrayList()).add(this.Ca.getId());
        }
    }

    public void a(String string2, Opaque126 opaque126) {
        this.BZ.put(string2, opaque126);
        ItemStackRegistry.g().P.computeIfAbsent(string2, string -> new HashMap()).put(this.Ca.getNamespacedID(), this.Ca);
        ItemStackRegistry.g().Q.computeIfAbsent(string2, string -> new ArrayList()).add(this.Ca.getNamespacedID());
        ItemStackRegistry.g().R.computeIfAbsent(string2, string -> new ArrayList()).add(this.Ca.getId());
    }

    public boolean bm(String string) {
        return this.BZ.containsKey(string);
    }

    @Nullable
    public Opaque126 bn(String string) {
        return (Opaque126)this.BZ.get(string);
    }

    @Nullable
    public NamespacedKeyEntityTypeHolder mb() {
        NamespacedKeyEntityTypeHolder namespacedKeyEntityTypeHolder = (NamespacedKeyEntityTypeHolder)this.Ca.Ge.bn("furniture");
        if (namespacedKeyEntityTypeHolder == null) {
            namespacedKeyEntityTypeHolder = (NamespacedKeyEntityTypeHolder)this.Ca.Ge.bn("vehicle");
        }
        return namespacedKeyEntityTypeHolder;
    }

    public void g(ItemStackBuilder_4 itemStackBuilder_4) {
        for (Map.Entry entry : this.BZ.entrySet()) {
            if (itemStackBuilder_4.Ge.BZ.containsKey(entry.getKey())) continue;
            Opaque126 opaque126 = ((Opaque126)entry.getValue()).f(itemStackBuilder_4);
            itemStackBuilder_4.Ge.BZ.put((String)entry.getKey(), opaque126);
            itemStackBuilder_4.Ge.ma();
        }
    }

    private static Quaternionf a(ConfigurationSectionBridge configurationSectionBridge, String string) {
        if (configurationSectionBridge.gP(string)) {
            if (configurationSectionBridge.gP(string + ".quaternion")) {
                return new Quaternionf(configurationSectionBridge.gX(string + ".quaternion.x"), configurationSectionBridge.gX(string + ".quaternion.y"), configurationSectionBridge.gX(string + ".quaternion.z"), configurationSectionBridge.gX(string + ".quaternion.w"));
            }
            if (configurationSectionBridge.gP(string + ".axis_angle")) {
                return new Quaternionf(new AxisAngle4f((float)Math.toRadians(configurationSectionBridge.gX(string + ".axis_angle.angle")), configurationSectionBridge.gX(string + ".axis_angle.axis.x"), configurationSectionBridge.gX(string + ".axis_angle.axis.y"), configurationSectionBridge.gX(string + ".axis_angle.axis.z")));
            }
        }
        return new Quaternionf();
    }
}
