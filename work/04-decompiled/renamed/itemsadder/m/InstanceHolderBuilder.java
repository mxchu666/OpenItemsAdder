package itemsadder.m;

import itemsadder.m.Implemented_2;
import itemsadder.m.InstanceHolder_5;
import itemsadder.m.InstanceHolder_6;

final class InstanceHolderBuilder
extends InstanceHolder_5 {
    InstanceHolderBuilder aCz;
    InstanceHolderBuilder aCA;
    InstanceHolderBuilder aCB;
    InstanceHolderBuilder aCC;
    boolean aCD;
    static final /* synthetic */ boolean aCE;

    InstanceHolderBuilder(int n, Object object, Object object2, InstanceHolder_6 instanceHolder_6) {
        super(n, object, object2, instanceHolder_6);
    }

    final InstanceHolderBuilder Eg() {
        InstanceHolderBuilder instanceHolderBuilder = this;
        InstanceHolderBuilder instanceHolderBuilder2;
        while ((instanceHolderBuilder2 = instanceHolderBuilder.aCz) != null) {
            instanceHolderBuilder = instanceHolderBuilder2;
        }
        return instanceHolderBuilder;
    }

    static void a(InstanceHolder_6[] instanceHolder_6Array, InstanceHolderBuilder instanceHolderBuilder) {
        int n;
        if (instanceHolderBuilder != null && instanceHolder_6Array != null && (n = instanceHolder_6Array.length) > 0) {
            int n2 = n - 1 & instanceHolderBuilder.aCx;
            InstanceHolderBuilder instanceHolderBuilder2 = (InstanceHolderBuilder)instanceHolder_6Array[n2];
            if (instanceHolderBuilder != instanceHolderBuilder2) {
                instanceHolder_6Array[n2] = instanceHolderBuilder;
                InstanceHolderBuilder instanceHolderBuilder3 = instanceHolderBuilder.aCC;
                InstanceHolder_6 instanceHolder_6 = instanceHolderBuilder.aCo;
                if (instanceHolder_6 != null) {
                    ((InstanceHolderBuilder)instanceHolder_6).aCC = instanceHolderBuilder3;
                }
                if (instanceHolderBuilder3 != null) {
                    instanceHolderBuilder3.aCo = instanceHolder_6;
                }
                if (instanceHolderBuilder2 != null) {
                    instanceHolderBuilder2.aCC = instanceHolderBuilder;
                }
                instanceHolderBuilder.aCo = instanceHolderBuilder2;
                instanceHolderBuilder.aCC = null;
            }
            if (!aCE && !InstanceHolderBuilder.a(instanceHolderBuilder)) {
                throw new AssertionError();
            }
        }
    }

    final InstanceHolderBuilder a(int n, Object object, Class clazz) {
        InstanceHolderBuilder instanceHolderBuilder = this;
        do {
            int n2;
            InstanceHolderBuilder instanceHolderBuilder2 = instanceHolderBuilder.aCA;
            InstanceHolderBuilder instanceHolderBuilder3 = instanceHolderBuilder.aCB;
            int n3 = instanceHolderBuilder.aCx;
            if (n3 > n) {
                instanceHolderBuilder = instanceHolderBuilder2;
                continue;
            }
            if (n3 < n) {
                instanceHolderBuilder = instanceHolderBuilder3;
                continue;
            }
            Object object2 = instanceHolderBuilder.aCy;
            if (object2 == object || object != null && object.equals(object2)) {
                return instanceHolderBuilder;
            }
            if (instanceHolderBuilder2 == null) {
                instanceHolderBuilder = instanceHolderBuilder3;
                continue;
            }
            if (instanceHolderBuilder3 == null) {
                instanceHolderBuilder = instanceHolderBuilder2;
                continue;
            }
            if ((clazz != null || (clazz = object != null ? object.getClass() : null) != null) && (n2 = Implemented_2.f(object, object2)) != 0) {
                instanceHolderBuilder = n2 < 0 ? instanceHolderBuilder2 : instanceHolderBuilder3;
                continue;
            }
            InstanceHolderBuilder instanceHolderBuilder4 = instanceHolderBuilder3.a(n, object, clazz);
            if (instanceHolderBuilder4 != null) {
                return instanceHolderBuilder4;
            }
            instanceHolderBuilder = instanceHolderBuilder2;
        } while (instanceHolderBuilder != null);
        return null;
    }

    final InstanceHolderBuilder a(int n, Object object) {
        return (this.aCz != null ? this.Eg() : this).a(n, object, null);
    }

    static int g(Object object, Object object2) {
        int n;
        if (object == null || object2 == null || (n = object.getClass().getName().compareTo(object2.getClass().getName())) == 0) {
            n = System.identityHashCode(object) <= System.identityHashCode(object2) ? -1 : 1;
        }
        return n;
    }

    final void a(InstanceHolder_6[] instanceHolder_6Array) {
        InstanceHolderBuilder instanceHolderBuilder = null;
        InstanceHolderBuilder instanceHolderBuilder2 = this;
        while (instanceHolderBuilder2 != null) {
            InstanceHolderBuilder instanceHolderBuilder3 = (InstanceHolderBuilder)instanceHolderBuilder2.aCo;
            instanceHolderBuilder2.aCB = null;
            instanceHolderBuilder2.aCA = null;
            if (instanceHolderBuilder == null) {
                instanceHolderBuilder2.aCz = null;
                instanceHolderBuilder2.aCD = false;
                instanceHolderBuilder = instanceHolderBuilder2;
            } else {
                InstanceHolderBuilder instanceHolderBuilder4;
                int n;
                Object object = instanceHolderBuilder2.aCy;
                int n2 = instanceHolderBuilder2.aCx;
                Class<?> clazz = null;
                InstanceHolderBuilder instanceHolderBuilder5 = instanceHolderBuilder;
                do {
                    Object object2 = instanceHolderBuilder5.aCy;
                    int n3 = instanceHolderBuilder5.aCx;
                    if (n3 > n2) {
                        n = -1;
                    } else if (n3 < n2) {
                        n = 1;
                    } else if (clazz == null && (clazz = object.getClass()) == null || (n = Implemented_2.f(object, object2)) == 0) {
                        n = InstanceHolderBuilder.g(object, object2);
                    }
                    instanceHolderBuilder4 = instanceHolderBuilder5;
                } while ((instanceHolderBuilder5 = n <= 0 ? instanceHolderBuilder5.aCA : instanceHolderBuilder5.aCB) != null);
                instanceHolderBuilder2.aCz = instanceHolderBuilder4;
                if (n <= 0) {
                    instanceHolderBuilder4.aCA = instanceHolderBuilder2;
                } else {
                    instanceHolderBuilder4.aCB = instanceHolderBuilder2;
                }
                instanceHolderBuilder = InstanceHolderBuilder.c(instanceHolderBuilder, instanceHolderBuilder2);
            }
            instanceHolderBuilder2 = instanceHolderBuilder3;
        }
        InstanceHolderBuilder.a(instanceHolder_6Array, instanceHolderBuilder);
    }

    final InstanceHolder_6 a(Implemented_2 implemented_2) {
        InstanceHolder_6 instanceHolder_6 = null;
        InstanceHolder_6 instanceHolder_62 = null;
        InstanceHolder_6 instanceHolder_63 = this;
        while (instanceHolder_63 != null) {
            InstanceHolder_6 instanceHolder_64 = implemented_2.a(instanceHolder_63, null);
            if (instanceHolder_62 == null) {
                instanceHolder_6 = instanceHolder_64;
            } else {
                instanceHolder_62.aCo = instanceHolder_64;
            }
            instanceHolder_62 = instanceHolder_64;
            instanceHolder_63 = instanceHolder_63.aCo;
        }
        return instanceHolder_6;
    }

    final InstanceHolderBuilder a(Implemented_2 implemented_2, InstanceHolder_6[] instanceHolder_6Array, int n, Object object, Object object2) {
        InstanceHolderBuilder instanceHolderBuilder;
        InstanceHolder_6 instanceHolder_6;
        int n2;
        InstanceHolderBuilder instanceHolderBuilder2;
        Class<?> clazz = null;
        boolean bl = false;
        InstanceHolderBuilder instanceHolderBuilder3 = instanceHolderBuilder2 = this.aCz != null ? this.Eg() : this;
        do {
            int n3;
            if ((n3 = instanceHolderBuilder3.aCx) > n) {
                n2 = -1;
            } else if (n3 < n) {
                n2 = 1;
            } else {
                Object object3 = instanceHolderBuilder3.aCy;
                if (object3 == object || object != null && object.equals(object3)) {
                    return instanceHolderBuilder3;
                }
                if (clazz == null && (clazz = object.getClass()) == null || (n2 = Implemented_2.f(object, object3)) == 0) {
                    if (!bl) {
                        bl = true;
                        instanceHolder_6 = instanceHolderBuilder3.aCA;
                        if (instanceHolder_6 != null && (instanceHolderBuilder = ((InstanceHolderBuilder)instanceHolder_6).a(n, object, clazz)) != null || (instanceHolder_6 = instanceHolderBuilder3.aCB) != null && (instanceHolderBuilder = ((InstanceHolderBuilder)instanceHolder_6).a(n, object, clazz)) != null) {
                            return instanceHolderBuilder;
                        }
                    }
                    n2 = InstanceHolderBuilder.g(object, object3);
                }
            }
            instanceHolderBuilder = instanceHolderBuilder3;
        } while ((instanceHolderBuilder3 = n2 <= 0 ? instanceHolderBuilder3.aCA : instanceHolderBuilder3.aCB) != null);
        instanceHolder_6 = instanceHolderBuilder.aCo;
        InstanceHolderBuilder instanceHolderBuilder4 = implemented_2.b(n, object, object2, instanceHolder_6);
        if (n2 <= 0) {
            instanceHolderBuilder.aCA = instanceHolderBuilder4;
        } else {
            instanceHolderBuilder.aCB = instanceHolderBuilder4;
        }
        instanceHolderBuilder.aCo = instanceHolderBuilder4;
        instanceHolderBuilder4.aCz = instanceHolderBuilder4.aCC = instanceHolderBuilder;
        if (instanceHolder_6 != null) {
            ((InstanceHolderBuilder)instanceHolder_6).aCC = instanceHolderBuilder4;
        }
        InstanceHolderBuilder.a(instanceHolder_6Array, InstanceHolderBuilder.c(instanceHolderBuilder2, instanceHolderBuilder4));
        return null;
    }

    final void a(Implemented_2 implemented_2, InstanceHolder_6[] instanceHolder_6Array, boolean bl) {
        InstanceHolderBuilder instanceHolderBuilder;
        InstanceHolderBuilder instanceHolderBuilder2;
        InstanceHolderBuilder instanceHolderBuilder3;
        InstanceHolderBuilder instanceHolderBuilder4;
        InstanceHolderBuilder instanceHolderBuilder5;
        int n;
        if (instanceHolder_6Array == null || (n = instanceHolder_6Array.length) == 0) {
            return;
        }
        int n2 = n - 1 & this.aCx;
        InstanceHolderBuilder instanceHolderBuilder6 = instanceHolderBuilder5 = (InstanceHolderBuilder)instanceHolder_6Array[n2];
        InstanceHolderBuilder instanceHolderBuilder7 = (InstanceHolderBuilder)this.aCo;
        InstanceHolderBuilder instanceHolderBuilder8 = this.aCC;
        if (instanceHolderBuilder8 == null) {
            instanceHolderBuilder5 = instanceHolderBuilder7;
            instanceHolder_6Array[n2] = instanceHolderBuilder5;
        } else {
            instanceHolderBuilder8.aCo = instanceHolderBuilder7;
        }
        if (instanceHolderBuilder7 != null) {
            instanceHolderBuilder7.aCC = instanceHolderBuilder8;
        }
        if (instanceHolderBuilder5 == null) {
            return;
        }
        if (instanceHolderBuilder6.aCz != null) {
            instanceHolderBuilder6 = instanceHolderBuilder6.Eg();
        }
        if (instanceHolderBuilder6 == null || bl && (instanceHolderBuilder6.aCB == null || (instanceHolderBuilder4 = instanceHolderBuilder6.aCA) == null || instanceHolderBuilder4.aCA == null)) {
            instanceHolder_6Array[n2] = instanceHolderBuilder5.a(implemented_2);
            return;
        }
        InstanceHolderBuilder instanceHolderBuilder9 = this;
        InstanceHolderBuilder instanceHolderBuilder10 = this.aCA;
        InstanceHolderBuilder instanceHolderBuilder11 = this.aCB;
        if (instanceHolderBuilder10 != null && instanceHolderBuilder11 != null) {
            instanceHolderBuilder3 = instanceHolderBuilder11;
            while ((instanceHolderBuilder2 = instanceHolderBuilder3.aCA) != null) {
                instanceHolderBuilder3 = instanceHolderBuilder2;
            }
            boolean bl2 = instanceHolderBuilder3.aCD;
            instanceHolderBuilder3.aCD = instanceHolderBuilder9.aCD;
            instanceHolderBuilder9.aCD = bl2;
            InstanceHolderBuilder instanceHolderBuilder12 = instanceHolderBuilder3.aCB;
            InstanceHolderBuilder instanceHolderBuilder13 = instanceHolderBuilder9.aCz;
            if (instanceHolderBuilder3 == instanceHolderBuilder11) {
                instanceHolderBuilder9.aCz = instanceHolderBuilder3;
                instanceHolderBuilder3.aCB = instanceHolderBuilder9;
            } else {
                InstanceHolderBuilder instanceHolderBuilder14 = instanceHolderBuilder3.aCz;
                instanceHolderBuilder9.aCz = instanceHolderBuilder14;
                if (instanceHolderBuilder9.aCz != null) {
                    if (instanceHolderBuilder3 == instanceHolderBuilder14.aCA) {
                        instanceHolderBuilder14.aCA = instanceHolderBuilder9;
                    } else {
                        instanceHolderBuilder14.aCB = instanceHolderBuilder9;
                    }
                }
                if ((instanceHolderBuilder3.aCB = instanceHolderBuilder11) != null) {
                    instanceHolderBuilder11.aCz = instanceHolderBuilder3;
                }
            }
            instanceHolderBuilder9.aCA = null;
            instanceHolderBuilder9.aCB = instanceHolderBuilder12;
            if (instanceHolderBuilder9.aCB != null) {
                instanceHolderBuilder12.aCz = instanceHolderBuilder9;
            }
            if ((instanceHolderBuilder3.aCA = instanceHolderBuilder10) != null) {
                instanceHolderBuilder10.aCz = instanceHolderBuilder3;
            }
            if ((instanceHolderBuilder3.aCz = instanceHolderBuilder13) == null) {
                instanceHolderBuilder6 = instanceHolderBuilder3;
            } else if (instanceHolderBuilder9 == instanceHolderBuilder13.aCA) {
                instanceHolderBuilder13.aCA = instanceHolderBuilder3;
            } else {
                instanceHolderBuilder13.aCB = instanceHolderBuilder3;
            }
            instanceHolderBuilder = instanceHolderBuilder12 != null ? instanceHolderBuilder12 : instanceHolderBuilder9;
        } else {
            instanceHolderBuilder = instanceHolderBuilder10 != null ? instanceHolderBuilder10 : (instanceHolderBuilder11 != null ? instanceHolderBuilder11 : instanceHolderBuilder9);
        }
        if (instanceHolderBuilder != instanceHolderBuilder9) {
            instanceHolderBuilder.aCz = instanceHolderBuilder9.aCz;
            instanceHolderBuilder3 = instanceHolderBuilder.aCz;
            if (instanceHolderBuilder3 == null) {
                instanceHolderBuilder6 = instanceHolderBuilder;
                instanceHolderBuilder.aCD = false;
            } else if (instanceHolderBuilder9 == instanceHolderBuilder3.aCA) {
                instanceHolderBuilder3.aCA = instanceHolderBuilder;
            } else {
                instanceHolderBuilder3.aCB = instanceHolderBuilder;
            }
            instanceHolderBuilder9.aCz = null;
            instanceHolderBuilder9.aCB = null;
            instanceHolderBuilder9.aCA = null;
        }
        InstanceHolderBuilder instanceHolderBuilder15 = instanceHolderBuilder3 = instanceHolderBuilder9.aCD ? instanceHolderBuilder6 : InstanceHolderBuilder.d(instanceHolderBuilder6, instanceHolderBuilder);
        if (instanceHolderBuilder == instanceHolderBuilder9) {
            instanceHolderBuilder2 = instanceHolderBuilder9.aCz;
            instanceHolderBuilder9.aCz = null;
            if (instanceHolderBuilder2 != null) {
                if (instanceHolderBuilder9 == instanceHolderBuilder2.aCA) {
                    instanceHolderBuilder2.aCA = null;
                } else if (instanceHolderBuilder9 == instanceHolderBuilder2.aCB) {
                    instanceHolderBuilder2.aCB = null;
                }
            }
        }
        if (bl) {
            InstanceHolderBuilder.a(instanceHolder_6Array, instanceHolderBuilder3);
        }
    }

    final void a(Implemented_2 implemented_2, InstanceHolder_6[] instanceHolder_6Array, int n, int n2) {
        InstanceHolderBuilder instanceHolderBuilder = this;
        InstanceHolderBuilder instanceHolderBuilder2 = null;
        InstanceHolderBuilder instanceHolderBuilder3 = null;
        InstanceHolderBuilder instanceHolderBuilder4 = null;
        InstanceHolderBuilder instanceHolderBuilder5 = null;
        int n3 = 0;
        int n4 = 0;
        InstanceHolderBuilder instanceHolderBuilder6 = instanceHolderBuilder;
        while (instanceHolderBuilder6 != null) {
            InstanceHolderBuilder instanceHolderBuilder7 = (InstanceHolderBuilder)instanceHolderBuilder6.aCo;
            instanceHolderBuilder6.aCo = null;
            if ((instanceHolderBuilder6.aCx & n2) == 0) {
                instanceHolderBuilder6.aCC = instanceHolderBuilder3;
                if (instanceHolderBuilder6.aCC == null) {
                    instanceHolderBuilder2 = instanceHolderBuilder6;
                } else {
                    instanceHolderBuilder3.aCo = instanceHolderBuilder6;
                }
                instanceHolderBuilder3 = instanceHolderBuilder6;
                ++n3;
            } else {
                instanceHolderBuilder6.aCC = instanceHolderBuilder5;
                if (instanceHolderBuilder6.aCC == null) {
                    instanceHolderBuilder4 = instanceHolderBuilder6;
                } else {
                    instanceHolderBuilder5.aCo = instanceHolderBuilder6;
                }
                instanceHolderBuilder5 = instanceHolderBuilder6;
                ++n4;
            }
            instanceHolderBuilder6 = instanceHolderBuilder7;
        }
        if (instanceHolderBuilder2 != null) {
            if (n3 <= 6) {
                instanceHolder_6Array[n] = instanceHolderBuilder2.a(implemented_2);
            } else {
                instanceHolder_6Array[n] = instanceHolderBuilder2;
                if (instanceHolderBuilder4 != null) {
                    instanceHolderBuilder2.a(instanceHolder_6Array);
                }
            }
        }
        if (instanceHolderBuilder4 != null) {
            if (n4 <= 6) {
                instanceHolder_6Array[n + n2] = instanceHolderBuilder4.a(implemented_2);
            } else {
                instanceHolder_6Array[n + n2] = instanceHolderBuilder4;
                if (instanceHolderBuilder2 != null) {
                    instanceHolderBuilder4.a(instanceHolder_6Array);
                }
            }
        }
    }

    static InstanceHolderBuilder a(InstanceHolderBuilder instanceHolderBuilder, InstanceHolderBuilder instanceHolderBuilder2) {
        InstanceHolderBuilder instanceHolderBuilder3;
        if (instanceHolderBuilder2 != null && (instanceHolderBuilder3 = instanceHolderBuilder2.aCB) != null) {
            InstanceHolderBuilder instanceHolderBuilder4 = instanceHolderBuilder2.aCB = instanceHolderBuilder3.aCA;
            if (instanceHolderBuilder2.aCB != null) {
                instanceHolderBuilder4.aCz = instanceHolderBuilder2;
            }
            InstanceHolderBuilder instanceHolderBuilder5 = instanceHolderBuilder3.aCz = instanceHolderBuilder2.aCz;
            if (instanceHolderBuilder3.aCz == null) {
                instanceHolderBuilder = instanceHolderBuilder3;
                instanceHolderBuilder3.aCD = false;
            } else if (instanceHolderBuilder5.aCA == instanceHolderBuilder2) {
                instanceHolderBuilder5.aCA = instanceHolderBuilder3;
            } else {
                instanceHolderBuilder5.aCB = instanceHolderBuilder3;
            }
            instanceHolderBuilder3.aCA = instanceHolderBuilder2;
            instanceHolderBuilder2.aCz = instanceHolderBuilder3;
        }
        return instanceHolderBuilder;
    }

    static InstanceHolderBuilder b(InstanceHolderBuilder instanceHolderBuilder, InstanceHolderBuilder instanceHolderBuilder2) {
        InstanceHolderBuilder instanceHolderBuilder3;
        if (instanceHolderBuilder2 != null && (instanceHolderBuilder3 = instanceHolderBuilder2.aCA) != null) {
            InstanceHolderBuilder instanceHolderBuilder4 = instanceHolderBuilder2.aCA = instanceHolderBuilder3.aCB;
            if (instanceHolderBuilder2.aCA != null) {
                instanceHolderBuilder4.aCz = instanceHolderBuilder2;
            }
            InstanceHolderBuilder instanceHolderBuilder5 = instanceHolderBuilder3.aCz = instanceHolderBuilder2.aCz;
            if (instanceHolderBuilder3.aCz == null) {
                instanceHolderBuilder = instanceHolderBuilder3;
                instanceHolderBuilder3.aCD = false;
            } else if (instanceHolderBuilder5.aCB == instanceHolderBuilder2) {
                instanceHolderBuilder5.aCB = instanceHolderBuilder3;
            } else {
                instanceHolderBuilder5.aCA = instanceHolderBuilder3;
            }
            instanceHolderBuilder3.aCB = instanceHolderBuilder2;
            instanceHolderBuilder2.aCz = instanceHolderBuilder3;
        }
        return instanceHolderBuilder;
    }

    static InstanceHolderBuilder c(InstanceHolderBuilder instanceHolderBuilder, InstanceHolderBuilder instanceHolderBuilder2) {
        instanceHolderBuilder2.aCD = true;
        while (true) {
            InstanceHolderBuilder instanceHolderBuilder3;
            InstanceHolderBuilder instanceHolderBuilder4;
            if ((instanceHolderBuilder4 = instanceHolderBuilder2.aCz) == null) {
                instanceHolderBuilder2.aCD = false;
                return instanceHolderBuilder2;
            }
            if (!instanceHolderBuilder4.aCD || (instanceHolderBuilder3 = instanceHolderBuilder4.aCz) == null) {
                return instanceHolderBuilder;
            }
            InstanceHolderBuilder instanceHolderBuilder5 = instanceHolderBuilder3.aCA;
            if (instanceHolderBuilder4 == instanceHolderBuilder5) {
                InstanceHolderBuilder instanceHolderBuilder6 = instanceHolderBuilder3.aCB;
                if (instanceHolderBuilder6 != null && instanceHolderBuilder6.aCD) {
                    instanceHolderBuilder6.aCD = false;
                    instanceHolderBuilder4.aCD = false;
                    instanceHolderBuilder3.aCD = true;
                    instanceHolderBuilder2 = instanceHolderBuilder3;
                    continue;
                }
                if (instanceHolderBuilder2 == instanceHolderBuilder4.aCB) {
                    instanceHolderBuilder2 = instanceHolderBuilder4;
                    instanceHolderBuilder = InstanceHolderBuilder.a(instanceHolderBuilder, instanceHolderBuilder2);
                    instanceHolderBuilder4 = instanceHolderBuilder2.aCz;
                    InstanceHolderBuilder instanceHolderBuilder7 = instanceHolderBuilder3 = instanceHolderBuilder4 == null ? null : instanceHolderBuilder4.aCz;
                }
                if (instanceHolderBuilder4 == null) continue;
                instanceHolderBuilder4.aCD = false;
                if (instanceHolderBuilder3 == null) continue;
                instanceHolderBuilder3.aCD = true;
                instanceHolderBuilder = InstanceHolderBuilder.b(instanceHolderBuilder, instanceHolderBuilder3);
                continue;
            }
            if (instanceHolderBuilder5 != null && instanceHolderBuilder5.aCD) {
                instanceHolderBuilder5.aCD = false;
                instanceHolderBuilder4.aCD = false;
                instanceHolderBuilder3.aCD = true;
                instanceHolderBuilder2 = instanceHolderBuilder3;
                continue;
            }
            if (instanceHolderBuilder2 == instanceHolderBuilder4.aCA) {
                instanceHolderBuilder2 = instanceHolderBuilder4;
                instanceHolderBuilder = InstanceHolderBuilder.b(instanceHolderBuilder, instanceHolderBuilder2);
                instanceHolderBuilder4 = instanceHolderBuilder2.aCz;
                InstanceHolderBuilder instanceHolderBuilder8 = instanceHolderBuilder3 = instanceHolderBuilder4 == null ? null : instanceHolderBuilder4.aCz;
            }
            if (instanceHolderBuilder4 == null) continue;
            instanceHolderBuilder4.aCD = false;
            if (instanceHolderBuilder3 == null) continue;
            instanceHolderBuilder3.aCD = true;
            instanceHolderBuilder = InstanceHolderBuilder.a(instanceHolderBuilder, instanceHolderBuilder3);
        }
    }

    static InstanceHolderBuilder d(InstanceHolderBuilder instanceHolderBuilder, InstanceHolderBuilder instanceHolderBuilder2) {
        while (instanceHolderBuilder2 != null && instanceHolderBuilder2 != instanceHolderBuilder) {
            InstanceHolderBuilder instanceHolderBuilder3;
            InstanceHolderBuilder instanceHolderBuilder4;
            InstanceHolderBuilder instanceHolderBuilder5 = instanceHolderBuilder2.aCz;
            if (instanceHolderBuilder5 == null) {
                instanceHolderBuilder2.aCD = false;
                return instanceHolderBuilder2;
            }
            if (instanceHolderBuilder2.aCD) {
                instanceHolderBuilder2.aCD = false;
                return instanceHolderBuilder;
            }
            InstanceHolderBuilder instanceHolderBuilder6 = instanceHolderBuilder5.aCA;
            if (instanceHolderBuilder6 == instanceHolderBuilder2) {
                InstanceHolderBuilder instanceHolderBuilder7 = instanceHolderBuilder5.aCB;
                if (instanceHolderBuilder7 != null && instanceHolderBuilder7.aCD) {
                    instanceHolderBuilder7.aCD = false;
                    instanceHolderBuilder5.aCD = true;
                    instanceHolderBuilder = InstanceHolderBuilder.a(instanceHolderBuilder, instanceHolderBuilder5);
                    instanceHolderBuilder5 = instanceHolderBuilder2.aCz;
                    InstanceHolderBuilder instanceHolderBuilder8 = instanceHolderBuilder7 = instanceHolderBuilder5 == null ? null : instanceHolderBuilder5.aCB;
                }
                if (instanceHolderBuilder7 == null) {
                    instanceHolderBuilder2 = instanceHolderBuilder5;
                    continue;
                }
                instanceHolderBuilder4 = instanceHolderBuilder7.aCA;
                instanceHolderBuilder3 = instanceHolderBuilder7.aCB;
                if (!(instanceHolderBuilder3 != null && instanceHolderBuilder3.aCD || instanceHolderBuilder4 != null && instanceHolderBuilder4.aCD)) {
                    instanceHolderBuilder7.aCD = true;
                    instanceHolderBuilder2 = instanceHolderBuilder5;
                    continue;
                }
                if (instanceHolderBuilder3 == null || !instanceHolderBuilder3.aCD) {
                    if (instanceHolderBuilder4 != null) {
                        instanceHolderBuilder4.aCD = false;
                    }
                    instanceHolderBuilder7.aCD = true;
                    instanceHolderBuilder = InstanceHolderBuilder.b(instanceHolderBuilder, instanceHolderBuilder7);
                    instanceHolderBuilder5 = instanceHolderBuilder2.aCz;
                    InstanceHolderBuilder instanceHolderBuilder9 = instanceHolderBuilder7 = instanceHolderBuilder5 == null ? null : instanceHolderBuilder5.aCB;
                }
                if (instanceHolderBuilder7 != null) {
                    instanceHolderBuilder7.aCD = instanceHolderBuilder5 == null ? false : instanceHolderBuilder5.aCD;
                    instanceHolderBuilder3 = instanceHolderBuilder7.aCB;
                    if (instanceHolderBuilder3 != null) {
                        instanceHolderBuilder3.aCD = false;
                    }
                }
                if (instanceHolderBuilder5 != null) {
                    instanceHolderBuilder5.aCD = false;
                    instanceHolderBuilder = InstanceHolderBuilder.a(instanceHolderBuilder, instanceHolderBuilder5);
                }
                instanceHolderBuilder2 = instanceHolderBuilder;
                continue;
            }
            if (instanceHolderBuilder6 != null && instanceHolderBuilder6.aCD) {
                instanceHolderBuilder6.aCD = false;
                instanceHolderBuilder5.aCD = true;
                instanceHolderBuilder = InstanceHolderBuilder.b(instanceHolderBuilder, instanceHolderBuilder5);
                instanceHolderBuilder5 = instanceHolderBuilder2.aCz;
                InstanceHolderBuilder instanceHolderBuilder10 = instanceHolderBuilder6 = instanceHolderBuilder5 == null ? null : instanceHolderBuilder5.aCA;
            }
            if (instanceHolderBuilder6 == null) {
                instanceHolderBuilder2 = instanceHolderBuilder5;
                continue;
            }
            instanceHolderBuilder4 = instanceHolderBuilder6.aCA;
            instanceHolderBuilder3 = instanceHolderBuilder6.aCB;
            if (!(instanceHolderBuilder4 != null && instanceHolderBuilder4.aCD || instanceHolderBuilder3 != null && instanceHolderBuilder3.aCD)) {
                instanceHolderBuilder6.aCD = true;
                instanceHolderBuilder2 = instanceHolderBuilder5;
                continue;
            }
            if (instanceHolderBuilder4 == null || !instanceHolderBuilder4.aCD) {
                if (instanceHolderBuilder3 != null) {
                    instanceHolderBuilder3.aCD = false;
                }
                instanceHolderBuilder6.aCD = true;
                instanceHolderBuilder = InstanceHolderBuilder.a(instanceHolderBuilder, instanceHolderBuilder6);
                instanceHolderBuilder5 = instanceHolderBuilder2.aCz;
                InstanceHolderBuilder instanceHolderBuilder11 = instanceHolderBuilder6 = instanceHolderBuilder5 == null ? null : instanceHolderBuilder5.aCA;
            }
            if (instanceHolderBuilder6 != null) {
                instanceHolderBuilder6.aCD = instanceHolderBuilder5 == null ? false : instanceHolderBuilder5.aCD;
                instanceHolderBuilder4 = instanceHolderBuilder6.aCA;
                if (instanceHolderBuilder4 != null) {
                    instanceHolderBuilder4.aCD = false;
                }
            }
            if (instanceHolderBuilder5 != null) {
                instanceHolderBuilder5.aCD = false;
                instanceHolderBuilder = InstanceHolderBuilder.b(instanceHolderBuilder, instanceHolderBuilder5);
            }
            instanceHolderBuilder2 = instanceHolderBuilder;
        }
        return instanceHolderBuilder;
    }

    static boolean a(InstanceHolderBuilder instanceHolderBuilder) {
        InstanceHolderBuilder instanceHolderBuilder2 = instanceHolderBuilder.aCz;
        InstanceHolderBuilder instanceHolderBuilder3 = instanceHolderBuilder.aCA;
        InstanceHolderBuilder instanceHolderBuilder4 = instanceHolderBuilder.aCB;
        InstanceHolderBuilder instanceHolderBuilder5 = instanceHolderBuilder.aCC;
        InstanceHolderBuilder instanceHolderBuilder6 = (InstanceHolderBuilder)instanceHolderBuilder.aCo;
        if (instanceHolderBuilder5 != null && instanceHolderBuilder5.aCo != instanceHolderBuilder) {
            return false;
        }
        if (instanceHolderBuilder6 != null && instanceHolderBuilder6.aCC != instanceHolderBuilder) {
            return false;
        }
        if (instanceHolderBuilder2 != null && instanceHolderBuilder != instanceHolderBuilder2.aCA && instanceHolderBuilder != instanceHolderBuilder2.aCB) {
            return false;
        }
        if (instanceHolderBuilder3 != null && (instanceHolderBuilder3.aCz != instanceHolderBuilder || instanceHolderBuilder3.aCx > instanceHolderBuilder.aCx)) {
            return false;
        }
        if (instanceHolderBuilder4 != null && (instanceHolderBuilder4.aCz != instanceHolderBuilder || instanceHolderBuilder4.aCx < instanceHolderBuilder.aCx)) {
            return false;
        }
        if (instanceHolderBuilder.aCD && instanceHolderBuilder3 != null && instanceHolderBuilder3.aCD && instanceHolderBuilder4 != null && instanceHolderBuilder4.aCD) {
            return false;
        }
        if (instanceHolderBuilder3 != null && !InstanceHolderBuilder.a(instanceHolderBuilder3)) {
            return false;
        }
        return instanceHolderBuilder4 == null || InstanceHolderBuilder.a(instanceHolderBuilder4);
    }

    static {
        aCE = !Implemented_2.class.desiredAssertionStatus();
    }
}
