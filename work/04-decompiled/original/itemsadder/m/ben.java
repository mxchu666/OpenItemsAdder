package itemsadder.m;

import itemsadder.m.bec;
import itemsadder.m.bed;
import itemsadder.m.bem;

final class ben
extends bed {
    ben aCz;
    ben aCA;
    ben aCB;
    ben aCC;
    boolean aCD;
    static final /* synthetic */ boolean aCE;

    ben(int n, Object object, Object object2, bem bem2) {
        super(n, object, object2, bem2);
    }

    final ben Eg() {
        ben ben2 = this;
        ben ben3;
        while ((ben3 = ben2.aCz) != null) {
            ben2 = ben3;
        }
        return ben2;
    }

    static void a(bem[] bemArray, ben ben2) {
        int n;
        if (ben2 != null && bemArray != null && (n = bemArray.length) > 0) {
            int n2 = n - 1 & ben2.aCx;
            ben ben3 = (ben)bemArray[n2];
            if (ben2 != ben3) {
                bemArray[n2] = ben2;
                ben ben4 = ben2.aCC;
                bem bem2 = ben2.aCo;
                if (bem2 != null) {
                    ((ben)bem2).aCC = ben4;
                }
                if (ben4 != null) {
                    ben4.aCo = bem2;
                }
                if (ben3 != null) {
                    ben3.aCC = ben2;
                }
                ben2.aCo = ben3;
                ben2.aCC = null;
            }
            if (!aCE && !ben.a(ben2)) {
                throw new AssertionError();
            }
        }
    }

    final ben a(int n, Object object, Class clazz) {
        ben ben2 = this;
        do {
            int n2;
            ben ben3 = ben2.aCA;
            ben ben4 = ben2.aCB;
            int n3 = ben2.aCx;
            if (n3 > n) {
                ben2 = ben3;
                continue;
            }
            if (n3 < n) {
                ben2 = ben4;
                continue;
            }
            Object object2 = ben2.aCy;
            if (object2 == object || object != null && object.equals(object2)) {
                return ben2;
            }
            if (ben3 == null) {
                ben2 = ben4;
                continue;
            }
            if (ben4 == null) {
                ben2 = ben3;
                continue;
            }
            if ((clazz != null || (clazz = object != null ? object.getClass() : null) != null) && (n2 = bec.f(object, object2)) != 0) {
                ben2 = n2 < 0 ? ben3 : ben4;
                continue;
            }
            ben ben5 = ben4.a(n, object, clazz);
            if (ben5 != null) {
                return ben5;
            }
            ben2 = ben3;
        } while (ben2 != null);
        return null;
    }

    final ben a(int n, Object object) {
        return (this.aCz != null ? this.Eg() : this).a(n, object, null);
    }

    static int g(Object object, Object object2) {
        int n;
        if (object == null || object2 == null || (n = object.getClass().getName().compareTo(object2.getClass().getName())) == 0) {
            n = System.identityHashCode(object) <= System.identityHashCode(object2) ? -1 : 1;
        }
        return n;
    }

    final void a(bem[] bemArray) {
        ben ben2 = null;
        ben ben3 = this;
        while (ben3 != null) {
            ben ben4 = (ben)ben3.aCo;
            ben3.aCB = null;
            ben3.aCA = null;
            if (ben2 == null) {
                ben3.aCz = null;
                ben3.aCD = false;
                ben2 = ben3;
            } else {
                ben ben5;
                int n;
                Object object = ben3.aCy;
                int n2 = ben3.aCx;
                Class<?> clazz = null;
                ben ben6 = ben2;
                do {
                    Object object2 = ben6.aCy;
                    int n3 = ben6.aCx;
                    if (n3 > n2) {
                        n = -1;
                    } else if (n3 < n2) {
                        n = 1;
                    } else if (clazz == null && (clazz = object.getClass()) == null || (n = bec.f(object, object2)) == 0) {
                        n = ben.g(object, object2);
                    }
                    ben5 = ben6;
                } while ((ben6 = n <= 0 ? ben6.aCA : ben6.aCB) != null);
                ben3.aCz = ben5;
                if (n <= 0) {
                    ben5.aCA = ben3;
                } else {
                    ben5.aCB = ben3;
                }
                ben2 = ben.c(ben2, ben3);
            }
            ben3 = ben4;
        }
        ben.a(bemArray, ben2);
    }

    final bem a(bec bec2) {
        bem bem2 = null;
        bem bem3 = null;
        bem bem4 = this;
        while (bem4 != null) {
            bem bem5 = bec2.a(bem4, null);
            if (bem3 == null) {
                bem2 = bem5;
            } else {
                bem3.aCo = bem5;
            }
            bem3 = bem5;
            bem4 = bem4.aCo;
        }
        return bem2;
    }

    final ben a(bec bec2, bem[] bemArray, int n, Object object, Object object2) {
        ben ben2;
        bem bem2;
        int n2;
        ben ben3;
        Class<?> clazz = null;
        boolean bl = false;
        ben ben4 = ben3 = this.aCz != null ? this.Eg() : this;
        do {
            int n3;
            if ((n3 = ben4.aCx) > n) {
                n2 = -1;
            } else if (n3 < n) {
                n2 = 1;
            } else {
                Object object3 = ben4.aCy;
                if (object3 == object || object != null && object.equals(object3)) {
                    return ben4;
                }
                if (clazz == null && (clazz = object.getClass()) == null || (n2 = bec.f(object, object3)) == 0) {
                    if (!bl) {
                        bl = true;
                        bem2 = ben4.aCA;
                        if (bem2 != null && (ben2 = ((ben)bem2).a(n, object, clazz)) != null || (bem2 = ben4.aCB) != null && (ben2 = ((ben)bem2).a(n, object, clazz)) != null) {
                            return ben2;
                        }
                    }
                    n2 = ben.g(object, object3);
                }
            }
            ben2 = ben4;
        } while ((ben4 = n2 <= 0 ? ben4.aCA : ben4.aCB) != null);
        bem2 = ben2.aCo;
        ben ben5 = bec2.b(n, object, object2, bem2);
        if (n2 <= 0) {
            ben2.aCA = ben5;
        } else {
            ben2.aCB = ben5;
        }
        ben2.aCo = ben5;
        ben5.aCz = ben5.aCC = ben2;
        if (bem2 != null) {
            ((ben)bem2).aCC = ben5;
        }
        ben.a(bemArray, ben.c(ben3, ben5));
        return null;
    }

    final void a(bec bec2, bem[] bemArray, boolean bl) {
        ben ben2;
        ben ben3;
        ben ben4;
        ben ben5;
        ben ben6;
        int n;
        if (bemArray == null || (n = bemArray.length) == 0) {
            return;
        }
        int n2 = n - 1 & this.aCx;
        ben ben7 = ben6 = (ben)bemArray[n2];
        ben ben8 = (ben)this.aCo;
        ben ben9 = this.aCC;
        if (ben9 == null) {
            ben6 = ben8;
            bemArray[n2] = ben6;
        } else {
            ben9.aCo = ben8;
        }
        if (ben8 != null) {
            ben8.aCC = ben9;
        }
        if (ben6 == null) {
            return;
        }
        if (ben7.aCz != null) {
            ben7 = ben7.Eg();
        }
        if (ben7 == null || bl && (ben7.aCB == null || (ben5 = ben7.aCA) == null || ben5.aCA == null)) {
            bemArray[n2] = ben6.a(bec2);
            return;
        }
        ben ben10 = this;
        ben ben11 = this.aCA;
        ben ben12 = this.aCB;
        if (ben11 != null && ben12 != null) {
            ben4 = ben12;
            while ((ben3 = ben4.aCA) != null) {
                ben4 = ben3;
            }
            boolean bl2 = ben4.aCD;
            ben4.aCD = ben10.aCD;
            ben10.aCD = bl2;
            ben ben13 = ben4.aCB;
            ben ben14 = ben10.aCz;
            if (ben4 == ben12) {
                ben10.aCz = ben4;
                ben4.aCB = ben10;
            } else {
                ben ben15 = ben4.aCz;
                ben10.aCz = ben15;
                if (ben10.aCz != null) {
                    if (ben4 == ben15.aCA) {
                        ben15.aCA = ben10;
                    } else {
                        ben15.aCB = ben10;
                    }
                }
                if ((ben4.aCB = ben12) != null) {
                    ben12.aCz = ben4;
                }
            }
            ben10.aCA = null;
            ben10.aCB = ben13;
            if (ben10.aCB != null) {
                ben13.aCz = ben10;
            }
            if ((ben4.aCA = ben11) != null) {
                ben11.aCz = ben4;
            }
            if ((ben4.aCz = ben14) == null) {
                ben7 = ben4;
            } else if (ben10 == ben14.aCA) {
                ben14.aCA = ben4;
            } else {
                ben14.aCB = ben4;
            }
            ben2 = ben13 != null ? ben13 : ben10;
        } else {
            ben2 = ben11 != null ? ben11 : (ben12 != null ? ben12 : ben10);
        }
        if (ben2 != ben10) {
            ben2.aCz = ben10.aCz;
            ben4 = ben2.aCz;
            if (ben4 == null) {
                ben7 = ben2;
                ben2.aCD = false;
            } else if (ben10 == ben4.aCA) {
                ben4.aCA = ben2;
            } else {
                ben4.aCB = ben2;
            }
            ben10.aCz = null;
            ben10.aCB = null;
            ben10.aCA = null;
        }
        ben ben16 = ben4 = ben10.aCD ? ben7 : ben.d(ben7, ben2);
        if (ben2 == ben10) {
            ben3 = ben10.aCz;
            ben10.aCz = null;
            if (ben3 != null) {
                if (ben10 == ben3.aCA) {
                    ben3.aCA = null;
                } else if (ben10 == ben3.aCB) {
                    ben3.aCB = null;
                }
            }
        }
        if (bl) {
            ben.a(bemArray, ben4);
        }
    }

    final void a(bec bec2, bem[] bemArray, int n, int n2) {
        ben ben2 = this;
        ben ben3 = null;
        ben ben4 = null;
        ben ben5 = null;
        ben ben6 = null;
        int n3 = 0;
        int n4 = 0;
        ben ben7 = ben2;
        while (ben7 != null) {
            ben ben8 = (ben)ben7.aCo;
            ben7.aCo = null;
            if ((ben7.aCx & n2) == 0) {
                ben7.aCC = ben4;
                if (ben7.aCC == null) {
                    ben3 = ben7;
                } else {
                    ben4.aCo = ben7;
                }
                ben4 = ben7;
                ++n3;
            } else {
                ben7.aCC = ben6;
                if (ben7.aCC == null) {
                    ben5 = ben7;
                } else {
                    ben6.aCo = ben7;
                }
                ben6 = ben7;
                ++n4;
            }
            ben7 = ben8;
        }
        if (ben3 != null) {
            if (n3 <= 6) {
                bemArray[n] = ben3.a(bec2);
            } else {
                bemArray[n] = ben3;
                if (ben5 != null) {
                    ben3.a(bemArray);
                }
            }
        }
        if (ben5 != null) {
            if (n4 <= 6) {
                bemArray[n + n2] = ben5.a(bec2);
            } else {
                bemArray[n + n2] = ben5;
                if (ben3 != null) {
                    ben5.a(bemArray);
                }
            }
        }
    }

    static ben a(ben ben2, ben ben3) {
        ben ben4;
        if (ben3 != null && (ben4 = ben3.aCB) != null) {
            ben ben5 = ben3.aCB = ben4.aCA;
            if (ben3.aCB != null) {
                ben5.aCz = ben3;
            }
            ben ben6 = ben4.aCz = ben3.aCz;
            if (ben4.aCz == null) {
                ben2 = ben4;
                ben4.aCD = false;
            } else if (ben6.aCA == ben3) {
                ben6.aCA = ben4;
            } else {
                ben6.aCB = ben4;
            }
            ben4.aCA = ben3;
            ben3.aCz = ben4;
        }
        return ben2;
    }

    static ben b(ben ben2, ben ben3) {
        ben ben4;
        if (ben3 != null && (ben4 = ben3.aCA) != null) {
            ben ben5 = ben3.aCA = ben4.aCB;
            if (ben3.aCA != null) {
                ben5.aCz = ben3;
            }
            ben ben6 = ben4.aCz = ben3.aCz;
            if (ben4.aCz == null) {
                ben2 = ben4;
                ben4.aCD = false;
            } else if (ben6.aCB == ben3) {
                ben6.aCB = ben4;
            } else {
                ben6.aCA = ben4;
            }
            ben4.aCB = ben3;
            ben3.aCz = ben4;
        }
        return ben2;
    }

    static ben c(ben ben2, ben ben3) {
        ben3.aCD = true;
        while (true) {
            ben ben4;
            ben ben5;
            if ((ben5 = ben3.aCz) == null) {
                ben3.aCD = false;
                return ben3;
            }
            if (!ben5.aCD || (ben4 = ben5.aCz) == null) {
                return ben2;
            }
            ben ben6 = ben4.aCA;
            if (ben5 == ben6) {
                ben ben7 = ben4.aCB;
                if (ben7 != null && ben7.aCD) {
                    ben7.aCD = false;
                    ben5.aCD = false;
                    ben4.aCD = true;
                    ben3 = ben4;
                    continue;
                }
                if (ben3 == ben5.aCB) {
                    ben3 = ben5;
                    ben2 = ben.a(ben2, ben3);
                    ben5 = ben3.aCz;
                    ben ben8 = ben4 = ben5 == null ? null : ben5.aCz;
                }
                if (ben5 == null) continue;
                ben5.aCD = false;
                if (ben4 == null) continue;
                ben4.aCD = true;
                ben2 = ben.b(ben2, ben4);
                continue;
            }
            if (ben6 != null && ben6.aCD) {
                ben6.aCD = false;
                ben5.aCD = false;
                ben4.aCD = true;
                ben3 = ben4;
                continue;
            }
            if (ben3 == ben5.aCA) {
                ben3 = ben5;
                ben2 = ben.b(ben2, ben3);
                ben5 = ben3.aCz;
                ben ben9 = ben4 = ben5 == null ? null : ben5.aCz;
            }
            if (ben5 == null) continue;
            ben5.aCD = false;
            if (ben4 == null) continue;
            ben4.aCD = true;
            ben2 = ben.a(ben2, ben4);
        }
    }

    static ben d(ben ben2, ben ben3) {
        while (ben3 != null && ben3 != ben2) {
            ben ben4;
            ben ben5;
            ben ben6 = ben3.aCz;
            if (ben6 == null) {
                ben3.aCD = false;
                return ben3;
            }
            if (ben3.aCD) {
                ben3.aCD = false;
                return ben2;
            }
            ben ben7 = ben6.aCA;
            if (ben7 == ben3) {
                ben ben8 = ben6.aCB;
                if (ben8 != null && ben8.aCD) {
                    ben8.aCD = false;
                    ben6.aCD = true;
                    ben2 = ben.a(ben2, ben6);
                    ben6 = ben3.aCz;
                    ben ben9 = ben8 = ben6 == null ? null : ben6.aCB;
                }
                if (ben8 == null) {
                    ben3 = ben6;
                    continue;
                }
                ben5 = ben8.aCA;
                ben4 = ben8.aCB;
                if (!(ben4 != null && ben4.aCD || ben5 != null && ben5.aCD)) {
                    ben8.aCD = true;
                    ben3 = ben6;
                    continue;
                }
                if (ben4 == null || !ben4.aCD) {
                    if (ben5 != null) {
                        ben5.aCD = false;
                    }
                    ben8.aCD = true;
                    ben2 = ben.b(ben2, ben8);
                    ben6 = ben3.aCz;
                    ben ben10 = ben8 = ben6 == null ? null : ben6.aCB;
                }
                if (ben8 != null) {
                    ben8.aCD = ben6 == null ? false : ben6.aCD;
                    ben4 = ben8.aCB;
                    if (ben4 != null) {
                        ben4.aCD = false;
                    }
                }
                if (ben6 != null) {
                    ben6.aCD = false;
                    ben2 = ben.a(ben2, ben6);
                }
                ben3 = ben2;
                continue;
            }
            if (ben7 != null && ben7.aCD) {
                ben7.aCD = false;
                ben6.aCD = true;
                ben2 = ben.b(ben2, ben6);
                ben6 = ben3.aCz;
                ben ben11 = ben7 = ben6 == null ? null : ben6.aCA;
            }
            if (ben7 == null) {
                ben3 = ben6;
                continue;
            }
            ben5 = ben7.aCA;
            ben4 = ben7.aCB;
            if (!(ben5 != null && ben5.aCD || ben4 != null && ben4.aCD)) {
                ben7.aCD = true;
                ben3 = ben6;
                continue;
            }
            if (ben5 == null || !ben5.aCD) {
                if (ben4 != null) {
                    ben4.aCD = false;
                }
                ben7.aCD = true;
                ben2 = ben.a(ben2, ben7);
                ben6 = ben3.aCz;
                ben ben12 = ben7 = ben6 == null ? null : ben6.aCA;
            }
            if (ben7 != null) {
                ben7.aCD = ben6 == null ? false : ben6.aCD;
                ben5 = ben7.aCA;
                if (ben5 != null) {
                    ben5.aCD = false;
                }
            }
            if (ben6 != null) {
                ben6.aCD = false;
                ben2 = ben.b(ben2, ben6);
            }
            ben3 = ben2;
        }
        return ben2;
    }

    static boolean a(ben ben2) {
        ben ben3 = ben2.aCz;
        ben ben4 = ben2.aCA;
        ben ben5 = ben2.aCB;
        ben ben6 = ben2.aCC;
        ben ben7 = (ben)ben2.aCo;
        if (ben6 != null && ben6.aCo != ben2) {
            return false;
        }
        if (ben7 != null && ben7.aCC != ben2) {
            return false;
        }
        if (ben3 != null && ben2 != ben3.aCA && ben2 != ben3.aCB) {
            return false;
        }
        if (ben4 != null && (ben4.aCz != ben2 || ben4.aCx > ben2.aCx)) {
            return false;
        }
        if (ben5 != null && (ben5.aCz != ben2 || ben5.aCx < ben2.aCx)) {
            return false;
        }
        if (ben2.aCD && ben4 != null && ben4.aCD && ben5 != null && ben5.aCD) {
            return false;
        }
        if (ben4 != null && !ben.a(ben4)) {
            return false;
        }
        return ben5 == null || ben.a(ben5);
    }

    static {
        aCE = !bec.class.desiredAssertionStatus();
    }
}
