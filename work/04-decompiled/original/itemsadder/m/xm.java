package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bce;
import itemsadder.m.bch;
import itemsadder.m.qm;
import itemsadder.m.qq;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.format.TextColor;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.Nullable;

public class xm {
    public static final Pattern Su = Pattern.compile("<([^\\s>]+)\\s([^>]+)>", 2);

    static int @Nullable [] dl(String string) {
        int[] nArray;
        switch (string) {
            case "r": {
                int[] nArray2 = new int[3];
                nArray2[0] = 230;
                nArray2[1] = 255;
                nArray = nArray2;
                nArray2[2] = 254;
                break;
            }
            case "w": {
                int[] nArray3 = new int[3];
                nArray3[0] = 230;
                nArray3[1] = 255;
                nArray = nArray3;
                nArray3[2] = 250;
                break;
            }
            case "rw": {
                int[] nArray4 = new int[3];
                nArray4[0] = 230;
                nArray4[1] = 251;
                nArray = nArray4;
                nArray4[2] = 254;
                break;
            }
            case "j": {
                int[] nArray5 = new int[3];
                nArray5[0] = 230;
                nArray5[1] = 251;
                nArray = nArray5;
                nArray5[2] = 250;
                break;
            }
            case "rj": {
                int[] nArray6 = new int[3];
                nArray6[0] = 230;
                nArray6[1] = 247;
                nArray = nArray6;
                nArray6[2] = 254;
                break;
            }
            case "b": {
                int[] nArray7 = new int[3];
                nArray7[0] = 230;
                nArray7[1] = 247;
                nArray = nArray7;
                nArray7[2] = 250;
                break;
            }
            case "noshadow": {
                int[] nArray8 = new int[3];
                nArray8[0] = 78;
                nArray8[1] = 92;
                nArray = nArray8;
                nArray8[2] = 36;
                break;
            }
            default: {
                nArray = null;
            }
        }
        return nArray;
    }

    public static boolean j(Component component) {
        for (Component component2 : component.children()) {
            if (!xm.j(component2)) continue;
            return true;
        }
        TextColor textColor = component.color();
        if (textColor == null) {
            return false;
        }
        if (textColor.red() == 0 && textColor.green() == 0 && textColor.blue() == 0) {
            return false;
        }
        if (textColor.red() == 230 && textColor.green() == 255 && textColor.blue() == 254) {
            return true;
        }
        if (textColor.red() == 230 && textColor.green() == 255 && textColor.blue() == 250) {
            return true;
        }
        if (textColor.red() == 230 && textColor.green() == 251 && textColor.blue() == 254) {
            return true;
        }
        if (textColor.red() == 230 && textColor.green() == 251 && textColor.blue() == 250) {
            return true;
        }
        if (textColor.red() == 230 && textColor.green() == 247 && textColor.blue() == 254) {
            return true;
        }
        if (textColor.red() == 230 && textColor.green() == 247 && textColor.blue() == 250) {
            return true;
        }
        return textColor.red() == 78 && textColor.green() == 92 && textColor.blue() == 36;
    }

    public static Component h(Component component) {
        return xm.a(null, component);
    }

    public static Component a(Component component, bch bch2) {
        return xm.a(null, component, bch2);
    }

    public static boolean dk(String string) {
        return string.contains("<") && string.contains(">");
    }

    public static Component a(@Nullable Permissible permissible, Component component) {
        return xm.a(permissible, component, bch.Dk());
    }

    private static Component a(@Nullable Permissible permissible, Component component, bch bch2) {
        return component.replaceText((TextReplacementConfig)TextReplacementConfig.builder().match(Su).replacement(builder -> {
            Matcher matcher = Su.matcher(builder.content());
            if (matcher.matches()) {
                String string = matcher.group(1);
                int[] nArray = xm.dl(string);
                if (nArray == null) {
                    return builder;
                }
                bch2.aAW = true;
                if (permissible != null && !permissible.hasPermission("ia.user.text_effect.use." + string)) {
                    if (permissible instanceof Player) {
                        bce.f((CommandSender)((Player)permissible), Main.PQ.ir("no-permission-detail").replace("{permission}", "ia.user.text_effect.use." + string));
                    }
                    return builder.content(matcher.group(2));
                }
                return builder.content(matcher.group(2)).color(TextColor.color((int)nArray[0], (int)nArray[1], (int)nArray[2]));
            }
            return builder;
        }).build());
    }

    public static String e(Permissible permissible, String string) {
        Matcher matcher = Su.matcher(string);
        while (matcher.find()) {
            String string2 = matcher.group();
            String string3 = matcher.group(1);
            if (permissible.hasPermission("ia.user.text_effect.use." + string3)) continue;
            string = StringUtils.replace((String)string, (String)string2, (String)string3.replace(string3, ""));
        }
        return string;
    }

    public static void z(qm qm2) {
        qm.a(qm2, (Component component) -> {
            bch bch2 = bch.G(false);
            component = xm.a(null, component, bch2);
            return new qq(component, (Boolean)bch2.aAW);
        });
    }
}
