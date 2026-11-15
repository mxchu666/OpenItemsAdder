package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.BlockNms_1_21_10_18;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.NamespacedKeyItemStackHolder;
import net.minecraft.network.protocol.game.PacketPlayInAutoRecipe;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.crafting.CraftingManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

class PacketListener_19
extends PacketAdapter {
    final /* synthetic */ BlockNms_1_21_10_18 amN;

    PacketListener_19(BlockNms_1_21_10_18 blockNms_1_21_10_18, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.amN = blockNms_1_21_10_18;
        super(adapterParameteters);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        try {
            RecipeHolder recipeHolder;
            NamespacedKeyItemStackHolder namespacedKeyItemStackHolder;
            PacketPlayInAutoRecipe packetPlayInAutoRecipe = (PacketPlayInAutoRecipe)packetEvent.getPacket().getHandle();
            CraftingManager.d d2 = MinecraftServer.getServer().aN().a(packetPlayInAutoRecipe.e());
            Player player = packetEvent.getPlayer();
            if (d2 == null) {
                CommandSenderBridge_5.error("'" + String.valueOf(player) + "' clicked on a recipe that doesn't exist '" + String.valueOf(packetPlayInAutoRecipe.e()) + "'. Hacking?");
                return;
            }
            if (this.amN.amJ.containsKey(player.getUniqueId())) {
                if (System.currentTimeMillis() - (Long)this.amN.amJ.get(player.getUniqueId()) < 5000L) {
                    packetEvent.setCancelled(true);
                    BukkitTaskBridge.i(() -> ((Player)player).closeInventory());
                    player.sendMessage(String.valueOf(ChatColor.RED) + "You abused the recipebook. Wait before using the recipe book again.");
                    return;
                }
                this.amN.amJ.remove(player.getUniqueId());
            }
            if ((namespacedKeyItemStackHolder = ItemStackRegistry.g().aW.cx((recipeHolder = d2.b()).a().a().toString())) != null) {
                packetEvent.setCancelled(true);
                if (this.amN.amG.containsKey(player.getUniqueId())) {
                    return;
                }
                this.amN.amG.put(player.getUniqueId(), true);
                BukkitTaskBridge.i(() -> {
                    this.amN.a(packetPlayInAutoRecipe.b(), packetPlayInAutoRecipe.f(), player, d2.a(), recipeHolder, namespacedKeyItemStackHolder);
                    this.amN.amG.remove(player.getUniqueId());
                });
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
