package itemsadder.m;

import itemsadder.m.aei;
import itemsadder.m.aej;
import itemsadder.m.bcg;
import java.lang.invoke.MethodType;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.minecraft.commands.CommandListenerWrapper;
import net.minecraft.commands.ICommandListener;
import net.minecraft.network.chat.IChatBaseComponent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

class aek
implements ICommandListener {
    final /* synthetic */ CommandListenerWrapper aay;

    aek(CommandListenerWrapper commandListenerWrapper) {
        this.aay = commandListenerWrapper;
    }

    @bcg
    public void a(@NotNull IChatBaseComponent iChatBaseComponent) {
        aei aei2 = (aei)aej.aaw.getIfPresent(this);
        if (!aei2.gH) {
            this.aay.c.a(iChatBaseComponent);
        }
        aei2.aau = iChatBaseComponent.toString();
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
                if (!list.get(0).equals(IChatBaseComponent.class)) continue;
                aei2.aav = false;
                return;
            }
            if (methodType.parameterCount() != 2 || !(list = methodType.parameterList()).get(0).equals(IChatBaseComponent.class) || !list.get(1).equals(Boolean.TYPE)) continue;
            aei2.aav = false;
            return;
        }
        aei2.aav = null;
    }

    @bcg
    public boolean l_() {
        return this.aay.c.l_();
    }

    @bcg
    public boolean w_() {
        return this.aay.c.w_();
    }

    @bcg
    public boolean U_() {
        return this.aay.c.U_();
    }

    @bcg
    @NotNull
    public CommandSender getBukkitSender(CommandListenerWrapper commandListenerWrapper) {
        return this.aay.c.getBukkitSender(commandListenerWrapper);
    }
}
