package itemsadder.m;

import itemsadder.m.bbe;
import java.awt.Color;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.reflect.FieldUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class bcy {
    public static Random Bl = new Random();
    private static final Pattern aBn = Pattern.compile("%#([A-Fa-f0-9]){6}%");
    private static final Pattern aBo = Pattern.compile("-?\\d+(\\.\\d+)?");
    static LegacyComponentSerializer azG = LegacyComponentSerializer.builder().hexColors().character('\u00a7').build();

    public static String t(double d) {
        return bcy.b(d, false);
    }

    public static String b(double d, boolean bl) {
        return bbe.a(d, bl);
    }

    public static float f(float f, float f2) {
        return Bl.nextFloat() * (f2 - f) + f;
    }

    public static double Ds() {
        return Bl.nextDouble();
    }

    public static int v(int n, int n2) {
        if (n2 == n) {
            return n2;
        }
        return Bl.nextInt(n2 - n + 1) + n;
    }

    public static int a(Random random, int n, int n2) {
        if (n2 == n) {
            return n2;
        }
        return random.nextInt(n2 - n + 1) + n;
    }

    public static boolean bO(int n) {
        int n2 = bcy.v(1, 100);
        return n2 <= n;
    }

    public static boolean j(Player player, String string) {
        if (player.hasPermission(string)) {
            return true;
        }
        return player.isOp();
    }

    public static String iH(String string) {
        return string.replace("\u00a7", "&");
    }

    public static String gH(String object) {
        Matcher matcher = aBn.matcher((CharSequence)object);
        while (matcher.find()) {
            ChatColor chatColor = ChatColor.of((String)matcher.group().substring(1, matcher.group().length() - 1));
            String string = ((String)object).substring(0, matcher.start());
            String string2 = ((String)object).substring(matcher.end());
            object = string + String.valueOf(chatColor) + string2;
            matcher = aBn.matcher((CharSequence)object);
        }
        return ((String)object).replace("&", "\u00a7");
    }

    public static boolean iI(String string) {
        return string.contains("\u00a7([0-fk-or])") || string.contains("&([0-fk-or])");
    }

    public static boolean iJ(String string) {
        if (string == null) {
            return false;
        }
        return aBo.matcher(string).matches();
    }

    public static boolean c(String[] stringArray, int n) {
        if (n > stringArray.length - 1) {
            return false;
        }
        return bcy.iJ(stringArray[n]);
    }

    private static Color iK(String string) {
        try {
            return new Color(Integer.valueOf(string.substring(1, 3), 16), Integer.valueOf(string.substring(3, 5), 16), Integer.valueOf(string.substring(5, 7), 16));
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

    public static org.bukkit.Color iL(String object) {
        if (object == null) {
            return null;
        }
        if (((String)object).endsWith(".0")) {
            object = ((String)object).replace(".0", "");
        }
        object = ((String)object).replace(".", "");
        while (((String)object).length() < 7) {
            object = (String)object + "0";
        }
        if (!((String)object).startsWith("#")) {
            object = "#" + (String)object;
        }
        Color color = bcy.iK((String)object);
        return org.bukkit.Color.fromRGB((int)color.getRed(), (int)color.getGreen(), (int)color.getBlue());
    }

    public static String bP(int n) {
        Color color = new Color(n);
        return bcy.m(color.getRed(), color.getGreen(), color.getBlue());
    }

    public static String a(org.bukkit.Color color, boolean bl) {
        Color color2 = new Color(color.asRGB());
        return bcy.a(color2.getRed(), color2.getGreen(), color2.getBlue(), bl);
    }

    public static String m(int n, int n2, int n3) {
        return bcy.a(n, n2, n3, true);
    }

    public static String a(int n, int n2, int n3, boolean bl) {
        if (bl) {
            return String.format("#%02x%02x%02x", n, n2, n3);
        }
        return String.format("%02x%02x%02x", n, n2, n3);
    }

    public static org.bukkit.Color bQ(int n) {
        Color color = new Color(n);
        return org.bukkit.Color.fromRGB((int)color.getRed(), (int)color.getGreen(), (int)color.getBlue());
    }

    public static int g(float f, float f2) {
        return (int)Math.ceil(f / f2);
    }

    public static ItemStack i(ItemStack itemStack, String string) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(string);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static int w(String string, int n) {
        try {
            return Integer.parseInt(string);
        }
        catch (Throwable throwable) {
            return n;
        }
    }

    public static float b(String string, float f) {
        try {
            return Float.parseFloat(string);
        }
        catch (Throwable throwable) {
            return f;
        }
    }

    public static boolean E(@NotNull String string, boolean bl) {
        if (string.equalsIgnoreCase("true") || string.equalsIgnoreCase("yes") || string.equalsIgnoreCase("1")) {
            return true;
        }
        if (string.equalsIgnoreCase("false") || string.equalsIgnoreCase("no") || string.equalsIgnoreCase("0")) {
            return false;
        }
        return bl;
    }

    public static org.bukkit.Color iM(String object) {
        try {
            return (org.bukkit.Color)FieldUtils.readStaticField(org.bukkit.Color.class, (String)object);
        }
        catch (Exception exception) {
            try {
                if (!bcy.iJ((String)object)) {
                    if (object == null) {
                        return null;
                    }
                    if (((String)object).endsWith(".0")) {
                        object = ((String)object).replace(".0", "");
                    }
                    object = ((String)object).replace(".", "");
                    while (((String)object).length() < 7) {
                        object = (String)object + "0";
                    }
                    if (!((String)object).startsWith("#")) {
                        object = "#" + (String)object;
                    }
                    Color color = bcy.iK((String)object);
                    return org.bukkit.Color.fromRGB((int)color.getRed(), (int)color.getGreen(), (int)color.getBlue());
                }
                org.bukkit.Color.fromBGR((int)Integer.parseInt((String)object));
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            return null;
        }
    }

    public static int iN(String object) {
        if (object == null) {
            return -1;
        }
        object = ((String)object).toUpperCase();
        try {
            return ((org.bukkit.Color)FieldUtils.readStaticField(org.bukkit.Color.class, (String)object)).asRGB();
        }
        catch (Exception exception) {
            try {
                if (!bcy.iJ((String)object)) {
                    if (object == null) {
                        return -1;
                    }
                    if (((String)object).endsWith(".0")) {
                        object = ((String)object).replace(".0", "");
                    }
                    object = ((String)object).replace(".", "");
                    while (((String)object).length() < 7) {
                        object = (String)object + "0";
                    }
                    if (!((String)object).startsWith("#")) {
                        object = "#" + (String)object;
                    }
                    Color color = bcy.iK((String)object);
                    return org.bukkit.Color.fromRGB((int)color.getRed(), (int)color.getGreen(), (int)color.getBlue()).asRGB();
                }
                return Integer.parseInt((String)object);
            }
            catch (Throwable throwable) {
                return -1;
            }
        }
    }

    public static boolean b(int n, int n2, int n3, boolean bl) {
        if (bl) {
            return n >= n2 && n <= n3;
        }
        return n > n2 && n < n3;
    }

    public static boolean n(int n, int n2, int n3) {
        return bcy.b(n, n2, n3, true);
    }

    public static String Dt() {
        return bcy.a(new Date());
    }

    public static String a(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(date);
    }

    public static void Du() {
        try {
            StackTraceElement[] stackTraceElementArray = new Throwable().fillInStackTrace().getStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < stackTraceElementArray.length; ++i) {
                stringBuilder.append(stackTraceElementArray[i].getMethodName()).append(":").append(stackTraceElementArray[i].getLineNumber()).append("->");
            }
            System.out.println(stringBuilder);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static String A(int n, int n2) {
        try {
            StackTraceElement[] stackTraceElementArray = new Throwable().fillInStackTrace().getStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = n; i < stackTraceElementArray.length && i < n2; ++i) {
                stringBuilder.append(stackTraceElementArray[i].getMethodName() + ":" + stackTraceElementArray[i].getLineNumber()).append("->");
            }
            return stringBuilder.toString();
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static int o(int n, int n2, int n3) {
        return new Color(n, n2, n3, 255).getRGB();
    }

    public static boolean F(String string, boolean bl) {
        File file = new File(string);
        if (file.exists()) {
            return true;
        }
        try {
            Files.createDirectories(file.toPath(), new FileAttribute[0]);
        }
        catch (Throwable throwable) {
            if (bl) {
                throwable.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public static Set c(Map map, Object object) {
        return map.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), object)).map(Map.Entry::getKey).collect(Collectors.toSet());
    }

    public static String H(File file) {
        return bcy.iO(file.getAbsolutePath());
    }

    public static String iO(String string) {
        int n;
        if (string == null) {
            return null;
        }
        String string2 = string.replace("\\", "/");
        int n2 = string2.indexOf("plugins/");
        if (n2 != -1) {
            string2 = string2.substring(n2);
        }
        if ((n = string2.indexOf("/")) != -1) {
            string2 = string2.substring(n + 1);
        }
        if ((n = string2.indexOf("/")) != -1) {
            string2 = string2.substring(n + 1);
        }
        return string2;
    }

    public static String I(File file) {
        return bcy.iP(file.getAbsolutePath());
    }

    public static String iP(String string) {
        if (string == null) {
            return null;
        }
        String string2 = string.replace("\\", "/");
        int n = string2.indexOf("plugins/");
        if (n != -1) {
            string2 = string2.substring(n);
        }
        if (string2.startsWith("plugins/ItemsAdder/")) {
            return string2.replace("plugins/ItemsAdder/", "");
        }
        return string2;
    }

    public static ArrayList a(File file, FileFilter fileFilter) {
        File[] fileArray = file.listFiles(fileFilter);
        if (fileArray != null) {
            return new ArrayList<File>(Arrays.asList(fileArray));
        }
        return new ArrayList();
    }

    public static int J(File file) {
        String[] stringArray = file.list();
        if (stringArray == null) {
            return 0;
        }
        return stringArray.length;
    }

    public static String K(File file) {
        File file2;
        String string = Bukkit.getServer().getWorldContainer().getAbsolutePath();
        if (string.endsWith(".")) {
            string = string.substring(0, string.length() - 2);
        }
        if ((file2 = new File(string).getParentFile()) == null) {
            return file.getAbsolutePath();
        }
        return file.getAbsolutePath().replace(file2.getAbsolutePath(), "");
    }

    public static Path iQ(String string) {
        return new File(string).toPath();
    }

    public static String iR(String string) {
        int n = (string = string.replace('\\', '/')).startsWith("/") ? 1 : 0;
        for (int i = n + 1; i < string.length(); ++i) {
            if (string.charAt(i) != '/' || string.charAt(i - 1) != '/' || i >= 2 && string.charAt(i - 2) == ':') continue;
            StringBuilder stringBuilder = new StringBuilder(string.length()).append(string, n, i);
            while (i < string.length()) {
                char c = string.charAt(i);
                int n2 = stringBuilder.length();
                if (c != '/' || n2 <= 0 || stringBuilder.charAt(n2 - 1) != '/' || n2 >= 2 && stringBuilder.charAt(n2 - 2) == ':') {
                    stringBuilder.append(c);
                }
                ++i;
            }
            return stringBuilder.toString();
        }
        return n == 0 ? string : string.substring(1);
    }

    public static String L(File file) {
        return bcy.iR(file.getAbsolutePath());
    }

    public static String aE(String string, String string2) {
        if (string.startsWith(string2)) {
            return string.substring(string2.length());
        }
        return string;
    }

    public static String aF(String string, String string2) {
        return string.replaceFirst(string2 + "$", "");
    }

    public static String iS(String string) {
        return string.substring(string.lastIndexOf(47) + 1);
    }

    public static String iT(String string) {
        return new String(string.getBytes(StandardCharsets.UTF_8));
    }

    public static Object[] c(Object[] objectArray) {
        return Arrays.copyOf(objectArray, objectArray.length);
    }

    public static String M(File file) {
        return FilenameUtils.getExtension((String)file.getAbsolutePath());
    }

    public static String a(File file, boolean bl) {
        if (bl) {
            return file.getName();
        }
        return FilenameUtils.getBaseName((String)file.getAbsolutePath());
    }

    public static String k(long l) {
        if (-1000L < l && l < 1000L) {
            return l + " B";
        }
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator("kMGTPE");
        while (l <= -999950L || l >= 999950L) {
            l /= 1000L;
            stringCharacterIterator.next();
        }
        return String.format("%.1f %cB", (double)l / 1000.0, Character.valueOf(stringCharacterIterator.current()));
    }

    public static int p(int n, int n2, int n3) {
        if (n < n2) {
            return n2;
        }
        return Math.min(n, n3);
    }

    public static String aG(String string, String string2) {
        return string.substring(string.indexOf(string2));
    }

    public static boolean iU(String string) {
        String[] stringArray = string.split(":");
        if (stringArray.length == 2 && !stringArray[0].endsWith("\\")) {
            return false;
        }
        try {
            Pattern.compile(string);
            return true;
        }
        catch (PatternSyntaxException patternSyntaxException) {
            return false;
        }
    }

    public static boolean bR(int n) {
        double d = Math.log(n) / Math.log(2.0);
        return Math.ceil(d) == Math.floor(d);
    }

    public static String Q(List list) {
        StringJoiner stringJoiner = new StringJoiner(",");
        list.forEach(object -> stringJoiner.add(object.toString()));
        return stringJoiner.toString();
    }

    public static boolean e(String[] stringArray, String string) {
        for (String string2 : stringArray) {
            if (!string2.equals(string)) continue;
            return true;
        }
        return false;
    }

    public static String iV(String string) {
        Component component = bbe.gK(string);
        return azG.serialize(component);
    }

    public static String x(Component component) {
        return azG.serialize(component);
    }

    public static String d(InputStream inputStream) {
        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    }

    public static int a(Player player, PotionEffectType potionEffectType) {
        PotionEffect potionEffect = player.getPotionEffect(potionEffectType);
        if (potionEffect == null) {
            return 0;
        }
        return potionEffect.getAmplifier();
    }

    @Nullable
    public static Location r(PlayerInteractEvent playerInteractEvent) {
        return playerInteractEvent.getClickedBlock() != null && playerInteractEvent.getClickedPosition() != null ? playerInteractEvent.getClickedBlock().getLocation().add(playerInteractEvent.getClickedPosition()) : null;
    }

    public static String iW(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] byArray = messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            for (byte by : byArray) {
                String string2 = Integer.toHexString(0xFF & by);
                if (string2.length() == 1) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(string2);
            }
            return stringBuilder.toString();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException("SHA-256 algorithm not found", noSuchAlgorithmException);
        }
    }

    public static Collection a(String string, Predicate predicate) {
        ArrayList<String> arrayList = new ArrayList<String>();
        URL uRL = bcy.class.getClassLoader().getResource(string);
        if (uRL == null) {
            return arrayList;
        }
        if (uRL.getProtocol().equals("jar")) {
            String string2 = uRL.getPath().substring(5, uRL.getPath().indexOf("!"));
            try (JarFile jarFile = new JarFile(URLDecoder.decode(string2, StandardCharsets.UTF_8));){
                Object object = string.endsWith("/") ? string : string + "/";
                Enumeration<JarEntry> enumeration = jarFile.entries();
                while (enumeration.hasMoreElements()) {
                    String string3;
                    String string4 = enumeration.nextElement().getName();
                    if (!string4.startsWith((String)object) || string4.equals(object) || (string3 = string4.substring(((String)object).length())).isEmpty() || string4.endsWith("/") || !predicate.test(string3)) continue;
                    arrayList.add(string4);
                }
            }
        }
        return arrayList;
    }
}
