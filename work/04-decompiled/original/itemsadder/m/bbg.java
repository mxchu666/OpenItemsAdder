package itemsadder.m;

import itemsadder.m.bbf;
import itemsadder.m.bbi;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class bbg {
    public final ConfigurationSection azU;

    public bbg(ConfigurationSection configurationSection) {
        this.azU = configurationSection;
    }

    public bbg(bbf bbf2, String string) {
        this.azU = bbf2.hi(string);
    }

    @NotNull
    public Set aX(boolean bl) {
        return this.azU.getKeys(bl);
    }

    @NotNull
    public Map aY(boolean bl) {
        return this.azU.getValues(bl);
    }

    public boolean fo(@NotNull String string) {
        return this.azU.contains(string);
    }

    public boolean B(@NotNull String string, boolean bl) {
        return this.azU.contains(string, bl);
    }

    public boolean hl(@NotNull String string) {
        return this.azU.isSet(string);
    }

    @Nullable
    public String CM() {
        return this.azU.getCurrentPath();
    }

    @NotNull
    public String getName() {
        return this.azU.getName();
    }

    @Nullable
    public Configuration CN() {
        return this.azU.getRoot();
    }

    @Nullable
    public ConfigurationSection CO() {
        return this.azU.getParent();
    }

    @Nullable
    public Object hm(@NotNull String string) {
        return this.azU.get(string);
    }

    @Nullable
    public Object e(@NotNull String string, @Nullable Object object) {
        return this.azU.get(string, object);
    }

    public void d(@NotNull String string, @Nullable Object object) {
        this.azU.set(string, object);
    }

    @NotNull
    public ConfigurationSection hn(@NotNull String string) {
        return this.azU.createSection(string);
    }

    @NotNull
    public ConfigurationSection e(@NotNull String string, @NotNull Map map) {
        return this.azU.createSection(string, map);
    }

    @Nullable
    public String gV(@NotNull String string) {
        return this.azU.getString(string);
    }

    @Nullable
    public String az(@NotNull String string, @Nullable String string2) {
        return this.azU.getString(string, string2);
    }

    public String aC(@NotNull String string, @NotNull String string2) {
        return this.azU.getString(string, string2);
    }

    public boolean ho(@NotNull String string) {
        return this.azU.isString(string);
    }

    public int gW(@NotNull String string) {
        return this.azU.getInt(string);
    }

    public int t(@NotNull String string, int n) {
        return this.azU.getInt(string, n);
    }

    public Integer c(@NotNull String string, @Nullable Integer n) {
        if (this.azU.contains(string)) {
            return this.azU.getInt(string);
        }
        return n;
    }

    public boolean hp(@NotNull String string) {
        return this.azU.isInt(string);
    }

    public boolean hq(@NotNull String string) {
        return this.azU.getBoolean(string);
    }

    public boolean C(@NotNull String string, boolean bl) {
        return this.azU.getBoolean(string, bl);
    }

    public boolean hr(@NotNull String string) {
        return this.azU.isBoolean(string);
    }

    public double hs(@NotNull String string) {
        return this.azU.getDouble(string);
    }

    public double b(@NotNull String string, double d) {
        return this.azU.getDouble(string, d);
    }

    public boolean ht(@NotNull String string) {
        return this.azU.isDouble(string);
    }

    public long hu(@NotNull String string) {
        return this.azU.getLong(string);
    }

    public long a(@NotNull String string, long l) {
        return this.azU.getLong(string, l);
    }

    public boolean hv(@NotNull String string) {
        return this.azU.isLong(string);
    }

    @Nullable
    public List hw(@NotNull String string) {
        return this.azU.getList(string);
    }

    @Nullable
    public List c(@NotNull String string, @Nullable List list) {
        return this.azU.getList(string, list);
    }

    public boolean hx(@NotNull String string) {
        return this.azU.isList(string);
    }

    @NotNull
    public List hg(@NotNull String string) {
        return this.azU.getStringList(string);
    }

    @NotNull
    public List hy(@NotNull String string) {
        return this.azU.getIntegerList(string);
    }

    @NotNull
    public List hz(@NotNull String string) {
        return this.azU.getBooleanList(string);
    }

    @NotNull
    public List hA(@NotNull String string) {
        return this.azU.getDoubleList(string);
    }

    @NotNull
    public List hB(@NotNull String string) {
        return this.azU.getFloatList(string);
    }

    @NotNull
    public List hC(@NotNull String string) {
        return this.azU.getLongList(string);
    }

    @NotNull
    public List hD(@NotNull String string) {
        return this.azU.getByteList(string);
    }

    @NotNull
    public List hE(@NotNull String string) {
        return this.azU.getCharacterList(string);
    }

    @NotNull
    public List hF(@NotNull String string) {
        return this.azU.getShortList(string);
    }

    @NotNull
    public List hG(@NotNull String string) {
        return this.azU.getMapList(string);
    }

    @Nullable
    public Object a(@NotNull String string, @NotNull Class clazz) {
        return this.azU.getObject(string, clazz);
    }

    @Nullable
    public Object a(@NotNull String string, @NotNull Class clazz, @Nullable Object object) {
        return this.azU.getObject(string, clazz, object);
    }

    @Nullable
    public ConfigurationSerializable b(@NotNull String string, @NotNull Class clazz) {
        return this.azU.getSerializable(string, clazz);
    }

    @Nullable
    public ConfigurationSerializable a(@NotNull String string, @NotNull Class clazz, @Nullable ConfigurationSerializable configurationSerializable) {
        return this.azU.getSerializable(string, clazz, configurationSerializable);
    }

    @Nullable
    public Vector hH(@NotNull String string) {
        return this.azU.getVector(string);
    }

    @Nullable
    public Vector a(@NotNull String string, @Nullable Vector vector) {
        return this.azU.getVector(string, vector);
    }

    public boolean hI(@NotNull String string) {
        return this.azU.isVector(string);
    }

    @Nullable
    public OfflinePlayer hJ(@NotNull String string) {
        return this.azU.getOfflinePlayer(string);
    }

    @Nullable
    public OfflinePlayer a(@NotNull String string, @Nullable OfflinePlayer offlinePlayer) {
        return this.azU.getOfflinePlayer(string, offlinePlayer);
    }

    public boolean hK(@NotNull String string) {
        return this.azU.isOfflinePlayer(string);
    }

    @Nullable
    public ItemStack hL(@NotNull String string) {
        return this.azU.getItemStack(string);
    }

    @Nullable
    public ItemStack a(@NotNull String string, @Nullable ItemStack itemStack) {
        return this.azU.getItemStack(string, itemStack);
    }

    public boolean hM(@NotNull String string) {
        return this.azU.isItemStack(string);
    }

    @Nullable
    public Color hN(@NotNull String string) {
        return this.azU.getColor(string);
    }

    @Nullable
    public Color a(@NotNull String string, @Nullable Color color) {
        return this.azU.getColor(string, color);
    }

    public boolean hO(@NotNull String string) {
        return this.azU.isColor(string);
    }

    @Nullable
    public Location hP(@NotNull String string) {
        return this.azU.getLocation(string);
    }

    @Nullable
    public Location a(@NotNull String string, @Nullable Location location) {
        return this.azU.getLocation(string, location);
    }

    public boolean hQ(@NotNull String string) {
        return this.azU.isLocation(string);
    }

    @Nullable
    public ConfigurationSection hi(@NotNull String string) {
        return this.azU.getConfigurationSection(string);
    }

    @Nullable
    public bbg hj(@NotNull String string) {
        ConfigurationSection configurationSection = this.hi(string);
        if (configurationSection == null) {
            return null;
        }
        return new bbg(configurationSection);
    }

    public boolean hR(@NotNull String string) {
        return this.azU.isConfigurationSection(string);
    }

    @Nullable
    public ConfigurationSection CP() {
        return this.azU.getDefaultSection();
    }

    public void f(@NotNull String string, @Nullable Object object) {
        this.azU.addDefault(string, object);
    }

    @NotNull
    public List hS(@NotNull String string) {
        return this.azU.getComments(string);
    }

    @NotNull
    public List hT(@NotNull String string) {
        return this.azU.getInlineComments(string);
    }

    public void d(@NotNull String string, @Nullable List list) {
        this.azU.setComments(string, list);
    }

    public void e(@NotNull String string, @Nullable List list) {
        this.azU.setInlineComments(string, list);
    }

    public Enum c(String string, Class clazz) {
        return bbf.a(this.azU, string, clazz, null);
    }

    public Enum a(String string, Class clazz, Enum enum_) {
        return bbf.a(this.azU, string, clazz, enum_);
    }

    public Enum a(String string, Class clazz, Enum enum_, Consumer consumer) {
        Enum enum_2;
        String string2 = this.azU.getString(string);
        Enum enum_3 = enum_2 = string2 != null ? bbi.b(string2.toUpperCase(), clazz, enum_) : enum_;
        if (enum_2 == null) {
            consumer.accept(string2);
        }
        return enum_2;
    }

    public List hU(String string) {
        return this.D(string, false);
    }

    @NotNull
    public List D(String string, boolean bl) {
        ConfigurationSection configurationSection = this.azU.getConfigurationSection(string);
        if (configurationSection == null) {
            return new ArrayList();
        }
        return new ArrayList(configurationSection.getKeys(bl));
    }

    @NotNull
    public List aZ(boolean bl) {
        return new ArrayList(this.azU.getKeys(bl));
    }

    public boolean gP(String string) {
        return this.azU.contains(string);
    }

    @Nullable
    public Long a(@NotNull String string, @Nullable Long l) {
        if (this.gP(string)) {
            return this.azU.getLong(string);
        }
        return l;
    }

    @Nullable
    public Float a(String string, @Nullable Float f) {
        if (this.gP(string)) {
            return Float.valueOf((float)this.azU.getDouble(string));
        }
        return f;
    }

    public float a(String string, float f) {
        if (this.gP(string)) {
            return (float)this.azU.getDouble(string);
        }
        return f;
    }

    public float gX(String string) {
        return this.a(string, 0.0f);
    }

    @Nullable
    public Double a(String string, @Nullable Double d) {
        if (this.gP(string)) {
            return this.azU.getDouble(string);
        }
        return d;
    }

    @Nullable
    public Boolean a(String string, @Nullable Boolean bl) {
        if (this.gP(string)) {
            return this.azU.getBoolean(string);
        }
        return bl;
    }

    public Material a(String string, Material material) {
        if (this.gP(string)) {
            return (Material)bbi.b(this.azU.getString(string).toUpperCase(), Material.class, (Enum)material);
        }
        return material;
    }

    public static Material b(String string, Material material) {
        return bbf.b(string, material);
    }

    public Material gZ(String string) {
        return this.a(string, (Material)null);
    }

    @Nullable
    public Material a(String string, Material material, @Nullable Consumer consumer) {
        String string2 = this.gV(string);
        if (string2 != null) {
            Material material2 = (Material)bbi.b(string2 = string2.toUpperCase(), Material.class, null);
            if (material2 == null) {
                if (consumer != null) {
                    consumer.accept(string2);
                }
                return material;
            }
            return material2;
        }
        return material;
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
        return new ArrayList(this.azU.getConfigurationSection(string).getKeys(bl));
    }

    public List hV(String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            ArrayList arrayList2 = (ArrayList)this.azU.getStringList(string);
            for (String string2 : arrayList2) {
                arrayList.add(bcy.gH(string2));
            }
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        return arrayList;
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

    public List d(Class clazz, String string) {
        return this.a(clazz, string, null);
    }

    public List a(Class clazz, String string, @Nullable List list) {
        ArrayList<Enum> arrayList = new ArrayList<Enum>();
        if (this.gP(string)) {
            List list2 = this.hg(string);
            for (int i = 0; i < list2.size(); ++i) {
                String string2 = ((String)list2.get(i)).toUpperCase();
                try {
                    arrayList.add(bbi.e(string2, clazz));
                    continue;
                }
                catch (Exception exception) {
                    if (list != null) {
                        list.add(string2);
                    }
                    list2.remove(i);
                    --i;
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    @NotNull
    public List hW(String string) {
        ArrayList<EntityType> arrayList = new ArrayList<EntityType>();
        if (!this.gP(string)) {
            return arrayList;
        }
        List list = this.hg(string);
        for (String string2 : list) {
            EntityType entityType;
            EntityType entityType2 = (EntityType)bbi.e(string2.toUpperCase(), EntityType.class);
            if (entityType2 != null) {
                arrayList.add(entityType2);
                continue;
            }
            if ((string2 = string2.toLowerCase()).startsWith("minecraft:")) {
                string2 = string2.replaceAll("minecraft:", "");
            }
            if ((entityType = EntityType.fromName((String)string2)) != null) {
                arrayList.add(entityType);
                continue;
            }
            bce.error("[Items] Invalid vanilla entity type '" + string2 + "' in " + string + " in yml file: " + this.CM());
        }
        return arrayList;
    }

    @Nullable
    public EntityType[] hX(String string) {
        List list = this.hW(string);
        if (list.isEmpty()) {
            return null;
        }
        return list.toArray(new EntityType[0]);
    }
}
