package itemsadder.m;

import itemsadder.m.BlockNms_1_21_10_6;
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

class CommandListenerWrapperBridge_3
implements ICommandListener {
    final /* synthetic */ CommandListenerWrapper aaE;

    CommandListenerWrapperBridge_3(CommandListenerWrapper commandListenerWrapper) {
        this.aaE = commandListenerWrapper;
    }

    @PluginContract_4
    public void a(@NotNull IChatBaseComponent iChatBaseComponent) {
        StringBoolBooleanData stringBoolBooleanData = (StringBoolBooleanData)BlockNms_1_21_10_6.aaC.getIfPresent(this);
        if (!stringBoolBooleanData.gH) {
            this.aaE.d.a(iChatBaseComponent);
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
    public boolean z_() {
        return this.aaE.d.z_();
    }

    @PluginContract_4
    public boolean A_() {
        return this.aaE.d.A_();
    }

    @PluginContract_4
    public boolean c() {
        return this.aaE.d.c();
    }

    @PluginContract_4
    public CommandSender getBukkitSender(@NotNull CommandListenerWrapper commandListenerWrapper) {
        return this.aaE.d.getBukkitSender(commandListenerWrapper);
    }
}
