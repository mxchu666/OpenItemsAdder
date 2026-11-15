package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.bch;
import itemsadder.m.d;
import itemsadder.m.fw;
import itemsadder.m.xk;
import itemsadder.m.xm;
import java.awt.Color;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.event.HoverEventSource;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.permissions.Permissible;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.Nullable;

public class xl {
    public static @NonNull Component h(Component component) {
        return xl.a(component, false, null);
    }

    public static @NonNull Component a(@Nullable Permissible permissible, Component component) {
        return xl.a(permissible, component, false, null);
    }

    public static @NonNull Component a(Component component, boolean bl, String string) {
        return xl.a(null, component, bl, string);
    }

    public static @NonNull Component a(@Nullable Permissible permissible, Component component, boolean bl, String string) {
        bch bch2 = bch.G(string);
        return component.replaceText((TextReplacementConfig)TextReplacementConfig.builder().match(xk.St).replacement(builder2 -> {
            fw fw2 = d.g().al.aR(builder2.content());
            if (fw2 != null && permissible != null && !fw2.a(permissible)) {
                return builder2;
            }
            if (fw2 == null) {
                String string2 = d.g().al.aT(builder2.content());
                if (string2 != null) {
                    return builder2.content(string2);
                }
                return builder2;
            }
            if (bl && string != null && fw2.uE) {
                if (fw2.ii() != null) {
                    bch2.H(fw2.ii());
                }
                builder2.hoverEvent((HoverEventSource)HoverEvent.showText((Component)Component.text((String)((String)bch2.aAW).replace("{id}", fw2.bM).replace("{placeholder}", fw2.ij())).replaceText((TextReplacementConfig)TextReplacementConfig.builder().match("\\{font_image\\}").replacement(builder -> {
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
}
