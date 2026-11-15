package itemsadder.m;

import java.util.Locale;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.SoundCategory;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers detected
 */
public class bbi {
    static final /* synthetic */ boolean azV;

    public static boolean d(String string, Class clazz) {
        try {
            Enum.valueOf(clazz, string);
        }
        catch (Exception exception) {
            return false;
        }
        return true;
    }

    @Nullable
    public static Enum e(String string, Class clazz) {
        return bbi.b(string, clazz, null);
    }

    public static Enum b(String string, Class clazz, Enum enum_) {
        if (StringUtils.isBlank((String)string)) {
            return enum_;
        }
        try {
            return Enum.valueOf(clazz, string);
        }
        catch (Exception exception) {
            return enum_;
        }
    }

    public static Enum a(String string, Class clazz, Enum enum_, Runnable runnable) {
        if (StringUtils.isBlank((String)string)) {
            return enum_;
        }
        try {
            return Enum.valueOf(clazz, string);
        }
        catch (Exception exception) {
            runnable.run();
            return enum_;
        }
    }

    public static SoundCategory a(String string, SoundCategory soundCategory) {
        if (string == null) {
            return soundCategory;
        }
        return (SoundCategory)bbi.b(string.toUpperCase(), SoundCategory.class, (Enum)SoundCategory.MASTER);
    }

    public static SoundCategory ib(String string) {
        return bbi.a(string, SoundCategory.MASTER);
    }

    @Nullable
    public static ItemFlag ic(String string) {
        if (string == null) {
            return null;
        }
        if (string.equals("HIDE_POTION_EFFECTS")) {
            return ItemFlag.HIDE_ADDITIONAL_TOOLTIP;
        }
        return (ItemFlag)bbi.e(string, ItemFlag.class);
    }

    @Nullable
    public static Particle id(@Nullable String string) {
        Particle particle;
        if (string == null) {
            return null;
        }
        switch (string) {
            case "EXPLOSION_NORMAL": {
                Particle particle2 = Particle.POOF;
                break;
            }
            case "EXPLOSION_LARGE": {
                Particle particle2 = Particle.EXPLOSION;
                break;
            }
            case "EXPLOSION_HUGE": {
                Particle particle2 = Particle.EXPLOSION_EMITTER;
                break;
            }
            case "FIREWORKS_SPARK": {
                Particle particle2 = Particle.FIREWORK;
                break;
            }
            case "WATER_BUBBLE": {
                Particle particle2 = Particle.BUBBLE;
                break;
            }
            case "WATER_SPLASH": {
                Particle particle2 = Particle.SPLASH;
                break;
            }
            case "WATER_WAKE": {
                Particle particle2 = Particle.FISHING;
                break;
            }
            case "SUSPENDED": {
                Particle particle2 = Particle.UNDERWATER;
                break;
            }
            case "SUSPENDED_DEPTH": {
                Particle particle2 = Particle.UNDERWATER;
                break;
            }
            case "CRIT_MAGIC": {
                Particle particle2 = Particle.ENCHANTED_HIT;
                break;
            }
            case "SMOKE_NORMAL": {
                Particle particle2 = Particle.SMOKE;
                break;
            }
            case "SMOKE_LARGE": {
                Particle particle2 = Particle.LARGE_SMOKE;
                break;
            }
            case "SPELL": {
                Particle particle2 = Particle.EFFECT;
                break;
            }
            case "SPELL_INSTANT": {
                Particle particle2 = Particle.INSTANT_EFFECT;
                break;
            }
            case "SPELL_MOB": {
                Particle particle2 = Particle.ENTITY_EFFECT;
                break;
            }
            case "SPELL_WITCH": {
                Particle particle2 = Particle.WITCH;
                break;
            }
            case "DRIP_WATER": {
                Particle particle2 = Particle.DRIPPING_WATER;
                break;
            }
            case "DRIP_LAVA": {
                Particle particle2 = Particle.DRIPPING_LAVA;
                break;
            }
            case "VILLAGER_ANGRY": {
                Particle particle2 = Particle.ANGRY_VILLAGER;
                break;
            }
            case "VILLAGER_HAPPY": {
                Particle particle2 = Particle.HAPPY_VILLAGER;
                break;
            }
            case "TOWN_AURA": {
                Particle particle2 = Particle.MYCELIUM;
                break;
            }
            case "ENCHANTMENT_TABLE": {
                Particle particle2 = Particle.ENCHANT;
                break;
            }
            case "REDSTONE": {
                Particle particle2 = Particle.DUST;
                break;
            }
            case "SNOWBALL": {
                Particle particle2 = Particle.ITEM_SNOWBALL;
                break;
            }
            case "SNOW_SHOVEL": {
                Particle particle2 = Particle.ITEM_SNOWBALL;
                break;
            }
            case "SLIME": {
                Particle particle2 = Particle.ITEM_SLIME;
                break;
            }
            case "ITEM_CRACK": {
                Particle particle2 = Particle.ITEM;
                break;
            }
            case "BLOCK_CRACK": {
                Particle particle2 = Particle.BLOCK;
                break;
            }
            case "BLOCK_DUST": {
                Particle particle2 = Particle.BLOCK;
                break;
            }
            case "WATER_DROP": {
                Particle particle2 = Particle.RAIN;
                break;
            }
            case "MOB_APPEARANCE": {
                Particle particle2 = Particle.ELDER_GUARDIAN;
                break;
            }
            case "TOTEM": {
                Particle particle2 = Particle.TOTEM_OF_UNDYING;
                break;
            }
            case "GUST_EMITTER": {
                Particle particle2 = Particle.GUST_EMITTER_LARGE;
                break;
            }
            default: {
                Particle particle2 = particle = (Particle)bbi.e(string, Particle.class);
            }
        }
        if (particle == null) {
            string = string.toLowerCase();
            String string2 = NamespacedKey.fromString((String)string);
            for (Particle particle3 : Particle.values()) {
                try {
                    if (particle3.getKey().equals((Object)string2)) {
                        return particle3;
                    }
                }
                catch (UnsupportedOperationException unsupportedOperationException) {
                    // empty catch block
                }
            }
        }
        return particle;
    }

