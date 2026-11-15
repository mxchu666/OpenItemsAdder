package itemsadder.m;

import itemsadder.m.Opaque140;
import itemsadder.m.PlayerBridge_15;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public abstract class WorldBridge_4
extends Opaque140 {
    public final List vI;
    int vJ;
    int vK;
    @Nullable
    Integer vL;
    boolean vM;
    public boolean vN;
    boolean vO;
    final boolean vP;
    final boolean vQ;
    final boolean vR;
    final boolean vS;
    private final boolean vT;
    private List vU;
    private List vV;
    String vW;
    @Nullable
    PlayerBridge_15 vX;
    int vY;
    boolean vZ = true;

    public WorldBridge_4(PlayerBridge_15 playerBridge_15, String string, String string2, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, List list) {
        super(string, string2);
        this.vX = playerBridge_15;
        this.vJ = n;
        this.vP = bl;
        this.vQ = bl2;
        this.vR = bl3;
        this.vS = bl4;
        this.vK = n;
        this.vI = list;
        boolean bl5 = this.vT = list.contains("*") || list.isEmpty();
        if (!this.vT) {
            this.vU = new ArrayList();
            this.vV = new ArrayList();
            for (World world : Bukkit.getWorlds()) {
                for (String string3 : list) {
                    if (string3.endsWith("*")) {
                        if ((string3 = string3.substring(0, string3.length() - 1)).startsWith("!")) {
                            string3 = string3.substring(1);
                            if (!world.getName().startsWith(string3)) continue;
                            this.vV.add(world);
                            continue;
                        }
                        if (!world.getName().startsWith(string3)) continue;
                        this.vU.add(world);
                        continue;
                    }
                    if (string3.startsWith("!")) {
                        string3 = string3.substring(1);
                        if (!world.getName().equals(string3)) continue;
                        this.vV.add(world);
                        continue;
                    }
                    if (!world.getName().equals(string3)) continue;
                    this.vU.add(world);
                }
            }
        }
        this.vN = bl;
        this.setVisible(this.vN);
    }

    @Deprecated
    public abstract WorldBridge_4 a(PlayerBridge_15 var1);

    public boolean g(World world) {
        if (this.vT) {
            return true;
        }
        if (this.vV.contains(world)) {
            return false;
        }
        if (this.vU.contains(world)) {
            return true;
        }
        return this.vU.isEmpty() && !this.vV.contains(world);
    }

    public void setVisible(boolean bl) {
        if (this.vM == bl) {
            return;
        }
        this.vM = bl;
        if (bl) {
            this.vN = true;
        }
        this.jM();
    }

    public void X(int n) {
        this.vJ = n;
    }

    public int jH() {
        return this.vK;
    }

    public int jI() {
        return this.vJ;
    }

    public abstract int jJ();

    public abstract String jK();

    public boolean jL() {
        if (!this.vO) {
            return false;
        }
        if (!this.vM) {
            return false;
        }
        if (this.vX == null) {
            return false;
        }
        Player player = this.vX.xd;
        return !(player.getGameMode() == GameMode.SPECTATOR || !this.vQ && player.getGameMode() == GameMode.CREATIVE || !this.vR && player.getRemainingAir() < player.getMaximumAir() || !this.vS && player.isInsideVehicle());
    }

    public void Y(int n) {
        if (this.vL != null) {
            if (this.vL == n) {
                return;
            }
            this.vY = this.vL;
        }
        this.vL = n;
        this.jM();
    }

    public void jM() {
        if (this.vX != null) {
            this.vX.recalculateOffsets();
        }
        this.vZ = true;
        this.vW = null;
    }

    @Generated
    public boolean isVisible() {
        return this.vM;
    }

    @Generated
    public boolean jN() {
        return this.vO;
    }

    @Generated
    public void aa(boolean bl) {
        this.vO = bl;
    }

    @Generated
    public boolean jO() {
        return this.vP;
    }

    @Generated
    public boolean jP() {
        return this.vQ;
    }

    @Generated
    public boolean jQ() {
        return this.vR;
    }

    @Generated
    public boolean jR() {
        return this.vS;
    }

    @Generated
    public boolean jS() {
        return this.vZ;
    }
}
