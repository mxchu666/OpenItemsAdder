package itemsadder.m;

import com.google.common.base.Splitter;
import com.mojang.datafixers.DataFix;
import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.TypeRewriteRule;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.OptionalDynamic;
import itemsadder.m.Count_4;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.datafix.ExtraDataFixUtils;
import net.minecraft.util.datafix.LegacyComponentDataFixUtils;
import net.minecraft.util.datafix.fixes.DataConverterTypes;
import net.minecraft.util.datafix.schemas.DataConverterSchemaNamed;

public class HideFlags_4
extends DataFix {
    private static final Set adE = Set.of("minecraft:potion", "minecraft:splash_potion", "minecraft:lingering_potion", "minecraft:tipped_arrow");
    private static final Set adF = Set.of("minecraft:pufferfish_bucket", "minecraft:salmon_bucket", "minecraft:cod_bucket", "minecraft:tropical_fish_bucket", "minecraft:axolotl_bucket", "minecraft:tadpole_bucket");
    private static final List adG = List.of("NoAI", "Silent", "NoGravity", "Glowing", "Invulnerable", "Health", "Age", "Variant", "HuntingCooldown", "BucketVariantTag");
    private static final Set adH = Set.of("attached", "bottom", "conditional", "disarmed", "drag", "enabled", "extended", "eye", "falling", "hanging", "has_bottle_0", "has_bottle_1", "has_bottle_2", "has_record", "has_book", "inverted", "in_wall", "lit", "locked", "occupied", "open", "persistent", "powered", "short", "signal_fire", "snowy", "triggered", "unstable", "waterlogged", "berries", "bloom", "shrieking", "can_summon", "up", "down", "north", "east", "south", "west", "slot_0_occupied", "slot_1_occupied", "slot_2_occupied", "slot_3_occupied", "slot_4_occupied", "slot_5_occupied", "cracked", "crafting");
    private static final Splitter adI = Splitter.on(',');

    public HideFlags_4(Schema schema) {
        super(schema, true);
    }

    public static void a(Count_4 count_4, Dynamic dynamic3) {
        Object object;
        Object object2;
        int n = count_4.dG("HideFlags").asInt(0);
        count_4.a("Damage", "minecraft:damage", dynamic3.createInt(0));
        count_4.a("RepairCost", "minecraft:repair_cost", dynamic3.createInt(0));
        count_4.O("CustomModelData", "minecraft:custom_model_data");
        count_4.dG("BlockStateTag").result().ifPresent(dynamic -> count_4.a("minecraft:block_state", HideFlags_4.a(dynamic)));
        count_4.O("EntityTag", "minecraft:entity_data");
        count_4.a("BlockEntityTag", false, dynamic -> {
            String string = DataConverterSchemaNamed.a((String)dynamic.get("id").asString(""));
            Dynamic dynamic2 = (dynamic = HideFlags_4.a(count_4, dynamic, string)).remove("id");
            return dynamic2.equals((Object)dynamic.emptyMap()) ? dynamic2 : dynamic;
        });
        count_4.O("BlockEntityTag", "minecraft:block_entity_data");
        if (count_4.dG("Unbreakable").asBoolean(false)) {
            object2 = dynamic3.emptyMap();
            if ((n & 4) != 0) {
                object2 = object2.set("show_in_tooltip", dynamic3.createBoolean(false));
            }
            count_4.a("minecraft:unbreakable", (Dynamic)object2);
        }
        HideFlags_4.a(count_4, dynamic3, "Enchantments", "minecraft:enchantments", (n & 1) != 0);
        if (count_4.dH("minecraft:enchanted_book")) {
            HideFlags_4.a(count_4, dynamic3, "StoredEnchantments", "minecraft:stored_enchantments", (n & 0x20) != 0);
        }
        count_4.a("display", false, dynamic -> HideFlags_4.a(count_4, dynamic, n));
        HideFlags_4.b(count_4, dynamic3, n);
        HideFlags_4.c(count_4, dynamic3, n);
        object2 = count_4.dG("Trim").result();
        if (((Optional)object2).isPresent()) {
            object = (Dynamic)((Optional)object2).get();
            if ((n & 0x80) != 0) {
                object = object.set("show_in_tooltip", object.createBoolean(false));
            }
            count_4.a("minecraft:trim", (Dynamic)object);
        }
        if ((n & 0x20) != 0) {
            count_4.a("minecraft:hide_additional_tooltip", dynamic3.emptyMap());
        }
        if (count_4.dH("minecraft:crossbow")) {
            count_4.dG("Charged");
            count_4.a("ChargedProjectiles", "minecraft:charged_projectiles", dynamic3.createList(Stream.empty()));
        }
        if (count_4.dH("minecraft:bundle")) {
            count_4.a("Items", "minecraft:bundle_contents", dynamic3.createList(Stream.empty()));
        }
        if (count_4.dH("minecraft:filled_map")) {
            count_4.O("map", "minecraft:map_id");
            object = count_4.dG("Decorations").asStream().map(HideFlags_4::d).collect(Collectors.toMap(Pair::getFirst, Pair::getSecond, (dynamic, dynamic2) -> dynamic));
            if (!object.isEmpty()) {
                count_4.a("minecraft:map_decorations", dynamic3.createMap((Map)object));
            }
        }
        if (count_4.f(adE)) {
            HideFlags_4.b(count_4, dynamic3);
        }
        if (count_4.dH("minecraft:writable_book")) {
            HideFlags_4.c(count_4, dynamic3);
        }
        if (count_4.dH("minecraft:written_book")) {
            HideFlags_4.d(count_4, dynamic3);
        }
        if (count_4.dH("minecraft:suspicious_stew")) {
            count_4.O("effects", "minecraft:suspicious_stew_effects");
        }
        if (count_4.dH("minecraft:debug_stick")) {
            count_4.O("DebugProperty", "minecraft:debug_stick_state");
        }
        if (count_4.f(adF)) {
            HideFlags_4.f(count_4, dynamic3);
        }
        if (count_4.dH("minecraft:goat_horn")) {
            count_4.O("instrument", "minecraft:instrument");
        }
        if (count_4.dH("minecraft:knowledge_book")) {
            count_4.O("Recipes", "minecraft:recipes");
        }
        if (count_4.dH("minecraft:compass")) {
            HideFlags_4.g(count_4, dynamic3);
        }
        if (count_4.dH("minecraft:firework_rocket")) {
            HideFlags_4.b(count_4);
        }
        if (count_4.dH("minecraft:firework_star")) {
            HideFlags_4.a(count_4);
        }
        if (count_4.dH("minecraft:player_head")) {
            count_4.dG("SkullOwner").result().ifPresent(dynamic -> count_4.a("minecraft:profile", HideFlags_4.f(dynamic)));
        }
    }

    private static Dynamic a(Dynamic dynamic) {
        Optional<Map> optional = dynamic.asMapOpt().result().map(stream -> stream.collect(Collectors.toMap(Pair::getFirst, pair -> {
            Optional optional;
            String string = ((Dynamic)pair.getFirst()).asString("");
            Dynamic dynamic = (Dynamic)pair.getSecond();
            if (adH.contains(string) && (optional = dynamic.asBoolean().result()).isPresent()) {
                return dynamic.createString(String.valueOf(optional.get()));
            }
            optional = dynamic.asNumber().result();
            return optional.isPresent() ? dynamic.createString(((Number)optional.get()).toString()) : dynamic;
        })));
        Objects.requireNonNull(dynamic);
        return (Dynamic)DataFixUtils.orElse(optional.map(object -> dynamic.createMap((Map)object)), (Object)dynamic);
    }

    private static Dynamic a(Count_4 count_4, Dynamic dynamic, int n) {
        Optional optional;
        boolean bl;
        count_4.a("minecraft:custom_name", dynamic.get("Name"));
        count_4.a("minecraft:lore", dynamic.get("Lore"));
        Optional<Integer> optional2 = dynamic.get("color").asNumber().result().map(Number::intValue);
        boolean bl2 = bl = (n & 0x40) != 0;
        if (optional2.isPresent() || bl) {
            optional = dynamic.emptyMap().set("rgb", dynamic.createInt(optional2.orElse(10511680).intValue()));
            if (bl) {
                optional = optional.set("show_in_tooltip", dynamic.createBoolean(false));
            }
            count_4.a("minecraft:dyed_color", (Dynamic)optional);
        }
        if ((optional = dynamic.get("LocName").asString().result()).isPresent()) {
            count_4.a("minecraft:item_name", LegacyComponentDataFixUtils.b((DynamicOps)dynamic.getOps(), (String)((String)optional.get())));
        }
        if (count_4.dH("minecraft:filled_map")) {
            count_4.a("minecraft:map_color", dynamic.get("MapColor"));
            dynamic = dynamic.remove("MapColor");
        }
        return dynamic.remove("Name").remove("Lore").remove("color").remove("LocName");
    }

    private static Dynamic a(Count_4 count_4, Dynamic dynamic2, String string) {
        count_4.a("minecraft:lock", dynamic2.get("Lock"));
        dynamic2 = dynamic2.remove("Lock");
        Optional optional = dynamic2.get("LootTable").result();
        if (optional.isPresent()) {
            dynamic3 = dynamic2.emptyMap().set("loot_table", (Dynamic)optional.get());
            long l = dynamic2.get("LootTableSeed").asLong(0L);
            if (l != 0L) {
                dynamic3 = dynamic3.set("seed", dynamic2.createLong(l));
            }
            count_4.a("minecraft:container_loot", dynamic3);
            dynamic2 = dynamic2.remove("LootTable").remove("LootTableSeed");
        }
        Dynamic dynamic3 = switch (string) {
            case "minecraft:skull" -> {
                count_4.a("minecraft:note_block_sound", dynamic2.get("note_block_sound"));
                yield dynamic2.remove("note_block_sound");
            }
            case "minecraft:decorated_pot" -> {
                count_4.a("minecraft:pot_decorations", dynamic2.get("sherds"));
                Optional var5_6 = dynamic2.get("item").result();
                if (var5_6.isPresent()) {
                    count_4.a("minecraft:container", dynamic2.createList(Stream.of(dynamic2.emptyMap().set("slot", dynamic2.createInt(0)).set("item", (Dynamic)var5_6.get()))));
                }
                yield dynamic2.remove("sherds").remove("item");
            }
            case "minecraft:banner" -> {
                count_4.a("minecraft:banner_patterns", dynamic2.get("patterns"));
                Optional var5_7 = dynamic2.get("Base").asNumber().result();
                if (var5_7.isPresent()) {
                    count_4.a("minecraft:base_color", dynamic2.createString(ExtraDataFixUtils.a((int)((Number)var5_7.get()).intValue())));
                }
                yield dynamic2.remove("patterns").remove("Base");
            }
            case "minecraft:shulker_box", "minecraft:chest", "minecraft:trapped_chest", "minecraft:furnace", "minecraft:ender_chest", "minecraft:dispenser", "minecraft:dropper", "minecraft:brewing_stand", "minecraft:hopper", "minecraft:barrel", "minecraft:smoker", "minecraft:blast_furnace", "minecraft:campfire", "minecraft:chiseled_bookshelf", "minecraft:crafter" -> {
                List var8_10 = dynamic2.get("Items").asList(dynamic -> dynamic.emptyMap().set("slot", dynamic.createInt(dynamic.get("Slot").asByte((byte)0) & 0xFF)).set("item", dynamic.remove("Slot")));
                if (!var8_10.isEmpty()) {
                    count_4.a("minecraft:container", dynamic2.createList(var8_10.stream()));
                }
                yield dynamic2.remove("Items");
            }
            case "minecraft:beehive" -> {
                count_4.a("minecraft:bees", dynamic2.get("bees"));
                yield dynamic2.remove("bees");
            }
            default -> dynamic2;
        };
        return dynamic3;
    }

    private static void a(Count_4 count_4, Dynamic dynamic2, String string, String string2, boolean bl) {
        OptionalDynamic optionalDynamic = count_4.dG(string);
        List list = optionalDynamic.asList(Function.identity()).stream().flatMap(dynamic -> HideFlags_4.b(dynamic).stream()).toList();
        if (!list.isEmpty() || bl) {
            Dynamic dynamic3 = dynamic2.emptyMap();
            Dynamic dynamic4 = dynamic2.emptyMap();
            for (Pair pair : list) {
                dynamic4 = dynamic4.set((String)pair.getFirst(), dynamic2.createInt(((Integer)pair.getSecond()).intValue()));
            }
            dynamic3 = dynamic3.set("levels", dynamic4);
            if (bl) {
                dynamic3 = dynamic3.set("show_in_tooltip", dynamic2.createBoolean(false));
            }
            count_4.a(string2, dynamic3);
        }
        if (optionalDynamic.result().isPresent() && list.isEmpty()) {
            count_4.a("minecraft:enchantment_glint_override", dynamic2.createBoolean(true));
        }
    }

    private static Optional b(Dynamic dynamic) {
        return dynamic.get("id").asString().apply2stable((string, number) -> Pair.of((Object)string, (Object)MathHelper.a((int)number.intValue(), (int)0, (int)255)), dynamic.get("lvl").asNumber()).result();
    }

    private static void b(Count_4 count_4, Dynamic dynamic, int n) {
        HideFlags_4.b(count_4, dynamic, "CanDestroy", "minecraft:can_break", (n & 8) != 0);
        HideFlags_4.b(count_4, dynamic, "CanPlaceOn", "minecraft:can_place_on", (n & 0x10) != 0);
    }

    private static void b(Count_4 count_4, Dynamic dynamic, String string, String string2, boolean bl) {
        Optional optional = count_4.dG(string).result();
        if (!optional.isEmpty()) {
            Dynamic dynamic2 = dynamic.emptyMap().set("predicates", dynamic.createList(((Dynamic)optional.get()).asStream().map(object2 -> {
                Dynamic dynamic = (Dynamic)object2;
                return (Dynamic)DataFixUtils.orElse((Optional)dynamic.asString().map(object -> HideFlags_4.a(dynamic, (String)object)).result(), (Object)object2);
            })));
            if (bl) {
                dynamic2 = dynamic2.set("show_in_tooltip", dynamic.createBoolean(false));
            }
            count_4.a(string2, dynamic2);
        }
    }

    private static Dynamic a(Dynamic dynamic, String string) {
        int n = string.indexOf(91);
        int n2 = string.indexOf(123);
        int n3 = string.length();
        if (n != -1) {
            n3 = n;
        }
        if (n2 != -1) {
            n3 = Math.min(n3, n2);
        }
        String string2 = string.substring(0, n3);
        Dynamic dynamic2 = dynamic.emptyMap().set("blocks", dynamic.createString(string2.trim()));
        int n4 = string.indexOf(93);
        if (n != -1 && n4 != -1) {
            Dynamic dynamic3 = dynamic.emptyMap();
            Iterable<String> iterable = adI.split(string.substring(n + 1, n4));
            for (String string3 : iterable) {
                int n5 = string3.indexOf(61);
                if (n5 == -1) continue;
                String string4 = string3.substring(0, n5).trim();
                String string5 = string3.substring(n5 + 1).trim();
                dynamic3 = dynamic3.set(string4, dynamic.createString(string5));
            }
            dynamic2 = dynamic2.set("state", dynamic3);
        }
        int n6 = string.indexOf(125);
        if (n2 != -1 && n6 != -1) {
            dynamic2 = dynamic2.set("nbt", dynamic.createString(string.substring(n2, n6 + 1)));
        }
        return dynamic2;
    }

    private static void c(Count_4 count_4, Dynamic dynamic, int n) {
        boolean bl;
        List list = count_4.dG("AttributeModifiers").asList(HideFlags_4::c);
        boolean bl2 = bl = (n & 2) != 0;
        if (!list.isEmpty() || bl) {
            Dynamic dynamic2 = dynamic.emptyMap().set("modifiers", dynamic.createList(list.stream()));
            if (bl) {
                dynamic2 = dynamic2.set("show_in_tooltip", dynamic.createBoolean(false));
            }
            count_4.a("minecraft:attribute_modifiers", dynamic2);
        }
    }

    private static Dynamic c(Dynamic dynamic2) {
        Dynamic dynamic3 = dynamic2.emptyMap().set("name", dynamic2.createString("")).set("amount", dynamic2.createDouble(0.0)).set("operation", dynamic2.createString("add_value"));
        dynamic3 = Dynamic.copyField((Dynamic)dynamic2, (String)"AttributeName", (Dynamic)dynamic3, (String)"type");
        dynamic3 = Dynamic.copyField((Dynamic)dynamic2, (String)"Slot", (Dynamic)dynamic3, (String)"slot");
        dynamic3 = Dynamic.copyField((Dynamic)dynamic2, (String)"UUID", (Dynamic)dynamic3, (String)"uuid");
        dynamic3 = Dynamic.copyField((Dynamic)dynamic2, (String)"Name", (Dynamic)dynamic3, (String)"name");
        dynamic3 = Dynamic.copyField((Dynamic)dynamic2, (String)"Amount", (Dynamic)dynamic3, (String)"amount");
        dynamic3 = Dynamic.copyAndFixField((Dynamic)dynamic2, (String)"Operation", (Dynamic)dynamic3, (String)"operation", dynamic -> dynamic.createString(switch (dynamic.asInt(0)) {
            case 1 -> "add_multiplied_base";
            case 2 -> "add_multiplied_total";
            default -> "add_value";
        }));
        return dynamic3;
    }

    private static Pair d(Dynamic dynamic) {
        Dynamic dynamic2 = (Dynamic)DataFixUtils.orElseGet((Optional)dynamic.get("id").result(), () -> dynamic.createString(""));
        Dynamic dynamic3 = dynamic.emptyMap().set("type", dynamic.createString(HideFlags_4.aH(dynamic.get("type").asInt(0)))).set("x", dynamic.createDouble(dynamic.get("x").asDouble(0.0))).set("z", dynamic.createDouble(dynamic.get("z").asDouble(0.0))).set("rotation", dynamic.createFloat((float)dynamic.get("rot").asDouble(0.0)));
        return Pair.of((Object)dynamic2, (Object)dynamic3);
    }

    private static String aH(int n) {
        return switch (n) {
            case 1 -> "frame";
            case 2 -> "red_marker";
            case 3 -> "blue_marker";
            case 4 -> "target_x";
            case 5 -> "target_point";
            case 6 -> "player_off_map";
            case 7 -> "player_off_limits";
            case 8 -> "mansion";
            case 9 -> "monument";
            case 10 -> "banner_white";
            case 11 -> "banner_orange";
            case 12 -> "banner_magenta";
            case 13 -> "banner_light_blue";
            case 14 -> "banner_yellow";
            case 15 -> "banner_lime";
            case 16 -> "banner_pink";
            case 17 -> "banner_gray";
            case 18 -> "banner_light_gray";
            case 19 -> "banner_cyan";
            case 20 -> "banner_purple";
            case 21 -> "banner_blue";
            case 22 -> "banner_brown";
            case 23 -> "banner_green";
            case 24 -> "banner_red";
            case 25 -> "banner_black";
            case 26 -> "red_x";
            case 27 -> "village_desert";
            case 28 -> "village_plains";
            case 29 -> "village_savanna";
            case 30 -> "village_snowy";
            case 31 -> "village_taiga";
            case 32 -> "jungle_temple";
            case 33 -> "swamp_hut";
            default -> "player";
        };
    }

    private static void b(Count_4 count_4, Dynamic dynamic) {
        Dynamic dynamic2 = dynamic.emptyMap();
        Optional<String> optional = count_4.dG("Potion").asString().result().filter(string -> !string.equals("minecraft:empty"));
        if (optional.isPresent()) {
            dynamic2 = dynamic2.set("potion", dynamic.createString(optional.get()));
        }
        dynamic2 = count_4.a("CustomPotionColor", dynamic2, "custom_color");
        if (!(dynamic2 = count_4.a("custom_potion_effects", dynamic2, "custom_effects")).equals((Object)dynamic.emptyMap())) {
            count_4.a("minecraft:potion_contents", dynamic2);
        }
    }

    private static void c(Count_4 count_4, Dynamic dynamic) {
        Dynamic dynamic2 = HideFlags_4.e(count_4, dynamic);
        if (dynamic2 != null) {
            count_4.a("minecraft:writable_book_content", dynamic.emptyMap().set("pages", dynamic2));
        }
    }

    private static void d(Count_4 count_4, Dynamic dynamic) {
        Dynamic dynamic2 = HideFlags_4.e(count_4, dynamic);
        String string = count_4.dG("title").asString("");
        Optional optional = count_4.dG("filtered_title").asString().result();
        Dynamic dynamic3 = dynamic.emptyMap();
        dynamic3 = dynamic3.set("title", HideFlags_4.a(dynamic, string, optional));
        dynamic3 = count_4.a("author", dynamic3, "author");
        dynamic3 = count_4.a("resolved", dynamic3, "resolved");
        dynamic3 = count_4.a("generation", dynamic3, "generation");
        if (dynamic2 != null) {
            dynamic3 = dynamic3.set("pages", dynamic2);
        }
        count_4.a("minecraft:written_book_content", dynamic3);
    }

    @Nullable
    private static Dynamic e(Count_4 count_4, Dynamic dynamic2) {
        List list = count_4.dG("pages").asList(dynamic -> dynamic.asString(""));
        Map map = count_4.dG("filtered_pages").asMap(dynamic -> dynamic.asString("0"), dynamic -> dynamic.asString(""));
        if (list.isEmpty()) {
            return null;
        }
        ArrayList<Dynamic> arrayList = new ArrayList<Dynamic>(list.size());
        for (int i = 0; i < list.size(); ++i) {
            String string = (String)list.get(i);
            String string2 = (String)map.get(String.valueOf(i));
            arrayList.add(HideFlags_4.a(dynamic2, string, Optional.ofNullable(string2)));
        }
        return dynamic2.createList(arrayList.stream());
    }

    private static Dynamic a(Dynamic dynamic, String string, Optional optional) {
        Dynamic dynamic2 = dynamic.emptyMap().set("raw", dynamic.createString(string));
        if (optional.isPresent()) {
            dynamic2 = dynamic2.set("filtered", dynamic.createString((String)optional.get()));
        }
        return dynamic2;
    }

    private static void f(Count_4 count_4, Dynamic dynamic) {
        Dynamic dynamic2 = dynamic.emptyMap();
        for (String string : adG) {
            dynamic2 = count_4.a(string, dynamic2, string);
        }
        if (!dynamic2.equals((Object)dynamic.emptyMap())) {
            count_4.a("minecraft:bucket_entity_data", dynamic2);
        }
    }

    private static void g(Count_4 count_4, Dynamic dynamic) {
        Optional optional = count_4.dG("LodestonePos").result();
        Optional optional2 = count_4.dG("LodestoneDimension").result();
        if (!optional.isEmpty() || !optional2.isEmpty()) {
            boolean bl = count_4.dG("LodestoneTracked").asBoolean(true);
            Dynamic dynamic2 = dynamic.emptyMap();
            if (optional.isPresent() && optional2.isPresent()) {
                dynamic2 = dynamic2.set("target", dynamic.emptyMap().set("pos", (Dynamic)optional.get()).set("dimension", (Dynamic)optional2.get()));
            }
            if (!bl) {
                dynamic2 = dynamic2.set("tracked", dynamic.createBoolean(false));
            }
            count_4.a("minecraft:lodestone_tracker", dynamic2);
        }
    }

    private static void a(Count_4 count_4) {
        count_4.a("Explosion", true, dynamic -> {
            count_4.a("minecraft:firework_explosion", HideFlags_4.e(dynamic));
            return dynamic.remove("Type").remove("Colors").remove("FadeColors").remove("Trail").remove("Flicker");
        });
    }

    private static void b(Count_4 count_4) {
        count_4.a("Fireworks", true, dynamic -> {
            Stream<Dynamic> stream = dynamic.get("Explosions").asStream().map(HideFlags_4::e);
            int n = dynamic.get("Flight").asInt(0);
            count_4.a("minecraft:fireworks", dynamic.emptyMap().set("explosions", dynamic.createList(stream)).set("flight_duration", dynamic.createByte((byte)n)));
            return dynamic.remove("Explosions").remove("Flight");
        });
    }

    private static Dynamic e(Dynamic dynamic) {
        dynamic = dynamic.set("shape", dynamic.createString(switch (dynamic.get("Type").asInt(0)) {
            case 1 -> "large_ball";
            case 2 -> "star";
            case 3 -> "creeper";
            case 4 -> "burst";
            default -> "small_ball";
        })).remove("Type");
        dynamic = dynamic.renameField("Colors", "colors");
        dynamic = dynamic.renameField("FadeColors", "fade_colors");
        dynamic = dynamic.renameField("Trail", "has_trail");
        dynamic = dynamic.renameField("Flicker", "has_twinkle");
        return dynamic;
    }

    public static Dynamic f(Dynamic dynamic) {
        Optional optional = dynamic.asString().result();
        if (optional.isPresent()) {
            return HideFlags_4.dE((String)optional.get()) ? dynamic.emptyMap().set("name", dynamic.createString((String)optional.get())) : dynamic.emptyMap();
        }
        String string = dynamic.get("Name").asString("");
        Optional optional2 = dynamic.get("Id").result();
        Dynamic dynamic2 = HideFlags_4.a(dynamic.get("Properties"));
        Dynamic dynamic3 = dynamic.emptyMap();
        if (HideFlags_4.dE(string)) {
            dynamic3 = dynamic3.set("name", dynamic.createString(string));
        }
        if (optional2.isPresent()) {
            dynamic3 = dynamic3.set("id", (Dynamic)optional2.get());
        }
        if (dynamic2 != null) {
            dynamic3 = dynamic3.set("properties", dynamic2);
        }
        return dynamic3;
    }

    private static boolean dE(String string) {
        return string.length() > 16 ? false : string.chars().filter(n -> n <= 32 || n >= 127).findAny().isEmpty();
    }

    @Nullable
    private static Dynamic a(OptionalDynamic optionalDynamic) {
        Map map = optionalDynamic.asMap(dynamic -> dynamic.asString(""), dynamic2 -> dynamic2.asList(dynamic -> {
            String string = dynamic.get("Value").asString("");
            Optional optional = dynamic.get("Signature").asString().result();
            return Pair.of((Object)string, (Object)optional);
        }));
        return map.isEmpty() ? null : optionalDynamic.createList(map.entrySet().stream().flatMap(entry -> ((List)entry.getValue()).stream().map(object -> {
            Pair pair = (Pair)object;
            Dynamic dynamic = optionalDynamic.emptyMap().set("name", optionalDynamic.createString((String)entry.getKey())).set("value", optionalDynamic.createString((String)pair.getFirst()));
            Optional optional = (Optional)pair.getSecond();
            return optional.isPresent() ? dynamic.set("signature", optionalDynamic.createString((String)optional.get())) : dynamic;
        })));
    }

    protected TypeRewriteRule makeRule() {
        return this.writeFixAndRead("ItemStack componentization", this.getInputSchema().getType(DataConverterTypes.x), this.getOutputSchema().getType(DataConverterTypes.x), dynamic -> {
            Optional<Dynamic> optional = Count_4.r(dynamic).map(count_4 -> {
                HideFlags_4.a(count_4, count_4.adn);
                return count_4.tY();
            });
            return (Dynamic)DataFixUtils.orElse(optional, (Object)dynamic);
        });
    }
}
