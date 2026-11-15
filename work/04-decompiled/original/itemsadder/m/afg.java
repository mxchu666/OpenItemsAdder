package itemsadder.m;

import itemsadder.m.aei;
import itemsadder.m.aff;
import itemsadder.m.bcg;
import java.lang.invoke.MethodType;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

class afg
implements CommandSource {
    final /* synthetic */ CommandSourceStack abf;

    afg(CommandSourceStack commandSourceStack) {
        this.abf = commandSourceStack;
    }

    @bcg
    public void sendSystemMessage(@NotNull Component component) {
        aei aei2 = (aei)aff.abd.getIfPresent(this);
        if (!aei2.gH) {
            this.abf.source.sendSystemMessage(component);
        }
        aei2.aau = component.toString();
        StackWalker stackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        for (StackWalker.StackFrame stackFrame : stackWalker.walk(Stream::toList)) {
            List<Class<?>> list;
            MethodType methodType;
            if ((stackFrame.getMethodName().equals("a") || stackFrame.getMethodName().equals("sendSuccess")) && (methodType = stackFrame.getMethodType()).returnType().equals(Void.TYPE) && methodType.parameterCount() == 2 && (list = methodType.parameterList()).get(0).equals(Supplier.class) && list.get(1).equals(Boolean.TYPE)) {
                aei2.aav = true;
                return;
            }
            if (!stackFrame.getMethodName().equals("b") && !stackFrame.getMethodName().equals("sendFailure") || !(methodType = stackFrame.getMethodType()).returnType().equals(Void.TYPE)) continue;
            if (methodType.parameterCount() == 1) {
                list = methodType.parameterList();
                if (!list.get(0).equals(Component.class)) continue;
                aei2.aav = false;
                return;
            }
            if (methodType.parameterCount() != 2 || !(list = methodType.parameterList()).get(0).equals(Component.class) || !list.get(1).equals(Boolean.TYPE)) continue;
            aei2.aav = false;
            return;
        }
        aei2.aav = null;
    }

    @bcg
    public boolean acceptsSuccess() {
        return this.abf.source.acceptsSuccess();
    }

    @bcg
    public boolean acceptsFailure() {
        return this.abf.source.acceptsFailure();
    }

    @bcg
    public boolean shouldInformAdmins() {
        return this.abf.source.shouldInformAdmins();
    }

    @bcg
    public CommandSender getBukkitSender(@NotNull CommandSourceStack commandSourceStack) {
        return this.abf.source.getBukkitSender(commandSourceStack);
    }
}
