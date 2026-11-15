package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import java.util.WeakHashMap;
import org.bukkit.command.CommandSender;

public class CommandSenderBridge_7 {
    CommandSender SK;
    String SL;
    long Nb;

    public CommandSenderBridge_7(CommandSender commandSender, String string, String[] stringArray) {
        this.SK = commandSender;
        this.SL = string + " " + String.join((CharSequence)" ", stringArray);
        this.Nb = System.currentTimeMillis();
    }

    public static void a(WeakHashMap weakHashMap, CommandSender commandSender, String string, String[] stringArray, String string3) {
        weakHashMap.put(commandSender, new CommandSenderBridge_7(commandSender, string, stringArray));
        CommandSenderBridge_5.a(commandSender, "confirm-command", string2 -> string2.replace("{command}", string));
        if (string3 != null) {
            CommandSenderBridge_5.f(commandSender, string3);
        }
    }

    public boolean b(String string, String[] stringArray) {
        return System.currentTimeMillis() - this.Nb < 5000L;
    }

    public boolean c(String string, String[] stringArray) {
        return (string + " " + String.join((CharSequence)" ", stringArray)).equals(this.SL);
    }
}
