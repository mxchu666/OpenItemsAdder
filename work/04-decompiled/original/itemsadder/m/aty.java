package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.atw;
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

class aty
extends PacketAdapter {
    final /* synthetic */ atw ant;

    aty(atw atw2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.ant = atw2;
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
            if (this.ant.amJ.containsKey(player.getUniqueId())) {
                if (System.currentTimeMillis() - (Long)this.ant.amJ.get(player.getUniqueId()) < 5000L) {
                    packetEvent.setCancelled(true);
                    bcp.i(() -> ((Player)player).closeInventory());
                    player.sendMessage(String.valueOf(ChatColor.RED) + "You abused the recipebook. Wait before using the recipe book again.");
                    return;
                }
                this.ant.amJ.remove(player.getUniqueId());
            }
            if ((uw2 = d.g().aW.cx((recipeHolder = serverDisplayInfo.parent()).id().identifier().toString())) != null) {
                packetEvent.setCancelled(true);
                if (this.ant.anr.containsKey(player.getUniqueId())) {
                    return;
                }
                this.ant.anr.put(player.getUniqueId(), true);
                bcp.i(() -> {
                    this.ant.a(serverboundPlaceRecipePacket.containerId(), serverboundPlaceRecipePacket.useMaxItems(), player, serverDisplayInfo.display(), recipeHolder, uw2);
                    this.ant.anr.remove(player.getUniqueId());
                });
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
