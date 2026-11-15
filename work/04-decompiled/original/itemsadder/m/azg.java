package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ae;
import itemsadder.m.aze;
import itemsadder.m.azf;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.bdb;
import itemsadder.m.d;
import itemsadder.m.qj;
import itemsadder.m.qm;
import itemsadder.m.rd;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import javax.imageio.stream.MemoryCacheImageInputStream;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.Nullable;

public class azg {
    private static azg axx;
    private static final int axy;
    private static final String axz = "assets/minecraft/textures/models/armor/leather_layer_1.png";
    public int axA;
    azf axB = new azf();
    azf axC = new azf();
    public ByteArrayOutputStream axD;
    public ByteArrayOutputStream axE;
    public BufferedImage[] axF = new BufferedImage[2];
    public BufferedImage[] axG = new BufferedImage[2];
    int axH = 0;
    private final String axI;
    private final String axJ;
    private final String axK;
    public HashMap axL = new HashMap();
    public ArrayList axM = new ArrayList();

    private azg() {
        this.axI = "assets/minecraft/optifine/";
        this.axJ = this.axI + "cit/ia_generated_armors/";
        this.axK = this.axI + "anim/ia_generated_armors/";
    }

    public static azg aV(boolean bl) {
        if (bl || axx == null) {
            axx = new azg();
        }
        return axx;
    }

    public void Bd() {
        this.axF[0] = null;
        this.axF[1] = null;
        this.axG[0] = null;
        this.axG[1] = null;
    }

    public void cy() {
        this.Bd();
        this.Bg();
    }

