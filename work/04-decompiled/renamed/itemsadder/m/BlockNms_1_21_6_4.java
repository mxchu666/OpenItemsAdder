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
import net.minecraft.EnumChatFormat;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.ChatClickable;
import net.minecraft.network.chat.ChatModifier;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.chat.IChatMutableComponent;
import net.minecraft.network.chat.SignedMessageBody;
import net.minecraft.network.chat.contents.LiteralContents;
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
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.network.Filterable;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.WrittenBookContent;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_21_R5.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_21_R5.util.CraftChatMessage;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BlockNms_1_21_6_4
implements PlayerWrapper {
    private static final IChatBaseComponent Xk = CraftChatMessage.fromStringOrNull((String)" ");

    @Override
    public void i(Player player, String string) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.g.b((Packet)new ClientboundSetActionBarTextPacket((IChatBaseComponent)this.dx(string)));
    }

    @Override
    public void a(Player player, Object object) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.g.b((Packet)new ClientboundSetActionBarTextPacket((IChatBaseComponent)object));
    }

    @Override
    public void bI(Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.g.b((Packet)new ClientboundSetActionBarTextPacket(Xk));
    }

    @Override
    public Object dx(String string) {
        return IChatMutableComponent.a((ComponentContents)new LiteralContents.a(string));
    }

    @Override
    public Object m(String string, int n) {
        return IChatMutableComponent.a((ComponentContents)new LiteralContents.a(string)).c(ChatModifier.a.a(n));
    }

    @Override
    public boolean b(Object object, String string) {
        if (object instanceof IChatBaseComponent) {
            IChatBaseComponent iChatBaseComponent = (IChatBaseComponent)object;
            return iChatBaseComponent.getString().contains(string);
        }
        return false;
    }

    @Override
    public String d(Object object) {
        SignedMessageBody.a a2 = (SignedMessageBody.a)object;
        return a2.a();
    }

    @Override
    @Nullable
    public Component e(Object object) {
        if (object instanceof IChatBaseComponent) {
            IChatBaseComponent iChatBaseComponent = (IChatBaseComponent)object;
            return PaperAdventure.asAdventure((IChatBaseComponent)iChatBaseComponent);
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
        if (object instanceof IChatBaseComponent) {
            IChatBaseComponent iChatBaseComponent = (IChatBaseComponent)object;
            StringBuilder stringBuilder = new StringBuilder();
            iChatBaseComponent.a(string -> {
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
        IChatMutableComponent iChatMutableComponent;
        try {
            iChatMutableComponent = IChatBaseComponent.b((String)" ".repeat(150));
            PlainMessage plainMessage = new PlainMessage((IChatBaseComponent)IChatBaseComponent.i(), 200);
            multiActionDialog = new MultiActionDialog(new CommonDialogData((IChatBaseComponent)iChatMutableComponent, Optional.empty(), true, false, DialogAction.b, List.of(new ItemBody(CraftItemStack.asNMSCopy((ItemStack)new ItemStack(Material.PURPLE_CONCRETE)), Optional.empty(), false, false, 16, 16), new PlainMessage((IChatBaseComponent)((IChatBaseComponent)PluginBridge_6.r(PluginBridge_6.gK("<gradient:#ac52d4:#6c3484>ItemsAdder</gradient>"))).f().a(EnumChatFormat.r), 200), new PlainMessage((IChatBaseComponent)IChatBaseComponent.b((String)"Welcome!").f("\n").b((IChatBaseComponent)IChatBaseComponent.b((String)"Thanks for buying my plugin! ").b(Color.YELLOW.getRGB())).b((IChatBaseComponent)IChatBaseComponent.b((String)"<3").b(Color.RED.getRGB())).f("\n\n").b((IChatBaseComponent)IChatBaseComponent.b((String)"Before using the plugin you have to finish the installation (it's easy).")), 200), new PlainMessage((IChatBaseComponent)IChatBaseComponent.b((String)"Have fun! :D"), 200), plainMessage, plainMessage, plainMessage, new PlainMessage((IChatBaseComponent)IChatBaseComponent.b((String)"(press ESC to close)"), 200)), List.of()), List.of(new ActionButton(new CommonButtonData((IChatBaseComponent)IChatBaseComponent.b((String)"Hosting Tutorial"), Optional.empty(), 150), Optional.of(new StaticAction((ChatClickable)new ChatClickable.OpenUrl(new URI("https://a.devs.beer/ia-host-pack"))))), new ActionButton(new CommonButtonData((IChatBaseComponent)IChatBaseComponent.b((String)"First Installation"), Optional.empty(), 150), Optional.of(new StaticAction((ChatClickable)new ChatClickable.OpenUrl(new URI("https://a.devs.beer/ia-welcome-first-install"))))), new ActionButton(new CommonButtonData((IChatBaseComponent)IChatBaseComponent.b((String)"Wiki"), Optional.empty(), 150), Optional.of(new StaticAction((ChatClickable)new ChatClickable.OpenUrl(new URI("https://a.devs.beer/ia-welcome-wiki")))))), Optional.empty(), 1);
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new RuntimeException(uRISyntaxException);
        }
        iChatMutableComponent = ((CraftPlayer)player).getHandle();
        iChatMutableComponent.b(Holder.a((Object)multiActionDialog));
    }

    @Override
    public void a(Player player, Book book) {
        if (VersionHelper_3.sZ()) {
            player.openBook(book);
            return;
        }
        WrittenBookContent writtenBookContent = new WrittenBookContent(Filterable.a((Object)PluginBridge_6.u(book.title())), PluginBridge_6.u(book.author()), 0, book.pages().stream().map(component -> Filterable.a((Object)((IChatBaseComponent)PluginBridge_6.r(component)))).toList(), true);
        net.minecraft.world.item.ItemStack itemStack = Items.vB.m();
        itemStack.b(DataComponents.V, (Object)writtenBookContent);
        player.openBook((ItemStack)CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack));
    }
}
