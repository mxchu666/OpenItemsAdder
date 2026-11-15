package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.Citizens.CitizensHook;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.ae;
import itemsadder.m.ai;
import itemsadder.m.bcy;
import itemsadder.m.bx;
import itemsadder.m.d;
import itemsadder.m.da;
import itemsadder.m.dn;
import itemsadder.m.fw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class zb
implements ai,
TabCompleter {
    private static final List SJ = Collections.singletonList("");

    public zb() {
        Main.cM("ia").setTabCompleter((TabCompleter)this);
        Main.cM("iaget").setTabCompleter((TabCompleter)this);
        Main.cM("iagive").setTabCompleter((TabCompleter)this);
        Main.cM("iaremove").setTabCompleter((TabCompleter)this);
        Main.cM("iadrop").setTabCompleter((TabCompleter)this);
        Main.cM("iarecipe").setTabCompleter((TabCompleter)this);
        Main.cM("iareload").setTabCompleter((TabCompleter)this);
        Main.cM("iazip").setTabCompleter((TabCompleter)this);
        Main.cM("iatexture").setTabCompleter((TabCompleter)this);
        Main.cM("iaspawntree").setTabCompleter((TabCompleter)this);
        Main.cM("iaplaytotemanimation").setTabCompleter((TabCompleter)this);
        Main.cM("iaplayerstat").setTabCompleter((TabCompleter)this);
        Main.cM("iasha1").setTabCompleter((TabCompleter)this);
        Main.cM("iacleancache").setTabCompleter((TabCompleter)this);
        Main.cM("iacustommodeldata").setTabCompleter((TabCompleter)this);
        Main.cM("iaconfig").setTabCompleter((TabCompleter)this);
        Main.cM("iaentity").setTabCompleter((TabCompleter)this);
        Main.cM("iaemote").setTabCompleter((TabCompleter)this);
        Main.cM("iaplaysound").setTabCompleter((TabCompleter)this);
        Main.cM("iacolor").setTabCompleter((TabCompleter)this);
        Main.cM("iadebug").setTabCompleter((TabCompleter)this);
        Main.cM("iatag").setTabCompleter((TabCompleter)this);
        Main.cM("iaimage").setTabCompleter((TabCompleter)this);
        Main.cM("iadisguise").setTabCompleter((TabCompleter)this);
        Main.cM("iaundisguise").setTabCompleter((TabCompleter)this);
        Main.cM("crops").setTabCompleter((TabCompleter)this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public List onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string3, @NotNull String[] stringArray) {
        if (!d.g().u) {
            return SJ;
        }
        if (command.getName().equalsIgnoreCase("ia")) {
            if (stringArray.length == 1) {
                List list = d.g().bi.Ue.sE();
                if (list.isEmpty()) return Collections.singletonList("CategoryNotFound");
                return list;
            }
            if (stringArray.length != 2) return SJ;
            return zb.a(stringArray[1], false, commandSender);
        }
        if (command.getName().equalsIgnoreCase("iaget")) {
            if (stringArray.length == 1) {
                List list = d.g().i(stringArray[0]);
                if (list.isEmpty()) return Collections.singletonList("ItemNotFound");
                return list;
            }
            if (stringArray.length != 2) return SJ;
            return Arrays.asList("5", "16", "32", "64");
        }
        if (command.getName().equalsIgnoreCase("iagive") || command.getName().equalsIgnoreCase("iaremove")) {
            if (stringArray.length == 1) {
                return zb.a(stringArray[0], false, commandSender);
            }
            if (stringArray.length == 2) {
                List list = d.g().i(stringArray[1]);
                if (list.isEmpty()) return Collections.singletonList("ItemNotFound");
                return list;
            }
            if (stringArray.length == 3) {
                return Arrays.asList("5", "16", "32", "64");
            }
            if (stringArray.length != 4) return SJ;
            return Collections.singletonList("silent");
        }
        if (command.getName().equalsIgnoreCase("iadrop")) {
            if (stringArray.length == 1) {
                List list = d.g().i(stringArray[0]);
                if (list.isEmpty()) return Collections.singletonList("ItemNotFound");
                return list;
            }
            if (stringArray.length == 2) {
                return zb.a(stringArray[1], false, commandSender);
            }
            if (stringArray.length == 3) {
                return Arrays.asList("5", "16", "32", "64");
            }
            if (stringArray.length != 4) return SJ;
            return Collections.singletonList("silent");
        }
        if (command.getName().equalsIgnoreCase("iacustommodeldata")) {
            if (stringArray.length != 1) return SJ;
            List list = d.g().i(stringArray[0]);
            if (list.isEmpty()) return Collections.singletonList("ItemNotFound");
            return list;
        }
        if (command.getName().equalsIgnoreCase("iarecipe")) {
            if (stringArray.length == 1) {
                List list = d.g().i(stringArray[0]);
                if (list.isEmpty()) return Collections.singletonList("ItemNotFound");
                return list;
            }
            if (stringArray.length != 2 || !s.c((Permissible)commandSender, "ia.user.iarecipe.others")) return SJ;
            return zb.a(stringArray[1], false, commandSender);
        }
        if (command.getName().equalsIgnoreCase("iatexture")) {
            if (stringArray.length != 1) return SJ;
            return zb.a(stringArray[0], true, commandSender);
        }
        if (command.getName().equalsIgnoreCase("iareload")) {
            if (stringArray.length != 1) return SJ;
            return List.of("--scripts-only", "--skip-recipes");
        }
        if (command.getName().equalsIgnoreCase("iazip")) {
            ArrayList<String> arrayList = new ArrayList<String>();
            String string4 = stringArray.length > 0 ? stringArray[stringArray.length - 1] : "";
            HashSet<String> hashSet = new HashSet<String>(Arrays.asList("--uncompressed", "--apply-to", "--skip-recipes", "--open-ia-menu", "--check-duplicate-images"));
            Set set = Arrays.stream(stringArray).filter(hashSet::contains).collect(Collectors.toSet());
            if (string4.startsWith("--")) {
                for (String string5 : hashSet) {
                    if (!string5.startsWith(string4) || set.contains(string5)) continue;
                    arrayList.add(string5);
                }
                return arrayList;
            }
            for (int i = 0; i < stringArray.length - 1; ++i) {
                if (!stringArray[i].equalsIgnoreCase("--apply-to") || i + 1 != stringArray.length - 1) continue;
                return Arrays.asList("all", "self", "none");
            }
            for (String string6 : hashSet) {
                if (set.contains(string6)) continue;
                arrayList.add(string6);
            }
            return arrayList;
        }
        if (command.getName().equalsIgnoreCase("iaspawntree")) {
            if (stringArray.length != 1) return SJ;
            List list = d.g().k(stringArray[0]);
            if (list.isEmpty()) return Collections.singletonList("TreeNotFound");
            return list;
        }
        if (command.getName().equalsIgnoreCase("iaplaytotemanimation")) {
            if (stringArray.length == 1) {
                List list = d.g().a(Material.TOTEM_OF_UNDYING, stringArray[0]);
                if (list.isEmpty()) return Collections.singletonList("TotemNotFound");
                return list;
            }
            if (stringArray.length == 2) {
                return zb.a(stringArray[1], false, commandSender);
            }
            if (stringArray.length != 3) return SJ;
            return Collections.singletonList("silent");
        }
        if (command.getName().equalsIgnoreCase("iaplayerstat")) {
            if (stringArray.length == 1) {
                return Arrays.asList("read", "write", "increment", "decrement");
            }
            if (stringArray.length == 2) {
                return zb.a(stringArray[1], false, commandSender);
            }
            if (stringArray.length == 3) {
                return d.g().l(stringArray[2]);
            }
            if (stringArray.length != 4) return SJ;
            if (stringArray[0].equals("write") || stringArray[0].equals("decrement") || stringArray[0].equals("increment")) {
                return Arrays.asList("0", "5", "10");
            }
            if (!stringArray[0].equals("read")) return SJ;
            return List.of("");
        }
        if (command.getName().equalsIgnoreCase("iasha1")) {
            if (stringArray.length != 1) return SJ;
            return Arrays.asList("local", "online");
        }
        if (command.getName().equalsIgnoreCase("iacleancache")) {
            if (stringArray.length != 1) return SJ;
            return Arrays.asList("items", "blocks");
        }
        if (command.getName().equalsIgnoreCase("iaconfig")) {
            if (stringArray.length == 1) {
                return Arrays.asList("item", "namespace", "recipes");
            }
            if (stringArray.length == 2) {
                switch (stringArray[0]) {
                    case "item": 
                    case "namespace": {
                        return Arrays.asList("delete", "disable");
                    }
                    case "recipes": {
                        return Arrays.asList("deleteofitem", "disableofitem");
                    }
                }
            }
            if (stringArray.length != 3) return SJ;
            switch (stringArray[0]) {
                case "item": 
                case "recipes": {
                    List list = d.g().i(stringArray[2]);
                    if (list.isEmpty()) return Collections.singletonList("ItemNotFound");
                    return list;
                }
                case "namespace": {
                    LinkedList<String> linkedList = new LinkedList<String>();
                    for (String string7 : d.g().Z) {
                        if (!string7.contains(stringArray[2])) continue;
                        linkedList.add(string7);
                    }
                    if (linkedList.isEmpty()) return Collections.singletonList("NamespaceNotFound");
                    return new ArrayList(linkedList);
                }
            }
            return SJ;
        }
        if (command.getName().equalsIgnoreCase("iarename")) {
            return SJ;
        }
        if (command.getName().equalsIgnoreCase("iaentity") && ae.dL) {
            if (stringArray.length == 1) {
                return Arrays.asList("summon", "anim", "kill", "count", "inspect", "citizens", "summonplayer", "playerskin", "disguise");
            }
            if (stringArray.length < 2) return SJ;
            switch (stringArray[0]) {
                case "disguise": {
                    if (stringArray.length == 2) {
                        return da.db().f(stringArray[1], false);
                    }
                    if (stringArray.length != 3) return SJ;
                    return zb.a(stringArray[2], false, commandSender);
                }
                case "summon": {
                    Location location;
                    if (commandSender instanceof Player) {
                        Player player = (Player)commandSender;
                        location = player.getLocation().clone();
                    } else {
                        location = new Location((World)Bukkit.getWorlds().get(0), 0.0, 0.0, 0.0);
                    }
                    if (stringArray.length == 2) {
                        return da.db().f(stringArray[1], false);
                    }
                    if (stringArray.length == 3) {
                        return List.of(location.getWorld().getName());
                    }
                    if (stringArray.length == 4) {
                        return List.of(bcy.t(location.getX()));
                    }
                    if (stringArray.length == 5) {
                        return List.of(bcy.t(location.getY()));
                    }
                    if (stringArray.length == 6) {
                        return List.of(bcy.t(location.getZ()));
                    }
                    if (stringArray.length == 7) {
                        return List.of(bcy.t(location.getYaw()));
                    }
                    if (stringArray.length != 8) return SJ;
                    return List.of(bcy.t(location.getPitch()));
                }
                case "kill": {
                    ArrayList<String> arrayList = new ArrayList<String>();
                    arrayList.add("all");
                    arrayList.addAll(da.db().f(stringArray[1], true));
                    return arrayList;
                }
                case "anim": {
                    if (stringArray.length == 2) {
                        return Arrays.asList("play", "pause");
                    }
                    if (stringArray.length == 3) {
                        if (!(commandSender instanceof Player)) return SJ;
                        dn dn2 = da.db().n(((Player)commandSender).getLocation());
                        if (dn2 == null) {
                            return Collections.singletonList("");
                        }
                        if (!dn2.et().pD) return dn2.getAnimationsNames();
                        return da.db().dn();
                    }
                    if (stringArray.length != 6) return SJ;
                    return Arrays.asList("0", "1", "2", "3", "4", "5", "6");
                }
                case "citizens": {
                    if (stringArray.length == 2) {
                        if (!Main.PK) return Collections.singletonList("");
                        ArrayList<String> arrayList = new ArrayList<String>();
                        arrayList.add("selected");
                        arrayList.addAll(CitizensHook.getNpcsIds());
                        return arrayList;
                    }
                    if (stringArray.length == 3) {
                        return Arrays.asList("model", "clean", "anim", "playerskin");
                    }
                    switch (stringArray[2]) {
                        case "model": {
                            return da.db().f(stringArray[3], true);
                        }
                        case "clean": {
                            return SJ;
                        }
                        case "anim": {
                            if (stringArray.length == 4) {
                                return Arrays.asList("play", "pause");
                            }
                            if (stringArray.length == 5) {
                                if (!Main.PK) return SJ;
                                dn dn3 = CitizensHook.getSelectedNpcEntityRenderer(commandSender);
                                if (dn3 == null) {
                                    return Collections.singletonList("");
                                }
                                if (!dn3.et().pD) return dn3.getAnimationsNames();
                                return da.db().dn();
                            }
                            if (stringArray.length != 6) return SJ;
                            return Arrays.asList("0", "1", "2", "3", "4", "5", "6");
                        }
                        case "playerskin": {
                            return Arrays.asList("CITIZENS_SKIN", "https://minesk.in/5f1e7ff6409e428bb500cc9315bf7ffb", "PlayerName");
                        }
                    }
                    return SJ;
                }
                case "summonplayer": {
                    Location location;
                    if (commandSender instanceof Player) {
                        Player player = (Player)commandSender;
                        location = player.getLocation().clone();
                    } else {
                        location = new Location((World)Bukkit.getWorlds().get(0), 0.0, 0.0, 0.0);
                    }
                    if (stringArray.length == 2) {
                        return Arrays.asList("https://minesk.in/5f1e7ff6409e428bb500cc9315bf7ffb", "PlayerName");
                    }
                    if (stringArray.length == 3) {
                        return List.of(location.getWorld().getName());
                    }
                    if (stringArray.length == 4) {
                        return List.of(bcy.t(location.getX()));
                    }
                    if (stringArray.length == 5) {
                        return List.of(bcy.t(location.getY()));
                    }
                    if (stringArray.length == 6) {
                        return List.of(bcy.t(location.getZ()));
                    }
                    if (stringArray.length == 7) {
                        return List.of(bcy.t(location.getYaw()));
                    }
                    if (stringArray.length != 8) return SJ;
                    return List.of(bcy.t(location.getPitch()));
                }
                case "playerskin": {
                    if (stringArray.length != 2) return SJ;
                    return Arrays.asList("https://minesk.in/5f1e7ff6409e428bb500cc9315bf7ffb", "PlayerName");
                }
                default: {
                    return SJ;
                }
            }
        }
        if (command.getName().equalsIgnoreCase("iaemote") && ae.dM) {
            if (!da.db().dc()) {
                return SJ;
            }
            if (stringArray.length == 1) {
                if (!(commandSender instanceof Player)) return SJ;
                List list = da.db().dn();
                list.add("stop-now");
                list.add("stop");
                String string8 = stringArray[0].toLowerCase().replace("-", "");
                return list.stream().filter(string2 -> string2.toLowerCase().replace("-", "").contains(string8)).collect(Collectors.toList());
            }
            if (stringArray.length != 2 || !commandSender.hasPermission("ia.user.iaemote.others")) return SJ;
            return zb.a(stringArray[1], false, commandSender);
        }
        if (command.getName().equalsIgnoreCase("iadisguise") && ae.dM) {
            if (stringArray.length != 1) return SJ;
            return da.db().f(stringArray[0], false);
        }
        if (command.getName().equalsIgnoreCase("iaundisguise")) {
            return SJ;
        }
        if (command.getName().equalsIgnoreCase("iaplaysound")) {
            if (stringArray.length == 1) {
                return Collections.singletonList("custom_sound_name");
            }
            if (stringArray.length == 2) {
                return zb.a(stringArray[1], false, commandSender);
            }
            if (stringArray.length == 3) {
                return List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
            }
            if (stringArray.length != 4) return SJ;
            return List.of("0.5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        }
        if (command.getName().equalsIgnoreCase("iacolor")) {
            if (stringArray.length == 1) {
                return List.of("#ffffff", "#000000", "#4287f5", "#692fba", "#ba2f41", "#ba802f", "255,0,0", "WHITE", "SILVER", "GRAY", "BLACK", "RED", "MAROON", "YELLOW", "OLIVE", "LIME", "GREEN", "AQUA", "TEAL", "BLUE", "NAVY", "FUCHSIA", "PURPLE", "ORANGE");
            }
            if (stringArray.length != 2) return SJ;
            return zb.a(stringArray[1], false, commandSender);
        }
        if (command.getName().equalsIgnoreCase("iadebug")) {
            if (stringArray.length == 1) {
                return Arrays.asList("region", "placeCrops", "cleanCrops", "stopEmote", "starve", "get-item-with-custom-model-data", "messages");
            }
            if (stringArray.length < 2) return SJ;
            if (stringArray[0].equals("region")) {
                if (stringArray.length != 3 && stringArray.length != 4) return zb.sw();
                return Arrays.asList("-2", "-1", "0", "1", "2");
            }
            if (stringArray[0].equals("placeCrops")) {
                if (stringArray.length == 2) {
                    return List.copyOf(d.g().ab.keySet());
                }
                if (stringArray.length == 3) {
                    return Arrays.asList("10", "20", "30", "40", "50");
                }
                if (stringArray.length != 4) return SJ;
                bx bx2 = (bx)d.g().ab.get(stringArray[1]);
                if (bx2 != null) return Arrays.asList("0", String.valueOf(bx2.hK));
                return List.of("0");
            }
            if (!stringArray[0].equals("get-item-with-custom-model-data")) return SJ;
            if (stringArray.length == 2) {
                return Arrays.stream(Material.values()).filter(Material::isItem).map(Enum::name).filter(string -> string.contains(stringArray[1].toUpperCase())).collect(Collectors.toList());
            }
            if (stringArray.length != 3) return SJ;
            return Arrays.asList("0", "1", "2", "3", "4", "5", "10", "50", "100", "500", "1000");
        }
        if (command.getName().equalsIgnoreCase("iatag")) {
            if (stringArray.length < 1) return SJ;
            return List.of("show-in-chat", "show-in-console", "pretty-print");
        }
        if (command.getName().equalsIgnoreCase("iaimage")) {
            if (!s.b((Permissible)commandSender, "ia.user.image.hints", true)) return SJ;
            return zb.b(commandSender, stringArray);
        }
        if (!command.getName().equalsIgnoreCase("crops")) return SJ;
        if (stringArray.length == 1) {
            return Arrays.asList("enable", "disable");
        }
        if (stringArray.length != 2 || !s.c((Permissible)commandSender, "ia.admin.crops.others")) return SJ;
        return zb.a(stringArray[1], false, commandSender);
    }

    public static List a(@NotNull String string, boolean bl, CommandSender commandSender) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (bl) {
            arrayList.add("all");
        }
        if (commandSender instanceof Player) {
            Player player = (Player)commandSender;
            for (Player player2 : Bukkit.getOnlinePlayers()) {
                if (!player.canSee(player2) || !string.isEmpty() && !player2.getName().contains(string)) continue;
                arrayList.add(player2.getName());
            }
        } else {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (!string.isEmpty() && !player.getName().contains(string)) continue;
                arrayList.add(player.getName());
            }
        }
        return arrayList;
    }

    public static List sw() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (World world : Bukkit.getWorlds()) {
            arrayList.add(world.getName());
        }
        return arrayList;
    }

    public static List b(CommandSender commandSender, String[] stringArray) {
        Collection collection = d.g().al.um.values();
        ArrayList<String> arrayList = new ArrayList<String>();
        if (stringArray[stringArray.length - 1].isEmpty()) {
            for (fw fw2 : collection) {
                if (!fw2.ih() || !fw2.a((Permissible)commandSender)) continue;
                arrayList.add(fw2.Q(false));
            }
        } else {
            for (fw fw3 : collection) {
                if (!fw3.ih() || !fw3.getId().contains(stringArray[stringArray.length - 1]) || !fw3.a((Permissible)commandSender)) continue;
                arrayList.add(fw3.Q(false));
            }
        }
        return arrayList;
    }
}
