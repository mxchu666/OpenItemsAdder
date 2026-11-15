package itemsadder.m;

import itemsadder.m.EntityAndBlockEnum;
import itemsadder.m.VectorBridge_4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

public class PlayerLocationHolder_2 {
    private ArrayList aDe;
    private ArrayList aDf;
    private Player iW;
    private Location iZ;
    private double lc;
    private EntityAndBlockEnum aDg;
    private Entity aDh;
    private Block aDi;
    private Location aDj;
    private boolean aDk;
    private boolean aDl = false;
    private Entity aDm;
    private Location aDn;
    private boolean aDo;
    private FluidCollisionMode aDp = FluidCollisionMode.NEVER;
    private double aDq = 0.0;

    public PlayerLocationHolder_2(Location location, double d) {
        this.aDe = new ArrayList();
        this.aDf = new ArrayList();
        this.ag(Material.AIR);
        this.ag(Material.CAVE_AIR);
        this.ag(Material.VOID_AIR);
        this.aDo = true;
        this.iZ = location;
        this.lc = d;
    }

    public PlayerLocationHolder_2(Player player, double d) {
        this(player, d, 0.0);
    }

    public PlayerLocationHolder_2(Player player, double d, double d2) {
        this(player.getEyeLocation(), d);
        this.iW = player;
        this.aDm = player;
        this.aDq = d2;
    }

    public static PlayerLocationHolder_2 a(Player player, double d, double d2) {
        return new PlayerLocationHolder_2(player, d, d2);
    }

    public void a(FluidCollisionMode fluidCollisionMode) {
        this.aDp = fluidCollisionMode;
    }

    private RayTraceResult Er() {
        return this.iZ.getWorld().rayTraceBlocks(this.iZ, this.iZ.getDirection(), this.lc, this.aDp, true);
    }

    private RayTraceResult Es() {
        if (this.iW == null) {
            return this.iZ.getWorld().rayTraceEntities(this.iZ, this.iZ.getDirection(), this.lc);
        }
        return this.iZ.getWorld().rayTraceEntities(this.iW.getEyeLocation(), this.iW.getEyeLocation().getDirection(), this.lc, this.aDq, entity -> this.iW != null && entity.getEntityId() != this.iW.getEntityId());
    }

    private RayTraceResult Et() {
        if (this.iW == null) {
            return this.iZ.getWorld().rayTrace(this.iZ, this.iZ.getDirection(), this.lc, this.aDp, true, this.aDq, entity -> this.iW != null && entity.getEntityId() != this.iW.getEntityId());
        }
        return this.iZ.getWorld().rayTrace(this.iW.getEyeLocation(), this.iW.getEyeLocation().getDirection(), this.lc, this.aDp, true, this.aDq, entity -> this.iW != null && entity.getEntityId() != this.iW.getEntityId());
    }

