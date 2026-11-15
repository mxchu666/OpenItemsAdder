package dev.lone.itemsadder.resourcepack;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import dev.lone.itemsadder.resourcepack.be;
import dev.lone.itemsadder.resourcepack.bi;
import dev.lone.itemsadder.resourcepack.bj;
import itemsadder.m.CommandSenderBridge_5;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.util.Random;
import java.util.zip.ZipEntry;
import org.bukkit.Material;

public class ch {
    private static final byte[] awS = new byte[]{80, 75, 3, 4};
    private static final byte[] awT = new byte[]{80, 75, 1, 2};
    private static final byte[] awU = new byte[]{80, 75, 5, 6};
    private static final byte[] awV = new byte[]{5, 57};
    private static final byte[] awW = new byte[]{0, 0, 0, 0};
    private static final byte[] awX = ch.bl(255);
    public static Random Bl = new Random();
    private static final FileTime awY = FileTime.fromMillis(0L);

    public static void a(ZipEntry zipEntry) {
        zipEntry.setCrc(0L);
        zipEntry.setLastAccessTime(awY);
        zipEntry.setCreationTime(awY);
        zipEntry.setLastModifiedTime(awY);
        if (zipEntry.getName().toLowerCase().endsWith(".ogg")) {
            zipEntry.setSize(ch.v(9000, 15000));
        } else {
            zipEntry.setSize(1337L);
        }
    }

    public static int v(int n, int n2) {
        if (n2 == n) {
            return n2;
        }
        return Bl.nextInt(n2 - n + 1) + n;
    }

    private static byte[] bl(int n) {
        byte[] byArray = new byte[n];
        for (int i = 0; i < n; ++i) {
            byArray[i] = 92;
        }
        if (n > 4) {
            byArray[0] = 46;
            byArray[1] = 46;
            byArray[2] = 47;
        }
        return byArray;
    }

