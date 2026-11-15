package dev.lone.itemsadder.Core.OtherPlugins.Citizens;

import com.google.common.collect.Iterables;
import dev.lone.itemsadder.Core.OtherPlugins.Citizens.CustomEntityTrait;
import itemsadder.m.bce;
import itemsadder.m.dn;
import itemsadder.m.zw;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import net.citizensnpcs.Citizens;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.DespawnReason;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.SimpleNPCDataStore;
import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.api.trait.TraitInfo;
import net.citizensnpcs.api.util.DataKey;
import net.citizensnpcs.api.util.Storage;
import org.apache.commons.lang.reflect.MethodUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class CitizensHook {
    private static TraitInfo trait;
    private static boolean isReload;

    public static boolean isRegistered() {
        return trait != null;
    }

    public static void register() {
        trait = TraitInfo.create(CustomEntityTrait.class).withName("customentity");
        CitizensAPI.getTraitFactory().registerTrait(trait);
        bce.log("Registered Citizens NPC Trait: " + trait.getTraitName());
    }

    public static void unregister() {
        if (trait != null) {
            try {
                CitizensAPI.getTraitFactory().deregisterTrait(trait);
                trait = null;
                block2: for (NPC nPC : CitizensAPI.getNPCRegistry()) {
                    for (Trait trait : nPC.getTraits()) {
                        if (!trait.getName().equals("customentity")) continue;
                        nPC.data().set("has_customentity", (Object)true);
                        nPC.despawn(DespawnReason.RELOAD);
                        bce.log("Despawned Citizens NPC " + nPC.getId() + " on ItemsAdder unload.");
                        continue block2;
                    }
                }
            }
            catch (Throwable throwable) {
                bce.error("Failed to unregister CustomEntity trait for Citizens . Try to update to the latest version.", throwable);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void reload() {
        if (Iterables.size(CitizensAPI.getNPCRegistry()) == 0) {
            return;
        }
        boolean bl = false;
        int n = 0;
        if (isReload) {
            CitizensHook.saveAll();
        }
        try {
            Citizens citizens = (Citizens)CitizensAPI.getPlugin();
            SimpleNPCDataStore simpleNPCDataStore = (SimpleNPCDataStore)zw.a(Citizens.class, "saves", (Object)citizens);
            Storage storage = (Storage)zw.a(SimpleNPCDataStore.class, "root", (Object)simpleNPCDataStore);
            Iterable iterable = storage.getKey("npc").getIntegerSubKeys();
            for (NPC nPC : CitizensAPI.getNPCRegistry()) {
                boolean bl2 = false;
                for (Trait trait : nPC.getTraits()) {
                    if (!trait.getName().equals("customentity")) continue;
                    CitizensHook.respawn(nPC);
                    ++n;
                    if (bl) break;
                    bce.log("Reloading ItemsAdder Custom Entities Citizens NPCs...");
                    bl = true;
                    break;
                }
                if (bl2 || !nPC.data().has("has_customentity")) continue;
                nPC.data().remove("has_customentity");
                nPC.despawn(DespawnReason.RELOAD);
                try {
                    for (Trait trait : iterable) {
                        int n2 = Integer.parseInt(trait.name());
                        if (n2 != nPC.getId()) continue;
                        if (!trait.keyExists("name")) {
                            throw new RuntimeException("Cound not find a name for NPC: " + nPC.getId());
                        }
                        String string = trait.getString("traitnames");
                        if (!string.contains("customentity")) continue;
                        nPC.load((DataKey)trait);
                    }
                    ++n;
                    if (!bl) {
                        bce.log("Reloading ItemsAdder Custom Entities Citizens NPCs...");
                        bl = true;
                    }
                    bce.log("Spawned Citizens NPC " + nPC.getId() + " after ItemsAdder resources load.");
                }
                catch (Throwable throwable) {
                    bce.error("Failed to respawn Custom Entities Citizens NPC: " + String.valueOf(nPC), throwable);
                }
            }
        }
        catch (Throwable throwable) {
            bce.error("Failed to respawn Custom Entities Citizens NPCs", throwable);
        }
        finally {
            if (n > 0) {
                bce.log("Reloaded " + n + " ItemsAdder Custom Entities Citizens NPCs.");
            }
        }
        isReload = true;
    }

    public static void saveAll() {
        CitizensHook.saveAll(false);
    }

    public static void saveAll(boolean bl) {
        bce.iA("Saving Citizens NPCs");
        try {
            Method method = MethodUtils.getAccessibleMethod(Citizens.class, (String)"storeNPCsNow", (Class[])new Class[0]);
            method.invoke((Object)CitizensAPI.getPlugin(), new Object[0]);
        }
        catch (Throwable throwable) {
            try {
                Method method = MethodUtils.getAccessibleMethod(Citizens.class, (String)"storeNPCs", (Class[])new Class[0]);
                method.invoke((Object)CitizensAPI.getPlugin(), new Object[0]);
            }
            catch (Throwable throwable2) {
                try {
                    Method method = MethodUtils.getAccessibleMethod(Citizens.class, (String)"storeNPCs", Boolean.TYPE);
                    method.invoke((Object)CitizensAPI.getPlugin(), bl);
                }
                catch (Throwable throwable3) {
                    bce.error("Failed to save Citizens NPCs. Try to update to the latest version.", throwable);
                }
            }
        }
    }

    public static boolean isNPC(@Nullable LivingEntity livingEntity) {
        if (livingEntity == null) {
            return false;
        }
        return CitizensAPI.getNPCRegistry().isNPC((Entity)livingEntity);
    }

    public static void spawn(NPC nPC) {
        if (!nPC.isSpawned()) {
            nPC.spawn(nPC.getStoredLocation());
        }
    }

    public static void respawn(NPC nPC) {
        if (nPC.isSpawned()) {
            nPC.despawn();
            nPC.spawn(nPC.getStoredLocation());
        }
    }

    public static boolean isNameplateVisible(NPC nPC) {
        return (Boolean)nPC.data().get(NPC.Metadata.NAMEPLATE_VISIBLE, (Object)true);
    }

    @Nullable
    public static NPC getSelected(CommandSender commandSender) {
        return CitizensAPI.getDefaultNPCSelector().getSelected(commandSender);
    }

    @Nullable
    public static dn getSelectedNpcEntityRenderer(CommandSender commandSender) {
        NPC nPC = CitizensAPI.getDefaultNPCSelector().getSelected(commandSender);
        if (nPC == null) {
            return null;
        }
        CustomEntityTrait customEntityTrait = (CustomEntityTrait)nPC.getTraitNullable(CustomEntityTrait.class);
        if (customEntityTrait == null) {
            return null;
        }
        return customEntityTrait.getRenderer();
    }

    public static List getNpcsIds() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (NPC nPC : CitizensAPI.getNPCRegistry()) {
            arrayList.add(Integer.toString(nPC.getId()));
        }
        return arrayList;
    }

    static {
        isReload = false;
    }
}
