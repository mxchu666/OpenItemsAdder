package itemsadder.m;

import com.comphenix.protocol.events.PacketContainer;
import dev.lone.itemsadder.Main;
import itemsadder.m.bce;
import itemsadder.m.xm;
import java.util.regex.Matcher;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.Nullable;

public class xn {
    public static void a(PacketContainer packetContainer) {
        Object object = packetContainer.getModifier().readSafely(0);
        if (object instanceof Component) {
            Component component = (Component)object;
            component = xn.h(component);
            packetContainer.getModifier().write(0, (Object)component);
        }
    }

    public static Component h(Component component) {
        return xn.a(null, component);
    }

    public static Component a(@Nullable Permissible permissible, Component component) {
        return component.replaceText((TextReplacementConfig)TextReplacementConfig.builder().match(xm.Su).replacement(builder -> {
            Matcher matcher = xm.Su.matcher(builder.content());
            if (matcher.matches()) {
                String string = matcher.group(1);
                int[] nArray = xm.dl(string);
                if (nArray == null) {
                    return builder;
                }
                if (permissible != null && !permissible.hasPermission("ia.user.text_effect.use." + string)) {
                    if (permissible instanceof Player) {
                        bce.f((CommandSender)((Player)permissible), Main.PQ.ir("no-permission-detail").replace("{permission}", "ia.user.text_effect.use." + string));
                    }
                    return builder.content(matcher.group(2));
                }
                return builder.content(matcher.group(2)).color(TextColor.color((int)nArray[0], (int)nArray[1], (int)nArray[2]));
            }
            return builder;
        }).build());
    }
}
