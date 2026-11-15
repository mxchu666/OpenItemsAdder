package itemsadder.m;

import itemsadder.m.bbe;
import itemsadder.m.bbf;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class bbw
extends bbf {
    bbf aAz;

    public bbw(Plugin plugin, String string, boolean bl) {
        super(plugin, true, "lang/" + string + ".yml", bl, true);
        this.iq(string);
    }

    private void iq(String string2) {
        if (!string2.equals("en")) {
            this.aAz = new bbf(this.azL, true, "lang/en.yml", true, true, false);
            this.aAz.CK().forEach(string -> {
                if (!this.gP((String)string)) {
                    this.d((String)string, this.aAz.gV((String)string));
                }
            });
            this.save();
        }
    }

    public String ir(String string) {
        return this.aD(string, null);
    }

    public String aD(String string, String string2) {
        if (this.gP(string)) {
            return this.he(string);
        }
        if (this.aAz != null && this.aAz.gP(string)) {
            return this.aAz.he(string);
        }
        this.gO(string);
        return string2;
    }

    public String f(String string, String string2, boolean bl) {
        if (this.gP(string)) {
            return this.he(string);
        }
        if (this.aAz != null && this.aAz.gP(string)) {
            return this.aAz.he(string);
        }
        if (bl) {
            this.gO(string);
        }
        return string2;
    }

    @Nullable
    String is(String string) {
        if (this.gP(string)) {
            return this.gV(string);
        }
        if (this.aAz != null && this.aAz.gP(string)) {
            return this.aAz.gV(string);
        }
        this.gO(string);
        return null;
    }

    public Component it(String string) {
        String string2 = this.is(string);
        return bbe.gK(string2 != null ? string2 : string);
    }

    public String c(String string, Player player) {
        return this.ir(string).replace("{player}", player.getName());
    }
}