    public void Be() {
        BufferedImage bufferedImage;
        Object object;
        Map.Entry entry3;
        Object object2;
        Map.Entry entry22;
        if (ae.dz) {
            bce.log(String.valueOf(ChatColor.AQUA) + "Generating custom vanilla armors");
        }
        this.cy();
        HashMap<Integer, Object> hashMap = new HashMap<Integer, Object>();
        for (Map.Entry entry22 : d.g().C.entrySet()) {
            object2 = qj.j((qm)entry22.getValue());
            if (object2 == null || hashMap.containsKey(((rd)object2).HC.asRGB())) continue;
            this.fY(((rd)object2).HD);
            this.fY(((rd)object2).HE);
            this.fY(((rd)object2).HF);
            this.fY(((rd)object2).HG);
            entry3 = new aze((rd)object2, ((rd)object2).HC.asRGB());
            this.a((aze)((Object)entry3));
            hashMap.put(((rd)object2).HC.asRGB(), entry3);
        }
        File file = new File(d.m, axz);
        entry22 = new File(d.m, "assets/minecraft/textures/models/armor/leather_layer_2.png");
        if (file.exists() && ((File)((Object)entry22)).exists()) {
            try {
                object = ImageIO.read(file);
                object2 = new BufferedImage(((BufferedImage)object).getWidth(), ((BufferedImage)object).getHeight(), 2);
                ((BufferedImage)object2).getGraphics().drawImage((Image)object, 0, 0, null);
                bufferedImage = ImageIO.read(file);
                entry3 = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 2);
                ((BufferedImage)((Object)entry3)).getGraphics().drawImage(bufferedImage, 0, 0, null);
                int n = ((BufferedImage)object2).getHeight() / 32;
                if (n > 1) {
                    bce.error("A custom armor atlas file was found. ItemsAdder doesn't support manually created armors atlas textures with height not equal to 32.");
                } else {
                    int n2;
                    int n3 = ((BufferedImage)object2).getWidth() / 64;
                    bce.warn("A custom armor atlas file was found, now loading " + n3 + " textures from it.");
                    bce.warn("WARNING: ItemsAdder won't automatically generate Optifine CIT configurations for these armors.");
                    LinkedList<BufferedImage> linkedList = new LinkedList<BufferedImage>();
                    LinkedList<BufferedImage> linkedList2 = new LinkedList<BufferedImage>();
                    for (n2 = 0; n2 < ((BufferedImage)object2).getWidth(); n2 += 64) {
                        linkedList.add(((BufferedImage)object2).getSubimage(n2, 0, 64, 32));
                    }
                    for (n2 = 0; n2 < ((BufferedImage)((Object)entry3)).getWidth(); n2 += 64) {
                        linkedList2.add(((BufferedImage)((Object)entry3)).getSubimage(n2, 0, 64, 32));
                    }
                    for (n2 = 0; n2 < n3; ++n2) {
                        BufferedImage bufferedImage2 = (BufferedImage)linkedList.get(n2);
                        BufferedImage bufferedImage3 = (BufferedImage)linkedList2.get(n2);
                        BufferedImage bufferedImage4 = null;
                        BufferedImage bufferedImage5 = null;
                        int n4 = bufferedImage2.getRGB(0, 0);
                        if (n2 + 1 < n3) {
                            if (this.c(bufferedImage2)) {
                                bufferedImage4 = (BufferedImage)linkedList.get(n2 + 1);
                            }
                            if (this.c(bufferedImage3)) {
                                bufferedImage5 = (BufferedImage)linkedList2.get(n2 + 1);
                            }
                        }
                        if (n4 != 0) {
                            aze aze2 = new aze(bufferedImage2, bufferedImage3, bufferedImage4, bufferedImage5, n4);
                            this.a(aze2);
                            hashMap.put(n4, aze2);
                            continue;
                        }
                        this.axG[0] = bufferedImage2;
                        this.axG[1] = bufferedImage3;
                    }
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        if (ae.dz) {
            bce.log(String.valueOf(ChatColor.AQUA) + "Armor textures maxSize: " + String.valueOf(this.axC));
        }
        if (this.axC.Bc()) {
            this.axC = azf.Bb();
        }
        this.Bf();
        if (this.axH == 0) {
            this.axH = Objects.requireNonNull(this.h(1, true)).getHeight();
        }
        this.axA = this.axH / 2;
        for (Map.Entry entry3 : hashMap.entrySet()) {
            object = (aze)entry3.getValue();
            if (((aze)object).Ba()) continue;
            bufferedImage = ((aze)object).a(1, this.axC);
            BufferedImage bufferedImage6 = ((aze)object).a(2, this.axC);
            if (this.axB.uz < bufferedImage.getHeight()) {
                this.axB.uz = bufferedImage.getHeight();
            }
            if (this.axB.uz < bufferedImage6.getHeight()) {
                this.axB.uz = bufferedImage6.getHeight();
            }
            this.axB.uA += this.axC.uA;
            if (((aze)object).axv[0] == null) continue;
            this.axB.uA += this.axC.uA;
        }
        try {
            this.axD = this.a(1, hashMap);
            this.axE = this.a(2, hashMap);
        }
        catch (Throwable throwable) {
            bce.error("Failed to generate armor atlas.");
            throwable.printStackTrace();
        }
    }

    private ByteArrayOutputStream a(int n, HashMap hashMap) {
        BufferedImage bufferedImage = this.a(hashMap, n);
        if (bufferedImage != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage)bufferedImage, "PNG", byteArrayOutputStream);
            if (ae.dz) {
                bce.log(String.valueOf(ChatColor.GREEN) + "Generated atlas " + n);
            }
            return byteArrayOutputStream;
        }
        return null;
    }

    private void a(aze aze2) {
        for (int i = 0; i < aze2.axu.length; ++i) {
            BufferedImage bufferedImage = aze2.axu[i];
            if (bufferedImage == null) continue;
            if (bufferedImage.getWidth() > this.axC.uA) {
                this.axC.uA = bufferedImage.getWidth();
            }
            if (bufferedImage.getHeight() > this.axC.uz) {
                this.axC.uz = bufferedImage.getHeight();
            }
            if (aze2.bq(1) <= this.axH) continue;
            this.axH = aze2.bq(i + 1);
        }
    }

    private boolean c(BufferedImage bufferedImage) {
        int n = bufferedImage.getRGB(2, 0);
        return new Color(n).getRed() != 0;
    }

    private void Bf() {
        this.h(1, true);
        this.h(2, true);
    }

