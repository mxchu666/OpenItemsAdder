package dev.lone.itemsadder;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.v;
import itemsadder.m.bce;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public final class u {
    private static final String RI = "https://api.github.com/repos/dmulloy2/ProtocolLib/releases?per_page=100";
    private static final String RJ = "https://api.github.com/repos/dmulloy2/ProtocolLib/contents/gradle.properties?ref=";
    private static final String RK = "https://api.github.com/repos/dmulloy2/ProtocolLib/compare/";
    public static final String RL = "https://github.com/dmulloy2/ProtocolLib/releases/download/dev-build/ProtocolLib.jar";
    private static final String RM = "dda284c";
    private static final String RN = "Development Build (dda284c)";
    private static final Pattern RO = Pattern.compile("(?i)(?:^|-)([0-9a-f]{7,40})$");
    private static final Pattern RP = Pattern.compile("(?i)\\[([0-9a-f]{7,40})]");
    private static final HttpClient RQ = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5L)).build();

    private u() {
    }

    public static void sj() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("ProtocolLib");
        if (plugin == null) {
            return;
        }
        String string = plugin.getDescription().getVersion();
        Bukkit.getScheduler().runTaskLaterAsynchronously((Plugin)Main.rS(), () -> {
            block3: {
                try {
                    JsonArray jsonArray = u.dd(RI).getAsJsonArray();
                    v v2 = u.a(jsonArray);
                    String string2 = u.db(v2.sl());
                    if (u.a(string, jsonArray, v2.sl())) {
                        return;
                    }
                    u.B(string, string2 + " [" + v2.fN() + ", ref " + v2.sl() + "]");
                }
                catch (Exception exception) {
                    if (string.contains(RM)) break block3;
                    u.B(string, RN);
                }
            }
        }, 1L);
    }

    static v a(JsonArray jsonArray) {
        v v2 = null;
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if (jsonObject.get("draft").getAsBoolean()) continue;
            v v3 = u.a(jsonObject);
            if (v2 != null && !v3.sm().isAfter(v2.sm())) continue;
            v2 = v3;
        }
        if (v2 == null) {
            throw new IllegalArgumentException("GitHub returned no ProtocolLib releases");
        }
        return v2;
    }

    static v a(String string, JsonArray jsonArray) {
        String string2 = u.de(string);
        for (JsonElement jsonElement : jsonArray) {
            v v2;
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if (jsonObject.get("draft").getAsBoolean() || !string2.equals(u.de((v2 = u.a(jsonObject)).sk())) && !string2.equals(u.de(v2.fN()))) continue;
            return v2;
        }
        return null;
    }

    static String da(String string) {
        Matcher matcher = RO.matcher(string);
        return matcher.find() ? matcher.group(1) : null;
    }

    private static boolean a(String string, JsonArray jsonArray, String string2) {
        String string3;
        v v2;
        String string4 = u.da(string);
        v v3 = v2 = string4 == null ? u.a(string, jsonArray) : null;
        String string5 = string4 != null ? string4 : (string3 = v2 == null ? null : v2.sl());
        if (string3 == null || !u.A(string, u.db(string3))) {
            return false;
        }
        JsonObject jsonObject = u.dd(RK + u.dc(string3) + "..." + u.dc(string2)).getAsJsonObject();
        return jsonObject.get("ahead_by").getAsInt() == 0;
    }

    private static v a(JsonObject jsonObject) {
        String string = jsonObject.get("tag_name").getAsString();
        String string2 = jsonObject.get("name").isJsonNull() ? string : jsonObject.get("name").getAsString();
        String string3 = string.equals("dev-build") ? u.b(jsonObject) : string;
        Instant instant = Instant.parse(jsonObject.get("published_at").getAsString());
        for (JsonElement jsonElement : jsonObject.getAsJsonArray("assets")) {
            Instant instant2 = Instant.parse(jsonElement.getAsJsonObject().get("updated_at").getAsString());
            if (!instant2.isAfter(instant)) continue;
            instant = instant2;
        }
        return new v(string2, string, string3, instant);
    }

    static String b(JsonObject jsonObject) {
        Matcher matcher = RP.matcher(jsonObject.get("body").getAsString());
        String string = null;
        while (matcher.find()) {
            string = matcher.group(1);
        }
        if (string == null) {
            throw new IllegalArgumentException("ProtocolLib dev-build release has no commit");
        }
        return string;
    }

    private static String db(String string) {
        return u.c(u.dd(RJ + u.dc(string)).getAsJsonObject());
    }

    static String c(JsonObject jsonObject) {
        byte[] byArray = Base64.getMimeDecoder().decode(jsonObject.get("content").getAsString());
        Properties properties = new Properties();
        properties.load(new StringReader(new String(byArray, StandardCharsets.UTF_8)));
        String string = properties.getProperty("version");
        if (string == null || string.isBlank()) {
            throw new IOException("ProtocolLib gradle.properties has no version");
        }
        return string.trim();
    }

    static boolean A(String string, String string2) {
        String string3;
        String string4 = u.de(string);
        return string4.equals(string3 = u.de(string2)) || string4.startsWith(string3 + "-");
    }

    private static String dc(String string) {
        return URLEncoder.encode(string, StandardCharsets.UTF_8);
    }

    private static JsonElement dd(String string) {
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(string)).timeout(Duration.ofSeconds(5L)).header("Accept", "application/vnd.github+json").header("User-Agent", "ItemsAdder").build();
        try {
            HttpResponse<String> httpResponse = RQ.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (httpResponse.statusCode() != 200) {
                throw new IOException("GitHub returned HTTP " + httpResponse.statusCode());
            }
            return JsonParser.parseString(httpResponse.body());
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            throw new IOException("GitHub request interrupted", interruptedException);
        }
    }

    private static String de(String string) {
        return string.toLowerCase(Locale.ROOT).replace("protocollib", "").trim().replaceFirst("^v", "");
    }

    private static void B(String string, String string2) {
        bce.warn(" ");
        bce.warn(String.valueOf(ChatColor.RED) + "\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588");
        bce.warn(String.valueOf(ChatColor.RED) + "\u2588\u2588                                                                \u2588\u2588");
        bce.warn(String.valueOf(ChatColor.RED) + "\u2588\u2588                 PROTOCOLLIB IS OUTDATED                        \u2588\u2588");
        bce.warn(String.valueOf(ChatColor.RED) + "\u2588\u2588                                                                \u2588\u2588");
        bce.warn(String.valueOf(ChatColor.RED) + "\u2588\u2588  Installed: " + string);
        bce.warn(String.valueOf(ChatColor.RED) + "\u2588\u2588  Latest GitHub build: " + string2);
        bce.warn(String.valueOf(ChatColor.RED) + "\u2588\u2588  Outdated builds break custom entity mount bones and cleanup.");
        bce.warn(String.valueOf(ChatColor.RED) + "\u2588\u2588  Download: https://github.com/dmulloy2/ProtocolLib/releases/download/dev-build/ProtocolLib.jar");
        bce.warn(String.valueOf(ChatColor.RED) + "\u2588\u2588                                                                \u2588\u2588");
        bce.warn(String.valueOf(ChatColor.RED) + "\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588");
        bce.warn(" ");
    }
}
