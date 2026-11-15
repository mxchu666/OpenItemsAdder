package dev.lone.itemsadder.api.Skript.implementation.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.aliases.ItemType;
import ch.njol.skript.doc.Name;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import itemsadder.m.qm;
import javax.annotation.Nullable;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

@Name(value="Is a customitem")
public class ExprIsCustomItem
extends Condition {
    Expression itemType;

    public boolean init(Expression[] expressionArray, int n, @NotNull Kleenean kleenean, @NotNull SkriptParser.ParseResult parseResult) {
        this.itemType = expressionArray[0];
        this.setNegated(n < 1);
        return true;
    }

    @NotNull
    public String toString(@Nullable Event event, boolean bl) {
        return "Entity is customitem " + this.itemType.toString(event, bl);
    }

    public boolean check(@NotNull Event event) {
        ItemType itemType = (ItemType)this.itemType.getSingle(event);
        if (itemType == null) {
            return this.isNegated();
        }
        return qm.isCustomItem(itemType.getRandom()) == this.isNegated();
    }

    static {
        Skript.registerCondition(ExprIsCustomItem.class, (String[])new String[]{"%itemtypes% (is|are) [(a|the) ](c|C)ustom[ ](i|I)tem"});
    }
}
