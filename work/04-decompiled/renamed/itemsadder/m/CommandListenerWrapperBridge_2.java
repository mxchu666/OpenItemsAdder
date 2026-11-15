package itemsadder.m;

import itemsadder.m.BlockNms_1_21_1_6;
import itemsadder.m.PluginContract_4;
import itemsadder.m.StringBoolBooleanData;
import java.lang.invoke.MethodType;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.minecraft.commands.CommandListenerWrapper;
import net.minecraft.commands.ICommandListener;
import net.minecraft.network.chat.IChatBaseComponent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

class CommandListenerWrapperBridge_2
implements ICommandListener {
    final /* synthetic */ CommandListenerWrapper aaB;

    CommandListenerWrapperBridge_2(CommandListenerWrapper commandListenerWrapper) {
        this.aaB = commandListenerWrapper;
    }

    @PluginContract_4
    public void a(@NotNull IChatBaseComponent iChatBaseComponent) {
        StringBoolBooleanData stringBoolBooleanData = (StringBoolBooleanData)BlockNms_1_21_1_6.aaz.getIfPresent(this);
        if (!stringBoolBooleanData.gH) {
            this.aaB.c.a(iChatBaseComponent);
        }
        stringBoolBooleanData.aau = iChatBaseComponent.toString();
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
                if (!list.get(0).equals(IChatBaseComponent.class)) continue;
                stringBoolBooleanData.aav = false;
                return;
            }
            if (methodType.parameterCount() != 2 || !(list = methodType.parameterList()).get(0).equals(IChatBaseComponent.class) || !list.get(1).equals(Boolean.TYPE)) continue;
            stringBoolBooleanData.aav = false;
            return;
        }
        stringBoolBooleanData.aav = null;
    }

    @PluginContract_4
    public boolean k_() {
        return this.aaB.c.k_();
    }

    @PluginContract_4
    public boolean w_() {
        return this.aaB.c.w_();
    }

    @PluginContract_4
    public boolean M_() {
        return this.aaB.c.M_();
    }

    @PluginContract_4
    public CommandSender getBukkitSender(@NotNull CommandListenerWrapper commandListenerWrapper) {
        return this.aaB.c.getBukkitSender(commandListenerWrapper);
    }
}
