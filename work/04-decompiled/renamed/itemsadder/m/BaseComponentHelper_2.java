package itemsadder.m;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.nbt.api.BinaryTagHolder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.HoverEventSource;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.StyleBuilderApplicable;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.KeybindComponent;
import net.md_5.bungee.api.chat.ScoreComponent;
import net.md_5.bungee.api.chat.SelectorComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.TranslatableComponent;
import net.md_5.bungee.api.chat.hover.content.Content;
import net.md_5.bungee.api.chat.hover.content.Entity;
import net.md_5.bungee.api.chat.hover.content.Item;
import net.md_5.bungee.api.chat.hover.content.Text;

public final class BaseComponentHelper_2 {
    private static final Key azr = Key.key((String)"minecraft:air");
    private static final Key azs = Key.key((String)"minecraft:pig");

    private BaseComponentHelper_2() {
    }

    public static Component b(BaseComponent baseComponent) {
        if (baseComponent == null) {
            return Component.empty();
        }
        return BaseComponentHelper_2.c(baseComponent);
    }

    public static Component a(BaseComponent ... baseComponentArray) {
        if (baseComponentArray == null || baseComponentArray.length == 0) {
            return Component.empty();
        }
        if (baseComponentArray.length == 1) {
            return BaseComponentHelper_2.b(baseComponentArray[0]);
        }
        TextComponent.Builder builder = Component.text();
        for (BaseComponent baseComponent : baseComponentArray) {
            if (baseComponent == null) continue;
            builder.append(BaseComponentHelper_2.c(baseComponent));
        }
        return builder.build();
    }

