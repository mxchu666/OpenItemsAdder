package itemsadder.m;

import itemsadder.m.BlockDataBridge;
import itemsadder.m.BlockStateBridge;
import itemsadder.m.BlockStateBridge_2;
import itemsadder.m.Builder_10;
import itemsadder.m.Builder_11;
import itemsadder.m.Builder_12;
import itemsadder.m.Builder_13;
import itemsadder.m.Builder_6;
import itemsadder.m.Builder_7;
import itemsadder.m.Builder_8;
import itemsadder.m.Builder_9;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.EntityHolder;
import itemsadder.m.EntityTypeBarStyleHolder;
import itemsadder.m.EntityTypeBridge;
import itemsadder.m.EntityTypeBridgeBuilder_2;
import itemsadder.m.EntityTypeBridgeBuilder_3;
import itemsadder.m.EntityTypeBridge_2;
import itemsadder.m.EntityTypeBridge_3;
import itemsadder.m.EntityTypeRefDataImpl;
import itemsadder.m.EntityTypeRefDataImpl_2;
import itemsadder.m.InstanceHolder;
import itemsadder.m.IntBoolData;
import itemsadder.m.IntBoolDataBuilderImpl;
import itemsadder.m.IntBoolDataBuilderImpl_11;
import itemsadder.m.IntBoolDataBuilderImpl_3;
import itemsadder.m.IntBoolDataBuilderImpl_5;
import itemsadder.m.IntBoolDataBuilderImpl_7;
import itemsadder.m.IntBoolDataBuilderImpl_9;
import itemsadder.m.IntBoolDataImpl;
import itemsadder.m.IntBoolDataImpl_10;
import itemsadder.m.IntBoolDataImpl_11;
import itemsadder.m.IntBoolDataImpl_12;
import itemsadder.m.IntBoolDataImpl_2;
import itemsadder.m.IntBoolDataImpl_3;
import itemsadder.m.IntBoolDataImpl_4;
import itemsadder.m.IntBoolDataImpl_5;
import itemsadder.m.IntBoolDataImpl_6;
import itemsadder.m.IntBoolDataImpl_7;
import itemsadder.m.IntBoolDataImpl_8;
import itemsadder.m.IntBoolDataImpl_9;
import itemsadder.m.ItemStackBridge_8;
import itemsadder.m.ItemStackBridge_9;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.Loader;
import itemsadder.m.MaterialBridge_4;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.Predicate_2;
import itemsadder.m.RecordOfEntityType;
import itemsadder.m.SoundCategoryBridge;
import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.Nullable;

public class LivingEntityBridge_7 {
    private static final Map va = new HashMap();
    private final EntityTypeBarStyleHolder vb;
    private final List vc = new ArrayList();
    private boolean vd = false;

    private static void a(String string, Loader loader) {
        va.put(string, loader);
    }

    public LivingEntityBridge_7(EntityTypeBarStyleHolder entityTypeBarStyleHolder) {
        this.vb = entityTypeBarStyleHolder;
    }

    public void aR() {
        String string = this.vb.nO.getNamespacedID();
        PluginFileConfigurationHolder pluginFileConfigurationHolder = this.vb.fz();
        if (pluginFileConfigurationHolder == null) {
            return;
        }
        @Nullable ConfigurationSectionBridge configurationSectionBridge = pluginFileConfigurationHolder.hj("entities." + this.vb.nO.bM + ".goals");
        if (configurationSectionBridge == null) {
            return;
        }
        for (String string2 : configurationSectionBridge.CK()) {
            ConfigurationSectionBridge configurationSectionBridge2;
            if (configurationSectionBridge.C("clear_all", false)) {
                this.vd = true;
            }
            if ((configurationSectionBridge2 = configurationSectionBridge.hj(string2)) == null || !configurationSectionBridge2.C("enabled", true)) continue;
            Optional<Map.Entry> optional = va.entrySet().stream().filter(entry -> string2.startsWith((String)entry.getKey())).findFirst();
            if (optional.isEmpty()) {
                CommandSenderBridge_5.warn("Unknown goal '" + string2 + "' in entity '" + string + "'. File: " + pluginFileConfigurationHolder.nh());
                continue;
            }
            IntBoolData intBoolData = ((Loader)optional.get().getValue()).load(string, this.vb, configurationSectionBridge2, string2, pluginFileConfigurationHolder);
            if (intBoolData == null) continue;
            this.vc.add(intBoolData);
        }
    }

