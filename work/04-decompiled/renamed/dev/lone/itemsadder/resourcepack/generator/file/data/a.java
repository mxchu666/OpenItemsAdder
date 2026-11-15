package dev.lone.itemsadder.resourcepack.generator.file.data;

import itemsadder.m.ColorBridge;
import java.io.File;
import lombok.Generated;

public class a {
    public final String ayo;
    public String axe;

    public a(String string, String string2) {
        if (string2.contains("#")) {
            throw new IllegalArgumentException("Special references are not accepted! '" + string2 + "'");
        }
        this.axe = string2;
        this.ayo = ColorBridge.iR(string);
    }

    public a(File file, String string) {
        this(file.getAbsolutePath(), string);
    }

    public a BD() {
        return new a(this.ayo, this.axe);
    }

    public int hashCode() {
        return this.axe.hashCode();
    }

    public File BE() {
        return new File(this.ayo);
    }

    public String pD() {
        String[] stringArray = this.axe.split(":");
        if (stringArray.length == 1) {
            return "minecraft";
        }
        return stringArray[0];
    }

    public String mj() {
        String[] stringArray = this.axe.split(":");
        if (stringArray.length == 1) {
            return this.axe;
        }
        return stringArray[1];
    }

    public String toString() {
        return this.ayo + " | " + this.axe;
    }

    public String BF() {
        return "assets/" + this.pD() + "/textures/" + this.mj() + ".png";
    }

    public boolean BG() {
        return a.gf(this.axe);
    }

    public static boolean gf(String string) {
        return string.startsWith("#");
    }

    @Generated
    public String BH() {
        return this.axe;
    }

    @Generated
    public void gg(String string) {
        this.axe = string;
    }
}
