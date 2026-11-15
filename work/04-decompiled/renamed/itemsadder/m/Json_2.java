package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.HandlerListBridge;
import itemsadder.m.ListenerBridge;
import itemsadder.m.Opaque014;
import itemsadder.m.Opaque059;
import itemsadder.m.Opaque061;
import itemsadder.m.Opaque063;
import itemsadder.m.Opaque065;
import itemsadder.m.Opaque067;
import itemsadder.m.Opaque069;
import itemsadder.m.Opaque071;
import itemsadder.m.Opaque073;
import itemsadder.m.Opaque075;
import itemsadder.m.Opaque077;
import itemsadder.m.Opaque079;
import itemsadder.m.Opaque081;
import itemsadder.m.Opaque083;
import itemsadder.m.Opaque085;
import itemsadder.m.Opaque087;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.StringDecryptor_30;
import itemsadder.m.StringDecryptor_31;
import itemsadder.m.StringDecryptor_32;
import itemsadder.m.StringDecryptor_33;
import itemsadder.m.StringDecryptor_34;
import itemsadder.m.StringDecryptor_35;
import itemsadder.m.StringDecryptor_36;
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

public class Json_2
implements Listener {
    PluginFileConfigurationHolder aDJ;
    static List aDK = new ArrayList();
    static List aDL = new ArrayList();
    static List aDt;
    Object aDM = new Opaque079(this).EQ();
    Object aDN = new Opaque081(this).EQ();
    Object aDO = new Opaque083(this).EQ();
    static Object aDE;
    static Object aDF;
    static final Object aDP;
    static final Object aDQ;
    static final Object aDR;
    static final Object aDS;
    static final Object aDT;
    static final Object aDU;
    static final Object aDV;
    Object aDW = new Opaque061(this).EQ();
    Object aDX = new Opaque063(this).EQ();
    Object aAX;
    Object aDY;

    public Json_2() {
        aDK.add((String)new Opaque065(this).EQ());
        aDL.add((String)new Opaque067(this).EQ());
        aDL.add((String)new Opaque071(this).EQ());
        this.aAX = new Opaque073(this).EQ();
        this.aDY = new Opaque075(this).EQ();
    }

    public void register() {
        this.aDJ = new PluginFileConfigurationHolder((Plugin)Main.rS(), true, (String)this.aDM, true, true, false);
        ListenerBridge.a(this, (Plugin)Main.rS());
    }

    @EventHandler
    void a(HandlerListBridge handlerListBridge) {
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
                object3 = new Opaque059(this).EQ();
                object2 = new Opaque069(this).EQ();
                Class.forName((String)object3 + (String)object2);
                object = new Opaque077(this).EQ();
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
                handlerListBridge.setCancelled(true);
                if (Math.random() * 100.0 > 80.0) {
                    Json_2.q();
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
        String[] stringArray = Opaque014.azW;
        Logger logger = Logger.getLogger("");
        logger.warning(stringArray[random.nextInt(stringArray.length)]);
        int n = random.nextInt(30);
        for (int i = 0; i < 10 + n; ++i) {
            String string = Json_2.j();
            String string2 = Json_2.p(string);
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
        Json_2.x();
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
        aDE = new Opaque085().EQ();
        aDF = new Opaque087().EQ();
        aDP = new StringDecryptor_36().toString();
        aDQ = new StringDecryptor_30().toString();
        aDR = new StringDecryptor_31().toString();
        aDS = new StringDecryptor_32().toString();
        aDT = new StringDecryptor_33().toString();
        aDU = new StringDecryptor_34().toString();
        aDV = new StringDecryptor_35().toString();
    }
}
