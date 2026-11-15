package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import dev.lone.itemsadder.Main;
import itemsadder.m.adb;
import itemsadder.m.ae;
import itemsadder.m.ai;
import itemsadder.m.bbe;
import itemsadder.m.bcp;
import itemsadder.m.d;
import itemsadder.m.fw;
import itemsadder.m.xe;
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

public class xj
implements ai {
    static final int So = 13;
    static final int Sp = Short.MAX_VALUE;
    private static final float Sq = 6.0f;
    private final Key Sr = Key.key((String)ae.eV);
    private final int Ss = ae.eU * 13;

    public void bp(Player player) {
        bcp.h(() -> adb.tp().a(player, Book.book((Component)Component.text((String)"ItemsAdder"), (Component)Component.text((String)"ItemsAdder"), (Collection)this.bq(player))));
    }

    private List bq(Player player) {
        ArrayList<TextComponent> arrayList = new ArrayList<TextComponent>();
        int n = 0;
        int n2 = 0;
        ArrayList<fw> arrayList2 = new ArrayList<fw>();
        ArrayList<fw> arrayList3 = new ArrayList<fw>();
        ArrayList<fw> arrayList4 = new ArrayList<fw>();
        for (Map.Entry entry : d.g().al.um.entrySet()) {
            if (!((fw)entry.getValue()).ig()) continue;
            if (((fw)entry.getValue()).a((Permissible)player)) {
                arrayList2.add((fw)entry.getValue());
                continue;
            }
            arrayList3.add((fw)entry.getValue());
        }
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        TextComponent textComponent = Component.empty();
        for (fw fw2 : arrayList4) {
            String string = fw2.a((Permissible)player) ? " " + fw2.ij() : " " + Main.PQ.ir("no-permission-short");
            int n3 = (int)Math.ceil((float)fw2.getWidth() / 6.0f);
            int n4 = Math.max(0, ae.eU - n3);
            string = String.valueOf(ChatColor.BLACK) + xj.i(string, n4);
            int n5 = n3 + xj.dj(string);
            Component component = Component.text((String)(String.valueOf(ChatColor.WHITE) + fw2.if())).append(this.a((Component)Component.text((String)(string + "\n")), fw2).font(this.Sr));
            Component component2 = textComponent.append(component).compact();
            if (n > 0 && (n2 + n5 > this.Ss || n >= 13 || Version.isAtLeast((Version)Version.v26_2) && xj.g(component2))) {
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

    private Component a(Component component, fw fw2) {
        if (ae.eF) {
            return component.hoverEvent((HoverEventSource)HoverEvent.showText((Component)bbe.gK(xe.Sf.replace("{id}", fw2.bM).replace("{placeholder}", fw2.ij())).replaceText((TextReplacementConfig)TextReplacementConfig.builder().match("\\{font_image\\}").replacement(builder -> builder.content(fw2.Q(false))).build())));
        }
        return component;
    }
}