    @Nullable
    public static Object a(Particle particle) {
        Class clazz = particle.getDataType();
        if (clazz == Void.class) {
            return null;
        }
        return switch (particle.name()) {
            case "DRAGON_BREATH" -> {
                if (clazz == Float.class) {
                    yield Float.valueOf(1.0f);
                }
                yield null;
            }
            case "FLASH" -> {
                if (clazz == Color.class) {
                    yield Color.WHITE;
                }
                yield null;
            }
            case "EFFECT", "INSTANT_EFFECT" -> bbi.q(clazz);
            default -> null;
        };
    }

    @Nullable
    private static Object q(Class clazz) {
        if (!clazz.getName().equals("org.bukkit.Particle$Spell")) {
            return null;
        }
        try {
            return clazz.getConstructor(Color.class, Float.TYPE).newInstance(Color.WHITE, Float.valueOf(1.0f));
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            return null;
        }
    }

    @Nullable
    public static Effect ie(@Nullable String string) {
        Effect effect = (Effect)bbi.e(string, Effect.class);
        if (effect != null || string == null) {
            return effect;
        }
        return (Effect)bbi.e(bbi.if(string), Effect.class);
    }

    private static String if(String string) {
        return switch (string) {
            case "CLICK2" -> "DISPENSER_DISPENSE";
            case "CLICK1" -> "DISPENSER_FAIL";
            case "BOW_FIRE" -> "DISPENSER_PROJECTILE_LAUNCH";
            case "SOUND_STOP_JUKEBOX_SONG" -> "RECORD_STOP";
            case "ENDERDRAGON_SHOOT" -> "ENDER_DRAGON_SHOOT";
            case "ZOMBIE_CONVERTED_VILLAGER" -> "ZOMBIE_CONVERTED_TO_VILLAGER";
            case "SOUND_WITH_CHARGE_SHOT" -> "WIND_CHARGE_SHOOT";
            case "DRAGON_BREATH" -> "ENDER_DRAGON_BREATH";
            case "VILLAGER_PLANT_GROW" -> "BEE_GROWTH";
            case "SMOKE" -> "SMOKE_SHOOT";
            case "SHOOT_WHITE_SMOKE" -> "WHITE_SMOKE_SHOOT";
            case "ENDERDRAGON_GROWL" -> "ENDER_DRAGON_GROWL";
            case "PARTICLES_SCULK_CHARGE" -> "SCULK_CHARGE";
            case "PARTICLES_SCULK_SHRIEK" -> "SCULK_SHRIEK";
            case "PARTICLES_AND_SOUND_BRUSH_BLOCK_COMPLETE" -> "BRUSH_BLOCK_COMPLETE";
            case "PARTICLES_EGG_CRACK" -> "EGG_CRACK";
            default -> string;
        };
    }

