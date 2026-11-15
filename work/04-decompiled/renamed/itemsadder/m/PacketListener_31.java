package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.BlockNms_1_21_7_18;
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

class PacketListener_31
extends PacketAdapter {
    final /* synthetic */ BlockNms_1_21_7_18 anl;

    PacketListener_31(BlockNms_1_21_7_18 blockNms_1_21_7_18, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.anl = blockNms_1_21_7_18;
        super(adapterParameteters);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        try {
            RecipeHolder recipeHolder;
            NamespacedKeyItemStackHolder namespacedKeyItemStackHolder;
            PacketPlayInAutoRecipe packetPlayInAutoRecipe = (PacketPlayInAutoRecipe)packetEvent.getPacket().getHandle();
            CraftingManager.d d2 = MinecraftServer.getServer().aI().a(packetPlayInAutoRecipe.e());
            Player player = packetEvent.getPlayer();
            if (d2 == null) {
                CommandSenderBridge_5.error("'" + String.valueOf(player) + "' clicked on a recipe that doesn't exist '" + String.valueOf(packetPlayInAutoRecipe.e()) + "'. Hacking?");
                return;
            }
            if (this.anl.amJ.containsKey(player.getUniqueId())) {
                if (System.currentTimeMillis() - (Long)this.anl.amJ.get(player.getUniqueId()) < 5000L) {
                    packetEvent.setCancelled(true);
                    BukkitTaskBridge.i(() -> ((Player)player).closeInventory());
                    player.sendMessage(String.valueOf(ChatColor.RED) + "You abused the recipebook. Wait before using the recipe book again.");
                    return;
                }
                this.anl.amJ.remove(player.getUniqueId());
            }
            if ((namespacedKeyItemStackHolder = ItemStackRegistry.g().aW.cx((recipeHolder = d2.b()).a().a().toString())) != null) {
                packetEvent.setCancelled(true);
                if (this.anl.anj.containsKey(player.getUniqueId())) {
                    return;
                }
                this.anl.anj.put(player.getUniqueId(), true);
                BukkitTaskBridge.i(() -> {
                    this.anl.a(packetPlayInAutoRecipe.b(), packetPlayInAutoRecipe.f(), player, d2.a(), recipeHolder, namespacedKeyItemStackHolder);
                    this.anl.anj.remove(player.getUniqueId());
                });
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