    private BufferedImage a(HashMap hashMap, int n) {
        BufferedImage bufferedImage;
        if ((this.axB.uA == 0 || this.axB.uz == 0) && ae.dz) {
            bce.log(String.valueOf(ChatColor.YELLOW) + "No custom armor. Size: 0x0, Generating base layers.");
        }
        if (this.axB.uz == 0) {
            this.axB.uz = Objects.requireNonNull(this.h(n, true)).getHeight();
        }
        if ((bufferedImage = this.bv(n)) == null) {
            throw new IllegalArgumentException("Default vanilla armor layer is null!");
        }
        BufferedImage bufferedImage2 = this.h(n, true);
        if (bufferedImage2 == null) {
            throw new IllegalArgumentException("Default vanilla armor base layer is null!");
        }
        BufferedImage bufferedImage3 = new BufferedImage(this.axB.uA + bufferedImage.getWidth() + bufferedImage2.getWidth(), this.axB.uz, 2);
        if (ae.dz) {
            bce.log(String.valueOf(ChatColor.AQUA) + "Armors atlas size: " + String.valueOf(this.axB));
        }
        Graphics2D graphics2D = bufferedImage3.createGraphics();
        int n2 = 0;
        graphics2D.drawImage((Image)bufferedImage, 0, 0, null);
        azg.a(bufferedImage3, n2, 1, bcy.o(255, 255, 255));
        graphics2D.drawImage((Image)bufferedImage2, n2 += bufferedImage.getWidth(), 0, null);
        azg.d(bufferedImage3, n2, bcy.o(160, 101, 64));
        azg.a(bufferedImage3, n2, 1, axy);
        azg.d(bufferedImage3, n2 + 2, new Color(0, 1, 0).getRGB());
        n2 += bufferedImage2.getWidth();
        for (aze aze2 : hashMap.values()) {
            BufferedImage bufferedImage4 = aze2.a(n, this.axC);
            BufferedImage bufferedImage5 = aze2.b(n, this.axC);
            if (bufferedImage4 == null) {
                if (!ae.dz) continue;
                if (aze2.axt == null) {
                    bce.log(String.valueOf(ChatColor.YELLOW) + "No layer texture, skip render for unknown item.");
                    continue;
                }
                bce.log(String.valueOf(ChatColor.YELLOW) + "No layer texture, skip render for item " + aze2.axt.getNamespacedID());
                continue;
            }
            graphics2D.drawImage((Image)bufferedImage4, n2, 0, null);
            if (aze2.axt != null) {
                azg.a(bufferedImage3, n2, aze2.axt.HC.getRed(), aze2.axt.HC.getGreen(), aze2.axt.HC.getBlue());
                int n3 = aze2.br(n);
                azg.a(bufferedImage3, n2 + 1, n3, aze2.axt.HJ, aze2.axt.HK ? 1 : 0);
                azg.a(bufferedImage3, n2 + 2, bufferedImage5 != null ? aze2.axt.HH : 0, aze2.axt.HI ? 1 : 0, 0);
                if (ae.dz) {
                    bce.log(String.valueOf(ChatColor.GREEN) + "Added custom layer texture for render: " + aze2.axt.getNamespacedID());
                }
            } else if (ae.dz) {
                bce.log(String.valueOf(ChatColor.GREEN) + "Added custom layer texture from manually created atlas texture. RGB: " + aze2.axw);
            }
            n2 += bufferedImage4.getWidth();
            if (bufferedImage5 == null) continue;
            graphics2D.drawImage((Image)bufferedImage5, n2, 0, null);
            n2 += bufferedImage5.getWidth();
            if (!ae.dz) continue;
            bce.log(String.valueOf(ChatColor.GREEN) + "Added custom emissive layer texture for render: " + aze2.axt.getNamespacedID());
        }
        graphics2D.dispose();
        if (this.axB.uA > 16384) {
            bce.warn(String.valueOf(ChatColor.YELLOW) + "##########################");
            bce.warn(String.valueOf(ChatColor.YELLOW) + "                          ");
            bce.warn(String.valueOf(ChatColor.YELLOW) + "         Warning         ");
            bce.warn(String.valueOf(ChatColor.YELLOW) + "                          ");
            bce.warn(String.valueOf(ChatColor.YELLOW) + "##########################");
            bce.warn(String.valueOf(ChatColor.RED) + "The generated armors texture is too big " + String.valueOf(this.axB) + "!");
            bce.warn(String.valueOf(ChatColor.RED) + "Please use smaller armor textures.");
            bce.warn(String.valueOf(ChatColor.RED) + "Most graphics cards can't support very high sized textures.");
            bce.warn(String.valueOf(ChatColor.RED) + "If your armors are not animated and you are on 1.21.2+, consider using the new component method: http://a.devs.beer/ia-armors-comp-big");
            bce.warn("                          ");
            bce.warn("                          ");
            bce.warn("                          ");
        }
        return bufferedImage3;
    }

