package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NCompound;
import beer.devs.fastnbt.nms.nbt.NItem;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.DynamicOps;
import itemsadder.m.aii;
import itemsadder.m.aij;
import itemsadder.m.ail;
import itemsadder.m.aim;
import itemsadder.m.ain;
import itemsadder.m.aio;
import itemsadder.m.aip;
import itemsadder.m.ajs;
import itemsadder.m.ajt;
import itemsadder.m.bbe;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import net.kyori.adventure.text.Component;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.DynamicOpsNBT;
import net.minecraft.nbt.MojangsonParser;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayOutOpenWindow;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.sounds.SoundEffects;
import net.minecraft.util.Unit;
import net.minecraft.util.datafix.DataConverterRegistry;
import net.minecraft.util.datafix.fixes.DataConverterTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EnumItemSlot;
import net.minecraft.world.entity.ai.attributes.GenericAttributes;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.food.FoodInfo;
import net.minecraft.world.item.AdventureModePredicate;
import net.minecraft.world.item.EitherHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.JukeboxPlayable;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.component.UseCooldown;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ClearAllStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.PlaySoundConsumeEffect;
import net.minecraft.world.item.consume_effects.RemoveStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.TeleportRandomlyConsumeEffect;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.item.equipment.trim.ArmorTrim;
import org.apache.commons.lang.reflect.FieldUtils;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_21_R5.CraftEquipmentSlot;
import org.bukkit.craftbukkit.v1_21_R5.entity.CraftEntityType;
import org.bukkit.craftbukkit.v1_21_R5.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftContainer;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_21_R5.potion.CraftPotionEffectType;
import org.bukkit.craftbukkit.v1_21_R5.util.CraftMagicNumbers;
import org.bukkit.craftbukkit.v1_21_R5.util.CraftNamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class aiy
implements aii {
    public static final Field acS = FieldUtils.getField(CraftItemStack.class, (String)"handle", (boolean)true);
    private static final boolean acT = Modifier.isPublic(acS.getModifiers());
    static double acF = EntityHuman.gg().a().b(GenericAttributes.e);

    public static net.minecraft.world.item.ItemStack a(CraftItemStack craftItemStack) {
        if (acT) {
            return craftItemStack.handle;
        }
        try {
            return (net.minecraft.world.item.ItemStack)acS.get(craftItemStack);
        }
        catch (IllegalAccessException illegalAccessException) {
            new RuntimeException("Error reading handle field of CraftItemStack.", illegalAccessException).printStackTrace();
            return null;
        }
    }

    @Override
    public void b(Player player, Component component) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        PacketPlayOutOpenWindow packetPlayOutOpenWindow = new PacketPlayOutOpenWindow(entityPlayer.cn.l, CraftContainer.getNotchInventoryType((Inventory)player.getOpenInventory().getTopInventory()), (IChatBaseComponent)bbe.r(component));
        entityPlayer.g.b((Packet)packetPlayOutOpenWindow);
        player.updateInventory();
    }

    @Override
    public int bT(Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        return entityPlayer.cn.l;
    }

    @Override
    public String K(Material material) {
        return CraftMagicNumbers.getItem((Material)material).j();
    }

    public static boolean a(net.minecraft.world.item.ItemStack itemStack) {
        CustomData customData = (CustomData)itemStack.a(DataComponents.b);
        return customData != null && customData.a("itemsadder");
    }

    @Override
    public void c(ItemStack itemStack, String string) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        PropertyMap propertyMap = new PropertyMap();
        propertyMap.put((Object)"textures", (Object)new Property("textures", string, null));
        itemStack2.b(DataComponents.ak, (Object)new ResolvableProfile(Optional.empty(), Optional.of(UUID.randomUUID()), propertyMap));
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public Double X(ItemStack itemStack) {
        return this.a(itemStack, Item.i);
    }

    public Double a(ItemStack itemStack, MinecraftKey minecraftKey) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        ItemAttributeModifiers itemAttributeModifiers = (ItemAttributeModifiers)itemStack2.h().f().a(DataComponents.o);
        if (itemAttributeModifiers != null) {
            for (ItemAttributeModifiers.c c2 : itemAttributeModifiers.b()) {
                if (!c2.b().a().equals((Object)minecraftKey)) continue;
                return acF + c2.b().b();
            }
        }
        return null;
    }

    @Override
    public void c(NItem nItem, String string) {
        String string2 = CraftMagicNumbers.getItem((Material)nItem.getItem().getType()).e().h().a().toString();
        NBTTagCompound nBTTagCompound = MojangsonParser.a((String)string);
        if (nBTTagCompound.b("components")) {
            nBTTagCompound.a("id", string2);
            nBTTagCompound.a("count", nItem.getItem().getAmount());
            NCompound nCompound = new NCompound((Object)nBTTagCompound);
            nItem.merge(nCompound.toBukkitItem());
            nItem.save();
        } else {
            String string32;
            NBTTagCompound nBTTagCompound2;
            if (!nBTTagCompound.b("tag")) {
                nBTTagCompound2 = new NBTTagCompound();
                for (String string32 : nBTTagCompound.e()) {
                    nBTTagCompound2.a(string32, nBTTagCompound.a(string32));
                    nBTTagCompound.r(string32);
                }
                nBTTagCompound.a("tag", (NBTBase)nBTTagCompound2);
            }
            nBTTagCompound.a("id", string2);
            nBTTagCompound.a("Count", nItem.getItem().getAmount());
            nBTTagCompound2 = DataConverterRegistry.a().update(DataConverterTypes.u, new Dynamic((DynamicOps)DynamicOpsNBT.a, (Object)nBTTagCompound), 3692, 3816);
            ajt ajt2 = (ajt)ajt.r((Dynamic)nBTTagCompound2).get();
            ajs.a(ajt2, (Dynamic)nBTTagCompound2);
            nBTTagCompound2 = ajt2.tY();
            string32 = new NCompound(nBTTagCompound2.getValue());
            nItem.merge(string32.toBukkitItem());
            nItem.save();
        }
    }

    @Override
    public ItemStack Y(ItemStack itemStack) {
        AdventureModePredicate adventureModePredicate;
        Unit unit;
        ArmorTrim armorTrim;
        DyedItemColor dyedItemColor;
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        itemStack2.b(0);
        TooltipDisplay tooltipDisplay = TooltipDisplay.c;
        DataComponentMap dataComponentMap = itemStack2.a();
        ItemAttributeModifiers itemAttributeModifiers = (ItemAttributeModifiers)dataComponentMap.a(DataComponents.o);
        if (itemAttributeModifiers != null) {
            tooltipDisplay = tooltipDisplay.a(DataComponents.o, true);
        }
        if ((dyedItemColor = (DyedItemColor)dataComponentMap.a(DataComponents.K)) != null) {
            tooltipDisplay = tooltipDisplay.a(DataComponents.K, true);
        }
        if ((armorTrim = (ArmorTrim)dataComponentMap.a(DataComponents.W)) != null) {
            tooltipDisplay = tooltipDisplay.a(DataComponents.W, true);
        }
        if ((unit = (Unit)dataComponentMap.a(DataComponents.f)) != null) {
            tooltipDisplay = tooltipDisplay.a(DataComponents.f, true);
        }
        if ((adventureModePredicate = (AdventureModePredicate)dataComponentMap.a(DataComponents.n)) != null) {
            tooltipDisplay = tooltipDisplay.a(DataComponents.n, true);
        }
        itemStack2.b(DataComponents.j, null);
        itemStack2.b(DataComponents.q, (Object)tooltipDisplay);
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
        return itemStack;
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
        NBTBase nBTBase = customData.e().a("itemsadder");
        if (nBTBase instanceof NBTTagCompound) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTBase;
            nBTBase = customData2.e().a("itemsadder");
            if (nBTBase instanceof NBTTagCompound) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTBase;
                return nBTTagCompound.i("id").equals(nBTTagCompound2.i("id")) && nBTTagCompound.i("namespace").equals(nBTTagCompound2.i("namespace"));
            }
        }
        return false;
    }

    @Override
    public void f(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2) {
        CraftItemStack craftItemStack = !(itemStack2 instanceof CraftItemStack) ? CraftItemStack.asCraftCopy((ItemStack)itemStack2) : (CraftItemStack)itemStack2;
        CraftItemStack craftItemStack2 = !(itemStack instanceof CraftItemStack) ? CraftItemStack.asCraftCopy((ItemStack)itemStack) : (CraftItemStack)itemStack;
        net.minecraft.world.item.ItemStack itemStack3 = aiy.a(craftItemStack);
        net.minecraft.world.item.ItemStack itemStack4 = aiy.a(craftItemStack2);
        if (itemStack3 == null) {
            throw new NullPointerException("ItemStack toNms is null.");
        }
        if (itemStack4 == null) {
            throw new NullPointerException("ItemStack fromNms is null.");
        }
        if (itemStack4.c(DataComponents.b)) {
            ((CustomData)itemStack3.a(DataComponents.b)).e().a(((CustomData)itemStack4.a(DataComponents.b)).e());
        }
        itemStack2.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack3).getItemMeta());
    }

    @Override
    public void a(ItemStack itemStack, float f, String object) {
        if (object != null && !((String)object).contains(":")) {
            object = "itemsadder:" + (String)object;
        }
        Optional optional = object == null ? Optional.empty() : Optional.of(MinecraftKey.a((String)object));
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        itemStack2.b(DataComponents.y, (Object)new UseCooldown(f, optional));
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public boolean Z(ItemStack itemStack) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        itemStack2.e(DataComponents.x);
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
        return true;
    }

    @Override
    public void a(ItemStack itemStack, int n, float f, boolean bl, int n2, @Nullable String string, @Nullable String string2, @Nullable Boolean bl2, @Nullable List list) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        Object object = string2 != null ? Holder.a((Object)SoundEffect.a((MinecraftKey)MinecraftKey.a((String)string2))) : SoundEffects.kQ;
        ItemUseAnimation itemUseAnimation = ItemUseAnimation.b;
        if (string != null) {
            for (Object object2 : ItemUseAnimation.values()) {
                if (!object2.c().equals(string)) continue;
                itemUseAnimation = object2;
                break;
            }
        }
        if (bl2 == null) {
            bl2 = true;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (aim aim2 : list) {
                List<Object> list2;
                if (aim2 instanceof aij) {
                    Object object2;
                    object2 = (aij)aim2;
                    list2 = object2.acq.stream().map(aik2 -> new MobEffect(CraftPotionEffectType.bukkitToMinecraftHolder((PotionEffectType)aik2.tQ()), aik2.tR(), aik2.tS(), aik2.tT(), aik2.tU(), aik2.tV())).toList();
                    arrayList.add(new ApplyStatusEffectsConsumeEffect(list2, object2.acr));
                    continue;
                }
                if (aim2 instanceof aio) {
                    aio aio2 = (aio)aim2;
                    list2 = aio2.acz.stream().map(CraftPotionEffectType::bukkitToMinecraftHolder).collect(Collectors.toList());
                    arrayList.add(new RemoveStatusEffectsConsumeEffect((HolderSet)HolderSet.a(list2)));
                    continue;
                }
                if (aim2 instanceof aip) {
                    aip aip2 = (aip)aim2;
                    arrayList.add(new TeleportRandomlyConsumeEffect(aip2.acA));
                    continue;
                }
                if (aim2 instanceof ail) {
                    arrayList.add(new ClearAllStatusEffectsConsumeEffect());
                    continue;
                }
                if (!(aim2 instanceof ain)) continue;
                ain ain2 = (ain)aim2;
                arrayList.add(new PlaySoundConsumeEffect(Holder.a((Object)SoundEffect.a((MinecraftKey)MinecraftKey.a((String)ain2.acy)))));
            }
        }
        itemStack2.b(DataComponents.w, (Object)new Consumable((float)n2, itemUseAnimation, (Holder)object, bl2.booleanValue(), (List)arrayList));
        itemStack2.b(DataComponents.v, (Object)new FoodInfo(n, f, bl));
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public boolean aa(ItemStack itemStack) {
        return CraftItemStack.asNMSCopy((ItemStack)itemStack).c(DataComponents.w);
    }

    @Override
    public void a(ItemStack itemStack, EquipmentSlot equipmentSlot, @Nullable NamespacedKey namespacedKey, @Nullable String string, @Nullable NamespacedKey namespacedKey2, @Nullable List list, @Nullable Boolean bl, @Nullable Boolean bl2, @Nullable Boolean bl3, @Nullable Boolean bl4) {
        EnumItemSlot enumItemSlot = CraftEquipmentSlot.getNMS((EquipmentSlot)equipmentSlot);
        Holder holder = null;
        if (string != null) {
            holder = Holder.a((Object)SoundEffect.a((MinecraftKey)MinecraftKey.a((String)string)));
        }
        Equippable.a a2 = Equippable.a((EnumItemSlot)enumItemSlot);
        if (holder != null) {
            a2.a(holder);
        }
        if (namespacedKey != null) {
            a2.a(ResourceKey.a((ResourceKey)EquipmentAssets.a, (MinecraftKey)CraftNamespacedKey.toMinecraft((NamespacedKey)namespacedKey)));
        }
        if (namespacedKey2 != null) {
            a2.a(CraftNamespacedKey.toMinecraft((NamespacedKey)namespacedKey2));
        }
        if (list != null && !list.isEmpty()) {
            a2.a((HolderSet)HolderSet.a(list.stream().filter(Objects::nonNull).map(CraftEntityType::bukkitToMinecraftHolder).toList()));
        }
        if (bl != null) {
            a2.a(bl.booleanValue());
        }
        if (bl2 != null) {
            a2.b(bl2.booleanValue());
        }
        if (bl3 != null) {
            a2.c(bl3.booleanValue());
        }
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        itemStack2.b(DataComponents.D, (Object)a2.a());
        if (bl4 != null && bl4.booleanValue()) {
            itemStack2.b(DataComponents.F, (Object)Unit.a);
        }
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public void a(ItemStack itemStack, @Nullable NamespacedKey namespacedKey) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        if (namespacedKey != null) {
            itemStack2.b(DataComponents.G, (Object)CraftNamespacedKey.toMinecraft((NamespacedKey)namespacedKey));
        } else {
            itemStack2.e(DataComponents.G);
        }
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public void ab(ItemStack itemStack) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        itemStack2.b(DataComponents.q, (Object)TooltipDisplay.c.a(DataComponents.o, true));
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public void b(ItemStack itemStack, @Nullable NamespacedKey namespacedKey) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        if (namespacedKey != null) {
            CraftNamespacedKey.toMinecraft((NamespacedKey)namespacedKey);
            JukeboxPlayable jukeboxPlayable = new JukeboxPlayable(new EitherHolder(ResourceKey.a((ResourceKey)Registries.ba, (MinecraftKey)MinecraftKey.a((String)namespacedKey.asString()))));
            itemStack2.b(DataComponents.ae, (Object)jukeboxPlayable);
        } else {
            itemStack2.e(DataComponents.ae);
        }
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public boolean g(ItemStack itemStack, ItemStack itemStack2) {
        net.minecraft.world.item.ItemStack itemStack3 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        net.minecraft.world.item.ItemStack itemStack4 = CraftItemStack.asNMSCopy((ItemStack)itemStack2);
        if (!aiy.a(itemStack3) || !aiy.a(itemStack4)) {
            return false;
        }
        aiy.b(itemStack3);
        aiy.b(itemStack4);
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

    @Override
    public void d(ItemStack itemStack, String string) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setItemModel(NamespacedKey.fromString((String)string));
        itemStack.setItemMeta(itemMeta);
    }

    @Override
    public void a(ItemStack itemStack, Color color) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        CustomModelDataComponent customModelDataComponent = itemMeta.getCustomModelDataComponent();
        customModelDataComponent.setColors(List.of(color));
        itemMeta.setCustomModelDataComponent(customModelDataComponent);
        itemStack.setItemMeta(itemMeta);
    }

    @Override
    public void a(ItemStack itemStack, List list) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        CustomModelDataComponent customModelDataComponent = itemMeta.getCustomModelDataComponent();
        customModelDataComponent.setColors(list);
        itemMeta.setCustomModelDataComponent(customModelDataComponent);
        itemStack.setItemMeta(itemMeta);
    }

    @Override
    public void b(ItemStack itemStack, List list) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        CustomModelDataComponent customModelDataComponent = itemMeta.getCustomModelDataComponent();
        customModelDataComponent.setFlags(list);
        itemMeta.setCustomModelDataComponent(customModelDataComponent);
        itemStack.setItemMeta(itemMeta);
    }

    private static void b(net.minecraft.world.item.ItemStack itemStack) {
        itemStack.e(DataComponents.g);
        itemStack.e(DataComponents.h);
        itemStack.e(DataComponents.j);
        itemStack.e(DataComponents.e);
        itemStack.e(DataComponents.C);
        itemStack.e(DataComponents.l);
        itemStack.e(DataComponents.t);
        itemStack.e(DataComponents.J);
        itemStack.e(DataComponents.au);
    }
}
