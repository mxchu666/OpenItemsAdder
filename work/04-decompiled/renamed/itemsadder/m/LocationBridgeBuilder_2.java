package itemsadder.m;

import dev.lone.itemsadder.resourcepack.f;
import itemsadder.m.BlockBridge_13;
import itemsadder.m.BlockBridge_2;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BlockEnum;
import itemsadder.m.BlockHolder_2;
import itemsadder.m.BlockRegistry;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridge_13;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationHolder_3;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.MaterialBlockDataHolder;
import itemsadder.m.MaterialBridge_12;
import itemsadder.m.NoneEnum;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RealEnum;
import itemsadder.m.VectorBridge_3;
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

public class LocationBridgeBuilder_2
extends BlockBridge_13 {
    public static final int Fx = 3;
    public static final String Fy = "group_3x3x1";
    public int Fz = -1;
    public Material FA = Material.GRAY_CONCRETE;
    private LocationBridgeBuilder_2 FB;
    public static final BlockFace[] FC = new BlockFace[]{BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST, BlockFace.UP, BlockFace.DOWN};
    @Nullable
    public MaterialBlockDataHolder FD;
    public LocationHolder_3 xu;
    boolean yk;
    boolean FE;
    boolean FF;
    public int yh;
    public float FG;
    private float FH;
    public boolean FI;
    LocationBridge_13 FJ;
    HashMap FK;
    HashMap FL;
    HashMap FM;
    HashMap FN;
    private boolean FO;

    public LocationBridgeBuilder_2(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, Material material, int n, RealEnum realEnum, BlockEnum blockEnum, boolean bl, int n2, List list, List list2, List list3, List list4, float f, boolean bl2, boolean bl3, boolean bl4, boolean bl5, int n3, int n4, @Nullable List list5) {
        super(pluginFileConfigurationHolder, string, string2, material, realEnum);
        this.FD = new MaterialBlockDataHolder(this, n, blockEnum, bl2, bl3, bl4, bl5, n3, n4, list5);
        this.xu = new LocationHolder_3();
        this.yk = bl;
        this.yh = ColorBridge.p(n2, 0, 15);
        this.FG = f;
        this.FK = new HashMap();
        for (String string3 : list) {
            this.FK.put(string3, ItemStackRegistry.g().f(string3));
        }
        this.FL = new HashMap();
        for (String string3 : list2) {
            this.FL.put(string3, ItemStackRegistry.g().f(string3));
        }
        this.FM = new HashMap();
        for (String string3 : list3) {
            this.FM.put(string3, ItemStackRegistry.g().f(string3));
        }
        this.FN = new HashMap();
        for (String string3 : list4) {
            this.FN.put(string3, ItemStackRegistry.g().f(string3));
        }
    }

    public LocationBridgeBuilder_2 a(String string, VectorBridge_3 vectorBridge_3) {
        if (this.FD == null) {
            CommandSenderBridge_5.error("ERROR cloning '" + this.getNamespacedID() + "'. Somehow the placedBlockModel is null, is this a template?");
            return null;
        }
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = new LocationBridgeBuilder_2(this.Ga, this.Gf, string, this.getType(), this.Hq.pg() ? f.xl().a(this.getType(), this.Hq, this.Gf, string) : -1, this.Hq, this.FD.IY, this.yk, this.yh, this.FK.keySet().stream().toList(), this.FL.keySet().stream().toList(), this.FM.keySet().stream().toList(), this.FN.keySet().stream().toList(), this.FG, this.FD.Jb, this.FD.Jc, this.FD.Jd, this.FD.Je, this.FD.oY(), this.FD.oZ(), null);
        locationBridgeBuilder_2.b(this.Gc);
        locationBridgeBuilder_2.FA = this.FA;
        locationBridgeBuilder_2.setItemMeta(this.getItemMeta());
        locationBridgeBuilder_2.xu = this.xu;
        locationBridgeBuilder_2.yk = this.yk;
        locationBridgeBuilder_2.FE = this.FE;
        locationBridgeBuilder_2.FF = this.FF;
        locationBridgeBuilder_2.FG = this.FG;
        locationBridgeBuilder_2.FI = this.FI;
        locationBridgeBuilder_2.FH = this.FH;
        locationBridgeBuilder_2.bc(this.kL());
        locationBridgeBuilder_2.bd(this.kM());
        locationBridgeBuilder_2.bK(this.nf());
        this.Ge.g(locationBridgeBuilder_2);
        this.Gd.a(locationBridgeBuilder_2, false);
        locationBridgeBuilder_2.ap(false);
        locationBridgeBuilder_2.m(List.of());
        locationBridgeBuilder_2.bF(this.ga());
        locationBridgeBuilder_2.FB = this.FB == null ? this : this.FB;
        locationBridgeBuilder_2.FD.am(vectorBridge_3.ha);
        locationBridgeBuilder_2.FD.an(vectorBridge_3.gW);
        return locationBridgeBuilder_2;
    }

    public String mD() {
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = this.FB == null ? this : this.FB;
        return "_iainternal:entity_blocks/" + locationBridgeBuilder_2.getNamespace() + "/" + locationBridgeBuilder_2.getId();
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
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = this.FB == null ? this : this.FB;
        Object object2 = locationBridgeBuilder_2.FX;
        if (object2 instanceof MaterialBridge_12) {
            MaterialBridge_12 materialBridge_12 = (MaterialBridge_12)object2;
            object2 = materialBridge_12.oD();
            if (LocationBridgeBuilder_2.bz(materialBridge_12.oC()) && object2.size() == 1) {
                map = Map.of("all", (String)object2.values().iterator().next());
            } else {
                if (!LocationBridgeBuilder_2.bA(materialBridge_12.oC())) return null;
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
            if (locationBridgeBuilder_2.FX != null) {
                return null;
            }
            object2 = locationBridgeBuilder_2.getTextures();
            if (!LocationBridgeBuilder_2.bz(locationBridgeBuilder_2.nm()) || object2 == null || object2.size() != 1) {
                return null;
            }
            map = Map.of("all", (String)object2.get(0));
        }
        for (Object object2 : map.values()) {
            if (ItemStackRegistry.t((String)object2) != null) continue;
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
        BlockBridge_9 blockBridge_9;
        Block block2;
        boolean bl6;
        if (this.FD == null) {
            CommandSenderBridge_5.error("ERROR placing '" + this.getNamespacedID() + "'. Somehow the placedBlockModel is null, is this a template?");
            return false;
        }
        boolean bl7 = bl6 = bl && this.FD.Jb;
        if (bl6) {
            block2 = block.getLocation().add(0.0, 1.0, 0.0).getBlock();
            if (bl5 && player != null && !LocationBridge_2.b(block2, player)) {
                return false;
            }
        } else {
            block2 = block;
        }
        if (this.Hq == RealEnum.ENTITY && MaterialBarColorHolder.a(this.Hq) && !ItemStackRegistry.g().W.a(block2.getWorld().getUID(), block2.getX(), block2.getY(), block2.getZ(), MaterialBarColorHolder.cO)) {
            if (player != null) {
                CommandSenderBridge_5.a((CommandSender)player, "max-furnitures-vehicles-reached", (Object string) -> string.replace("{value}", Integer.toString(MaterialBarColorHolder.cO)));
            }
            return false;
        }
        if (bl6) {
            BlockHolder_2.tN().l(block, true);
        }
        String string2 = this.getNamespacedID();
        if (!MaterialBarColorHolder.a(this.Hq)) {
            if (player != null) {
                CommandSenderBridge_5.a((CommandSender)player, "custom-blocks-type-disabled", (Object string) -> string.replace("{type}", this.Hq.toString()));
            }
        } else if (this.Hq == RealEnum.TILE) {
            BukkitTaskBridge.b(() -> this.FD.i(block2, bl3), bl2);
        } else if (this.Hq == RealEnum.REAL_WIRE) {
            this.FD.i(block2, bl3);
            blockBridge_9 = block2.getRelative(BlockFace.UP);
            if (BlockRegistry.aM((Block)blockBridge_9)) {
                blockBridge_9.setType(Material.AIR, false);
            }
        } else if (blockFace != null && this.FD.oW()) {
            LocationBridgeBuilder_2 locationBridgeBuilder_2;
            blockBridge_9 = blockFace;
            if (player != null) {
                if (this.FD.oV() == NoneEnum.DROPPER) {
                    BlockFace blockFace2 = LocationBridge_2.cB(player);
                    BlockFace blockFace3 = LocationBridge_2.cC(player);
                    if (blockFace3 != BlockFace.SELF) {
                        if (blockFace3 == BlockFace.UP) {
                            blockBridge_9 = BlockFace.DOWN;
                        } else if (blockFace3 == BlockFace.DOWN) {
                            blockBridge_9 = BlockFace.UP;
                        }
                    } else {
                        blockBridge_9 = blockFace2.getOppositeFace();
                    }
                } else if (this.FD.oV() == NoneEnum.FURNACE) {
                    BlockFace blockFace4 = LocationBridge_2.cB(player);
                    blockBridge_9 = blockFace4.getOppositeFace();
                }
            }
            if ((locationBridgeBuilder_2 = this.FD.a((BlockFace)blockBridge_9)) != null) {
                locationBridgeBuilder_2.FD.i(block2, bl3);
                string2 = locationBridgeBuilder_2.getNamespacedID();
            }
            if (locationBridgeBuilder_2 == null) {
                CommandSenderBridge_5.error("ERROR placing '" + this.getNamespacedID() + "'. Somehow the directional block is null, is this a template?");
                return false;
            }
        } else {
            this.FD.i(block2, bl3);
        }
        if (this.yh != -1 && bl4) {
            BlockBridge_2.d(block2, this.yh);
        }
        blockBridge_9 = ItemStackRegistry.g().b(block2);
        blockBridge_9.e(block2, string2);
        return true;
    }

    @Nullable
    public static LocationBridgeBuilder_2 au(Block block) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        return (LocationBridgeBuilder_2)ItemStackRegistry.g().e(blockBridge_9.Y(block));
    }

    public static boolean av(Block block) {
        return LocationBridgeBuilder_2.j(block.getType());
    }

    @Deprecated
    public static boolean g(Block block, boolean bl) {
        return LocationBridgeBuilder_2.a(block.getType(), bl);
    }

    public static boolean j(Material material) {
        return material == Material.NOTE_BLOCK || material == Material.BROWN_MUSHROOM_BLOCK || material == Material.RED_MUSHROOM_BLOCK || material == Material.MUSHROOM_STEM || material == Material.CHORUS_PLANT || material == Material.TRIPWIRE || material == Material.BARRIER || material == Material.SPAWNER;
    }

    public static boolean k(Material material) {
        if (material == Material.STRING) {
            return true;
        }
        return LocationBridgeBuilder_2.j(material);
    }

    public static boolean a(Material material, boolean bl) {
        if (bl) {
            return material == Material.BROWN_MUSHROOM_BLOCK || material == Material.RED_MUSHROOM_BLOCK || material == Material.MUSHROOM_STEM;
        }
        return LocationBridgeBuilder_2.j(material);
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
        String string2 = string = ItemStackBuilder_4.isCustomItem(itemStack) ? ItemStackBuilder_4.u(itemStack) : null;
        if (this.FL.size() > 0) {
            for (Map.Entry entry : this.FL.entrySet()) {
                if (((String)entry.getKey()).equals("HAND") && !ItemStackBridge_2.ae(itemStack)) {
                    bl = true;
                } else if (((Boolean)entry.getValue()).booleanValue()) {
                    if (!ItemStackBuilder_4.b(itemStack, (String)entry.getKey())) continue;
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
                    if (ItemStackBridge_2.ae(itemStack)) continue;
                    bl = false;
                }
                if (((Boolean)entry.getValue()).booleanValue()) {
                    if (!ItemStackBuilder_4.b(itemStack, (String)entry.getKey())) continue;
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
                if (((String)entry.getKey()).equals("HAND") && !ItemStackBridge_2.ae(itemStack)) {
                    bl = true;
                } else if (((Boolean)entry.getValue()).booleanValue()) {
                    if (!ItemStackBuilder_4.b(itemStack, (String)entry.getKey())) continue;
                    bl = true;
                } else if (ItemStackBuilder_4.isCustomItem(itemStack)) {
                    if (!ItemStackBuilder_4.u(itemStack).contains((CharSequence)entry.getKey())) continue;
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
                    if (ItemStackBridge_2.ae(itemStack)) continue;
                    bl = false;
                }
                if (((Boolean)entry.getValue()).booleanValue()) {
                    if (!ItemStackBuilder_4.b(itemStack, (String)entry.getKey())) continue;
                    bl = false;
                    continue;
                }
                if (ItemStackBuilder_4.isCustomItem(itemStack)) {
                    if (!ItemStackBuilder_4.u(itemStack).contains((CharSequence)entry.getKey())) continue;
                    bl = true;
                    break;
                }
                if (!itemStack.getType().toString().contains((CharSequence)entry.getKey())) continue;
                bl = false;
            }
        }
        return bl;
    }

    public static boolean k(ItemStackBuilder_4 itemStackBuilder_4) {
        return itemStackBuilder_4 instanceof LocationBridgeBuilder_2;
    }

    public void ak(boolean bl) {
        this.FO = bl;
        BlockDataMeta blockDataMeta = (BlockDataMeta)this.getItemMeta();
        blockDataMeta.setBlockData(this.FD.pb());
        this.setItemMeta((ItemMeta)blockDataMeta);
        this.mZ();
    }

    @Generated
    public LocationBridge_13 mK() {
        return this.FJ;
    }

    @Generated
    public void a(LocationBridge_13 locationBridge_13) {
        this.FJ = locationBridge_13;
    }

    @Generated
    public boolean mL() {
        return this.FO;
    }
}
