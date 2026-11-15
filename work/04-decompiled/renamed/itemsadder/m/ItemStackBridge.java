package itemsadder.m;

import java.util.List;
import java.util.stream.Collectors;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStackBridge {
    public static void e(ItemStack itemStack, String string) {
        itemStack.setType(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta)itemStack.getItemMeta();
        bookMeta.setAuthor(string);
        itemStack.setItemMeta((ItemMeta)bookMeta);
    }

    public static void a(ItemStack itemStack, BookMeta.Generation generation) {
        itemStack.setType(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta)itemStack.getItemMeta();
        bookMeta.setGeneration(generation);
        itemStack.setItemMeta((ItemMeta)bookMeta);
    }

    public static void f(ItemStack itemStack, String string) {
        itemStack.setType(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta)itemStack.getItemMeta();
        bookMeta.setTitle(string);
        itemStack.setItemMeta((ItemMeta)bookMeta);
    }

    public static void c(ItemStack itemStack, List list) {
        itemStack.setType(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta)itemStack.getItemMeta();
        bookMeta.setPages(list.stream().map(string -> ChatColor.translateAlternateColorCodes((char)'&', (String)string)).collect(Collectors.toList()));
        itemStack.setItemMeta((ItemMeta)bookMeta);
    }
}
