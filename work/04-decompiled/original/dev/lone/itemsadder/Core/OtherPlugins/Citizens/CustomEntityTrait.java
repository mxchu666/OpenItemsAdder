package dev.lone.itemsadder.Core.OtherPlugins.Citizens;

import itemsadder.m.ae;
import itemsadder.m.afz;
import itemsadder.m.da;
import itemsadder.m.db;
import itemsadder.m.dn;
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
        if (!ae.dL) {
            return;
        }
    }

    public void onSpawn() {
        if (!ae.dL) {
            return;
        }
        if (this.namespacedId != null) {
            if (!da.db().lJ.containsKey(this.namespacedId)) {
                return;
            }
            this.initRenderer(false);
        }
    }

    public void onDespawn() {
        dn dn2 = this.getRenderer();
        if (dn2 != null) {
            da.db().a(dn2, false, false);
        }
    }

    public void save(DataKey dataKey) {
    }

    public void run() {
    }

    public void onAttach() {
    }

    public void onRemove() {
        dn dn2 = this.getRenderer();
        if (dn2 != null) {
            da.db().a(dn2, false, true);
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
        dn dn2 = da.db().e(this.npc.getEntity().getUniqueId());
        if (dn2 != null) {
            if (!dn2.my.nO.pD) {
                this.namespacedId = "_iainternal:player";
                dn2 = this.initRenderer(false);
            }
            string = this.resolvePlayerSkin(string);
            dn2.changePlayerSkin(string);
            this.customPlayerSkin = dn2.ek();
        }
    }

    public static void fixEntityType(NPC nPC) {
        if (!afz.tK().P(nPC.getEntity())) {
            nPC.setBukkitEntityType(EntityType.ZOMBIE);
        }
    }

    @Nullable
    dn initRenderer(boolean bl) {
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

    private dn attachNewPlayerRenderer() {
        dn dn2 = da.db().a(this.namespacedId, null, (LivingEntity)this.npc.getEntity(), true, true, false, true, true);
        if (this.customPlayerSkin != null) {
            dn2.changePlayerSkin(this.customPlayerSkin);
        }
        dn2.dV();
        dn2.dX();
        return dn2;
    }

    public void playAnim(String string, int n) {
        dn dn2 = da.db().e(this.npc.getEntity().getUniqueId());
        if (dn2 != null) {
            if (!da.h(dn2) && !da.db().dp().contains(this.namespacedId)) {
                dn2.playAnim(string, n);
                return;
            }
            db db2 = da.a(dn2, string);
            this.namespacedId = db2.mb;
        }
    }

    public void pauseAnim() {
        dn dn2 = da.db().e(this.npc.getEntity().getUniqueId());
        if (dn2 != null) {
            dn2.ec().gm();
        }
    }

    public dn getRenderer() {
        return da.db().h(this.npc.getEntity());
    }
}
