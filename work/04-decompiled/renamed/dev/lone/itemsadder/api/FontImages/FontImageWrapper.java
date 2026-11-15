package dev.lone.itemsadder.api.FontImages;

import itemsadder.m.ItemStackRegistry;
import itemsadder.m.Opaque123;
import itemsadder.m.PermissibleBridge;
import itemsadder.m.PermissibleBridge_2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class FontImageWrapper {
    private final PermissibleBridge internal;
    private TextColor color;
    private int offset;

    public FontImageWrapper(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("FontImageWrapper: namespacedID cannot be null or empty");
        }
        this.internal = (PermissibleBridge)ItemStackRegistry.g().al.um.get(string);
        if (this.internal == null) {
            throw new IllegalArgumentException("FontImageWrapper: FontImage with namespacedID '" + string + "' does not exist");
        }
        this.color = TextColor.fromHexString((String)"#FFFFFF");
        this.offset = 0;
    }

    public static FontImageWrapper instance(String string) {
        try {
            return new FontImageWrapper(string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }

    public static Set getNamespacedIdsInRegistry() {
        return ItemStackRegistry.g().al.um.keySet();
    }

    public static Map getNamespacedIdsAndValueInRegistry() {
        return ItemStackRegistry.g().al.um.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> ((PermissibleBridge)entry.getValue()).Q(false)));
    }

    public static String replaceFontImages(String string) {
        return PermissibleBridge_2.replaceFontImages(string);
    }

    @NotNull
    public static Component replaceFontImages(Component component) {
        return PermissibleBridge_2.h(component);
    }

    public static String replaceFontImages(Permissible permissible, String string) {
        return PermissibleBridge_2.replaceFontImages(permissible, string);
    }

    @NotNull
    public static Component replaceFontImages(Permissible permissible, Component component) {
        return PermissibleBridge_2.a(permissible, component);
    }

    public static String applyPixelsOffsetToString(String string, int n) {
        return Opaque123.c(string, n);
    }

    public PermissibleBridge getInternal() {
        return this.internal;
    }

    public String getNamespacedID() {
        return this.internal.getNamespacedID();
    }

    public boolean exists() {
        return this.internal != null;
    }

    public String getString() {
        return Opaque123.c(this.internal.if(), this.offset);
    }

    public int getWidth() {
        return this.internal.getWidth();
    }

    public int getHeight() {
        return this.internal.getHeight();
    }

    @Deprecated
    public String applyPixelsOffset(int n) {
        this.offset = n;
        return Opaque123.c(this.internal.if(), n);
    }

    public TextColor getColor() {
        return this.color;
    }

    public FontImageWrapper setColor(TextColor textColor) {
        this.color = textColor;
        return this;
    }

    public FontImageWrapper setColor(ChatColor chatColor) {
        if (chatColor == null) {
            this.color = TextColor.fromHexString((String)"#FFFFFF");
        } else if (chatColor == ChatColor.WHITE) {
            this.color = TextColor.fromHexString((String)"#FFFFFF");
        } else if (chatColor == ChatColor.BLACK) {
            this.color = TextColor.fromHexString((String)"#000000");
        } else if (chatColor == ChatColor.DARK_BLUE) {
            this.color = TextColor.fromHexString((String)"#0000AA");
        } else if (chatColor == ChatColor.DARK_GREEN) {
            this.color = TextColor.fromHexString((String)"#00AA00");
        } else if (chatColor == ChatColor.DARK_AQUA) {
            this.color = TextColor.fromHexString((String)"#00AAAA");
        } else if (chatColor == ChatColor.DARK_RED) {
            this.color = TextColor.fromHexString((String)"#AA0000");
        } else if (chatColor == ChatColor.DARK_PURPLE) {
            this.color = TextColor.fromHexString((String)"#AA00AA");
        } else if (chatColor == ChatColor.GOLD) {
            this.color = TextColor.fromHexString((String)"#FFAA00");
        } else if (chatColor == ChatColor.GRAY) {
            this.color = TextColor.fromHexString((String)"#AAAAAA");
        } else if (chatColor == ChatColor.DARK_GRAY) {
            this.color = TextColor.fromHexString((String)"#555555");
        } else if (chatColor == ChatColor.BLUE) {
            this.color = TextColor.fromHexString((String)"#5555FF");
        } else if (chatColor == ChatColor.GREEN) {
            this.color = TextColor.fromHexString((String)"#55FF55");
        } else if (chatColor == ChatColor.AQUA) {
            this.color = TextColor.fromHexString((String)"#55FFFF");
        } else if (chatColor == ChatColor.RED) {
            this.color = TextColor.fromHexString((String)"#FF5555");
        } else if (chatColor == ChatColor.LIGHT_PURPLE) {
            this.color = TextColor.fromHexString((String)"#FF55FF");
        } else if (chatColor == ChatColor.YELLOW) {
            this.color = TextColor.fromHexString((String)"#FFFF55");
        }
        return this;
    }

    public FontImageWrapper setOffset(int n) {
        this.offset = n;
        return this;
    }

    public int getOffset() {
        return this.offset;
    }

    public String internalGetUnicode() {
        return Opaque123.c(this.internal.if(), this.offset);
    }
}
