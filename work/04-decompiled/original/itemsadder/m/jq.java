package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.bbi;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.da;
import itemsadder.m.dn;
import itemsadder.m.ki;
import itemsadder.m.qm;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class jq
extends ki {
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

    public jq(qm qm2, String object, @Nullable Integer n, @Nullable Integer n2, @Nullable Integer n3) {
        super(qm2);
        this.gN = n;
        this.xZ = n2;
        this.ya = n3;
        EntityType entityType = (EntityType)bbi.e(((String)object).toUpperCase(), EntityType.class);
        if (entityType != null) {
            this.gM = entityType;
        } else {
            if (!((String)object).contains(":")) {
                object = qm2.getNamespace() + ":" + (String)object;
            }
            if (ae.dL && da.db().lJ.containsKey(object)) {
                this.gL = object;
            }
        }
        if (this.gM == null && this.gL == null) {
            throw new IllegalArgumentException("Invalid entity id: " + (String)object);
        }
    }

    public void a(Player player, ItemStack itemStack, Location location) {
        if (this.xZ != null && this.xZ > 0 && !bbs.ap(itemStack)) {
            bce.warn("Item '" + this.zk.getNamespacedID() + "' has no durability. Failed to execute 'entity_summoner' behaviour. File: " + this.zk.nh());
            return;
        }
        boolean bl = false;
        int n = this.gN != null ? this.gN : ae.dR;
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
                if (!da.db().f(entity) || ++n2 < n) continue;
                return;
            }
            dn dn2 = da.db().a(this.gL, location, true);
            if (dn2 != null) {
                bl = true;
            }
        }
        if (bl) {
            if (player.getGameMode() == GameMode.CREATIVE) {
                return;
            }
            if (this.ya != null && this.ya > 0) {
                bbs.aj(itemStack);
                return;
            }
            if (this.xZ != null && this.xZ > 0) {
                bbs.a(itemStack, this.xZ, false, true);
            }
        }
    }
}
