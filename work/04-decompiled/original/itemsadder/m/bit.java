package itemsadder.m;

import itemsadder.m.bio;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class bit
extends bio {
    private final List aEo = new ArrayList();
    private final List aEp = new ArrayList();
    private List aEq = IntStream.range(0, Math.max(9, this.getInventory().getSize() - 9)).boxed().collect(Collectors.toList());
    private int TE = 1;
    private IntFunction aEr;
    private IntFunction aEs;
    private int aEt = -1;
    private int aEu = -1;

    public bit(int n) {
        this((T bit2) -> Bukkit.createInventory((InventoryHolder)bit2, (int)n));
    }

    public bit(int n, String string) {
        this((T bit2) -> Bukkit.createInventory((InventoryHolder)bit2, (int)n, (String)string));
    }

    public bit(InventoryType inventoryType) {
        this((T bit2) -> Bukkit.createInventory((InventoryHolder)bit2, (InventoryType)inventoryType));
    }

    public bit(InventoryType inventoryType, String string) {
        this((T bit2) -> Bukkit.createInventory((InventoryHolder)bit2, (InventoryType)inventoryType, (String)string));
    }

    public bit(Function function) {
        super((T bio2) -> (Inventory)function.apply((bit)bio2));
    }

    public void aE(ItemStack itemStack) {
        this.b(itemStack, null);
    }

    public void b(ItemStack itemStack, Consumer consumer) {
        this.aEo.add(itemStack);
        this.aEp.add(consumer);
    }

    public void g(Collection collection) {
        this.c(collection, Collections.nCopies(collection.size(), null));
    }

    public void c(Collection collection, Collection collection2) {
        Objects.requireNonNull(collection, "content");
        Objects.requireNonNull(collection2, "handlers");
        if (collection.size() != collection2.size()) {
            throw new IllegalArgumentException("The content and handlers lists must have the same size");
        }
        this.aEo.addAll(collection);
        this.aEp.addAll(collection2);
    }

    public void c(int n, ItemStack itemStack) {
        this.b(n, itemStack, null);
    }

    public void b(int n, ItemStack itemStack, Consumer consumer) {
        this.aEo.set(n, itemStack);
        this.aEp.set(n, consumer);
    }

    public void U(List list) {
        this.Fd();
        this.g(list);
    }

    public void d(Collection collection, Collection collection2) {
        Objects.requireNonNull(collection, "content");
        Objects.requireNonNull(collection2, "handlers");
        if (collection.size() != collection2.size()) {
            throw new IllegalArgumentException("The content and handlers lists must have the same size");
        }
        this.Fd();
        this.c(collection, collection2);
    }

    public void Fd() {
        this.aEo.clear();
        this.aEp.clear();
    }

    public void Fe() {
        this.ca(this.TE - 1);
    }

    public void Ff() {
        this.ca(this.TE + 1);
    }

    public void ca(int n) {
        int n2 = this.Fh();
        this.TE = Math.max(1, Math.min(n, n2));
        int n3 = this.aEq.size() * (this.TE - 1);
        Iterator iterator = this.aEq.iterator();
        while (iterator.hasNext()) {
            int n4 = (Integer)iterator.next();
            if (n3 >= this.aEo.size()) {
                this.bX(n4);
                continue;
            }
            this.a(n4, (ItemStack)this.aEo.get(n3), (Consumer)this.aEp.get(n3++));
        }
        if (this.TE > 1 && this.aEr != null) {
            this.a(this.aEt, (ItemStack)this.aEr.apply(this.TE - 1), (T inventoryClickEvent) -> this.Fe());
        } else if (this.aEt >= 0) {
            this.bX(this.aEt);
        }
        if (this.TE < n2 && this.aEs != null) {
            this.a(this.aEu, (ItemStack)this.aEs.apply(this.TE + 1), (T inventoryClickEvent) -> this.Ff());
        } else if (this.aEu >= 0) {
            this.bX(this.aEu);
        }
        this.cb(n);
    }

    public void V(List list) {
        this.aEq = Objects.requireNonNull(list, "contentSlots");
    }

    public void b(int n, IntFunction intFunction) {
        if (n < 0 || n >= this.getInventory().getSize()) {
            throw new IllegalArgumentException("Invalid slot: " + n);
        }
        this.aEt = n;
        this.aEr = intFunction;
    }

    public void d(int n2, ItemStack itemStack) {
        this.b(n2, (int n) -> itemStack);
    }

    public void c(int n, IntFunction intFunction) {
        if (n < 0 || n >= this.getInventory().getSize()) {
            throw new IllegalArgumentException("Invalid slot: " + n);
        }
        this.aEu = n;
        this.aEs = intFunction;
    }

    public void e(int n2, ItemStack itemStack) {
        this.c(n2, (int n) -> itemStack);
    }

    @Override
    public void cG(Player player) {
        this.ca(this.TE);
        super.cG(player);
    }

    protected void cb(int n) {
    }

    public int Fg() {
        return this.TE;
    }

    public int Fh() {
        int n = this.aEo.size() / this.aEq.size();
        int n2 = this.aEo.size() % this.aEq.size();
        return n2 == 0 ? n : n + 1;
    }

    public boolean Fi() {
        return this.TE == 1;
    }

    public boolean Fj() {
        return this.TE == this.Fh();
    }
}
