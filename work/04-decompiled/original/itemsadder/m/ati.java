package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.atg;
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

class ati
extends PacketAdapter {
    final /* synthetic */ atg and;

    ati(atg atg2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.and = atg2;
        super(adapterParameteters);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        try {
            RecipeHolder recipeHolder;
            uw uw2;
            PacketPlayInAutoRecipe packetPlayInAutoRecipe = (PacketPlayInAutoRecipe)packetEvent.getPacket().getHandle();
            CraftingManager.d d2 = MinecraftServer.getServer().aI().a(packetPlayInAutoRecipe.e());
            Player player = packetEvent.getPlayer();
            if (d2 == null) {
                bce.error("'" + String.valueOf(player) + "' clicked on a recipe that doesn't exist '" + String.valueOf(packetPlayInAutoRecipe.e()) + "'. Hacking?");
                return;
            }
            if (this.and.amJ.containsKey(player.getUniqueId())) {
                if (System.currentTimeMillis() - (Long)this.and.amJ.get(player.getUniqueId()) < 5000L) {
                    packetEvent.setCancelled(true);
                    bcp.i(() -> ((Player)player).closeInventory());
                    player.sendMessage(String.valueOf(ChatColor.RED) + "You abused the recipebook. Wait before using the recipe book again.");
                    return;
                }
                this.and.amJ.remove(player.getUniqueId());
            }
            if ((uw2 = d.g().aW.cx((recipeHolder = d2.b()).a().a().toString())) != null) {
                packetEvent.setCancelled(true);
                if (this.and.anb.containsKey(player.getUniqueId())) {
                    return;
                }
                this.and.anb.put(player.getUniqueId(), true);
                bcp.i(() -> {
                    this.and.a(packetPlayInAutoRecipe.b(), packetPlayInAutoRecipe.f(), player, d2.a(), recipeHolder, uw2);
                    this.and.anb.remove(player.getUniqueId());
                });
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
