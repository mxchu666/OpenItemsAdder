package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.ayg;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bjq;
import itemsadder.m.bkk;
import itemsadder.m.mn;
import itemsadder.m.ms;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.bukkit.Chunk;

public class mq {
    private static final int BH = 8192;
    private ayg BI;
    private File BJ;
    private final AtomicBoolean BK = new AtomicBoolean();
    private final Lock BL;
    private final File BM;

    public mq(File file) {
        this.BM = file;
        this.BL = new ReentrantReadWriteLock().writeLock();
    }

    void lV() {
        block15: {
            if (!ae.er) {
                return;
            }
            this.BJ = new File(this.BM, "fixed_glitched_blocks.pregion");
            if (this.BJ.exists()) {
                try {
                    GZIPInputStream gZIPInputStream;
                    if (this.BJ.exists() && this.BJ.length() / 1024L >= 256L) {
                        if (this.BJ.delete()) {
                            bce.log("Cleaned up fixed_glitched_blocks.nbt file (size > 512KB)");
                        } else {
                            bce.error("Failed to clean up fixed_glitched_blocks.nbt file (size > 512KB)");
                        }
                    }
                    try (GZIPInputStream gZIPInputStream2 = gZIPInputStream = new GZIPInputStream(new FileInputStream(this.BJ));){
                        this.BI = ayg.wP();
                        mn.a(gZIPInputStream, this.BI);
                    }
                }
                catch (Exception exception) {
                    if (this.BJ.delete()) {
                        bce.warn("Error loading world '" + this.BJ.getName() + "' file. Regenerated: " + String.valueOf(this.BJ.getAbsoluteFile()));
                        break block15;
                    }
                    bce.error("Error loading file, also failed to delete it. Stop the server and try to delete the file manually: " + this.BJ.getAbsolutePath(), exception);
                }
            } else {
                this.BI = ayg.wP();
            }
        }
    }

    void lW() {
        if (!ae.er) {
            return;
        }
        if (!this.BK.get()) {
            return;
        }
        try {
            this.BL.lock();
            bcp.j(() -> {
                try {
                    if (!this.BJ.exists()) {
                        Files.createDirectories(this.BJ.getParentFile().toPath(), new FileAttribute[0]);
                        try {
                            Files.createFile(this.BJ.toPath(), new FileAttribute[0]);
                        }
                        catch (FileAlreadyExistsException fileAlreadyExistsException) {
                            // empty catch block
                        }
                    }
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(this.BJ));
                    bjq bjq2 = bjq.cv(8192);
                    bkk bkk2 = new bkk(bjq2, gZIPOutputStream);
                    ayg.apY.a(bkk2, (Object)this.BI);
                    bjq.a(gZIPOutputStream, bjq2);
                    gZIPOutputStream.finish();
                    gZIPOutputStream.close();
                }
                catch (IOException iOException) {
                    bce.error("Error saving 'already fixed glitched blocks' chunks cache, please try to delete the file: " + this.BJ.getAbsolutePath(), iOException);
                }
            });
        }
        finally {
            this.BL.unlock();
        }
    }

    public void s(Chunk chunk) {
        if (this.BI != null) {
            this.BI.dX(ms.w(chunk));
            this.BK.set(true);
        }
    }

    public boolean t(Chunk chunk) {
        if (this.BI == null) {
            return false;
        }
        return this.BI.wQ().contains(ms.w(chunk));
    }
}