    private void fY(@Nullable String string) {
        if (string == null) {
            return;
        }
        this.axM.add(string);
    }

    private static void a(BufferedImage bufferedImage, int n, int n2, int n3) {
        bufferedImage.setRGB(n, n2, n3);
    }

    private static void d(BufferedImage bufferedImage, int n, int n2) {
        bufferedImage.setRGB(n, 0, n2);
    }

    private static void a(BufferedImage bufferedImage, int n, int n2, int n3, int n4) {
        bufferedImage.setRGB(n, 0, bcy.o(n2, n3, n4));
    }

    @Nullable
    public static Integer b(int n, HashMap hashMap) {
        int n2 = n;
        boolean bl = false;
        while (hashMap.containsKey(n)) {
            if (!bl) {
                if (++n < 0xFFFFFF) continue;
                n = n2;
                bl = true;
                continue;
            }
            if (--n > 0) continue;
            return null;
        }
        return n;
    }

    private void Bg() {
        this.axD = null;
        this.axE = null;
        this.axB = new azf();
        this.axC = new azf();
        this.axA = 0;
        this.axH = 0;
    }

    public boolean Bh() {
        return this.axD != null && this.axE != null;
    }

    @Nullable
    public BufferedImage bv(int n) {
        try {
            if (this.axF[n - 1] == null) {
                this.axF[n - 1] = ae.du ? azg.a("internal/textures/models/armor/leather_layer_" + n + ".png", this.axC) : azg.a("internal/textures/models/armor/leather_layer_" + n + "_base.png", this.axC);
            }
            return this.axF[n - 1];
        }
        catch (IOException iOException) {
            bce.error("Failed to load default armor layer texture: " + iOException.getMessage());
            return null;
        }
    }

    @Nullable
    public BufferedImage h(int n, boolean bl) {
        try {
            if (this.axG[n - 1] == null) {
                BufferedImage bufferedImage = aze.a("assets/minecraft/textures/models/armor/leather_layer_" + n + ".png", null, false);
                try {
                    this.axG[n - 1] = bufferedImage == null ? azg.a("internal/textures/models/armor/leather_layer_" + n + "_base.png", this.axC) : (bl ? aze.a(bufferedImage, this.axC.uA) : bufferedImage);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    this.axG[n - 1] = azg.a("internal/textures/models/armor/leather_layer_" + n + "_base.png", this.axC);
                }
            }
            return this.axG[n - 1];
        }
        catch (IOException iOException) {
            bce.error("Failed to load brown armor base layer texture: " + iOException.getMessage());
            return null;
        }
    }

    @Nullable
    private static BufferedImage fZ(String string) {
        return azg.a(string, null);
    }

    @Nullable
    public static BufferedImage a(String string, @Nullable azf azf2) {
        InputStream inputStream = Main.rS().getResource(string);
        if (inputStream == null) {
            return null;
        }
        BufferedImage bufferedImage = ImageIO.read(new MemoryCacheImageInputStream(inputStream));
        if (azf2 != null) {
            bufferedImage = aze.a(bufferedImage, azf2.uA);
        }
        return bufferedImage;
    }

