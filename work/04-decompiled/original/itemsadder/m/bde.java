package itemsadder.m;

import itemsadder.m.bce;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class bde {
    public List Lm;
    boolean all;
    List aBs = Collections.synchronizedList(new ArrayList());
    List aBt = Collections.synchronizedList(new ArrayList());

    public bde(List list) {
        this.Lm = list;
        if (this.Lm.contains("*")) {
            this.all = true;
            list.removeIf(string -> string.equals("*"));
        } else {
            this.all = false;
        }
        Bukkit.getWorlds().forEach(world -> this.Lm.forEach(string -> {
            if (string.startsWith("!")) {
                if (FilenameUtils.wildcardMatch((String)world.getName(), (String)string.substring(1))) {
                    this.aBt.add(world.getUID());
                }
            } else if (FilenameUtils.wildcardMatch((String)world.getName(), (String)string)) {
                this.aBs.add(world.getUID());
            }
        }));
        for (World world2 : Bukkit.getWorlds()) {
            this.w(world2);
        }
    }

    private void w(World world) {
        if (!this.x(world) && world.getWorldFolder().toPath().resolve("itemsadder").toFile().exists()) {
            bce.warn(" ");
            bce.warn("[!] The world '" + world.getName() + "' contains ItemsAdder data, but it's not in the worlds list in config.yml of ItemsAdder.");
            bce.warn("[!] The data might get lost because custom blocks events won't get triggered anymore.");
            bce.warn("[!] Make sure to know what you're doing or delete the 'itemsadder' folder from the world folder if you don't need it anymore.");
            bce.warn(" ");
        }
    }

    public boolean x(World world) {
        if (this.all && this.aBt.isEmpty()) {
            return true;
        }
        for (UUID uUID : this.aBt) {
            if (uUID == null || !uUID.equals(world.getUID())) continue;
            return false;
        }
        for (UUID uUID : this.aBs) {
            if (uUID == null || !uUID.equals(world.getUID())) continue;
            return true;
        }
        return this.all;
    }

    public void y(World world) {
        if (!this.x(world)) {
            this.aBs.remove(world.getUID());
            this.aBt.add(world.getUID());
            return;
        }
        this.aBs.add(world.getUID());
        this.aBt.remove(world.getUID());
        this.w(world);
    }

    public void f(World world) {
        this.aBs.remove(world.getUID());
        this.aBt.remove(world.getUID());
    }
}
