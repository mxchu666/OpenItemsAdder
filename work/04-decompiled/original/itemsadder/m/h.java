package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bcy;
import itemsadder.m.i;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.Nullable;

public class h {
    private static h bq;
    AtomicBoolean br = new AtomicBoolean(false);
    AtomicBoolean bs = new AtomicBoolean(false);
    @Nullable
    private File bt;
    @Nullable
    BukkitTask bu;

    public static h M() {
        return bq;
    }

    public static void c(File file) {
        bq = new h(file);
    }

    public static void N() {
        bq = new h(null);
    }

    public static void O() {
        if (bq != null) {
            h.bq.br.set(false);
            h.bq.bt = null;
            if (h.bq.bu != null) {
                h.bq.bu.cancel();
            }
            h.bq.bu = null;
        }
    }

    public h(File file) {
        if (file == null) {
            this.br.set(false);
            return;
        }
        try {
            this.e(file);
            if (this.bt != null) {
                this.br.set(true);
                bce.iA("[Libs] FFmpeg is available at: " + this.bt.getAbsolutePath());
            } else {
                bce.warn("[Libs] FFmpeg is not available.");
                this.br.set(false);
            }
        }
        catch (IOException | InterruptedException exception) {
            bce.warn("[Libs] Failed to ensure FFmpeg availability: " + exception.getMessage());
            this.br.set(false);
        }
    }

    public boolean P() {
        return this.br.get();
    }

    public boolean Q() {
        return this.bs.get();
    }

