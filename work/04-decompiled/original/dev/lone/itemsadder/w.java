package dev.lone.itemsadder;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.lone.itemsadder.x;
import dev.lone.itemsadder.y;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class w {
    private static final List RV = Arrays.asList("alpha", "beta", "rc", "release", "hotfix");
    private final JavaPlugin RW;
    private final int RX;
    private final String RY;

    public w(JavaPlugin javaPlugin, int n, @NotNull String string) {
        this.RW = javaPlugin;
        this.RX = n;
        this.RY = string;
    }

    public void a(Consumer consumer, Consumer consumer2) {
        Bukkit.getScheduler().runTaskAsynchronously((Plugin)this.RW, () -> {
            try (InputStream inputStream = new URL("https://api.polymart.org/v1/getResourceUpdates?resource_id=" + this.RX).openStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream);){
                JsonObject jsonObject = JsonParser.parseReader(inputStreamReader).getAsJsonObject();
                JsonObject jsonObject2 = jsonObject.getAsJsonObject("response");
                if (!jsonObject2.get("success").getAsBoolean()) {
                    this.RW.getLogger().warning("Update check failed: API returned error.");
                    return;
                }
                JsonArray jsonArray = jsonObject2.getAsJsonArray("updates");
                if (jsonArray == null || jsonArray.isEmpty()) {
                    this.RW.getLogger().warning("Update check failed: No updates found.");
                    return;
                }
                JsonObject jsonObject3 = jsonArray.get(0).getAsJsonObject();
                int n = jsonObject3.get("id").getAsInt();
                String string = jsonObject3.get("version").getAsString();
                String string2 = jsonObject3.get("title").getAsString();
                long l = jsonObject3.get("time").getAsLong();
                int n2 = 0;
                for (JsonElement jsonElement : jsonArray) {
                    JsonObject jsonObject4 = jsonElement.getAsJsonObject();
                    String string3 = jsonObject4.get("version").getAsString();
                    if (string3.equals(this.RY)) {
                        int n3 = jsonObject4.get("id").getAsInt();
                        if (n3 != n) {
                            x x2 = new x(string, string2, l, n, n2);
                            consumer.accept(x2);
                        } else {
                            x x3 = new x(string, string2, l, n, 0);
                            consumer2.accept(x3);
                        }
                        return;
                    }
                    ++n2;
                }
                x x4 = new x(string, string2, l, n, n2);
                if (this.C(this.RY, string) < 0) {
                    consumer.accept(x4);
                } else {
                    consumer2.accept(x4);
                }
            }
            catch (Exception exception) {
                this.RW.getLogger().warning("Update check error: " + exception.getMessage());
            }
        });
    }

    private int C(String string, String string2) {
        y y2 = this.dg(string);
        y y3 = this.dg(string2);
        int n = this.D(y2.kJ, y3.kJ);
        if (n != 0) {
            return n;
        }
        int n2 = Integer.compare(RV.indexOf(y2.Sd), RV.indexOf(y3.Sd));
        if (n2 != 0) {
            return n2;
        }
        return Integer.compare(y2.Se, y3.Se);
    }

    private y dg(String string) {
        String[] stringArray = string.split("-", 3);
        String string2 = stringArray[0];
        String string3 = "release";
        int n = 0;
        if (stringArray.length >= 2) {
            string3 = this.di(stringArray[1]);
        }
        if (stringArray.length == 3) {
            n = this.dh(stringArray[2]);
        }
        return new y(string2, string3, n);
    }

    private int D(String string, String string2) {
        String[] stringArray = string.split("\\.");
        String[] stringArray2 = string2.split("\\.");
        int n = Math.max(stringArray.length, stringArray2.length);
        for (int i = 0; i < n; ++i) {
            int n2;
            int n3 = i < stringArray.length ? this.dh(stringArray[i]) : 0;
            int n4 = n2 = i < stringArray2.length ? this.dh(stringArray2[i]) : 0;
            if (n3 == n2) continue;
            return Integer.compare(n3, n2);
        }
        return 0;
    }

    private int dh(String string) {
        try {
            return Integer.parseInt(string.replaceAll("[^0-9]", ""));
        }
        catch (Exception exception) {
            return 0;
        }
    }

    private String di(String string) {
        if ((string = string.toLowerCase()).contains("alpha")) {
            return "alpha";
        }
        if (string.contains("beta")) {
            return "beta";
        }
        if (string.contains("rc")) {
            return "rc";
        }
        if (string.contains("release")) {
            return "release";
        }
        if (string.contains("hotfix")) {
            return "hotfix";
        }
        return "release";
    }
}