    public boolean a(EntityAndBlockEnum entityAndBlockEnum) {
        this.aDf.clear();
        if (!this.aDk && this.aDo) {
            RayTraceResult rayTraceResult = null;
            switch (entityAndBlockEnum.ordinal()) {
                case 0: {
                    rayTraceResult = this.Et();
                    break;
                }
                case 2: {
                    rayTraceResult = this.Er();
                    break;
                }
                case 1: {
                    rayTraceResult = this.Es();
                }
            }
            if (rayTraceResult != null) {
                this.aDi = null;
                this.aDh = rayTraceResult.getHitEntity();
                this.aDi = rayTraceResult.getHitBlock();
                this.aDj = new Location(this.iZ.getWorld(), rayTraceResult.getHitPosition().getX(), rayTraceResult.getHitPosition().getY(), rayTraceResult.getHitPosition().getZ());
                return true;
            }
        } else {
            int n = 0;
            this.b(new Vector(0.0, 0.0, (double)n + 50.0));
            if (entityAndBlockEnum == EntityAndBlockEnum.BLOCK) {
                this.aDg = EntityAndBlockEnum.BLOCK;
                while (this.aDe.contains(this.aDn.getBlock().getType()) && (double)n <= this.lc * 100.0) {
                    this.aDf.add(this.aDn);
                    this.b(new Vector(0.0, 0.0, (double)(++n) + 50.0));
                    if (!this.aDl) continue;
                    this.iZ.getWorld().spawnParticle(Particle.CLOUD, this.aDn.getX(), this.aDn.getY(), this.aDn.getZ(), 0, 0.0, 0.0, 0.0);
                }
                if (!this.aDe.contains(this.aDn.getBlock().getType())) {
                    this.aDi = this.aDn.getBlock();
                    this.aDj = this.aDn;
                    return true;
                }
            } else if (entityAndBlockEnum == EntityAndBlockEnum.ENTITY) {
                this.aDg = EntityAndBlockEnum.ENTITY;
                Collection collection = this.iZ.getWorld().getNearbyEntities(this.aDn, 0.01, 0.01, 0.01);
                while ((collection.size() <= 0 || collection.contains(this.aDm)) && (double)n <= this.lc * 100.0) {
                    this.aDf.add(this.aDn);
                    this.b(new Vector(0.0, 0.0, (double)(++n) + 50.0));
                    collection = this.iZ.getWorld().getNearbyEntities(this.aDn, 0.01, 0.01, 0.01);
                    if (!this.aDl) continue;
                    this.iZ.getWorld().spawnParticle(Particle.CLOUD, this.aDn.getX(), this.aDn.getY(), this.aDn.getZ(), 0, 0.0, 0.0, 0.0);
                }
                if (collection.size() > 0) {
                    Iterator iterator = collection.iterator();
                    while (iterator.hasNext()) {
                        Entity entity;
                        this.aDh = entity = (Entity)iterator.next();
                        this.aDj = this.aDn;
                    }
                    return true;
                }
            } else if (entityAndBlockEnum == EntityAndBlockEnum.ENTITY_AND_BLOCK) {
                Collection collection = this.iZ.getWorld().getNearbyEntities(this.aDn, 0.01, 0.01, 0.01);
                while (this.aDe.contains(this.aDn.getBlock().getType()) && (collection.size() <= 0 || collection.contains(this.aDm)) && (double)n <= this.lc * 100.0) {
                    this.aDf.add(this.aDn);
                    this.b(new Vector(0.0, 0.0, (double)(++n) + 50.0));
                    collection = this.iZ.getWorld().getNearbyEntities(this.aDn, 0.01, 0.01, 0.01);
                    if (!this.aDl) continue;
                    this.iZ.getWorld().spawnParticle(Particle.CLOUD, this.aDn.getX(), this.aDn.getY(), this.aDn.getZ(), 0, 0.0, 0.0, 0.0);
                }
                if (!this.aDe.contains(this.aDn.getBlock().getType())) {
                    this.aDg = EntityAndBlockEnum.BLOCK;
                    this.aDi = this.aDn.getBlock();
                    this.aDj = this.aDn;
                    return true;
                }
                if (collection.size() > 0) {
                    this.aDg = EntityAndBlockEnum.ENTITY;
                    Iterator iterator = collection.iterator();
                    while (iterator.hasNext()) {
                        Entity entity;
                        this.aDh = entity = (Entity)iterator.next();
                        this.aDj = this.aDn;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void b(Vector vector) {
        vector = VectorBridge_4.a(vector, this.iZ.getYaw(), this.iZ.getPitch());
        this.aDn = new Location(this.iZ.getWorld(), this.iZ.getX(), this.iZ.getY(), this.iZ.getZ()).clone().add(vector.getX() / 100.0, vector.getY() / 100.0, vector.getZ() / 100.0);
    }

    public ArrayList Eu() {
        return this.aDe;
    }

    public void b(ArrayList arrayList) {
        this.aDe = arrayList;
    }

    public void ag(Material material) {
        if (!this.aDe.contains(material)) {
            this.aDo = false;
            this.aDe.add(material);
        }
    }

    public ArrayList Ev() {
        return this.aDf;
    }

    public World cE() {
        return this.iZ.getWorld();
    }

    public double Ew() {
        return this.iZ.getX();
    }

    public double Ex() {
        return this.iZ.getY();
    }

    public double Ey() {
        return this.iZ.getZ();
    }

    public double Ez() {
        return this.iZ.getYaw();
    }

    public double EA() {
        return this.iZ.getPitch();
    }

    public double EB() {
        return this.lc;
    }

    public void u(double d) {
        this.lc = d;
    }

    public EntityAndBlockEnum EC() {
        return this.aDg;
    }

    public void b(EntityAndBlockEnum entityAndBlockEnum) {
        this.aDg = entityAndBlockEnum;
    }

    public Entity ED() {
        return this.aDh;
    }

    public void V(Entity entity) {
        this.aDh = entity;
    }

    public boolean EE() {
        return this.aDh != null;
    }

    public Block EF() {
        return this.aDi;
    }

    public boolean EG() {
        return this.aDi != null;
    }

    public void bv(Block block) {
        this.aDi = block;
    }

    public Location EH() {
        return this.aDj;
    }

    public void ak(Location location) {
        this.aDj = location;
    }

    public boolean EI() {
        return this.aDj != null;
    }

    public boolean EJ() {
        return this.aDl;
    }

    @Deprecated
    public void bd(boolean bl) {
        this.aDl = bl;
    }

    public void be(boolean bl) {
        this.aDk = bl;
    }

    public Entity EK() {
        return this.aDm;
    }

    public void W(Entity entity) {
        this.aDm = entity;
    }
}
