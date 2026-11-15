package itemsadder.m;

import itemsadder.m.aei;
import itemsadder.m.aer;
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

class aes
implements ICommandListener {
    final /* synthetic */ CommandListenerWrapper aaK;

    aes(CommandListenerWrapper commandListenerWrapper) {
        this.aaK = commandListenerWrapper;
    }

    @bcg
    public void a(@NotNull IChatBaseComponent iChatBaseComponent) {
        aei aei2 = (aei)aer.aaI.getIfPresent(this);
        if (!aei2.gH) {
            this.aaK.c.a(iChatBaseComponent);
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
    public boolean y_() {
        return this.aaK.c.y_();
    }

    @bcg
    public boolean z_() {
        return this.aaK.c.z_();
    }

    @bcg
    public boolean c() {
        return this.aaK.c.c();
    }

    @bcg
    public CommandSender getBukkitSender(@NotNull CommandListenerWrapper commandListenerWrapper) {
        return this.aaK.c.getBukkitSender(commandListenerWrapper);
    }
}
