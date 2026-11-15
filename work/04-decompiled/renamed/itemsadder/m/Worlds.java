package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ChunkBridge_3;
import itemsadder.m.EntityBridge_4;
import itemsadder.m.EntityBridge_5;
import itemsadder.m.EntityTypeBarStyleHolder;
import itemsadder.m.EntityTypeBridge_6;
import itemsadder.m.ItemBridge;
import itemsadder.m.ItemStackBridgeImpl;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBridge_32;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackIntData;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LivingEntityBridge_6;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LocationBridge_14;
import itemsadder.m.MaterialBridge_17;
import itemsadder.m.MaterialBridge_9;
import itemsadder.m.NamespacedKeyVectorHolder;
import itemsadder.m.Opaque135;
import itemsadder.m.Opaque136;
import itemsadder.m.VersionHelper;
import itemsadder.m.WorldBridge_10;
import itemsadder.m.WorldBridge_11;
import itemsadder.m.WorldBridge_13;
import itemsadder.m.WorldBridge_14;
import itemsadder.m.WorldBridge_8;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.TranslatableComponent;

public class Worlds {
    final ItemStackRegistry UA;
    final ItemStackBuilder_4 UB;
    public final List UC;
    public final List UD;
    public final List UE;
    public final List UF;
    public final List UG;
    public final List UH;
    public final List UI;
    public final List UJ;
    public final List UK;
    public final List UL;

    public Worlds(ItemStackRegistry itemStackRegistry, ItemStackBuilder_4 itemStackBuilder_4) {
        this.UA = itemStackRegistry;
        this.UB = itemStackBuilder_4;
        this.UC = new ArrayList();
        this.UD = new ArrayList();
        this.UE = new ArrayList();
        this.UF = new ArrayList();
        this.UG = new ArrayList();
        this.UH = new ArrayList();
        this.UI = new ArrayList();
        this.UJ = new ArrayList();
        this.UK = new ArrayList();
        this.UL = new ArrayList();
        this.sU();
    }

    private static String[] k(String string, int n) {
        String string2 = string.replaceAll("((?:\\w+\\s){" + --n + "}\\w+)(\\s)", "$1\n");
        return string2.split("\n");
    }

    private String[] a(Set set, int n) {
        String string = set.toString().replace("[", "").replace("]", "").replace(",", "");
        String[] stringArray = Worlds.k(string, n);
        int n2 = stringArray.length;
        for (int i = 0; i < n2; ++i) {
            String string2 = stringArray[i];
            stringArray[i] = string2.replace(" ", ", ");
        }
        return stringArray;
    }

