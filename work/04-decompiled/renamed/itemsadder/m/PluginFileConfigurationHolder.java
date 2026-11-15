package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.SoundCategoryBridge;
import itemsadder.m.YamlConfigurationBridge;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.logging.Level;
import net.kyori.adventure.text.Component;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.yaml.snakeyaml.parser.ParserException;

public class PluginFileConfigurationHolder {
    final Plugin azL;
    private boolean aws;
    private FileConfiguration azM;
    private final String azN;
    private final File azO;
    private boolean azP = true;
    private boolean azQ = false;
    private String TD;
    private boolean azR;
    private boolean azS;
    @Nullable
    private Long azT = null;

    public PluginFileConfigurationHolder(Plugin plugin, boolean bl, String string, boolean bl2, boolean bl3, @Nullable Character c) {
        this(plugin, bl, string, bl2, bl3, true, c);
    }

    public PluginFileConfigurationHolder(Plugin plugin, boolean bl, String string, boolean bl2, boolean bl3) {
        this(plugin, bl, string, bl2, bl3, true);
    }

    public PluginFileConfigurationHolder(Plugin plugin, boolean bl, String string, boolean bl2, boolean bl3, boolean bl4) {
        this(plugin, bl, string, bl2, bl3, bl4, false, null);
    }

    public PluginFileConfigurationHolder(Plugin plugin, boolean bl, String string, boolean bl2, boolean bl3, boolean bl4, @Nullable Character c) {
        this(plugin, bl, string, bl2, bl3, bl4, false, c);
    }

    public PluginFileConfigurationHolder(Plugin plugin, boolean bl, String string, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this(plugin, bl, string, bl2, bl3, bl4, bl5, null);
    }

    public PluginFileConfigurationHolder(Plugin plugin, boolean bl, String string, boolean bl2, boolean bl3, boolean bl4, boolean bl5, @Nullable Character c) {
        this.azL = plugin;
        this.azR = bl4;
        if (bl) {
            this.TD = string;
            this.azN = String.valueOf(plugin.getDataFolder()) + File.separator + string;
        } else {
            this.TD = string.replace(plugin.getDataFolder().getAbsolutePath(), "");
            this.azN = string;
        }
        this.TD = this.TD.replace("\\", "/");
        if (!new File(this.azN).exists()) {
            new File(this.azN).getParentFile().mkdirs();
        }
        this.azP = bl2;
        this.azQ = bl3;
        this.azO = new File(this.azN);
        try {
            this.azM = PluginFileConfigurationHolder.a(this.azO, c);
            this.CH();
            this.aws = true;
        }
        catch (InvalidConfigurationException | ParserException throwable) {
            Bukkit.getLogger().log(Level.WARNING, "Cannot load file: " + this.TD);
            if (bl5) {
                throwable.printStackTrace();
            } else {
                CommandSenderBridge_5.warn("Error: " + throwable.getMessage());
            }
            this.aws = false;
        }
        catch (Throwable throwable) {
            Bukkit.getLogger().log(Level.SEVERE, "Cannot load file: " + this.TD);
            throwable.printStackTrace();
            this.aws = false;
        }
    }

    public PluginFileConfigurationHolder(Plugin plugin, boolean bl, String string, boolean bl2) {
        this(plugin, bl, string, bl2, false, null);
    }

    public PluginFileConfigurationHolder(Plugin plugin, boolean bl, String string, boolean bl2, @Nullable Character c) {
        this(plugin, bl, string, bl2, false, c);
    }

    public static PotionType gL(String string) {
        if (string == null) {
            return null;
        }
        PotionType potionType = (PotionType)SoundCategoryBridge.e(string.replace("minecraft:", "").toUpperCase(), PotionType.class);
        if (potionType == null) {
            for (PotionType potionType2 : PotionType.values()) {
                if (potionType2.getKey() == null || !potionType2.getKey().toString().equalsIgnoreCase(string)) continue;
                return potionType2;
            }
        }
        return potionType;
    }

