package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.Consumer;
import itemsadder.m.EntityBridgeImpl;
import itemsadder.m.EntityTypeBarStyleHolder;
import itemsadder.m.EventBridge;
import itemsadder.m.EventBridgeBuilder;
import itemsadder.m.EventBridgeBuilder_3;
import itemsadder.m.EventBridge_2;
import itemsadder.m.EventBridge_3;
import itemsadder.m.InfoNamespace_3;
import itemsadder.m.InteractEnum;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.Opaque022;
import itemsadder.m.Opaque124;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfValue_4;
import itemsadder.m.StopIfLastSuccessEnum;
import itemsadder.m.StringClassBoolData;
import itemsadder.m.SuccessEnum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class LivingEntityBridge_5 {
    final EntityTypeBarStyleHolder gB;
    public final HashMap gC = new HashMap();
    public final HashMap gD = new HashMap();

    public LivingEntityBridge_5(EntityTypeBarStyleHolder entityTypeBarStyleHolder) {
        this.gB = entityTypeBarStyleHolder;
    }

    public void aR() {
        String string = this.gB.nO.getNamespace();
        String string2 = this.gB.nO.getNamespacedID();
        PluginFileConfigurationHolder pluginFileConfigurationHolder = this.gB.fz();
        if (pluginFileConfigurationHolder == null) {
            return;
        }
        @Nullable ConfigurationSectionBridge configurationSectionBridge = pluginFileConfigurationHolder.hj("entities." + this.gB.nO.bM + ".events");
        if (configurationSectionBridge == null) {
            return;
        }
        for (InteractEnum interactEnum : InteractEnum.values()) {
            ConfigurationSectionBridge configurationSectionBridge2;
            if (!configurationSectionBridge.fo(interactEnum.toString())) continue;
            if (pluginFileConfigurationHolder.gP("entities." + this.gB.nO.bM + ".events." + String.valueOf((Object)interactEnum) + ".cooldown")) {
                this.gD.put(interactEnum, (long)(pluginFileConfigurationHolder.t("entities." + this.gB.nO.bM + ".events." + String.valueOf((Object)interactEnum) + ".cooldown", 0) / 20) * 1000L);
            }
            if ((configurationSectionBridge2 = configurationSectionBridge.hj(interactEnum.toString())) == null) continue;
            for (String string3 : PluginFileConfigurationHolder.b(configurationSectionBridge2, "")) {
                StringClassBoolData stringClassBoolData;
                Object object;
                Object object2;
                ConfigurationSectionBridge configurationSectionBridge3 = configurationSectionBridge2.hj(string3);
                if (configurationSectionBridge3 == null) continue;
                if (string3.startsWith("summon_entity")) {
                    object2 = configurationSectionBridge3.gV("entity");
                    if (object2 == null) {
                        CommandSenderBridge_5.error("Missing 'entity' for action '" + string3 + "' in event '" + String.valueOf((Object)interactEnum) + "' for entity '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    if (!LivingEntityRegistry.db().lJ.containsKey(object2)) {
                        CommandSenderBridge_5.error("Unknown entity '" + (String)object2 + "' for action '" + string3 + "' in event '" + String.valueOf((Object)interactEnum) + "' for entity '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    try {
                        object = ((EventBridgeBuilder_3)((EventBridgeBuilder_3)((EventBridgeBuilder_3)((EventBridgeBuilder_3)EventBridge_3.Z((String)object2).a(configurationSectionBridge3.c("max_per_chunk", (Integer)null)).U(configurationSectionBridge3.az("permission", null))).a(configurationSectionBridge3.a("delay", (Long)null))).a(this.a(configurationSectionBridge3))).V(string3)).bc();
                        this.a(interactEnum, (EntityBridgeImpl)object);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        CommandSenderBridge_5.error("Failed to register action '" + string3 + "' in event '" + String.valueOf((Object)interactEnum) + "' for entity '" + string2 + "'. " + illegalArgumentException.getMessage() + ". File: " + pluginFileConfigurationHolder.nh());
                    }
                    continue;
                }
                if (string3.startsWith("execute_command")) {
                    object2 = ((EventBridgeBuilder)((EventBridgeBuilder)((EventBridgeBuilder)((EventBridgeBuilder)EventBridge.aS().W(configurationSectionBridge3.gV("command")).k(configurationSectionBridge3.C("as_console", true)).l(configurationSectionBridge3.C("silent", true)).X(configurationSectionBridge3.az("flow_success_if_message_contains", null)).U(configurationSectionBridge3.az("permission", null))).a(configurationSectionBridge3.a("delay", (Long)null))).a(this.a(configurationSectionBridge3))).V(string3)).aU();
                    this.a(interactEnum, (EntityBridgeImpl)object2);
                    continue;
                }
                if (!string3.startsWith("script")) continue;
                object2 = configurationSectionBridge3.gV("name");
                if (object2 == null) {
                    CommandSenderBridge_5.error("&cMissing script name for action &e" + string3 + "&c of custom entity &e" + string2);
                    continue;
                }
                object2 = ((String)object2).replace(".jspp", "");
                object2 = ((String)object2).replace(".js", "");
                object = object2 = ((String)object2).replace(".java", "");
                if (!((String)object).contains(":")) {
                    object = string + ":" + (String)object2;
                }
                if ((stringClassBoolData = InfoNamespace_3.ck((String)object)) == null) {
                    CommandSenderBridge_5.error("&cScript &e" + (String)object + "&c not found for action &e" + string3 + "&c of item &e" + string2);
                    continue;
                }
                EventBridge_2 eventBridge_2 = EventBridge_2.aW().Y((String)object).a(stringClassBoolData).aY();
                this.a(interactEnum, eventBridge_2);
            }
        }
    }

    public Opaque124 a(ConfigurationSectionBridge configurationSectionBridge) {
        for (StopIfLastSuccessEnum stopIfLastSuccessEnum : StopIfLastSuccessEnum.values()) {
            if (!configurationSectionBridge.fo(stopIfLastSuccessEnum.key)) continue;
            String string = null;
            if (!(configurationSectionBridge.hm(stopIfLastSuccessEnum.key) instanceof Boolean)) {
                string = configurationSectionBridge.gV(stopIfLastSuccessEnum.key);
            }
            return new Opaque124(stopIfLastSuccessEnum, string);
        }
        return null;
    }

    public EntityBridgeImpl a(InteractEnum interactEnum, EntityBridgeImpl entityBridgeImpl) {
        List<EntityBridgeImpl> list = this.gC.containsKey((Object)interactEnum) ? (List)this.gC.get((Object)interactEnum) : new ArrayList<EntityBridgeImpl>();
        list.add(entityBridgeImpl);
        this.gC.put(interactEnum, list);
        return entityBridgeImpl;
    }

    public boolean a(InteractEnum interactEnum) {
        return this.gC.containsKey((Object)interactEnum);
    }

    public List b(InteractEnum interactEnum) {
        if (this.a(interactEnum)) {
            return (List)this.gC.get((Object)interactEnum);
        }
        return new ArrayList();
    }

    @Deprecated
    public List a(LivingEntity livingEntity, InteractEnum interactEnum) {
        if (this.a(interactEnum) && this.gB.om != null && !livingEntity.hasPermission(this.gB.om)) {
            CommandSenderBridge_5.f((CommandSender)livingEntity, Main.PQ.ir("no-permission-detail").replace("{permission}", this.gB.om));
            return new ArrayList();
        }
        return new ArrayList();
    }

    public void a(Entity entity, InteractEnum interactEnum, Consumer consumer) {
        if (!(entity instanceof LivingEntity)) {
            return;
        }
        if (this.a(interactEnum)) {
            if (this.gB.om != null && !entity.hasPermission(this.gB.om)) {
                CommandSenderBridge_5.f((CommandSender)entity, Main.PQ.ir("no-permission-detail").replace("{permission}", this.gB.om));
                return;
            }
            boolean bl = false;
            SuccessEnum successEnum = null;
            boolean bl2 = false;
            boolean bl3 = false;
            List list = null;
            List list2 = null;
            List list3 = (List)this.gC.get((Object)interactEnum);
            block14: for (EntityBridgeImpl entityBridgeImpl : list3) {
                if (entityBridgeImpl.aE() && !entityBridgeImpl.c(entity)) {
                    if (bl) continue;
                    CommandSenderBridge_5.f((CommandSender)entity, Main.PQ.ir("no-permission-detail").replace("{permission}", entityBridgeImpl.getPermission()));
                    bl = true;
                    continue;
                }
                if (entityBridgeImpl.aD()) {
                    BukkitTaskBridge.c(() -> consumer.accept(entityBridgeImpl), entityBridgeImpl.aG());
                    continue;
                }
                if (list3.size() <= 1) {
                    consumer.accept(entityBridgeImpl);
                    continue;
                }
                Opaque124 opaque124 = entityBridgeImpl.aH();
                if (opaque124 != null && successEnum != null) {
                    switch (opaque124.xm) {
                        case STOP_IF_LAST_SUCCESS: {
                            if (successEnum != SuccessEnum.SUCCESS) break;
                            return;
                        }
                        case STOP_IF_LAST_FAIL: {
                            if (successEnum != SuccessEnum.FAILED) break;
                            return;
                        }
                        case SKIP_IF_LAST_SUCCESS: {
                            if (successEnum != SuccessEnum.SUCCESS) break;
                            continue block14;
                        }
                        case SKIP_IF_LAST_FAIL: {
                            if (successEnum != SuccessEnum.FAILED) break;
                            continue block14;
                        }
                        case STOP_IF_ANY_SUCCESS: {
                            if (!bl3) break;
                            return;
                        }
                        case STOP_IF_ANY_FAIL: {
                            if (!bl2) break;
                            return;
                        }
                        case SKIP_IF_ANY_SUCCESS: {
                            if (!bl3) break;
                            continue block14;
                        }
                        case SKIP_IF_ANY_FAIL: {
                            if (!bl2) break;
                            continue block14;
                        }
                        case STOP_IF_SUCCESS: {
                            if (!bl3 || !Opaque022.c(list2, opaque124.xn)) break;
                            return;
                        }
                        case STOP_IF_FAIL: {
                            if (!bl2 || !Opaque022.c(list, opaque124.xn)) break;
                            return;
                        }
                        case SKIP_IF_SUCCESS: {
                            if (!bl3 || !Opaque022.c(list2, opaque124.xn)) break;
                            continue block14;
                        }
                        case SKIP_IF_FAIL: {
                            if (!bl2 || !Opaque022.c(list, opaque124.xn)) break;
                            continue block14;
                        }
                    }
                }
                RecordOfValue_4 recordOfValue_4 = consumer.accept(entityBridgeImpl);
                successEnum = recordOfValue_4.aO();
                if (recordOfValue_4.aO() == SuccessEnum.SUCCESS) {
                    bl3 = true;
                    list2 = Opaque022.b(list2, (Object)entityBridgeImpl.aF());
                    continue;
                }
                if (recordOfValue_4.aO() != SuccessEnum.FAILED) continue;
                bl2 = true;
                list = Opaque022.b(list, (Object)entityBridgeImpl.aF());
            }
        }
    }

    public boolean c(InteractEnum interactEnum) {
        return this.gD.containsKey((Object)interactEnum);
    }

    public Long d(InteractEnum interactEnum) {
        if (this.c(interactEnum)) {
            return (Long)this.gD.get((Object)interactEnum);
        }
        return 0L;
    }
}
