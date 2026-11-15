package itemsadder.m;

import itemsadder.m.bbm;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import org.bukkit.Bukkit;

public class bbl {
    private static final SimpleDateFormat aAc = new SimpleDateFormat("yyyyMMddHHmmss");
    private static boolean vG = true;

    public static boolean F(File file) {
        if (!vG) {
            return true;
        }
        if (!file.exists()) {
            return true;
        }
        if (file.length() == 0L) {
            return true;
        }
        try {
            String string = aAc.format(new Date());
            String string2 = file.getName() + "." + string;
            File file2 = new File(file.getParentFile(), string2);
            Files.copy(file.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        }
        catch (IOException iOException) {
            Bukkit.getLogger().log(Level.WARNING, "Failed to create backup for file: " + file.getAbsolutePath(), iOException);
            return false;
        }
    }

    public static bbm f(File file, String string) {
        if (!file.exists() || file.length() == 0L) {
            return new bbm(file, null, string);
        }
        String string2 = aAc.format(new Date());
        File file2 = new File(file.getParentFile(), file.getName() + ".backup." + string2);
        Files.copy(file.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
        return new bbm(file, file2, string);
    }

    public static bbm G(File file) {
        return bbl.f(file, null);
    }

    public static void Z(boolean bl) {
        vG = bl;
    }

    public static boolean isEnabled() {
        return vG;
    }
}
