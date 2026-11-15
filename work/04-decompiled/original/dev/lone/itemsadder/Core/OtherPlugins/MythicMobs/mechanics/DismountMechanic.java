package dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.mechanics;

import io.lumine.mythic.api.adapters.AbstractEntity;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.skills.ITargetedEntitySkill;
import io.lumine.mythic.api.skills.SkillMetadata;
import io.lumine.mythic.api.skills.SkillResult;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.core.skills.SkillMechanic;
import io.lumine.mythic.core.skills.mechanics.CustomMechanic;
import itemsadder.m.bce;
import itemsadder.m.da;
import itemsadder.m.dn;
import itemsadder.m.ek;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public class DismountMechanic
extends SkillMechanic
implements ITargetedEntitySkill {
    private final String[] seatsNames;
    private final boolean all;

    public DismountMechanic(CustomMechanic customMechanic, String string, MythicLineConfig mythicLineConfig) {
        super(customMechanic.getManager(), string, mythicLineConfig);
        this.setAsyncSafe(false);
        String string2 = mythicLineConfig.getString(new String[]{"bones"});
        this.seatsNames = string2.contains(",") ? string2.split(",") : new String[]{string2};
        this.all = mythicLineConfig.getBoolean("all");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public SkillResult castAtEntity(SkillMetadata skillMetadata, AbstractEntity abstractEntity) {
        Entity entity = BukkitAdapter.adapt((AbstractEntity)skillMetadata.getCaster().getEntity());
        if (!(entity instanceof LivingEntity)) {
            bce.error("Error loading MythicMobs entity: " + entity.getName() + ". You must use only living entities. For example: ZOMBIE, SKELETON...");
            return SkillResult.INVALID_TARGET;
        }
        dn dn2 = da.db().h(entity);
        if (dn2 != null) {
            if (this.all) {
                da.db().f(dn2);
                return SkillResult.SUCCESS;
            }
            if (this.seatsNames == null) return SkillResult.INVALID_CONFIG;
            int n = 0;
            String[] stringArray = this.seatsNames;
            int n2 = stringArray.length;
            if (n >= n2) return SkillResult.CONDITION_FAILED;
            String string = stringArray[n];
            ek ek2 = dn2.as(string);
            if (ek2 == null) return SkillResult.INVALID_CONFIG;
            if (!(abstractEntity.getBukkitEntity() instanceof LivingEntity)) return SkillResult.INVALID_CONFIG;
            da.db().a(ek2);
            return SkillResult.SUCCESS;
        }
        String string = String.valueOf(entity.getUniqueId()) + " " + entity.getName() + " - " + String.valueOf(entity.getLocation());
        bce.warn("Warning: MythicMobs entity " + string + " is not a custom entity!");
        return SkillResult.INVALID_TARGET;
    }
}
