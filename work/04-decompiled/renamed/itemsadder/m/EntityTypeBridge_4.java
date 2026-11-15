package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque126;
import itemsadder.m.SoundCategoryBridge;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class EntityTypeBridge_4
extends Opaque126 {
    public static final String xY = "entity_summoner";
    @Nullable
    public String gL;
    @Nullable
    public EntityType gM;
    @Nullable
    public Integer gN;
    @Nullable
    public Integer xZ;
    @Nullable
    public Integer ya;

    public EntityTypeBridge_4(ItemStackBuilder_4 itemStackBuilder_4, String object, @Nullable Integer n, @Nullable Integer n2, @Nullable Integer n3) {
        super(itemStackBuilder_4);
        this.gN = n;
        this.xZ = n2;
        this.ya = n3;
        EntityType entityType = (EntityType)SoundCategoryBridge.e(((String)object).toUpperCase(), EntityType.class);
        if (entityType != null) {
            this.gM = entityType;
        } else {
            if (!((String)object).contains(":")) {
                object = itemStackBuilder_4.getNamespace() + ":" + (String)object;
            }
            if (MaterialBarColorHolder.dL && LivingEntityRegistry.db().lJ.containsKey(object)) {
                this.gL = object;
            }
        }
        if (this.gM == null && this.gL == null) {
            throw new IllegalArgumentException("Invalid entity id: " + (String)object);
        }
    }

    public void a(Player player, ItemStack itemStack, Location location) {
        if (this.xZ != null && this.xZ > 0 && !ItemStackBridge_2.ap(itemStack)) {
            CommandSenderBridge_5.warn("Item '" + this.zk.getNamespacedID() + "' has no durability. Failed to execute 'entity_summoner' behaviour. File: " + this.zk.nh());
            return;
        }
        boolean bl = false;
        int n = this.gN != null ? this.gN : MaterialBarColorHolder.dR;
        int n2 = 0;
        if (this.gM != null) {
            for (Entity entity : location.getChunk().getEntities()) {
                if (entity.getType() != this.gM || ++n2 < n) continue;
                return;
            }
            location.getWorld().spawnEntity(location, this.gM);
            bl = true;
        } else {
            for (Entity entity : location.getChunk().getEntities()) {
                if (!LivingEntityRegistry.db().f(entity) || ++n2 < n) continue;
                return;
            }
            LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().a(this.gL, location, true);
            if (livingEntityBuilder != null) {
                bl = true;
            }
        }
        if (bl) {
            if (player.getGameMode() == GameMode.CREATIVE) {
                return;
            }
            if (this.ya != null && this.ya > 0) {
                ItemStackBridge_2.aj(itemStack);
                return;
            }
            if (this.xZ != null && this.xZ > 0) {
                ItemStackBridge_2.a(itemStack, this.xZ, false, true);
            }
        }
    }
}
