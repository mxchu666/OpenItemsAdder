package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.aue;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.d;
import itemsadder.m.uw;
import net.minecraft.network.protocol.game.ServerboundPlaceRecipePacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

class aug
extends PacketAdapter {
    final /* synthetic */ aue anB;

    aug(aue aue2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.anB = aue2;
        super(adapterParameteters);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        try {
            RecipeHolder recipeHolder;
            uw uw2;
            ServerboundPlaceRecipePacket serverboundPlaceRecipePacket = (ServerboundPlaceRecipePacket)packetEvent.getPacket().getHandle();
            RecipeManager.ServerDisplayInfo serverDisplayInfo = MinecraftServer.getServer().getRecipeManager().getRecipeFromDisplay(serverboundPlaceRecipePacket.recipe());
            Player player = packetEvent.getPlayer();
            if (serverDisplayInfo == null) {
                bce.error("'" + String.valueOf(player) + "' clicked on a recipe that doesn't exist '" + String.valueOf(serverboundPlaceRecipePacket.recipe()) + "'. Hacking?");
                return;
            }
            if (this.anB.amJ.containsKey(player.getUniqueId())) {
                if (System.currentTimeMillis() - (Long)this.anB.amJ.get(player.getUniqueId()) < 5000L) {
                    packetEvent.setCancelled(true);
                    bcp.i(() -> ((Player)player).closeInventory());
                    player.sendMessage(String.valueOf(ChatColor.RED) + "You abused the recipebook. Wait before using the recipe book again.");
                    return;
                }
                this.anB.amJ.remove(player.getUniqueId());
            }
            if ((uw2 = d.g().aW.cx((recipeHolder = serverDisplayInfo.parent()).id().identifier().toString())) != null) {
                packetEvent.setCancelled(true);
                if (this.anB.anz.containsKey(player.getUniqueId())) {
                    return;
                }
                this.anB.anz.put(player.getUniqueId(), true);
                bcp.i(() -> {
                    this.anB.a(serverboundPlaceRecipePacket.containerId(), serverboundPlaceRecipePacket.useMaxItems(), player, serverDisplayInfo.display(), recipeHolder, uw2);
                    this.anB.anz.remove(player.getUniqueId());
                });
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
