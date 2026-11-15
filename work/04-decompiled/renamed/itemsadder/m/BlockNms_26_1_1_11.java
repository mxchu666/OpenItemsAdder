package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NCompound;
import beer.devs.fastnbt.nms.nbt.NItem;
import com.google.common.collect.HashMultimap;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.DynamicOps;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.Count_11;
import itemsadder.m.FloatData;
import itemsadder.m.HideFlags_11;
import itemsadder.m.ItemStackWrapper;
import itemsadder.m.ListFloatData;
import itemsadder.m.Opaque002;
import itemsadder.m.Opaque003;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.SetData;
import itemsadder.m.StringData;
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
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.TagParser;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundOpenScreenPacket;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Unit;
import net.minecraft.util.datafix.DataFixers;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.AdventureModePredicate;
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
import org.bukkit.craftbukkit.CraftEquipmentSlot;
import org.bukkit.craftbukkit.CraftRegistry;
import org.bukkit.craftbukkit.entity.CraftEntityType;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.craftbukkit.inventory.CraftContainer;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.craftbukkit.potion.CraftPotionEffectType;
import org.bukkit.craftbukkit.util.CraftMagicNumbers;
import org.bukkit.craftbukkit.util.CraftNamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockNms_26_1_1_11
implements ItemStackWrapper {
    public static final Field acY = FieldUtils.getField(CraftItemStack.class, (String)"handle", (boolean)true);
    private static final boolean acZ = Modifier.isPublic(acY.getModifiers());
    static double acF = Player.createAttributes().build().getBaseValue(Attributes.ATTACK_SPEED);

    public static net.minecraft.world.item.ItemStack a(CraftItemStack craftItemStack) {
        if (acZ) {
            return craftItemStack.handle;
        }
        try {
            return (net.minecraft.world.item.ItemStack)acY.get(craftItemStack);
        }
        catch (IllegalAccessException illegalAccessException) {
            new RuntimeException("Error reading handle field of CraftItemStack.", illegalAccessException).printStackTrace();
            return null;
        }
    }

    @Override
    public void b(org.bukkit.entity.Player player, Component component) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        ClientboundOpenScreenPacket clientboundOpenScreenPacket = new ClientboundOpenScreenPacket(serverPlayer.containerMenu.containerId, CraftContainer.getNotchInventoryType((Inventory)player.getOpenInventory().getTopInventory()), (net.minecraft.network.chat.Component)PluginBridge_6.r(component));
        serverPlayer.connection.send((Packet)clientboundOpenScreenPacket);
        player.updateInventory();
    }

    @Override
    public int bT(org.bukkit.entity.Player player) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        return serverPlayer.containerMenu.containerId;
    }

    @Override
    public String K(Material material) {
        return CraftMagicNumbers.getItem((Material)material).getDescriptionId();
    }

    public static boolean a(net.minecraft.world.item.ItemStack itemStack) {
        CustomData customData = (CustomData)itemStack.get(DataComponents.CUSTOM_DATA);
        return customData != null && customData.contains("itemsadder");
    }

    @Override
    public void c(ItemStack itemStack, String string) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        HashMultimap hashMultimap = HashMultimap.create();
        hashMultimap.put("textures", new Property("textures", string, null));
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
        PropertyMap propertyMap = new PropertyMap(hashMultimap);
        ResolvableProfile resolvableProfile = ResolvableProfile.createResolved((GameProfile)new GameProfile(UUID.randomUUID(), "", propertyMap));
        itemStack2.set(DataComponents.PROFILE, (Object)resolvableProfile);
    }

    @Override
    public Double X(ItemStack itemStack) {
        return this.a(itemStack, Item.BASE_ATTACK_SPEED_ID);
    }

    public Double a(ItemStack itemStack, Identifier identifier) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        ItemAttributeModifiers itemAttributeModifiers = (ItemAttributeModifiers)itemStack2.getItem().components().get(DataComponents.ATTRIBUTE_MODIFIERS);
        if (itemAttributeModifiers != null) {
            for (ItemAttributeModifiers.Entry entry : itemAttributeModifiers.modifiers()) {
                if (!entry.modifier().id().equals((Object)identifier)) continue;
                return acF + entry.modifier().amount();
            }
        }
        return null;
    }

    @Override
    public void c(NItem nItem, String string) {
        String string2 = CraftMagicNumbers.getItem((Material)nItem.getItem().getType()).builtInRegistryHolder().key().identifier().toString();
        CompoundTag compoundTag = TagParser.parseCompoundFully((String)string);
        if (compoundTag.contains("components")) {
            compoundTag.putString("id", string2);
            compoundTag.putInt("count", nItem.getItem().getAmount());
            NCompound nCompound = new NCompound((Object)compoundTag);
            nItem.merge(nCompound.toBukkitItem());
            nItem.save();
        } else {
            String string32;
            CompoundTag compoundTag2;
            if (!compoundTag.contains("tag")) {
                compoundTag2 = new CompoundTag();
                for (String string32 : compoundTag.keySet()) {
                    compoundTag2.put(string32, compoundTag.get(string32));
                    compoundTag.remove(string32);
                }
                compoundTag.put("tag", (Tag)compoundTag2);
            }
            compoundTag.putString("id", string2);
            compoundTag.putInt("Count", nItem.getItem().getAmount());
            compoundTag2 = DataFixers.getDataFixer().update(References.ITEM_STACK, new Dynamic((DynamicOps)NbtOps.INSTANCE, (Object)compoundTag), 3692, 3816);
            Count_11 count_11 = (Count_11)Count_11.r((Dynamic)compoundTag2).get();
            HideFlags_11.a(count_11, (Dynamic)compoundTag2);
            compoundTag2 = count_11.tY();
            string32 = new NCompound(compoundTag2.getValue());
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
        itemStack2.setDamageValue(0);
        TooltipDisplay tooltipDisplay = TooltipDisplay.DEFAULT;
        DataComponentMap dataComponentMap = itemStack2.getComponents();
        ItemAttributeModifiers itemAttributeModifiers = (ItemAttributeModifiers)dataComponentMap.get(DataComponents.ATTRIBUTE_MODIFIERS);
        if (itemAttributeModifiers != null) {
            tooltipDisplay = tooltipDisplay.withHidden(DataComponents.ATTRIBUTE_MODIFIERS, true);
        }
        if ((dyedItemColor = (DyedItemColor)dataComponentMap.get(DataComponents.DYED_COLOR)) != null) {
            tooltipDisplay = tooltipDisplay.withHidden(DataComponents.DYED_COLOR, true);
        }
        if ((armorTrim = (ArmorTrim)dataComponentMap.get(DataComponents.TRIM)) != null) {
            tooltipDisplay = tooltipDisplay.withHidden(DataComponents.TRIM, true);
        }
        if ((unit = (Unit)dataComponentMap.get(DataComponents.UNBREAKABLE)) != null) {
            tooltipDisplay = tooltipDisplay.withHidden(DataComponents.UNBREAKABLE, true);
        }
        if ((adventureModePredicate = (AdventureModePredicate)dataComponentMap.get(DataComponents.CAN_BREAK)) != null) {
            tooltipDisplay = tooltipDisplay.withHidden(DataComponents.CAN_BREAK, true);
        }
        itemStack2.set(DataComponents.LORE, null);
        itemStack2.set(DataComponents.TOOLTIP_DISPLAY, (Object)tooltipDisplay);
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
        return itemStack;
    }

    public static boolean a(net.minecraft.world.item.ItemStack itemStack, net.minecraft.world.item.ItemStack itemStack2) {
        CustomData customData = (CustomData)itemStack.get(DataComponents.CUSTOM_DATA);
        CustomData customData2 = (CustomData)itemStack2.get(DataComponents.CUSTOM_DATA);
        if (customData == null && customData2 == null) {
            return true;
        }
        if (customData == null || customData2 == null) {
            return false;
        }
        Tag tag = customData.getUnsafe().get("itemsadder");
        if (tag instanceof CompoundTag) {
            CompoundTag compoundTag = (CompoundTag)tag;
            tag = customData2.getUnsafe().get("itemsadder");
            if (tag instanceof CompoundTag) {
                CompoundTag compoundTag2 = (CompoundTag)tag;
                return compoundTag.getString("id").equals(compoundTag2.getString("id")) && compoundTag.getString("namespace").equals(compoundTag2.getString("namespace"));
            }
        }
        return false;
    }

    @Override
    public void f(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2) {
        CraftItemStack craftItemStack = !(itemStack2 instanceof CraftItemStack) ? CraftItemStack.asCraftCopy((ItemStack)itemStack2) : (CraftItemStack)itemStack2;
        CraftItemStack craftItemStack2 = !(itemStack instanceof CraftItemStack) ? CraftItemStack.asCraftCopy((ItemStack)itemStack) : (CraftItemStack)itemStack;
        net.minecraft.world.item.ItemStack itemStack3 = BlockNms_26_1_1_11.a(craftItemStack);
        net.minecraft.world.item.ItemStack itemStack4 = BlockNms_26_1_1_11.a(craftItemStack2);
        if (itemStack3 == null) {
            throw new NullPointerException("ItemStack toNms is null.");
        }
        if (itemStack4 == null) {
            throw new NullPointerException("ItemStack fromNms is null.");
        }
        if (itemStack4.has(DataComponents.CUSTOM_DATA)) {
            ((CustomData)itemStack3.get(DataComponents.CUSTOM_DATA)).getUnsafe().merge(((CustomData)itemStack4.get(DataComponents.CUSTOM_DATA)).getUnsafe());
        }
        itemStack2.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack3).getItemMeta());
    }

    @Override
    public void a(ItemStack itemStack, float f, String object) {
        if (object != null && !((String)object).contains(":")) {
            object = "itemsadder:" + (String)object;
        }
        Optional optional = object == null ? Optional.empty() : Optional.of(Identifier.parse((String)object));
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        itemStack2.set(DataComponents.USE_COOLDOWN, (Object)new UseCooldown(f, optional));
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public boolean Z(ItemStack itemStack) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        itemStack2.remove(DataComponents.USE_REMAINDER);
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
        return true;
    }

    @Override
    public void a(ItemStack itemStack, int n, float f, boolean bl, int n2, @Nullable String string, @Nullable String string2, @Nullable Boolean bl2, @Nullable List list) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        Object object = string2 != null ? Holder.direct((Object)SoundEvent.createVariableRangeEvent((Identifier)Identifier.parse((String)string2))) : SoundEvents.GENERIC_EAT;
        ItemUseAnimation itemUseAnimation = ItemUseAnimation.EAT;
        if (string != null) {
            for (Object object2 : ItemUseAnimation.values()) {
                if (!object2.getSerializedName().equals(string)) continue;
                itemUseAnimation = object2;
                break;
            }
        }
        if (bl2 == null) {
            bl2 = true;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Opaque003 opaque003 : list) {
                List<Object> list2;
                if (opaque003 instanceof ListFloatData) {
                    Object object2;
                    object2 = (ListFloatData)opaque003;
                    list2 = object2.acq.stream().map(recordOfPotionEffectType -> new MobEffectInstance(CraftPotionEffectType.bukkitToMinecraftHolder((PotionEffectType)recordOfPotionEffectType.tQ()), recordOfPotionEffectType.tR(), recordOfPotionEffectType.tS(), recordOfPotionEffectType.tT(), recordOfPotionEffectType.tU(), recordOfPotionEffectType.tV())).toList();
                    arrayList.add(new ApplyStatusEffectsConsumeEffect(list2, object2.acr));
                    continue;
                }
                if (opaque003 instanceof SetData) {
                    SetData setData = (SetData)opaque003;
                    list2 = setData.acz.stream().map(CraftPotionEffectType::bukkitToMinecraftHolder).collect(Collectors.toList());
                    arrayList.add(new RemoveStatusEffectsConsumeEffect((HolderSet)HolderSet.direct(list2)));
                    continue;
                }
                if (opaque003 instanceof FloatData) {
                    FloatData floatData = (FloatData)opaque003;
                    arrayList.add(new TeleportRandomlyConsumeEffect(floatData.acA));
                    continue;
                }
                if (opaque003 instanceof Opaque002) {
                    arrayList.add(new ClearAllStatusEffectsConsumeEffect());
                    continue;
                }
                if (!(opaque003 instanceof StringData)) continue;
                StringData stringData = (StringData)opaque003;
                arrayList.add(new PlaySoundConsumeEffect(Holder.direct((Object)SoundEvent.createVariableRangeEvent((Identifier)Identifier.parse((String)stringData.acy)))));
            }
        }
        itemStack2.set(DataComponents.CONSUMABLE, (Object)new Consumable((float)n2, itemUseAnimation, (Holder)object, bl2.booleanValue(), (List)arrayList));
        itemStack2.set(DataComponents.FOOD, (Object)new FoodProperties(n, f, bl));
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public boolean aa(ItemStack itemStack) {
        return CraftItemStack.asNMSCopy((ItemStack)itemStack).has(DataComponents.CONSUMABLE);
    }

    @Override
    public void a(ItemStack itemStack, org.bukkit.inventory.EquipmentSlot equipmentSlot, @Nullable NamespacedKey namespacedKey, @Nullable String string, @Nullable NamespacedKey namespacedKey2, @Nullable List list, @Nullable Boolean bl, @Nullable Boolean bl2, @Nullable Boolean bl3, @Nullable Boolean bl4) {
        EquipmentSlot equipmentSlot2 = CraftEquipmentSlot.getNMS((org.bukkit.inventory.EquipmentSlot)equipmentSlot);
        Holder holder = null;
        if (string != null) {
            holder = Holder.direct((Object)SoundEvent.createVariableRangeEvent((Identifier)Identifier.parse((String)string)));
        }
        Equippable.Builder builder = Equippable.builder((EquipmentSlot)equipmentSlot2);
        if (holder != null) {
            builder.setEquipSound(holder);
        }
        if (namespacedKey != null) {
            builder.setAsset(ResourceKey.create((ResourceKey)EquipmentAssets.ROOT_ID, (Identifier)CraftNamespacedKey.toMinecraft((NamespacedKey)namespacedKey)));
        }
        if (namespacedKey2 != null) {
            builder.setCameraOverlay(CraftNamespacedKey.toMinecraft((NamespacedKey)namespacedKey2));
        }
        if (list != null && !list.isEmpty()) {
            builder.setAllowedEntities((HolderSet)HolderSet.direct(list.stream().filter(Objects::nonNull).map(CraftEntityType::bukkitToMinecraftHolder).toList()));
        }
        if (bl != null) {
            builder.setDispensable(bl.booleanValue());
        }
        if (bl2 != null) {
            builder.setSwappable(bl2.booleanValue());
        }
        if (bl3 != null) {
            builder.setDamageOnHurt(bl3.booleanValue());
        }
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        itemStack2.set(DataComponents.EQUIPPABLE, (Object)builder.build());
        if (bl4 != null && bl4.booleanValue()) {
            itemStack2.set(DataComponents.GLIDER, (Object)Unit.INSTANCE);
        }
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public void a(ItemStack itemStack, @Nullable NamespacedKey namespacedKey) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        if (namespacedKey != null) {
            itemStack2.set(DataComponents.TOOLTIP_STYLE, (Object)CraftNamespacedKey.toMinecraft((NamespacedKey)namespacedKey));
        } else {
            itemStack2.remove(DataComponents.TOOLTIP_STYLE);
        }
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public void ab(ItemStack itemStack) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        itemStack2.set(DataComponents.TOOLTIP_DISPLAY, (Object)TooltipDisplay.DEFAULT.withHidden(DataComponents.ATTRIBUTE_MODIFIERS, true));
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public void b(ItemStack itemStack, @Nullable NamespacedKey namespacedKey) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        if (namespacedKey != null) {
            ResourceKey resourceKey;
            Registry registry = CraftRegistry.getMinecraftRegistry((ResourceKey)Registries.JUKEBOX_SONG);
            Optional optional = registry.get(resourceKey = ResourceKey.create((ResourceKey)Registries.JUKEBOX_SONG, (Identifier)CraftNamespacedKey.toMinecraft((NamespacedKey)namespacedKey)));
            if (optional.isEmpty()) {
                CommandSenderBridge_5.warn("Jukebox song with id '" + String.valueOf(namespacedKey) + "' not found.");
                return;
            }
            JukeboxPlayable jukeboxPlayable = new JukeboxPlayable((Holder)optional.get());
            itemStack2.set(DataComponents.JUKEBOX_PLAYABLE, (Object)jukeboxPlayable);
        } else {
            itemStack2.remove(DataComponents.JUKEBOX_PLAYABLE);
        }
        itemStack.setItemMeta(CraftItemStack.asCraftMirror((net.minecraft.world.item.ItemStack)itemStack2).getItemMeta());
    }

    @Override
    public boolean g(ItemStack itemStack, ItemStack itemStack2) {
        net.minecraft.world.item.ItemStack itemStack3 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        net.minecraft.world.item.ItemStack itemStack4 = CraftItemStack.asNMSCopy((ItemStack)itemStack2);
        if (!BlockNms_26_1_1_11.a(itemStack3) || !BlockNms_26_1_1_11.a(itemStack4)) {
            return false;
        }
        BlockNms_26_1_1_11.b(itemStack3);
        BlockNms_26_1_1_11.b(itemStack4);
        CustomData customData = (CustomData)itemStack3.get(DataComponents.CUSTOM_DATA);
        CustomData customData2 = (CustomData)itemStack4.get(DataComponents.CUSTOM_DATA);
        if (customData == null && customData2 == null) {
            return true;
        }
        if (customData == null || customData2 == null) {
            return false;
        }
        return itemStack3.getComponentsPatch().equals((Object)itemStack4.getComponentsPatch());
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
        itemStack.remove(DataComponents.CUSTOM_NAME);
        itemStack.remove(DataComponents.ITEM_NAME);
        itemStack.remove(DataComponents.LORE);
        itemStack.remove(DataComponents.DAMAGE);
        itemStack.remove(DataComponents.ENCHANTABLE);
        itemStack.remove(DataComponents.ENCHANTMENTS);
        itemStack.remove(DataComponents.ENCHANTMENT_GLINT_OVERRIDE);
        itemStack.remove(DataComponents.STORED_ENCHANTMENTS);
        itemStack.remove(DataComponents.BREAK_SOUND);
    }
}
