package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomStack;
import itemsadder.m.bay;
import itemsadder.m.d;
import itemsadder.m.js;
import itemsadder.m.qm;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.jetbrains.annotations.Nullable;

public class CustomFurniture
extends CustomStack {
    private static final Set EMPTY_SET = new HashSet();
    Entity entity;
    private js behaviour;

    public static Set getNamespacedIdsInRegistry() {
        Set set = d.g().d("furniture");
        if (set == null) {
            return EMPTY_SET;
        }
        return set;
    }

    CustomFurniture(qm qm2, Entity entity) {
        super(qm2);
        this.entity = entity;
        this.initItemStack(entity);
    }

    CustomFurniture(qm qm2, ItemStack itemStack, Entity entity, js js2) {
        super(qm2, itemStack);
        this.entity = entity;
        this.behaviour = js2;
        this.initItemStack(entity);
    }

    private void initItemStack(Entity entity) {
        this.itemStack = js.o(entity);
    }

    @Nullable
    public static CustomFurniture byAlreadySpawned(Entity entity) {
        ItemStack itemStack = js.o(entity);
        if (!qm.isCustomItem(itemStack)) {
            return null;
        }
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return null;
        }
        js js2 = (js)qm2.Ge.bn("furniture");
        if (js2 == null) {
            return null;
        }
        return new CustomFurniture(qm2, entity);
    }

    @Nullable
    public static CustomFurniture byAlreadySpawned(Block block) {
        Optional<Entity> optional = block.getLocation().getWorld().getNearbyEntities(block.getLocation().add(0.5, 0.5, 0.5), 0.1, 0.1, 0.1).stream().filter(js::w).findFirst();
        return optional.map(CustomFurniture::byAlreadySpawned).orElse(null);
    }

    @Nullable
    public static CustomFurniture spawnPreciseNonSolid(String string, Location location) {
        qm qm2 = d.g().e(string);
        if (qm2 == null) {
            return null;
        }
        if (!qm2.Ge.bm("furniture")) {
            return null;
        }
        ItemStack itemStack = qm2.mP();
        js js2 = (js)qm2.Ge.bn("furniture");
        Entity entity = js2.a(itemStack, location);
        return new CustomFurniture(qm2, itemStack, entity, js2);
    }

    @Nullable
    public static CustomFurniture spawn(String string, Block block) {
        qm qm2 = d.g().e(string);
        if (qm2 == null) {
            return null;
        }
        if (!qm2.Ge.bm("furniture")) {
            return null;
        }
        ItemStack itemStack = qm2.mP();
        js js2 = (js)qm2.Ge.bn("furniture");
        Entity entity = js2.a(itemStack, block);
        return new CustomFurniture(qm2, itemStack, entity, js2);
    }

    public void remove(boolean bl) {
        if (this.entity != null) {
            CustomFurniture.remove(this.entity, bl);
        }
    }

    public static void remove(Entity entity, boolean bl) {
        d.g().aC.a(entity, bl);
    }

    public void teleport(Entity entity) {
        this.teleport(entity.getLocation());
    }

    public void teleport(Location location) {
        if (this.entity != null) {
            if (this.behaviour.kI()) {
                this.behaviour.s(this.entity);
            }
            this.entity.teleport(location);
        }
    }

    public void replaceFurniture(String string) {
        this.replaceFurniture(string, null);
    }

    public void replaceFurniture(String string, Color color) {
        qm qm2 = d.g().e(string);
        if (qm2 == null) {
            throw new NoSuchElementException("No custom item with that namespacedId: " + string);
        }
        if (!qm2.Ge.bm("furniture")) {
            throw new NoSuchElementException("Custom item has no furniture behaviour with that namespacedId: " + string);
        }
        if (js.a(qm2, this.internalItem, this.entity)) {
            this.replace(this.itemStack, qm2);
            this.itemStack = qm2.mP();
            this.itemStack = js.h(this.itemStack);
            if (color != null) {
                this.setColor(color);
            } else if (this.entity instanceof ArmorStand) {
                ((ArmorStand)this.entity).setHelmet(this.itemStack);
            } else if (this.entity instanceof ItemFrame) {
                ((ItemFrame)this.entity).setItem(this.itemStack, false);
            } else if (this.entity instanceof ItemDisplay) {
                ((ItemDisplay)this.entity).setItemStack(this.itemStack);
            }
        }
    }

    public void setColor(Color color) {
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        if (itemMeta instanceof PotionMeta) {
            ((PotionMeta)itemMeta).setColor(color);
            this.itemStack.setItemMeta(itemMeta);
        } else if (itemMeta instanceof LeatherArmorMeta) {
            ((LeatherArmorMeta)itemMeta).setColor(color);
            this.itemStack.setItemMeta(itemMeta);
        }
        if (this.entity instanceof ArmorStand) {
            ((ArmorStand)this.entity).setHelmet(this.itemStack);
        } else if (this.entity instanceof ItemFrame) {
            ((ItemFrame)this.entity).setItem(this.itemStack, false);
        } else if (this.entity instanceof ItemDisplay) {
            ((ItemDisplay)this.entity).setItemStack(this.itemStack);
        }
    }

    public int getOriginalLightLevel() {
        return this.behaviour.kH();
    }

    public void setCurrentLightLevel(int n) {
        bay.bk(this.entity.getLocation().getBlock());
        bay.d(this.entity.getLocation().getBlock(), n);
    }

    @Deprecated
    @Nullable
    public Entity getArmorstand() {
        return this.entity;
    }

    @Nullable
    public Entity getEntity() {
        return this.entity;
    }
}
