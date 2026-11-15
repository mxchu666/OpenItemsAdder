package itemsadder.m;

import itemsadder.m.bem;
import itemsadder.m.ben;
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

public class bec
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
    transient bem[] aCh;
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

    public bec(int n, float f) {
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
        this.ayR = bec.bW(n);
    }

    public bec(int n) {
        this(n, 0.75f);
    }

    public bec() {
        this.aCk = 0.75f;
    }

    public bec(Map map) {
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
                    this.ayR = bec.bW(n2);
                }
            } else {
                while (n > this.ayR && this.aCh.length < 0x40000000) {
                    this.DY();
                }
            }
            for (Map.Entry entry : map.entrySet()) {
                Object k = entry.getKey();
                Object v = entry.getValue();
                this.a(bec.K(k), k, v, false, bl);
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
        bem bem2 = this.L(object);
        return bem2 == null ? null : bem2.LG;
    }

    final bem L(Object object) {
        int n;
        bem bem2;
        int n2;
        bem[] bemArray = this.aCh;
        if (this.aCh != null && (n2 = bemArray.length) > 0 && (bem2 = bemArray[n2 - 1 & (n = bec.K(object))]) != null) {
            Object object2;
            if (bem2.aCx == n && ((object2 = bem2.aCy) == object || object != null && object.equals(object2))) {
                return bem2;
            }
            bem bem3 = bem2.aCo;
            if (bem3 != null) {
                if (bem2 instanceof ben) {
                    return ((ben)bem2).a(n, object);
                }
                do {
                    if (bem3.aCx != n || (object2 = bem3.aCy) != object && (object == null || !object.equals(object2))) continue;
                    return bem3;
                } while ((bem3 = bem3.aCo) != null);
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(Object object) {
        return this.L(object) != null;
    }

    public Object put(Object object, Object object2) {
        return this.a(bec.K(object), object, object2, false, true);
    }

    final Object a(int n, Object object, Object object2, boolean bl, boolean bl2) {
        int n2;
        bem bem2;
        int n3;
        bem[] bemArray = this.aCh;
        if (this.aCh == null || (n3 = bemArray.length) == 0) {
            bemArray = this.DY();
            n3 = bemArray.length;
        }
        if ((bem2 = bemArray[n2 = n3 - 1 & n]) == null) {
            bemArray[n2] = this.a(n, object, object2, null);
        } else {
            bem bem3;
            Object object3;
            if (bem2.aCx == n && ((object3 = bem2.aCy) == object || object != null && object.equals(object3))) {
                bem3 = bem2;
            } else if (bem2 instanceof ben) {
                bem3 = ((ben)bem2).a(this, bemArray, n, object, object2);
            } else {
                int n4 = 0;
                while (true) {
                    if ((bem3 = bem2.aCo) == null) {
                        bem2.aCo = this.a(n, object, object2, null);
                        if (n4 < 7) break;
                        this.a(bemArray, n);
                        break;
                    }
                    if (bem3.aCx == n && ((object3 = bem3.aCy) == object || object != null && object.equals(object3))) break;
                    bem2 = bem3;
                    ++n4;
                }
            }
            if (bem3 != null) {
                Object object4 = bem3.LG;
                if (!bl || object4 == null) {
                    bem3.LG = object2;
                }
                this.a(bem3);
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

    final bem[] DY() {
        int n;
        bem[] bemArray = this.aCh;
        int n2 = bemArray == null ? 0 : bemArray.length;
        int n3 = this.ayR;
        int n4 = 0;
        if (n2 > 0) {
            if (n2 >= 0x40000000) {
                this.ayR = Integer.MAX_VALUE;
                return bemArray;
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
        bem[] bemArray2 = new bem[n];
        this.aCh = bemArray2;
        if (bemArray != null) {
            for (int i = 0; i < n2; ++i) {
                bem bem2;
                bem bem3 = bemArray[i];
                if (bem3 == null) continue;
                bemArray[i] = null;
                if (bem3.aCo == null) {
                    bemArray2[bem3.aCx & n - 1] = bem3;
                    continue;
                }
                if (bem3 instanceof ben) {
                    ((ben)bem3).a(this, bemArray2, i, n2);
                    continue;
                }
                bem bem4 = null;
                bem bem5 = null;
                bem bem6 = null;
                bem bem7 = null;
                do {
                    bem2 = bem3.aCo;
                    if ((bem3.aCx & n2) == 0) {
                        if (bem5 == null) {
                            bem4 = bem3;
                        } else {
                            bem5.aCo = bem3;
                        }
                        bem5 = bem3;
                        continue;
                    }
                    if (bem7 == null) {
                        bem6 = bem3;
                    } else {
                        bem7.aCo = bem3;
                    }
                    bem7 = bem3;
                } while ((bem3 = bem2) != null);
                if (bem5 != null) {
                    bem5.aCo = null;
                    bemArray2[i] = bem4;
                }
                if (bem7 == null) continue;
                bem7.aCo = null;
                bemArray2[i + n2] = bem6;
            }
        }
        return bemArray2;
    }

    final void a(bem[] bemArray, int n) {
        int n2;
        if (bemArray == null || (n2 = bemArray.length) < 64) {
            this.DY();
        } else {
            int n3 = n2 - 1 & n;
            bem bem2 = bemArray[n3];
            if (bem2 != null) {
                ben ben2 = null;
                ben ben3 = null;
                do {
                    ben ben4 = this.b(bem2, null);
                    if (ben3 == null) {
                        ben2 = ben4;
                    } else {
                        ben4.aCC = ben3;
                        ben3.aCo = ben4;
                    }
                    ben3 = ben4;
                } while ((bem2 = bem2.aCo) != null);
                bemArray[n3] = ben2;
                if (bemArray[n3] != null) {
                    ben2.a(bemArray);
                }
            }
        }
    }

    public void putAll(Map map) {
        this.a(map, true);
    }

    public Object remove(Object object) {
        bem bem2 = this.b(bec.K(object), object, null, false, true);
        return bem2 == null ? null : bem2.LG;
    }

    final bem b(int n, Object object, Object object2, boolean bl, boolean bl2) {
        int n2;
        bem bem2;
        int n3;
        bem[] bemArray = this.aCh;
        if (this.aCh != null && (n3 = bemArray.length) > 0 && (bem2 = bemArray[n2 = n3 - 1 & n]) != null) {
            Object object3;
            Object object4;
            bem bem3 = null;
            if (bem2.aCx == n && ((object4 = bem2.aCy) == object || object != null && object.equals(object4))) {
                bem3 = bem2;
            } else {
                bem bem4 = bem2.aCo;
                if (bem4 != null) {
                    if (bem2 instanceof ben) {
                        bem3 = ((ben)bem2).a(n, object);
                    } else {
                        do {
                            if (bem4.aCx == n && ((object4 = bem4.aCy) == object || object != null && object.equals(object4))) {
                                bem3 = bem4;
                                break;
                            }
                            bem2 = bem4;
                        } while ((bem4 = bem4.aCo) != null);
                    }
                }
            }
            if (bem3 != null && (!bl || (object3 = bem3.LG) == object2 || object2 != null && object2.equals(object3))) {
                if (bem3 instanceof ben) {
                    ((ben)bem3).a(this, bemArray, bl2);
                } else if (bem3 == bem2) {
                    bemArray[n2] = bem3.aCo;
                } else {
                    bem2.aCo = bem3.aCo;
                }
                ++this.aCj;
                --this.tK;
                this.b(bem3);
                return bem3;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        ++this.aCj;
        bem[] bemArray = this.aCh;
        if (this.aCh != null && this.tK > 0) {
            this.tK = 0;
            for (int i = 0; i < bemArray.length; ++i) {
                bemArray[i] = null;
            }
        }
    }

    @Override
    public boolean containsValue(Object object) {
        bem[] bemArray = this.aCh;
        if (this.aCh != null && this.tK > 0) {
            for (bem bem2 : bemArray) {
                while (bem2 != null) {
                    Object object2 = bem2.LG;
                    if (object2 == object || object != null && object.equals(object2)) {
                        return true;
                    }
                    bem2 = bem2.aCo;
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
            bem[] bemArray = this.aCh;
            if (this.aCh != null) {
                for (bem bem2 : bemArray) {
                    while (bem2 != null) {
                        objectArray2[n++] = bem2.aCy;
                        bem2 = bem2.aCo;
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
            bem[] bemArray = this.aCh;
            if (this.aCh != null) {
                for (bem bem2 : bemArray) {
                    while (bem2 != null) {
                        objectArray2[n++] = bem2.LG;
                        bem2 = bem2.aCo;
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
        bem bem2 = this.L(object);
        return bem2 == null ? object2 : bem2.LG;
    }

    public Object putIfAbsent(Object object, Object object2) {
        return this.a(bec.K(object), object, object2, true, true);
    }

    @Override
    public boolean remove(Object object, Object object2) {
        return this.b(bec.K(object), object, object2, true, true) != null;
    }

    public boolean replace(Object object, Object object2, Object object3) {
        Object object4;
        bem bem2 = this.L(object);
        if (bem2 != null && ((object4 = bem2.LG) == object2 || object4 != null && object4.equals(object2))) {
            bem2.LG = object3;
            this.a(bem2);
            return true;
        }
        return false;
    }

    public Object replace(Object object, Object object2) {
        bem bem2 = this.L(object);
        if (bem2 != null) {
            Object object3 = bem2.LG;
            bem2.LG = object2;
            this.a(bem2);
            return object3;
        }
        return null;
    }

    public Object computeIfAbsent(Object object, Function function) {
        Object object2;
        int n;
        bem bem2;
        int n2;
        bem[] bemArray;
        bem bem3;
        ben ben2;
        int n3;
        int n4;
        block17: {
            block16: {
                if (function == null) {
                    throw new NullPointerException();
                }
                n4 = bec.K(object);
                n3 = 0;
                ben2 = null;
                bem3 = null;
                if (this.tK > this.ayR) break block16;
                bemArray = this.aCh;
                if (this.aCh != null && (n2 = bemArray.length) != 0) break block17;
            }
            bemArray = this.DY();
            n2 = bemArray.length;
        }
        if ((bem2 = bemArray[n = n2 - 1 & n4]) != null) {
            Object object3;
            if (bem2 instanceof ben) {
                ben2 = (ben)bem2;
                bem3 = ben2.a(n4, object);
            } else {
                object3 = bem2;
                do {
                    if (((bem)object3).aCx == n4 && ((object2 = ((bem)object3).aCy) == object || object != null && object.equals(object2))) {
                        bem3 = object3;
                        break;
                    }
                    ++n3;
                } while ((object3 = ((bem)object3).aCo) != null);
            }
            if (bem3 != null && (object3 = bem3.LG) != null) {
                this.a(bem3);
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
        if (bem3 != null) {
            bem3.LG = object2;
            this.a(bem3);
            return object2;
        }
        if (ben2 != null) {
            ben2.a(this, bemArray, n4, object, object2);
        } else {
            bemArray[n] = this.a(n4, object, object2, bem2);
            if (n3 >= 7) {
                this.a(bemArray, n4);
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
        bem bem2 = this.L(object);
        if (bem2 != null && (object2 = bem2.LG) != null) {
            int n = this.aCj;
            Object r = biFunction.apply(object, object2);
            if (n != this.aCj) {
                throw new ConcurrentModificationException();
            }
            if (r != null) {
                bem2.LG = r;
                this.a(bem2);
                return r;
            }
            int n2 = bec.K(object);
            this.b(n2, object, null, false, true);
        }
        return null;
    }

    public Object compute(Object object, BiFunction biFunction) {
        Object object2;
        int n;
        bem bem2;
        int n2;
        bem[] bemArray;
        Object object3;
        ben ben2;
        int n3;
        int n4;
        block19: {
            block18: {
                if (biFunction == null) {
                    throw new NullPointerException();
                }
                n4 = bec.K(object);
                n3 = 0;
                ben2 = null;
                object3 = null;
                if (this.tK > this.ayR) break block18;
                bemArray = this.aCh;
                if (this.aCh != null && (n2 = bemArray.length) != 0) break block19;
            }
            bemArray = this.DY();
            n2 = bemArray.length;
        }
        if ((bem2 = bemArray[n = n2 - 1 & n4]) != null) {
            if (bem2 instanceof ben) {
                ben2 = (ben)bem2;
                object3 = ben2.a(n4, object);
            } else {
                object2 = bem2;
                do {
                    Object object4;
                    if (((bem)object2).aCx == n4 && ((object4 = ((bem)object2).aCy) == object || object != null && object.equals(object4))) {
                        object3 = object2;
                        break;
                    }
                    ++n3;
                } while ((object2 = ((bem)object2).aCo) != null);
            }
        }
        object2 = object3 == null ? null : ((bem)object3).LG;
        int n5 = this.aCj;
        Object r = biFunction.apply(object, object2);
        if (n5 != this.aCj) {
            throw new ConcurrentModificationException();
        }
        if (object3 != null) {
            if (r != null) {
                ((bem)object3).LG = r;
                this.a((bem)object3);
            } else {
                this.b(n4, object, null, false, true);
            }
        } else if (r != null) {
            if (ben2 != null) {
                ben2.a(this, bemArray, n4, object, r);
            } else {
                bemArray[n] = this.a(n4, object, r, bem2);
                if (n3 >= 7) {
                    this.a(bemArray, n4);
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
        bem bem2;
        int n2;
        bem[] bemArray;
        Object object4;
        ben ben2;
        int n3;
        int n4;
        block20: {
            block19: {
                if (object2 == null || biFunction == null) {
                    throw new NullPointerException();
                }
                n4 = bec.K(object);
                n3 = 0;
                ben2 = null;
                object4 = null;
                if (this.tK > this.ayR) break block19;
                bemArray = this.aCh;
                if (this.aCh != null && (n2 = bemArray.length) != 0) break block20;
            }
            bemArray = this.DY();
            n2 = bemArray.length;
        }
        if ((bem2 = bemArray[n = n2 - 1 & n4]) != null) {
            if (bem2 instanceof ben) {
                ben2 = (ben)bem2;
                object4 = ben2.a(n4, object);
            } else {
                object3 = bem2;
                do {
                    Object object5;
                    if (((bem)object3).aCx == n4 && ((object5 = ((bem)object3).aCy) == object || object != null && object.equals(object5))) {
                        object4 = object3;
                        break;
                    }
                    ++n3;
                } while ((object3 = ((bem)object3).aCo) != null);
            }
        }
        if (object4 != null) {
            if (((bem)object4).LG != null) {
                int n5 = this.aCj;
                object3 = biFunction.apply(((bem)object4).LG, object2);
                if (n5 != this.aCj) {
                    throw new ConcurrentModificationException();
                }
            } else {
                object3 = object2;
            }
            if (object3 != null) {
                ((bem)object4).LG = object3;
                this.a((bem)object4);
            } else {
                this.b(n4, object, null, false, true);
            }
            return object3;
        }
        if (ben2 != null) {
            ben2.a(this, bemArray, n4, object, object2);
        } else {
            bemArray[n] = this.a(n4, object, object2, bem2);
            if (n3 >= 7) {
                this.a(bemArray, n4);
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
            bem[] bemArray = this.aCh;
            if (this.aCh != null) {
                int n = this.aCj;
                for (bem bem2 : bemArray) {
                    while (bem2 != null) {
                        biConsumer.accept(bem2.aCy, bem2.LG);
                        bem2 = bem2.aCo;
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
            bem[] bemArray = this.aCh;
            if (this.aCh != null) {
                int n = this.aCj;
                for (bem bem2 : bemArray) {
                    while (bem2 != null) {
                        bem2.LG = biFunction.apply(bem2.aCy, bem2.LG);
                        bem2 = bem2.aCo;
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
        bec bec2;
        try {
            bec2 = (bec)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError(cloneNotSupportedException);
        }
        bec2.vr();
        bec2.a(this, false);
        return bec2;
    }

    final float DZ() {
        return this.aCk;
    }

    final int Ea() {
        return this.aCh != null ? this.aCh.length : (this.ayR > 0 ? this.ayR : 16);
    }

    bem a(int n, Object object, Object object2, bem bem2) {
        return new bem(n, object, object2, bem2);
    }

    bem a(bem bem2, bem bem3) {
        return new bem(bem2.aCx, bem2.aCy, bem2.LG, bem3);
    }

    ben b(int n, Object object, Object object2, bem bem2) {
        return new ben(n, object, object2, bem2);
    }

    ben b(bem bem2, bem bem3) {
        return new ben(bem2.aCx, bem2.aCy, bem2.LG, bem3);
    }

    void vr() {
        throw new RuntimeException("Not implemented!");
    }

    void a(bem bem2) {
    }

    void bc(boolean bl) {
    }

    void b(bem bem2) {
    }

    void a(ObjectOutputStream objectOutputStream) {
        if (this.tK > 0) {
            bem[] bemArray = this.aCh;
            if (this.aCh != null) {
                for (bem bem2 : bemArray) {
                    while (bem2 != null) {
                        objectOutputStream.writeObject(bem2.aCy);
                        objectOutputStream.writeObject(bem2.LG);
                        bem2 = bem2.aCo;
                    }
                }
            }
        }
    }
}
