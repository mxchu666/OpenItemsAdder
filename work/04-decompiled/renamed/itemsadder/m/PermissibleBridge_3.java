package itemsadder.m;

import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque020;
import itemsadder.m.PermissibleBridge;
import itemsadder.m.PermissibleBridge_2;
import itemsadder.m.PermissibleBridge_4;
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

public class PermissibleBridge_3 {
    public static @NonNull Component h(Component component) {
        return PermissibleBridge_3.a(component, false, null);
    }

    public static @NonNull Component a(@Nullable Permissible permissible, Component component) {
        return PermissibleBridge_3.a(permissible, component, false, null);
    }

    public static @NonNull Component a(Component component, boolean bl, String string) {
        return PermissibleBridge_3.a(null, component, bl, string);
    }

    public static @NonNull Component a(@Nullable Permissible permissible, Component component, boolean bl, String string) {
        Opaque020 opaque020 = Opaque020.G(string);
        return component.replaceText((TextReplacementConfig)TextReplacementConfig.builder().match(PermissibleBridge_2.St).replacement(builder2 -> {
            PermissibleBridge permissibleBridge = ItemStackRegistry.g().al.aR(builder2.content());
            if (permissibleBridge != null && permissible != null && !permissibleBridge.a(permissible)) {
                return builder2;
            }
            if (permissibleBridge == null) {
                String string2 = ItemStackRegistry.g().al.aT(builder2.content());
                if (string2 != null) {
                    return builder2.content(string2);
                }
                return builder2;
            }
            if (bl && string != null && permissibleBridge.uE) {
                if (permissibleBridge.ii() != null) {
                    opaque020.H(permissibleBridge.ii());
                }
                builder2.hoverEvent((HoverEventSource)HoverEvent.showText((Component)Component.text((String)((String)opaque020.aAW).replace("{id}", permissibleBridge.bM).replace("{placeholder}", permissibleBridge.ij())).replaceText((TextReplacementConfig)TextReplacementConfig.builder().match("\\{font_image\\}").replacement(builder -> {
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
}
