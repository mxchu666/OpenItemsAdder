package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bbj;
import itemsadder.m.bfs;
import itemsadder.m.bft;
import itemsadder.m.bfu;
import itemsadder.m.bfv;
import itemsadder.m.bfw;
import itemsadder.m.bfx;
import itemsadder.m.bfy;
import itemsadder.m.bfz;
import itemsadder.m.bga;
import itemsadder.m.bgb;
import itemsadder.m.bgc;
import itemsadder.m.bgd;
import itemsadder.m.bge;
import itemsadder.m.bgf;
import itemsadder.m.bgg;
import itemsadder.m.bgh;
import itemsadder.m.bgi;
import itemsadder.m.bgj;
import itemsadder.m.bgk;
import itemsadder.m.bgl;
import itemsadder.m.bgm;
import itemsadder.m.bgo;
import itemsadder.m.bgq;
import itemsadder.m.bgr;
import itemsadder.m.bgs;
import itemsadder.m.bgt;
import itemsadder.m.bgu;
import itemsadder.m.bgv;
import itemsadder.m.bgw;
import itemsadder.m.bgx;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class bfr {
    private final Plugin aDr;
    public boolean aDs;
    static List aDt;
    static final String aDu;
    static final String aDv;
    static final String aDw;
    static final String aDx;
    static final String aDy;
    static final String aDz;
    static final String aDA;
    static final String aDB;
    static final String aDC;
    static final String aDD;
    static Object aDE;
    static Object aDF;

    public bfr(Plugin plugin) {
        this.aDr = plugin;
    }

    public void a() {
        this.R(this.EM());
    }

    void R(List list) {
        block5: {
            try {
                String string = this.EO();
                String string2 = new bgr(this).toString();
                String string3 = new bgs(this).toString();
                Class<?> clazz = Class.forName(string);
                Method method = clazz.getMethod(string2, new Class[0]);
                Object object = method.invoke((Object)this, new Object[0]);
                try {
                    if (list.contains(object) || !bfr.jk(this.e()) || this.e().isEmpty() || this.e().equals(" ")) {
                        method = clazz.getMethod(string3, Boolean.TYPE);
                        method.invoke((Object)this, true);
                        break block5;
                    }
                    method = clazz.getMethod(string3, Boolean.TYPE);
                    method.invoke((Object)this, false);
                }
                catch (NullPointerException nullPointerException) {
                    method = clazz.getMethod(string3, Boolean.TYPE);
                    method.invoke((Object)this, true);
                }
            }
            catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
                this.z();
            }
        }
    }

    List EM() {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            String string = new bgt(this).toString();
            String string2 = new bgu(this).toString();
            String string3 = new bgv(this).toString();
            String string4 = new bgw(this).toString();
            String string5 = new bft(this).toString();
            String string6 = new bfu(this).toString();
            String string7 = new bfv(this).toString();
            try {
                Class<?> clazz = Class.forName(string2);
                Class<?> clazz2 = Class.forName(string3);
                Class<?> clazz3 = Class.forName(string4);
                try {
                    Constructor<?> constructor = clazz.getConstructor(String.class);
                    Object obj = constructor.newInstance(string);
                    Method method = clazz.getDeclaredMethod(string5, new Class[0]);
                    Constructor<?> constructor2 = clazz2.getConstructor(clazz3);
                    Object obj2 = constructor2.newInstance(method.invoke(obj, new Object[0]));
                    Method method2 = clazz2.getDeclaredMethod(string6, new Class[0]);
                    Method method3 = clazz2.getDeclaredMethod(string7, new Class[0]);
                    while (((Boolean)method2.invoke(obj2, new Object[0])).booleanValue()) {
                        arrayList.add((String)method3.invoke(obj2, new Object[0]));
                    }
                }
                catch (InvocationTargetException invocationTargetException) {
                }
            }
            catch (ClassNotFoundException | InstantiationException | NoSuchMethodException | SecurityException exception) {
                this.z();
                exception.printStackTrace();
            }
        }
        catch (IllegalAccessException | IllegalArgumentException exception) {
            // empty catch block
        }
        return arrayList;
    }

    public String e() {
        try {
            String string = new bfw(this).toString();
            Class<?> clazz = Class.forName(aDu + string);
            return (String)clazz.getField(aDv).get(null);
        }
        catch (Exception exception) {
            return "q";
        }
    }

    public void f(boolean bl) {
        this.aDs = bl;
        if (this.aDs) {
            bfr.q();
            this.z();
        }
    }

    public static void q() {
        Random random = new Random();
        String[] stringArray = bbj.azW;
        Logger logger = Logger.getLogger("");
        logger.warning(stringArray[random.nextInt(stringArray.length)]);
        int n = random.nextInt(42);
        for (int i = 0; i < 35 + n; ++i) {
            int n2 = new Random().nextInt(6658);
            String string = bfr.j();
            String string2 = bfr.p(string);
            String[] stringArray2 = string.split("\\.");
            String string3 = stringArray2[stringArray2.length - 1];
            String string4 = string.replace((CharSequence)aDF, "");
            logger.warning("\t" + String.valueOf(aDE) + " " + string4 + "." + string2 + "(" + string3 + ":" + n2 + ")");
        }
    }

    public static String p(String string) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(string);
            Method[] methodArray = clazz.getDeclaredMethods();
            return Arrays.asList(methodArray).get(new Random().nextInt(methodArray.length)).getName();
        }
        catch (ClassNotFoundException | IllegalArgumentException exception) {
            return "a";
        }
    }

    static String j() {
        bfr.x();
        return (String)aDt.get(new Random().nextInt(aDt.size()));
    }

    static void x() {
        if (aDt != null) {
            return;
        }
        aDt = new ArrayList();
        CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
        if (codeSource != null) {
            URL uRL = codeSource.getLocation();
            ZipInputStream zipInputStream = null;
            try {
                ZipEntry zipEntry;
                zipInputStream = new ZipInputStream(uRL.openStream());
                while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                    String string = zipEntry.getName();
                    if (!string.endsWith(".class")) continue;
                    aDt.add(string.replace("\\", ".").replace("/", "."));
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public boolean EN() {
        return this.aDs;
    }

    public void z() {
        Bukkit.getScheduler().runTask(this.aDr, () -> {
            String string = new bgf(this).toString();
            String string2 = new bgg(this).toString();
            String string3 = new bgh(this).toString();
            String string4 = new bgi(this).toString();
            String string5 = new bgj(this).toString();
            String string6 = new bgk(this).toString();
            String string7 = new bgl(this).toString();
            try {
                Class<?> clazz = Class.forName(string);
                Class<?> clazz2 = Class.forName(string2);
                Class<?> clazz3 = Class.forName(string3);
                Class<?> clazz4 = Class.forName(string4);
                Method method = clazz.getDeclaredMethod(string5, new Class[0]);
                Method method2 = clazz2.getDeclaredMethod(string6, new Class[0]);
                Method method3 = clazz3.getDeclaredMethod(string7, clazz4);
                Object object = method.invoke((Object)string, new Object[0]);
                Object object2 = method2.invoke(object, new Object[0]);
                method3.invoke(object2, this.aDr);
            }
            catch (Exception exception) {
                // empty catch block
            }
        });
    }

    String EO() {
        try {
            return (String)bgx.u(this.getClass());
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

    public static boolean jk(String string) {
        return string.matches("\\d+");
    }

    static {
        aDu = new bfs().toString();
        aDv = new bgd().toString();
        aDw = new bgq().toString();
        aDx = new bfx().toString();
        aDy = new bfy().toString();
        aDz = new bfz().toString();
        aDA = new bga().toString();
        aDB = new bgb().toString();
        aDC = new bgc().toString();
        aDD = new bge().toString();
        aDE = new bgm().EQ();
        aDF = new bgo().EQ();
    }
}
