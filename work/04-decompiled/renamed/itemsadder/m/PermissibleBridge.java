package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.Opaque121;
import itemsadder.m.Opaque123;
import itemsadder.m.Opaque140;
import itemsadder.m.OutputNull;
import itemsadder.m.PluginFileConfigurationHolder;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.ShadowColor;
import net.kyori.adventure.util.ARGBLike;
import net.kyori.adventure.util.RGBLike;
import org.apache.commons.lang.StringEscapeUtils;
import org.bukkit.ChatColor;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers detected
 */
public class PermissibleBridge
extends Opaque140
implements Cloneable {
    public static final int ur = 1;
    private static final int us = 16;
    private static final int ut = 16;
    public final boolean uu;
    private String uv;
    String uw;
    String ux;
    int uy = 0;
    int uz = 9;
    int uA = 0;
    String uB;
    public final boolean uC;
    @Nullable
    public final Integer uD;
    public boolean uE;
    String uF;
    boolean uG;
    boolean uH;
    String uI;
    String uJ;
    boolean uK;

    @Nullable
    public static BufferedImage aU(String string) {
        if (string == null) {
            return null;
        }
        return PermissibleBridge.j(new File(string));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public static BufferedImage j(File file) {
        BufferedImage bufferedImage;
        if (file == null || !file.exists()) {
            return null;
        }
        ImageInputStream imageInputStream = ImageIO.createImageInputStream(file);
        Iterator<ImageReader> iterator = ImageIO.getImageReaders(imageInputStream);
        if (!iterator.hasNext()) {
            CommandSenderBridge_5.error("Error initializing PNG image reader. Something's wrong with your Java installation.");
            return null;
        }
        ImageReader imageReader = iterator.next();
        ImageReadParam imageReadParam = imageReader.getDefaultReadParam();
        try {
            imageReader.setInput(imageInputStream, false, true);
            bufferedImage = imageReader.read(0, imageReadParam);
        }
        finally {
            imageReader.dispose();
            imageInputStream.close();
        }
        return bufferedImage;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PermissibleBridge(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, String object, int n2, int n3, String string3, boolean bl, boolean bl2, Integer n4, boolean bl3, @Nullable String string4, boolean bl4) {
        super(string, string2);
        Object object2;
        this.ux = string;
        this.uC = bl2;
        this.uD = n4;
        this.uE = bl3;
        this.uF = string4;
        if (object == null || ((String)object).isEmpty() || ((String)object).equals(" ")) {
            CommandSenderBridge_5.error("Blank path for font_image '" + this.getNamespacedID() + "'. Please specify one.");
            this.uu = true;
            return;
        }
        if (((String)object).contains(":")) {
            object2 = ((String)object).split(":");
            if (((String[])object2).length != 2) {
                CommandSenderBridge_5.error("Bad path for font_image '" + this.getNamespacedID() + "'. It contains " + ((String[])object2).length + " ':' characters. Only one is allowed.");
                this.uu = true;
                return;
            }
            this.ux = object2[0];
            object = object2[1];
        }
        if (!((String)object).endsWith(".png")) {
            object = (String)object + ".png";
        }
        this.uJ = ":" + string2 + ":";
        this.uy = n2;
        this.uI = string3;
        this.uG = bl;
        this.uH = bl4;
        this.uw = object;
        this.uv = "assets/" + this.ux + "/textures/" + (String)object;
        object2 = ItemStackRegistry.s(this.uv);
        if (object2 == null || !((File)object2).exists()) {
            if (!this.ux.equals("minecraft")) {
                CommandSenderBridge_5.error("Image not found for font_image '" + this.getNamespacedID() + "'. " + this.uv);
                this.uu = true;
                return;
            }
            if (!ItemStackRegistry.g().as.auh.eN(this.uv)) {
                CommandSenderBridge_5.warn("Failed to add font glyph entry. Vanilla resource '" + this.uv + "' does not exist. File: " + pluginFileConfigurationHolder.nh());
                this.uu = true;
                return;
            }
            this.uz = 16;
            this.uA = 16;
        } else {
            try {
                Opaque121 opaque121 = new Opaque121((File)object2);
                this.uA = opaque121.uM;
                this.uz = opaque121.uL;
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.error("Error calculating font_image '" + this.getNamespacedID() + "' dimensions. File: " + this.uv, throwable);
                this.uu = true;
                return;
            }
        }
        if (n3 != 0) {
            this.uA = PermissibleBridge.h(this.uA, this.uz, n3);
            this.uz = n3;
        }
        if (n2 > this.uz) {
            CommandSenderBridge_5.error(String.valueOf(ChatColor.RED) + "Error loading font_image '" + this.getNamespacedID() + "': &6y_position &cmust be lower or equal to &6scale_ratio&c (or &6png height&c).");
            CommandSenderBridge_5.error("&6y_position: " + n2 + " &c| &6scale_ratio: " + n3 + " &c| &6png height: " + this.uz + "&c. ");
            this.uu = true;
            return;
        }
        if (Main.KO.gY("debug.items.log-font-images-loading")) {
            CommandSenderBridge_5.log("    size: " + this.uA + "x" + this.uz);
        }
        this.uu = false;
    }

    public void hY() {
        try {
            File file = ItemStackRegistry.s(this.uv);
            BufferedImage bufferedImage = PermissibleBridge.j(file);
            PermissibleBridge.a(file, bufferedImage);
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Failed to fix transparent pixels of font image '" + this.getNamespacedID() + "'. File: " + this.uv, throwable);
        }
    }

    @Nullable
    public File hZ() {
        return ItemStackRegistry.s(this.uv);
    }

    public PermissibleBridge ia() {
        try {
            return (PermissibleBridge)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            cloneNotSupportedException.printStackTrace();
            return null;
        }
    }

    public void aV(String string) {
        this.uB = string;
        this.uK = PermissibleBridge.d(string.charAt(0));
    }

    public String ib() {
        return this.ux + ":" + this.uw;
    }

    public String ic() {
        return this.ux;
    }

    public String id() {
        return this.uw;
    }

    public int ie() {
        return this.uy;
    }

    public int getHeight() {
        return this.uz;
    }

    public int getWidth() {
        return this.uA;
    }

    public void P(int n2) {
        this.uA = n2;
    }

    public String if() {
        return this.Q(true);
    }

    public String Q(boolean bl) {
        if (bl) {
            return Opaque123.e(this.uB, -1);
        }
        return this.uB;
    }

    public boolean ig() {
        return this.uG;
    }

    public boolean ih() {
        return this.uH;
    }

    @Nullable
    public String ii() {
        return this.uF;
    }

    public void aW(String string) {
        if (string == null || string.isEmpty()) {
            return;
        }
        this.uF = string;
    }

    @Nullable
    public String getPermission() {
        if (this.uI == null || this.uI.isEmpty()) {
            return null;
        }
        return s.cY(this.uI);
    }

    public boolean a(Permissible permissible) {
        return s.a(permissible, this.getPermission());
    }

    @Deprecated
    public String ij() {
        return this.uJ;
    }

    public boolean ik() {
        return this.uK;
    }

    public static boolean b(String string, int n2) {
        if (n2 > string.length() - 1) {
            return false;
        }
        return PermissibleBridge.d(string.charAt(n2)) && PermissibleBridge.d(string.charAt(n2 + 1));
    }

    public static boolean d(char c) {
        return c >= '\ud7fc' && c <= '\udfff';
    }

    @Deprecated
    public static int a(BufferedImage bufferedImage) {
        int n2;
        int n3 = 0;
        int n4 = 0;
        int n5 = bufferedImage.getWidth();
        int n6 = bufferedImage.getHeight();
        for (n2 = n5 - 1; n2 >= 0; --n2) {
            int n7 = n3 * n5 + n2;
            for (int i2 = 0; i2 < n6; ++i2) {
                int n8 = n4 * n6 + i2;
                if (new Color(bufferedImage.getRGB(n7, n8), true).getAlpha() == 0) continue;
                return n2 + 1;
            }
        }
        return n2 + 1;
    }

    public static BufferedImage a(File file, BufferedImage bufferedImage) {
        PermissibleBridge.a(bufferedImage, 0, 0);
        PermissibleBridge.a(bufferedImage, bufferedImage.getWidth() - 1, bufferedImage.getHeight() - 1);
        OutputNull.a((RenderedImage)bufferedImage, "PNG", file);
        return bufferedImage;
    }

    public static void a(BufferedImage bufferedImage, int n2, int n3) {
        Color color = new Color(bufferedImage.getRGB(n2, n3), true);
        if (color.getAlpha() < 5) {
            color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 5);
            bufferedImage.setRGB(n2, n3, color.getRGB());
        }
    }

    public static int h(int n2, int n3, int n4) {
        return (int)((double)n4 * (double)n2 / (double)n3 + 0.5);
    }

    public static String aX(String string) {
        return StringEscapeUtils.escapeJavaScript((String)string);
    }

    public TextComponent.Builder a(TextComponent.Builder builder) {
        if (!Version.isAtLeast((Version)Version.v1_21_4)) {
            return builder;
        }
        if (this.uC) {
            if (this.uD != null) {
                builder = (TextComponent.Builder)builder.shadowColor((ARGBLike)ShadowColor.shadowColor((RGBLike)ShadowColor.shadowColor((int)this.uD), (int)255));
            }
        } else {
            builder = (TextComponent.Builder)builder.shadowColor((ARGBLike)ShadowColor.shadowColor((int)0, (int)0, (int)0, (int)0));
        }
        return builder;
    }

    public /* synthetic */ Object clone() {
        return this.ia();
    }
}
