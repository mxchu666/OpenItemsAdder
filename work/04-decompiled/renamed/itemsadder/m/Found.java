package itemsadder.m;

import itemsadder.m.ColorBridge_2;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.Opaque009;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.Nullable;

class Found {
    public static final int axr = 32;
    public static final int axs = 64;
    @Nullable
    public ColorBridge_2 axt;
    public BufferedImage[] axu = new BufferedImage[2];
    public BufferedImage[] axv = new BufferedImage[2];
    public int axw;

    public Found(BufferedImage bufferedImage, BufferedImage bufferedImage2) {
        this.axu[0] = bufferedImage;
        this.axu[1] = bufferedImage2;
    }

    public Found(@Nullable ColorBridge_2 colorBridge_2, int n) {
        this.axt = colorBridge_2;
        this.axw = n;
        if (colorBridge_2 == null) {
            this.axt = null;
            return;
        }
        this.axu[0] = Found.a(colorBridge_2.HD, colorBridge_2);
        this.axu[1] = Found.a(colorBridge_2.HE, colorBridge_2);
        this.axv[0] = Found.a(colorBridge_2.HF, colorBridge_2);
        this.axv[1] = Found.a(colorBridge_2.HG, colorBridge_2);
        if (Found.a(this.axu[0], this.axv[0])) {
            CommandSenderBridge_5.error(String.valueOf(ChatColor.RED) + "Error: layer_1 and emissive_1 texture have different size for item " + colorBridge_2.getNamespacedID() + ". File: " + colorBridge_2.HB.nh());
            this.axu[0] = null;
            this.axv[0] = null;
        }
        if (Found.a(this.axu[1], this.axv[1])) {
            CommandSenderBridge_5.error(String.valueOf(ChatColor.RED) + "Error: layer_2 and emissive_2 texture have different size for item " + colorBridge_2.getNamespacedID() + ". File: " + colorBridge_2.HB.nh());
            this.axu[1] = null;
            this.axv[1] = null;
        }
    }

    public Found(BufferedImage bufferedImage, BufferedImage bufferedImage2, BufferedImage bufferedImage3, BufferedImage bufferedImage4, int n) {
        this.axw = n;
        this.axu[0] = bufferedImage;
        this.axu[1] = bufferedImage2;
        this.axv[0] = bufferedImage3;
        this.axv[1] = bufferedImage4;
        if (Found.a(this.axu[0], this.axv[0])) {
            CommandSenderBridge_5.error(String.valueOf(ChatColor.RED) + "Error: layer_1 and emissive_1 texture have different size!");
            this.axu[0] = null;
            this.axv[0] = null;
        }
        if (Found.a(this.axu[1], this.axv[1])) {
            CommandSenderBridge_5.error(String.valueOf(ChatColor.RED) + "Error: layer_2 and emissive_2 texture have different size!");
            this.axu[1] = null;
            this.axv[1] = null;
        }
    }

    public boolean Ba() {
        if (this.axu == null) {
            return true;
        }
        return this.axu[0] == null || this.axu[1] == null;
    }

    public boolean bm(int n) {
        if (this.axv == null) {
            return false;
        }
        return this.axv[n - 1] != null;
    }

    @Nullable
    private static BufferedImage a(String string, @Nullable ColorBridge_2 colorBridge_2) {
        return Found.a(string, colorBridge_2, true);
    }

