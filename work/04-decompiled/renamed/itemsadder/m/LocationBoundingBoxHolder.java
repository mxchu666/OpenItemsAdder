package itemsadder.m;

import dev.lone.itemsadder.Main;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PlayerJoinListener_2;
import itemsadder.m.PlayerToggleSneakListener;
import itemsadder.m.RecordOfValue_10;
import itemsadder.m.VersionHelper_3;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Interaction;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.jetbrains.annotations.Nullable;

public final class LocationBoundingBoxHolder {
    private static final long jg = TimeUnit.MILLISECONDS.toNanos(200L);
    private static final long jh = TimeUnit.SECONDS.toNanos(1L);
    private static final long ji = TimeUnit.MILLISECONDS.toNanos(200L);
    private static final double jj = 8.0;
    public ObjectArrayList jk = new ObjectArrayList();
    @Nullable
    public Location jl;
    @Nullable
    public BoundingBox jm;
    @Nullable
    private Interaction jn;
    private long jo;
    private long jp;
    private long jq;
    private boolean jr;
    @Nullable
    private volatile RecordOfValue_10 js;
    private boolean jt;
    private boolean ju = true;
    final Location jv;
    final Location jw;
    final Location jx;
    private final Player jy;
    long jz = 0L;
    final AtomicBoolean jA = new AtomicBoolean();
    final AtomicBoolean jB = new AtomicBoolean(true);
    final AtomicBoolean jC = new AtomicBoolean();
    final AtomicBoolean jD = new AtomicBoolean();
    final AtomicBoolean jE = new AtomicBoolean();
    volatile long jf;
    ObjectArrayList jF;
    int jG = Integer.MIN_VALUE;
    int jH = Integer.MIN_VALUE;
    @Nullable
    Float jI;
    @Nullable
    Float jJ;
    public boolean jK;
    public short jL;
    public byte jM;
    public byte jN;

    LocationBoundingBoxHolder(Player player) {
        World world = player.getWorld();
        this.jv = new Location(world, 0.0, 0.0, 0.0);
        this.jw = new Location(world, 0.0, 0.0, 0.0);
        this.jx = new Location(world, 0.0, 0.0, 0.0);
        this.jy = player;
        this.jF = new ObjectArrayList();
    }

    public float cg() {
        if (this.jI == null || this.jJ == null) {
            this.jI = Float.valueOf(this.jw.getYaw());
            this.jJ = Float.valueOf(this.jw.getPitch());
            return 0.0f;
        }
        float f = LocationBridge_2.D(this.jw.getYaw() - this.jI.floatValue());
        float f2 = this.jw.getPitch() - this.jJ.floatValue();
        this.jI = Float.valueOf(this.jw.getYaw());
        this.jJ = Float.valueOf(this.jw.getPitch());
        return (Math.abs(f) + Math.abs(f2)) / (float)PlayerToggleSneakListener.iB;
    }

    public void ch() {
        if (!this.jk.isEmpty()) {
            IntList intList = IntList.of((int[])this.jk.stream().mapToInt(Entity::getEntityId).toArray());
            PacketListenerRegistry.uN().a(this.jy, intList);
        }
        this.jk.clear();
        if (this.jn != null) {
            this.jn.remove();
            this.jn = null;
        }
        this.ju = true;
        this.jl = null;
        this.jm = null;
        this.jo = 0L;
        this.jt = false;
    }

    private boolean ci() {
        return this.jn != null && this.jn.isValid();
    }

    public boolean a(Interaction interaction) {
        return this.jn == interaction;
    }

    public void cj() {
        this.b(jg);
    }

    public void ck() {
        this.b(jh);
    }

    void cl() {
        this.jp = System.nanoTime() + ji;
    }

    boolean cm() {
        return System.nanoTime() < this.jp;
    }

    void cn() {
        this.cl();
        if (!MaterialBarColorHolder.ee || this.jr || VersionHelper_3.UQ && PlayerJoinListener_2.w(this.jy)) {
            return;
        }
        double d = PlayerHolder_4.uW().a(this.jy, 8.0);
        Location location = this.jy.getEyeLocation();
        this.js = new RecordOfValue_10(location.getX(), location.getY(), location.getZ(), d);
        this.jr = true;
    }

