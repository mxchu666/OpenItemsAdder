package itemsadder.m;

import dev.lone.itemsadder.resourcepack.f;
import itemsadder.m.aaf;
import itemsadder.m.ae;
import itemsadder.m.ahd;
import itemsadder.m.bay;
import itemsadder.m.bbf;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bcy;
import itemsadder.m.bdb;
import itemsadder.m.d;
import itemsadder.m.ms;
import itemsadder.m.qm;
import itemsadder.m.ra;
import itemsadder.m.rf;
import itemsadder.m.rg;
import itemsadder.m.rq;
import itemsadder.m.rz;
import itemsadder.m.sb;
import itemsadder.m.sd;
import itemsadder.m.se;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Generated;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockDataMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;

public class ql
extends ra {
    public static final int Fx = 3;
    public static final String Fy = "group_3x3x1";
    public int Fz = -1;
    public Material FA = Material.GRAY_CONCRETE;
    private ql FB;
    public static final BlockFace[] FC = new BlockFace[]{BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST, BlockFace.UP, BlockFace.DOWN};
    @Nullable
    public rz FD;
    public rf xu;
    boolean yk;
    boolean FE;
    boolean FF;
    public int yh;
    public float FG;
    private float FH;
    public boolean FI;
    se FJ;
    HashMap FK;
    HashMap FL;
    HashMap FM;
    HashMap FN;
    private boolean FO;

    public ql(bbf bbf2, String string, String string2, Material material, int n, sd sd2, rg rg2, boolean bl, int n2, List list, List list2, List list3, List list4, float f2, boolean bl2, boolean bl3, boolean bl4, boolean bl5, int n3, int n4, @Nullable List list5) {
        super(bbf2, string, string2, material, sd2);
        this.FD = new rz(this, n, rg2, bl2, bl3, bl4, bl5, n3, n4, list5);
        this.xu = new rf();
        this.yk = bl;
        this.yh = bcy.p(n2, 0, 15);
        this.FG = f2;
        this.FK = new HashMap();
        for (String string3 : list) {
            this.FK.put(string3, d.g().f(string3));
        }
        this.FL = new HashMap();
        for (String string3 : list2) {
            this.FL.put(string3, d.g().f(string3));
        }
        this.FM = new HashMap();
        for (String string3 : list3) {
            this.FM.put(string3, d.g().f(string3));
        }
        this.FN = new HashMap();
        for (String string3 : list4) {
            this.FN.put(string3, d.g().f(string3));
        }
    }

    public ql a(String string, bdb bdb2) {
        if (this.FD == null) {
            bce.error("ERROR cloning '" + this.getNamespacedID() + "'. Somehow the placedBlockModel is null, is this a template?");
            return null;
        }
        ql ql2 = new ql(this.Ga, this.Gf, string, this.getType(), this.Hq.pg() ? f.xl().a(this.getType(), this.Hq, this.Gf, string) : -1, this.Hq, this.FD.IY, this.yk, this.yh, this.FK.keySet().stream().toList(), this.FL.keySet().stream().toList(), this.FM.keySet().stream().toList(), this.FN.keySet().stream().toList(), this.FG, this.FD.Jb, this.FD.Jc, this.FD.Jd, this.FD.Je, this.FD.oY(), this.FD.oZ(), null);
        ql2.b(this.Gc);
        ql2.FA = this.FA;
        ql2.setItemMeta(this.getItemMeta());
        ql2.xu = this.xu;
        ql2.yk = this.yk;
        ql2.FE = this.FE;
        ql2.FF = this.FF;
        ql2.FG = this.FG;
        ql2.FI = this.FI;
        ql2.FH = this.FH;
        ql2.bc(this.kL());
        ql2.bd(this.kM());
        ql2.bK(this.nf());
        this.Ge.g(ql2);
        this.Gd.a(ql2, false);
        ql2.ap(false);
        ql2.m(List.of());
        ql2.bF(this.ga());
        ql2.FB = this.FB == null ? this : this.FB;
        ql2.FD.am(bdb2.ha);
        ql2.FD.an(bdb2.gW);
        return ql2;
    }

    public String mD() {
        ql ql2 = this.FB == null ? this : this.FB;
        return "_iainternal:entity_blocks/" + ql2.getNamespace() + "/" + ql2.getId();
    }

    public String mE() {
        return this.mD() + "/group_3x3x1";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    public Map mF() {
        Map<Object, Object> map;
        ql ql2 = this.FB == null ? this : this.FB;
        Object object2 = ql2.FX;
        if (object2 instanceof rq) {
            rq rq2 = (rq)object2;
            object2 = rq2.oD();
            if (ql.bz(rq2.oC()) && object2.size() == 1) {
                map = Map.of("all", (String)object2.values().iterator().next());
            } else {
                if (!ql.bA(rq2.oC())) return null;
                map = new HashMap();
                for (String string : List.of("down", "up", "north", "south", "west", "east")) {
                    String string2 = (String)object2.get(string);
                    if (string2 == null) {
                        return null;
                    }
                    map.put(string, string2);
                }
            }
        } else {
            if (ql2.FX != null) {
                return null;
            }
            object2 = ql2.getTextures();
            if (!ql.bz(ql2.nm()) || object2 == null || object2.size() != 1) {
                return null;
            }
            map = Map.of("all", (String)object2.get(0));
        }
        for (Object object2 : map.values()) {
            if (d.t((String)object2) != null) continue;
            return null;
        }
        return map;
    }

    private static boolean bz(String string) {
        return "block/cube_all".equals(string) || "minecraft:block/cube_all".equals(string);
    }

    private static boolean bA(String string) {
        return "block/cube".equals(string) || "minecraft:block/cube".equals(string);
    }

    public void a(String string, float f2, float f3) {
        this.xu.a(string, f2, f3);
    }

    public void b(String string, float f2, float f3) {
        this.xu.b(string, f2, f3);
    }

    public void c(String string, float f2, float f3) {
        this.xu.c(string, f2, f3);
    }

    public void d(String string, float f2, float f3) {
        this.xu.d(string, f2, f3);
    }

    public void e(String string, float f2, float f3) {
        this.xu.e(string, f2, f3);
    }

    public boolean mG() {
        return this.yk;
    }

    public boolean mH() {
        return this.FE;
    }

    public boolean mI() {
        return this.FF;
    }

    public int kH() {
        return this.yh;
    }

    public void ah(boolean bl) {
        this.FI = bl;
    }

    public void m(float f2) {
        this.FH = f2 == -1.0f ? this.FG * 3.0f : f2;
    }

    public float mJ() {
        return this.FH;
    }

    public void ai(boolean bl) {
        this.FE = bl;
    }

    public void aj(boolean bl) {
        this.FF = bl;
    }

    @Override
    public boolean M(Location location) {
        return this.d(null, location);
    }

    public boolean d(Player player, Location location) {
        return this.a(player, location, true, false);
    }

    public boolean d(Player player, Block block) {
        return this.a(player, block, true, false, true, true);
    }

    @Override
    public boolean ar(Block block) {
        return this.a(null, block, false, false, true, false);
    }

    @Override
    public boolean e(Block block, boolean bl) {
        return this.a(null, block, false, false, true, false);
    }

    @Override
    public boolean as(Block block) {
        return this.d(null, block);
    }

    @Override
    public boolean f(Block block, boolean bl) {
        return this.a(null, block, true, false, true, true);
    }

    public boolean a(Player player, Location location, boolean bl, boolean bl2) {
        return this.a(player, location.getBlock(), bl, bl2, true, true);
    }

    public boolean a(Player player, Location location, @Nullable BlockFace blockFace, boolean bl, boolean bl2) {
        return this.a(player, location.getBlock(), blockFace, bl, bl2, true, true, false);
    }

    public boolean at(Block block) {
        return this.a(null, block, true, false, false, true);
    }

    public boolean a(Player player, Block block, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        return this.a(player, block, null, bl, bl2, bl3, bl4, true);
    }

    public boolean a(Player player, Block block, @Nullable BlockFace blockFace, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        ms ms2;
        Block block2;
        boolean bl6;
        if (this.FD == null) {
            bce.error("ERROR placing '" + this.getNamespacedID() + "'. Somehow the placedBlockModel is null, is this a template?");
            return false;
        }
        boolean bl7 = bl6 = bl && this.FD.Jb;
        if (bl6) {
            block2 = block.getLocation().add(0.0, 1.0, 0.0).getBlock();
            if (bl5 && player != null && !bcc.b(block2, player)) {
                return false;
            }
        } else {
            block2 = block;
        }
        if (this.Hq == sd.ENTITY && ae.a(this.Hq) && !d.g().W.a(block2.getWorld().getUID(), block2.getX(), block2.getY(), block2.getZ(), ae.cO)) {
            if (player != null) {
                bce.a((CommandSender)player, "max-furnitures-vehicles-reached", (Object string) -> string.replace("{value}", Integer.toString(ae.cO)));
            }
            return false;
        }
        if (bl6) {
            ahd.tN().l(block, true);
        }
        String string2 = this.getNamespacedID();
        if (!ae.a(this.Hq)) {
            if (player != null) {
                bce.a((CommandSender)player, "custom-blocks-type-disabled", (Object string) -> string.replace("{type}", this.Hq.toString()));
            }
        } else if (this.Hq == sd.TILE) {
            bcp.b(() -> this.FD.i(block2, bl3), bl2);
        } else if (this.Hq == sd.REAL_WIRE) {
            this.FD.i(block2, bl3);
            ms2 = block2.getRelative(BlockFace.UP);
            if (aaf.aM((Block)ms2)) {
                ms2.setType(Material.AIR, false);
            }
        } else if (blockFace != null && this.FD.oW()) {
            ql ql2;
            ms2 = blockFace;
            if (player != null) {
                if (this.FD.oV() == sb.DROPPER) {
                    BlockFace blockFace2 = bcc.cB(player);
                    BlockFace blockFace3 = bcc.cC(player);
                    if (blockFace3 != BlockFace.SELF) {
                        if (blockFace3 == BlockFace.UP) {
                            ms2 = BlockFace.DOWN;
                        } else if (blockFace3 == BlockFace.DOWN) {
                            ms2 = BlockFace.UP;
                        }
                    } else {
                        ms2 = blockFace2.getOppositeFace();
                    }
                } else if (this.FD.oV() == sb.FURNACE) {
                    BlockFace blockFace4 = bcc.cB(player);
                    ms2 = blockFace4.getOppositeFace();
                }
            }
            if ((ql2 = this.FD.a((BlockFace)ms2)) != null) {
                ql2.FD.i(block2, bl3);
                string2 = ql2.getNamespacedID();
            }
            if (ql2 == null) {
                bce.error("ERROR placing '" + this.getNamespacedID() + "'. Somehow the directional block is null, is this a template?");
                return false;
            }
        } else {
            this.FD.i(block2, bl3);
        }
        if (this.yh != -1 && bl4) {
            bay.d(block2, this.yh);
        }
        ms2 = d.g().b(block2);
        ms2.e(block2, string2);
        return true;
    }

    @Nullable
    public static ql au(Block block) {
        ms ms2 = d.g().b(block);
        return (ql)d.g().e(ms2.Y(block));
    }

    public static boolean av(Block block) {
        return ql.j(block.getType());
    }

    @Deprecated
    public static boolean g(Block block, boolean bl) {
        return ql.a(block.getType(), bl);
    }

    public static boolean j(Material material) {
        return material == Material.NOTE_BLOCK || material == Material.BROWN_MUSHROOM_BLOCK || material == Material.RED_MUSHROOM_BLOCK || material == Material.MUSHROOM_STEM || material == Material.CHORUS_PLANT || material == Material.TRIPWIRE || material == Material.BARRIER || material == Material.SPAWNER;
    }

    public static boolean k(Material material) {
        if (material == Material.STRING) {
            return true;
        }
        return ql.j(material);
    }

    public static boolean a(Material material, boolean bl) {
        if (bl) {
            return material == Material.BROWN_MUSHROOM_BLOCK || material == Material.RED_MUSHROOM_BLOCK || material == Material.MUSHROOM_STEM;
        }
        return ql.j(material);
    }

    public static boolean h(Material material) {
        return material == Material.BROWN_MUSHROOM_BLOCK || material == Material.RED_MUSHROOM_BLOCK || material == Material.MUSHROOM_STEM;
    }

    public static boolean l(Material material) {
        return material == Material.CHORUS_PLANT;
    }

    public static boolean m(Material material) {
        return material == Material.NOTE_BLOCK;
    }

    public boolean p(ItemStack itemStack) {
        String string;
        boolean bl = false;
        if (this.FL.size() == 0 && this.FK.size() == 0) {
            return true;
        }
        String string2 = string = qm.isCustomItem(itemStack) ? qm.u(itemStack) : null;
        if (this.FL.size() > 0) {
            for (Map.Entry entry : this.FL.entrySet()) {
                if (((String)entry.getKey()).equals("HAND") && !bbs.ae(itemStack)) {
                    bl = true;
                } else if (((Boolean)entry.getValue()).booleanValue()) {
                    if (!qm.b(itemStack, (String)entry.getKey())) continue;
                    bl = true;
                } else if (string != null) {
                    if (!string.contains((CharSequence)entry.getKey())) continue;
                    bl = true;
                } else {
                    if (!itemStack.getType().toString().contains((CharSequence)entry.getKey())) continue;
                    bl = true;
                }
                break;
            }
        } else {
            bl = true;
        }
        if (this.FK.size() > 0) {
            for (Map.Entry entry : this.FK.entrySet()) {
                if (((String)entry.getKey()).equals("HAND")) {
                    if (bbs.ae(itemStack)) continue;
                    bl = false;
                }
                if (((Boolean)entry.getValue()).booleanValue()) {
                    if (!qm.b(itemStack, (String)entry.getKey())) continue;
                    bl = false;
                    break;
                }
                if (string != null) {
                    if (!string.contains((CharSequence)entry.getKey())) continue;
                    bl = false;
                    break;
                }
                if (!itemStack.getType().toString().contains((CharSequence)entry.getKey())) continue;
                bl = false;
            }
        }
        return bl;
    }

    public boolean q(ItemStack itemStack) {
        boolean bl = false;
        if (this.FN.size() > 0) {
            for (Map.Entry entry : this.FN.entrySet()) {
                if (((String)entry.getKey()).equals("HAND") && !bbs.ae(itemStack)) {
                    bl = true;
                } else if (((Boolean)entry.getValue()).booleanValue()) {
                    if (!qm.b(itemStack, (String)entry.getKey())) continue;
                    bl = true;
                } else if (qm.isCustomItem(itemStack)) {
                    if (!qm.u(itemStack).contains((CharSequence)entry.getKey())) continue;
                    bl = true;
                } else {
                    if (!itemStack.getType().toString().contains((CharSequence)entry.getKey())) continue;
                    bl = true;
                }
                break;
            }
        } else {
            bl = true;
        }
        if (this.FM.size() > 0) {
            for (Map.Entry entry : this.FM.entrySet()) {
                if (((String)entry.getKey()).equals("HAND")) {
                    if (bbs.ae(itemStack)) continue;
                    bl = false;
                }
                if (((Boolean)entry.getValue()).booleanValue()) {
                    if (!qm.b(itemStack, (String)entry.getKey())) continue;
                    bl = false;
                    continue;
                }
                if (qm.isCustomItem(itemStack)) {
                    if (!qm.u(itemStack).contains((CharSequence)entry.getKey())) continue;
                    bl = true;
                    break;
                }
                if (!itemStack.getType().toString().contains((CharSequence)entry.getKey())) continue;
                bl = false;
            }
        }
        return bl;
    }

    public static boolean k(qm qm2) {
        return qm2 instanceof ql;
    }

    public void ak(boolean bl) {
        this.FO = bl;
        BlockDataMeta blockDataMeta = (BlockDataMeta)this.getItemMeta();
        blockDataMeta.setBlockData(this.FD.pb());
        this.setItemMeta((ItemMeta)blockDataMeta);
        this.mZ();
    }

    @Generated
    public se mK() {
        return this.FJ;
    }

    @Generated
    public void a(se se2) {
        this.FJ = se2;
    }

    @Generated
    public boolean mL() {
        return this.FO;
    }
}