    public static Material ig(String string) {
        if ((string = string.toUpperCase(Locale.ROOT)).equals("GRASS")) {
            return Material.SHORT_GRASS;
        }
        return Material.matchMaterial((String)string);
    }

    @Nullable
    public static EntityType ih(String string) {
        EntityType entityType = (EntityType)bbi.e(string = string.toUpperCase(Locale.ROOT), EntityType.class);
        if (entityType != null) {
            return entityType;
        }
        if ((string = string.toLowerCase(Locale.ROOT)).startsWith("minecraft:")) {
            string = string.substring("minecraft:".length());
        }
        entityType = EntityType.fromName((String)string);
        return entityType;
    }

    public static PotionEffectType ii(String string) {
        PotionEffectType potionEffectType = PotionEffectType.getByName((String)string);
        if (potionEffectType == null) {
            return switch (string) {
                case "SLOW" -> PotionEffectType.SLOWNESS;
                case "FAST_DIGGING" -> PotionEffectType.HASTE;
                case "SLOW_DIGGING" -> PotionEffectType.MINING_FATIGUE;
                case "INCREASE_DAMAGE" -> PotionEffectType.STRENGTH;
                case "HEAL" -> PotionEffectType.INSTANT_HEALTH;
                case "HARM" -> PotionEffectType.INSTANT_DAMAGE;
                case "JUMP" -> PotionEffectType.JUMP_BOOST;
                case "CONFUSION" -> PotionEffectType.NAUSEA;
                case "DAMAGE_RESISTANCE" -> PotionEffectType.RESISTANCE;
                default -> null;
            };
        }
        return potionEffectType;
    }

    public static Enchantment ij(String string) {
        Enchantment enchantment = Enchantment.getByName((String)string);
        if (enchantment == null && string.equals("ARRROW_DAMAGE")) {
            return Enchantment.FLAME;
        }
        if (enchantment == null && string.toLowerCase().equals(string)) {
            enchantment = Enchantment.getByKey((NamespacedKey)NamespacedKey.minecraft((String)string));
        }
        return enchantment;
    }

    @Nullable
    public static EquipmentSlot ik(String string) {
        EquipmentSlot equipmentSlot = (EquipmentSlot)bbi.b(string, EquipmentSlot.class, null);
        if (equipmentSlot != null) {
            return equipmentSlot;
        }
        if (string.equalsIgnoreCase("main_hand")) {
            return EquipmentSlot.HAND;
        }
        if (string.equalsIgnoreCase("mainhand")) {
            return EquipmentSlot.HAND;
        }
        if (string.equalsIgnoreCase("offhand")) {
            return EquipmentSlot.OFF_HAND;
        }
        if (string.equalsIgnoreCase("helmet")) {
            return EquipmentSlot.HEAD;
        }
        if (string.equalsIgnoreCase("chestplate")) {
            return EquipmentSlot.CHEST;
        }
        if (string.equalsIgnoreCase("leggings")) {
            return EquipmentSlot.LEGS;
        }
        if (string.equalsIgnoreCase("boots")) {
            return EquipmentSlot.FEET;
        }
        return null;
    }

    @Nullable
    public static BarStyle il(String string) {
        return (BarStyle)bbi.b(string.toUpperCase(), BarStyle.class, null);
    }

    public static BarColor im(String string) {
        return (BarColor)bbi.b(string.toUpperCase(), BarColor.class, null);
    }

    static {
        boolean bl = azV = !bbi.class.desiredAssertionStatus();
        if (!azV && !bbi.if("SMOKE").equals("SMOKE_SHOOT")) {
            throw new AssertionError();
        }
        if (!azV && !bbi.if("DRAGON_BREATH").equals("ENDER_DRAGON_BREATH")) {
            throw new AssertionError();
        }
    }
}
