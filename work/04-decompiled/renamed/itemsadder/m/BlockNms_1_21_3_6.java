package itemsadder.m;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import itemsadder.m.CommandListenerWrapperBridge_5;
import itemsadder.m.IFunction;
import itemsadder.m.StringBoolBooleanData;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import net.minecraft.commands.CommandListenerWrapper;
import net.minecraft.commands.ICommandListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_21_R2.CraftServer;
import org.bukkit.craftbukkit.v1_21_R2.command.ProxiedNativeCommandSender;

public class BlockNms_1_21_3_6
extends ProxiedNativeCommandSender
implements IFunction {
    private static final Cache aaI = CacheBuilder.newBuilder().expireAfterWrite(1L, TimeUnit.MINUTES).build();

    public BlockNms_1_21_3_6() {
        this(((CraftServer)Bukkit.getConsoleSender().getServer()).getServer().aH(), (CommandSender)Bukkit.getConsoleSender(), (CommandSender)Bukkit.getConsoleSender());
    }

    public BlockNms_1_21_3_6(CommandListenerWrapper commandListenerWrapper, CommandSender commandSender, CommandSender commandSender2) {
        super(commandListenerWrapper.a((ICommandListener)new CommandListenerWrapperBridge_5(commandListenerWrapper)), commandSender, commandSender2);
    }

    @Override
    public StringBoolBooleanData i(String string, boolean bl) {
        StringBoolBooleanData stringBoolBooleanData = new StringBoolBooleanData();
        aaI.put(this.getHandle().c, stringBoolBooleanData);
        stringBoolBooleanData.gH = bl;
        Bukkit.dispatchCommand((CommandSender)this, (String)string);
        return (StringBoolBooleanData)aaI.getIfPresent(this.getHandle().c);
    }

    public void dC(String string) {
        StringBoolBooleanData stringBoolBooleanData = (StringBoolBooleanData)aaI.getIfPresent(this.getHandle().c);
        assert (stringBoolBooleanData != null);
        stringBoolBooleanData.aau = string;
        if (!stringBoolBooleanData.gH) {
            super.sendMessage(string);
        }
    }

    public void h(String ... stringArray) {
        StringBoolBooleanData stringBoolBooleanData = (StringBoolBooleanData)aaI.getIfPresent(this.getHandle().c);
        assert (stringBoolBooleanData != null);
        stringBoolBooleanData.aau = String.join((CharSequence)" ", stringArray);
        if (!stringBoolBooleanData.gH) {
            super.sendMessage(stringArray);
        }
    }

    public void d(UUID uUID, String string) {
        StringBoolBooleanData stringBoolBooleanData = (StringBoolBooleanData)aaI.getIfPresent(this.getHandle().c);
        assert (stringBoolBooleanData != null);
        stringBoolBooleanData.aau = string;
        if (!stringBoolBooleanData.gH) {
            super.sendMessage(uUID, string);
        }
    }

    public void a(UUID uUID, String ... stringArray) {
        StringBoolBooleanData stringBoolBooleanData = (StringBoolBooleanData)aaI.getIfPresent(this.getHandle().c);
        assert (stringBoolBooleanData != null);
        stringBoolBooleanData.aau = String.join((CharSequence)" ", stringArray);
        if (!stringBoolBooleanData.gH) {
            super.sendMessage(uUID, stringArray);
        }
    }
}
