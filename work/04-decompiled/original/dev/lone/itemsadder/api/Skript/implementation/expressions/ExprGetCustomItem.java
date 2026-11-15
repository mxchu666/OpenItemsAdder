package dev.lone.itemsadder.api.Skript.implementation.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.aliases.ItemType;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.expressions.base.PropertyExpression;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import itemsadder.m.d;
import itemsadder.m.qm;
import javax.annotation.Nullable;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Name(value="ItemsAdderItem")
@Description(value={"Get an ItemsAdder item by NamespacedID"})
@Examples(value={"give player a customitem itemsadder:ruby", "set slot 1 of inventory of player to customitem ruby"})
public class ExprGetCustomItem
extends PropertyExpression {
    private Expression itemName;

    public boolean init(Expression[] expressionArray, int n, @NotNull Kleenean kleenean, @NotNull SkriptParser.ParseResult parseResult) {
        this.setExpr(expressionArray[0]);
        this.itemName = expressionArray[0];
        return true;
    }

    @NotNull
    protected ItemType[] get(@NotNull Event event, @NotNull String[] stringArray) {
        String string = (String)this.itemName.getSingle(event);
        qm qm2 = d.g().e(string);
        if (qm2 == null) {
            return null;
        }
        qm2 = qm2.clone();
        ItemType itemType = new ItemType((ItemStack)qm2);
        return new ItemType[]{itemType};
    }

    @NotNull
    public Class getReturnType() {
        return ItemType.class;
    }

    @NotNull
    public String toString(@Nullable Event event, boolean bl) {
        return "customitem" + (String)this.itemName.getSingle(event);
    }

    static {
        Skript.registerExpression(ExprGetCustomItem.class, ItemType.class, (ExpressionType)ExpressionType.SIMPLE, (String[])new String[]{"customitem %string%"});
    }
}
