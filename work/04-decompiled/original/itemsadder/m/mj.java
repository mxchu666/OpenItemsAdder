package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.AdvancedSlimePaperWrapper;
import itemsadder.m.ae;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bdq;
import itemsadder.m.ms;
import java.io.File;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public abstract class mj {
    final Plugin Bw;
    final String Bx;
    protected final Map By = new ConcurrentHashMap();
    final AtomicBoolean Bz = new AtomicBoolean(false);
    private final ConcurrentHashMap BA = new ConcurrentHashMap();
    private final ReadWriteLock BB = new ReentrantReadWriteLock();

    public ReadWriteLock bg(String string2) {
        return this.BA.computeIfAbsent(string2, string -> new ReentrantReadWriteLock());
    }

    public mj(Plugin plugin) {
        this.Bw = plugin;
        this.Bx = "/region/";
    }

    public Map lJ() {
        return this.By;
    }

    public abstract ms c(World var1, int var2, int var3);

    public abstract ms a(World var1, int var2, int var3);

    public ms m(Chunk chunk) {
        return this.c(chunk.getWorld(), chunk.getX(), chunk.getZ());
    }

    public ms D(Location location) {
        return this.m(location.getChunk());
    }

    public boolean lK() {
        return this.Bz.get();
    }

    public boolean ac(int n) {
        return this.By.containsKey(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public ms d(World world, int n, int n2) {
        ReadWriteLock readWriteLock = this.bg(world.getName());
        readWriteLock.readLock().lock();
        try {
            File file = null;
            try {
                file = mj.a(world, n, n2, this.Bx);
                ms ms2 = new ms(file, world);
                return ms2;
            }
            catch (Exception exception) {
                if (file != null) {
                    bce.error("Corrupted region data '" + n + ", " + n2 + "'! Renaming it to '_corrupted'. ", exception);
                    try {
                        File file2 = new File(file.getParentFile(), file.getName().replace(".pregion", ".pregion_corrupted"));
                        FileUtils.copyFile((File)file, (File)file2);
                        FileUtils.forceDelete((File)file);
                    }
                    catch (Exception exception2) {
                        bce.error("Error copying the corrupted region file.", exception2);
                    }
                } else {
                    bce.error("Error loading region file '" + n + ", " + n2 + "'. File is null for some reason.", exception);
                }
                readWriteLock.readLock().unlock();
            }
        }
        finally {
            readWriteLock.readLock().unlock();
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public ms a(World world, int n, int n2, @Nullable Consumer consumer) {
        ReadWriteLock readWriteLock = this.bg(world.getName());
        readWriteLock.readLock().lock();
        try {
            File file = null;
            try {
                if (consumer != null) {
                    file = this.e(world, n, n2);
                    ms ms2 = new ms(file, world);
                    consumer.accept(ms2);
                    ms ms3 = ms2;
                    return ms3;
                }
                file = this.e(world, n, n2);
                ms ms4 = new ms(file, world);
                return ms4;
            }
            catch (Exception exception) {
                if (file != null) {
                    bce.error("Corrupted region data for chunk '" + n + ", " + n2 + "'! Renaming it to '_corrupted'. ", exception);
                    try {
                        File file2 = new File(file.getParentFile(), file.getName().replace(".pregion", ".pregion_corrupted"));
                        FileUtils.copyFile((File)file, (File)file2);
                        FileUtils.forceDelete((File)file);
                    }
                    catch (Exception exception2) {
                        bce.error("Error copying the corrupted region file.", exception2);
                    }
                } else {
                    bce.error("Error loading region file for chunk '" + n + ", " + n2 + "'. File is null for some reason.", exception);
                }
            }
        }
        finally {
            readWriteLock.readLock().unlock();
        }
        return null;
    }

    public synchronized void af(boolean bl) {
        this.BB.writeLock().lock();
        try {
            bcp.a(() -> {
                try {
                    long l;
                    bdq bdq2 = new bdq();
                    this.Bz.set(true);
                    int n = 0;
                    Iterator iterator = this.By.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry entry = iterator.next();
                        ms ms2 = (ms)entry.getValue();
                        ReadWriteLock readWriteLock = this.bg(ms2.BO.getName());
                        readWriteLock.writeLock().lock();
                        try {
                            ms2.save();
                            iterator.remove();
                            ++n;
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                            this.Bz.set(true);
                        }
                        finally {
                            readWriteLock.writeLock().unlock();
                        }
                    }
                    if (ae.dF && (l = bdq2.DJ()) >= (long)ae.dG) {
                        bce.log(String.valueOf(ChatColor.YELLOW) + "Saved " + n + " regions of all worlds in " + l + "ms");
                    }
                    this.Bz.set(false);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }, bl);
        }
        finally {
            this.BB.writeLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void a(World world, boolean bl, boolean bl2) {
        this.Bz.set(true);
        ReadWriteLock readWriteLock = this.bg(world.getName());
        readWriteLock.writeLock().lock();
        try {
            bcp.a(() -> {
                try {
                    long l;
                    bdq bdq2 = new bdq();
                    int n = 0;
                    Iterator iterator = this.By.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry entry = iterator.next();
                        ms ms2 = (ms)entry.getValue();
                        if (!ms2.BO.getName().equals(world.getName())) continue;
                        try {
                            ms2.ag(bl2);
                            if (bl2) {
                                iterator.remove();
                            }
                            if (bl2 && ae.dF) {
                                bce.log(String.valueOf(ChatColor.YELLOW) + world.getName() + ": unloaded region '" + ms2.lQ() + "'");
                            }
                            ++n;
                        }
                        catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    }
                    if (ae.dF && (l = bdq2.DJ()) >= (long)ae.dG) {
                        bce.log(String.valueOf(ChatColor.YELLOW) + world.getName() + ": saved " + n + " regions in " + l + "ms");
                    }
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                this.Bz.set(false);
            }, bl);
        }
        finally {
            if (bl2) {
                this.BA.remove(world.getName());
            }
            readWriteLock.writeLock().unlock();
        }
    }

    static File a(World world, int n, int n2, String string) {
        if (AdvancedSlimePaperWrapper.inst().isSlimeWorld(world)) {
            File file = Bukkit.getServer().getWorldContainer();
            return Paths.get(new File(file, "slime_worlds").getPath(), "itemsadder/" + world.getName(), string, "r." + n + "." + n2 + ".pregion").toFile();
        }
        return Paths.get(world.getWorldFolder().getPath(), "itemsadder", string, "r." + n + "." + n2 + ".pregion").toFile();
    }

    static File b(World world, int n, int n2, String string) {
        int n3 = n >> 5;
        int n4 = n2 >> 5;
        return mj.a(world, n3, n4, string);
    }

    File e(World world, int n, int n2) {
        return mj.b(world, n, n2, this.Bx);
    }
}
