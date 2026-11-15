package dev.lone.itemsadder.resourcepack.generator.file.data;

import beer.devs.fastnbt.nms.Version;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.f;
import itemsadder.m.VersionHelper_2;
import java.util.Map;
import lombok.Generated;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public class e
extends f {
    private final String ayr;

    e(String string, Version version, boolean bl) {
        super("assets/minecraft/models/" + (bl ? "block" : "item") + "/" + string.toLowerCase() + ".json", version);
        this.ayr = "minecraft:item/" + string.toLowerCase();
    }

    e(Material material, Version version, boolean bl) {
        super("assets/minecraft/models/" + (bl ? "block" : "item") + "/" + material.toString().toLowerCase() + ".json", version);
        this.ayr = "minecraft:item/" + material.toString().toLowerCase();
    }

    public static e gj(String string) {
        return e.f(string, Version.get());
    }

    public static e f(String string, Version version) {
        e e2 = new e(string, version, false);
        if (!e2.BN()) {
            return e2;
        }
        return new e(string, version, true);
    }

    public static e R(Material material) {
        return e.f(material.toString(), Version.get());
    }

    public static e a(Material material, Version version) {
        return e.a(material, version, false);
    }

    public static e a(Material material, Version version, boolean bl) {
        e e2 = new e(material, version, false);
        if (!e2.BN()) {
            return e2;
        }
        e2 = new e(material, version, true);
        if (!e2.BN()) {
            return e2;
        }
        if (bl) {
            for (Version version2 : VersionHelper_2.go) {
                e e3 = new e(material, version2, false);
                System.out.println(String.valueOf(version2) + " -> " + e3.BN());
                if (e3.BN()) continue;
                System.out.println("FOUND: " + String.valueOf(version2));
                return e3;
            }
        }
        return e2;
    }

    public @UnknownNullability String oC() {
        return ((JSONObject)this.ayp).getString("parent");
    }

    public boolean BI() {
        return ((JSONObject)this.ayp).containsKey("display");
    }

    public @UnknownNullability JSONObject BJ() {
        return ((JSONObject)this.ayp).getJSONObject("display");
    }

    public @UnknownNullability JSONObject BK() {
        return ((JSONObject)this.ayp).getJSONObject("textures");
    }

    public boolean BL() {
        return ((JSONObject)this.ayp).containsKey("textures");
    }

    public int BM() {
        if (!this.BL()) {
            return 0;
        }
        return this.BK().size();
    }

    @Nullable
    public String BS() {
        if (!this.BL()) {
            return null;
        }
        return (String)((Map.Entry)this.BK().entrySet().stream().findFirst().get()).getKey();
    }

    @Generated
    public String BT() {
        return this.ayr;
    }
}
