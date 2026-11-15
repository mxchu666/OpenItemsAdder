package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.BlockNms_26_1_1_18;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.NamespacedKeyItemStackHolder;
import net.minecraft.network.protocol.game.ServerboundPlaceRecipePacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

class PacketListener_35
extends PacketAdapter {
    final /* synthetic */ BlockNms_26_1_1_18 ant;

    PacketListener_35(BlockNms_26_1_1_18 blockNms_26_1_1_18, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.ant = blockNms_26_1_1_18;
        super(adapterParameteters);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        try {
            RecipeHolder recipeHolder;
            NamespacedKeyItemStackHolder namespacedKeyItemStackHolder;
            ServerboundPlaceRecipePacket serverboundPlaceRecipePacket = (ServerboundPlaceRecipePacket)packetEvent.getPacket().getHandle();
            RecipeManager.ServerDisplayInfo serverDisplayInfo = MinecraftServer.getServer().getRecipeManager().getRecipeFromDisplay(serverboundPlaceRecipePacket.recipe());
            Player player = packetEvent.getPlayer();
            if (serverDisplayInfo == null) {
                CommandSenderBridge_5.error("'" + String.valueOf(player) + "' clicked on a recipe that doesn't exist '" + String.valueOf(serverboundPlaceRecipePacket.recipe()) + "'. Hacking?");
                return;
            }
            if (this.ant.amJ.containsKey(player.getUniqueId())) {
                if (System.currentTimeMillis() - (Long)this.ant.amJ.get(player.getUniqueId()) < 5000L) {
                    packetEvent.setCancelled(true);
                    BukkitTaskBridge.i(() -> ((Player)player).closeInventory());
                    player.sendMessage(String.valueOf(ChatColor.RED) + "You abused the recipebook. Wait before using the recipe book again.");
                    return;
                }
                this.ant.amJ.remove(player.getUniqueId());
            }
            if ((namespacedKeyItemStackHolder = ItemStackRegistry.g().aW.cx((recipeHolder = serverDisplayInfo.parent()).id().identifier().toString())) != null) {
                packetEvent.setCancelled(true);
                if (this.ant.anr.containsKey(player.getUniqueId())) {
                    return;
                }
                this.ant.anr.put(player.getUniqueId(), true);
                BukkitTaskBridge.i(() -> {
                    this.ant.a(serverboundPlaceRecipePacket.containerId(), serverboundPlaceRecipePacket.useMaxItems(), player, serverDisplayInfo.display(), recipeHolder, namespacedKeyItemStackHolder);
                    this.ant.anr.remove(player.getUniqueId());
                });
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
