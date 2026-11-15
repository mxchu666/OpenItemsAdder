package itemsadder.m;

import itemsadder.m.sg;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

public class rf {
    public static final rf HO = new rf();
    public sg HP;
    public sg HQ;
    public sg HR;
    public sg HS;
    public sg HT;

    public void a(String string, float f, float f2) {
        this.HP = new sg(string, Sound.BLOCK_STONE_BREAK);
        this.HP.o(f);
        this.HP.p(f2);
    }

    public void b(String string, float f, float f2) {
        this.HQ = new sg(string, Sound.BLOCK_STONE_PLACE);
        this.HQ.o(f);
        this.HQ.p(f2);
    }

    public void c(String string, float f, float f2) {
        this.HR = new sg(string, Sound.BLOCK_STONE_HIT);
        this.HR.o(f);
        this.HR.p(f2);
    }

    public void d(String string, float f, float f2) {
        this.HS = new sg(string, Sound.BLOCK_STONE_STEP);
        this.HS.o(f);
        this.HS.p(f2);
    }

    public void e(String string, float f, float f2) {
        this.HT = new sg(string, Sound.BLOCK_STONE_FALL);
        this.HT.o(f);
        this.HT.p(f2);
    }

    public void a(sg sg2, Player player, Location location) {
        sg2.a(player, location, SoundCategory.BLOCKS);
    }

    public void O(Location location) {
        this.HP.a(location, SoundCategory.BLOCKS);
    }

    public void P(Location location) {
        this.HQ.a(location, SoundCategory.BLOCKS);
    }

    public void Q(Location location) {
        this.HR.a(location, SoundCategory.BLOCKS);
    }

    public void R(Location location) {
        this.HS.a(location, SoundCategory.BLOCKS);
    }

    public void S(Location location) {
        this.HT.a(location, SoundCategory.BLOCKS);
    }

    static {
        HO.a(null, 1.0f, 1.0f);
        HO.b(null, 1.0f, 1.0f);
        HO.c(null, 1.0f, 1.0f);
        HO.d(null, 1.0f, 1.0f);
        HO.e(null, 1.0f, 1.0f);
    }
}
