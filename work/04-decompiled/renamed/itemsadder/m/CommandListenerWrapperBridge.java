package itemsadder.m;

import itemsadder.m.BlockNms_1_20_6_6;
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

class CommandListenerWrapperBridge
implements ICommandListener {
    final /* synthetic */ CommandListenerWrapper aay;

    CommandListenerWrapperBridge(CommandListenerWrapper commandListenerWrapper) {
        this.aay = commandListenerWrapper;
    }

    @PluginContract_4
    public void a(@NotNull IChatBaseComponent iChatBaseComponent) {
        StringBoolBooleanData stringBoolBooleanData = (StringBoolBooleanData)BlockNms_1_20_6_6.aaw.getIfPresent(this);
        if (!stringBoolBooleanData.gH) {
            this.aay.c.a(iChatBaseComponent);
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
    public boolean l_() {
        return this.aay.c.l_();
    }

    @PluginContract_4
    public boolean w_() {
        return this.aay.c.w_();
    }

    @PluginContract_4
    public boolean U_() {
        return this.aay.c.U_();
    }

    @PluginContract_4
    @NotNull
    public CommandSender getBukkitSender(CommandListenerWrapper commandListenerWrapper) {
        return this.aay.c.getBukkitSender(commandListenerWrapper);
    }
}
