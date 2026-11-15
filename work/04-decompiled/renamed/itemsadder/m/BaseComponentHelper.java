package itemsadder.m;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.KeybindComponent;
import net.kyori.adventure.text.ScoreComponent;
import net.kyori.adventure.text.SelectorComponent;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.TranslatableComponent;
import net.kyori.adventure.text.TranslationArgument;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.ShadowColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Content;
import net.md_5.bungee.api.chat.hover.content.Entity;
import net.md_5.bungee.api.chat.hover.content.Text;

public final class BaseComponentHelper {
    private static final BaseComponent[] azo = new BaseComponent[0];

    private BaseComponentHelper() {
    }

    public static BaseComponent l(Component component) {
        if (component == null) {
            return new net.md_5.bungee.api.chat.TextComponent("");
        }
        return BaseComponentHelper.n(component);
    }

    public static BaseComponent[] m(Component component) {
        if (component == null) {
            return azo;
        }
        return new BaseComponent[]{BaseComponentHelper.n(component)};
    }

    public static BaseComponent[] e(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return azo;
        }
        ArrayList<BaseComponent> arrayList = new ArrayList<BaseComponent>(collection.size());
        for (Component component : collection) {
            if (component == null) continue;
            arrayList.add(BaseComponentHelper.n(component));
        }
        if (arrayList.isEmpty()) {
            return azo;
        }
        return arrayList.toArray(new BaseComponent[arrayList.size()]);
    }

    private static BaseComponent n(Component component) {
        BaseComponent baseComponent = BaseComponentHelper.o(component);
        BaseComponentHelper.a(baseComponent, component.style());
        BaseComponentHelper.a(baseComponent, component.children());
        return baseComponent;
    }

    private static BaseComponent o(Component component) {
        if (component instanceof TextComponent) {
            TextComponent textComponent = (TextComponent)component;
            return new net.md_5.bungee.api.chat.TextComponent(BaseComponentHelper.gu(textComponent.content()));
        }
        if (component instanceof TranslatableComponent) {
            TranslatableComponent translatableComponent = (TranslatableComponent)component;
            return BaseComponentHelper.a(translatableComponent);
        }
        if (component instanceof KeybindComponent) {
            KeybindComponent keybindComponent = (KeybindComponent)component;
            return new net.md_5.bungee.api.chat.KeybindComponent(BaseComponentHelper.gu(keybindComponent.keybind()));
        }
        if (component instanceof ScoreComponent) {
            ScoreComponent scoreComponent = (ScoreComponent)component;
            net.md_5.bungee.api.chat.ScoreComponent scoreComponent2 = new net.md_5.bungee.api.chat.ScoreComponent(BaseComponentHelper.gu(scoreComponent.name()), BaseComponentHelper.gu(scoreComponent.objective()));
            String string = scoreComponent.value();
            if (string != null && !string.isEmpty()) {
                scoreComponent2.setValue(string);
            }
            return scoreComponent2;
        }
        if (component instanceof SelectorComponent) {
            SelectorComponent selectorComponent = (SelectorComponent)component;
            net.md_5.bungee.api.chat.SelectorComponent selectorComponent2 = new net.md_5.bungee.api.chat.SelectorComponent(BaseComponentHelper.gu(selectorComponent.pattern()));
            Component component2 = selectorComponent.separator();
            if (component2 != null) {
                selectorComponent2.setSeparator(BaseComponentHelper.n(component2));
            }
            return selectorComponent2;
        }
        return new net.md_5.bungee.api.chat.TextComponent("");
    }

    private static BaseComponent a(TranslatableComponent translatableComponent) {
        List list;
        net.md_5.bungee.api.chat.TranslatableComponent translatableComponent2 = new net.md_5.bungee.api.chat.TranslatableComponent(BaseComponentHelper.gu(translatableComponent.key()), new Object[0]);
        String string = translatableComponent.fallback();
        if (string != null) {
            translatableComponent2.setFallback(string);
        }
        if ((list = translatableComponent.arguments()) != null && !list.isEmpty()) {
            ArrayList<BaseComponent> arrayList = new ArrayList<BaseComponent>(list.size());
            for (TranslationArgument translationArgument : list) {
                arrayList.add(BaseComponentHelper.a(translationArgument));
            }
            translatableComponent2.setWith(arrayList);
        }
        return translatableComponent2;
    }

    private static BaseComponent a(TranslationArgument translationArgument) {
        if (translationArgument == null || translationArgument.value() == null) {
            return new net.md_5.bungee.api.chat.TextComponent("");
        }
        Object object = translationArgument.value();
        if (object instanceof ComponentLike) {
            ComponentLike componentLike = (ComponentLike)object;
            return BaseComponentHelper.n(componentLike.asComponent());
        }
        return new net.md_5.bungee.api.chat.TextComponent(String.valueOf(object));
    }

    private static void a(BaseComponent baseComponent, Style style) {
        HoverEvent hoverEvent;
        ClickEvent clickEvent;
        ChatColor chatColor;
        if (style == null || style.isEmpty()) {
            return;
        }
        TextColor textColor = style.color();
        if (textColor != null && (chatColor = BaseComponentHelper.a(textColor)) != null) {
            baseComponent.setColor(chatColor);
        }
        BaseComponentHelper.a(baseComponent, TextDecoration.BOLD, style.decoration(TextDecoration.BOLD));
        BaseComponentHelper.a(baseComponent, TextDecoration.ITALIC, style.decoration(TextDecoration.ITALIC));
        BaseComponentHelper.a(baseComponent, TextDecoration.UNDERLINED, style.decoration(TextDecoration.UNDERLINED));
        BaseComponentHelper.a(baseComponent, TextDecoration.STRIKETHROUGH, style.decoration(TextDecoration.STRIKETHROUGH));
        BaseComponentHelper.a(baseComponent, TextDecoration.OBFUSCATED, style.decoration(TextDecoration.OBFUSCATED));
        chatColor = style.font();
        if (chatColor != null) {
            baseComponent.setFont(chatColor.asString());
        }
        ShadowColor shadowColor = style.shadowColor();
        String string = style.insertion();
        if (string != null) {
            baseComponent.setInsertion(string);
        }
        if ((clickEvent = BaseComponentHelper.a(style.clickEvent())) != null) {
            baseComponent.setClickEvent(clickEvent);
        }
        if ((hoverEvent = BaseComponentHelper.a(style.hoverEvent())) != null) {
            baseComponent.setHoverEvent(hoverEvent);
        }
    }

    private static void a(BaseComponent baseComponent, TextDecoration textDecoration, TextDecoration.State state) {
        if (state == null || state == TextDecoration.State.NOT_SET) {
            return;
        }
        boolean bl = state == TextDecoration.State.TRUE;
        switch (textDecoration) {
            case BOLD: {
                baseComponent.setBold(Boolean.valueOf(bl));
                break;
            }
            case ITALIC: {
                baseComponent.setItalic(Boolean.valueOf(bl));
                break;
            }
            case UNDERLINED: {
                baseComponent.setUnderlined(Boolean.valueOf(bl));
                break;
            }
            case STRIKETHROUGH: {
                baseComponent.setStrikethrough(Boolean.valueOf(bl));
                break;
            }
            case OBFUSCATED: {
                baseComponent.setObfuscated(Boolean.valueOf(bl));
            }
        }
    }

    private static void a(BaseComponent baseComponent, List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Component component : list) {
            if (component == null) continue;
            baseComponent.addExtra(BaseComponentHelper.n(component));
        }
    }

    private static ChatColor a(TextColor textColor) {
        int n = textColor.value() & 0xFFFFFF;
        ChatColor chatColor = BaseComponentHelper.by(n);
        if (chatColor != null) {
            return chatColor;
        }
        try {
            return ChatColor.of((String)BaseComponentHelper.bz(n));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }

    private static ChatColor by(int n) {
        switch (n) {
            case 0: {
                return ChatColor.BLACK;
            }
            case 170: {
                return ChatColor.DARK_BLUE;
            }
            case 43520: {
                return ChatColor.DARK_GREEN;
            }
            case 43690: {
                return ChatColor.DARK_AQUA;
            }
            case 0xAA0000: {
                return ChatColor.DARK_RED;
            }
            case 0xAA00AA: {
                return ChatColor.DARK_PURPLE;
            }
            case 0xFFAA00: {
                return ChatColor.GOLD;
            }
            case 0xAAAAAA: {
                return ChatColor.GRAY;
            }
            case 0x555555: {
                return ChatColor.DARK_GRAY;
            }
            case 0x5555FF: {
                return ChatColor.BLUE;
            }
            case 0x55FF55: {
                return ChatColor.GREEN;
            }
            case 0x55FFFF: {
                return ChatColor.AQUA;
            }
            case 0xFF5555: {
                return ChatColor.RED;
            }
            case 0xFF55FF: {
                return ChatColor.LIGHT_PURPLE;
            }
            case 0xFFFF55: {
                return ChatColor.YELLOW;
            }
            case 0xFFFFFF: {
                return ChatColor.WHITE;
            }
        }
        return null;
    }

    private static ClickEvent a(net.kyori.adventure.text.event.ClickEvent clickEvent) {
        if (clickEvent == null) {
            return null;
        }
        ClickEvent.Action action = clickEvent.action();
        ClickEvent.Payload payload = clickEvent.payload();
        if (action == ClickEvent.Action.OPEN_URL) {
            return BaseComponentHelper.a(ClickEvent.Action.OPEN_URL, payload);
        }
        if (action == ClickEvent.Action.OPEN_FILE) {
            return BaseComponentHelper.a(ClickEvent.Action.OPEN_FILE, payload);
        }
        if (action == ClickEvent.Action.RUN_COMMAND) {
            return BaseComponentHelper.a(ClickEvent.Action.RUN_COMMAND, payload);
        }
        if (action == ClickEvent.Action.SUGGEST_COMMAND) {
            return BaseComponentHelper.a(ClickEvent.Action.SUGGEST_COMMAND, payload);
        }
        if (action == ClickEvent.Action.COPY_TO_CLIPBOARD) {
            return BaseComponentHelper.a(ClickEvent.Action.COPY_TO_CLIPBOARD, payload);
        }
        if (action == ClickEvent.Action.CHANGE_PAGE) {
            if (!(payload instanceof ClickEvent.Payload.Int)) {
                return null;
            }
            ClickEvent.Payload.Int intVal = (ClickEvent.Payload.Int)payload;
            return new ClickEvent(ClickEvent.Action.CHANGE_PAGE, Integer.toString(intVal.integer()));
        }
        return null;
    }

    private static ClickEvent a(ClickEvent.Action action, ClickEvent.Payload payload) {
        if (!(payload instanceof ClickEvent.Payload.Text)) {
            return null;
        }
        ClickEvent.Payload.Text text = (ClickEvent.Payload.Text)payload;
        return new ClickEvent(action, text.value());
    }

    private static HoverEvent a(net.kyori.adventure.text.event.HoverEvent hoverEvent) {
        if (hoverEvent == null) {
            return null;
        }
        HoverEvent.Action action = hoverEvent.action();
        Object object = hoverEvent.value();
        if (action == HoverEvent.Action.SHOW_TEXT) {
            return BaseComponentHelper.D(object);
        }
        if (action == HoverEvent.Action.SHOW_ENTITY && object instanceof HoverEvent.ShowEntity) {
            HoverEvent.ShowEntity showEntity = (HoverEvent.ShowEntity)object;
            return BaseComponentHelper.a(showEntity);
        }
        return null;
    }

    private static HoverEvent D(Object object) {
        BaseComponent baseComponent;
        if (object instanceof ComponentLike) {
            ComponentLike componentLike = (ComponentLike)object;
            baseComponent = BaseComponentHelper.n(componentLike.asComponent());
        } else {
            baseComponent = new net.md_5.bungee.api.chat.TextComponent(object == null ? "" : String.valueOf(object));
        }
        return new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Content[]{new Text(new BaseComponent[]{baseComponent})});
    }

    private static HoverEvent a(HoverEvent.ShowEntity showEntity) {
        Component component = showEntity.name();
        return new HoverEvent(HoverEvent.Action.SHOW_ENTITY, new Content[]{new Entity(showEntity.type().asString(), showEntity.id().toString(), component == null ? null : BaseComponentHelper.n(component))});
    }

    private static String bz(int n) {
        String string = Integer.toHexString(n & 0xFFFFFF);
        return "#000000".substring(0, 7 - string.length()) + string;
    }

    private static String gu(String string) {
        return string == null ? "" : string;
    }
}
