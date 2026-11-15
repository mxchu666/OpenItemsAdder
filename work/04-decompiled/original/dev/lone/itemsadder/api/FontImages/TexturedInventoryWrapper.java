package dev.lone.itemsadder.api.FontImages;

import dev.lone.itemsadder.api.FontImages.FontImageWrapper;
import itemsadder.m.aiq;
import itemsadder.m.bbe;
import itemsadder.m.il;
import itemsadder.m.zv;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TexturedInventoryWrapper {
    private final Inventory internal;
    Component component;

    public TexturedInventoryWrapper(@Nullable InventoryHolder inventoryHolder, int n, String string, int n2, int n3, FontImageWrapper ... fontImageWrapperArray) {
        this(inventoryHolder, null, n, string, n2, n3, fontImageWrapperArray);
    }

    public TexturedInventoryWrapper(@Nullable InventoryHolder inventoryHolder, @NotNull InventoryType inventoryType, String string, int n, int n2, FontImageWrapper ... fontImageWrapperArray) {
        this(inventoryHolder, inventoryType, 0, string, n, n2, fontImageWrapperArray);
    }

    public TexturedInventoryWrapper(@Nullable InventoryHolder inventoryHolder, int n, int n2, FontImageWrapper ... fontImageWrapperArray) {
        this(inventoryHolder, n, null, 0, n2, fontImageWrapperArray);
    }

    public TexturedInventoryWrapper(@Nullable InventoryHolder inventoryHolder, @NotNull InventoryType inventoryType, int n, FontImageWrapper ... fontImageWrapperArray) {
        this(inventoryHolder, inventoryType, 0, null, 0, n, fontImageWrapperArray);
    }

    private TexturedInventoryWrapper(@Nullable InventoryHolder inventoryHolder, InventoryType inventoryType, int n, String string, int n2, int n3, FontImageWrapper ... fontImageWrapperArray) {
        this.internal = inventoryType != null ? Bukkit.createInventory((InventoryHolder)inventoryHolder, (InventoryType)inventoryType, (String)"IA_CUST_GUI") : (n > 0 ? Bukkit.createInventory((InventoryHolder)inventoryHolder, (int)n, (String)"IA_CUST_GUI") : Bukkit.createInventory((InventoryHolder)inventoryHolder, (int)54, (String)"IA_CUST_GUI"));
        this.component = Component.text((String)"");
        this.component = this.component.style(builder -> {
            builder.decoration(TextDecoration.ITALIC, false);
            builder.color(bbe.azD);
        });
        int n4 = 0;
        for (FontImageWrapper fontImageWrapper : fontImageWrapperArray) {
            n4 += fontImageWrapper.getInternal().getWidth();
            this.component = this.component.append(Component.text((String)fontImageWrapper.internalGetUnicode()).color(fontImageWrapper.getColor()));
        }
        this.component = il.a(this.component, n3);
        if (string != null && !string.isEmpty()) {
            this.component = this.component.append(il.a(bbe.gF(string), -n4 + n3 + n2));
        }
    }

    public TexturedInventoryWrapper(@Nullable InventoryHolder inventoryHolder, @NotNull InventoryType inventoryType, String string, FontImageWrapper fontImageWrapper, int n, int n2) {
        this.internal = Bukkit.createInventory((InventoryHolder)inventoryHolder, (InventoryType)inventoryType, (String)"IA_CUST_GUI");
        this.component = bbe.gF(String.valueOf(ChatColor.WHITE) + il.c(fontImageWrapper.getInternal().if(), n2));
        if (string != null && !string.isEmpty()) {
            this.component = this.component.append(il.a(bbe.gF(string), -fontImageWrapper.getInternal().getWidth() + n2 + n));
        }
    }

    public TexturedInventoryWrapper(@Nullable InventoryHolder inventoryHolder, int n, String string, FontImageWrapper fontImageWrapper, int n2, int n3) {
        this.internal = Bukkit.createInventory((InventoryHolder)inventoryHolder, (int)n, (String)"IA_CUST_GUI");
        this.component = bbe.gF(String.valueOf(ChatColor.WHITE) + il.c(fontImageWrapper.getInternal().if(), n3));
        if (string != null && !string.isEmpty()) {
            this.component = this.component.append(il.a(bbe.gF(string), -fontImageWrapper.getInternal().getWidth() + n3 + n2));
        }
    }

    public TexturedInventoryWrapper(@Nullable InventoryHolder inventoryHolder, int n, FontImageWrapper fontImageWrapper, int n2) {
        this(inventoryHolder, n, null, fontImageWrapper, 0, n2);
    }

    @Deprecated
    public TexturedInventoryWrapper(@Nullable InventoryHolder inventoryHolder, @NotNull InventoryType inventoryType, String string, FontImageWrapper fontImageWrapper) {
        this(inventoryHolder, inventoryType, string, fontImageWrapper, 16, -16);
    }

    @Deprecated
    public TexturedInventoryWrapper(@Nullable InventoryHolder inventoryHolder, @NotNull InventoryType inventoryType, String string, FontImageWrapper fontImageWrapper, int n) {
        this(inventoryHolder, inventoryType, string, fontImageWrapper, n, -16);
    }

    @Deprecated
    public TexturedInventoryWrapper(@Nullable InventoryHolder inventoryHolder, int n, String string, FontImageWrapper fontImageWrapper) {
        this(inventoryHolder, n, string, fontImageWrapper, 16, -16);
    }

    @Deprecated
    public TexturedInventoryWrapper(@Nullable InventoryHolder inventoryHolder, int n, String string, FontImageWrapper fontImageWrapper, int n2) {
        this(inventoryHolder, n, string, fontImageWrapper, n2, -16);
    }

    public static void setPlayerInventoryTexture(Player player, FontImageWrapper fontImageWrapper, String string) {
        TexturedInventoryWrapper.setPlayerInventoryTexture(player, fontImageWrapper, string, 16, -16);
    }

    public static void setPlayerInventoryTexture(Player player, FontImageWrapper fontImageWrapper) {
        TexturedInventoryWrapper.setPlayerInventoryTexture(player, fontImageWrapper, null, 16, -16);
    }

    public static void setPlayerInventoryTexture(Player player, FontImageWrapper fontImageWrapper, int n) {
        TexturedInventoryWrapper.setPlayerInventoryTexture(player, fontImageWrapper, null, n, -16);
    }

    public static void setPlayerInventoryTexture(Player player, FontImageWrapper fontImageWrapper, String string, int n, int n2) {
        if (string == null) {
            string = player.getOpenInventory().getTitle();
        }
        TextComponent textComponent = Component.text((String)(String.valueOf(ChatColor.WHITE) + il.c(fontImageWrapper.getInternal().if(), n2)));
        textComponent = textComponent.append(il.a(bbe.gF(string), -fontImageWrapper.getInternal().getWidth() + n2 + n));
        aiq.tX().b(player, (Component)textComponent);
    }

    @Deprecated
    public Inventory getInternal() {
        return this.internal;
    }

    public void showInventory(Player player) {
        zv.a(player, this.component);
        player.openInventory(this.internal);
    }
}
