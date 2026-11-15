package itemsadder.m;

import itemsadder.m.bbg;
import itemsadder.m.bce;
import itemsadder.m.bdb;
import itemsadder.m.d;
import itemsadder.m.ql;
import itemsadder.m.sb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;
import org.bukkit.block.BlockFace;

public class sm {
    public static void d(ql ql2) {
        d d2 = d.g();
        sb sb2 = sm.a(ql2.ao(true), (T string) -> {
            if (string != null) {
                bce.error("[Items] '" + ql2.getNamespacedID() + "'. Error: Unknown 'directional_mode' value '" + string + "'. File: " + ql2.nh());
            }
        });
        if (sb2 != null && ql2.FD != null) {
            if (ql2.Hq.pg() && (ql2.getTextures() == null || ql2.getTextures().size() < 6)) {
                bce.warn("[Items] '" + ql2.getNamespacedID() + "'. Not enough textures for directional block. Provide all 6 faces textures. File: " + ql2.nh());
                return;
            }
            ArrayList<ql> arrayList = new ArrayList<ql>();
            ql2.FD.a(sb2);
            for (BlockFace blockFace : ql.FC) {
                bdb bdb2 = new bdb(0, 0, 0);
                block0 : switch (sb2) {
                    case ALL: {
                        switch (blockFace) {
                            case SOUTH: {
                                bdb2.ha = 90;
                                bdb2.gW = 180;
                                break;
                            }
                            case NORTH: {
                                bdb2.ha = 90;
                                break;
                            }
                            case EAST: {
                                bdb2.ha = 90;
                                bdb2.gW = 90;
                                break;
                            }
                            case WEST: {
                                bdb2.ha = 90;
                                bdb2.gW = -90;
                                break;
                            }
                            case DOWN: {
                                bdb2.ha = 180;
                                bdb2.gW = 180;
                            }
                        }
                        break;
                    }
                    case LOG: {
                        switch (blockFace) {
                            case SOUTH: 
                            case NORTH: {
                                bdb2.ha = 90;
                                break;
                            }
                            case EAST: 
                            case WEST: {
                                bdb2.ha = 90;
                                bdb2.gW = 90;
                            }
                        }
                        break;
                    }
                    case FURNACE: {
                        switch (blockFace) {
                            case SOUTH: {
                                bdb2.gW = 180;
                                break;
                            }
                            case EAST: {
                                bdb2.gW = 90;
                                break;
                            }
                            case WEST: {
                                bdb2.gW = -90;
                            }
                        }
                        break;
                    }
                    case DROPPER: {
                        switch (blockFace) {
                            case SOUTH: {
                                bdb2.gW = 180;
                                break block0;
                            }
                            case EAST: {
                                bdb2.gW = 90;
                                break block0;
                            }
                            case WEST: {
                                bdb2.gW = -90;
                                break block0;
                            }
                            case UP: {
                                bdb2.ha = -90;
                                break block0;
                            }
                            case DOWN: {
                                bdb2.ha = 90;
                                bdb2.gW = 180;
                            }
                        }
                    }
                }
                if (bdb2.Bc()) continue;
                ql ql3 = ql2.FD.n(bdb2.ha, bdb2.gW);
                if (ql3 != null) {
                    bce.iA("[Items] '" + ql2.getNamespacedID() + "'. Using previously created directional block '" + ql3.getNamespacedID() + "' for face '" + blockFace.name() + "'. File: " + ql2.nh());
                    ql2.FD.a(blockFace, ql3);
                    continue;
                }
                String string2 = ql2.getId() + "_" + blockFace.name().toLowerCase();
                ql ql4 = d.g().h(string2);
                if (ql4 != null) {
                    bce.log("[Items] '" + ql2.getNamespacedID() + "'. Using existing directional block '" + ql4.getNamespacedID() + "'. File: " + ql2.nh());
                    ql4.FD.am(bdb2.ha);
                    ql4.FD.an(bdb2.gW);
                    ql4.FD.aw(true);
                } else {
                    ql4 = ql2.a(string2, bdb2);
                    arrayList.add(ql4);
                }
                ql4.FD.aw(true);
                ql2.FD.a(blockFace, ql4);
            }
            for (ql ql5 : arrayList) {
                d2.S.add(ql5);
                d2.T.put(ql5.getNamespacedID(), ql2);
                if (ql2.Hq.pg()) {
                    d2.U.put(ql2.FD.id, ql2);
                }
                d2.C.put(ql5.getNamespacedID(), ql5);
                d2.E.put(ql5.getId(), ql5);
                d2.D.put(ql5.Gi, ql5);
                d2.N.computeIfAbsent(ql5.getType(), material -> new ArrayList()).add(ql5);
                d2.O.computeIfAbsent(ql5.getType(), material -> new HashMap()).put(ql5.getNamespacedID(), ql5);
                d2.M.computeIfAbsent(ql5.getNamespace(), string -> new HashMap()).put(ql5.getId(), ql5);
                bce.iA("Created directional block '" + ql5.getNamespacedID() + "' from '" + ql2.getNamespacedID() + "'.");
            }
            bce.log("[Items] Created " + arrayList.size() + " directional items for block '" + ql2.getNamespacedID() + "' ('" + sb2.name() + "'). File: " + ql2.nh());
        }
    }

    static sb a(bbg bbg2, Consumer consumer) {
        bbg bbg3 = bbg2.hj("specific_properties.block");
        if (bbg3 == null) {
            bbg3 = bbg2.hj("behaviours.block");
        }
        if (bbg3 == null) {
            return null;
        }
        return (sb)bbg3.a("placed_model.directional_mode", sb.class, null, consumer);
    }
}
