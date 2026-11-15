package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.ato;
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

class atq
extends PacketAdapter {
    final /* synthetic */ ato anl;

    atq(ato ato2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.anl = ato2;
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
            if (this.anl.amJ.containsKey(player.getUniqueId())) {
                if (System.currentTimeMillis() - (Long)this.anl.amJ.get(player.getUniqueId()) < 5000L) {
                    packetEvent.setCancelled(true);
                    bcp.i(() -> ((Player)player).closeInventory());
                    player.sendMessage(String.valueOf(ChatColor.RED) + "You abused the recipebook. Wait before using the recipe book again.");
                    return;
                }
                this.anl.amJ.remove(player.getUniqueId());
            }
            if ((uw2 = d.g().aW.cx((recipeHolder = d2.b()).a().a().toString())) != null) {
                packetEvent.setCancelled(true);
                if (this.anl.anj.containsKey(player.getUniqueId())) {
                    return;
                }
                this.anl.anj.put(player.getUniqueId(), true);
                bcp.i(() -> {
                    this.anl.a(packetPlayInAutoRecipe.b(), packetPlayInAutoRecipe.f(), player, d2.a(), recipeHolder, uw2);
                    this.anl.anj.remove(player.getUniqueId());
                });
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
