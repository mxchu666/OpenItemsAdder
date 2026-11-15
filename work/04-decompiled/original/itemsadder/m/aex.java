package itemsadder.m;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import itemsadder.m.aeh;
import itemsadder.m.aei;
import itemsadder.m.aey;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import net.minecraft.commands.CommandListenerWrapper;
import net.minecraft.commands.ICommandListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_21_R5.CraftServer;
import org.bukkit.craftbukkit.v1_21_R5.command.ProxiedNativeCommandSender;

public class aex
extends ProxiedNativeCommandSender
implements aeh {
    private static final Cache aaR = CacheBuilder.newBuilder().expireAfterWrite(1L, TimeUnit.MINUTES).build();

    public aex() {
        this(((CraftServer)Bukkit.getConsoleSender().getServer()).getServer().aH(), (CommandSender)Bukkit.getConsoleSender(), (CommandSender)Bukkit.getConsoleSender());
    }

    public aex(CommandListenerWrapper commandListenerWrapper, CommandSender commandSender, CommandSender commandSender2) {
        super(commandListenerWrapper.a((ICommandListener)new aey(commandListenerWrapper)), commandSender, commandSender2);
    }

    @Override
    public aei i(String string, boolean bl) {
        aei aei2 = new aei();
        aaR.put(this.getHandle().d, aei2);
        aei2.gH = bl;
        Bukkit.dispatchCommand((CommandSender)this, (String)string);
        return (aei)aaR.getIfPresent(this.getHandle().d);
    }

    public void dC(String string) {
        aei aei2 = (aei)aaR.getIfPresent(this.getHandle().d);
        assert (aei2 != null);
        aei2.aau = string;
        if (!aei2.gH) {
            super.sendMessage(string);
        }
    }

    public void h(String ... stringArray) {
        aei aei2 = (aei)aaR.getIfPresent(this.getHandle().d);
        assert (aei2 != null);
        aei2.aau = String.join((CharSequence)" ", stringArray);
        if (!aei2.gH) {
            super.sendMessage(stringArray);
        }
    }

    public void d(UUID uUID, String string) {
        aei aei2 = (aei)aaR.getIfPresent(this.getHandle().d);
        assert (aei2 != null);
        aei2.aau = string;
        if (!aei2.gH) {
            super.sendMessage(uUID, string);
        }
    }

    public void a(UUID uUID, String ... stringArray) {
        aei aei2 = (aei)aaR.getIfPresent(this.getHandle().d);
        assert (aei2 != null);
        aei2.aau = String.join((CharSequence)" ", stringArray);
        if (!aei2.gH) {
            super.sendMessage(uUID, stringArray);
        }
    }
}