    public void sU() {
        Object object5;
        Object object2;
        Object object32;
        Object object42;
        boolean bl = false;
        for (ChunkBridge_3 object5 : ChunkBridge_3.md) {
            object42 = (List)object5.OO.get(this.UB.Gi);
            if (object42 == null) continue;
            object32 = object42.iterator();
            while (object32.hasNext()) {
                object2 = (WorldBridge_8)object32.next();
                object5 = object5.cE();
                if (object5 == null) continue;
                if (!bl) {
                    this.UC.add(Main.PQ.ir("worlds"));
                }
                bl = true;
                this.UC.add(String.valueOf(ChatColor.AQUA) + object5.getName());
                this.UC.add(Main.PQ.ir("chance").replace("{value}", "" + ((WorldBridge_8)object2).On));
                this.UC.add(Main.PQ.ir("amount").replace("{value}", "" + ((WorldBridge_8)object2).Oj));
                this.UC.add(Main.PQ.ir("min-height").replace("{value}", "" + ((WorldBridge_8)object2).Om));
                this.UC.add(Main.PQ.ir("max-height").replace("{value}", "" + ((WorldBridge_8)object2).Ol));
                if (((WorldBridge_8)object2).Oo.isEmpty()) continue;
                this.UC.add(Main.PQ.ir("biome"));
                for (String string : this.a(((WorldBridge_8)object2).Oo, 3)) {
                    this.UC.add(String.valueOf(ChatColor.GRAY) + "     " + string);
                }
            }
        }
        for (WorldBridge_13 worldBridge_13 : WorldBridge_13.md) {
            object42 = (List)worldBridge_13.OO.get(this.UB.Gi);
            if (object42 == null) continue;
            object32 = object42.iterator();
            while (object32.hasNext()) {
                object2 = (WorldBridge_10)object32.next();
                object5 = worldBridge_13.cE();
                if (object5 == null) continue;
                if (!bl) {
                    this.UD.add(Main.PQ.ir("worlds"));
                }
                bl = true;
                this.UD.add(String.valueOf(ChatColor.AQUA) + object5.getName());
                this.UD.add(Main.PQ.ir("chance").replace("{value}", "" + ((WorldBridge_10)object2).On));
                this.UD.add(Main.PQ.ir("amount").replace("{value}", "" + ((WorldBridge_10)object2).Oj));
                this.UD.add(Main.PQ.ir("min-height").replace("{value}", "" + ((WorldBridge_10)object2).Om));
                this.UD.add(Main.PQ.ir("max-height").replace("{value}", "" + ((WorldBridge_10)object2).Ol));
                if (((WorldBridge_10)object2).Oo.isEmpty()) continue;
                this.UD.add(Main.PQ.ir("biome"));
                for (String string : this.a(((WorldBridge_10)object2).Oo, 3)) {
                    this.UD.add(String.valueOf(ChatColor.GRAY) + "     " + string);
                }
            }
        }
        for (WorldBridge_14 worldBridge_14 : WorldBridge_14.md) {
            for (Object object32 : worldBridge_14.Ow) {
                object2 = worldBridge_14.cE();
                if (object2 == null || !this.UB.l(((WorldBridge_11)object32).OI) && !this.UB.l(((WorldBridge_11)object32).OJ)) continue;
                if (!bl) {
                    this.UE.add(Main.PQ.ir("worlds"));
                }
                bl = true;
                this.UE.add(String.valueOf(ChatColor.AQUA) + object2.getName());
                this.UE.add(Main.PQ.ir("chance").replace("{value}", "" + ((WorldBridge_11)object32).On));
                this.UE.add(Main.PQ.ir("amount").replace("{value}", "" + ((WorldBridge_11)object32).Oj));
                this.UE.add(Main.PQ.ir("min-height").replace("{value}", "" + ((WorldBridge_11)object32).Om));
                this.UE.add(Main.PQ.ir("max-height").replace("{value}", "" + ((WorldBridge_11)object32).Ol));
                if (((WorldBridge_11)object32).Oo.size() <= 0) continue;
                this.UE.add(Main.PQ.ir("biome"));
                for (String string : this.a(((WorldBridge_11)object32).Oo, 3)) {
                    this.UE.add(String.valueOf(ChatColor.GRAY) + "     " + (String)string);
                }
            }
        }
        for (MaterialBridge_9 materialBridge_9 : this.UA.I.values()) {
            for (Object object32 : materialBridge_9.Hs) {
                if (!((ItemStackBridge_32)object32).oQ() || !this.UB.l(((ItemStackBridge_32)object32).oP())) continue;
                this.UF.add(String.valueOf(ChatColor.AQUA) + materialBridge_9.getItemMeta().getDisplayName());
                this.UF.add(Main.PQ.ir("chance").replace("{value}", "" + ((ItemStackBridge_32)object32).oT()));
                if (((ItemStackBridge_32)object32).oR() == ((ItemStackBridge_32)object32).oS()) {
                    this.UF.add(Main.PQ.ir("amount").replace("{value}", "" + ((ItemStackBridge_32)object32).oR()));
                    continue;
                }
                this.UF.add(Main.PQ.ir("amount").replace("{value}", ((ItemStackBridge_32)object32).oR() + "-" + ((ItemStackBridge_32)object32).oS()));
            }
        }
        for (Map.Entry entry : this.UA.aq.Lc.entrySet()) {
            for (Object object32 : (List)entry.getValue()) {
                for (Object object5 : ((LocationBridge_14)object32).qx()) {
                    if (!((ItemStackBridge_32)object5).oQ() || !this.UB.l(((ItemStackBridge_32)object5).oP())) continue;
                    if (VersionHelper.Vc) {
                        this.UI.add(String.valueOf(ChatColor.AQUA) + "TRANSLATE_" + ItemStackBridge_2.Z(((MaterialBridge_17)object32).nM()));
                    } else {
                        this.UI.add(String.valueOf(ChatColor.AQUA) + ItemStackBridge_2.Y(((MaterialBridge_17)object32).nM()));
                    }
                    if (!((LocationBridge_14)object32).qA().isEmpty()) {
                        this.UI.add(Main.PQ.ir("biome"));
                        for (String string : this.a(((LocationBridge_14)object32).qA(), 3)) {
                            this.UI.add(String.valueOf(ChatColor.GRAY) + "     " + string);
                        }
                    }
                    this.UI.add(Main.PQ.ir("chance").replace("{value}", "" + ((ItemStackBridge_32)object5).oT()));
                    if (((ItemStackBridge_32)object5).oR() == ((ItemStackBridge_32)object5).oS()) {
                        this.UI.add(Main.PQ.ir("amount").replace("{value}", "" + ((ItemStackBridge_32)object5).oR()));
                        continue;
                    }
                    this.UI.add(Main.PQ.ir("amount").replace("{value}", ((ItemStackBridge_32)object5).oR() + "-" + ((ItemStackBridge_32)object5).oS()));
                }
            }
        }
        for (Map.Entry entry : this.UA.aq.Ld.entrySet()) {
            for (Object object32 : (List)entry.getValue()) {
                for (Object object5 : ((LocationBridge_14)object32).qx()) {
                    if (!((ItemStackBridge_32)object5).oQ() || !this.UB.l(((ItemStackBridge_32)object5).oP())) continue;
                    this.UI.add(String.valueOf(ChatColor.AQUA) + ((ItemStackBridgeImpl)object32).ln().getItemMeta().getDisplayName());
                    if (!((LocationBridge_14)object32).qA().isEmpty()) {
                        this.UI.add(Main.PQ.ir("biome"));
                        for (String string : this.a(((LocationBridge_14)object32).qA(), 3)) {
                            this.UI.add(String.valueOf(ChatColor.GRAY) + "     " + string);
                        }
                    }
                    this.UI.add(Main.PQ.ir("chance").replace("{value}", "" + ((ItemStackBridge_32)object5).oT()));
                    if (((ItemStackBridge_32)object5).oR() == ((ItemStackBridge_32)object5).oS()) {
                        this.UI.add(Main.PQ.ir("amount").replace("{value}", "" + ((ItemStackBridge_32)object5).oR()));
                        continue;
                    }
                    this.UI.add(Main.PQ.ir("amount").replace("{value}", ((ItemStackBridge_32)object5).oR() + "-" + ((ItemStackBridge_32)object5).oS()));
                }
            }
        }
        for (ItemBridge itemBridge : this.UA.aq.Le) {
            for (Object object32 : itemBridge.qx()) {
                if (!((ItemStackBridge_32)object32).oQ() || !this.UB.l(((ItemStackBridge_32)object32).oP())) continue;
                if (!itemBridge.qA().isEmpty()) {
                    this.UK.add(Main.PQ.ir("biome"));
                    for (String string : this.a(itemBridge.qA(), 3)) {
                        this.UK.add(String.valueOf(ChatColor.GRAY) + "     " + (String)string);
                    }
                }
                this.UK.add(Main.PQ.ir("chance").replace("{value}", "" + ((ItemStackBridge_32)object32).oT()));
            }
        }
        for (Opaque136 opaque136 : this.UA.aq.Lf) {
            for (Object object32 : opaque136.qx()) {
                if (!((ItemStackBridge_32)object32).oQ() || !this.UB.l(((ItemStackBridge_32)object32).oP())) continue;
                if (opaque136 instanceof EntityTypeBridge_6) {
                    EntityTypeBarStyleHolder entityTypeBarStyleHolder;
                    object2 = (EntityTypeBridge_6)opaque136;
                    Optional optional = opaque136.cu("ItemsAdderEntity");
                    if (optional.isPresent() && LivingEntityRegistry.P() && (entityTypeBarStyleHolder = LivingEntityRegistry.db().am((String)((EntityBridge_4)optional.get()).qD())) != null) {
                        String string = ChatColor.stripColor((String)entityTypeBarStyleHolder.nQ);
                        this.UG.add(String.valueOf(ChatColor.AQUA) + string);
                        this.a((EntityTypeBridge_6)object2);
                    }
                }
                if (opaque136 instanceof Opaque135) {
                    object2 = (Opaque135)opaque136;
                    this.UG.add(String.valueOf(ChatColor.AQUA) + ((Opaque135)object2).nL());
                    this.a((Opaque135)object2);
                }
                if (!opaque136.qA().isEmpty()) {
                    this.UG.add(Main.PQ.ir("biome"));
                    for (String string : this.a(opaque136.qA(), 3)) {
                        this.UG.add(String.valueOf(ChatColor.GRAY) + "     " + (String)string);
                    }
                }
                this.UG.add(Main.PQ.ir("chance").replace("{value}", "" + ((ItemStackBridge_32)object32).oT()));
                for (EntityBridge_5 entityBridge_5 : opaque136.qF()) {
                    this.UG.add(Main.PQ.ir("nbt-rule").replace("{rule}", entityBridge_5.qH()).replace("{value}", String.valueOf(entityBridge_5.qI())));
                }
            }
        }
        if (this.UB.Ge.bm("vehicle")) {
            NamespacedKeyVectorHolder namespacedKeyVectorHolder = (NamespacedKeyVectorHolder)this.UB.Ge.bn("vehicle");
            assert (namespacedKeyVectorHolder != null);
            for (Object object42 : namespacedKeyVectorHolder.zh) {
                if (((ItemStackIntData)object42).itemStack.hasItemMeta()) {
                    this.UL.add(Main.PQ.ir("fuel-item").replace("{type}", ChatColor.stripColor((String)((ItemStackIntData)object42).itemStack.getItemMeta().getDisplayName())).replace("{amount}", "" + ((ItemStackIntData)object42).BG));
                    continue;
                }
                this.UL.add(Main.PQ.ir("fuel-item").replace("{type}", ItemStackBridge_2.a(((ItemStackIntData)object42).itemStack, ChatColor.GRAY)).replace("{amount}", "" + ((ItemStackIntData)object42).BG));
            }
        }
        if (VersionHelper.Vc) {
            this.a(this.UI, this.UJ);
            this.a(this.UG, this.UH);
        }
    }

