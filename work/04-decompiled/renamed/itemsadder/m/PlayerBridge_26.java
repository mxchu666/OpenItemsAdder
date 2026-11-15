package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import dev.lone.itemsadder.Main;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PacketContainerHolder;
import itemsadder.m.PermissibleBridge;
import itemsadder.m.PlayerJoinListener_10;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.PluginContract;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.kyori.adventure.inventory.Book;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.event.HoverEventSource;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;

public class PlayerBridge_26
implements PluginContract {
    static final int So = 13;
    static final int Sp = Short.MAX_VALUE;
    private static final float Sq = 6.0f;
    private final Key Sr = Key.key((String)MaterialBarColorHolder.eV);
    private final int Ss = MaterialBarColorHolder.eU * 13;

    public void bp(Player player) {
        BukkitTaskBridge.h(() -> PacketContainerHolder.tp().a(player, Book.book((Component)Component.text((String)"ItemsAdder"), (Component)Component.text((String)"ItemsAdder"), (Collection)this.bq(player))));
    }

    private List bq(Player player) {
        ArrayList<TextComponent> arrayList = new ArrayList<TextComponent>();
        int n = 0;
        int n2 = 0;
        ArrayList<PermissibleBridge> arrayList2 = new ArrayList<PermissibleBridge>();
        ArrayList<PermissibleBridge> arrayList3 = new ArrayList<PermissibleBridge>();
        ArrayList<PermissibleBridge> arrayList4 = new ArrayList<PermissibleBridge>();
        for (Map.Entry entry : ItemStackRegistry.g().al.um.entrySet()) {
            if (!((PermissibleBridge)entry.getValue()).ig()) continue;
            if (((PermissibleBridge)entry.getValue()).a((Permissible)player)) {
                arrayList2.add((PermissibleBridge)entry.getValue());
                continue;
            }
            arrayList3.add((PermissibleBridge)entry.getValue());
        }
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        TextComponent textComponent = Component.empty();
        for (PermissibleBridge permissibleBridge : arrayList4) {
            String string = permissibleBridge.a((Permissible)player) ? " " + permissibleBridge.ij() : " " + Main.PQ.ir("no-permission-short");
            int n3 = (int)Math.ceil((float)permissibleBridge.getWidth() / 6.0f);
            int n4 = Math.max(0, MaterialBarColorHolder.eU - n3);
            string = String.valueOf(ChatColor.BLACK) + PlayerBridge_26.i(string, n4);
            int n5 = n3 + PlayerBridge_26.dj(string);
            Component component = Component.text((String)(String.valueOf(ChatColor.WHITE) + permissibleBridge.if())).append(this.a((Component)Component.text((String)(string + "\n")), permissibleBridge).font(this.Sr));
            Component component2 = textComponent.append(component).compact();
            if (n > 0 && (n2 + n5 > this.Ss || n >= 13 || Version.isAtLeast((Version)Version.v26_2) && PlayerBridge_26.g(component2))) {
                arrayList.add(textComponent);
                textComponent = component.compact();
                n = 1;
                n2 = n5;
                continue;
            }
            textComponent = component2;
            ++n;
            n2 += n5;
        }
        if (n > 0 || arrayList.isEmpty()) {
            arrayList.add(textComponent);
        }
        return arrayList;
    }

    static boolean g(Component component) {
        return ((String)GsonComponentSerializer.gson().serialize(component)).length() > Short.MAX_VALUE;
    }

    static String i(String string, int n) {
        Object object = ChatColor.stripColor((String)string);
        if (((String)object).length() > n) {
            object = n <= 3 ? ".".repeat(n) : ((String)object).substring(0, n - 3) + "...";
        }
        return ChatColor.getLastColors((String)string) + (String)object;
    }

    private static int dj(String string) {
        return ChatColor.stripColor((String)string).length();
    }

    private Component a(Component component, PermissibleBridge permissibleBridge) {
        if (MaterialBarColorHolder.eF) {
            return component.hoverEvent((HoverEventSource)HoverEvent.showText((Component)PluginBridge_6.gK(PlayerJoinListener_10.Sf.replace("{id}", permissibleBridge.bM).replace("{placeholder}", permissibleBridge.ij())).replaceText((TextReplacementConfig)TextReplacementConfig.builder().match("\\{font_image\\}").replacement(builder -> builder.content(permissibleBridge.Q(false))).build())));
        }
        return component;
    }
}
