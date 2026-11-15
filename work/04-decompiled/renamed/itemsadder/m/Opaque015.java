package itemsadder.m;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import org.bukkit.Bukkit;

public class Opaque015 {
    private final File aAd;
    private final File aAe;
    private final String aAf;
    private boolean aAg = false;

    private Opaque015(File file, File file2, String string) {
        this.aAd = file;
        this.aAe = file2;
        this.aAf = string;
    }

    public void CT() {
        if (this.aAe == null || !this.aAe.exists()) {
            return;
        }
        Files.copy(this.aAe.toPath(), this.aAd.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Bukkit.getLogger().info("Rolled back file: " + this.aAd.getName() + " from backup");
    }

    public void CU() {
        if (this.aAe == null || !this.aAe.exists()) {
            this.aAg = true;
            return;
        }
        try {
            File file;
            if (this.aAf != null) {
                File file2 = new File(this.aAd.getParentFile(), this.aAf);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(file2, this.aAd.getName());
            } else {
                String string = this.aAd.getName() + ".old." + System.currentTimeMillis();
                file = new File(this.aAd.getParentFile(), string);
            }
            Files.move(this.aAe.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            this.aAg = true;
        }
        catch (IOException iOException) {
            Bukkit.getLogger().log(Level.WARNING, "Failed to move backup file: " + this.aAe.getAbsolutePath(), iOException);
        }
    }

    public void CV() {
        if (this.aAe != null && this.aAe.exists()) {
            this.aAe.delete();
        }
        this.aAg = true;
    }

    protected void finalize() {
        try {
            if (!this.aAg && this.aAe != null && this.aAe.exists()) {
                this.aAe.delete();
            }
        }
        finally {
            super.finalize();
        }
    }
}
