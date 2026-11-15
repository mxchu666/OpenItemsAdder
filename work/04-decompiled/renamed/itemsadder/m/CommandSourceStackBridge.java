package itemsadder.m;

import itemsadder.m.BlockNms_26_1_1_6;
import itemsadder.m.PluginContract_4;
import itemsadder.m.StringBoolBooleanData;
import java.lang.invoke.MethodType;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

class CommandSourceStackBridge
implements CommandSource {
    final /* synthetic */ CommandSourceStack abc;

    CommandSourceStackBridge(CommandSourceStack commandSourceStack) {
        this.abc = commandSourceStack;
    }

    @PluginContract_4
    public void sendSystemMessage(@NotNull Component component) {
        StringBoolBooleanData stringBoolBooleanData = (StringBoolBooleanData)BlockNms_26_1_1_6.aba.getIfPresent(this);
        if (!stringBoolBooleanData.gH) {
            this.abc.source.sendSystemMessage(component);
        }
        stringBoolBooleanData.aau = component.toString();
        StackWalker stackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        for (StackWalker.StackFrame stackFrame : stackWalker.walk(Stream::toList)) {
            List<Class<?>> list;
            MethodType methodType;
            if ((stackFrame.getMethodName().equals("a") || stackFrame.getMethodName().equals("sendSuccess")) && (methodType = stackFrame.getMethodType()).returnType().equals(Void.TYPE) && methodType.parameterCount() == 2 && (list = methodType.parameterList()).get(0).equals(Supplier.class) && list.get(1).equals(Boolean.TYPE)) {
                stringBoolBooleanData.aav = true;
                return;
            }
            if (!stackFrame.getMethodName().equals("b") && !stackFrame.getMethodName().equals("sendFailure") || !(methodType = stackFrame.getMethodType()).returnType().equals(Void.TYPE)) continue;
            if (methodType.parameterCount() == 1) {
                list = methodType.parameterList();
                if (!list.get(0).equals(Component.class)) continue;
                stringBoolBooleanData.aav = false;
                return;
            }
            if (methodType.parameterCount() != 2 || !(list = methodType.parameterList()).get(0).equals(Component.class) || !list.get(1).equals(Boolean.TYPE)) continue;
            stringBoolBooleanData.aav = false;
            return;
        }
        stringBoolBooleanData.aav = null;
    }

    @PluginContract_4
    public boolean acceptsSuccess() {
        return this.abc.source.acceptsSuccess();
    }

    @PluginContract_4
    public boolean acceptsFailure() {
        return this.abc.source.acceptsFailure();
    }

    @PluginContract_4
    public boolean shouldInformAdmins() {
        return this.abc.source.shouldInformAdmins();
    }

    @PluginContract_4
    public CommandSender getBukkitSender(@NotNull CommandSourceStack commandSourceStack) {
        return this.abc.source.getBukkitSender(commandSourceStack);
    }
}
