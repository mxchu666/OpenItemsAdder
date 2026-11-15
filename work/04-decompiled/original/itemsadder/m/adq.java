package itemsadder.m;

import com.comphenix.protocol.events.PacketContainer;
import com.destroystokyo.paper.profile.PlayerProfile;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.lone.itemsadder.resourcepack.f;
import itemsadder.m.aab;
import itemsadder.m.adr;
import itemsadder.m.ads;
import itemsadder.m.ae;
import itemsadder.m.aiq;
import itemsadder.m.aow;
import itemsadder.m.are;
import itemsadder.m.ark;
import itemsadder.m.bbk;
import itemsadder.m.bbp;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.bcz;
import itemsadder.m.bda;
import itemsadder.m.da;
import itemsadder.m.do;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import lombok.Generated;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerTextures;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2d;

public abstract class adq {
    public static Cache Xq = CacheBuilder.newBuilder().expireAfterWrite(60L, TimeUnit.MINUTES).build();
    public static final double Xr = 1.975;
    public static final double Xs = 0.562;
    public static final double Xt = 0.4375;
    @Deprecated
    public static final double Xu = 1.5375;
    public static final double Xv = 1.8;
    public static final double Xw = 0.9;
    public static final double Xx = 1.2;
    public static final double Xy = 1.413;
    public static float Xz = 0.68f;
    public static float XA = 3.0f;
    public final List XB = List.of(ads.a(new Vector2d(8.0, 8.0), new Vector2d(8.0, 8.0)), ads.a(new Vector2d(24.0, 8.0), new Vector2d(8.0, 8.0)), ads.a(new Vector2d(0.0, 8.0), new Vector2d(8.0, 8.0)), ads.a(new Vector2d(16.0, 8.0), new Vector2d(8.0, 8.0)), ads.a(new Vector2d(8.0, 0.0), new Vector2d(8.0, 8.0)), ads.a(new Vector2d(16.0, 0.0), new Vector2d(8.0, 8.0)));
    public final List XC = List.of(ads.a(new Vector2d(40.0, 8.0), new Vector2d(8.0, 8.0)), ads.a(new Vector2d(56.0, 8.0), new Vector2d(8.0, 8.0)), ads.a(new Vector2d(32.0, 8.0), new Vector2d(8.0, 8.0)), ads.a(new Vector2d(48.0, 8.0), new Vector2d(8.0, 8.0)), ads.a(new Vector2d(40.0, 0.0), new Vector2d(8.0, 8.0)), ads.a(new Vector2d(48.0, 0.0), new Vector2d(8.0, 8.0)));
    public final List XD = List.of(ads.a(new Vector2d(20.0, 20.0), new Vector2d(8.0, 12.0)), ads.a(new Vector2d(32.0, 20.0), new Vector2d(8.0, 12.0)), ads.a(new Vector2d(28.0, 20.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(16.0, 20.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(20.0, 16.0), new Vector2d(8.0, 4.0)), ads.a(new Vector2d(28.0, 16.0), new Vector2d(8.0, 4.0)));
    public final List XE = List.of(ads.a(new Vector2d(20.0, 36.0), new Vector2d(8.0, 12.0)), ads.a(new Vector2d(32.0, 36.0), new Vector2d(8.0, 12.0)), ads.a(new Vector2d(28.0, 36.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(16.0, 36.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(20.0, 32.0), new Vector2d(8.0, 4.0)), ads.a(new Vector2d(28.0, 32.0), new Vector2d(8.0, 4.0)));
    public final List XF = List.of(ads.a(new Vector2d(36.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(44.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(40.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(32.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(36.0, 48.0), new Vector2d(4.0, 4.0)), ads.a(new Vector2d(40.0, 48.0), new Vector2d(4.0, 4.0)));
    public final List XG = List.of(ads.a(new Vector2d(52.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(60.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(56.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(48.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(52.0, 48.0), new Vector2d(4.0, 4.0)), ads.a(new Vector2d(56.0, 48.0), new Vector2d(4.0, 4.0)));
    public final List XH = List.of(ads.a(new Vector2d(36.0, 52.0), new Vector2d(3.0, 12.0)), ads.a(new Vector2d(43.0, 52.0), new Vector2d(3.0, 12.0)), ads.a(new Vector2d(32.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(39.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(36.0, 48.0), new Vector2d(3.0, 4.0)), ads.a(new Vector2d(39.0, 48.0), new Vector2d(3.0, 4.0)));
    public final List XI = List.of(ads.a(new Vector2d(52.0, 52.0), new Vector2d(3.0, 12.0)), ads.a(new Vector2d(59.0, 52.0), new Vector2d(3.0, 12.0)), ads.a(new Vector2d(48.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(55.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(52.0, 48.0), new Vector2d(3.0, 4.0)), ads.a(new Vector2d(55.0, 48.0), new Vector2d(3.0, 4.0)));
    public final List XJ = List.of(ads.a(new Vector2d(44.0, 20.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(52.0, 20.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(48.0, 20.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(40.0, 20.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(44.0, 16.0), new Vector2d(4.0, 4.0)), ads.a(new Vector2d(48.0, 16.0), new Vector2d(4.0, 4.0)));
    public final List XK = List.of(ads.a(new Vector2d(44.0, 36.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(52.0, 36.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(48.0, 36.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(40.0, 36.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(44.0, 32.0), new Vector2d(4.0, 4.0)), ads.a(new Vector2d(48.0, 35.0), new Vector2d(4.0, 4.0)));
    public final List XL = List.of(ads.a(new Vector2d(44.0, 20.0), new Vector2d(3.0, 12.0)), ads.a(new Vector2d(51.0, 20.0), new Vector2d(3.0, 12.0)), ads.a(new Vector2d(40.0, 20.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(47.0, 20.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(44.0, 16.0), new Vector2d(3.0, 4.0)), ads.a(new Vector2d(47.0, 16.0), new Vector2d(3.0, 4.0)));
    public final List XM = List.of(ads.a(new Vector2d(44.0, 36.0), new Vector2d(3.0, 12.0)), ads.a(new Vector2d(51.0, 36.0), new Vector2d(3.0, 12.0)), ads.a(new Vector2d(40.0, 36.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(47.0, 36.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(44.0, 32.0), new Vector2d(3.0, 4.0)), ads.a(new Vector2d(47.0, 35.0), new Vector2d(3.0, 4.0)));
    public final List XN = List.of(ads.a(new Vector2d(20.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(28.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(16.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(24.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(20.0, 48.0), new Vector2d(4.0, 4.0)), ads.a(new Vector2d(24.0, 48.0), new Vector2d(4.0, 4.0)));
    public final List XO = List.of(ads.a(new Vector2d(4.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(12.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(8.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(0.0, 52.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(4.0, 48.0), new Vector2d(4.0, 4.0)), ads.a(new Vector2d(8.0, 48.0), new Vector2d(4.0, 4.0)));
    public final List XP = List.of(ads.a(new Vector2d(4.0, 20.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(12.0, 20.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(0.0, 20.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(8.0, 20.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(4.0, 16.0), new Vector2d(4.0, 4.0)), ads.a(new Vector2d(8.0, 16.0), new Vector2d(4.0, 4.0)));
    public final List XQ = List.of(ads.a(new Vector2d(4.0, 36.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(12.0, 36.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(0.0, 36.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(8.0, 36.0), new Vector2d(4.0, 12.0)), ads.a(new Vector2d(4.0, 32.0), new Vector2d(4.0, 4.0)), ads.a(new Vector2d(8.0, 32.0), new Vector2d(4.0, 4.0)));
    protected final HashMap XR = new HashMap();
    protected final HashMap XS = new HashMap();
    public boolean XT;
    protected bcz XU;
    protected bcz XV;
    protected bcz XW;
    protected bcz XX;
    protected bcz XY;
    protected bcz XZ;
    public int Ya;
    public int Yb;
    public Location Yc;
    protected boolean Yd = true;
    protected boolean Ye = true;
    protected boolean Yf = true;
    public boolean Yg = false;
    @Nullable
    protected String playerSkin;
    protected final boolean Yh;
    protected boolean Yi = false;
    protected int JJ = 0xFFFFFF;
    static Constructor WD;
    public EquipmentSlot Yj;
    protected double Yk;
    static double Yl;
    static float Ym;

    public static adq a(Location location, EquipmentSlot equipmentSlot, boolean bl, boolean bl2, boolean bl3) {
        if (WD == null && (WD = aab.a(adq.class, false, Location.class, EquipmentSlot.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE)) == null) {
            throw new RuntimeException("Failed to get constructor for the client entity.");
        }
        try {
            adq adq2 = (adq)WD.newInstance(location, equipmentSlot, bl, bl2, bl3);
            adq2.Yj = equipmentSlot;
            return adq2;
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException reflectiveOperationException) {
            bce.error("Error getting constructor for ClientEntity", reflectiveOperationException);
            return null;
        }
    }

    protected adq(Location location, boolean bl) {
        this.Yh = bl;
        this.Yc = location.clone();
        this.Yc.setPitch(0.0f);
        this.Yc.setYaw(0.0f);
    }

    protected static ItemStack dy(String string) {
        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        if (itemStack.getType() == Material.PLAYER_HEAD) {
            if (string.length() > 16) {
                aiq.tX().c(itemStack, string);
            } else {
                SkullMeta skullMeta = (SkullMeta)itemStack.getItemMeta();
                skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer((String)string));
                itemStack.setItemMeta((ItemMeta)skullMeta);
            }
        }
        return itemStack;
    }

    public void tq() {
        this.XR.clear();
        this.XS.clear();
    }

    public double[] tr() {
        return new double[]{this.XZ.akd, this.XZ.ake, this.XZ.akf};
    }

    public double[] ts() {
        return new double[]{this.XY.akd, this.XY.ake, this.XY.akf};
    }

    public Location tt() {
        return new Location(this.Yc.getWorld(), this.Yc.getX(), this.Yc.getY() + 1.9, this.Yc.getZ());
    }

    public Location tu() {
        return this.Yc;
    }

    public double[] tv() {
        double[] dArray = this.ts();
        dArray[1] = dArray[1] + 1.5375;
        return dArray;
    }

    public abstract void c(float var1, float var2, float var3);

    public boolean q(float f) {
        if (adq.r(f) == adq.r(this.Yc.getYaw())) {
            return false;
        }
        this.Yc.setYaw(f);
        this.Ye = true;
        return true;
    }

    public void a(double d, double d2, double d3, bda bda2) {
        double d4 = d + (double)bda2.aBp;
        double d5 = d2 + (double)bda2.aBq;
        double d6 = d3 + (double)bda2.aBr;
        this.d(d4, d5, d6);
    }

    public static boolean b(double d, double d2) {
        return bbk.q(d2 - d) <= Yl;
    }

    public static boolean c(float f, float f2) {
        return bbk.A(f2 - f) <= Ym;
    }

    public void d(double d, double d2, double d3) {
        this.a(d, d2, d3, false);
    }

    public void a(double d, double d2, double d3, boolean bl) {
        if (!bl && adq.b(d, this.XZ.akd) && adq.b(d2, this.XZ.ake) && adq.b(d3, this.XZ.akf)) {
            return;
        }
        this.XZ.i(d, d2, d3);
        this.XY.i(d, d2 + this.Yk + 0.12, d3);
        this.Yc.setX(d);
        this.Yc.setY(d2);
        this.Yc.setZ(d3);
        this.Yd = true;
    }

    public void b(List list, int n) {
        this.e(list, n);
    }

    public void c(List list, int n) {
        this.d(list, n);
    }

    public abstract void v(List var1);

    public abstract void h(do var1);

    public abstract void f(do var1);

    public abstract void d(List var1, int var2);

    public abstract void a(do var1, int var2);

    public abstract void e(List var1, int var2);

    public abstract void a(@Nullable Player var1, List var2, ItemStack var3);

    public abstract void w(List var1);

    public abstract void a(boolean var1, @Nullable LivingEntity var2, List var3);

    public void tw() {
        bcz bcz2 = this.XZ.Dw();
        bcz bcz3 = this.XY.Dw();
        adq.a(bcz2, this.XU, Xz);
        adq.a(bcz3, this.XV, Xz);
        this.XU = bcz2.Dw();
        this.XV = bcz3.Dw();
        bcz2 = this.XZ.Dw();
        bcz3 = this.XY.Dw();
        adq.a(bcz2, this.XW, XA);
        adq.a(bcz3, this.XX, XA);
        this.XW = bcz2.Dw();
        this.XX = bcz3.Dw();
    }

    public abstract void x(List var1);

    public abstract void bK(Player var1);

    public abstract void b(Player var1, Object var2);

    public static byte r(float f) {
        return (byte)(f * 256.0f / 360.0f);
    }

    public void a(Player player, are are2) {
        are2.cc(player);
    }

    public void a(Player player, PacketContainer packetContainer) {
        aow.a(player, packetContainer, false);
    }

    public void a(List list, LivingEntity livingEntity) {
        ark ark2 = new ark();
        ark2.aM(this.Yb);
        ark2.a(new int[]{livingEntity.getEntityId()});
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (!do_.fl()) continue;
            this.a(do_.iW, ark2);
        }
    }

    public void b(List list, boolean bl) {
        if (bl == this.XT) {
            return;
        }
        this.XT = bl;
        this.x(list);
    }

    public void dz(@Nullable String string) {
        this.playerSkin = string;
    }

    public void tx() {
        this.Yf = true;
        this.Yd = true;
        this.Ye = true;
    }

    public void setColor(int n) {
        this.JJ = n;
        this.tq();
    }

    public boolean getEnchanted() {
        return this.Yi;
    }

    public void setEnchanted(boolean bl) {
        this.Yi = bl;
        this.tq();
    }

    public static void a(bcz bcz2, bcz bcz3, float f) {
        bcz2.akd = bcz3.akd + (bcz2.akd - bcz3.akd) / (double)f;
        bcz2.ake = bcz3.ake + (bcz2.ake - bcz3.ake) / (double)f;
        bcz2.akf = bcz3.akf + (bcz2.akf - bcz3.akf) / (double)f;
    }

    private ItemStack a(BufferedImage bufferedImage, NamespacedKey namespacedKey, List list, @Nullable List list2) {
        int n;
        int n2;
        int n3;
        int n4;
        int[] nArray;
        BufferedImage bufferedImage2;
        bce.iA(namespacedKey.asString());
        ArrayList<Color> arrayList = new ArrayList<Color>();
        ArrayList<Boolean> arrayList2 = new ArrayList<Boolean>();
        for (ads ads2 : list) {
            bufferedImage2 = bufferedImage.getSubimage((int)ads2.tB().x, (int)ads2.tB().y, (int)ads2.tC().x, (int)ads2.tC().y);
            for (int n5 : nArray = bbp.d(bufferedImage2)) {
                n4 = n5 >> 24 & 0xFF;
                if (n4 > 0) {
                    n3 = n5 >> 16 & 0xFF;
                    n2 = n5 >> 8 & 0xFF;
                    n = n5 & 0xFF;
                    arrayList.add(Color.fromRGB((int)n3, (int)n2, (int)n));
                    continue;
                }
                arrayList.add(Color.BLACK);
            }
        }
        if (list2 != null) {
            for (ads ads2 : list2) {
                bufferedImage2 = bufferedImage.getSubimage((int)ads2.tB().x, (int)ads2.tB().y, (int)ads2.tC().x, (int)ads2.tC().y);
                for (int n5 : nArray = bbp.d(bufferedImage2)) {
                    n4 = n5 >> 24 & 0xFF;
                    if (n4 > 0) {
                        n3 = n5 >> 16 & 0xFF;
                        n2 = n5 >> 8 & 0xFF;
                        n = n5 & 0xFF;
                        arrayList.add(Color.fromRGB((int)n3, (int)n2, (int)n));
                        arrayList2.add(true);
                        continue;
                    }
                    arrayList.add(Color.RED);
                    arrayList2.add(false);
                }
            }
        }
        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        aiq.tX().d(itemStack, namespacedKey.toString());
        aiq.tX().a(itemStack, arrayList);
        aiq.tX().b(itemStack, arrayList2);
        return itemStack;
    }

    @NotNull
    public static PlayerTextures bL(Player player) {
        PlayerProfile playerProfile = player.getPlayerProfile();
        if (!playerProfile.isComplete() || playerProfile.getTextures().isEmpty()) {
            playerProfile = Bukkit.createProfile((UUID)player.getUniqueId());
        }
        return playerProfile.getTextures();
    }

    @Nullable
    public static String dA(String string) {
        if (string.length() < 100) {
            Player player = Bukkit.getPlayer((String)string);
            if (player == null) {
                throw new IllegalStateException("Invalid Base64 value and player not found: " + string);
            }
            URL uRL = adq.bL(player).getSkin();
            if (uRL != null) {
                return uRL.toString();
            }
            return null;
        }
        String string2 = new String(Base64.getDecoder().decode(string));
        JsonObject jsonObject = JsonParser.parseString(string2).getAsJsonObject();
        JsonObject jsonObject2 = jsonObject.getAsJsonObject("textures");
        if (jsonObject2 == null || !jsonObject2.has("SKIN")) {
            throw new IllegalStateException("SKIN object not present in textures");
        }
        JsonObject jsonObject3 = jsonObject2.getAsJsonObject("SKIN");
        return jsonObject3.get("url").getAsString();
    }

    public static BufferedImage dB(String string) {
        try (HttpClient httpClient = HttpClient.newHttpClient();){
            HttpResponse<InputStream> httpResponse = httpClient.send(HttpRequest.newBuilder(URI.create(string)).GET().build(), HttpResponse.BodyHandlers.ofInputStream());
            BufferedImage bufferedImage = ImageIO.read(httpResponse.body());
            return bufferedImage;
        }
    }

    public ItemStack c(int n, @NotNull String string) {
        adr adr2;
        if (!ae.dy) {
            ItemStack itemStack = adq.dy(this.playerSkin);
            bbs.b(itemStack, n);
            return itemStack;
        }
        try {
            adr2 = (adr)Xq.getIfPresent(string);
            if (adr2 == null) {
                BufferedImage bufferedImage;
                boolean bl = false;
                String string2 = adq.dA(string);
                if (string2 != null) {
                    bufferedImage = adq.dB(string2);
                    if (bufferedImage.getHeight() == 64) {
                        bl = bbp.e(bufferedImage);
                    } else {
                        bufferedImage = da.dr();
                    }
                } else {
                    bufferedImage = da.dr();
                }
                adr2 = new adr(string, bufferedImage, bl);
                Xq.put(string, adr2);
            }
        }
        catch (Exception exception) {
            bce.error("Failed to load texture", exception);
            return new ItemStack(Material.BARRIER);
        }
        ItemStack itemStack = n == f.aqw ? this.a(adr2.Yo, new NamespacedKey("_iainternal", "player_model/head"), this.XB, this.XC) : (n == f.aqy ? this.a(adr2.Yo, new NamespacedKey("_iainternal", "player_model/torso"), this.XD, this.XE) : (n == f.aqx ? (!adr2.Yp ? this.a(adr2.Yo, new NamespacedKey("_iainternal", "player_model/left_arm"), this.XF, this.XG) : this.a(adr2.Yo, new NamespacedKey("_iainternal", "player_model/left_arm_slim"), this.XH, this.XI)) : (n == f.aqB ? (!adr2.Yp ? this.a(adr2.Yo, new NamespacedKey("_iainternal", "player_model/right_arm"), this.XJ, this.XK) : this.a(adr2.Yo, new NamespacedKey("_iainternal", "player_model/right_arm_slim"), this.XL, this.XM)) : (n == f.aqz ? this.a(adr2.Yo, new NamespacedKey("_iainternal", "player_model/left_leg"), this.XN, this.XO) : (n == f.aqA ? this.a(adr2.Yo, new NamespacedKey("_iainternal", "player_model/right_leg"), this.XP, this.XQ) : adq.dy(this.playerSkin))))));
        return itemStack;
    }

    @Generated
    public int getColor() {
        return this.JJ;
    }

    static {
        Yl = 0.001;
        Ym = 1.0E-5f;
    }
}
