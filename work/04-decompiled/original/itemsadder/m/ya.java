package itemsadder.m;

import com.google.common.collect.ImmutableList;
import dev.lone.itemsadder.Core.OtherPlugins.Citizens.CitizensHook;
import dev.lone.itemsadder.Core.OtherPlugins.Citizens.CustomEntityTrait;
import dev.lone.itemsadder.Main;
import itemsadder.m.ae;
import itemsadder.m.afz;
import itemsadder.m.bbe;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bcy;
import itemsadder.m.da;
import itemsadder.m.dn;
import itemsadder.m.dp;
import itemsadder.m.za;
import java.util.HashMap;
import java.util.Iterator;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.event.HoverEventSource;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ya
implements CommandExecutor {
    HashMap SA = new HashMap();
    HashMap SB = new HashMap();

    public ya() {
        bcp.a((T bukkitRunnable) -> {
            this.SA.clear();
            this.SB.clear();
        }, 0L, 6000L);
        Main.cM("iaentity").setExecutor((CommandExecutor)this);
    }

    private static boolean a(CommandSender commandSender, String string, Location location) {
        dp dp2 = da.db().am(string);
        boolean bl = afz.tK().j(dp2.nS);
        if (!ya.a(location.getWorld().getDifficulty(), bl)) {
            String string2 = Main.PQ.ir("custom-entity-cannot-spawn-peaceful").replace("{entity}", string).replace("{type}", dp2.nS.toString());
            bce.warn(bbe.u(bbe.gK(string2)));
            if (commandSender instanceof Player) {
                bce.a(commandSender, bce.aAT.append(bbe.gK(string2)));
            }
            return false;
        }
        return true;
    }

    static boolean a(Difficulty difficulty, boolean bl) {
        return difficulty != Difficulty.PEACEFUL || bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string2, @NotNull String[] stringArray) {
        block80: {
            int n3;
            Object object;
            Object object2;
            block82: {
                int n4;
                block84: {
                    block83: {
                        block81: {
                            if (!ae.dL) {
                                bce.g(commandSender, "custom-entities-disabled");
                                return true;
                            }
                            if (za.a(3, stringArray) && stringArray[0].equals("citizens")) {
                                object2 = stringArray[1];
                                object = ((String)object2).equals("selected") ? CitizensAPI.getDefaultNPCSelector().getSelected(commandSender) : (bcy.iJ((String)object2) ? CitizensAPI.getNPCRegistry().getById(bcy.w((String)object2, 0)) : null);
                                if (object == null) {
                                    bce.g(commandSender, "no-npc-selected");
                                    return true;
                                }
                                if (stringArray[2].equals("model")) {
                                    if (!ya.dm(stringArray[3])) {
                                        return true;
                                    }
                                    CustomEntityTrait customEntityTrait = (CustomEntityTrait)object.getTraitNullable(CustomEntityTrait.class);
                                    if (customEntityTrait == null) {
                                        customEntityTrait = CustomEntityTrait.inject((NPC)object);
                                        customEntityTrait.applyModel(stringArray[3], true);
                                    } else {
                                        customEntityTrait.applyModel(stringArray[3], false);
                                    }
                                    CitizensHook.saveAll(true);
                                    return true;
                                }
                                if (stringArray[2].equals("clean")) {
                                    CustomEntityTrait customEntityTrait = (CustomEntityTrait)object.getTraitNullable(CustomEntityTrait.class);
                                    if (customEntityTrait == null) return true;
                                    da.db().a(customEntityTrait.getRenderer(), false, false);
                                    object.removeTrait(CustomEntityTrait.class);
                                    CitizensHook.respawn((NPC)object);
                                    CitizensHook.reload();
                                    return true;
                                }
                                CustomEntityTrait customEntityTrait = (CustomEntityTrait)object.getTraitNullable(CustomEntityTrait.class);
                                int n5 = n3 = customEntityTrait == null ? 1 : 0;
                                if (stringArray[2].equals("anim")) {
                                    if (n3 != 0) {
                                        bce.g(commandSender, "no-npc-selected");
                                        return true;
                                    }
                                    if (stringArray[3].equals("play")) {
                                        int n6 = 0;
                                        if (stringArray.length == 6) {
                                            n6 = bcy.w(stringArray[5], 0);
                                        }
                                        customEntityTrait.playAnim(stringArray[4], n6);
                                    } else {
                                        customEntityTrait.pauseAnim();
                                    }
                                    CitizensHook.saveAll(true);
                                    return true;
                                }
                                if (stringArray[2].equals("playerskin")) {
                                    if (customEntityTrait == null) {
                                        CustomEntityTrait customEntityTrait2 = CustomEntityTrait.inject((NPC)object);
                                        customEntityTrait2.initPlayerModel(stringArray[3]);
                                    } else {
                                        customEntityTrait.changePlayerSkin(stringArray[3]);
                                    }
                                    CitizensHook.saveAll(true);
                                    return true;
                                }
                            }
                            if (stringArray.length <= 0) break block80;
                            if (stringArray[0].equals("summon")) {
                                if (stringArray.length == 1) {
                                    this.d(commandSender);
                                    return true;
                                }
                                object = stringArray[1];
                                if (!ya.dm((String)object)) {
                                    bce.a(commandSender, "unknown-entity", arg_0 -> ya.F((String)object, arg_0));
                                    return true;
                                }
                                if (stringArray.length < 6) {
                                    if (!(commandSender instanceof Player)) return true;
                                    object2 = ((Player)commandSender).getLocation().clone();
                                    object2.setYaw(0.0f);
                                    object2.setPitch(0.0f);
                                    if (!ya.a(commandSender, (String)object, (Location)object2)) return true;
                                    da.db().a((String)object, (Location)object2, true);
                                    return true;
                                }
                                if (bcy.c(stringArray, 3) && bcy.c(stringArray, 4) && bcy.c(stringArray, 5)) {
                                    object2 = Bukkit.getWorld((String)stringArray[2]);
                                    if (object2 == null) {
                                        this.d(commandSender);
                                        return true;
                                    }
                                    Location location = new Location((World)object2, (double)Float.parseFloat(stringArray[3]), (double)Float.parseFloat(stringArray[4]), (double)Float.parseFloat(stringArray[5]));
                                    if (stringArray.length >= 7) {
                                        if (bcy.c(stringArray, 6) && bcy.c(stringArray, 7)) {
                                            location.setYaw(Float.parseFloat(stringArray[6]));
                                            location.setPitch(Float.parseFloat(stringArray[7]));
                                        } else {
                                            this.d(commandSender);
                                        }
                                    }
                                    if (!ya.a(commandSender, (String)object, location)) return true;
                                    da.db().a((String)object, location, true);
                                    return true;
                                }
                                this.d(commandSender);
                                return true;
                            }
                            if (stringArray[0].equals("summonplayer")) {
                                Object object3 = object = stringArray.length >= 2 ? stringArray[1] : null;
                                if (stringArray.length >= 5) {
                                    if (bcy.c(stringArray, 3) && bcy.c(stringArray, 4) && bcy.c(stringArray, 5)) {
                                        object2 = Bukkit.getWorld((String)stringArray[2]);
                                        if (object2 == null) {
                                            this.d(commandSender);
                                            return true;
                                        }
                                        Location location = new Location((World)object2, (double)Float.parseFloat(stringArray[3]), (double)Float.parseFloat(stringArray[4]), (double)Float.parseFloat(stringArray[5]));
                                        if (stringArray.length >= 7) {
                                            if (bcy.c(stringArray, 6) && bcy.c(stringArray, 7)) {
                                                location.setYaw(Float.parseFloat(stringArray[6]));
                                                location.setPitch(Float.parseFloat(stringArray[7]));
                                            } else {
                                                this.d(commandSender);
                                            }
                                        }
                                        if (!ya.a(commandSender, "_iainternal:player", location)) return true;
                                        da.db().a("_iainternal:player", (String)object, location, true, false, false);
                                        return true;
                                    }
                                    this.d(commandSender);
                                    return true;
                                }
                                if (commandSender instanceof Player) {
                                    object2 = ((Player)commandSender).getLocation().clone();
                                    object2.setYaw(0.0f);
                                    object2.setPitch(0.0f);
                                    if (!ya.a(commandSender, "_iainternal:player", (Location)object2)) return true;
                                    da.db().a("_iainternal:player", (String)object, (Location)object2, true, false, false);
                                    return true;
                                }
                                this.d(commandSender);
                                return true;
                            }
                            if (!stringArray[0].equals("kill")) break block81;
                            if (stringArray.length > 1) {
                                int n7 = 0;
                                if (stringArray[1].equals("all")) {
                                    object2 = da.db().dl().iterator();
                                    while (true) {
                                        if (!object2.hasNext()) {
                                            bce.f(commandSender, Main.PQ.ir("custom-entity-kill-all").replace("{amount}", "" + n7));
                                            return true;
                                        }
                                        dn dn2 = (dn)object2.next();
                                        if (Main.PK && CitizensHook.isNPC(dn2.eg())) continue;
                                        da.db().a(dn2, true, false);
                                        ++n7;
                                    }
                                }
                                if (!ya.dm(stringArray[1])) {
                                    return true;
                                }
                                object2 = da.db().dl().iterator();
                                while (true) {
                                    if (!object2.hasNext()) {
                                        bce.f(commandSender, Main.PQ.ir("custom-entity-kill").replace("{mob}", stringArray[1]).replace("{amount}", "" + n7));
                                        return true;
                                    }
                                    dn dn3 = (dn)object2.next();
                                    if (!dn3.es().equals(stringArray[1]) || Main.PK && CitizensHook.isNPC(dn3.eg())) continue;
                                    da.db().a(dn3, true, false);
                                    ++n7;
                                }
                            }
                            break block80;
                        }
                        if (stringArray[0].equals("count")) {
                            object = new HashMap();
                            object2 = new HashMap();
                            HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
                            Iterator iterator = da.db().dl().iterator();
                            while (true) {
                                if (!iterator.hasNext()) {
                                    ((HashMap)object).forEach((arg_0, arg_1) -> ya.a(commandSender, hashMap, (HashMap)object2, arg_0, arg_1));
                                    return true;
                                }
                                dn dn4 = (dn)iterator.next();
                                ((HashMap)object).merge(dn4.es(), 1, Integer::sum);
                                ((HashMap)object2).merge(dn4.es(), dn4.na.size(), Integer::sum);
                                if (hashMap.containsKey(dn4.es())) continue;
                                hashMap.put(dn4.es(), dn4.na.size());
                            }
                        }
                        if (!stringArray[0].equals("inspect")) break block82;
                        if (stringArray.length <= 1) break block83;
                        if (stringArray[1].equals("next")) {
                            if (this.SB.containsKey(commandSender)) {
                                this.SB.merge(commandSender, 1, Integer::sum);
                            }
                            break block84;
                        } else if (stringArray[1].equals("prev") && this.SB.containsKey(commandSender)) {
                            this.SB.merge(commandSender, -1, (n, n2) -> Math.max(n + n2, 0));
                        }
                        break block84;
                    }
                    this.SA.put(commandSender, da.db().dl());
                    this.SB.put(commandSender, 0);
                }
                int n8 = 5;
                object2 = (Integer)this.SB.get(commandSender);
                ImmutableList immutableList = (ImmutableList)this.SA.get(commandSender);
                for (int i = n4 = (Integer)object2 * n8; i < i + n8 && i < immutableList.size(); ++i) {
                    dn dn5 = (dn)immutableList.get(i);
                    commandSender.spigot().sendMessage(bbe.s(bbe.gF(String.valueOf(ChatColor.YELLOW) + dn5.es()).hoverEvent((HoverEventSource)HoverEvent.showText((Component)bbe.gF(dn5.es() + "\nLoc: " + bcc.b(dn5.getLocation(), true) + "\nAnim: " + dn5.ec().aM("none") + "\n" + String.valueOf(ChatColor.GRAY) + "Click to teleport"))).clickEvent(ClickEvent.clickEvent((ClickEvent.Action)ClickEvent.Action.RUN_COMMAND, (String)("/minecraft:tp " + dn5.getLocation().getBlockX() + " " + dn5.getLocation().getBlockY() + " " + dn5.getLocation().getBlockZ() + " ")))));
                }
                if (n4 + n8 < immutableList.size()) {
                    commandSender.spigot().sendMessage(bbe.s(bbe.gF("Next page ->").clickEvent(ClickEvent.clickEvent((ClickEvent.Action)ClickEvent.Action.RUN_COMMAND, (String)"/iaentity inspect next"))));
                    return true;
                }
                if ((Integer)object2 <= 0) return true;
                commandSender.spigot().sendMessage(bbe.s(bbe.gF("<- Prev page").clickEvent(ClickEvent.clickEvent((ClickEvent.Action)ClickEvent.Action.RUN_COMMAND, (String)"/iaentity inspect prev"))));
                return true;
            }
            if (stringArray[0].equals("anim")) {
                if (!(commandSender instanceof Player)) {
                    bce.iy("command-ingame-only");
                    return true;
                }
                object = ((Player)commandSender).getLocation();
                switch (stringArray[1]) {
                    case "play": {
                        dn dn6 = da.db().n((Location)object);
                        if (dn6 == null) {
                            bce.g(commandSender, "no-near-entity-found");
                            return true;
                        }
                        String string3 = stringArray[2];
                        if (dn6.nw) {
                            da.a(dn6, string3);
                            return true;
                        }
                        dn6.ap(string3);
                        return true;
                    }
                    case "stop": 
                    case "pause": {
                        dn dn7 = da.db().n((Location)object);
                        if (dn7 != null) {
                            dn7.ec().gm();
                            return true;
                        }
                        bce.g(commandSender, "no-near-entity-found");
                        return true;
                    }
                }
                return true;
            }
            if (stringArray[0].equals("playerskin")) {
                if (!(commandSender instanceof Player)) {
                    bce.iy("command-ingame-only");
                    return true;
                }
                object = ((Player)commandSender).getLocation();
                object2 = da.db().n((Location)object);
                if (object2 == null) {
                    bce.g(commandSender, "no-near-entity-found");
                    return true;
                }
                ((dn)object2).changePlayerSkin(stringArray[1]);
                bce.g(commandSender, "skin-changed");
                return true;
            }
            if (stringArray[0].equals("disguise")) {
                if (stringArray.length == 1) {
                    this.d(commandSender);
                    return true;
                }
                object = stringArray[1];
                if (!ya.dm((String)object)) {
                    bce.a(commandSender, "unknown-entity", arg_0 -> ya.H((String)object, arg_0));
                    return true;
                }
                object2 = null;
                if (stringArray.length >= 3) {
                    object2 = Bukkit.getPlayer((String)stringArray[2]);
                    if (object2 == null) {
                        bce.a(commandSender, "player-not-found", (Object string) -> string.replace("{player}", stringArray[2]));
                        return true;
                    }
                } else if (commandSender instanceof Player) {
                    object2 = (Player)commandSender;
                }
                if (object2 == null) {
                    bce.f(commandSender, Main.PQ.ir("command-ingame-only"));
                    return true;
                }
                n3 = da.db().c((Player)object2, (String)object) ? 1 : 0;
                if (n3 == 0) {
                    bce.a(commandSender, "disguise-failed", arg_0 -> ya.G((String)object, arg_0));
                    return true;
                }
            } else if (stringArray[0].equals("undisguise")) {
                if (stringArray.length == 1) {
                    this.d(commandSender);
                    return true;
                }
                object = Bukkit.getPlayer((String)stringArray[1]);
                if (object == null) {
                    bce.a(commandSender, "player-not-found", (Object string) -> string.replace("{player}", stringArray[1]));
                    return true;
                }
                boolean bl = da.db().W((Player)object);
                if (!bl) {
                    bce.a(commandSender, "undisguise-failed-player-not-disguised", arg_0 -> ya.h((Player)object, arg_0));
                    return true;
                }
            }
        }
        this.d(commandSender);
        return true;
    }

    public static boolean dm(String string) {
        return da.db().t(false).contains(string);
    }

    private void d(CommandSender commandSender) {
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "Command usage:");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "   /iaentity disguise <name> [player] - Disguise as an entity");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "   /iaentity undisguise [player] - Undisguise yourself or another player");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "   /iaentity summon <name> - Spawns a new entity");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "   /iaentity summon <name> [world] [x] [y] [z] [yaw] [pitch] - Spawns a new entity at specific location");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "   /iaentity summonplayer <name> - Spawns a new player entity");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "   /iaentity summonplayer <name> [world] [x] [y] [z] [yaw] [pitch] - Spawns a new player entity at specific location");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "   /iaentity playerskin <name|url|skin id> - Change skin of the nearest player entity");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "   /iaentity anim <play|pause> <animation> [repeatCount] - Change/pause nearest entity animation");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "   /iaentity kill <name|all> - Kills all entities or all entities of a type");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "   /iaentity count - Counts all entities");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "   /iaentity inspect [prev|next] - Get paged info about spawned custom entities");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "   /iaentity citizens <id|selected> model <model> - Change model of a Citizens NPC");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "   /iaentity citizens <id|selected> clean - Detach ItemsAdder from a Citizens NPC");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "   /iaentity citizens <id|selected> playerskin <name|url|skin id> - Change player skin of a Citizen NPC");
    }

    private static /* synthetic */ String h(Player player, String string) {
        return string.replace("{player}", player.getName());
    }

    private static /* synthetic */ String G(String string, String string2) {
        return string2.replace("{entity}", string);
    }

    private static /* synthetic */ String H(String string, String string2) {
        return string2.replace("{entity}", string);
    }

    private static /* synthetic */ void a(CommandSender commandSender, HashMap hashMap, HashMap hashMap2, String string, Integer n) {
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + string + String.valueOf(ChatColor.GRAY) + " x" + n + " (x" + String.valueOf(hashMap.get(string)) + " bones | total x" + String.valueOf(hashMap2.get(string)) + " bones)");
    }

    private static /* synthetic */ String F(String string, String string2) {
        return string2.replace("{entity}", string);
    }
}
