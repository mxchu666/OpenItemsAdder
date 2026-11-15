package itemsadder.m;

import itemsadder.m.InstanceHolderBuilder;
import itemsadder.m.InstanceHolder_6;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Implemented_2
extends AbstractMap
implements Serializable,
Cloneable,
Map {
    private static final long serialVersionUID = 6767664750549425943L;
    static final int aCb = 16;
    static final int aCc = 0x40000000;
    static final float aCd = 0.75f;
    static final int aCe = 8;
    static final int aCf = 6;
    static final int aCg = 64;
    transient InstanceHolder_6[] aCh;
    transient Set aCi;
    transient int tK;
    transient int aCj;
    int ayR;
    final float aCk;

    static final int K(Object object) {
        int n;
        if (object == null) {
            n = 0;
        } else {
            int n2 = object.hashCode();
            n = n2 ^ n2 >>> 16;
        }
        return n;
    }

    static int f(Object object, Object object2) {
        return object2 == null ? 0 : ((Comparable)object).compareTo(object2);
    }

    static final int bW(int n) {
        int n2 = -1 >>> Integer.numberOfLeadingZeros(n - 1);
        return n2 < 0 ? 1 : (n2 >= 0x40000000 ? 0x40000000 : n2 + 1);
    }

    public Implemented_2(int n, float f) {
        if (n < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + n);
        }
        if (n > 0x40000000) {
            n = 0x40000000;
        }
        if (f <= 0.0f || Float.isNaN(f)) {
            throw new IllegalArgumentException("Illegal load factor: " + f);
        }
        this.aCk = f;
        this.ayR = Implemented_2.bW(n);
    }

    public Implemented_2(int n) {
        this(n, 0.75f);
    }

    public Implemented_2() {
        this.aCk = 0.75f;
    }

    public Implemented_2(Map map) {
        this.aCk = 0.75f;
        this.a(map, false);
    }

    final void a(Map map, boolean bl) {
        int n = map.size();
        if (n > 0) {
            if (this.aCh == null) {
                int n2;
                float f = (float)n / this.aCk + 1.0f;
                int n3 = n2 = f < 1.0737418E9f ? (int)f : 0x40000000;
                if (n2 > this.ayR) {
                    this.ayR = Implemented_2.bW(n2);
                }
            } else {
                while (n > this.ayR && this.aCh.length < 0x40000000) {
                    this.DY();
                }
            }
            for (Map.Entry entry : map.entrySet()) {
                Object k = entry.getKey();
                Object v = entry.getValue();
                this.a(Implemented_2.K(k), k, v, false, bl);
            }
        }
    }

    @Override
    public int size() {
        return this.tK;
    }

    @Override
    public boolean isEmpty() {
        return this.tK == 0;
    }

    public Object get(Object object) {
        InstanceHolder_6 instanceHolder_6 = this.L(object);
        return instanceHolder_6 == null ? null : instanceHolder_6.LG;
    }

    final InstanceHolder_6 L(Object object) {
        int n;
        InstanceHolder_6 instanceHolder_6;
        int n2;
        InstanceHolder_6[] instanceHolder_6Array = this.aCh;
        if (this.aCh != null && (n2 = instanceHolder_6Array.length) > 0 && (instanceHolder_6 = instanceHolder_6Array[n2 - 1 & (n = Implemented_2.K(object))]) != null) {
            Object object2;
            if (instanceHolder_6.aCx == n && ((object2 = instanceHolder_6.aCy) == object || object != null && object.equals(object2))) {
                return instanceHolder_6;
            }
            InstanceHolder_6 instanceHolder_62 = instanceHolder_6.aCo;
            if (instanceHolder_62 != null) {
                if (instanceHolder_6 instanceof InstanceHolderBuilder) {
                    return ((InstanceHolderBuilder)instanceHolder_6).a(n, object);
                }
                do {
                    if (instanceHolder_62.aCx != n || (object2 = instanceHolder_62.aCy) != object && (object == null || !object.equals(object2))) continue;
                    return instanceHolder_62;
                } while ((instanceHolder_62 = instanceHolder_62.aCo) != null);
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(Object object) {
        return this.L(object) != null;
    }

    public Object put(Object object, Object object2) {
        return this.a(Implemented_2.K(object), object, object2, false, true);
    }

    final Object a(int n, Object object, Object object2, boolean bl, boolean bl2) {
        int n2;
        InstanceHolder_6 instanceHolder_6;
        int n3;
        InstanceHolder_6[] instanceHolder_6Array = this.aCh;
        if (this.aCh == null || (n3 = instanceHolder_6Array.length) == 0) {
            instanceHolder_6Array = this.DY();
            n3 = instanceHolder_6Array.length;
        }
        if ((instanceHolder_6 = instanceHolder_6Array[n2 = n3 - 1 & n]) == null) {
            instanceHolder_6Array[n2] = this.a(n, object, object2, null);
        } else {
            InstanceHolder_6 instanceHolder_62;
            Object object3;
            if (instanceHolder_6.aCx == n && ((object3 = instanceHolder_6.aCy) == object || object != null && object.equals(object3))) {
                instanceHolder_62 = instanceHolder_6;
            } else if (instanceHolder_6 instanceof InstanceHolderBuilder) {
                instanceHolder_62 = ((InstanceHolderBuilder)instanceHolder_6).a(this, instanceHolder_6Array, n, object, object2);
            } else {
                int n4 = 0;
                while (true) {
                    if ((instanceHolder_62 = instanceHolder_6.aCo) == null) {
                        instanceHolder_6.aCo = this.a(n, object, object2, null);
                        if (n4 < 7) break;
                        this.a(instanceHolder_6Array, n);
                        break;
                    }
                    if (instanceHolder_62.aCx == n && ((object3 = instanceHolder_62.aCy) == object || object != null && object.equals(object3))) break;
                    instanceHolder_6 = instanceHolder_62;
                    ++n4;
                }
            }
            if (instanceHolder_62 != null) {
                Object object4 = instanceHolder_62.LG;
                if (!bl || object4 == null) {
                    instanceHolder_62.LG = object2;
                }
                this.a(instanceHolder_62);
                return object4;
            }
        }
        ++this.aCj;
        if (++this.tK > this.ayR) {
            this.DY();
        }
        this.bc(bl2);
        return null;
    }

    final InstanceHolder_6[] DY() {
        int n;
        InstanceHolder_6[] instanceHolder_6Array = this.aCh;
        int n2 = instanceHolder_6Array == null ? 0 : instanceHolder_6Array.length;
        int n3 = this.ayR;
        int n4 = 0;
        if (n2 > 0) {
            if (n2 >= 0x40000000) {
                this.ayR = Integer.MAX_VALUE;
                return instanceHolder_6Array;
            }
            n = n2 << 1;
            if (n < 0x40000000 && n2 >= 16) {
                n4 = n3 << 1;
            }
        } else if (n3 > 0) {
            n = n3;
        } else {
            n = 16;
            n4 = 12;
        }
        if (n4 == 0) {
            float f = (float)n * this.aCk;
            n4 = n < 0x40000000 && f < 1.0737418E9f ? (int)f : Integer.MAX_VALUE;
        }
        this.ayR = n4;
        InstanceHolder_6[] instanceHolder_6Array2 = new InstanceHolder_6[n];
        this.aCh = instanceHolder_6Array2;
        if (instanceHolder_6Array != null) {
            for (int i = 0; i < n2; ++i) {
                InstanceHolder_6 instanceHolder_6;
                InstanceHolder_6 instanceHolder_62 = instanceHolder_6Array[i];
                if (instanceHolder_62 == null) continue;
                instanceHolder_6Array[i] = null;
                if (instanceHolder_62.aCo == null) {
                    instanceHolder_6Array2[instanceHolder_62.aCx & n - 1] = instanceHolder_62;
                    continue;
                }
                if (instanceHolder_62 instanceof InstanceHolderBuilder) {
                    ((InstanceHolderBuilder)instanceHolder_62).a(this, instanceHolder_6Array2, i, n2);
                    continue;
                }
                InstanceHolder_6 instanceHolder_63 = null;
                InstanceHolder_6 instanceHolder_64 = null;
                InstanceHolder_6 instanceHolder_65 = null;
                InstanceHolder_6 instanceHolder_66 = null;
                do {
                    instanceHolder_6 = instanceHolder_62.aCo;
                    if ((instanceHolder_62.aCx & n2) == 0) {
                        if (instanceHolder_64 == null) {
                            instanceHolder_63 = instanceHolder_62;
                        } else {
                            instanceHolder_64.aCo = instanceHolder_62;
                        }
                        instanceHolder_64 = instanceHolder_62;
                        continue;
                    }
                    if (instanceHolder_66 == null) {
                        instanceHolder_65 = instanceHolder_62;
                    } else {
                        instanceHolder_66.aCo = instanceHolder_62;
                    }
                    instanceHolder_66 = instanceHolder_62;
                } while ((instanceHolder_62 = instanceHolder_6) != null);
                if (instanceHolder_64 != null) {
                    instanceHolder_64.aCo = null;
                    instanceHolder_6Array2[i] = instanceHolder_63;
                }
                if (instanceHolder_66 == null) continue;
                instanceHolder_66.aCo = null;
                instanceHolder_6Array2[i + n2] = instanceHolder_65;
            }
        }
        return instanceHolder_6Array2;
    }

    final void a(InstanceHolder_6[] instanceHolder_6Array, int n) {
        int n2;
        if (instanceHolder_6Array == null || (n2 = instanceHolder_6Array.length) < 64) {
            this.DY();
        } else {
            int n3 = n2 - 1 & n;
            InstanceHolder_6 instanceHolder_6 = instanceHolder_6Array[n3];
            if (instanceHolder_6 != null) {
                InstanceHolderBuilder instanceHolderBuilder = null;
                InstanceHolderBuilder instanceHolderBuilder2 = null;
                do {
                    InstanceHolderBuilder instanceHolderBuilder3 = this.b(instanceHolder_6, null);
                    if (instanceHolderBuilder2 == null) {
                        instanceHolderBuilder = instanceHolderBuilder3;
                    } else {
                        instanceHolderBuilder3.aCC = instanceHolderBuilder2;
                        instanceHolderBuilder2.aCo = instanceHolderBuilder3;
                    }
                    instanceHolderBuilder2 = instanceHolderBuilder3;
                } while ((instanceHolder_6 = instanceHolder_6.aCo) != null);
                instanceHolder_6Array[n3] = instanceHolderBuilder;
                if (instanceHolder_6Array[n3] != null) {
                    instanceHolderBuilder.a(instanceHolder_6Array);
                }
            }
        }
    }

    public void putAll(Map map) {
        this.a(map, true);
    }

    public Object remove(Object object) {
        InstanceHolder_6 instanceHolder_6 = this.b(Implemented_2.K(object), object, null, false, true);
        return instanceHolder_6 == null ? null : instanceHolder_6.LG;
    }

    final InstanceHolder_6 b(int n, Object object, Object object2, boolean bl, boolean bl2) {
        int n2;
        InstanceHolder_6 instanceHolder_6;
        int n3;
        InstanceHolder_6[] instanceHolder_6Array = this.aCh;
        if (this.aCh != null && (n3 = instanceHolder_6Array.length) > 0 && (instanceHolder_6 = instanceHolder_6Array[n2 = n3 - 1 & n]) != null) {
            Object object3;
            Object object4;
            InstanceHolder_6 instanceHolder_62 = null;
            if (instanceHolder_6.aCx == n && ((object4 = instanceHolder_6.aCy) == object || object != null && object.equals(object4))) {
                instanceHolder_62 = instanceHolder_6;
            } else {
                InstanceHolder_6 instanceHolder_63 = instanceHolder_6.aCo;
                if (instanceHolder_63 != null) {
                    if (instanceHolder_6 instanceof InstanceHolderBuilder) {
                        instanceHolder_62 = ((InstanceHolderBuilder)instanceHolder_6).a(n, object);
                    } else {
                        do {
                            if (instanceHolder_63.aCx == n && ((object4 = instanceHolder_63.aCy) == object || object != null && object.equals(object4))) {
                                instanceHolder_62 = instanceHolder_63;
                                break;
                            }
                            instanceHolder_6 = instanceHolder_63;
                        } while ((instanceHolder_63 = instanceHolder_63.aCo) != null);
                    }
                }
            }
            if (instanceHolder_62 != null && (!bl || (object3 = instanceHolder_62.LG) == object2 || object2 != null && object2.equals(object3))) {
                if (instanceHolder_62 instanceof InstanceHolderBuilder) {
                    ((InstanceHolderBuilder)instanceHolder_62).a(this, instanceHolder_6Array, bl2);
                } else if (instanceHolder_62 == instanceHolder_6) {
                    instanceHolder_6Array[n2] = instanceHolder_62.aCo;
                } else {
                    instanceHolder_6.aCo = instanceHolder_62.aCo;
                }
                ++this.aCj;
                --this.tK;
                this.b(instanceHolder_62);
                return instanceHolder_62;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        ++this.aCj;
        InstanceHolder_6[] instanceHolder_6Array = this.aCh;
        if (this.aCh != null && this.tK > 0) {
            this.tK = 0;
            for (int i = 0; i < instanceHolder_6Array.length; ++i) {
                instanceHolder_6Array[i] = null;
            }
        }
    }

    @Override
    public boolean containsValue(Object object) {
        InstanceHolder_6[] instanceHolder_6Array = this.aCh;
        if (this.aCh != null && this.tK > 0) {
            for (InstanceHolder_6 instanceHolder_6 : instanceHolder_6Array) {
                while (instanceHolder_6 != null) {
                    Object object2 = instanceHolder_6.LG;
                    if (object2 == object || object != null && object.equals(object2)) {
                        return true;
                    }
                    instanceHolder_6 = instanceHolder_6.aCo;
                }
            }
        }
        return false;
    }

    public Set keySet() {
        throw new RuntimeException("Not implemented!");
    }

    final Object[] d(Object[] objectArray) {
        int n = this.tK;
        if (objectArray.length < n) {
            return (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n);
        }
        if (objectArray.length > n) {
            objectArray[n] = null;
        }
        return objectArray;
    }

    Object[] e(Object[] objectArray) {
        Object[] objectArray2 = objectArray;
        int n = 0;
        if (this.tK > 0) {
            InstanceHolder_6[] instanceHolder_6Array = this.aCh;
            if (this.aCh != null) {
                for (InstanceHolder_6 instanceHolder_6 : instanceHolder_6Array) {
                    while (instanceHolder_6 != null) {
                        objectArray2[n++] = instanceHolder_6.aCy;
                        instanceHolder_6 = instanceHolder_6.aCo;
                    }
                }
            }
        }
        return objectArray;
    }

    Object[] f(Object[] objectArray) {
        Object[] objectArray2 = objectArray;
        int n = 0;
        if (this.tK > 0) {
            InstanceHolder_6[] instanceHolder_6Array = this.aCh;
            if (this.aCh != null) {
                for (InstanceHolder_6 instanceHolder_6 : instanceHolder_6Array) {
                    while (instanceHolder_6 != null) {
                        objectArray2[n++] = instanceHolder_6.LG;
                        instanceHolder_6 = instanceHolder_6.aCo;
                    }
                }
            }
        }
        return objectArray;
    }

    public Collection values() {
        throw new RuntimeException("Not implemented!");
    }

    public Set entrySet() {
        throw new RuntimeException("Not implemented!");
    }

    public Object getOrDefault(Object object, Object object2) {
        InstanceHolder_6 instanceHolder_6 = this.L(object);
        return instanceHolder_6 == null ? object2 : instanceHolder_6.LG;
    }

    public Object putIfAbsent(Object object, Object object2) {
        return this.a(Implemented_2.K(object), object, object2, true, true);
    }

    @Override
    public boolean remove(Object object, Object object2) {
        return this.b(Implemented_2.K(object), object, object2, true, true) != null;
    }

    public boolean replace(Object object, Object object2, Object object3) {
        Object object4;
        InstanceHolder_6 instanceHolder_6 = this.L(object);
        if (instanceHolder_6 != null && ((object4 = instanceHolder_6.LG) == object2 || object4 != null && object4.equals(object2))) {
            instanceHolder_6.LG = object3;
            this.a(instanceHolder_6);
            return true;
        }
        return false;
    }

    public Object replace(Object object, Object object2) {
        InstanceHolder_6 instanceHolder_6 = this.L(object);
        if (instanceHolder_6 != null) {
            Object object3 = instanceHolder_6.LG;
            instanceHolder_6.LG = object2;
            this.a(instanceHolder_6);
            return object3;
        }
        return null;
    }

    public Object computeIfAbsent(Object object, Function function) {
        Object object2;
        int n;
        InstanceHolder_6 instanceHolder_6;
        int n2;
        InstanceHolder_6[] instanceHolder_6Array;
        InstanceHolder_6 instanceHolder_62;
        InstanceHolderBuilder instanceHolderBuilder;
        int n3;
        int n4;
        block17: {
            block16: {
                if (function == null) {
                    throw new NullPointerException();
                }
                n4 = Implemented_2.K(object);
                n3 = 0;
                instanceHolderBuilder = null;
                instanceHolder_62 = null;
                if (this.tK > this.ayR) break block16;
                instanceHolder_6Array = this.aCh;
                if (this.aCh != null && (n2 = instanceHolder_6Array.length) != 0) break block17;
            }
            instanceHolder_6Array = this.DY();
            n2 = instanceHolder_6Array.length;
        }
        if ((instanceHolder_6 = instanceHolder_6Array[n = n2 - 1 & n4]) != null) {
            Object object3;
            if (instanceHolder_6 instanceof InstanceHolderBuilder) {
                instanceHolderBuilder = (InstanceHolderBuilder)instanceHolder_6;
                instanceHolder_62 = instanceHolderBuilder.a(n4, object);
            } else {
                object3 = instanceHolder_6;
                do {
                    if (((InstanceHolder_6)object3).aCx == n4 && ((object2 = ((InstanceHolder_6)object3).aCy) == object || object != null && object.equals(object2))) {
                        instanceHolder_62 = object3;
                        break;
                    }
                    ++n3;
                } while ((object3 = ((InstanceHolder_6)object3).aCo) != null);
            }
            if (instanceHolder_62 != null && (object3 = instanceHolder_62.LG) != null) {
                this.a(instanceHolder_62);
                return object3;
            }
        }
        int n5 = this.aCj;
        object2 = function.apply(object);
        if (n5 != this.aCj) {
            throw new ConcurrentModificationException();
        }
        if (object2 == null) {
            return null;
        }
        if (instanceHolder_62 != null) {
            instanceHolder_62.LG = object2;
            this.a(instanceHolder_62);
            return object2;
        }
        if (instanceHolderBuilder != null) {
            instanceHolderBuilder.a(this, instanceHolder_6Array, n4, object, object2);
        } else {
            instanceHolder_6Array[n] = this.a(n4, object, object2, instanceHolder_6);
            if (n3 >= 7) {
                this.a(instanceHolder_6Array, n4);
            }
        }
        this.aCj = n5 + 1;
        ++this.tK;
        this.bc(true);
        return object2;
    }

    public Object computeIfPresent(Object object, BiFunction biFunction) {
        Object object2;
        if (biFunction == null) {
            throw new NullPointerException();
        }
        InstanceHolder_6 instanceHolder_6 = this.L(object);
        if (instanceHolder_6 != null && (object2 = instanceHolder_6.LG) != null) {
            int n = this.aCj;
            Object r = biFunction.apply(object, object2);
            if (n != this.aCj) {
                throw new ConcurrentModificationException();
            }
            if (r != null) {
                instanceHolder_6.LG = r;
                this.a(instanceHolder_6);
                return r;
            }
            int n2 = Implemented_2.K(object);
            this.b(n2, object, null, false, true);
        }
        return null;
    }

    public Object compute(Object object, BiFunction biFunction) {
        Object object2;
        int n;
        InstanceHolder_6 instanceHolder_6;
        int n2;
        InstanceHolder_6[] instanceHolder_6Array;
        Object object3;
        InstanceHolderBuilder instanceHolderBuilder;
        int n3;
        int n4;
        block19: {
            block18: {
                if (biFunction == null) {
                    throw new NullPointerException();
                }
                n4 = Implemented_2.K(object);
                n3 = 0;
                instanceHolderBuilder = null;
                object3 = null;
                if (this.tK > this.ayR) break block18;
                instanceHolder_6Array = this.aCh;
                if (this.aCh != null && (n2 = instanceHolder_6Array.length) != 0) break block19;
            }
            instanceHolder_6Array = this.DY();
            n2 = instanceHolder_6Array.length;
        }
        if ((instanceHolder_6 = instanceHolder_6Array[n = n2 - 1 & n4]) != null) {
            if (instanceHolder_6 instanceof InstanceHolderBuilder) {
                instanceHolderBuilder = (InstanceHolderBuilder)instanceHolder_6;
                object3 = instanceHolderBuilder.a(n4, object);
            } else {
                object2 = instanceHolder_6;
                do {
                    Object object4;
                    if (((InstanceHolder_6)object2).aCx == n4 && ((object4 = ((InstanceHolder_6)object2).aCy) == object || object != null && object.equals(object4))) {
                        object3 = object2;
                        break;
                    }
                    ++n3;
                } while ((object2 = ((InstanceHolder_6)object2).aCo) != null);
            }
        }
        object2 = object3 == null ? null : ((InstanceHolder_6)object3).LG;
        int n5 = this.aCj;
        Object r = biFunction.apply(object, object2);
        if (n5 != this.aCj) {
            throw new ConcurrentModificationException();
        }
        if (object3 != null) {
            if (r != null) {
                ((InstanceHolder_6)object3).LG = r;
                this.a((InstanceHolder_6)object3);
            } else {
                this.b(n4, object, null, false, true);
            }
        } else if (r != null) {
            if (instanceHolderBuilder != null) {
                instanceHolderBuilder.a(this, instanceHolder_6Array, n4, object, r);
            } else {
                instanceHolder_6Array[n] = this.a(n4, object, r, instanceHolder_6);
                if (n3 >= 7) {
                    this.a(instanceHolder_6Array, n4);
                }
            }
            this.aCj = n5 + 1;
            ++this.tK;
            this.bc(true);
        }
        return r;
    }

    public Object merge(Object object, Object object2, BiFunction biFunction) {
        Object object3;
        int n;
        InstanceHolder_6 instanceHolder_6;
        int n2;
        InstanceHolder_6[] instanceHolder_6Array;
        Object object4;
        InstanceHolderBuilder instanceHolderBuilder;
        int n3;
        int n4;
        block20: {
            block19: {
                if (object2 == null || biFunction == null) {
                    throw new NullPointerException();
                }
                n4 = Implemented_2.K(object);
                n3 = 0;
                instanceHolderBuilder = null;
                object4 = null;
                if (this.tK > this.ayR) break block19;
                instanceHolder_6Array = this.aCh;
                if (this.aCh != null && (n2 = instanceHolder_6Array.length) != 0) break block20;
            }
            instanceHolder_6Array = this.DY();
            n2 = instanceHolder_6Array.length;
        }
        if ((instanceHolder_6 = instanceHolder_6Array[n = n2 - 1 & n4]) != null) {
            if (instanceHolder_6 instanceof InstanceHolderBuilder) {
                instanceHolderBuilder = (InstanceHolderBuilder)instanceHolder_6;
                object4 = instanceHolderBuilder.a(n4, object);
            } else {
                object3 = instanceHolder_6;
                do {
                    Object object5;
                    if (((InstanceHolder_6)object3).aCx == n4 && ((object5 = ((InstanceHolder_6)object3).aCy) == object || object != null && object.equals(object5))) {
                        object4 = object3;
                        break;
                    }
                    ++n3;
                } while ((object3 = ((InstanceHolder_6)object3).aCo) != null);
            }
        }
        if (object4 != null) {
            if (((InstanceHolder_6)object4).LG != null) {
                int n5 = this.aCj;
                object3 = biFunction.apply(((InstanceHolder_6)object4).LG, object2);
                if (n5 != this.aCj) {
                    throw new ConcurrentModificationException();
                }
            } else {
                object3 = object2;
            }
            if (object3 != null) {
                ((InstanceHolder_6)object4).LG = object3;
                this.a((InstanceHolder_6)object4);
            } else {
                this.b(n4, object, null, false, true);
            }
            return object3;
        }
        if (instanceHolderBuilder != null) {
            instanceHolderBuilder.a(this, instanceHolder_6Array, n4, object, object2);
        } else {
            instanceHolder_6Array[n] = this.a(n4, object, object2, instanceHolder_6);
            if (n3 >= 7) {
                this.a(instanceHolder_6Array, n4);
            }
        }
        ++this.aCj;
        ++this.tK;
        this.bc(true);
        return object2;
    }

    public void forEach(BiConsumer biConsumer) {
        if (biConsumer == null) {
            throw new NullPointerException();
        }
        if (this.tK > 0) {
            InstanceHolder_6[] instanceHolder_6Array = this.aCh;
            if (this.aCh != null) {
                int n = this.aCj;
                for (InstanceHolder_6 instanceHolder_6 : instanceHolder_6Array) {
                    while (instanceHolder_6 != null) {
                        biConsumer.accept(instanceHolder_6.aCy, instanceHolder_6.LG);
                        instanceHolder_6 = instanceHolder_6.aCo;
                    }
                }
                if (this.aCj != n) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    public void replaceAll(BiFunction biFunction) {
        if (biFunction == null) {
            throw new NullPointerException();
        }
        if (this.tK > 0) {
            InstanceHolder_6[] instanceHolder_6Array = this.aCh;
            if (this.aCh != null) {
                int n = this.aCj;
                for (InstanceHolder_6 instanceHolder_6 : instanceHolder_6Array) {
                    while (instanceHolder_6 != null) {
                        instanceHolder_6.LG = biFunction.apply(instanceHolder_6.aCy, instanceHolder_6.LG);
                        instanceHolder_6 = instanceHolder_6.aCo;
                    }
                }
                if (this.aCj != n) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    @Override
    public Object clone() {
        Implemented_2 implemented_2;
        try {
            implemented_2 = (Implemented_2)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError(cloneNotSupportedException);
        }
        implemented_2.vr();
        implemented_2.a(this, false);
        return implemented_2;
    }

    final float DZ() {
        return this.aCk;
    }

    final int Ea() {
        return this.aCh != null ? this.aCh.length : (this.ayR > 0 ? this.ayR : 16);
    }

    InstanceHolder_6 a(int n, Object object, Object object2, InstanceHolder_6 instanceHolder_6) {
        return new InstanceHolder_6(n, object, object2, instanceHolder_6);
    }

    InstanceHolder_6 a(InstanceHolder_6 instanceHolder_6, InstanceHolder_6 instanceHolder_62) {
        return new InstanceHolder_6(instanceHolder_6.aCx, instanceHolder_6.aCy, instanceHolder_6.LG, instanceHolder_62);
    }

    InstanceHolderBuilder b(int n, Object object, Object object2, InstanceHolder_6 instanceHolder_6) {
        return new InstanceHolderBuilder(n, object, object2, instanceHolder_6);
    }

    InstanceHolderBuilder b(InstanceHolder_6 instanceHolder_6, InstanceHolder_6 instanceHolder_62) {
        return new InstanceHolderBuilder(instanceHolder_6.aCx, instanceHolder_6.aCy, instanceHolder_6.LG, instanceHolder_62);
    }

    void vr() {
        throw new RuntimeException("Not implemented!");
    }

    void a(InstanceHolder_6 instanceHolder_6) {
    }

    void bc(boolean bl) {
    }

    void b(InstanceHolder_6 instanceHolder_6) {
    }

    void a(ObjectOutputStream objectOutputStream) {
        if (this.tK > 0) {
            InstanceHolder_6[] instanceHolder_6Array = this.aCh;
            if (this.aCh != null) {
                for (InstanceHolder_6 instanceHolder_6 : instanceHolder_6Array) {
                    while (instanceHolder_6 != null) {
                        objectOutputStream.writeObject(instanceHolder_6.aCy);
                        objectOutputStream.writeObject(instanceHolder_6.LG);
                        instanceHolder_6 = instanceHolder_6.aCo;
                    }
                }
            }
        }
    }
}
