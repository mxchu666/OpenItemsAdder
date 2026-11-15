package itemsadder.m;

import itemsadder.m.aei;
import itemsadder.m.ael;
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

class aem
implements ICommandListener {
    final /* synthetic */ CommandListenerWrapper aaB;

    aem(CommandListenerWrapper commandListenerWrapper) {
        this.aaB = commandListenerWrapper;
    }

    @bcg
    public void a(@NotNull IChatBaseComponent iChatBaseComponent) {
        aei aei2 = (aei)ael.aaz.getIfPresent(this);
        if (!aei2.gH) {
            this.aaB.c.a(iChatBaseComponent);
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
    public boolean k_() {
        return this.aaB.c.k_();
    }

    @bcg
    public boolean w_() {
        return this.aaB.c.w_();
    }

    @bcg
    public boolean M_() {
        return this.aaB.c.M_();
    }

    @bcg
    public CommandSender getBukkitSender(@NotNull CommandListenerWrapper commandListenerWrapper) {
        return this.aaB.c.getBukkitSender(commandListenerWrapper);
    }
}