    private void co() {
        if (this.jr) {
            if (!MaterialBarColorHolder.ee || !this.cm()) {
                this.cp();
            } else {
                Location location = this.jy.getEyeLocation();
                RecordOfValue_10 recordOfValue_10 = this.js;
                if (recordOfValue_10 != null) {
                    this.js = new RecordOfValue_10(location.getX(), location.getY(), location.getZ(), recordOfValue_10.cv());
                }
            }
        } else if (this.js != null && System.nanoTime() >= this.jq) {
            this.js = null;
        }
    }

    boolean e(int n, int n2, int n3) {
        RecordOfValue_10 recordOfValue_10 = this.js;
        return recordOfValue_10 != null && LocationBoundingBoxHolder.a(recordOfValue_10.cs(), recordOfValue_10.ct(), recordOfValue_10.cu(), n, n2, n3, recordOfValue_10.cv());
    }

    static boolean a(double d, double d2, double d3, int n, int n2, int n3, double d4) {
        double d5;
        double d6;
        double d7;
        double d8 = Math.max(Math.max((double)n - d, 0.0), d - (double)n - 1.0);
        return d8 * d8 + (d7 = Math.max(Math.max((double)n2 - d2, 0.0), d2 - (double)n2 - 1.0)) * d7 + (d6 = Math.max(Math.max((double)n3 - d3, 0.0), d3 - (double)n3 - 1.0)) * d6 >= (d5 = d4 + 1.0) * d5;
    }

    private void cp() {
        if (!this.jr) {
            return;
        }
        if (this.jy.isOnline()) {
            PlayerHolder_4.uW().bV(this.jy);
        }
        this.jq = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(Math.max(200L, (long)this.jy.getPing() + 100L));
        this.jr = false;
    }

    private void a(BoundingBox boundingBox, boolean bl) {
        boolean bl2;
        if (!MaterialBarColorHolder.ed) {
            if (this.jn != null) {
                this.jn.remove();
                this.jn = null;
            }
            this.jt = false;
            return;
        }
        this.jt = bl;
        boolean bl3 = bl2 = !bl || this.jo != 0L && System.nanoTime() < this.jo;
        if (!bl2) {
            this.jo = 0L;
        }
        float f = bl2 ? 0.0f : (float)Math.max(boundingBox.getWidthX(), boundingBox.getWidthZ());
        float f2 = bl2 ? 0.0f : (float)boundingBox.getHeight();
        Location location = new Location(this.jy.getWorld(), boundingBox.getCenterX(), boundingBox.getMinY(), boundingBox.getCenterZ());
        if (!this.ci()) {
            this.jn = (Interaction)this.jy.getWorld().spawn(location, Interaction.class, interaction -> {
                interaction.setPersistent(false);
                interaction.setVisibleByDefault(false);
                interaction.setResponsive(true);
                interaction.setInvisible(true);
                interaction.setInteractionWidth(f);
                interaction.setInteractionHeight(f2);
            });
            this.jy.showEntity((Plugin)Main.rS(), (Entity)this.jn);
            return;
        }
        this.jn.teleport(location);
        this.a(f, f2);
    }

    private void b(long l) {
        this.jo = Math.max(this.jo, System.nanoTime() + l);
        this.a(0.0f, 0.0f);
    }

    private void cq() {
        if (!MaterialBarColorHolder.ed || this.jo == 0L || System.nanoTime() < this.jo || !this.jt || this.ju || this.jm == null || !this.ci()) {
            return;
        }
        this.jo = 0L;
        this.a((float)Math.max(this.jm.getWidthX(), this.jm.getWidthZ()), (float)this.jm.getHeight());
    }

    private void a(float f, float f2) {
        if (!this.ci()) {
            return;
        }
        if (this.jn.getInteractionWidth() != f) {
            this.jn.setInteractionWidth(f);
        }
        if (this.jn.getInteractionHeight() != f2) {
            this.jn.setInteractionHeight(f2);
        }
    }

    public void cr() {
        if (this.ju) {
            return;
        }
        Location location = new Location(this.jy.getWorld(), 0.0, -1000.0, 0.0);
        for (ItemDisplay itemDisplay : this.jk) {
            PacketListenerRegistry.uN().a((Entity)itemDisplay, this.jy, location);
        }
        this.a(0.0f, 0.0f);
        this.ju = true;
    }

    public void p(boolean bl) {
        if (bl) {
            this.ch();
        }
        this.jk.clear();
        this.ju = true;
        this.jl = null;
        this.jm = null;
        this.jo = 0L;
        this.jp = 0L;
        this.jq = 0L;
        this.jr = false;
        this.js = null;
        this.jt = false;
        this.jF.clear();
    }
}
