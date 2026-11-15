package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ColorBridge;
import itemsadder.m.ColorBridge_2;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.Found;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.MaterialBridge_6;
import itemsadder.m.Opaque009;
import itemsadder.m.VectorBridge_3;
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

public class InstanceRegistry_9 {
    private static InstanceRegistry_9 axx;
    private static final int axy;
    private static final String axz = "assets/minecraft/textures/models/armor/leather_layer_1.png";
    public int axA;
    Opaque009 axB = new Opaque009();
    Opaque009 axC = new Opaque009();
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

    private InstanceRegistry_9() {
        this.axI = "assets/minecraft/optifine/";
        this.axJ = this.axI + "cit/ia_generated_armors/";
        this.axK = this.axI + "anim/ia_generated_armors/";
    }

    public static InstanceRegistry_9 aV(boolean bl) {
        if (bl || axx == null) {
            axx = new InstanceRegistry_9();
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
        if (MaterialBarColorHolder.dz) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "Generating custom vanilla armors");
        }
        this.cy();
        HashMap<Integer, Object> hashMap = new HashMap<Integer, Object>();
        for (Map.Entry entry22 : ItemStackRegistry.g().C.entrySet()) {
            object2 = MaterialBridge_6.j((ItemStackBuilder_4)entry22.getValue());
            if (object2 == null || hashMap.containsKey(((ColorBridge_2)object2).HC.asRGB())) continue;
            this.fY(((ColorBridge_2)object2).HD);
            this.fY(((ColorBridge_2)object2).HE);
            this.fY(((ColorBridge_2)object2).HF);
            this.fY(((ColorBridge_2)object2).HG);
            entry3 = new Found((ColorBridge_2)object2, ((ColorBridge_2)object2).HC.asRGB());
            this.a((Found)((Object)entry3));
            hashMap.put(((ColorBridge_2)object2).HC.asRGB(), entry3);
        }
        File file = new File(ItemStackRegistry.m, axz);
        entry22 = new File(ItemStackRegistry.m, "assets/minecraft/textures/models/armor/leather_layer_2.png");
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
                    CommandSenderBridge_5.error("A custom armor atlas file was found. ItemsAdder doesn't support manually created armors atlas textures with height not equal to 32.");
                } else {
                    int n2;
                    int n3 = ((BufferedImage)object2).getWidth() / 64;
                    CommandSenderBridge_5.warn("A custom armor atlas file was found, now loading " + n3 + " textures from it.");
                    CommandSenderBridge_5.warn("WARNING: ItemsAdder won't automatically generate Optifine CIT configurations for these armors.");
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
                            Found found = new Found(bufferedImage2, bufferedImage3, bufferedImage4, bufferedImage5, n4);
                            this.a(found);
                            hashMap.put(n4, found);
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
        if (MaterialBarColorHolder.dz) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "Armor textures maxSize: " + String.valueOf(this.axC));
        }
        if (this.axC.Bc()) {
            this.axC = Opaque009.Bb();
        }
        this.Bf();
        if (this.axH == 0) {
            this.axH = Objects.requireNonNull(this.h(1, true)).getHeight();
        }
        this.axA = this.axH / 2;
        for (Map.Entry entry3 : hashMap.entrySet()) {
            object = (Found)entry3.getValue();
            if (((Found)object).Ba()) continue;
            bufferedImage = ((Found)object).a(1, this.axC);
            BufferedImage bufferedImage6 = ((Found)object).a(2, this.axC);
            if (this.axB.uz < bufferedImage.getHeight()) {
                this.axB.uz = bufferedImage.getHeight();
            }
            if (this.axB.uz < bufferedImage6.getHeight()) {
                this.axB.uz = bufferedImage6.getHeight();
            }
            this.axB.uA += this.axC.uA;
            if (((Found)object).axv[0] == null) continue;
            this.axB.uA += this.axC.uA;
        }
        try {
            this.axD = this.a(1, hashMap);
            this.axE = this.a(2, hashMap);
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Failed to generate armor atlas.");
            throwable.printStackTrace();
        }
    }

    private ByteArrayOutputStream a(int n, HashMap hashMap) {
        BufferedImage bufferedImage = this.a(hashMap, n);
        if (bufferedImage != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage)bufferedImage, "PNG", byteArrayOutputStream);
            if (MaterialBarColorHolder.dz) {
                CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "Generated atlas " + n);
            }
            return byteArrayOutputStream;
        }
        return null;
    }

    private void a(Found found) {
        for (int i = 0; i < found.axu.length; ++i) {
            BufferedImage bufferedImage = found.axu[i];
            if (bufferedImage == null) continue;
            if (bufferedImage.getWidth() > this.axC.uA) {
                this.axC.uA = bufferedImage.getWidth();
            }
            if (bufferedImage.getHeight() > this.axC.uz) {
                this.axC.uz = bufferedImage.getHeight();
            }
            if (found.bq(1) <= this.axH) continue;
            this.axH = found.bq(i + 1);
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
        if ((this.axB.uA == 0 || this.axB.uz == 0) && MaterialBarColorHolder.dz) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "No custom armor. Size: 0x0, Generating base layers.");
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
        if (MaterialBarColorHolder.dz) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "Armors atlas size: " + String.valueOf(this.axB));
        }
        Graphics2D graphics2D = bufferedImage3.createGraphics();
        int n2 = 0;
        graphics2D.drawImage((Image)bufferedImage, 0, 0, null);
        InstanceRegistry_9.a(bufferedImage3, n2, 1, ColorBridge.o(255, 255, 255));
        graphics2D.drawImage((Image)bufferedImage2, n2 += bufferedImage.getWidth(), 0, null);
        InstanceRegistry_9.d(bufferedImage3, n2, ColorBridge.o(160, 101, 64));
        InstanceRegistry_9.a(bufferedImage3, n2, 1, axy);
        InstanceRegistry_9.d(bufferedImage3, n2 + 2, new Color(0, 1, 0).getRGB());
        n2 += bufferedImage2.getWidth();
        for (Found found : hashMap.values()) {
            BufferedImage bufferedImage4 = found.a(n, this.axC);
            BufferedImage bufferedImage5 = found.b(n, this.axC);
            if (bufferedImage4 == null) {
                if (!MaterialBarColorHolder.dz) continue;
                if (found.axt == null) {
                    CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "No layer texture, skip render for unknown item.");
                    continue;
                }
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "No layer texture, skip render for item " + found.axt.getNamespacedID());
                continue;
            }
            graphics2D.drawImage((Image)bufferedImage4, n2, 0, null);
            if (found.axt != null) {
                InstanceRegistry_9.a(bufferedImage3, n2, found.axt.HC.getRed(), found.axt.HC.getGreen(), found.axt.HC.getBlue());
                int n3 = found.br(n);
                InstanceRegistry_9.a(bufferedImage3, n2 + 1, n3, found.axt.HJ, found.axt.HK ? 1 : 0);
                InstanceRegistry_9.a(bufferedImage3, n2 + 2, bufferedImage5 != null ? found.axt.HH : 0, found.axt.HI ? 1 : 0, 0);
                if (MaterialBarColorHolder.dz) {
                    CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "Added custom layer texture for render: " + found.axt.getNamespacedID());
                }
            } else if (MaterialBarColorHolder.dz) {
                CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "Added custom layer texture from manually created atlas texture. RGB: " + found.axw);
            }
            n2 += bufferedImage4.getWidth();
            if (bufferedImage5 == null) continue;
            graphics2D.drawImage((Image)bufferedImage5, n2, 0, null);
            n2 += bufferedImage5.getWidth();
            if (!MaterialBarColorHolder.dz) continue;
            CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "Added custom emissive layer texture for render: " + found.axt.getNamespacedID());
        }
        graphics2D.dispose();
        if (this.axB.uA > 16384) {
            CommandSenderBridge_5.warn(String.valueOf(ChatColor.YELLOW) + "##########################");
            CommandSenderBridge_5.warn(String.valueOf(ChatColor.YELLOW) + "                          ");
            CommandSenderBridge_5.warn(String.valueOf(ChatColor.YELLOW) + "         Warning         ");
            CommandSenderBridge_5.warn(String.valueOf(ChatColor.YELLOW) + "                          ");
            CommandSenderBridge_5.warn(String.valueOf(ChatColor.YELLOW) + "##########################");
            CommandSenderBridge_5.warn(String.valueOf(ChatColor.RED) + "The generated armors texture is too big " + String.valueOf(this.axB) + "!");
            CommandSenderBridge_5.warn(String.valueOf(ChatColor.RED) + "Please use smaller armor textures.");
            CommandSenderBridge_5.warn(String.valueOf(ChatColor.RED) + "Most graphics cards can't support very high sized textures.");
            CommandSenderBridge_5.warn(String.valueOf(ChatColor.RED) + "If your armors are not animated and you are on 1.21.2+, consider using the new component method: http://a.devs.beer/ia-armors-comp-big");
            CommandSenderBridge_5.warn("                          ");
            CommandSenderBridge_5.warn("                          ");
            CommandSenderBridge_5.warn("                          ");
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
        bufferedImage.setRGB(n, 0, ColorBridge.o(n2, n3, n4));
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
        this.axB = new Opaque009();
        this.axC = new Opaque009();
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
                this.axF[n - 1] = MaterialBarColorHolder.du ? InstanceRegistry_9.a("internal/textures/models/armor/leather_layer_" + n + ".png", this.axC) : InstanceRegistry_9.a("internal/textures/models/armor/leather_layer_" + n + "_base.png", this.axC);
            }
            return this.axF[n - 1];
        }
        catch (IOException iOException) {
            CommandSenderBridge_5.error("Failed to load default armor layer texture: " + iOException.getMessage());
            return null;
        }
    }

    @Nullable
    public BufferedImage h(int n, boolean bl) {
        try {
            if (this.axG[n - 1] == null) {
                BufferedImage bufferedImage = Found.a("assets/minecraft/textures/models/armor/leather_layer_" + n + ".png", null, false);
                try {
                    this.axG[n - 1] = bufferedImage == null ? InstanceRegistry_9.a("internal/textures/models/armor/leather_layer_" + n + "_base.png", this.axC) : (bl ? Found.a(bufferedImage, this.axC.uA) : bufferedImage);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    this.axG[n - 1] = InstanceRegistry_9.a("internal/textures/models/armor/leather_layer_" + n + "_base.png", this.axC);
                }
            }
            return this.axG[n - 1];
        }
        catch (IOException iOException) {
            CommandSenderBridge_5.error("Failed to load brown armor base layer texture: " + iOException.getMessage());
            return null;
        }
    }

    @Nullable
    private static BufferedImage fZ(String string) {
        return InstanceRegistry_9.a(string, null);
    }

    @Nullable
    public static BufferedImage a(String string, @Nullable Opaque009 opaque009) {
        InputStream inputStream = Main.rS().getResource(string);
        if (inputStream == null) {
            return null;
        }
        BufferedImage bufferedImage = ImageIO.read(new MemoryCacheImageInputStream(inputStream));
        if (opaque009 != null) {
            bufferedImage = Found.a(bufferedImage, opaque009.uA);
        }
        return bufferedImage;
    }

    private void a(BufferedImage bufferedImage, String string) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write((RenderedImage)bufferedImage, "PNG", byteArrayOutputStream);
        this.axL.put(string, byteArrayOutputStream);
    }

    public void Bi() {
        if (MaterialBarColorHolder.dz) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "Generating custom Optifine armors");
        }
        try {
            this.Bj();
            this.Bk();
        }
        catch (Exception exception) {
            CommandSenderBridge_5.error("[Optifine] Failed to generate vanilla leather armor textures.");
            exception.printStackTrace();
        }
        int n = 0;
        for (Map.Entry entry : ItemStackRegistry.g().C.entrySet()) {
            Found found;
            MaterialBridge_6 materialBridge_6;
            ColorBridge_2 colorBridge_2;
            if (!(entry.getValue() instanceof MaterialBridge_6) || (colorBridge_2 = (materialBridge_6 = (MaterialBridge_6)entry.getValue()).mB()) == null || (found = new Found(colorBridge_2, colorBridge_2.HC.asRGB())).Ba()) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("nbt.display.color=" + materialBridge_6.getColor()).append("\n");
            stringBuilder.append("type=armor").append("\n");
            stringBuilder.append("items=").append(materialBridge_6.getType().toString().toLowerCase()).append("\n");
            String string = ColorBridge.a(colorBridge_2.HC, false) + "_1.png";
            String string2 = ColorBridge.a(colorBridge_2.HC, false) + "_2.png";
            if (!colorBridge_2.HI) {
                stringBuilder.append("texture.leather_layer_1_overlay=").append(string).append("\n");
                stringBuilder.append("texture.leather_layer_2_overlay=").append(string2).append("\n");
            }
            stringBuilder.append("texture.leather_layer_1=").append(string).append("\n");
            stringBuilder.append("texture.leather_layer_2=").append(string2).append("\n");
            stringBuilder.append("weight=9999").append("\n");
            if (this.a(stringBuilder.toString(), this.axJ + materialBridge_6.Gf + "_" + materialBridge_6.Gg + ".properties", materialBridge_6)) {
                try {
                    this.a(found.f(1, false), this.axJ + string);
                    this.a(found.f(2, false), this.axJ + string2);
                    if (found.bm(1)) {
                        this.a(found.g(1, false), this.axJ + string.replace(".png", "_e.png"));
                    }
                    if (found.bm(2)) {
                        this.a(found.g(2, false), this.axJ + string2.replace(".png", "_e.png"));
                    }
                    ++n;
                }
                catch (IOException iOException) {
                    CommandSenderBridge_5.error("Failed to save Optifine custom armor images: " + materialBridge_6.getNamespacedID());
                    iOException.printStackTrace();
                }
            }
            this.a(found, false, string, 1, materialBridge_6, colorBridge_2);
            this.a(found, true, string, 1, materialBridge_6, colorBridge_2);
            this.a(found, false, string2, 2, materialBridge_6, colorBridge_2);
            this.a(found, true, string2, 2, materialBridge_6, colorBridge_2);
        }
        if (MaterialBarColorHolder.dz) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "Generated " + n + " custom Optifine armors");
        }
    }

    private void Bj() {
        Found found = new Found(InstanceRegistry_9.fZ("internal/textures/models/armor/leather_layer_1_base.png"), InstanceRegistry_9.fZ("internal/textures/models/armor/leather_layer_2_base.png"));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("type=armor").append("\n");
        stringBuilder.append("items=").append("leather_helmet leather_chestplate leather_leggings leather_boots").append("\n");
        String string = "base_1.png";
        String string2 = "base_2.png";
        stringBuilder.append("texture.leather_layer_1=").append(string).append("\n");
        stringBuilder.append("texture.leather_layer_2=").append(string2).append("\n");
        this.a(found, stringBuilder, "base_leather", string, string2);
    }

    private void Bk() {
        Found found = new Found(InstanceRegistry_9.fZ("internal/textures/models/armor/leather_layer_1.png"), InstanceRegistry_9.fZ("internal/textures/models/armor/leather_layer_2.png"));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("type=armor").append("\n");
        stringBuilder.append("items=").append("leather_helmet leather_chestplate leather_leggings leather_boots").append("\n");
        String string = "custom_base_1.png";
        String string2 = "custom_base_2.png";
        stringBuilder.append("texture.leather_layer_1=").append(string).append("\n");
        stringBuilder.append("texture.leather_layer_2=").append(string2).append("\n");
        stringBuilder.append("nbt.itemsadder.namespace=pattern:*").append("\n");
        stringBuilder.append("weight=9997").append("\n");
        this.a(found, stringBuilder, "custom_base_leather", string, string2);
    }

    private void a(Found found, StringBuilder stringBuilder, String string, String string2, String string3) {
        if (this.a(stringBuilder.toString(), this.axJ + string + ".properties", null)) {
            try {
                this.a(found.f(1, false), this.axJ + string2);
                this.a(found.f(2, false), this.axJ + string3);
            }
            catch (IOException iOException) {
                CommandSenderBridge_5.error("Failed to save Optifine default vanilla armor images");
                iOException.printStackTrace();
            }
        }
    }

    private boolean a(String string, String string2, @Nullable ItemStackBuilder_4 itemStackBuilder_4) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(string.getBytes(StandardCharsets.UTF_8));
            this.axL.put(string2, byteArrayOutputStream);
        }
        catch (IOException iOException) {
            if (itemStackBuilder_4 != null) {
                CommandSenderBridge_5.error("Failed to write Optifine CIT for armor " + itemStackBuilder_4.getNamespacedID() + ". File: " + itemStackBuilder_4.nh());
            } else {
                CommandSenderBridge_5.error("Failed to write Optifine CIT for armor. Destination: " + string2);
            }
            iOException.printStackTrace();
            return false;
        }
        return true;
    }

    private void a(Found found, boolean bl, String string, int n, ItemStackBuilder_4 itemStackBuilder_4, ColorBridge_2 colorBridge_2) {
        if (bl && !found.bm(n)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = (int)(24.0f / ((float)colorBridge_2.HJ / 25.0f));
        stringBuilder.append("duration=").append(n2).append("\n");
        if (colorBridge_2.HK) {
            stringBuilder.append("interpolate=").append("true").append("\n");
        }
        stringBuilder.append("h=").append(found.d(n, false)).append("\n");
        stringBuilder.append("w=").append(found.bp(n)).append("\n");
        stringBuilder.append("x=0").append("\n");
        stringBuilder.append("y=0").append("\n");
        if (bl) {
            string = string.replace(".png", "_e.png");
        }
        stringBuilder.append("from=").append("./").append(string).append("\n");
        stringBuilder.append("to=").append("minecraft:optifine/cit/ia_generated_armors/").append(string).append("\n");
        String string2 = itemStackBuilder_4.Gf + "_" + itemStackBuilder_4.Gg + "_" + n + (bl ? "_e" : "") + "_animation.properties";
        if (this.a(stringBuilder.toString(), this.axK + string2, itemStackBuilder_4)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ImageIO.write((RenderedImage)(bl ? found.bo(n) : found.bn(n)), "PNG", byteArrayOutputStream);
                this.axL.put(this.axK + string, byteArrayOutputStream);
            }
            catch (IOException iOException) {
                CommandSenderBridge_5.error("Failed to save Optifine custom armor images: " + itemStackBuilder_4.getNamespacedID());
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
    public VectorBridge_3 Bl() {
        return this.e(CommandSenderBridge_5::error);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Nullable
    VectorBridge_3 e(Consumer consumer) {
        if (this.axD == null) {
            consumer.accept("Cannot calculate custom armor atlas dimensions: 'assets/minecraft/textures/models/armor/leather_layer_1.png' was not generated.");
            return null;
        }
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.axD.toByteArray());){
            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
            if (bufferedImage == null) {
                consumer.accept("Cannot calculate custom armor atlas dimensions: 'assets/minecraft/textures/models/armor/leather_layer_1.png' is not a readable PNG.");
                VectorBridge_3 vectorBridge_3 = null;
                return vectorBridge_3;
            }
            VectorBridge_3 vectorBridge_3 = new VectorBridge_3(bufferedImage.getWidth(), bufferedImage.getHeight(), 0);
            return vectorBridge_3;
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
