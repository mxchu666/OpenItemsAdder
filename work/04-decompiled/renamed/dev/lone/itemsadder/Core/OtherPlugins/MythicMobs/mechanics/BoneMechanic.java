package dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.mechanics;

import dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.MythicMobsHook;
import io.lumine.mythic.api.adapters.AbstractEntity;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.skills.ITargetedEntitySkill;
import io.lumine.mythic.api.skills.SkillMetadata;
import io.lumine.mythic.api.skills.SkillResult;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.core.skills.SkillMechanic;
import io.lumine.mythic.core.skills.mechanics.CustomMechanic;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LocationHolder_2;
import java.util.Map;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class BoneMechanic
extends SkillMechanic
implements ITargetedEntitySkill {
    @Nullable
    private final Boolean all;
    @Nullable
    private final String boneName;
    @Nullable
    private final Boolean visible;
    @Nullable
    private final Integer color;
    @Nullable
    private final Boolean enchant;

    public BoneMechanic(CustomMechanic customMechanic, String string, MythicLineConfig mythicLineConfig) {
        super(customMechanic.getManager(), string, mythicLineConfig);
        this.setAsyncSafe(false);
        this.all = MythicMobsHook.getBoolean(mythicLineConfig, new String[]{"all"});
        this.boneName = mythicLineConfig.getString("name");
        this.visible = MythicMobsHook.getBoolean(mythicLineConfig, new String[]{"visible", "vis"});
        this.color = MythicMobsHook.getInteger(mythicLineConfig, new String[]{"color", "col"});
        this.enchant = MythicMobsHook.getBoolean(mythicLineConfig, new String[]{"enchant", "ench"});
    }

    public SkillResult castAtEntity(SkillMetadata skillMetadata, AbstractEntity abstractEntity) {
        Entity entity = BukkitAdapter.adapt((AbstractEntity)skillMetadata.getCaster().getEntity());
        if (!(entity instanceof LivingEntity)) {
            CommandSenderBridge_5.error("Error loading MythicMobs entity: " + entity.getName() + ". You must use only living entities. For example: ZOMBIE, SKELETON...");
            return SkillResult.INVALID_TARGET;
        }
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().h(entity);
        if (livingEntityBuilder != null) {
            if (this.all != null && this.all.booleanValue()) {
                for (Map.Entry entry : livingEntityBuilder.na.entrySet()) {
                    LocationHolder_2 locationHolder_2 = (LocationHolder_2)entry.getValue();
                    this.handle(livingEntityBuilder, locationHolder_2);
                }
                return SkillResult.SUCCESS;
            }
            if (this.boneName == null) {
                return SkillResult.INVALID_CONFIG;
            }
            LocationHolder_2 locationHolder_2 = livingEntityBuilder.an(this.boneName);
            if (locationHolder_2 != null) {
                this.handle(livingEntityBuilder, locationHolder_2);
                return SkillResult.SUCCESS;
            }
            return SkillResult.INVALID_CONFIG;
        }
        if (entity.isDead()) {
            return SkillResult.SUCCESS;
        }
        String string = String.valueOf(entity.getUniqueId()) + " " + entity.getName() + " - " + String.valueOf(entity.getLocation());
        CommandSenderBridge_5.warn("Warning: MythicMobs entity " + string + " is not a custom entity!");
        return SkillResult.INVALID_TARGET;
    }

    private void handle(LivingEntityBuilder livingEntityBuilder, LocationHolder_2 locationHolder_2) {
        if (this.visible != null) {
            locationHolder_2.a(livingEntityBuilder.ea(), (boolean)this.visible);
        }
        if (this.enchant != null) {
            locationHolder_2.setEnchanted(this.enchant);
        }
        if (this.color != null) {
            locationHolder_2.setColor(this.color);
        }
    }
}
