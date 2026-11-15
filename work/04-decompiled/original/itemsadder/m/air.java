package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NCompound;
import beer.devs.fastnbt.nms.nbt.NItem;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.DynamicOps;
import itemsadder.m.aii;
import itemsadder.m.aje;
import itemsadder.m.ajf;
import itemsadder.m.bbe;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.DynamicOpsNBT;
import net.minecraft.nbt.MojangsonParser;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayOutOpenWindow;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.util.datafix.DataConverterRegistry;
import net.minecraft.util.datafix.fixes.DataConverterTypes;
import net.minecraft.world.entity.ai.attributes.GenericAttributes;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.food.FoodInfo;
import net.minecraft.world.item.AdventureModePredicate;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.ArmorTrim;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.item.component.Unbreakable;
import org.apache.commons.lang.reflect.FieldUtils;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_20_R4.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_20_R4.inventory.CraftContainer;
import org.bukkit.craftbukkit.v1_20_R4.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_20_R4.util.CraftMagicNumbers;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class air
implements aii {
    public static final Field acD = FieldUtils.getField(CraftItemStack.class, (String)"handle", (boolean)true);
    private static final boolean acE = Modifier.isPublic(acD.getModifiers());
    static double acF = EntityHuman.fQ().a().b(GenericAttributes.e);

    public static net.minecraft.world.item.ItemStack a(CraftItemStack craftItemStack) {
        if (acE) {
            return craftItemStack.handle;
        }
        try {
            return (net.minecraft.world.item.ItemStack)acD.get(craftItemStack);
        }
        catch (IllegalAccessException illegalAccessException) {
            new RuntimeException("Error reading handle field of CraftItemStack.", illegalAccessException).printStackTrace();
            return null;
        }
    }

    @Override
    public void b(Player player, Component component) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        PacketPlayOutOpenWindow packetPlayOutOpenWindow = new PacketPlayOutOpenWindow(entityPlayer.cb.j, CraftContainer.getNotchInventoryType((Inventory)player.getOpenInventory().getTopInventory()), (IChatBaseComponent)bbe.r(component));
        entityPlayer.c.b((Packet)packetPlayOutOpenWindow);
        player.updateInventory();
    }

    @Override
    public int bT(Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        return entityPlayer.cb.j;
    }

    @Override
    public String K(Material material) {
        return CraftMagicNumbers.getItem((Material)material).a();
    }

    public static boolean a(net.minecraft.world.item.ItemStack itemStack) {
        if (!itemStack.b(DataComponents.b)) {
            return false;
        }
        CustomData customData = (CustomData)itemStack.a(DataComponents.b);
        return customData.d().e("itemsadder");
    }

    @Override
    public void c(ItemStack itemStack, String string) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        PropertyMap propertyMap = new PropertyMap();
        propertyMap.put((Object)"textures", (Object)new Property("textures", string, null));
        itemStack2.b(DataComponents.V, (Object)new ResolvableProfile(Optional.empty(), Optional.of(UUID.randomUUID()), propertyMap));
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public Double X(ItemStack itemStack) {
        return this.a(itemStack, Item.f);
    }

    public Double a(ItemStack itemStack, UUID uUID) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        ItemAttributeModifiers itemAttributeModifiers = (ItemAttributeModifiers)itemStack2.g().p().a(DataComponents.n);
        if (itemAttributeModifiers != null) {
            for (ItemAttributeModifiers.b b2 : itemAttributeModifiers.b()) {
                if (b2.b().b() != uUID) continue;
                return acF + b2.b().d();
            }
        }
        return null;
    }

    @Override
    public void c(NItem nItem, String string) {
        String string2 = CraftMagicNumbers.getItem((Material)nItem.getItem().getType()).o().h().a().toString();
        NBTTagCompound nBTTagCompound = MojangsonParser.a((String)string);
        if (nBTTagCompound.e("components")) {
            nBTTagCompound.a("id", string2);
            nBTTagCompound.a("count", nItem.getItem().getAmount());
            NCompound nCompound = new NCompound((Object)nBTTagCompound);
            nItem.merge(nCompound.toBukkitItem());
            nItem.save();
        } else {
            String string32;
            NBTTagCompound nBTTagCompound2;
            if (!nBTTagCompound.e("tag")) {
                nBTTagCompound2 = new NBTTagCompound();
                for (String string32 : nBTTagCompound.e()) {
                    nBTTagCompound2.a(string32, nBTTagCompound.c(string32));
                    nBTTagCompound.r(string32);
                }
                nBTTagCompound.a("tag", (NBTBase)nBTTagCompound2);
            }
            nBTTagCompound.a("id", string2);
            nBTTagCompound.a("Count", nItem.getItem().getAmount());
            nBTTagCompound2 = DataConverterRegistry.a().update(DataConverterTypes.t, new Dynamic((DynamicOps)DynamicOpsNBT.a, (Object)nBTTagCompound), 3692, 3816);
            ajf ajf2 = (ajf)ajf.r((Dynamic)nBTTagCompound2).get();
            aje.a(ajf2, (Dynamic)nBTTagCompound2);
            nBTTagCompound2 = ajf2.tY();
            string32 = new NCompound(nBTTagCompound2.getValue());
            nItem.merge(string32.toBukkitItem());
            nItem.save();
        }
    }

    @Override
    public ItemStack Y(ItemStack itemStack) {
        AdventureModePredicate adventureModePredicate;
        Unbreakable unbreakable;
        ArmorTrim armorTrim;
        DyedItemColor dyedItemColor;
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        itemStack2.b(0);
        DataComponentMap dataComponentMap = itemStack2.a();
        ItemAttributeModifiers itemAttributeModifiers = (ItemAttributeModifiers)dataComponentMap.a(DataComponents.n);
        if (itemAttributeModifiers != null) {
            itemStack2.b(DataComponents.n, (Object)itemAttributeModifiers.a(false));
        }
        if ((dyedItemColor = (DyedItemColor)dataComponentMap.a(DataComponents.z)) != null) {
            itemStack2.b(DataComponents.z, (Object)dyedItemColor.a(false));
        }
        if ((armorTrim = (ArmorTrim)dataComponentMap.a(DataComponents.K)) != null) {
            itemStack2.b(DataComponents.K, (Object)armorTrim.a(false));
        }
        if ((unbreakable = (Unbreakable)dataComponentMap.a(DataComponents.f)) != null) {
            itemStack2.b(DataComponents.f, (Object)unbreakable.a(false));
        }
        if ((adventureModePredicate = (AdventureModePredicate)dataComponentMap.a(DataComponents.m)) != null) {
            itemStack2.b(DataComponents.m, (Object)adventureModePredicate.a(false));
        }
        itemStack2.b(DataComponents.i, null);
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
        return itemStack;
    }

    @Override
    public void f(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2) {
        CraftItemStack craftItemStack = !(itemStack2 instanceof CraftItemStack) ? CraftItemStack.asCraftCopy((ItemStack)itemStack2) : (CraftItemStack)itemStack2;
        CraftItemStack craftItemStack2 = !(itemStack instanceof CraftItemStack) ? CraftItemStack.asCraftCopy((ItemStack)itemStack) : (CraftItemStack)itemStack;
        net.minecraft.world.item.ItemStack itemStack3 = air.a(craftItemStack);
        net.minecraft.world.item.ItemStack itemStack4 = air.a(craftItemStack2);
        if (itemStack3 == null) {
            throw new NullPointerException("ItemStack toNms is null.");
        }
        if (itemStack4 == null) {
            throw new NullPointerException("ItemStack fromNms is null.");
        }
        if (itemStack4.b(DataComponents.b)) {
            ((CustomData)itemStack3.a(DataComponents.b)).d().a(((CustomData)itemStack4.a(DataComponents.b)).d());
        }
        itemStack2.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack3).getItemMeta());
    }

    public static boolean a(net.minecraft.world.item.ItemStack itemStack, net.minecraft.world.item.ItemStack itemStack2) {
        CustomData customData = (CustomData)itemStack.a(DataComponents.b);
        CustomData customData2 = (CustomData)itemStack2.a(DataComponents.b);
        if (customData == null && customData2 == null) {
            return true;
        }
        if (customData == null || customData2 == null) {
            return false;
        }
        NBTBase nBTBase = customData.d().c("itemsadder");
        if (nBTBase instanceof NBTTagCompound) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTBase;
            nBTBase = customData2.d().c("itemsadder");
            if (nBTBase instanceof NBTTagCompound) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTBase;
                return nBTTagCompound.l("id").equals(nBTTagCompound2.l("id")) && nBTTagCompound.l("namespace").equals(nBTTagCompound2.l("namespace"));
            }
        }
        return false;
    }

    @Override
    public void a(ItemStack itemStack, int n, float f, boolean bl, int n2, @Nullable String string, @Nullable String string2, @Nullable Boolean bl2, @Nullable List list) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        itemStack2.b(DataComponents.v, (Object)new FoodInfo(n, f, bl, (float)n2, List.of()));
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public void ab(ItemStack itemStack) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        ItemAttributeModifiers itemAttributeModifiers = (ItemAttributeModifiers)itemStack2.a(DataComponents.n);
        if (itemAttributeModifiers != null) {
            itemStack2.b(DataComponents.n, (Object)itemAttributeModifiers.a(false));
        } else {
            itemStack2.b(DataComponents.n, (Object)ItemAttributeModifiers.a.a(false));
        }
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public boolean g(ItemStack itemStack, ItemStack itemStack2) {
        net.minecraft.world.item.ItemStack itemStack3 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        net.minecraft.world.item.ItemStack itemStack4 = CraftItemStack.asNMSCopy((ItemStack)itemStack2);
        if (!air.a(itemStack3) || !air.a(itemStack4)) {
            return false;
        }
        air.b(itemStack3);
        air.b(itemStack4);
        CustomData customData = (CustomData)itemStack3.a(DataComponents.b);
        CustomData customData2 = (CustomData)itemStack4.a(DataComponents.b);
        if (customData == null && customData2 == null) {
            return true;
        }
        if (customData == null || customData2 == null) {
            return false;
        }
        return itemStack3.d().equals((Object)itemStack4.d());
    }

    private static void b(net.minecraft.world.item.ItemStack itemStack) {
        itemStack.c(DataComponents.g);
        itemStack.c(DataComponents.h);
        itemStack.c(DataComponents.i);
        itemStack.c(DataComponents.e);
        itemStack.c(DataComponents.k);
        itemStack.c(DataComponents.t);
        itemStack.c(DataComponents.y);
    }
}
