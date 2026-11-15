package dev.lone.itemsadder.api.Skript.implementation.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import dev.lone.itemsadder.api.FontImages.FontImageWrapper;
import javax.annotation.Nullable;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

public class ExprGetFontImage
extends SimpleExpression {
    private Expression fontImageName;

    @NotNull
    public Class getReturnType() {
        return String.class;
    }

    public boolean isSingle() {
        return true;
    }

    public boolean init(Expression[] expressionArray, int n, @NotNull Kleenean kleenean, @NotNull SkriptParser.ParseResult parseResult) {
        this.fontImageName = expressionArray[0];
        return true;
    }

    @NotNull
    public String toString(@Nullable Event event, boolean bl) {
        return "fontimage " + this.fontImageName.toString(event, bl);
    }

    @Nullable
    protected String[] get(@NotNull Event event) {
        String string = (String)this.fontImageName.getSingle(event);
        FontImageWrapper fontImageWrapper = new FontImageWrapper(string);
        if (!fontImageWrapper.exists()) {
            return null;
        }
        return new String[]{fontImageWrapper.getString()};
    }

    static {
        Skript.registerExpression(ExprGetFontImage.class, String.class, (ExpressionType)ExpressionType.PROPERTY, (String[])new String[]{"fontimage %string%"});
    }
}
