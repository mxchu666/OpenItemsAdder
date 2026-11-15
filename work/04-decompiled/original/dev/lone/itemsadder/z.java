package dev.lone.itemsadder;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.ch;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.bce;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class z {
    private static void n(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] fileArray = file.listFiles();
            if (fileArray == null) {
                return;
            }
            for (File file2 : fileArray) {
                z.n(file2);
            }
        }
        try {
            Files.delete(file.toPath());
        }
        catch (IOException iOException) {
            bce.warn("Failed to delete file: " + file.getAbsolutePath(), iOException);
        }
    }

    public static void b(File file, File file2) {
        z.n(file2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try (ZipFile zipFile = new ZipFile(file);){
            Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
            while (enumeration.hasMoreElements()) {
                ZipEntry zipEntry = enumeration.nextElement();
                File file3 = new File(file2, zipEntry.getName());
                try {
                    if (!file3.getCanonicalPath().startsWith(file2.getCanonicalPath())) {
                        bce.warn("Skipping suspicious entry: " + zipEntry.getName());
                        continue;
                    }
                    if (zipEntry.isDirectory()) {
                        file3.mkdirs();
                        continue;
                    }
                    file3.getParentFile().mkdirs();
                    try (InputStream inputStream = zipFile.getInputStream(zipEntry);
                         FileOutputStream fileOutputStream = new FileOutputStream(file3);){
                        int n;
                        byte[] byArray = new byte[4096];
                        while ((n = inputStream.read(byArray)) > 0) {
                            ((OutputStream)fileOutputStream).write(byArray, 0, n);
                        }
                    }
                    if (!file3.getName().endsWith(".json")) continue;
                    try {
                        inputStream = c.N(file3);
                        inputStream = ch.y((JSONObject)inputStream);
                        c.a(file3, (JSONObject)inputStream);
                    }
                    catch (Exception exception) {
                        bce.warn("Failed to process JSON file: " + file3.getAbsolutePath() + ". It may be obfuscated or corrupted.", exception);
                    }
                }
                catch (IOException iOException) {
                    bce.warn("Skipping corrupted entry: " + zipEntry.getName(), iOException);
                }
            }
        }
        catch (IOException iOException) {
            bce.error("Failed to extract zip file: " + file.getAbsolutePath(), iOException);
        }
    }
}