    public void a(Mob mob) {
        if (mob == null) {
            CommandSenderBridge_5.error("Failed to apply goals to a null mob for entity '" + this.vb.nO.getNamespacedID() + "'.");
            return;
        }
        if (this.vd) {
            InstanceHolder.ua().b(mob);
        }
        block18: for (IntBoolData intBoolData : this.vc) {
            IntBoolData intBoolData2;
            Objects.requireNonNull(intBoolData);
            int n = 0;
            switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{EntityTypeBridge_2.class, EntityTypeRefDataImpl.class, IntBoolDataImpl_9.class, IntBoolDataImpl_12.class, IntBoolDataImpl_11.class, IntBoolDataImpl_10.class, IntBoolDataImpl_6.class, EntityTypeBridge_3.class, EntityTypeRefDataImpl_2.class, IntBoolDataImpl_5.class, IntBoolDataImpl.class, IntBoolDataImpl_4.class, IntBoolDataImpl_7.class, IntBoolDataImpl_8.class, IntBoolDataImpl_2.class, IntBoolDataImpl_3.class}, (Object)intBoolData2, n)) {
                case 0: {
                    EntityTypeBridge_2 entityTypeBridge_2 = (EntityTypeBridge_2)intBoolData2;
                    InstanceHolder.ua().a(mob, intBoolData.uO, intBoolData.uN, entityTypeBridge_2.vi, entityTypeBridge_2.vj, entityTypeBridge_2.vk, entityTypeBridge_2.vl);
                    continue block18;
                }
                case 1: {
                    EntityTypeRefDataImpl entityTypeRefDataImpl = (EntityTypeRefDataImpl)intBoolData2;
                    InstanceHolder.ua().a(mob, intBoolData.uO, intBoolData.uN, entityTypeRefDataImpl.uP, entityTypeRefDataImpl.uT, entityTypeRefDataImpl.uU, entityTypeRefDataImpl.uV, null);
                    continue block18;
                }
                case 2: {
                    IntBoolDataImpl_9 intBoolDataImpl_9 = (IntBoolDataImpl_9)intBoolData2;
                    InstanceHolder.ua().a(mob, intBoolDataImpl_9.uO, intBoolDataImpl_9.uN);
                    continue block18;
                }
                case 3: {
                    IntBoolDataImpl_12 intBoolDataImpl_12 = (IntBoolDataImpl_12)intBoolData2;
                    InstanceHolder.ua().a(mob, intBoolDataImpl_12.uO, intBoolDataImpl_12.uN, intBoolDataImpl_12.vw, intBoolDataImpl_12.vx);
                    continue block18;
                }
                case 4: {
                    IntBoolDataImpl_11 intBoolDataImpl_11 = (IntBoolDataImpl_11)intBoolData2;
                    InstanceHolder.ua().a(mob, intBoolDataImpl_11.uN, intBoolDataImpl_11.vu, intBoolDataImpl_11.vv);
                    continue block18;
                }
                case 5: {
                    IntBoolDataImpl_10 intBoolDataImpl_10 = (IntBoolDataImpl_10)intBoolData2;
                    InstanceHolder.ua().a(mob, intBoolDataImpl_10.uN, intBoolDataImpl_10.vs, intBoolDataImpl_10.vt);
                    continue block18;
                }
                case 6: {
                    IntBoolDataImpl_6 intBoolDataImpl_6 = (IntBoolDataImpl_6)intBoolData2;
                    InstanceHolder.ua().a(mob, intBoolDataImpl_6.uO, intBoolDataImpl_6.uN, intBoolDataImpl_6.vm, intBoolDataImpl_6.vn);
                    continue block18;
                }
                case 7: {
                    EntityTypeBridge_3 entityTypeBridge_3 = (EntityTypeBridge_3)intBoolData2;
                    InstanceHolder.ua().a(mob, entityTypeBridge_3.uO, entityTypeBridge_3.uN, entityTypeBridge_3.vz, entityTypeBridge_3.vA, entityTypeBridge_3.vB);
                    continue block18;
                }
                case 8: {
                    EntityTypeRefDataImpl_2 entityTypeRefDataImpl_2 = (EntityTypeRefDataImpl_2)intBoolData2;
                    InstanceHolder.ua().a(mob, entityTypeRefDataImpl_2.uO, entityTypeRefDataImpl_2.uN, entityTypeRefDataImpl_2.uP, entityTypeRefDataImpl_2.uW, entityTypeRefDataImpl_2.uX, entityTypeRefDataImpl_2.uY, null);
                    continue block18;
                }
                case 9: {
                    IntBoolDataImpl_5 intBoolDataImpl_5 = (IntBoolDataImpl_5)intBoolData2;
                    InstanceHolder.ua().a(mob, intBoolDataImpl_5.uO, intBoolDataImpl_5.uN, intBoolDataImpl_5.vf, intBoolDataImpl_5.vg);
                    continue block18;
                }
                case 10: {
                    IntBoolDataImpl intBoolDataImpl = (IntBoolDataImpl)intBoolData2;
                    InstanceHolder.ua().b(mob, intBoolDataImpl.uO, intBoolDataImpl.uN);
                    continue block18;
                }
                case 11: {
                    IntBoolDataImpl_4 intBoolDataImpl_4 = (IntBoolDataImpl_4)intBoolData2;
                    InstanceHolder.ua().c(mob, intBoolDataImpl_4.uO, intBoolDataImpl_4.uN);
                    continue block18;
                }
                case 12: {
                    IntBoolDataImpl_7 intBoolDataImpl_7 = (IntBoolDataImpl_7)intBoolData2;
                    InstanceHolder.ua().a(mob, intBoolDataImpl_7.uO, intBoolDataImpl_7.uN, intBoolDataImpl_7.vo, intBoolDataImpl_7.vp, intBoolDataImpl_7.vq);
                    continue block18;
                }
                case 13: {
                    IntBoolDataImpl_8 intBoolDataImpl_8 = (IntBoolDataImpl_8)intBoolData2;
                    InstanceHolder.ua().a(mob, intBoolDataImpl_8.uO, intBoolDataImpl_8.uN, intBoolDataImpl_8.vr);
                    continue block18;
                }
                case 14: {
                    IntBoolDataImpl_2 intBoolDataImpl_2 = (IntBoolDataImpl_2)intBoolData2;
                    InstanceHolder.ua().d(mob, intBoolDataImpl_2.uO, intBoolDataImpl_2.uN);
                    continue block18;
                }
                case 15: {
                    IntBoolDataImpl_3 intBoolDataImpl_3 = (IntBoolDataImpl_3)intBoolData2;
                    InstanceHolder.ua().a(mob, intBoolDataImpl_3.uO, intBoolDataImpl_3.uN, intBoolDataImpl_3.uZ);
                    continue block18;
                }
            }
            CommandSenderBridge_5.error("Unknown goal type '" + intBoolData.getClass().getSimpleName() + "' for entity '" + this.vb.nO.getNamespacedID() + "'.");
        }
    }

    @Nullable
    private static Predicate a(List list, String string, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        if (list.isEmpty()) {
            CommandSenderBridge_5.error("Failed to register action '" + string + "' for entity '" + string2 + "'. No blocks specified. File: " + pluginFileConfigurationHolder.nh());
            return null;
        }
        ArrayList<BlockStateBridge> arrayList = new ArrayList<BlockStateBridge>();
        for (String string3 : list) {
            string3 = string3.toLowerCase();
            if (ItemStackRegistry.g().g(string3)) {
                arrayList.add(new BlockStateBridge_2(string3));
                continue;
            }
            try {
                BlockData blockData = Bukkit.createBlockData((String)string3);
                arrayList.add(new BlockDataBridge(blockData));
            }
            catch (IllegalArgumentException illegalArgumentException) {
                CommandSenderBridge_5.error("Unknown block '" + string3 + "' for action '" + string + "' for entity '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh());
            }
        }
        if (arrayList.isEmpty()) {
            CommandSenderBridge_5.error("Failed to register action '" + string + "' for entity '" + string2 + "'. No valid blocks specified. File: " + pluginFileConfigurationHolder.nh());
            return null;
        }
        return blockState -> {
            if (blockState == null) {
                return false;
            }
            for (BlockStateBridge blockStateBridge : arrayList) {
                if (!blockStateBridge.b((BlockState)blockState)) continue;
                return true;
            }
            return false;
        };
    }

    private static @Nullable Predicate_2 a(ConfigurationSectionBridge configurationSectionBridge, String string, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder, @Nullable EntityTypeBarStyleHolder entityTypeBarStyleHolder, @Nullable Boolean bl) {
        float f = configurationSectionBridge.a("max_health", 199.0f);
        float f2 = configurationSectionBridge.a("min_health", 0.0f);
        boolean bl2 = configurationSectionBridge.C("equipment.match_all", true);
        HashMap<EquipmentSlot, ItemStackBridge_8> hashMap = new HashMap<EquipmentSlot, ItemStackBridge_8>();
        for (String string3 : configurationSectionBridge.hU("equipment")) {
            String string4 = configurationSectionBridge.gV("equipment." + string3);
            if (string4 == null || string4.isEmpty()) continue;
            EquipmentSlot equipmentSlot = SoundCategoryBridge.ik(string3);
            if (equipmentSlot == null) {
                CommandSenderBridge_5.error("Failed to register action '" + string + "' for entity '" + string2 + "'. Invalid equipment slot '" + string3 + "'. File: " + pluginFileConfigurationHolder.nh());
                return null;
            }
            if (ItemStackRegistry.g().f(string4)) {
                hashMap.put(equipmentSlot, new ItemStackBridge_9(string4));
                continue;
            }
            Material material = SoundCategoryBridge.ig(string4);
            if (material == null) {
                CommandSenderBridge_5.error("Failed to register action '" + string + "' for entity '" + string2 + "'. Invalid item '" + string4 + "' for equipment slot '" + string3 + "'. File: " + pluginFileConfigurationHolder.nh());
                return null;
            }
            hashMap.put(equipmentSlot, new MaterialBridge_4(material));
        }
        return (livingEntity, livingEntity2) -> {
            LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().h((Entity)livingEntity2);
            if (livingEntityBuilder == null || livingEntityBuilder.my != entityTypeBarStyleHolder) {
                return false;
            }
            if (livingEntity2.getHealth() < (double)f2 || livingEntity2.getHealth() > (double)f) {
                return false;
            }
            if (bl != null && bl.booleanValue() && !EntityHolder.tK().a(livingEntity, livingEntity2)) {
                return false;
            }
            if (!hashMap.isEmpty()) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    ItemStackBridge_8 itemStackBridge_8 = (ItemStackBridge_8)entry.getValue();
                    boolean bl3 = livingEntityBuilder.a((EquipmentSlot)entry.getKey(), itemStackBridge_8);
                    if (bl2) {
                        if (bl3) continue;
                        return false;
                    }
                    if (!bl3) continue;
                    return true;
                }
            }
            return bl2;
        };
    }

    @Nullable
    static RecordOfEntityType a(ConfigurationSectionBridge configurationSectionBridge, String string, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        EntityTypeBarStyleHolder entityTypeBarStyleHolder;
        String string3 = configurationSectionBridge.gV("entity");
        @Nullable EntityType entityType = SoundCategoryBridge.ih(string3);
        if (entityType == null) {
            if (!LivingEntityRegistry.db().lJ.containsKey(string3)) {
                return null;
            }
            entityTypeBarStyleHolder = (EntityTypeBarStyleHolder)LivingEntityRegistry.db().lJ.get(string3);
            entityType = entityTypeBarStyleHolder.nS;
        } else {
            entityTypeBarStyleHolder = null;
        }
        Boolean bl = null;
        if (string.equals("attack_near")) {
            bl = configurationSectionBridge.a("must_be_angry_at", (Boolean)null);
        }
        Predicate_2 predicate_2 = null;
        if (!configurationSectionBridge.fo("selector") && entityTypeBarStyleHolder != null) {
            predicate_2 = (livingEntity, livingEntity2) -> {
                LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().h((Entity)livingEntity2);
                return livingEntityBuilder != null && livingEntityBuilder.my == entityTypeBarStyleHolder;
            };
        } else {
            ConfigurationSectionBridge configurationSectionBridge2 = configurationSectionBridge.hj("selector");
            if (configurationSectionBridge2 != null) {
                predicate_2 = LivingEntityBridge_7.a(configurationSectionBridge2, string, string2, pluginFileConfigurationHolder, entityTypeBarStyleHolder, bl);
            }
        }
        return new RecordOfEntityType(entityType, predicate_2);
    }

    static EntityTypeBridge[] a(ConfigurationSectionBridge configurationSectionBridge, String string, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string3) {
        ArrayList<EntityTypeBridge> arrayList = new ArrayList<EntityTypeBridge>();
        ConfigurationSectionBridge configurationSectionBridge2 = configurationSectionBridge.hj(string3);
        if (configurationSectionBridge2 != null) {
            for (String string4 : configurationSectionBridge2.CK()) {
                EntityTypeBarStyleHolder entityTypeBarStyleHolder;
                ConfigurationSectionBridge configurationSectionBridge3 = configurationSectionBridge.hj(string4);
                assert (configurationSectionBridge3 != null);
                String string5 = configurationSectionBridge3.gV("entity");
                @Nullable EntityType entityType = SoundCategoryBridge.ih(string5);
                if (entityType == null) {
                    if (!LivingEntityRegistry.db().lJ.containsKey(string5)) {
                        CommandSenderBridge_5.error("Failed to register action '" + string + "' for entity '" + string2 + "'. Invalid entity type '" + string5 + "'. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    entityTypeBarStyleHolder = (EntityTypeBarStyleHolder)LivingEntityRegistry.db().lJ.get(string5);
                    entityType = entityTypeBarStyleHolder.nS;
                } else {
                    entityTypeBarStyleHolder = null;
                }
                Predicate_2 predicate_2 = null;
                ConfigurationSectionBridge configurationSectionBridge4 = configurationSectionBridge3.hj("selector");
                if (configurationSectionBridge4 != null) {
                    predicate_2 = LivingEntityBridge_7.a(configurationSectionBridge4, string, string2, pluginFileConfigurationHolder, entityTypeBarStyleHolder, null);
                }
                arrayList.add(EntityTypeBridge.iQ().d(entityType).b(predicate_2).iR());
            }
        }
        return arrayList.toArray(new EntityTypeBridge[0]);
    }

    static {
        LivingEntityBridge_7.a("look_at_entity", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> {
            RecordOfEntityType recordOfEntityType = LivingEntityBridge_7.a(configurationSectionBridge, string2, string, pluginFileConfigurationHolder);
            if (recordOfEntityType == null) {
                CommandSenderBridge_5.error("Failed to register action '" + string2 + "' for entity '" + string + "'. Invalid entity type or selector. File: " + pluginFileConfigurationHolder.nh());
                return null;
            }
            return ((EntityTypeBridgeBuilder_2)((EntityTypeBridgeBuilder_2)((EntityTypeBridgeBuilder_2)EntityTypeBridge_2.iV().R(configurationSectionBridge.C("replace_vanilla", true))).Q(configurationSectionBridge.t("priority", 10))).e(recordOfEntityType.ip()).g(configurationSectionBridge.a("range", 8.0f)).h(configurationSectionBridge.a("chance", 20.0f) / 100.0f).U(configurationSectionBridge.C("look_forward", false)).a(recordOfEntityType.iq())).iX();
        });
        LivingEntityBridge_7.a("random_look_around", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> ((IntBoolDataBuilderImpl_11)((IntBoolDataBuilderImpl_11)IntBoolDataImpl_9.jl().R(configurationSectionBridge.C("replace_vanilla", true))).Q(configurationSectionBridge.t("priority", 10))).jn());
        LivingEntityBridge_7.a("random_wander_around", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> ((Builder_13)((Builder_13)IntBoolDataImpl_12.jx().R(configurationSectionBridge.C("replace_vanilla", true))).Q(configurationSectionBridge.t("priority", 10))).l(configurationSectionBridge.a("speed_modifier", 1.0f)).V(configurationSectionBridge.t("interval", 10)).Y(configurationSectionBridge.C("check_no_action_time", true)).jz());
        LivingEntityBridge_7.a("random_teleport_timed", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> ((Builder_12)IntBoolDataImpl_11.jt().Q(configurationSectionBridge.t("priority", 10))).T(configurationSectionBridge.t("min_delay", 10)).U(configurationSectionBridge.t("max_delay", 20)).jv());
        LivingEntityBridge_7.a("random_teleport_on_hit", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> ((Builder_11)IntBoolDataImpl_10.jp().Q(configurationSectionBridge.t("priority", 10))).X(configurationSectionBridge.C("check_visibility", true)).i(configurationSectionBridge.a("chance", 100.0f) / 100.0f).jr());
        LivingEntityBridge_7.a("attack_near", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> {
            RecordOfEntityType recordOfEntityType = LivingEntityBridge_7.a(configurationSectionBridge, string2, string, pluginFileConfigurationHolder);
            if (recordOfEntityType == null) {
                CommandSenderBridge_5.error("Failed to register action '" + string2 + "' for entity '" + string + "'. Invalid entity type or selector. File: " + pluginFileConfigurationHolder.nh());
                return null;
            }
            return ((Builder_6)((Builder_6)((Builder_6)((Builder_6)EntityTypeRefDataImpl.ir().R(configurationSectionBridge.C("replace_vanilla", true))).Q(configurationSectionBridge.t("priority", 10))).c(recordOfEntityType.ip())).R(configurationSectionBridge.t("interval", 10)).S(configurationSectionBridge.C("check_visibility", true)).T(configurationSectionBridge.C("check_can_navigate", true)).a(recordOfEntityType.iq())).it();
        });
        LivingEntityBridge_7.a("melee_attack", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> ((Builder_9)((Builder_9)IntBoolDataImpl_6.iZ().R(configurationSectionBridge.C("replace_vanilla", true))).Q(configurationSectionBridge.t("priority", 10))).j(configurationSectionBridge.t("speed_modifier", 1)).V(configurationSectionBridge.C("pause_when_idle", false)).jb());
        LivingEntityBridge_7.a("ranged_bow_attack", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> {
            if (!EntityTypeBridge_3.f(entityTypeBarStyleHolder.nS)) {
                CommandSenderBridge_5.warn("Custom entity entity '" + string + "' is not compatible with RangedBowAttackGoal. This goal will not work as expected. File: " + pluginFileConfigurationHolder.nh());
                CommandSenderBridge_5.warn("Compatible types: " + Arrays.toString(EntityTypeBridge_3.jB()));
                return null;
            }
            return ((EntityTypeBridgeBuilder_3)((EntityTypeBridgeBuilder_3)EntityTypeBridge_3.jC().R(configurationSectionBridge.C("replace_vanilla", true))).Q(configurationSectionBridge.t("priority", 10))).m(configurationSectionBridge.a("speed_modifier", 1.0f)).W(configurationSectionBridge.t("attack_interval_min", 20)).j(configurationSectionBridge.a("attack_radius", 15.0f)).jE();
        });
        LivingEntityBridge_7.a("avoid_entity", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> {
            RecordOfEntityType recordOfEntityType = LivingEntityBridge_7.a(configurationSectionBridge, string2, string, pluginFileConfigurationHolder);
            if (recordOfEntityType == null) {
                CommandSenderBridge_5.error("Failed to register action '" + string2 + "' for entity '" + string + "'. Invalid entity type or selector. File: " + pluginFileConfigurationHolder.nh());
                return null;
            }
            return ((Builder_7)((Builder_7)((Builder_7)((Builder_7)EntityTypeRefDataImpl_2.iv().R(configurationSectionBridge.C("replace_vanilla", true))).Q(configurationSectionBridge.t("priority", 10))).c(recordOfEntityType.ip())).f(configurationSectionBridge.a("max_distance", 12.0f)).h(configurationSectionBridge.a("walk_speed_modifier", 1.0f)).i(configurationSectionBridge.a("sprint_speed_modifier", 1.2f)).a(recordOfEntityType.iq())).ix();
        });
        LivingEntityBridge_7.a("hurt_by_target", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> {
            EntityTypeBridge[] entityTypeBridgeArray = LivingEntityBridge_7.a(configurationSectionBridge, string2, string, pluginFileConfigurationHolder, "ignore_damage_from");
            EntityTypeBridge[] entityTypeBridgeArray2 = LivingEntityBridge_7.a(configurationSectionBridge, string2, string, pluginFileConfigurationHolder, "alert_others");
            return ((Builder_8)((Builder_8)IntBoolDataImpl_5.iP().R(configurationSectionBridge.C("replace_vanilla", true))).Q(configurationSectionBridge.t("priority", 10))).a(entityTypeBridgeArray).b(entityTypeBridgeArray2).iT();
        });
        LivingEntityBridge_7.a("avoid_sun", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> ((IntBoolDataBuilderImpl)((IntBoolDataBuilderImpl)IntBoolDataImpl.iz().R(configurationSectionBridge.C("replace_vanilla", true))).Q(configurationSectionBridge.t("priority", 10))).iB());
        LivingEntityBridge_7.a("float", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> ((IntBoolDataBuilderImpl_7)((IntBoolDataBuilderImpl_7)IntBoolDataImpl_4.iL().R(configurationSectionBridge.C("replace_vanilla", true))).Q(configurationSectionBridge.t("priority", 10))).iN());
        LivingEntityBridge_7.a("move_to_block", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> {
            List list = configurationSectionBridge.hg("blocks");
            Predicate predicate = LivingEntityBridge_7.a(list, string2, string, pluginFileConfigurationHolder);
            if (predicate == null) {
                return null;
            }
            return ((Builder_10)((Builder_10)IntBoolDataImpl_7.jd().R(configurationSectionBridge.C("replace_vanilla", true))).Q(configurationSectionBridge.t("priority", 10))).b(predicate).k(configurationSectionBridge.a("speed_modifier", 1.0f)).S(configurationSectionBridge.t("search_range", 16)).jf();
        });
        LivingEntityBridge_7.a("open_door", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> ((IntBoolDataBuilderImpl_9)((IntBoolDataBuilderImpl_9)IntBoolDataImpl_8.jh().R(configurationSectionBridge.C("replace_vanilla", true))).Q(configurationSectionBridge.t("priority", 10))).W(configurationSectionBridge.C("close", true)).jj());
        LivingEntityBridge_7.a("break_door", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> ((IntBoolDataBuilderImpl_3)((IntBoolDataBuilderImpl_3)IntBoolDataImpl_2.iD().R(configurationSectionBridge.C("replace_vanilla", true))).Q(configurationSectionBridge.t("priority", 10))).iF());
        LivingEntityBridge_7.a("eat_block", (String string, EntityTypeBarStyleHolder entityTypeBarStyleHolder, ConfigurationSectionBridge configurationSectionBridge, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) -> {
            List list = configurationSectionBridge.hg("blocks");
            Predicate predicate = LivingEntityBridge_7.a(list, string2, string, pluginFileConfigurationHolder);
            if (predicate == null) {
                return null;
            }
            return ((IntBoolDataBuilderImpl_5)((IntBoolDataBuilderImpl_5)IntBoolDataImpl_3.iH().R(configurationSectionBridge.C("replace_vanilla", true))).Q(configurationSectionBridge.t("priority", 10))).a(predicate).iJ();
        });
    }
}
