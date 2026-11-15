package itemsadder.m;

import itemsadder.m.ComponentBoolData;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque020;
import itemsadder.m.PermissibleBridge;
import itemsadder.m.PermissibleBridge_4;
import itemsadder.m.PluginBridge_6;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.event.HoverEventSource;
import net.kyori.adventure.text.format.TextColor;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.StringUtils;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PermissibleBridge_2 {
    public static final Pattern St = Pattern.compile(":([a-z_\\-0-9]+):", 2);

    @NotNull
    public static Component h(@NotNull Component component) {
        return PermissibleBridge_2.a(null, component, false, null, Opaque020.Dk());
    }

    @NotNull
    public static Component a(@Nullable Permissible permissible, @NotNull Component component) {
        return PermissibleBridge_2.a(permissible, component, false, null, Opaque020.Dk());
    }

    @NotNull
    public static Component a(@NotNull Component component, Opaque020 opaque020) {
        return PermissibleBridge_2.a(null, component, false, null, opaque020);
    }

    public static boolean dk(String string) {
        return StringUtils.countMatches((String)string, (String)":") > 1;
    }

    @NotNull
    public static Component a(@NotNull Component component, boolean bl, @Nullable String string) {
        return PermissibleBridge_2.a(null, component, bl, string, Opaque020.Dk());
    }

    @NotNull
    public static Component a(@Nullable Permissible permissible, @NotNull Component component, boolean bl, @Nullable String string, Opaque020 opaque020) {
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        if (itemStackRegistry == null || itemStackRegistry.al == null) {
            return component;
        }
        Opaque020 opaque0202 = Opaque020.G(string);
        return component.replaceText((TextReplacementConfig)TextReplacementConfig.builder().match(St).replacement(builder2 -> {
            opaque020.aAW = true;
            PermissibleBridge permissibleBridge = ItemStackRegistry.g().al.aR(builder2.content());
            if (permissibleBridge != null && permissible != null && !permissibleBridge.a(permissible)) {
                return builder2;
            }
            if (permissibleBridge == null) {
                String string = ItemStackRegistry.g().al.aT(builder2.content());
                if (string != null) {
                    return builder2.content(string);
                }
                return builder2;
            }
            if (bl && opaque0202.Dl() && permissibleBridge.uE) {
                if (permissibleBridge.ii() != null) {
                    opaque0202.H(permissibleBridge.ii());
                }
                builder2.hoverEvent((HoverEventSource)HoverEvent.showText((Component)PluginBridge_6.gK(((String)opaque0202.aAW).replace("{id}", permissibleBridge.bM).replace("{placeholder}", permissibleBridge.ij())).replaceText((TextReplacementConfig)TextReplacementConfig.builder().match("\\{font_image\\}").replacement(builder -> {
                    TextComponent.Builder builder2 = builder.content(permissibleBridge.Q(false));
                    builder2 = permissibleBridge.a(builder2);
                    return builder2;
                }).build())));
            }
            TextComponent.Builder builder3 = MaterialBarColorHolder.fr && PermissibleBridge_4.j(component) ? builder2.content(permissibleBridge.Q(false)) : (TextComponent.Builder)builder2.content(permissibleBridge.Q(false)).color(TextColor.color((int)Color.WHITE.getRGB()));
            builder3 = permissibleBridge.a(builder3);
            return builder3;
        }).build());
    }

    public static String replaceFontImages(Permissible permissible, String string) {
        return PermissibleBridge_2.c(permissible, string, true);
    }

    public static String c(Permissible permissible, String string, boolean bl) {
        Matcher matcher = St.matcher(string);
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        if (itemStackRegistry == null || itemStackRegistry.al == null) {
            return string;
        }
        while (matcher.find()) {
            String string2 = matcher.group();
            PermissibleBridge permissibleBridge = ItemStackRegistry.g().al.aR(string2);
            if (permissibleBridge == null) {
                String string3 = ItemStackRegistry.g().al.aT(string2);
                if (string3 == null) continue;
                string = StringUtils.replace((String)string, (String)string2, (String)string3);
                continue;
            }
            if (!permissibleBridge.a(permissible)) continue;
            if (bl) {
                string = string.replace(string2, String.valueOf(ChatColor.WHITE) + permissibleBridge.Q(false) + String.valueOf(ChatColor.RESET));
                continue;
            }
            string = StringUtils.replace((String)string, (String)string2, (String)permissibleBridge.Q(false));
        }
        return string;
    }

    public static String replaceFontImages(String string) {
        Matcher matcher = St.matcher(string);
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        if (itemStackRegistry == null || itemStackRegistry.al == null) {
            return string;
        }
        while (matcher.find()) {
            String string2 = matcher.group();
            PermissibleBridge permissibleBridge = ItemStackRegistry.g().al.aR(string2);
            if (permissibleBridge == null) {
                String string3 = ItemStackRegistry.g().al.aT(string2);
                if (string3 == null) continue;
                string = StringUtils.replace((String)string, (String)string2, (String)string3);
                continue;
            }
            string = StringUtils.replace((String)string, (String)string2, (String)(String.valueOf(ChatColor.WHITE) + permissibleBridge.Q(false) + String.valueOf(ChatColor.RESET)));
        }
        return string;
    }

    public static void z(ItemStackBuilder_4 itemStackBuilder_4) {
        ItemStackBuilder_4.a(itemStackBuilder_4, (Component component) -> {
            Opaque020 opaque020 = Opaque020.G(false);
            component = PermissibleBridge_2.a(component, opaque020);
            return new ComponentBoolData(component, (Boolean)opaque020.aAW);
        });
    }
}
