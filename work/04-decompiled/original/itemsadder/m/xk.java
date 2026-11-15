package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.bbe;
import itemsadder.m.bch;
import itemsadder.m.d;
import itemsadder.m.fw;
import itemsadder.m.qm;
import itemsadder.m.qq;
import itemsadder.m.xm;
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

public class xk {
    public static final Pattern St = Pattern.compile(":([a-z_\\-0-9]+):", 2);

    @NotNull
    public static Component h(@NotNull Component component) {
        return xk.a(null, component, false, null, bch.Dk());
    }

    @NotNull
    public static Component a(@Nullable Permissible permissible, @NotNull Component component) {
        return xk.a(permissible, component, false, null, bch.Dk());
    }

    @NotNull
    public static Component a(@NotNull Component component, bch bch2) {
        return xk.a(null, component, false, null, bch2);
    }

    public static boolean dk(String string) {
        return StringUtils.countMatches((String)string, (String)":") > 1;
    }

    @NotNull
    public static Component a(@NotNull Component component, boolean bl, @Nullable String string) {
        return xk.a(null, component, bl, string, bch.Dk());
    }

    @NotNull
    public static Component a(@Nullable Permissible permissible, @NotNull Component component, boolean bl, @Nullable String string, bch bch2) {
        d d2 = d.g();
        if (d2 == null || d2.al == null) {
            return component;
        }
        bch bch3 = bch.G(string);
        return component.replaceText((TextReplacementConfig)TextReplacementConfig.builder().match(St).replacement(builder2 -> {
            bch2.aAW = true;
            fw fw2 = d.g().al.aR(builder2.content());
            if (fw2 != null && permissible != null && !fw2.a(permissible)) {
                return builder2;
            }
            if (fw2 == null) {
                String string = d.g().al.aT(builder2.content());
                if (string != null) {
                    return builder2.content(string);
                }
                return builder2;
            }
            if (bl && bch3.Dl() && fw2.uE) {
                if (fw2.ii() != null) {
                    bch3.H(fw2.ii());
                }
                builder2.hoverEvent((HoverEventSource)HoverEvent.showText((Component)bbe.gK(((String)bch3.aAW).replace("{id}", fw2.bM).replace("{placeholder}", fw2.ij())).replaceText((TextReplacementConfig)TextReplacementConfig.builder().match("\\{font_image\\}").replacement(builder -> {
                    TextComponent.Builder builder2 = builder.content(fw2.Q(false));
                    builder2 = fw2.a(builder2);
                    return builder2;
                }).build())));
            }
            TextComponent.Builder builder3 = ae.fr && xm.j(component) ? builder2.content(fw2.Q(false)) : (TextComponent.Builder)builder2.content(fw2.Q(false)).color(TextColor.color((int)Color.WHITE.getRGB()));
            builder3 = fw2.a(builder3);
            return builder3;
        }).build());
    }

    public static String replaceFontImages(Permissible permissible, String string) {
        return xk.c(permissible, string, true);
    }

    public static String c(Permissible permissible, String string, boolean bl) {
        Matcher matcher = St.matcher(string);
        d d2 = d.g();
        if (d2 == null || d2.al == null) {
            return string;
        }
        while (matcher.find()) {
            String string2 = matcher.group();
            fw fw2 = d.g().al.aR(string2);
            if (fw2 == null) {
                String string3 = d.g().al.aT(string2);
                if (string3 == null) continue;
                string = StringUtils.replace((String)string, (String)string2, (String)string3);
                continue;
            }
            if (!fw2.a(permissible)) continue;
            if (bl) {
                string = string.replace(string2, String.valueOf(ChatColor.WHITE) + fw2.Q(false) + String.valueOf(ChatColor.RESET));
                continue;
            }
            string = StringUtils.replace((String)string, (String)string2, (String)fw2.Q(false));
        }
        return string;
    }

    public static String replaceFontImages(String string) {
        Matcher matcher = St.matcher(string);
        d d2 = d.g();
        if (d2 == null || d2.al == null) {
            return string;
        }
        while (matcher.find()) {
            String string2 = matcher.group();
            fw fw2 = d.g().al.aR(string2);
            if (fw2 == null) {
                String string3 = d.g().al.aT(string2);
                if (string3 == null) continue;
                string = StringUtils.replace((String)string, (String)string2, (String)string3);
                continue;
            }
            string = StringUtils.replace((String)string, (String)string2, (String)(String.valueOf(ChatColor.WHITE) + fw2.Q(false) + String.valueOf(ChatColor.RESET)));
        }
        return string;
    }

    public static void z(qm qm2) {
        qm.a(qm2, (Component component) -> {
            bch bch2 = bch.G(false);
            component = xk.a(component, bch2);
            return new qq(component, (Boolean)bch2.aAW);
        });
    }
}
