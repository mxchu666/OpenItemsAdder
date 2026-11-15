package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.lone.itemsadder.Core.OtherPlugins.mmoitems.MmoItemsHook;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.ItemsAdderFirstLoadEvent;
import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent;
import dev.lone.itemsadder.api.ItemsAdder$Advanced$InjectedItemModifier;
import dev.lone.itemsadder.resourcepack.av;
import dev.lone.itemsadder.resourcepack.bk;
import itemsadder.m.a;
import itemsadder.m.aa;
import itemsadder.m.aad;
import itemsadder.m.ac;
import itemsadder.m.ad;
import itemsadder.m.ae;
import itemsadder.m.ai;
import itemsadder.m.aj;
import itemsadder.m.an;
import itemsadder.m.aow;
import itemsadder.m.asg;
import itemsadder.m.azr;
import itemsadder.m.b;
import itemsadder.m.bbe;
import itemsadder.m.bbf;
import itemsadder.m.bbi;
import itemsadder.m.bbr;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.bcm;
import itemsadder.m.bcp;
import itemsadder.m.bcy;
import itemsadder.m.bdh;
import itemsadder.m.bdq;
import itemsadder.m.bev;
import itemsadder.m.bip;
import itemsadder.m.c;
import itemsadder.m.co;
import itemsadder.m.cy;
import itemsadder.m.da;
import itemsadder.m.e;
import itemsadder.m.f;
import itemsadder.m.fa;
import itemsadder.m.fc;
import itemsadder.m.fm;
import itemsadder.m.fv;
import itemsadder.m.g;
import itemsadder.m.h;
import itemsadder.m.ih;
import itemsadder.m.jd;
import itemsadder.m.ki;
import itemsadder.m.kk;
import itemsadder.m.kl;
import itemsadder.m.km;
import itemsadder.m.kn;
import itemsadder.m.ko;
import itemsadder.m.kp;
import itemsadder.m.kq;
import itemsadder.m.kr;
import itemsadder.m.ks;
import itemsadder.m.kt;
import itemsadder.m.kv;
import itemsadder.m.kw;
import itemsadder.m.kx;
import itemsadder.m.kz;
import itemsadder.m.la;
import itemsadder.m.lh;
import itemsadder.m.lo;
import itemsadder.m.lr;
import itemsadder.m.lw;
import itemsadder.m.mc;
import itemsadder.m.mk;
import itemsadder.m.ms;
import itemsadder.m.mv;
import itemsadder.m.na;
import itemsadder.m.pe;
import itemsadder.m.pf;
import itemsadder.m.pg;
import itemsadder.m.ph;
import itemsadder.m.pi;
import itemsadder.m.pm;
import itemsadder.m.po;
import itemsadder.m.pp;
import itemsadder.m.pu;
import itemsadder.m.pv;
import itemsadder.m.pw;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.qx;
import itemsadder.m.r;
import itemsadder.m.ra;
import itemsadder.m.rb;
import itemsadder.m.ro;
import itemsadder.m.rz;
import itemsadder.m.s;
import itemsadder.m.sk;
import itemsadder.m.sq;
import itemsadder.m.sr;
import itemsadder.m.sv;
import itemsadder.m.sy;
import itemsadder.m.t;
import itemsadder.m.td;
import itemsadder.m.te;
import itemsadder.m.tf;
import itemsadder.m.tl;
import itemsadder.m.ty;
import itemsadder.m.ur;
import itemsadder.m.us;
import itemsadder.m.ux;
import itemsadder.m.vc;
import itemsadder.m.vg;
import itemsadder.m.vm;
import itemsadder.m.vp;
import itemsadder.m.vq;
import itemsadder.m.vs;
import itemsadder.m.vu;
import itemsadder.m.vx;
import itemsadder.m.we;
import itemsadder.m.wi;
import itemsadder.m.wz;
import itemsadder.m.xe;
import itemsadder.m.xj;
import itemsadder.m.y;
import itemsadder.m.yp;
import itemsadder.m.yy;
import itemsadder.m.yz;
import itemsadder.m.z;
import itemsadder.m.zd;
import itemsadder.m.ze;
import itemsadder.m.zo;
import itemsadder.m.zw;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.stream.Collectors;
import lombok.Generated;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class d {
    private final AtomicBoolean c = new AtomicBoolean();
    @Deprecated
    public static Gson d;
    static d e;
    final Plugin f;
    public static final String g;
    public static final String i;
    public static final String j = "generated.zip";
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q = "__manually_handled";
    public static final char r = '~';
    static Set s;
    static Set t;
    public volatile boolean u;
    public volatile boolean v;
    public List w = new ArrayList();
    public List x = new ArrayList();
    public List y = new ArrayList();
    public boolean z;
    public wi A;
    public an B;
    public LinkedHashMap C = new LinkedHashMap();
    public LinkedHashMap D = new LinkedHashMap();
    public LinkedHashMap E = new LinkedHashMap();
    public LinkedHashMap F = new LinkedHashMap();
    @Deprecated
    public LinkedHashMap G = new LinkedHashMap();
    public LinkedHashMap H = new LinkedHashMap();
    public LinkedHashMap I = new LinkedHashMap();
    Map J = new HashMap();
    public HashMap K = new HashMap();
    public HashMap L = new HashMap();
    public HashMap M = new HashMap();
    public HashMap N = new HashMap();
    public HashMap O = new HashMap();
    public HashMap P = new HashMap();
    public HashMap Q = new HashMap();
    public HashMap R = new HashMap();
    public final LinkedHashSet S = new LinkedHashSet();
    public LinkedHashMap T = new LinkedHashMap();
    public LinkedHashMap U = new LinkedHashMap();
    public final fa V = new fa();
    public final fm W = new fm();
    public final fc X = new fc(this.W, this.V);
    public final Map Y = new HashMap();
    public final HashSet Z = new HashSet();
    public List aa = new ArrayList();
    public HashMap ab = new HashMap();
    public HashMap ac = new HashMap();
    Map ad = new HashMap();
    List ae = new ArrayList();
    public HashMap af = new HashMap();
    public HashMap ag = new HashMap();
    public HashMap ah = new HashMap();
    public static final HashMap ai;
    public static final List aj;
    private final a ak;
    public fv al;
    public ih am;
    public y an;
    public jd ao;
    public mk ap;
    public ty aq;
    public na ar;
    public av as;
    private ac at;
    public pf au;
    public pg av;
    public pm aw;
    public po ax;
    public pp ay;
    public pe az;
    public pi aA;
    public pv aB;
    public kv aC;
    public kk aD;
    public lh aE;
    public kn aF;
    public ko aG;
    public kp aH;
    public kl aI;
    public kq aJ;
    public kt aK;
    public kx aL;
    public kz aM;
    public km aN;
    public la aO;
    public ks aP;
    public kr aQ;
    public kw aR;
    public pu aS;
    public mc aT;
    public lo aU;
    public lr aV;
    public ux aW;
    @Nullable
    public vm aX;
    @Nullable
    public vg aY;
    @Nullable
    public we aZ;
    @Nullable
    public vc ba;
    public vu bb;
    public vx bc;
    public zd bd;
    @Nullable
    private co be;
    public final HashMap bf = new HashMap();
    public final cy bg = new cy();
    public final ur bh = new ur();
    public zo bi;
    public xj bj;
    public xe bk;
    public boolean bl;

    private d(Plugin plugin, an an2) {
        e = this;
        this.f = plugin;
        this.B = an2;
        this.ak = new a();
        d = !itemsadder.m.ae.di ? new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create() : new GsonBuilder().disableHtmlEscaping().create();
        try {
            s = bcy.a("internal/models", (T string) -> string.endsWith(".json")).stream().map(string -> {
                String string2 = FilenameUtils.removeExtension((String)string);
                string2 = string2.replace("internal/models/", "");
                return "minecraft:" + string2;
            }).collect(Collectors.toSet());
            t = bcy.a("internal/textures", (T string) -> string.endsWith(".png")).stream().map(string -> {
                String string2 = FilenameUtils.removeExtension((String)string);
                string2 = string2.replace("internal/textures/", "");
                return "minecraft:" + string2;
            }).collect(Collectors.toSet());
        }
        catch (IOException iOException) {
            bce.error("Error while loading builtin assets from plugin resources.", iOException);
        }
        ze.init();
        new ph();
        bcp.a(new e(this), 54000L, 54000L);
        new t().register();
        this.A = new wi();
    }

    public static boolean a(String string) {
        return s.contains(string);
    }

    public static boolean b(String string) {
        return t.contains(string.contains(":") ? string : "minecraft:" + string);
    }

    public void f() {
        this.a(() -> {
            if (!this.as.auh.yB()) {
                this.a(false, () -> bce.log("Resourcepack not found. Generating..."), bl -> {
                    if (bl.booleanValue()) {
                        bce.log("Resourcepack generated.");
                        this.as.aui.a(null, (CommandSender)Bukkit.getConsoleSender());
                        yy.a(null, false, yz.ALL);
                    } else {
                        bbr.clear();
                    }
                }, bbr::s, null);
            } else {
                this.as.aui.a(null, (CommandSender)Bukkit.getConsoleSender());
                bbr.clear();
            }
        }, false, false);
    }

    public static d g() {
        return e;
    }

    public static d a(Plugin plugin, an an2) {
        if (e != null) {
            plugin.getLogger().severe("Core already initialized. Use the Core.inst() method instead of Core.inst(plugin).");
            return e;
        }
        e = new d(plugin, an2);
        return e;
    }

    public static boolean a(Block block) {
        ms ms2 = itemsadder.m.d.g().b(block);
        if (!ms2.isCustomBlock(block)) {
            return false;
        }
        ra ra2 = (ra)itemsadder.m.d.g().e(ms2.Y(block));
        if (ra2 == null) {
            return false;
        }
        return ra2.Ge.bm("block_trade_machine");
    }

    public static File h() {
        return new File(Main.rS().getDataFolder(), "output");
    }

    public static boolean a(@Nullable String string, bbf bbf2) {
        return a.a(string, bbf2);
    }

    public boolean i() {
        return this.u;
    }

    public boolean k() {
        return this.v;
    }

    public static Material l() {
        return Material.BARRIER;
    }

    public Collection b() {
        return this.ak.b();
    }

    public Map d() {
        return this.ak.d();
    }

    public void a(boolean bl) {
        this.a(true, bl);
    }

    public void a(boolean bl, boolean bl2) {
        bcp.r(this.getClass());
        this.X.bU();
        tl.mc();
        bip.EX();
        if (this.as != null) {
            this.as.bU();
        }
        if (this.ap != null) {
            this.ap.af(bl);
        }
        if (this.an != null) {
            this.an.e(bl);
        }
        if (this.ao != null) {
            this.ao.kp();
        }
        itemsadder.m.ai.a(this.ar);
        itemsadder.m.ai.a(this.az);
        itemsadder.m.ai.a(this.aA);
        itemsadder.m.ai.a(this.ay);
        itemsadder.m.ai.a(this.ax);
        itemsadder.m.ai.a(this.av);
        itemsadder.m.ai.a(this.au);
        itemsadder.m.ai.a(this.aw);
        itemsadder.m.ai.a(this.aB);
        itemsadder.m.ai.a(this.aE);
        itemsadder.m.ai.a(this.aL);
        itemsadder.m.ai.a(this.aG);
        itemsadder.m.ai.a(this.aH);
        itemsadder.m.ai.a(this.aI);
        itemsadder.m.ai.a(this.aJ);
        itemsadder.m.ai.a(this.aK);
        itemsadder.m.ai.a(this.aO);
        itemsadder.m.ai.a(this.aC);
        itemsadder.m.ai.a(this.aD);
        itemsadder.m.ai.a(this.aF);
        itemsadder.m.ai.a(this.aM);
        itemsadder.m.ai.a(this.aN);
        itemsadder.m.ai.a(this.aP);
        itemsadder.m.ai.a(this.aQ);
        itemsadder.m.ai.a(this.aR);
        itemsadder.m.ai.a(this.aS);
        if (this.aT != null) {
            this.aT.unregister();
        }
        itemsadder.m.ai.a(this.aU);
        itemsadder.m.ai.a(this.aV);
        itemsadder.m.ai.a(this.aX);
        itemsadder.m.ai.a(this.aY);
        itemsadder.m.ai.a(this.aZ);
        itemsadder.m.ai.a(this.ba);
        if (this.an instanceof ai) {
            itemsadder.m.ai.a((ai)((Object)this.an));
        }
        itemsadder.m.ai.a(this.ao);
        if (this.aq != null) {
            itemsadder.m.ai.a(this.aq.Li);
        }
        itemsadder.m.ai.a(this.bk);
        if (!bl2) {
            pw.unregister();
        }
        if (this.be != null) {
            if (bl2) {
                this.be.bU();
            } else {
                this.be.O();
            }
        }
    }

    public void b(boolean bl) {
        mv.Cb = false;
        te.px();
        aad.tf().mc();
        this.C.clear();
        this.E.clear();
        this.D.clear();
        this.F.clear();
        this.G.clear();
        this.J.clear();
        this.H.clear();
        this.I.clear();
        this.ab.clear();
        this.ac.clear();
        this.K.clear();
        this.L.clear();
        this.M.clear();
        this.N.clear();
        this.O.clear();
        this.P.clear();
        this.Q.clear();
        this.R.clear();
        this.Y.clear();
        this.ad.clear();
        this.ae.clear();
        if (this.al != null) {
            this.al.cy();
        }
        this.S.clear();
        this.T.clear();
        this.X.bU();
        this.V.clear();
        this.W.clear();
        this.Z.clear();
        this.aa.clear();
        this.af.clear();
        this.ag.clear();
        this.ah.clear();
        if (this.aW != null) {
            this.aW.b(bl);
        }
        if (da.P()) {
            da.db().de();
        }
        rz.mc();
        lw.lF().unregister();
    }

    public boolean m() {
        return ai != null && !ai.isEmpty() || aj != null && !aj.isEmpty();
    }

    public void n() {
        aj.clear();
        ai.clear();
    }

    public void a(Plugin plugin) {
        ai.forEach((string, list) -> list.removeIf(itemsAdder$Advanced$InjectedItemModifier -> plugin.getName().equals(itemsAdder$Advanced$InjectedItemModifier.owner)));
        aj.removeIf(itemsAdder$Advanced$InjectedItemModifier -> plugin.getName().equals(itemsAdder$Advanced$InjectedItemModifier.owner));
    }

    public void a(@Nullable Runnable runnable, boolean bl, boolean bl2) {
        bbr.bf("Cleaning up...");
        this.b(bl2);
        if (itemsadder.m.ae.fV) {
            try {
                h.c(new File(this.f.getDataFolder(), "storage" + File.separator + "cache" + File.separator + "ffmpeg"));
            }
            catch (Throwable throwable) {
                bce.warn("Error while initializing FFMPEG library: " + throwable.getMessage());
            }
        } else {
            h.N();
        }
        new r();
        bbr.bf("Refreshing contents...");
        this.d(false);
        dev.lone.itemsadder.resourcepack.f.xl().init();
        bbr.bf("Initializing...");
        if (this.ap == null) {
            this.ap = new mk(this.f);
        }
        this.as = new av(this.f);
        this.at = new ac(this.f, this.as);
        this.o();
        this.p();
        this.bd = new zd(this.f);
        this.r();
        us.i(itemsadder.m.ae.fu);
        itemsadder.m.aj.i(itemsadder.m.ae.fw);
        if (!this.B.aB()) {
            bce.warn("Vanilla assets are not downloaded yet. Please wait until download ends.");
            bbr.clear();
            this.u();
            yp.SE = false;
            yy.SE = false;
            return;
        }
        this.v = false;
        bcp.i(() -> {
            try {
                this.b(() -> {
                    pw.i(this.y());
                    if (runnable != null) {
                        runnable.run();
                    }
                }, bl, bl2);
            }
            catch (Throwable throwable) {
                bce.error("Error loading the plugin, something is not configured right or an exception occurred.", throwable);
                bbr.clear();
                this.v = true;
                this.u();
                yp.SE = false;
                yy.SE = false;
            }
        });
        this.c(bl2);
    }

    private void o() {
        this.ar = new na(this.f, this);
        this.az = new pe(this.f, this);
        this.aA = new pi(this.f, this);
        this.ay = new pp(this.f, this);
        this.ax = new po(this.f, this);
        this.av = new pg(this.f, this);
        this.au = new pf(this);
        this.aw = new pm(this.f, this);
        this.aB = new pv(this.f, this);
        this.aE = new lh();
        this.aL = new kx(this.f, this);
        this.aG = new ko(this.f, this);
        this.aH = new kp(this.f, this);
        this.aI = new kl(this.f);
        this.aJ = new kq(this.f, this);
        this.aK = new kt(this.f);
        this.aO = new la(this.f, this);
        this.aC = new kv(this.f);
        this.aD = new kk(this.f);
        this.aF = new kn(this.f);
        this.aM = new kz(this.f, this);
        this.aN = new km(this.f, this);
        this.aR = new kw(this.f, this);
        if (zw.sZ()) {
            this.aS = new pu();
        }
        this.aT = mc.lH();
        this.aU = new lo(this.f, this);
        this.aV = new lr(this.f, this);
    }

    private void p() {
        this.aW = new ux();
        if (itemsadder.m.ae.fa) {
            this.aX = new vm(this.f, this);
        }
        if (itemsadder.m.ae.fb) {
            this.aY = new vg(this.f, this);
        }
        if (itemsadder.m.ae.fd) {
            this.aZ = new we(this.f, this);
        }
        if (itemsadder.m.ae.fc) {
            this.ba = new vc(this.f);
        }
        asg.vr();
        if (this.bb == null) {
            this.bb = new vu(this.f);
        }
        if (this.bc == null) {
            this.bc = new vx(this.f);
        }
    }

    private void r() {
        this.an = itemsadder.m.ae.fv ? new z(this.f, this) : new aa(this.f, this);
        this.al = new fv(this.f, this);
        this.am = new ih(this.f, this);
        if (this.ao == null) {
            this.ao = new jd(this.f, this);
        }
        this.aq = new ty(this.f, this);
    }

    private void c(boolean bl) {
        if (Version.isAtLeast((Version)Version.v1_21_4)) {
            if (!this.ab.isEmpty()) {
                if (!bl) {
                    this.be = new co();
                    this.be.onEnable();
                } else if (this.be != null) {
                    this.be.cS();
                } else {
                    this.be = new co();
                    this.be.onEnable();
                }
            } else if (this.be != null) {
                this.be.O();
                this.be = null;
            }
        }
    }

    public static void a(Runnable runnable) {
        if (itemsadder.m.ae.cA) {
            runnable.run();
        } else {
            bcp.h(runnable);
        }
    }

    private void b(@Nullable Runnable runnable, boolean bl, boolean bl2) {
        bbr.bf("Preparing content load...");
        this.u = false;
        azr.Bu();
        dev.lone.itemsadder.resourcepack.bk.gr();
        bdh.gr();
        dev.lone.itemsadder.resourcepack.f.xl().xm();
        bdq bdq2 = new bdq();
        f f2 = new f();
        bbr.bf("Extracting internal files...");
        f2.A("extract-internal-files");
        if (itemsadder.m.ae.eu) {
            dev.lone.itemsadder.resourcepack.ad.yy();
        }
        bbr.bf("Refreshing content file cache...");
        if (itemsadder.m.ae.dI) {
            bce.log(String.valueOf(ChatColor.AQUA) + "[Content] Loading content...");
        }
        f2.A("contents-cache");
        this.d(true);
        bbr.bf("Finding files...");
        f2.A("find-files");
        if (itemsadder.m.ae.dI) {
            bce.log(String.valueOf(ChatColor.AQUA) + "[Content] Loading YML files...");
        }
        this.ak.a(l, p, this.z, bl2);
        f2.A("compiling-scripts");
        bbr.bf("Compiling Scripts...");
        te.az(bl2);
        f2.A("font-images");
        bbr.bf("Font images...");
        this.al.hU();
        if (Main.KO.gY("huds.enabled")) {
            bbr.bf("HUDs...");
            f2.A("huds");
            this.am.jG();
        } else {
            this.am.Z(false);
        }
        f2.A("langs");
        bbr.bf("Languages...");
        this.bh.clear();
        bbr.bf("Loading dictionaries...");
        for (Object object : this.b()) {
            itemsadder.m.c.a((bbf)object, this.bg);
            itemsadder.m.c.a((bbf)object, this.bh);
        }
        sv sv2 = new sv(this);
        bbr.bf("Converting legacy configurations...");
        f2.A("convert-legacy-configs");
        sy.pt();
        bbr.bf("Legacy Armors...");
        f2.A("armors-legacy");
        itemsadder.m.s.a(this.b(), this.K, this.L);
        bbr.bf("Sounds...");
        f2.A("sounds");
        tf.aR();
        bbr.bf("Equipments...");
        f2.A("equipments");
        itemsadder.m.g.a(this.b(), this.ad, this.x, this.w);
        bbr.bf("Items...");
        f2.A("items");
        try {
            sv2.aR();
            this.bl = false;
            for (Map.Entry entry : this.C.entrySet()) {
                qm qm2 = (qm)entry.getValue();
                if (!qm2.ng()) continue;
                this.bl = true;
                break;
            }
        }
        catch (Exception exception) {
            dev.lone.itemsadder.resourcepack.f.xl().xn();
            bce.error("");
            bce.error("ITEMS LOADING INTERRUPTED!");
            bce.error("Something unexpected happened while loading items.");
            bce.error("Remove configurations until you find out the cause of the issue.");
            bce.error("Please report this issue on GitHub.", exception);
            bce.error("");
        }
        bbr.bf("Crops...");
        f2.A("crops");
        sk.aR();
        bbr.bf("Registering cooldown indicators...");
        this.ar.me();
        if (itemsadder.m.ae.dL) {
            Object object;
            bbr.bf("Entities...");
            f2.A("entities");
            if (itemsadder.m.ae.dO) {
                bce.warn("Custom entities 'delay_packets' is enabled. This helps client/server performance but might cause stuttering animations. More info: https://a.devs.beer/ia-delaypackets");
            }
            object = new sq();
            ((sq)object).c(this);
            bbr.bf("Entities Populators...");
            f2.A("entities_populators");
            sr.aR();
        }
        if (!this.af.isEmpty()) {
            bbr.bf("Liquids...");
            itemsadder.m.ai.a(this.aP);
            itemsadder.m.ai.a(this.aQ);
            if (itemsadder.m.ae.cS) {
                this.aP = new ks(this.f, this);
                this.aQ = new kr(this.f, this);
            }
        }
        this.u = true;
        bbr.clear();
        itemsadder.m.d.a(() -> {
            try {
                td td2;
                if (!bl) {
                    bbr.bf("Preloading recipes...");
                    f2.A("recipes");
                    td2 = new td();
                    td2.a(this, this.d(), this.ba);
                } else {
                    td2 = null;
                }
                bbr.bf("Reloading worlds configuration...");
                f2.A("various");
                tl.reload();
                bbr.bf("Finalizing loaded items...");
                sv2.ps();
                if (itemsadder.m.ae.dM) {
                    bbr.bf("Registering emotes...");
                    f2.A("emotes");
                    da.db().dh();
                    da.db().dg();
                    bbr.bf("Caching emote models...");
                    da.db().do();
                    bbr.bf("Loading emote overrides...");
                    for (bbf bbf2 : this.b()) {
                        da.db().c(bbf2);
                    }
                    bbr.bf("Loading emote events and goals...");
                    da.db().di();
                }
                bbr.bf("Saving content IDs and statistics...");
                f2.A("stats");
                bce.log(String.valueOf(ChatColor.GREEN) + "[Content] Loaded " + String.valueOf(ChatColor.AQUA) + this.C.size() + String.valueOf(ChatColor.GREEN) + " items");
                dev.lone.itemsadder.resourcepack.f.xl().sJ();
                f2.A("cache");
                dev.lone.itemsadder.resourcepack.f.xl().xq();
                dev.lone.itemsadder.resourcepack.f.xl().xo();
                if (Main.KO.gY("huds.enabled") && this.am.vF.size() > 0) {
                    bbr.bf("Initializing HUDs...");
                    f2.A("huds");
                    this.ao.init();
                }
                bbr.bf("Loots...");
                f2.A("loots");
                this.aq.a(this.b());
                bbr.bf("Initializing content categories...");
                this.bi = new zo(this.f, this);
                bbr.bf("Initializing font images book...");
                f2.A("chat-packet-handler");
                f2.A("font-images-book");
                this.bj = new xj();
                bbr.bf("Initializing chat packet handlers...");
                f2.A("chat-packets-replace-handlers");
                this.bk = new xe(this.f, this);
                f2.K();
                bcp.i(() -> {
                    try {
                        bbr.bf("Registering recipes...");
                        if (!bl) {
                            f2.A("recipes-2");
                            td2.a(this.aX, this.aY, this.aZ);
                        }
                        bbr.bf("Loading recipe categories...");
                        this.bi.Ue.sG();
                        if (!Bukkit.getWorlds().isEmpty()) {
                            bbr.bf("Rebuilding entity block cache...");
                            this.V.a((World)Bukkit.getWorlds().get(0), this.S);
                            this.W.a(this.ap);
                            this.X.hn();
                        }
                        bbr.bf("Calling content load events...");
                        bev.b(new ItemsAdderFirstLoadEvent());
                        bev.b(new ItemsAdderLoadDataEvent(bl2, bl));
                        if (Main.KO.gY("debug.performance.loading-ms")) {
                            if (bl2) {
                                bce.a(String.format("&a[Content] Loaded successfully in &b%dms", bdq2.DJ()), Level.INFO);
                                f2.L();
                            } else {
                                bce.log("&a[Content] Contents loaded successfully!");
                            }
                        }
                        bbr.bf("Registering gameplay watchers...");
                        this.ay.mr();
                        this.v = true;
                        if (sv2.Ka) {
                            bbr.bf("Refreshing biome registry...");
                            itemsadder.m.d.A();
                        }
                        bbr.bf("Finalizing content load...");
                        this.at.h(bl2);
                        bbr.clear();
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                    catch (Error | RuntimeException throwable) {
                        bbr.clear();
                        throw throwable;
                    }
                });
            }
            catch (Error | RuntimeException throwable) {
                bbr.clear();
                throw throwable;
            }
        });
    }

    public void a(@Nullable Plugin plugin, qm qm2) {
        ItemsAdder$Advanced$InjectedItemModifier itemsAdder$Advanced$InjectedItemModifier = null;
        try {
            List list = (List)ai.get(qm2.getNamespacedID());
            if (list != null) {
                for (ItemsAdder$Advanced$InjectedItemModifier itemsAdder$Advanced$InjectedItemModifier2 : list) {
                    if (plugin != null && !itemsAdder$Advanced$InjectedItemModifier2.owner.equals(plugin.getName())) continue;
                    itemsAdder$Advanced$InjectedItemModifier = itemsAdder$Advanced$InjectedItemModifier2;
                    itemsAdder$Advanced$InjectedItemModifier2.call(qm2.getNamespacedID(), qm2);
                }
            }
            for (ItemsAdder$Advanced$InjectedItemModifier itemsAdder$Advanced$InjectedItemModifier2 : aj) {
                if (plugin != null && !itemsAdder$Advanced$InjectedItemModifier2.owner.equals(plugin.getName())) continue;
                itemsAdder$Advanced$InjectedItemModifier = itemsAdder$Advanced$InjectedItemModifier2;
                itemsAdder$Advanced$InjectedItemModifier2.call(qm2.getNamespacedID(), qm2);
            }
        }
        catch (Exception exception) {
            if (itemsAdder$Advanced$InjectedItemModifier != null) {
                if (itemsAdder$Advanced$InjectedItemModifier.item != null) {
                    bce.error("Error calling injected item modifier of plugin " + itemsAdder$Advanced$InjectedItemModifier.owner + " for item " + itemsAdder$Advanced$InjectedItemModifier.item);
                } else {
                    bce.error("Error calling injected items modifier of plugin " + itemsAdder$Advanced$InjectedItemModifier.owner);
                }
            } else {
                bce.error("Error calling injected item modifiers");
            }
            exception.printStackTrace();
        }
    }

    public boolean a(boolean bl, @Nullable Runnable runnable, @Nullable Consumer consumer, @Nullable bcm bcm2, @Nullable Player player) {
        return this.a(bl, runnable, consumer, bcm2, player, false);
    }

    public boolean b(boolean bl, @Nullable Runnable runnable, @Nullable Consumer consumer, @Nullable bcm bcm2, @Nullable Player player) {
        return this.a(bl, runnable, consumer, bcm2, player, true);
    }

    private boolean a(boolean bl, @Nullable Runnable runnable, @Nullable Consumer consumer, @Nullable bcm bcm2, @Nullable Player player, boolean bl2) {
        return this.at.a(this.N, this.C, this.be != null, this.al.um, this.bh, bl, runnable, consumer, bcm2, player, bl2);
    }

    public boolean s() {
        return this.c.compareAndSet(false, true);
    }

    public boolean t() {
        return this.c.get();
    }

    public void u() {
        this.c.set(false);
    }

    public co v() {
        if (this.be == null) {
            throw new RuntimeException("Crops are not available for this server version!");
        }
        return this.be;
    }

    @Nullable
    public Collection c(String string) {
        HashMap hashMap = (HashMap)this.P.get(string);
        if (hashMap == null) {
            return null;
        }
        return hashMap.values();
    }

    @Nullable
    public Set d(String string) {
        HashMap hashMap = (HashMap)this.P.get(string);
        if (hashMap == null) {
            return null;
        }
        return hashMap.keySet();
    }

    @Nullable
    public ki c(String string, String string2) {
        HashMap hashMap = (HashMap)itemsadder.m.d.g().P.get(string);
        if (hashMap == null) {
            return null;
        }
        qm qm2 = (qm)hashMap.get(string2);
        if (qm2 != null) {
            return qm2.Ge.bn(string);
        }
        if (!string2.contains(":")) {
            for (qm qm3 : hashMap.values()) {
                if (!qm3.Gg.equals(string2)) continue;
                return qm3.Ge.bn(string);
            }
        }
        return null;
    }

    @Nullable
    public qm a(@Nullable ItemStack itemStack, boolean bl) {
        if (!qm.isCustomItem(itemStack)) {
            if (bl) {
                bce.error("Warning, ITEM " + String.valueOf(itemStack.getType()) + " is not a custom item.");
            }
            return null;
        }
        String string = qm.u(itemStack);
        if (!this.u) {
            throw new RuntimeException("Items not finished loading, can't get item " + string);
        }
        qm qm2 = (qm)this.C.get(qm.u(itemStack));
        if (qm2 == null) {
            if (bl) {
                bce.error("ERROR, ITEM " + string + " not found in configs! Maybe an old item?");
            } else {
                return null;
            }
        }
        return qm2;
    }

    @Nullable
    public qm a(ItemStack itemStack) {
        return this.a(itemStack, false);
    }

    @Nullable
    public qm a(Class clazz, ItemStack itemStack) {
        qm qm2 = this.a(itemStack, false);
        if (qm2 == null) {
            return null;
        }
        if (clazz.isInstance(qm2)) {
            return qm2;
        }
        return null;
    }

    @Nullable
    public qm b(String string, boolean bl) {
        if (string == null) {
            if (bl) {
                bce.error("ERROR, ITEM is null. Maybe an old item?");
            }
            return null;
        }
        qm qm2 = null;
        if (string.contains(":")) {
            qm2 = (qm)this.C.get(string);
        } else {
            qm2 = (qm)this.E.get(string);
            if (qm2 != null && Main.KO.gY("debug.items.log-warnings")) {
                bce.log(String.valueOf(ChatColor.YELLOW) + "Guessed item namespace for item '" + string + "' -> " + qm2.getNamespacedID());
            }
        }
        if (qm2 == null) {
            if (bl) {
                bce.error("ERROR, ITEM " + string + " not found in configs! Maybe an old item?");
            } else {
                return null;
            }
        }
        return qm2;
    }

    @Nullable
    public qm c(String string, boolean bl) {
        qm qm2 = null;
        if (string.contains(":")) {
            qm2 = (qm)this.F.get(string);
        } else {
            qm2 = (qm)this.G.get(string);
            if (Main.KO.gY("debug.items.log-warnings")) {
                bce.log(String.valueOf(ChatColor.YELLOW) + "Guessed item namespace for item '" + string + "' -> " + qm2.getNamespacedID());
            }
        }
        if (qm2 == null) {
            if (bl) {
                bce.error("ERROR, VARIANT " + string + " not found in configs! Maybe an old item?");
            } else {
                return null;
            }
        }
        return qm2;
    }

    @Nullable
    public Object a(Class clazz, String string) {
        qm qm2 = this.e(string);
        if (clazz.isInstance(qm2)) {
            return qm2;
        }
        return null;
    }

    @Nullable
    public qm e(String string) {
        return this.b(string, false);
    }

    public boolean f(String string) {
        return this.e(string) != null;
    }

    public boolean isCustomItem(ItemStack itemStack) {
        return this.a(itemStack) != null;
    }

    public boolean b(ItemStack itemStack) {
        qm qm2 = this.a(itemStack);
        if (qm2 == null) {
            return false;
        }
        return qm2 instanceof ql;
    }

    public boolean a(ql ql2) {
        return this.aa.contains(ql2);
    }

    public boolean g(String string) {
        if (string.contains(":")) {
            return this.C.containsKey(string);
        }
        return this.E.containsKey(string);
    }

    @Nullable
    public ql c(ItemStack itemStack) {
        qm qm2 = this.a(itemStack);
        if (!(qm2 instanceof ql)) {
            return null;
        }
        return (ql)qm2;
    }

    @Nullable
    public ql h(String string) {
        qm qm2 = this.e(string);
        if (!(qm2 instanceof ql)) {
            return null;
        }
        return (ql)qm2;
    }

    public boolean a(Block block, Consumer consumer) {
        ms ms2 = itemsadder.m.d.g().b(block);
        if (!ms2.isCustomBlock(block)) {
            return false;
        }
        ql ql2 = itemsadder.m.d.g().h(ms2.Y(block));
        if (ql2 == null) {
            return false;
        }
        consumer.accept(ql2);
        return true;
    }

    public boolean hasBehaviour(ItemStack itemStack, String string) {
        qm qm2 = this.a(itemStack);
        if (qm2 == null) {
            return false;
        }
        return qm2.Ge.bm(string);
    }

    public boolean w() {
        if (!itemsadder.m.d.g().H.isEmpty()) {
            for (Map.Entry entry : itemsadder.m.d.g().H.entrySet()) {
                if (((HashMap)entry.getValue()).isEmpty()) continue;
                return true;
            }
        }
        return false;
    }

    public boolean y() {
        return itemsadder.m.d.g().N.containsKey(Material.TRIDENT);
    }

    @Nullable
    public qm a(Material material, int n2) {
        List list = (List)this.N.get(material);
        if (list == null) {
            return null;
        }
        for (qm qm2 : list) {
            if (qm2.fX() != n2) continue;
            return qm2;
        }
        return null;
    }

    @Deprecated
    public ql a(Material material, HashMap hashMap) {
        for (ql ql2 : this.S) {
            if (!material.equals((Object)ql2.FD.pc()) || !hashMap.equals(ql2.FD.pa())) continue;
            return ql2;
        }
        return null;
    }

    @Nullable
    public static ql a(BlockData blockData) {
        for (ql ql2 : itemsadder.m.d.g().S) {
            if (!blockData.matches(ql2.FD.pb())) continue;
            return ql2;
        }
        return null;
    }

    public boolean d(ItemStack itemStack) {
        return this.a(itemStack) instanceof rb;
    }

    public List i(String string) {
        LinkedList<String> linkedList = new LinkedList<String>();
        if (string == null || string.isEmpty() || string.equals(" ")) {
            for (Map.Entry entry : this.C.entrySet()) {
                qm qm2 = (qm)entry.getValue();
                if (qm2 instanceof ql) {
                    ql ql2 = (ql)qm2;
                    if (ql2.FD != null && ql2.FD.oX()) continue;
                }
                linkedList.add((String)entry.getKey());
            }
            return linkedList;
        }
        string = itemsadder.m.d.j(string);
        for (Map.Entry entry : this.C.entrySet()) {
            Object object;
            qm qm3 = (qm)entry.getValue();
            if (qm3 instanceof ql) {
                object = (ql)qm3;
                if (((ql)object).FD != null && ((ql)object).FD.oX()) continue;
            }
            if (!((String)(object = itemsadder.m.d.j((String)entry.getKey()))).contains(string)) continue;
            linkedList.add((String)entry.getKey());
        }
        return linkedList;
    }

    private static String j(String string) {
        return string.toLowerCase().replace(":", "").replace("_", "").replace("-", "");
    }

    public List k(String string) {
        if (string == null || string.isEmpty() || string.equals(" ")) {
            return new ArrayList(wz.Oz.keySet());
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : wz.Oz.keySet()) {
            if (!string2.contains(string)) continue;
            arrayList.add(string2);
        }
        return arrayList;
    }

    public List a(Material material, String string) {
        if (!this.O.containsKey(material)) {
            return new ArrayList();
        }
        if (string == null || string.isEmpty() || string.equals(" ")) {
            return new ArrayList(((HashMap)this.O.get(material)).keySet());
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : ((HashMap)this.O.get(material)).keySet()) {
            if (!string2.contains(string)) continue;
            arrayList.add(string2);
        }
        return arrayList;
    }

    public List l(String string) {
        if (string == null || string.isEmpty() || string.equals(" ")) {
            return this.am.vH;
        }
        LinkedList<String> linkedList = new LinkedList<String>();
        for (String string2 : this.am.vH) {
            if (!string2.contains(string)) continue;
            linkedList.add(string2);
        }
        return linkedList;
    }

    @Nullable
    public ItemStack m(String string) {
        if (string != null && this.f(string)) {
            qm qm2 = this.e(string);
            if (qm2 == null) {
                return null;
            }
            qm2 = qm2.clone();
            MmoItemsHook.injectMmoItem(qm2);
            return qm2;
        }
        return null;
    }

    @Deprecated
    @Nullable
    public Object d(String string, @Nullable String string2) {
        if (string != null) {
            @Nullable Material material = bbi.ig(string);
            if (material != null) {
                return material;
            }
            if (this.f(string)) {
                return this.e(string).mO();
            }
        }
        if (string2 != null) {
            bce.warn("Can't find item '" + string + "' to load some settings. File '" + string2 + "'");
            return itemsadder.m.d.l();
        }
        return null;
    }

    @Nullable
    public vp e(String string, @Nullable String string2) {
        if (string != null) {
            @Nullable Material material = bbi.ig(string);
            if (material != null) {
                return new vs(material);
            }
            if (this.f(string)) {
                return new vq(this.e(string));
            }
        }
        if (string2 != null) {
            bce.warn("Can't find item '" + string + "' to load some settings. File '" + string2 + "'");
            return new vs(itemsadder.m.d.l());
        }
        return null;
    }

    public vp n(String string) {
        return this.e(string, null);
    }

    @Nullable
    public ItemStack f(String string, String string2) {
        if (string != null) {
            @Nullable Material material = bbi.ig(string);
            if (material != null) {
                return new ItemStack(material);
            }
            qm qm2 = this.e(string);
            if (qm2 == null) {
                return null;
            }
            return qm2.mP();
        }
        if (string2 != null) {
            bce.warn("Can't find item '" + string + "' to load some settings. File '" + string2 + "'");
            return new ItemStack(itemsadder.m.d.l());
        }
        return null;
    }

    @Nullable
    public ItemStack o(String string) {
        if (string != null) {
            @Nullable Material material = bbi.ig(string);
            if (material != null) {
                return new ItemStack(material);
            }
            qm qm2 = this.e(string);
            if (qm2 == null) {
                return null;
            }
            return qm2;
        }
        return null;
    }

    @Nullable
    public ItemStack q(String string) {
        return this.f(string, null);
    }

    public static boolean a(ItemStack itemStack, ItemStack itemStack2) {
        if (bbs.at(itemStack) && bbs.at(itemStack2)) {
            return true;
        }
        if (itemStack == null || itemStack2 == null) {
            return false;
        }
        if (itemStack.getType() != itemStack2.getType()) {
            return false;
        }
        if (itemStack.hasItemMeta() != itemStack2.hasItemMeta()) {
            return false;
        }
        if (qm.s(itemStack) && qm.s(itemStack2)) {
            return qm.b(itemStack, itemStack2);
        }
        return itemStack.isSimilar(itemStack2);
    }

    public ItemStack a(Player player, Material material) {
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        ItemStack itemStack2 = player.getInventory().getItemInOffHand();
        if (itemStack.getType() == material) {
            if (qm.isCustomItem(itemStack)) {
                return itemStack;
            }
            if (itemStack2.getType() == material && qm.isCustomItem(itemStack2)) {
                return itemStack2;
            }
        }
        return null;
    }

    public ms a(Chunk chunk) {
        return this.ap.m(chunk);
    }

    public ms b(Block block) {
        return this.ap.b(block);
    }

    public ms a(Location location) {
        return this.ap.D(location);
    }

    public ms a(World world, int n2, int n3) {
        return this.ap.a(world, n2, n3);
    }

    public static boolean isCustomBlock(Block block) {
        return e.b(block).isCustomBlock(block);
    }

    @Nullable
    public static String c(Block block) {
        return e.b(block).Y(block);
    }

    @Nullable
    public static ql d(Block block) {
        String string = itemsadder.m.d.c(block);
        if (string == null) {
            return null;
        }
        return itemsadder.m.d.g().h(string);
    }

    public static boolean e(Block block) {
        ms ms2 = e.b(block);
        return ms2.aa(block) != null;
    }

    public static boolean b(Location location) {
        return lw.lF().b(location);
    }

    public static void A() {
        if (itemsadder.m.ae.fX) {
            if (!Bukkit.getServer().isAcceptingTransfers()) {
                bce.warn("Temporarily enabling 'accepts-transfers' to automatically re-join players after content refresh.");
            }
            Bukkit.getOnlinePlayers().forEach(player -> aow.uN().a((Player)player, itemsadder.m.ae.fZ, itemsadder.m.ae.ga));
        } else if (itemsadder.m.ae.fY) {
            Bukkit.getOnlinePlayers().forEach(player -> {
                if (zw.sZ()) {
                    player.kick(Main.PQ.it("server-content-changed-join-again"));
                } else {
                    player.kickPlayer(bbe.u(Main.PQ.it("server-content-changed-join-again")));
                }
            });
        }
    }

    public static String a(List list, int n2, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = list.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            qx qx2 = (qx)list.get(i2);
            if (i2 > n2) {
                stringBuilder.setLength(stringBuilder.length() - 2);
                stringBuilder.append(string);
                return stringBuilder.toString();
            }
            stringBuilder.append(qx2.getNamespacedID()).append(", ");
        }
        return stringBuilder.toString();
    }

    public boolean B() {
        for (Map.Entry entry : this.C.entrySet()) {
            qm qm2 = (qm)entry.getValue();
            if (!qm2.mV() || !qm2.nk().isVisible()) continue;
            return true;
        }
        return false;
    }

    @Nullable
    public static File r(String string) {
        return b.a(itemsadder.m.d.e.y, string);
    }

    public static String g(@Nullable String string, String string2) {
        return itemsadder.m.ad.g(string, string2);
    }

    public static String h(@Nullable String string, String string2) {
        return itemsadder.m.ad.h(string, string2);
    }

    public static String a(int n2, @Nullable String string, String string2) {
        return itemsadder.m.ad.a(n2, string, string2);
    }

    @Nullable
    public static File s(String string) {
        return b.a(itemsadder.m.d.e.x, itemsadder.m.d.e.w, string);
    }

    @Nullable
    public static File t(String string) {
        String string2 = itemsadder.m.d.g(null, string);
        if (string2 == null) {
            return null;
        }
        string2 = bcy.iR(string2);
        return itemsadder.m.d.s(string2);
    }

    @Nullable
    public static File u(String string) {
        String string2 = itemsadder.m.d.h(null, string);
        if (string2 == null) {
            return null;
        }
        string2 = bcy.iR(string2);
        return itemsadder.m.d.s(string2);
    }

    public static List v(String string) {
        return b.b(itemsadder.m.d.e.x, itemsadder.m.d.e.w, string);
    }

    public static List a(File file) {
        return b.a(file);
    }

    public static List C() {
        return b.a(itemsadder.m.d.g().x);
    }

    public static List D() {
        return b.b(itemsadder.m.d.g().x);
    }

    private void d(boolean bl) {
        this.w = b.a(l, p);
        this.x = b.a(l, p, o);
        this.y = b.b(l, p, n);
        this.z = b.b(p, o);
        if (bl && this.z) {
            bce.warn("Detected legacy ItemsAdder pack (pre 3.3.0). Loading anyway. Info: https://a.devs.beer/ia-new-guidelines-330");
        }
    }

    public int a(int n2) {
        for (Map.Entry entry : this.H.entrySet()) {
            for (Map.Entry entry2 : ((HashMap)entry.getValue()).entrySet()) {
                if (((qm)entry2.getValue()).fX() != n2) continue;
                return (Integer)entry2.getKey();
            }
        }
        throw new IllegalArgumentException("Armor color not found for custom model data " + n2);
    }

    public ro a(NamespacedKey namespacedKey) {
        return (ro)this.ad.get(namespacedKey);
    }

    public void a(qm qm2) {
        this.D.remove(qm2.Gi);
        this.C.remove(qm2.getNamespacedID());
        this.E.remove(qm2.getId());
        ((HashMap)this.O.get(qm2.getType())).remove(qm2.getNamespacedID());
        if (((HashMap)this.O.get(qm2.getType())).isEmpty()) {
            this.O.remove(qm2.getType());
        }
        this.F.remove(qm2.getNamespacedID());
        this.G.remove(qm2.getId());
    }

    @Generated
    public Map E() {
        return this.J;
    }

    @Generated
    public void a(Map map) {
        this.J = map;
    }

    @Generated
    public Map F() {
        return this.ad;
    }

    @Generated
    public List G() {
        return this.ae;
    }

    @Generated
    public mk H() {
        return this.ap;
    }

    static {
        g = Main.rS().getDataFolder().getAbsolutePath();
        i = g + "/storage/";
        k = g + "/output/generated.zip";
        l = g + "/contents/";
        m = l + "vanilla/resourcepack/";
        n = g + "/data/resource_pack/";
        o = n + "assets/";
        p = g + "/data/items_packs/";
        s = new HashSet();
        t = new HashSet();
        ai = new HashMap();
        aj = new ArrayList();
    }
}
