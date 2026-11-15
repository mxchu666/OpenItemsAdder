package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.asu;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.d;
import itemsadder.m.uw;
import net.minecraft.network.protocol.game.PacketPlayInAutoRecipe;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.crafting.CraftingManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

class asw
extends PacketAdapter {
    final /* synthetic */ asu amR;

    asw(asu asu2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.amR = asu2;
        super(adapterParameteters);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        try {
            RecipeHolder recipeHolder;
            uw uw2;
            PacketPlayInAutoRecipe packetPlayInAutoRecipe = (PacketPlayInAutoRecipe)packetEvent.getPacket().getHandle();
            CraftingManager.d d2 = MinecraftServer.getServer().aJ().a(packetPlayInAutoRecipe.e());
            Player player = packetEvent.getPlayer();
            if (d2 == null) {
                bce.error("'" + String.valueOf(player) + "' clicked on a recipe that doesn't exist '" + String.valueOf(packetPlayInAutoRecipe.e()) + "'. Hacking?");
                return;
            }
            if (this.amR.amJ.containsKey(player.getUniqueId())) {
                if (System.currentTimeMillis() - (Long)this.amR.amJ.get(player.getUniqueId()) < 5000L) {
                    packetEvent.setCancelled(true);
                    bcp.i(() -> ((Player)player).closeInventory());
                    player.sendMessage(String.valueOf(ChatColor.RED) + "You abused the recipebook. Wait before using the recipe book again.");
                    return;
                }
                this.amR.amJ.remove(player.getUniqueId());
            }
            if ((uw2 = d.g().aW.cx((recipeHolder = d2.b()).a().a().toString())) != null) {
                packetEvent.setCancelled(true);
                if (this.amR.amP.containsKey(player.getUniqueId())) {
                    return;
                }
                this.amR.amP.put(player.getUniqueId(), true);
                bcp.i(() -> {
                    this.amR.a(packetPlayInAutoRecipe.b(), packetPlayInAutoRecipe.f(), player, d2.a(), recipeHolder, uw2);
                    this.amR.amP.remove(player.getUniqueId());
                });
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
