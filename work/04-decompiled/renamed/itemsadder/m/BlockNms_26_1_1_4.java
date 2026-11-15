package itemsadder.m;

import io.papermc.paper.adventure.PaperAdventure;
import itemsadder.m.PlayerWrapper;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.VersionHelper_3;
import java.awt.Color;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import net.kyori.adventure.inventory.Book;
import net.kyori.adventure.text.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.SignedMessageBody;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.contents.PlainTextContents;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.server.dialog.ActionButton;
import net.minecraft.server.dialog.CommonButtonData;
import net.minecraft.server.dialog.CommonDialogData;
import net.minecraft.server.dialog.DialogAction;
import net.minecraft.server.dialog.MultiActionDialog;
import net.minecraft.server.dialog.action.StaticAction;
import net.minecraft.server.dialog.body.ItemBody;
import net.minecraft.server.dialog.body.PlainMessage;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.Filterable;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.WrittenBookContent;
import org.bukkit.Material;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.craftbukkit.util.CraftChatMessage;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BlockNms_26_1_1_4
implements PlayerWrapper {
    private static final net.minecraft.network.chat.Component Xn = CraftChatMessage.fromStringOrNull((String)" ");

    @Override
    public void i(Player player, String string) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        serverPlayer.connection.send((Packet)new ClientboundSetActionBarTextPacket((net.minecraft.network.chat.Component)this.dx(string)));
    }

    @Override
    public void a(Player player, Object object) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        serverPlayer.connection.send((Packet)new ClientboundSetActionBarTextPacket((net.minecraft.network.chat.Component)object));
    }

    @Override
    public void bI(Player player) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        serverPlayer.connection.send((Packet)new ClientboundSetActionBarTextPacket(Xn));
    }

    @Override
    public Object dx(String string) {
        return MutableComponent.create((ComponentContents)new PlainTextContents.LiteralContents(string));
    }

    @Override
    public Object m(String string, int n) {
        return MutableComponent.create((ComponentContents)new PlainTextContents.LiteralContents(string)).withStyle(Style.EMPTY.withColor(n));
    }

    @Override
    public boolean b(Object object, String string) {
        if (object instanceof net.minecraft.network.chat.Component) {
            net.minecraft.network.chat.Component component = (net.minecraft.network.chat.Component)object;
            return component.getString().contains(string);
        }
        return false;
    }

    @Override
    public String d(Object object) {
        SignedMessageBody.Packed packed = (SignedMessageBody.Packed)object;
        return packed.content();
    }

    @Override
    @Nullable
    public Component e(Object object) {
        if (object instanceof net.minecraft.network.chat.Component) {
            net.minecraft.network.chat.Component component = (net.minecraft.network.chat.Component)object;
            return PaperAdventure.asAdventure((net.minecraft.network.chat.Component)component);
        }
        return null;
    }

    @Override
    @Nullable
    public Object f(Object object) {
        if (object instanceof Component) {
            Component component = (Component)object;
            return PaperAdventure.asVanilla((Component)component);
        }
        return null;
    }

    @Override
    public String g(Object object) {
        if (object instanceof net.minecraft.network.chat.Component) {
            net.minecraft.network.chat.Component component = (net.minecraft.network.chat.Component)object;
            StringBuilder stringBuilder = new StringBuilder();
            component.visit(string -> {
                stringBuilder.append(string);
                return Optional.empty();
            });
            return stringBuilder.toString();
        }
        return object.toString();
    }

    @Override
    public void bJ(Player player) {
        MultiActionDialog multiActionDialog;
        MutableComponent mutableComponent;
        try {
            mutableComponent = net.minecraft.network.chat.Component.literal((String)" ".repeat(150));
            PlainMessage plainMessage = new PlainMessage((net.minecraft.network.chat.Component)net.minecraft.network.chat.Component.empty(), 200);
            multiActionDialog = new MultiActionDialog(new CommonDialogData((net.minecraft.network.chat.Component)mutableComponent, Optional.empty(), true, false, DialogAction.NONE, List.of(new ItemBody(ItemStackTemplate.fromNonEmptyStack((net.minecraft.world.item.ItemStack)CraftItemStack.asNMSCopy((ItemStack)new ItemStack(Material.PURPLE_CONCRETE))), Optional.empty(), false, false, 16, 16), new PlainMessage((net.minecraft.network.chat.Component)((net.minecraft.network.chat.Component)PluginBridge_6.r(PluginBridge_6.gK("<gradient:#ac52d4:#6c3484>ItemsAdder</gradient>"))).copy().withStyle(ChatFormatting.BOLD), 200), new PlainMessage((net.minecraft.network.chat.Component)net.minecraft.network.chat.Component.literal((String)"Welcome!").append("\n").append((net.minecraft.network.chat.Component)net.minecraft.network.chat.Component.literal((String)"Thanks for buying my plugin! ").withColor(Color.YELLOW.getRGB())).append((net.minecraft.network.chat.Component)net.minecraft.network.chat.Component.literal((String)"<3").withColor(Color.RED.getRGB())).append("\n\n").append((net.minecraft.network.chat.Component)net.minecraft.network.chat.Component.literal((String)"Before using the plugin you have to finish the installation (it's easy).")), 200), new PlainMessage((net.minecraft.network.chat.Component)net.minecraft.network.chat.Component.literal((String)"Have fun! :D"), 200), plainMessage, plainMessage, plainMessage, new PlainMessage((net.minecraft.network.chat.Component)net.minecraft.network.chat.Component.literal((String)"(press ESC to close)"), 200)), List.of()), List.of(new ActionButton(new CommonButtonData((net.minecraft.network.chat.Component)net.minecraft.network.chat.Component.literal((String)"Hosting Tutorial"), Optional.empty(), 150), Optional.of(new StaticAction((ClickEvent)new ClickEvent.OpenUrl(new URI("https://a.devs.beer/ia-host-pack"))))), new ActionButton(new CommonButtonData((net.minecraft.network.chat.Component)net.minecraft.network.chat.Component.literal((String)"First Installation"), Optional.empty(), 150), Optional.of(new StaticAction((ClickEvent)new ClickEvent.OpenUrl(new URI("https://a.devs.beer/ia-welcome-first-install"))))), new ActionButton(new CommonButtonData((net.minecraft.network.chat.Component)net.minecraft.network.chat.Component.literal((String)"Wiki"), Optional.empty(), 150), Optional.of(new StaticAction((ClickEvent)new ClickEvent.OpenUrl(new URI("https://a.devs.beer/ia-welcome-wiki")))))), Optional.empty(), 1);
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new RuntimeException(uRISyntaxException);
        }
        mutableComponent = ((CraftPlayer)player).getHandle();
        mutableComponent.openDialog(Holder.direct((Object)multiActionDialog));
    }

    @Override
    public void a(Player player, Book book) {
        if (VersionHelper_3.sZ()) {
            player.openBook(book);
            return;
        }
        WrittenBookContent writtenBookContent = new WrittenBookContent(Filterable.passThrough((Object)PluginBridge_6.u(book.title())), PluginBridge_6.u(book.author()), 0, book.pages().stream().map(component -> Filterable.passThrough((Object)((net.minecraft.network.chat.Component)PluginBridge_6.r(component)))).toList(), true);
        net.minecraft.world.item.ItemStack itemStack = Items.WRITTEN_BOOK.getDefaultInstance();
        itemStack.set(DataComponents.WRITTEN_BOOK_CONTENT, (Object)writtenBookContent);
        player.openBook((ItemStack)CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack));
    }
}
