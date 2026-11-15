package dev.lone.itemsadder.resourcepack;

import com.google.common.primitives.Longs;
import itemsadder.m.CommandSenderBridge_5;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;

public class d {
    public static void b(File file, String string) {
        try {
            long l = d.o(file);
            Files.setAttribute(file.toPath(), "user:" + string, Longs.toByteArray(l), new LinkOption[0]);
            if (!file.setLastModified(l)) {
                throw new RuntimeException("Failed to set file lastModified attribute. Check your FTP permissions.");
            }
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Can't set file file attribute " + string + ": " + file.getAbsolutePath(), throwable);
        }
    }

    public static boolean c(File file, String string) {
        try {
            long l = Longs.fromByteArray((byte[])Files.getAttribute(file.toPath(), "user:" + string, new LinkOption[0]));
            return l == file.lastModified();
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    private static long o(File file) {
        long l = file.lastModified();
        if (l < 0L) {
            l = System.currentTimeMillis();
        }
        return l;
    }
}
