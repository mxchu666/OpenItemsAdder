package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.xk;
import itemsadder.m.xm;
import itemsadder.m.za;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class yr
extends za {
    public yr() {
        Main.cM("iarename").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!(commandSender instanceof Player)) {
            bce.iy("command-ingame-only");
            return true;
        }
        Player player = (Player)commandSender;
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (itemStack.getType() == Material.AIR) {
            bce.f(commandSender, Main.PQ.ir("cannot-repair"));
            return true;
        }
        TextComponent textComponent = Component.text((String)String.join((CharSequence)" ", stringArray));
        textComponent = xm.h((Component)textComponent);
        textComponent = xk.h((Component)textComponent);
        textComponent = textComponent.style(builder -> builder.decoration(TextDecoration.ITALIC, false));
        bbs.a(itemStack, (Component)textComponent);
        bce.f(commandSender, Main.PQ.ir("renamed-successfully"));
        return true;
    }
}
