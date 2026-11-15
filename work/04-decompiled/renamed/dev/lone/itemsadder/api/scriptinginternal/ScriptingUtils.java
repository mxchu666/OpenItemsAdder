package dev.lone.itemsadder.api.scriptinginternal;

import dev.lone.itemsadder.Main;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.VersionHelper_3;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ScriptingUtils {
    public static void msg(Player player, String string, boolean bl) {
        if (bl) {
            ScriptingUtils.msg(player, PluginBridge_6.gK(string));
        } else {
            player.sendMessage(string);
        }
    }

    public static void msg(Player player, String string) {
        player.sendMessage(string);
    }

    public static void msg(Player player, Component component) {
        if (VersionHelper_3.sZ()) {
            player.sendMessage(component);
        } else {
            player.spigot().sendMessage(PluginBridge_6.s(component));
        }
    }

    public static void log(String string) {
        Bukkit.getConsoleSender().sendMessage(string);
    }

    public static void _runDelayed(long l, Runnable runnable) {
        if (l > 0L) {
            Bukkit.getScheduler().runTaskLater(Main.rT(), runnable, l);
        } else if (!Bukkit.isPrimaryThread()) {
            Bukkit.getScheduler().runTask(Main.rT(), runnable);
        } else {
            runnable.run();
        }
    }

    public static Object cast(Class clazz, Object object) {
        if (object == null) {
            return null;
        }
        if (clazz.isInstance(object)) {
            return object;
        }
        throw new ClassCastException("Cannot cast " + object.getClass().getName() + " to " + clazz.getName());
    }

    public static boolean hasData(PersistentDataContainer persistentDataContainer, String string, String string2) {
        return persistentDataContainer.has(new NamespacedKey(string, string2));
    }

    public static void removeData(PersistentDataContainer persistentDataContainer, String string, String string2) {
        persistentDataContainer.remove(new NamespacedKey(string, string2));
    }

    public static byte getDataByte(PersistentDataContainer persistentDataContainer, String string, String string2, byte by) {
        return (Byte)persistentDataContainer.getOrDefault(new NamespacedKey(string, string2), PersistentDataType.BYTE, (Object)by);
    }

    public static void setDataByte(PersistentDataContainer persistentDataContainer, String string, String string2, byte by) {
        persistentDataContainer.set(new NamespacedKey(string, string2), PersistentDataType.BYTE, (Object)by);
    }

    public static short getDataShort(PersistentDataContainer persistentDataContainer, String string, String string2, short s) {
        return (Short)persistentDataContainer.getOrDefault(new NamespacedKey(string, string2), PersistentDataType.SHORT, (Object)s);
    }

    public static void setDataShort(PersistentDataContainer persistentDataContainer, String string, String string2, short s) {
        persistentDataContainer.set(new NamespacedKey(string, string2), PersistentDataType.SHORT, (Object)s);
    }

    public static int getDataInt(PersistentDataContainer persistentDataContainer, String string, String string2, int n) {
        return (Integer)persistentDataContainer.getOrDefault(new NamespacedKey(string, string2), PersistentDataType.INTEGER, (Object)n);
    }

    public static void setDataInt(PersistentDataContainer persistentDataContainer, String string, String string2, int n) {
        persistentDataContainer.set(new NamespacedKey(string, string2), PersistentDataType.INTEGER, (Object)n);
    }

    public static long getDataLong(PersistentDataContainer persistentDataContainer, String string, String string2, long l) {
        return (Long)persistentDataContainer.getOrDefault(new NamespacedKey(string, string2), PersistentDataType.LONG, (Object)l);
    }

    public static void setDataLong(PersistentDataContainer persistentDataContainer, String string, String string2, long l) {
        persistentDataContainer.set(new NamespacedKey(string, string2), PersistentDataType.LONG, (Object)l);
    }

    public static float getDataFloat(PersistentDataContainer persistentDataContainer, String string, String string2, float f) {
        return ((Float)persistentDataContainer.getOrDefault(new NamespacedKey(string, string2), PersistentDataType.FLOAT, (Object)Float.valueOf(f))).floatValue();
    }

    public static void setDataFloat(PersistentDataContainer persistentDataContainer, String string, String string2, float f) {
        persistentDataContainer.set(new NamespacedKey(string, string2), PersistentDataType.FLOAT, (Object)Float.valueOf(f));
    }

    public static double getDataDouble(PersistentDataContainer persistentDataContainer, String string, String string2, double d) {
        return (Double)persistentDataContainer.getOrDefault(new NamespacedKey(string, string2), PersistentDataType.DOUBLE, (Object)d);
    }

    public static void setDataDouble(PersistentDataContainer persistentDataContainer, String string, String string2, double d) {
        persistentDataContainer.set(new NamespacedKey(string, string2), PersistentDataType.DOUBLE, (Object)d);
    }

    public static boolean getDataBool(PersistentDataContainer persistentDataContainer, String string, String string2, boolean bl) {
        return (Boolean)persistentDataContainer.getOrDefault(new NamespacedKey(string, string2), PersistentDataType.BOOLEAN, (Object)bl);
    }

    public static void setDataBool(PersistentDataContainer persistentDataContainer, String string, String string2, boolean bl) {
        persistentDataContainer.set(new NamespacedKey(string, string2), PersistentDataType.BOOLEAN, (Object)bl);
    }

    public static String getDataString(PersistentDataContainer persistentDataContainer, String string, String string2, String string3) {
        return (String)persistentDataContainer.getOrDefault(new NamespacedKey(string, string2), PersistentDataType.STRING, (Object)string3);
    }

    public static void setDataString(PersistentDataContainer persistentDataContainer, String string, String string2, String string3) {
        persistentDataContainer.set(new NamespacedKey(string, string2), PersistentDataType.STRING, (Object)string3);
    }
}
