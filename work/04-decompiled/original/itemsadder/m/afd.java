package itemsadder.m;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import itemsadder.m.aeh;
import itemsadder.m.aei;
import itemsadder.m.afe;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.command.ProxiedNativeCommandSender;

public class afd
extends ProxiedNativeCommandSender
implements aeh {
    private static final Cache aba = CacheBuilder.newBuilder().expireAfterWrite(1L, TimeUnit.MINUTES).build();

    public afd() {
        this(((CraftServer)Bukkit.getConsoleSender().getServer()).getServer().createCommandSourceStack(), (CommandSender)Bukkit.getConsoleSender(), (CommandSender)Bukkit.getConsoleSender());
    }

    public afd(CommandSourceStack commandSourceStack, CommandSender commandSender, CommandSender commandSender2) {
        super(commandSourceStack.withSource((CommandSource)new afe(commandSourceStack)), commandSender, commandSender2);
    }

    @Override
    public aei i(String string, boolean bl) {
        aei aei2 = new aei();
        aba.put(this.getHandle().source, aei2);
        aei2.gH = bl;
        Bukkit.dispatchCommand((CommandSender)this, (String)string);
        return (aei)aba.getIfPresent(this.getHandle().source);
    }

    public void dC(String string) {
        aei aei2 = (aei)aba.getIfPresent(this.getHandle().source);
        assert (aei2 != null);
        aei2.aau = string;
        if (!aei2.gH) {
            super.sendMessage(string);
        }
    }

    public void h(String ... stringArray) {
        aei aei2 = (aei)aba.getIfPresent(this.getHandle().source);
        assert (aei2 != null);
        aei2.aau = String.join((CharSequence)" ", stringArray);
        if (!aei2.gH) {
            super.sendMessage(stringArray);
        }
    }

    public void d(UUID uUID, String string) {
        aei aei2 = (aei)aba.getIfPresent(this.getHandle().source);
        assert (aei2 != null);
        aei2.aau = string;
        if (!aei2.gH) {
            super.sendMessage(uUID, string);
        }
    }

    public void a(UUID uUID, String ... stringArray) {
        aei aei2 = (aei)aba.getIfPresent(this.getHandle().source);
        assert (aei2 != null);
        aei2.aau = String.join((CharSequence)" ", stringArray);
        if (!aei2.gH) {
            super.sendMessage(uUID, stringArray);
        }
    }
}
