package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.DFunction;
import itemsadder.m.ListenerBridge_2;
import itemsadder.m.Opaque048;
import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredListener;
import org.jetbrains.annotations.NotNull;

public class ListenerBridge {
    static final String aCJ = "org.bukkit";
    static PluginManager aCK = Bukkit.getPluginManager();
    static String aCL = ListenerBridge.class.getClassLoader().getName();

    public static void a(Listener listener, Plugin plugin) {
        for (RegisteredListener registeredListener : HandlerList.getRegisteredListeners((Plugin)plugin)) {
            if (!listener.getClass().isInstance(registeredListener.getListener())) continue;
            return;
        }
        aCK.registerEvents(listener, plugin);
    }

    public static void b(Listener listener, Plugin plugin) {
        aCK.registerEvents(listener, plugin);
    }

    public static void a(Listener listener) {
        aCK.registerEvents(listener, (Plugin)Main.rS());
    }

    public static void b(Listener listener) {
        if (listener == null) {
            return;
        }
        HandlerList.unregisterAll((Listener)listener);
    }

    public static boolean b(Event event) {
        aCK.callEvent(event);
        if (event instanceof Cancellable) {
            return !((Cancellable)event).isCancelled();
        }
        return true;
    }

    public static boolean g(BlockBreakEvent blockBreakEvent) {
        return blockBreakEvent.getClass() != BlockBreakEvent.class;
    }

    public static boolean k(BlockPlaceEvent blockPlaceEvent) {
        Class<?> clazz = blockPlaceEvent.getClass();
        return clazz != BlockPlaceEvent.class && clazz != BlockMultiPlaceEvent.class;
    }

    public static boolean h(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        return entityDamageByEntityEvent.getClass() != EntityDamageByEntityEvent.class;
    }

    public static boolean c(FoodLevelChangeEvent foodLevelChangeEvent) {
        return foodLevelChangeEvent.getClass() != FoodLevelChangeEvent.class;
    }

    @Deprecated
    static boolean c(Event event) {
        return !event.getClass().getPackage().getName().startsWith(aCJ);
    }

    public static boolean Ek() {
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        if (stackTraceElementArray.length < 2) {
            return false;
        }
        String string = stackTraceElementArray[2].getMethodName();
        String string2 = stackTraceElementArray[2].getClassName();
        int n = stackTraceElementArray.length;
        for (int i = 3; i < n; ++i) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if (!Objects.equals(aCL, stackTraceElement.getClassLoaderName()) || !string.equals(stackTraceElement.getMethodName()) || !string2.equals(stackTraceElement.getClassName())) continue;
            return true;
        }
        return false;
    }

    public static boolean s(PlayerInteractEvent playerInteractEvent) {
        return playerInteractEvent.getAction() == Action.LEFT_CLICK_AIR || playerInteractEvent.getAction() == Action.LEFT_CLICK_BLOCK;
    }

    public static void a(@NotNull Class clazz, EventPriority eventPriority, boolean bl, @NotNull DFunction dFunction) {
        Bukkit.getPluginManager().registerEvent(clazz, (Listener)new Opaque048(), eventPriority, (EventExecutor)new ListenerBridge_2(clazz, dFunction), (Plugin)Main.rS(), bl);
    }

    public static void a(@NotNull Class clazz, @NotNull DFunction dFunction) {
        ListenerBridge.a(clazz, EventPriority.NORMAL, false, dFunction);
    }
}
