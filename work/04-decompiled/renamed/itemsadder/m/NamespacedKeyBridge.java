package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

public class NamespacedKeyBridge {
    public static void a(PersistentDataHolder persistentDataHolder, NamespacedKey namespacedKey, Location location) {
        persistentDataHolder.getPersistentDataContainer().set(namespacedKey, PersistentDataType.STRING, (Object)(location.getWorld().getName() + "," + location.getX() + "," + location.getY() + "," + location.getZ() + "," + location.getYaw() + "," + location.getPitch()));
    }

    public static Location a(PersistentDataHolder persistentDataHolder, NamespacedKey namespacedKey) {
        String string = (String)persistentDataHolder.getPersistentDataContainer().get(namespacedKey, PersistentDataType.STRING);
        if (string != null) {
            String[] stringArray = string.split(",");
            return new Location(Bukkit.getServer().getWorld(stringArray[0]), Double.parseDouble(stringArray[1]), Double.parseDouble(stringArray[2]), Double.parseDouble(stringArray[3]), Float.parseFloat(stringArray[4]), Float.parseFloat(stringArray[5]));
        }
        return null;
    }

    public static void b(PersistentDataHolder persistentDataHolder, NamespacedKey namespacedKey) {
        persistentDataHolder.getPersistentDataContainer().remove(namespacedKey);
    }

    public static byte[] cW(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(string.getBytes(StandardCharsets.UTF_8));
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static String j(byte[] byArray) {
        int n;
        if (byArray == null || byArray.length == 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byArray2 = new byte[256];
        while ((n = gZIPInputStream.read(byArray2)) >= 0) {
            byteArrayOutputStream.write(byArray2, 0, n);
        }
        return byteArrayOutputStream.toString(StandardCharsets.UTF_8);
    }

    @Nullable
    public static String c(PersistentDataHolder persistentDataHolder, NamespacedKey namespacedKey) {
        if (persistentDataHolder.getPersistentDataContainer().has(namespacedKey)) {
            try {
                return NamespacedKeyBridge.j((byte[])persistentDataHolder.getPersistentDataContainer().get(namespacedKey, PersistentDataType.BYTE_ARRAY));
            }
            catch (IOException iOException) {
                CommandSenderBridge_5.error("Failed to get compressed persistent string from " + String.valueOf(persistentDataHolder), iOException);
                return null;
            }
        }
        return null;
    }

    public static void a(PersistentDataHolder persistentDataHolder, NamespacedKey namespacedKey, String string) {
        try {
            persistentDataHolder.getPersistentDataContainer().set(namespacedKey, PersistentDataType.BYTE_ARRAY, (Object)NamespacedKeyBridge.cW(string));
        }
        catch (IOException iOException) {
            CommandSenderBridge_5.error("Failed to set compressed persistent string from " + String.valueOf(persistentDataHolder), iOException);
        }
    }

    @Nullable
    public static String d(PersistentDataHolder persistentDataHolder, NamespacedKey namespacedKey) {
        if (persistentDataHolder.getPersistentDataContainer().has(namespacedKey)) {
            return (String)persistentDataHolder.getPersistentDataContainer().get(namespacedKey, PersistentDataType.STRING);
        }
        return null;
    }

    public static void b(PersistentDataHolder persistentDataHolder, NamespacedKey namespacedKey, String string) {
        persistentDataHolder.getPersistentDataContainer().set(namespacedKey, PersistentDataType.STRING, (Object)string);
    }

    public static boolean a(Entity entity, NamespacedKey namespacedKey, boolean bl) {
        @Nullable Boolean bl2 = (Boolean)entity.getPersistentDataContainer().get(namespacedKey, PersistentDataType.BOOLEAN);
        if (bl2 != null) {
            return bl2;
        }
        return bl;
    }
}