    @Nullable
    public static NamespacedKey a(String object, String string, boolean bl, Consumer consumer) {
        if (object == null) {
            return null;
        }
        if (!((String)object).contains(":")) {
            object = string + ":" + (String)object;
        }
        try {
            return NamespacedKey.fromString((String)object);
        }
        catch (Exception exception) {
            if (bl) {
                return null;
            }
            consumer.accept(object);
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public static EquipmentSlot a(String string, @Nullable Consumer consumer) {
        EquipmentSlot equipmentSlot = null;
        try {
            EquipmentSlot equipmentSlot2 = equipmentSlot = PluginFileConfigurationHolder.gM(string);
            return equipmentSlot2;
        }
        finally {
            if (consumer != null && equipmentSlot == null) {
                consumer.accept(string);
            }
        }
    }

    @Nullable
    public static EquipmentSlot gM(String string) {
        return SoundCategoryBridge.ik(string);
    }

    @Nullable
    public static String a(String string, boolean bl, Runnable runnable) {
        if (string == null) {
            if (!bl) {
                runnable.run();
            }
            return null;
        }
        return string;
    }

    @Nullable
    public static List a(List list, Class clazz, boolean bl, boolean bl2, Consumer consumer) {
        ArrayList<Enum> arrayList = new ArrayList<Enum>();
        for (String string : list) {
            Enum enum_ = SoundCategoryBridge.e(string, clazz);
            if (enum_ == null) {
                if (bl) continue;
                consumer.accept(string);
                if (!bl2) {
                    return null;
                }
            }
            arrayList.add(enum_);
        }
        return arrayList;
    }

    public List gN(String string) {
        return this.x(string, false);
    }

    public List x(String string, boolean bl) {
        if (!this.gP(string)) {
            return new ArrayList();
        }
        return new ArrayList(this.azM.getConfigurationSection(string).getKeys(bl));
    }

    public static List b(ConfigurationSection configurationSection) {
        return PluginFileConfigurationHolder.a(configurationSection, "");
    }

    public static List a(ConfigurationSection configurationSection, String string) {
        if (!configurationSection.contains(string)) {
            return new ArrayList();
        }
        return new ArrayList(configurationSection.getKeys(false));
    }

    public static List b(ConfigurationSectionBridge configurationSectionBridge, String string) {
        if (!configurationSectionBridge.fo(string)) {
            return new ArrayList();
        }
        return new ArrayList(configurationSectionBridge.aX(false));
    }

    public static List e(ConfigurationSectionBridge configurationSectionBridge) {
        return PluginFileConfigurationHolder.b(configurationSectionBridge, "");
    }

    public boolean CD() {
        return this.aws;
    }

    public boolean CE() {
        return this.azS;
    }

    public Long CF() {
        if (this.azT != null) {
            return this.azT;
        }
        this.azT = this.getFile().lastModified();
        return this.azT;
    }

    @NotNull
    public static YamlConfiguration a(@NotNull File file, @Nullable Character c) {
        Validate.notNull((Object)file, (String)"File cannot be null");
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        if (c != null) {
            yamlConfiguration.options().pathSeparator(c.charValue());
        }
        yamlConfiguration.options().width(99999);
        try {
            YamlConfigurationBridge.a(yamlConfiguration, file);
        }
        catch (FileNotFoundException fileNotFoundException) {
            // empty catch block
        }
        return yamlConfiguration;
    }

    private PluginFileConfigurationHolder(Plugin plugin, String string) {
        this.azL = plugin;
        this.azN = string;
        this.azO = new File(this.azN);
        this.azM = YamlConfiguration.loadConfiguration((File)this.azO);
    }

    private PluginFileConfigurationHolder(Plugin plugin, String string, char c) {
        this.azL = plugin;
        this.azN = string;
        this.azO = new File(this.azN);
        this.azM = PluginFileConfigurationHolder.a(this.azO, Character.valueOf(c));
    }

    public PluginFileConfigurationHolder CG() {
        PluginFileConfigurationHolder pluginFileConfigurationHolder = new PluginFileConfigurationHolder(this.azL, this.azN);
        pluginFileConfigurationHolder.TD = this.TD;
        pluginFileConfigurationHolder.azP = this.azP;
        pluginFileConfigurationHolder.azQ = this.azQ;
        return pluginFileConfigurationHolder;
    }

    public PluginFileConfigurationHolder g(char c) {
        PluginFileConfigurationHolder pluginFileConfigurationHolder = new PluginFileConfigurationHolder(this.azL, this.azN, c);
        pluginFileConfigurationHolder.CI().options().pathSeparator(c);
        return pluginFileConfigurationHolder;
    }

    public File getFile() {
        return this.azO;
    }

    public void reload() {
        this.azM = YamlConfiguration.loadConfiguration((File)this.azO);
    }

    public void CH() {
        block7: {
            if (this.azP) {
                String string = this.azN.replace("plugins/" + this.azL.getName() + "/", "").replace("plugins\\" + this.azL.getName() + "\\", "").replace("plugins\\" + this.azL.getName() + "/", "");
                try {
                    if (!this.azO.exists()) {
                        FileUtils.copyInputStreamToFile((InputStream)this.azL.getResource(string), (File)this.azO);
                    } else if (this.azQ) {
                        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration((Reader)new InputStreamReader(this.azL.getResource(string), StandardCharsets.UTF_8));
                        for (String string2 : yamlConfiguration.getKeys(true)) {
                            if (this.azM.contains(string2)) continue;
                            this.azM.set(string2, yamlConfiguration.get(string2));
                        }
                        this.azM.save(this.azO);
                    }
                    this.azM.load(this.azO);
                }
                catch (IOException | NullPointerException | InvalidConfigurationException throwable) {
                    if (!this.azR) break block7;
                    CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "Using custom language file '" + this.azN + "'");
                }
            }
        }
    }

    public FileConfiguration CI() {
        return this.azM;
    }

    public String qd() {
        return this.azN;
    }

    public String nh() {
        return this.TD;
    }

    public static String D(File file) {
        return file.getAbsolutePath().replace(Main.rT().getDataFolder().getAbsolutePath(), "");
    }

    public static String gH(String string) {
        return ColorBridge.gH(string).replace("\\n", "\n");
    }

    protected void gO(String string) {
        CommandSenderBridge_5.error("MISSING FILE PROPERTY! '" + string + "' in file '" + this.azN + "'");
    }

    public void d(String string, Object object) {
        this.azM.set(string, object);
        this.azS = true;
    }

    public void CJ() {
        if (!this.azS) {
            return;
        }
        try {
            this.azM.save(this.azO);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void save() {
        try {
            this.azM.save(this.azO);
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

    public List CK() {
        return this.y("", false);
    }

    public List gR(String string) {
        return this.y(string, false);
    }

    public List y(String string, boolean bl) {
        if (!this.gP(string)) {
            return new ArrayList();
        }
        return new ArrayList(this.azM.getConfigurationSection(string).getKeys(bl));
    }

    public static List c(ConfigurationSection configurationSection) {
        return PluginFileConfigurationHolder.b(configurationSection, "");
    }

    public static List b(ConfigurationSection configurationSection, String string) {
        if (!configurationSection.contains(string)) {
            return new ArrayList();
        }
        return new ArrayList(configurationSection.getKeys(false));
    }

    public Map gS(String string) {
        if (!this.gP(string)) {
            return null;
        }
        return this.azM.getConfigurationSection(string).getValues(false);
    }

    @Nullable
    public Map gT(String string) {
        if (!this.gP(string)) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        ConfigurationSection configurationSection = this.azM.getConfigurationSection(string);
        if (configurationSection == null) {
            return null;
        }
        String string2 = String.valueOf(this.azM.options().pathSeparator());
        Set set = configurationSection.getKeys(true);
        for (String string3 : set) {
            Object object = configurationSection.get(string3);
            if (object instanceof MemorySection) continue;
            String[] stringArray = string3.split(string2);
            hashMap.put(stringArray[stringArray.length - 1], object);
        }
        return hashMap;
    }

    @Nullable
    public List gU(String string) {
        if (!this.gP(string)) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ConfigurationSection configurationSection = this.azM.getConfigurationSection(string);
        if (configurationSection == null) {
            return null;
        }
        Set set = configurationSection.getKeys(true);
        for (String string2 : set) {
            Object object = configurationSection.get(string2);
            if (object instanceof MemorySection) continue;
            arrayList.add((Integer)object);
        }
        return arrayList;
    }

    public Object e(String string, Object object) {
        return this.azM.get(string, object);
    }

    public String gV(String string) {
        return this.azM.getString(string);
    }

    public String az(String string, String string2) {
        return this.azM.getString(string, string2);
    }

    public int gW(String string) {
        return this.azM.getInt(string);
    }

    public int t(String string, int n) {
        return this.azM.getInt(string, n);
    }

    public double b(String string, double d) {
        return this.azM.getDouble(string, d);
    }

    public float a(String string, float f) {
        return (float)this.azM.getDouble(string, (double)f);
    }

    public float gX(String string) {
        return this.a(string, 0.0f);
    }

    public boolean gY(String string) {
        return this.azM.getBoolean(string);
    }

    public boolean z(String string, boolean bl) {
        return this.azM.getBoolean(string, bl);
    }

    @Nullable
    public Boolean a(String string, @Nullable Boolean bl) {
        if (!this.gP(string)) {
            return bl;
        }
        return this.azM.getBoolean(string, bl != null && bl != false);
    }

    public Material a(String string, Material material) {
        Object object = this.azM.get(string, null);
        if (object instanceof String) {
            object = ((String)object).toUpperCase();
            return (Material)SoundCategoryBridge.b((String)object, Material.class, (Enum)material);
        }
        return material;
    }

    public static Material b(String string, Material material) {
        if (string == null) {
            return null;
        }
        return (Material)SoundCategoryBridge.b(string.toUpperCase(), Material.class, (Enum)material);
    }

    public Material gZ(String string) {
        return this.a(string, (Material)null);
    }

    public PotionEffectType ha(String string) {
        Object object = this.azM.get(string, null);
        if (object instanceof String) {
            return PluginFileConfigurationHolder.hb((String)object);
        }
        return null;
    }

    @Nullable
    public static PotionEffectType hb(String string) {
        return SoundCategoryBridge.ii(string);
    }

    public Enum a(String string, Class clazz, Enum enum_) {
        String string2 = this.gV(string);
        return string2 != null ? SoundCategoryBridge.b(string2.toUpperCase(), clazz, enum_) : enum_;
    }

    public Enum a(String string, Class clazz, Enum enum_, Consumer consumer) {
        Enum enum_2;
        String string2 = this.gV(string);
        Enum enum_3 = enum_2 = string2 != null ? SoundCategoryBridge.b(string2.toUpperCase(), clazz, enum_) : enum_;
        if (enum_2 == null) {
            consumer.accept(string2);
        }
        return enum_2;
    }

    public static Enum a(ConfigurationSection configurationSection, String string, Class clazz) {
        return PluginFileConfigurationHolder.a(configurationSection, string, clazz, null);
    }

    public static Enum a(ConfigurationSection configurationSection, String string, Class clazz, Enum enum_) {
        String string2 = configurationSection.getString(string);
        return string2 != null ? SoundCategoryBridge.b(string2.toUpperCase(), clazz, enum_) : enum_;
    }

    public String hc(String string) {
        if (this.gP(string)) {
            return ChatColor.translateAlternateColorCodes((char)'&', (String)this.gV(string));
        }
        return string;
    }

    public Component hd(String string) {
        if (this.gP(string)) {
            return PluginBridge_6.gF(this.hc(string));
        }
        return PluginBridge_6.gF(string);
    }

    public String aA(String string, String string2) {
        if (this.gP(string)) {
            return PluginBridge_6.gJ(this.gV(string));
        }
        return string2;
    }

    public String he(String string) {
        return this.aA(string, null);
    }

    public String hf(String string) {
        return ChatColor.stripColor((String)this.he(string));
    }

    public String aB(String string, String string2) {
        return ChatColor.stripColor((String)this.aA(string, string2));
    }

    public List A(String string, boolean bl) {
        if (bl) {
            ArrayList<String> arrayList = new ArrayList<String>();
            try {
                ArrayList arrayList2 = (ArrayList)this.azM.getStringList(string);
                for (String string2 : arrayList2) {
                    arrayList.add(PluginBridge_6.gJ(string2));
                }
            }
            catch (NullPointerException nullPointerException) {
                nullPointerException.printStackTrace();
                this.gO(string);
            }
            return arrayList;
        }
        return this.azM.getStringList(string);
    }

    public List hg(String string) {
        return this.A(string, false);
    }

    public Set hh(String string) {
        return new HashSet(this.A(string, false));
    }

    @Nullable
    public ConfigurationSection hi(@NotNull String string) {
        return this.azM.getConfigurationSection(string);
    }

    @Nullable
    public ConfigurationSection k(String ... stringArray) {
        for (String string : stringArray) {
            ConfigurationSection configurationSection = this.hi(string);
            if (configurationSection == null) continue;
            return configurationSection;
        }
        return null;
    }

    @Nullable
    public ConfigurationSectionBridge hj(@NotNull String string) {
        if (!this.gP(string)) {
            return null;
        }
        return new ConfigurationSectionBridge(this.azM.getConfigurationSection(string));
    }

    public ConfigurationSectionBridge hk(@NotNull String string) {
        if (!this.gP(string)) {
            this.azM.createSection(string);
            this.azS = true;
        } else if (!(this.azM.get(string) instanceof ConfigurationSection)) {
            this.azM.set(string, null);
            this.azM.createSection(string);
            this.azS = true;
        }
        return new ConfigurationSectionBridge(this.azM.getConfigurationSection(string));
    }

    @Nullable
    public EntityType a(String string, EntityType entityType, @Nullable Consumer consumer) {
        if (this.gP(string)) {
            String string2 = this.gV(string).toUpperCase();
            try {
                return EntityType.valueOf((String)string2);
            }
            catch (Exception exception) {
                if (consumer != null) {
                    consumer.accept(string2);
                }
                return null;
            }
        }
        return entityType;
    }

    public char CL() {
        return this.CI().options().pathSeparator();
    }

    @Nullable
    public Integer b(String string, @Nullable Integer n) {
        Object object = this.e(string, n);
        if (object instanceof Integer) {
            Integer n2 = (Integer)object;
            return n2;
        }
        return n;
    }

    public /* synthetic */ Object clone() {
        return this.CG();
    }
}
