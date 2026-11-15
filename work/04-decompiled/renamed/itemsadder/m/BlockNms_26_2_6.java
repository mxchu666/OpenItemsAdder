package itemsadder.m;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import itemsadder.m.CommandSourceStackBridge_3;
import itemsadder.m.IFunction;
import itemsadder.m.StringBoolBooleanData;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.command.ProxiedNativeCommandSender;

public class BlockNms_26_2_6
extends ProxiedNativeCommandSender
implements IFunction {
    private static final Cache abg = CacheBuilder.newBuilder().expireAfterWrite(1L, TimeUnit.MINUTES).build();

    public BlockNms_26_2_6() {
        this(((CraftServer)Bukkit.getConsoleSender().getServer()).getServer().createCommandSourceStack(), (CommandSender)Bukkit.getConsoleSender(), (CommandSender)Bukkit.getConsoleSender());
    }

    public BlockNms_26_2_6(CommandSourceStack commandSourceStack, CommandSender commandSender, CommandSender commandSender2) {
        super(commandSourceStack.withSource((CommandSource)new CommandSourceStackBridge_3(commandSourceStack)), commandSender, commandSender2);
    }

    @Override
    public StringBoolBooleanData i(String string, boolean bl) {
        StringBoolBooleanData stringBoolBooleanData = new StringBoolBooleanData();
        abg.put(this.getHandle().source, stringBoolBooleanData);
        stringBoolBooleanData.gH = bl;
        Bukkit.dispatchCommand((CommandSender)this, (String)string);
        return (StringBoolBooleanData)abg.getIfPresent(this.getHandle().source);
    }

    public void dC(String string) {
        StringBoolBooleanData stringBoolBooleanData = (StringBoolBooleanData)abg.getIfPresent(this.getHandle().source);
        assert (stringBoolBooleanData != null);
        stringBoolBooleanData.aau = string;
        if (!stringBoolBooleanData.gH) {
            super.sendMessage(string);
        }
    }

    public void h(String ... stringArray) {
        StringBoolBooleanData stringBoolBooleanData = (StringBoolBooleanData)abg.getIfPresent(this.getHandle().source);
        assert (stringBoolBooleanData != null);
        stringBoolBooleanData.aau = String.join((CharSequence)" ", stringArray);
        if (!stringBoolBooleanData.gH) {
            super.sendMessage(stringArray);
        }
    }

    public void d(UUID uUID, String string) {
        StringBoolBooleanData stringBoolBooleanData = (StringBoolBooleanData)abg.getIfPresent(this.getHandle().source);
        assert (stringBoolBooleanData != null);
        stringBoolBooleanData.aau = string;
        if (!stringBoolBooleanData.gH) {
            super.sendMessage(uUID, string);
        }
    }

    public void a(UUID uUID, String ... stringArray) {
        StringBoolBooleanData stringBoolBooleanData = (StringBoolBooleanData)abg.getIfPresent(this.getHandle().source);
        assert (stringBoolBooleanData != null);
        stringBoolBooleanData.aau = String.join((CharSequence)" ", stringArray);
        if (!stringBoolBooleanData.gH) {
            super.sendMessage(uUID, stringArray);
        }
    }
}
