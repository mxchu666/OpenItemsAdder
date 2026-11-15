package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import java.io.File;
import java.util.function.Consumer;

public class Opaque016 {
    public static void a(File file, Consumer consumer) {
        if (file.exists()) {
            if (!file.delete()) {
                CommandSenderBridge_5.error("Failed to delete file, probably no permission. " + file.getAbsolutePath());
                return;
            }
            consumer.accept(file);
        }
    }
}
