package itemsadder.m;

import com.comphenix.protocol.events.PacketContainer;
import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.PermissibleBridge_4;
import java.util.regex.Matcher;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.Nullable;

public class PacketContainerHelper_3 {
    public static void a(PacketContainer packetContainer) {
        Object object = packetContainer.getModifier().readSafely(0);
        if (object instanceof Component) {
            Component component = (Component)object;
            component = PacketContainerHelper_3.h(component);
            packetContainer.getModifier().write(0, (Object)component);
        }
    }

    public static Component h(Component component) {
        return PacketContainerHelper_3.a(null, component);
    }

    public static Component a(@Nullable Permissible permissible, Component component) {
        return component.replaceText((TextReplacementConfig)TextReplacementConfig.builder().match(PermissibleBridge_4.Su).replacement(builder -> {
            Matcher matcher = PermissibleBridge_4.Su.matcher(builder.content());
            if (matcher.matches()) {
                String string = matcher.group(1);
                int[] nArray = PermissibleBridge_4.dl(string);
                if (nArray == null) {
                    return builder;
                }
                if (permissible != null && !permissible.hasPermission("ia.user.text_effect.use." + string)) {
                    if (permissible instanceof Player) {
                        CommandSenderBridge_5.f((CommandSender)((Player)permissible), Main.PQ.ir("no-permission-detail").replace("{permission}", "ia.user.text_effect.use." + string));
                    }
                    return builder.content(matcher.group(2));
                }
                return builder.content(matcher.group(2)).color(TextColor.color((int)nArray[0], (int)nArray[1], (int)nArray[2]));
            }
            return builder;
        }).build());
    }
}
