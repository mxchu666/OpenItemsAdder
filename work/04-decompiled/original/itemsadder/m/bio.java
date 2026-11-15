package itemsadder.m;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class bio
implements InventoryHolder {
    private final Map aEa = new HashMap();
    private final List aEb = new ArrayList();
    private final List aEc = new ArrayList();
    private final List aEd = new ArrayList();
    private final List aEe = new ArrayList();
    private final Inventory aEf;
    private Predicate aEg;

    public bio(int n) {
        this((T bio2) -> Bukkit.createInventory((InventoryHolder)bio2, (int)n));
    }

    public bio(int n, String string) {
        this((T bio2) -> Bukkit.createInventory((InventoryHolder)bio2, (int)n, (String)string));
    }

    public bio(InventoryType inventoryType) {
        this((T bio2) -> Bukkit.createInventory((InventoryHolder)bio2, (InventoryType)inventoryType));
    }

    public bio(InventoryType inventoryType, String string) {
        this((T bio2) -> Bukkit.createInventory((InventoryHolder)bio2, (InventoryType)inventoryType, (String)string));
    }

    public bio(Function function) {
        Objects.requireNonNull(function, "inventoryFunction");
        Inventory inventory = (Inventory)function.apply(this);
        if (inventory.getHolder() != this) {
            throw new IllegalStateException("Inventory holder is not FastInv, found: " + inventory.getHolder());
        }
        this.aEf = inventory;
    }

    protected void b(InventoryOpenEvent inventoryOpenEvent) {
    }

    protected void j(InventoryClickEvent inventoryClickEvent) {
    }

    protected void b(InventoryDragEvent inventoryDragEvent) {
    }

    protected void b(InventoryCloseEvent inventoryCloseEvent) {
    }

    public void aC(ItemStack itemStack) {
        this.a(itemStack, null);
    }

    public void a(ItemStack itemStack, Consumer consumer) {
        int n = this.aEf.firstEmpty();
        if (n >= 0) {
            this.a(n, itemStack, consumer);
        }
    }

    public void a(int n, ItemStack itemStack) {
        this.a(n, itemStack, null);
    }

    public void a(int n, ItemStack itemStack, Consumer consumer) {
        this.aEf.setItem(n, itemStack);
        if (consumer != null) {
            this.aEa.put(n, consumer);
        } else {
            this.aEa.remove(n);
        }
    }

    public void a(int n, int n2, ItemStack itemStack) {
        this.a(n, n2, itemStack, null);
    }

    public void a(int n, int n2, ItemStack itemStack, Consumer consumer) {
        for (int i = n; i < n2; ++i) {
            this.a(i, itemStack, consumer);
        }
    }

    public void a(int[] nArray, ItemStack itemStack) {
        this.a(nArray, itemStack, null);
    }

    public void a(int[] nArray, ItemStack itemStack, Consumer consumer) {
        for (int n : nArray) {
            this.a(n, itemStack, consumer);
        }
    }

    public void a(Iterable iterable, ItemStack itemStack) {
        this.a(iterable, itemStack, null);
    }

    public void a(Iterable iterable, ItemStack itemStack, Consumer consumer) {
        for (Integer n : iterable) {
            this.a((int)n, itemStack, consumer);
        }
    }

    public void bX(int n) {
        this.aEf.clear(n);
        this.aEa.remove(n);
    }

    public void c(int ... nArray) {
        for (int n : nArray) {
            this.bX(n);
        }
    }

    public void EU() {
        this.aEf.clear();
        this.aEa.clear();
    }

    public void d(Predicate predicate) {
        this.aEg = predicate;
    }

    public void i(Consumer consumer) {
        this.aEb.add(consumer);
    }

    public void j(Consumer consumer) {
        this.aEc.add(consumer);
    }

    public void k(Consumer consumer) {
        this.aEd.add(consumer);
    }

    public void l(Consumer consumer) {
        this.aEe.add(consumer);
    }

    public void cG(Player player) {
        Objects.requireNonNull(player, "player").openInventory(this.aEf);
    }

    public int[] EV() {
        int n = this.aEf.getSize();
        return IntStream.range(0, n).filter(n2 -> n < 27 || n2 < 9 || n2 % 9 == 0 || (n2 - 8) % 9 == 0 || n2 > n - 9).toArray();
    }

    public int[] EW() {
        int n = this.aEf.getSize();
        return IntStream.range(0, n).filter(n2 -> n2 < 2 || n2 > 6 && n2 < 10 || n2 == 17 || n2 == n - 18 || n2 > n - 11 && n2 < n - 7 || n2 > n - 3).toArray();
    }

    public Inventory getInventory() {
        return this.aEf;
    }

    void c(InventoryOpenEvent inventoryOpenEvent) {
        this.b(inventoryOpenEvent);
        this.aEb.forEach(consumer -> consumer.accept(inventoryOpenEvent));
    }

    boolean c(InventoryCloseEvent inventoryCloseEvent) {
        this.b(inventoryCloseEvent);
        this.aEc.forEach(consumer -> consumer.accept(inventoryCloseEvent));
        return this.aEg != null && this.aEg.test((Player)inventoryCloseEvent.getPlayer());
    }

    void k(InventoryClickEvent inventoryClickEvent) {
        this.j(inventoryClickEvent);
        this.aEd.forEach(consumer -> consumer.accept(inventoryClickEvent));
        Consumer consumer2 = (Consumer)this.aEa.get(inventoryClickEvent.getRawSlot());
        if (consumer2 != null) {
            consumer2.accept(inventoryClickEvent);
        }
    }

    void c(InventoryDragEvent inventoryDragEvent) {
        this.b(inventoryDragEvent);
        this.aEe.forEach(consumer -> consumer.accept(inventoryDragEvent));
    }
}
