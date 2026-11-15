package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketListener;
import com.comphenix.protocol.wrappers.MinecraftKey;
import dev.lone.itemsadder.Main;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBridge_35;
import itemsadder.m.ItemStackBridge_41;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerHolder_2;
import itemsadder.m.PlayerHolder_5;
import itemsadder.m.PlayerJoinListener_8;
import itemsadder.m.PlayerNms;
import itemsadder.m.PlayerQuitListener_4;
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

public abstract class PlayerQuitListenerBase
implements PlayerNms,
Listener {
    public static String ami = "zzzfake_";
    protected final Main amj;
    public final ItemStackRegistry amk;
    protected PacketAdapter aml;
    protected PacketAdapter amm;
    private PlayerJoinListener_8 amn;
    private PlayerQuitListener_4 amo;
    public /*
     * Issues handling annotations - annotations may be inaccurate
     */
    @Nullable WeakHashMap amp = new WeakHashMap();
    protected HashMap amq = new HashMap();

    public PlayerQuitListenerBase() {
        this.amj = Main.rS();
        this.amk = ItemStackRegistry.g();
    }

    public static void a(Player player, NamespacedKeyItemStackHolder namespacedKeyItemStackHolder) {
        if (MaterialBarColorHolder.eC) {
            CommandSenderBridge_5.f((CommandSender)player, Main.PQ.ir("no-craft-permission"));
        }
        BukkitTaskBridge.c(() -> PlayerQuitListenerBase.c(player, namespacedKeyItemStackHolder), 1L);
    }

    public static void b(Player player, NamespacedKeyItemStackHolder namespacedKeyItemStackHolder) {
        if (MaterialBarColorHolder.eC) {
            CommandSenderBridge_5.f((CommandSender)player, Main.PQ.ir("no-craft-permission"));
        }
        PlayerQuitListenerBase.c(player, namespacedKeyItemStackHolder);
    }

    public static void c(Player player, NamespacedKeyItemStackHolder namespacedKeyItemStackHolder) {
        if (namespacedKeyItemStackHolder.qT()) {
            PlayerHolder_5.vq().a(player, ((Keyed)namespacedKeyItemStackHolder.qR()).getKey());
        }
        if (MaterialBarColorHolder.eB) {
            ItemStack itemStack = namespacedKeyItemStackHolder.qN().clone();
            Component component = ItemStackBridge_2.ah(itemStack);
            if (component == null) {
                component = Component.translatable((String)PlayerHolder_2.tX().W(itemStack));
            }
            component = component.font(Key.key((String)"minecraft:default"));
            Component component2 = ((TextComponent)((TextComponent)Component.text((String)"!A@").color(TextColor.color((int)255, (int)255, (int)255))).decoration(TextDecoration.ITALIC, false)).font(Key.key((String)"_iainternal:gui"));
            component2 = component2.append(component);
            ItemStackBridge_2.a(itemStack, component2);
            int n = 2;
            if (namespacedKeyItemStackHolder instanceof ItemStackBridge_35) {
                n = 0;
            }
            if (namespacedKeyItemStackHolder instanceof ItemStackBridge_41) {
                n = 3;
            }
            PlayerHolder_2.b(player, itemStack, n);
        }
    }

    protected void vk() {
        PacketListenerRegistry.b((PacketListener)this.aml);
        PacketListenerRegistry.b((PacketListener)this.amm);
        if (MaterialBarColorHolder.eX) {
            this.amn = new PlayerJoinListener_8((Plugin)this.amj);
        } else if (MaterialBarColorHolder.eY) {
            this.amo = new PlayerQuitListener_4((Plugin)this.amj, this);
        }
    }

    public void vl() {
        PacketListenerRegistry.c((PacketListener)this.aml);
        PacketListenerRegistry.c((PacketListener)this.amm);
        ListenerBridge.b(this.amn);
        ListenerBridge.b(this.amo);
        this.amp.clear();
        this.amq.clear();
        ListenerBridge.b(this);
    }

    public void a(Player player, @NotNull NamespacedKey namespacedKey) {
        if (!Version.isAtLeast((Version)Version.v1_21_3)) {
            PacketContainer packetContainer = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Server.AUTO_RECIPE);
            packetContainer.getIntegers().write(0, (Object)PlayerHolder_2.tX().bT(player));
            packetContainer.getMinecraftKeys().write(0, (Object)new MinecraftKey(namespacedKey.getNamespace(), namespacedKey.getKey()));
            PacketListenerRegistry.a(player, packetContainer, false);
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
