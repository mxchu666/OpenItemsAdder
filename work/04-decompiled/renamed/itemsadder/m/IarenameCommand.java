package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.PermissibleBridge_2;
import itemsadder.m.PermissibleBridge_4;
import itemsadder.m.PluginCommand_2;
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

public class IarenameCommand
extends PluginCommand_2 {
    public IarenameCommand() {
        Main.cM("iarename").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!(commandSender instanceof Player)) {
            CommandSenderBridge_5.iy("command-ingame-only");
            return true;
        }
        Player player = (Player)commandSender;
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (itemStack.getType() == Material.AIR) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("cannot-repair"));
            return true;
        }
        TextComponent textComponent = Component.text((String)String.join((CharSequence)" ", stringArray));
        textComponent = PermissibleBridge_4.h((Component)textComponent);
        textComponent = PermissibleBridge_2.h((Component)textComponent);
        textComponent = textComponent.style(builder -> builder.decoration(TextDecoration.ITALIC, false));
        ItemStackBridge_2.a(itemStack, (Component)textComponent);
        CommandSenderBridge_5.f(commandSender, Main.PQ.ir("renamed-successfully"));
        return true;
    }
}
