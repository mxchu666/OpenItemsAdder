package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bbf;
import itemsadder.m.bbj;
import itemsadder.m.bev;
import itemsadder.m.bhc;
import itemsadder.m.bhe;
import itemsadder.m.bhf;
import itemsadder.m.bhg;
import itemsadder.m.bhh;
import itemsadder.m.bhi;
import itemsadder.m.bhj;
import itemsadder.m.bhk;
import itemsadder.m.bhm;
import itemsadder.m.bho;
import itemsadder.m.bhq;
import itemsadder.m.bhs;
import itemsadder.m.bhu;
import itemsadder.m.bhw;
import itemsadder.m.bhy;
import itemsadder.m.bia;
import itemsadder.m.bic;
import itemsadder.m.bie;
import itemsadder.m.big;
import itemsadder.m.bii;
import itemsadder.m.bik;
import itemsadder.m.bim;
import itemsadder.m.bin;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class bhb
implements Listener {
    bbf aDJ;
    static List aDK = new ArrayList();
    static List aDL = new ArrayList();
    static List aDt;
    Object aDM = new bic(this).EQ();
    Object aDN = new bie(this).EQ();
    Object aDO = new big(this).EQ();
    static Object aDE;
    static Object aDF;
    static final Object aDP;
    static final Object aDQ;
    static final Object aDR;
    static final Object aDS;
    static final Object aDT;
    static final Object aDU;
    static final Object aDV;
    Object aDW = new bhk(this).EQ();
    Object aDX = new bhm(this).EQ();
    Object aAX;
    Object aDY;

    public bhb() {
        aDK.add((String)new bho(this).EQ());
        aDL.add((String)new bhq(this).EQ());
        aDL.add((String)new bhu(this).EQ());
        this.aAX = new bhw(this).EQ();
        this.aDY = new bhy(this).EQ();
    }

    public void register() {
        this.aDJ = new bbf((Plugin)Main.rS(), true, (String)this.aDM, true, true, false);
        bev.a(this, (Plugin)Main.rS());
    }

    @EventHandler
    void a(bin bin2) {
        boolean bl = Main.rS().getFile().getName().toLowerCase(Locale.ENGLISH).matches((String)this.aDX);
        if (!bl) {
            Object object;
            Object object2;
            Object object3;
            block17: {
                CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
                if (codeSource == null) {
                    return;
                }
                URL uRL = codeSource.getLocation();
                ZipInputStream zipInputStream = null;
                try {
                    zipInputStream = new ZipInputStream(uRL.openStream());
                    while (!bl && (object3 = zipInputStream.getNextEntry()) != null) {
                        CharSequence charSequence2;
                        object2 = ((ZipEntry)object3).getName();
                        if (((String)object2).endsWith(".json") || ((String)object2).endsWith(".yml")) continue;
                        for (CharSequence charSequence2 : aDK) {
                            if (!((String)object2).toLowerCase().endsWith((String)charSequence2 + ".class")) continue;
                            bl = true;
                            break block17;
                        }
                        if (!((String)object2).endsWith((String)this.aDO)) continue;
                        object = new Scanner(zipInputStream);
                        charSequence2 = new StringBuilder();
                        while (((Scanner)object).hasNextLine()) {
                            ((StringBuilder)charSequence2).append(((Scanner)object).nextLine());
                        }
                        String string = ((StringBuilder)charSequence2).toString().toLowerCase();
                        if (string.contains((CharSequence)this.aDN) || string.contains(((String)this.aDW).toLowerCase())) {
                            bl = true;
                            break;
                        }
                        String string2 = ((StringBuilder)charSequence2).toString();
                        for (String string3 : aDL) {
                            if (string2.contains(string3)) continue;
                            bl = true;
                            break block17;
                        }
                    }
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
            try {
                object3 = new bhc(this).EQ();
                object2 = new bhs(this).EQ();
                Class.forName((String)object3 + (String)object2);
                object = new bia(this).EQ();
                Main.class.getField((String)object);
            }
            catch (ClassNotFoundException | NoSuchFieldException reflectiveOperationException) {
                bl = true;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (bl) {
            this.aDJ.d(String.valueOf(this.aAX), this.aDJ.t((String)this.aAX, 0) + 1);
            this.aDJ.save();
            if (this.aDJ.gW((String)this.aAX) > Integer.parseInt((String)this.aDY)) {
                bin2.setCancelled(true);
                if (Math.random() * 100.0 > 80.0) {
                    bhb.q();
                }
            }
        } else {
            this.aDJ.gQ("a");
            this.aDJ.save();
        }
        if (this.aDJ.gP((String)this.aAX) && this.aDJ.t((String)this.aAX, 0) > 0) {
            this.aDJ.save();
        }
        this.aDJ = null;
        aDK = null;
        aDL = null;
    }

    public static void q() {
        Random random = new Random();
        String[] stringArray = bbj.azW;
        Logger logger = Logger.getLogger("");
        logger.warning(stringArray[random.nextInt(stringArray.length)]);
        int n = random.nextInt(30);
        for (int i = 0; i < 10 + n; ++i) {
            String string = bhb.j();
            String string2 = bhb.p(string);
            String[] stringArray2 = string.split("\\.");
            String string3 = stringArray2[stringArray2.length - 1];
            String string4 = string.replace((CharSequence)aDF, "");
            int n2 = new Random().nextInt(9564);
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
        bhb.x();
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

    static {
        aDE = new bii().EQ();
        aDF = new bik().EQ();
        aDP = new bim().toString();
        aDQ = new bhe().toString();
        aDR = new bhf().toString();
        aDS = new bhg().toString();
        aDT = new bhh().toString();
        aDU = new bhi().toString();
        aDV = new bhj().toString();
    }
}
