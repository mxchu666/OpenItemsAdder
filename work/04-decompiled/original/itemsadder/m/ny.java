package itemsadder.m;

import itemsadder.m.abk;
import itemsadder.m.axi;
import itemsadder.m.bay;
import itemsadder.m.bcc;
import itemsadder.m.bdf;
import itemsadder.m.d;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Bed;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class ny
extends ou {
    public final int CX;
    public final int CY;
    public final boolean CZ;
    public final boolean Da;
    public final boolean Db;
    public final boolean Dc;

    public ny(int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.CX = n;
        this.CY = n2;
        this.CZ = bl;
        this.Da = bl2;
        this.Db = bl3;
        this.Dc = bl4;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        return pa.ml();
    }

    @Override
    public pa a(BlockBreakEvent blockBreakEvent, qm qm2, ItemStack itemStack2) {
        Player player = blockBreakEvent.getPlayer();
        Block block = blockBreakEvent.getBlock();
        if (block.getType().getHardness() == 0.0f) {
            return pa.mk();
        }
        BlockFace blockFace = w.bN.f(player);
        ArrayList arrayList = new ArrayList();
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        boolean bl = itemStack2.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH);
        if (this.CZ) {
            if (!this.a(player, blockFace, this.CX, block, arrayList)) {
                return pa.ml();
            }
        } else {
            this.a(blockFace, this.CX, block, arrayList);
        }
        int n2 = 0;
        HashMap<Object, Integer> hashMap = new HashMap<Object, Integer>();
        HashMap<String, ItemStack> hashMap2 = new HashMap<String, ItemStack>();
        for (Block block2 : arrayList) {
            Bed bed2;
            Object object;
            ql ql2;
            if (block2.equals((Object)block) || bay.S(block2.getType()) || this.Da && bay.bj(block2)) continue;
            ql ql3 = ql2 = ql.av(block2) ? ql.au(block2) : null;
            if ((ql2 == null ? !abk.tl().b(block2, itemStack2) : !ql2.p(itemStack2)) || !bcc.a(block2, player)) continue;
            Collection collection = block2.getDrops();
            BlockData blockData = block2.getBlockData();
            if (blockData instanceof Bisected) {
                object = (Bisected)blockData;
                if ((blockData = block2.getRelative(object.getHalf() == Bisected.Half.TOP ? BlockFace.DOWN : BlockFace.UP)).getType() == block2.getType()) {
                    arrayList2.add(blockData);
                }
            } else {
                blockData = block2.getBlockData();
                if (blockData instanceof Bed && (blockData = block2.getRelative((bed2 = (Bed)blockData).getFacing().getOppositeFace())).getType() == block2.getType()) {
                    arrayList2.add(blockData);
                }
            }
            arrayList2.add(block2);
            ++n2;
            if (this.Dc && !bl || !this.Db) continue;
            if (collection.isEmpty()) {
                if (ql2 != null) {
                    this.a(hashMap2, ql2);
                    continue;
                }
                object = block2.getType();
                if (object == Material.STONE) {
                    Material material2 = bed2 = bl ? Material.STONE : Material.COBBLESTONE;
                    if (hashMap.containsKey(bed2)) {
                        hashMap.put(bed2, (Integer)hashMap.get(bed2) + 1);
                        continue;
                    }
                    hashMap.put(bed2, 1);
                    continue;
                }
                if (hashMap.containsKey(object)) {
                    hashMap.put(object, (Integer)hashMap.get(object) + 1);
                    continue;
                }
                hashMap.put(object, 1);
                continue;
            }
            for (Bed bed2 : collection) {
                if (ql.j(bed2.getType()) && ql2 != null) {
                    this.a(hashMap2, ql2);
                    continue;
                }
                if (hashMap.containsKey(bed2.getType())) {
                    hashMap.put(bed2.getType(), (Integer)hashMap.get(bed2.getType()) + bed2.getAmount());
                    continue;
                }
                hashMap.put(bed2.getType(), bed2.getAmount());
            }
        }
        if (!arrayList2.isEmpty()) {
            abk.a(arrayList2, block);
            for (Block block2 : arrayList2) {
                d.g().b(block2).ag(block2);
            }
            if (axi.t(block.getWorld())) {
                abk.b(arrayList2, block);
            }
        }
        qm.a(itemStack2, n2, (LivingEntity)player);
        hashMap.forEach((material, n) -> bdf.b(block.getLocation(), new ItemStack(material, n.intValue())));
        hashMap2.forEach((string, itemStack) -> bdf.b(block.getLocation(), itemStack));
        return pa.ml();
    }

    private void a(BlockFace blockFace, int n, Block block, List list) {
        Location location2;
        Object object;
        ArrayList arrayList = new ArrayList();
        int n2 = n / 3;
        if (blockFace == BlockFace.UP) {
            object = block.getLocation().add((double)(-n2), 0.0, (double)n2);
            location2 = block.getLocation().add((double)n2, (double)(-this.CY), (double)(-n2));
            list.addAll(bay.d((Location)object, location2));
        } else if (blockFace == BlockFace.DOWN) {
            object = block.getLocation().add((double)(-n2), 0.0, (double)n2);
            location2 = block.getLocation().add((double)n2, (double)this.CY, (double)(-n2));
            list.addAll(bay.d((Location)object, location2));
        } else if (blockFace == BlockFace.NORTH) {
            object = block.getLocation().add((double)(-n2), (double)n2, 0.0);
            location2 = block.getLocation().add((double)n2, (double)(-n2), (double)this.CY);
            list.addAll(bay.d((Location)object, location2));
        } else if (blockFace == BlockFace.SOUTH) {
            object = block.getLocation().add((double)(-n2), (double)n2, 0.0);
            location2 = block.getLocation().add((double)n2, (double)(-n2), (double)(-this.CY));
            list.addAll(bay.d((Location)object, location2));
        } else if (blockFace == BlockFace.EAST) {
            object = block.getLocation().add(0.0, (double)n2, (double)(-n2));
            location2 = block.getLocation().add((double)(-this.CY), (double)(-n2), (double)n2);
            list.addAll(bay.d((Location)object, location2));
        } else if (blockFace == BlockFace.WEST) {
            object = block.getLocation().add(0.0, (double)n2, (double)(-n2));
            location2 = block.getLocation().add((double)this.CY, (double)(-n2), (double)n2);
            list.addAll(bay.d((Location)object, location2));
        }
        if (blockFace == BlockFace.UP || blockFace == BlockFace.DOWN) {
            object = block.getLocation().add((double)(-n2), 0.0, (double)n2);
            location2 = block.getLocation().add((double)n2, 0.0, (double)(-n2));
            arrayList.addAll(bay.d((Location)object, location2));
        } else if (blockFace == BlockFace.NORTH || blockFace == BlockFace.SOUTH) {
            object = block.getLocation().add((double)(-n2), (double)n2, 0.0);
            location2 = block.getLocation().add((double)n2, (double)(-n2), 0.0);
            arrayList.addAll(bay.d((Location)object, location2));
        } else if (blockFace == BlockFace.EAST || blockFace == BlockFace.WEST) {
            object = block.getLocation().add(0.0, (double)n2, (double)(-n2));
            location2 = block.getLocation().add(0.0, (double)(-n2), (double)n2);
            arrayList.addAll(bay.d((Location)object, location2));
        }
        for (Location location2 : arrayList) {
            this.am((Block)location2);
        }
    }

    private boolean a(Player player, BlockFace blockFace, int n, Block block, List list) {
        World world = block.getWorld();
        Location location = block.getLocation();
        BlockFace blockFace2 = blockFace.getOppositeFace();
        if (blockFace2 != BlockFace.UP && blockFace2 != BlockFace.DOWN) {
            if (location.getY() > player.getLocation().getY()) {
                location.subtract(0.0, 1.0, 0.0);
            }
        } else {
            return false;
        }
        for (int i = 0; i < n; ++i) {
            Block block2 = world.getBlockAt(location);
            list.add(block2);
            this.am(block2);
            location.add(0.0, 1.0, 0.0);
        }
        return true;
    }

    private void a(HashMap hashMap, ql ql2) {
        ItemStack itemStack;
        if (hashMap.containsKey(ql2.getNamespacedID())) {
            itemStack = (ItemStack)hashMap.get(ql2.getNamespacedID());
            itemStack.setAmount(itemStack.getAmount() + 1);
        } else {
            itemStack = ql2.mP();
            itemStack.setAmount(1);
        }
        hashMap.put(ql2.getNamespacedID(), itemStack);
    }

    private void am(Block block) {
        block.getLocation().getBlock().getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, (Object)block.getType());
    }
}
