package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.resourcepack.bj;
import dev.lone.itemsadder.resourcepack.y;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.zw;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.Nullable;

final class x {
    private final Map arR = new LinkedHashMap();

    x() {
    }

    void a(String string, bj bj2, String string2) {
        this.arR.putIfAbsent(bcy.iR(string), new y(bj2, string2));
    }

    void T(String string, @Nullable String string2) {
        String string3 = bcy.iR(string);
        if (!string3.toLowerCase(Locale.ROOT).endsWith(".png")) {
            return;
        }
        this.arR.put(string3, new y(bj.WRITE_ERROR, "write error"));
    }

    int a(bj bj2) {
        return (int)this.arR.values().stream().filter(y2 -> y2.yv() == bj2).count();
    }

    int size() {
        return this.arR.size();
    }

    void L() {
        if (!zw.sW()) {
            return;
        }
        if (this.arR.isEmpty()) {
            return;
        }
        int n = this.a(bj.APPLIED);
        int n2 = this.a(bj.ALREADY_PROCESSED);
        int n3 = this.a(bj.UNSUPPORTED_FORMAT) + this.a(bj.NOT_NEEDED);
        int n4 = this.a(bj.INVALID_PNG) + this.a(bj.READ_ERROR) + this.a(bj.WRITE_ERROR);
        String string = "PNG obfuscation: " + n + " processed, " + n2 + " already protected, " + n3 + " skipped, " + n4 + " failed.";
        if (n4 == 0) {
            bce.log(String.valueOf(ChatColor.AQUA) + "### [DEV MODE LOG] " + string);
        } else {
            bce.warn(String.valueOf(ChatColor.AQUA) + "### [DEV MODE LOG] " + string);
        }
        this.a("skipped", false, EnumSet.of(bj.UNSUPPORTED_FORMAT, bj.NOT_NEEDED));
        this.a("failed", true, EnumSet.of(bj.INVALID_PNG, bj.READ_ERROR, bj.WRITE_ERROR));
    }

    private void a(String string2, boolean bl, Set set) {
        List<Map.Entry> list = this.arR.entrySet().stream().filter(entry -> set.contains((Object)((y)entry.getValue()).yv())).toList();
        if (list.isEmpty()) {
            return;
        }
        Map map = list.stream().collect(Collectors.groupingBy(entry -> ((y)entry.getValue()).xQ(), TreeMap::new, Collectors.counting()));
        StringBuilder stringBuilder = new StringBuilder("PNG obfuscation ").append(string2).append(' ').append(list.size()).append(" files:");
        map.forEach((string, l) -> stringBuilder.append("\n- ").append((String)string).append(": ").append(l));
        stringBuilder.append("\nFiles:");
        list.forEach(entry -> stringBuilder.append("\n- ").append((String)entry.getKey()));
        if (bl) {
            bce.iB(stringBuilder.toString());
        } else if (zw.sW()) {
            bce.log(String.valueOf(ChatColor.AQUA) + "### [DEV MODE LOG] " + String.valueOf(ChatColor.RESET) + String.valueOf(stringBuilder));
        }
    }
}
