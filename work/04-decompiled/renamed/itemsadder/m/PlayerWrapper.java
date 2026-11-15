package itemsadder.m;

import itemsadder.m.PluginBridge_6;
import net.kyori.adventure.inventory.Book;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public interface PlayerWrapper {
    public void i(Player var1, String var2);

    public void a(Player var1, Object var2);

    public void bI(Player var1);

    public Object dx(String var1);

    public Object m(String var1, int var2);

    default public boolean b(Object object, String string) {
        return false;
    }

    public String d(Object var1);

    public Component e(Object var1);

    @Nullable
    public Object f(Object var1);

    public String g(Object var1);

    default public void bJ(Player player) {
        throw new RuntimeException("Not supported on this server version.");
    }

    default public void a(Player player, Book book) {
        PluginBridge_6.CC().player(player).openBook(book);
    }
}