    @Nullable
    static BufferedImage a(String string, @Nullable ColorBridge_2 colorBridge_2, boolean bl) {
        if (string == null) {
            return null;
        }
        File file = ItemStackRegistry.s(string);
        if (file == null || !file.exists()) {
            if (bl) {
                Found.a("not found", string, colorBridge_2, null);
            }
            return null;
        }
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            if (bufferedImage == null) {
                if (bl) {
                    Found.a("is not a readable PNG", string, colorBridge_2, null);
                }
                return null;
            }
            BufferedImage bufferedImage2 = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 2);
            bufferedImage2.getGraphics().drawImage(bufferedImage, 0, 0, null);
            return bufferedImage2;
        }
        catch (IOException iOException) {
            if (bl) {
                Found.a("could not be read", string, colorBridge_2, iOException.getMessage());
            }
            return null;
        }
    }

    private static void a(String string, String string2, @Nullable ColorBridge_2 colorBridge_2, @Nullable String string3) {
        String string4 = colorBridge_2 == null ? "" : " for '" + colorBridge_2.getNamespacedID() + "' (config: " + colorBridge_2.HB.nh() + ")";
        Object object = string3 == null ? "" : ": " + string3;
        CommandSenderBridge_5.error(String.valueOf(ChatColor.RED) + "Armor PNG '" + string2 + "' " + string + string4 + (String)object);
    }

    public BufferedImage bn(int n) {
        return this.axu[n - 1];
    }

    public BufferedImage bo(int n) {
        return this.axv[n - 1];
    }

    private static boolean a(BufferedImage bufferedImage, BufferedImage bufferedImage2) {
        if (bufferedImage == null || bufferedImage2 == null) {
            return false;
        }
        return bufferedImage.getWidth() != bufferedImage2.getWidth() || bufferedImage.getHeight() != bufferedImage2.getHeight();
    }

    private static BufferedImage b(@Nullable BufferedImage bufferedImage, int n, int n2) {
        if (bufferedImage == null) {
            return null;
        }
        if (bufferedImage.getWidth() == n && bufferedImage.getHeight() == n2) {
            return bufferedImage;
        }
        Image image = bufferedImage.getScaledInstance(n, n2, 1);
        BufferedImage bufferedImage2 = new BufferedImage(n, n2, 2);
        bufferedImage2.getGraphics().drawImage(image, 0, 0, null);
        return bufferedImage2;
    }

    public static BufferedImage a(@Nullable BufferedImage bufferedImage, int n) {
        if (bufferedImage == null) {
            return null;
        }
        int n2 = n / bufferedImage.getWidth();
        return Found.b(bufferedImage, n, bufferedImage.getHeight() * n2);
    }

    public BufferedImage a(int n, Opaque009 opaque009) {
        return Found.a(this.axu[n - 1], opaque009.uA);
    }

    @Nullable
    public BufferedImage b(int n, Opaque009 opaque009) {
        return Found.a(this.axv[n - 1], opaque009.uA);
    }

    public int bp(int n) {
        BufferedImage bufferedImage = this.axu[n - 1];
        if (bufferedImage == null) {
            return 0;
        }
        return bufferedImage.getWidth();
    }

    public int bq(int n) {
        return this.d(n, true);
    }

    public int d(int n, boolean bl) {
        BufferedImage bufferedImage = this.axu[n - 1];
        if (bufferedImage == null) {
            return 0;
        }
        int n2 = this.e(n, bl);
        return bufferedImage.getHeight() / n2;
    }

    public int br(int n) {
        return this.e(n, true);
    }

    public int e(int n, boolean bl) {
        BufferedImage bufferedImage = this.axu[n - 1];
        if (bufferedImage == null) {
            return 1;
        }
        int n2 = bufferedImage.getWidth() / 64;
        return bufferedImage.getHeight() / n2 / 32;
    }

    public BufferedImage bs(int n) {
        return this.axu[n - 1];
    }

    public BufferedImage bt(int n) {
        return this.f(n, true);
    }

    public BufferedImage f(int n, boolean bl) {
        BufferedImage bufferedImage = this.axu[n - 1];
        return Found.c(bufferedImage, bufferedImage.getWidth(), this.d(n, bl));
    }

    public BufferedImage bu(int n) {
        return this.g(n, true);
    }

    public BufferedImage g(int n, boolean bl) {
        BufferedImage bufferedImage = this.axv[n - 1];
        return Found.c(bufferedImage, bufferedImage.getWidth(), this.d(n, bl));
    }

    private static BufferedImage c(BufferedImage bufferedImage, int n, int n2) {
        return bufferedImage.getSubimage(0, 0, n, n2);
    }
}
