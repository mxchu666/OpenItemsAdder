package itemsadder.m;

import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerHolder_2;
import itemsadder.m.PlayerWrapper_4;
import itemsadder.m.RealEnum;
import itemsadder.m.RecordOfString_7;
import itemsadder.m.RecordOfValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.function.IntFunction;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

public final class MaterialBridge_3 {
    static final int rx = 10;
    static final byte ry = 0;
    static final byte rz = 1;
    static final byte rA = 2;
    static final float rB = 1.0E-4f;
    private static final int rC = 11;
    private static final int rD = 12;
    private static final int rE = 13;
    private RecordOfValue[] rF = new RecordOfValue[0];
    private Map rG = Map.of();
    private Object[] rH = new Object[0];
    private boolean[] rI = new boolean[0];
    private Material[] rJ = new Material[0];
    private int rK;
    private Object rL;

    public void a(World world, Collection collection) {
        Material[] materialArray2;
        this.clear();
        if (!MaterialBarColorHolder.cL) {
            return;
        }
        boolean bl = collection.stream().anyMatch(locationBridgeBuilder_2 -> locationBridgeBuilder_2.Hq == RealEnum.ENTITY);
        if (!bl) {
            return;
        }
        PlayerWrapper_4 playerWrapper_4 = PacketListenerRegistry.uN();
        int n2 = MaterialBarColorHolder.cN;
        int n3 = 9;
        int n4 = (n2 + n3 - 1) / n3;
        this.a(n2 + n4, (int n) -> playerWrapper_4.p(world));
        float f = Math.max(0.1f, (float)MaterialBarColorHolder.cM / 64.0f);
        HashMap<String, ItemStack> hashMap = new HashMap<String, ItemStack>();
        HashMap<RecordOfString_7, Integer> hashMap2 = new HashMap<RecordOfString_7, Integer>();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (Material[] materialArray2 : collection) {
            String string3;
            if (materialArray2.Hq != RealEnum.ENTITY) continue;
            String string4 = materialArray2.mD();
            RecordOfString_7 recordOfString_7 = new RecordOfString_7(string4, string3 = materialArray2.mF() == null ? null : materialArray2.mE(), materialArray2.FD.oY(), materialArray2.FD.oZ(), materialArray2.FA);
            Integer n5 = (Integer)hashMap2.get(recordOfString_7);
            if (n5 == null) {
                int n6;
                n5 = hashMap2.size();
                hashMap2.put(recordOfString_7, n5);
                float f2 = 2.0f + (string3 == null ? 0.0f : 1.0E-4f);
                for (n6 = -1; n6 < 10; ++n6) {
                    int n7 = n6;
                    String string5 = string4 + "#" + n6;
                    Material material = MaterialBridge_3.o(n6);
                    ItemStack itemStack = hashMap.computeIfAbsent(string5, string2 -> {
                        ItemStack itemStack = new ItemStack(material);
                        PlayerHolder_2.tX().d(itemStack, string4);
                        if (n7 >= 0) {
                            ItemStackBridge_2.b(itemStack, n7 + 1);
                        }
                        return itemStack;
                    });
                    arrayList.add(playerWrapper_4.a(world, itemStack, recordOfString_7.rO, recordOfString_7.rP, f, f2, f2, f2, 1.0f, 1.0f));
                }
                for (n6 = 1; n6 <= 2; n6 = (int)((byte)(n6 + 1))) {
                    if (string3 == null) {
                        arrayList.add(null);
                        continue;
                    }
                    ItemStack itemStack = hashMap.computeIfAbsent(string3, string -> {
                        ItemStack itemStack = new ItemStack(Material.PAPER);
                        PlayerHolder_2.tX().d(itemStack, (String)string);
                        return itemStack;
                    });
                    arrayList.add(playerWrapper_4.a(world, itemStack, recordOfString_7.rO + (n6 == 2 ? 90 : 0), recordOfString_7.rP, f, 6.0001f, 6.0001f, 2.0001f, 3.0f, 0.0f));
                }
            }
            materialArray2.Fz = n5;
        }
        Object object = new boolean[hashMap2.size()];
        materialArray2 = new Material[hashMap2.size()];
        hashMap2.forEach((arg_0, arg_1) -> MaterialBridge_3.a((boolean[])object, materialArray2, arg_0, arg_1));
        this.rG = Map.copyOf(hashMap);
        this.rH = arrayList.toArray();
        this.rI = (boolean[])object;
        this.rJ = materialArray2;
        this.rK = hashMap2.size();
        this.rL = playerWrapper_4.a(world, f);
    }

    static Material o(int n) {
        return n < 0 ? Material.PAPER : Material.GLASS;
    }

    void a(int n, IntFunction intFunction) {
        if (n < 1) {
            throw new IllegalArgumentException("ENTITY block display cap must be positive.");
        }
        RecordOfValue[] recordOfValueArray = new RecordOfValue[n];
        HashSet<Integer> hashSet = new HashSet<Integer>(n);
        for (int i = 0; i < n; ++i) {
            RecordOfValue recordOfValue = Objects.requireNonNull((RecordOfValue)intFunction.apply(i));
            if (recordOfValue.ux() < 0 || !hashSet.add(recordOfValue.ux())) {
                throw new IllegalStateException("Invalid vanilla ENTITY block identity: " + recordOfValue.ux());
            }
            recordOfValueArray[i] = recordOfValue;
        }
        this.rF = recordOfValueArray;
    }

    public RecordOfValue p(int n) {
        return this.rF[n];
    }

    public Object q(int n) {
        return this.rH[MaterialBridge_3.b(n, -1)];
    }

    Object r(int n) {
        return this.rH[n];
    }

    static int b(int n, int n2) {
        if (n2 < -1 || n2 >= 10) {
            throw new IllegalArgumentException("Invalid ENTITY block break stage: " + n2);
        }
        return n * 13 + n2 + 1;
    }

    static int a(int n, byte by) {
        int n2;
        switch (by) {
            case 1: {
                int n3 = 11;
                break;
            }
            case 2: {
                int n3 = 12;
                break;
            }
            default: {
                int n3 = n2 = -1;
            }
        }
        if (n2 < 0) {
            throw new IllegalArgumentException("Not an ENTITY block group kind: " + by);
        }
        return n * 13 + n2;
    }

    public boolean s(int n) {
        return n >= 0 && n < this.rI.length && this.rI[n];
    }

    public Material t(int n) {
        return this.rJ[n];
    }

    public Object he() {
        return this.rL;
    }

    public int hf() {
        return this.rF.length;
    }

    public int hg() {
        return this.rK;
    }

    public int hh() {
        return this.rG.size();
    }

    public void clear() {
        this.rF = new RecordOfValue[0];
        this.rG = Map.of();
        this.rH = new Object[0];
        this.rI = new boolean[0];
        this.rJ = new Material[0];
        this.rK = 0;
        this.rL = null;
    }

    private static /* synthetic */ void a(boolean[] blArray, Material[] materialArray, RecordOfString_7 recordOfString_7, Integer n) {
        blArray[n.intValue()] = recordOfString_7.rN != null;
        materialArray[n.intValue()] = recordOfString_7.rQ;
    }
}
