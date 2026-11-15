package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import itemsadder.m.AFunction;
import itemsadder.m.BlockNms;
import itemsadder.m.BlockWrapper;
import itemsadder.m.BlockWrapper_2;
import itemsadder.m.BlockWrapper_3;
import itemsadder.m.ChunkWrapper;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.DMFunction;
import itemsadder.m.EntityDamageListenerBase;
import itemsadder.m.EntityTypeWrapper;
import itemsadder.m.EntityWrapper;
import itemsadder.m.IFunction;
import itemsadder.m.ItemStackWrapper;
import itemsadder.m.LivingEntityWrapper;
import itemsadder.m.LocationEquipmentSlotHolder;
import itemsadder.m.LocationWrapper;
import itemsadder.m.LocationWrapper_2;
import itemsadder.m.PacketContainerHelper_2;
import itemsadder.m.PacketEventWrapper;
import itemsadder.m.PlayerNms;
import itemsadder.m.PlayerQuitListenerBase;
import itemsadder.m.PlayerWrapper;
import itemsadder.m.PlayerWrapper_2;
import itemsadder.m.PlayerWrapper_3;
import itemsadder.m.PlayerWrapper_4;
import itemsadder.m.PlayerWrapper_5;
import itemsadder.m.VersionHelper_3;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public class NmsWrapperFactory {
    private static final Map Ve = new HashMap();

    @Nullable
    public static Field a(Class clazz, Class clazz2) {
        return VersionHelper_3.a(clazz, clazz2);
    }

    @Nullable
    public static Constructor b(Class clazz, Class ... classArray) {
        try {
            return clazz.getConstructor(classArray);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            try {
                Constructor constructor = clazz.getDeclaredConstructor(classArray);
                constructor.setAccessible(true);
                return constructor;
            }
            catch (NoSuchMethodException noSuchMethodException2) {
                return null;
            }
        }
    }

    private static Class m(Class clazz) {
        Version version = Version.get();
        Class<?> clazz2 = null;
        if (BlockNms.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6");
                default -> null;
            };
        } else if (BlockWrapper.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_2");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_2");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_2");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_2");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_2");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_2");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_2");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_2");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_2");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_2");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_2");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_2");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_2");
                default -> null;
            };
        } else if (LivingEntityWrapper.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_3");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_3");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_3");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_3");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_3");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_3");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_3");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_3");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_3");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_3");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_3");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_3");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_3");
                default -> null;
            };
        } else if (PlayerWrapper.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_4");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_4");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_4");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_4");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_4");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_4");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_4");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_4");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_4");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_4");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_4");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_4");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_4");
                default -> null;
            };
        } else if (LocationEquipmentSlotHolder.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_5");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_5");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_5");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_5");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_5");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_5");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_5");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_5");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_5");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_5");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_5");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_5");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_5");
                default -> null;
            };
        } else if (IFunction.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_6");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_6");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_6");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_6");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_6");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_6");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_6");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_6");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_6");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_6");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_6");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_6");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_6");
                default -> null;
            };
        } else if (BlockWrapper_2.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_7");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_7");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_7");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_7");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_7");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_7");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_7");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_7");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_7");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_7");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_7");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_7");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_7");
                default -> null;
            };
        } else if (EntityWrapper.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_8");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_8");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_8");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_8");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_8");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_8");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_8");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_8");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_8");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_8");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_8");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_8");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_8");
                default -> null;
            };
        } else if (BlockWrapper_3.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_9");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_9");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_9");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_9");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_9");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_9");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_9");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_9");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_9");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_9");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_9");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_9");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_9");
                default -> null;
            };
        } else if (PlayerWrapper_2.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_10");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_10");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_10");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_10");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_10");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_10");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_10");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_10");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_10");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_10");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_10");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_10");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_10");
                default -> null;
            };
        } else if (ItemStackWrapper.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_11");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_11");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_11");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_11");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_11");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_11");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_11");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_11");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_11");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_11");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_11");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_11");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_11");
                default -> null;
            };
        } else if (PlayerWrapper_3.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_12");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_12");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_12");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_12");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_12");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_12");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_12");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_12");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_12");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_12");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_12");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_12");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_12");
                default -> null;
            };
        } else if (PlayerWrapper_4.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_13");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_13");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_13");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_13");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_13");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_13");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_13");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_13");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_13");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_13");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_13");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_13");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_13");
                default -> null;
            };
        } else if (DMFunction.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_14");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_14");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_14");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_14");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_14");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_14");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_14");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_14");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_14");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_14");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_14");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_14");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_14");
                default -> null;
            };
        } else if (PlayerWrapper_5.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_15");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_15");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_15");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_15");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_15");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_15");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_15");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_15");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_15");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_15");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_15");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_15");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_15");
                default -> null;
            };
        } else if (LocationWrapper.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_16");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_16");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_16");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_16");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_16");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_16");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_16");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_16");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_16");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_16");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_16");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_16");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_16");
                default -> null;
            };
        } else if (EntityDamageListenerBase.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_17");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_17");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_17");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_17");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_17");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_17");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_17");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_17");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_17");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_17");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_17");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_17");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_17");
                default -> null;
            };
        } else if (PlayerQuitListenerBase.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_18");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_18");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_18");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_18");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_18");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_18");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_18");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_18");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_18");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_18");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_18");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_18");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_18");
                default -> null;
            };
        } else if (PacketContainerHelper_2.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_19");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_19");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_19");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_19");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_19");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_19");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_19");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_19");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_19");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_19");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_19");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_19");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_19");
                default -> null;
            };
        } else if (AFunction.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_20");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_20");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_20");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_20");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_20");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_20");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_20");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_20");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_20");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_20");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_20");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_20");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_20");
                default -> null;
            };
        } else if (PacketEventWrapper.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_21");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_21");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_21");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_21");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_21");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_21");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_21");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_21");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_21");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_21");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_21");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_21");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_21");
                default -> null;
            };
        } else if (LocationWrapper_2.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_22");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_22");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_22");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_22");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_22");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_22");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_22");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_22");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_22");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_22");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_22");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_22");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_22");
                default -> null;
            };
        } else if (ChunkWrapper.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_23");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_23");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_23");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_23");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_23");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_23");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_23");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_23");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_23");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_23");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_23");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_23");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.BlockNms_1_20_6_23");
                default -> null;
            };
        } else if (EntityTypeWrapper.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.BlockNms_26_2_24");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.BlockNms_26_1_2_24");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.BlockNms_26_1_1_24");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.BlockNms_1_21_11_24");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.BlockNms_1_21_10_24");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.BlockNms_1_21_8_24");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.BlockNms_1_21_7_24");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.BlockNms_1_21_6_24");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.BlockNms_1_21_5_24");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.BlockNms_1_21_4_24");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.BlockNms_1_21_3_24");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.BlockNms_1_21_1_24");
                case Version.v1_20_6 -> Class.forName("dev.lone.itemsadder.nms.mobgoal.impl.MobGoalNMS_v1_20_6");
                default -> null;
            };
        } else {
            if (PlayerNms.class == clazz) {
                throw new RuntimeException("Use RecipePacketHandler instead of IRecipebook!");
            }
            CommandSenderBridge_5.error("Class not found for type: " + clazz.getName());
            CommandSenderBridge_5.error("Maybe not an NMS wrapper class or not implemented yet?");
        }
        return clazz2;
    }

    public static Object n(Class clazz) {
        Class clazz2 = null;
        try {
            clazz2 = NmsWrapperFactory.m(clazz);
            if (clazz2 == null) {
                CommandSenderBridge_5.error("Can't instantiate NMS wrapper");
                CommandSenderBridge_5.error("This server version is not compatible with this plugin.");
                throw new RuntimeException("Class name not found for type: " + clazz.getName());
            }
            return NmsWrapperFactory.b(clazz, clazz2);
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Can't instantiate NMS wrapper");
            CommandSenderBridge_5.error("This server version is not compatible with this plugin.");
            throw new RuntimeException("Failed to create instance for class: " + String.valueOf(clazz2), throwable);
        }
    }

    private static Object b(Class clazz, Class clazz3) {
        Constructor constructor = Ve.computeIfAbsent(clazz, clazz2 -> {
            try {
                return clazz3.getDeclaredConstructor(new Class[0]);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new RuntimeException(noSuchMethodException);
            }
        });
        return constructor.newInstance(new Object[0]);
    }

    public static Constructor a(Class clazz, boolean bl, Class ... classArray) {
        Class clazz2;
        try {
            clazz2 = NmsWrapperFactory.m(clazz);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        }
        return NmsWrapperFactory.b(clazz2, classArray);
    }
}
