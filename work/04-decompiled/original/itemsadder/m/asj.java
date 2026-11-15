package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import itemsadder.m.ae;
import itemsadder.m.asf;
import itemsadder.m.asi;
import itemsadder.m.bce;
import itemsadder.m.bdq;
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
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipes;
import net.minecraft.world.item.crafting.ShapelessRecipes;
import org.bukkit.plugin.Plugin;

class asj
extends PacketAdapter {
    final /* synthetic */ asi amz;

    asj(asi asi2, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        this.amz = asi2;
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        PacketContainer packetContainer = packetEvent.getPacket();
        long l = bdq.DL();
        PacketPlayOutRecipeUpdate packetPlayOutRecipeUpdate = (PacketPlayOutRecipeUpdate)packetContainer.getHandle();
        ArrayList<RecipeHolder> arrayList = new ArrayList<RecipeHolder>();
        AtomicInteger atomicInteger = new AtomicInteger();
        for (RecipeHolder recipeHolder : packetPlayOutRecipeUpdate.b()) {
            if (recipeHolder.a().b().startsWith(asf.ami)) continue;
            if (ae.dK) {
                if (asi.a(this.amz).containsKey(recipeHolder.a())) {
                    arrayList.add((RecipeHolder)asi.b(this.amz).get(recipeHolder.a()));
                    continue;
                }
                RecipeHolder recipeHolder2 = this.a(recipeHolder, atomicInteger);
                arrayList.add(recipeHolder2);
                asi.c(this.amz).put(recipeHolder2.a(), recipeHolder2);
                continue;
            }
            arrayList.add(recipeHolder);
        }
        packetContainer.getModifier().write(0, arrayList);
        if (ae.dA) {
            bce.warn("Cleaned " + arrayList.size() + " recipes.");
            bce.warn("Cleaned " + atomicInteger.get() + " NBT.");
            bce.warn("Time " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l) + " ms.");
        }
    }

    private RecipeHolder a(RecipeHolder recipeHolder, AtomicInteger atomicInteger) {
        if (recipeHolder.b() instanceof ShapelessRecipes || recipeHolder.b() instanceof ShapedRecipes) {
            RegistryFriendlyByteBuf registryFriendlyByteBuf = new RegistryFriendlyByteBuf((ByteBuf)new PacketDataSerializer(Unpooled.buffer()), (IRegistryCustom)IRegistryCustom.b);
            RecipeSerializer recipeSerializer = recipeHolder.b().ao_();
            IRecipe iRecipe = null;
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
