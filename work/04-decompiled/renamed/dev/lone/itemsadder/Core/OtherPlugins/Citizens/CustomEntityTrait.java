package dev.lone.itemsadder.Core.OtherPlugins.Citizens;

import itemsadder.m.BoolStringData;
import itemsadder.m.EntityHolder;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.MaterialBarColorHolder;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.persistence.Persist;
import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.api.util.DataKey;
import net.citizensnpcs.trait.HologramTrait;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class CustomEntityTrait
extends Trait {
    @Persist(value="namespacedId")
    String namespacedId;
    @Persist(value="customPlayerSkin")
    String customPlayerSkin;

    public CustomEntityTrait() {
        super("customentity");
    }

    public static CustomEntityTrait inject(NPC nPC) {
        CustomEntityTrait.fixEntityType(nPC);
        return (CustomEntityTrait)nPC.getOrAddTrait(CustomEntityTrait.class);
    }

    public void load(DataKey dataKey) {
        if (!MaterialBarColorHolder.dL) {
            return;
        }
    }

    public void onSpawn() {
        if (!MaterialBarColorHolder.dL) {
            return;
        }
        if (this.namespacedId != null) {
            if (!LivingEntityRegistry.db().lJ.containsKey(this.namespacedId)) {
                return;
            }
            this.initRenderer(false);
        }
    }

    public void onDespawn() {
        LivingEntityBuilder livingEntityBuilder = this.getRenderer();
        if (livingEntityBuilder != null) {
            LivingEntityRegistry.db().a(livingEntityBuilder, false, false);
        }
    }

    public void save(DataKey dataKey) {
    }

    public void run() {
    }

    public void onAttach() {
    }

    public void onRemove() {
        LivingEntityBuilder livingEntityBuilder = this.getRenderer();
        if (livingEntityBuilder != null) {
            LivingEntityRegistry.db().a(livingEntityBuilder, false, true);
        }
    }

    public void applyModel(String string, boolean bl) {
        this.namespacedId = string;
        this.initRenderer(bl);
    }

    public void initPlayerModel(@Nullable String string) {
        this.namespacedId = "_iainternal:player";
        this.customPlayerSkin = this.resolvePlayerSkin(string);
        this.initRenderer(true);
    }

    private String resolvePlayerSkin(String string) {
        SkinTrait skinTrait;
        if (string != null && (string.equals("CITIZENS_SKIN") || string.equals("KEEP_CURRENT_SKIN")) && (skinTrait = (SkinTrait)this.npc.getTraitNullable(SkinTrait.class)) != null) {
            if (skinTrait.getTexture() != null) {
                string = skinTrait.getTexture();
            } else if (skinTrait.getSkinName() != null) {
                string = skinTrait.getSkinName();
            } else if (skinTrait.getName() != null) {
                string = skinTrait.getName();
            }
        }
        return string;
    }

    public void changePlayerSkin(String string) {
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().e(this.npc.getEntity().getUniqueId());
        if (livingEntityBuilder != null) {
            if (!livingEntityBuilder.my.nO.pD) {
                this.namespacedId = "_iainternal:player";
                livingEntityBuilder = this.initRenderer(false);
            }
            string = this.resolvePlayerSkin(string);
            livingEntityBuilder.changePlayerSkin(string);
            this.customPlayerSkin = livingEntityBuilder.ek();
        }
    }

    public static void fixEntityType(NPC nPC) {
        if (!EntityHolder.tK().P(nPC.getEntity())) {
            nPC.setBukkitEntityType(EntityType.ZOMBIE);
        }
    }

    @Nullable
    LivingEntityBuilder initRenderer(boolean bl) {
        if (bl) {
            this.npc.setAlwaysUseNameHologram(true);
            this.npc.data().setPersistent(NPC.Metadata.SILENT, (Object)true);
            this.npc.data().setPersistent(NPC.Metadata.AMBIENT_SOUND, (Object)"");
            this.npc.data().setPersistent(NPC.Metadata.DEATH_SOUND, (Object)"");
            this.npc.data().setPersistent(NPC.Metadata.HURT_SOUND, (Object)"");
            HologramTrait hologramTrait = (HologramTrait)this.npc.getTraitNullable(HologramTrait.class);
            if (hologramTrait != null && hologramTrait.getLineHeight() == -1.0) {
                hologramTrait.setLineHeight(0.0);
            }
        }
        return this.attachNewPlayerRenderer();
    }

    private LivingEntityBuilder attachNewPlayerRenderer() {
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().a(this.namespacedId, null, (LivingEntity)this.npc.getEntity(), true, true, false, true, true);
        if (this.customPlayerSkin != null) {
            livingEntityBuilder.changePlayerSkin(this.customPlayerSkin);
        }
        livingEntityBuilder.dV();
        livingEntityBuilder.dX();
        return livingEntityBuilder;
    }

    public void playAnim(String string, int n) {
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().e(this.npc.getEntity().getUniqueId());
        if (livingEntityBuilder != null) {
            if (!LivingEntityRegistry.h(livingEntityBuilder) && !LivingEntityRegistry.db().dp().contains(this.namespacedId)) {
                livingEntityBuilder.playAnim(string, n);
                return;
            }
            BoolStringData boolStringData = LivingEntityRegistry.a(livingEntityBuilder, string);
            this.namespacedId = boolStringData.mb;
        }
    }

    public void pauseAnim() {
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().e(this.npc.getEntity().getUniqueId());
        if (livingEntityBuilder != null) {
            livingEntityBuilder.ec().gm();
        }
    }

    public LivingEntityBuilder getRenderer() {
        return LivingEntityRegistry.db().h(this.npc.getEntity());
    }
}