    private void a(Opaque135 opaque135) {
        if (!LivingEntityRegistry.P()) {
            return;
        }
        EntityTypeBarStyleHolder entityTypeBarStyleHolder = (EntityTypeBarStyleHolder)LivingEntityRegistry.db().lJ.get(opaque135.nL());
        if (entityTypeBarStyleHolder == null) {
            return;
        }
        this.UG.add(entityTypeBarStyleHolder.nQ);
    }

    private void a(EntityTypeBridge_6 entityTypeBridge_6) {
        if (VersionHelper.Vc) {
            this.UG.add(String.valueOf(ChatColor.AQUA) + "TRANSLATE_" + LivingEntityBridge_6.o(entityTypeBridge_6.getType()));
        } else {
            this.UG.add(String.valueOf(ChatColor.AQUA) + LivingEntityBridge_6.n(entityTypeBridge_6.getType()));
        }
    }

    private void a(List list, List list2) {
        for (String string : list) {
            Object object;
            if (string.contains("TRANSLATE_")) {
                object = ChatColor.stripColor((String)string).replace("TRANSLATE_", "");
                BaseComponent[] baseComponentArray = TextComponent.fromLegacyText((String)string);
                ChatColor chatColor = baseComponentArray[0].getColor();
                baseComponentArray[0] = new TranslatableComponent((String)object, new Object[0]);
                baseComponentArray[0].setColor(chatColor);
                baseComponentArray[0].setItalic(Boolean.valueOf(false));
                list2.add(baseComponentArray);
                continue;
            }
            object = TextComponent.fromLegacyText((String)string);
            for (int i = 0; i < ((BaseComponent[])object).length; ++i) {
                object[i].setItalic(Boolean.valueOf(false));
            }
            list2.add(object);
        }
        if (!list.isEmpty()) {
            list.clear();
            list.add("dummy");
        }
    }
}