    public static void A(File file) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");){
            try {
                byte[] byArray = new byte[8192];
                int n = 0;
                while ((long)n < randomAccessFile.length()) {
                    int n2 = randomAccessFile.read(byArray);
                    n += n2;
                    long l = randomAccessFile.getFilePointer() - (long)n2;
                    for (int i = 0; i < n2 - 6; ++i) {
                        if (byArray[i] == awS[0] && byArray[i + 1] == awS[1] && byArray[i + 2] == awS[2] && byArray[i + 3] == awS[3]) {
                            int n3;
                            int n4;
                            int n5;
                            if (i + 30 >= n2 || (n5 = byArray[i + 4] & 0xFF | (byArray[i + 5] & 0xFF) << 8) < 10 || n5 > 63 || (n4 = byArray[i + 8] & 0xFF | (byArray[i + 9] & 0xFF) << 8) != 8 && n4 != 0 || (n3 = byArray[i + 26] & 0xFF | (byArray[i + 27] & 0xFF) << 8) == 0 || n3 > 260 || i + 30 + n3 > n2) continue;
                            randomAccessFile.seek(l + (long)i + 18L);
                            randomAccessFile.write(awW);
                            randomAccessFile.seek(l + (long)i + 22L);
                            randomAccessFile.write(awW);
                            randomAccessFile.seek(l + (long)i + 30L);
                            int n6 = Math.min(awX.length, n3);
                            randomAccessFile.write(awX, 0, n6);
                            for (int j = n6; j < n3; ++j) {
                                randomAccessFile.write(0);
                            }
                            i += 98;
                            continue;
                        }
                        if (byArray[i] != awT[0] || byArray[i + 1] != awT[1] || byArray[i + 2] != awT[2] || byArray[i + 3] != awT[3]) continue;
                        randomAccessFile.seek(l + (long)i + 34L);
                        randomAccessFile.write(awV);
                        i += 34;
                    }
                    if (l + (long)n2 - 4L >= randomAccessFile.length()) continue;
                    randomAccessFile.seek(l + (long)n2 - 4L);
                }
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.error("Failed to protect zip file.", throwable);
            }
        }
        catch (IOException iOException) {
            CommandSenderBridge_5.error("Failed to close zip file after protection.", iOException);
        }
    }

    @Deprecated
    public static byte[] B(File file) {
        byte[] byArray = Files.readAllBytes(file.toPath());
        bi bi2 = be.g(byArray);
        if (bi2.yv() == bj.APPLIED || bi2.yv() == bj.ALREADY_PROCESSED) {
            return bi2.zT();
        }
        throw new IOException(bi2.xQ());
    }

    @Deprecated
    public static byte[] x(JSONObject jSONObject) {
        Object object3;
        block16: {
            Object object2;
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject.containsKey("parent")) {
                object2 = "parent\u200b";
                object3 = ch.AO();
                jSONObject2.put(object2, (Object)("minecraft:item/" + (String)object3));
            }
            if (jSONObject.containsKey("textures")) {
                object2 = "textures\u200b";
                object3 = new JSONObject();
                object3.put((Object)"layer0", (Object)("minecraft:item/" + ch.AO()));
                jSONObject2.put(object2, object3);
            }
            for (Object object3 : jSONObject.keySet()) {
                Object object4;
                String string;
                Object object5 = jSONObject.get((String)object3);
                if (((String)object3).equals("parent") && object5 instanceof String) {
                    String string2 = (String)object5;
                    string = ch.fU((String)object3);
                    object4 = ch.fU(string2);
                    jSONObject2.put((Object)string, object4);
                    continue;
                }
                if (((String)object3).equals("textures") && object5 instanceof JSONObject) {
                    JSONObject jSONObject3 = (JSONObject)object5;
                    string = new JSONObject();
                    for (String string3 : jSONObject3.keySet()) {
                        Object object6;
                        Object object7 = jSONObject3.get(string3);
                        String string4 = ch.fU(string3);
                        if (object7 instanceof String) {
                            String string5 = (String)object7;
                            object6 = ch.fU(string5);
                        } else {
                            object6 = object7;
                        }
                        Object object8 = object6;
                        string.put((Object)string4, object8);
                    }
                    object4 = ch.fU((String)object3);
                    jSONObject2.put(object4, (Object)string);
                    if (!(Math.random() < 0.3)) continue;
                    jSONObject2.put((Object)ch.fV((String)object3), (Object)string);
                    continue;
                }
                jSONObject2.put(object3, object5);
            }
            object2 = JSONWriter.of((JSONWriter.Feature[])new JSONWriter.Feature[]{JSONWriter.Feature.LargeObject});
            try {
                object2.setRootObject((Object)jSONObject2);
                object2.write(jSONObject2);
                object3 = object2.toString().replace("\\\\", "\\").getBytes(StandardCharsets.UTF_8);
                if (object2 == null) break block16;
            }
            catch (Throwable throwable) {
                try {
                    if (object2 != null) {
                        try {
                            object2.close();
                        }
                        catch (Throwable throwable2) {
                            throwable.addSuppressed(throwable2);
                        }
                    }
                    throw throwable;
                }
                catch (Throwable throwable3) {
                    CommandSenderBridge_5.error("Failed to obfuscate JSON file. Returning non-obfuscated JSON as fallback.", throwable3);
                    return jSONObject.toString().getBytes(StandardCharsets.UTF_8);
                }
            }
            object2.close();
        }
        return object3;
    }

    private static String fU(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (Character.isLetter(c)) {
                stringBuilder.append(String.format("\\u%04x", c));
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static String fV(String string) {
        return string + "\u200b";
    }

    private static String AO() {
        Material[] materialArray = Material.values();
        Material material = materialArray[(int)(Math.random() * (double)materialArray.length)];
        return material.name().toLowerCase();
    }

    private static String fW(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        while (n < string.length()) {
            if (string.charAt(n) == '\\' && n + 5 < string.length() && string.charAt(n + 1) == 'u') {
                String string2 = string.substring(n + 2, n + 6);
                try {
                    int n2 = Integer.parseInt(string2, 16);
                    stringBuilder.append((char)n2);
                    n += 6;
                    continue;
                }
                catch (NumberFormatException numberFormatException) {
                    // empty catch block
                }
            }
            stringBuilder.append(string.charAt(n));
            ++n;
        }
        return stringBuilder.toString();
    }

    public static JSONObject y(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        for (String string : jSONObject.keySet()) {
            if (string.endsWith("\u200b")) continue;
            Object object = jSONObject.get(string);
            String string2 = ch.fW(string);
            if (object instanceof String) {
                String string3 = (String)object;
                String string4 = ch.fW(string3);
                jSONObject2.put((Object)string2, (Object)string4);
                continue;
            }
            if (object instanceof JSONObject) {
                JSONObject jSONObject3 = (JSONObject)object;
                jSONObject2.put((Object)string2, (Object)ch.y(jSONObject3));
                continue;
            }
            jSONObject2.put((Object)string2, object);
        }
        return jSONObject2;
    }
}