    public File a(File file, File file2, i i2) {
        if (this.bt == null || !this.br.get()) {
            throw new IllegalStateException("[Libs] FFmpeg is not available");
        }
        if (i2.bv == null && i2.bw == null) {
            throw new IllegalArgumentException("At least one of qualityPercent or mono must be set");
        }
        Files.createDirectories(file2.toPath().getParent(), new FileAttribute[0]);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(this.bt.getAbsolutePath());
        arrayList.add("-y");
        arrayList.add("-loglevel");
        arrayList.add("error");
        arrayList.add("-i");
        arrayList.add(file.getAbsolutePath());
        if (i2.bw != null) {
            arrayList.add("-ac");
            arrayList.add(i2.bw != false ? "1" : "2");
        }
        arrayList.add("-c:a");
        arrayList.add("libvorbis");
        if (i2.bv != null && i2.bv < 100) {
            if (i2.bv < 1) {
                throw new IllegalArgumentException("quality must be between 1 and 100");
            }
            int n = 48 + (int)((double)i2.bv.intValue() / 100.0 * 144.0);
            arrayList.add("-b:a");
            arrayList.add(n + "k");
        }
        arrayList.add(file2.getAbsolutePath());
        ProcessBuilder processBuilder = new ProcessBuilder(arrayList);
        processBuilder.redirectErrorStream(false);
        Process process = processBuilder.start();
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));){
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                stringBuilder.append(string).append(System.lineSeparator());
            }
        }
        int n = process.waitFor();
        if (n != 0 || !stringBuilder.isEmpty()) {
            throw new IOException("FFmpeg failed:\n" + stringBuilder.toString().trim());
        }
        return file2;
    }

    public double d(File file) {
        if (!this.br.get()) {
            throw new IllegalStateException("FFmpeg is not available");
        }
        ProcessBuilder processBuilder = new ProcessBuilder(this.bt.getAbsolutePath(), "-i", file.getAbsolutePath());
        processBuilder.redirectErrorStream(false);
        Process process = processBuilder.start();
        double d = -1.0;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));){
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                if (!string.contains("Duration:")) continue;
                String string2 = string.split("Duration:")[1].split(",")[0].trim();
                String[] stringArray = string2.split(":");
                double d2 = Double.parseDouble(stringArray[0]);
                double d3 = Double.parseDouble(stringArray[1]);
                double d4 = Double.parseDouble(stringArray[2]);
                d = d2 * 3600.0 + d3 * 60.0 + d4;
                break;
            }
        }
        process.waitFor();
        if (d == -1.0) {
            throw new IOException("Unable to determine duration from FFmpeg output");
        }
        return d;
    }

    private void e(File file) {
        String string = h.S();
        File file2 = new File(file, string);
        file2.mkdirs();
        AtomicReference atomicReference = new AtomicReference();
        try (Object object = Files.walk(file2.toPath(), new FileVisitOption[0]);){
            object.filter(path -> Files.isRegularFile(path, new LinkOption[0])).map(Path::toFile).filter(h::f).findFirst().ifPresent(atomicReference::set);
        }
        if (atomicReference.get() != null) {
            if (!((File)atomicReference.get()).setExecutable(true)) {
                bce.warn("[Libs] Failed to set executable permission for FFmpeg binary: " + ((File)atomicReference.get()).getAbsolutePath());
            }
            object = (File)atomicReference.get();
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(((File)object).getAbsolutePath(), "-version");
                processBuilder.redirectErrorStream(true);
                processBuilder.start();
                this.bt = object;
                return;
            }
            catch (IOException iOException) {
                bce.warn("[Libs] FFmpeg executable is not valid. Trying to re-download it.");
                this.bt = null;
            }
        }
        object = switch (string) {
            case "windows" -> "https://github.com/ItemsAdder/ffmpeg-assets/releases/download/2025-05-19/ffmpeg_windows.zip";
            case "linux" -> "https://github.com/ItemsAdder/ffmpeg-assets/releases/download/2025-05-19/ffmpeg_linux.zip";
            case "mac" -> "https://github.com/ItemsAdder/ffmpeg-assets/releases/download/2025-05-19/ffmpeg_mac.zip";
            default -> throw new IOException("Unsupported OS: " + string);
        };
        if (ae.fW) {
            this.bs.set(true);
            bce.warn(" ");
            bce.warn("Downloading FFmpeg");
            bce.warn("(It will be downloaded only this time)");
            bce.warn("This can take some time, depending on your internet connection.");
            bce.warn("Set 'download_ffmpeg' to 'false' in 'config.yml' to skip this step.");
            bce.warn("This program is used to compress and handle .ogg audio files.");
            bce.warn(" ");
            bce.warn("NOTE: If the automatic download fails you can manually download and extract it into this folder and restart.");
            bce.warn("Folder: " + file2.getAbsolutePath());
            bce.warn("Download: " + (String)object);
            bce.warn(" ");
            bce.log("[Libs] Downloading FFmpeg: 0%");
            Object object = new File(file, "ffmpeg_download.zip");
            bcp.h(arg_0 -> this.a((String)object, (File)object, file2, arg_0));
        } else {
            bce.warn("[Libs] FFmpeg is not available and 'download_ffmpeg' is set to false in config.yml");
            bce.warn("[Libs] Download from: " + (String)object);
            bce.warn("[Libs] Extract it into: " + bcy.iO(file2.getAbsolutePath()));
        }
    }

    private static void a(File file, File file2) {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));){
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                File file3 = new File(file2, zipEntry.getName());
                if (zipEntry.isDirectory()) {
                    file3.mkdirs();
                    continue;
                }
                file3.getParentFile().mkdirs();
                try (FileOutputStream fileOutputStream = new FileOutputStream(file3);){
                    zipInputStream.transferTo(fileOutputStream);
                }
            }
        }
    }

    private static boolean f(File file) {
        String string = file.getName().toLowerCase(Locale.ROOT);
        if (h.R()) {
            return string.equals("ffmpeg.exe");
        }
        return string.equals("ffmpeg");
    }

    private static boolean R() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    private static String S() {
        String string = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        if (string.contains("win")) {
            return "windows";
        }
        if (string.contains("mac")) {
            return "mac";
        }
        if (string.contains("nux") || string.contains("nix")) {
            return "linux";
        }
        return "unknown";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private /* synthetic */ void a(String string, File file, File file2, BukkitRunnable bukkitRunnable) {
        try {
            Object object;
            HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(string).openConnection();
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
            try (AutoCloseable autoCloseable = httpURLConnection.getInputStream();){
                object = new FileOutputStream(file);
                try {
                    int n;
                    byte[] byArray = new byte[8192];
                    long l = httpURLConnection.getContentLengthLong();
                    long l2 = 0L;
                    int n2 = 0;
                    while ((n = ((InputStream)autoCloseable).read(byArray)) != -1) {
                        int n3;
                        if (bukkitRunnable.isCancelled()) {
                            return;
                        }
                        ((FileOutputStream)object).write(byArray, 0, n);
                        if (l <= 0L || (n3 = (int)((l2 += (long)n) * 100L / l)) < n2 + 10) continue;
                        bce.log("[Libs] Downloading FFmpeg: " + n3 + "%");
                        n2 = n3;
                    }
                    if (l > 0L && n2 < 100) {
                        bce.log("[Libs] FFmpeg Download Completed!");
                    }
                }
                finally {
                    ((FileOutputStream)object).close();
                }
            }
            h.a(file, file2);
            autoCloseable = Files.walk(file2.toPath(), new FileVisitOption[0]);
            try {
                object = autoCloseable.filter(path -> Files.isRegularFile(path, new LinkOption[0])).map(Path::toFile).filter(h::f).findFirst().orElseThrow(() -> new IOException("FFmpeg executable not found after extraction"));
                if (!((File)object).setExecutable(true)) {
                    bce.warn("[Libs] Failed to set executable permission for FFmpeg binary: " + ((File)object).getAbsolutePath());
                } else {
                    bce.log("[Libs] FFmpeg executable found: " + ((File)object).getAbsolutePath());
                    this.br.set(true);
                    this.bt = object;
                }
            }
            finally {
                if (autoCloseable != null) {
                    autoCloseable.close();
                }
            }
        }
        catch (IOException iOException) {
            bce.error("Failed to download or extract FFmpeg: " + iOException.getMessage());
        }
        finally {
            this.bs.set(false);
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
