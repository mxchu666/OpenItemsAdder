package dev.lone.itemsadder.resourcepack.generator.file.data;

import beer.devs.fastnbt.nms.Version;
import dev.lone.itemsadder.resourcepack.generator.file.data.f;
import org.bukkit.Material;

public class d
extends f {
    public d(String string) {
        super(string);
    }

    public d(String string, Version version) {
        super(string, version);
    }

    public d(Material material) {
        super("assets/minecraft/items/" + material.toString().toLowerCase() + ".json");
    }

    public static d e(String string, Version version) {
        return new d("assets/minecraft/items/" + string + ".json", version);
    }
}
