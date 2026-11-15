package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.aua;
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

class auc
extends PacketAdapter {
    final /* synthetic */ aua anx;

    auc(aua aua2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.anx = aua2;
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
            if (this.anx.amJ.containsKey(player.getUniqueId())) {
                if (System.currentTimeMillis() - (Long)this.anx.amJ.get(player.getUniqueId()) < 5000L) {
                    packetEvent.setCancelled(true);
                    bcp.i(() -> ((Player)player).closeInventory());
                    player.sendMessage(String.valueOf(ChatColor.RED) + "You abused the recipebook. Wait before using the recipe book again.");
                    return;
                }
                this.anx.amJ.remove(player.getUniqueId());
            }
            if ((uw2 = d.g().aW.cx((recipeHolder = serverDisplayInfo.parent()).id().identifier().toString())) != null) {
                packetEvent.setCancelled(true);
                if (this.anx.anv.containsKey(player.getUniqueId())) {
                    return;
                }
                this.anx.anv.put(player.getUniqueId(), true);
                bcp.i(() -> {
                    this.anx.a(serverboundPlaceRecipePacket.containerId(), serverboundPlaceRecipePacket.useMaxItems(), player, serverDisplayInfo.display(), recipeHolder, uw2);
                    this.anx.anv.remove(player.getUniqueId());
                });
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
