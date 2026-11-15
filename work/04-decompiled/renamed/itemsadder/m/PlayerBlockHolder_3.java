package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.CustomBlockBreakEvent;
import dev.lone.itemsadder.s;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.MsgEnum;
import itemsadder.m.PacketContainerHolder;
import itemsadder.m.PlayerBlockHolder_2;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PlayerJoinListener_5;
import itemsadder.m.RealEnum;
import java.util.UUID;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class PlayerBlockHolder_3 {
    private final Player AJ;
    Block Ae;
    LocationBridgeBuilder_2 Af;
    ItemStack AK;
    BlockBridge_9 Ag;
    Vector AL;
    long AM;
    long AN;
    int AO = -1;
    private boolean AP;
    BukkitTask AQ;
    private long AR;
    private long AS;
    private long AT;
    private volatile boolean AU;
    private final UUID AV;
    private final int AW;
    private final int AX;
    private final int AY;
    private final int AZ;

    public PlayerBlockHolder_3(Block block, Player player, LocationBridgeBuilder_2 locationBridgeBuilder_2, BlockBridge_9 blockBridge_9) {
        this.Ae = block;
        this.AJ = player;
        this.Af = locationBridgeBuilder_2;
        this.Ag = blockBridge_9;
        this.AL = block.getLocation().toVector();
        this.AV = block.getWorld().getUID();
        this.AW = block.getX();
        this.AX = block.getY();
        this.AY = block.getZ();
        this.AZ = -player.getEntityId();
    }

    public void lv() {
        this.ab(-1);
        this.AK = this.AJ.getInventory().getItemInMainHand();
        this.AS = (long)(this.lB() * 1.0E9f);
        this.AP = this.Af.p(this.AK);
        if (this.AS <= 10000000L) {
            this.lz();
            return;
        }
        this.AT = this.AS / 10L;
        this.AM = 0L;
        this.AN = 0L;
        this.AR = System.nanoTime();
        if (!this.AP) {
            this.aL(this.AJ);
        }
        this.AQ = BukkitTaskBridge.b(bukkitRunnable -> {
            if (System.nanoTime() - this.AR <= 500000000L) {
                return;
            }
            this.lx();
        }, 0L, 1L);
    }

    public boolean lw() {
        if (this.AM >= this.AS) {
            this.lz();
            return true;
        }
        if (!this.AK.equals((Object)this.AJ.getInventory().getItemInMainHand())) {
            this.ae(false);
            this.lv();
            return false;
        }
        this.AM += System.nanoTime() - this.AR;
        this.AN += System.nanoTime() - this.AR;
        this.AR = System.nanoTime();
        if (this.AN >= this.AT) {
            ++this.AO;
            this.AN = 0L;
        }
        this.ab(this.AO);
        return false;
    }

    public void lx() {
        this.ae(true);
    }

    public void ae(boolean bl) {
        this.ly();
        this.ab(-1);
        if (bl) {
            PlayerJoinListener_5.lF().ak(this.AJ);
        }
    }

    public void ly() {
        if (this.AQ != null) {
            this.AQ.cancel();
        }
    }

    public void lz() {
        if (this.AU) {
            return;
        }
        Location location = this.Ae.getLocation();
        this.AU = true;
        this.ly();
        if (PlayerJoinListener_5.lF().b(location) || this.Ag.H(location) == null) {
            this.lA();
            return;
        }
        PlayerJoinListener_5.lF().a(location, this);
        BukkitTaskBridge.i(() -> {
            if (s.b((HumanEntity)this.AJ, this.Af.kL()) && LocationBridge_2.a(this.Ae, this.AJ)) {
                PlayerBlockHolder_2 playerBlockHolder_2 = new PlayerBlockHolder_2(this.AJ, this.Ae, this.Af, this.Ag);
                playerBlockHolder_2.ac(this.AP);
                MsgEnum msgEnum = this.a(this.AJ, playerBlockHolder_2);
                if (msgEnum == MsgEnum.CANCEL) {
                    if (this.Ae.getType().getHardness() == 0.0f) {
                        this.Af.e(this.Ae, false);
                    }
                } else {
                    CustomBlockBreakEvent customBlockBreakEvent = new CustomBlockBreakEvent(this.AJ, this.Ae, this.Af);
                    customBlockBreakEvent.setCancelled(playerBlockHolder_2.isCancelled());
                    if (ListenerBridge.b((Event)customBlockBreakEvent) && ListenerBridge.b(playerBlockHolder_2)) {
                        BukkitTaskBridge.i(() -> ItemStackBuilder_4.a(1, this.AJ));
                    }
                }
            }
            PlayerJoinListener_5.lF().b(location, this);
            this.lA();
        });
    }

    private void lA() {
        BukkitTaskBridge.b(() -> this.ab(-1), 2L);
        PlayerJoinListener_5.lF().ak(this.AJ);
    }

    private MsgEnum a(Player player, PlayerBlockHolder_2 playerBlockHolder_2) {
        MsgEnum msgEnum = MsgEnum.RIGHT_TOOL;
        if (player.getGameMode() == GameMode.CREATIVE) {
            msgEnum = MsgEnum.CREATIVE_ALLOW;
        }
        if (!MaterialBarColorHolder.fp && !MaterialBarColorHolder.fq) {
            msgEnum = MsgEnum.WRONG_BUT_DO_NOTHING;
        }
        if (!this.AP) {
            if (this.aL(player)) {
                msgEnum = MsgEnum.MSG;
            }
            if (MaterialBarColorHolder.fp) {
                if (playerBlockHolder_2 != null) {
                    playerBlockHolder_2.setCancelled(true);
                }
                msgEnum = MsgEnum.CANCEL;
            }
            if (playerBlockHolder_2 != null) {
                playerBlockHolder_2.ac(false);
            }
        }
        return msgEnum;
    }

    private boolean aL(Player player) {
        if (MaterialBarColorHolder.fq) {
            PacketContainerHolder.i(player, Main.PQ.ir("cannot-break-with-this-tool"));
            return true;
        }
        return false;
    }

    private void ab(int n) {
        if (this.Af.Hq == RealEnum.ENTITY) {
            ItemStackRegistry.g().X.a(this.AV, this.AW, this.AX, this.AY, this.AZ, n);
        } else {
            PlayerBlockHolder_3.a(this.AJ, this.AL, n, this.AZ);
        }
    }

    public static void a(Player player, Vector vector, int n, int n2) {
        PlayerHolder_4.a(player, vector, n, n2);
    }

    public float lB() {
        int n;
        float f = this.Af.FG;
        float f2 = 0.0f;
        float f3 = 1.0f;
        this.AP = this.Af.p(this.AK);
        f2 = this.AP ? f * 0.75f : f * 5.0f;
        if (this.AP) {
            f3 = ItemStackBridge_2.ar(this.AK) / 1.5f;
        }
        if (!this.AP && !ItemStackBridge_2.U(this.AK.getType())) {
            f3 = 0.2f;
        }
        if (this.AP && this.AK.hasItemMeta() && (n = this.AK.getItemMeta().getEnchantLevel(Enchantment.EFFICIENCY)) > 0) {
            f3 += (float)(n * n + 1);
        }
        if (this.AJ.hasPotionEffect(PotionEffectType.HASTE)) {
            f3 *= (float)(1.0 + 0.2 * (double)this.AJ.getPotionEffect(PotionEffectType.HASTE).getAmplifier());
        }
        if (this.AJ.hasPotionEffect(PotionEffectType.MINING_FATIGUE)) {
            f3 /= (float)(3 ^ this.AJ.getPotionEffect(PotionEffectType.MINING_FATIGUE).getAmplifier());
        }
        f2 /= f3;
        if (this.AJ.isInWater()) {
            f2 *= 5.0f;
        }
        return f2;
    }
}
