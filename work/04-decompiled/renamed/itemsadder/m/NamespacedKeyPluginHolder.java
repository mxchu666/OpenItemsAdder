package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.BlockRegistry;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.EntityBridge_4;
import itemsadder.m.EntityBridge_5;
import itemsadder.m.EntityDeathListener;
import itemsadder.m.EntityTypeBarStyleHolder;
import itemsadder.m.EntityTypeBridge_6;
import itemsadder.m.EntityWrapper_2;
import itemsadder.m.EnumWrappersHolder;
import itemsadder.m.ItemBridge;
import itemsadder.m.ItemStackBridgeImpl;
import itemsadder.m.ItemStackBridge_32;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridgeImpl;
import itemsadder.m.LocationBridge_14;
import itemsadder.m.MaterialBridge_17;
import itemsadder.m.Opaque135;
import itemsadder.m.Opaque136;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfList_2;
import itemsadder.m.RecordOfString_8;
import itemsadder.m.RecordOfValue_25;
import itemsadder.m.SoundCategoryBridge;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class NamespacedKeyPluginHolder {
    static final NamespacedKey KZ = new NamespacedKey(Main.rT(), "spawned_from_spawner");
    final Plugin La;
    final ItemStackRegistry Lb;
    public HashMap Lc = new HashMap();
    public HashMap Ld = new HashMap();
    public List Le = new ArrayList();
    public List Lf = new ArrayList();
    public HashMap Lg = new HashMap();
    public HashMap Lh = new HashMap();
    public EntityDeathListener Li;

    public NamespacedKeyPluginHolder(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.Lb = itemStackRegistry;
        this.La = plugin;
        this.Li = new EntityDeathListener();
        this.Li.qm();
    }

    public void a(Collection collection) {
        for (PluginFileConfigurationHolder pluginFileConfigurationHolder : collection) {
            this.g(pluginFileConfigurationHolder);
        }
    }

    public void g(PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        if (!pluginFileConfigurationHolder.gP("loots")) {
            if (Main.KO.gY("debug.items.log-loots-loading")) {
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No loots found in file " + pluginFileConfigurationHolder.qd());
            }
            return;
        }
        block10: for (String string2 : pluginFileConfigurationHolder.gR("loots")) {
            String string3 = "loots." + string2;
            switch (string2) {
                case "mobs": {
                    Object object;
                    String string4;
                    Object object2;
                    Object object3;
                    EntityType entityType2;
                    Object object4;
                    String string5;
                    for (String string6 : pluginFileConfigurationHolder.gR(string3)) {
                        string5 = string3 + "." + string6;
                        if (!pluginFileConfigurationHolder.z(string5 + ".enabled", true)) {
                            if (!Main.KO.gY("debug.items.log-loots-loading-disabled")) continue;
                            CommandSenderBridge_5.log("    Ignored disabled loot: " + string6);
                            continue;
                        }
                        object4 = pluginFileConfigurationHolder.gV(string5 + ".type");
                        if (object4 == null) {
                            CommandSenderBridge_5.error("Missing 'type' in loot '" + string6 + "'. File " + pluginFileConfigurationHolder.nh());
                            continue;
                        }
                        entityType2 = SoundCategoryBridge.ih((String)object4);
                        if (entityType2 != null) {
                            object3 = new EntityTypeBridge_6(entityType2, pluginFileConfigurationHolder.z(string5 + ".ignore_spawner", true));
                            object2 = (EntityTypeBridge_6)object3;
                            this.Lg.computeIfAbsent(((EntityTypeBridge_6)object2).getType(), entityType -> new ArrayList()).add(object2);
                        } else {
                            object2 = (EntityTypeBarStyleHolder)LivingEntityRegistry.db().lJ.get(object4);
                            if (object2 == null) {
                                CommandSenderBridge_5.error("Unknown entity '" + (String)object4 + "' not found for loot '" + string6 + "'. File: " + pluginFileConfigurationHolder.nh());
                                continue;
                            }
                            object3 = new Opaque135(((EntityTypeBarStyleHolder)object2).nO.getNamespacedID(), pluginFileConfigurationHolder.z(string5 + ".ignore_spawner", true));
                            Object object5 = (Opaque135)object3;
                            this.Lh.computeIfAbsent(((Opaque135)object5).nL(), string -> new ArrayList()).add(object5);
                        }
                        if (pluginFileConfigurationHolder.gP(string5 + ".nbt")) {
                            for (Object object5 : pluginFileConfigurationHolder.gR(string5 + ".nbt")) {
                                string4 = string5 + ".nbt." + (String)object5;
                                object = new EntityBridge_5(pluginFileConfigurationHolder.gV((String)string4 + ".path"), pluginFileConfigurationHolder.gV((String)string4 + ".value"), pluginFileConfigurationHolder.gV((String)string4 + ".type"));
                                ((Opaque136)object3).a((EntityBridge_5)object);
                            }
                        }
                        if (pluginFileConfigurationHolder.gP(string5 + ".metadata")) {
                            for (Object object5 : pluginFileConfigurationHolder.gR(string5 + ".metadata")) {
                                string4 = string5 + ".metadata." + (String)object5;
                                object = pluginFileConfigurationHolder.gV((String)string4 + ".name");
                                if (((String)object).equals("ItemsAdderMob")) {
                                    object = "ItemsAdderEntity";
                                }
                                EntityBridge_4 entityBridge_4 = new EntityBridge_4((String)object, pluginFileConfigurationHolder.gV((String)string4 + ".value"), pluginFileConfigurationHolder.az((String)string4 + ".type", "string"));
                                ((Opaque136)object3).a(entityBridge_4);
                            }
                        }
                        this.a((LocationBridge_14)object3, pluginFileConfigurationHolder, string5);
                        this.Lf.add(object3);
                    }
                    continue block10;
                }
                case "blocks": {
                    Object object;
                    String string4;
                    Object object2;
                    Object object3;
                    EntityType entityType2;
                    Object object4;
                    String string5;
                    for (String string6 : pluginFileConfigurationHolder.gR(string3)) {
                        string5 = string3 + "." + string6;
                        if (!pluginFileConfigurationHolder.z(string5 + ".enabled", true)) {
                            if (!Main.KO.gY("debug.items.log-loots-loading-disabled")) continue;
                            CommandSenderBridge_5.log("    Ignored disabled loot: " + string6);
                            continue;
                        }
                        object4 = pluginFileConfigurationHolder.gV(string5 + ".type");
                        if (object4 == null) {
                            CommandSenderBridge_5.error("Missing 'type' in loot '" + string6 + "'. File " + pluginFileConfigurationHolder.nh());
                            continue;
                        }
                        entityType2 = SoundCategoryBridge.ig((String)object4);
                        if (entityType2 != null) {
                            object3 = new MaterialBridge_17((Material)entityType2);
                            if (pluginFileConfigurationHolder.gP(string5 + ".nbt")) {
                                if (BlockRegistry.B(((MaterialBridge_17)object3).nM())) {
                                    for (Object object5 : pluginFileConfigurationHolder.gR(string5 + ".nbt")) {
                                        string4 = string5 + ".nbt." + (String)object5;
                                        object = new EntityBridge_5(pluginFileConfigurationHolder.gV(string4 + ".path"), pluginFileConfigurationHolder.gV(string4 + ".value"), pluginFileConfigurationHolder.gV(string4 + ".type"));
                                        ((LocationBridgeImpl)object3).a((EntityBridge_5)object);
                                    }
                                } else {
                                    CommandSenderBridge_5.error("Ignored NBT rule of loot for block: " + String.valueOf(ChatColor.AQUA) + string6 + String.valueOf(ChatColor.RED) + ". File " + String.valueOf(ChatColor.AQUA) + pluginFileConfigurationHolder.nh() + String.valueOf(ChatColor.RED) + " (" + String.valueOf(ChatColor.AQUA) + String.valueOf(((MaterialBridge_17)object3).nM()) + String.valueOf(ChatColor.RED) + " is not a tile entity!)");
                                }
                            }
                            this.a((LocationBridge_14)object3, pluginFileConfigurationHolder, string5);
                            this.Lc.computeIfAbsent(Material.getMaterial((String)object4), material -> new ArrayList()).add(object3);
                            if (!Main.KO.gY("debug.items.log-loots-loading")) continue;
                            CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "Registered block loot: " + String.valueOf(((MaterialBridge_17)object3).nM()));
                            continue;
                        }
                        if (!this.Lb.f((String)object4)) {
                            CommandSenderBridge_5.error("Block '" + (String)object4 + "' not found for loot '" + string6 + "'. File: " + pluginFileConfigurationHolder.nh());
                            continue;
                        }
                        object3 = this.Lb.e((String)object4);
                        if (object3 instanceof LocationBridgeBuilder_2) {
                            object2 = new ItemStackBridgeImpl((LocationBridgeBuilder_2)object3);
                            this.a((LocationBridge_14)object2, pluginFileConfigurationHolder, string5);
                            this.Ld.computeIfAbsent((LocationBridgeBuilder_2)object3, locationBridgeBuilder_2 -> new ArrayList()).add(object2);
                            if (!Main.KO.gY("debug.items.log-loots-loading")) continue;
                            CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "Registered block loot: " + ((ItemStackBridgeImpl)object2).ln().getNamespacedID());
                            continue;
                        }
                        CommandSenderBridge_5.error("Error: You have to set a valid BLOCK as the 'type' of block loot '" + string6 + "'. You set " + (String)object4 + "' which is NOT a block. File: " + pluginFileConfigurationHolder.qd());
                    }
                    continue block10;
                }
                case "fishing": {
                    Object object4;
                    String string5;
                    for (String string6 : pluginFileConfigurationHolder.gR(string3)) {
                        string5 = string3 + "." + string6;
                        if (!pluginFileConfigurationHolder.z(string5 + ".enabled", true)) {
                            if (!Main.KO.gY("debug.items.log-loots-loading-disabled")) continue;
                            CommandSenderBridge_5.log("    Ignored disabled loot: " + string6);
                            continue;
                        }
                        object4 = new ItemBridge();
                        this.a((LocationBridge_14)object4, pluginFileConfigurationHolder, string5);
                        this.Le.add(object4);
                    }
                    break;
                }
            }
        }
    }

    private void a(LocationBridge_14 locationBridge_14, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string) {
        Object object;
        Object object2;
        Object object32;
        for (Object object4 : pluginFileConfigurationHolder.gR(string + ".items")) {
            object32 = string + ".items." + (String)object4;
            object2 = pluginFileConfigurationHolder.gV((String)object32 + ".item");
            object = this.Lb.o((String)object2);
            if (object == null) {
                CommandSenderBridge_5.error("Item '" + (String)object2 + "' not found for loot '" + string + "'. File: " + pluginFileConfigurationHolder.nh());
                continue;
            }
            ItemStackBridge_32 itemStackBridge_32 = new ItemStackBridge_32((ItemStack)object, pluginFileConfigurationHolder.t((String)object32 + ".min_amount", 1), pluginFileConfigurationHolder.t((String)object32 + ".max_amount", 1), pluginFileConfigurationHolder.a((String)object32 + ".chance", 100.0f), pluginFileConfigurationHolder.z((String)object32 + ".ignore_fortune", false));
            if (itemStackBridge_32.oR() > itemStackBridge_32.oS()) {
                CommandSenderBridge_5.error("Invalid loot. 'min_amount' " + itemStackBridge_32.oR() + " greater than 'max_amount' " + itemStackBridge_32.oS() + "! Must be lower. Loot '" + string + "'. File: " + pluginFileConfigurationHolder.nh());
                continue;
            }
            locationBridge_14.c(itemStackBridge_32);
        }
        if (pluginFileConfigurationHolder.gP(string + ".exp")) {
            for (Object object4 : pluginFileConfigurationHolder.gR(string + ".exp")) {
                object32 = string + ".exp." + (String)object4;
                object2 = new RecordOfValue_25(pluginFileConfigurationHolder.gW((String)object32 + ".min_amount"), pluginFileConfigurationHolder.gW((String)object32 + ".max_amount"), pluginFileConfigurationHolder.gX((String)object32 + ".chance"));
                locationBridge_14.a((RecordOfValue_25)object2);
            }
        }
        if (pluginFileConfigurationHolder.gP(string + ".commands")) {
            Iterator iterator = pluginFileConfigurationHolder.hj(string + ".commands");
            assert (iterator != null);
            for (Object object32 : ((ConfigurationSectionBridge)((Object)iterator)).CK()) {
                object2 = ((ConfigurationSectionBridge)((Object)iterator)).hj((String)object32);
                assert (object2 != null);
                object = new ArrayList();
                for (String string2 : ((ConfigurationSectionBridge)object2).CK()) {
                    if (string2.equals("chance")) continue;
                    ConfigurationSectionBridge configurationSectionBridge = ((ConfigurationSectionBridge)object2).hj(string2);
                    assert (configurationSectionBridge != null);
                    object.add(new RecordOfString_8(configurationSectionBridge.gV("command"), configurationSectionBridge.C("as_console", true), configurationSectionBridge.C("silent", false)));
                }
                locationBridge_14.a(new RecordOfList_2((List)object, ((ConfigurationSectionBridge)object2).gW("chance")));
            }
        }
        if (pluginFileConfigurationHolder.gP(string + ".biomes")) {
            for (Object object4 : pluginFileConfigurationHolder.hg(string + ".biomes")) {
                object32 = EnumWrappersHolder.vC().aoJ.dO(((String)object4).toUpperCase());
                if (object32 == null) continue;
                locationBridge_14.d((NamespacedKey)object32);
            }
        }
        if (pluginFileConfigurationHolder.gP(string + ".worlds")) {
            for (Object object4 : pluginFileConfigurationHolder.hg(string + ".worlds")) {
                locationBridge_14.cv((String)object4);
            }
        }
        locationBridge_14.aA(pluginFileConfigurationHolder.z(string + ".stop_on_first_success", pluginFileConfigurationHolder.z(string + ".drop_only_first", false)));
    }

    @Nullable
    public List c(Block block, Material material) {
        ArrayList<MaterialBridge_17> arrayList = new ArrayList<MaterialBridge_17>();
        List list = (List)this.Lc.get(material);
        if (list == null) {
            return null;
        }
        Biome biome = block.getBiome();
        World world = block.getWorld();
        for (MaterialBridge_17 materialBridge_17 : list) {
            if (!materialBridge_17.a(biome) || !materialBridge_17.i(world)) continue;
            arrayList.add(materialBridge_17);
        }
        return arrayList;
    }

    @Nullable
    public List e(Block block, LocationBridgeBuilder_2 locationBridgeBuilder_2) {
        ArrayList<ItemStackBridgeImpl> arrayList = new ArrayList<ItemStackBridgeImpl>();
        List list = (List)this.Ld.get(locationBridgeBuilder_2);
        if (list == null) {
            return null;
        }
        Biome biome = block.getBiome();
        World world = block.getWorld();
        for (ItemStackBridgeImpl itemStackBridgeImpl : list) {
            if (!itemStackBridgeImpl.a(biome) || !itemStackBridgeImpl.i(world)) continue;
            arrayList.add(itemStackBridgeImpl);
        }
        return arrayList;
    }

    @Nullable
    public List aC(Block block) {
        ArrayList<ItemBridge> arrayList = new ArrayList<ItemBridge>();
        Biome biome = block.getBiome();
        World world = block.getWorld();
        for (ItemBridge itemBridge : this.Le) {
            if (!itemBridge.a(biome) || !itemBridge.i(world)) continue;
            arrayList.add(itemBridge);
        }
        return arrayList;
    }

    @Nullable
    public List h(LivingEntity livingEntity) {
        ArrayList<EntityTypeBridge_6> arrayList = new ArrayList<EntityTypeBridge_6>();
        List list = (List)this.Lg.get(livingEntity.getType());
        if (list == null) {
            return null;
        }
        Block block = livingEntity.getLocation().getBlock();
        Biome biome = block.getBiome();
        World world = block.getWorld();
        for (EntityTypeBridge_6 entityTypeBridge_6 : list) {
            if (!NamespacedKeyPluginHolder.a(livingEntity, biome, world, entityTypeBridge_6)) continue;
            arrayList.add(entityTypeBridge_6);
        }
        return arrayList;
    }

    @Nullable
    public List m(LivingEntityBuilder livingEntityBuilder) {
        LivingEntity livingEntity = livingEntityBuilder.eh();
        if (livingEntity == null) {
            return null;
        }
        ArrayList<Opaque135> arrayList = new ArrayList<Opaque135>();
        List list = (List)this.Lh.get(livingEntityBuilder.my.nO.getNamespacedID());
        if (list == null) {
            return null;
        }
        Block block = livingEntity.getLocation().getBlock();
        Biome biome = block.getBiome();
        World world = block.getWorld();
        for (Opaque135 opaque135 : list) {
            if (!NamespacedKeyPluginHolder.a(livingEntity, biome, world, opaque135)) continue;
            arrayList.add(opaque135);
        }
        return arrayList;
    }

    private static boolean a(LivingEntity livingEntity, Biome biome, World world, Opaque136 opaque136) {
        if (opaque136.a(biome) && opaque136.i(world)) {
            if (opaque136.qq() && ((Boolean)livingEntity.getPersistentDataContainer().getOrDefault(KZ, PersistentDataType.BOOLEAN, (Object)false)).booleanValue()) {
                return false;
            }
            if (opaque136.qn()) {
                for (EntityWrapper_2 entityWrapper_2 : opaque136.qp()) {
                    if (entityWrapper_2.I((Entity)livingEntity)) continue;
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
