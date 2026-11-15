package itemsadder.m;

import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.to;
import itemsadder.m.tq;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.Nullable;

public class tw
extends to {
    private bbg KY;

    public tw(bbf bbf2, String string, bbg bbg2) {
        super(bbf2, string, bbg2);
    }

    @Override
    public String pX() {
        return "resource_to_graphics";
    }

    @Override
    public boolean pY() {
        if (!this.KQ.gP("resource")) {
            return false;
        }
        this.KY = this.KQ.hj("resource");
        if (this.KY == null) {
            throw new tq("Item '" + this.KP + "' has null resource section", true);
        }
        if (this.KY.fo("custom_model_data") || this.KY.fo("model_id")) {
            throw new tq("Item '" + this.KP + "' has 'custom_model_data' or 'model_id', needs manual conversion", true);
        }
        boolean bl = this.KY.C("generate", false);
        boolean bl2 = this.KY.fo("model_path");
        if (!bl && !bl2) {
            throw new tq("Item '" + this.KP + "' has neither 'generate' nor 'model_path', needs manual conversion", true);
        }
        if (bl) {
            boolean bl3 = this.KY.fo("texture");
            List list = this.KY.hg("textures");
            if (!bl3 && list.isEmpty()) {
                if (this.KQ.fo("specific_properties.armor")) {
                    throw new tq("Item '" + this.KP + "' has 'generate' but no texture/textures, skipping legacy armor.", true, true);
                }
                throw new tq("Item '" + this.KP + "' has 'generate' but no texture/textures", true);
            }
            if (!bl3 && list.size() > 1 && !this.KQ.fo("specific_properties.block")) {
                throw new tq("Item '" + this.KP + "' has multiple textures but is not a block, needs manual conversion", true);
            }
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void pZ() {
        try {
            boolean bl = this.KQ.gP("specific_properties.block") || this.KQ.gP("behaviours.block");
            @Nullable Material material = this.KY.a("material", (Material)null);
            if (material != null) {
                if (bl) {
                    if (material != Material.PAPER) {
                        this.KQ.d("material", (Object)material.toString());
                    }
                } else {
                    this.KQ.d("material", (Object)material.toString());
                }
            }
            if (material == Material.TRIDENT) {
                throw new tq("Item '" + this.KP + "' is a trident, needs manual conversion to properly set throwing texture", true, true);
            }
            if (this.KQ.fo("display_name")) {
                this.KQ.d("name", (Object)this.KQ.gV("display_name"));
                this.KQ.d("display_name", (Object)null);
            }
            if (this.KQ.gP("enabled") && this.KQ.hq("enabled")) {
                this.KQ.d("enabled", (Object)null);
            }
            ConfigurationSection configurationSection = this.KQ.hn("graphics");
            if (this.KY.C("generate", false)) {
                String string = tw.d(this.KY);
                if (material == Material.BOW) {
                    ConfigurationSection configurationSection2 = configurationSection.createSection("textures");
                    configurationSection2.set("normal", (Object)string);
                    configurationSection2.set("pulling_0", (Object)(string + "_0"));
                    configurationSection2.set("pulling_1", (Object)(string + "_1"));
                    configurationSection2.set("pulling_2", (Object)(string + "_2"));
                } else if (material == Material.CROSSBOW) {
                    ConfigurationSection configurationSection3 = configurationSection.createSection("textures");
                    configurationSection3.set("normal", (Object)string);
                    configurationSection3.set("pulling_0", (Object)(string + "_0"));
                    configurationSection3.set("pulling_1", (Object)(string + "_1"));
                    configurationSection3.set("pulling_2", (Object)(string + "_2"));
                    configurationSection3.set("arrow", (Object)(string + "_charged"));
                    configurationSection3.set("rocket", (Object)(string + "_firework"));
                } else if (material == Material.SHIELD) {
                    ConfigurationSection configurationSection4 = configurationSection.createSection("textures");
                    configurationSection4.set("normal", (Object)string);
                    configurationSection4.set("blocking", (Object)(string + "_blocking"));
                } else if (material == Material.FISHING_ROD) {
                    ConfigurationSection configurationSection5 = configurationSection.createSection("textures");
                    configurationSection5.set("normal", (Object)string);
                    configurationSection5.set("cast", (Object)(string + "_cast"));
                } else if (this.KY.fo("texture")) {
                    configurationSection.set("texture", (Object)string);
                } else {
                    List list = this.KY.hg("textures");
                    if (list.size() == 1) {
                        configurationSection.set("texture", list.getFirst());
                    } else {
                        if (!bl) throw new tq("Item '" + this.KP + "' has multiple textures but is not a block, needs manual conversion", true);
                        ConfigurationSection configurationSection6 = configurationSection.createSection("textures");
                        configurationSection6.set("down", list.get(0));
                        configurationSection6.set("east", list.get(1));
                        configurationSection6.set("north", list.get(2));
                        configurationSection6.set("south", list.get(3));
                        configurationSection6.set("up", list.get(4));
                        configurationSection6.set("west", list.get(5));
                    }
                }
            } else {
                String string = this.KY.gV("model_path");
                if (material == Material.BOW) {
                    ConfigurationSection configurationSection7 = configurationSection.createSection("models");
                    configurationSection7.set("normal", (Object)string);
                    configurationSection7.set("pulling_0", (Object)(string + "_0"));
                    configurationSection7.set("pulling_1", (Object)(string + "_1"));
                    configurationSection7.set("pulling_2", (Object)(string + "_2"));
                } else if (material == Material.CROSSBOW) {
                    ConfigurationSection configurationSection8 = configurationSection.createSection("models");
                    configurationSection8.set("normal", (Object)string);
                    configurationSection8.set("pulling_0", (Object)(string + "_0"));
                    configurationSection8.set("pulling_1", (Object)(string + "_1"));
                    configurationSection8.set("pulling_2", (Object)(string + "_2"));
                    configurationSection8.set("arrow", (Object)(string + "_charged"));
                    configurationSection8.set("rocket", (Object)(string + "_firework"));
                } else if (material == Material.SHIELD) {
                    ConfigurationSection configurationSection9 = configurationSection.createSection("models");
                    configurationSection9.set("normal", (Object)string);
                    configurationSection9.set("blocking", (Object)(string + "_blocking"));
                } else if (material == Material.FISHING_ROD) {
                    ConfigurationSection configurationSection10 = configurationSection.createSection("models");
                    configurationSection10.set("normal", (Object)string);
                    configurationSection10.set("cast", (Object)(string + "_cast"));
                } else {
                    configurationSection.set("model", (Object)string);
                }
            }
            if (this.KY.gP("icon")) {
                configurationSection.set("icon", (Object)this.KY.gV("icon"));
            }
            this.KQ.d("resource", (Object)null);
            this.ql();
            return;
        }
        catch (Exception exception) {
            throw new tq("Failed to apply resource_to_graphics conversion for item '" + this.KP + "'", exception);
        }
    }

    @Nullable
    private static String d(bbg bbg2) {
        if (bbg2.fo("texture")) {
            return bbg2.gV("texture");
        }
        List list = bbg2.hg("textures");
        if (list.size() != 1) {
            return null;
        }
        return (String)list.getFirst();
    }

    private void ql() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
        for (String object : this.KQ.aX(false)) {
            linkedHashMap.put(object, this.KQ.hm(object));
        }
        for (String string : new ArrayList(this.KQ.aX(false))) {
            this.KQ.d(string, (Object)null);
        }
        if (linkedHashMap.containsKey("name")) {
            this.KQ.d("name", linkedHashMap.remove("name"));
        }
        if (linkedHashMap.containsKey("material")) {
            this.KQ.d("material", linkedHashMap.remove("material"));
        }
        if (linkedHashMap.containsKey("graphics")) {
            this.KQ.d("graphics", linkedHashMap.remove("graphics"));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            this.KQ.d((String)entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String qa() {
        return "Convert 'resource' to 'graphics' for item '" + this.KP + "'";
    }
}
