package itemsadder.m;

import java.awt.Color;
import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.fusesource.jansi.Ansi;

public class Opaque013 {
    private static final Map azv = new EnumMap(ChatColor.class);
    private static final ChatColor[] azw;
    private static final String azx = "\u001b[38;2;%d;%d;%dm";
    private static final Pattern azy;
    private Logger azz;
    private String azA;

    public Opaque013() {
        this("");
    }

    public Opaque013(String string) {
        this.azA = Opaque013.gA(string);
        this.azz = Bukkit.getServer() == null ? Logger.getGlobal() : Bukkit.getLogger();
    }

    public Opaque013(String string, Logger logger) {
        this.azA = Opaque013.gA(string);
        this.azz = logger;
    }

    public void gz(String string) {
        this.azA = Opaque013.gA(string);
    }

    public void a(Logger logger) {
        this.azz = logger;
    }

    public void a(Level level, String string) {
        this.azz.log(level, this.azA + Opaque013.gA(string));
    }

    public void a(Level level, String string, Throwable throwable) {
        this.azz.log(level, this.azA + Opaque013.gA(string), throwable);
    }

    private static String gA(String string) {
        if (!string.isEmpty()) {
            string = ChatColor.translateAlternateColorCodes((char)'&', (String)string);
            String string2 = Opaque013.gB(string);
            for (ChatColor chatColor : azw) {
                string2 = string2.replaceAll("(?i)" + chatColor.toString(), azv.getOrDefault(chatColor, ""));
            }
            return string2 + Ansi.ansi().reset().toString();
        }
        return string;
    }

    private static String gB(String string) {
        Matcher matcher = azy.matcher(string);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String string2 = matcher.group().replace("\u00a7", "").replace('x', '#');
            Color color = Color.decode(string2);
            int n = color.getRed();
            int n2 = color.getBlue();
            int n3 = color.getGreen();
            String string3 = String.format(azx, n, n3, n2);
            matcher.appendReplacement(stringBuffer, string3);
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    static {
        azv.put(ChatColor.BLACK, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLACK).boldOff().toString());
        azv.put(ChatColor.DARK_BLUE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLUE).boldOff().toString());
        azv.put(ChatColor.DARK_GREEN, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.GREEN).boldOff().toString());
        azv.put(ChatColor.DARK_AQUA, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.CYAN).boldOff().toString());
        azv.put(ChatColor.DARK_RED, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.RED).boldOff().toString());
        azv.put(ChatColor.DARK_PURPLE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.MAGENTA).boldOff().toString());
        azv.put(ChatColor.GOLD, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.YELLOW).boldOff().toString());
        azv.put(ChatColor.GRAY, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.WHITE).boldOff().toString());
        azv.put(ChatColor.DARK_GRAY, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLACK).bold().toString());
        azv.put(ChatColor.BLUE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLUE).bold().toString());
        azv.put(ChatColor.GREEN, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.GREEN).bold().toString());
        azv.put(ChatColor.AQUA, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.CYAN).bold().toString());
        azv.put(ChatColor.RED, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.RED).bold().toString());
        azv.put(ChatColor.LIGHT_PURPLE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.MAGENTA).bold().toString());
        azv.put(ChatColor.YELLOW, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.YELLOW).bold().toString());
        azv.put(ChatColor.WHITE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.WHITE).bold().toString());
        azv.put(ChatColor.MAGIC, Ansi.ansi().a(Ansi.Attribute.BLINK_SLOW).toString());
        azv.put(ChatColor.BOLD, Ansi.ansi().a(Ansi.Attribute.UNDERLINE_DOUBLE).toString());
        azv.put(ChatColor.STRIKETHROUGH, Ansi.ansi().a(Ansi.Attribute.STRIKETHROUGH_ON).toString());
        azv.put(ChatColor.UNDERLINE, Ansi.ansi().a(Ansi.Attribute.UNDERLINE).toString());
        azv.put(ChatColor.ITALIC, Ansi.ansi().a(Ansi.Attribute.ITALIC).toString());
        azv.put(ChatColor.RESET, Ansi.ansi().a(Ansi.Attribute.RESET).toString());
        azw = ChatColor.values();
        azy = Pattern.compile("\u00a7x(\u00a7[A-F0-9]){6}", 2);
    }
}
