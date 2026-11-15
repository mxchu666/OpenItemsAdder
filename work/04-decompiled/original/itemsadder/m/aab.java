package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import itemsadder.m.aai;
import itemsadder.m.abl;
import itemsadder.m.acm;
import itemsadder.m.adc;
import itemsadder.m.adq;
import itemsadder.m.aeh;
import itemsadder.m.afk;
import itemsadder.m.agb;
import itemsadder.m.ahe;
import itemsadder.m.ahu;
import itemsadder.m.aii;
import itemsadder.m.ake;
import itemsadder.m.ana;
import itemsadder.m.aoc;
import itemsadder.m.aor;
import itemsadder.m.apz;
import itemsadder.m.aqo;
import itemsadder.m.arn;
import itemsadder.m.asd;
import itemsadder.m.asf;
import itemsadder.m.aui;
import itemsadder.m.auw;
import itemsadder.m.avl;
import itemsadder.m.awc;
import itemsadder.m.axh;
import itemsadder.m.bce;
import itemsadder.m.zw;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public class aab {
    private static final Map Ve = new HashMap();

    @Nullable
    public static Field a(Class clazz, Class clazz2) {
        return zw.a(clazz, clazz2);
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
        if (aai.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.abi");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.abg");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.abe");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.aaq");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.aao");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.abc");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.aba");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.aay");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.aaw");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.aau");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.aas");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.aam");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.aak");
                default -> null;
            };
        } else if (abl.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.ack");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.aci");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.acg");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.abs");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.abq");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.ace");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.acc");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.aca");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.aby");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.abw");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.abu");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.abo");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.abm");
                default -> null;
            };
        } else if (acm.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.ada");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.acz");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.acy");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.acr");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.acq");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.acx");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.acw");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.acv");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.acu");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.act");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.acs");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.acp");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.aco");
                default -> null;
            };
        } else if (adc.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.adp");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.ado");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.adn");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.adg");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.adf");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.adm");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.adl");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.adk");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.adj");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.adi");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.adh");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.ade");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.add");
                default -> null;
            };
        } else if (adq.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.aef");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.aee");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.aed");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.adw");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.adv");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.aec");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.aeb");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.aea");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.adz");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.ady");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.adx");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.adu");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.adt");
                default -> null;
            };
        } else if (aeh.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.afh");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.aff");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.afd");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.aep");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.aen");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.afb");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.aez");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.aex");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.aev");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.aet");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.aer");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.ael");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.aej");
                default -> null;
            };
        } else if (afk.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.afy");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.afx");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.afw");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.afp");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.afo");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.afv");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.afu");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.aft");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.afs");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.afr");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.afq");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.afn");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.afm");
                default -> null;
            };
        } else if (agb.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.ahb");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.agz");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.agx");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.agj");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.agh");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.agv");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.agt");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.agr");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.agp");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.agn");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.agl");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.agf");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.agd");
                default -> null;
            };
        } else if (ahe.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.ahr");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.ahq");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.ahp");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.ahi");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.ahh");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.aho");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.ahn");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.ahm");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.ahl");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.ahk");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.ahj");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.ahg");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.ahf");
                default -> null;
            };
        } else if (ahu.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.aih");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.aig");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.aif");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.ahy");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.ahx");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.aie");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.aid");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.aic");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.aib");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.aia");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.ahz");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.ahw");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.ahv");
                default -> null;
            };
        } else if (aii.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.ajd");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.ajc");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.ajb");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.aiu");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.ait");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.aja");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.aiz");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.aiy");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.aix");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.aiw");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.aiv");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.ais");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.air");
                default -> null;
            };
        } else if (aoc.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.aoq");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.aop");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.aoo");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.aoh");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.aog");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.aon");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.aom");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.aol");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.aok");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.aoj");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.aoi");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.aof");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.aoe");
                default -> null;
            };
        } else if (aor.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.apx");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.apv");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.apt");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.apf");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.apd");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.apr");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.app");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.apn");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.apl");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.apj");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.aph");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.apb");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.aoz");
                default -> null;
            };
        } else if (apz.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.aqn");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.aqm");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.aql");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.aqe");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.aqd");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.aqk");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.aqj");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.aqi");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.aqh");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.aqg");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.aqf");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.aqc");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.aqb");
                default -> null;
            };
        } else if (aqo.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.ard");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.arc");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.arb");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.aqu");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.aqt");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.ara");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.aqz");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.aqy");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.aqx");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.aqw");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.aqv");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.aqs");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.aqr");
                default -> null;
            };
        } else if (arn.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.asc");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.asb");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.asa");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.art");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.ars");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.arz");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.ary");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.arx");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.arw");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.arv");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.aru");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.arr");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.arq");
                default -> null;
            };
        } else if (ana.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.aoa");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.any");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.anw");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.ani");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.ang");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.anu");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.ans");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.anq");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.ano");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.anm");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.ank");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.ane");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.anc");
                default -> null;
            };
        } else if (asf.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.aue");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.aua");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.atw");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.asu");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.asq");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.ats");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.ato");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.atk");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.atg");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.atc");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.asy");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.asm");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.asi");
                default -> null;
            };
        } else if (aui.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.auv");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.auu");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.aut");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.aum");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.aul");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.aus");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.aur");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.auq");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.aup");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.auo");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.aun");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.auk");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.auj");
                default -> null;
            };
        } else if (auw.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.avk");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.avj");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.avi");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.avb");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.ava");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.avh");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.avg");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.avf");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.ave");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.avd");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.avc");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.auz");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.auy");
                default -> null;
            };
        } else if (avl.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.awa");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.avz");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.avy");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.avr");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.avq");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.avx");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.avw");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.avv");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.avu");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.avt");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.avs");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.avp");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.avo");
                default -> null;
            };
        } else if (awc.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.axf");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.axd");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.axb");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.awn");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.awl");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.awz");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.awx");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.awv");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.awt");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.awr");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.awp");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.awj");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.awh");
                default -> null;
            };
        } else if (axh.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.axx");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.axw");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.axv");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.axo");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.axn");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.axu");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.axt");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.axs");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.axr");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.axq");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.axp");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.axm");
                case Version.v1_20_6 -> Class.forName("itemsadder.m.axl");
                default -> null;
            };
        } else if (ake.class == clazz) {
            clazz2 = switch (version) {
                case Version.v26_2 -> Class.forName("itemsadder.m.amu");
                case Version.v26_1_2 -> Class.forName("itemsadder.m.amo");
                case Version.v26_1_1 -> Class.forName("itemsadder.m.ami");
                case Version.v1_21_11 -> Class.forName("itemsadder.m.aks");
                case Version.v1_21_10 -> Class.forName("itemsadder.m.akm");
                case Version.v1_21_8 -> Class.forName("itemsadder.m.amc");
                case Version.v1_21_7 -> Class.forName("itemsadder.m.alw");
                case Version.v1_21_6 -> Class.forName("itemsadder.m.alq");
                case Version.v1_21_5 -> Class.forName("itemsadder.m.alk");
                case Version.v1_21_4 -> Class.forName("itemsadder.m.ale");
                case Version.v1_21_3 -> Class.forName("itemsadder.m.aky");
                case Version.v1_21_1 -> Class.forName("itemsadder.m.akg");
                case Version.v1_20_6 -> Class.forName("dev.lone.itemsadder.nms.mobgoal.impl.MobGoalNMS_v1_20_6");
                default -> null;
            };
        } else {
            if (asd.class == clazz) {
                throw new RuntimeException("Use RecipePacketHandler instead of IRecipebook!");
            }
            bce.error("Class not found for type: " + clazz.getName());
            bce.error("Maybe not an NMS wrapper class or not implemented yet?");
        }
        return clazz2;
    }

    public static Object n(Class clazz) {
        Class clazz2 = null;
        try {
            clazz2 = aab.m(clazz);
            if (clazz2 == null) {
                bce.error("Can't instantiate NMS wrapper");
                bce.error("This server version is not compatible with this plugin.");
                throw new RuntimeException("Class name not found for type: " + clazz.getName());
            }
            return aab.b(clazz, clazz2);
        }
        catch (Throwable throwable) {
            bce.error("Can't instantiate NMS wrapper");
            bce.error("This server version is not compatible with this plugin.");
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
            clazz2 = aab.m(clazz);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        }
        return aab.b(clazz2, classArray);
    }
}
