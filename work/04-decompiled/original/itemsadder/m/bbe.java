package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.google.gson.JsonElement;
import itemsadder.m.adb;
import itemsadder.m.bau;
import itemsadder.m.bbx;
import itemsadder.m.zw;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.platform.bukkit.BukkitComponentSerializer;
import net.kyori.adventure.platform.bukkit.MinecraftComponentSerializer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.TranslatableComponent;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.ParsingException;
import net.kyori.adventure.text.serializer.bungeecord.BungeeComponentSerializer;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.kyori.adventure.text.serializer.gson.legacyimpl.NBTLegacyHoverEventSerializer;
import net.kyori.adventure.text.serializer.json.JSONOptions;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.option.OptionState;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class bbe {
    public static GsonComponentSerializer azB;
    public static final MiniMessage azC;
    public static TextColor azD;
    private static final Style azE;
    public static Style azF;
    public static final LegacyComponentSerializer azG;
    public static final String azH = "{\"text\":\"\"}";
    public static final DecimalFormat azI;
    public static final DecimalFormat azJ;
    private static BukkitAudiences azK;

    public static String gC(@NotNull String string) {
        return (String)azB.serialize(bbe.gF(string));
    }

    public static String gD(String string) {
        return LegacyComponentSerializer.legacy((char)'\u00a7').serialize(bbe.gE(string));
    }

    public static String p(@NotNull Component component) {
        return (String)azB.serialize(component);
    }

    @NotNull
    public static JsonElement q(@NotNull Component component) {
        return azB.serializeToTree(component);
    }

    @NotNull
    public static Component gE(String string) {
        if (!string.startsWith("{")) {
            return Component.text((String)string).style(azF);
        }
        return azB.deserialize((Object)string);
    }

    public static Object r(Component component) {
        if (component == null) {
            return null;
        }
        if (zw.sZ()) {
            return adb.tp().f(component);
        }
        return MinecraftComponentSerializer.get().serialize(component);
    }

    @Nullable
    public static Component F(Object object) {
        if (object == null) {
            return null;
        }
        if (zw.sZ()) {
            return adb.tp().e(object);
        }
        return MinecraftComponentSerializer.get().deserialize(object);
    }

    public static String g(Object object) {
        return adb.tp().g(object);
    }

    public static BaseComponent[] s(Component component) {
        if (Version.isAtLeast((Version)Version.v26_2)) {
            return bau.m(component);
        }
        return BungeeComponentSerializer.legacy().serialize(component);
    }

    public static Component gF(String string) {
        if (Version.isAtLeast((Version)Version.v26_2)) {
            return bbx.iv(string);
        }
        TextComponent textComponent = BukkitComponentSerializer.legacy().deserialize(string);
        return textComponent.decorationIfAbsent(TextDecoration.ITALIC, TextDecoration.State.FALSE);
    }

    public static Component w(String string, boolean bl) {
        if (Version.isAtLeast((Version)Version.v26_2)) {
            if (bl) {
                return bbx.iv(string).style(azE);
            }
            return bbx.iv(string);
        }
        if (!bl) {
            return BukkitComponentSerializer.legacy().deserialize(string);
        }
        return BukkitComponentSerializer.legacy().deserialize(string).style(azE);
    }

    public static boolean gG(String string) {
        return string.trim().startsWith("{");
    }

    public static String gH(String string) {
        return string.replaceAll("&(?=\\S)", "\u00a7");
    }

    public static TranslatableComponent gI(String string) {
        TranslatableComponent translatableComponent = Component.translatable((String)string);
        return (TranslatableComponent)translatableComponent.decorationIfAbsent(TextDecoration.ITALIC, TextDecoration.State.FALSE);
    }

    public static // Could not load outer class - annotation placement on inner may be incorrect
    @NotNull Style.Builder a(Style style, Style.Builder builder, TextDecoration textDecoration, TextDecoration.State state) {
        if (style.decoration(textDecoration) == state) {
            return builder.decoration(textDecoration, TextDecoration.State.NOT_SET);
        }
        return builder.decoration(textDecoration, style.decoration(textDecoration));
    }

    public static Component t(Component component) {
        component = component.compact();
        Style style = component.style();
        Style.Builder builder = style.toBuilder();
        builder = bbe.a(style, builder, TextDecoration.BOLD, TextDecoration.State.FALSE);
        builder = bbe.a(style, builder, TextDecoration.UNDERLINED, TextDecoration.State.FALSE);
        builder = bbe.a(style, builder, TextDecoration.STRIKETHROUGH, TextDecoration.State.FALSE);
        builder = bbe.a(style, builder, TextDecoration.OBFUSCATED, TextDecoration.State.FALSE);
        return component.style(builder);
    }

    public static String u(Component component) {
        return LegacyComponentSerializer.legacy((char)'\u00a7').serialize(component);
    }

    public static boolean v(Component component) {
        return component.color() != null;
    }

    public static String j(String ... stringArray) {
        TextComponent textComponent = Component.text((String)"");
        for (String string : stringArray) {
            textComponent = textComponent.append((Component)Component.text((String)string));
        }
        return bbe.p((Component)textComponent);
    }

    public static String gJ(String string) {
        return bbe.u(bbe.gK(string));
    }

    public static Component gK(String string) {
        Component component;
        if (string.contains("%#")) {
            string = string.replaceAll("%#([a-fA-F0-9]{6})%", "&#$1");
        }
        if (string.contains("&#") || string.contains("\u00a7#")) {
            string = bbe.gH(string);
        }
        try {
            string = bbe.gH(string);
            component = azC.deserialize((Object)string);
        }
        catch (ParsingException parsingException) {
            component = bbe.gF(string);
        }
        return component.colorIfAbsent(azD).decorationIfAbsent(TextDecoration.ITALIC, TextDecoration.State.FALSE);
    }

    public static String a(double d, boolean bl) {
        if (bl) {
            return azJ.format(d);
        }
        return azI.format(d);
    }

    public static void b(Plugin plugin) {
        azK = BukkitAudiences.create((Plugin)plugin);
    }

    public static BukkitAudiences CC() {
        if (azK == null) {
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
        }
        return azK;
    }

    public static void O() {
        if (azK != null) {
            azK.close();
            azK = null;
        }
    }

    static {
        azC = MiniMessage.miniMessage();
        azD = TextColor.color((int)255, (int)255, (int)255);
        azE = Style.style(builder -> builder.decoration(TextDecoration.ITALIC, false));
        azF = Style.style(builder -> {
            builder.color(azD);
            builder.decoration(TextDecoration.ITALIC, false);
        });
        azG = LegacyComponentSerializer.builder().hexColors().useUnusualXRepeatedCharacterHexFormat().build();
        azI = new DecimalFormat("#.##");
        azI.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ROOT));
        azJ = new DecimalFormat("0.0#");
        azJ.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ROOT));
        azB = Version.isAtLeast((Version)Version.v26_2) ? GsonComponentSerializer.builder().options(OptionState.optionState().value(JSONOptions.EMIT_RGB, (Object)Boolean.TRUE).value(JSONOptions.EMIT_COMPACT_TEXT_COMPONENT, (Object)Boolean.TRUE).value(JSONOptions.EMIT_HOVER_SHOW_ENTITY_ID_AS_INT_ARRAY, (Object)Boolean.TRUE).value(JSONOptions.VALIDATE_STRICT_EVENTS, (Object)Boolean.TRUE).build()).build() : GsonComponentSerializer.builder().legacyHoverEventSerializer(NBTLegacyHoverEventSerializer.get()).options(OptionState.optionState().value(JSONOptions.EMIT_RGB, (Object)Boolean.TRUE).value(JSONOptions.EMIT_HOVER_EVENT_TYPE, (Object)JSONOptions.HoverEventValueMode.MODERN_ONLY).value(JSONOptions.EMIT_COMPACT_TEXT_COMPONENT, (Object)Boolean.TRUE).value(JSONOptions.EMIT_HOVER_SHOW_ENTITY_ID_AS_INT_ARRAY, (Object)Boolean.TRUE).value(JSONOptions.VALIDATE_STRICT_EVENTS, (Object)Boolean.TRUE).build()).build();
    }
}
