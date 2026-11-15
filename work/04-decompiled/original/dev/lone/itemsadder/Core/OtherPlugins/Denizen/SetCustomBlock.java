package dev.lone.itemsadder.Core.OtherPlugins.Denizen;

import com.denizenscript.denizen.objects.LocationTag;
import com.denizenscript.denizen.objects.MaterialTag;
import com.denizenscript.denizencore.exceptions.InvalidArgumentsException;
import com.denizenscript.denizencore.exceptions.InvalidArgumentsRuntimeException;
import com.denizenscript.denizencore.objects.Argument;
import com.denizenscript.denizencore.objects.core.ElementTag;
import com.denizenscript.denizencore.objects.core.ListTag;
import com.denizenscript.denizencore.objects.properties.PropertyParser;
import com.denizenscript.denizencore.scripts.ScriptEntry;
import com.denizenscript.denizencore.scripts.commands.AbstractCommand;
import com.denizenscript.denizencore.utilities.debugging.Debug;
import com.denizenscript.denizencore.utilities.debugging.Debuggable;
import itemsadder.m.d;
import itemsadder.m.ql;
import java.util.List;
import org.bukkit.block.Block;

public class SetCustomBlock
extends AbstractCommand {
    public SetCustomBlock() {
        this.setName("set_custom_block");
        this.setSyntax("set_custom_block [<location>|...] [<namespaced_id>]");
        this.setRequiredArguments(1, 2);
        this.isProcedural = false;
        this.allowedDynamicPrefixes = true;
    }

    public void addCustomTabCompletions(AbstractCommand.TabCompletionsBuilder tabCompletionsBuilder) {
        tabCompletionsBuilder.add(((PropertyParser.ClassPropertiesInfo)PropertyParser.propertiesByClass.get(MaterialTag.class)).propertiesByMechanism.keySet());
    }

    public void parseArgs(ScriptEntry scriptEntry) {
        for (Argument argument : scriptEntry) {
            if (!scriptEntry.hasObject("locations") && argument.matchesArgumentList(LocationTag.class)) {
                scriptEntry.addObject("locations", (Object)((ListTag)argument.asType(ListTag.class)).filter(LocationTag.class, scriptEntry));
                continue;
            }
            if (!scriptEntry.hasObject("namespaced_id")) {
                scriptEntry.addObject("namespaced_id", (Object)new ElementTag(argument.getRawValue()));
                continue;
            }
            argument.reportUnhandled();
        }
        if (!scriptEntry.hasObject("locations")) {
            throw new InvalidArgumentsException("You must specify a location!");
        }
        if (!scriptEntry.hasObject("namespaced_id")) {
            throw new InvalidArgumentsException("You must specify a namespaced_id!");
        }
    }

    public void execute(ScriptEntry scriptEntry) {
        ql ql2;
        ElementTag elementTag = scriptEntry.getElement("namespaced_id");
        List list = (List)scriptEntry.getObject("locations");
        if (scriptEntry.dbCallShouldDebug()) {
            Debug.report((Debuggable)scriptEntry, (String)this.getName(), (Object[])new Object[]{SetCustomBlock.db((String)"locations", (Object)list), elementTag});
        }
        if ((ql2 = d.g().h(elementTag.asString())) == null) {
            throw new InvalidArgumentsRuntimeException("Not a custom ItemAdder block: " + elementTag.asString());
        }
        for (LocationTag locationTag : list) {
            Block block = locationTag.getBlock();
            ql2.as(block);
        }
    }
}
