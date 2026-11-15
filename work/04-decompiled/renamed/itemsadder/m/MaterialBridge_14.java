package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.NoneEnum;
import itemsadder.m.VectorBridge_3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;
import org.bukkit.block.BlockFace;

public class MaterialBridge_14 {
    public static void d(LocationBridgeBuilder_2 locationBridgeBuilder_2) {
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        NoneEnum noneEnum = MaterialBridge_14.a(locationBridgeBuilder_2.ao(true), (T string) -> {
            if (string != null) {
                CommandSenderBridge_5.error("[Items] '" + locationBridgeBuilder_2.getNamespacedID() + "'. Error: Unknown 'directional_mode' value '" + string + "'. File: " + locationBridgeBuilder_2.nh());
            }
        });
        if (noneEnum != null && locationBridgeBuilder_2.FD != null) {
            if (locationBridgeBuilder_2.Hq.pg() && (locationBridgeBuilder_2.getTextures() == null || locationBridgeBuilder_2.getTextures().size() < 6)) {
                CommandSenderBridge_5.warn("[Items] '" + locationBridgeBuilder_2.getNamespacedID() + "'. Not enough textures for directional block. Provide all 6 faces textures. File: " + locationBridgeBuilder_2.nh());
                return;
            }
            ArrayList<LocationBridgeBuilder_2> arrayList = new ArrayList<LocationBridgeBuilder_2>();
            locationBridgeBuilder_2.FD.a(noneEnum);
            for (BlockFace blockFace : LocationBridgeBuilder_2.FC) {
                VectorBridge_3 vectorBridge_3 = new VectorBridge_3(0, 0, 0);
                block0 : switch (noneEnum) {
                    case ALL: {
                        switch (blockFace) {
                            case SOUTH: {
                                vectorBridge_3.ha = 90;
                                vectorBridge_3.gW = 180;
                                break;
                            }
                            case NORTH: {
                                vectorBridge_3.ha = 90;
                                break;
                            }
                            case EAST: {
                                vectorBridge_3.ha = 90;
                                vectorBridge_3.gW = 90;
                                break;
                            }
                            case WEST: {
                                vectorBridge_3.ha = 90;
                                vectorBridge_3.gW = -90;
                                break;
                            }
                            case DOWN: {
                                vectorBridge_3.ha = 180;
                                vectorBridge_3.gW = 180;
                            }
                        }
                        break;
                    }
                    case LOG: {
                        switch (blockFace) {
                            case SOUTH: 
                            case NORTH: {
                                vectorBridge_3.ha = 90;
                                break;
                            }
                            case EAST: 
                            case WEST: {
                                vectorBridge_3.ha = 90;
                                vectorBridge_3.gW = 90;
                            }
                        }
                        break;
                    }
                    case FURNACE: {
                        switch (blockFace) {
                            case SOUTH: {
                                vectorBridge_3.gW = 180;
                                break;
                            }
                            case EAST: {
                                vectorBridge_3.gW = 90;
                                break;
                            }
                            case WEST: {
                                vectorBridge_3.gW = -90;
                            }
                        }
                        break;
                    }
                    case DROPPER: {
                        switch (blockFace) {
                            case SOUTH: {
                                vectorBridge_3.gW = 180;
                                break block0;
                            }
                            case EAST: {
                                vectorBridge_3.gW = 90;
                                break block0;
                            }
                            case WEST: {
                                vectorBridge_3.gW = -90;
                                break block0;
                            }
                            case UP: {
                                vectorBridge_3.ha = -90;
                                break block0;
                            }
                            case DOWN: {
                                vectorBridge_3.ha = 90;
                                vectorBridge_3.gW = 180;
                            }
                        }
                    }
                }
                if (vectorBridge_3.Bc()) continue;
                LocationBridgeBuilder_2 locationBridgeBuilder_22 = locationBridgeBuilder_2.FD.n(vectorBridge_3.ha, vectorBridge_3.gW);
                if (locationBridgeBuilder_22 != null) {
                    CommandSenderBridge_5.iA("[Items] '" + locationBridgeBuilder_2.getNamespacedID() + "'. Using previously created directional block '" + locationBridgeBuilder_22.getNamespacedID() + "' for face '" + blockFace.name() + "'. File: " + locationBridgeBuilder_2.nh());
                    locationBridgeBuilder_2.FD.a(blockFace, locationBridgeBuilder_22);
                    continue;
                }
                String string2 = locationBridgeBuilder_2.getId() + "_" + blockFace.name().toLowerCase();
                LocationBridgeBuilder_2 locationBridgeBuilder_23 = ItemStackRegistry.g().h(string2);
                if (locationBridgeBuilder_23 != null) {
                    CommandSenderBridge_5.log("[Items] '" + locationBridgeBuilder_2.getNamespacedID() + "'. Using existing directional block '" + locationBridgeBuilder_23.getNamespacedID() + "'. File: " + locationBridgeBuilder_2.nh());
                    locationBridgeBuilder_23.FD.am(vectorBridge_3.ha);
                    locationBridgeBuilder_23.FD.an(vectorBridge_3.gW);
                    locationBridgeBuilder_23.FD.aw(true);
                } else {
                    locationBridgeBuilder_23 = locationBridgeBuilder_2.a(string2, vectorBridge_3);
                    arrayList.add(locationBridgeBuilder_23);
                }
                locationBridgeBuilder_23.FD.aw(true);
                locationBridgeBuilder_2.FD.a(blockFace, locationBridgeBuilder_23);
            }
            for (LocationBridgeBuilder_2 locationBridgeBuilder_24 : arrayList) {
                itemStackRegistry.S.add(locationBridgeBuilder_24);
                itemStackRegistry.T.put(locationBridgeBuilder_24.getNamespacedID(), locationBridgeBuilder_2);
                if (locationBridgeBuilder_2.Hq.pg()) {
                    itemStackRegistry.U.put(locationBridgeBuilder_2.FD.id, locationBridgeBuilder_2);
                }
                itemStackRegistry.C.put(locationBridgeBuilder_24.getNamespacedID(), locationBridgeBuilder_24);
                itemStackRegistry.E.put(locationBridgeBuilder_24.getId(), locationBridgeBuilder_24);
                itemStackRegistry.D.put(locationBridgeBuilder_24.Gi, locationBridgeBuilder_24);
                itemStackRegistry.N.computeIfAbsent(locationBridgeBuilder_24.getType(), material -> new ArrayList()).add(locationBridgeBuilder_24);
                itemStackRegistry.O.computeIfAbsent(locationBridgeBuilder_24.getType(), material -> new HashMap()).put(locationBridgeBuilder_24.getNamespacedID(), locationBridgeBuilder_24);
                itemStackRegistry.M.computeIfAbsent(locationBridgeBuilder_24.getNamespace(), string -> new HashMap()).put(locationBridgeBuilder_24.getId(), locationBridgeBuilder_24);
                CommandSenderBridge_5.iA("Created directional block '" + locationBridgeBuilder_24.getNamespacedID() + "' from '" + locationBridgeBuilder_2.getNamespacedID() + "'.");
            }
            CommandSenderBridge_5.log("[Items] Created " + arrayList.size() + " directional items for block '" + locationBridgeBuilder_2.getNamespacedID() + "' ('" + noneEnum.name() + "'). File: " + locationBridgeBuilder_2.nh());
        }
    }

    static NoneEnum a(ConfigurationSectionBridge configurationSectionBridge, Consumer consumer) {
        ConfigurationSectionBridge configurationSectionBridge2 = configurationSectionBridge.hj("specific_properties.block");
        if (configurationSectionBridge2 == null) {
            configurationSectionBridge2 = configurationSectionBridge.hj("behaviours.block");
        }
        if (configurationSectionBridge2 == null) {
            return null;
        }
        return (NoneEnum)configurationSectionBridge2.a("placed_model.directional_mode", NoneEnum.class, null, consumer);
    }
}
