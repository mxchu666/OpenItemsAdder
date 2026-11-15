package dev.lone.itemsadder.api.scriptinginternal;

import dev.lone.itemsadder.api.scriptinginternal.ScriptingUtils;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataContainer;

public class EntityUtils {
    private static PersistentDataContainer getContainer(Entity entity) {
        if (entity == null) {
            return null;
        }
        return entity.getPersistentDataContainer();
    }

    public static boolean hasData(Entity entity, String string, String string2) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        return ScriptingUtils.hasData(persistentDataContainer, string, string2);
    }

    public static void removeData(Entity entity, String string, String string2) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        ScriptingUtils.removeData(persistentDataContainer, string, string2);
    }

    public static void setDataByte(Entity entity, String string, String string2, byte by) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        ScriptingUtils.setDataByte(persistentDataContainer, string, string2, by);
    }

    public static byte getDataByte(Entity entity, String string, String string2, byte by) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        return ScriptingUtils.getDataByte(persistentDataContainer, string, string2, by);
    }

    public static void setDataShort(Entity entity, String string, String string2, short s) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        ScriptingUtils.setDataShort(persistentDataContainer, string, string2, s);
    }

    public static short getDataShort(Entity entity, String string, String string2, short s) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        return ScriptingUtils.getDataShort(persistentDataContainer, string, string2, s);
    }

    public static void setDataInt(Entity entity, String string, String string2, int n) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        ScriptingUtils.setDataInt(persistentDataContainer, string, string2, n);
    }

    public static int getDataInt(Entity entity, String string, String string2, int n) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        return ScriptingUtils.getDataInt(persistentDataContainer, string, string2, n);
    }

    public static void setDataLong(Entity entity, String string, String string2, long l) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        ScriptingUtils.setDataLong(persistentDataContainer, string, string2, l);
    }

    public static long getDataLong(Entity entity, String string, String string2, long l) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        return ScriptingUtils.getDataLong(persistentDataContainer, string, string2, l);
    }

    public static void setDataFloat(Entity entity, String string, String string2, float f) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        ScriptingUtils.setDataFloat(persistentDataContainer, string, string2, f);
    }

    public static float getDataFloat(Entity entity, String string, String string2, float f) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        return ScriptingUtils.getDataFloat(persistentDataContainer, string, string2, f);
    }

    public static void setDataDouble(Entity entity, String string, String string2, double d) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        ScriptingUtils.setDataDouble(persistentDataContainer, string, string2, d);
    }

    public static double getDataDouble(Entity entity, String string, String string2, double d) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        return ScriptingUtils.getDataDouble(persistentDataContainer, string, string2, d);
    }

    public static void setDataBool(Entity entity, String string, String string2, boolean bl) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        ScriptingUtils.setDataBool(persistentDataContainer, string, string2, bl);
    }

    public static boolean getDataBool(Entity entity, String string, String string2, boolean bl) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        return ScriptingUtils.getDataBool(persistentDataContainer, string, string2, bl);
    }

    public static void setDataString(Entity entity, String string, String string2, String string3) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        ScriptingUtils.setDataString(persistentDataContainer, string, string2, string3);
    }

    public static String getDataString(Entity entity, String string, String string2, String string3) {
        PersistentDataContainer persistentDataContainer = EntityUtils.getContainer(entity);
        return ScriptingUtils.getDataString(persistentDataContainer, string, string2, string3);
    }
}