    public static Component f(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return Component.empty();
        }
        if (collection.size() == 1) {
            return BaseComponentHelper_2.b((BaseComponent)collection.iterator().next());
        }
        TextComponent.Builder builder = Component.text();
        for (BaseComponent baseComponent : collection) {
            if (baseComponent == null) continue;
            builder.append(BaseComponentHelper_2.c(baseComponent));
        }
        return builder.build();
    }

    private static Component c(BaseComponent baseComponent) {
        Component component = BaseComponentHelper_2.d(baseComponent);
        component = BaseComponentHelper_2.a(component, baseComponent);
        List list = baseComponent.getExtra();
        if (list == null || list.isEmpty()) {
            return component;
        }
        ArrayList<Component> arrayList = new ArrayList<Component>(list.size());
        for (BaseComponent baseComponent2 : list) {
            if (baseComponent2 == null) continue;
            arrayList.add(BaseComponentHelper_2.c(baseComponent2));
        }
        if (arrayList.isEmpty()) {
            return component;
        }
        return component.children(arrayList);
    }

    private static Component d(BaseComponent baseComponent) {
        if (baseComponent instanceof TextComponent) {
            TextComponent textComponent = (TextComponent)baseComponent;
            return Component.text((String)BaseComponentHelper_2.gu(textComponent.getText()));
        }
        if (baseComponent instanceof TranslatableComponent) {
            TranslatableComponent translatableComponent = (TranslatableComponent)baseComponent;
            return BaseComponentHelper_2.a(translatableComponent);
        }
        if (baseComponent instanceof KeybindComponent) {
            KeybindComponent keybindComponent = (KeybindComponent)baseComponent;
            return Component.keybind((String)BaseComponentHelper_2.gu(keybindComponent.getKeybind()));
        }
        if (baseComponent instanceof ScoreComponent) {
            ScoreComponent scoreComponent = (ScoreComponent)baseComponent;
            String string = scoreComponent.getValue();
            if (string == null || string.isEmpty()) {
                return Component.score((String)BaseComponentHelper_2.gu(scoreComponent.getName()), (String)BaseComponentHelper_2.gu(scoreComponent.getObjective()));
            }
            return Component.score((String)BaseComponentHelper_2.gu(scoreComponent.getName()), (String)BaseComponentHelper_2.gu(scoreComponent.getObjective()), (String)string);
        }
        if (baseComponent instanceof SelectorComponent) {
            SelectorComponent selectorComponent = (SelectorComponent)baseComponent;
            BaseComponent baseComponent2 = selectorComponent.getSeparator();
            if (baseComponent2 == null) {
                return Component.selector((String)BaseComponentHelper_2.gu(selectorComponent.getSelector()));
            }
            return Component.selector((String)BaseComponentHelper_2.gu(selectorComponent.getSelector()), (ComponentLike)BaseComponentHelper_2.c(baseComponent2));
        }
        return Component.text((String)baseComponent.toPlainText());
    }

    private static Component a(TranslatableComponent translatableComponent) {
        List list = translatableComponent.getWith();
        if (list == null || list.isEmpty()) {
            return Component.translatable((String)BaseComponentHelper_2.gu(translatableComponent.getTranslate()), (String)translatableComponent.getFallback());
        }
        ArrayList<Component> arrayList = new ArrayList<Component>(list.size());
        for (BaseComponent baseComponent : list) {
            if (baseComponent == null) continue;
            arrayList.add(BaseComponentHelper_2.c(baseComponent));
        }
        return Component.translatable((String)BaseComponentHelper_2.gu(translatableComponent.getTranslate()), (String)translatableComponent.getFallback(), arrayList, (StyleBuilderApplicable[])new StyleBuilderApplicable[0]);
    }

    private static Component a(Component component, BaseComponent baseComponent) {
        net.kyori.adventure.text.event.HoverEvent hoverEvent;
        net.kyori.adventure.text.event.ClickEvent clickEvent;
        Object object;
        Style.Builder builder = Style.style();
        boolean bl = false;
        boolean bl2 = baseComponent.isReset();
        TextColor textColor = BaseComponentHelper_2.a(baseComponent.getColorRaw());
        if (textColor != null) {
            builder.color(textColor);
            bl = true;
        } else if (bl2) {
            builder.color((TextColor)NamedTextColor.WHITE);
            bl = true;
        }
        String string = baseComponent.getFontRaw();
        if (string != null && !string.isEmpty() && (object = BaseComponentHelper_2.gy(string)) != null) {
            builder.font(object);
            bl = true;
        }
        bl |= BaseComponentHelper_2.a(builder, TextDecoration.BOLD, baseComponent.isBoldRaw(), bl2);
        bl |= BaseComponentHelper_2.a(builder, TextDecoration.ITALIC, baseComponent.isItalicRaw(), bl2);
        bl |= BaseComponentHelper_2.a(builder, TextDecoration.UNDERLINED, baseComponent.isUnderlinedRaw(), bl2);
        bl |= BaseComponentHelper_2.a(builder, TextDecoration.STRIKETHROUGH, baseComponent.isStrikethroughRaw(), bl2);
        bl |= BaseComponentHelper_2.a(builder, TextDecoration.OBFUSCATED, baseComponent.isObfuscatedRaw(), bl2);
        object = baseComponent.getInsertion();
        if (object != null) {
            builder.insertion((String)object);
            bl = true;
        }
        if ((clickEvent = BaseComponentHelper_2.a(baseComponent.getClickEvent())) != null) {
            builder.clickEvent(clickEvent);
            bl = true;
        }
        if ((hoverEvent = BaseComponentHelper_2.a(baseComponent.getHoverEvent())) != null) {
            builder.hoverEvent((HoverEventSource)hoverEvent);
            bl = true;
        }
        return bl ? component.style(builder.build()) : component;
    }

    private static boolean a(Style.Builder builder, TextDecoration textDecoration, Boolean bl, boolean bl2) {
        if (bl == null && !bl2) {
            return false;
        }
        builder.decoration(textDecoration, Boolean.TRUE.equals(bl) ? TextDecoration.State.TRUE : TextDecoration.State.FALSE);
        return true;
    }

    private static TextColor a(ChatColor chatColor) {
        if (chatColor == null || chatColor.getColor() == null) {
            return null;
        }
        if (chatColor == ChatColor.BLACK) {
            return NamedTextColor.BLACK;
        }
        if (chatColor == ChatColor.DARK_BLUE) {
            return NamedTextColor.DARK_BLUE;
        }
        if (chatColor == ChatColor.DARK_GREEN) {
            return NamedTextColor.DARK_GREEN;
        }
        if (chatColor == ChatColor.DARK_AQUA) {
            return NamedTextColor.DARK_AQUA;
        }
        if (chatColor == ChatColor.DARK_RED) {
            return NamedTextColor.DARK_RED;
        }
        if (chatColor == ChatColor.DARK_PURPLE) {
            return NamedTextColor.DARK_PURPLE;
        }
        if (chatColor == ChatColor.GOLD) {
            return NamedTextColor.GOLD;
        }
        if (chatColor == ChatColor.GRAY) {
            return NamedTextColor.GRAY;
        }
        if (chatColor == ChatColor.DARK_GRAY) {
            return NamedTextColor.DARK_GRAY;
        }
        if (chatColor == ChatColor.BLUE) {
            return NamedTextColor.BLUE;
        }
        if (chatColor == ChatColor.GREEN) {
            return NamedTextColor.GREEN;
        }
        if (chatColor == ChatColor.AQUA) {
            return NamedTextColor.AQUA;
        }
        if (chatColor == ChatColor.RED) {
            return NamedTextColor.RED;
        }
        if (chatColor == ChatColor.LIGHT_PURPLE) {
            return NamedTextColor.LIGHT_PURPLE;
        }
        if (chatColor == ChatColor.YELLOW) {
            return NamedTextColor.YELLOW;
        }
        if (chatColor == ChatColor.WHITE) {
            return NamedTextColor.WHITE;
        }
        return TextColor.color((int)(chatColor.getColor().getRGB() & 0xFFFFFF));
    }

    private static net.kyori.adventure.text.event.ClickEvent a(ClickEvent clickEvent) {
        if (clickEvent == null) {
            return null;
        }
        String string = clickEvent.getValue();
        try {
            switch (clickEvent.getAction()) {
                case OPEN_URL: {
                    return string == null ? null : net.kyori.adventure.text.event.ClickEvent.openUrl((String)string);
                }
                case OPEN_FILE: {
                    return string == null ? null : net.kyori.adventure.text.event.ClickEvent.openFile((String)string);
                }
                case RUN_COMMAND: {
                    return string == null ? null : net.kyori.adventure.text.event.ClickEvent.runCommand((String)string);
                }
                case SUGGEST_COMMAND: {
                    return string == null ? null : net.kyori.adventure.text.event.ClickEvent.suggestCommand((String)string);
                }
                case CHANGE_PAGE: {
                    Integer n = BaseComponentHelper_2.gx(string);
                    return n == null ? null : net.kyori.adventure.text.event.ClickEvent.changePage((int)n);
                }
                case COPY_TO_CLIPBOARD: {
                    return string == null ? null : net.kyori.adventure.text.event.ClickEvent.copyToClipboard((String)string);
                }
            }
            return null;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }

    private static net.kyori.adventure.text.event.HoverEvent a(HoverEvent hoverEvent) {
        if (hoverEvent == null || hoverEvent.getContents() == null || hoverEvent.getContents().isEmpty()) {
            return null;
        }
        try {
            switch (hoverEvent.getAction()) {
                case SHOW_TEXT: {
                    return net.kyori.adventure.text.event.HoverEvent.showText((Component)BaseComponentHelper_2.O(hoverEvent.getContents()));
                }
                case SHOW_ITEM: {
                    Item item = (Item)BaseComponentHelper_2.a(hoverEvent.getContents(), Item.class);
                    return item == null ? null : BaseComponentHelper_2.a(item);
                }
                case SHOW_ENTITY: {
                    Entity entity = (Entity)BaseComponentHelper_2.a(hoverEvent.getContents(), Entity.class);
                    return entity == null ? null : BaseComponentHelper_2.a(entity);
                }
                case SHOW_ACHIEVEMENT: {
                    String string = BaseComponentHelper_2.P(hoverEvent.getContents());
                    return string == null ? null : net.kyori.adventure.text.event.HoverEvent.showAchievement((String)string);
                }
            }
            return null;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }

    private static Component O(List list) {
        ArrayList<Component> arrayList = new ArrayList<Component>(list.size());
        for (Object object : list) {
            Text text;
            Component component;
            if (!(object instanceof Text) || (component = BaseComponentHelper_2.E((text = (Text)object).getValue())).equals((Object)Component.empty())) continue;
            arrayList.add(component);
        }
        if (arrayList.isEmpty()) {
            return Component.empty();
        }
        if (arrayList.size() == 1) {
            return (Component)arrayList.get(0);
        }
        TextComponent.Builder builder = Component.text();
        for (Component component : arrayList) {
            builder.append(component);
        }
        return builder.build();
    }

    private static Component E(Object object) {
        if (object == null) {
            return Component.empty();
        }
        if (object instanceof BaseComponent[]) {
            BaseComponent[] baseComponentArray = (BaseComponent[])object;
            return BaseComponentHelper_2.a(baseComponentArray);
        }
        if (object instanceof BaseComponent) {
            BaseComponent baseComponent = (BaseComponent)object;
            return BaseComponentHelper_2.b(baseComponent);
        }
        return Component.text((String)String.valueOf(object));
    }

    private static net.kyori.adventure.text.event.HoverEvent a(Item item) {
        Key key = BaseComponentHelper_2.a(item.getId(), azr);
        int n = item.getCount() > 0 ? item.getCount() : 1;
        BinaryTagHolder binaryTagHolder = null;
        if (item.getTag() != null && item.getTag().getNbt() != null && !item.getTag().getNbt().isEmpty()) {
            binaryTagHolder = BinaryTagHolder.binaryTagHolder((String)item.getTag().getNbt());
        }
        return net.kyori.adventure.text.event.HoverEvent.showItem((Key)key, (int)n, binaryTagHolder);
    }

    private static net.kyori.adventure.text.event.HoverEvent a(Entity entity) {
        UUID uUID;
        if (entity.getId() == null || entity.getId().isEmpty()) {
            return null;
        }
        try {
            uUID = UUID.fromString(entity.getId());
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
        Key key = BaseComponentHelper_2.a(entity.getType(), azs);
        Component component = entity.getName() == null ? null : BaseComponentHelper_2.b(entity.getName());
        return net.kyori.adventure.text.event.HoverEvent.showEntity((Key)key, (UUID)uUID, (Component)component);
    }

    private static Content a(List list, Class clazz) {
        for (Content content : list) {
            if (!clazz.isInstance(content)) continue;
            return (Content)clazz.cast(content);
        }
        return null;
    }

    private static String P(List list) {
        for (Content content : list) {
            if (!(content instanceof Text)) continue;
            Text text = (Text)content;
            Object object = text.getValue();
            if (object instanceof BaseComponent[]) {
                BaseComponent[] baseComponentArray = (BaseComponent[])object;
                return BaseComponent.toPlainText((BaseComponent[])baseComponentArray);
            }
            if (object instanceof BaseComponent) {
                BaseComponent baseComponent = (BaseComponent)object;
                return baseComponent.toPlainText();
            }
            if (object == null) continue;
            return String.valueOf(object);
        }
        return null;
    }

    private static Integer gx(String string) {
        if (string == null) {
            return null;
        }
        try {
            int n = Integer.parseInt(string);
            return n > 0 ? Integer.valueOf(n) : null;
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    private static Key a(String string, Key key) {
        Key key2 = BaseComponentHelper_2.gy(string);
        return key2 == null ? key : key2;
    }

    private static Key gy(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        try {
            return Key.key((String)string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }

    private static String gu(String string) {
        return string == null ? "" : string;
    }
}
