package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import itemsadder.m.BlockNms_1_21_1_18;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque028;
import itemsadder.m.PlayerQuitListenerBase;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.core.IRegistryCustom;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.PacketDataSerializer;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.game.PacketPlayOutRecipeUpdate;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.IRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeItemStack;
import net.minecraft.world.item.crafting.ShapedRecipes;
import net.minecraft.world.item.crafting.ShapelessRecipes;
import org.bukkit.plugin.Plugin;

class HowFuckListener_2
extends PacketAdapter {
    final /* synthetic */ BlockNms_1_21_1_18 amC;

    HowFuckListener_2(BlockNms_1_21_1_18 blockNms_1_21_1_18, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        this.amC = blockNms_1_21_1_18;
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        long l = Opaque028.DL();
        PacketContainer packetContainer = packetEvent.getPacket();
        PacketPlayOutRecipeUpdate packetPlayOutRecipeUpdate = (PacketPlayOutRecipeUpdate)packetContainer.getHandle();
        ArrayList<RecipeHolder> arrayList = new ArrayList<RecipeHolder>();
        AtomicInteger atomicInteger = new AtomicInteger();
        for (RecipeHolder recipeHolder : packetPlayOutRecipeUpdate.b()) {
            if (recipeHolder.a().b().startsWith(PlayerQuitListenerBase.ami)) continue;
            if (MaterialBarColorHolder.dK) {
                if (BlockNms_1_21_1_18.a(this.amC).containsKey(recipeHolder.a())) {
                    arrayList.add((RecipeHolder)BlockNms_1_21_1_18.b(this.amC).get(recipeHolder.a()));
                    continue;
                }
                RecipeHolder recipeHolder2 = this.a(recipeHolder, atomicInteger);
                arrayList.add(recipeHolder2);
                BlockNms_1_21_1_18.c(this.amC).put(recipeHolder2.a(), recipeHolder2);
                continue;
            }
            arrayList.add(recipeHolder);
        }
        packetContainer.getModifier().write(0, arrayList);
        if (MaterialBarColorHolder.dA) {
            CommandSenderBridge_5.warn("Cleaned " + arrayList.size() + " recipes.");
            CommandSenderBridge_5.warn("Cleaned " + atomicInteger.get() + " NBT.");
            CommandSenderBridge_5.warn("Time " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l) + " ms.");
        }
    }

    private RecipeHolder a(RecipeHolder recipeHolder, AtomicInteger atomicInteger) {
        if (recipeHolder.b() instanceof ShapelessRecipes || recipeHolder.b() instanceof ShapedRecipes) {
            IRecipe iRecipe;
            RegistryFriendlyByteBuf registryFriendlyByteBuf = new RegistryFriendlyByteBuf((ByteBuf)new PacketDataSerializer(Unpooled.buffer()), (IRegistryCustom)IRegistryCustom.b);
            if (recipeHolder.b() instanceof ShapelessRecipes) {
                ShapelessRecipes.i.encode((Object)registryFriendlyByteBuf, (Object)recipeHolder.b());
                iRecipe = (IRecipe)ShapelessRecipes.i.decode((Object)registryFriendlyByteBuf);
            } else if (recipeHolder.b() instanceof ShapedRecipes) {
                ShapedRecipes.i.encode((Object)registryFriendlyByteBuf, (Object)recipeHolder.b());
                iRecipe = (IRecipe)ShapedRecipes.i.decode((Object)registryFriendlyByteBuf);
            } else {
                throw new RuntimeException("How the fuck?");
            }
            for (Object e : iRecipe.a()) {
                RecipeItemStack recipeItemStack = (RecipeItemStack)e;
                for (ItemStack itemStack : recipeItemStack.a()) {
                    itemStack.c(DataComponents.i);
                    itemStack.c(DataComponents.n);
                    itemStack.c(DataComponents.b);
                    atomicInteger.incrementAndGet();
                }
            }
            return new RecipeHolder(recipeHolder.a(), iRecipe);
        }
        return recipeHolder;
    }
}
