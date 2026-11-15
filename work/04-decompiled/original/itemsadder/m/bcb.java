package itemsadder.m;

import itemsadder.m.bce;
import itemsadder.m.bdh;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.yaml.snakeyaml.parser.ParserException;

public class bcb {
    final Plugin aAK;
    private FileConfiguration azM;
    private final String aAL;
    private final File aAM;
    private String TD;
    private boolean aws;
    private boolean azS;

    public static bcb a(Plugin plugin, String string) {
        try {
            bcb bcb2 = new bcb(plugin, true, string, true, null);
            if (bcb2.aws) {
                return bcb2;
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            // empty catch block
        }
        return null;
    }

    public bcb(Plugin plugin, boolean bl, String string, boolean bl2, @Nullable Character c) {
        this.aAK = plugin;
        if (bl) {
            this.TD = string;
            this.aAL = String.valueOf(plugin.getDataFolder()) + File.separator + string;
        } else {
            this.TD = string.replace(plugin.getDataFolder().getAbsolutePath(), "");
            this.aAL = string;
        }
        this.TD = this.TD.replace("\\", "/");
        if (!new File(this.aAL).exists()) {
            throw new FileNotFoundException();
        }
        this.aAM = new File(this.aAL);
        if (!this.aAM.exists()) {
            throw new FileNotFoundException();
        }
        try {
            this.azM = bcb.a(this.aAM, c);
            this.aws = true;
        }
        catch (InvalidConfigurationException | ParserException throwable) {
            Bukkit.getLogger().log(Level.WARNING, "Cannot load file: " + this.TD);
            if (bl2) {
                throwable.printStackTrace();
            } else {
                bce.warn("Error: " + throwable.getMessage());
            }
            this.aws = false;
        }
        catch (Throwable throwable) {
            Bukkit.getLogger().log(Level.SEVERE, "Cannot load file: " + this.TD);
            throwable.printStackTrace();
            this.aws = false;
        }
    }

    public boolean CD() {
        return this.aws;
    }

    public boolean CE() {
        return this.azS;
    }

    @NotNull
    public static YamlConfiguration a(@NotNull File file, @Nullable Character c) {
        Validate.notNull((Object)file, (String)"File cannot be null");
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        if (c != null) {
            yamlConfiguration.options().pathSeparator(c.charValue());
        }
        try {
            bdh.a(yamlConfiguration, file);
        }
        catch (FileNotFoundException fileNotFoundException) {
            // empty catch block
        }
        return yamlConfiguration;
    }

    public File getFile() {
        return this.aAM;
    }

    public void reload() {
        this.azM = YamlConfiguration.loadConfiguration((File)this.aAM);
    }

    public FileConfiguration CI() {
        return this.azM;
    }

    public String qd() {
        return this.aAL;
    }

    public String nh() {
        return this.TD;
    }

    public void d(String string, Object object) {
        this.azM.set(string, object);
        this.azS = true;
    }

    public void CJ() {
        if (!this.azS) {
            return;
        }
        this.save();
    }

    public void save() {
        try {
            this.azM.save(this.aAM);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void E(File file) {
        try {
            this.azM.save(file);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public boolean gP(String string) {
        return this.azM.contains(string);
    }

    public void gQ(String string) {
        this.azM.set(string, null);
        this.azS = true;
    }

    public Object e(String string, Object object) {
        if (this.gP(string)) {
            return this.azM.get(string);
        }
        return object;
    }

    public String gV(String string) {
        return this.azM.getString(string);
    }

    public String az(String string, String string2) {
        if (!this.gP(string)) {
            return string2;
        }
        return this.azM.getString(string);
    }

    public int gW(String string) {
        return this.azM.getInt(string);
    }

    public int t(String string, int n) {
        if (this.gP(string)) {
            return this.azM.getInt(string);
        }
        return n;
    }

    public double b(String string, double d) {
        if (this.gP(string)) {
            return this.azM.getDouble(string);
        }
        return d;
    }

    public float a(String string, float f) {
        if (this.gP(string)) {
            return (float)this.azM.getDouble(string);
        }
        return f;
    }

    public float gX(String string) {
        return this.a(string, 0.0f);
    }

    public boolean hq(String string) {
        return this.azM.getBoolean(string);
    }

    public Boolean a(String string, Boolean bl) {
        if (this.gP(string)) {
            return this.azM.getBoolean(string);
        }
        return bl;
    }

    public char CL() {
        return this.CI().options().pathSeparator();
    }
}
