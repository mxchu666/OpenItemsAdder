package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketListener;
import com.comphenix.protocol.wrappers.MinecraftKey;
import dev.lone.itemsadder.Main;
import itemsadder.m.ae;
import itemsadder.m.aiq;
import itemsadder.m.aow;
import itemsadder.m.asd;
import itemsadder.m.asg;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.uu;
import itemsadder.m.uw;
import itemsadder.m.va;
import itemsadder.m.vk;
import itemsadder.m.wc;
import java.util.HashMap;
import java.util.Set;
import java.util.WeakHashMap;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Furnace;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class asf
implements asd,
Listener {
    public static String ami = "zzzfake_";
    protected final Main amj;
    public final d amk;
    protected PacketAdapter aml;
    protected PacketAdapter amm;
    private va amn;
    private uu amo;
    public /*
     * Issues handling annotations - annotations may be inaccurate
     */
    @Nullable WeakHashMap amp = new WeakHashMap();
    protected HashMap amq = new HashMap();

    public asf() {
        this.amj = Main.rS();
        this.amk = d.g();
    }

    public static void a(Player player, uw uw2) {
        if (ae.eC) {
            bce.f((CommandSender)player, Main.PQ.ir("no-craft-permission"));
        }
        bcp.c(() -> asf.c(player, uw2), 1L);
    }

    public static void b(Player player, uw uw2) {
        if (ae.eC) {
            bce.f((CommandSender)player, Main.PQ.ir("no-craft-permission"));
        }
        asf.c(player, uw2);
    }

    public static void c(Player player, uw uw2) {
        if (uw2.qT()) {
            asg.vq().a(player, ((Keyed)uw2.qR()).getKey());
        }
        if (ae.eB) {
            ItemStack itemStack = uw2.qN().clone();
            Component component = bbs.ah(itemStack);
            if (component == null) {
                component = Component.translatable((String)aiq.tX().W(itemStack));
            }
            component = component.font(Key.key((String)"minecraft:default"));
            Component component2 = ((TextComponent)((TextComponent)Component.text((String)"!A@").color(TextColor.color((int)255, (int)255, (int)255))).decoration(TextDecoration.ITALIC, false)).font(Key.key((String)"_iainternal:gui"));
            component2 = component2.append(component);
            bbs.a(itemStack, component2);
            int n = 2;
            if (uw2 instanceof vk) {
                n = 0;
            }
            if (uw2 instanceof wc) {
                n = 3;
            }
            aiq.b(player, itemStack, n);
        }
    }

    protected void vk() {
        aow.b((PacketListener)this.aml);
        aow.b((PacketListener)this.amm);
        if (ae.eX) {
            this.amn = new va((Plugin)this.amj);
        } else if (ae.eY) {
            this.amo = new uu((Plugin)this.amj, this);
        }
    }

    public void vl() {
        aow.c((PacketListener)this.aml);
        aow.c((PacketListener)this.amm);
        bev.b(this.amn);
        bev.b(this.amo);
        this.amp.clear();
        this.amq.clear();
        bev.b(this);
    }

    public void a(Player player, @NotNull NamespacedKey namespacedKey) {
        if (!Version.isAtLeast((Version)Version.v1_21_3)) {
            PacketContainer packetContainer = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Server.AUTO_RECIPE);
            packetContainer.getIntegers().write(0, (Object)aiq.tX().bT(player));
            packetContainer.getMinecraftKeys().write(0, (Object)new MinecraftKey(namespacedKey.getNamespace(), namespacedKey.getKey()));
            aow.a(player, packetContainer, false);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void c(PlayerQuitEvent playerQuitEvent) {
        this.amp.remove(playerQuitEvent.getPlayer());
    }

    public abstract void g(Set var1);

    public abstract void vm();

    public abstract NamespacedKey a(Furnace var1);

    public abstract void a(Furnace var1, NamespacedKey var2);

    public abstract Set h(Set var1);

    @Nullable
    public abstract String c(CraftingInventory var1);

    public void vn() {
    }

    public boolean e(Recipe recipe) {
        return Bukkit.addRecipe((Recipe)recipe);
    }

    public boolean h(NamespacedKey namespacedKey) {
        return Bukkit.removeRecipe((NamespacedKey)namespacedKey);
    }

    public void vo() {
    }

    public abstract boolean a(ShapedRecipe var1, CraftingInventory var2);
}
