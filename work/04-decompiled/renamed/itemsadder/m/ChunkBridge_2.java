package itemsadder.m;

import itemsadder.m.BlockBridge_9;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ChunkStreamSomehowImpl;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.FluentBuilder_5;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PluginContractBuilder;
import itemsadder.m.PluginContractImpl_6;
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

public class ChunkBridge_2 {
    private static final int BH = 8192;
    private PluginContractBuilder BI;
    private File BJ;
    private final AtomicBoolean BK = new AtomicBoolean();
    private final Lock BL;
    private final File BM;

    public ChunkBridge_2(File file) {
        this.BM = file;
        this.BL = new ReentrantReadWriteLock().writeLock();
    }

    void lV() {
        block15: {
            if (!MaterialBarColorHolder.er) {
                return;
            }
            this.BJ = new File(this.BM, "fixed_glitched_blocks.pregion");
            if (this.BJ.exists()) {
                try {
                    GZIPInputStream gZIPInputStream;
                    if (this.BJ.exists() && this.BJ.length() / 1024L >= 256L) {
                        if (this.BJ.delete()) {
                            CommandSenderBridge_5.log("Cleaned up fixed_glitched_blocks.nbt file (size > 512KB)");
                        } else {
                            CommandSenderBridge_5.error("Failed to clean up fixed_glitched_blocks.nbt file (size > 512KB)");
                        }
                    }
                    try (GZIPInputStream gZIPInputStream2 = gZIPInputStream = new GZIPInputStream(new FileInputStream(this.BJ));){
                        this.BI = PluginContractBuilder.wP();
                        ChunkStreamSomehowImpl.a(gZIPInputStream, this.BI);
                    }
                }
                catch (Exception exception) {
                    if (this.BJ.delete()) {
                        CommandSenderBridge_5.warn("Error loading world '" + this.BJ.getName() + "' file. Regenerated: " + String.valueOf(this.BJ.getAbsoluteFile()));
                        break block15;
                    }
                    CommandSenderBridge_5.error("Error loading file, also failed to delete it. Stop the server and try to delete the file manually: " + this.BJ.getAbsolutePath(), exception);
                }
            } else {
                this.BI = PluginContractBuilder.wP();
            }
        }
    }

    void lW() {
        if (!MaterialBarColorHolder.er) {
            return;
        }
        if (!this.BK.get()) {
            return;
        }
        try {
            this.BL.lock();
            BukkitTaskBridge.j(() -> {
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
                    FluentBuilder_5 fluentBuilder_5 = FluentBuilder_5.cv(8192);
                    PluginContractImpl_6 pluginContractImpl_6 = new PluginContractImpl_6(fluentBuilder_5, gZIPOutputStream);
                    PluginContractBuilder.apY.a(pluginContractImpl_6, (Object)this.BI);
                    FluentBuilder_5.a(gZIPOutputStream, fluentBuilder_5);
                    gZIPOutputStream.finish();
                    gZIPOutputStream.close();
                }
                catch (IOException iOException) {
                    CommandSenderBridge_5.error("Error saving 'already fixed glitched blocks' chunks cache, please try to delete the file: " + this.BJ.getAbsolutePath(), iOException);
                }
            });
        }
        finally {
            this.BL.unlock();
        }
    }

    public void s(Chunk chunk) {
        if (this.BI != null) {
            this.BI.dX(BlockBridge_9.w(chunk));
            this.BK.set(true);
        }
    }

    public boolean t(Chunk chunk) {
        if (this.BI == null) {
            return false;
        }
        return this.BI.wQ().contains(BlockBridge_9.w(chunk));
    }
}
