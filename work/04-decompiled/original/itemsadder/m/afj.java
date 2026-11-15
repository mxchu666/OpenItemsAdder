package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import itemsadder.m.aab;
import itemsadder.m.afk;
import itemsadder.m.bce;
import itemsadder.m.d;
import java.io.File;
import java.io.IOException;
import javax.annotation.Nullable;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;

public final class afj {
    final afk abj = (afk)aab.n(afk.class);
    static afj abk;

    afj() {
    }

    private static afj tF() {
        if (abk == null) {
            abk = new afj();
        }
        return abk;
    }

    public static afk tG() {
        return afj.tF().abj;
    }

    @Deprecated
    public static boolean a(String string, String string2, int n, int n2, int n3) {
        Object object;
        boolean bl = false;
        World world = (World)Bukkit.getServer().getWorlds().get(0);
        File file = new File(world.getWorldFolder(), "datapacks/ia_" + string + "/data/" + string + "/worldgen/biome".replace("/", File.separator));
        File file2 = new File(world.getWorldFolder(), ("datapacks/ia_" + string + "/").replace("/", File.separator));
        if (!file.exists()) {
            file.mkdirs();
            object = "{\n  \"pack\": {\n    \"pack_format\": 6,\n    \"description\": \"ItemsAdder - colored fluids\"\n  }\n}";
            try {
                FileUtils.write((File)new File(file2, "pack.mcmeta"), (CharSequence)object);
            }
            catch (IOException iOException) {
                bce.error("Failed to write pack.mcmeta of " + string + " datapack");
                iOException.printStackTrace();
            }
        }
        object = d.d.fromJson("{\n" + (Version.isAtLeast((Version)Version.v1_21_3) ? "  \"carvers\": [],\n" : "\"carvers\": {},") + "  \"downfall\": 0.4,\n  \"effects\": {\n    \"fog_color\": 12638463,\n    \"mood_sound\": {\n      \"block_search_extent\": 8,\n      \"offset\": 2.0,\n      \"sound\": \"minecraft:ambient.cave\",\n      \"tick_delay\": 6000\n    },\n    \"sky_color\": 7907327,\n    \"water_color\": 4159204,\n    \"water_fog_color\": 329011\n  },\n  \"features\": [\n    [],\n    [],\n    [],\n    [],\n    [],\n    [],\n    [],\n    [],\n    [],\n    [],\n    []\n  ],\n  \"has_precipitation\": true,\n  \"spawn_costs\": {},\n  \"spawners\": {\n    \"ambient\": [],\n    \"axolotls\": [],\n    \"creature\": [],\n    \"misc\": [],\n    \"monster\": [],\n    \"underground_water_creature\": [],\n    \"water_ambient\": [],\n    \"water_creature\": []\n  },\n  \"temperature\": 0.8\n}", JsonObject.class);
        if (n != -1) {
            ((JsonObject)object).getAsJsonObject("effects").addProperty("water_color", n);
        }
        if (n != -1) {
            ((JsonObject)object).getAsJsonObject("effects").addProperty("water_fog_color", n);
        }
        if (n2 != -1) {
            ((JsonObject)object).getAsJsonObject("effects").addProperty("foliage_color", n2);
        }
        if (n3 != -1) {
            ((JsonObject)object).getAsJsonObject("effects").addProperty("grass_color", n3);
        }
        File file3 = new File(file, string2 + ".json");
        try {
            String string3 = d.d.toJson((JsonElement)object);
            if (!file3.exists() || !d.d.fromJson(FileUtils.readFileToString((File)file3), JsonObject.class).equals(object)) {
                FileUtils.write((File)file3, (CharSequence)string3);
                bl = true;
            } else {
                bl = false;
            }
        }
        catch (IOException iOException) {
            bce.error("Failed to write datapack for: " + string + ":" + string2, iOException);
            bl = false;
        }
        return bl;
    }

    @Nullable
    public static Biome bc(Block block) {
        try {
            return block.getBiome();
        }
        catch (NullPointerException nullPointerException) {
            return null;
        }
    }

    public static Biome a(Block block, Biome biome) {
        Biome biome2 = afj.bc(block);
        if (biome2 == null) {
            return biome;
        }
        return biome2;
    }
}