    private void a(BufferedImage bufferedImage, String string) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write((RenderedImage)bufferedImage, "PNG", byteArrayOutputStream);
        this.axL.put(string, byteArrayOutputStream);
    }

    public void Bi() {
        if (ae.dz) {
            bce.log(String.valueOf(ChatColor.AQUA) + "Generating custom Optifine armors");
        }
        try {
            this.Bj();
            this.Bk();
        }
        catch (Exception exception) {
            bce.error("[Optifine] Failed to generate vanilla leather armor textures.");
            exception.printStackTrace();
        }
        int n = 0;
        for (Map.Entry entry : d.g().C.entrySet()) {
            aze aze2;
            qj qj2;
            rd rd2;
            if (!(entry.getValue() instanceof qj) || (rd2 = (qj2 = (qj)entry.getValue()).mB()) == null || (aze2 = new aze(rd2, rd2.HC.asRGB())).Ba()) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("nbt.display.color=" + qj2.getColor()).append("\n");
            stringBuilder.append("type=armor").append("\n");
            stringBuilder.append("items=").append(qj2.getType().toString().toLowerCase()).append("\n");
            String string = bcy.a(rd2.HC, false) + "_1.png";
            String string2 = bcy.a(rd2.HC, false) + "_2.png";
            if (!rd2.HI) {
                stringBuilder.append("texture.leather_layer_1_overlay=").append(string).append("\n");
                stringBuilder.append("texture.leather_layer_2_overlay=").append(string2).append("\n");
            }
            stringBuilder.append("texture.leather_layer_1=").append(string).append("\n");
            stringBuilder.append("texture.leather_layer_2=").append(string2).append("\n");
            stringBuilder.append("weight=9999").append("\n");
            if (this.a(stringBuilder.toString(), this.axJ + qj2.Gf + "_" + qj2.Gg + ".properties", qj2)) {
                try {
                    this.a(aze2.f(1, false), this.axJ + string);
                    this.a(aze2.f(2, false), this.axJ + string2);
                    if (aze2.bm(1)) {
                        this.a(aze2.g(1, false), this.axJ + string.replace(".png", "_e.png"));
                    }
                    if (aze2.bm(2)) {
                        this.a(aze2.g(2, false), this.axJ + string2.replace(".png", "_e.png"));
                    }
                    ++n;
                }
                catch (IOException iOException) {
                    bce.error("Failed to save Optifine custom armor images: " + qj2.getNamespacedID());
                    iOException.printStackTrace();
                }
            }
            this.a(aze2, false, string, 1, qj2, rd2);
            this.a(aze2, true, string, 1, qj2, rd2);
            this.a(aze2, false, string2, 2, qj2, rd2);
            this.a(aze2, true, string2, 2, qj2, rd2);
        }
        if (ae.dz) {
            bce.log(String.valueOf(ChatColor.GREEN) + "Generated " + n + " custom Optifine armors");
        }
    }

    private void Bj() {
        aze aze2 = new aze(azg.fZ("internal/textures/models/armor/leather_layer_1_base.png"), azg.fZ("internal/textures/models/armor/leather_layer_2_base.png"));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("type=armor").append("\n");
        stringBuilder.append("items=").append("leather_helmet leather_chestplate leather_leggings leather_boots").append("\n");
        String string = "base_1.png";
        String string2 = "base_2.png";
        stringBuilder.append("texture.leather_layer_1=").append(string).append("\n");
        stringBuilder.append("texture.leather_layer_2=").append(string2).append("\n");
        this.a(aze2, stringBuilder, "base_leather", string, string2);
    }

    private void Bk() {
        aze aze2 = new aze(azg.fZ("internal/textures/models/armor/leather_layer_1.png"), azg.fZ("internal/textures/models/armor/leather_layer_2.png"));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("type=armor").append("\n");
        stringBuilder.append("items=").append("leather_helmet leather_chestplate leather_leggings leather_boots").append("\n");
        String string = "custom_base_1.png";
        String string2 = "custom_base_2.png";
        stringBuilder.append("texture.leather_layer_1=").append(string).append("\n");
        stringBuilder.append("texture.leather_layer_2=").append(string2).append("\n");
        stringBuilder.append("nbt.itemsadder.namespace=pattern:*").append("\n");
        stringBuilder.append("weight=9997").append("\n");
        this.a(aze2, stringBuilder, "custom_base_leather", string, string2);
    }

    private void a(aze aze2, StringBuilder stringBuilder, String string, String string2, String string3) {
        if (this.a(stringBuilder.toString(), this.axJ + string + ".properties", null)) {
            try {
                this.a(aze2.f(1, false), this.axJ + string2);
                this.a(aze2.f(2, false), this.axJ + string3);
            }
            catch (IOException iOException) {
                bce.error("Failed to save Optifine default vanilla armor images");
                iOException.printStackTrace();
            }
        }
    }

    private boolean a(String string, String string2, @Nullable qm qm2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(string.getBytes(StandardCharsets.UTF_8));
            this.axL.put(string2, byteArrayOutputStream);
        }
        catch (IOException iOException) {
            if (qm2 != null) {
                bce.error("Failed to write Optifine CIT for armor " + qm2.getNamespacedID() + ". File: " + qm2.nh());
            } else {
                bce.error("Failed to write Optifine CIT for armor. Destination: " + string2);
            }
            iOException.printStackTrace();
            return false;
        }
        return true;
    }

    private void a(aze aze2, boolean bl, String string, int n, qm qm2, rd rd2) {
        if (bl && !aze2.bm(n)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = (int)(24.0f / ((float)rd2.HJ / 25.0f));
        stringBuilder.append("duration=").append(n2).append("\n");
        if (rd2.HK) {
            stringBuilder.append("interpolate=").append("true").append("\n");
        }
        stringBuilder.append("h=").append(aze2.d(n, false)).append("\n");
        stringBuilder.append("w=").append(aze2.bp(n)).append("\n");
        stringBuilder.append("x=0").append("\n");
        stringBuilder.append("y=0").append("\n");
        if (bl) {
            string = string.replace(".png", "_e.png");
        }
        stringBuilder.append("from=").append("./").append(string).append("\n");
        stringBuilder.append("to=").append("minecraft:optifine/cit/ia_generated_armors/").append(string).append("\n");
        String string2 = qm2.Gf + "_" + qm2.Gg + "_" + n + (bl ? "_e" : "") + "_animation.properties";
        if (this.a(stringBuilder.toString(), this.axK + string2, qm2)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ImageIO.write((RenderedImage)(bl ? aze2.bo(n) : aze2.bn(n)), "PNG", byteArrayOutputStream);
                this.axL.put(this.axK + string, byteArrayOutputStream);
            }
            catch (IOException iOException) {
                bce.error("Failed to save Optifine custom armor images: " + qm2.getNamespacedID());
                iOException.printStackTrace();
            }
        }
    }

    public void clear() {
        this.axL.clear();
        this.axD = null;
        this.axE = null;
    }

    @Nullable
    public bdb Bl() {
        return this.e(bce::error);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Nullable
    bdb e(Consumer consumer) {
        if (this.axD == null) {
            consumer.accept("Cannot calculate custom armor atlas dimensions: 'assets/minecraft/textures/models/armor/leather_layer_1.png' was not generated.");
            return null;
        }
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.axD.toByteArray());){
            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
            if (bufferedImage == null) {
                consumer.accept("Cannot calculate custom armor atlas dimensions: 'assets/minecraft/textures/models/armor/leather_layer_1.png' is not a readable PNG.");
                bdb bdb2 = null;
                return bdb2;
            }
            bdb bdb3 = new bdb(bufferedImage.getWidth(), bufferedImage.getHeight(), 0);
            return bdb3;
        }
        catch (IOException iOException) {
            consumer.accept("Cannot read custom armor atlas 'assets/minecraft/textures/models/armor/leather_layer_1.png': " + iOException.getMessage());
            return null;
        }
    }

    static {
        axy = new Color(0, 0, 0, 0).getRGB();
    }
}
