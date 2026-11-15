package itemsadder.m;

import itemsadder.m.bce;
import java.io.File;
import java.util.function.Consumer;

public class bbn {
    public static void a(File file, Consumer consumer) {
        if (file.exists()) {
            if (!file.delete()) {
                bce.error("Failed to delete file, probably no permission. " + file.getAbsolutePath());
                return;
            }
            consumer.accept(file);
        }
    }
}
