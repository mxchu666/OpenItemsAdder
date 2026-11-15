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
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public class CustomEntityMechanic
extends SkillMechanic
implements ITargetedEntitySkill {
    private final String namespacedId;
    private final String playerSkin;
    private final String animationPlay;
    private final boolean animationStop;
    private final String animationIdle;
    private final String animationWalk;
    private final String animationAttack;
    private final String animationDeath;

    public CustomEntityMechanic(CustomMechanic customMechanic, String string, MythicLineConfig mythicLineConfig) {
        super(customMechanic.getManager(), string, mythicLineConfig);
        this.setAsyncSafe(false);
        this.playerSkin = mythicLineConfig.getString(new String[]{"playerskin"}, null, new String[0]);
        this.namespacedId = this.playerSkin == null ? mythicLineConfig.getString(new String[]{"id", "model", "entity"}) : "_iainternal:player";
        this.animationPlay = mythicLineConfig.getString(new String[]{"play"});
        this.animationStop = mythicLineConfig.getBoolean("stop");
        this.animationIdle = mythicLineConfig.getString("idle");
        this.animationWalk = mythicLineConfig.getString("walk");
        this.animationAttack = mythicLineConfig.getString("attack");
        this.animationDeath = mythicLineConfig.getString("death");
    }

    /*
     * Enabled aggressive block sorting
     */
    public SkillResult castAtEntity(SkillMetadata skillMetadata, AbstractEntity abstractEntity) {
        dn dn2;
        Entity entity = BukkitAdapter.adapt((AbstractEntity)skillMetadata.getCaster().getEntity());
        if (!(entity instanceof LivingEntity)) {
            bce.error("Error loading MythicMobs entity: " + entity.getName() + ". You must use only living entities. For example: ZOMBIE, SKELETON...");
            return SkillResult.INVALID_TARGET;
        }
        this.setAsyncSafe(false);
        if (this.namespacedId != null) {
            if (!da.db().lJ.containsKey(this.namespacedId)) {
                bce.error("Unknown custom entity id '" + this.namespacedId + "' in MythicMobs config.");
                return SkillResult.CONDITION_FAILED;
            }
            dn2 = da.db().a(this.namespacedId, this.playerSkin, (LivingEntity)entity, true, true, false, true);
        } else {
            dn2 = da.db().h(entity);
        }
        this.setAsyncSafe(true);
        if (dn2 == null) {
            String string = String.valueOf(entity.getUniqueId()) + " " + entity.getName() + " - " + String.valueOf(entity.getLocation());
            bce.warn("Warning: MythicMobs entity " + string + " is not a custom entity!");
            return SkillResult.INVALID_TARGET;
        }
        if (this.animationIdle != null) {
            dn2.c(dn2.ar(this.animationIdle));
        }
        if (this.animationWalk != null) {
            dn2.d(dn2.ar(this.animationWalk));
        }
        if (this.animationAttack != null) {
            dn2.e(dn2.ar(this.animationAttack));
        }
        if (this.animationDeath != null) {
            dn2.f(dn2.ar(this.animationDeath));
        }
        if (this.animationStop) {
            dn2.ec().gm();
            return SkillResult.SUCCESS;
        }
        if (this.animationPlay == null) return SkillResult.SUCCESS;
        dn2.playAnim(this.animationPlay, 0);
        return SkillResult.SUCCESS;
    }
}
