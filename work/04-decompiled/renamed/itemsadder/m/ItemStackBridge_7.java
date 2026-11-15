package itemsadder.m;

import dev.lone.itemsadder.api.Events.TradeMachineOpenEvent;
import dev.lone.itemsadder.api.Events.TradeMachinePreOpenEvent;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ListenerBridge;
import itemsadder.m.Opaque123;
import itemsadder.m.Opaque126;
import itemsadder.m.PermissibleBridge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Generated;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.jetbrains.annotations.Nullable;

public class ItemStackBridge_7
extends Opaque126 {
    public final List merchantRecipes = new ArrayList();
    String yT;
    PermissibleBridge yU;
    PermissibleBridge yV;
    int yW;
    String gx;

    public ItemStackBridge_7(ItemStackBuilder_4 itemStackBuilder_4, String string) {
        super(itemStackBuilder_4);
        this.yT = string;
    }

    @Nullable
    public String getPermission() {
        return this.gx;
    }

    public void be(String string) {
        this.gx = string;
    }

    public void b(PermissibleBridge permissibleBridge) {
        this.yU = permissibleBridge;
    }

    public void c(PermissibleBridge permissibleBridge) {
        this.yV = permissibleBridge;
    }

    public void aa(int n) {
        this.yW = n;
    }

    public void kW() {
        if (this.yU != null && this.yV != null) {
            this.yT = String.valueOf(ChatColor.WHITE) + Opaque123.c(this.yU.if(), -117 + this.yV.getWidth() / 2) + Opaque123.c(this.yV.if(), -49);
        }
    }

    public void a(ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3) {
        MerchantRecipe merchantRecipe = new MerchantRecipe(itemStack, 10000);
        merchantRecipe.setExperienceReward(true);
        merchantRecipe.setVillagerExperience(1000);
        merchantRecipe.addIngredient(itemStack2);
        if (itemStack3 != null) {
            merchantRecipe.addIngredient(itemStack3);
        }
        this.merchantRecipes.add(merchantRecipe);
    }

    public void a(String string, ItemStack itemStack, ItemStack itemStack2) {
        this.a(itemStack, itemStack2, null);
    }

    public void au(Player player) {
        List list = this.merchantRecipes;
        TradeMachinePreOpenEvent tradeMachinePreOpenEvent = new TradeMachinePreOpenEvent(player, this, this.zk, list);
        if (!ListenerBridge.b((Event)tradeMachinePreOpenEvent)) {
            return;
        }
        Merchant merchant = Bukkit.createMerchant((String)this.yT);
        merchant.setRecipes(Collections.unmodifiableList(list));
        if (player.openMerchant(merchant, true) != null) {
            ListenerBridge.b((Event)new TradeMachineOpenEvent(player, this, this.zk, list));
        }
    }

    @Generated
    public String getTitle() {
        return this.yT;
    }
}
