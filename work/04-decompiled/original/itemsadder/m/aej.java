package itemsadder.m;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import itemsadder.m.aeh;
import itemsadder.m.aei;
import itemsadder.m.aek;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import net.minecraft.commands.CommandListenerWrapper;
import net.minecraft.commands.ICommandListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_20_R4.CraftServer;
import org.bukkit.craftbukkit.v1_20_R4.command.ProxiedNativeCommandSender;

public class aej
extends ProxiedNativeCommandSender
implements aeh {
    private static final Cache aaw = CacheBuilder.newBuilder().expireAfterWrite(1L, TimeUnit.MINUTES).build();

    public aej() {
        this(((CraftServer)Bukkit.getConsoleSender().getServer()).getServer().aI(), (CommandSender)Bukkit.getConsoleSender(), (CommandSender)Bukkit.getConsoleSender());
    }

    public aej(CommandListenerWrapper commandListenerWrapper, CommandSender commandSender, CommandSender commandSender2) {
        super(commandListenerWrapper.a((ICommandListener)new aek(commandListenerWrapper)), commandSender, commandSender2);
    }

    @Override
    public aei i(String string, boolean bl) {
        aei aei2 = new aei();
        aaw.put(this.getHandle().c, aei2);
        aei2.gH = bl;
        Bukkit.dispatchCommand((CommandSender)this, (String)string);
        return (aei)aaw.getIfPresent(this.getHandle().c);
    }

    public void dC(String string) {
        aei aei2 = (aei)aaw.getIfPresent(this.getHandle().c);
        assert (aei2 != null);
        aei2.aau = string;
        if (!aei2.gH) {
            super.sendMessage(string);
        }
    }

    public void h(String ... stringArray) {
        aei aei2 = (aei)aaw.getIfPresent(this.getHandle().c);
        assert (aei2 != null);
        aei2.aau = String.join((CharSequence)" ", stringArray);
        if (!aei2.gH) {
            super.sendMessage(stringArray);
        }
    }

    public void d(UUID uUID, String string) {
        aei aei2 = (aei)aaw.getIfPresent(this.getHandle().c);
        assert (aei2 != null);
        aei2.aau = string;
        if (!aei2.gH) {
            super.sendMessage(uUID, string);
        }
    }

    public void a(UUID uUID, String ... stringArray) {
        aei aei2 = (aei)aaw.getIfPresent(this.getHandle().c);
        assert (aei2 != null);
        aei2.aau = String.join((CharSequence)" ", stringArray);
        if (!aei2.gH) {
            super.sendMessage(uUID, stringArray);
        }
    }
}
