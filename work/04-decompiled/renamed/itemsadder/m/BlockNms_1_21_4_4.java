package itemsadder.m;

import io.papermc.paper.adventure.PaperAdventure;
import itemsadder.m.PlayerWrapper;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.VersionHelper_3;
import java.util.Optional;
import net.kyori.adventure.inventory.Book;
import net.kyori.adventure.text.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.ChatModifier;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.chat.IChatMutableComponent;
import net.minecraft.network.chat.SignedMessageBody;
import net.minecraft.network.chat.contents.LiteralContents;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.network.Filterable;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.WrittenBookContent;
import org.bukkit.craftbukkit.v1_21_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_21_R3.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_21_R3.util.CraftChatMessage;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BlockNms_1_21_4_4
implements PlayerWrapper {
    private static final IChatBaseComponent Xi = CraftChatMessage.fromStringOrNull((String)" ");

    @Override
    public void i(Player player, String string) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.f.b((Packet)new ClientboundSetActionBarTextPacket((IChatBaseComponent)this.dx(string)));
    }

    @Override
    public void a(Player player, Object object) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.f.b((Packet)new ClientboundSetActionBarTextPacket((IChatBaseComponent)object));
    }

    @Override
    public void bI(Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.f.b((Packet)new ClientboundSetActionBarTextPacket(Xi));
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
    public void a(Player player, Book book) {
        if (VersionHelper_3.sZ()) {
            player.openBook(book);
            return;
        }
        WrittenBookContent writtenBookContent = new WrittenBookContent(Filterable.a((Object)PluginBridge_6.u(book.title())), PluginBridge_6.u(book.author()), 0, book.pages().stream().map(component -> Filterable.a((Object)((IChatBaseComponent)PluginBridge_6.r(component)))).toList(), true);
        net.minecraft.world.item.ItemStack itemStack = Items.uY.n();
        itemStack.b(DataComponents.T, (Object)writtenBookContent);
        player.openBook((ItemStack)CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack));
    }
}
